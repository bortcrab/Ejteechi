package administrarTickets;

import dtos.RespuestaDTO;
import dtos.TicketDTO;
import dtos.UsuarioDTO;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Diego Valenzuela Parra - 00000247700
 */
public class FacadeAdministrarTickets implements IAdministrarTickets {

    private final CtrlAdministrarTickets ctrlContactarAtnAlCliente;

    public FacadeAdministrarTickets() {
        ctrlContactarAtnAlCliente = new CtrlAdministrarTickets();
    }

    @Override
    public void enviarTicket(TicketDTO ticket) {
        ctrlContactarAtnAlCliente.enviarTicket(ticket);
    }

    @Override
    public List<TicketDTO> obtenerTickets(UsuarioDTO usuario) {
        return ctrlContactarAtnAlCliente.obtenerTickets(usuario);
    }

    @Override
    public TicketDTO enviarRespuesta(ObjectId folio, RespuestaDTO respuesta) {
        return ctrlContactarAtnAlCliente.enviarRespuesta(folio, respuesta);
    }

}
