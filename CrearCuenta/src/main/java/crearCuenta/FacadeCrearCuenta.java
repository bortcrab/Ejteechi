package crearCuenta;

import dtos.ClienteDTO;

public class FacadeCrearCuenta implements ICrearCuenta {

    private final CtrlCrearCuenta ctrlCrearCuenta = new CtrlCrearCuenta();
    
    @Override
    public ClienteDTO crearCuenta(ClienteDTO clienteDTO) throws CrearCuentaException {
        try {
            ctrlCrearCuenta.crearCuenta(clienteDTO);
            
            return clienteDTO;
        } catch (CrearCuentaException cce) {
            throw cce;
        }
    }
    
}
