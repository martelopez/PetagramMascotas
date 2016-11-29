package com.martelopez.amigosapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetalleContacto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);

        //Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        //setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        // Obtener los datos que manda el MainActivity
        Bundle parametros = getIntent().getExtras();

        String nombre   = parametros.getString("nombre");
        String telefono = parametros.getString("telefono");


        TextView tvNombre   = (TextView) findViewById(R.id.tvNombre);
        TextView tvTelefono = (TextView) findViewById(R.id.tvTelefono);

        tvNombre.setText(nombre);
        tvTelefono.setText(telefono);


    }
}
