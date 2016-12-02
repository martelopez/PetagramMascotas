package com.martelopez.amigosapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import static com.martelopez.amigosapp.R.id.rvContactos;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contacto> contactos;
    private RecyclerView listaContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaContactos = (RecyclerView) findViewById(rvContactos);


        // Mostrar el RecyclerView
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaContactos.setLayoutManager(llm);
        iniciarListaContactos();
        iniciarAdaptador();
    }

    public void agregarFab(){
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabCamara);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

     @Override
     public boolean onOptionsItemSelected(MenuItem item){
         switch(item.getItemId()) {
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

    public ContactoAdaptador adaptador;

    private void iniciarAdaptador(){
        //ContactoAdaptador adaptador = new ContactoAdaptador(contactos);
        //listaContactos.setAdapter(adaptador);

        adaptador = new ContactoAdaptador(contactos,this);
        listaContactos.setAdapter(adaptador);
    }

    public void iniciarListaContactos(){

        contactos = new ArrayList<Contacto>();

        // Creamos los contactos
        contactos.add(new Contacto(R.drawable.dalmata,R.drawable.dogboneamarillo,"Dalmata", "5",R.drawable.dogboneblanco));
        contactos.add(new Contacto(R.drawable.bulldog,R.drawable.dogboneamarillo,"Bulldog", "4",R.drawable.dogboneblanco));
        contactos.add(new Contacto(R.drawable.doberman,R.drawable.dogboneamarillo,"Doberman", "1",R.drawable.dogboneblanco));
        contactos.add(new Contacto(R.drawable.goldenretriever,R.drawable.dogboneamarillo,"Goldenretriever","2",R.drawable.dogboneblanco));
        contactos.add(new Contacto(R.drawable.foxterrier,R.drawable.dogboneamarillo,"Foxterrier", "3",R.drawable.dogboneblanco));

    }
}
