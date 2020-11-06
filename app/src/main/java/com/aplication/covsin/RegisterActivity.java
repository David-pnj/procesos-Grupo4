package com.aplication.covsin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    //Método para botones
    public void Login (View View){

        Intent login = new Intent(this, LoginActivity.class);
        startActivity(login);


    }
}