package Persistence;

public class Disciplinas {
    private Materias materia;
    private int ano;
    private int semestre;
    private int porcentagem;
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

    public int getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(int porcentagem) {
        this.porcentagem = porcentagem;
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
        this.porcentagem = 30;
        this.semestre = 5;
    }
}
