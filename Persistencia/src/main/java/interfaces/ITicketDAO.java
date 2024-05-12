package interfaces;

import colecciones.Respuesta;
import colecciones.Ticket;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Diego Valenzuela Parra - 00000247700
 */
public interface ITicketDAO {
    
    public void agregarTicket(Ticket ticket);

    public List<Ticket> obtenerTickets(ObjectId id);

    public Ticket obtenerTicket(ObjectId folio);

    public void agregarRespuesta(ObjectId folio, Respuesta respuestaEnt);

    public List<Ticket> obtenerTodosTickets(ObjectId idAtendiendo);

    public void actualizarTicket(Ticket ticket);

}
