package objetosNegocio;

import dtos.LineaDTO;
import dtos.RutaDTO;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.jxmapviewer.viewer.DefaultWaypoint;
import org.jxmapviewer.viewer.Waypoint;

public class Linea {
    
    public List<LineaDTO> getLineas() {
        Ruta ruta = new Ruta();
        List<RutaDTO> rutasDTO = ruta.getRutas();
        
        // Coordenadas para las paradas del camión.
        Set<Waypoint> paradas1 = new HashSet<>();
        paradas1.add(new DefaultWaypoint(27.48270, -109.95938));
        paradas1.add(new DefaultWaypoint(27.48633, -109.96896));
        paradas1.add(new DefaultWaypoint(27.48408, -109.98187));
        paradas1.add(new DefaultWaypoint(27.48571, -109.98238));
        paradas1.add(new DefaultWaypoint(27.48571, -109.98427));
        paradas1.add(new DefaultWaypoint(27.48918, -109.98984));
        paradas1.add(new DefaultWaypoint(27.4892, -109.98836));
        paradas1.add(new DefaultWaypoint(27.4895, -109.98245));
        paradas1.add(new DefaultWaypoint(27.49106, -109.97527));
        paradas1.add(new DefaultWaypoint(27.49133, -109.97369));
        paradas1.add(new DefaultWaypoint(27.49685, -109.9731));
        paradas1.add(new DefaultWaypoint(27.49312, -109.96776));
        paradas1.add(new DefaultWaypoint(27.49432, -109.96284));
        paradas1.add(new DefaultWaypoint(27.49383, -109.95656));
        paradas1.add(new DefaultWaypoint(27.48271, -109.95656));
        
        // Coordenadas para las paradas del camión.
        Set<Waypoint> paradas2 = new HashSet<>();
        paradas2.add(new DefaultWaypoint(27.48265, -109.94684));
        paradas2.add(new DefaultWaypoint(27.48278, -109.94365));
        paradas2.add(new DefaultWaypoint(27.48767, -109.94365));
        paradas2.add(new DefaultWaypoint(27.48768, -109.94651));
        paradas2.add(new DefaultWaypoint(27.48648, -109.94649));
        paradas2.add(new DefaultWaypoint(27.48632, -109.94881));
        paradas2.add(new DefaultWaypoint(27.48276, -109.94874));
        
        List<LineaDTO> lineas = new ArrayList<>();
        
        lineas.add(new LineaDTO(paradas1, rutasDTO.get(0)));
        lineas.add(new LineaDTO(paradas2, rutasDTO.get(1)));
        
        return lineas;
    }
}
