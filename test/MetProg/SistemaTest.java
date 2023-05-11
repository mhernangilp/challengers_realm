
package MetProg;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.junit.Test;

public class SistemaTest {
    private ProgramManager PM = new ProgramManager();
    private Database data;
    
    public SistemaTest() throws IOException, FileNotFoundException, ClassNotFoundException {
        data = PM.loadData();
    }

    @Test
    public void testLogIn() throws Exception {
        String[] entradas = {"Juan777","Juan2003", "1", "Jose777","Jose2003", "1", "Alberto777","Alberto2003", "1"};
        String input = String.join(System.lineSeparator(), entradas) + System.lineSeparator();
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        
        Sistema instance = new Sistema();
        instance.logIn(data);
    }

    @Test
    public void testRegistro() throws Exception {
        String[] entradas = {"1", "Lucia", "Lucia777", "Lucia2003"};
        String input = String.join(System.lineSeparator(), entradas) + System.lineSeparator();
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        
        Sistema instance = new Sistema();
        instance.registro(data);
        
        String[] entradas2 = {"Lucia777", "Lucia2003", "1"};
        String input2 = String.join(System.lineSeparator(), entradas) + System.lineSeparator();
        InputStream in2 = new ByteArrayInputStream(input.getBytes());
        System.setIn(in2);
        instance.logIn(data);
    }

    @Test
    public void testDarDeBaja() throws Exception {
        String[] entradas = {"Lucia777", "Lucia2003"};
        String input = String.join(System.lineSeparator(), entradas) + System.lineSeparator();
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        
        Sistema instance = new Sistema();
        instance.darDeBaja(data);
        
        String[] entradas2 = {"Lucia777", "Lucia2003", "1"};
        String input2 = String.join(System.lineSeparator(), entradas) + System.lineSeparator();
        InputStream in2 = new ByteArrayInputStream(input.getBytes());
        System.setIn(in2);
        instance.logIn(data);
    }
    
}
