package dtos;

public class QuejaDTO {
    private String noQueja;
    private String fecha;
    private String queja;

    public QuejaDTO(String noQueja, String fecha, String queja) {
        this.noQueja = noQueja;
        this.fecha = fecha;
        this.queja = queja;
    }

    public String getNoQueja() {
        return noQueja;
    }

    public void setNoQueja(String noQueja) {
        this.noQueja = noQueja;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getQueja() {
        return queja;
    }

    public void setQueja(String queja) {
        this.queja = queja;
    }
    
}
