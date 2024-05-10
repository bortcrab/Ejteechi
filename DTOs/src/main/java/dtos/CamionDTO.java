package dtos;

public class CamionDTO {
    
    private String numeroUnidad;
    private String estadoMotor;
    private String estadoLimpieza;
    private String estadoLlantas;
    private String estadoLuces;
    private String nivelPrioridad;

    // Constructor vacío
    public CamionDTO() {
    }

    // Constructor con parámetros
    public CamionDTO(String numeroUnidad, String estadoMotor, String estadoLimpieza, String estadoLlantas, String estadoLuces, String nivelPrioridad) {
        this.numeroUnidad = numeroUnidad;
        this.estadoMotor = estadoMotor;
        this.estadoLimpieza = estadoLimpieza;
        this.estadoLlantas = estadoLlantas;
        this.estadoLuces = estadoLuces;
        this.nivelPrioridad = nivelPrioridad;
    }

    // Getters y Setters
    public String getNumeroUnidad() {
        return numeroUnidad;
    }

    public void setNumeroUnidad(String numeroUnidad) {
        this.numeroUnidad = numeroUnidad;
    }

    public String getEstadoMotor() {
        return estadoMotor;
    }

    public void setEstadoMotor(String estadoMotor) {
        this.estadoMotor = estadoMotor;
    }

    public String getEstadoLimpieza() {
        return estadoLimpieza;
    }

    public void setEstadoLimpieza(String estadoLimpieza) {
        this.estadoLimpieza = estadoLimpieza;
    }

    public String getEstadoLlantas() {
        return estadoLlantas;
    }

    public void setEstadoLlantas(String estadoLlantas) {
        this.estadoLlantas = estadoLlantas;
    }

    public String getEstadoLuces() {
        return estadoLuces;
    }

    public void setEstadoLuces(String estadoLuces) {
        this.estadoLuces = estadoLuces;
    }

    public String getNivelPrioridad() {
        return nivelPrioridad;
    }

    public void setNivelPrioridad(String nivelPrioridad) {
        this.nivelPrioridad = nivelPrioridad;
    }
}


