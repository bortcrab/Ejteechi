/*
 * FacadeRegistrarCliente.java
 */
package registrarCliente;

import excepciones.CrearCuentaClienteException;
import dtos.UsuarioDTO;

/**
 * Clase fachada que implementa los métodos de la interfaz IRegistrarCliente
 para facilitar el uso del subsistema al usuario.
 *
 * @author Diego Valenzuela Parra - 00000247700
 */
public class FacadeRegistrarCliente implements IRegistrarCliente {

    private final CtrlRegistrarCliente ctrlCrearCuenta;

    /**
     * Constructor que inicializa el atributo de la clase.
     */
    public FacadeRegistrarCliente() {
        ctrlCrearCuenta = new CtrlRegistrarCliente();
    }

    /**
     * Método para crear la cuenta de un usuario del tipo "cliente".
     *
     * @param usuario Usuario a quien se le creará la cuenta.
     * @return El usuario con sus datos encriptados.
     * @throws CrearCuentaClienteException si ya hay una cuenta con el correo
     * proporcionado.
     */
    @Override
    public UsuarioDTO crearCuenta(UsuarioDTO usuario) throws CrearCuentaClienteException {
        return ctrlCrearCuenta.crearCuenta(usuario);
    }

}
