package com.andres.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmarDatos extends AppCompatActivity {

    TextView tvNombre, tvFecha, tvTelefono, tvEmail, tvDescripcion;
    Button btnEditarDatos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);

        Bundle parametros = getIntent().getExtras();
        String nombre = parametros.getString(getResources().getString(R.string.cnombre));
        String fecha = parametros.getString(getResources().getString(R.string.cfecha));
        String telefono = parametros.getString(getResources().getString(R.string.ctelefono));
        String email = parametros.getString(getResources().getString(R.string.cemail));
        String descripcion = parametros.getString(getResources().getString(R.string.cdescripcion));

        tvNombre = (TextView)findViewById(R.id.tvNombre);
        tvFecha = (TextView)findViewById(R.id.tvFecha);
        tvTelefono = (TextView)findViewById(R.id.tvTelefono);
        tvEmail = (TextView)findViewById(R.id.tvEmail);
        tvDescripcion = (TextView)findViewById(R.id.tvDescripcion);
        btnEditarDatos = (Button)findViewById(R.id.btnEditarDatos);

        tvNombre.setText(nombre);
        tvFecha.setText(fecha);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
        tvDescripcion.setText(descripcion);

        btnEditarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConfirmarDatos.this, MainActivity.class);
                intent.putExtra(getResources().getString(R.string.cnombre), tvNombre.getText().toString());
                intent.putExtra(getResources().getString(R.string.ctelefono), tvTelefono.getText().toString());
                intent.putExtra(getResources().getString(R.string.cemail), tvEmail.getText().toString());
                intent.putExtra(getResources().getString(R.string.cdescripcion), tvDescripcion.getText().toString());
                intent.putExtra(getResources().getString(R.string.cfecha), tvFecha.getText().toString());
                startActivityForResult(intent, MI_REQUEST_CODE);
            }
        });
    }
    public final static int MI_REQUEST_CODE = 1;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }
}
