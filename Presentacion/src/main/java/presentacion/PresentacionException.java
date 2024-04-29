/*
 * PersistenciaException.java
 */
package presentacion;

public class PresentacionException extends Exception {

    /**
     * Constructor que establece el mensaje de error que explica el origen del
     * error que ocurrio al ejecutar una operación.
     *
     * @param mensaje Mensaje de error.
     */
    public PresentacionException(String mensaje) {
        super(mensaje);
    }
}
