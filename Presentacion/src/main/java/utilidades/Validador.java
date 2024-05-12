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
     * Método para validar que un nombre cumple con el formato correcto.
     *
     * @param correo Correo a validar.
     * @throws PresentacionException si el nombre está vacío, excede la longitud
     * de caracteres o no cumple con el patrón especifico.
     */
    
    public void validarNombres(String nombres) throws PresentacionException {
        try {
            validarVacio(nombres);
        } catch (PresentacionException pe) {
            // Si nombres está vacío.
            throw new PresentacionException("Nombre(s) no puede estar vacío. ");
        }
        if (nombres.length() > 25) {
            // Si el correo excede los 256 caracteres.
            throw new PresentacionException("Nombre(s) excede el límite. ");
        }
        if (!nombres.matches("^[A-Z][a-zA-Z]*(\\s+[A-Z][a-zA-Z]*)*$")) {
            // Si el texto no coincide con el patrón "Nombre(s)".
            throw new PresentacionException("El nombre no es válido. "
                    + "Debe contener solo letras con la primera letra de cada nombre en mayúscula.");
        }
    }
    
    /**
     * Método para validar que el apellido paterno cumple con el formato correcto.
     *
     * @param apellidoP apellido paterno a validar.
     * @throws PresentacionException si el apellido está vacio, excede la
     * longitud de caracteres o no cumple con el patrón especifico.
     */
    public void validarApellidoP(String apellidoP) throws PresentacionException {
        try {
            validarVacio(apellidoP);
        } catch (PresentacionException pe) {
            // Si nombres está vacío.
            throw new PresentacionException("El apellido paterno no puede estar vacío. ");
        }
        if (apellidoP.length() > 25) {
            // Si el correo excede los 256 caracteres.
            throw new PresentacionException("El apellido paterno excede el límite. ");
        }
        if (!apellidoP.matches("^[A-Z][a-zA-Z]*(\\s+[A-Z][a-zA-Z]*)*$")) {
            // Si el texto no coincide con el patrón "Apellido Paterno".
            throw new PresentacionException("El apellido paterno no es válido. "
                    + "Debe contener solo letras con la primera letra de cada nombre en mayúscula.");
        }
    }
    
    /**
     * Método para validar que el apellido materno cumple con el formato correcto.
     *
     * @param apellidoM apellido materno a validar.
     * @throws PresentacionException si el apellido está vacío, excede la
     * longitud de caracteres o no cumple con el patrón especifico.
     */
    public void validarApellidoM(String apellidoM) throws PresentacionException {
        try {
            validarVacio(apellidoM);
        } catch (PresentacionException pe) {
            // Si nombres está vacío.
            throw new PresentacionException("El apellido paterno no puede estar vacío. ");
        }
        if (apellidoM.length() > 25) {
            // Si el correo excede los 256 caracteres.
            throw new PresentacionException("El apellido paterno excede el límite. ");
        }
        if (!apellidoM.matches("^[A-Z][a-zA-Z]*(\\s+[A-Z][a-zA-Z]*)*$")) {
            // Si el texto no coincide con el patrón "Apellido Paterno".
            throw new PresentacionException("El apellido paterno no es válido. "
                    + "Debe contener solo letras con la primera letra de cada nombre en mayúscula.");
        }
    }
    
    /**
     * Método para validar que un correo cumple con el formato correcto.
     *
     * @param correo correo a validar.
     * @throws PresentacionException si el correo está vacío, excede la
     * longitud de caracteres o no cumple con el patrón especifico.
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
     * Método para validar que un telefono cumple con el formato correcto.
     *
     * @param telefono telefono a validar.
     * @throws PresentacionException si el telefono está vacío, excede la
     * longitud de caracteres o no cumple con el patrón especifico.
     */
    public void validarTelefono(String telefono) throws PresentacionException {
        try {
            validarVacio(telefono);
        } catch (PresentacionException pe) {
            // Si el correo está vacío.
            throw new PresentacionException("El correo no puede estar vacío. "
                    + "Ejemplo: \"ejemplo@ejemplo.com\".");
        }
        // Elimina cualquier espacio en blanco y guiones del número de teléfono
        telefono = telefono.replaceAll("\\s|-", "");
        
        // Verifica si el número de teléfono tiene exactamente 10 dígitos
        if (telefono.matches("\\d{10}")) {
            System.out.println("Número de teléfono válido.");
        } else {
            System.out.println("Número de teléfono inválido."
                                + "Tienen que ser 10 digitos");
        }
    }
    
    /**
     * Método para validar que una CURP cumple con el formato correcto.
     *
     * @param curp curp a validar.
     * @throws PresentacionException si la curp está vacía, excede la
     * longitud de caracteres o no cumple con el patrón especifico.
     */
    public void validarCURP(String curp) throws PresentacionException {
        try {
            validarVacio(curp);
        } catch (PresentacionException pe) {
            // Si el correo está vacío.
            throw new PresentacionException("El correo no puede estar vacío. "
                    + "Ejemplo: \"ejemplo@ejemplo.com\".");
        }
        // Elimina cualquier espacio en blanco del CURP y lo convierte a mayúsculas
        curp = curp.trim().toUpperCase();

        // Verifica si la CURP tiene el formato correcto
        if (curp.matches("[a-zA-Z0-9]{18}")) {
            System.out.println("CURP valida.");
        } else {
            System.out.println("CURP inválida. Debe contener exactamente 18 caracteres alfanuméricos.");
        }
    }
    
    
    /**
     * Método para validar que un rfc cumple con el formato correcto.
     *
     * @param rfc rfc a validar.
     * @throws PresentacionException si el rfc está vacío, excede la
     * longitud de caracteres o no cumple con el patrón especifico.
     */
    public void validarRFC(String rfc) throws PresentacionException {
        try {
            validarVacio(rfc);
        } catch (PresentacionException pe) {
            // Si el correo está vacío.
            throw new PresentacionException("El correo no puede estar vacío. "
                    + "Ejemplo: \"ejemplo@ejemplo.com\".");
        }
        // Elimina cualquier espacio en blanco del CURP y lo convierte a mayúsculas
        rfc = rfc.trim().toUpperCase();

        // Verifica si la CURP tiene el formato correcto
        if (rfc.matches("[a-zA-Z0-9]{13}")) {
            System.out.println("RFC valida.");
        } else {
            System.out.println("CURFCRP inválida. Debe contener exactamente 13 caracteres alfanuméricos.");
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
     * 
     * @param contenido
     * @throws PresentacionException 
     */
    public void validarRespuesta(String contenido) throws PresentacionException {
        try {
            validarVacio(contenido);
        } catch (PresentacionException pe) {
            // Si la contraseña está vacía.
            throw new PresentacionException("El mensaje no puede estar vacío.");
        }
        if (contenido.length() > 500) {
            // Si la contraseña es diferente a la original.
            throw new PresentacionException("El mensaje no puede exceder los 500 caracteres.");
        }
    }

    public void validarNombres(String nombres) throws PresentacionException {
        try {
            validarVacio(nombres);
        } catch (PresentacionException pe) {
            // Si la contraseña está vacía.
            throw new PresentacionException("El nombre no puede estar vacío.");
        }
        if (nombres.length() > 100) {
            // Si la contraseña es diferente a la original.
            throw new PresentacionException("El nombre no puede exceder los 100 caracteres.");
        }
        if (!nombres.matches("^[a-zA-ZÀ-ÿ ]+$")) {
            // Si la contraseña es diferente a la original.
            throw new PresentacionException("El nombre sólo puede tener letras.");
        }
    }
    
    public void validarApellidoP(String apellido) throws PresentacionException {
        try {
            validarVacio(apellido);
        } catch (PresentacionException pe) {
            // Si la contraseña está vacía.
            throw new PresentacionException("El apellido paterno no puede estar vacío.");
        }
        if (apellido.length() > 100) {
            // Si la contraseña es diferente a la original.
            throw new PresentacionException("El apellido paterno no puede exceder los 100 caracteres.");
        }
        if (!apellido.matches("^[a-zA-ZÀ-ÿ ]+$")) {
            // Si la contraseña es diferente a la original.
            throw new PresentacionException("El apellido paterno sólo puede tener letras.");
        }
    }
    
    public void validarApellidoM(String apellido) throws PresentacionException {
        try {
            validarVacio(apellido);
        } catch (PresentacionException pe) {
            // Si la contraseña está vacía.
            throw new PresentacionException("El apellido materno no puede estar vacío.");
        }
        if (apellido.length() > 100) {
            // Si la contraseña es diferente a la original.
            throw new PresentacionException("El apellido materno no puede exceder los 100 caracteres.");
        }
        if (!apellido.matches("^[a-zA-ZÀ-ÿ ]+$")) {
            // Si la contraseña es diferente a la original.
            throw new PresentacionException("El apellido materno sólo puede tener letras.");
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
