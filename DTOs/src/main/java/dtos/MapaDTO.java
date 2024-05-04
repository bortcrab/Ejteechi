/*
 * MapaDTO.java
 */
package dtos;

import java.util.List;

/**
 * Clase DTO con las características que conforman un mapa.
 *
 * @author Eliana Monge Cámara - 00000247782
 * @author Francisco Valdez Gastelum - 00000246904
 * @author Diego Valenzuela Parra - 00000247700
 */
public class MapaDTO {

    private double[] coordenadas;
    private List<LineaDTO> lineas;

    /**
     * Constructor por ausencia.
     */
    public MapaDTO() {
    }

    /**
     * Constructor que inicializa los atributos de la clase.
     *
     * @param coordenadas Coordenadas del mapa.
     * @param lineas Lista de líneas que conforman al mapa.
     */
    public MapaDTO(double[] coordenadas, List<LineaDTO> lineas) {
        this.coordenadas = coordenadas;
        this.lineas = lineas;
    }

    /**
     * Método que devuelve las líneas del mapa.
     *
     * @return Líneas del mapa.
     */
    public List<LineaDTO> getLineas() {
        return lineas;
    }

    /**
     * Método que asigna las líneas al mapa.
     *
     * @param lineas Líneas a asignar al mapa.
     */
    public void setLineas(List<LineaDTO> lineas) {
        this.lineas = lineas;
    }

    /**
     * Método para devolver las coordenadas del mapa.
     *
     * @return Coordenadas del mapa.
     */
    public double[] getCoordenadas() {
        return coordenadas;
    }

    /**
     * Método para asignar unas coordenadas al mapa.
     *
     * @param coordenadas Coordenadas a asiganar.
     */
    public void setCoordenadas(double[] coordenadas) {
        this.coordenadas = coordenadas;
    }

}
