package persistencia;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.Date;
import org.bson.Document;

public class QuejaDAO implements IQuejaDAO {

    private final IConexion conexion = new Conexion();
    private final MongoCollection<Document> coleccion;

    public QuejaDAO() {
        MongoDatabase db = conexion.crearConexion();
        coleccion = db.getCollection("quejas");
    }

    @Override
    public Document enviarComentario(Queja queja) throws PersistenciaException {

        Document nuevoComentario = new Document();
        nuevoComentario.append("comentario", queja.getQueja())
                .append("tipo", queja.getTipoQueja())
                .append("anonimo", queja.isAnonimo())
                .append("fecha", new Date()); 

        if (!queja.isAnonimo()) {
            nuevoComentario.append("idCliente", queja.getIdCliente());
        }

        coleccion.insertOne(nuevoComentario);
        return nuevoComentario;
    }
    
    
    

}
