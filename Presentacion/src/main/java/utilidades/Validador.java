/*
 * Validadores.java
 */
package utilidades;

import pantallas.FrmLogin;
import dtos.UsuarioDTO;
import javax.swing.JFrame;
import excepciones.PresentacionException;

/**
 * Clase con todos los métodos necesarios para validar que los datos
 * introducidos por el cliente tengan el formato correcto.
 *
 * @author Diego Valenzuela Parra - 00000247700
 */
public class Validador {

    /**
     * Método para validar cadenas vacías o con puros espacios.
     *
     * @param cadena Cadena a validar.
     * @throws PresentacionException si la cadena del parámetro está vacía.
     */
    public void validarVacio(String cadena) throws PresentacionException {
        if (cadena.isBlank()) {
            throw new PresentacionException("");
        }
    }

    /**
     * Método para validar que un correo cumple con el formato correcto.
     *
     * @param correo Correo a validar.
     * @throws PresentacionException si el correo está vacío, excede la longitud
     * de caracteres o no cumple con el patrón especifico.
     */
    public void validarCorreo(String correo) throws PresentacionException {
        try {
            validarVacio(correo);
        } catch (PresentacionException pe) {
            // Si el correo está vacío.
            throw new PresentacionException("El correo no puede estar vacío. "
                    + "Ejemplo: \"ejemplo@ejemplo.com\".");
        }
        if (correo.length() > 256) {
            // Si el correo excede los 256 caracteres.
            throw new PresentacionException("El correo excede el límite. "
                    + "Ejemplo: \"ejemplo@ejemplo.com\".");
        }
        if (!correo.matches("^[\\w\\-\\.]+@([\\w-]+\\.)+[\\w-]{2,}$")) {
            // Si el correo no coincide con el patrón "ejemplo@ejemplo.com".
            throw new PresentacionException("El correo no es válido. "
                    + "Ejemplo: \"ejemplo@ejemplo.com\".");
        }
    }

    /**
     * Método para validar que una contraseña cumple con el formato correcto.
     *
     * @param contrasenia Contraseña a validar.
     * @throws PresentacionException si la contraseña está vacía, excede la
     * longitud de caracteres o no cumple con el patrón especifico.
     */
    public void validarContrasenia(String contrasenia) throws PresentacionException {
        try {
            validarVacio(contrasenia);
        } catch (PresentacionException pe) {
            // Si la contraseña está vacía.
            throw new PresentacionException("La contraseña no puede estar vacía. "
                    + "Ejemplo: \"jk2aUHhaj9\".");
        }
        if (contrasenia.length() < 8) {
            // Si la contraseña tiene menos de 8 caracteres.
            throw new PresentacionException("La contraseña debe tener al menos 8 caracteres. "
                    + "Ejemplo: \"jk2aUHhaj9\".");
        }
        if (!contrasenia.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+")) {
            // Si la contraseña no cumple con el formato definido.
            throw new PresentacionException("La contraseña debe contener:"
                    + "\n• Al menos una minúscula."
                    + "\n• Al menos una mayúscula."
                    + "\n• Al menos un número. "
                    + "Ejemplo: \"jk2aUHhaj9\".");
        }
    }

    /**
     * Método para validar que un la contraseña para confirmar es la misma que
     * la otra.
     *
     * @param contraseniaOriginal Contraseña a la cual la otra tiene que ser
     * igual.
     * @param contraseniaCopia Contraseña a validar.
     * @throws PresentacionException si la contraseña está vacía o es diferente
     * a la otra contraseña.
     */
    public void validarConfirmarContrasenia(String contraseniaOriginal, String contraseniaCopia) throws PresentacionException {
        try {
            validarVacio(contraseniaCopia);
        } catch (PresentacionException pe) {
            // Si la contraseña está vacía.
            throw new PresentacionException("La segunda contraseña no puede estar vacía. "
                    + "Ejemplo: \"jk2aUHhaj9\".");
        }
        if (!contraseniaCopia.equals(contraseniaOriginal)) {
            // Si la contraseña es diferente a la original.
            throw new PresentacionException("Las contraseñas son diferentes.");
        }
    }
    
    /**
     * 
     * @param contenido
     * @throws PresentacionException 
     */
    public void validarTicket(String contenido) throws PresentacionException {
        try {
            validarVacio(contenido);
        } catch (PresentacionException pe) {
            // Si la contraseña está vacía.
            throw new PresentacionException("El ticket no puede estar vacío.");
        }
        if (contenido.length() > 500) {
            // Si la contraseña es diferente a la original.
            throw new PresentacionException("El ticket no puede exceder los 500 caracteres.");
        }
    }

    /**
     * Método para validar si hay una sesión activa para continuar.
     *
     * @param usuario Usuario que debe tener una sesión iniciada.
     * @param pantalla Pantalla donde se hace la validación.
     * @throws PresentacionException si la sesión no está activa
     */
    public static void validarSesion(UsuarioDTO usuario, JFrame pantalla) throws PresentacionException {
        if (usuario == null) { // Validamos que el usuario no sea null.
            FrmLogin frmLogin = new FrmLogin(); // Lo mandamos de vuelta a login.
            frmLogin.setVisible(true);
            pantalla.dispose(); // Se destruye la pantalla donde se hace la validación.
            throw new PresentacionException("Necesitas una sesión activa para acceder a esta funcionalidad.");
        }
    }
}
