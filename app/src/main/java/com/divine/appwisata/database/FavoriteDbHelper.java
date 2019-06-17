package com.divine.appwisata.database;
/**
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.divine.appwisata.response.WisataItem;

import java.util.ArrayList;
import java.util.List;

public class FavoriteDbHelper {
    private static final String DATABASE_NAME = "favorite_db";
    private static final int DATABASE_VERSION = 1;
    private static final String LOGTAG = "FAVORITE";

    SQLiteOpenHelper dbHandler;
    SQLiteDatabase db;

    public FavoriteDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void open(){
        Log.i(LOGTAG, "Database dibuka");
        db = dbHandler.getWritableDatabase();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        final String SQL_CREATE_TABLE = "CREATE TABLE " + FavoriteData.FavoriteInput.TB_NAMA + " ( " +
                FavoriteData.FavoriteInput.COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                FavoriteData.FavoriteInput.COL_NAMA + " TEXT NOT NULL, " +
                FavoriteData.FavoriteInput.COL_SUB + " TEXT NOT NULL, " +
                FavoriteData.FavoriteInput.COL_FOTO + " TEXT NOT NULL, " +
                FavoriteData.FavoriteInput.COL_KONTEN + " TEXT NOT NULL, " +
                " ); ";
        db.execSQL(SQL_CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + FavoriteData.FavoriteInput.TB_NAMA);
        onCreate(db);
    }

    public void tambahFavorite(WisataItem dataWisata){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(FavoriteData.FavoriteInput.COL_ID, dataWisata.getId());
        values.put(FavoriteData.FavoriteInput.COL_NAMA, dataWisata.getNamaTempat());
        values.put(FavoriteData.FavoriteInput.COL_SUB, dataWisata.getSubNama());
        values.put(FavoriteData.FavoriteInput.COL_FOTO, dataWisata.getFoto());
        values.put(FavoriteData.FavoriteInput.COL_KONTEN, dataWisata.getIsiKeterangan());


        db.insert(FavoriteData.FavoriteInput.TB_NAMA, null, values);
        db.close();
    }


    public void deleteFavorite(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(FavoriteData.FavoriteInput.TB_NAMA, FavoriteData.FavoriteInput.COL_ID+ "=" +id, null);
    }

    public boolean isFavorites(int id){
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT "+ FavoriteData.FavoriteInput.COL_ID + " FROM " + FavoriteData.FavoriteInput.TB_NAMA +
                " WHERE "+ FavoriteData.FavoriteInput.COL_ID + " = "+ id;
        Cursor cursor = db.rawQuery(query, null);
        if(cursor.getCount() <=0){
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }


    public List<WisataItem> getAllFavorite(){
        String[]kolom = {
                FavoriteData.FavoriteInput.COL_ID,
                FavoriteData.FavoriteInput.COL_NAMA,
                FavoriteData.FavoriteInput.COL_SUB,
                FavoriteData.FavoriteInput.COL_FOTO,
                FavoriteData.FavoriteInput.COL_KONTEN,

        };
        String order = FavoriteData.FavoriteInput.COL_NAMA+ " DESC";
        List<WisataItem> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(FavoriteData.FavoriteInput.TB_NAMA, kolom,
                null,null,null,null, order);

        if (cursor.moveToFirst()){
            do{
                WisataItem dataWisata = new WisataItem();
                dataWisata.setId(cursor.getInt(cursor.getColumnIndex(FavoriteData.FavoriteInput.COL_ID)));
                dataWisata.setFoto(cursor.getString(cursor.getColumnIndex(FavoriteData.FavoriteInput.COL_FOTO)));
                dataWisata.setNamaTempat(cursor.getString(cursor.getColumnIndex(FavoriteData.FavoriteInput.COL_NAMA)));
                dataWisata.setSubNama(cursor.getString(cursor.getColumnIndex(FavoriteData.FavoriteInput.COL_SUB)));
                dataWisata.setIsiKeterangan(cursor.getString(cursor.getColumnIndex(FavoriteData.FavoriteInput.COL_KONTEN)));
                list.add(dataWisata);
            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return list;
    }
    public int getNotesCount() {
        String countQuery = "SELECT  * FROM " + FavoriteData.FavoriteInput.TB_NAMA;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();

        return count;
    }
}
*/
