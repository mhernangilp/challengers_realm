
package MetProg;

import java.util.ArrayList;
import java.util.HashMap;

public class Personaje {
    private Habilidad habilidad;
    private HashMap<String, Arma> armas;
    private HashMap<String, Armadura> armaduras;
    private ArrayList<Esbirro> esbirros;
    private Integer salud;
    private ArrayList<Debilidad> debilidades;
    private ArrayList<Fortaleza> fortalezas;

    public Personaje(Habilidad habilidad, HashMap<String, Arma> armas, HashMap<String, Armadura> armaduras, ArrayList<Esbirro> esbirros, Integer salud, ArrayList<Debilidad> debilidades, ArrayList<Fortaleza> fortalezas) {
        this.habilidad = habilidad;
        this.armas = armas;
        this.armaduras = armaduras;
        this.esbirros = esbirros;
        this.salud = salud;
        this.debilidades = debilidades;
        this.fortalezas = fortalezas;
    }
    
    
}
