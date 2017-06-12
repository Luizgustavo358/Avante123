package com.luizgbraganca.avante123;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.luizgbraganca.avante123.database.models.User;

/**
 * Created by luiz on 06/06/17.
 */

public class Projetos
{
    // definir dados
    private String nomeProjeto;
    private String descricao;

    public Projetos( )
    {

    }

    public Projetos(String nomeProjeto)
    {
        this.nomeProjeto = nomeProjeto;
    }

    public Projetos(String nomeProjeto, String descricao) {
        this.nomeProjeto = nomeProjeto;
        this.descricao = descricao;
    }

    public String getNomeProjeto() {
        return nomeProjeto;
    }

    public void setNomeProjeto(String nomeProjeto) {
        this.nomeProjeto = nomeProjeto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}