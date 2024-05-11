/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dtos.QuejaDTO;
import excepciones.ObjetosNegocioException;
import java.util.List;

/**
 *
 * @author elimo
 */
public interface IQuejaBO {
    
    public QuejaDTO enviarQueja(QuejaDTO quejaDTO) throws ObjetosNegocioException;
    
    public List<QuejaDTO> obtenerQuejasPorTipo(String tipo) throws ObjetosNegocioException;

    public List<QuejaDTO> obtenerTodasLasQuejas() throws ObjetosNegocioException;

    public List<QuejaDTO> obtenerQuejasLeidas() throws ObjetosNegocioException;

    public List<QuejaDTO> obtenerQuejasNoLeidas() throws ObjetosNegocioException;
    
}
