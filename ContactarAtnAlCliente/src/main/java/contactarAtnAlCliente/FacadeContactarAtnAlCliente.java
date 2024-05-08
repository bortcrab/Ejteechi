package contactarAtnAlCliente;

import dtos.TicketDTO;
import dtos.UsuarioDTO;
import excepciones.EnviarTicketException;
import java.util.List;

/**
 *
 * @author Diego Valenzuela Parra - 00000247700
 */
public class FacadeContactarAtnAlCliente implements IContactarAtnAlCliente {

    private final CtrlContactarAtnAlCliente ctrlContactarAtnAlCliente;

    public FacadeContactarAtnAlCliente() {
        this.ctrlContactarAtnAlCliente = new CtrlContactarAtnAlCliente();
    }

    @Override
    public void enviarTicket(TicketDTO ticket) throws EnviarTicketException {
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
