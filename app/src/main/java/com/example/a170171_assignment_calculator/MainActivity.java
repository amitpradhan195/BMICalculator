package com.example.a170171_assignment_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText weight, height;
    Button btnCalc;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weight = (EditText) findViewById(R.id.etKg);
        height = (EditText) findViewById(R.id.etM);
        btnCalc = (Button)findViewById(R.id.btnCalc);

        final TextView tvRes = (TextView)findViewById(R.id.tvRes);
        final TextView tvInfo = (TextView)findViewById(R.id.tvInfo);
        Button btnCalc = (Button)findViewById(R.id.btnCalc);


        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(weight.getText().length()==0 && height.getText().length()==0){
                    weight.setError("Field cannot be left blank");
                    height.setError("Field cannot be left blank");
                }

                else if(weight.getText().length()==0) {
                    weight.setError("Field cannot be left blank");
                }

                else if(height.getText().length()==0) {
                    height.setError("Field cannot be left blank");
                }

                else{
                    double kg = Double.parseDouble(weight.getText().toString());
                    double m = Double.parseDouble(height.getText().toString());
                    double res = kg/(m*m);

                    if (res < 18.5)
                        tvRes.setText("BMI = " + String.format("%.2f", res) + "\n Underweight");
                    else if (res >= 18.5 && res < 25)
                        tvRes.setText("BMI = " + String.format("%.2f", res) + "\n Normal Weight");
                    else
                        tvRes.setText("BMI = " + String.format("%.2f", res) + "\n Overweight");

                    tvRes.setVisibility(View.VISIBLE);
                    tvInfo.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

}