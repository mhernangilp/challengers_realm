
package MetProg;

public class Habilidad {
    private String nombre;
    private Integer ataque;
    private Integer defensa;

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
