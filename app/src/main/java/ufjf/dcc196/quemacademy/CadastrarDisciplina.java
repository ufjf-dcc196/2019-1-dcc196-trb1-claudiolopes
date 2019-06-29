package ufjf.dcc196.quemacademy;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CadastrarDisciplina extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_disciplina);

        final EditText editTextNome = findViewById(R.id.editTextNome);
        final EditText editTextArea = findViewById(R.id.editTextArea);
        final EditText editTextHoras = findViewById(R.id.editTextHoras);

        Button buttonCadastrar = findViewById(R.id.buttonSalvarDisciplina);
        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("nome", editTextNome.getText());
                intent.putExtra("area", editTextArea.getText());
                intent.putExtra("horas", editTextHoras.getText());
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }
}
