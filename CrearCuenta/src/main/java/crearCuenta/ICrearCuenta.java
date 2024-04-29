package crearCuenta;

import dtos.ClienteDTO;

public interface ICrearCuenta {
    public ClienteDTO crearCuenta(ClienteDTO clienteDTO) throws CrearCuentaException;
}
