package administrarTickets;

import dtos.TicketDTO;
import dtos.UsuarioDTO;
import excepciones.AdministrarTicketsException;
import java.util.List;

/**
 *
 * @author Diego Valenzuela Parra - 00000247700
 */
public class FacadeAdministrarTickets implements IAdministrarTickets {

    private final CtrlAdministrarTickets ctrlContactarAtnAlCliente;

    public FacadeAdministrarTickets() {
        this.ctrlContactarAtnAlCliente = new CtrlAdministrarTickets();
    }

    @Override
    public void enviarTicket(TicketDTO ticket) throws AdministrarTicketsException {
        ctrlContactarAtnAlCliente.enviarTicket(ticket);
    }

    @Override
    public List<TicketDTO> obtenerTickets(UsuarioDTO usuario) {
        return ctrlContactarAtnAlCliente.obtenerTickets(usuario);
    }

    @Override
    public TicketDTO obtenerTicket(String folio) {
        return ctrlContactarAtnAlCliente.obtenerTicket(folio);
    }

}
