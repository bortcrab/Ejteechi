package dtos;

import java.util.List;

public class MapaDTO {
    
    private double[] coordenadas;
    private List<LineaDTO> lineas;

    public MapaDTO() {
    }

    public MapaDTO(double[] coordenadas, List<LineaDTO> lineas) {
        this.coordenadas = coordenadas;
        this.lineas = lineas;
    }

    public List<LineaDTO> getLineas() {
        return lineas;
    }

    public void setLineas(List<LineaDTO> lineas) {
        this.lineas = lineas;
    }

    public double[] getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(double[] coordenadas) {
        this.coordenadas = coordenadas;
    }
    
}
