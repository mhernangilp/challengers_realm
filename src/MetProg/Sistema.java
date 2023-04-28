
package MetProg;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

// La clase se encargará de el resto de menús de la aplicación
public class Sistema {
    public void logIn(Database data) throws Exception{
        Scanner input = new Scanner(System.in);
        String nick;
        String contraseña;
        Integer opcion;
        
        // Primero, el inicio de sesión:
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
            Usuario usuario = data.getUsuarioByNick(nick);
            do {
                if (usuario instanceof Cliente){
                    if (((Cliente) usuario).isBaneado()){
                        System.out.println("\n--- Usuario baneado ---\n");
                        return ;
                    }
                    // Las opciones de registrar personaje o consultar ranking global 
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
                            
                            case 3: ((Cliente) usuario).rankingGlobal(data);
                                    break;
                            
                            default:System.out.println("\n--- Por favor seleccione una opcion correcta ---\n");
                                    break;
                        }
                    } else {
                        if (data.getPosDesafio(usuario.getNick()) != -1 && data.getDesafios().get(data.getPosDesafio(usuario.getNick())).isValidado()){
                            Combate combate = new Combate();
                            Desafio desafio = data.getDesafios().get(data.getPosDesafio(usuario.getNick()));
                            do {
                            // Si hay desafíos pendientes, mostrará la notificación al comienzo del inicio de sesión:
                            System.out.println("¡¡ Tienes un desafio nuevo!!");
                            System.out.println("-- Desafiante: " + desafio.getDesafiante());
                            System.out.println("-- Personaje del enemigo: " + ((Cliente) data.getUsuarioByNick(desafio.getDesafiante())).getPersonaje().getTipo());
                            System.out.println("-- Oro apostado: " + desafio.getOroApostado());
                            System.out.println("Elija que desea hacer:");
                            System.out.println("1.- Aceptar desafio");
                            System.out.println("2.- Rechazar desafio");
                            opcion = input.nextInt();
                            switch (opcion){
                                case 1: if (((Cliente)data.getUsuarioByNick(desafio.getDesafiado())).getPersonaje().getArmaActiva()[0] == null
                                                || ((Cliente)data.getUsuarioByNick(desafio.getDesafiado())).getPersonaje().getArmaduraActiva() == null){
                                            System.out.println("\n--- Para poder aceptar un desafio debe tener un equipo activo, seleccionelo para poder continuar: ---\n");
                                            ((Cliente)data.getUsuarioByNick(desafio.getDesafiado())).elegirEquipo(data, ((Cliente) usuario).getPersonaje().getTipo());
                                        }
                                        combate.aceptarCombate(data, desafio);
                                        break;
                                case 2: combate.rechazarCombate(data, desafio);
                                        break;
                                default: System.out.println("\n--- Por favor seleccione una opcion correcta ---\n");
                                         break;
                            }
                            } while (opcion != 1 && opcion != 2);
                        }
                        // Y mostrará los resultados del historial al desafiante
                        ArrayList<Historial> logs = ((Cliente) usuario).getPersonaje().getHistorial();
                        for(int i = 0; i < logs.size(); i++){
                            if (!logs.get(i).isVisto() && logs.get(i).getUsuarioDesafiante().equals(((Cliente) usuario).getNick())){
                                System.out.println("\n..::Nuevo resultado de desafio !!::..\n");
                                System.out.println(i + ":");
                                System.out.println("    Usuario desafiante: " + logs.get(i).getUsuarioDesafiante());
                                System.out.println("    Usuario desafiado: " + logs.get(i).getUsuarioDesafiado());
                                System.out.println("    Rondas Empleadas: " + logs.get(i).getRondasEmpleadas());
                                SimpleDateFormat ft = new SimpleDateFormat ("dd/MM/yyyy");
                                System.out.println("    Fecha Combate: " + ft.format(logs.get(i).getFechaCombate()));
                                System.out.println("    Usuario Vencedor: " + logs.get(i).getUsuarioVencedor());
                                System.out.print("    El desafiante termino con algun esbirro sin derrotar: ");
                                if (logs.get(i).getEsbirroSinDerrotar()[0] == 1){
                                    System.out.println("Si");
                                } else {
                                    System.out.println("No");
                                }
                                System.out.print("    El desafiado termino con algun esbirro sin derrotar: ");
                                if (logs.get(i).getEsbirroSinDerrotar()[1] == 1){
                                    System.out.println("Si");
                                } else {
                                    System.out.println("No");
                                }
                                System.out.println("    Oro ganado: " + logs.get(i).getOroGanado() + "\n");
                                logs.get(i).ver();
                            }
                        }
                        // De nuevo el menú:
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
                            
                            case 2: ((Cliente) usuario).elegirEquipo(data, ((Cliente) usuario).getPersonaje().getTipo());
                                    break;
                            
                            case 3: ((Cliente) usuario).desafiarUsuario(data);
                                    break;
                            
                            case 4: ((Cliente) usuario).consultarHistorial();
                                    break;
                            
                            case 5: ((Cliente) usuario).rankingGlobal(data);
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
                        System.out.println("5.- Desbanear usuarios");
                        opcion = input.nextInt();
                        // Segun la opcion, se llamará a las funciones respectivas
                        switch (opcion){
                            case 1: break;
                            
                            case 2: ((Operador) usuario).editarPersonaje(data);
                                    break;
                            
                            case 3: ((Operador) usuario).validarDesafios(data);
                                    break;
                            
                            case 4: ((Operador) usuario).banear(data);
                                    break;
                            
                            case 5: ((Operador) usuario).desbanear(data);
                                    break;
                            
                            default:System.out.println("\n--- Por favor seleccione una opcion correcta ---\n");
                                    break;
                        }
                }
            } while (opcion != 1);
        }
    }
    
    // Esta función se encargará del registro de un usuario en la base de datos
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
    
    // Esta función se encargará de crear un numero de registro unico por cada usuario
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
    
    // Función para dar de baja una cuenta en la base de datos
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
            data.eliminarUsuario(nick);
            System.out.println("\n--- Usuario eliminado correctamente ---\n");
        }
    }
}
