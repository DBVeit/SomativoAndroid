package com.example.mycartandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.mycartandroid.Adapters.AdapterLista;
import com.example.mycartandroid.Databases.DBMain;
import com.example.mycartandroid.Models.Model;

import java.util.ArrayList;

public class ListasCriadas extends AppCompatActivity {
DBMain dbMain;
SQLiteDatabase sqLiteDatabase;
ArrayList<Model>modelArrayList;
AdapterLista adapterLista;
RecyclerView recyclerView;
ImageButton criarNovaLista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas_criadas);

        modelArrayList = new ArrayList<>();
        dbMain = new DBMain(this);

        findid();

        modelArrayList = displayListas();
        adapterLista = new AdapterLista(modelArrayList,ListasCriadas.this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ListasCriadas.this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapterLista);

        //Btn p/ tela de criacao de listas
        criarNovaLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ListasCriadas.this, MainActivity.class));
            }
        });

        adapterLista.setOnItemClickListener(new AdapterLista.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                modelArrayList.get(position);
            }

            @Override
            public void onDeleteClick(int position) {

            }
        });

    }

    private ArrayList<Model> displayListas() {
        sqLiteDatabase = dbMain.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM listaCompra",null);
        ArrayList<Model>modelArrayList = new ArrayList<>();
        if (cursor.moveToFirst()){
            do{
                modelArrayList.add(new Model(cursor.getString(1)));
            }while(cursor.moveToNext());
        }
        cursor.close();
        return modelArrayList;
    }

    private void findid() {
        recyclerView = findViewById(R.id.rv_listas);
        criarNovaLista = (ImageButton) findViewById(R.id.ibtn_criarLista);
    }


}