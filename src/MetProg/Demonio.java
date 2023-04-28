
package MetProg;

import java.util.ArrayList;

public class Demonio extends Esbirro{
    private String pacto;
    private ArrayList<Esbirro> esbirros;

    // Un Demonio heredará de Esbirro, que tendrá además un pacto y una lista de más esbirros
    public Demonio(String pacto, ArrayList<Esbirro> esbirros, String nombre, Integer salud) {
        super(nombre, salud);
        this.pacto = pacto;
        this.esbirros = esbirros;
    }

    public String getPacto() {
        return pacto;
    }

    public ArrayList<Esbirro> getEsbirros() {
        return esbirros;
    }
    
    
}
