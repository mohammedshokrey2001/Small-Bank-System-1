package com.example.banksystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    Button startBT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startBT = findViewById(R.id.startButton);
      //  setContentView(R.layout.activity_main);
        VideoView videoView = findViewById(R.id.videoView2);
        String path_video = "android.resource://" +getPackageName() +"/" +R.raw.vid7;
        Uri uri = Uri.parse(path_video);
        videoView.setVideoURI(uri);
        videoView.start();


        startBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,sign_in.class);
                startActivity(intent);

            }
        });
    }
}