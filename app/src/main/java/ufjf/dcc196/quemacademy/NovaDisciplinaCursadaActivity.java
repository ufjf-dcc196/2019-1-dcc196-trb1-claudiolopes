package ufjf.dcc196.quemacademy;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NovaDisciplinaCursadaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_disciplina_cursada);

        Button btConfirmar = findViewById(R.id.btConfirmar);

        final EditText etHoras = findViewById(R.id.editHoras);
        final EditText etArea = findViewById(R.id.etArea);


        btConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("horas", etHoras.getText());
                intent.putExtra("area", etArea.getText());
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });

    }
}
