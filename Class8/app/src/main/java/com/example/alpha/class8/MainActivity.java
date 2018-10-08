package com.example.alpha.class8;

import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView play, next, prev;
    MediaPlayer mediaPlayer;
    int pauseOn;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = findViewById(R.id.play);
        prev = findViewById(R.id.prev);
        next = findViewById(R.id.next);

        play.setOnClickListener(this);
        prev.setOnClickListener(this);
        next.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.play:
                if (mediaPlayer == null){
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.friction);
                    mediaPlayer.start();
                }else if (mediaPlayer.isPlaying()){
                    count++;
                    Toast.makeText(this, count, Toast.LENGTH_SHORT).show();
                    if (count % 2 == 1){
                        mediaPlayer.seekTo(pauseOn);
                        mediaPlayer.start();
                        } else{
                        mediaPlayer.pause();
                        pauseOn = mediaPlayer.getCurrentPosition();
                    }
                }
                break;

            case R.id.prev:
                Toast.makeText(this, "Prev", Toast.LENGTH_SHORT).show();
                break;

            case R.id.next:
                Toast.makeText(this, "Nexe", Toast.LENGTH_SHORT).show();
                break;

        }

    }
}
