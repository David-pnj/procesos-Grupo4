package com.aplication.covsin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class LoginActivity extends AppCompatActivity {

    private EditText userLo;
    private EditText passLo;
    private String userLogin;
    private String passLogin;
    private final String fileNameUser = "Users.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userLo = (EditText)findViewById(R.id.editUser);
        passLo = (EditText)findViewById(R.id.editPassword);

    }
    public void Sesion (View View){

        String archUsers [] = fileList();
        boolean login = false;

        userLogin = userLo.getText().toString();
        passLogin = passLo.getText().toString();

        if (archivoExiste(archUsers, fileNameUser)){

            login = loguearUsuario();
            if (login){

                Intent sesion = new Intent(this, SesionActivity.class);
                sesion.putExtra("name", userLogin);
                startActivity(sesion);
            } else {
                Toast.makeText(this, "Usuario o contraseña incorrectas", Toast.LENGTH_SHORT).show();
            }

        } else{

            crearFic();
            login = loguearUsuario();
            if (login){
                Intent sesion = new Intent(this, SesionActivity.class);
                sesion.putExtra("name", userLogin);
                startActivity(sesion);
            } else {
                Toast.makeText(this, "Usuario o contraseña incorrectas", Toast.LENGTH_SHORT).show();
            }

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

    public boolean loguearUsuario(){
        String[] userData = null;
        String line = "";
        boolean login = false;


        try {
            InputStreamReader archivo = new InputStreamReader(openFileInput(fileNameUser));
            BufferedReader br = new BufferedReader(archivo);
            line = br.readLine();

            while (line != null){

                userData = line.split("/");
                String[] user = userData[0].split(":");
                String[] pass = userData[1].split(":");
                if (user[1].equals(userLogin) && pass[1].equals(passLogin)){
                    login = true;
                }

                line = br.readLine();


            }
            br.close();
            archivo.close();



        } catch (IOException e) {
            e.printStackTrace();
        }
        return login;
    }

}