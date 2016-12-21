package com.mbarrios.petagram.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mbarrios.petagram.Adapter.PerfilAdaptador;
import com.mbarrios.petagram.R;
import com.mbarrios.petagram.pojo.Mascota;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {
    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    public PerfilAdaptador adaptador;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        listaMascotas = (RecyclerView) v.findViewById(R.id.rvPerfil);
        GridLayoutManager llm = new GridLayoutManager(getContext(), 3);
        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();

        return v;
    }

    public void inicializarAdaptador(){
        adaptador = new PerfilAdaptador(mascotas, getActivity());
        listaMascotas.setAdapter(adaptador);
    }


    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.pet_2, 3));
        mascotas.add(new Mascota(R.drawable.pet_3, 5));
        mascotas.add(new Mascota(R.drawable.pet_4, 4));
        mascotas.add(new Mascota(R.drawable.pet_5, 3));
        mascotas.add(new Mascota(R.drawable.pet_6, 7));
        mascotas.add(new Mascota(R.drawable.pet_7, 4));

    }

}
