package implementaciones;

import colecciones.Queja;
import dtos.QuejaDTO;
import excepciones.ObjetosNegocioException;
import excepciones.PersistenciaException;
import interfaces.IQuejaBO;
import interfaces.IQuejaDAO;
import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author elimo
 */
public class QuejaBO implements IQuejaBO {

    private IQuejaDAO quejaDAO;

    /**
     * 
     */
    public QuejaBO() {
        this.quejaDAO = new QuejaDAO();
    }

    /**
     * 
     * @param quejaDTO
     * @return
     * @throws ObjetosNegocioException 
     */
    @Override
    public QuejaDTO enviarQueja(QuejaDTO quejaDTO) throws ObjetosNegocioException {

        try {
            quejaDAO.insertarQueja(convertirDTOToQueja(quejaDTO));
            return quejaDTO;
        } catch (PersistenciaException e) {
            throw new ObjetosNegocioException(e.getMessage());
        }

    }

    /**
     * 
     * @param queja
     * @return 
     */
    public static QuejaDTO convertirQuejaToDTO(Queja queja) {
        QuejaDTO quejaDTO = new QuejaDTO();
        quejaDTO.setLeido(queja.isLeido());
        quejaDTO.setNoQueja(queja.getId());
        quejaDTO.setTipoQueja(queja.getTipo());
        quejaDTO.setFecha(queja.getFecha());
        quejaDTO.setDescripcion(queja.getComentario());
        quejaDTO.setAnonimo(queja.isAnonimo());
        quejaDTO.setIdCliente(queja.getIdCliente());
        return quejaDTO;
    }

    /**
     * 
     * @param quejaDTO
     * @return 
     */
    public static Queja convertirDTOToQueja(QuejaDTO quejaDTO) {
        Queja queja = new Queja();
        queja.setLeido(quejaDTO.isLeido());
        queja.setId(quejaDTO.getNoQueja());
        queja.setTipo(quejaDTO.getTipoQueja());
        queja.setFecha(quejaDTO.getFecha());
        queja.setComentario(quejaDTO.getDescripcion());
        queja.setAnonimo(quejaDTO.isAnonimo());
        queja.setIdCliente(quejaDTO.getIdCliente());
        return queja;
    }

    /**
     * 
     * @param tipo
     * @return
     * @throws ObjetosNegocioException 
     */
    @Override
    public List<QuejaDTO> obtenerQuejasPorTipo(String tipo) throws ObjetosNegocioException {
        try {
            List<Queja> quejas = quejaDAO.obtenerQuejasPorTipo(tipo);
            List<QuejaDTO> quejasDTO = new ArrayList<>();
            for (Queja queja : quejas) {
                quejasDTO.add(convertirQuejaToDTO(queja));
            }
            return quejasDTO;
        } catch (PersistenciaException e) {
            throw new ObjetosNegocioException(e.getMessage());
        }
    }

    /**
     * 
     * @return
     * @throws ObjetosNegocioException 
     */
    @Override
    public List<QuejaDTO> obtenerTodasLasQuejas() throws ObjetosNegocioException {
        try {
            List<Queja> quejas = quejaDAO.obtenerTodasLasQuejas();
            List<QuejaDTO> quejasDTO = new ArrayList<>();
            for (Queja queja : quejas) {
                quejasDTO.add(convertirQuejaToDTO(queja));
            }
            return quejasDTO;
        } catch (PersistenciaException e) {
            throw new ObjetosNegocioException(e.getMessage());
        }
    }

    /**
     * 
     * @param leido
     * @return
     * @throws ObjetosNegocioException 
     */
    @Override
    public List<QuejaDTO> obtenerQuejasPorEstado(boolean leido) throws ObjetosNegocioException {
        try {
            List<Queja> quejas = quejaDAO.obtenerQuejasPorEstadoYAnonimato(leido);
            List<QuejaDTO> quejasDTO = new ArrayList<>();
            for (Queja queja : quejas) {
                quejasDTO.add(convertirQuejaToDTO(queja));
            }
            return quejasDTO;
        } catch (PersistenciaException e) {
            throw new ObjetosNegocioException(e.getMessage());
        }
    }

    /**
     * 
     * @param queja
     * @return
     * @throws ObjetosNegocioException 
     */
    @Override
    public QuejaDTO confirmarLectura(QuejaDTO queja) throws ObjetosNegocioException {
        try {
            Queja quejas = quejaDAO.confirmarLectura(convertirDTOToQueja(queja));
            return convertirQuejaToDTO(quejas);
        } catch (PersistenciaException e) {
            throw new ObjetosNegocioException(e.getMessage());
        }
    }

}
