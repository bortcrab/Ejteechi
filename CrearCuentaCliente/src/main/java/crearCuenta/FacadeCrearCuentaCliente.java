package crearCuenta;

import dtos.UsuarioDTO;

public class FacadeCrearCuentaCliente implements ICrearCuentaCliente {

    private final CtrlCrearCuentaCliente ctrlCrearCuenta;
    
    public FacadeCrearCuentaCliente() {
        ctrlCrearCuenta = new CtrlCrearCuentaCliente();
    }
    
    @Override
    public UsuarioDTO crearCuenta(UsuarioDTO usuario) throws CrearCuentaClienteException {
        return ctrlCrearCuenta.crearCuenta(usuario);
    }
    
}
