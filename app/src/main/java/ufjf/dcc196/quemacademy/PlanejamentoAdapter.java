package ufjf.dcc196.quemacademy;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DecimalFormat;

import Persistence.BibliotecaDbHelper;
import Persistence.ContratoBD;

public class PlanejamentoAdapter extends RecyclerView.Adapter<PlanejamentoAdapter.ViewHolder> {
    private Cursor items;
    private Context contexto;
    private OnPlanejamentoAdapterClickListener listener;

    public PlanejamentoAdapter(Cursor items, Context context){
        this.items = items;
        this.contexto = context;
    }

    public void setOnPlanejamentoAdapterClickListener(OnPlanejamentoAdapterClickListener listener){
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inlf = LayoutInflater.from(context);
        View linha = inlf.inflate(R.layout.activity_planejamento_adapter, viewGroup, false);
        PlanejamentoAdapter.ViewHolder vh = new PlanejamentoAdapter.ViewHolder(linha);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        BibliotecaDbHelper bibliotecaHelper = new BibliotecaDbHelper(contexto);
        SQLiteDatabase db = bibliotecaHelper.getReadableDatabase();
        String[] visao = {
                ContratoBD.contratoPlanejamento._ID,
                ContratoBD.contratoPlanejamento.column_planejamento_semestre,
                ContratoBD.contratoPlanejamento.column_planejamento_ano,
        };
        String selecao = ContratoBD.contratoPlanejamento._ID + " >= ?";
        String[] args = {"0"};
        String sort = ContratoBD.contratoPlanejamento._ID + " DESC";
        items = db.query(ContratoBD.contratoPlanejamento.table_planejamento_name, visao, selecao, args, null, null, sort);

        int idxId = items.getColumnIndexOrThrow(ContratoBD.contratoPlanejamento._ID);
        int idxSemestre = items.getColumnIndexOrThrow(ContratoBD.contratoPlanejamento.column_planejamento_semestre);
        int idxAno = items.getColumnIndexOrThrow(ContratoBD.contratoPlanejamento.column_planejamento_ano);

        items.moveToPosition(i);
        viewHolder.textViewSemestre.setText(items.getString(idxSemestre));
        viewHolder.textViewAno.setText(items.getString(idxAno));
        try {
            viewHolder.textViewPorcentagem.setText(getPorcentagem(items.getString(idxId)));
        }catch (NullPointerException ex){
            viewHolder.textViewPorcentagem.setText(0);
        }

    }

    @Override
    public int getItemCount() {
        return items.getCount();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView textViewSemestre;
        public TextView textViewAno;
        public TextView textViewPorcentagem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewSemestre = itemView.findViewById(R.id.textViewSemestre);
            textViewAno = itemView.findViewById(R.id.textViewAno);
            textViewPorcentagem = itemView.findViewById(R.id.textViewPorcentagem);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        listener.onPlanejamentoAdapterClick(v, getAdapterPosition());
                    }
                }
            });
        }

        @Override
        public void onClick(View v) {
            int possition = getAdapterPosition();
            if(possition != RecyclerView.NO_POSITION){
                listener.onPlanejamentoAdapterClick(v, possition);
            }
        }
    }

    public interface OnPlanejamentoAdapterClickListener{
        public void onPlanejamentoAdapterClick(View v, int possition);
    }

    public String getPorcentagem(String id){
        BibliotecaDbHelper bibliotecaHelper = new BibliotecaDbHelper(contexto);
        SQLiteDatabase db = bibliotecaHelper.getReadableDatabase();
        String[] visao = {
                ContratoBD.contratoDisciplina._ID,
                ContratoBD.contratoDisciplina.column_disciplina_planejamento,
                ContratoBD.contratoDisciplina.column_disciplina_horas,
        };
        String selecao = ContratoBD.contratoDisciplina.column_disciplina_planejamento + " = ?";
        String[] args = {id};
        String sort = ContratoBD.contratoPlanejamento._ID + " DESC";
        Cursor c = db.query(ContratoBD.contratoDisciplina.table_disciplina_nome, visao, selecao, args, null, null, sort);
        c.moveToFirst();

        int idxHoras = c.getColumnIndexOrThrow(ContratoBD.contratoDisciplina.column_disciplina_horas);
        int cont = 0;
        String porcentagem = "";
        while (c.getPosition() <= c.getCount() - 1){
            cont += Integer.valueOf(c.getInt(idxHoras));
            c.moveToNext();
        }
        c.moveToFirst();
        while (c.getPosition() <= c.getCount() -1 ){
            porcentagem += String.format("%.2f", (float)(Integer.valueOf(c.getInt(idxHoras))*100)/(float)cont) + " - ";
            c.moveToNext();
        }
        return porcentagem;
    }

}
