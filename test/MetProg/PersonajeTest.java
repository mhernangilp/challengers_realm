
package MetProg;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class PersonajeTest {
    private Habilidad habilidad;
    private HashMap<String, Arma> armas;
    private HashMap<String, Armadura> armaduras;
    private ArrayList<Esbirro> esbirros;
    private Integer salud;
    private ArrayList<Debilidad> debilidades;
    private ArrayList<Fortaleza> fortalezas;
    private Integer poder;
    private Personaje personaje;
    
    @Before
    public void setUp() {
        habilidad = new Habilidad("ataque", 2, 3);
        armas = new HashMap<String, Arma>();
        armas.put("espada", new Arma("espada", 2, 1, 1));
        armaduras = new HashMap<String, Armadura>();
        esbirros = new ArrayList<Esbirro>();
        salud = 100;
        debilidades = new ArrayList<Debilidad>();
        fortalezas = new ArrayList<Fortaleza>();
        poder = 50;
        personaje = new Personaje(habilidad, armas, armaduras, esbirros, salud, debilidades, fortalezas, poder);
    }
    
    @Test
    public void testGetPoder() {
        assertEquals(poder, personaje.getPoder());
    }
    
    @Test
    public void testGetHabilidad() {
        assertEquals(habilidad, personaje.getHabilidad());
    }
    
    @Test
    public void testGetArmas() {
        assertEquals(armas, personaje.getArmas());
    }
    
    @Test
    public void testGetArmaduras() {
        assertEquals(armaduras, personaje.getArmaduras());
    }
    
    @Test
    public void testGetEsbirros() {
        assertEquals(esbirros, personaje.getEsbirros());
    }
    
    @Test
    public void testGetSalud() {
        assertEquals(salud, personaje.getSalud());
    }
    
    @Test
    public void testGetDebilidades() {
        assertEquals(debilidades, personaje.getDebilidades());
    }
    
    @Test
    public void testGetFortalezas() {
        assertEquals(fortalezas, personaje.getFortalezas());
    }
    
  
    public void testAnandirArma(){
        Arma arma = new Arma("Espada", 2, 1, 1);
        personaje.getArmas().put("Espada", arma);
        assertEquals(arma, personaje.getArmas().get("Espada"));
        assertEquals(1, personaje.getArmas().size());
        assertTrue(personaje.getArmas().containsKey("Espada"));
   
    }
    
    public void testEliminarArma(){
        personaje.getArmas().remove("Espada");
        assertNull(personaje.getArmas().get("Espada"));
        assertEquals(0, personaje.getArmaduras().size());
      
    }
    
    public void testModificarArma(){
        Arma arma = new Arma("Espada", 2, 1, 1);
        personaje.getArmas().put("Espada", arma);
        Arma nuevarma = new Arma("NuevaEspada", 2, 2, 2);
        personaje.getArmas().remove("Espada");
        personaje.getArmas().put("NuevaEspada",nuevarma);
        assertEquals(1, personaje.getArmas().size());
        assertNull(personaje.getArmas().get("Espada"));
        assertNotNull(personaje.getArmas().get("NuevaEspada"));
        
       
    
    }
       public void testAnandirArmadura(){
        Armadura armadura = new Armadura("Armadura", 1, 1);
        personaje.getArmaduras().put("Armadura", armadura);
        assertEquals(armadura, personaje.getArmaduras().get("Armadura"));
        assertEquals(1, personaje.getArmaduras().size());
        assertTrue(personaje.getArmaduras().containsKey("Armadura"));
       
    }
    
    public void testEliminarArmadura(){
        personaje.getArmaduras().remove("Armadura");
        assertNull(personaje.getArmaduras().get("Armadura"));
        assertEquals(0, personaje.getArmaduras().size());
            
          
    }
    
    public void testModificarArmadura(){
        Armadura armadura = new Armadura("Armadura", 1, 1);
        personaje.getArmaduras().put("Armadura", armadura);
        Armadura nuevarmadura = new Armadura("NuevaArmadura", 3, 3);
        personaje.getArmaduras().remove("Armadura");
        personaje.getArmaduras().put("NuevaArmadura",nuevarmadura);
        assertEquals(1, personaje.getArmaduras().size());
        assertNull(personaje.getArmaduras().get("Armadura"));
        assertNotNull(personaje.getArmas().get("NuevaArmadura"));
        
    
    }
    
    public void testModificarHabilidad() {
        Vampiro vampiro = new Vampiro(25, 5, new Disciplina(2, "Dominación", 2, 1), armas, armaduras, esbirros, salud, debilidades, fortalezas, poder);
        Database data = new Database();
        vampiro.modificarHabilidades(vampiro, data);
        assertEquals("Dominacion", vampiro.getHabilidad().getNombre());

        
       

}
    public void testModificarSalud(){
        String input = "4\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
       
        personaje.modificarSalud(personaje);
       
   
    }
    public void testAniadirEsbirros (){
        Esbirro esbirro = new Esbirro("JoseFrancisco", 2);
        personaje.getEsbirros().add(esbirro);
        assertEquals(1, personaje.getEsbirros().size());
        assertTrue(personaje.getEsbirros().contains(esbirro));
    
    }
    
    public void testBorrarEsbirro (){
     
        personaje.getEsbirros().remove("JoseFrancisco");
        assertNull(personaje.getEsbirros().get(0));
        assertEquals(0, personaje.getEsbirros().size());
        
    
  
    }
    public void testModificarEsbirro(){
        Esbirro esbirro = new Esbirro("JoseFrancisco", 2);
        personaje.getEsbirros().add(esbirro);
        Esbirro nuevoEsbirro = new Esbirro("JoseLuis", 1);
        personaje.getEsbirros().remove("JoseFrancisco");
        personaje.getEsbirros().add(nuevoEsbirro);
        assertEquals(1, personaje.getEsbirros().size());
    }
    
    
    
    
    
     public void testAniadirFortaleza (){
        Fortaleza fortaleza = new Fortaleza("Fortaleza1", 2);
        personaje.getFortalezas().add(fortaleza);
        assertEquals(1, personaje.getFortalezas().size());
        assertTrue(personaje.getFortalezas().contains(fortaleza));
    
    }
    
     
     
    public void testBorrarFortaleza (){
     
        personaje.getFortalezas().remove("Fortaleza1");
        assertNull(personaje.getFortalezas().get(0));
        assertEquals(0, personaje.getFortalezas().size());
        
    
  
    }
    
      public void testModificarFortaleza(){
        Fortaleza fortaleza = new Fortaleza("Fortaleza2", 3);
        personaje.getFortalezas().add(fortaleza);
        Fortaleza nuevaFortaleza = new Fortaleza("Fortaleza3", 1);
        personaje.getFortalezas().remove("Fortaleza2");
        personaje.getFortalezas().add(nuevaFortaleza);
        assertEquals(1, personaje.getFortalezas().size());
    }
    
    
    
     public void testAniadirDebilidad (){
        Debilidad debilidad = new Debilidad("Debilidad1", 2);
        personaje.getDebilidades().add(debilidad);
        assertEquals(1, personaje.getDebilidades().size());
        assertTrue(personaje.getDebilidades().contains(debilidad));
    
    }
    
    public void testBorrarDebilidad (){
     
        personaje.getDebilidades().remove("Debilidad1");
        assertNull(personaje.getDebilidades().get(0));
        assertEquals(0, personaje.getDebilidades().size());
        
    
  
    }
    
    public void testModificarDebilidad(){
        Debilidad debilidad = new Debilidad("Debilidad2", 3);
        personaje.getDebilidades().add(debilidad);
        Debilidad nuevaDebilidad = new Debilidad("Debilidad3", 1);
        personaje.getDebilidades().remove("Debilidad2");
        personaje.getDebilidades().add(nuevaDebilidad);
        assertEquals(1, personaje.getDebilidades().size());
        
    
    
    
    }
    
}
