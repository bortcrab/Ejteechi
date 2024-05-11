package programarMantenimiento;

import colecciones.Camion;
import dtos.CamionDTO;
import java.awt.Color;
import java.util.Date;
import javax.swing.JLabel;

public class FacadeProgramarMantenimiento implements IProgramarMantenimiento {

    private final CtrlProgramarMantenimiento ctrlProgramarMantenimiento;

    public FacadeProgramarMantenimiento() {
        this.ctrlProgramarMantenimiento = new CtrlProgramarMantenimiento();
    }

    @Override
    public CamionDTO obtenerPorNumeroUnidad(String numeroUnidad) throws ProgramarMantenimientoException {
        return ctrlProgramarMantenimiento.obtenerPorNumeroUnidad(numeroUnidad);
    }

    @Override
    public CamionDTO actualizarEstado(String numeroUnidad, String atributoEstado, String nuevoEstado) throws ProgramarMantenimientoException {
        return ctrlProgramarMantenimiento.actualizarEstado(numeroUnidad, atributoEstado, nuevoEstado);
    }

    @Override
    public CamionDTO actualizarPrioridadYFechaMantenimiento(String numeroUnidad, String nuevaPrioridad, Date nuevaFechaMantenimiento) throws ProgramarMantenimientoException {
        return ctrlProgramarMantenimiento.actualizarPrioridadYFechaMantenimiento(numeroUnidad, nuevaPrioridad, nuevaFechaMantenimiento);
    }

    public static void actualizarLabelConEstado(JLabel label, String estado) {
        label.setText(estado);
        switch (estado.toLowerCase()) {
            case "bueno":
                label.setForeground(Color.GREEN);
                break;
            case "medio":
                label.setForeground(Color.YELLOW);
                break;
            case "malo":
                label.setForeground(Color.RED);
                break;
            default:
                // Dejar el color por defecto
                label.setForeground(null);
        }
    }

    public static void updatePrioridadLabel(String nivelPrioridad, JLabel lblMantenimiento) {
        lblMantenimiento.setText(nivelPrioridad);
        switch (nivelPrioridad.toLowerCase()) {
            case "alto":
                lblMantenimiento.setForeground(Color.RED);
                break;
            case "medio":
                lblMantenimiento.setForeground(Color.YELLOW);
                break;
            case "bajo":
                lblMantenimiento.setForeground(Color.GREEN);
                break;
            default:
                // Dejar el color por defecto
                lblMantenimiento.setForeground(null);
        }
    }

    public static String actualizarLabelEstado(JLabel label) {
        String textoActual = label.getText();

        switch (textoActual.toLowerCase()) {
            case "bueno":
                label.setText("MEDIO");
                label.setForeground(Color.YELLOW);
                return "medio";
            case "medio":
                label.setText("MALO");
                label.setForeground(Color.RED);
                return "malo";
            case "malo":
                label.setText("BUENO");
                label.setForeground(Color.GREEN);
                return "bueno";
            default:
                // No hacer nada si el texto no coincide con ninguno de los casos anteriores
                return null;
        }
    }

    public static String calcularPrioridad(CamionDTO camion) {
        int contadorMalo = 0;
        int contadorMedio = -2;
        if (camion.getEstadoMotor().equals("MEDIO")) {
            contadorMedio ++;
        }

        if (camion.getEstadoLuces().equals("MEDIO")) {
           contadorMedio ++;
        }

        if (camion.getEstadoLlantas().equals("MEDIO")) {
            contadorMedio ++;
        }

        if (camion.getEstadoLimpieza().equals("MEDIO")) {
            contadorMedio ++;
        }
        if (camion.getEstadoMotor().equals("MALO")) {
            contadorMalo++;
        }

        if (camion.getEstadoLuces().equals("MALO")) {
            contadorMalo++;
        }

        if (camion.getEstadoLlantas().equals("MALO")) {
            contadorMalo++;
        }

        if (camion.getEstadoLimpieza().equals("MALO")) {
            contadorMalo++;
        }

        String nuevaPrioridad;
        if (contadorMalo > 2) {
            nuevaPrioridad = "ALTO";
        } else if (contadorMalo == 1 || contadorMalo == 2 || contadorMedio == 1 || contadorMedio == 2 ) {
            nuevaPrioridad = "MEDIO";
        } else {
            nuevaPrioridad = "BAJO";
        }

        return nuevaPrioridad;
    }

}
