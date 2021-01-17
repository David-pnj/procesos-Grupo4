package com.aplication.covsin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class Rating1Activity extends AppCompatActivity {

    private EditText coment;
    private RatingBar note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating1);

        coment = (EditText) findViewById(R.id.coment);
        note = (RatingBar) findViewById(R.id.ratingBar);
    }

    public void Sesion (View View){

        Intent sesion = new Intent(this, SesionActivity.class);
        startActivity(sesion);
        Animatoo.animateSlideRight(this);

    }

    public void RatingSesion (View View) {

        SharedPreferences prefs = getSharedPreferences("shared_login_data",   Context.MODE_PRIVATE);
        String idUser = prefs.getString("UserID", "");
        long millis=System.currentTimeMillis();
        java.sql.Date date=new java.sql.Date(millis);

        String saveComent = coment.getText().toString();
        String saveNote = String.valueOf(note.getRating());


        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase baseDeDatos = admin.getWritableDatabase();

        ContentValues tra = new ContentValues();

        tra.put("ID_USER", Integer.parseInt(idUser));
        tra.put("DATE", String.valueOf(date));
        tra.put("DESCRIPCION", saveComent);
        tra.put("PUNTOS", saveNote);


        baseDeDatos.insert("RATING", null, tra);

        Toast.makeText(this,"Registro exitoso", Toast.LENGTH_SHORT).show();
        baseDeDatos.close();

        Intent sesion = new Intent(this, SesionActivity.class);
        startActivity(sesion);
        Animatoo.animateSlideRight(this);
    }

}