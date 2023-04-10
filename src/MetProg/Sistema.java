
package MetProg;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Sistema {
    public void logIn(Database data){
        
    }
    
    private void pantallaDesafio(Database data){
        
    }
    
    public void registro(Database data){
        Scanner input = new Scanner(System.in);
        Integer opcion;
        String nombre;
        String nick;
        String contraseña;
        
        do {
            System.out.println("Elija una opcion:");
            System.out.println("1.- Cliente");
            System.out.println("2.- Operador");
            System.out.println("3.- Volver");
            opcion = input.nextInt();
            if (opcion == 3){
                return ;
            }
            if (opcion != 1 && opcion != 2 && opcion != 3){
                System.out.println("Selecione una opcion correcta por favor\n");
            }
        }
        while (opcion != 1 && opcion != 2 && opcion != 3);
        input.nextLine();
        System.out.println("Escriba su nombre:");
        nombre = input.nextLine();
        do {
            System.out.println("Escriba su nick:");
            nick = input.nextLine();
            if (data.checkNick(nick)){
                System.out.println("Nick ya en uso, por favor escoja otro diferente");
            }
        } while (data.checkNick(nick));
        System.out.println("Escriba su contraseña:");
        contraseña = input.nextLine();
        if (opcion == 1){
            String numReg = crearNumReg(data);
            Usuario user = new Cliente(nombre, nick, contraseña, numReg);
            data.añadirUsuario(user);
        } else {
            Usuario user = new Operador(nombre, nick, contraseña);
            data.añadirUsuario(user);
        }
        System.out.println("\n--- Usuario registrado Correctamente ---\n");
    }
    
    private String crearNumReg(Database data){
        Random r = new Random();
        String numReg;
        do {
            char a = (char)(r.nextInt(26) + 'a');
            Integer n = r.nextInt(99);
            char b = (char)(r.nextInt(26) + 'a');
            char c = (char)(r.nextInt(26) + 'a');
            numReg = (a + n.toString() + b + c);
        } while(data.checkNumReg(numReg));
        return (numReg);
    }
    
    public void darDeBaja(Database data){
        
    }
}
