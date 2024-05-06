/*
 * FacadeCrearCuentaCliente.java
 */
package crearCuentaCliente;

import excepciones.CrearCuentaClienteException;
import dtos.UsuarioDTO;

/**
 * Clase fachada que implementa los métodos de la interfaz ICrearCuentaCliente
 * para facilitar el uso del subsistema al usuario.
 *
 * @author Diego Valenzuela Parra - 00000247700
 */
public class FacadeCrearCuentaCliente implements ICrearCuentaCliente {

    private final CtrlCrearCuentaCliente ctrlCrearCuenta;

    /**
     * Constructor que inicializa el atributo de la clase.
     */
    public FacadeCrearCuentaCliente() {
        ctrlCrearCuenta = new CtrlCrearCuentaCliente();
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
