package com.example.mycartandroid.Databases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBItens extends SQLiteOpenHelper {

    public static final String DBNAME = "myCartShop";
    public static final String TABLENAME = "itensLista";
    public static final int VER = 1;

    public DBItens(@Nullable Context context) {
        super(context, DBNAME, null, VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE "+TABLENAME+"(idItem INTEGER PRIMARY KEY AUTOINCREMENT, idLista INTEGER, nomeItem TEXT, qtd INTEGER, valorItem REAL)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String query="DROP TABLE IF EXISTS "+TABLENAME+"";
        db.execSQL(query);
    }
}
