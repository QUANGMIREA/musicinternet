package com.example.musicinternet;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button playButton = findViewById(R.id.playButton);
        mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource("https://www.learningcontainer.com/wp-content/uploads/2020/02/Kalimba.mp3");
                    mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        playButton.setOnClickListener(new View.OnClickListener() {
    @Override
   public void onClick(View v) {
  if (!mediaPlayer.isPlaying()) {
     mediaPlayer.start();
   } else {
      mediaPlayer.pause();
              }}
        });
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
