/*
 * CrearCuentaClienteException.java
 */
package excepciones;

/**
 * Clase para customizar las excepciones generadas en el subsistema MostrarMapa.
 *
 * @author Diego Valenzuela Parra - 00000247700
 */
public class CrearCuentaClienteException extends Exception {

    /**
     * Constructor que establece el mensaje de error que explica el origen del
     * error que ocurrió al ejecutar una operación.
     *
     * @param mensaje Mensaje de error.
     */
    public CrearCuentaClienteException(String mensaje) {
        super(mensaje);
    }
}
