
package MetProg;

import java.util.Scanner;

public class ProgramManager {
    public void pantallaInicial(){
        Integer opcion = 0;
        Scanner input = new Scanner(System.in);
        
        while (opcion != 3){
            System.out.println("-----------------------");
            System.out.println("  .: Bienvenido !! :.");
            System.out.println("-----------------------");
            System.out.println("Elija que desea hacer:");
            System.out.println("1.- Iniciar Sesion");
            System.out.println("2.- Registrarse");
            System.out.println("3.- Salir del sistema");
            opcion = input.nextInt();
            if (opcion == 2){
                System.out.println("holaa");
            }
        }
    }
}
