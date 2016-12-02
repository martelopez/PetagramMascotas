package com.martelopez.amigosapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Contactar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactar);
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
}
