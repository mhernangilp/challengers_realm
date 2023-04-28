
package MetProg;

public class Don extends Habilidad{
    private Integer costeRabia;

    // Don heredará de Habilidad, será el del licántropo, y tendrá un coste de rabia que dará fuerza al personaje
    public Don(Integer costeRabia, String nombre, Integer ataque, Integer defensa) {
        super(nombre, ataque, defensa);
        this.costeRabia = costeRabia;
    }

    public Integer getCosteRabia() {
        return costeRabia;
    }
    
    
}
