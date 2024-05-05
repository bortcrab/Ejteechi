/*
 * UsuarioBO.java
 */
package implementaciones;

import colecciones.Usuario;
import excepciones.ObjetosNegocioException;
import interfaces.IUsuarioBO;
import utilidades.Encriptador;
import dtos.UsuarioDTO;
import interfaces.IUsuarioDAO;

/**
 * Clase que implementa los métodos de la interfaz IUsuarioBO para aplicar
 * reglas de negocio relacionadas con los usuarios.
 *
 * @author Diego Valenzuela Parra - 00000247700
 */
public class UsuarioBO implements IUsuarioBO {

    private final IUsuarioDAO usuarioDAO;
    private final Encriptador encriptador;

    /**
     * Constructor que inicializa los atributos de la clase.
     */
    public UsuarioBO() {
        this.usuarioDAO = new UsuarioDAO();
        this.encriptador = new Encriptador();
    }

    /**
     * Método para agregar un usuario.
     *
     * @param usuarioDTO Usuario que se agregará.
     * @return El usuario ya insertado con sus datos encriptados.
     * @throws ObjetosNegocioException si ya existe una cuenta creada con el
     * correo proporcionado.
     */
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

    /**
     * Método para obtener un usuario.
     *
     * @param usuarioDTO Usuario a buscar.
     * @return El usuario encontrado.
     * @throws ObjetosNegocioException si no se encontró el usuario.
     */
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

    /**
     * Método para convertir de UsuarioDTO a una entidad Usuario.
     *
     * @param usuarioDTO UsuarioDTO a convertir.
     * @return La entidad de Usuario ya convertida.
     * @throws Exception si ocurre un error de encriptación.
     */
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

    /**
     * Método para convertir de una entidad Usuario a UsuarioDTO.
     *
     * @param usuarioEnt Entidad de Usuario a convertir.
     * @return UsuarioDTO ya convertido.
     */
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
