package dtos;

import java.util.Date;

public class QuejaDTO {
    private String noQueja;
    private String tipoQueja;
    private Date fecha;
    private String queja;
    private boolean anonimo;
    private String idCliente;

    public QuejaDTO() {
    }

    
    
    public QuejaDTO(Date fecha, String queja, boolean anonimo, String idCliente, String tipoQueja) {
        this.queja = queja;
        this.fecha = fecha;
        this.queja = queja;
        this.anonimo = anonimo;
        this.idCliente = idCliente;
    }

    public QuejaDTO(Date fecha, String queja, boolean anonimo,String tipoQueja) {
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
