package com.luizgbraganca.avante123;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Configuracoes extends AppCompatActivity
{
    private ImageView batman, deadpool, homemAranha, homemDeFerro;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracoes);

        batman = (ImageView) findViewById(R.id.batman);
        deadpool = (ImageView) findViewById(R.id.deadpool);
        homemAranha = (ImageView) findViewById(R.id.homemAranha);
        homemDeFerro = (ImageView) findViewById(R.id.homemDeFerro);
    }

    public void batman(View v)
    {
        Toast.makeText(Configuracoes.this, "Batman nanananana :)", Toast.LENGTH_SHORT).show();

        batman.setImageResource(R.drawable.batman2);
    }

    public void deadpool(View view)
    {
        Toast.makeText(Configuracoes.this, "Deadpool", Toast.LENGTH_SHORT).show();
    }

    public void homemAranha(View view)
    {
        Toast.makeText(Configuracoes.this, "Homem Aranha", Toast.LENGTH_SHORT).show();
    }

    public void homemDeFerro(View view)
    {
        Toast.makeText(Configuracoes.this, "Homem de Ferro", Toast.LENGTH_SHORT).show();
    }
}
