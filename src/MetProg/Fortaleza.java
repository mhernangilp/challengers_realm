
package MetProg;

import java.io.Serializable;

public class Fortaleza implements Serializable{
    private String nombre;
    private Integer valor;

    public Fortaleza(String nombre, Integer valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getValor() {
        return valor;
    }
    
    
}
