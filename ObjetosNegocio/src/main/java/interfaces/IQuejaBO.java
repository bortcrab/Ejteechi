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
    
    public List<QuejaDTO> obtenerQuejas(String seleccion) throws ObjetosNegocioException;
    
    public QuejaDTO confirmarLectura(QuejaDTO queja) throws ObjetosNegocioException;
    
}
