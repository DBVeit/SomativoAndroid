package com.example.mycartandroid.Models;

public class Model {
    private int idLista;
    private String nomeLista;
    /*private int idAgrup;
    private int idItem;
    private String nomeItem;
    private int qtdItem;
    private float valorItem;
    private int checkItem;*/

    //Construtor
    public Model(int idLista, String nomeLista /*, int idAgrup, int idItem, String nomeItem, int qtdItem, float valorItem, int checkItem*/) {
        this.idLista = idLista;
        this.nomeLista = nomeLista;
        /*this.idAgrup = idAgrup;
        this.idItem = idItem;
        this.nomeItem = nomeItem;
        this.qtdItem = qtdItem;
        this.valorItem = valorItem;
        this.checkItem = checkItem;*/
    }

    //Getters e setters

    public int getIdLista() {
        return idLista;
    }

    public void setIdLista(int idLista) {
        this.idLista = idLista;
    }

    public String getNomeLista() {
        return nomeLista;
    }

    public void setNomeLista(String nomeLista) {
        this.nomeLista = nomeLista;
    }

    /*public int getIdAgrup() {
        return idAgrup;
    }

    public void setIdAgrup(int idAgrup) {
        this.idAgrup = idAgrup;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public String getNomeItem() {
        return nomeItem;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
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

    public int getCheckItem() {
        return checkItem;
    }

    public void setCheckItem(int checkItem) {
        this.checkItem = checkItem;
    }*/
}
