package interfaces;

import dtos.LineaDTO;
import dtos.MapaDTO;
import dtos.RutaDTO;
import entidades.Linea;
import entidades.Mapa;
import entidades.Ruta;
import excepciones.ObjetosNegocioException;

public interface IMapaBO {
    public MapaDTO obtenerMapa() throws ObjetosNegocioException;
    
    public MapaDTO convertirMapaDTO(Mapa mapa);
    
    public LineaDTO convertirLineaDTO(Linea linea);
    
    public RutaDTO convertirRutaDTO(Ruta ruta);
}
