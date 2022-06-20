package com.example.mycartandroid.Models;

public class Model {
    private String lnome;
    private int id;

    public Model(String lnome) {
        this.lnome = lnome;
    }

    public String getLnome() {
        return lnome;
    }

    public void setLnome(String lnome) {
        this.lnome = lnome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
