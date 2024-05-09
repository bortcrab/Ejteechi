package administrarTickets;

import dtos.TicketDTO;
import dtos.UsuarioDTO;
import excepciones.AdministrarTicketsException;
import excepciones.ObjetosNegocioException;
import implementaciones.TicketBO;
import interfaces.ITicketBO;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Diego Valenzuela Parra - 00000247700
 */
public class CtrlAdministrarTickets {
    
    private final ITicketBO ticketBO;

    public CtrlAdministrarTickets() {
        this.ticketBO = new TicketBO();
    }
    
    public void enviarTicket(TicketDTO ticket) throws AdministrarTicketsException {
        try {
            ticketBO.enviarTicket(ticket);
        } catch (ObjetosNegocioException one) {
            throw new AdministrarTicketsException(one.getMessage());
        }
    }

    public List<TicketDTO> obtenerTickets(UsuarioDTO usuario) {
        return ticketBO.obtenerTickets(usuario);
    }

    TicketDTO obtenerTicket(ObjectId folio) {
        return ticketBO.obtenerTicket(folio);
    }
}
