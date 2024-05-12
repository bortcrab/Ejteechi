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

   
    
    public List<QuejaDTO> obtenerQuejasPorTipo(String tipo) throws VisualizarQuejasException{
        try{
        return quejasBO.obtenerQuejasPorTipo(tipo);
        }catch(ObjetosNegocioException e){
            throw new VisualizarQuejasException(e.getMessage());
        }
    }

    public List<QuejaDTO> obtenerTodasLasQuejas() throws VisualizarQuejasException{
        try{
        return quejasBO.obtenerTodasLasQuejas();
        }catch(ObjetosNegocioException e){
            throw new VisualizarQuejasException(e.getMessage());
        }
    }

    public List<QuejaDTO> obtenerQuejasPorEstadoYAnonimato(boolean leido) throws VisualizarQuejasException{
       try{
        return quejasBO.obtenerQuejasPorEstado(leido);
        }catch(ObjetosNegocioException e){
            throw new VisualizarQuejasException(e.getMessage());
        } 
    }
    
    public QuejaDTO confirmarLectura(QuejaDTO queja) throws VisualizarQuejasException{
        try{
        return quejasBO.confirmarLectura(queja);
        }catch(ObjetosNegocioException e){
            throw new VisualizarQuejasException(e.getMessage());
        } 
    }

}
