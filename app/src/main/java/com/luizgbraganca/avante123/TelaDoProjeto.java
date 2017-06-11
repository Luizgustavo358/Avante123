package com.luizgbraganca.avante123;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TelaDoProjeto extends AppCompatActivity
{
    // definir dados
    private TextView nomeProjeto, descricaoProjeto;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_do_projeto);

        nomeProjeto = (TextView) findViewById(R.id.nomeProjeto);
        descricaoProjeto = (TextView) findViewById(R.id.descricaoProjeto);

        String projeto = getIntent().getStringExtra("nomeProjeto");
        String descricao = getIntent().getStringExtra("descricao");

        nomeProjeto.setText(projeto);
        descricaoProjeto.setText(descricao);
    }
}
