/*
 * Validadores.java
 */
package presentacion;

import dtos.ClienteDTO;
import javax.swing.JFrame;

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
     * @throws PresentacionException si la contraseña está vacía o no es igual a
     * la otra contraseña.
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
     * Método para validar si hay una sesión activa para continuar.
     *
     * @param cliente Cliente que debe estar logueado.
     * @param pantalla Pantalla donde se hace la validación.
     * @throws PresentacionException si la sesión no está activa
     */
    public static void validarSesion(ClienteDTO cliente, JFrame pantalla) throws PresentacionException {
        if (cliente == null) {
            FrmLogin frmLogin = new FrmLogin();
            frmLogin.setVisible(true);
            pantalla.dispose();
            throw new PresentacionException("Necesitas una sesión activa para acceder a esta funcionalidad.");
        }
    }
}
