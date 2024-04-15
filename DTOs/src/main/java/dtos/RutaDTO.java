package dtos;

import java.util.List;
import org.jxmapviewer.viewer.GeoPosition;

public class RutaDTO {
    
    private List<DatosRutaDTO> datosRuta;
    private List<GeoPosition> puntos;

    public RutaDTO() {
    }

    public RutaDTO(List<DatosRutaDTO> datosRuta, List<GeoPosition> puntos) {
        this.datosRuta = datosRuta;
        this.puntos = puntos;
    }

    public List<DatosRutaDTO> getDatosRuta() {
        return datosRuta;
    }

    public void setDatosRuta(List<DatosRutaDTO> ruta) {
        this.datosRuta = ruta;
    }

    public List<GeoPosition> getPuntos() {
        return puntos;
    }

    public void setPuntos(List<GeoPosition> puntos) {
        this.puntos = puntos;
    }
}
