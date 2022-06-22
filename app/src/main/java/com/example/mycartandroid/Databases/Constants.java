package com.example.mycartandroid.Databases;

public class Constants {

    //Nome BD
    public static final String DB_NAME = "MY_CART_ANDROID";

    //Versao BD
    public static final int DB_VERSION = 1;

    //Tabela BD
    public static final String TABLE_NAME = "LISTA_COMPRA";

    //Colunas tabela
    public static final String C_ID_LISTA = "ID_LISTA";
    public static final String C_NOME_LISTA = "NOME_LISTA";
    public static final String C_ID_AGRUP = "ID_AGRUP";
    public static final String C_ID_ITEM = "ID_ITEM";
    public static final String C_NOME_ITEM = "NOME_ITEM";
    public static final String C_QTD_ITEM = "QTD_ITEM";
    public static final String C_VLR_ITEM = "VLR_ITEM";
    public static final String C_CHECK_ITEM = "CHECK_ITEM";
    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ("
            + C_ID_LISTA + " INSERT PRIMARY KEY AUTOINCREMENT,"
            + C_NOME_LISTA + " TEXT,"
            + C_ID_AGRUP + " TEXT,"
            + C_ID_ITEM + " TEXT,"
            + C_NOME_ITEM + " TEXT,"
            + C_QTD_ITEM + " TEXT,"
            + C_VLR_ITEM + " TEXT,"
            + C_CHECK_ITEM + " TEXT"
            + ");";

}
