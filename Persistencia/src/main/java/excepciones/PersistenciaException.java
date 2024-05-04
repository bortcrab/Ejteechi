/*
 * PersistenciaException.java
 */
package excepciones;

public class PersistenciaException extends Exception {

    /**
     * Constructor que establece el mensaje de error que explica el origen del
     * error que ocurrio al ejecutar una operación.
     *
     * @param mensaje Mensaje de error.
     */
    public PersistenciaException(String mensaje) {
        super(mensaje);
    }
}
