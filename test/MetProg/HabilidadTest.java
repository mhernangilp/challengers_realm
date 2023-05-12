
package MetProg;

import org.junit.Test;
import static org.junit.Assert.*;

public class HabilidadTest {
    
    public HabilidadTest() {
    }

    @Test
    public void testGetNombre() {
        Habilidad instance = new Habilidad("Nombre", 2, 3);
        String expResult = "Nombre";
        String result = instance.getNombre();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetAtaque() {
        Habilidad instance = new Habilidad("Nombre", 2, 3);
        Integer expResult = 2;
        Integer result = instance.getAtaque();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetDefensa() {
        Habilidad instance = new Habilidad("Nombre", 2, 3);
        Integer expResult = 3;
        Integer result = instance.getDefensa();
        assertEquals(expResult, result);
    }
    
}
