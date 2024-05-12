package atenderTickets;

import dtos.RespuestaDTO;
import dtos.TicketDTO;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Diego Valenzuela Parra - 00000247700
 */
public interface IAtenderTickets {

    public List<TicketDTO> obtenerTodosTickets(ObjectId idAtendiendo);
    
    public void cambiarEstado(TicketDTO ticket);

    public TicketDTO enviarRespuestaTrabajador(ObjectId folio, RespuestaDTO respuesta, ObjectId idAtendiendo);
}
