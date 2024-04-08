package mostrarMapa;

import javax.swing.event.MouseInputListener;
import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.input.PanMouseInputListener;
import org.jxmapviewer.input.ZoomMouseWheelListenerCenter;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.TileFactoryInfo;

/**
 *
 * @author Diego Valenzuela Parra - 00000247700
 * @author Juventino López García - 00000248547
 */
public class ManejoMapa {

    public void cargarMapa(JXMapViewer pnlMapa) {
        pnlMapa = (JXMapViewer) pnlMapa;
        TileFactoryInfo info = new OSMTileFactoryInfo();
        DefaultTileFactory tileFactory = new DefaultTileFactory(info);
        pnlMapa.setTileFactory(tileFactory);
        GeoPosition geo = new GeoPosition(27.4832003, -109.93149);
        pnlMapa.setAddressLocation(geo);
        pnlMapa.setZoom(6);

        //  Create event mouse move
        MouseInputListener mm = new PanMouseInputListener(pnlMapa);
        pnlMapa.addMouseListener(mm);
        pnlMapa.addMouseMotionListener(mm);
        pnlMapa.addMouseWheelListener(new ZoomMouseWheelListenerCenter(pnlMapa));
    }
}
