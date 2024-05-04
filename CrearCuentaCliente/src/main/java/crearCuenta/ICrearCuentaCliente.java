package crearCuenta;

import dtos.UsuarioDTO;

public interface ICrearCuentaCliente {
    public UsuarioDTO crearCuenta(UsuarioDTO usuario) throws CrearCuentaClienteException;
}
