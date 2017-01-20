package com.mbarrios.petagram;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.mbarrios.petagram.Adapter.MascotaFavoritaAdaptador;
import com.mbarrios.petagram.pojo.Mascota;
import com.mbarrios.petagram.presentador.RecyclerViewPetsFavoritesPresenter;

import java.util.ArrayList;

public class MascotasFavoritas extends AppCompatActivity implements IRecyclerViewFavoritasView {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    public MascotaFavoritaAdaptador adaptador;
    private RecyclerViewPetsFavoritesPresenter presenter;



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
        presenter = new RecyclerViewPetsFavoritesPresenter(this, this);

    }



   /* public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Bruce", R.drawable.imguno, 5));
        mascotas.add(new Mascota("Dash", R.drawable.imgdos, 7));
        mascotas.add(new Mascota("Bella", R.drawable.imgtres, 5));
        mascotas.add(new Mascota("Bob", R.drawable.imgcuatro, 8));
        mascotas.add(new Mascota("Koke", R.drawable.mascotaseis, 6));

    }*/

    @Override
    public void generarLinaerLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaFavoritaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaFavoritaAdaptador adaptador = new MascotaFavoritaAdaptador(mascotas, this);
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaFavoritaAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);
    }

}
