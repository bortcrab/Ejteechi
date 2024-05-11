package implementaciones;

import colecciones.Queja;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import conexion.Conexion;
import conexion.IConexion;
import excepciones.PersistenciaException;
import interfaces.IQuejaDAO;
import java.util.ArrayList;
import java.util.List;
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
    public void insertarQueja(Queja queja) throws PersistenciaException{
    if (queja.isAnonimo()) {
        queja.setIdCliente(null);
    }
        coleccion.insertOne(queja);
        logger.log(Level.INFO, "Se ha insertado la queja en la colección 'quejas'.");
        conexion.cerrarConexion();
    }

    @Override
    public List<Queja> obtenerQuejasPorTipo(String tipo) throws PersistenciaException{
      List<Queja> quejasPorTipo = new ArrayList<>();
        try {
            for (Queja queja : coleccion.find(eq("tipoQueja", tipo))) {
                quejasPorTipo.add(queja);
            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Error al obtener quejas por tipo", ex);
            throw new PersistenciaException(ex.getMessage());
        }
        return quejasPorTipo;
    }

    @Override
    public List<Queja> obtenerTodasLasQuejas() throws PersistenciaException{
         List<Queja> todasLasQuejas = new ArrayList<>();
        try {
            for (Queja queja : coleccion.find()) {
                todasLasQuejas.add(queja);
            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Error al obtener todas las quejas", ex);
            throw new PersistenciaException(ex.getMessage());
        }
        return todasLasQuejas;
    }

    @Override
    public List<Queja> obtenerQuejasLeidas() throws PersistenciaException{
        List<Queja> quejasLeidas = new ArrayList<>();
        try {
            for (Queja queja : coleccion.find(eq("leido", true))) {
                quejasLeidas.add(queja);
            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Error al obtener quejas leídas", ex);
            throw new PersistenciaException(ex.getMessage());
        }
        return quejasLeidas;
    }

    @Override
    public List<Queja> obtenerQuejasNoLeidas() throws PersistenciaException{
        List<Queja> quejasNoLeidas = new ArrayList<>();
        try {
            for (Queja queja : coleccion.find(eq("leido", false))) {
                quejasNoLeidas.add(queja);
            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Error al obtener quejas no leídas", ex);
            throw new PersistenciaException(ex.getMessage());
        }
        return quejasNoLeidas;
    }
    }


