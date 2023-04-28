
package MetProg;

import java.util.ArrayList;
import java.util.HashMap;

public class Licantropo extends Personaje{
    private Integer rabia;

    // El Licantropo heredará de Personaje, tendrá un valor de rabia que usará para usar su habilidad
    public Licantropo(Integer rabia, Habilidad habilidad, HashMap<String, Arma> armas, HashMap<String, Armadura> armaduras, ArrayList<Esbirro> esbirros, Integer salud, ArrayList<Debilidad> debilidades, ArrayList<Fortaleza> fortalezas, Integer poder) {
        super(habilidad, armas, armaduras, esbirros, salud, debilidades, fortalezas, poder);
        this.rabia = rabia;
    }

    public Integer getRabia() {
        return rabia;
    }

    public void setRabia(Integer rabia) {
        this.rabia = rabia;
    }
    
    
}
