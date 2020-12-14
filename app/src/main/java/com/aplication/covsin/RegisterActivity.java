package com.aplication.covsin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;


public class RegisterActivity extends AppCompatActivity {

    private EditText userRe;
    private EditText passRe;
    private EditText nameRe;
    private EditText birthDateRe;
    private String userSave;
    private String passSave;
    private String nameSave;
    private String birthDateSave;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        userRe = (EditText)findViewById(R.id.editUserRe);
        passRe = (EditText)findViewById(R.id.editPasswordRe);
        nameRe = (EditText)findViewById(R.id.editNameRe);
        birthDateRe = (EditText)findViewById(R.id.editBirthRe);

    }

    //Método para botones
    public void Login (View View){
        userSave = userRe.getText().toString();
        passSave = passRe.getText().toString();
        nameSave = nameRe.getText().toString();
        birthDateSave = birthDateRe.getText().toString();

        String userData[] = {userSave, passSave, nameSave, birthDateSave};

        Registrar(userData);

        userRe.setText("");
        passRe.setText("");
        nameRe.setText("");
        birthDateRe.setText("");

        Intent login = new Intent(this, LoginActivity.class);
        startActivity(login);
        Animatoo.animateSlideRight(this);
    }

    public void Registrar (String datos[]) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase baseDeDatos = admin.getWritableDatabase();

        if (!datos[0].isEmpty() && !datos[1].isEmpty() && !datos[2].isEmpty() && !datos[3].isEmpty()){
            ContentValues sub = new ContentValues();

            sub.put("USER", datos[0]);
            sub.put("PASS", datos[1]);
            sub.put("NAME", datos[2]);
            sub.put("BIRTHDATE", datos[3]);
            baseDeDatos.insert("USER_DATA", null, sub);

            Toast.makeText(this,"Registro exitoso", Toast.LENGTH_SHORT).show();
            baseDeDatos.close();
        } else {
            Toast.makeText(this, "Registro fallido", Toast.LENGTH_SHORT).show();
        }

    }
}