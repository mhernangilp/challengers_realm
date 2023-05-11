
package MetProg;

import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;


public class HistorialTest {
    
    public HistorialTest() {
    }

    @Test
    public void testGetUsuarioDesafiante() {
        int[] esbirrosSinDerrotar = new int[2];
        esbirrosSinDerrotar[0] = 0;
        esbirrosSinDerrotar[1] = 1;
        Historial instance = new Historial("Desafiante", "Desafiado", 10, "Vencedor", esbirrosSinDerrotar, 200);
        String expResult = "Desafiante";
        String result = instance.getUsuarioDesafiante();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetUsuarioDesafiado() {
        int[] esbirrosSinDerrotar = new int[2];
        esbirrosSinDerrotar[0] = 0;
        esbirrosSinDerrotar[1] = 1;
        Historial instance = new Historial("Desafiante", "Desafiado", 10, "Vencedor", esbirrosSinDerrotar, 200);
        String expResult = "Desafiado";
        String result = instance.getUsuarioDesafiado();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetRondasEmpleadas() {
        int[] esbirrosSinDerrotar = new int[2];
        esbirrosSinDerrotar[0] = 0;
        esbirrosSinDerrotar[1] = 1;
        Historial instance = new Historial("Desafiante", "Desafiado", 10, "Vencedor", esbirrosSinDerrotar, 200);
        Integer expResult = 10;
        Integer result = instance.getRondasEmpleadas();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetUsuarioVencedor() {
        int[] esbirrosSinDerrotar = new int[2];
        esbirrosSinDerrotar[0] = 0;
        esbirrosSinDerrotar[1] = 1;
        Historial instance = new Historial("Desafiante", "Desafiado", 10, "Vencedor", esbirrosSinDerrotar, 200);
        String expResult = "Vencedor";
        String result = instance.getUsuarioVencedor();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetEsbirroSinDerrotar() {
        int[] esbirrosSinDerrotar = new int[2];
        esbirrosSinDerrotar[0] = 0;
        esbirrosSinDerrotar[1] = 1;
        Historial instance = new Historial("Desafiante", "Desafiado", 10, "Vencedor", esbirrosSinDerrotar, 200);
        int[] expResult = esbirrosSinDerrotar;
        int[] result = instance.getEsbirroSinDerrotar();
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testGetOroGanado() {
        int[] esbirrosSinDerrotar = new int[2];
        esbirrosSinDerrotar[0] = 0;
        esbirrosSinDerrotar[1] = 1;
        Historial instance = new Historial("Desafiante", "Desafiado", 10, "Vencedor", esbirrosSinDerrotar, 200);
        long expResult = 200;
        long result = instance.getOroGanado();
        assertEquals(expResult, result);
    }

    @Test
    public void testIsVisto() {
        int[] esbirrosSinDerrotar = new int[2];
        esbirrosSinDerrotar[0] = 0;
        esbirrosSinDerrotar[1] = 1;
        Historial instance = new Historial("Desafiante", "Desafiado", 10, "Vencedor", esbirrosSinDerrotar, 200);
        boolean result = instance.isVisto();
        assertFalse(result);
        instance.ver();
        result = instance.isVisto();
        assertTrue(result);
    }

    @Test
    public void testVer() {
        int[] esbirrosSinDerrotar = new int[2];
        esbirrosSinDerrotar[0] = 0;
        esbirrosSinDerrotar[1] = 1;
        Historial instance = new Historial("Desafiante", "Desafiado", 10, "Vencedor", esbirrosSinDerrotar, 200);
        boolean result = instance.isVisto();
        assertFalse(result);
        instance.ver();
        result = instance.isVisto();
        assertTrue(result);
    }
    
}
