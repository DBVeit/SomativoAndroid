package com.example.mycartandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.mycartandroid.Adapters.AdapterItens;
import com.example.mycartandroid.Adapters.AdapterLista;
import com.example.mycartandroid.Databases.DBItens;
import com.example.mycartandroid.Databases.DBMain;
import com.example.mycartandroid.Models.ModelItens;

import java.util.ArrayList;

public class ItensLista extends AppCompatActivity {
DBMain dbMain;
SQLiteDatabase sqLiteDatabase;
ArrayList<ModelItens>modelItensArrayList;
AdapterItens adapterItens;
AdapterLista adapterLista;
RecyclerView recyclerView;
TextView nomeLista, adicionarItem;
int idLista = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itens_lista);
        dbMain = new DBMain(this);
        modelItensArrayList = new ArrayList<>();


        //Métodos
        findid();
        dadosItensLista();
    }

    private void dadosItensLista() {
        if(getIntent().getBundleExtra("dadosItensLista")!=null){
            Bundle bundle = getIntent().getBundleExtra("dadosItensLista");
            idLista=bundle.getInt("idLista");
            nomeLista.setText(bundle.getString("nomeLista"));

        }
    }

    private void findid() {
        recyclerView = findViewById(R.id.rv_itensLista);
        nomeLista = findViewById(R.id.txt_nomeListaItens);
        adicionarItem = findViewById(R.id.txtV_adicionarItem);
    }
}