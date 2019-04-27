package ufjf.dcc196.quemacademy;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import Persistence.Materias;

public class NovaDisciplinaCursadaActivity extends AppCompatActivity {

    Materias materia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_disciplina_cursada);

        materia = new Materias();

        Button btConfirmar = findViewById(R.id.btConfirmar);

        TextView tvArea1 = findViewById(R.id.tvArea1);
        TextView tvArea2 = findViewById(R.id.tvArea2);
        TextView tvArea3 = findViewById(R.id.tvArea3);
        TextView tvArea4 = findViewById(R.id.tvArea4);

        TextView tvMateria11 = findViewById(R.id.tvMateria11);
        TextView tvMateria12 = findViewById(R.id.tvMateria12);
        TextView tvMateria13 = findViewById(R.id.tvMateria13);

        TextView tvMateria21 = findViewById(R.id.tvMateria21);
        TextView tvMateria22 = findViewById(R.id.tvMateria22);
        TextView tvMateria23 = findViewById(R.id.tvMateria23);

        TextView tvMateria31 = findViewById(R.id.tvMateria31);
        TextView tvMateria32 = findViewById(R.id.tvMateria32);
        TextView tvMateria33 = findViewById(R.id.tvMateria33);

        TextView tvMateria41 = findViewById(R.id.tvMateria41);
        TextView tvMateria42 = findViewById(R.id.tvMateria42);
        TextView tvMateria43 = findViewById(R.id.tvMateria43);

        final EditText etMateria11 = findViewById(R.id.etMateria11);
        final EditText etMateria12 = findViewById(R.id.etMateria12);
        final EditText etMateria13 = findViewById(R.id.etMateria13);

        final EditText etMateria21 = findViewById(R.id.etMateria21);
        final EditText etMateria22 = findViewById(R.id.etMateria22);
        final EditText etMateria23 = findViewById(R.id.etMateria23);

        final EditText etMateria31 = findViewById(R.id.etMateria31);
        final EditText etMateria32 = findViewById(R.id.etMateria32);
        final EditText etMateria33 = findViewById(R.id.etMateria33);

        final EditText etMateria41 = findViewById(R.id.etMateria41);
        final EditText etMateria42 = findViewById(R.id.etMateria42);
        final EditText etMateria43 = findViewById(R.id.etMateria43);

        tvArea1.setText("Linguas:");
        tvArea2.setText("Exatas:");
        tvArea3.setText("Saude:");
        tvArea4.setText("Humanas:");

        tvMateria11.setText(materia.getLinguas(0));
        tvMateria12.setText(materia.getLinguas(1));
        tvMateria13.setText(materia.getLinguas(2));

        tvMateria21.setText(materia.getExatas(0));
        tvMateria22.setText(materia.getExatas(1));
        tvMateria23.setText(materia.getExatas(2));

        tvMateria31.setText(materia.getSaude(0));
        tvMateria32.setText(materia.getSaude(1));
        tvMateria33.setText(materia.getSaude(2));

        tvMateria41.setText(materia.getHumanas(0));
        tvMateria42.setText(materia.getHumanas(1));
        tvMateria43.setText(materia.getHumanas(2));

        btConfirmar.setOnClickListener(new View.OnClickListener() {
            int[] linguas;
            int[] exatas;
            int[] saude;
            int[] humanas;
            @Override
            public void onClick(View v) {
                linguas[0] = Integer.parseInt(etMateria11.getText().toString());
                linguas[1] = Integer.parseInt(etMateria12.getText().toString());
                linguas[2] = Integer.parseInt(etMateria13.getText().toString());

                exatas[0] = Integer.parseInt(etMateria21.getText().toString());
                exatas[1] = Integer.parseInt(etMateria22.getText().toString());
                exatas[2] = Integer.parseInt(etMateria23.getText().toString());

                saude[0] = Integer.parseInt(etMateria31.getText().toString());
                saude[1] = Integer.parseInt(etMateria32.getText().toString());
                saude[2] = Integer.parseInt(etMateria33.getText().toString());

                humanas[0] = Integer.parseInt(etMateria41.getText().toString());
                humanas[1] = Integer.parseInt(etMateria42.getText().toString());
                humanas[2] = Integer.parseInt(etMateria43.getText().toString());

                Intent intent = new Intent();
                intent.putExtra("hLinguas", linguas);
                intent.putExtra("hExatas", exatas);
                intent.putExtra("hSaude", saude);
                intent.putExtra("hHumanas", humanas);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });

    }
}
