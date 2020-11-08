package com.aplication.covsin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

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

        String archUsers [] = fileList();

        if (archivoExiste(archUsers, fileNameUser)){

            guardarTracing();
            Intent sesion = new Intent(this, SesionActivity.class);
            sesion.putExtra("name", userLogin);
            startActivity(sesion);

        } else{

            crearFic();
            guardarTracing();
            Intent sesion = new Intent(this, SesionActivity.class);
            sesion.putExtra("name", userLogin);
            startActivity(sesion);

        }
    }

    private boolean archivoExiste(String source [], String sourceName) {
        for (int i = 0; i<source.length; i++){
            if (sourceName.equals(source[i])){
                return true;
            }
        }
        return false;
    }

    //Crear el fichero
    public void crearFic(){
        try {
            OutputStreamWriter fout = new OutputStreamWriter(openFileOutput(fileNameUser, Context.MODE_PRIVATE));
            fout.close();
        } catch (Exception ex) {
            Log.e("Ficheros", "Error al escribir fichero a memoria interna");
        }
    }

    public void guardarTracing(){

        String saveHabituales = habituales.getText().toString();
        String saveFiebre = fiebre.getText().toString()+": "+fiebre.isChecked();
        String saveTos = tos.getText().toString()+": "+tos.isChecked();
        String saveCansancio = cansancio.getText().toString()+": "+cansancio.isChecked();

        String saveMenosHabituales = menosHabituales.getText().toString();
        String saveMolestia = molestia.getText().toString()+": "+molestia.isChecked();
        String saveDolorGarganta = dolorGarganta.getText().toString()+": "+dolorGarganta.isChecked();
        String saveDiarrea = diarrea.getText().toString()+": "+diarrea.isChecked();
        String saveConjuntivitis = conjuntivitis.getText().toString()+": "+conjuntivitis.isChecked();
        String saveDolorCabeza = dolorCabeza.getText().toString()+": "+dolorCabeza.isChecked();
        String savePerdidaSentido = perdidaSentido.getText().toString()+": "+perdidaSentido.isChecked();
        String saveErupciones = erupciones.getText().toString()+": "+erupciones.isChecked();

        String saveGraves = graves.getText().toString();
        String saveDificultadR = dificultadR.getText().toString()+": "+dificultadR.isChecked();
        String saveDolorPecho = dolorPecho.getText().toString()+": "+dolorPecho.isChecked();
        String saveIncapazHablar = incapazHablar.getText().toString()+": "+incapazHablar.isChecked();

        String lines = "";
        String line = "";
        int i = 0;

        try {
            InputStreamReader archivo = new InputStreamReader(openFileInput(fileNameUser));
            BufferedReader br = new BufferedReader(archivo);
            line = br.readLine();

            while (line != null){
                lines = lines + line +"\n";
                line = br.readLine();

            }
            br.close();
            archivo.close();

            OutputStreamWriter fichUsers = new OutputStreamWriter(openFileOutput(fileNameUser, Context.MODE_PRIVATE));
            if (lines != null ){
                fichUsers.write(lines);
            }
            fichUsers.write("*Nueva entrada del usuario: "+userLogin+"\n"+
                    saveHabituales+"\n"+
                    saveFiebre+"\n"+
                    saveTos+"\n"+
                    saveCansancio+"\n"+
                    saveMenosHabituales+"\n"+
                    saveMolestia+"\n"+
                    saveDolorGarganta+"\n"+
                    saveDiarrea+"\n"+
                    saveConjuntivitis+"\n"+
                    saveDolorCabeza+"\n"+
                    savePerdidaSentido+"\n"+
                    saveErupciones+"\n"+
                    saveGraves+"\n"+
                    saveDificultadR+"\n"+
                    saveDolorPecho+"\n"+
                    saveIncapazHablar+"\n"+
                    "*"+"\n"+"*"+"\n");

            fichUsers.flush();
            fichUsers.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}