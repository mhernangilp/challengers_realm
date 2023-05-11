
package MetProg;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.Test;
import static org.junit.Assert.*;


public class ProgramManagerTest {
    
    public ProgramManagerTest() {
    }

    @Test
    public void testPantallaInicial() throws Exception {
        String[] entradas = {"4"};
        String input = String.join(System.lineSeparator(), entradas) + System.lineSeparator();
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        
        ProgramManager instance = new ProgramManager();
        instance.pantallaInicial();
        
    }

    @Test
    public void testLoadData() throws Exception {
        Database data;
        ProgramManager instance = new ProgramManager();
        
        data = instance.loadData();
    }
    
}
