package objetosNegocio;

import dtos.LineaDTO;
import dtos.MapaDTO;
import java.util.List;

public class Mapa {
    
    public MapaDTO getMapa() {
        
        Linea linea = new Linea();
                
        List<LineaDTO> lineas = linea.getLineas();
        
        MapaDTO mapa = new MapaDTO(lineas);
        
        return mapa;
    }
}
