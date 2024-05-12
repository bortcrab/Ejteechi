/*
 * IQuejaBO.java
 */
package interfaces;

import dtos.QuejaDTO;
import excepciones.ObjetosNegocioException;

/**
 *
 * @author elimo
 */
public interface IQuejaBO {
    
    public QuejaDTO enviarQueja(QuejaDTO quejaDTO) throws ObjetosNegocioException;
    
}
