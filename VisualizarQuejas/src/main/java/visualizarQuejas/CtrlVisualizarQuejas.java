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
     * Obtiene una lista de todas las quejas según la selección.
     *
     * @param Selección La selección realizada.
     * @return Una lista de QuejaDTO que coinciden con la selección.
     * @throws VisualizarQuejasException Si ocurre un error al obtener las
     * quejas.
     */
    public List<QuejaDTO> obtenerQuejas(String seleccion) throws VisualizarQuejasException {
        try {
            return quejasBO.obtenerQuejas(seleccion);
        } catch (ObjetosNegocioException e) {
            throw new VisualizarQuejasException(e.getMessage());
        }
    }

}
