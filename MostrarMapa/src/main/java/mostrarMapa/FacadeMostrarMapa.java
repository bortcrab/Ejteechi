package mostrarMapa;

import dtos.DatosRutaDTO;
import dtos.JXMapViewerCustom;
import dtos.MapaDTO;
import dtos.RutaDTO;
import java.util.List;

public class FacadeMostrarMapa implements IMostrarMapa {

    private final CtrlMostrarMapa ctrlMostrarMapa = new CtrlMostrarMapa();
    
    @Override
    public MapaDTO cargarMapa(JXMapViewerCustom pnlMapa) throws MostrarMapaException {
        return ctrlMostrarMapa.cargarMapa(pnlMapa);
    }

    @Override
    public List<DatosRutaDTO> cargarRuta(RutaDTO ruta) {
        return ctrlMostrarMapa.cargarRuta(ruta);
    }
}
