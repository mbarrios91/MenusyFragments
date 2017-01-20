package com.mbarrios.petagram;

import com.mbarrios.petagram.Adapter.MascotaAdaptador;
import com.mbarrios.petagram.Adapter.MascotaFavoritaAdaptador;
import com.mbarrios.petagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by mbarrios on 20/1/2017.
 */

public interface IRecyclerViewFavoritasView {

    public void generarLinaerLayoutVertical();

    public MascotaFavoritaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV(MascotaFavoritaAdaptador adaptador);
}
