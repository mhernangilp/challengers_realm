
package MetProg;

import java.util.Scanner;

public class Cliente extends Usuario{
    private String numReg;
    private boolean baneado;
    private PersonajeUsuario personaje;

    public Cliente(String nombre, String nick, String contraseña, String numReg) {
        super(nombre, nick, contraseña);
        this.numReg = numReg;
    }

    public String getNumReg() {
        return numReg;
    }

    public boolean isBaneado() {
        return baneado;
    }

    public PersonajeUsuario getPersonaje() {
        return personaje;
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
