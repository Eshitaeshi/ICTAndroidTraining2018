package com.example.alpha.class3;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    RadioGroup rg;
    Button bt;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rg = findViewById(R.id.radio_grp);
        bt = findViewById(R.id.btn);
        tv = findViewById(R.id.txt);

        bt.setOnClickListener(new OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                int genderID = rg.getCheckedRadioButtonId();
                Button getOption = findViewById(genderID);
                String value = getOption.getText().toString();
                tv.setText("You have selected " + value);
            }
        });
    }
}