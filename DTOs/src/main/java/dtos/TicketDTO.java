package dtos;

import java.util.Date;
import java.util.List;

public class TicketDTO {
    
    private String id;
    private String contenido;
    private Date fecha;
    private String estado;
    private String idUsuario;
    private List<RespuestaDTO> respuestas;

    public TicketDTO() {
    }

    public TicketDTO(String id, String contenido, Date fecha, String estado, String idUsuario, List<RespuestaDTO> respuestas) {
        this.id = id;
        this.contenido = contenido;
        this.fecha = fecha;
        this.estado = estado;
        this.idUsuario = idUsuario;
        this.respuestas = respuestas;
    }
    
    public TicketDTO(String contenido, Date fecha, String estado, String idUsuario, List<RespuestaDTO> respuestas) {
        this.contenido = contenido;
        this.fecha = fecha;
        this.estado = estado;
        this.idUsuario = idUsuario;
        this.respuestas = respuestas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public List<RespuestaDTO> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<RespuestaDTO> respuestas) {
        this.respuestas = respuestas;
    }
    
}
