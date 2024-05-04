package entidades;

import java.util.List;
import org.bson.types.ObjectId;

public class Ruta {
    
    private ObjectId id;
    private List<List<Double>> puntos;

    public Ruta() {
    }

    public Ruta(List<List<Double>> puntos) {
        this.puntos = puntos;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }
    
    public List<List<Double>> getPuntos() {
        return puntos;
    }

    public void setPuntos(List<List<Double>> puntos) {
        this.puntos = puntos;
    }
    
}
