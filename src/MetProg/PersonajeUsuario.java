
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
        this.oro = 1000;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public String[] getArmaActiva() {
        return armaActiva;
    }

    public String getArmaduraActiva() {
        return armaduraActiva;
    }

    public long getOro() {
        return oro;
    }

    public ArrayList<Historial> getHistorial() {
        return historial;
    }

    public void setArmaduraActiva(String armaduraActiva) {
        this.armaduraActiva = armaduraActiva;
    }
    
    
}
