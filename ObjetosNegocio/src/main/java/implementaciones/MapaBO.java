package implementaciones;

import excepciones.ObjetosNegocioException;
import interfaces.IMapaBO;
import dtos.LineaDTO;
import dtos.MapaDTO;
import dtos.RutaDTO;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.jxmapviewer.viewer.DefaultWaypoint;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.Waypoint;
import interfaces.IMapaDAO;
import entidades.Linea;
import entidades.Mapa;
import implementaciones.MapaDAO;
import excepciones.PersistenciaException;
import entidades.Ruta;

public class MapaBO implements IMapaBO {

    private final IMapaDAO mapaDAO = new MapaDAO();

    @Override
    public MapaDTO obtenerMapa() throws ObjetosNegocioException {
        try {
            Mapa mapa = mapaDAO.obtenerMapa();
            MapaDTO mapaDTO = convertirMapaDTO(mapa);
            return mapaDTO;
        } catch (PersistenciaException pe) {
            throw new ObjetosNegocioException(pe.getMessage());
        }
    }

    @Override
    public MapaDTO convertirMapaDTO(Mapa mapa) {
        List<Linea> lineas = mapa.getLineas();
        List<LineaDTO> lineasDTO = new ArrayList<>();
        for (Linea linea : lineas) {
            lineasDTO.add(convertirLineaDTO(linea));
        }
        double[] coordenada = mapa.getCoordenadas().stream().mapToDouble(Double::doubleValue).toArray();
        MapaDTO mapaDTO = new MapaDTO(coordenada, lineasDTO);
        return mapaDTO;
    }

    @Override
    public LineaDTO convertirLineaDTO(Linea linea) {
        List<List<Double>> paradas = linea.getParadas();
        Set<Waypoint> paradasWaypoint = new HashSet<>();
        for (List<Double> parada : paradas) {
            double[] coordenada = parada.stream().mapToDouble(Double::doubleValue).toArray();
            paradasWaypoint.add(new DefaultWaypoint(new GeoPosition(coordenada)));
        }
        RutaDTO rutaDTO = convertirRutaDTO(linea.getRuta());
        LineaDTO lineaDTO = new LineaDTO(paradasWaypoint, rutaDTO);
        return lineaDTO;
    }

    @Override
    public RutaDTO convertirRutaDTO(Ruta ruta) {
        List<List<Double>> puntos = ruta.getPuntos();
        List<GeoPosition> puntosGeoPosition = new ArrayList<>();
        for (List<Double> punto : puntos) {
            double[] coordenada = punto.stream().mapToDouble(Double::doubleValue).toArray();
            puntosGeoPosition.add(new GeoPosition(coordenada));
        }
        RutaDTO rutaDTO = new RutaDTO(new ArrayList<>(), puntosGeoPosition);

        return rutaDTO;
    }

}
