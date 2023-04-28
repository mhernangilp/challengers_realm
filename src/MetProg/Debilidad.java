
package MetProg;

import java.io.Serializable;

public class Debilidad implements Serializable{
    private String nombre;
    private Integer valor;

    // Una Debilidad tendrá un nombre que lo identifique y un valor de impacto en el personaje
    public Debilidad(String nombre, Integer valor) {
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
