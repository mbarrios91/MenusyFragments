package com.mbarrios.petagram.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mbarrios.petagram.Adapter.MascotaAdaptador;
import com.mbarrios.petagram.R;
import com.mbarrios.petagram.pojo.Mascota;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MascotasFragment extends Fragment {
    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    public MascotaAdaptador adaptador;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_mascotas, container, false);

        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();


        return v;
    }

    public void inicializarAdaptador(){
        adaptador = new MascotaAdaptador(mascotas, getActivity());
        listaMascotas.setAdapter(adaptador);
    }


    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Bruce", R.drawable.imguno, 0));
        mascotas.add(new Mascota("Dash", R.drawable.imgdos, 0));
        mascotas.add(new Mascota("Bella", R.drawable.imgtres, 0));
        mascotas.add(new Mascota("Bob", R.drawable.imgcuatro, 0));
        mascotas.add(new Mascota("Koke", R.drawable.mascotaseis, 0));
        mascotas.add(new Mascota("Drake", R.drawable.imgseis, 0));
        mascotas.add(new Mascota("Buffy", R.drawable.imgsiete, 0));
        mascotas.add(new Mascota("Nieve", R.drawable.imgocho, 0));

    }

}
