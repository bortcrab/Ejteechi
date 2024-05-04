package crearCuenta;

import dtos.UsuarioDTO;
import interfaces.IUsuarioBO;
import excepciones.ObjetosNegocioException;
import implementaciones.UsuarioBO;

public class CtrlCrearCuentaCliente {

    private final IUsuarioBO usuarioBO;

    public CtrlCrearCuentaCliente() {
        usuarioBO = new UsuarioBO();
    }

    public UsuarioDTO crearCuenta(UsuarioDTO usuario) throws CrearCuentaClienteException {
        try {
            return usuarioBO.agregarUsuario(usuario);
        } catch (ObjetosNegocioException one) {
            throw new CrearCuentaClienteException(one.getMessage());
        }
    }

}
