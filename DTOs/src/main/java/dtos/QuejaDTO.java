package dtos;

import java.util.Date;

public class QuejaDTO {
    private String noQueja;
    private Date fecha;
    private String queja;
    private boolean anonimo;
    private String idCliente;

    
    public QuejaDTO(Date fecha, String queja, boolean anonimo, String idCliente) {
        
        this.fecha = fecha;
        this.queja = queja;
        this.anonimo = anonimo;
        this.idCliente = idCliente;
    }

    public QuejaDTO(Date fecha, String queja, boolean anonimo) {
        
        this.fecha = fecha;
        this.queja = queja;
        this.anonimo = anonimo;
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

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    
    
}
