package manejoClientes;

import dto.ClienteDTO;

/**
 *
 * @author Diego Valenzuela Parra - 00000247700
 * @author Juventino López García - 00000248547
 */
public class ObtenCliente {
    protected ClienteDTO obtener(String nombre) {
        ClienteDTO cliente = new ClienteDTO(nombre, nombre+"@.com", nombre);
        return cliente;
    }
}
