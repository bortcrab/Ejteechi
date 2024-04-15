package objetosNegocio;

import dtos.DatosRutaDTO;
import java.util.List;
import dtos.RutaDTO;
import java.util.ArrayList;
import org.jxmapviewer.viewer.GeoPosition;

public class Ruta {
    
    public List<RutaDTO> getRutas() {
        // Coordenadas para crear la ruta del camión.
        List<GeoPosition> puntos1 = new ArrayList<>();
        puntos1.add(new GeoPosition(27.48270, -109.95938));
        puntos1.add(new GeoPosition(27.48627, -109.96098));
        puntos1.add(new GeoPosition(27.48633, -109.96896));
        puntos1.add(new GeoPosition(27.48632, -109.97365));
        puntos1.add(new GeoPosition(27.48273, -109.97374));
        puntos1.add(new GeoPosition(27.48408, -109.98187));
        puntos1.add(new GeoPosition(27.48571, -109.98238));
        puntos1.add(new GeoPosition(27.48571, -109.98427));
        puntos1.add(new GeoPosition(27.48547, -109.99021));
        puntos1.add(new GeoPosition(27.48918, -109.98984));
        puntos1.add(new GeoPosition(27.4892, -109.98836));
        puntos1.add(new GeoPosition(27.4895, -109.98245));
        puntos1.add(new GeoPosition(27.48951, -109.97735));
        puntos1.add(new GeoPosition(27.49106, -109.97527));
        puntos1.add(new GeoPosition(27.49133, -109.97369));
        puntos1.add(new GeoPosition(27.49685, -109.9731));
        puntos1.add(new GeoPosition(27.49312, -109.96776));
        puntos1.add(new GeoPosition(27.4952, -109.96572));
        puntos1.add(new GeoPosition(27.49432, -109.96284));
        puntos1.add(new GeoPosition(27.49383, -109.95656));
        puntos1.add(new GeoPosition(27.48271, -109.95656));
        
        RutaDTO ruta1 = new RutaDTO(new ArrayList<DatosRutaDTO>(), puntos1);
       
        
        // Coordenadas para crear la ruta del camión.
        List<GeoPosition> puntos2 = new ArrayList<>();
        puntos2.add(new GeoPosition(27.48265, -109.94684));
        puntos2.add(new GeoPosition(27.48278, -109.94365));
        puntos2.add(new GeoPosition(27.48767, -109.94365));
        puntos2.add(new GeoPosition(27.48768, -109.94651));
        puntos2.add(new GeoPosition(27.48648, -109.94649));
        puntos2.add(new GeoPosition(27.48632, -109.94881));
        puntos2.add(new GeoPosition(27.48276, -109.94874));
        
        RutaDTO ruta2 = new RutaDTO(new ArrayList<>(), puntos2);
        
        List<RutaDTO> rutas = new ArrayList<>();
        
        rutas.add(ruta1);
        rutas.add(ruta2);
        
        return rutas;
    }
    
}
