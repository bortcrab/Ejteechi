package dtos;

import java.util.Date;
import org.bson.types.ObjectId;

/**
 *
 * @author Diego Valenzuela Parra - 00000247700
 */
public class RespuestaDTO {
    
    private String contenido;
    private Date fecha;
    private String emisor;
    private ObjectId idEmisor;

    public RespuestaDTO() {
    }

    public RespuestaDTO(String contenido, Date fecha, String emisor, ObjectId idEmisor) {
        this.contenido = contenido;
        this.fecha = fecha;
        this.emisor = emisor;
        this.idEmisor = idEmisor;
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

    public String getEmisor() {
        return emisor;
    }

    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }

    public ObjectId getIdEmisor() {
        return idEmisor;
    }

    public void setIdEmisor(ObjectId idEmisor) {
        this.idEmisor = idEmisor;
    }
    
}
