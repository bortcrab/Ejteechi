package implementaciones;

import colecciones.Respuesta;
import colecciones.Ticket;
import dtos.RespuestaDTO;
import dtos.TicketDTO;
import dtos.UsuarioDTO;
import interfaces.ITicketBO;
import interfaces.ITicketDAO;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Diego Valenzuela Parra - 00000247700
 */
public class TicketBO implements ITicketBO {

    private final ITicketDAO ticketDAO;

    public TicketBO() {
        this.ticketDAO = new TicketDAO();
    }
    
    @Override
    public void enviarTicket(TicketDTO ticketDTO) {
        Ticket ticketEnt = convertirTicket(ticketDTO);
        ticketEnt.setIdUsuario(ticketDTO.getIdUsuario());
        ticketDAO.agregarTicket(ticketEnt);
    }
    
    @Override
    public List<TicketDTO> obtenerTickets(UsuarioDTO usuario) {
        List<Ticket> listaTicketsEnt = ticketDAO.obtenerTickets(usuario.getId());
        
        List<TicketDTO> listaTicketsDTO = new ArrayList<>();
        
        for (Ticket ticket : listaTicketsEnt) {
            listaTicketsDTO.add(convertirTicket(ticket));
        }
        
        return listaTicketsDTO;
    }

    @Override
    public TicketDTO obtenerTicket(ObjectId folio) {
        Ticket ticketEnt = ticketDAO.obtenerTicket(folio);

        TicketDTO ticketDTO = convertirTicket(ticketEnt);
        
        return ticketDTO;
    }
    
    @Override
    public TicketDTO enviarRespuesta(ObjectId folio, RespuestaDTO respuestaDTO) {
        Respuesta respuestaEnt = convertirRespuesta(respuestaDTO);
        ticketDAO.agregarRespuesta(folio, respuestaEnt);
        return this.obtenerTicket(folio);
    }
    
    @Override
    public TicketDTO enviarRespuestaTrabajador(ObjectId folio, RespuestaDTO respuestaDTO, ObjectId idAtendiendo) {
        Respuesta respuestaEnt = convertirRespuesta(respuestaDTO);
        ticketDAO.agregarRespuesta(folio, respuestaEnt);
        
        Ticket ticketEnt = ticketDAO.obtenerTicket(folio);
        
        if (ticketEnt.getIdAtendiendo() == null) {
            ticketEnt.setIdAtendiendo(idAtendiendo);
            ticketDAO.actualizarTicket(ticketEnt);
        }
        
        return this.obtenerTicket(folio);
    }
    
    @Override
    public List<TicketDTO> obtenerTodosTickets(ObjectId idAtendiendo) {
        List<Ticket> listaTicketsEnt = ticketDAO.obtenerTodosTickets(idAtendiendo);
        
        List<TicketDTO> listaTicketsDTO = new ArrayList<>();
        
        for (Ticket ticket : listaTicketsEnt) {
            listaTicketsDTO.add(convertirTicket(ticket));
        }
        
        return listaTicketsDTO;
    }
    
    @Override
    public void actualizarTicket(TicketDTO ticketDTO) {
        Ticket ticketEnt = convertirTicket(ticketDTO);
        ticketEnt.setIdUsuario(ticketDTO.getIdUsuario());
        ticketDAO.actualizarTicket(ticketEnt);
    }
    
    private Ticket convertirTicket(TicketDTO ticketDTO) {
        Ticket ticketEnt = new Ticket(
                ticketDTO.getContenido(), 
                ticketDTO.getFecha(), 
                ticketDTO.getEstado(), 
                ticketDTO.getIdUsuario(), 
                ticketDTO.getNombreUsuario(), 
                ticketDTO.getIdAtendiendo(), 
                convertirRespuestasDTO(ticketDTO.getRespuestas()));
        ticketEnt.setId(ticketDTO.getId());
        
        return ticketEnt;
    }
    
    private TicketDTO convertirTicket(Ticket ticketEnt) {
        TicketDTO ticketDTO = new TicketDTO(
                ticketEnt.getId(),
                ticketEnt.getContenido(),
                ticketEnt.getFecha(),
                ticketEnt.getEstado(),
                ticketEnt.getIdUsuario(),
                ticketEnt.getNombreUsuario(),
                ticketEnt.getIdAtendiendo(),
                convertirRespuestasEntidad(ticketEnt.getRespuestas()));
        
        return ticketDTO;
    }
    
    private Respuesta convertirRespuesta(RespuestaDTO respuestaDTO) {
        Respuesta respuestaEnt = new Respuesta(
                respuestaDTO.getContenido(),
                respuestaDTO.getFecha(),
                respuestaDTO.getEmisor(),
                respuestaDTO.getIdEmisor());
        
        return respuestaEnt;
    }
    
    private RespuestaDTO convertirRespuesta(Respuesta respuestaEnt) {
        RespuestaDTO respuestaDTO = new RespuestaDTO(
                respuestaEnt.getContenido(),
                respuestaEnt.getFecha(),
                respuestaEnt.getEmisor(),
                respuestaEnt.getIdEmisor());
        
        return respuestaDTO;
    }
    
    private List<Respuesta> convertirRespuestasDTO(List<RespuestaDTO> listaRespuestasDTO) {
        List<Respuesta> listaRespuestasEnt = new ArrayList<>();
        for (RespuestaDTO respuestaDTO : listaRespuestasDTO) {
            listaRespuestasEnt.add(convertirRespuesta(respuestaDTO));
        }
        return listaRespuestasEnt;
    }

    private List<RespuestaDTO> convertirRespuestasEntidad(List<Respuesta> listaRespuestasEnt) {
        List<RespuestaDTO> listaRespuestasDTO = new ArrayList<>();
        for (Respuesta respuestaEnt : listaRespuestasEnt) {
            listaRespuestasDTO.add(convertirRespuesta(respuestaEnt));
        }
        return listaRespuestasDTO;
    }
    
}
