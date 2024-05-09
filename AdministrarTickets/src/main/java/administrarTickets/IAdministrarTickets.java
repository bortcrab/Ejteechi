package administrarTickets;

import dtos.TicketDTO;
import dtos.UsuarioDTO;
import excepciones.AdministrarTicketsException;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Diego Valenzuela Parra - 00000247700
 */
public interface IAdministrarTickets {

    public void enviarTicket(TicketDTO ticket) throws AdministrarTicketsException;

    public List<TicketDTO> obtenerTickets(UsuarioDTO usuario);

    public TicketDTO obtenerTicket(ObjectId folio);
}
