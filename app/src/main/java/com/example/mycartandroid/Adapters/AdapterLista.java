package com.example.mycartandroid.Adapters;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mycartandroid.ItensLista;
import com.example.mycartandroid.ListasCriadas;
import com.example.mycartandroid.MainActivity;
import com.example.mycartandroid.MainActivity2;
import com.example.mycartandroid.Models.Model;
import com.example.mycartandroid.R;

import java.util.ArrayList;
import java.util.Random;

public class AdapterLista extends RecyclerView.Adapter<AdapterLista.ViewHolder> {
    Context context;
    ArrayList<Model>modelArrayList=new ArrayList<>();
    SQLiteDatabase sqLiteDatabase;
    OnItemClickListener cvListener;

    public AdapterLista(Context context, int card_view_lista, ArrayList<Model> modelArrayList, SQLiteDatabase sqLiteDatabase) {
        this.modelArrayList = modelArrayList;
        this.context = context;
        this.sqLiteDatabase = sqLiteDatabase;
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
        void onDeleteClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        cvListener = listener;
    }



    @NonNull
    @Override
    public AdapterLista.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.card_view_lista,null);
        //View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_lista,parent,false);
        return new ViewHolder(view, cvListener);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterLista.ViewHolder holder, int position) {
        final Model model = modelArrayList.get(position);
        holder.txt_nomeLista.setText(model.getNomeLista());

        //Ir ao main activity com o id da lista ao clicar em editar
        holder.txt_editList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("idLista", model.getIdLista());
                bundle.putString("nomeLista", model.getNomeLista());
                Intent intent = new Intent(context,MainActivity.class);
                intent.putExtra("dadosLista",bundle);
                context.startActivity(intent);
            }
        });

        //Ir ao itens lista com o id da lista ao clicar no cardview
        holder.cardView_lista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Bundle bundle = new Bundle();
                 bundle.putInt("idLista", model.getIdLista());
                 bundle.putString("nomeLista", model.getNomeLista());
                 Intent intent = new Intent(context,ItensLista.class);
                 intent.putExtra("dadosItensLista",bundle);
                 context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView txt_nomeLista;
        public ImageButton txt_editList;
        public ImageButton txt_deleteList;
        public CardView cardView_lista;
        public Context context;

        public ViewHolder(View itemView, OnItemClickListener listener) {
            super(itemView);
            txt_nomeLista = (TextView)itemView.findViewById(R.id.txt_nomeLista);
            txt_editList = (ImageButton)itemView.findViewById(R.id.txt_editList);
            txt_deleteList = (ImageButton)itemView.findViewById(R.id.txt_editList);
            cardView_lista = (CardView)itemView.findViewById(R.id.cardView_lista);
            //this.context

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
