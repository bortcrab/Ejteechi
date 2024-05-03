package persistencia;

import java.util.Date;
import org.bson.types.ObjectId;

public class Queja {

    private String tipoQueja;
    private Date fecha;
    private String queja;
    private boolean anonimo;
    private ObjectId idCliente;

    public Queja(Date fecha, String queja, boolean anonimo, ObjectId idCliente, String tipoQueja) {
        this.queja = queja;
        this.fecha = fecha;
        this.queja = queja;
        this.anonimo = anonimo;
        this.idCliente = idCliente;
    }

    public Queja(Date fecha, String queja, boolean anonimo, String tipoQueja) {
        this.queja = queja;
        this.fecha = fecha;
        this.queja = queja;
        this.anonimo = anonimo;
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

    public String getQueja() {
        return queja;
    }

    public void setQueja(String queja) {
        this.queja = queja;
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
