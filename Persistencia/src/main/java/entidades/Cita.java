package entidades;

import java.util.Date;
import org.bson.types.ObjectId;

/**
 *
 * @author Diego Valenzuela Parra - 00000247700
 */
public class Cita {
    
    private ObjectId id;
    private int numeroCita;
    private Date fecha;
    private String documentos;
    private String asesor;

    public Cita() {
    }

    public Cita(ObjectId id, int numeroCita, Date fecha, String documentos, String asesor) {
        this.id = id;
        this.numeroCita = numeroCita;
        this.fecha = fecha;
        this.documentos = documentos;
        this.asesor = asesor;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public int getNumeroCita() {
        return numeroCita;
    }

    public void setNumeroCita(int numeroCita) {
        this.numeroCita = numeroCita;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDocumentos() {
        return documentos;
    }

    public void setDocumentos(String documentos) {
        this.documentos = documentos;
    }

    public String getAsesor() {
        return asesor;
    }

    public void setAsesor(String asesor) {
        this.asesor = asesor;
    }
    
}
