
package MetProg;

import java.io.Serializable;

public class Habilidad implements Serializable{
    private String nombre;
    private Integer ataque;
    private Integer defensa;

    // Habilidad será la clase padre de todas las habilidades, con un nombre que lo identifique, valor de ataque y defensa
    public Habilidad(String nombre, Integer ataque, Integer defensa) {
        this.nombre = nombre;
        this.ataque = ataque;
        this.defensa = defensa;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getAtaque() {
        return ataque;
    }

    public Integer getDefensa() {
        return defensa;
    }
    
    
}
