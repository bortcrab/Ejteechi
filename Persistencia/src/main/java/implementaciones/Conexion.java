package implementaciones;

import interfaces.IConexion;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

public class Conexion implements IConexion {
    
    private final ConnectionString cadenaConexion = new ConnectionString("mongodb://diegovalenzuela247700:wYZZNu9bnHOtHsQN@ac-rvttj18-shard-00-00.kjczdex.mongodb.net:27017,ac-rvttj18-shard-00-01.kjczdex.mongodb.net:27017,ac-rvttj18-shard-00-02.kjczdex.mongodb.net:27017/?ssl=true&replicaSet=atlas-xfbyw1-shard-0&authSource=admin&retryWrites=true&w=majority&appName=ejteechi");
    private final String nombreBaseDatos = "ejteechidb";
    private static final Logger logger = Logger.getLogger(Conexion.class.getName());
    private MongoClient servidor;
    
    @Override
    public MongoDatabase crearConexion() {
        // Configura el proveedor de códecs para trabajar con objetos Java y MongoDB
        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());

        // Combina el proveedor de códecs POJO con el registro de códecs predeterminado de MongoDB
        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);

        // Configura los ajustes del cliente MongoDB, incluyendo la cadena de conexión y el registro de códecs
        MongoClientSettings clientsSettings = MongoClientSettings.builder()
                .applyConnectionString(cadenaConexion)
                .codecRegistry(codecRegistry)
                .build();

        // Crea un cliente MongoDB utilizando los ajustes configurados
        servidor = MongoClients.create(clientsSettings);
        
        logger.log(Level.INFO, "Se ha establecido la conexión con el servidor.");
        
        // Obtiene la base de datos específicada y la devuelve.
        return servidor.getDatabase(nombreBaseDatos);
    }
    
    @Override
    public void cerrarConexion() {
        servidor.close();
        logger.log(Level.INFO, "Se ha cerrado la conexión con el servidor.");
    }
}
