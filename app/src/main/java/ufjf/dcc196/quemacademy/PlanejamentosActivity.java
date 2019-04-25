package ufjf.dcc196.quemacademy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import Persistence.Disciplinas;

public class PlanejamentosActivity extends AppCompatActivity {

    public Disciplinas diciplina = new Disciplinas();

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
                Intent intente = new Intent(PlanejamentosActivity.this, NovoPlanejamentoActivity.class);
                startActivity(intente);
            }
        });

        botaoNovaDisciplina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intente = new Intent(PlanejamentosActivity.this, NovaDisciplinaCursadaActivity.class);
                startActivity(intente);
            }
        });

        botaoDisciplinaCursadas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlanejamentosActivity.this, DisciplinasCursadasActivity.class);
                startActivity(intent);
            }
        });

        RecyclerView rv = findViewById(R.id.rvPlanejamento);
        PlanejamentoAdapter pAdapter = new PlanejamentoAdapter(this.diciplina);
        rv.setAdapter(pAdapter);
        rv.setLayoutManager(new LinearLayoutManager(this));
        pAdapter.setOnPlanejamentoAdapterClickListener(new PlanejamentoAdapter.OnPlanejamentoAdapterClickListener() {
            @Override
            public void onPlanejamentoClick(View v, int possition) {
                Intent intent = new Intent(PlanejamentosActivity.this, DetalhesPlanejamentoActivity.class);
                startActivity(intent);
            }
        });
    }
}
