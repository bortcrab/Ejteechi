package implementaciones;

import colecciones.Camion;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import conexion.Conexion;
import conexion.IConexion;
import interfaces.ICamionDAO;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CamionDAO implements ICamionDAO{
    
    private final IConexion conexion;
    private MongoCollection<Camion> coleccion;
    private static final Logger logger = Logger.getLogger(CamionDAO.class.getName());

    /**
     * Constructor que inicializa el atributo de conexión de la clase.
     */
    public CamionDAO() {
        conexion = new Conexion();
    }
    
     @Override
    public Camion obtenerPorNumeroUnidad(String numeroUnidad) {
        MongoDatabase db = conexion.crearConexion();
        coleccion = db.getCollection("camiones",  Camion.class);
        
        Camion cam = coleccion.find(Filters.eq("numeroUnidad", numeroUnidad)).first();

        if (cam == null) {
            logger.log(Level.WARNING, "No se encontró ningún camión con el número de unidad especificado: " + numeroUnidad);
            return null;
        }

        return cam;
    }

    @Override
    public Camion actualizarEstado(String numeroUnidad, String atributoEstado, String nuevoEstado) {
        MongoDatabase db = conexion.crearConexion();
        coleccion = db.getCollection("camiones",  Camion.class);
        coleccion.updateOne(Filters.eq("numeroUnidad", numeroUnidad), Updates.set(atributoEstado, nuevoEstado));
        return obtenerPorNumeroUnidad(numeroUnidad);
    }

    @Override
    public Camion actualizarPrioridadYFechaMantenimiento(String numeroUnidad, String nuevaPrioridad, Date nuevaFechaMantenimiento) {
        MongoDatabase db = conexion.crearConexion();
        coleccion = db.getCollection("camiones",  Camion.class);
        coleccion.updateOne(Filters.eq("numeroUnidad", numeroUnidad), Updates.combine(
                Updates.set("nivelPrioridad", nuevaPrioridad),
                Updates.set("fechaUltimoMantenimiento", nuevaFechaMantenimiento)
        ));
        return obtenerPorNumeroUnidad(numeroUnidad);
    }

    // Método auxiliar para convertir un documento de MongoDB en un objeto Camion
//    private Camion documentToCamion(Document doc) {
//        Camion camion = new Camion();
//        camion.setNumeroUnidad(doc.getString("numeroUnidad"));
//        camion.setEstadoMotor(doc.getString("estadoMotor"));
//        camion.setEstadoLimpieza(doc.getString("estadoLimpieza"));
//        camion.setEstadoLlantas(doc.getString("estadoLlantas"));
//        camion.setEstadoLuces(doc.getString("estadoLuces"));
//        camion.setFechaUltimoMantenimiento(doc.getDate("fechaUltimoMantenimiento"));
//        camion.setNivelPrioridad(doc.getString("nivelPrioridad"));
//        return camion;
//
//
//}
}
