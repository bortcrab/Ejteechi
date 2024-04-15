package dtos;

public class TicketDTO {
    private String noTicket;
    private String categoria;
    private String ticket;
    private String estado;

    public TicketDTO(String noTicket, String categoria, String ticket, String estado) {
        this.noTicket = noTicket;
        this.categoria = categoria;
        this.ticket = ticket;
        this.estado = estado;
    }

    public String getNoTicket() {
        return noTicket;
    }

    public void setNoTicket(String noTicket) {
        this.noTicket = noTicket;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
