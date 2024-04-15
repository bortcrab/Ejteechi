package mostrarMapa;

import dtos.DatosRutaDTO;
import dtos.MapaDTO;
import dtos.RutaDTO;
import java.util.List;
import objetosNegocio.Mapa;
import org.jxmapviewer.viewer.GeoPosition;

public class CtrlMostrarMapa {

    private final Mapa mapa = new Mapa();
    private final CalcularRuta calcularRuta = new CalcularRuta();
        
    public MapaDTO cargarMapa() {
        return mapa.getMapa();
    }
    
    public List<DatosRutaDTO> cargarRuta(RutaDTO ruta) {
        List<GeoPosition> puntos = ruta.getPuntos();
        List<DatosRutaDTO> datosRuta = ruta.getDatosRuta();
        for (int i = 0; i < (puntos.size()-1); i++) {
            double inicioLat = puntos.get(i).getLatitude();
            double inicioLon = puntos.get(i).getLongitude();
            double finLat = puntos.get(i+1).getLatitude();
            double finLon = puntos.get(i+1).getLongitude();
            datosRuta = calcularRuta.calcularRuta(datosRuta, inicioLat, inicioLon, finLat, finLon);
        }
        return datosRuta;
    }
}
