package entidades;

import java.util.List;
import org.bson.types.ObjectId;

public class Linea {
    
    private ObjectId id;
    private int numero;
    private List<List<Double>> paradas;
    private Ruta ruta;

    public Linea() {
    }

    public Linea(int numero, List<List<Double>> paradas, Ruta ruta) {
        this.numero = numero;
        this.paradas = paradas;
        this.ruta = ruta;
    }
    
    public Linea(Ruta ruta) {
        this.ruta = ruta;
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

    public List<List<Double>> getParadas() {
        return paradas;
    }

    public void setParadas(List<List<Double>> paradas) {
        this.paradas = paradas;
    }
    
    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }
    
}
