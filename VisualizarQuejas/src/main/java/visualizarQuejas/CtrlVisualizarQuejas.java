package visualizarQuejas;

import dtos.QuejaDTO;
import excepciones.ObjetosNegocioException;
import implementaciones.QuejaBO;
import interfaces.IQuejaBO;
import java.util.List;

/**
 * Controlador para visualizar quejas. Esta clase proporciona funcionalidades
 * para visualizar quejas en el sistema.
 *
 * @author elimo
 */
public class CtrlVisualizarQuejas {

    private final IQuejaBO quejasBO;

    /**
     * Constructor de la clase CtrlVisualizarQuejas. Inicializa un nuevo objeto
     * CtrlVisualizarQuejas con una instancia de QuejaBO.
     */
    public CtrlVisualizarQuejas() {
        this.quejasBO = new QuejaBO();
    }

    /**
     * Obtiene una lista de quejas por tipo.
     *
     * @param tipo El tipo de quejas a obtener.
     * @return Una lista de QuejaDTO que coinciden con el tipo especificado.
     * @throws VisualizarQuejasException Si ocurre un error al obtener las
     * quejas.
     */
    public List<QuejaDTO> obtenerQuejasPorTipo(String tipo) throws VisualizarQuejasException {
        try {
            return quejasBO.obtenerQuejasPorTipo(tipo);
        } catch (ObjetosNegocioException e) {
            throw new VisualizarQuejasException(e.getMessage());
        }
    }

    /**
     * Obtiene todas las quejas registradas en el sistema.
     *
     * @return Una lista de QuejaDTO que representa todas las quejas
     * registradas.
     * @throws VisualizarQuejasException Si ocurre un error al obtener las
     * quejas.
     */
    public List<QuejaDTO> obtenerTodasLasQuejas() throws VisualizarQuejasException {
        try {
            return quejasBO.obtenerTodasLasQuejas();
        } catch (ObjetosNegocioException e) {
            throw new VisualizarQuejasException(e.getMessage());
        }
    }

    /**
     * Obtiene una lista de quejas por estado de leído y anonimato.
     *
     * @param leido Indica si las quejas están marcadas como leídas o no.
     * @return Una lista de QuejaDTO que coinciden con el estado de leído
     * especificado.
     * @throws VisualizarQuejasException Si ocurre un error al obtener las
     * quejas.
     */
    public List<QuejaDTO> obtenerQuejasPorEstadoYAnonimato(boolean leido) throws VisualizarQuejasException {
        try {
            return quejasBO.obtenerQuejasPorEstado(leido);
        } catch (ObjetosNegocioException e) {
            throw new VisualizarQuejasException(e.getMessage());
        }
    }

    /**
     * Confirma la lectura de una queja.
     *
     * @param queja La queja que se va a marcar como leída.
     * @return La queja actualizada con la confirmación de lectura.
     * @throws VisualizarQuejasException Si ocurre un error al confirmar la
     * lectura de la queja.
     */
    public QuejaDTO confirmarLectura(QuejaDTO queja) throws VisualizarQuejasException {
        try {
            return quejasBO.confirmarLectura(queja);
        } catch (ObjetosNegocioException e) {
            throw new VisualizarQuejasException(e.getMessage());
        }
    }

}
