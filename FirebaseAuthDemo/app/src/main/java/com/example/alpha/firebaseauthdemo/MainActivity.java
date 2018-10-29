package com.example.alpha.firebaseauthdemo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn;
    TextView textView;
    EditText mEmail, mPassword;
    FirebaseAuth mAuth;
    ProgressDialog mProg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mProg = new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();
        btn = findViewById(R.id.register);
        textView = findViewById(R.id.textViewRegistered);
        mEmail = findViewById(R.id.editTextEmail);
        mPassword = findViewById(R.id.editTextPassword);


        btn.setOnClickListener(this);
        textView.setOnClickListener(this);
        mEmail.setOnClickListener(this);
        mPassword.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btn){
            creatAccount();
        }
        if (v == textView){
            //will open sign in progressbar
        }

    }

    public void creatAccount(){
        String email = mEmail.getText().toString().trim();
        String pass = mPassword.getText().toString().trim();
        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(pass)){
            Toast.makeText(this, "Emply email or password", Toast.LENGTH_SHORT).show();
            return;
        }
        mProg.setMessage("Registering User... ");
        mProg.show();
        mAuth.createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "User Registered", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                            startActivity(intent);
                            mProg.dismiss();
                        }else{
                            Toast.makeText(MainActivity.this, "Try Again", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

}
