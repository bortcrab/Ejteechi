package administrarQuejas;

import dtos.QuejaDTO;

public class FacadeAdministrarQuejas implements IAdministrarQuejas {
private final CtrlAdministrarQuejas ctrlAdministrarQuejas;

    public FacadeAdministrarQuejas() {
        this.ctrlAdministrarQuejas = new CtrlAdministrarQuejas();
    }

@Override
    public void enviarQueja(QuejaDTO queja) throws AdministrarQuejaException {
        try {
        ctrlAdministrarQuejas.enviarQueja(queja);
         } catch (AdministrarQuejaException cce) {
            throw cce;
        }
    }
}
