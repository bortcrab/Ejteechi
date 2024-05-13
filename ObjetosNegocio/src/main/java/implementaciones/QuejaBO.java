package implementaciones;

import colecciones.Queja;
import dtos.QuejaDTO;
import excepciones.ObjetosNegocioException;
import excepciones.PersistenciaException;
import interfaces.IQuejaBO;
import interfaces.IQuejaDAO;
import java.util.ArrayList;
import java.util.List;

public class QuejaBO implements IQuejaBO {

    private IQuejaDAO quejaDAO;

    public QuejaBO() {
        this.quejaDAO = new QuejaDAO();
    }

    @Override
    public QuejaDTO enviarQueja(QuejaDTO quejaDTO) throws ObjetosNegocioException {

        try {
            quejaDAO.insertarQueja(convertirDTOToQueja(quejaDTO));
            return quejaDTO;
        } catch (PersistenciaException e) {
            throw new ObjetosNegocioException(e.getMessage());
        }

    }

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

    @Override
    public List<QuejaDTO> obtenerQuejas(String seleccion) throws ObjetosNegocioException {
        try {
            List<Queja> quejas = new ArrayList<>();
            if (seleccion.equals("<Elije uno>")) {
                quejas = quejaDAO.obtenerTodasLasQuejas();
            } else if (seleccion.equals("No leidos")) {
                quejas = quejaDAO.obtenerQuejasPorEstadoYAnonimato(false);
            } else if (seleccion.equals("Leidos")) {
                quejas = quejaDAO.obtenerQuejasPorEstadoYAnonimato(true);
            } else {
                quejas = quejaDAO.obtenerQuejasPorTipo(seleccion);
            }
            List<QuejaDTO> quejasDTO = new ArrayList<>();
            for (Queja queja : quejas) {
                quejasDTO.add(convertirQuejaToDTO(queja));
            }
            return quejasDTO;
        } catch (PersistenciaException e) {
            throw new ObjetosNegocioException(e.getMessage());
        }
    }

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
