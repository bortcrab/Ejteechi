/*
 * CtrlCrearCuentaCliente.java
 */
package crearCuentaCliente;

import excepciones.CrearCuentaClienteException;
import dtos.UsuarioDTO;
import interfaces.IUsuarioBO;
import excepciones.ObjetosNegocioException;
import implementaciones.UsuarioBO;

/**
 * Clase control para crear la cuenta de un cliente.
 *
 * @author Diego Valenzuela Parra - 00000247700
 */
public class CtrlCrearCuentaCliente {

    private final IUsuarioBO usuarioBO;

    /**
     * Constructor que inicializa el atributo de la clase.
     */
    public CtrlCrearCuentaCliente() {
        usuarioBO = new UsuarioBO();
    }

    /**
     * Método para crear la cuenta de un usuario del tipo "cliente".
     *
     * @param usuario Usuario a quien se le creará la cuenta.
     * @return El usuario con sus datos encriptados.
     * @throws CrearCuentaClienteException si ya hay una cuenta con el correo
     * proporcionado.
     */
    public UsuarioDTO crearCuenta(UsuarioDTO usuario) throws CrearCuentaClienteException {
        try {
            // Mandamos a crear la cuenta y devolvemos el usuario con sus datos encriptados.
            return usuarioBO.agregarUsuario(usuario);
        } catch (ObjetosNegocioException one) {
            // Si ya existe una cuenta con el correo proporcionado.
            throw new CrearCuentaClienteException(one.getMessage());
        }
    }

}
