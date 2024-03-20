
package manejoClientes;

import dto.ClienteDTO;

/**
 *
 * @author Diego Valenzuela Parra - 00000247700
 * @author Juventino López García - 00000248547
 */
public interface IManejoClientes {
    public void registrar(ClienteDTO cliente);
    public void ingresar(ClienteDTO cliente);
}
