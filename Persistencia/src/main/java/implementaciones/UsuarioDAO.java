/*
 * UsuarioDAO.java
 */
package implementaciones;

import colecciones.Usuario;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import conexion.Conexion;
import conexion.IConexion;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;
import interfaces.IUsuarioDAO;

/**
 * Clase que implementa los métodos de la interfaz IUsuarioDAO para realizar
 * operaciones relacionadas con la entidad Usuario en la base de datos.
 *
 * @author Diego Valenzuela Parra - 00000247700
 */
public class UsuarioDAO implements IUsuarioDAO {

    private final IConexion conexion;
    private MongoCollection<Usuario> coleccion;
    private static final Logger logger = Logger.getLogger(UsuarioDAO.class.getName());

    /**
     * Constructor que inicializa el atributo de conexión de la clase.
     */
    public UsuarioDAO() {
        conexion = new Conexion();
    }

    /**
     * Método para agregar un usuario a la base de datos.
     *
     * @param usuario Usuario a agregar.
     */
    @Override
    public void agregarUsuario(Usuario usuario) {
        // Creamos la conexión con el servidor.
        MongoDatabase db = conexion.crearConexion();
        // Obtenemos la colección de usuarios.
        coleccion = db.getCollection("usuarios", Usuario.class);

        // Mandamos a insertar el usuario.
        coleccion.insertOne(usuario);

        // Imprimimos lo que se hizo.
        logger.log(Level.INFO, "Se ha insertado un documento en la colección 'usuarios'.");
    }

    /**
     * Método para obtener un usuario de la base de datos dado su correo.
     *
     * @param correo Correo del usuario a buscar.
     * @return El usuario encontrado, null si no se encontró nada.
     */
    @Override
    public Usuario obtenerUsuarioCorreo(String correo) {
        // Creamos la conexión con el servidor.
        MongoDatabase db = conexion.crearConexion();
        // Obtenemos la colección de usuarios.
        coleccion = db.getCollection("usuarios", Usuario.class);

        /**
         * Filtro para indicar que sólo se busque usuarios cuyo correo sea el
         * mismo que el proporcionado.
         */
        Document filtro = new Document("correo", correo);

        /**
         * Mandamos a ejecutar la consulta con el filtro, limitamos los
         * resultados a uno porque sólo debe haber un usuario con ese correo. Lo
         * que obtengamos lo guardamos en una variable.
         */
        Usuario usuario = coleccion.find(filtro).first();
        // Mensajito indicando lo que se hizo.
        logger.log(Level.INFO, "Se ha consultado la colección 'usuarios'.");
        conexion.cerrarConexion(); // Cerramos la conexión.

        // Retornamos el usuario encontrado.
        return usuario;
    }

}
