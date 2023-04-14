
package MetProg;

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
}
