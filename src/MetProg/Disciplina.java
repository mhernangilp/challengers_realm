
package MetProg;

public class Disciplina extends Habilidad{
    private Integer costeSangre;

    // Una disciplina heredará de habilidad, y añadirá un coste de sangre (será la habilidad del vampiro)
    public Disciplina(Integer costeSangre, String nombre, Integer ataque, Integer defensa) {
        super(nombre, ataque, defensa);
        this.costeSangre = costeSangre;
    }

    public Integer getCosteSangre() {
        return costeSangre;
    }
    
    
}
