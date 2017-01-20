package com.mbarrios.petagram.db;

import android.content.ContentValues;
import android.content.Context;

import com.mbarrios.petagram.R;
import com.mbarrios.petagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by mbarrios on 18/1/2017.
 */

public class ConstructorMascotas {

    private  static final int LIKE = 1;
    private Context context;

    public ConstructorMascotas(Context context) {
        this.context = context;
    }


    public ArrayList<Mascota> obtenerDatos(){
        BaseDatos bd = new BaseDatos(context);
        insertarMascotas(bd);
        return bd.obtenerTodasLasMascotas();
    }

    public ArrayList<Mascota> obtenerDatosFavoritas(){
        BaseDatos bd = new BaseDatos(context);

        return bd.obtenerMascotasFavoritas();
    }

    public void insertarMascotas(BaseDatos bd){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "Bruce");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO, R.drawable.imguno);
        bd.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "Dash");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO, R.drawable.imgdos);
        bd.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "Bella");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO, R.drawable.imgtres);
        bd.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "Bob");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO, R.drawable.imgcuatro);
        bd.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "Koke");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO, R.drawable.mascotaseis);
        bd.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "Drake");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO, R.drawable.imgseis);
        bd.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "Buffy");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO, R.drawable.imgsiete);
        bd.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "Nieve");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO, R.drawable.imgocho);
        bd.insertarMascota(contentValues);

    }

    public void darLikeMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();

        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_PET_ID_CONTACTO, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_PET_NUMERO_LIKES, LIKE);
        db.insertarLikeMascota(contentValues);
    }

    public int obtenerLikesMascota(Mascota mascota){
        BaseDatos bd = new BaseDatos(context);
        return  bd.obtenerLikesMascota(mascota);
    }

    public void insertmascotafavorita(Mascota mascota){
        BaseDatos bd = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();

        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FAVORITES_ID_CONTACTO, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, mascota.getNombre());
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO, mascota.getFoto());
        bd.insertarMascotaFavorita(contentValues);
    }

}
