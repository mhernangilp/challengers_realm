
package MetProg;

import java.util.ArrayList;
import java.util.HashMap;

public class Cazador extends Personaje{
    private Integer voluntad;

    public Cazador(Integer voluntad, Habilidad habilidad, HashMap<String, Arma> armas, HashMap<String, Armadura> armaduras, ArrayList<Esbirro> esbirros, Integer salud, ArrayList<Debilidad> debilidades, ArrayList<Fortaleza> fortalezas, Integer poder) {
        super(habilidad, armas, armaduras, esbirros, salud, debilidades, fortalezas, poder);
        this.voluntad = voluntad;
    }

    public Integer getVoluntad() {
        return voluntad;
    }
    
    
}
