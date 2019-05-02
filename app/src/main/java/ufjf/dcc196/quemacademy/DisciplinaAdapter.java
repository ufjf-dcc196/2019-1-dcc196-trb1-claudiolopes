package ufjf.dcc196.quemacademy;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import Persistence.Disciplinas;

public class DisciplinaAdapter extends RecyclerView.Adapter<DisciplinaAdapter.ViewHolder> {

    private OnDisciplinaAdapterClickListener listener;

    public DisciplinaAdapter(List<Disciplinas> disciplinas){

    }

    public void setOnDisciplinaAdapterClickListener(OnDisciplinaAdapterClickListener listener){
        this.listener = listener;
    }

    @NonNull
    @Override
    public DisciplinaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inlf = LayoutInflater.from(context);
        View linha = inlf.inflate(R.layout.activity_disciplina_adapter, viewGroup, false);
        ViewHolder vh = new ViewHolder(linha);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull DisciplinaAdapter.ViewHolder viewHolder, int i) {
        viewHolder.textHoras.setText("10");
        viewHolder.textArea.setText("Exatas");
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView textTitulo;
        public TextView textHoras;
        public TextView textArea;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textTitulo = itemView.findViewById(R.id.textTitulo);
            textHoras = itemView.findViewById(R.id.textHoras);
            textArea = itemView.findViewById(R.id.textArea);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        listener.onDiscipliClick(v, getAdapterPosition());
                    }
                }
            });
        }

        @Override
        public void onClick(View v) {
            int possition = getAdapterPosition();
            if (possition != RecyclerView.NO_POSITION){
                listener.onDiscipliClick(v, possition);
            }
        }
    }

    public interface OnDisciplinaAdapterClickListener{
        public void onDiscipliClick(View v, int possition);
    }
}
