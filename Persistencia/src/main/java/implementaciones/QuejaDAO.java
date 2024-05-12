package implementaciones;

import colecciones.Queja;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import conexion.Conexion;
import conexion.IConexion;
import interfaces.IQuejaDAO;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QuejaDAO implements IQuejaDAO {

    private final IConexion conexion;
    private MongoCollection<Queja> coleccion;
    private static final Logger logger = Logger.getLogger(MapaDAO.class.getName());
    private MongoDatabase db;

    public QuejaDAO() {
        this.conexion = new Conexion();
        db = conexion.crearConexion();
        coleccion = db.getCollection("quejas", Queja.class);
    }

    @Override
    public void insertarQueja(Queja queja) {
 if (queja.isAnonimo()) {
        queja.setIdCliente(null);
    }
        coleccion.insertOne(queja);
        logger.log(Level.INFO, "Se ha insertado la queja en la colección 'quejas'.");
        conexion.cerrarConexion();
    }

}
