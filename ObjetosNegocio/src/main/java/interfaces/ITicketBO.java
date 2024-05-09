package interfaces;

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
    public void enviarTicket(TicketDTO ticketDTO) throws ObjetosNegocioException;

    public List<TicketDTO> obtenerTickets(UsuarioDTO usuario);

    public TicketDTO obtenerTicket(ObjectId folio);
}
