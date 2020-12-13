package com.aplication.covsin.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.aplication.covsin.AdminSQLiteOpenHelper;

public abstract class Usuarios extends Context {

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
        }


    }
}
