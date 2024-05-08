package administrarQuejas;

import dtos.QuejaDTO;
import excepciones.ObjetosNegocioException;
import implementaciones.QuejaBO;
import interfaces.IQuejaBO;

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
