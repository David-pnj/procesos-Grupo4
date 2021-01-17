package com.aplication.covsin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.transition.Fade;
import android.view.View;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class SesionActivity extends AppCompatActivity {

    private String userLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesion);
        userLogin = getIntent().getStringExtra("name");

    }
    public void Symtoms (View View){

        Intent symtons = new Intent(this, SymptomsActivity.class);
        startActivity(symtons);
        Animatoo.animateSlideRight(this);

    }
    public void Map (View View){

        Intent map = new Intent(this, MapActivity.class);
        startActivity(map);
        Animatoo.animateSlideRight(this);

    }
    public void Tracing (View View){

        Intent tracing = new Intent(this, TracingActivity.class);
        tracing.putExtra("name", userLogin);
        startActivity(tracing);
        Animatoo.animateSlideRight(this);

    }
    public void Record (View View){

        Intent record = new Intent(this, RecordActivity.class);
        record.putExtra("name", userLogin);
        startActivity(record);
        Animatoo.animateSlideRight(this);

    }
    public void Rating (View View){

        Intent rating = new Intent(this, Rating1Activity.class);
        rating.putExtra("name", userLogin);
        startActivity(rating);
        Animatoo.animateSlideRight(this);

    }
}