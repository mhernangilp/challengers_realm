
package MetProg;

public class Cliente extends Usuario{
    private String numReg;

    public Cliente(String nombre, String nick, String contraseña, String numReg) {
        super(nombre, nick, contraseña);
        this.numReg = numReg;
    }

    public String getNumReg() {
        return numReg;
    }
}
