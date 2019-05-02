package ufjf.dcc196.quemacademy;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import Persistence.Disciplinas;

public class PlanejamentoAdapter extends RecyclerView.Adapter<PlanejamentoAdapter.ViewHolder>{

    private final List<Disciplinas> items;
    private OnPlanejamentoAdapterClickListener listener;

    public PlanejamentoAdapter(List<Disciplinas> disciplinas) {
        this.items = disciplinas;
    }

    public void setOnPlanejamentoAdapterClickListener(OnPlanejamentoAdapterClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public PlanejamentoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inlf = LayoutInflater.from(context);
        View linha = inlf.inflate(R.layout.activity_planejamento, viewGroup, false);
        ViewHolder vh = new ViewHolder(linha);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull PlanejamentoAdapter.ViewHolder viewHolder, int i) {
            Disciplinas disc = this.items.get(i);
            viewHolder.textAno.setText(disc.getAno());
            viewHolder.textSimester.setText(disc.getSemestre());
            viewHolder.textPorcentagem.setText(disc.getPorcentagem(0) + ", " + disc.getPorcentagem(1) + ", " + disc.getPorcentagem(2) + ", " + disc.getPorcentagem(3));
            viewHolder.textTotalHoras.setText(disc.getHoras(i));
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView textAno;
        public TextView textSimester;
        public TextView textPorcentagem;
        public TextView textTotalHoras;

        @Override
        public void onClick(View v) {
            int possition = getAdapterPosition();
            if (possition != RecyclerView.NO_POSITION){
                listener.onPlanejamentoClick(v, possition);
            }
        }

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textAno = itemView.findViewById(R.id.textAno);
            textSimester = itemView.findViewById(R.id.textSimester);
            textPorcentagem = itemView.findViewById(R.id.textPorcentagem);
            textTotalHoras = itemView.findViewById(R.id.textTotalHoras);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        listener.onPlanejamentoClick(v, getAdapterPosition());
                    }
                }
            });
        }
    }

    public interface OnPlanejamentoAdapterClickListener{
        public void onPlanejamentoClick(View v, int possition);
    }
}
