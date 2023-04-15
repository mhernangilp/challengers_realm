
package MetProg;

import java.util.ArrayList;
import java.util.Scanner;

public class Operador extends Usuario{
    
    public Operador(String nombre, String nick, String contraseña) {
        super(nombre, nick, contraseña);
    }
    
    public void validarDesafios(Database data){
        ArrayList<Desafio> desafios = data.getDesafios();
        for (int i = 0; i < desafios.size(); i++){
            System.out.println("\n" + i + ":");
            System.out.println("    Desafiante: " + desafios.get(i).getDebDesafiante());
            System.out.println("    Desafiado: " + desafios.get(i).getDebDesafiado());
        }
    }
    
    public void editarPersonaje(Database data){
        Scanner input = new Scanner(System.in);
        Integer opcion;
        Personaje personaje;
        
        System.out.println("Elija que personaje desea editar:");
        System.out.println("1.- Vampiro");
        System.out.println("2.- Licantropo");
        System.out.println("3.- Cazador");
        opcion = input.nextInt();
        switch (opcion){
            case 1: personaje = data.getPersonaje(0);
                    break;
            
            case 2: personaje = data.getPersonaje(1);
                    break;
            
            case 3: personaje = data.getPersonaje(2);
                    break;
            
            default:System.out.println("\n--- Eleccion incorrecta ---\n");
                    return ;
        }
        do {
            System.out.println("Elija una opcion:");
            System.out.println("1.- Modificar conjunto de armas");
            System.out.println("2.- Modificar conjunto de armaduras");
            System.out.println("3.- Modificar habilidades");
            System.out.println("4.- Modificar esbirros");
            System.out.println("5.- Modificar salud");
            System.out.println("6.- Modificar debilidades");
            System.out.println("7.- Modificar fortalezas");
            System.out.println("8.- Volver");
            opcion = input.nextInt();
            switch (opcion){
                case 1: personaje.modificarArmas();
                        break;
                
                case 2: break;
                
                case 3: break;
                
                case 4: break;
                
                case 5: break;
                
                case 6: break;
                
                case 7: break;
                
                default: break;
            }
        } while (opcion != 8);
    }
}
