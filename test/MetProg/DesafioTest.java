
package MetProg;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

public class DesafioTest {
    
    public DesafioTest() {
    }

    @Test
    public void testSetValidado() {
        Desafio instance = new Desafio("Desafiante", null, null, "Desafiado", null, null, 200);
        assertFalse(instance.isValidado());
        instance.setValidado(true);
        assertTrue(instance.isValidado());
    }

    @Test
    public void testSetDebDesafiante() {
        ArrayList<Debilidad> debDesafiante = new ArrayList<Debilidad>();
        Debilidad debilidad11 = new Debilidad("Luz solar", 1);
        Debilidad debilidad12 = new Debilidad("Estaca", 3);
        debDesafiante.add(debilidad11);
        debDesafiante.add(debilidad12);
            
        Desafio instance = new Desafio("Deasfiante", null, null, "Desafiado", null, null, 200);
        instance.setDebDesafiante(debDesafiante);
        assertEquals(debDesafiante, instance.getDebDesafiante());
    }

    @Test
    public void testSetFortDesafiante() {
        ArrayList<Fortaleza> fortDesafiante = new ArrayList<Fortaleza>();
        Fortaleza fortaleza11 = new Fortaleza("Rayos x", 3);
        Fortaleza fortaleza12 = new Fortaleza("Vista de halcon", 2);
        fortDesafiante.add(fortaleza11);
        fortDesafiante.add(fortaleza12);
        
        
        Desafio instance = new Desafio("Desafiante", null, null, "Desafiado", null, null, 200);
        instance.setFortDesafiante(fortDesafiante);
        assertEquals(fortDesafiante, instance.getFortDesafiante());
    }

    @Test
    public void testSetDebDesafiado() {
        ArrayList<Debilidad> debDesafiado = new ArrayList<Debilidad>();
        Debilidad debilidad11 = new Debilidad("Luz solar", 1);
        Debilidad debilidad12 = new Debilidad("Estaca", 3);
        debDesafiado.add(debilidad11);
        debDesafiado.add(debilidad12);
            
        Desafio instance = new Desafio("Desafiante", null, null, "Desafiado", null, null, 200);
        instance.setDebDesafiado(debDesafiado);
        assertEquals(debDesafiado, instance.getDebDesafiado());
    }

    @Test
    public void testSetFortDesafiado() {
        ArrayList<Fortaleza> fortDesafiado = new ArrayList<Fortaleza>();
        Fortaleza fortaleza11 = new Fortaleza("Rayos x", 3);
        Fortaleza fortaleza12 = new Fortaleza("Vista de halcon", 2);
        fortDesafiado.add(fortaleza11);
        fortDesafiado.add(fortaleza12);
        
        
        Desafio instance = new Desafio("Desafiante", null, null, "Desafiado", null, null, 200);
        instance.setFortDesafiado(fortDesafiado);
        assertEquals(fortDesafiado, instance.getFortDesafiado());
    }

    @Test
    public void testIsValidado() {
        Desafio instance = new Desafio("Desafiante", null, null, "Desafiado", null, null, 200);
        assertFalse(instance.isValidado());
        instance.setValidado(true);
        assertTrue(instance.isValidado());
    }

    @Test
    public void testGetDesafiante() {
        Desafio instance = new Desafio("Desafiante", null, null, "Desafiado", null, null, 200);

        assertEquals("Desafiante", instance.getDesafiante());
    }

    @Test
    public void testGetDebDesafiante() {
        ArrayList<Debilidad> debDesafiante = new ArrayList<Debilidad>();
        Debilidad debilidad11 = new Debilidad("Luz solar", 1);
        Debilidad debilidad12 = new Debilidad("Estaca", 3);
        debDesafiante.add(debilidad11);
        debDesafiante.add(debilidad12);
            
        Desafio instance = new Desafio("Deasfiante", null, null, "Desafiado", null, null, 200);
        assertNull(instance.getDebDesafiante());
        instance.setDebDesafiante(debDesafiante);
        assertEquals(debDesafiante, instance.getDebDesafiante());
    }

    @Test
    public void testGetFortDesafiante() {
        ArrayList<Fortaleza> fortDesafiante = new ArrayList<Fortaleza>();
        Fortaleza fortaleza11 = new Fortaleza("Rayos x", 3);
        Fortaleza fortaleza12 = new Fortaleza("Vista de halcon", 2);
        fortDesafiante.add(fortaleza11);
        fortDesafiante.add(fortaleza12);
        
        
        Desafio instance = new Desafio("Desafiante", null, null, "Desafiado", null, null, 200);
        assertNull(instance.getFortDesafiante());
        instance.setFortDesafiante(fortDesafiante);
        assertEquals(fortDesafiante, instance.getFortDesafiante());
    }

    @Test
    public void testGetDesafiado() {
        Desafio instance = new Desafio("Desafiante", null, null, "Desafiado", null, null, 200);

        assertEquals("Desafiado", instance.getDesafiado());
    }

    @Test
    public void testGetDebDesafiado() {
        ArrayList<Debilidad> debDesafiado = new ArrayList<Debilidad>();
        Debilidad debilidad11 = new Debilidad("Luz solar", 1);
        Debilidad debilidad12 = new Debilidad("Estaca", 3);
        debDesafiado.add(debilidad11);
        debDesafiado.add(debilidad12);
            
        Desafio instance = new Desafio("Desafiante", null, null, "Desafiado", null, null, 200);
        assertNull(instance.getDebDesafiado());
        instance.setDebDesafiado(debDesafiado);
        assertEquals(debDesafiado, instance.getDebDesafiado());
    }

    @Test
    public void testGetFortDesafiado() {
        ArrayList<Fortaleza> fortDesafiado = new ArrayList<Fortaleza>();
        Fortaleza fortaleza11 = new Fortaleza("Rayos x", 3);
        Fortaleza fortaleza12 = new Fortaleza("Vista de halcon", 2);
        fortDesafiado.add(fortaleza11);
        fortDesafiado.add(fortaleza12);
        
        
        Desafio instance = new Desafio("Desafiante", null, null, "Desafiado", null, null, 200);
        assertNull(instance.getFortDesafiado());
        instance.setFortDesafiado(fortDesafiado);
        assertEquals(fortDesafiado, instance.getFortDesafiado());
    }

    @Test
    public void testGetOroApostado() {
        Desafio instance = new Desafio("Desafiante", null, null, "Desafiado", null, null, 200);

        assertEquals(200, instance.getOroApostado());
    }
    
}
