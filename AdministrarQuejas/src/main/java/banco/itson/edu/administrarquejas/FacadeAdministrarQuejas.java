package banco.itson.edu.administrarquejas;

import objetosNegocio.IQuejaBO;
import objetosNegocio.ObjetosNegocioException;
import objetosNegocio.QuejaBO;
import org.bson.types.ObjectId;

public class FacadeAdministrarQuejas implements IAdministrarQuejas {
private final IQuejaBO queja;

    public FacadeAdministrarQuejas() {
        this.queja = new QuejaBO();
    }

@Override
    public void enviarQueja(String comentario, String tipo, boolean anonimo, ObjectId idCliente) throws ObjetosNegocioException {
        queja.enviarQueja(comentario, tipo, anonimo, idCliente);
    }
}
