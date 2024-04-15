package dtos;

import com.graphhopper.util.PointList;

public class DatosRutaDTO {
    private double distancia;
    private String descripcion;
    private PointList puntos;

    public DatosRutaDTO(double distancia, String descripcion, PointList puntos) {
        this.distancia = distancia;
        this.descripcion = descripcion;
        this.puntos = puntos;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public PointList getPuntos() {
        return puntos;
    }

    public void setPuntos(PointList puntos) {
        this.puntos = puntos;
    }
    
}
