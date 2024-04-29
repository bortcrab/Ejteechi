package banco.itson.edu.administrarquejas;

import objetosNegocio.ObjetosNegocioException;
import org.bson.types.ObjectId;

public class CtrlAdministrarQuejas {

    private final IAdministrarQuejas quejaFacade;

    public CtrlAdministrarQuejas() {
        this.quejaFacade = new FacadeAdministrarQuejas();
    }

    public void enviarQueja(String comentario, String tipo, boolean anonimo, ObjectId idCliente) throws ObjetosNegocioException {
try{
        quejaFacade.enviarQueja(comentario, tipo, anonimo, idCliente);
}catch(ObjetosNegocioException e){
    throw new ObjetosNegocioException(e.getMessage());
}
    }

}
