package ufjf.dcc196.quemacademy;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import Persistence.BibliotecaDbHelper;
import Persistence.ContratoBD;
import Persistence.Planejamento;

public class PlanejamentosActivity extends AppCompatActivity {
    public static final int REQUEST_EDT = 1;
    public static final int REQUEST_CAD = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planejamentos);

        Button buttonCadastrar = findViewById(R.id.buttonCadastrarPlanejamento);
        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlanejamentosActivity.this, CadastrarPlanejamento.class);
                startActivityForResult(intent, PlanejamentosActivity.REQUEST_CAD);
            }
        });
        try {
            recycleView();
        }catch (NullPointerException ex){

        }


    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == PlanejamentosActivity.REQUEST_CAD) {
            if (resultCode == Activity.RESULT_OK) {
                Bundle bundle = data.getExtras();
                BibliotecaDbHelper bibliotecaHelper = new BibliotecaDbHelper(this);
                SQLiteDatabase db = bibliotecaHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(ContratoBD.contratoPlanejamento.column_planejamento_ano, bundle.get("ano").toString());
                values.put(ContratoBD.contratoPlanejamento.column_planejamento_semestre, bundle.get("semestre").toString());
                long id = db.insert(ContratoBD.contratoPlanejamento.table_planejamento_name, null, values);
            }
        }

        recycleView();
    }

    private void recycleView(){
        BibliotecaDbHelper bibliotecaHelper = new BibliotecaDbHelper(this);

        SQLiteDatabase db = bibliotecaHelper.getReadableDatabase();
        String[] visao = {
                ContratoBD.contratoPlanejamento._ID,
                ContratoBD.contratoPlanejamento.column_planejamento_semestre,
                ContratoBD.contratoPlanejamento.column_planejamento_ano,
        };
        String selecao = ContratoBD.contratoPlanejamento._ID + " >= ?";
        String[] args = {"0"};
        String sort = ContratoBD.contratoPlanejamento._ID + " DESC";
        final Cursor c = db.query(ContratoBD.contratoPlanejamento.table_planejamento_name, visao, selecao, args, null, null  , sort);
        c.moveToFirst();

        RecyclerView recyclerView = findViewById(R.id.rvPlanejamento);
        PlanejamentoAdapter planejamentoAdapter = new PlanejamentoAdapter(c, this);
        recyclerView.setAdapter(planejamentoAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        planejamentoAdapter.setOnPlanejamentoAdapterClickListener(new PlanejamentoAdapter.OnPlanejamentoAdapterClickListener() {
            @Override
            public void onPlanejamentoAdapterClick(View v, int possition) {
                c.moveToPosition(possition);
                int idxId = c.getColumnIndexOrThrow(ContratoBD.contratoPlanejamento._ID);
                int idxSemestre = c.getColumnIndexOrThrow(ContratoBD.contratoPlanejamento.column_planejamento_semestre);
                int idxAno = c.getColumnIndexOrThrow(ContratoBD.contratoPlanejamento.column_planejamento_ano);

                Intent intent = new Intent(PlanejamentosActivity.this, EditarPlanejamento.class);
                intent.putExtra("id", c.getString(idxId));
                intent.putExtra("semestre", c.getString(idxSemestre));
                intent.putExtra("ano", c.getString(idxAno));
                startActivityForResult(intent, PlanejamentosActivity.REQUEST_EDT);

            }
        });
    }
}
