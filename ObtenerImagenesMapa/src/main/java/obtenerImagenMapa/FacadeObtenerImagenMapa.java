package obtenerImagenMapa;

import dtos.JXMapViewerCustom;

/**
 *
 * @author Diego Valenzuela Parra - 00000247700
 */
public class FacadeObtenerImagenMapa implements IObtenerImagenMapa {

    private CtrlObtenerImagenMapa ctrlObtenerMapa = new CtrlObtenerImagenMapa();
    
    @Override
    public void obtenerImagenMapa(JXMapViewerCustom pnlMapa, double[] coordenadas) {
        ctrlObtenerMapa.obtenerImagenesMapa(pnlMapa, coordenadas);
    }
    
}
