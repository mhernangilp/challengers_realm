
package MetProg;

import java.util.ArrayList;

public class Database {
    private ArrayList<Usuario> Usuarios = new ArrayList<Usuario>();

    public ArrayList<Usuario> getUsuarios() {
        return Usuarios;
    }
    
    public void loadData(){
        
    }
    
    public void saveData(){
        
    }
    
    public void eliminarUsuario(int posicion){
        Usuarios.remove(posicion);
    }
    
    public void añadirUsuario(Usuario usuario){
        Usuarios.add(usuario);
    }
    
    public int getPosUsuario(String nick){
        for (int i = 0; i < Usuarios.size(); i++){
            if (nick.equals(Usuarios.get(i).getNick())){
                return (i);
            }
        }
        return (-1);
    }
    
    public Usuario getUsuarioByPos(int pos){
        return Usuarios.get(pos);
    }
    
    //check if nick is in use, return true if it already exists.
    public boolean checkNick(String nick){
        for (int i = 0; i < Usuarios.size(); i++){
            if (nick.equals(Usuarios.get(i).getNick())){
                return true;
            }
        }
        return false;
    }

    //check if numReg is in use, return true if it already exists.
    public boolean checkNumReg(String numReg){
        for (int i = 0; i < Usuarios.size(); i++){
            if (Usuarios.get(i) instanceof Cliente){
                if (numReg.equals(((Cliente)Usuarios.get(i)).getNumReg())){
                    return true;
                }
            }
        }
        return false;
    }
    
    //check if the password "contraseña" is the same as the Usuario user with "nick" nick.
    public boolean checkNickPass(String nick, String contraseña){
        for (int i = 0; i < Usuarios.size(); i++){
            if (nick.equals(Usuarios.get(i).getNick())){
                if (contraseña.equals(Usuarios.get(i).getContraseña())){
                    return true;
                }
            }
        }
        return false;
    }
}
