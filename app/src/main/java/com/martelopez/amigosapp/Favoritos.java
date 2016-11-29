package com.martelopez.amigosapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import static com.martelopez.amigosapp.R.id.rvContactos;

public class Favoritos extends AppCompatActivity {

    ArrayList<Contacto> contactos;
    private RecyclerView listaContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        listaContactos = (RecyclerView) findViewById(rvContactos);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaContactos.setLayoutManager(llm);
        iniciarListaContactos();
        iniciarAdaptador();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        switch(item.getItemId()) {
            case R.id.favoritos:  // LLamar el Activity Favosritos
                Intent intent = new Intent(this, DetalleContacto.class);
                startActivity(intent);
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    public ContactoAdaptador adaptador;

    private void iniciarAdaptador() {

        adaptador = new ContactoAdaptador(contactos,this);
        listaContactos.setAdapter(adaptador);
    }

    private void iniciarListaContactos() {

        contactos = new ArrayList<Contacto>();

        // Creamos los contactos
        contactos.add(new Contacto(R.drawable.dalmata,R.drawable.dogboneamarillo,"Dalmata", "5",R.drawable.dogboneblanco));
        contactos.add(new Contacto(R.drawable.bulldog,R.drawable.dogboneamarillo,"Bulldog", "4",R.drawable.dogboneblanco));
        contactos.add(new Contacto(R.drawable.doberman,R.drawable.dogboneamarillo,"Doberman", "1",R.drawable.dogboneblanco));
        contactos.add(new Contacto(R.drawable.goldenretriever,R.drawable.dogboneamarillo,"Goldenretriever", "2",R.drawable.dogboneblanco));
        contactos.add(new Contacto(R.drawable.foxterrier,R.drawable.dogboneamarillo,"Foxterrier", "3",R.drawable.dogboneblanco));
    }
}
