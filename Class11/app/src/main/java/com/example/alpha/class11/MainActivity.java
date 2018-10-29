package com.example.alpha.class11;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button call, sms, email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        call = findViewById(R.id.call);
        sms = findViewById(R.id.sms);
        email = findViewById(R.id.email);

        call.setOnClickListener(this);
        sms.setOnClickListener(this);
        email.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.call:
                setCall();
                break;
            case R.id.sms:
                setSms();
                break;
            case R.id.email:
                setEmail();
                break;
        }
    }

    public void setCall(){
        String phone = "+8801521468097";
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.fromParts("tel", phone, null));
        startActivity(intent);
        if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_DENIED){
            return;
        }
        startActivity(intent);
    }

    public void setSms(){
        Intent smsIntent = new Intent(Intent.ACTION_VIEW);
        smsIntent.putExtra("address", "01521468097");
        smsIntent.setType("vnd.android-dir/mms-sms");
        startActivity(smsIntent);
        Toast.makeText(this, "SMS Sending", Toast.LENGTH_SHORT).show();
    }

    public void setEmail(){
        String[] TO = {"tosabbir@ieee.org"};
        String[] CC = {"sabbir.eee.hstu@gmail.com"};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("MailTo:"));
        emailIntent.setType("text/pain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Mail Subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "mail text");

        try {
            startActivity(Intent.createChooser(emailIntent, "Send Email..."));
            finish();
        } catch (android.content.ActivityNotFoundException e){
            Toast.makeText(this, "Install an email client", Toast.LENGTH_SHORT).show();
        }

//        Toast.makeText(this, "Sending Email", Toast.LENGTH_SHORT).show();

    }
}