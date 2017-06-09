package com.luizgbraganca.avante123;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class EscolheGrupo extends AppCompatActivity
{
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolhe_grupo);

        fab = (FloatingActionButton) findViewById(R.id.mapa);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mapa();
            }
        });
    }

    public void mapa( )
    {
        Intent intent = new Intent(EscolheGrupo.this, EncontrarGrupo.class);
        startActivity(intent);
    }
}
