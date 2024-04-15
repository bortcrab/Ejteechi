package dtos;

import java.util.Set;
import org.jxmapviewer.viewer.Waypoint;

public class LineaDTO {
    private Set<Waypoint> paradas;
    private RutaDTO ruta;

    public LineaDTO() {
    }

    public LineaDTO(Set<Waypoint> paradas, RutaDTO ruta) {
        this.paradas = paradas;
        this.ruta = ruta;
    }

    public Set<Waypoint> getParadas() {
        return paradas;
    }

    public void setParadas(Set<Waypoint> paradas) {
        this.paradas = paradas;
    }

    public RutaDTO getRuta() {
        return ruta;
    }

    public void setRuta(RutaDTO ruta) {
        this.ruta = ruta;
    }
    
}
