
package MetProg;

public class Humano extends Esbirro{
    private Integer lealtad;

    public Humano(Integer lealtad, String nombre, Integer salud) {
        super(nombre, salud);
        this.lealtad = lealtad;
    }
    
    
}
