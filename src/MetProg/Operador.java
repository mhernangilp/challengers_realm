
package MetProg;

import java.text.SimpleDateFormat;
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
        
        if (desafios.size() == 0){
            System.out.println("\n--- No hay desafios para validar en estos momentos ---\n");
            return ;
        }
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
            System.out.println("Tipo de personaje del contrincante: " + ((Cliente) data.getUsuarioByNick(desafio.getDesafiado())).getPersonaje().getTipo());
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
            if (opcion2 == -1){
                break ;
            }
            if (opcion2 < -1 || opcion2 > debilidades.size() - 1){
                System.out.println("\n--- Opcion incorrecta ---\n");
            } else if (debilidadesDesafiante.contains(debilidades.get(opcion2))){
                System.out.println("\n--- Opcion ya escogida ---\n");
            } else {
                debilidadesDesafiante.add(debilidades.get(opcion2));
            }
        } while (opcion2 != -1);
        do {
            ArrayList<Fortaleza> fortalezas = desafio.getFortDesafiante();
            System.out.println("Seleccione las fortalezas de el desafiante '" + desafio.getDesafiante() + "' quedeben estar presentes en este combate: (-1 para continuar)");
            System.out.println("Tipo de personaje del contrincante: " + ((Cliente) data.getUsuarioByNick(desafio.getDesafiado())).getPersonaje().getTipo());
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
            if (opcion2 == -1){
                break ;
            }
            if (opcion2 < -1 || opcion2 > fortalezas.size() - 1){
                System.out.println("\n--- Opcion incorrecta ---\n");
            } else if(fortalezasDesafiante.contains(fortalezas.get(opcion2))){
                System.out.println("\n--- Opcion ya escogida ---\n");
            } else {
                fortalezasDesafiante.add(fortalezas.get(opcion2));
            }
        } while (opcion2 != -1);
        do {
            ArrayList<Debilidad> debilidades = desafio.getDebDesafiado();
            System.out.println("Seleccione las debilidades de el desafiado '" + desafio.getDesafiado() + "' quedeben estar presentes en este combate: (-1 para continuar)");
            System.out.println("Tipo de personaje del contrincante: " + ((Cliente) data.getUsuarioByNick(desafio.getDesafiante())).getPersonaje().getTipo());
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
            if (opcion2 == -1){
                break ;
            }
            if (opcion2 < -1 || opcion2 > debilidades.size() - 1){
                System.out.println("\n--- Opcion incorrecta ---\n");
            } else if (debilidadesDesafiado.contains(debilidades.get(opcion2))){
                System.out.println("\n--- Opcion ya escogida ---\n");
            } else {
                debilidadesDesafiado.add(debilidades.get(opcion2));
            }
        } while (opcion2 != -1);
        do {
            ArrayList<Fortaleza> fortalezas = desafio.getFortDesafiado();
            System.out.println("Seleccione las fortalezas de el desafiado '" + desafio.getDesafiado() + "' quedeben estar presentes en este combate: (-1 para continuar)");
            System.out.println("Tipo de personaje del contrincante: " + ((Cliente) data.getUsuarioByNick(desafio.getDesafiante())).getPersonaje().getTipo());
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
            if (opcion2 == -1){
                break ;
            }
            if (opcion2 < -1 || opcion2 > fortalezas.size() - 1){
                System.out.println("\n--- Opcion incorrecta ---\n");
            } else if (fortalezasDesafiado.contains(fortalezas.get(opcion2))){
                System.out.println("\n--- Opcion ya escogida ---\n");
            } else {
                fortalezasDesafiado.add(fortalezas.get(opcion2));
            }
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
                
                case 3:personaje.modificarHabilidades(personaje,data);
                    break;
                
                case 4: personaje.modificarEsbirros();
                break;
                
                case 5:personaje.modificarSalud(personaje);
               
                
                    break;
                
                case 6: personaje.modificarDebilidades();
                    break;
                
                case 7: personaje.modificarFortazlezas();
                    break;
                
                default: break;
            }
        } while (opcion != 8);
    }
    
    private boolean incumplidoNormas(Cliente usuario){
        ArrayList<Historial> logs = usuario.getPersonaje().getHistorial();
        
        if (logs.size() > 1){
            for (int i = 0; i < logs.size() - 1; i++){
                SimpleDateFormat ft = new SimpleDateFormat ("dd/MM/yyyy");
                if (ft.format(logs.get(i).getFechaCombate()).equals(ft.format(logs.get(i + 1).getFechaCombate()))){
                    if (logs.get(i).getUsuarioDesafiante().equals(logs.get(i + 1).getUsuarioDesafiante())){
                        if (usuario.getNick().equals(logs.get(i).getUsuarioDesafiante())){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }    
    
    // El método busca en la lista de usuarios a aquellos que son clientes con personaje y que han incumplido alguna norma. Si no encuentra ningún usuario que
    // cumpla ambas características (tener personaje e incumplir normas), mostrará por pantalla que ningún usuario se puede banear. Por el contrario, muestra la 
    // lista de usuarios baneables por pantalla con un indice por cada uno. Introduciendo ese indice "i", comprobará si el usuario seleccionado ya ha sido 
    // baneado usando el método "isBaneado()". Si ya ha sido baneado se indicará mostrándolo por pantalla. Si no ha sido baneado, se baneará al usuario seleccionado
    // haciendo uso del método "banear()"
    public void banear (Database data) {
        Scanner input = new Scanner (System.in);
        Integer opcion, size;
        
        size = 0;
        ArrayList<Usuario> listaData = data.getUsuarios();
        for (int i = 0; i < listaData.size(); i++) {
            if (listaData.get(i) instanceof Cliente) {
                if (((Cliente) listaData.get(i)).getPersonaje() != null) {
                    if (this.incumplidoNormas((Cliente) listaData.get(i))){
                        System.out.println(i + ": " + ((Cliente) listaData.get(i)).getNick());
                        size++;
                    }
                } 
            }
        }
        if (size == 0){
            System.out.println("\n--- Ningun usuario que se pueda banear ---\n");
            return ;
        }
        opcion = input.nextInt();
        if (((Cliente) listaData.get(opcion)).isBaneado()){
            System.out.println("Usuario ya baneado");
        } else{
            ((Cliente) listaData.get(opcion)).banear();
            System.out.println("\n--- Usuario baneado correctamente ---\n");
        }  
    }
    
    // El método busca en la lista de usuarios y muestra por pantalla a aquellos que son clientes y que han sido baneados. El usuario ingresará por pantalla
    // un input de opción para seleccionar el usuario a desbanear. Primero comprueba si el usuario está baneado. Si no lo está, mostrará por pantalla "Usuario
    // no baneado". Por el contrario, si está baneado, lo desbaneará usando el método "desbanear()" y confirmará el desbaneo con un mensaje por pantalla.
    public void desbanear (Database data) {
        Scanner input = new Scanner (System.in);
        Integer opcion;
        
        ArrayList<Usuario> listaData = data.getUsuarios();
        for (int i = 0; i < listaData.size(); i++) {
            if (listaData.get(i) instanceof Cliente) {
                if (((Cliente) listaData.get(i)).isBaneado()) {
                    System.out.println(i + ": " + ((Cliente) listaData.get(i)).getNick());
                } 
            }
        }
        opcion = input.nextInt();
        if (!((Cliente) listaData.get(opcion)).isBaneado()){
            System.out.println("Usuario no baneado");
        } else{
            ((Cliente) listaData.get(opcion)).desbanear();
            System.out.println("\n--- Usuario desbaneado correctamente ---\n");
        }  
    }
}

