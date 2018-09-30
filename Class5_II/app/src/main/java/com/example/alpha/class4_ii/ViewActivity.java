package com.example.alpha.class4_ii;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewActivity extends AppCompatActivity {
    TextView text, text1, text2;
    String Value, Value1, Value2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        text = findViewById(R.id.details);
        text1 = findViewById(R.id.details1);
        text2 = findViewById(R.id.details2);
        Value = getIntent().getExtras().getString("Value");
        Value1 = getIntent().getExtras().getString("Value1");
        Value2 = getIntent().getExtras().getString("Value2");
        text.setText(Value);
        text1.setText(Value1);
        text2.setText(Value2);

    }
}
