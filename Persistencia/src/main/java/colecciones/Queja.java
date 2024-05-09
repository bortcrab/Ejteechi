package colecciones;

import java.util.Date;
import org.bson.types.ObjectId;

public class Queja {
    private String noQueja;
    private String tipoQueja;
    private Date fecha;
    private String descripcion;
    private boolean anonimo;
    private ObjectId idCliente;

    /**
     * Constructor vacío
     */
    public Queja() {
    }

    /**
     * 
     * @param tipoQueja
     * @param fecha
     * @param descripcion
     * @param anonimo
     */
    public Queja(String tipoQueja, Date fecha, String descripcion, boolean anonimo) {
        this.tipoQueja = tipoQueja;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.anonimo = anonimo;
    }

    
    /**
     * 
     * @return 
     */
    public String getNoQueja() {
        return noQueja;
    }

    public void setNoQueja(String noQueja) {
        this.noQueja = noQueja;
    }

    public String getTipoQueja() {
        return tipoQueja;
    }

    public void setTipoQueja(String tipoQueja) {
        this.tipoQueja = tipoQueja;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isAnonimo() {
        return anonimo;
    }

    public void setAnonimo(boolean anonimo) {
        this.anonimo = anonimo;
    }

    public ObjectId getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(ObjectId idCliente) {
        this.idCliente = idCliente;
    }

    
}

