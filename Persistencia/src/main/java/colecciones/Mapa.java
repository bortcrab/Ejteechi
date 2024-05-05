/*
 * Mapa.java
 */
package colecciones;

import java.util.List;
import org.bson.types.ObjectId;

/**
 * Clase para representar una entidad de Mapa.
 *
 * @author Eliana Monge Cámara - 00000247782
 * @author Francisco Valdez Gastelum - 00000246904
 * @author Diego Valenzuela Parra - 00000247700
 */
public class Mapa {

    private ObjectId id;
    private List<Double> coordenadas;
    private List<Linea> lineas;

    /**
     * Constructor por ausencia.
     */
    public Mapa() {
    }

    /**
     * Constructor que inicializa todos los atributos menos el ID de la entidad.
     *
     * @param coordenadas Coordenadas del mapa.
     * @param lineas Lista de líneas del mapa.
     */
    public Mapa(List<Double> coordenadas, List<Linea> lineas) {
        this.coordenadas = coordenadas;
        this.lineas = lineas;
    }

    /**
     * Método que regresa el ID del mapa.
     *
     * @return ID del mapa.
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Método para asignar un ID al mapa.
     *
     * @param id ID a asignar al mapa.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Método para devolver las coordenadas
     *
     * @return
     */
    public List<Double> getCoordenadas() {
        return coordenadas;
    }

    /**
     * Método para asignar unas coordenadas al mapa.
     *
     * @param coordenadas Coordenadas a asignar.
     */
    public void setCoordenadas(List<Double> coordenadas) {
        this.coordenadas = coordenadas;
    }

    /**
     * Método para devolver las líneas que conforman al mapa.
     *
     * @return Lista de líneas que conforman al mapa.
     */
    public List<Linea> getLineas() {
        return lineas;
    }

    /**
     * Método para asignar una lista de coordenadas al mapa.
     *
     * @param lineas Lista de líneas a asignar al mapa.
     */
    public void setLineas(List<Linea> lineas) {
        this.lineas = lineas;
    }

}
