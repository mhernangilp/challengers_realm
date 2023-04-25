
package MetProg;

import java.io.Serializable;

public class Esbirro implements Serializable{
    private String nombre;
    private Integer salud;

    public Esbirro(String nombre, Integer salud) {
        this.nombre = nombre;
        this.salud = salud;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getSalud() {
        return salud;
    }
    
    
    
    
}
