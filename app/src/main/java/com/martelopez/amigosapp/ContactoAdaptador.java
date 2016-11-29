package com.martelopez.amigosapp;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by emartelopez on 26/11/16.
 */

public class ContactoAdaptador extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder>{

    ArrayList<Contacto> contactos;
    Activity activity;

    // Clase para invocar el metodo constructor y pasarla al objeto de la clase
    public ContactoAdaptador(ArrayList<Contacto> contactos, Activity activity){
        this.contactos = contactos;
        this.activity = activity;
    }

    // Inflar el Layotu y lo pasa al ViewHolder y obtenga cada elementos
    @Override
    public ContactoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contacto, parent,false);
        return new ContactoViewHolder(v);
    }

    // Asocia cada elemento de la lista a cada View
    @Override
    public void onBindViewHolder(ContactoViewHolder contactoViewHolder, int position) {
        final Contacto contacto = contactos.get(position); // Obtiene los Objetos

        contactoViewHolder.imgFoto.setImageResource(contacto.getFoto());
        contactoViewHolder.btnLike.setImageResource(contacto.getFoto2());
        contactoViewHolder.tvnombreCV.setText(contacto.getNombre());
        contactoViewHolder.tvTelefonoCV.setText(contacto.getTelefono());
        contactoViewHolder.btnLike1.setImageResource(contacto.getFoto3());

    }

    // Cantidad de elementos que contiene la lista
    @Override
    public int getItemCount() {
        return contactos.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private ImageView btnLike;
        private TextView tvnombreCV;
        private TextView tvTelefonoCV;
        private ImageButton btnLike1;


        public ContactoViewHolder(View itemView) {
            super(itemView);
            imgFoto         = (ImageView) itemView.findViewById(R.id.imgFotoCv);
            btnLike         = (ImageView) itemView.findViewById(R.id.btnLike);
            tvnombreCV      = (TextView) itemView.findViewById(R.id.tvNombreCv);
            tvTelefonoCV    = (TextView) itemView.findViewById(R.id.tvTelefonoCv);
            btnLike1        = (ImageButton) itemView.findViewById(R.id.btnLike1);

        }
    }
}
