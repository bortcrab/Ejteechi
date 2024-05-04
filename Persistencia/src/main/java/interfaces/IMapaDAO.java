package interfaces;

import entidades.Mapa;
import excepciones.PersistenciaException;

public interface IMapaDAO {
    
    public Mapa obtenerMapa() throws PersistenciaException ;
    
}
