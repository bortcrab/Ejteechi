/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import colecciones.Queja;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author elimo
 */
public interface IQuejaDAO {

    public void insertarQueja(Queja queja) throws PersistenciaException;

    public List<Queja> obtenerQuejasPorTipo(String tipo) throws PersistenciaException;

    public List<Queja> obtenerTodasLasQuejas() throws PersistenciaException;

    public List<Queja> obtenerQuejasLeidas() throws PersistenciaException;

    public List<Queja> obtenerQuejasNoLeidas() throws PersistenciaException;

}
