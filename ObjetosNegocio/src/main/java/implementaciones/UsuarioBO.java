package implementaciones;

import excepciones.ObjetosNegocioException;
import interfaces.IUsuarioBO;
import utilidades.Encriptador;
import dtos.UsuarioDTO;
import entidades.Usuario;
import implementaciones.UsuarioDAO;
import interfaces.IUsuarioDAO;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego Valenzuela Parra - 00000247700
 */
public class UsuarioBO implements IUsuarioBO {
    
    private final IUsuarioDAO usuarioDAO;
    private final Encriptador encriptador;

    public UsuarioBO() {
        this.usuarioDAO = new UsuarioDAO();
        this.encriptador = new Encriptador();
    }
    
    @Override
    public UsuarioDTO agregarUsuario(UsuarioDTO usuarioDTO) throws ObjetosNegocioException {
        try {
            Usuario usuarioEnt = usuarioDAO.obtenerUsuarioCorreo(encriptador.encriptar(usuarioDTO.getCorreo()));
            
            if (usuarioEnt != null) {
                throw new ObjetosNegocioException("Ese correo ya está registrado.");
            }
            
            usuarioEnt = convertirUsuario(usuarioDTO);
            
            usuarioDAO.agregarUsuario(usuarioEnt);
            
            usuarioDTO = convertirUsuario(usuarioEnt);
            
            return usuarioDTO;
        } catch (Exception ex) {
            throw new ObjetosNegocioException(ex.getMessage());
        }
    }
    
    @Override
    public UsuarioDTO obtenerUsuario(UsuarioDTO usuarioDTO) throws ObjetosNegocioException {
        try {
            String correo = encriptador.encriptar(usuarioDTO.getCorreo());
            String contrasenia = encriptador.encriptar(usuarioDTO.getContra());
            
            Usuario usuarioEnt = usuarioDAO.obtenerUsuarioCorreoContra(correo, contrasenia);
            if (usuarioEnt == null) {
                throw new ObjetosNegocioException("No se encontró ninguna cuenta con los datos ingresados.");
            }
            
            usuarioDTO = convertirUsuario(usuarioEnt);
            
            return usuarioDTO;
        } catch (Exception ex) {
            throw new ObjetosNegocioException(ex.getMessage());
        }
    }
    
    private Usuario convertirUsuario(UsuarioDTO usuarioDTO) throws Exception {
        Usuario usuarioEnt = new Usuario(
                usuarioDTO.getNombres(),
                usuarioDTO.getApellidoPaterno(),
                usuarioDTO.getApellidoMaterno(),
                usuarioDTO.getTelefono(),
                encriptador.encriptar(usuarioDTO.getCorreo()),
                encriptador.encriptar(usuarioDTO.getContra()),
                usuarioDTO.getCurp(),
                usuarioDTO.getRfc(),
                usuarioDTO.getTipo());
        
        return usuarioEnt;
    }
    
    private UsuarioDTO convertirUsuario(Usuario usuarioEnt) {
        UsuarioDTO usuarioDTO = new UsuarioDTO(
                usuarioEnt.getNombres(),
                usuarioEnt.getApellidoPaterno(),
                usuarioEnt.getApellidoMaterno(),
                usuarioEnt.getTelefono(),
                usuarioEnt.getCurp(),
                usuarioEnt.getRfc(),
                usuarioEnt.getCorreo(),
                usuarioEnt.getContrasenia(),
                usuarioEnt.getTipo());
        
        return usuarioDTO;
    }

}
