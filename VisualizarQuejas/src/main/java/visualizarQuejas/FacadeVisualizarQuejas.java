package visualizarQuejas;

import dtos.QuejaDTO;
import java.util.List;

public class FacadeVisualizarQuejas implements IVisualizarQuejas {

    private final CtrlVisualizarQuejas ctrlVisualizarQuejas;

    public FacadeVisualizarQuejas() {
        this.ctrlVisualizarQuejas = new CtrlVisualizarQuejas();
    }
    
    @Override
    public List<QuejaDTO> obtenerQuejas(String seleccion) throws VisualizarQuejasException {
        return ctrlVisualizarQuejas.obtenerQuejas(seleccion);
    }

    @Override
    public QuejaDTO confirmarLectura(QuejaDTO queja) throws VisualizarQuejasException {
       return ctrlVisualizarQuejas.confirmarLectura(queja);
    }

}
