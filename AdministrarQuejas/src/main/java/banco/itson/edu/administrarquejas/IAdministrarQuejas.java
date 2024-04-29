/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package banco.itson.edu.administrarquejas;

import objetosNegocio.ObjetosNegocioException;
import org.bson.types.ObjectId;

/**
 *
 * @author elimo
 */
public interface IAdministrarQuejas {
    
    public void enviarQueja(String comentario, String tipo, boolean anonimo, ObjectId idCliente) throws ObjetosNegocioException;
    
}
