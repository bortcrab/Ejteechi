
package ejteechiFacade;

import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jxmapviewer.JXMapViewer;

/**
 *
 * @author Diego Valenzuela Parra - 00000247700
 * @author Juventino López García - 00000248547
 */
public interface IEjteechiFacade {
    
    public void cambiarPantalla(JFrame origen, JFrame destino);
    public void mostrarMapa(JXMapViewer pnlMapa);
}
