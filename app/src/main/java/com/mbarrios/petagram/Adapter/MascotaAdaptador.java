package com.mbarrios.petagram.Adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mbarrios.petagram.R;
import com.mbarrios.petagram.pojo.Mascota;

import java.util.ArrayList;

/** Created by mbarrios on 15/11/2016. **/

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{

    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;;
    }


    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_mascotas, parent, false);

            return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);

        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombre.setText(mascota.getNombre());
        mascotaViewHolder.tvRanking.setText(String.valueOf(mascota.getRanking()));

        mascotaViewHolder.imgHuesoDos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, "Acabas de darles raiting a " + " " +mascota.getNombre(), Toast.LENGTH_SHORT).show();
                mascota.setRanking(1);
                mascotaViewHolder.tvRanking.setText(String.valueOf(mascota.getRanking()));
                mascota.mascotasFavoritas(mascota.getNombre(), mascota.getFoto(), mascota.getRanking());
            }
        });

    }


    @Override
    public int getItemCount() { //Cantidad de elementos que contiene mi lista
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView tvNombre;
        private TextView tvRanking;
        private ImageView imgHueso;
        private ImageView imgHuesoDos;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFoto         =   (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombre        =   (TextView)  itemView.findViewById(R.id.tvNombre);
            tvRanking       =   (TextView)  itemView.findViewById(R.id.tvRanking);
            imgHueso        =   (ImageView) itemView.findViewById(R.id.imgHueso);
            imgHuesoDos     =   (ImageView) itemView.findViewById(R.id.imgHuesoDos);
        }
    }
}
