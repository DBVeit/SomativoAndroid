package com.example.mycartandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.mycartandroid.Databases.DBItens;
import com.example.mycartandroid.Databases.DBMain;

public class MainActivity2 extends AppCompatActivity {
DBMain dbMain;
SQLiteDatabase sqLiteDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
}