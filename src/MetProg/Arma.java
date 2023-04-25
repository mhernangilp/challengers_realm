
package MetProg;

import java.io.Serializable;

public class Arma implements Serializable{
    private String nombre;
    private Integer modifAtaque;
    private Integer modifDefensa;
    private double peso;

    public Arma(String nombre, Integer modifAtaque, Integer modifDefensa, double peso) {
        this.nombre = nombre;
        this.modifAtaque = modifAtaque;
        this.modifDefensa = modifDefensa;
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getModifAtaque() {
        return modifAtaque;
    }

    public Integer getModifDefensa() {
        return modifDefensa;
    }

    public double getPeso() {
        return peso;
    }
    
    
}
