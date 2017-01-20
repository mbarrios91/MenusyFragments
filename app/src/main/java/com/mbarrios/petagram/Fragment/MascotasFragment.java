package com.mbarrios.petagram.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mbarrios.petagram.Adapter.MascotaAdaptador;
import com.mbarrios.petagram.R;
import com.mbarrios.petagram.pojo.Mascota;
import com.mbarrios.petagram.presentador.IRecyclerViewFragmentPresenter;
import com.mbarrios.petagram.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;
import static com.mbarrios.petagram.R.id.rvMascotas;


public class MascotasFragment extends Fragment implements IRecyclerViewFragmentView{
    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private RecyclerViewFragmentPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_mascotas, container, false);

        listaMascotas = (RecyclerView) v.findViewById(rvMascotas);
        presenter = new RecyclerViewFragmentPresenter(this, getContext());

        return v;
    }


    /*public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Bruce", R.drawable.imguno, 0));
        mascotas.add(new Mascota("Dash", R.drawable.imgdos, 0));
        mascotas.add(new Mascota("Bella", R.drawable.imgtres, 0));
        mascotas.add(new Mascota("Bob", R.drawable.imgcuatro, 0));
        mascotas.add(new Mascota("Koke", R.drawable.mascotaseis, 0));
        mascotas.add(new Mascota("Drake", R.drawable.imgseis, 0));
        mascotas.add(new Mascota("Buffy", R.drawable.imgsiete, 0));
        mascotas.add(new Mascota("Nieve", R.drawable.imgocho, 0));

    }*/

    @Override
    public void generarLinaerLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);
    }
}
