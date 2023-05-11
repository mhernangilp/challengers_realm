
package MetProg;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;


public class PersonajeUsuarioTest {
    
    public PersonajeUsuarioTest() {
    }

    @Test
    public void testSetOro() {
        PersonajeUsuario instance = new PersonajeUsuario("Tipo", "Nombre");
        long oro = 200;
        assertEquals(1000, instance.getOro());
        instance.setOro(oro);
        assertEquals(oro, instance.getOro());
    }

    @Test
    public void testSetHistorial() {
        int[] esbirrosSinDerrotar = new int[2];
        esbirrosSinDerrotar[0] = 0;
        esbirrosSinDerrotar[1] = 1;
        Historial historial = new Historial("Desafiante", "Desafiado", 10, "Vencedor", esbirrosSinDerrotar, 200);
        ArrayList<Historial> historiales = new ArrayList<Historial>();
        historiales.add(historial);
        PersonajeUsuario instance = new PersonajeUsuario("Tipo", "Nombre");
        assertNotNull(instance.getHistorial());
        instance.setHistorial(historiales);
        assertNotNull(instance.getHistorial());
    }

    @Test
    public void testGetTipo() {
        PersonajeUsuario instance = new PersonajeUsuario("Tipo", "Nombre");
        String expResult = "Tipo";
        String result = instance.getTipo();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetNombre() {
        PersonajeUsuario instance = new PersonajeUsuario("Tipo", "Nombre");
        String expResult = "Nombre";
        String result = instance.getNombre();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetArmaActiva() {
        PersonajeUsuario instance = new PersonajeUsuario("Tipo", "Nombre");
        String[] expResult = new String[2];
        String[] result = instance.getArmaActiva();
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testGetArmaduraActiva() {
        PersonajeUsuario instance = new PersonajeUsuario("Tipo", "Nombre");
        String expResult = "Armadura";
        instance.setArmaduraActiva("Armadura");
        String result = instance.getArmaduraActiva();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetOro() {
        PersonajeUsuario instance = new PersonajeUsuario("Tipo", "Nombre");
        long oro = 200;
        assertEquals(1000, instance.getOro());
        instance.setOro(oro);
        assertEquals(oro, instance.getOro());
    }

    @Test
    public void testGetHistorial() {
        int[] esbirrosSinDerrotar = new int[2];
        esbirrosSinDerrotar[0] = 0;
        esbirrosSinDerrotar[1] = 1;
        Historial historial = new Historial("Desafiante", "Desafiado", 10, "Vencedor", esbirrosSinDerrotar, 200);
        ArrayList<Historial> historiales = new ArrayList<Historial>();
        historiales.add(historial);
        PersonajeUsuario instance = new PersonajeUsuario("Tipo", "Nombre");
        assertNotNull(instance.getHistorial());
        instance.setHistorial(historiales);
        assertNotNull(instance.getHistorial());
    }

    @Test
    public void testSetArmaduraActiva() {
        PersonajeUsuario instance = new PersonajeUsuario("Tipo", "Nombre");
        String expResult = "Armadura";
        assertNull(instance.getArmaduraActiva());
        instance.setArmaduraActiva("Armadura");
        String result = instance.getArmaduraActiva();
        assertEquals(expResult, result);
    }

    @Test
    public void testActualizarOro() {
        long valor = 200;
        PersonajeUsuario instance = new PersonajeUsuario("Tipo", "Nombre");
        assertEquals(1000, instance.getOro());
        instance.actualizarOro(valor);
        assertEquals(1200, instance.getOro());
        instance.actualizarOro(-valor);
        assertEquals(1000, instance.getOro());
        instance.actualizarOro(-valor);
        assertEquals(800, instance.getOro());
    }
    
}
