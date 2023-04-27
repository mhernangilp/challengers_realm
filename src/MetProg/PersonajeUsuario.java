
package MetProg;

import java.io.Serializable;
import java.util.ArrayList;

public class PersonajeUsuario implements Serializable{
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

    public void setOro(long oro) {
        this.oro = oro;
    }

    public void setHistorial(ArrayList<Historial> historial) {
        this.historial = historial;
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
    
    public void actualizarOro(long valor) {
        this.oro += valor;
    }
    
    
}
