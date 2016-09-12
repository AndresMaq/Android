package com.andres.myapplication;

import android.annotation.TargetApi;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

public class MainActivity extends AppCompatActivity {

    TextInputEditText etNombre, etTelefono, etEmail, etDescripcion;
    Button btnSiguiente;
    DatePicker dpFecha;
    protected void onActivityResult(int requestCode, int resultCode, Intent data){

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = (TextInputEditText)findViewById(R.id.etNombre);
        etTelefono = (TextInputEditText)findViewById(R.id.etTelefono);
        etEmail = (TextInputEditText)findViewById(R.id.etEmail);
        etDescripcion = (TextInputEditText)findViewById(R.id.etDescripcion);
        btnSiguiente = (Button)findViewById(R.id.btnSiguiente);

        dpFecha = (DatePicker)findViewById(R.id.dpFecha);


        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {

                Integer year = dpFecha.getYear();
                Integer month = dpFecha.getMonth();
                Integer day = dpFecha.getDayOfMonth();
                StringBuilder sb =new StringBuilder();
                sb.append(year.toString()).append("-").append(month.toString()).append("-").append(day.toString());
                String str = sb.toString();


                Snackbar.make(v, str, Snackbar.LENGTH_LONG).show();
                if (etNombre.getText().toString().equals("") ||
                        etTelefono.getText().toString().equals("") ||
                        etEmail.getText().toString().equals("") ||
                        etDescripcion.getText().toString().equals("")){
                    Snackbar.make(v, getResources().getString(R.string.mensaje), Snackbar.LENGTH_LONG).show();

                } else{
                    Intent intent = new Intent(MainActivity.this, ConfirmarDatos.class);
                    intent.putExtra(getResources().getString(R.string.cnombre), etNombre.getText().toString());
                    intent.putExtra(getResources().getString(R.string.ctelefono), etTelefono.getText().toString());
                    intent.putExtra(getResources().getString(R.string.cemail), etEmail.getText().toString());
                    intent.putExtra(getResources().getString(R.string.cdescripcion), etDescripcion.getText().toString());
                    intent.putExtra(getResources().getString(R.string.cfecha), str);
                    startActivity(intent);
                   // finish();
                }
            }
        });

    }
}
