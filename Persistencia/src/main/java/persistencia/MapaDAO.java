package persistencia;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;

public class MapaDAO implements IMapaDAO {
    
    private final IConexion conexion = new Conexion();
    private final MongoCollection<Document> coleccion;
    private static final Logger logger = Logger.getLogger(MapaDAO.class.getName());
    
    public MapaDAO() {
        MongoDatabase db = conexion.crearConexion();
        coleccion = db.getCollection("mapas");
    }
    
    @Override
    public Mapa obtenerMapa() throws PersistenciaException {
        // Definir la operación de agregación con $lookup
        Document buscarLineas = new Document("$lookup",
                new Document("from", "lineas")
                        .append("localField", "lineas")
                        .append("foreignField", "_id")
                        .append("as", "lineas"));
        
        Document buscarRutas = new Document("$lookup",
                new Document("from", "rutas")
                        .append("localField", "lineas.ruta")
                        .append("foreignField", "_id")
                        .append("as", "rutas"));


        // Ejecutar la agregación
        Document documento = coleccion.aggregate(Arrays.asList(buscarLineas, buscarRutas)).first();
        logger.log(Level.INFO, "Se ha consultado la colección 'mapas'.");    
        
        if (documento == null) {
            throw new PersistenciaException("No se encontró ningún mapa.");
        }
        
        List<Document> lineas = documento.getList("lineas", Document.class);
        List<Document> rutas = documento.getList("rutas", Document.class);
        
        List<Linea> listaLineas = new ArrayList<>();
        
        for (Document ruta : rutas) {
            int numeroRuta = ruta.getInteger("numero");
            List<List<Double>> rutaPuntos = (List<List<Double>>) ruta.get("puntos");
            Ruta rutaEntidad = new Ruta(numeroRuta, rutaPuntos);
            for (Document linea : lineas) {
                int numeroLinea = linea.getInteger("numero");
                List<List<Double>> paradas = (List<List<Double>>) linea.get("paradas");
                if (numeroRuta == numeroLinea) {
                    Linea lineaEntidad = new Linea(numeroLinea, paradas, rutaEntidad);
                    listaLineas.add(lineaEntidad);
                }
            }
        }
                
        List<Double> mapaCoord = (List<Double>) documento.get("coordenadas");
        Mapa mapa = new Mapa(mapaCoord, listaLineas);
        return mapa;
    }
}
