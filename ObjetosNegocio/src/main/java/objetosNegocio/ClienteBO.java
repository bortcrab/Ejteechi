package objetosNegocio;

import dtos.ClienteDTO;
import persistencia.Cliente;
import persistencia.ClienteDAO;
import persistencia.IClienteDAO;
import persistencia.PersistenciaException;

public class ClienteBO implements IClienteBO {  

    private final IClienteDAO clienteDAO = new ClienteDAO();
    private final Encriptador encriptador = new Encriptador();
    
    @Override
    public ClienteDTO agregarCuenta(ClienteDTO clienteDTO) throws ObjetosNegocioException {
        try {
            Cliente clienteEntidad = new Cliente(
                    encriptador.encriptar(clienteDTO.getCorreo()),
                    encriptador.encriptar(clienteDTO.getContra())
            );
            
            Cliente clienteBuscado = clienteDAO.obtenerCliente(clienteEntidad);
            if (clienteBuscado != null) {
                throw new ObjetosNegocioException("Ese correo ya está registrado.");
            }
            
            clienteDAO.agregarCuenta(clienteEntidad);
            
            return clienteDTO;
        } catch (PersistenciaException pe) {
            throw new ObjetosNegocioException(pe.getMessage());
        } catch (Exception ex) {
            throw new ObjetosNegocioException(ex.getMessage());
        }
    }            
}
