package com.mbarrios.petagram.db;

import android.content.Context;

/**
 * Created by mbarrios on 18/1/2017.
 */

public final class ConstantesBaseDatos {

    public static final String DATABASE_NAME = "mascotas";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_PETS  = "mascota";
    public static final String TABLE_PETS_ID = "id";
    public static final String TABLE_PETS_NOMBRE = "nombre";
    public static final String TABLE_PETS_FOTO = "foto";

    public static String TABLE_LIKES_PET = "mascota_likes";
    public static final String TABLE_LIKES_PET_ID = "id";
    public static final String TABLE_LIKES_PET_ID_CONTACTO = "id_mascota";
    public static final String TABLE_LIKES_PET_NUMERO_LIKES = "numero_likes";

    public static final String TABLE_PETS_FAVORITES  = "mascotas_favoritas";
    public static final String TABLE_PETS_FAVORITES_ID = "id";
    public static final String TABLE_PETS_FAVORITES_ID_CONTACTO = "id_mascota";
    public static final String TABLE_PETS_FAVORITES_NOMBRE = "nombre";
    public static final String TABLE_PETS_FAVORITES_FOTO = "foto";

}
