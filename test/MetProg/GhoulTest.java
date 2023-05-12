package MetProg;

import org.junit.Test;
import static org.junit.Assert.*;


public class GhoulTest {
    
    public GhoulTest() {
    }

    @Test
    public void testGetDependencia() {
        Ghoul instance = null; //ver que instancia es
        Integer expResult = null;  //ver el tipo de resultado esperado
        Integer result = instance.getDependencia();
        assertEquals(expResult, result);
    }
}
