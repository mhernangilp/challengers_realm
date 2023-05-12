package MetProg;

import java.util.ArrayList;
import java.util.HashMap;
import org.junit.Test;
import static org.junit.Assert.*;


public class CazadorTest {
    
    public CazadorTest() {
    }

    @Test
    public void testGetVoluntad() {
                    Habilidad habilidad3 = new Talento("Talento", 1, 2);
            HashMap<String,Arma> armas3 = new HashMap<String,Arma>();
            Arma arma31 = new Arma("La temida BK", 3, 3, 1);
            Arma arma32 = new Arma("Hacha naranja", 3, 1, 0.5);
            Arma arma33 = new Arma("Espada que cae de canto", 2, 0, 0.5);
            armas3.put("La temida BK", arma31);
            armas3.put("Hacha naranja", arma32);
            armas3.put("Espada que cae de canto", arma33);
            
            HashMap<String,Armadura> armaduras3 = new HashMap<String,Armadura>();
            Armadura armadura31 = new Armadura("Brazaletes de Zeus", 0, 1);
            Armadura armadura32 = new Armadura("Camiseta del lol", 2, 3);
            Armadura armadura33 = new Armadura("Pechera de diamante", 1, 3);
            armaduras3.put("Brazaletes de Zeus", armadura31);
            armaduras3.put("Camiseta del lol", armadura32);
            armaduras3.put("Pechera de diamante", armadura33);
            
            ArrayList<Esbirro> esbirros3 = new ArrayList<Esbirro>();
            Esbirro esbirro31 = new Ghoul(2, "Marcos", 2);
            Esbirro esbirro32 = new Humano(2, "David", 1);
            esbirros3.add(esbirro31);
            esbirros3.add(esbirro32);
            
            ArrayList<Debilidad> debilidades3 = new ArrayList<Debilidad>();
            Debilidad debilidad31 = new Debilidad("Pequeño", 2);
            Debilidad debilidad32 = new Debilidad("Despistado", 3);
            debilidades3.add(debilidad31);
            debilidades3.add(debilidad32);
            
            ArrayList<Fortaleza> fortalezas3 = new ArrayList<Fortaleza>();
            Fortaleza fortaleza31 = new Fortaleza("Buena punteria", 3);
            Fortaleza fortaleza32 = new Fortaleza("Aguante", 2);
            fortalezas3.add(fortaleza31);
            fortalezas3.add(fortaleza32);
            
        Cazador instance = new Cazador(3, habilidad3, armas3, armaduras3, esbirros3, 4, debilidades3, fortalezas3, 3);
        Integer voluntad = 1;
        assertEquals(voluntad, instance.getVoluntad());
        instance.setVoluntad(voluntad);
    }

    @Test
    public void testSetVoluntad() {
        Integer voluntad = null;
                    Habilidad habilidad3 = new Talento("Talento", 1, 2);
            HashMap<String,Arma> armas3 = new HashMap<String,Arma>();
            Arma arma31 = new Arma("La temida BK", 3, 3, 1);
            Arma arma32 = new Arma("Hacha naranja", 3, 1, 0.5);
            Arma arma33 = new Arma("Espada que cae de canto", 2, 0, 0.5);
            armas3.put("La temida BK", arma31);
            armas3.put("Hacha naranja", arma32);
            armas3.put("Espada que cae de canto", arma33);
            
            HashMap<String,Armadura> armaduras3 = new HashMap<String,Armadura>();
            Armadura armadura31 = new Armadura("Brazaletes de Zeus", 0, 1);
            Armadura armadura32 = new Armadura("Camiseta del lol", 2, 3);
            Armadura armadura33 = new Armadura("Pechera de diamante", 1, 3);
            armaduras3.put("Brazaletes de Zeus", armadura31);
            armaduras3.put("Camiseta del lol", armadura32);
            armaduras3.put("Pechera de diamante", armadura33);
            
            ArrayList<Esbirro> esbirros3 = new ArrayList<Esbirro>();
            Esbirro esbirro31 = new Ghoul(2, "Marcos", 2);
            Esbirro esbirro32 = new Humano(2, "David", 1);
            esbirros3.add(esbirro31);
            esbirros3.add(esbirro32);
            
            ArrayList<Debilidad> debilidades3 = new ArrayList<Debilidad>();
            Debilidad debilidad31 = new Debilidad("Pequeño", 2);
            Debilidad debilidad32 = new Debilidad("Despistado", 3);
            debilidades3.add(debilidad31);
            debilidades3.add(debilidad32);
            
            ArrayList<Fortaleza> fortalezas3 = new ArrayList<Fortaleza>();
            Fortaleza fortaleza31 = new Fortaleza("Buena punteria", 3);
            Fortaleza fortaleza32 = new Fortaleza("Aguante", 2);
            fortalezas3.add(fortaleza31);
            fortalezas3.add(fortaleza32);
        Cazador instance = new Cazador(3, habilidad3, armas3, armaduras3, esbirros3, 4, debilidades3, fortalezas3, 3);
        instance.setVoluntad(voluntad);
    }
    
}
