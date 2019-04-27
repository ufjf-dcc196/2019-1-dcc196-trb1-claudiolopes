package Persistence;

import android.text.Editable;

import java.util.Arrays;
import java.util.List;

public class Disciplinas {
    private Materias materia;
    private int ano;
    private int semestre;
    private List<Integer> porcentagem;
    private int horas;

    public Materias getMateria() {
        return materia;
    }

    public void setMateria(Materias materia) {
        this.materia = materia;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public Integer getPorcentagem(int i) {
        return porcentagem.get(i);
    }

    public void setPorcentagem(int porcentagem) {
        this.porcentagem.add(porcentagem);
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public Disciplinas() {
        this.materia = new Materias();
        this.ano = 2019;
        this.horas = 20;
        this.porcentagem = Arrays.asList(20,20,20,20);
        this.semestre = 5;
    }
}
