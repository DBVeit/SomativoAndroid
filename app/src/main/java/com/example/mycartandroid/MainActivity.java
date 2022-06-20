package com.example.mycartandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mycartandroid.Databases.DBMain;

public class MainActivity extends AppCompatActivity {
EditText nomeLista;
Button criarLista, listasCriadas, editarLista;
TextView txtCriarLista, txtEditarLista;
DBMain dbMain;
SQLiteDatabase sqLiteDatabase;
int idLista = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbMain = new DBMain(this);

        //Metodos
        findid();
        inserirLista();
        limparDados();
        editarDados();
    }

    private void editarDados(){
        if(getIntent().getBundleExtra("listaDados")!=null){
            Bundle bundle = getIntent().getBundleExtra("listaDados");
            idLista=bundle.getInt("idLista");
            nomeLista.setText(bundle.getString("nomeLista"));

            editarLista.setVisibility(View.VISIBLE);
            txtEditarLista.setVisibility(View.VISIBLE);
            criarLista.setVisibility(View.GONE);
            txtCriarLista.setVisibility(View.GONE);

        }
    }

    private void limparDados() {
        nomeLista.setText("");
    }

    private void inserirLista(){
        //Criar lista
        criarLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues cv = new ContentValues();
                cv.put("nomeLista",nomeLista.getText().toString());
                sqLiteDatabase=dbMain.getReadableDatabase();

                Long recinsert=sqLiteDatabase.insert("listaCompra", null, cv);
                if(recinsert!=null){
                    Toast.makeText(MainActivity.this, "Nova lista de compras criada!", Toast.LENGTH_SHORT).show();
                    limparDados();
                }else{
                    Toast.makeText(MainActivity.this, "Erro ao criar lista!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Ir para listas criadas
        listasCriadas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ListasCriadas.class));
            }
        });

        //Confirmar edicao de lista
        editarLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues cv = new ContentValues();
                cv.put("nomeLista",nomeLista.getText().toString());
                sqLiteDatabase=dbMain.getReadableDatabase();

                long recupdate=sqLiteDatabase.update("listaCompra",cv,"idLista"+idLista,null);
                if (recupdate!=-1){
                    Toast.makeText(MainActivity.this, "Lista alterada!", Toast.LENGTH_SHORT).show();
                    criarLista.setVisibility(View.VISIBLE);
                    editarLista.setVisibility(View.GONE);
                    limparDados();
                }else{
                    Toast.makeText(MainActivity.this, "Erro ao alterar lista!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void findid(){
        nomeLista = (EditText)findViewById(R.id.edTxt_nomeLista);
        criarLista = (Button)findViewById(R.id.btn_criarLista);
        editarLista = (Button)findViewById(R.id.btn_editarLista);
        listasCriadas = (Button)findViewById(R.id.btn_listasCriadas);
        txtCriarLista = (TextView)findViewById(R.id.txtV_criarNovaLista);
        txtEditarLista = (TextView)findViewById(R.id.txtV_editarLista);
    }
}