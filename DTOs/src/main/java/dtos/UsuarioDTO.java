package dtos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Diego Valenzuela Parra - 00000247700
 */
public class UsuarioDTO {
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String telefono;
    private String curp;
    private String rfc;
    private String correo;
    private String contra;
    private String tipo;

    public UsuarioDTO() {
    }

    public UsuarioDTO(String nombres, String apellidoPaterno, String apellidoMaterno, String telefono, String curp, String rfc, String correo, String contra, String tipo) {
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.telefono = telefono;
        this.curp = curp;
        this.rfc = rfc;
        this.correo = correo;
        this.contra = contra;
        this.tipo = tipo;
    }

    public UsuarioDTO(String correo, String contra, String tipo) {
        this.correo = correo;
        this.contra = contra;
        this.tipo = tipo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
