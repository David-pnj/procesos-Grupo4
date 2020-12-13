package com.aplication.covsin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class RecordActivity extends AppCompatActivity {

    private TextView muestraRecord;
    private String userLogin;
    private final String file = "Record.txt";
    private  String fileNameUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        userLogin = getIntent().getStringExtra("name");
        fileNameUser = userLogin+file;

        muestraRecord = (TextView)findViewById(R.id.textHistorial);
        muestraRecord.setMovementMethod(new ScrollingMovementMethod());


        String recor = "";

        recor = record();
        muestraRecord.setText(recor);

    }

    public void Sesion (View View){

        Intent sesion = new Intent(this, SesionActivity.class);
        startActivity(sesion);
        Animatoo.animateSlideRight(this);

    }

    public String record (){
        String lines = "";
        SharedPreferences prefs = getSharedPreferences("shared_login_data",   Context.MODE_PRIVATE);
        String idUser = prefs.getString("UserID", "");
        String name = prefs.getString("Name", "");

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase baseDeDatos = admin.getWritableDatabase();

        if (!idUser.isEmpty()){
            Cursor fila = baseDeDatos.rawQuery("SELECT DATE, FIEBRE, TOS_SECA, CANSANCIO, MOLESTIAS_DOLORES, DOLOR_GARGANTA, DIARREA, CONJUNTIVITIS, DOLOR_CABEZA, PERDIDA_UN_SENTIDO, ERUPCIONES_CUTÁNEAS, DIFICULTAD_RESPIRAR, DOLOR_PECHO, INCAPACIDAD_HABLAR_MOVERSE " +
                    "FROM RECORD " +
                    "WHERE " +
                    "ID_USER =" + idUser, null);
            if(fila.moveToFirst()) {
                while (!fila.isAfterLast()) {
                    lines = lines + ("*Nueva entrada del usuario: "+name+" a fecha: "+fila.getString(fila.getColumnIndex("DATE"))+"\n"+
                            fila.getString(fila.getColumnIndex("FIEBRE"))+"\n"+
                            fila.getString(fila.getColumnIndex("TOS_SECA"))+"\n"+
                            fila.getString(fila.getColumnIndex("CANSANCIO"))+"\n"+
                            fila.getString(fila.getColumnIndex("MOLESTIAS_DOLORES"))+"\n"+
                            fila.getString(fila.getColumnIndex("DOLOR_GARGANTA"))+"\n"+
                            fila.getString(fila.getColumnIndex("DIARREA"))+"\n"+
                            fila.getString(fila.getColumnIndex("CONJUNTIVITIS"))+"\n"+
                            fila.getString(fila.getColumnIndex("DOLOR_CABEZA"))+"\n"+
                            fila.getString(fila.getColumnIndex("PERDIDA_UN_SENTIDO"))+"\n"+
                            fila.getString(fila.getColumnIndex("ERUPCIONES_CUTÁNEAS"))+"\n"+
                            fila.getString(fila.getColumnIndex("DIFICULTAD_RESPIRAR"))+"\n"+
                            fila.getString(fila.getColumnIndex("DOLOR_PECHO"))+"\n"+
                            fila.getString(fila.getColumnIndex("INCAPACIDAD_HABLAR_MOVERSE"))+"\n"+
                            "*"+"\n"+"*"+"\n");

                    fila.moveToNext();
                }
                baseDeDatos.close();
                return lines;
            } else {
                Toast.makeText(this,"No hay datos del usuario", Toast.LENGTH_SHORT).show();
                baseDeDatos.close();
                return null;
            }

        } else {
            Toast.makeText(this,"Logging fallido", Toast.LENGTH_SHORT).show();
            return null;
        }
    }

}