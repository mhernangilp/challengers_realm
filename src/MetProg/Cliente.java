
package MetProg;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Cliente extends Usuario{
    private String numReg;
    private boolean baneado;
    private PersonajeUsuario personaje;

    public Cliente(String nombre, String nick, String contraseña, String numReg) {
        super(nombre, nick, contraseña);
        this.numReg = numReg;
        this.baneado = false;
    }

    public String getNumReg() {
        return numReg;
    }
    
    // Método que devuelve el valor booleano del estado de la variable baneado, es decir, devuelve True si está baneado y False si no lo está
    public boolean isBaneado() {
        return baneado;
    }

    public PersonajeUsuario getPersonaje() {
        return personaje;
    }
    
    // Establece la variable baneado a True, por lo que se baneará al cliente al aplicarle este método
    public void banear(){
        this.baneado = true;
    }
    
    // Establece la variable baneado a False, por lo que se desbaneará al cliente al aplicarle este método
    public void desbanear(){
        this.baneado = false;
    }
    
    // Crea el array temporal Ranking, que se compone únicamente de clientes con al menos un personaje. Si está vacío imprimirá por pantalla una frase
    // que así lo indique, y si contiene elementos se mostrará ordenadamente por cada elemento su posición, su nick y su cantidad de oro
    public void rankingGlobal(Database data) {
        ArrayList<Usuario> ArrayRanking = new ArrayList<Usuario>();
        ArrayList<Usuario> listaData = data.getUsuarios();
        for (int r = 0; r < listaData.size(); r++) {
            if (listaData.get(r) instanceof Cliente) {
                if (((Cliente) listaData.get(r)).getPersonaje() != null) {
                    ArrayRanking.add(listaData.get(r));
                }
            }
        }
        int n = ArrayRanking.size();
        if (n == 0) {
            System.out.println("\n--- Ranking vacio ---\n");
        } else {
            System.out.println();
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (((Cliente) ArrayRanking.get(j)).getPersonaje().getOro() < ((Cliente) ArrayRanking.get(j+1)).getPersonaje().getOro()) {
                        Usuario aux = ArrayRanking.get(j);
                        ArrayRanking.set(j, ArrayRanking.get(j+1));
                        ArrayRanking.set(j+1, aux);
                    }
                }
            }
            for (int k = 0; k < n; k++) {
                Cliente cliente = (Cliente) ArrayRanking.get(k);
                System.out.println(k+1 + ". " + cliente.getNick() + " => " + cliente.getPersonaje().getOro() + " oro");
            }
            System.out.println();
        }
    }
    
    public void consultarHistorial(){
        ArrayList<Historial> historial = personaje.getHistorial();
        
        if (historial.size() == 0){
            System.out.println("\n--- Historial vacio ---\n");
        }
        for (int i = 0; i < historial.size(); i++){
            System.out.println("\n" + i + ":");
            System.out.println("    Usuario desafiante: " + historial.get(i).getUsuarioDesafiante());
            System.out.println("    Usuario desafiado: " + historial.get(i).getUsuarioDesafiado());
            System.out.println("    Rondas Empleadas: " + historial.get(i).getRondasEmpleadas());
            SimpleDateFormat ft = new SimpleDateFormat ("dd/MM/yyyy");
            System.out.println("    Fecha Combate: " + ft.format(historial.get(i).getFechaCombate()));
            System.out.println("    Usuario Vencedor: " + historial.get(i).getUsuarioVencedor());
            System.out.print("    El desafiante termino con algun esbirro sin derrotar: ");
            if (historial.get(i).getEsbirroSinDerrotar()[0] == 1){
                System.out.println("Si");
            } else {
                System.out.println("No");
            }
            System.out.print("    El desafiado termino con algun esbirro sin derrotar: ");
            if (historial.get(i).getEsbirroSinDerrotar()[1] == 1){
                System.out.println("Si");
            } else {
                System.out.println("No");
            }
            System.out.println("    Oro ganado: " + historial.get(i).getOroGanado());
        }
        System.out.println();
    }
    
    public void elegirEquipo(Database data, String tipo){
        Scanner input = new Scanner(System.in);
        String opcion;
        Personaje personajeData;
        
        switch (tipo){
            case "Vampiro": personajeData = data.getPersonaje(0);
                            break;
            
            case "Licantropo": personajeData = data.getPersonaje(1);
                            break;
            
            case "Cazador": personajeData = data.getPersonaje(2);
                            break;
            default: personajeData = null;
                     break;
        }
        if (personajeData == null){
            return ;
        }
        HashMap<String, Arma> armas = personajeData.getArmas();
        HashMap<String, Armadura> armaduras = personajeData.getArmaduras();
        String[] armaActiva = ((Cliente) this).getPersonaje().getArmaActiva();
        double peso = 0;
        int i = 0;
        if (armaActiva[0] == null){
            System.out.print("\n--Arma Activa: Ninguna");
        } else {
            System.out.print("\n--Arma Activa: " + armaActiva[0]);
            if (armaActiva[1] != null){
                System.out.println(", " + armaActiva[1]);
            } else {
                System.out.println();
            }
        }
        if (((Cliente) this).getPersonaje().getArmaduraActiva() == null){
            System.out.println("\n--Armadura Activa: Ninguna\n");
        } else {
            System.out.println("\n--Armadura Activa: " + ((Cliente) this).getPersonaje().getArmaduraActiva() + "\n");
        }
        System.out.println("Elegir arma: (Escribir su nombre)");
        do {
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
            opcion = input.nextLine();
            if (armas.containsKey(opcion)){
                peso = peso + armas.get(opcion).getPeso();
                armaActiva[i] = opcion;
                i++;
            } else {
                System.out.println("Por favor escriba un nombre de arma correcto\n");
            }
        } while (peso < 1);
        if (peso != 1){
            System.out.println("\n--- Mala configuracion de armas (Maximo 2 manos en total) ---\n");
            armaActiva[0] = null;
            armaActiva[1] = null;
            return;
        }
        System.out.println("Elegir armadura: (Escribir su nombre)");
        do {
            for (Map.Entry<String, Armadura> entry : armaduras.entrySet()){
                System.out.println("-- '" + entry.getKey() + "':");
                System.out.println("    Modificacion de ataque: " + entry.getValue().getModifAtaque());
                System.out.println("    Modificacion de defesa: " + entry.getValue().getModifDefensa());
            }
            opcion = input.nextLine();
            if (armaduras.containsKey(opcion)){
                ((Cliente) this).getPersonaje().setArmaduraActiva(opcion);
            } else {
                System.out.println("Por favor escriba un nombre de armadura correcto\n");
            }
        } while (!armaduras.containsKey(opcion));
        System.out.println("\n--- Seleccion de equipo finalizada correctamente ---\n");
    }
    
    public void registrarPersonaje(){
        Scanner input = new Scanner(System.in);
        Integer opcion;
        String nombre;
        
        System.out.println("Elija una opcion:");
        System.out.println("1.- Seleccionar vampiro");
        System.out.println("2.- Seleccionar licantropo");
        System.out.println("3.- Seleccionar cazador");
        System.out.println("4.- Volver");
        opcion = input.nextInt();
        switch (opcion){
            case 1: input.nextLine();
                    System.out.println("Escriba el nombre de su personaje:");
                    nombre = input.nextLine();
                    personaje = new PersonajeUsuario("Vampiro", nombre);
                    break;

            case 2: input.nextLine();
                    System.out.println("Escriba el nombre de su personaje:");
                    nombre = input.nextLine();
                    personaje = new PersonajeUsuario("Licantropo", nombre);
                    break;

            case 3: input.nextLine();
                    System.out.println("Escriba el nombre de su personaje:");
                    nombre = input.nextLine();
                    personaje = new PersonajeUsuario("Cazador", nombre);
                    break;

            case 4: break;

            default:System.out.println("\n--- Por favor seleccione una opcion correcta ---\n");
                    break;
        }
    }
    
    public void desafiarUsuario(Database data){
        Scanner input = new Scanner(System.in);
        String nick;
        Integer tipoDesafiante, tipoDesafiado;
        Desafio desafio;
        long oroApostado;
        
        if (this.getPersonaje().getArmaActiva()[0] == null || this.getPersonaje().getArmaduraActiva() == null){
            System.out.println("\n--- Seleccione equipo activo antes de desafiar un jugador ---\n");
            return ;
        }
        System.out.println("Escriba el nick al usuario al que desea desafiar:");
        nick = input.nextLine();
        if (!data.checkNick(nick)){
            System.out.println("\n--- No existe ningun usuario con ese nick ---\n");
            return ;
        }
        if(nick.equals(this.getNick())){
            System.out.println("\n--- No se puede desafiar a si mismo ---\n");
            return ;
        }
        if (data.getUsuarioByNick(nick) instanceof Operador){
            System.out.println("\n--- Este usuario es un operador, no se le puede desafiar ---\n");
            return ;
        }
        if (((Cliente) data.getUsuarioByNick(nick)).getPersonaje() == null){
            System.out.println("\n--- El usuario seleccionado no tiene ningun personaje registrado ---\n");
            return ;
        }
        System.out.println("Cuanto oro desea apostar:");
        oroApostado = input.nextLong();
        if (oroApostado < 0 || oroApostado > personaje.getOro()){
            System.out.println("\n--- Cantidad de oro no valida ---\n");
            return ;
        }
        switch (this.getPersonaje().getTipo()){
            case "Vampiro": tipoDesafiante = 0;
                            break;
        
            case "Licantropo": tipoDesafiante = 1;
                               break;
        
            case "Cazador": tipoDesafiante = 2;
                            break;
            default: tipoDesafiante = null;
                     break;
        }
        switch (((Cliente) data.getUsuarioByNick(nick)).getPersonaje().getTipo()){
            case "Vampiro": tipoDesafiado = 0;
                            break;
        
            case "Licantropo": tipoDesafiado = 1;
                               break;
        
            case "Cazador": tipoDesafiado = 2;
                            break;
            default: tipoDesafiado = null;
                     break;
        }
        if (tipoDesafiante == null || tipoDesafiado == null){
            return ;
        }
        desafio = new Desafio(this.getNombre(), data.getPersonaje(tipoDesafiante).getDebilidades(), data.getPersonaje(tipoDesafiante).getFortalezas(), nick, data.getPersonaje(tipoDesafiado).getDebilidades(), data.getPersonaje(tipoDesafiante).getFortalezas(), oroApostado);
        data.getDesafios().add(desafio);
        this.personaje.actualizarOro(-desafio.getOroApostado());
        System.out.println("\n--- Desafio añadido correctamente ---\n");
    }
    
    public void darBajaPersonaje(){
        Scanner input = new Scanner(System.in);
        Integer opcion;
        
        System.out.println("Esá seguro que desea eliminar su personaje?\n1.- Si\n2.- No");
        opcion = input.nextInt();
        if (opcion == 1){
            personaje = null;
            System.out.println("\n--- Personaje eliminado correctamente ---\n");
        } else {
            System.out.println("\n--- Eliminacion de personaje cancelada ---\n");
        }
    }
}
