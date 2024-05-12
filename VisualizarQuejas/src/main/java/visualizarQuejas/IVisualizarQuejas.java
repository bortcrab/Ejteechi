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

    public List<QuejaDTO> obtenerQuejasPorTipo(String tipo) throws VisualizarQuejasException;

    public List<QuejaDTO> obtenerTodasLasQuejas() throws VisualizarQuejasException;

    public List<QuejaDTO> obtenerQuejasPorEstado(boolean leido) throws VisualizarQuejasException;
    
    public QuejaDTO confirmarLectura(QuejaDTO queja) throws VisualizarQuejasException;


}
