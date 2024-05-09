package implementaciones;

import colecciones.Respuesta;
import colecciones.Ticket;
import colecciones.Usuario;
import dtos.RespuestaDTO;
import dtos.TicketDTO;
import dtos.UsuarioDTO;
import interfaces.ITicketBO;
import interfaces.ITicketDAO;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;
import utilidades.Encriptador;

/**
 *
 * @author Diego Valenzuela Parra - 00000247700
 */
public class TicketBO implements ITicketBO {

    private final ITicketDAO ticketDAO;
    private final Encriptador encriptador;

    public TicketBO() {
        this.ticketDAO = new TicketDAO();
        this.encriptador = new Encriptador();
    }
    
    @Override
    public void enviarTicket(TicketDTO ticketDTO) {
        Ticket ticketEnt = convertirTicket(ticketDTO);
        ticketDAO.agregarTicket(ticketEnt);
    }
    
    @Override
    public List<TicketDTO> obtenerTickets(UsuarioDTO usuario) {
        List<Ticket> listaTicketsEnt = ticketDAO.obtenerTickets(usuario.getId());
        
        List<TicketDTO> listaTicketsDTO = convertirListaTickets(listaTicketsEnt);
        
        return listaTicketsDTO;
    }

    @Override
    public TicketDTO obtenerTicket(ObjectId folio) {
        Ticket ticketEnt = ticketDAO.obtenerTicket(folio);

        TicketDTO ticketDTO = convertirTicket(ticketEnt);
        
        return ticketDTO;
    }
    
    private Ticket convertirTicket(TicketDTO ticketDTO) {
        Ticket ticketEnt = new Ticket(
                ticketDTO.getContenido(),
                ticketDTO.getFecha(),
                ticketDTO.getEstado(),
                ticketDTO.getIdUsuario(),
                convertirRespuestasDTO(ticketDTO.getRespuestas()));
        
        return ticketEnt;
    }
    
    private TicketDTO convertirTicket(Ticket ticketEnt) {
        TicketDTO ticketDTO = new TicketDTO(
                ticketEnt.getId(),
                ticketEnt.getContenido(),
                ticketEnt.getFecha(),
                ticketEnt.getEstado(),
                ticketEnt.getIdUsuario(),
                convertirRespuestasEntidad(ticketEnt.getRespuestas()));
        
        return ticketDTO;
    }
    
    private Usuario convertirUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuarioEnt = new Usuario(
                usuarioDTO.getNombres(),
                usuarioDTO.getApellidoPaterno(),
                usuarioDTO.getApellidoMaterno(),
                usuarioDTO.getTelefono(),
                encriptador.encriptar(usuarioDTO.getCorreo()),
                encriptador.encriptar(usuarioDTO.getContra()),
                usuarioDTO.getCurp(),
                usuarioDTO.getRfc(),
                usuarioDTO.getTipo());

        return usuarioEnt;
    }
    
    private List<Respuesta> convertirRespuestasDTO(List<RespuestaDTO> respuestasDTO) {
        List<Respuesta> respuestasEnt = new ArrayList<>();
        for (RespuestaDTO respuestaDTO : respuestasDTO) {
            Respuesta respuestaEnt = new Respuesta(
                    respuestaDTO.getContenido(),
                    respuestaDTO.getFecha(),
                    convertirUsuario(respuestaDTO.getUsuario()));
            
            respuestasEnt.add(respuestaEnt);
        }
        return respuestasEnt;
    }

    private List<TicketDTO> convertirListaTickets(List<Ticket> listaTicketsEnt) {
        List<TicketDTO> listaTicketsDTO = new ArrayList<>();
        for (Ticket ticketEnt : listaTicketsEnt) {
            TicketDTO ticketDTO = new TicketDTO(
                ticketEnt.getId(),
                ticketEnt.getContenido(),
                ticketEnt.getFecha(),
                ticketEnt.getEstado(),
                ticketEnt.getIdUsuario(),
                convertirRespuestasEntidad(ticketEnt.getRespuestas()));
            
            listaTicketsDTO.add(ticketDTO);
        }
        
        return listaTicketsDTO;
    }
    
    private List<RespuestaDTO> convertirRespuestasEntidad(List<Respuesta> respuestasEnt) {
        List<RespuestaDTO> respuestasDTO = new ArrayList<>();
        for (Respuesta respuestaEnt : respuestasEnt) {
            RespuestaDTO respuestaDTO = new RespuestaDTO(
                    respuestaEnt.getContenido(),
                    respuestaEnt.getFecha(),
                    convertirUsuario(respuestaEnt.getUsuario()));
            
            respuestasDTO.add(respuestaDTO);
        }
        return respuestasDTO;
    }
    
    /**
     * Método para convertir de una entidad Usuario a UsuarioDTO.
     *
     * @param usuarioEnt Entidad de Usuario a convertir.
     * @return UsuarioDTO ya convertido.
     */
    private UsuarioDTO convertirUsuario(Usuario usuarioEnt) {
        UsuarioDTO usuarioDTO = new UsuarioDTO(
                usuarioEnt.getId(),
                usuarioEnt.getNombres(),
                usuarioEnt.getApellidoPaterno(),
                usuarioEnt.getApellidoMaterno(),
                usuarioEnt.getTelefono(),
                usuarioEnt.getCurp(),
                usuarioEnt.getRfc(),
                usuarioEnt.getCorreo(),
                usuarioEnt.getContrasenia(),
                usuarioEnt.getTipo());

        return usuarioDTO;
    }

}
