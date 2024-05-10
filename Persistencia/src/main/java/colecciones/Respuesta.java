package colecciones;

import java.util.Date;
import org.bson.types.ObjectId;

/**
 *
 * @author Diego Valenzuela Parra - 00000247700
 */
public class Respuesta {

    private ObjectId id;
    private String contenido;
    private Date fecha;
    private Usuario usuario;

    public Respuesta() {
    }

    public Respuesta(String contenido, Date fecha, Usuario usuario) {
        this.contenido = contenido;
        this.fecha = fecha;
        this.usuario = usuario;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
