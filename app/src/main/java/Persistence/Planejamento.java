package Persistence;

public class Planejamento {
    private int semestre;
    private int ano;
    private int[] porcentagem;

    public Planejamento() {
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }


    public int[] getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(int[] porcentagem) {
        this.porcentagem = porcentagem;
    }
}
