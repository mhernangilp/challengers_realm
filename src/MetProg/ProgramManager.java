
package MetProg;

import java.util.Scanner;

public class ProgramManager {
    public void pantallaInicial(){
        Database data = new Database();
        Sistema sistema = new Sistema();
        Integer opcion = 0;
        Scanner input = new Scanner(System.in);
        
        data.inicializarPersonajes();
        while (opcion != 4){
            System.out.println("-----------------------");
            System.out.println("  .: Bienvenido !! :.");
            System.out.println("-----------------------");
            System.out.println("Elija que desea hacer:");
            System.out.println("1.- Iniciar Sesion");
            System.out.println("2.- Registrarse");
            System.out.println("3.- Darse de baja");
            System.out.println("4.- Salir del sistema");
            opcion = input.nextInt();
            switch (opcion){
                case 1: sistema.logIn(data);
                        break;
                
                case 2: sistema.registro(data);
                        break;
                
                case 3: sistema.darDeBaja(data);
                        break;
                
                default: break;
            }
        }
    }
}
