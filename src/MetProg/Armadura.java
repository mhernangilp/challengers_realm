
package MetProg;

import java.io.Serializable;

public class Armadura implements Serializable{
    private String nombre;
    private Integer modifAtaque;
    private Integer modifDefensa;

    public Armadura(String nombre, Integer modifAtaque, Integer modifDefensa) {
        this.nombre = nombre;
        this.modifAtaque = modifAtaque;
        this.modifDefensa = modifDefensa;
    }

    public Integer getModifAtaque() {
        return modifAtaque;
    }

    public Integer getModifDefensa() {
        return modifDefensa;
    }

    public String getNombre() {
        return nombre;
    }
    
    
}
