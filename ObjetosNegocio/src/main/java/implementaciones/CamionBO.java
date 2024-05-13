package implementaciones;

import colecciones.Camion;
import dtos.CamionDTO;
import excepciones.ObjetosNegocioException;
import interfaces.ICamionBO;
import interfaces.ICamionDAO;
import java.util.Date;

public class CamionBO implements ICamionBO {

    private final ICamionDAO camionDAO;

    public CamionBO() {
        this.camionDAO = new CamionDAO();
    }

    public static CamionDTO CamionADTO(Camion camion) {
        CamionDTO camionDTO = new CamionDTO();
        camionDTO.setNumeroUnidad(camion.getNumeroUnidad());
        camionDTO.setEstadoMotor(camion.getEstadoMotor());
        camionDTO.setEstadoLimpieza(camion.getEstadoLimpieza());
        camionDTO.setEstadoLlantas(camion.getEstadoLlantas());
        camionDTO.setEstadoLuces(camion.getEstadoLuces());
        camionDTO.setNivelPrioridad(camion.getNivelPrioridad());
        camionDTO.setFechaUltimoMantenimiento(camion.getFechaUltimoMantenimiento());
        return camionDTO;
    }

    @Override
    public CamionDTO obtenerPorNumeroUnidad(String numeroUnidad) throws ObjetosNegocioException {
        camionDAO.obtenerPorNumeroUnidad(numeroUnidad);
        if(camionDAO.obtenerPorNumeroUnidad(numeroUnidad)==null){
            throw new ObjetosNegocioException("Ocurrió un error al obtener la unidad.");
        }
        return CamionADTO(camionDAO.obtenerPorNumeroUnidad(numeroUnidad));
    }

    

    @Override
    public CamionDTO actualizarPrioridadYFechaMantenimiento(String numeroUnidad, String nuevaPrioridad, Date nuevaFechaMantenimiento) throws ObjetosNegocioException {
        camionDAO.actualizarPrioridadYFechaMantenimiento(numeroUnidad, nuevaPrioridad, nuevaFechaMantenimiento);
        if(camionDAO.actualizarPrioridadYFechaMantenimiento(numeroUnidad, nuevaPrioridad, nuevaFechaMantenimiento)==null){
            throw new ObjetosNegocioException("Ocurrio un error al actualizar los datos de la unidad");
        }
        return CamionADTO(camionDAO.actualizarPrioridadYFechaMantenimiento(numeroUnidad, nuevaPrioridad, nuevaFechaMantenimiento));
    }

    @Override
    public Camion actualizarEstado(String numeroUnidad, String estadoMotor, String estadoLimpieza, String estadoLlantas, String estadoLuces) throws ObjetosNegocioException {
        camionDAO.actualizarEstado(numeroUnidad, estadoMotor, estadoLimpieza, estadoLlantas, estadoLuces);
        if(camionDAO.actualizarEstado(numeroUnidad, estadoMotor, estadoLimpieza, estadoLlantas, estadoLuces)==null){
            throw new ObjetosNegocioException("Ocurrio un error al actualizar la unidad");
        }
        return camionDAO.actualizarEstado(numeroUnidad, estadoMotor, estadoLimpieza, estadoLlantas, estadoLuces);
    }

}
