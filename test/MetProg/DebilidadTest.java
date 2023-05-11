
package MetProg;

import org.junit.Test;
import static org.junit.Assert.*;


public class DebilidadTest {
    
    public DebilidadTest() {
    }

    @Test
    public void testGetNombre() {
        Debilidad instance = new Debilidad("Nombre", 2);
        String expResult = "Nombre";
        String result = instance.getNombre();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetValor() {
        Debilidad instance = new Debilidad("Nombre", 2);
        Integer expResult = 2;
        Integer result = instance.getValor();
        assertEquals(expResult, result);
    }
    
}
