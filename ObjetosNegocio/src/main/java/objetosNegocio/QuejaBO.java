package objetosNegocio;

import dtos.QuejaDTO;
import java.util.Date;
import org.bson.Document;
import org.bson.types.ObjectId;
import persistencia.IQuejaDAO;
import persistencia.PersistenciaException;
import persistencia.Queja;
import persistencia.QuejaDAO;

public class QuejaBO implements IQuejaBO {

    private final IQuejaDAO quejaDAO;

    public QuejaBO() {
        this.quejaDAO = new QuejaDAO();
    }

    @Override
    public QuejaDTO enviarQueja(QuejaDTO queja) throws ObjetosNegocioException {
        try {
            ObjectId idPersona = new ObjectId(queja.getIdCliente());
            Queja quejaEntidad = new Queja(queja.getFecha(), queja.getQueja(), queja.isAnonimo(), idPersona, queja.getTipoQueja());
            return documentToDTO(quejaDAO.enviarComentario(quejaEntidad));
        } catch (PersistenciaException e) {
            throw new ObjetosNegocioException(e.getMessage());
        }
    }
    
    
    public static QuejaDTO documentToDTO(Document document) { 
        String tipoQueja = document.getString("tipoQueja");
        Date fecha = document.getDate("fecha");
        String queja = document.getString("queja");
        boolean anonimo = document.getBoolean("anonimo");
        String idCliente = document.getString("idCliente");

        return new QuejaDTO( fecha, queja, anonimo, tipoQueja, idCliente);
    }

}
