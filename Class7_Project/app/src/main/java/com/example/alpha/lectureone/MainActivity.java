package com.example.alpha.lectureone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatePicker datePicker;
    Button btn;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datePicker = findViewById(R.id.cal);
        btn = findViewById(R.id.btn);
        textView = findViewById(R.id.txt);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer day = datePicker.getDayOfMonth();
                Integer mnth = datePicker.getMonth() + 1;
                Integer year = datePicker.getYear();
                String result = day.toString() + "/" + mnth.toString() + "/" + year.toString();
                textView.setText(result);
                
                if (day == 19 && mnth == 1) {
                    Toast.makeText(MainActivity.this, "Happy Birthday", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
