
package MetProg;

import org.junit.Test;
import static org.junit.Assert.*;


public class UsuarioTest {
    
    public UsuarioTest() {
    }

    @Test
    public void testGetNombre() {
        Usuario instance = new Usuario("Nombre", "Nick", "Pass");
        String expResult = "Nombre";
        String result = instance.getNombre();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetNick() {
        Usuario instance = new Usuario("Nombre", "Nick", "Pass");
        String expResult = "Nick";
        String result = instance.getNick();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetContraseña() {
        Usuario instance = new Usuario("Nombre", "Nick", "Pass");
        String expResult = "Pass";
        String result = instance.getContraseña();
        assertEquals(expResult, result);
    }
    
}
