package com.example.alpha.class7timepicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    TimePicker timePicker;
    TextView textView;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timePicker = findViewById(R.id.clk);
        textView = findViewById(R.id.time_txt);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
               Integer hr = timePicker.getCurrentHour();
               Integer mn = timePicker.getCurrentMinute();
               textView.setText(hr.toString()+ ':' + mn.toString() );
            }
        });
    }
}
