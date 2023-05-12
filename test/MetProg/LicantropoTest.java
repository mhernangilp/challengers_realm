package MetProg;

import org.junit.Test;
import static org.junit.Assert.*;


public class LicantropoTest {
    
    public LicantropoTest() {
    }

    @Test
    public void testGetRabia() {
        Licantropo instance = null; //ver tipo de instancia
        Integer expResult = 1;  
        Integer result = instance.getRabia();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetRabia() {
        Integer rabia = 1; 
        Licantropo instance = null; //ver tipo de instancia
        instance.setRabia(rabia);
    }
    
}
