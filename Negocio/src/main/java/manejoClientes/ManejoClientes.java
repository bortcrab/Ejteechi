package manejoClientes;

import dto.ClienteDTO;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego Valenzuela Parra - 00000247700
 * @author Juventino López García - 00000248547
 */
public class ManejoClientes implements IManejoClientes {

    @Override
    public void registrar(ClienteDTO cliente) {
//        ValidacionCliente vc = new ValidacionCliente();
//        RegistroCliente rc = new RegistroCliente();
//        if(vc.validar(cliente)) {
//            rc.guardar(cliente);
//        } else {
//            JOptionPane.showMessageDialog(null, "El cliente ya está registrado.", "¡Error!", JOptionPane.ERROR_MESSAGE);
//        }
    }

    @Override
    public void ingresar(ClienteDTO cliente) {
//        ObtenCliente oc = new ObtenCliente();
//        if(oc.buscar(cliente) != null) {
//            EjteechiFacade ef = new EjteechiFacade();
//        } else {
//            JOptionPane.showMessageDialog(null, "El cliente ya está registrado.", "¡Error!", JOptionPane.ERROR_MESSAGE);
//        }
    }

}
