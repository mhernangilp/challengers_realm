
package MetProg;

import java.util.ArrayList;
import java.util.Scanner;

public class Operador extends Usuario{
    
    public Operador(String nombre, String nick, String contraseña) {
        super(nombre, nick, contraseña);
    }
    
    public void validarDesafios(Database data){
        Scanner input = new Scanner(System.in);
        Integer opcion, opcion2;
        ArrayList<Desafio> desafios = data.getDesafios();
        ArrayList<Debilidad> debilidadesDesafiante = new ArrayList<Debilidad>();
        ArrayList<Fortaleza> fortalezasDesafiante = new ArrayList<Fortaleza>();
        ArrayList<Debilidad> debilidadesDesafiado = new ArrayList<Debilidad>();
        ArrayList<Fortaleza> fortalezasDesafiado = new ArrayList<Fortaleza>();
        
        System.out.println("Selecione un desafio:");
        for (int i = 0; i < desafios.size(); i++){
            if (!desafios.get(i).isValidado()){
                System.out.println(i + ":");
                System.out.println("    Desafiante: " + desafios.get(i).getDesafiante());
                System.out.println("    Desafiado: " + desafios.get(i).getDesafiado());
                System.out.println("    Oro apostado: " + desafios.get(i).getOroApostado() + "\n");
            }
        }
        opcion = input.nextInt();
        if (opcion < 0 || opcion > desafios.size() - 1){
            System.out.println("\n--- Opcion incorrecta ---\n");
            return ;
        }
        Desafio desafio = desafios.get(opcion);
        do {
            ArrayList<Debilidad> debilidades = desafio.getDebDesafiante();
            System.out.println("Seleccione las debilidades de el desafiante '" + desafio.getDesafiante() + "' quedeben estar presentes en este combate: (-1 para continuar)");
            System.out.println("Tipo de personaje del contrincante: " + ((Cliente) data.getUsuarioByPos(data.getPosUsuario(desafio.getDesafiado()))).getPersonaje().getTipo());
            for (int i = 0; i < debilidades.size(); i++){
                System.out.println(i + ":");
                System.out.println("    Nombre: " + debilidades.get(i).getNombre());
                System.out.println("    Valor: " + debilidades.get(i).getValor());
            }
            if (!debilidadesDesafiante.isEmpty()){
                System.out.println("\nYa seleccionado:");
                for (int i = 0; i < debilidadesDesafiante.size(); i++){
                    System.out.println(i + ":");
                    System.out.println("    Nombre: " + debilidadesDesafiante.get(i).getNombre());
                    System.out.println("    Valor: " + debilidadesDesafiante.get(i).getValor());
                }
            }
            opcion2 = input.nextInt();
            if (opcion2 < -1 || opcion2 > debilidades.size() - 1){
                System.out.println("\n--- Opcion incorrecta ---\n");
                return ;
            }
            if (opcion2 == -1){
                break ;
            }
            debilidadesDesafiante.add(debilidades.get(opcion2));
        } while (opcion2 != -1);
        do {
            ArrayList<Fortaleza> fortalezas = desafio.getFortDesafiante();
            System.out.println("Seleccione las fortalezas de el desafiante '" + desafio.getDesafiante() + "' quedeben estar presentes en este combate: (-1 para continuar)");
            System.out.println("Tipo de personaje del contrincante: " + ((Cliente) data.getUsuarioByPos(data.getPosUsuario(desafio.getDesafiado()))).getPersonaje().getTipo());
            for (int i = 0; i < fortalezas.size(); i++){
                System.out.println(i + ":");
                System.out.println("    Nombre: " + fortalezas.get(i).getNombre());
                System.out.println("    Valor: " + fortalezas.get(i).getValor());
            }
            if (!fortalezasDesafiante.isEmpty()){
                System.out.println("\nYa seleccionado:");
                for (int i = 0; i < fortalezasDesafiante.size(); i++){
                    System.out.println(i + ":");
                    System.out.println("    Nombre: " + fortalezasDesafiante.get(i).getNombre());
                    System.out.println("    Valor: " + fortalezasDesafiante.get(i).getValor());
                }
            }
            opcion2 = input.nextInt();
            if (opcion2 < -1 || opcion2 > fortalezas.size() - 1){
                System.out.println("\n--- Opcion incorrecta ---\n");
                return ;
            }
            if (opcion2 == -1){
                break ;
            }
            fortalezasDesafiante.add(fortalezas.get(opcion2));
        } while (opcion2 != -1);
        do {
            ArrayList<Debilidad> debilidades = desafio.getDebDesafiado();
            System.out.println("Seleccione las debilidades de el desafiado '" + desafio.getDesafiado() + "' quedeben estar presentes en este combate: (-1 para continuar)");
            System.out.println("Tipo de personaje del contrincante: " + ((Cliente) data.getUsuarioByPos(data.getPosUsuario(desafio.getDesafiante()))).getPersonaje().getTipo());
            for (int i = 0; i < debilidades.size(); i++){
                System.out.println(i + ":");
                System.out.println("    Nombre: " + debilidades.get(i).getNombre());
                System.out.println("    Valor: " + debilidades.get(i).getValor());
            }
            if (!debilidadesDesafiado.isEmpty()){
                System.out.println("\nYa seleccionado:");
                for (int i = 0; i < debilidadesDesafiado.size(); i++){
                    System.out.println(i + ":");
                    System.out.println("    Nombre: " + debilidadesDesafiado.get(i).getNombre());
                    System.out.println("    Valor: " + debilidadesDesafiado.get(i).getValor());
                }
            }
            opcion2 = input.nextInt();
            if (opcion2 < -1 || opcion2 > debilidades.size() - 1){
                System.out.println("\n--- Opcion incorrecta ---\n");
                return ;
            }
            if (opcion2 == -1){
                break ;
            }
            debilidadesDesafiado.add(debilidades.get(opcion2));
        } while (opcion2 != -1);
        do {
            ArrayList<Fortaleza> fortalezas = desafio.getFortDesafiado();
            System.out.println("Seleccione las fortalezas de el desafiado '" + desafio.getDesafiado() + "' quedeben estar presentes en este combate: (-1 para continuar)");
            System.out.println("Tipo de personaje del contrincante: " + ((Cliente) data.getUsuarioByPos(data.getPosUsuario(desafio.getDesafiante()))).getPersonaje().getTipo());
            for (int i = 0; i < fortalezas.size(); i++){
                System.out.println(i + ":");
                System.out.println("    Nombre: " + fortalezas.get(i).getNombre());
                System.out.println("    Valor: " + fortalezas.get(i).getValor());
            }
            if (!fortalezasDesafiado.isEmpty()){
                System.out.println("\nYa seleccionado:");
                for (int i = 0; i < fortalezasDesafiado.size(); i++){
                    System.out.println(i + ":");
                    System.out.println("    Nombre: " + fortalezasDesafiado.get(i).getNombre());
                    System.out.println("    Valor: " + fortalezasDesafiado.get(i).getValor());
                }
            }
            opcion2 = input.nextInt();
            if (opcion2 < -1 || opcion2 > fortalezas.size() - 1){
                System.out.println("\n--- Opcion incorrecta ---\n");
                return ;
            }
            if (opcion2 == -1){
                break ;
            }
            fortalezasDesafiado.add(fortalezas.get(opcion2));
        } while (opcion2 != -1);
        desafio.setDebDesafiante(debilidadesDesafiante);
        desafio.setFortDesafiante(fortalezasDesafiante);
        desafio.setDebDesafiado(debilidadesDesafiado);
        desafio.setFortDesafiado(fortalezasDesafiado);
        desafio.setValidado(true);
        System.out.println("\n--- Desafio validado correctamente ---\n");
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
                
                case 2: personaje.modificarArmadura();
                        break;
                
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
