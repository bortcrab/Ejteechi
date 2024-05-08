/*
 * IUsuarioBO.java
 */
package interfaces;

import dtos.UsuarioDTO;
import excepciones.ObjetosNegocioException;

/**
 * Interfaz que define los métodos para aplicar las reglas de negocio en lo
 * relacionado a los usuarios.
 *
 * @author Diego Valenzuela Parra - 00000247700
 */
public interface IUsuarioBO {

    /**
     * Método para agregar un usuario.
     *
     * @param usuarioDTO Usuario que se agregará.
     * @return El usuario ya insertado con sus datos encriptados.
     * @throws ObjetosNegocioException si ya existe una cuenta creada con el
     * correo proporcionado.
     */
    public UsuarioDTO agregarUsuario(UsuarioDTO usuarioDTO) throws ObjetosNegocioException;

    public UsuarioDTO obtenerUsuarioCorreoContra(UsuarioDTO usuario) throws ObjetosNegocioException;
    
}
