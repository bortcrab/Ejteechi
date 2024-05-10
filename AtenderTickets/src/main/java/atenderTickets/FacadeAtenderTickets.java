package atenderTickets;

import dtos.RespuestaDTO;
import dtos.TicketDTO;
import dtos.UsuarioDTO;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Diego Valenzuela Parra - 00000247700
 */
public class FacadeAtenderTickets implements IAtenderTickets {

    private final CtrlAtenderTickets ctrlAtenderTickets;

    public FacadeAtenderTickets() {
        ctrlAtenderTickets = new CtrlAtenderTickets();
    }

    @Override
    public List<TicketDTO> obtenerTodosTickets() {
        return ctrlAtenderTickets.obtenerTodosTickets();
    }

    @Override
    public TicketDTO enviarRespuesta(ObjectId folio, RespuestaDTO respuesta) {
        return ctrlAtenderTickets.enviarRespuesta(folio, respuesta);
    }

    @Override
    public void cambiarEstado(TicketDTO ticket) {
        ctrlAtenderTickets.cambiarEstado(ticket);
    }

}
