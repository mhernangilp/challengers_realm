
package MetProg;

public class Ghoul extends Esbirro{
    private Integer dependencia;

    // Ghoul heredará de Esbirro, y guardará un valor de dependencia
    public Ghoul(Integer dependencia, String nombre, Integer salud) {
        super(nombre, salud);
        this.dependencia = dependencia;
    }

    public Integer getDependencia() {
        return dependencia;
    }
    
    
}
