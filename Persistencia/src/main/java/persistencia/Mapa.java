package persistencia;

import java.util.List;
import org.bson.types.ObjectId;

public class Mapa {
    
    private ObjectId id;
    private List<Double> coordenadas;
    private List<Linea> lineas;

    public Mapa() {
    }
    
    public Mapa(List<Double> coordenadas, List<Linea> lineas) {
        this.coordenadas = coordenadas;
        this.lineas = lineas;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public List<Double> getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(List<Double> coordenadas) {
        this.coordenadas = coordenadas;
    }

    public List<Linea> getLineas() {
        return lineas;
    }

    public void setLineas(List<Linea> lineas) {
        this.lineas = lineas;
    }
        
}
