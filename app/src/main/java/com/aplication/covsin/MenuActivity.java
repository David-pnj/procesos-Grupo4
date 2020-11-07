package com.aplication.covsin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    //Método para botones
    public void Login (View View){

        Intent login = new Intent(this, LoginActivity.class);
        startActivity(login);


    }
    public void Register (View View){

        Intent register = new Intent(this, RegisterActivity.class);
        startActivity(register);


    }
    public void Symtoms (View View){

        Intent symtons = new Intent(this, SymptomsActivity.class);
        startActivity(symtons);


    }
    public void Map (View View){

        Intent map = new Intent(this, MapActivity.class);
        startActivity(map);


    }
}