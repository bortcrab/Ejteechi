package objetosNegocio;

import dtos.MapaDTO;

public interface IMapaBO {
    public MapaDTO obtenerMapa() throws ObjetosNegocioException;
}
