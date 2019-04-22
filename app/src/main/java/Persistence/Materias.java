package Persistence;

import java.util.ArrayList;
import java.util.List;

public class Materias {
    private List<String> exatas = new ArrayList<>();
    private List<String> humanas = new ArrayList<>();
    private List<String> saude = new ArrayList<>();
    private List<String> linguas = new ArrayList<>();

    public Materias() {
        popula();
    }

    public String getExatas(int i) {
        return exatas.get(i);
    }

    public void setExatas(String exatas) {
        this.exatas.add(exatas);
    }

    public String getHumanas(int i) {
        return humanas.get(i);
    }

    public void setHumanas(String humanas) {
        this.humanas.add(humanas);
    }

    public String getSaude(int i) {
        return saude.get(i);
    }

    public void setSaude(String saude) {
        this.saude.add(saude);
    }

    public String getLinguas(int i) {
        return linguas.get(i);
    }

    public void setLinguas(String linguas) {
        this.linguas.add(linguas);
    }

    public void popula(){
        humanas.add("Saudação ao sol");
        humanas.add("Principios de greve");
        humanas.add("Arte de missangas");

        linguas.add("Ingles");
        linguas.add("Mandarim");
        linguas.add("Espanhol");

        exatas.add("Fisica");
        exatas.add("Matematica");
        exatas.add("Computação");

        saude.add("Bomba quimica");
        saude.add("Atestado");
        saude.add("Culinaria");
    }
}
