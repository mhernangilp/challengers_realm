package MetProg;

import java.util.ArrayList;
import java.util.HashMap;
import org.junit.Test;
import static org.junit.Assert.*;


public class VampiroTest {
    
    public VampiroTest() {
    }

    @Test
    public void testSetEdad() {
        Habilidad habilidad1 = new Disciplina(2, "Disciplina", 2, 1);
            
        HashMap<String,Arma> armas1 = new HashMap<String,Arma>();
        Arma arma11 = new Arma("Martillo de telefonica", 3, 2, 1);
        Arma arma12 = new Arma("Puno de rompe ralf", 2, 1, 0.5);
        Arma arma13 = new Arma("Espada de en bucle", 2, 0, 0.5);
        armas1.put("Martillo de telefonica", arma11);
        armas1.put("Puno de rompe ralf", arma12);
        armas1.put("Espada de en bucle", arma13);

        HashMap<String,Armadura> armaduras1 = new HashMap<String,Armadura>();
        Armadura armadura11 = new Armadura("Pechera de diamante", 1, 3);
        Armadura armadura12 = new Armadura("Casco de hierro", 0, 2);
        Armadura armadura13 = new Armadura("Pantalones de fuego", 2, 2);
        armaduras1.put("Pechera de diamante", armadura11);
        armaduras1.put("Casco de hierro", armadura12);
        armaduras1.put("Pantalones de fuego", armadura13);

        ArrayList<Esbirro> esbirros1 = new ArrayList<Esbirro>();
        Esbirro esbirro11 = new Ghoul(4, "Juan", 3);
        ArrayList<Esbirro> subesbirros = new ArrayList<Esbirro>();
        Esbirro subesbirro1 = new Ghoul(2, "Alberto", 2);
        Esbirro subesbirro2 = new Ghoul(3, "Jose", 1);
        subesbirros.add(subesbirro1);
        subesbirros.add(subesbirro2);
        Esbirro esbirro12 = new Demonio("Esta union es muy fuerte y nunca será rota", subesbirros, "Vicente", 2);
        esbirros1.add(esbirro11);
        esbirros1.add(esbirro12);

        ArrayList<Debilidad> debilidades1 = new ArrayList<Debilidad>();
        Debilidad debilidad11 = new Debilidad("Luz solar", 1);
        Debilidad debilidad12 = new Debilidad("Estaca", 3);
        debilidades1.add(debilidad11);
        debilidades1.add(debilidad12);

        ArrayList<Fortaleza> fortalezas1 = new ArrayList<Fortaleza>();
        Fortaleza fortaleza11 = new Fortaleza("Rayos x", 3);
        Fortaleza fortaleza12 = new Fortaleza("Vista de halcon", 2);
        fortalezas1.add(fortaleza11);
        fortalezas1.add(fortaleza12);

        Vampiro instance = new Vampiro(265, 0, habilidad1, armas1, armaduras1, esbirros1, 5, debilidades1, fortalezas1, 4);
        
        Integer edad = 100;
        Integer edadIni = 265;
        assertEquals(edadIni, instance.getEdad());
        instance.setEdad(edad);
        assertEquals(edad, instance.getEdad());
    }

    @Test
    public void testSetPuntosSangre() {
        Habilidad habilidad1 = new Disciplina(2, "Disciplina", 2, 1);
            
        HashMap<String,Arma> armas1 = new HashMap<String,Arma>();
        Arma arma11 = new Arma("Martillo de telefonica", 3, 2, 1);
        Arma arma12 = new Arma("Puno de rompe ralf", 2, 1, 0.5);
        Arma arma13 = new Arma("Espada de en bucle", 2, 0, 0.5);
        armas1.put("Martillo de telefonica", arma11);
        armas1.put("Puno de rompe ralf", arma12);
        armas1.put("Espada de en bucle", arma13);

        HashMap<String,Armadura> armaduras1 = new HashMap<String,Armadura>();
        Armadura armadura11 = new Armadura("Pechera de diamante", 1, 3);
        Armadura armadura12 = new Armadura("Casco de hierro", 0, 2);
        Armadura armadura13 = new Armadura("Pantalones de fuego", 2, 2);
        armaduras1.put("Pechera de diamante", armadura11);
        armaduras1.put("Casco de hierro", armadura12);
        armaduras1.put("Pantalones de fuego", armadura13);

        ArrayList<Esbirro> esbirros1 = new ArrayList<Esbirro>();
        Esbirro esbirro11 = new Ghoul(4, "Juan", 3);
        ArrayList<Esbirro> subesbirros = new ArrayList<Esbirro>();
        Esbirro subesbirro1 = new Ghoul(2, "Alberto", 2);
        Esbirro subesbirro2 = new Ghoul(3, "Jose", 1);
        subesbirros.add(subesbirro1);
        subesbirros.add(subesbirro2);
        Esbirro esbirro12 = new Demonio("Esta union es muy fuerte y nunca será rota", subesbirros, "Vicente", 2);
        esbirros1.add(esbirro11);
        esbirros1.add(esbirro12);

        ArrayList<Debilidad> debilidades1 = new ArrayList<Debilidad>();
        Debilidad debilidad11 = new Debilidad("Luz solar", 1);
        Debilidad debilidad12 = new Debilidad("Estaca", 3);
        debilidades1.add(debilidad11);
        debilidades1.add(debilidad12);

        ArrayList<Fortaleza> fortalezas1 = new ArrayList<Fortaleza>();
        Fortaleza fortaleza11 = new Fortaleza("Rayos x", 3);
        Fortaleza fortaleza12 = new Fortaleza("Vista de halcon", 2);
        fortalezas1.add(fortaleza11);
        fortalezas1.add(fortaleza12);

        Vampiro instance = new Vampiro(265, 0, habilidad1, armas1, armaduras1, esbirros1, 5, debilidades1, fortalezas1, 4);
        
        Integer puntosSangre = 5;
        instance.setPuntosSangre(puntosSangre);
    }

    @Test
    public void testGetEdad() {
        Habilidad habilidad1 = new Disciplina(2, "Disciplina", 2, 1);
            
        HashMap<String,Arma> armas1 = new HashMap<String,Arma>();
        Arma arma11 = new Arma("Martillo de telefonica", 3, 2, 1);
        Arma arma12 = new Arma("Puno de rompe ralf", 2, 1, 0.5);
        Arma arma13 = new Arma("Espada de en bucle", 2, 0, 0.5);
        armas1.put("Martillo de telefonica", arma11);
        armas1.put("Puno de rompe ralf", arma12);
        armas1.put("Espada de en bucle", arma13);

        HashMap<String,Armadura> armaduras1 = new HashMap<String,Armadura>();
        Armadura armadura11 = new Armadura("Pechera de diamante", 1, 3);
        Armadura armadura12 = new Armadura("Casco de hierro", 0, 2);
        Armadura armadura13 = new Armadura("Pantalones de fuego", 2, 2);
        armaduras1.put("Pechera de diamante", armadura11);
        armaduras1.put("Casco de hierro", armadura12);
        armaduras1.put("Pantalones de fuego", armadura13);

        ArrayList<Esbirro> esbirros1 = new ArrayList<Esbirro>();
        Esbirro esbirro11 = new Ghoul(4, "Juan", 3);
        ArrayList<Esbirro> subesbirros = new ArrayList<Esbirro>();
        Esbirro subesbirro1 = new Ghoul(2, "Alberto", 2);
        Esbirro subesbirro2 = new Ghoul(3, "Jose", 1);
        subesbirros.add(subesbirro1);
        subesbirros.add(subesbirro2);
        Esbirro esbirro12 = new Demonio("Esta union es muy fuerte y nunca será rota", subesbirros, "Vicente", 2);
        esbirros1.add(esbirro11);
        esbirros1.add(esbirro12);

        ArrayList<Debilidad> debilidades1 = new ArrayList<Debilidad>();
        Debilidad debilidad11 = new Debilidad("Luz solar", 1);
        Debilidad debilidad12 = new Debilidad("Estaca", 3);
        debilidades1.add(debilidad11);
        debilidades1.add(debilidad12);

        ArrayList<Fortaleza> fortalezas1 = new ArrayList<Fortaleza>();
        Fortaleza fortaleza11 = new Fortaleza("Rayos x", 3);
        Fortaleza fortaleza12 = new Fortaleza("Vista de halcon", 2);
        fortalezas1.add(fortaleza11);
        fortalezas1.add(fortaleza12);

        Vampiro instance = new Vampiro(265, 0, habilidad1, armas1, armaduras1, esbirros1, 5, debilidades1, fortalezas1, 4);
        
        Integer expResult = 100;
        Integer result = instance.getEdad();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetPuntosSangre() {
        Habilidad habilidad1 = new Disciplina(2, "Disciplina", 2, 1);
            
        HashMap<String,Arma> armas1 = new HashMap<String,Arma>();
        Arma arma11 = new Arma("Martillo de telefonica", 3, 2, 1);
        Arma arma12 = new Arma("Puno de rompe ralf", 2, 1, 0.5);
        Arma arma13 = new Arma("Espada de en bucle", 2, 0, 0.5);
        armas1.put("Martillo de telefonica", arma11);
        armas1.put("Puno de rompe ralf", arma12);
        armas1.put("Espada de en bucle", arma13);

        HashMap<String,Armadura> armaduras1 = new HashMap<String,Armadura>();
        Armadura armadura11 = new Armadura("Pechera de diamante", 1, 3);
        Armadura armadura12 = new Armadura("Casco de hierro", 0, 2);
        Armadura armadura13 = new Armadura("Pantalones de fuego", 2, 2);
        armaduras1.put("Pechera de diamante", armadura11);
        armaduras1.put("Casco de hierro", armadura12);
        armaduras1.put("Pantalones de fuego", armadura13);

        ArrayList<Esbirro> esbirros1 = new ArrayList<Esbirro>();
        Esbirro esbirro11 = new Ghoul(4, "Juan", 3);
        ArrayList<Esbirro> subesbirros = new ArrayList<Esbirro>();
        Esbirro subesbirro1 = new Ghoul(2, "Alberto", 2);
        Esbirro subesbirro2 = new Ghoul(3, "Jose", 1);
        subesbirros.add(subesbirro1);
        subesbirros.add(subesbirro2);
        Esbirro esbirro12 = new Demonio("Esta union es muy fuerte y nunca será rota", subesbirros, "Vicente", 2);
        esbirros1.add(esbirro11);
        esbirros1.add(esbirro12);

        ArrayList<Debilidad> debilidades1 = new ArrayList<Debilidad>();
        Debilidad debilidad11 = new Debilidad("Luz solar", 1);
        Debilidad debilidad12 = new Debilidad("Estaca", 3);
        debilidades1.add(debilidad11);
        debilidades1.add(debilidad12);

        ArrayList<Fortaleza> fortalezas1 = new ArrayList<Fortaleza>();
        Fortaleza fortaleza11 = new Fortaleza("Rayos x", 3);
        Fortaleza fortaleza12 = new Fortaleza("Vista de halcon", 2);
        fortalezas1.add(fortaleza11);
        fortalezas1.add(fortaleza12);

        Vampiro instance = new Vampiro(265, 0, habilidad1, armas1, armaduras1, esbirros1, 5, debilidades1, fortalezas1, 4);
        
        Integer expResult = 5;
        Integer result = instance.getPuntosSangre();
        assertEquals(expResult, result);
    }
    
}
