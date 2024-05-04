package implementaciones;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import entidades.Usuario;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;
import interfaces.IConexion;
import interfaces.IUsuarioDAO;

public class UsuarioDAO implements IUsuarioDAO {

    private final IConexion conexion;
    private MongoCollection<Usuario> coleccion;
    private static final Logger logger = Logger.getLogger(UsuarioDAO.class.getName());
    
    public UsuarioDAO() {
        conexion = new Conexion();
    }
    
    @Override
    public void agregarUsuario(Usuario usuario) {
        MongoDatabase db = conexion.crearConexion();
        coleccion = db.getCollection("usuarios", Usuario.class);
        
        // Definir la operación de agregación con $lookup
        coleccion.insertOne(usuario);
        
        logger.log(Level.INFO, "Se ha insertado un documento en la colección 'usuarios'.");
    }

    @Override
    public Usuario obtenerUsuarioCorreo(String correo) {
        MongoDatabase db = conexion.crearConexion();
        coleccion = db.getCollection("usuarios", Usuario.class);
        
        // Filtro
        Document filtro = new Document("correo", correo);
        
        Usuario usuario = coleccion.find(filtro).first();
        logger.log(Level.INFO, "Se ha consultado la colección 'usuarios'.");
        conexion.cerrarConexion();
        
        return usuario;
    }
    
    @Override
    public Usuario obtenerUsuarioCorreoContra(String correo, String contrasenia) {
        MongoDatabase db = conexion.crearConexion();
        coleccion = db.getCollection("usuarios", Usuario.class);
        
        // Filtro
        Document filtro = new Document("correo", correo).append("contrasenia", contrasenia);
        
        Usuario usuario = coleccion.find(filtro).first();
        logger.log(Level.INFO, "Se ha consultado la colección 'usuarios'.");
        conexion.cerrarConexion();
        
        return usuario;
    }
    
}
