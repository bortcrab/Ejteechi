package visualizarQuejas;

import dtos.QuejaDTO;
import excepciones.ObjetosNegocioException;
import implementaciones.QuejaBO;
import interfaces.IQuejaBO;
import java.util.List;

public class CtrlVisualizarQuejas {

    private final IQuejaBO quejasBO;

    public CtrlVisualizarQuejas() {
        this.quejasBO = new QuejaBO();
    }

    public List<QuejaDTO> obtenerQuejas(String seleccion) throws VisualizarQuejasException {
        try {
            return quejasBO.obtenerQuejas(seleccion);
        } catch (ObjetosNegocioException e) {
            throw new VisualizarQuejasException(e.getMessage());
        }
    }

    public QuejaDTO confirmarLectura(QuejaDTO queja) throws VisualizarQuejasException {
        try {
            return quejasBO.confirmarLectura(queja);
        } catch (ObjetosNegocioException e) {
            throw new VisualizarQuejasException(e.getMessage());
        }
    }

}
