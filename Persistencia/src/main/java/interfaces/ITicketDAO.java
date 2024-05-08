package interfaces;

import colecciones.Ticket;
import java.util.List;

/**
 *
 * @author Diego Valenzuela Parra - 00000247700
 */
public interface ITicketDAO {
    public void agregarTicket(Ticket ticket);

    public List<Ticket> obtenerTickets(String id);

    public Ticket obtenerTicket(String folio);

}
