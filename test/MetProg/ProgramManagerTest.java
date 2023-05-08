
package MetProg;

import java.io.ByteArrayInputStream;
import org.junit.Test;


public class ProgramManagerTest {
    
    public ProgramManagerTest() {
    }

    @Test
    public void testExitPantallaInicial() throws Exception {
        String entrada = "4";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(entrada.getBytes());
        System.setIn(inputStream);
        
        ProgramManager programManager = new ProgramManager();
        programManager.pantallaInicial();
    }
    
}
