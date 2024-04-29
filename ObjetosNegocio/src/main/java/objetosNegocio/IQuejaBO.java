/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package objetosNegocio;

import dtos.QuejaDTO;
import org.bson.types.ObjectId;

/**
 *
 * @author elimo
 */
public interface IQuejaBO {
    public QuejaDTO enviarQueja(String comentario, String tipo, boolean anonimo, ObjectId iDcliente) throws ObjetosNegocioException;
}
