package dtos;

import java.util.Date;

public class QuejaDTO {
    private String noQueja;
    private String tipoQueja;
    private Date fecha;
    private String descripcion;
    private boolean anonimo;
    private String idCliente;

    public QuejaDTO() {
    }
    
    public QuejaDTO(Date fecha, String descripcion, boolean anonimo, String tipoQueja) {
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.tipoQueja = tipoQueja;
        this.anonimo = anonimo;
    }

    public String getTipoQueja() {
        return tipoQueja;
    }

    public void setTipoQueja(String tipoQueja) {
        this.tipoQueja = tipoQueja;
    }

    public String getNoQueja() {
        return noQueja;
    }

    public void setNoQueja(String noQueja) {
        this.noQueja = noQueja;
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

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    
    
}
