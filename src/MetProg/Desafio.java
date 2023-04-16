
package MetProg;

import java.util.ArrayList;

public class Desafio {
    private boolean validado;
    private String desafiante;
    private ArrayList<Debilidad> debDesafiante;
    private ArrayList<Fortaleza> fortDesafiante;
    private String desafiado;
    private ArrayList<Debilidad> debDesafiado;
    private ArrayList<Fortaleza> fortDesafiado;
    private long oroApostado;

    public Desafio(String desafiante, ArrayList<Debilidad> debDesafiante, ArrayList<Fortaleza> fortDesafiante, String desafiado, ArrayList<Debilidad> debDesafiado, ArrayList<Fortaleza> fortDesafiado, long oroApostado) {
        this.desafiante = desafiante;
        this.debDesafiante = debDesafiante;
        this.fortDesafiante = fortDesafiante;
        this.desafiado = desafiado;
        this.debDesafiado = debDesafiado;
        this.fortDesafiado = fortDesafiado;
        this.oroApostado = oroApostado;
        this.validado = false;
    }

    public void setValidado(boolean validado) {
        this.validado = validado;
    }

    public void setDebDesafiante(ArrayList<Debilidad> debDesafiante) {
        this.debDesafiante = debDesafiante;
    }

    public void setFortDesafiante(ArrayList<Fortaleza> fortDesafiante) {
        this.fortDesafiante = fortDesafiante;
    }

    public void setDebDesafiado(ArrayList<Debilidad> debDesafiado) {
        this.debDesafiado = debDesafiado;
    }

    public void setFortDesafiado(ArrayList<Fortaleza> fortDesafiado) {
        this.fortDesafiado = fortDesafiado;
    }

    public boolean isValidado() {
        return validado;
    }

    public String getDesafiante() {
        return desafiante;
    }

    public ArrayList<Debilidad> getDebDesafiante() {
        return debDesafiante;
    }

    public ArrayList<Fortaleza> getFortDesafiante() {
        return fortDesafiante;
    }

    public String getDesafiado() {
        return desafiado;
    }

    public ArrayList<Debilidad> getDebDesafiado() {
        return debDesafiado;
    }

    public ArrayList<Fortaleza> getFortDesafiado() {
        return fortDesafiado;
    }

    public long getOroApostado() {
        return oroApostado;
    }
    
    
}
