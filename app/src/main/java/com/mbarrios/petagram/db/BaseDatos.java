package com.mbarrios.petagram.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.mbarrios.petagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by mbarrios on 18/1/2017.
 */

public class BaseDatos extends SQLiteOpenHelper {
    private Context context;
    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String queryCrearTablaMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_PETS + "("+
                ConstantesBaseDatos.TABLE_PETS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_PETS_NOMBRE + " TEXT, " +
                ConstantesBaseDatos.TABLE_PETS_FOTO + " INTEGER" +
                ")";

        String queryCrearTablaLikesMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_LIKES_PET + "(" +
                ConstantesBaseDatos.TABLE_LIKES_PET_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_LIKES_PET_ID_CONTACTO + " INTEGER, " +
                ConstantesBaseDatos.TABLE_LIKES_PET_NUMERO_LIKES + " INTEGER, " +
                "FOREIGN KEY (" + ConstantesBaseDatos.TABLE_LIKES_PET_ID_CONTACTO + ") " +
                "REFERENCES " + ConstantesBaseDatos.TABLE_PETS + " (" + ConstantesBaseDatos.TABLE_PETS_ID + ")" +
                ")";

        String queryCrearTablaMascotaFavoritas = "CREATE TABLE " + ConstantesBaseDatos.TABLE_PETS_FAVORITES + "(" +
                ConstantesBaseDatos.TABLE_PETS_FAVORITES_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_PETS_FAVORITES_ID_CONTACTO + " INTEGER, " +
                ConstantesBaseDatos.TABLE_PETS_NOMBRE + " TEXT, " +
                ConstantesBaseDatos.TABLE_PETS_FOTO + " INTEGER, " +
                "FOREIGN KEY (" + ConstantesBaseDatos.TABLE_PETS_FAVORITES_ID_CONTACTO + ") " +
                "REFERENCES " + ConstantesBaseDatos.TABLE_PETS + " (" + ConstantesBaseDatos.TABLE_PETS_ID + ")" +
                ")";

        db.execSQL(queryCrearTablaMascota);
        db.execSQL(queryCrearTablaLikesMascota);
        db.execSQL(queryCrearTablaMascotaFavoritas);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_PETS);
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_LIKES_PET);
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_PETS_FAVORITES);
        onCreate(db);
    }

    public ArrayList<Mascota> obtenerTodasLasMascotas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_PETS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while(registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));

            String queryLikes = "SELECT COUNT(" + ConstantesBaseDatos.TABLE_LIKES_PET_NUMERO_LIKES + ") as likes " +
                    " FROM " + ConstantesBaseDatos.TABLE_LIKES_PET +
                    " WHERE " + ConstantesBaseDatos.TABLE_LIKES_PET_ID_CONTACTO + "=" + registros.getInt(0);

            Cursor registrosLikes = db.rawQuery(queryLikes, null);
            if(registrosLikes.moveToNext()){
                mascotaActual.setRanking(registrosLikes.getInt(0));
            }else{
                mascotaActual.setRanking(0);
            }

            mascotas.add(mascotaActual);
        }

        db.close();

        return mascotas;
    }


    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_PETS, null, contentValues);
        db.close();
    }

    public void insertarLikeMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_LIKES_PET, null, contentValues);
        db.close();
    }

    public void insertarMascotaFavorita(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_PETS_FAVORITES, null, contentValues);
        db.close();
    }

    public int obtenerLikesMascota(Mascota mascota){
        int likes = 0;
        String query = "SELECT COUNT(" + ConstantesBaseDatos.TABLE_LIKES_PET_NUMERO_LIKES + ")" +
                " FROM " + ConstantesBaseDatos.TABLE_LIKES_PET +
                " WHERE " + ConstantesBaseDatos.TABLE_LIKES_PET_ID_CONTACTO + "=" + mascota.getId();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        if(registros.moveToNext()){
            likes = registros.getInt(0);
        }

        db.close();
        return likes;
    }

    public ArrayList<Mascota> obtenerMascotasFavoritas() {
        ArrayList<Mascota> mascotas = new ArrayList<>();

            String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_PETS_FAVORITES + " ORDER BY " + ConstantesBaseDatos.TABLE_PETS_FAVORITES_ID + " DESC LIMIT 5 ";
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor registros = db.rawQuery(query, null);

            while (registros.moveToNext()) {
                Mascota mascotaActual = new Mascota();
                mascotaActual.setId(registros.getInt(0));
                mascotaActual.setNombre(registros.getString(2));
                mascotaActual.setFoto(registros.getInt(3));

                mascotas.add(mascotaActual);
            }

            db.close();

        return mascotas;
    }

}
