/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package programarMantenimiento;

import dtos.CamionDTO;
import java.util.Date;

/**
 *
 * @author elimo
 */
public interface IProgramarMantenimiento {

    public CamionDTO obtenerPorNumeroUnidad(String numeroUnidad) throws ProgramarMantenimientoException;

    public CamionDTO actualizarEstado(String numeroUnidad, String atributoEstado, String nuevoEstado) throws ProgramarMantenimientoException;

    public CamionDTO actualizarPrioridadYFechaMantenimiento(String numeroUnidad, String nuevaPrioridad, Date nuevaFechaMantenimiento) throws ProgramarMantenimientoException;
}
