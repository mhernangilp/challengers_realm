
package MetProg;

import java.io.Serializable;

public class Fortaleza implements Serializable{
    private String nombre;
    private Integer valor;

    // Fortaleza implementará Serializable para guardar sus datos en ficheros, tendrá un nombre y un valor que dará fuerza al personaje correspondiente
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
