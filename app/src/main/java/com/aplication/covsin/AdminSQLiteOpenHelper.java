package com.aplication.covsin;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper{
    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase covsin) {
        covsin.execSQL("create table USER_DATA(ID_USER INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "USER TEXTO UNIQUE NOT NULL, " +
                "PASS TEXTO NOT NULL, " +
                "NAME TEXTO NOT NULL, " +
                "BIRTHDATE DATE)");

        covsin.execSQL("create table RECORD(ID_RECORD INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "ID_USER INT NOT NULL, " +
                "DATE DATE NOT NULL, " +
                "FIEBRE TEXTO NOT NULL, " +
                "TOS_SECA TEXTO NOT NULL, " +
                "CANSANCIO TEXTO NOT NULL, " +
                "MOLESTIAS_DOLORES TEXTO NOT NULL, " +
                "DOLOR_GARGANTA TEXTO NOT NULL, " +
                "DIARREA TEXTO NOT NULL, " +
                "CONJUNTIVITIS TEXTO NOT NULL, " +
                "DOLOR_CABEZA TEXTO NOT NULL, " +
                "PERDIDA_UN_SENTIDO TEXTO NOT NULL, " +
                "ERUPCIONES_CUTÁNEAS TEXTO NOT NULL, " +
                "DIFICULTAD_RESPIRAR TEXTO NOT NULL, " +
                "DOLOR_PECHO TEXTO NOT NULL, " +
                "INCAPACIDAD_HABLAR_MOVERSE TEXTO NOT NULL, " +
                "FOREIGN KEY(ID_USER) REFERENCES USER_DATA(ID_USER))");

        covsin.execSQL("create table RATING(ID_RATING INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "ID_USER INT NOT NULL, " +
                "DATE DATE NOT NULL, " +
                "DESCRIPCION TEXTO NOT NULL, " +
                "PUNTOS TEXTO NOT NULL, " +
                "FOREIGN KEY(ID_USER) REFERENCES USER_DATA(ID_USER))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
