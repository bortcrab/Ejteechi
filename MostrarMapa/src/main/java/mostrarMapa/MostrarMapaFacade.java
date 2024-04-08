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
public class MostrarMapaFacade implements IMostrarMapa {

    ManejoMapa manejoMapa = new ManejoMapa();
    
    @Override
    public void cargarMapa(JXMapViewer pnlMapa) {
        manejoMapa.cargarMapa(pnlMapa);
    }
}
