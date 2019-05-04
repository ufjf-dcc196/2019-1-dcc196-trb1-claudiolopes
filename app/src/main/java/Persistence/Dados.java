package Persistence;

import java.util.ArrayList;
import java.util.List;

public class Dados {

    private static Dados instance = new Dados();

    public static Dados getInstance() {
        if (instance == null)
            instance = new Dados();

        return instance;
    }

    public List<Disciplinas> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplinas> disciplinas) {
        this.disciplinas = disciplinas;
    }

    private  List<Disciplinas> disciplinas;
    private Disciplinas disciplina;
    private int posicao;

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public Dados() {
        this.disciplina = new Disciplinas();
        this.disciplinas = new ArrayList<Disciplinas>();
    }

    public Disciplinas getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplinas disciplina) {
        this.disciplina = disciplina;
    }
}
