package administrarTickets;

import dtos.RespuestaDTO;
import dtos.TicketDTO;
import dtos.UsuarioDTO;
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

    public void enviarTicket(TicketDTO ticket) {
        ticketBO.enviarTicket(ticket);
    }

    public List<TicketDTO> obtenerTickets(UsuarioDTO usuario) {
        return ticketBO.obtenerTickets(usuario);
    }

    public TicketDTO enviarRespuesta(ObjectId folio, RespuestaDTO respuesta) {
        return ticketBO.enviarRespuesta(folio, respuesta);
    }
}
