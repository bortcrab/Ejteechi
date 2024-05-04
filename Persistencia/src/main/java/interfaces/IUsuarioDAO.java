package interfaces;

import entidades.Usuario;
import excepciones.PersistenciaException;

public interface IUsuarioDAO {
    
    public void agregarUsuario(Usuario usuario);
    
    public Usuario obtenerUsuarioCorreo(String correo);
    
    public Usuario obtenerUsuarioCorreoContra(String correo, String contrasenia);
}
