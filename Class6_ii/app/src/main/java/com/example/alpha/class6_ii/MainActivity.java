package com.example.alpha.class6_ii;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_splash);

        long Delay = 1700;
        Timer runsTimer = new Timer();

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                finish();
                Intent intent = new Intent(getApplicationContext(), SplashActivity.class);
                startActivity(intent);
            }

        };

        runsTimer.schedule(timerTask, Delay);
    }
}
