package contactarAtnAlCliente;

import dtos.TicketDTO;
import dtos.UsuarioDTO;
import excepciones.EnviarTicketException;
import excepciones.ObjetosNegocioException;
import implementaciones.TicketBO;
import interfaces.ITicketBO;
import java.util.List;

/**
 *
 * @author Diego Valenzuela Parra - 00000247700
 */
public class CtrlContactarAtnAlCliente {
    
    private final ITicketBO ticketBO;

    public CtrlContactarAtnAlCliente() {
        this.ticketBO = new TicketBO();
    }
    
    public void enviarTicket(TicketDTO ticket) throws EnviarTicketException {
        try {
            ticketBO.enviarTicket(ticket);
        } catch (ObjetosNegocioException one) {
            throw new EnviarTicketException(one.getMessage());
        }
    }

    public List<TicketDTO> obtenerTickets(UsuarioDTO usuario) {
        return ticketBO.obtenerTickets(usuario);
    }

    TicketDTO obtenerTicket(String folio) {
        return ticketBO.obtenerTicket(folio);
    }
}
