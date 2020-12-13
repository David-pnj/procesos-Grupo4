package com.aplication.covsin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Date;

public class TracingActivity extends AppCompatActivity {

    private TextView habituales;
    private Switch fiebre;
    private Switch tos;
    private Switch cansancio;

    private TextView menosHabituales;
    private Switch molestia;
    private Switch dolorGarganta;
    private Switch diarrea;
    private Switch conjuntivitis;
    private Switch dolorCabeza;
    private Switch perdidaSentido;
    private Switch erupciones;

    private TextView graves;
    private Switch dificultadR;
    private Switch dolorPecho;
    private Switch incapazHablar;


    private String userLogin;
    private final String file = "Record.txt";
    private  String fileNameUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracing);
        userLogin = getIntent().getStringExtra("name");
        fileNameUser = userLogin+file;

        habituales = (TextView)findViewById(R.id.habituales);
        fiebre = (Switch)findViewById(R.id.fiebre);
        tos = (Switch)findViewById(R.id.tos);
        cansancio = (Switch)findViewById(R.id.cansancio);
        menosHabituales = (TextView)findViewById(R.id.menosHabituales);
        molestia = (Switch)findViewById(R.id.molestia);
        dolorGarganta = (Switch)findViewById(R.id.dolorGarganta);
        diarrea = (Switch)findViewById(R.id.diarrea);
        conjuntivitis = (Switch)findViewById(R.id.conjuntivitis);
        dolorCabeza = (Switch)findViewById(R.id.dolorCabeza);
        perdidaSentido = (Switch)findViewById(R.id.perdidaSentido);
        erupciones = (Switch)findViewById(R.id.erupciones);
        graves = (TextView)findViewById(R.id.graves);
        dificultadR = (Switch)findViewById(R.id.dificultadR);
        dolorPecho = (Switch)findViewById(R.id.dolorPecho);
        incapazHablar = (Switch)findViewById(R.id.incapazHablar);

    }

    public void Sesion (View View){

        tracing();
        Intent sesion = new Intent(this, SesionActivity.class);
        startActivity(sesion);
        Animatoo.animateSlideRight(this);

    }

    public void tracing () {

        SharedPreferences prefs = getSharedPreferences("shared_login_data",   Context.MODE_PRIVATE);
        String idUser = prefs.getString("UserID", "");
        long millis=System.currentTimeMillis();
        java.sql.Date date=new java.sql.Date(millis);

        String saveFiebre = fiebre.getText().toString()+": "+fiebre.isChecked();
        String saveTos = tos.getText().toString()+": "+tos.isChecked();
        String saveCansancio = cansancio.getText().toString()+": "+cansancio.isChecked();

        String saveMolestia = molestia.getText().toString()+": "+molestia.isChecked();
        String saveDolorGarganta = dolorGarganta.getText().toString()+": "+dolorGarganta.isChecked();
        String saveDiarrea = diarrea.getText().toString()+": "+diarrea.isChecked();
        String saveConjuntivitis = conjuntivitis.getText().toString()+": "+conjuntivitis.isChecked();
        String saveDolorCabeza = dolorCabeza.getText().toString()+": "+dolorCabeza.isChecked();
        String savePerdidaSentido = perdidaSentido.getText().toString()+": "+perdidaSentido.isChecked();
        String saveErupciones = erupciones.getText().toString()+": "+erupciones.isChecked();

        String saveDificultadR = dificultadR.getText().toString()+": "+dificultadR.isChecked();
        String saveDolorPecho = dolorPecho.getText().toString()+": "+dolorPecho.isChecked();
        String saveIncapazHablar = incapazHablar.getText().toString()+": "+incapazHablar.isChecked();

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase baseDeDatos = admin.getWritableDatabase();

        ContentValues tra = new ContentValues();

        tra.put("ID_USER", Integer.parseInt(idUser));
        tra.put("DATE", String.valueOf(date));
        tra.put("FIEBRE", saveFiebre);
        tra.put("TOS_SECA", saveTos);
        tra.put("CANSANCIO", saveCansancio);
        tra.put("MOLESTIAS_DOLORES", saveMolestia);
        tra.put("DOLOR_GARGANTA", saveDolorGarganta);
        tra.put("DIARREA", saveDiarrea);
        tra.put("CONJUNTIVITIS", saveConjuntivitis);
        tra.put("DOLOR_CABEZA", saveDolorCabeza);
        tra.put("PERDIDA_UN_SENTIDO", savePerdidaSentido);
        tra.put("ERUPCIONES_CUTÁNEAS", saveErupciones);
        tra.put("DIFICULTAD_RESPIRAR", saveDificultadR);
        tra.put("DOLOR_PECHO", saveDolorPecho);
        tra.put("INCAPACIDAD_HABLAR_MOVERSE", saveIncapazHablar);

        baseDeDatos.insert("RECORD", null, tra);

        Toast.makeText(this,"Registro exitoso", Toast.LENGTH_SHORT).show();
        baseDeDatos.close();
    }
}