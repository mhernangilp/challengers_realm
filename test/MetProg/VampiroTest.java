package MetProg;

import org.junit.Test;
import static org.junit.Assert.*;


public class VampiroTest {
    
    public VampiroTest() {
    }

    @Test
    public void testSetEdad() {
        Integer edad = 100;
        Vampiro instance = null; //ver instancia Vampiro
        instance.setEdad(edad);
    }

    @Test
    public void testSetPuntosSangre() {
        Integer puntosSangre = 5;
        Vampiro instance = null; //ver instancia Vampiro
        instance.setPuntosSangre(puntosSangre);
    }

    @Test
    public void testGetEdad() {
        Vampiro instance = null; //ver instancia Vampiro
        Integer expResult = 100;
        Integer result = instance.getEdad();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetPuntosSangre() {
        Vampiro instance = null; //ver instancia Vampiro
        Integer expResult = 5;
        Integer result = instance.getPuntosSangre();
        assertEquals(expResult, result);
    }
    
}
