/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package MetProg;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author marky
 */
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
        String[] entradas = {"1", "Lucia", "Lucia777","Lucia2003"};
        String input = String.join(System.lineSeparator(), entradas) + System.lineSeparator();
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        
        Sistema instance = new Sistema();
        instance.registro(data);
    }

    @Test
    public void testDarDeBaja() {
        String[] entradas = {"Lucia777", "Lucia2003"};
        String input = String.join(System.lineSeparator(), entradas) + System.lineSeparator();
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        
        Sistema instance = new Sistema();
        instance.darDeBaja(data);
    }
    
}
