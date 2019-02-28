package com.example.bitp3453labs;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.BitSet;

public class ThreadedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_threaded);

       ImageView iv = (ImageView)findViewById(R.id.imageVwProfile);
        Intent intent = getIntent();
        String strMsg = intent.getStringExtra("varStr1");
        TextView tv1 = (TextView)findViewById(R.id.txtVwStatus);
        tv1.setText("Welcome to New Activity wahai "+strMsg);

    }


    public void fnTakePic(View vw) {
        Runnable run = new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(inte  nt,0);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        TextView tv1 = (TextView)findViewById(R.id.txtVwStatus);
                        tv1.setText(tv1.getText().toString()+ "...this is your picture heheh...");
                    }
                });
            }
        };
        Thread thr = new Thread(run);
        thr.start();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bp = (Bitmap) data.getExtras().get("data");
       ImageView iv = (ImageView)findViewById(R.id.imageVwProfile);
        iv.setImageBitmap(bp);
    }



}
