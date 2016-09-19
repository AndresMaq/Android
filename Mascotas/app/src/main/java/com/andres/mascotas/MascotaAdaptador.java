package com.andres.mascotas;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Samsung1 on 18/09/2016.
 */
public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MascotaViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);
        holder.imgFoto.setImageResource(mascota.getFoto());
        holder.tvNombeCV.setText(mascota.getNombre());
        holder.tvRaitingCV.setText(mascota.getRaiting());

        /*holder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, MascotasFavoritas.class);
                intent.putExtra("nombre", mascota.getNombre());
                intent.putExtra("raiting",mascota.getRaiting());
                activity.startActivity(intent);
                //activity.finish();
            }
        });*/

        holder.btnHueso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Nuevo raiting para:"+mascota.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto, imgHuesoAmarillo;
        private TextView tvNombeCV, tvRaitingCV;
        private ImageButton btnHueso;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            imgHuesoAmarillo = (ImageView) itemView.findViewById(R.id.imgHuesoAmarillo);
            tvNombeCV = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvRaitingCV = (TextView) itemView.findViewById(R.id.tvRaitingCV);
            btnHueso = (ImageButton) itemView.findViewById(R.id.btnHueso);

        }
    }

}


