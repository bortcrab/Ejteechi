package obtenerImagenesMapa;

import dtos.JXMapViewerCustom;

public interface IObtenerImagenesMapa {
    
    public void obtenerImagenMapa(JXMapViewerCustom pnlMapa, double[] coordenadas);
    
}
