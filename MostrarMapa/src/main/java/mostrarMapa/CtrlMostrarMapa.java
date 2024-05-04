package mostrarMapa;

import dtos.DatosRutaDTO;
import utilidades.JXMapViewerCustom;
import dtos.MapaDTO;
import dtos.RutaDTO;
import java.util.List;
import interfaces.IMapaBO;
import implementaciones.MapaBO;
import excepciones.ObjetosNegocioException;
import obtenerImagenesMapa.FacadeObtenerImagenesMapa;
import org.jxmapviewer.viewer.GeoPosition;
import obtenerImagenesMapa.IObtenerImagenesMapa;

public class CtrlMostrarMapa {

    private final IObtenerImagenesMapa obtenerImagenesMapa;
    private final IMapaBO mapaBO;

    public CtrlMostrarMapa() {
        obtenerImagenesMapa = new FacadeObtenerImagenesMapa();
        mapaBO = new MapaBO();
    }

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
        CalcularRuta calcularRuta = new CalcularRuta();
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
