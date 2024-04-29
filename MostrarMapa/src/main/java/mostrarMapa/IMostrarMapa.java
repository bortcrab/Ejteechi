package mostrarMapa;

import dtos.DatosRutaDTO;
import dtos.JXMapViewerCustom;
import dtos.MapaDTO;
import dtos.RutaDTO;
import java.util.List;

public interface IMostrarMapa {

    public MapaDTO cargarMapa(JXMapViewerCustom pnlMapa) throws MostrarMapaException;
    
    public List<DatosRutaDTO> cargarRuta(RutaDTO ruta);
}
