
package MetProg;

public class Humano extends Esbirro{
    private Integer lealtad;

    // Humano heredará de Esbirro, tendrá un valor de lealtad
    public Humano(Integer lealtad, String nombre, Integer salud) {
        super(nombre, salud);
        this.lealtad = lealtad;
    }

    public Integer getLealtad() {
        return lealtad;
    }
    
    
}
