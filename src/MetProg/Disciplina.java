
package MetProg;

public class Disciplina extends Habilidad{
    private Integer costeSangre;

    public Disciplina(Integer costeSangre, String nombre, Integer ataque, Integer defensa) {
        super(nombre, ataque, defensa);
        this.costeSangre = costeSangre;
    }
    
    
}
