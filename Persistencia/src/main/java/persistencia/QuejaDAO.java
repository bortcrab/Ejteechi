package persistencia;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.Date;
import org.bson.Document;
import org.bson.types.ObjectId;

public class QuejaDAO implements IQuejaDAO {

    private final IConexion conexion = new Conexion();
    private final MongoCollection<Document> coleccion;

    public QuejaDAO() {
        MongoDatabase db = conexion.crearConexion();
        coleccion = db.getCollection("quejas");
    }

    @Override
    public Document enviarComentario(String comentario, String tipo, boolean anonimo, ObjectId iDcliente) throws PersistenciaException {

        Document nuevoComentario = new Document();
        nuevoComentario.append("comentario", comentario)
                .append("tipo", tipo)
                .append("anonimo", anonimo)
                .append("fecha", new Date()); 

        if (!anonimo) {
            nuevoComentario.append("idCliente", iDcliente);
        }

        coleccion.insertOne(nuevoComentario);
        return nuevoComentario;
    }
    
    
    

}
