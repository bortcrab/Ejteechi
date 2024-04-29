package persistencia;

import java.util.List;
import org.bson.types.ObjectId;

public class Ruta {
    
    private ObjectId id;
    private int numero;
    private List<List<Double>> puntos;

    public Ruta() {
    }

    public Ruta(int numero, List<List<Double>> puntos) {
        this.numero = numero;
        this.puntos = puntos;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    public List<List<Double>> getPuntos() {
        return puntos;
    }

    public void setPuntos(List<List<Double>> puntos) {
        this.puntos = puntos;
    }
    
}
