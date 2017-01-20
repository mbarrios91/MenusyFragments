package com.mbarrios.petagram.presentador;

import android.content.Context;

import com.mbarrios.petagram.Fragment.IRecyclerViewFragmentView;
import com.mbarrios.petagram.db.ConstantesBaseDatos;
import com.mbarrios.petagram.db.ConstructorMascotas;
import com.mbarrios.petagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by mbarrios on 19/1/2017.
 */

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter{
    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context){
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        obtenerMascotasBaseDatos();
    }

    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();
        mostrarMascotasRV();

    }

    @Override
    public void mostrarMascotasRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(mascotas));
        iRecyclerViewFragmentView.generarLinaerLayoutVertical();
    }
}
