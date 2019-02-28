package com.example.bitp3453labs;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.time.Year;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
TextView txtvwAge;
EditText edtName,edtYear;
Button btnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txtvwAge = (TextView) findViewById(R.id.txtvwAge);
        edtName = (EditText) findViewById(R.id.edtTxtName);
        edtYear = (EditText) findViewById(R.id.edtYear);
    }


    public void fnThreadedActivity(View vw) {
        Intent intent = new Intent(this, ThreadedActivity.class);
        String strMSG = ((EditText) findViewById(R.id.edtTxtName)).getText().toString();
        intent.putExtra("varStr1", strMSG);
        startActivity(intent);
    }

    public void fnGreet(View vw)
    {

        String strName = edtName.getText().toString();
        String intumur = edtYear.getText().toString();
        int desiredValue = Integer.parseInt(intumur);
        int years = Calendar.getInstance().get(Calendar.YEAR);  
        int result = years-desiredValue;
        txtvwAge.setText("Hello and welcome " + strName +"! You are " +result+ " years old");
    }
}
