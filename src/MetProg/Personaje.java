
package MetProg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Personaje {
    private Habilidad habilidad;
    private HashMap<String, Arma> armas;
    private HashMap<String, Armadura> armaduras;
    private ArrayList<Esbirro> esbirros;
    private Integer salud;
    private ArrayList<Debilidad> debilidades;
    private ArrayList<Fortaleza> fortalezas;
    private Integer poder;

    public Personaje(Habilidad habilidad, HashMap<String, Arma> armas, HashMap<String, Armadura> armaduras, ArrayList<Esbirro> esbirros, Integer salud, ArrayList<Debilidad> debilidades, ArrayList<Fortaleza> fortalezas, Integer poder) {
        this.habilidad = habilidad;
        this.armas = armas;
        this.armaduras = armaduras;
        this.esbirros = esbirros;
        this.salud = salud;
        this.debilidades = debilidades;
        this.fortalezas = fortalezas;
        this.poder = poder;
    }

    public Integer getPoder() {
        return poder;
    }

    public Habilidad getHabilidad() {
        return habilidad;
    }

    public HashMap<String, Arma> getArmas() {
        return armas;
    }

    public HashMap<String, Armadura> getArmaduras() {
        return armaduras;
    }

    public ArrayList<Esbirro> getEsbirros() {
        return esbirros;
    }

    public Integer getSalud() {
        return salud;
    }

    public ArrayList<Debilidad> getDebilidades() {
        return debilidades;
    }

    public ArrayList<Fortaleza> getFortalezas() {
        return fortalezas;
    }
    
    public void modificarArmas(){
        Scanner input = new Scanner(System.in);
        Integer opcion, modifAtaque, modifDefensa, manos;
        String nombre;
        Arma arma;
        
        do {
            System.out.println("Elija una opcion:");
            System.out.println("1.- Añadir arma");
            System.out.println("2.- Eliminar arma");
            System.out.println("3.- Modificar arma");
            System.out.println("4.- Volver");
            opcion = input.nextInt();
            input.nextLine();
            switch (opcion){
                case 1: System.out.println("Nombre del nuevo arma: ");
                        nombre = input.nextLine();
                        System.out.println("Modificador de ataque: (rango 1-3)");
                        modifAtaque = input.nextInt();
                        if (modifAtaque < 1 || modifAtaque > 3){
                            System.out.println("\n--- Valor invalido, rango 1-3 ---\n");
                            break;
                        }
                        System.out.println("Modificador de defensa: (rango 1-3)");
                        modifDefensa = input.nextInt();
                        if (modifDefensa < 1 || modifDefensa > 3){
                            System.out.println("\n--- Valor invalido, rango 1-3 ---\n");
                            break;
                        }
                        System.out.println("Manos de el arma: (1 o 2)");
                        manos = input.nextInt();
                        if (manos < 1 || manos > 2){
                            System.out.println("\n--- Valor invalido, rango 1-2 ---\n");
                            break;
                        }
                        if (manos == 1){
                            arma = new Arma(nombre, modifAtaque, modifDefensa, 0.5);
                        } else {
                            arma = new Arma(nombre, modifAtaque, modifDefensa, 1);
                        }
                        armas.put(nombre, arma);
                        System.out.println("\n--- Arma añadida correctamente ---\n");
                        break;

                case 2: System.out.println("Escriba el arma que quiere eliminar:");
                        for (Map.Entry<String, Arma> entry : armas.entrySet()){
                            System.out.println("-- '" + entry.getKey() + "':");
                            System.out.println("    Modificacion de ataque: " + entry.getValue().getModifAtaque());
                            System.out.println("    Modificacion de defesa: " + entry.getValue().getModifDefensa());
                            if (entry.getValue().getPeso() == 0.5){
                                System.out.println("    Manos: 1\n");
                            } else {
                                System.out.println("    Manos: 2\n");
                            }
                        }
                        nombre = input.nextLine();
                        if (armas.containsKey(nombre)){
                            armas.remove(nombre);
                            System.out.println("\n--- Arma eliminada correctamente ---\n");
                        } else {
                            System.out.println("Por favor escriba un nombre de arma correcto\n");
                        }
                        break;

                case 3: System.out.println("Escriba el arma que quiere modificar:");
                        for (Map.Entry<String, Arma> entry : armas.entrySet()){
                            System.out.println("-- '" + entry.getKey() + "':");
                            System.out.println("    Modificacion de ataque: " + entry.getValue().getModifAtaque());
                            System.out.println("    Modificacion de defesa: " + entry.getValue().getModifDefensa());
                            if (entry.getValue().getPeso() == 0.5){
                                System.out.println("    Manos: 1\n");
                            } else {
                                System.out.println("    Manos: 2\n");
                            }
                        }
                        nombre = input.nextLine();
                        if (armas.containsKey(nombre)){
                            String nuevoNombre;
                            
                            System.out.println("Escriba el nuevo nombre para este arma: ('N' para no modificar este valor)");
                            nuevoNombre = input.nextLine();
                            if (nuevoNombre.equals("N") || nuevoNombre.equals("n")){
                                nuevoNombre = nombre;
                            }
                            System.out.println("Escriba el nuevo valor del modificador de ataque: (rango 1-3,0 para no modificar este valor)");
                            modifAtaque = input.nextInt();
                            if (modifAtaque < 0 || modifAtaque > 3){
                                System.out.println("\n--- Valor invalido, rango 1-3 ---\n");
                                break;
                            }
                            if (modifAtaque == 0){
                                modifAtaque = armas.get(nombre).getModifAtaque();
                            }
                            System.out.println("Escriba el nuevo valor del modificador de defensa: (rango 1-3,0 para no modificar este valor)");
                            modifDefensa = input.nextInt();
                            if (modifDefensa < 0 || modifDefensa > 3){
                                System.out.println("\n--- Valor invalido, rango 1-3 ---\n");
                                break;
                            }
                            if (modifDefensa == 0){
                                modifDefensa = armas.get(nombre).getModifDefensa();
                            }
                            System.out.println("Escriba cuantas manos ocupa el nuevo arma: (rango 1-2,0 para no modificar este valor)");
                            manos = input.nextInt();
                            if (manos < 0 || manos > 2){
                                System.out.println("\n--- Valor invalido, rango 1-2 ---\n");
                                break;
                            }
                            if (manos == 0){
                                if (armas.get(nombre).getPeso() == 0.5){
                                    manos = 1;
                                } else {
                                    manos = 2;
                                }
                            }
                            if (manos == 1){
                                arma = new Arma(nuevoNombre, modifAtaque, modifDefensa, 0.5);
                            } else {
                                arma = new Arma(nuevoNombre, modifAtaque, modifDefensa, 1);
                            }
                            armas.remove(nombre);
                            armas.put(nuevoNombre, arma);
                            System.out.println("\n--- Arma modificada correctamente ---\n");
                        } else {
                            System.out.println("Por favor escriba un nombre de arma correcto\n");
                        }
                        break;

                default: break;
            }
        } while (opcion != 4);
    }
    public void modificarArmadura(){
           
        Scanner input = new Scanner(System.in);
        Integer opcion, modifAtaque, modifDefensa;
        String nombre;
        Armadura armadura;
        
        do {
            System.out.println("Elija una opcion:");
            System.out.println("1.- Añadir armadura");
            System.out.println("2.- Eliminar armadura");
            System.out.println("3.- Modificar armadura");
            System.out.println("4.- Volver");
            opcion = input.nextInt();
            input.nextLine();
            switch (opcion){
                case 1: System.out.println("Nombre de la nueva armadura: ");
                        nombre = input.nextLine();
                        System.out.println("Modificador de ataque: (rango 1-3)");
                        modifAtaque = input.nextInt();
                        if (modifAtaque < 1 || modifAtaque > 3){
                            System.out.println("\n--- Valor invalido, rango 1-3 ---\n");
                            break;
                        }
                        System.out.println("Modificador de defensa: (rango 1-3)");
                        modifDefensa = input.nextInt();
                        if (modifDefensa < 1 || modifDefensa > 3){
                            System.out.println("\n--- Valor invalido, rango 1-3 ---\n");
                            break;
                        }
                        armadura = new Armadura(nombre, modifAtaque, modifDefensa);
                        armaduras.put(nombre,armadura);
                        System.out.println("\n--- Armadura añadida correctamente ---\n");
                        break;

                case 2: System.out.println("Escriba la armadura que quiere eliminar:");
                        for (Map.Entry<String, Armadura> entry : armaduras.entrySet()){
                            System.out.println("-- '" + entry.getKey() + "':");
                            System.out.println("    Modificacion de ataque: " + entry.getValue().getModifAtaque());
                            System.out.println("    Modificacion de defesa: " + entry.getValue().getModifDefensa());
                            
                        }
                        nombre = input.nextLine();
                        if (armaduras.containsKey(nombre)){
                            armaduras.remove(nombre);
                            System.out.println("\n--- Armadura eliminada correctamente ---\n");
                        } else {
                            System.out.println("Por favor escriba un nombre de armadura correcto\n");
                        }
                        break;

                case 3: System.out.println("Escriba la armadura que quiere modificar:");
                        for (Map.Entry<String, Armadura> entry : armaduras.entrySet()){
                            System.out.println("-- '" + entry.getKey() + "':");
                            System.out.println("    Modificacion de ataque: " + entry.getValue().getModifAtaque());
                            System.out.println("    Modificacion de defesa: " + entry.getValue().getModifDefensa());
                        }
                        nombre = input.nextLine();
                        if (armaduras.containsKey(nombre)){
                            String nuevoNombre;
                            
                            System.out.println("Escriba el nuevo nombre para esta armadura: ('N' para no modificar este valor)");
                            nuevoNombre = input.nextLine();
                            if (nuevoNombre.equals("N") || nuevoNombre.equals("n")){
                                nuevoNombre = nombre;
                            }
                            System.out.println("Escriba el nuevo valor del modificador de ataque: (rango 1-3,0 para no modificar este valor)");
                            modifAtaque = input.nextInt();
                            if (modifAtaque < 0 || modifAtaque > 3){
                                System.out.println("\n--- Valor invalido, rango 1-3 ---\n");
                                break;
                            }
                            if (modifAtaque == 0){
                                modifAtaque = armaduras.get(nombre).getModifAtaque();
                            }
                            System.out.println("Escriba el nuevo valor del modificador de defensa: (rango 1-3,0 para no modificar este valor)");
                            modifDefensa = input.nextInt();
                            if (modifDefensa < 0 || modifDefensa > 3){
                                System.out.println("\n--- Valor invalido, rango 1-3 ---\n");
                                break;
                            }
                            if (modifDefensa == 0){
                                modifDefensa = armaduras.get(nombre).getModifDefensa();
                            }
                            armadura = new Armadura(nuevoNombre, modifAtaque, modifDefensa);
                           
                            armaduras.remove(nombre);
                            armaduras.put(nuevoNombre, armadura);
                           
                            System.out.println("\n--- Armadura modificada correctamente ---\n");
                        } else {
                            System.out.println("Por favor escriba un nombre de armadura correcto\n");
                        }
                        break;

                default: break;
            }
        } while (opcion != 4);
    }
    public void modificarHabilidades(Personaje personaje, Database data){
         Scanner input = new Scanner(System.in);
        Integer opcion, modifAtaque, modifDefensa, sangre, rabia;
        String nombre;
        Habilidad habilidad;
        Disciplina disciplina;
        Don don;
        Talento talento;
        
        System.out.println("La habilidad del personaje es:" +personaje.habilidad.getNombre());
        System.out.println("Ataque:"+personaje.habilidad.getAtaque());
        System.out.println("Defensa:"+personaje.habilidad.getDefensa());
         System.out.println("Escriba el nuevo nombre para esta habilidad: ('N' para no modificar este valor)");
        String nuevoNombre = input.nextLine();
                            if (nuevoNombre.equals("N") || nuevoNombre.equals("n")){
                                nuevoNombre = personaje.habilidad.getNombre();
                            }
       
        
        System.out.println("Escriba el nuevo valor de ataque: (rango 1-3,0 para no modificar este valor)");
                            modifAtaque = input.nextInt();
                            if (modifAtaque < 0 || modifAtaque > 3){
                                System.out.println("\n--- Valor invalido, rango 1-3 ---\n");
                         
                            }
                            if (modifAtaque == 0){
                                modifAtaque = personaje.habilidad.getAtaque();
                            }
                            
         System.out.println("Escriba el nuevo valor de defensa: (rango 1-3,0 para no modificar este valor)");
                            modifDefensa = input.nextInt();
                            if (modifDefensa < 0 || modifDefensa > 3){
                                System.out.println("\n--- Valor invalido, rango 1-3 ---\n");
                                
                                
                            }
                            if (modifDefensa == 0){
                                modifDefensa = personaje.habilidad.getDefensa();
                            }
            if(this instanceof Vampiro){
             disciplina = (Disciplina) personaje.habilidad;
              System.out.println("Puntos de sangre:" + disciplina.getCosteSangre());
              System.out.println("Escriba el nuevo valor de los puntos de sangre: (rango 1-3)");
             sangre = input.nextInt();
                            if (sangre < 0 || sangre > 3){
                                System.out.println("\n--- Valor invalido, rango 1-3 ---\n");     
                            }
                           disciplina = new Disciplina(sangre,nuevoNombre,modifAtaque,modifDefensa);
                           personaje.habilidad = disciplina;
                           System.out.println("La nueva habilidad es:"+ personaje.habilidad.getNombre());
                           System.out.println("Ataque:"+personaje.habilidad.getAtaque());
                           System.out.println("Defensa:"+personaje.habilidad.getDefensa());
                           System.out.println("Puntos de sangre:"+sangre);
                     
            }
           
        
            if (this instanceof Licantropo){
                don = (Don) personaje.habilidad;
             System.out.println("Valor de rabia minimo:" + don.getCosteRabia());
             System.out.println("Escriba el nuevo valor de rabia minimo)");
            rabia = input.nextInt();
                           don = new Don(rabia,nuevoNombre,modifAtaque,modifDefensa);
                           personaje.habilidad = don;
                           System.out.println("La nueva habilidad es:"+ personaje.habilidad.getNombre());
                           System.out.println("Ataque:"+personaje.habilidad.getAtaque());
                           System.out.println("Defensa:"+personaje.habilidad.getDefensa());
                           System.out.println("Rabia minima:"+rabia);}
           
                           
              
           if (this instanceof Cazador){
               talento = new Talento(nuevoNombre,modifAtaque, modifDefensa);
               personaje.habilidad = talento;
               System.out.println("La nueva habilidad es:"+ personaje.habilidad.getNombre());
               System.out.println("Ataque:"+personaje.habilidad.getAtaque());
               System.out.println("Defensa:"+personaje.habilidad.getDefensa());
           }
            
  
            
   
    
    }
    
    public void modificarEsbirros(){
        Scanner input = new Scanner(System.in);
        Integer opcion, salud, tipoesbirro, lealtad, dependencia, confirmacion;
        String nombre, pacto;
        Esbirro esbirro;
        Humano humano;
        Ghoul ghoul;
        Demonio demonio;
        ArrayList<Esbirro> subesbirros = new ArrayList<Esbirro>();
        
        
        do{ 
            System.out.println("Elija una opcion:");
            System.out.println("1.- Añadir esbirros");
            System.out.println("2.- Eliminar esbirros");
            System.out.println("3.- Modificar esbirros");
            System.out.println("4.- Volver");
            opcion = input.nextInt();
            input.nextLine();
            switch (opcion){
                case 1: System.out.println("Nombre del nuevo esbirro: ");
                        nombre = input.nextLine();
                        System.out.println("Salud: (rango 1-3)");
                        salud = input.nextInt();
                        if (salud < 1 || salud > 3){
                            System.out.println("\n--- Valor invalido, rango 1-3 ---\n");
                            break;
                        }
                        System.out.println("Tipo de esbirro: (escriba el numero del tipo (1-3)");
                        System.out.println("1.-Humano");
                        System.out.println("2-Ghoul");
                        System.out.println("3-Demonio");
                        tipoesbirro = input.nextInt();
                        switch(tipoesbirro){ 
                            case 1:
                                if (this instanceof Vampiro){
                                    System.out.println("Los vampiros no pueden tener esbirros humanos");
                                    break;
                                }
                                else{
                           
                                System.out.println("Valor de lealtad (Rango 1-3) ");
                                System.out.println("1.-Baja");
                                System.out.println("2.-Normal");
                                System.out.println("3.-Alta");
                                lealtad = input.nextInt();
                                if (lealtad < 1 || lealtad >3){
                                    System.out.println("\n--- Valor invalido, rango 1-3 ---\n");
                                    break;
                                }
                                humano = new Humano(lealtad, nombre, salud);
                                esbirros.add(humano); 
                                System.out.println("Humano añadidio correctamente");
                          ;
                                } break;
                        
                            case 2: 
                                System.out.println("Valor de dependencia: (rango 1-5) ");
                                dependencia = input.nextInt();
                                 if (dependencia < 1 || dependencia >5){
                                    System.out.println("\n--- Valor invalido, rango 1-5 ---\n");
                                    break;
                                }
                                 ghoul = new Ghoul(dependencia, nombre, salud);
                                 esbirros.add(ghoul);
                                 System.out.println("Ghoul añadido correctamente");
                                
                             
                                 break;
                            case 3: 
                                System.out.println("Pacto entre demonio y amo");
                                pacto = input.nextLine();
                                input.nextLine();
                                
                             
                        do{
                                 System.out.println("Desea añadir mas esbirros al demonio(1 para añadir esbirros, 0 para no añadir)");
                                 confirmacion = input.nextInt();
                                 if (confirmacion==1){
                        System.out.println("Nombre del nuevo esbirro: ");
                        input.nextLine();
                        nombre = input.nextLine();
                        System.out.println("Salud: (rango 1-3)");
                        salud = input.nextInt();
                        input.nextLine();
                        if (salud < 1 || salud > 3){
                            System.out.println("\n--- Valor invalido, rango 1-3 ---\n");
                            break;
                        }
                        System.out.println("Tipo de esbirro");
                        System.out.println("1.-Humano");
                        System.out.println("2-Ghoul");
                        System.out.println("3-Demonio");
                        tipoesbirro = input.nextInt();
                        switch(tipoesbirro){ 
                            case 1:
                                System.out.println("Valor de lealtad: (rango 1-3) ");
                                System.out.println("1.-Baja");
                                System.out.println("2.-Normal");
                                System.out.println("3.-Alta");
                                lealtad = input.nextInt();
                                if (lealtad < 1 || lealtad >3){
                                    System.out.println("\n--- Valor invalido, rango 1-3 ---\n");
                                    break;
                                }
                                humano = new Humano(lealtad, nombre, salud);
                                
                                subesbirros.add(humano); 
                                System.out.println("Humano añadidio al demonio correctamente");
                                
                               
                                break;
                        
                            case 2: 
                                System.out.println("Valor de dependencia:: (rango1-5 ");
                                dependencia = input.nextInt();
                                 if (dependencia < 1 || dependencia >5){
                                    System.out.println("\n--- Valor invalido, rango 1-5 ---\n");
                                    break;
                                }
                                 ghoul = new Ghoul(dependencia, nombre, salud);
                                 
                                 subesbirros.add(ghoul);
                                 
                                 System.out.println("Ghoul añadido al demonio correctamente");
                                 break;
                            case 3: 
                                System.out.println("Pacto entre demonio y amo");
                                pacto = input.nextLine();
                                input.nextLine();
                                demonio =new Demonio(pacto,subesbirros,nombre,salud);
                                subesbirros.add(demonio);
                              
                        }   }else if(confirmacion ==0){
                                     demonio = new Demonio(pacto,subesbirros,nombre,salud);
                                     esbirros.add(demonio);
                                    
                        }
                                 else {
                                System.out.println("Por favor escriba un valor entre 0 y 1");
                                break;
                               
                                         }  
                                 
                             }while (confirmacion != 0);
                            
                      
                        System.out.println("Demonio añadidio correctamente");
                        }    break;       
              
                case 2:
                        System.out.println("Escriba el numero del esbirro que quiera eliminar");
                           for (int i= 0; i< esbirros.size(); i++){
                           System.out.println("-- --");
                           System.out.println(i+"--Nombre:"+esbirros.get(i).getNombre());
                           System.out.println("Salud:"+esbirros.get(i).getSalud());
                          
                           }
                           int indice = input.nextInt();

                       esbirros.remove(indice);
                       System.out.println("Esbirro eliminado con exito");
                           break;
                
                case 3: System.out.println("Escriba el numero del esbirro que quiera modificar");
                        for (int i= 0; i< esbirros.size(); i++){
                           System.out.println("-- --");
                           System.out.println(i+"--Nombre:"+esbirros.get(i).getNombre());
                           System.out.println("Salud:"+esbirros.get(i).getSalud());
                        }
                           int i = input.nextInt();
                        if (esbirros.size()>i){
                            String nuevoNombre;
                            
                            System.out.println("Escriba el nuevo nombre para el esbirro: ('N' para no modificar este valor)");
                            input.nextLine();
                            nuevoNombre = input.nextLine();
                            
                            if (nuevoNombre.equals("N") || nuevoNombre.equals("n")){
                                nuevoNombre = esbirros.get(i).getNombre();
                            }
                            System.out.println("Escriba el nuevo valor de salud: (rango 1-3,0 para no modificar este valor)");
                             salud = input.nextInt();
                            if (salud < 0 || salud > 3){
                                System.out.println("\n--- Valor invalido, rango 1-3 ---\n");
                                break;
                            }
                            if (salud == 0){
                                salud = esbirros.get(i).getSalud();
                            }
                               if(esbirros.get(i) instanceof Humano){
                            Humano human = (Humano) esbirros.get(i);
                           System.out.println("Lealtad:"+ human.getLealtad());
                           System.out.println("Escriba el nuevo valor de lealtad: (rango 1-3,0 para no modificar este valor)");
                             lealtad = input.nextInt();
                            if (lealtad < 0 || lealtad > 3){
                                System.out.println("\n--- Valor invalido, rango 1-3 ---\n");
                                break;
                            }
                            if (lealtad == 0){
                                lealtad = human.getLealtad();
                            }
                                  humano = new Humano(lealtad,nuevoNombre,salud);
                                  esbirros.remove(i);
                                  esbirros.add(humano);
                        }
                        if(esbirros.get(i) instanceof Ghoul){
                        Ghoul ghou = (Ghoul) esbirros.get(i);
                        System.out.println("Dependencia:"+ghou.getDependencia());
                         System.out.println("Escriba el nuevo valor de dependencia: (rango 1-5,0 para no modificar este valor)");
                             dependencia = input.nextInt();
                            if (dependencia < 1 || dependencia > 5){
                                System.out.println("\n--- Valor invalido, rango 1-5 ---\n");
                                break;
                            }
                            if (dependencia == 0){
                                lealtad = ghou.getDependencia();
                            }
                                  ghou = new Ghoul(dependencia,nuevoNombre,salud);
                                  esbirros.remove(i);
                                  esbirros.add(ghou);
                        }
                        if (esbirros.get(i) instanceof Demonio){
                            Demonio demon = (Demonio) esbirros.get(i);
                            System.out.println("Pacto entre demonio y amo:"+ demon.getPacto());
                             System.out.println("Escriba el nuevo pacto: (N para no modificar este valor)");
                             input.nextLine();
                           pacto = input.nextLine();
                            
                            if (pacto.equals("N") || pacto.equals("n")){
                                pacto = demon.getPacto();
                            }
                            for (int j= 0; j< demon.getEsbirros().size(); j++){
                                System.out.println("Nombre subesbrro:"+demon.getEsbirros().get(j).getNombre());
                                System.out.println("Salud:"+ demon.getEsbirros().get(j).getSalud());
                                String nombreSub;
                                 System.out.println("Escriba el nuevo nombre para el subesbirro: ('N' para no modificar este valor)");
                            
                            nombreSub = input.nextLine();
                            
                            if (nombreSub.equals("N") || nombreSub.equals("n")){
                                nombreSub = demon.getEsbirros().get(j).getNombre();
                            }
                            System.out.println("Escriba el nuevo valor de salud: (rango 1-3,0 para no modificar este valor)");
                             
                            int saludSub = input.nextInt();
                            if (saludSub < 0 || saludSub > 3){
                                System.out.println("\n--- Valor invalido, rango 1-3 ---\n");
                                break;
                            }
                            if (saludSub == 0){
                                saludSub = demon.getEsbirros().get(j).getSalud();
                            }
                            if (demon.getEsbirros().get(j) instanceof Humano){ 
                                Humano subhuman = (Humano) demon.getEsbirros().get(j);
                           System.out.println("Lealtad:"+ subhuman.getLealtad());
                           System.out.println("Escriba el nuevo valor de lealtad: (rango 1-3,0 para no modificar este valor)");
                             lealtad = input.nextInt();
                            if (lealtad < 0 || lealtad > 3){
                                System.out.println("\n--- Valor invalido, rango 1-3 ---\n");
                                break;
                            }
                            if (lealtad == 0){
                                lealtad = subhuman.getLealtad();
                            }
                                  humano = new Humano(lealtad,nuevoNombre,salud);
                                  demon.getEsbirros().remove(j);
                                  demon.getEsbirros().add(humano);
                        }
                        if(demon.getEsbirros().get(j) instanceof Ghoul){
                        Ghoul subghou = (Ghoul) demon.getEsbirros().get(j);
                        System.out.println("Dependencia:"+subghou.getDependencia());
                         System.out.println("Escriba el nuevo valor de dependencia: (rango 1-5,0 para no modificar este valor)");
                             dependencia = input.nextInt();
                            if (dependencia < 1 || dependencia > 5){
                                System.out.println("\n--- Valor invalido, rango 1-5 ---\n");
                                break;
                            }
                            if (dependencia == 0){
                                lealtad = subghou.getDependencia();
                            }
                                  ghoul = new Ghoul(dependencia,nuevoNombre,salud);
                                 demon.getEsbirros().remove(j);
                                  demon.getEsbirros().add(ghoul);
                        }
                        if (demon.getEsbirros().get(j) instanceof Demonio){
                            Demonio subdemon = (Demonio) demon.getEsbirros().get(j);
                            System.out.println("Pacto entre demonio y amo:"+ subdemon.getPacto());
                             System.out.println("Escriba el nuevo pacto: (N para no modificar este valor)");
                             input.nextLine();
                           pacto = input.nextLine();
                            if (pacto.equals("N") || pacto.equals("n")){
                                pacto = demon.getPacto();
                            }
                            
                            subesbirros = demon.getEsbirros();
                            
                           
                            
                            
                            }
                        demonio = new Demonio(pacto, subesbirros, nuevoNombre,salud);
                        esbirros.remove(i);
                        esbirros.add(demonio);
                            
                            
                            
                            
                            }
                            
                        
                        
                        }
                        
                        
                           
                       
                            System.out.println("\n--- Esbirro modificado correctamente ---\n");
                        } else {
                            System.out.println("Por favor escriba un numero de esbirro correcto\n");
                        }
                        break;

                           
                                  
                           }
                break;
                               
        }while (opcion !=4);
            

        }
    public void modificarSalud(Personaje personaje){
        Scanner input = new Scanner(System.in);
        Integer  nuevaSalud;
        System.out.println("La salud del personaje es:" +personaje.getSalud());

            System.out.println("Escriba la nueva salud del personaje: (Rango :0-5)");
            nuevaSalud = input.nextInt();
            if (nuevaSalud < 0 || nuevaSalud > 5){
                 System.out.println("Escriba un valor entre 0 y 5");
           
            }
            else{
               
                 personaje.salud = nuevaSalud;
            System.out.println("La nueva salud de su personaje es:"+ personaje.getSalud());
                
            }
      
    
    
    
    
    }
    public void modificarDebilidades (){ 
        Scanner input = new Scanner(System.in);
        Integer opcion, sensibilidad;
        String nombre;
        Debilidad debilidad;
        
        do {
            System.out.println("Elija una opcion:");
            System.out.println("1.- Añadir debilidad");
            System.out.println("2.- Eliminar debilidad");
            System.out.println("3.- Modificar debilidad");
            System.out.println("4.- Volver");
            opcion = input.nextInt();
            input.nextLine();
            switch (opcion){
                case 1: System.out.println("Nombre de la nueva debilidad: ");
                        nombre = input.nextLine();
                        System.out.println("Sensibilidad del personaje a la debilidad: (rango 1-5)");
                        sensibilidad = input.nextInt();
                        if (sensibilidad < 1 || sensibilidad > 5){
                            System.out.println("\n--- Valor invalido, rango 1-5 ---\n");
                            break;
                        }
                        debilidad = new Debilidad(nombre,sensibilidad);
                        debilidades.add(debilidad);
                        System.out.println("\n--- Debilidad añadida correctamente ---\n");
                        break;

                case 2: System.out.println("Escriba el numero de la debilidad que quiere eliminar:");
               
                        for  (int i = 0; i<debilidades.size(); i++){
                            System.out.println("-- --");
                            System.out.println(i+"--Nombre de la debilidad:"+debilidades.get(i).getNombre());
                            System.out.println("Valor de la debilidad:"+ debilidades.get(i).getValor() );
                        } 
                      System.out.print("Escriba el número de la debilidad que quiere eliminar: ");
                       int indice = input.nextInt();

                       debilidades.remove(indice);
                       System.out.println("Debilidad eliminada con exito");
            
                        break;
                            
                        
        

                case 3: System.out.println("Escriba el numero de la debilidad que quiere modificar:");
                        for (int i = 0; i<debilidades.size(); i++){
                            System.out.println(i+"--Nombre de la debilidad:"+ debilidades.get(i).getNombre() );
                            System.out.println("Valor de la debilidad: " + debilidades.get(i).getValor());
                           
                        }
                       int i = input.nextInt();
                        if (debilidades.size()>i){
                            String nuevoNombre;
                            
                            System.out.println("Escriba el nuevo nombre para esta debilidad: ('N' para no modificar este valor)");
                            input.nextLine();
                            nuevoNombre = input.nextLine();
                            
                            if (nuevoNombre.equals("N") || nuevoNombre.equals("n")){
                                nuevoNombre = debilidades.get(i).getNombre();
                            }
                            System.out.println("Escriba el nuevo valor de la debilidad: (rango 1-5,0 para no modificar este valor)");
                            sensibilidad = input.nextInt();
                            if (sensibilidad < 0 || sensibilidad > 5){
                                System.out.println("\n--- Valor invalido, rango 1-5 ---\n");
                                break;
                            }
                            if (sensibilidad == 0){
                                sensibilidad = debilidades.get(i).getValor();
                            }
                          
                            debilidad = new Debilidad(nuevoNombre, sensibilidad);
                           
                            debilidades.remove(i);
                           debilidades.add(debilidad);
                           
                            System.out.println("\n--- Debilidad modificada correctamente ---\n");
                        } else {
                            System.out.println("Por favor escriba un numero de debilidad correcto\n");
                        }
                        break;

               
            }
        } while (opcion != 4);
    }
    
    public void modificarFortazlezas(){ 
        Scanner input = new Scanner(System.in);
        Integer opcion, eficacia;
        String nombre;
        Fortaleza fortaleza;
        
        do {
            System.out.println("Elija una opcion:");
            System.out.println("1.- Añadir fortazleza");
            System.out.println("2.- Eliminar fortaleza");
            System.out.println("3.- Modificar Fortaleza");
            System.out.println("4.- Volver");
            opcion = input.nextInt();
            input.nextLine();
            switch (opcion){
                case 1: System.out.println("Nombre de la nueva fortaleza: ");
                        nombre = input.nextLine();
                        System.out.println("Eficacia de la fortaleza: (rango 1-5)");
                        eficacia = input.nextInt();
                        if (eficacia < 1 || eficacia > 5){
                            System.out.println("\n--- Valor invalido, rango 1-5 ---\n");
                            break;
                        }
                        fortaleza= new Fortaleza(nombre,eficacia);
                        fortalezas.add(fortaleza);
                        System.out.println("\n--- Fortaleza añadida correctamente ---\n");
                        break;

                case 2: System.out.println("Escriba el numero de la fortaleza que quiere eliminar:");
               
                        for  (int i = 0; i<fortalezas.size(); i++){
                            System.out.println("-- --");
                            System.out.println(i+"--Nombre de la fortaleza:"+fortalezas.get(i).getNombre());
                            System.out.println("Valor de la fortaleza:"+ fortalezas.get(i).getValor() );
                        } 
                     
                       int indice = input.nextInt();

                       fortalezas.remove(indice);
                       System.out.println("Fortaleza eliminada con exito");
            
                        break;
                            
                        
        

                case 3: System.out.println("Escriba el numero de la fortaleza que quiere modificar:");
                        for (int i = 0; i<debilidades.size(); i++){
                            System.out.println(i+"--Nombre de la fortaleza:"+ fortalezas.get(i).getNombre() );
                            System.out.println("Valor de la fortaleza: " + fortalezas.get(i).getValor());
                           
                        }
                       int i = input.nextInt();
                        if (fortalezas.size()>i){
                            String nuevoNombre;
                            
                            System.out.println("Escriba el nuevo nombre para esta fortaleza: ('N' para no modificar este valor)");
                            input.nextLine();
                            nuevoNombre = input.nextLine();
                            
                            if (nuevoNombre.equals("N") || nuevoNombre.equals("n")){
                                nuevoNombre = fortalezas.get(i).getNombre();
                            }
                            System.out.println("Escriba el nuevo valor de la eficacia: (rango 1-5,0 para no modificar este valor)");
                            eficacia = input.nextInt();
                            if (eficacia < 0 || eficacia > 5){
                                System.out.println("\n--- Valor invalido, rango 1-5 ---\n");
                                break;
                            }
                            if (eficacia == 0){
                                eficacia = fortalezas.get(i).getValor();
                            }
                          
                            fortaleza = new Fortaleza(nuevoNombre, eficacia);
                           
                            fortalezas.remove(i);
                           fortalezas.add(fortaleza);
                           
                            System.out.println("\n--- Fortaleza modificada correctamente ---\n");
                        } else {
                            System.out.println("Por favor escriba un numero de fortaleza correcto\n");
                        }
                        break;

               
            }
        } while (opcion != 4);
    }
    
    }

   



        
