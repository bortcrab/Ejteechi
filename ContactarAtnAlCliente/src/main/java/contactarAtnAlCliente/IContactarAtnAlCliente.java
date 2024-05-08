package contactarAtnAlCliente;

import dtos.TicketDTO;
import dtos.UsuarioDTO;
import excepciones.EnviarTicketException;
import java.util.List;

/**
 *
 * @author Diego Valenzuela Parra - 00000247700
 */
public interface IContactarAtnAlCliente {

    public void enviarTicket(TicketDTO ticket) throws EnviarTicketException;

    public List<TicketDTO> obtenerTickets(UsuarioDTO usuario);

    public TicketDTO obtenerTicket(String folio);
}
