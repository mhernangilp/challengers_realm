
package MetProg;

import org.junit.Test;
import static org.junit.Assert.*;


public class ProgramManagerTest {
    
    public ProgramManagerTest() {
    }

    @Test
    public void testPantallaInicial() throws Exception {
        System.out.println("pantallaInicial");
        ProgramManager instance = new ProgramManager();
        instance.pantallaInicial();
        fail("The test case is a prototype.");
    }

    @Test
    public void testLoadData() throws Exception {
        Database data;
        ProgramManager instance = new ProgramManager();
        
        data = instance.loadData();
    }
    
}
