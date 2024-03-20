package manejoPantallas;

import javax.swing.JFrame;

/**
 *
 * @author Diego Valenzuela Parra - 00000247700
 * @author Juventino López García - 00000248547
 */
public class ManejoPantallas implements IManejoPantallas {

    @Override
    public void cambiarPantalla(JFrame origen, JFrame destino) {
        destino.setVisible(true);
        if (origen != null) {
            origen.dispose();
        }
    }
}
