/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import colecciones.Camion;
import java.util.Date;

/**
 *
 * @author elimo
 */
public interface ICamionDAO {

    Camion obtenerPorNumeroUnidad(String numeroUnidad);

    Camion actualizarEstado(String numeroUnidad, String atributoEstado, String nuevoEstado);

    Camion actualizarPrioridadYFechaMantenimiento(String numeroUnidad, String nuevaPrioridad, Date nuevaFechaMantenimiento);
}
