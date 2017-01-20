package com.mbarrios.petagram.Fragment;

import com.mbarrios.petagram.Adapter.MascotaAdaptador;
import com.mbarrios.petagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by mbarrios on 19/1/2017.
 */

public interface IRecyclerViewFragmentView {

    public void generarLinaerLayoutVertical();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);
}
