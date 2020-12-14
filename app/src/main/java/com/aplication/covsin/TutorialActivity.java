package com.aplication.covsin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class TutorialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        VideoView videoTutorial = findViewById(R.id.videoView);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.tutorial;
        Uri uri =  Uri.parse(videoPath);
        videoTutorial.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        videoTutorial.setMediaController(mediaController);
        mediaController.setAnchorView(videoTutorial);
    }

    public void Menu (View View){
        Intent menu =new Intent(this, MenuActivity.class);
        startActivity(menu);
    }

}