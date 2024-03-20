
package ejteechiFacade;

import dto.ClienteDTO;
import javax.swing.JFrame;
import org.jxmapviewer.JXMapViewer;

/**
 *
 * @author Diego Valenzuela Parra - 00000247700
 * @author Juventino López García - 00000248547
 */
public interface IEjteechiFacade {
    
    public void cambiarPantalla(JFrame origen, JFrame destino);
    public void acceder(ClienteDTO cliente);
    public void registrar(ClienteDTO cliente);
    public void mostrarMapa(JXMapViewer pnlMapa);
}
