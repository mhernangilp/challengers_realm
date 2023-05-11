
package MetProg;

import org.junit.Test;
import static org.junit.Assert.*;

public class FortalezaTest {
    
    public FortalezaTest() {
    }

    @Test
    public void testGetNombre() {
        Fortaleza instance = new Fortaleza("Nombre", 2);
        String expResult = "Nombre";
        String result = instance.getNombre();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetValor() {
        Fortaleza instance = new Fortaleza("Nombre", 2);
        Integer expResult = 2;
        Integer result = instance.getValor();
        assertEquals(expResult, result);
    }
    
}
