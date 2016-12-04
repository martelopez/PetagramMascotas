package com.martelopez.amigosapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class Contactar extends AppCompatActivity implements View.OnClickListener {

    //private TextInputLayout tilNombre, tilCorreo, tilDescripcion;
    private EditText etNombre, etCorreo, etDescripcion;
    String nombre, correo, descripcion;
    Context context = null;
    ProgressDialog pdialog = null;
    Button btnEnviar;

    String miCorreo, miClave;

    Session session = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactar);

        etNombre = (EditText) findViewById(R.id.etNombre);
        etCorreo = (EditText) findViewById(R.id.etCorreo);
        etDescripcion = (EditText) findViewById(R.id.etDescripcion);
        btnEnviar = (Button) findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.favoritos:
                Intent intent = new Intent(this, Favoritos.class);
                startActivity(intent);
                break;
            case R.id.menuContacto:
                Intent intentC = new Intent(this, Contactar.class);
                startActivity(intentC);
                break;
            case R.id.menuAcerca:
                Intent intentA = new Intent(this, Acerca.class);
                startActivity(intentA);
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        nombre = etNombre.getText().toString();
        correo = etCorreo.getText().toString();
        descripcion = etDescripcion.getText().toString();

        miCorreo = "androidcurso@gmail.com";
        miClave  = "androidcurso";

        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");

        try {
            session = Session.getDefaultInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(miCorreo, miClave);
                }
            });

            if(session != null){

                Message.message
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
