package com.aplication.covsin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

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


        String archUsers [] = fileList();
        String recor = "";


        if (archivoExiste(archUsers, fileNameUser)){

            recor = cargarTracing();
            muestraRecord.setText(recor);

        } else{

            crearFic();
            recor = cargarTracing();
            muestraRecord.setText(recor);

        }
    }

    public void Sesion (View View){

        Intent sesion = new Intent(this, SesionActivity.class);
        sesion.putExtra("name", userLogin);
        startActivity(sesion);



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

    public String cargarTracing(){

        String lines = "";
        String line = "";
        int i = 0;

        try {
            InputStreamReader archivo = new InputStreamReader(openFileInput(fileNameUser));
            BufferedReader br = new BufferedReader(archivo);
            line = br.readLine();

            while (line != null){
                lines = lines + line+"\n";
                line = br.readLine();

            }
            br.close();
            archivo.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }

}