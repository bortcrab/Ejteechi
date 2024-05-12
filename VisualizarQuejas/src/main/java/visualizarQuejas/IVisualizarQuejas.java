/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package visualizarQuejas;

import dtos.QuejaDTO;
import java.util.List;

/**
 *
 * @author elimo
 */
public interface IVisualizarQuejas {

    public List<QuejaDTO> obtenerQuejasPorTipo(String tipo, boolean anonimo) throws VisualizarQuejasException;

    public List<QuejaDTO> obtenerTodasLasQuejas() throws VisualizarQuejasException;

    public List<QuejaDTO> obtenerQuejasPorEstadoYAnonimato(boolean leido, boolean anonimo) throws VisualizarQuejasException;


}
