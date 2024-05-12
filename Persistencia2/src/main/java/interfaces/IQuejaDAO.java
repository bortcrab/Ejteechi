/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import colecciones.Queja;
import excepciones.PersistenciaException;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author elimo
 */
public interface IQuejaDAO {
    
    
    
     public void insertarQueja(Queja queja) throws PersistenciaException;
    
}
