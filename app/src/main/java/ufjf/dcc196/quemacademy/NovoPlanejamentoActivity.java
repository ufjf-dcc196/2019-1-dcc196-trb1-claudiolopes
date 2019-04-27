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

import Persistence.Disciplinas;

public class NovoPlanejamentoActivity extends AppCompatActivity {

    Disciplinas disciplina;
    int progressTotal = 100;

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
                disciplina.setAno(Integer.parseInt(etAno.getText().toString()));
                disciplina.setSemestre(Integer.parseInt(etSemestre.getText().toString()));
                disciplina.setPorcentagem(sbLinguas.getProgress());
                disciplina.setPorcentagem(sbExatas.getProgress());
                disciplina.setPorcentagem(sbSaude.getProgress());
                disciplina.setPorcentagem(sbHumanas.getProgress());
                disciplina.setHoras(sbLinguas.getProgress() + sbExatas.getProgress() + sbSaude.getProgress() + sbHumanas.getProgress());
                Intent intent = new Intent();
                intent  .putExtra("disciplina", (Parcelable) disciplina);
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
