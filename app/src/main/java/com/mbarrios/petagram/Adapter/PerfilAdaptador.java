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
import java.util.List;

/**
 * Created by mbarrios on 21/12/2016.
 */

public class PerfilAdaptador extends RecyclerView.Adapter<PerfilAdaptador.PerfilViewHolder>  {

    ArrayList<Mascota> mascotas;
    Activity activity;

    public PerfilAdaptador(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;;
    }

    @Override
    public PerfilViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_perfil_mascota, parent, false);

        return new PerfilViewHolder(v);
    }


    @Override
    public void onBindViewHolder(PerfilViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);

        PerfilViewHolder.imgFoto.setImageResource(mascota.getFoto());
        PerfilViewHolder.tvRanking.setText(String.valueOf(mascota.getRanking()));
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class PerfilViewHolder extends RecyclerView.ViewHolder{

        private static ImageView imgFoto;
        private static TextView tvRanking;
        private ImageView imgHuesoDos;

        public PerfilViewHolder(View itemView) {
            super(itemView);
            imgFoto         =   (ImageView) itemView.findViewById(R.id.imgFoto);
            tvRanking       =   (TextView)  itemView.findViewById(R.id.tvRanking);
            imgHuesoDos     =   (ImageView) itemView.findViewById(R.id.imgHuesoDos);
        }
    }
}
