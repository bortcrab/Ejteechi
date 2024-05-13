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
    
    public List<QuejaDTO> obtenerQuejas(String seleccion) throws VisualizarQuejasException;
        
    public QuejaDTO confirmarLectura(QuejaDTO queja) throws VisualizarQuejasException;

}
