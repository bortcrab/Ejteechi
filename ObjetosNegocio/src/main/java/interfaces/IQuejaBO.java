/*
 * IQuejaBO.java
 */
package interfaces;

import dtos.QuejaDTO;
import excepciones.ObjetosNegocioException;
import java.util.List;

/**
 * Interfaz que define las operaciones relacionadas con la gestión de quejas.
 * Esta interfaz proporciona métodos para enviar quejas, obtener quejas por diversos criterios
 * como tipo o estado, y confirmar la lectura de una queja.
 * 
 * @author elimo
 */
public interface IQuejaBO {

    /**
     * Envía una queja representada por un objeto de tipo QuejaDTO.
     *
     * @param quejaDTO El objeto QuejaDTO que contiene la información de la
     * queja a enviar.
     * @return Un objeto QuejaDTO que representa la queja enviada.
     * @throws ObjetosNegocioException Si ocurre un error al enviar la queja.
     */
    public QuejaDTO enviarQueja(QuejaDTO quejaDTO) throws ObjetosNegocioException;

    /**
     * Obtiene una lista de quejas filtradas por tipo.
     *
     * @param tipo El tipo de quejas que se desea obtener.
     * @return Una lista de objetos QuejaDTO que representan las quejas del tipo
     * especificado.
     * @throws ObjetosNegocioException Si ocurre un error al obtener las quejas
     * por tipo.
     */
    public List<QuejaDTO> obtenerQuejasPorTipo(String tipo) throws ObjetosNegocioException;

    /**
     * Obtiene una lista de todas las quejas registradas.
     *
     * @return Una lista de objetos QuejaDTO que representan todas las quejas
     * registradas.
     * @throws ObjetosNegocioException Si ocurre un error al obtener todas las
     * quejas.
     */
    public List<QuejaDTO> obtenerTodasLasQuejas() throws ObjetosNegocioException;

    /**
     * Obtiene una lista de quejas filtradas por estado de lectura.
     *
     * @param leido El estado de lectura de las quejas que se desea obtener.
     * @return Una lista de objetos QuejaDTO que representan las quejas con el
     * estado de lectura especificado.
     * @throws ObjetosNegocioException Si ocurre un error al obtener las quejas
     * por estado de lectura.
     */
    public List<QuejaDTO> obtenerQuejasPorEstado(boolean leido) throws ObjetosNegocioException;

    /**
     * Obtiene una lista de quejas filtradas por estado de lectura.
     *
     * @param queja Queja que contiene el estado de lectura de las quejas que se desea obtener
     * @return Una lista de objetos QuejaDTO que representan las quejas con el
     * estado de lectura especificado.
     * @throws ObjetosNegocioException Si ocurre un error al obtener las quejas
     * por estado de lectura.
     */
    public QuejaDTO confirmarLectura(QuejaDTO queja) throws ObjetosNegocioException;

}
