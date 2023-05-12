
package MetProg;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class CombateTest {
    private Combate combate;
    private Database database;
    private Desafio desafio;
    private Usuario uDesafiante;
    private Usuario uDesafiado;
    
    public CombateTest() throws IOException, FileNotFoundException, ClassNotFoundException {
        ProgramManager pm = new ProgramManager();
        this.database = pm.loadData();
        
        //this.database = new Database();
        
        //this.uDesafiante = new Usuario("joe", "joe", "123");
        //this.uDesafiado = new Usuario("pol", "pol", "123");
        
        //database.añadirUsuario(uDesafiante);
        //database.añadirUsuario(uDesafiado);
        
        this.combate = new Combate();
        ArrayList<Debilidad> debDesafiante = new ArrayList<Debilidad>();
        ArrayList<Fortaleza> fortDesafiante = new ArrayList<Fortaleza>();
        
        ArrayList<Debilidad> debDesafiado = new ArrayList<Debilidad>();
        ArrayList<Fortaleza> fortDesafiado = new ArrayList<Fortaleza>();
        
        this.desafio = new Desafio("Juan777", debDesafiante, fortDesafiante, "Jose777", debDesafiado, fortDesafiado, 230);
    }
    
    @Test
    public void testRecorrerEsbirros() throws Exception {
        Cliente c = (Cliente) database.getUsuarioByNick(desafio.getDesafiante());
        Personaje pj = (Personaje) database.pedirPersonaje((c).getPersonaje().getTipo());
        ArrayList<Esbirro> esbirros = pj.getEsbirros();

        int saludInicial = 5;
        int resultado = combate.recorrerEsbirros(esbirros, saludInicial);

        assertEquals(13, resultado);
    }
    
    @Test
    public void testActualizarSalud() {
        int[] salud = {5,2};
        combate.actualizarSalud(salud, -1);
        assertEquals(1, salud[1]);
    }
    
    @Test
    public void testRechazarCombate() {
        Cliente cDesafiado = (Cliente) database.getUsuarioByNick(desafio.getDesafiado());
        PersonajeUsuario pjDesafiado = cDesafiado.getPersonaje();
        long oroAntiguo = pjDesafiado.getOro();
        combate.rechazarCombate(database, desafio);
        assertEquals(oroAntiguo - desafio.getOroApostado() + 207, pjDesafiado.getOro());
    }

    @Test
    public void testAceptarCombate() throws Exception {
        System.out.println("aceptarCombate");
                
        // Redirigir la salida estándar a un flujo de salida diferente
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        // Llamar al método que imprime por pantalla
        String entrada = "no";
        String input = String.join(System.lineSeparator(), entrada);
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        combate.aceptarCombate(database, desafio);

        // Capturar la salida impresa
        String salidaPantalla = outputStream.toString();

        // Restaurar la salida estándar
        System.setOut(System.out);

        // Dividir las impresiones por línea
        String[] lineas = salidaPantalla.split(System.lineSeparator());

        // Obtener la última línea de impresión
        String ultimaLinea = lineas[lineas.length - 1];

        // Realizar la comprobación
        Assert.assertEquals("HA GANADO EL DESAFIANTE (J1), FELICIDADES!!", ultimaLinea.trim());
                
    }
    
}
