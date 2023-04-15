
package MetProg;

public class Ghoul extends Esbirro{
    private Integer dependencia;

    public Ghoul(Integer dependencia, String nombre, Integer salud) {
        super(nombre, salud);
        this.dependencia = dependencia;
    }

    public Integer getDependencia() {
        return dependencia;
    }
    
    
}
