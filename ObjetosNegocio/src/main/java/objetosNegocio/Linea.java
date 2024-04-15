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
        RutaDTO rutaDTO = ruta.getRuta();
        
        // Coordenadas para las paradas del camión.
        Set<Waypoint> paradas = new HashSet<>();
        paradas.add(new DefaultWaypoint(27.48270, -109.95938));
        paradas.add(new DefaultWaypoint(27.48633, -109.96896));
        paradas.add(new DefaultWaypoint(27.48408, -109.98187));
        paradas.add(new DefaultWaypoint(27.48571, -109.98238));
        paradas.add(new DefaultWaypoint(27.48571, -109.98427));
        paradas.add(new DefaultWaypoint(27.48918, -109.98984));
        paradas.add(new DefaultWaypoint(27.4892, -109.98836));
        paradas.add(new DefaultWaypoint(27.4895, -109.98245));
        paradas.add(new DefaultWaypoint(27.49106, -109.97527));
        paradas.add(new DefaultWaypoint(27.49133, -109.97369));
        paradas.add(new DefaultWaypoint(27.49685, -109.9731));
        paradas.add(new DefaultWaypoint(27.49312, -109.96776));
        paradas.add(new DefaultWaypoint(27.49432, -109.96284));
        paradas.add(new DefaultWaypoint(27.49383, -109.95656));
        paradas.add(new DefaultWaypoint(27.48271, -109.95656));
        
        List<LineaDTO> lineas = new ArrayList<>();
        
        lineas.add(new LineaDTO(paradas, rutaDTO));
        
        return lineas;
    }
}
