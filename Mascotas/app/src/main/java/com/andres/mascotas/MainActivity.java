package com.andres.mascotas;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;
    private MascotaAdaptador adaptador;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar)findViewById(R.id.miActionBar);
        //ImageView imgStar = (ImageView)findViewById(R.id.imgStar);

        setSupportActionBar(miActionBar);
        agregarFAB();

        rvMascotas = (RecyclerView)findViewById(R.id.rvMascotas);


        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();


    }

    public void favoritas(View v){
        Intent intent = new Intent(this, MascotasFavoritas.class);
        startActivity(intent);
    }

    private void inicializarAdaptador(){
        adaptador = new MascotaAdaptador(mascotas, this);
        rvMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.gato,"Churro", "5"));
        mascotas.add(new Mascota(R.drawable.perro,"Glumar", "2"));
        mascotas.add(new Mascota(R.drawable.guacamaya,"Colors", "8"));
        mascotas.add(new Mascota(R.drawable.pug,"Trompo","7"));
        mascotas.add(new Mascota(R.drawable.hamster,"Pinkys","7"));
    }

    public void agregarFAB(){
        FloatingActionButton miFAB = (FloatingActionButton) findViewById(R.id.fab);
        miFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                //Toast.makeText(getBaseContext(), getResources().getString(R.string.mensaje), Toast.LENGTH_SHORT);
                Snackbar.make(v, getResources().getString(R.string.mensaje), Snackbar.LENGTH_LONG)
                        .setAction(getResources().getString(R.string.texto_accion), new View.OnClickListener(){
                            @Override
                            public void onClick(View v){
                                Log.i("SNACKBAR", "Click en Snackbar");
                            }
                        })
                        .setActionTextColor(getResources().getColor(R.color.colorPrimary))
                        .show();
            }
        });
    }
}
