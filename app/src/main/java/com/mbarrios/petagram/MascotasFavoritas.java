package com.mbarrios.petagram;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.mbarrios.petagram.Adapter.MascotaAdaptador;
import com.mbarrios.petagram.pojo.Mascota;

import java.util.ArrayList;

public class MascotasFavoritas extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    public MascotaAdaptador adaptador;



    @Override
    public View findViewById(@IdRes int id) {
        return super.findViewById(id);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);

    //    getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        listaMascotas = (RecyclerView) findViewById (R.id.rvMascotasFavoritas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();
    }

    public void inicializarAdaptador(){
        adaptador = new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }


    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Bruce", R.drawable.imguno, 5));
        mascotas.add(new Mascota("Dash", R.drawable.imgdos, 7));
        mascotas.add(new Mascota("Bella", R.drawable.imgtres, 5));
        mascotas.add(new Mascota("Bob", R.drawable.imgcuatro, 8));
        mascotas.add(new Mascota("Koke", R.drawable.mascotaseis, 6));

    }
}
