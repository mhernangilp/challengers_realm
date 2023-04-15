
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
}
