/*
 * IMapaBO.java
 */
package interfaces;

import dtos.LineaDTO;
import dtos.MapaDTO;
import dtos.RutaDTO;
import entidades.Linea;
import entidades.Mapa;
import entidades.Ruta;
import excepciones.ObjetosNegocioException;

/**
 * Interfaz que define los métodos para aplicar las reglas de negocio en lo
 * relacionado con el mapa.
 *
 * @author Eliana Monge Cámara - 00000247782
 * @author Francisco Valdez Gastelum - 00000246904
 * @author Diego Valenzuela Parra - 00000247700
 */
public interface IMapaBO {

    /**
     * Método que devuelve el mapa a mostrar.
     * 
     * @return El mapa encontrado.
     * @throws ObjetosNegocioException si no se encontró ningún mapa.
     */
    public MapaDTO obtenerMapa() throws ObjetosNegocioException;

    /**
     * Método que convierte una entidad de mapa a una instancia de MapaDTO.
     * 
     * @param mapa Mapa entidad a convertir.
     * @return El mapa convertido a DTO.
     */
    public MapaDTO convertirMapa(Mapa mapa);

    /**
     * Método que convierte una entidad de línea a una instancia de LineaDTO.
     * 
     * @param linea Línea entidad a convertir.
     * @return La línea convertida a DTO.
     */
    public LineaDTO convertirLinea(Linea linea);

    /**
     * Método que convierte una entidad de ruta a una instancia de RutaDTO.
     * 
     * @param ruta Ruta entidad a convertir.
     * @return La ruta convertida a DTO.
     */
    public RutaDTO convertirRuta(Ruta ruta);
}
