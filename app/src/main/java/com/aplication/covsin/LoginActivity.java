package com.aplication.covsin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

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

        userLogin = userLo.getText().toString();
        passLogin = passLo.getText().toString();

        String userData[] = {userLogin, passLogin};
        String infoUsers[] = loguear(userData);

        SharedPreferences sharedpreferences = getSharedPreferences("shared_login_data",   Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString("UserID", "");
        editor.putString("User" , "");
        editor.putString("Name" , "");
        editor.commit();

        if (!infoUsers[0].isEmpty() && !infoUsers[1].isEmpty() && !infoUsers[2].isEmpty()){


            editor.putString("UserID", infoUsers[0]);
            editor.putString("User" , infoUsers[1]);
            editor.putString("Name" , infoUsers[2]);
            editor.commit();




            Intent sesion = new Intent(this, SesionActivity.class);
            startActivity(sesion);
            Animatoo.animateSlideRight(this);


        } else{

        }
    }

    public String[] loguear (String datos[]) {
        Integer idUser;
        String dato1= datos[0];
        String dato2= datos[1];
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase baseDeDatos = admin.getWritableDatabase();

        if (!datos[0].isEmpty() && !datos[1].isEmpty()){
            Cursor fila = baseDeDatos.rawQuery
                    ("SELECT ID_USER, USER, NAME " +
                            "FROM USER_DATA " +
                            "WHERE " +
                            "USER =\"" + dato1 + "\" and  " +
                            "PASS =\"" + dato2 + "\"", null);
            if(fila.moveToFirst()) {
                idUser = fila.getInt(0);
                String info[] = {idUser.toString(), fila.getString(1), fila.getString(2)};
                baseDeDatos.close();
                return info;
            } else {
                Toast.makeText(this,"Usuario o contraseña incorrectas", Toast.LENGTH_SHORT).show();
                baseDeDatos.close();
                return null;
            }

        } else {
            Toast.makeText(this,"Logging fallido", Toast.LENGTH_SHORT).show();
            return null;
        }
    }


}