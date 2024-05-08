package implementaciones;

import colecciones.Queja;
import dtos.QuejaDTO;
import excepciones.ObjetosNegocioException;
import excepciones.PersistenciaException;
import interfaces.IQuejaBO;
import interfaces.IQuejaDAO;

public class QuejaBO implements IQuejaBO{
    
    private IQuejaDAO quejaDAO;

    public QuejaBO() {
        this.quejaDAO = new QuejaDAO();
    }

    @Override
    public QuejaDTO enviarQueja(QuejaDTO quejaDTO) throws ObjetosNegocioException {
        
        try{
            quejaDAO.insertarQueja(convertirDTOToQueja(quejaDTO));
            return quejaDTO;
        }catch(PersistenciaException e){
            throw new ObjetosNegocioException(e.getMessage());
        }
        
    }
    
     public static QuejaDTO convertirQuejaToDTO(Queja queja) {
        QuejaDTO quejaDTO = new QuejaDTO();
        quejaDTO.setNoQueja(queja.getNoQueja());
        quejaDTO.setTipoQueja(queja.getTipoQueja());
        quejaDTO.setFecha(queja.getFecha());
        quejaDTO.setDescripcion(queja.getDescripcion());
        quejaDTO.setAnonimo(queja.isAnonimo());
        quejaDTO.setIdCliente(queja.getIdCliente());
        return quejaDTO;
    }
     
     public static Queja convertirDTOToQueja(QuejaDTO quejaDTO) {
        Queja queja = new Queja();
        queja.setNoQueja(quejaDTO.getNoQueja());
        queja.setTipoQueja(quejaDTO.getTipoQueja());
        queja.setFecha(quejaDTO.getFecha());
        queja.setDescripcion(quejaDTO.getDescripcion());
        queja.setAnonimo(quejaDTO.isAnonimo());
        queja.setIdCliente(quejaDTO.getIdCliente());
        return queja;
    }

}
