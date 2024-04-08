package mostrarMapa;

import org.jxmapviewer.JXMapViewer;

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
