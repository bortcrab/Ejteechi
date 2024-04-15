package dtos;

import java.util.List;

public class MapaDTO {
    
    private List<LineaDTO> lineas;

    public MapaDTO() {
    }

    public MapaDTO(List<LineaDTO> lineas) {
        this.lineas = lineas;
    }

    public List<LineaDTO> getLineas() {
        return lineas;
    }

    public void setLineas(List<LineaDTO> lineas) {
        this.lineas = lineas;
    }
}
