package atenderTickets;

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
public class CtrlAtenderTickets {

    private final ITicketBO ticketBO;

    public CtrlAtenderTickets() {
        this.ticketBO = new TicketBO();
    }

    public List<TicketDTO> obtenerTodosTickets(ObjectId idAtendiendo) {
        return ticketBO.obtenerTodosTickets(idAtendiendo);
    }

    public TicketDTO enviarRespuestaTrabajador(ObjectId folio, RespuestaDTO respuesta, ObjectId idAtendiendo)  {
        return ticketBO.enviarRespuestaTrabajador(folio, respuesta, idAtendiendo);
    }

    public void cambiarEstado(TicketDTO ticket) {
        ticketBO.actualizarTicket(ticket);
    }
}
