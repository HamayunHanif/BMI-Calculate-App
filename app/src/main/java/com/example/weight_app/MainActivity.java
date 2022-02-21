package com.example.weight_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText edtweight,edtheightft,edtheightin;
        TextView txtresult;
        Button btncalculate;
        LinearLayout llmain;

        edtweight = findViewById(R.id.edtweight);
        edtheightft = findViewById(R.id.edtheightft);
        edtheightin = findViewById(R.id.edtheightin);
        txtresult = findViewById(R.id.txtresult);
        btncalculate = findViewById(R.id.btncalculate);
        llmain = findViewById(R.id.llmain);

        btncalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               int wt =Integer.parseInt(edtweight.getText().toString());
               int ft = Integer.parseInt(edtheightft.getText().toString());
               int in = Integer.parseInt(edtheightin.getText().toString());

               int totalin = ft*12+in;
               double totalcm = totalin*2.53;
               double totalM = totalcm/100;
               double bmi = wt/(totalM*totalM);

               if (bmi>25){
                   txtresult.setText("You are overweight");
                   llmain.setBackgroundColor(getResources().getColor(R.color.orange));
               } else if (bmi<18){
                   txtresult.setText("You are underwight");
                   llmain.setBackgroundColor(getResources().getColor(R.color.purple));
               } else {
                   txtresult.setText("You are Healthy");
                   llmain.setBackgroundColor(getResources().getColor(R.color.pink));
               }





            }
        });
    }
}