package ufjf.dcc196.quemacademy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import Persistence.Disciplinas;

public class DisciplinasCursadasActivity extends AppCompatActivity {

    private Disciplinas disciplinas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disciplinas_cursadas);

        Bundle bundle = new Bundle();
        //disciplinas = (Disciplinas) bundle.get(disciplinas);

        RecyclerView rv = findViewById(R.id.rvDisciplinas);
        //DisciplinaAdapter pAdapter = new DisciplinaAdapter(this.disciplinas);
        DisciplinaAdapter pAdapter = new DisciplinaAdapter();
        rv.setAdapter(pAdapter);
        rv.setLayoutManager(new LinearLayoutManager(this));

    }
}
