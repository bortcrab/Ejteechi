/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dtos.CamionDTO;
import excepciones.ObjetosNegocioException;
import java.util.Date;

/**
 *
 * @author elimo
 */
public interface ICamionBO {
    
    CamionDTO obtenerPorNumeroUnidad(String numeroUnidad) throws ObjetosNegocioException;

    CamionDTO actualizarEstado(String numeroUnidad, String atributoEstado, String nuevoEstado) throws ObjetosNegocioException;

    CamionDTO actualizarPrioridadYFechaMantenimiento(String numeroUnidad, String nuevaPrioridad, Date nuevaFechaMantenimiento) throws ObjetosNegocioException;
    
}
