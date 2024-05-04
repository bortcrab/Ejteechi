package interfaces;

import dtos.UsuarioDTO;
import excepciones.ObjetosNegocioException;

/**
 *
 * @author Diego Valenzuela Parra - 00000247700
 */
public interface IUsuarioBO {
    public UsuarioDTO agregarUsuario(UsuarioDTO usuarioDTO) throws ObjetosNegocioException;

    public UsuarioDTO obtenerUsuario(UsuarioDTO usuario) throws ObjetosNegocioException;
}
