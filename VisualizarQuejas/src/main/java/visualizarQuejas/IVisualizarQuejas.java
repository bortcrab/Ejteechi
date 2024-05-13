/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package visualizarQuejas;

import dtos.QuejaDTO;
import java.util.List;

/**
 * Interfaz para visualizar quejas. Define métodos para obtener y manipular
 * quejas en el sistema.
 *
 * @author elimo
 */
public interface IVisualizarQuejas {

    /**
     * Obtiene una lista de quejas por tipo.
     *
     * @param tipo El tipo de quejas a obtener.
     * @return Una lista de QuejaDTO que coinciden con el tipo especificado.
     * @throws VisualizarQuejasException Si ocurre un error al obtener las
     * quejas.
     */
    public List<QuejaDTO> obtenerQuejasPorTipo(String tipo) throws VisualizarQuejasException;

    /**
     * Obtiene todas las quejas registradas en el sistema.
     *
     * @return Una lista de QuejaDTO que representa todas las quejas
     * registradas.
     * @throws VisualizarQuejasException Si ocurre un error al obtener las
     * quejas.
     */
    public List<QuejaDTO> obtenerTodasLasQuejas() throws VisualizarQuejasException;

    /**
     * Obtiene una lista de quejas por estado de leído y anonimato.
     *
     * @param leido Indica si las quejas están marcadas como leídas o no.
     * @return Una lista de QuejaDTO que coinciden con el estado de leído
     * especificado.
     * @throws VisualizarQuejasException Si ocurre un error al obtener las
     * quejas.
     */
    public List<QuejaDTO> obtenerQuejasPorEstado(boolean leido) throws VisualizarQuejasException;

    /**
     * Confirma la lectura de una queja.
     *
     * @param queja La queja que se va a marcar como leída.
     * @return La queja actualizada con la confirmación de lectura.
     * @throws VisualizarQuejasException Si ocurre un error al confirmar la
     * lectura de la queja.
     */
    public QuejaDTO confirmarLectura(QuejaDTO queja) throws VisualizarQuejasException;

}
