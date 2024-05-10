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

    public List<TicketDTO> obtenerTodosTickets();
    
    public TicketDTO enviarRespuesta(ObjectId folio, RespuestaDTO respuesta);

    public void cambiarEstado(TicketDTO ticket);
}
