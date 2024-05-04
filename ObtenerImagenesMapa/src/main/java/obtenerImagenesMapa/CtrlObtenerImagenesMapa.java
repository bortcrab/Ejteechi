package obtenerImagenesMapa;

import utilidades.JXMapViewerCustom;
import javax.swing.event.MouseInputListener;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.input.PanMouseInputListener;
import org.jxmapviewer.input.ZoomMouseWheelListenerCursor;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.TileFactoryInfo;

public class CtrlObtenerImagenesMapa {
    public void obtenerImagenesMapa(JXMapViewerCustom pnlMapa, double[] coordenadas) {
        // Creamos un objeto TileFactoryInfo.
        TileFactoryInfo info = new OSMTileFactoryInfo();
        // Creamos un objeto TileFactory.
        DefaultTileFactory tileFactory = new DefaultTileFactory(info);
        
        // Al panel del parámetro le asignamos la el TileFactory.
        pnlMapa.setTileFactory(tileFactory);
        
        // Asignamos las coordenadas del mapa.
        GeoPosition geo = new GeoPosition(coordenadas);
        pnlMapa.setAddressLocation(geo);
        pnlMapa.setZoom(6);
        
        // Creamos eventos para moverse por el mapa y para hacer zoom.
        MouseInputListener mil = new PanMouseInputListener(pnlMapa);
        pnlMapa.addMouseListener(mil);
        pnlMapa.addMouseMotionListener(mil);
        pnlMapa.addMouseWheelListener(new ZoomMouseWheelListenerCursor(pnlMapa));
    }
}
