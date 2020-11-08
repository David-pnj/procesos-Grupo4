package com.aplication.covsin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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


    }
    public void Map (View View){

        Intent map = new Intent(this, MapActivity.class);
        startActivity(map);


    }
    public void Tracing (View View){

        Intent tracing = new Intent(this, TracingActivity.class);
        tracing.putExtra("name", userLogin);
        startActivity(tracing);


    }
    public void Record (View View){

        Intent record = new Intent(this, RecordActivity.class);
        record.putExtra("name", userLogin);
        startActivity(record);


    }
}