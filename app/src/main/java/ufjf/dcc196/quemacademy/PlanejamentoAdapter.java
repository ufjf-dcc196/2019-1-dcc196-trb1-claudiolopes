package ufjf.dcc196.quemacademy;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import Persistence.Disciplinas;

public class PlanejamentoAdapter extends RecyclerView.Adapter<PlanejamentoAdapter.ViewHolder>{

    private final List<Disciplinas> disciplinas;
    private OnPlanejamentoAdapterClickListener listener;

    public PlanejamentoAdapter() {
        disciplinas = new ArrayList<>();
    }

    public void setOnPlanejamentoAdapterClickListener(OnPlanejamentoAdapterClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public PlanejamentoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull PlanejamentoAdapter.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            int possition = getAdapterPosition();
            if (possition != RecyclerView.NO_POSITION){
                listener.onPlanejamentoClick(v, possition);
            }
        }

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    public interface OnPlanejamentoAdapterClickListener{
        public void onPlanejamentoClick(View v, int possition);
    }
}
