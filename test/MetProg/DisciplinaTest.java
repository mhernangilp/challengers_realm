
package MetProg;

import org.junit.Test;
import static org.junit.Assert.*;


public class DisciplinaTest {
    
    public DisciplinaTest() {
    }

    @Test
    public void testGetCosteSangre() {
        Disciplina instance = new Disciplina(2, "Disciplina", 2, 1);
        Integer expResult = 2;
        Integer result = instance.getCosteSangre();
        assertEquals(expResult, result);
    }
    
}
