
package MetProg;

public class Armadura {
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
    
    
}
