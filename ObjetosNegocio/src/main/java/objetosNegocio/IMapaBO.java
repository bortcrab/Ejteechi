package objetosNegocio;

import dtos.LineaDTO;
import dtos.MapaDTO;
import dtos.RutaDTO;
import persistencia.Linea;
import persistencia.Mapa;
import persistencia.Ruta;

public interface IMapaBO {
    public MapaDTO obtenerMapa() throws ObjetosNegocioException;
    
    public MapaDTO convertirMapaDTO(Mapa mapa);
    
    public LineaDTO convertirLineaDTO(Linea linea);
    
    public RutaDTO convertirRutaDTO(Ruta ruta);
}
