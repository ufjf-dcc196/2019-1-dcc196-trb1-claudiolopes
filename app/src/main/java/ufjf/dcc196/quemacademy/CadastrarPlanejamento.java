package ufjf.dcc196.quemacademy;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CadastrarPlanejamento extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_planejamento);

        final EditText editTextAno = findViewById(R.id.editTextAno);
        final EditText editTextSemestre = findViewById(R.id.editTextSemestre);

        Button buttonCadastrar = findViewById(R.id.buttonSalvarPlanejamento);
        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("semestre", editTextSemestre.getText());
                intent.putExtra("ano", editTextAno.getText());
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }
}
