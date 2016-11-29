package com.martelopez.amigosapp;

/**
 * Created by emartelopez on 18/11/16.
 */

public class Contacto {

    private String nombre;
    private String telefono;
    private int foto;
    private int foto2;
    private int foto3;

    public Contacto(int foto, int foto2, String nombre, String telefono, int foto3) {
        this.foto = foto;
        this.foto2 = foto2;
        this.nombre = nombre;
        this.telefono = telefono;
        this.foto2 = foto3;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getFoto2() {
        return foto2;
    }

    public void setFoto2(int foto2) {
        this.foto2 = foto2;
    }

    public int getFoto3() {
        return foto3;
    }

    public void setFoto3(int foto3) {
        this.foto3 = foto3;
    }
}
