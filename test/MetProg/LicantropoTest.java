package MetProg;

import java.util.ArrayList;
import java.util.HashMap;
import org.junit.Test;
import static org.junit.Assert.*;


public class LicantropoTest {
    
    public LicantropoTest() {
    }

    @Test
    public void testGetRabia() {
                    Habilidad habilidad2 = new Don(3,"Don", 2, 2);
            HashMap<String,Arma> armas2 = new HashMap<String,Arma>();
            Arma arma21 = new Arma("Super vaso pitufo", 3, 2, 1);
            Arma arma22 = new Arma("Botella de el poderoso love", 1, 1, 0.5);
            Arma arma23 = new Arma("Espada de kruskal", 2, 0, 0.5);
            armas2.put("Super vaso pitufo", arma21);
            armas2.put("Botella de el poderoso love", arma22);
            armas2.put("Espada de kruskal", arma23);
            
            HashMap<String,Armadura> armaduras2 = new HashMap<String,Armadura>();
            Armadura armadura21 = new Armadura("Botas de moises", 1, 1);
            Armadura armadura22 = new Armadura("Pechera de diamante", 1, 3);
            Armadura armadura23 = new Armadura("Casco de motero", 0, 2);
            armaduras2.put("Botas de moises", armadura21);
            armaduras2.put("Pechera de diamante", armadura22);
            armaduras2.put("Casco de motero", armadura23);
            
            ArrayList<Esbirro> esbirros2 = new ArrayList<Esbirro>();
            Esbirro esbirro21 = new Humano(3, "Victor", 3);
            Esbirro esbirro22 = new Ghoul(4, "Mangel", 1);
            esbirros2.add(esbirro21);
            esbirros2.add(esbirro22);
            
            ArrayList<Debilidad> debilidades2 = new ArrayList<Debilidad>();
            Debilidad debilidad21 = new Debilidad("Barro", 1);
            Debilidad debilidad22 = new Debilidad("Presa facil", 4);
            debilidades2.add(debilidad21);
            debilidades2.add(debilidad22);
            
            ArrayList<Fortaleza> fortalezas2 = new ArrayList<Fortaleza>();
            Fortaleza fortaleza21 = new Fortaleza("Fuerza bruta", 2);
            Fortaleza fortaleza22 = new Fortaleza("Garras", 2);
            fortalezas2.add(fortaleza21);
            fortalezas2.add(fortaleza22);
        Licantropo instance = new Licantropo(0, habilidad2, armas2, armaduras2, esbirros2, 3, debilidades2, fortalezas2, 2);
        Integer rabia = 1;
        assertEquals(rabia, instance.getRabia());
        instance.setRabia(rabia);
        assertEquals(rabia, instance.getRabia());
    }

    @Test
    public void testSetRabia() {
        Integer rabia = 1;
            Habilidad habilidad2 = new Don(3,"Don", 2, 2);
            HashMap<String,Arma> armas2 = new HashMap<String,Arma>();
            Arma arma21 = new Arma("Super vaso pitufo", 3, 2, 1);
            Arma arma22 = new Arma("Botella de el poderoso love", 1, 1, 0.5);
            Arma arma23 = new Arma("Espada de kruskal", 2, 0, 0.5);
            armas2.put("Super vaso pitufo", arma21);
            armas2.put("Botella de el poderoso love", arma22);
            armas2.put("Espada de kruskal", arma23);
            
            HashMap<String,Armadura> armaduras2 = new HashMap<String,Armadura>();
            Armadura armadura21 = new Armadura("Botas de moises", 1, 1);
            Armadura armadura22 = new Armadura("Pechera de diamante", 1, 3);
            Armadura armadura23 = new Armadura("Casco de motero", 0, 2);
            armaduras2.put("Botas de moises", armadura21);
            armaduras2.put("Pechera de diamante", armadura22);
            armaduras2.put("Casco de motero", armadura23);
            
            ArrayList<Esbirro> esbirros2 = new ArrayList<Esbirro>();
            Esbirro esbirro21 = new Humano(3, "Victor", 3);
            Esbirro esbirro22 = new Ghoul(4, "Mangel", 1);
            esbirros2.add(esbirro21);
            esbirros2.add(esbirro22);
            
            ArrayList<Debilidad> debilidades2 = new ArrayList<Debilidad>();
            Debilidad debilidad21 = new Debilidad("Barro", 1);
            Debilidad debilidad22 = new Debilidad("Presa facil", 4);
            debilidades2.add(debilidad21);
            debilidades2.add(debilidad22);
            
            ArrayList<Fortaleza> fortalezas2 = new ArrayList<Fortaleza>();
            Fortaleza fortaleza21 = new Fortaleza("Fuerza bruta", 2);
            Fortaleza fortaleza22 = new Fortaleza("Garras", 2);
            fortalezas2.add(fortaleza21);
            fortalezas2.add(fortaleza22);
        Licantropo instance = new Licantropo(0, habilidad2, armas2, armaduras2, esbirros2, 3, debilidades2, fortalezas2, 2);
        instance.setRabia(rabia);
    }
    
}
