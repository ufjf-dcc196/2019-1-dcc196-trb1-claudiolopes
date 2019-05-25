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
import java.util.ArrayList;
import java.util.List;

import Persistence.BibliotecaDbHelper;
import Persistence.Dados;
import Persistence.Disciplinas;
import Persistence.Planejamento;

public class PlanejamentosActivity extends AppCompatActivity {

    public List<Disciplinas> disciplinas = new ArrayList<>();
    public static final int REQUEST_MAIN = 1;
    public static final int REQUEST_DISC = 2;
    public static final int REQUEST_DET = 3;

    Disciplinas d = new Disciplinas();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planejamentos);

        popula();

        Button botaoNovoPlanejamento = findViewById(R.id.botaoNovoPlanejamento);
        Button botaoNovaDisciplina = findViewById(R.id.botaoNovaDisciplina);
        Button botaoDisciplinaCursadas = findViewById(R.id.botaoDisciplinasCursadas);

        botaoNovoPlanejamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlanejamentosActivity.this, NovoPlanejamentoActivity.class);
                startActivityForResult(intent, PlanejamentosActivity.REQUEST_MAIN);
            }
        });

        botaoNovaDisciplina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlanejamentosActivity.this, NovaDisciplinaCursadaActivity.class);
                startActivityForResult(intent, PlanejamentosActivity.REQUEST_DISC);
            }
        });

        botaoDisciplinaCursadas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlanejamentosActivity.this, DisciplinasCursadasActivity.class);
                Dados dados = Dados.getInstance();
                dados.setDisciplinas(disciplinas);
                startActivityForResult(intent, PlanejamentosActivity.REQUEST_MAIN);
            }
        });

        RecyclerView rv = findViewById(R.id.rvPlanejamento);
        PlanejamentoAdapter pAdapter = new PlanejamentoAdapter(this.disciplinas);
        rv.setAdapter(pAdapter);
        rv.setLayoutManager(new LinearLayoutManager(this));
        pAdapter.setOnPlanejamentoAdapterClickListener(new PlanejamentoAdapter.OnPlanejamentoAdapterClickListener() {
            @Override
            public void onPlanejamentoClick(View v, int possition) {
                Dados dados = Dados.getInstance();
                dados.setDisciplina(disciplinas.get(possition));
                dados.setPosicao(possition);
                Intent intent = new Intent(PlanejamentosActivity.this, DetalhesPlanejamentoActivity.class);
                startActivityForResult(intent, PlanejamentosActivity.REQUEST_DET);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        Disciplinas disciplina = new Disciplinas();
        if (requestCode == PlanejamentosActivity.REQUEST_MAIN){
            if (resultCode == Activity.RESULT_OK){
                if (data != null) {
                    Bundle bundle = data.getExtras();
                    disciplina.setAno((Integer) bundle.get("ano"));
                    disciplina.setSemestre((Integer) bundle.get("semestre"));
                    disciplina.setPorcentagem((Integer) bundle.get("linguas"));
                    disciplina.setPorcentagem((Integer) bundle.get("exatas"));
                    disciplina.setPorcentagem((Integer) bundle.get("saude"));
                    disciplina.setPorcentagem((Integer) bundle.get("humanas"));
                    disciplina.setHoras(0);
                    disciplina.setHoras(0);
                    disciplina.setHoras(0);
                    disciplina.setHoras(0);
                    rvPopula();
                }
            }
        }
        if (requestCode == PlanejamentosActivity.REQUEST_DISC){
            if (resultCode == Activity.RESULT_OK){
                if (data != null) {
                    Bundle bundle = data.getExtras();
                }
            }
        }
        if (requestCode == PlanejamentosActivity.REQUEST_DET){
            if (resultCode == Activity.RESULT_OK){
                if (data != null) {
                    Bundle bundle = data.getExtras();
                    Disciplinas disc = new Disciplinas();
                    disc.setAno((int) bundle.get("ano"));
                    disc.setSemestre((int) bundle.get("semestre"));
                    disc.setPorcentagem((int) bundle.get("pLinguas"));
                    disc.setPorcentagem((int) bundle.get("pExatas"));
                    disc.setPorcentagem((int) bundle.get("pSaude"));
                    disc.setPorcentagem((int) bundle.get("pHumanas"));
                    disciplina.setHoras(0,0);
                    disciplina.setHoras(0,1);
                    disciplina.setHoras(0,2);
                    disciplina.setHoras(0,3);
                    disciplinas.set((int) bundle.get("possition"), disc);
                    rvPopula();
                }
            }
        }
        disciplinas.add(disciplina);
    }

    public void popula (){

        BibliotecaDbHelper bibliotecaHelper = new BibliotecaDbHelper(this);
        SQLiteDatabase db = bibliotecaHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Planejamento.planejamento.COLUMN_NAME_ANO, 2019);
        values.put(Planejamento.planejamento.COLUMN_NAME_SEMESTRE, 3);
        values.put(Planejamento.planejamento.COLUMN_NAME_PORCENTAGEM, "25,25,25,25");
        values.put(Planejamento.planejamento.COLUMN_NAME_HORAS, "4,4,4,4");
        long id = db.insert(Planejamento.planejamento.TABLE_NAME, null, values);

        Cursor c;
        SQLiteDatabase dbR = bibliotecaHelper.getReadableDatabase();
        String [] visao = {
                Planejamento.planejamento._ID,
                Planejamento.planejamento.COLUMN_NAME_ANO,
                Planejamento.planejamento.COLUMN_NAME_SEMESTRE,
                Planejamento.planejamento.COLUMN_NAME_PORCENTAGEM,
                Planejamento.planejamento.COLUMN_NAME_HORAS,
        };
        String selecao = Planejamento.planejamento._ID + " >= ?";
        String[] args = {"0"};
        String sort = Planejamento.planejamento._ID + " DESC";
        c = dbR.query(Planejamento.planejamento.TABLE_NAME, visao, selecao, args, null, null  , sort);

        int idxAno = c.getColumnIndexOrThrow(Planejamento.planejamento.COLUMN_NAME_ANO);
        int idxSemestre = c.getColumnIndexOrThrow(Planejamento.planejamento.COLUMN_NAME_SEMESTRE);
        int idxPorcentagem = c.getColumnIndexOrThrow(Planejamento.planejamento.COLUMN_NAME_PORCENTAGEM);
        int idxHoras = c.getColumnIndexOrThrow(Planejamento.planejamento.COLUMN_NAME_HORAS);
        c.moveToFirst();
        d.setAno(c.getInt(idxAno));
        d.setSemestre(c.getInt(idxSemestre));
        d.setPorcentagem(c.getInt(idxPorcentagem));
        d.setHoras(c.getInt(idxHoras));

        disciplinas.add(d);
    }

    private void rvPopula(){
        RecyclerView rv = findViewById(R.id.rvPlanejamento);
        PlanejamentoAdapter pAdapter = new PlanejamentoAdapter(this.disciplinas);
        rv.setAdapter(pAdapter);
        rv.setLayoutManager(new LinearLayoutManager(this));
        pAdapter.setOnPlanejamentoAdapterClickListener(new PlanejamentoAdapter.OnPlanejamentoAdapterClickListener() {
            @Override
            public void onPlanejamentoClick(View v, int possition) {
                Intent intent = new Intent(PlanejamentosActivity.this, DetalhesPlanejamentoActivity.class);
                intent.putExtra("possition", possition);
                startActivityForResult(intent, PlanejamentosActivity.REQUEST_DET);
            }
        });
    }
}
