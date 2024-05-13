package visualizarQuejas;

import dtos.QuejaDTO;
import java.util.List;

/**
 * Implementación de la interfaz IVisualizarQuejas que proporciona una fachada
 * para visualizar quejas. Esta clase actúa como una fachada para proporcionar
 * métodos para visualizar y manipular quejas en el sistema.
 *
 * @author elimo
 */
public class FacadeVisualizarQuejas implements IVisualizarQuejas {

    private final CtrlVisualizarQuejas ctrlVisualizarQuejas;

    /**
     * Constructor de la clase FacadeVisualizarQuejas. Inicializa un nuevo
     * objeto FacadeVisualizarQuejas con una instancia de CtrlVisualizarQuejas.
     */
    public FacadeVisualizarQuejas() {
        this.ctrlVisualizarQuejas = new CtrlVisualizarQuejas();
    }

    /**
     * Obtiene una lista de quejas por tipo.
     *
     * @param tipo El tipo de quejas a obtener.
     * @return Una lista de QuejaDTO que coinciden con el tipo especificado.
     * @throws VisualizarQuejasException Si ocurre un error al obtener las
     * quejas.
     */
    @Override
    public List<QuejaDTO> obtenerQuejasPorTipo(String tipo) throws VisualizarQuejasException {
        return ctrlVisualizarQuejas.obtenerQuejasPorTipo(tipo);
    }

    /**
     * Obtiene todas las quejas registradas en el sistema.
     *
     * @return Una lista de QuejaDTO que representa todas las quejas
     * registradas.
     * @throws VisualizarQuejasException Si ocurre un error al obtener las
     * quejas.
     */
    @Override
    public List<QuejaDTO> obtenerTodasLasQuejas() throws VisualizarQuejasException {
        return ctrlVisualizarQuejas.obtenerTodasLasQuejas();
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
    @Override
    public List<QuejaDTO> obtenerQuejasPorEstado(boolean leido) throws VisualizarQuejasException {
        return ctrlVisualizarQuejas.obtenerQuejasPorEstadoYAnonimato(leido);
    }

    /**
     * Confirma la lectura de una queja.
     *
     * @param queja La queja que se va a marcar como leída.
     * @return La queja actualizada con la confirmación de lectura.
     * @throws VisualizarQuejasException Si ocurre un error al confirmar la
     * lectura de la queja.
     */
    @Override
    public QuejaDTO confirmarLectura(QuejaDTO queja) throws VisualizarQuejasException {
        return ctrlVisualizarQuejas.confirmarLectura(queja);
    }

}
