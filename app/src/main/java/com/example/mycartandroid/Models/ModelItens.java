package com.example.mycartandroid.Models;

public class ModelItens {
    private String listaNome;
    private String itemNome;
    private int qtdItem;
    private float valorItem;
    private int idItem;

    public ModelItens(String itemNome, int qtdItem, float valorItem) {
        this.itemNome = itemNome;
        this.qtdItem = qtdItem;
        this.valorItem = valorItem;
    }

    public String getItemNome() {
        return itemNome;
    }

    public void setItemNome(String itemNome) {
        this.itemNome = itemNome;
    }

    public int getQtdItem() {
        return qtdItem;
    }

    public void setQtdItem(int qtdItem) {
        this.qtdItem = qtdItem;
    }

    public float getValorItem() {
        return valorItem;
    }

    public void setValorItem(float valorItem) {
        this.valorItem = valorItem;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }
}
