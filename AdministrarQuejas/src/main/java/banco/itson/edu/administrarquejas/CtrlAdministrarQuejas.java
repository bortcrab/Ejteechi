package banco.itson.edu.administrarquejas;

import dtos.QuejaDTO;
import objetosNegocio.IQuejaBO;
import objetosNegocio.ObjetosNegocioException;
import objetosNegocio.QuejaBO;

public class CtrlAdministrarQuejas {

    private final IQuejaBO quejaBO;

    public CtrlAdministrarQuejas() {
        this.quejaBO = new QuejaBO();
    }

    public void enviarQueja(QuejaDTO queja) throws AdministrarQuejaException {
         try {
            quejaBO.enviarQueja(queja);
            } catch (ObjetosNegocioException one) {
            throw new AdministrarQuejaException(one.getMessage());
        }
    }

}
