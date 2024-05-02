package objetosNegocio;

import dtos.ClienteDTO;

public interface IClienteBO {
    public ClienteDTO agregarCuenta(ClienteDTO clienteDTO) throws ObjetosNegocioException;
}
