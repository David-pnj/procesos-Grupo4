package com.aplication.covsin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class RegisterActivity extends AppCompatActivity {

    private EditText userRe;
    private EditText passRe;
    private String userSave;
    private String passSave;
    private final String fileNameUser = "Users.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        userRe = (EditText)findViewById(R.id.editUserRe);
        passRe = (EditText)findViewById(R.id.editPasswordRe);

    }

    //Método para botones
    public void Login (View View){

        String archUsers [] = fileList();

        if (archivoExiste(archUsers, fileNameUser)){

            guardarUsuario();
            Intent login = new Intent(this, LoginActivity.class);
            startActivity(login);

        } else{

            crearFic();
            guardarUsuario();
            Intent login = new Intent(this, LoginActivity.class);
            startActivity(login);

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


    public void guardarUsuario(){
        userSave = userRe.getText().toString();
        passSave = passRe.getText().toString();
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
            fichUsers.write("usuario:"+userSave+"/pass:"+passSave);
            fichUsers.flush();
            fichUsers.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}