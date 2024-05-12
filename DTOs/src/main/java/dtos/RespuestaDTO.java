package dtos;

import java.util.Date;

/**
 *
 * @author Diego Valenzuela Parra - 00000247700
 */
public class RespuestaDTO {
    
    private String contenido;
    private Date fecha;
    private UsuarioDTO usuario;

    public RespuestaDTO() {
    }

    public RespuestaDTO(String contenido, Date fecha, UsuarioDTO usuario) {
        this.contenido = contenido;
        this.fecha = fecha;
        this.usuario = usuario;
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

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }
    
}
