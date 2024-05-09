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
    public TicketDTO obtenerTicket(ObjectId folio) {
        return ctrlContactarAtnAlCliente.obtenerTicket(folio);
    }

}
