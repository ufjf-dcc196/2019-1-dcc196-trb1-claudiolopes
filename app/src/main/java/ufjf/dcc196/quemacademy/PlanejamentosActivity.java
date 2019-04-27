package ufjf.dcc196.quemacademy;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import Persistence.Disciplinas;

public class PlanejamentosActivity extends AppCompatActivity {

    public List<Disciplinas> diciplinas = new ArrayList<>();
    public static final int REQUEST_MAIN = 1;
    public static final int REQUEST_DISC = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planejamentos);


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
                intent.putExtra("disciplinas", (Serializable) diciplinas);
                startActivityForResult(intent, PlanejamentosActivity.REQUEST_DISC);
            }
        });

        botaoDisciplinaCursadas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlanejamentosActivity.this, DisciplinasCursadasActivity.class);
                startActivityForResult(intent, PlanejamentosActivity.REQUEST_MAIN);
            }
        });

        RecyclerView rv = findViewById(R.id.rvPlanejamento);
        PlanejamentoAdapter pAdapter = new PlanejamentoAdapter(this.diciplinas);
        rv.setAdapter(pAdapter);
        rv.setLayoutManager(new LinearLayoutManager(this));
        pAdapter.setOnPlanejamentoAdapterClickListener(new PlanejamentoAdapter.OnPlanejamentoAdapterClickListener() {
            @Override
            public void onPlanejamentoClick(View v, int possition) {
                Intent intent = new Intent(PlanejamentosActivity.this, DetalhesPlanejamentoActivity.class);
                startActivityForResult(intent, PlanejamentosActivity.REQUEST_MAIN);
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
                }
            }
        }
        if (requestCode == PlanejamentosActivity.REQUEST_DISC){
            if (resultCode == Activity.RESULT_OK){
                if (data != null) {
                    Bundle bundle = data.getExtras();
                    disciplina.setHoras((int[]) bundle.get("hLinguas"), 0);
                    disciplina.setHoras((int[]) bundle.get("hExatas"), 1);
                    disciplina.setHoras((int[]) bundle.get("hSaude"), 2);
                    disciplina.setHoras((int[]) bundle.get("hHumanas"), 3);
                }
            }
        }
        diciplinas.add(disciplina);
    }
}
