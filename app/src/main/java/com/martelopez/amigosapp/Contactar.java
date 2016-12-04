package com.martelopez.amigosapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Contactar extends AppCompatActivity {

    //private TextInputLayout tilNombre, tilCorreo, tilDescripcion;
    private EditText etNombre, etCorreo, etDescripcion;

    String nombre; String correo; String descripcion;

    Context context = null;

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

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nombre = etNombre.getText().toString();
                correo = etCorreo.getText().toString();
                descripcion = etDescripcion.getText().toString();

                miCorreo = "martelopezclases@gmail.com";
                miClave  = "Clases2016";

                //StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder.permitAll().build();
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

                        Message message = new MimeMessage(session);
                        message.setFrom(new InternetAddress("martelopezclases@gmail.com"));
                        message.setSubject(nombre);

                        message.setRecipient(Message.RecipientType.TO, InternetAddress.parse(InternetAddress.parse(correo));
                        message.setContent(descripcion, "text/html;charset=utf-8");
                        Transport.send(message);
                        Toast.makeText(getApplicationContext(), "Message sent", Toast.LENGTH_LONG).show();
                    }

                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        });
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

}
