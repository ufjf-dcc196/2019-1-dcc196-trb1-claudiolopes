package Persistence;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class Disciplinas {
    private int ano;
    private int semestre;
    private List<Integer> porcentagem = new ArrayList<Integer>();
    private List<Integer> horas = new ArrayList<Integer>();

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

    public int getHoras(int area) {
        return horas.get(area);
    }

    public void setHoras(int horas) {
        this.horas.add(horas);
    }

    public void setPorcentagem(int porcentagem, int mat){
        this.porcentagem.set(mat, porcentagem);
    }

    public Disciplinas() {

    }

}
