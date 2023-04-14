
package MetProg;

import java.util.ArrayList;
import java.util.HashMap;

public class Licantropo extends Personaje{
    private Integer rabia;

    public Licantropo(Integer rabia, Habilidad habilidad, HashMap<String, Arma> armas, HashMap<String, Armadura> armaduras, ArrayList<Esbirro> esbirros, Integer salud, ArrayList<Debilidad> debilidades, ArrayList<Fortaleza> fortalezas) {
        super(habilidad, armas, armaduras, esbirros, salud, debilidades, fortalezas);
        this.rabia = rabia;
    }
    
    
}
