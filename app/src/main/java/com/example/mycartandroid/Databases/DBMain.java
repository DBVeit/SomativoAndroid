package com.example.mycartandroid.Databases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBMain extends SQLiteOpenHelper {

    public static final String DBNAME = "myCartShop";
    public static final String TABLENAME = "listaCompra";
    public static final int VER = 1;

    public DBMain(@Nullable Context context) {
        super(context, DBNAME, null, VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE "+TABLENAME+"(idLista INTEGER PRIMARY KEY AUTOINCREMENT, nomeLista TEXT, dataLista DATE)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String query="DROP TABLE IF EXISTS "+TABLENAME+"";
        db.execSQL(query);
    }
}