/*
 * ICrearCuentaCliente.java
 */
package crearCuenta;

import excepciones.CrearCuentaClienteException;
import dtos.UsuarioDTO;

/**
 * Interfaz que define los métodos que el subsistema puede realizar.
 *
 * @author Diego Valenzuela Parra - 00000247700
 */
public interface ICrearCuentaCliente {

    /**
     * Método para crear la cuenta de un usuario del tipo "cliente".
     *
     * @param usuario Usuario a quien se le creará la cuenta.
     * @return El usuario con sus datos encriptados.
     * @throws CrearCuentaClienteException si ya hay una cuenta con el correo
     * proporcionado.
     */
    public UsuarioDTO crearCuenta(UsuarioDTO usuario) throws CrearCuentaClienteException;

}
