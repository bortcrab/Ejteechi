package mostrarMapa;

import dtos.DatosRutaDTO;
import dtos.MapaDTO;
import dtos.RutaDTO;
import java.util.List;

public interface IMostrarMapa {

    public MapaDTO cargarMapa();
    
    public List<DatosRutaDTO> cargarRuta(RutaDTO ruta);
}
