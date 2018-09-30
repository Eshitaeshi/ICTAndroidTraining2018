package com.example.alpha.class4_ii;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    EditText getText, getText1, getText2;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getText = findViewById(R.id.edit);
        getText1 = findViewById(R.id.edit2);
        getText2 = findViewById(R.id.edit3);

        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = getText.getText().toString();
                Intent intent = new Intent(getApplicationContext(), ViewActivity.class);
                intent.putExtra("Value", value);
                intent.putExtra("Value1", value);
                intent.putExtra("Value2", value);
                startActivity(intent);
            }
        });

    }
}
