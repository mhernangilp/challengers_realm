
package MetProg;

import java.util.ArrayList;

public class PersonajeUsuario {
    private String tipo;
    private String nombre;
    private String[] armaActiva;
    private String armaduraActiva;
    private long oro;
    private ArrayList<Historial> historial;

    public PersonajeUsuario(String tipo, String nombre) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.armaActiva = new String[2];
        this.oro = 0;
        this.historial = new ArrayList<Historial>();
    }
}
