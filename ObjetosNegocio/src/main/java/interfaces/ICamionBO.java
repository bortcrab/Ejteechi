/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import colecciones.Camion;
import dtos.CamionDTO;
import excepciones.ObjetosNegocioException;
import java.util.Date;

/**
 *
 * @author elimo
 */
public interface ICamionBO {
    
    CamionDTO obtenerPorNumeroUnidad(String numeroUnidad) throws ObjetosNegocioException;

    public Camion actualizarEstado(String numeroUnidad, String estadoMotor, String estadoLimpieza, String estadoLlantas, String estadoLuces) throws ObjetosNegocioException;

    CamionDTO actualizarPrioridadYFechaMantenimiento(String numeroUnidad, String nuevaPrioridad, Date nuevaFechaMantenimiento) throws ObjetosNegocioException;
    
}
