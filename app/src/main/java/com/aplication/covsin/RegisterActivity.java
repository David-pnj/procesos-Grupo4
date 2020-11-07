package com.aplication.covsin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


import com.aplication.covsin.modules.Users;



public class RegisterActivity extends AppCompatActivity {

    private EditText userRe;
    private EditText passRe;
    private Users userSave;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        userRe = (EditText)findViewById(R.id.editUserRe);
        passRe = (EditText)findViewById(R.id.editPasswordRe);
        userSave = new Users(String.valueOf(userRe), String.valueOf(passRe));

    }

    private boolean archivoExiste(String source [], String sourceName) {
        for (int i = 0; i<source.length; i++){
            if (sourceName.equals(source[i])){
                return true;
            }
        }
        return false;
    }

    //Método para botones, DAVID SACO BOTONES MIENTRAS TRABAJABA POR EL ERROR Q LE DABA LO DELOS FICH INACABADOS
    public void Sesion (View View){

        Intent sesion = new Intent(this, LoginActivity.class);
        startActivity(sesion);


    }

  /*  public void Login (View View){

        String archUsers [] = fileList();

        if (archivoExiste(archUsers, "Users.json")){

            userSave.guardarUsuario(userSave);
            Intent login = new Intent(this, LoginActivity.class);
            startActivity(login);

        } else{

            userSave.crearFich();
            userSave.guardarUsuario(userSave);
            Intent login = new Intent(this, LoginActivity.class);
            startActivity(login);

        }
    }
    */

}