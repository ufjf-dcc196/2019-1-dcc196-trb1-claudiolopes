package ufjf.dcc196.quemacademy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import Persistence.Disciplinas;

public class DisciplinasCursadasActivity extends AppCompatActivity {

    public List<Disciplinas> disciplinas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disciplinas_cursadas);

        Bundle bundle = new Bundle();
        this.disciplinas = (List<Disciplinas>) bundle.get("Disciplinas");

        RecyclerView rv = findViewById(R.id.rvDisciplinas);
        DisciplinaAdapter pAdapter = new DisciplinaAdapter(this.disciplinas);
        rv.setAdapter(pAdapter);
        rv.setLayoutManager(new LinearLayoutManager(this));
    }
}
