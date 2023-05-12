
package MetProg;

import org.junit.Test;
import static org.junit.Assert.*;


public class DonTest {
    
    public DonTest() {
    }

    @Test
    public void testGetCosteRabia() {
        Don instance = new Don(3,"Don", 2, 2);
        Integer expResult = 3;
        Integer result = instance.getCosteRabia();
        assertEquals(expResult, result);
    }
    
}
