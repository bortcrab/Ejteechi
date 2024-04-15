package presentacion;

import javax.swing.JFrame;

public class ControlNavegacion {

    public void cambiarPantalla(JFrame origen, JFrame destino) {
        destino.setVisible(true);
        if (origen != null) {
            origen.dispose();
        }
    }
    
}
