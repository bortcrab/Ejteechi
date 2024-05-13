package programarMantenimiento;

import dtos.CamionDTO;
import excepciones.ObjetosNegocioException;
import implementaciones.CamionBO;
import interfaces.ICamionBO;
import java.util.Date;

public class CtrlProgramarMantenimiento {

    private final ICamionBO camionBO;

    public CtrlProgramarMantenimiento() {
        this.camionBO = new CamionBO();
    }

    public CamionDTO obtenerPorNumeroUnidad(String numeroUnidad) throws ProgramarMantenimientoException {
        try {
            camionBO.obtenerPorNumeroUnidad(numeroUnidad);
            return camionBO.obtenerPorNumeroUnidad(numeroUnidad);
        } catch (ObjetosNegocioException one) {
            throw new ProgramarMantenimientoException(one.getMessage());
        }
    }

    public CamionDTO actualizarEstado(String numeroUnidad, String atributoEstado, String nuevoEstado) throws ProgramarMantenimientoException, ProgramarMantenimientoException {
        try {
            camionBO.actualizarEstado(numeroUnidad, atributoEstado, nuevoEstado);
            return camionBO.actualizarEstado(numeroUnidad, atributoEstado, nuevoEstado);
        } catch (ObjetosNegocioException one) {
            throw new ProgramarMantenimientoException(one.getMessage());
        }
    }

    public CamionDTO actualizarPrioridadYFechaMantenimiento(String numeroUnidad, String nuevaPrioridad, Date nuevaFechaMantenimiento) throws ProgramarMantenimientoException {
        try {
            camionBO.actualizarPrioridadYFechaMantenimiento(numeroUnidad, nuevaPrioridad, nuevaFechaMantenimiento);
            return camionBO.actualizarPrioridadYFechaMantenimiento(numeroUnidad, nuevaPrioridad, nuevaFechaMantenimiento);
        } catch (ObjetosNegocioException one) {
            throw new ProgramarMantenimientoException(one.getMessage());
        }
    }

}
