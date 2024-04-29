package persistencia;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;

public class ClienteDAO implements IClienteDAO {

    private final IConexion conexion = new Conexion();
    private MongoCollection<Cliente> coleccion;
    private static final Logger logger = Logger.getLogger(ClienteDAO.class.getName());
    
    @Override
    public Cliente agregarCuenta(Cliente cliente) throws PersistenciaException {
        MongoDatabase db = conexion.crearConexion();
        coleccion = db.getCollection("clientes", Cliente.class);
        
        // Definir la operación de agregación con $lookup
        coleccion.insertOne(cliente);
        
        logger.log(Level.INFO, "Se ha insertado un documento en la colección 'clientes'.");
        
        obtenerCliente(cliente);
        
        return cliente;
    }

    @Override
    public Cliente obtenerCliente(Cliente cliente) {
        MongoDatabase db = conexion.crearConexion();
        coleccion = db.getCollection("clientes", Cliente.class);
        
        // Filtro
        Document filtro = new Document("correo", cliente.getCorreo());
        
        // Definir la operación de agregación con $lookup
        cliente = coleccion.find(filtro).first();
        
        logger.log(Level.INFO, "Se ha consultado la colección 'clientes'.");
        
        return cliente;
    }
    
}
