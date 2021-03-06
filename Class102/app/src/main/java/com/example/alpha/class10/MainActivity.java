package com.example.alpha.class10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.RatingBar;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    VideoView videoView;
    Button play, pause, stop;
    RatingBar ratingBar;
    MediaController mediaController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play = findViewById(R.id.play);
        pause = findViewById(R.id.pause);
        stop = findViewById(R.id.stop);
        videoView = findViewById(R.id.vdo);
        ratingBar = findViewById(R.id.rate);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(MainActivity.this, "You Rated"+ rating, Toast.LENGTH_SHORT).show();
            }
        });

        play();

        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        stop.setOnClickListener(this);


    }

    private void play() {
        Uri uri = Uri.parse("android.resource://"+ getPackageName()+"/"+R.raw.lucas);
//        Uri uri = Uri.parse("https://www.youtube.com/watch?v=LfPf9hjXNZk");

        videoView.setVideoURI(uri);
        mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        videoView.start();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.play:
                videoView.start();
                break;
            case R.id.pause:
                videoView.pause();
                break;
            case R.id.stop:
                videoView.stopPlayback();
                if (!videoView.isPlaying()){
                    play();
                    videoView.pause();
                }
                break;

        }
    }
}
