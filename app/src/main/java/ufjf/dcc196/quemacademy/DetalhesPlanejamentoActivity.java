package ufjf.dcc196.quemacademy;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import Persistence.Disciplinas;

public class DetalhesPlanejamentoActivity extends AppCompatActivity {

    private Disciplinas disciplina;
    private int possition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_planejamento);

        Bundle bundle = new Bundle();
        disciplina = (Disciplinas) bundle.get("disciplina");
        possition = (int) bundle.get("possition");


        final TextView tvLinguas = findViewById(R.id.tvLinguasD);
        final TextView tvExatas = findViewById(R.id.tvExatasD);
        final TextView tvSaude = findViewById(R.id.tvSaudeD);
        final TextView tvHumanas = findViewById(R.id.tvHumanasD);
        final EditText etAno = findViewById(R.id.etAnoD);
        final EditText etSemestre = findViewById(R.id.etSemestreD);
        final SeekBar sbLinguas = findViewById(R.id.sbLinguasD);
        final SeekBar sbExatas = findViewById(R.id.sbExatasD);
        final SeekBar sbSaude = findViewById(R.id.sbSaudeD);
        final SeekBar sbHumanas = findViewById(R.id.sbHumanasD);
        Button btConfirmar = findViewById(R.id.btConfirmarD);

        etAno.setHint(disciplina.getAno());
        etSemestre.setHint(disciplina.getSemestre());
        sbLinguas.setProgress(disciplina.getPorcentagem(0));
        sbExatas.setProgress(disciplina.getPorcentagem(1));
        sbSaude.setProgress(disciplina.getPorcentagem(2));
        sbHumanas.setProgress(disciplina.getPorcentagem(3));

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

        btConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                //disciplina.setPorcentagem(sbHumanas.getProgress(), 3);
                intent.putExtra("ano", Integer.parseInt(etAno.getText().toString()));
                intent.putExtra("semestre", Integer.parseInt(etSemestre.getText().toString()));
                intent.putExtra("pLinguas", sbLinguas.getProgress());
                intent.putExtra("pExatas", sbExatas.getProgress());
                intent.putExtra("pSaude", sbSaude.getProgress());
                intent.putExtra("pHumanas", sbHumanas.getProgress());
                intent.putExtra("possition", possition);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }
}
