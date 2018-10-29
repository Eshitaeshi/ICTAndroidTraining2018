package com.example.alpha.firebaseauthdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

public class ProfileActivity extends AppCompatActivity {
    FirebaseAuth user;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        textView = findViewById(R.id.user_name);
        user = FirebaseAuth.getInstance();
        textView.setText(user.getCurrentUser().toString());

    }
}
