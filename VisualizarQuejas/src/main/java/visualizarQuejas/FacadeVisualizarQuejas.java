package visualizarQuejas;

import dtos.QuejaDTO;
import java.util.List;

public class FacadeVisualizarQuejas implements IVisualizarQuejas {

    private final CtrlVisualizarQuejas ctrlVisualizarQuejas;

    public FacadeVisualizarQuejas() {
        this.ctrlVisualizarQuejas = new CtrlVisualizarQuejas();
    }

    /**
     *
     * @param tipo
     * @param anonimo
     * @return
     * @throws VisualizarQuejasException
     */
    @Override
    public List<QuejaDTO> obtenerQuejasPorTipo(String tipo, boolean anonimo) throws VisualizarQuejasException {
        return ctrlVisualizarQuejas.obtenerQuejasPorTipo(tipo, anonimo);
    }

    @Override
    public List<QuejaDTO> obtenerTodasLasQuejas() throws VisualizarQuejasException {
       return ctrlVisualizarQuejas.obtenerTodasLasQuejas();
    }

    @Override
    public List<QuejaDTO> obtenerQuejasPorEstadoYAnonimato(boolean leido, boolean anonimo) throws VisualizarQuejasException{
         return ctrlVisualizarQuejas.obtenerQuejasPorEstadoYAnonimato(leido, anonimo);
    }

}
