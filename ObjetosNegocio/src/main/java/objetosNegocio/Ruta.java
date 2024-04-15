package objetosNegocio;

import dtos.DatosRutaDTO;
import java.util.List;
import dtos.RutaDTO;
import java.util.ArrayList;
import org.jxmapviewer.viewer.GeoPosition;

public class Ruta {
    
    public RutaDTO getRuta() {
        // Coordenadas para crear la ruta del camión.
        List<GeoPosition> puntos = new ArrayList<>();
        puntos.add(new GeoPosition(27.48270, -109.95938));
        puntos.add(new GeoPosition(27.48627, -109.96098));
        puntos.add(new GeoPosition(27.48633, -109.96896));
        puntos.add(new GeoPosition(27.48632, -109.97365));
        puntos.add(new GeoPosition(27.48273, -109.97374));
        puntos.add(new GeoPosition(27.48408, -109.98187));
        puntos.add(new GeoPosition(27.48571, -109.98238));
        puntos.add(new GeoPosition(27.48571, -109.98427));
        puntos.add(new GeoPosition(27.48547, -109.99021));
        puntos.add(new GeoPosition(27.48918, -109.98984));
        puntos.add(new GeoPosition(27.4892, -109.98836));
        puntos.add(new GeoPosition(27.4895, -109.98245));
        puntos.add(new GeoPosition(27.48951, -109.97735));
        puntos.add(new GeoPosition(27.49106, -109.97527));
        puntos.add(new GeoPosition(27.49133, -109.97369));
        puntos.add(new GeoPosition(27.49685, -109.9731));
        puntos.add(new GeoPosition(27.49312, -109.96776));
        puntos.add(new GeoPosition(27.4952, -109.96572));
        puntos.add(new GeoPosition(27.49432, -109.96284));
        puntos.add(new GeoPosition(27.49383, -109.95656));
        puntos.add(new GeoPosition(27.48271, -109.95656));
        
        RutaDTO ruta = new RutaDTO(new ArrayList<DatosRutaDTO>(), puntos);
        
        return ruta;
    }
    
}
