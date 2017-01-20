package com.mbarrios.petagram.presentador;

import android.content.Context;
import com.mbarrios.petagram.IRecyclerViewFavoritasView;
import com.mbarrios.petagram.db.ConstructorMascotas;
import com.mbarrios.petagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by mbarrios on 19/1/2017.
 */

public class RecyclerViewPetsFavoritesPresenter implements IRecyclerViewPetsFavoritesPresenter{
    private IRecyclerViewFavoritasView iRecyclerViewFavoritasView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public  RecyclerViewPetsFavoritesPresenter(IRecyclerViewFavoritasView iRecyclerViewFavoritasView, Context context){
        this.iRecyclerViewFavoritasView = iRecyclerViewFavoritasView;
        this.context = context;
        obtenerMascotasFavoritasBaseDatos();
    }

    @Override
    public void obtenerMascotasFavoritasBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatosFavoritas();
        mostrarMascotasFavoritasRV();

    }

    @Override
    public void mostrarMascotasFavoritasRV() {
        iRecyclerViewFavoritasView.inicializarAdaptadorRV(iRecyclerViewFavoritasView.crearAdaptador(mascotas));
        iRecyclerViewFavoritasView.generarLinaerLayoutVertical();
    }
}
