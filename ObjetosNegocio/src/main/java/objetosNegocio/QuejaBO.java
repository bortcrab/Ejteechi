package objetosNegocio;

import dtos.QuejaDTO;
import java.util.Date;
import org.bson.Document;
import org.bson.types.ObjectId;
import persistencia.IQuejaDAO;
import persistencia.PersistenciaException;
import persistencia.QuejaDAO;

public class QuejaBO implements IQuejaBO {

    private final IQuejaDAO quejaDAO;

    public QuejaBO() {
        this.quejaDAO = new QuejaDAO();
    }

    @Override
    public QuejaDTO enviarQueja(String comentario, String tipo, boolean anonimo, ObjectId iDcliente) throws ObjetosNegocioException {
        try {
            return convertirDocumentoAQuejaDTO(quejaDAO.enviarComentario(comentario, tipo, anonimo, iDcliente));
        } catch (PersistenciaException e) {
            throw new ObjetosNegocioException(e.getMessage());
        }
    }

    public static QuejaDTO convertirDocumentoAQuejaDTO(Document documento) {

        String queja = documento.getString("queja");
        boolean anonimo = documento.getBoolean("anonimo");
        Date fecha = new Date();
        if (documento.getObjectId("idCliente").toString() == null) {
            return new QuejaDTO(fecha, queja, anonimo);
        }

        String idCliente = documento.getObjectId("idCliente").toString();

        return new QuejaDTO(fecha, queja, anonimo, idCliente);
    }

}
