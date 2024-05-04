package implementaciones;

import entidades.Mapa;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.logging.Level;
import java.util.logging.Logger;
import interfaces.IConexion;
import interfaces.IMapaDAO;
import excepciones.PersistenciaException;

public class MapaDAO implements IMapaDAO {
    
    private final IConexion conexion;
    private MongoCollection<Mapa> coleccion;
    private static final Logger logger = Logger.getLogger(MapaDAO.class.getName());
    
    public MapaDAO() {
        conexion = new Conexion();
    }
    
    @Override
    public Mapa obtenerMapa() throws PersistenciaException {
        MongoDatabase db = conexion.crearConexion();
        coleccion = db.getCollection("mapas", Mapa.class);
        
        Mapa mapa = coleccion.find().first();
        logger.log(Level.INFO, "Se ha consultado la colección 'mapas'.");
        conexion.cerrarConexion();
        
        if (mapa == null) {
            throw new PersistenciaException("No se encontró ningún mapa.");
        }
        return mapa;
    }
}
