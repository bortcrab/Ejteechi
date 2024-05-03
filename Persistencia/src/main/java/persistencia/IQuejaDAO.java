/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia;

import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author elimo
 */
public interface IQuejaDAO {
    
    
    
    public Document enviarComentario(Queja queja) throws PersistenciaException;
    
    
}
