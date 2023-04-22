
package MetProg;

import java.util.ArrayList;
import java.util.HashMap;

public class Vampiro extends Personaje{
    private Integer edad;
    private Integer puntosSangre;

    public Vampiro(Integer edad, Integer puntosSangre, Habilidad habilidad, HashMap<String, Arma> armas, HashMap<String, Armadura> armaduras, ArrayList<Esbirro> esbirros, Integer salud, ArrayList<Debilidad> debilidades, ArrayList<Fortaleza> fortalezas, Integer poder) {
        super(habilidad, armas, armaduras, esbirros, salud, debilidades, fortalezas, poder);
        this.edad = edad;
        this.puntosSangre = puntosSangre;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public void setPuntosSangre(Integer puntosSangre) {
        this.puntosSangre = puntosSangre;
    }

    public Integer getEdad() {
        return edad;
    }

    public Integer getPuntosSangre() {
        return puntosSangre;
    }
    
    
}
