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
    public List<TicketDTO> obtenerTodosTickets(ObjectId idAtendiendo) {
        return ctrlAtenderTickets.obtenerTodosTickets(idAtendiendo);
    }

    @Override
    public TicketDTO enviarRespuestaTrabajador(ObjectId folio, RespuestaDTO respuesta, ObjectId idAtendiendo) {
        return ctrlAtenderTickets.enviarRespuestaTrabajador(folio, respuesta, idAtendiendo);
    }

    @Override
    public void cambiarEstado(TicketDTO ticket) {
        ctrlAtenderTickets.cambiarEstado(ticket);
    }

}
