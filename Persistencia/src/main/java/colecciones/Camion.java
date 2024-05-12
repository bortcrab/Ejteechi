package colecciones;

import java.util.Date;

 public class Camion {
    private String numeroUnidad;
    private String estadoMotor;
    private String estadoLimpieza;
    private String estadoLlantas;
    private String estadoLuces;
    private Date fechaUltimoMantenimiento;
    private String nivelPrioridad;

    // Constructor vacío
    public Camion() {}

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

    public Date getFechaUltimoMantenimiento() {
        return fechaUltimoMantenimiento;
    }

    public void setFechaUltimoMantenimiento(Date fechaUltimoMantenimiento) {
        this.fechaUltimoMantenimiento = fechaUltimoMantenimiento;
    }

    public String getNivelPrioridad() {
        return nivelPrioridad;
    }

    public void setNivelPrioridad(String nivelPrioridad) {
        this.nivelPrioridad = nivelPrioridad;
    }
}