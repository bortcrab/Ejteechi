package mostrarMapa;

import dtos.DatosRutaDTO;
import dtos.MapaDTO;
import dtos.RutaDTO;
import java.util.List;

public class FacadeMostrarMapa implements IMostrarMapa {

    private final CtrlMostrarMapa ctrlMostrarMapa = new CtrlMostrarMapa();
    
    @Override
    public MapaDTO cargarMapa() {
        return ctrlMostrarMapa.cargarMapa();
    }

    @Override
    public List<DatosRutaDTO> cargarRuta(RutaDTO ruta) {
        return ctrlMostrarMapa.cargarRuta(ruta);
    }
}
