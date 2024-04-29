package persistencia;

public interface IClienteDAO {
    
    public Cliente agregarCuenta(Cliente cliente) throws PersistenciaException;
    
    public Cliente obtenerCliente(Cliente cliente);
}
