package crearCuenta;

import dtos.ClienteDTO;
import objetosNegocio.ClienteBO;
import objetosNegocio.IClienteBO;
import objetosNegocio.ObjetosNegocioException;

public class CtrlCrearCuenta {
    
    private final IClienteBO clienteBO = new ClienteBO();
    
    public ClienteDTO crearCuenta(ClienteDTO clienteDTO) throws CrearCuentaException {
        try {
            clienteBO.agregarCuenta(clienteDTO);
            
            return clienteDTO;
        } catch (ObjetosNegocioException one) {
            throw new CrearCuentaException(one.getMessage());
        }
    }
    
}
