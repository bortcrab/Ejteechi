package implementaciones;

import colecciones.Ticket;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import conexion.Conexion;
import conexion.IConexion;
import interfaces.ITicketDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 * 
 * @author Diego Valenzuela Parra - 00000247700
 */
public class TicketDAO implements ITicketDAO {

    private final IConexion conexion;
    private MongoCollection<Ticket> coleccion;
    private static final Logger logger = Logger.getLogger(TicketDAO.class.getName());
    
    public TicketDAO() {
        conexion = new Conexion();
    }
    
    @Override
    public void agregarTicket(Ticket ticket) {
        // Creamos la conexión con el servidor.
        MongoDatabase db = conexion.crearConexion();
        // Obtenemos la colección de tickets.
        coleccion = db.getCollection("tickets", Ticket.class);

        // Mandamos a insertar el ticket.
        coleccion.insertOne(ticket);

        // Imprimimos lo que se hizo.
        logger.log(Level.INFO, "Se ha insertado un documento en la colección 'tickets'.");
        conexion.cerrarConexion(); // Cerramos la conexión.
    }

    @Override
    public List<Ticket> obtenerTickets(String idUsuario) {
        // Creamos la conexión con el servidor.
        MongoDatabase db = conexion.crearConexion();
        // Obtenemos la colección de tickets.
        coleccion = db.getCollection("tickets", Ticket.class);

        /**
         * Filtro para indicar que sólo se busque usuarios cuyo correo sea el
         * mismo que el proporcionado.
         */
        Document filtro = new Document("idUsuario", new ObjectId(idUsuario));

        /**
         * Mandamos a ejecutar la consulta con el filtro, limitamos los
         * resultados a uno porque sólo debe haber un usuario con ese correo. Lo
         * que obtengamos lo guardamos en una variable.
         */
        FindIterable<Ticket> resultados = coleccion.find(filtro);

        List<Ticket> listaTickets = new ArrayList<>();
        MongoCursor<Ticket> cursor = resultados.iterator();
        while (cursor.hasNext()) {
            listaTickets.add(cursor.next());
        }
        
        // Imprimimos lo que se hizo.
        logger.log(Level.INFO, "Se ha insertado un documento en la colección 'tickets'.");
        conexion.cerrarConexion(); // Cerramos la conexión.
        
        return listaTickets;
    }

    @Override
    public Ticket obtenerTicket(String folio) {
        // Creamos la conexión con el servidor.
        MongoDatabase db = conexion.crearConexion();
        // Obtenemos la colección de tickets.
        coleccion = db.getCollection("tickets", Ticket.class);

        /**
         * Filtro para indicar que sólo se busque usuarios cuyo correo sea el
         * mismo que el proporcionado.
         */
        Document filtro = new Document("id", new ObjectId(folio));

        /**
         * Mandamos a ejecutar la consulta con el filtro, limitamos los
         * resultados a uno porque sólo debe haber un usuario con ese correo. Lo
         * que obtengamos lo guardamos en una variable.
         */
        Ticket ticket = coleccion.find(filtro).first();
        
        // Imprimimos lo que se hizo.
        logger.log(Level.INFO, "Se ha insertado un documento en la colección 'tickets'.");
        conexion.cerrarConexion(); // Cerramos la conexión.
        
        return ticket;
    }

}
