package interfaces;

import com.mongodb.client.MongoDatabase;

public interface IConexion {
    public MongoDatabase crearConexion();
    
    public void cerrarConexion();
}
