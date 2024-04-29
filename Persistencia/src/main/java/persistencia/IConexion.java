package persistencia;

import com.mongodb.client.MongoDatabase;

public interface IConexion {
    public MongoDatabase crearConexion();
}
