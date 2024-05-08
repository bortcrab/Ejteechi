/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package administrarQuejas;

import dtos.QuejaDTO;

/**
 *
 * @author elimo
 */
public interface IAdministrarQuejas {
    
    public void enviarQueja(QuejaDTO queja) throws AdministrarQuejaException;
    
}
