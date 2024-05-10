package administrarTickets;

import dtos.RespuestaDTO;
import dtos.TicketDTO;
import dtos.UsuarioDTO;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Diego Valenzuela Parra - 00000247700
 */
public interface IAdministrarTickets {

    public void enviarTicket(TicketDTO ticket);

    public List<TicketDTO> obtenerTickets(UsuarioDTO usuario);
    
    public TicketDTO enviarRespuesta(ObjectId folio, RespuestaDTO respuesta);
}
