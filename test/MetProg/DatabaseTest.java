
package MetProg;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

public class DatabaseTest {
    private ProgramManager PM = new ProgramManager();
    private Database data;
    
    public DatabaseTest() throws IOException, FileNotFoundException, ClassNotFoundException {
        data = PM.loadData();
    }

    @Test
    public void testPedirPersonaje(){
        Personaje personaje = data.getPersonaje(0);
        
        assertEquals(personaje.getClass(), Vampiro.class);
        
        personaje = data.getPersonaje(1);
        
        assertEquals(personaje.getClass(), Licantropo.class);
        
        personaje = data.getPersonaje(2);
        
        assertEquals(personaje.getClass(), Cazador.class);
    }

    @Test
    public void testSaveData() throws Exception {
        data.saveData();
    }

    @Test
    public void testInicializarPersonajes() {
        Database database = new Database();
        database.inicializarPersonajes();
        
        Personaje personaje = database.getPersonaje(0);
        
        assertEquals(personaje.getClass(), Vampiro.class);
        
        personaje = database.getPersonaje(1);
        
        assertEquals(personaje.getClass(), Licantropo.class);
        
        personaje = database.getPersonaje(2);
        
        assertEquals(personaje.getClass(), Cazador.class);
    }

    @Test
    public void testEliminarUsuario() {
        assertNotNull(data.getUsuarioByNick("Juan777"));
        
        data.eliminarUsuario("Juan777");
        
        assertNull(data.getUsuarioByNick("Juan777"));
    }

    @Test
    public void testAñadirUsuario() {
        Usuario user = new Usuario("Pablo", "Pablo777", "Pablo2003");
        assertNull(data.getUsuarioByNick("Pablo777"));
        data.añadirUsuario(user);
        assertNotNull(data.getUsuarioByNick("Pablo777"));
    }

    @Test
    public void testGetPosDesafio() {
        assertNotNull(data.getPosDesafio("Juan777"));
        assertEquals(-1, data.getPosDesafio("Esta pesona no existe"));
    }

    @Test
    public void testEliminarDesafio() {
        Desafio desafio = data.getDesafios().get(data.getPosDesafio("Juan777"));
        assertNotEquals(-1, data.getPosDesafio("Juan777"));
        data.eliminarDesafio(desafio);
        assertEquals(-1, data.getPosDesafio("Juan777"));
    }

    @Test
    public void testGetUsuarioByNick() {
        assertNotNull(data.getUsuarioByNick("Juan777"));
        assertNotNull(data.getUsuarioByNick("Jose777"));
        assertNotNull(data.getUsuarioByNick("Alberto777"));
        assertNull(data.getUsuarioByNick("Este usuario no existe"));
    }

    @Test
    public void testCheckNick() {
        assertTrue(data.checkNick("Juan777"));
        assertTrue(data.checkNick("Jose777"));
        assertTrue(data.checkNick("Alberto777"));
        assertFalse(data.checkNick("Este usuario no existe"));
    }

    @Test
    public void testCheckNumReg() {
        assertTrue(data.checkNumReg("F78HL"));
        assertTrue(data.checkNumReg("D80FH"));
        assertTrue(data.checkNumReg("A30QG"));
        assertFalse(data.checkNumReg("DASJKHD342ADASD"));
    }

    @Test
    public void testCheckNickPass() {
        assertTrue(data.checkNickPass("Juan777", "Juan2003"));
        assertTrue(data.checkNickPass("Jose777", "Jose2003"));
        assertTrue(data.checkNickPass("Alberto777", "Alberto2003"));
        assertFalse(data.checkNickPass("Juan777", "Alberto2003"));
        assertFalse(data.checkNickPass("Alberto777", "Jose2003"));
    }
    
}
