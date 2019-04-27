package ufjf.dcc196.quemacademy;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.Serializable;

import Persistence.Disciplinas;

public class NovoPlanejamentoActivity extends AppCompatActivity {

    Disciplinas disciplina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_planejamento);

        final TextView tvLinguas = findViewById(R.id.tvLinguas);
        final TextView tvExatas = findViewById(R.id.tvExatas);
        final TextView tvSaude = findViewById(R.id.tvSaude);
        final TextView tvHumanas = findViewById(R.id.tvHumanas);
        final EditText etAno = findViewById(R.id.etAno);
        final EditText etSemestre = findViewById(R.id.etSemestre);
        final SeekBar sbLinguas = findViewById(R.id.sbLinguas);
        final SeekBar sbExatas = findViewById(R.id.sbExatas);
        final SeekBar sbSaude = findViewById(R.id.sbSaude);
        final SeekBar sbHumanas = findViewById(R.id.sbHumanas);
        Button btConfirmar = findViewById(R.id.btConfirmar);

        btConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("ano", Integer.parseInt(etAno.getText().toString()));
                intent.putExtra("semestre", Integer.parseInt(etSemestre.getText().toString()));
                intent.putExtra("linguas", sbLinguas.getProgress());
                intent.putExtra("exatas", sbExatas.getProgress());
                intent.putExtra("saude", sbSaude.getProgress());
                intent.putExtra("humanas", sbHumanas.getProgress());
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });

        sbLinguas.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progresso = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progresso = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                tvLinguas.setText(progresso + "/" + seekBar.getMax());
                sbExatas.setMax(seekBar.getMax() - progresso);
                sbSaude.setMax(seekBar.getMax() - progresso);
                sbHumanas.setMax(seekBar.getMax() - progresso);
            }
        });

        sbExatas.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progresso = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progresso = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                tvExatas.setText(progresso + "/" + seekBar.getMax());
                sbLinguas.setMax(seekBar.getMax() - progresso);
                sbSaude.setMax(seekBar.getMax() - progresso);
                sbHumanas.setMax(seekBar.getMax() - progresso);
            }
        });

        sbSaude.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progresso = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progresso = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                tvSaude.setText(progresso + "/" + seekBar.getMax());
                sbExatas.setMax(seekBar.getMax() - progresso);
                sbLinguas.setMax(seekBar.getMax() - progresso);
                sbHumanas.setMax(seekBar.getMax() - progresso);
            }
        });

        sbHumanas.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progresso = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progresso = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                tvHumanas.setText(progresso + "/" + seekBar.getMax());
                sbExatas.setMax(seekBar.getMax() - progresso);
                sbSaude.setMax(seekBar.getMax() - progresso);
                sbLinguas.setMax(seekBar.getMax() - progresso);
            }
        });
    }
}
