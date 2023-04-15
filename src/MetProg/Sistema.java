
package MetProg;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Sistema {
    public void logIn(Database data){
        Scanner input = new Scanner(System.in);
        String nick;
        String contraseña;
        Integer opcion;
        
        System.out.println("Escriba su nick:");
        nick = input.nextLine();
        System.out.println("Escriba su contraseña:");
        contraseña = input.nextLine();
        if (!data.checkNick(nick)){
            System.out.println("\n--- No existe ningun usuario con este nick ---\n");
        } else if (!data.checkNickPass(nick, contraseña)){
            System.out.println("\n--- Contraseña incorrecta ---\n");
        } else {
            System.out.println("\n--- Inicio de sesión correcto ---\n");
            Usuario usuario = data.getUsuarioByPos(data.getPosUsuario(nick));
            do {
                if (usuario instanceof Cliente){
                    if (((Cliente) usuario).isBaneado()){
                        System.out.println("\n--- Usuario baneado ---\n");
                        return ;
                    }
                    if (((Cliente)usuario).getPersonaje() == null){
                        System.out.println("Elija una opcion:");
                        System.out.println("1.- Cerrar sesion");
                        System.out.println("2.- Registrar personaje");
                        System.out.println("3.- Consultar ranking global");
                        opcion = input.nextInt();
                        switch (opcion){
                            case 1: break;
                            
                            case 2: ((Cliente) usuario).registrarPersonaje();
                                    break;
                            
                            case 3: // ranking global
                                    break;
                            
                            default:System.out.println("\n--- Por favor seleccione una opcion correcta ---\n");
                                    break;
                        }
                    } else {

                        //checkear si hay algun desafio pendiente

                        System.out.println("Elija una opcion:");
                        System.out.println("1.- Cerrar sesion");
                        System.out.println("2.- Elegir equipo activo");
                        System.out.println("3.- Desafiar usuario");
                        System.out.println("4.- Consultar historial");
                        System.out.println("5.- Consultar ranking global");
                        System.out.println("6.- Dar de baja personaje");
                        opcion = input.nextInt();
                        switch (opcion){
                            case 1: break;
                            
                            case 2: ((Cliente) usuario).elegirEquipo(data, ((Cliente) usuario).getPersonaje().getTipo(), usuario);
                                    break;
                            
                            case 3: ((Cliente) usuario).desafiarUsuario(data);
                                    break;
                            
                            case 4: // consultar historial
                                    break;
                            
                            case 5: // ranking global
                                    break;
                            
                            case 6: ((Cliente) usuario).darBajaPersonaje();
                                    break;
                            
                            default:System.out.println("\n--- Por favor seleccione una opcion correcta ---\n");
                                    break;
                        }
                    }
                } else {
                    System.out.println("Elija una opcion:");
                        System.out.println("1.- Cerrar sesion");
                        System.out.println("2.- Editar personaje");
                        System.out.println("3.- Validar desafios");
                        System.out.println("4.- Banear usuarios");
                        opcion = input.nextInt();
                        switch (opcion){
                            case 1: break;
                            
                            case 2: ((Operador) usuario).editarPersonaje(data);
                                    break;
                            
                            case 3: ((Operador) usuario).validarDesafios(data);
                                    break;
                            
                            case 4: break;
                            
                            default:System.out.println("\n--- Por favor seleccione una opcion correcta ---\n");
                                    break;
                        }
                }
            } while (opcion != 1);
        }
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
        System.out.println("\n--- Usuario registrado correctamente ---\n");
    }
    
    private String crearNumReg(Database data){
        Random r = new Random();
        String numReg;
        do {
            char a = (char)(r.nextInt(26) + 'A');
            Integer n = r.nextInt(99);
            char b = (char)(r.nextInt(26) + 'A');
            char c = (char)(r.nextInt(26) + 'A');
            numReg = (a + n.toString() + b + c);
        } while(data.checkNumReg(numReg));
        return (numReg);
    }
    
    public void darDeBaja(Database data){
        Scanner input = new Scanner(System.in);
        String nick;
        String contraseña;
        
        System.out.println("Escriba su nick:");
        nick = input.nextLine();
        System.out.println("Escriba su contraseña:");
        contraseña = input.nextLine();
        if (!data.checkNick(nick)){
            System.out.println("\n--- No existe ningun usuario con este nick ---\n");
        } else if (!data.checkNickPass(nick, contraseña)){
            System.out.println("\n--- Contraseña incorrecta ---\n");
        } else {
            data.eliminarUsuario(data.getPosUsuario(nick));
            System.out.println("\n--- Usuario eliminado correctamente ---\n");
        }
    }
}
