package ufjf.dcc196.quemacademy;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
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

public class EditarPlanejamento extends AppCompatActivity {
    public static final int REQUEST_CAD = 1;

    public Intent intent;
    public Bundle bdl;
    public Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_planejamento);

        intent = getIntent();
        bdl = intent.getExtras();

        Button buttonCadastrar = findViewById(R.id.buttonCadastrarDisciplina);
        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditarPlanejamento.this, CadastrarDisciplina.class);
                startActivityForResult(intent, EditarPlanejamento.REQUEST_CAD);
            }
        });

        recycleView();
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == EditarPlanejamento.REQUEST_CAD) {
            if (resultCode == Activity.RESULT_OK) {
                Bundle bundle = data.getExtras();
                BibliotecaDbHelper bibliotecaHelper = new BibliotecaDbHelper(this);
                SQLiteDatabase db = bibliotecaHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(ContratoBD.contratoDisciplina.column_disciplina_nome, bundle.get("nome").toString());
                values.put(ContratoBD.contratoDisciplina.column_disciplina_area, bundle.get("area").toString());
                values.put(ContratoBD.contratoDisciplina.column_disciplina_horas, bundle.get("horas").toString());
                values.put(ContratoBD.contratoDisciplina.column_disciplina_planejamento, bdl.get("id").toString());
                long id = db.insert(ContratoBD.contratoDisciplina.table_disciplina_nome, null, values);
            }
        }

        recycleView();
    }

    private void recycleView(){
        BibliotecaDbHelper bibliotecaHelper = new BibliotecaDbHelper(this);

        SQLiteDatabase db = bibliotecaHelper.getReadableDatabase();
        String[] visao = {
                ContratoBD.contratoDisciplina._ID,
                ContratoBD.contratoDisciplina.column_disciplina_nome,
                ContratoBD.contratoDisciplina.column_disciplina_area,
                ContratoBD.contratoDisciplina.column_disciplina_horas,
                ContratoBD.contratoDisciplina.column_disciplina_planejamento,
        };
        String selecao = ContratoBD.contratoDisciplina.column_disciplina_planejamento + " = ?";
        String[] args = {bdl.get("id").toString()};
        String sort = ContratoBD.contratoDisciplina._ID + " DESC";
        final Cursor c = db.query(ContratoBD.contratoDisciplina.table_disciplina_nome, visao, selecao, args, null, null  , sort);
        c.moveToFirst();

        RecyclerView recyclerView = findViewById(R.id.rvDisciplina);
        DisciplinaAdapter disciplinaAdapter = new DisciplinaAdapter(c, this);
        recyclerView.setAdapter(disciplinaAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
