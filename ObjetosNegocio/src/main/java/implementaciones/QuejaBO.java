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

    @Override
    public List<QuejaDTO> obtenerQuejasLeidas() throws ObjetosNegocioException {
        try {
            List<Queja> quejas = quejaDAO.obtenerQuejasLeidas();
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
    public List<QuejaDTO> obtenerQuejasNoLeidas() throws ObjetosNegocioException {
        try {
            List<Queja> quejas = quejaDAO.obtenerQuejasNoLeidas();
            List<QuejaDTO> quejasDTO = new ArrayList<>();
            for (Queja queja : quejas) {
                quejasDTO.add(convertirQuejaToDTO(queja));
            }
            return quejasDTO;
        } catch (PersistenciaException e) {
            throw new ObjetosNegocioException(e.getMessage());
        }
    }

}
