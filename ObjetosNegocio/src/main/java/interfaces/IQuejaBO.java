/*
 * IQuejaBO.java
 */
package interfaces;

import colecciones.Queja;
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

    public List<QuejaDTO> obtenerQuejasPorEstado(boolean leido) throws ObjetosNegocioException;
    
    public QuejaDTO confirmarLectura(QuejaDTO queja) throws ObjetosNegocioException;
    
}
