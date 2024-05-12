package dtos;

import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

public class TicketDTO {
    
    private ObjectId id;
    private String contenido;
    private Date fecha;
    private String estado;
    private ObjectId idUsuario;
    private String nombreUsuario;
    private ObjectId idAtendiendo;
    private List<RespuestaDTO> respuestas;

    public TicketDTO() {
    }

    public TicketDTO(ObjectId id, String contenido, Date fecha, String estado, ObjectId idUsuario, String nombreUsuario, List<RespuestaDTO> respuestas) {
        this.id = id;
        this.contenido = contenido;
        this.fecha = fecha;
        this.estado = estado;
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.respuestas = respuestas;
    }
    
    public TicketDTO(String contenido, Date fecha, String estado, ObjectId idUsuario, String nombreUsuario, List<RespuestaDTO> respuestas) {
        this.contenido = contenido;
        this.fecha = fecha;
        this.estado = estado;
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.respuestas = respuestas;
    }

    public TicketDTO(ObjectId id, String contenido, Date fecha, String estado, ObjectId idUsuario, String nombreUsuario, ObjectId idAtendiendo, List<RespuestaDTO> respuestas) {
        this.id = id;
        this.contenido = contenido;
        this.fecha = fecha;
        this.estado = estado;
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.idAtendiendo = idAtendiendo;
        this.respuestas = respuestas;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
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

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    
    public ObjectId getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(ObjectId idUsuario) {
        this.idUsuario = idUsuario;
    }

    public ObjectId getIdAtendiendo() {
        return idAtendiendo;
    }

    public void setIdAtendiendo(ObjectId idAtendiendo) {
        this.idAtendiendo = idAtendiendo;
    }
    
    public List<RespuestaDTO> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<RespuestaDTO> respuestas) {
        this.respuestas = respuestas;
    }
    
}
