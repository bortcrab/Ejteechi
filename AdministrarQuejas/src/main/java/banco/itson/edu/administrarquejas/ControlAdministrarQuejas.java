package banco.itson.edu.administrarquejas;

import dtos.QuejaDTO;
import objetosNegocio.ObjetosNegocioException;
import org.bson.types.ObjectId;

public class ControlAdministrarQuejas {

    private final IAdministrarQuejas quejaFacade;

    public ControlAdministrarQuejas() {
        this.quejaFacade = new FacadeAdministrarQuejas();
    }

    public void enviarQueja(QuejaDTO queja) throws ObjetosNegocioException {
        try {
            quejaFacade.enviarQueja(queja.getQueja(), queja.getTipoQueja(), queja.isAnonimo(), new ObjectId(queja.getIdCliente()) );
        } catch (ObjetosNegocioException e) {
            throw new ObjetosNegocioException(e.getMessage());
        }
    }

}
