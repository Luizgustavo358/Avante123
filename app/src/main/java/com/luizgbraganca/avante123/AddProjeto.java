package com.luizgbraganca.avante123;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.luizgbraganca.avante123.database.models.User;

public class AddProjeto extends AppCompatActivity
{
    // definir dados
    private String filho;
    private Button adicionar;
    private DatabaseReference mDatabase;
    private EditText nomeProjeto;
    private EditText descricaoProjeto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_projeto);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        adicionar = (Button) findViewById(R.id.addProj);
        nomeProjeto = (EditText) findViewById(R.id.nomeProjeto);
        descricaoProjeto = (EditText) findViewById(R.id.descricaoProjeto);

        adicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                filho = nomeProjeto.getText().toString();
                adicionaProjeto();
                Toast.makeText(AddProjeto.this, "Projeto adicionado com sucesso!", Toast.LENGTH_SHORT).show();

                voltaParaTelaPrincipal( );
            }
        });
    }

    public void voltaParaTelaPrincipal( )
    {
        Intent intent = new Intent(AddProjeto.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void adicionaProjeto()
    {
        writeProjeto(nomeProjeto.toString(), descricaoProjeto.toString());
    }

    private void writeProjeto(String projeto, String descricao)
    {
        User user = new User(projeto, descricao, true);

        mDatabase.child("projetos").child(filho).setValue(user);
    }
}