package com.mbarrios.petagram.Adapter;

import android.app.Activity;
import android.content.Context;
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

/**
 * Created by mbarrios on 20/1/2017.
 */

public class MascotaFavoritaAdaptador extends RecyclerView.Adapter<MascotaFavoritaAdaptador.MascotaFavoritaViewHolder> {
    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaFavoritaAdaptador (ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;;
    }

    @Override
    public MascotaFavoritaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_mascotas, parent, false);
        return new MascotaFavoritaAdaptador.MascotaFavoritaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaFavoritaViewHolder mascotaViewHolder, final int position) {
        final Mascota mascota = mascotas.get(position);

        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombre.setText(mascota.getNombre());
        mascotaViewHolder.tvRanking.setText(String.valueOf(""));
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }


    public static class MascotaFavoritaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView tvNombre;
        private TextView tvRanking;
        private ImageView imgHueso;
        private ImageView imgHuesoDos;

        public MascotaFavoritaViewHolder(View itemView) {
            super(itemView);
            imgFoto         =   (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombre        =   (TextView)  itemView.findViewById(R.id.tvNombre);
            tvRanking       =   (TextView)  itemView.findViewById(R.id.tvRanking);
            imgHueso        =   (ImageView) itemView.findViewById(R.id.imgHueso);
            imgHuesoDos     =   (ImageView) itemView.findViewById(R.id.imgHuesoDos);
        }
    }

}
