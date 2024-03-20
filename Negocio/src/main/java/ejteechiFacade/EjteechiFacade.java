package ejteechiFacade;

import static java.awt.SystemColor.info;
import javax.swing.JFrame;
import javax.swing.JPanel;
import manejoMapa.IManejoMapa;
import manejoMapa.ManejoMapa;
import manejoPantallas.IManejoPantallas;
import manejoPantallas.ManejoPantallas;
import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.viewer.DefaultTileFactory;

/**
 *
 * @author Diego Valenzuela Parra - 00000247700
 * @author Juventino López García - 00000248547
 */
public class EjteechiFacade implements IEjteechiFacade{
        
    @Override
    public void cambiarPantalla(JFrame origen, JFrame destino) {
        IManejoPantallas mp = new ManejoPantallas();
        mp.cambiarPantalla(origen, destino);
    }

    @Override
    public void mostrarMapa(JXMapViewer pnlMapa) {
        IManejoMapa mp = new ManejoMapa();
        mp.cargarMapa(pnlMapa);
    }

}
