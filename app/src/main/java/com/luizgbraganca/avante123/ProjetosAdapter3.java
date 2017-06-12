package com.luizgbraganca.avante123;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by luiz on 08/06/17.
 */

public class ProjetosAdapter3 extends RecyclerView.Adapter<ProjetosAdapter3.ProjetoViewHolder3>
{
    public List<Projetos> projetos;
    public Context context;

    public ProjetosAdapter3(List<Projetos> projetos, Context context)
    {
        this.context = context;
        this.projetos = projetos;
    }

    @Override
    public ProjetosAdapter3.ProjetoViewHolder3 onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_lista_projetos, parent, false);

        return new ProjetoViewHolder3(view);
    }

    @Override
    public void onBindViewHolder(ProjetosAdapter3.ProjetoViewHolder3 holder, int position)
    {
//        Projetos projeto = projetos.get(position);
//
//        holder.nomeProjetoLinha.setText(projeto.getNomeProjeto());
//        holder.descricaoLinha.setText(projeto.getDescricao());

        holder.bindProjeto(projetos.get(position));
    }

    @Override
    public int getItemCount()
    {
        return projetos.size();
    }

    public class ProjetoViewHolder3 extends RecyclerView.ViewHolder
    {
        public TextView nomeCriador;
        private Context mContext;

        public ProjetoViewHolder3(View itemView)
        {
            super(itemView);

            mContext = itemView.getContext();

            nomeCriador = (TextView) itemView.findViewById(R.id.criador);
        }

        public void bindProjeto(Projetos projetos)
        {
            nomeCriador.setText(projetos.getNomeProjeto());
        }
    }
}