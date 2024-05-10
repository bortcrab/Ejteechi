package interfaces;

import dtos.RespuestaDTO;
import dtos.TicketDTO;
import dtos.UsuarioDTO;
import excepciones.ObjetosNegocioException;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Diego Valenzuela Parra - 00000247700
 */
public interface ITicketBO {
    
    public void enviarTicket(TicketDTO ticketDTO);

    public List<TicketDTO> obtenerTickets(UsuarioDTO usuario);

    public TicketDTO obtenerTicket(ObjectId folio);

    public TicketDTO enviarRespuesta(ObjectId folio, RespuestaDTO respuesta);

    public List<TicketDTO> obtenerTodosTickets();

    public void cambiarEstado(TicketDTO ticketDTO);
}
