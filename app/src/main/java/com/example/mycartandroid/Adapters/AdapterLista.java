package com.example.mycartandroid.Adapters;

import android.content.Context;
import android.content.Intent;
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
    private ArrayList<Model> modelArrayList;
    private Context context;
    private OnItemClickListener cvListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
        void onDeleteClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        cvListener = listener;
    }

    public AdapterLista(ArrayList<Model> modelArrayList, Context context) {
        this.modelArrayList = modelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterLista.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_lista,parent,false);
        return new ViewHolder(view, cvListener);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterLista.ViewHolder holder, int position) {
        Model model = modelArrayList.get(position);
        holder.txt_nomeLista.setText(model.getLnome());
    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView txt_nomeLista;
        public ImageButton txt_addToList;
        public ImageButton txt_editList;
        public ImageButton txt_deleteList;
        public CardView cardView_lista;
        public Context context;

        public ViewHolder(View itemView, OnItemClickListener listener) {
            super(itemView);
            txt_nomeLista = (TextView)itemView.findViewById(R.id.txt_nomeLista);
            //txt_addToList = (ImageButton)itemView.findViewById(R.id.txt_addToList);
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

            cardView_lista.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);

                            //txt_nomeLista.setVisibility(View.GONE);
                            //txt_addToList.setVisibility(View.VISIBLE);
                            //txt_editList.setVisibility(View.VISIBLE);
                            //txt_deleteList.setVisibility(View.VISIBLE);

                            Intent intent = new Intent(view.getContext(), ItensLista.class);
                            view.getContext().startActivity(intent);
                        }
                    }
                }

            });

            txt_editList.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                            Intent intent = new Intent(view.getContext(), MainActivity.class);
                            view.getContext().startActivity(intent);
                        }
                    }
                }
            });


        }
    }
}
