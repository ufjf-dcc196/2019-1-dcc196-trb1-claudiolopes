package ufjf.dcc196.quemacademy;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import Persistence.BibliotecaDbHelper;
import Persistence.ContratoBD;

public class DisciplinaAdapter extends RecyclerView.Adapter<DisciplinaAdapter.ViewHolder>{

    private Cursor items;
    private Context contexto;
    private OnDisciplinaAdapterClickListener listener;

    public DisciplinaAdapter(Cursor items, Context contexto) {
        this.items = items;
        this.contexto = contexto;
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
        DisciplinaAdapter.ViewHolder vh = new DisciplinaAdapter.ViewHolder(linha);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull DisciplinaAdapter.ViewHolder viewHolder, int i) {
        int idxNome = items.getColumnIndexOrThrow(ContratoBD.contratoDisciplina.column_disciplina_nome);
        int idxArea = items.getColumnIndexOrThrow(ContratoBD.contratoDisciplina.column_disciplina_area);
        int idxHoras = items.getColumnIndexOrThrow(ContratoBD.contratoDisciplina.column_disciplina_horas);

        items.moveToPosition(i);

        viewHolder.textViewNome.setText(items.getString(idxNome));
        viewHolder.textViewArea.setText(items.getString(idxArea));
        viewHolder.textViewHoras.setText(items.getString(idxHoras));
    }

    @Override
    public int getItemCount() {
        return items.getCount();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView textViewNome;
        public TextView textViewArea;
        public TextView textViewHoras;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNome = itemView.findViewById(R.id.textViewNome);
            textViewArea = itemView.findViewById(R.id.textViewAre);
            textViewHoras = itemView.findViewById(R.id.textViewHoras);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        listener.onDisciplinaAdapterClick(v, getAdapterPosition());
                    }
                }
            });
        }

        @Override
        public void onClick(View v) {
            int possition = getAdapterPosition();
            if(possition != RecyclerView.NO_POSITION){
                listener.onDisciplinaAdapterClick(v, possition);
            }
        }
    }


    public interface OnDisciplinaAdapterClickListener{
        public void onDisciplinaAdapterClick(View v, int possition);
    }
}
