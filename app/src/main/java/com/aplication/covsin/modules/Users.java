package com.aplication.covsin.modules;

import com.google.gson.Gson;

import java.io.File;

public class Users {
    private String user = "";
    private String pass = "";
    private Gson g = new Gson();
    private final String fileName = "Users.json";

    public Users(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void guardarUsuario(Users users){


    }

    public void guardarSintomas(String usuario){

    }

    public String cargarUsuario(){
        String usuarios = null;

        return usuarios;

    }

    public String cargarSintomas(String usuario){
        String historial = null;

        return historial;

    }

    public void crearFich (){

        File file = new File(context.getFilesDir(), fileName);
        File file = new File("./Android/data/com.aplication.covsin", fileName);
    }

}
