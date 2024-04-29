package obtenerImagenesMapa;

import dtos.JXMapViewerCustom;

/**
 *
 * @author Diego Valenzuela Parra - 00000247700
 */
public class FacadeObtenerImagenesMapa implements IObtenerImagenesMapa {

    private CtrlObtenerImagenesMapa ctrlObtenerImagenesMapa = new CtrlObtenerImagenesMapa();
    
    @Override
    public void obtenerImagenMapa(JXMapViewerCustom pnlMapa, double[] coordenadas) {
        ctrlObtenerImagenesMapa.obtenerImagenesMapa(pnlMapa, coordenadas);
    }
    
}
