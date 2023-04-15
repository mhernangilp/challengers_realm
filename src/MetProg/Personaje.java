
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

    public Personaje(Habilidad habilidad, HashMap<String, Arma> armas, HashMap<String, Armadura> armaduras, ArrayList<Esbirro> esbirros, Integer salud, ArrayList<Debilidad> debilidades, ArrayList<Fortaleza> fortalezas) {
        this.habilidad = habilidad;
        this.armas = armas;
        this.armaduras = armaduras;
        this.esbirros = esbirros;
        this.salud = salud;
        this.debilidades = debilidades;
        this.fortalezas = fortalezas;
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
    
}
