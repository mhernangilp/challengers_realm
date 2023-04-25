
package MetProg;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Database implements Serializable{
    private ArrayList<Usuario> Usuarios = new ArrayList<Usuario>();
    private ArrayList<Desafio> desafios = new ArrayList<Desafio>();
    private Personaje[] personajes;
    
    public Object pedirPersonaje(String tipo) throws Exception {
        if (tipo.equals("Vampiro")) {
            Vampiro original = (Vampiro) personajes[0];
            Vampiro clon = new Vampiro(original.getEdad(), original.getPuntosSangre(), original.getHabilidad(), original.getArmas(), original.getArmaduras(), original.getEsbirros(), original.getSalud(), original.getDebilidades(), original.getFortalezas(), original.getPoder());
            return clon;
        }
        else if (tipo.equals("Licantropo")) {
            Licantropo original = (Licantropo) personajes[1];
            Licantropo clon = new Licantropo(original.getRabia(), original.getHabilidad(), original.getArmas(), original.getArmaduras(), original.getEsbirros(), original.getSalud(), original.getDebilidades(), original.getFortalezas(), original.getPoder());
            return clon;
        }
        else {
            Cazador original = (Cazador) personajes[2];
            Cazador clon = new Cazador(original.getVoluntad(), original.getHabilidad(), original.getArmas(), original.getArmaduras(), original.getEsbirros(), original.getSalud(), original.getDebilidades(), original.getFortalezas(), original.getPoder());
            return clon;
        }
    }
    
    public ArrayList<Usuario> getUsuarios() {
        return Usuarios;
    }

    public Personaje getPersonaje(int pos) {
        return personajes[pos];
    }

    public ArrayList<Desafio> getDesafios() {
        return desafios;
    }
    
    public void saveData() throws FileNotFoundException, IOException{
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data/database.data"));
        out.writeObject(this);
        out.close();
    }
    
    public void inicializarPersonajes(){
        if (personajes == null){
            personajes = new Personaje[3];
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
            
            personajes[0] = new Vampiro(265, 0, habilidad1, armas1, armaduras1, esbirros1, 5, debilidades1, fortalezas1, 4);
            
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
            
            personajes[1] = new Licantropo(0, habilidad2, armas2, armaduras2, esbirros2, 3, debilidades2, fortalezas2, 2);
            
            
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
            
            personajes[2] = new Cazador(3, habilidad3, armas3, armaduras3, esbirros3, 4, debilidades3, fortalezas3, 3);
        }
    }
    
    public void eliminarUsuario(String nick){
        int i = 0;
        boolean found = false;
        while (i < Usuarios.size() && found == false) {
            if (nick.equals(Usuarios.get(i).getNick())) {
                Usuarios.remove(i);
                found = true;
            }
            i = i + 1;
        }
    }
    
    public void añadirUsuario(Usuario usuario){
        Usuarios.add(usuario);
    }
    
    public int getPosDesafio(String nick){
        for (int i = 0; i < desafios.size(); i++){
            if (nick.equals(desafios.get(i).getDesafiado())){
                return (i);
            }
        }
        return (-1);
    }
    
    public void eliminarDesafio(Desafio desafio){
        desafios.remove(desafio);
    }
    
    public Usuario getUsuarioByNick(String nick) {
        int i = 0;
        boolean found = false;
        Usuario u = null;
        while (i < Usuarios.size() && found == false) {
            String nick2 = Usuarios.get(i).getNick();
            if (nick.equals(nick2)) {
                u = Usuarios.get(i);
                found = true;
            }
            i = i + 1;
        }
        return u;
    }
    
    //check if nick is in use, return true if it already exists.
    public boolean checkNick(String nick){
        for (int i = 0; i < Usuarios.size(); i++){
            if (nick.equals(Usuarios.get(i).getNick())){
                return true;
            }
        }
        return false;
    }

    //check if numReg is in use, return true if it already exists.
    public boolean checkNumReg(String numReg){
        for (int i = 0; i < Usuarios.size(); i++){
            if (Usuarios.get(i) instanceof Cliente){
                if (numReg.equals(((Cliente)Usuarios.get(i)).getNumReg())){
                    return true;
                }
            }
        }
        return false;
    }
    
    //check if the password "contraseña" is the same as the Usuario user with "nick" nick.
    public boolean checkNickPass(String nick, String contraseña){
        for (int i = 0; i < Usuarios.size(); i++){
            if (nick.equals(Usuarios.get(i).getNick())){
                if (contraseña.equals(Usuarios.get(i).getContraseña())){
                    return true;
                }
            }
        }
        return false;
    }
}
