
package MetProg;

public class Usuario {
    private String nombre;
    private String nick;
    private String contraseña;

    public Usuario(String nombre, String nick, String contraseña) {
        this.nombre = nombre;
        this.nick = nick;
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNick() {
        return nick;
    }

    public String getContraseña() {
        return contraseña;
    }
}
