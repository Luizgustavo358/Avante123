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

public class ProjetosAdapter extends RecyclerView.Adapter<ProjetosAdapter.ProjetoViewHolder>
{
    public List<Projetos> projetos;
    public Context context;

    public ProjetosAdapter(List<Projetos> projetos, Context context)
    {
        this.context = context;
        this.projetos = projetos;
    }

    @Override
    public ProjetosAdapter.ProjetoViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.linha, parent, false);

        return new ProjetoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProjetosAdapter.ProjetoViewHolder holder, int position)
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

    public class ProjetoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        public TextView nomeProjetoLinha, descricaoLinha;
        private Context mContext;

        public ProjetoViewHolder(View itemView)
        {
            super(itemView);

            mContext = itemView.getContext();

            nomeProjetoLinha = (TextView) itemView.findViewById(R.id.nomeProjetoLista);
            descricaoLinha = (TextView) itemView.findViewById(R.id.descricaoLista);

            itemView.setOnClickListener(this);
        }

        public void bindProjeto(Projetos projetos)
        {
            nomeProjetoLinha.setText(projetos.getNomeProjeto());
            descricaoLinha.setText(projetos.getDescricao());
        }

        @Override
        public void onClick(View v)
        {
            int itemPosition = getLayoutPosition();

            Intent intent = new Intent(mContext, TelaDoProjeto.class);

            intent.putExtra("position", itemPosition + "");
            intent.putExtra("nomeProjeto", nomeProjetoLinha + "");
            intent.putExtra("descricao", descricaoLinha + "");

            mContext.startActivity(intent);
        }
    }
}