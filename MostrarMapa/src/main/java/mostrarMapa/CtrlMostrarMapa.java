package mostrarMapa;

import dtos.DatosRutaDTO;
import dtos.JXMapViewerCustom;
import dtos.MapaDTO;
import dtos.RutaDTO;
import java.util.List;
import objetosNegocio.IMapaBO;
import objetosNegocio.MapaBO;
import objetosNegocio.ObjetosNegocioException;
import obtenerImagenesMapa.FacadeObtenerImagenesMapa;
import org.jxmapviewer.viewer.GeoPosition;
import obtenerImagenesMapa.IObtenerImagenesMapa;

public class CtrlMostrarMapa {

    private final IObtenerImagenesMapa obtenerImagenesMapa = new FacadeObtenerImagenesMapa();
    private final IMapaBO mapaBO = new MapaBO();
    private final CalcularRuta calcularRuta = new CalcularRuta();

    public MapaDTO cargarMapa(JXMapViewerCustom pnlMapa) throws MostrarMapaException {
        try {
            MapaDTO mapaDTO = mapaBO.obtenerMapa();
            obtenerImagenesMapa.obtenerImagenMapa(pnlMapa, mapaDTO.getCoordenadas());
            return mapaDTO;
        } catch (ObjetosNegocioException one) {
            throw new MostrarMapaException(one.getMessage());
        }
    }

    public List<DatosRutaDTO> cargarRuta(RutaDTO ruta) {
        List<GeoPosition> puntos = ruta.getPuntos();
        List<DatosRutaDTO> datosRuta = ruta.getDatosRuta();
        for (int i = 0; i < (puntos.size()); i++) {
            double inicioLat = puntos.get(i).getLatitude();
            double inicioLon = puntos.get(i).getLongitude();
            if (i < (puntos.size() - 1)) {
                double finLat = puntos.get(i + 1).getLatitude();
                double finLon = puntos.get(i + 1).getLongitude();
                datosRuta = calcularRuta.calcularRuta(datosRuta, inicioLat, inicioLon, finLat, finLon);
            } else {
                datosRuta = calcularRuta.calcularRuta(datosRuta, inicioLat, inicioLon, puntos.get(0).getLatitude(), puntos.get(0).getLongitude());
            }
        }
        return datosRuta;
    }
}
