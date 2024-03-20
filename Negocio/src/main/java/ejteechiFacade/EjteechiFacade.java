package ejteechiFacade;

import javax.swing.JFrame;
import manejoPantallas.IManejoPantallas;
import manejoPantallas.ManejoPantallas;

/**
 *
 * @author Diego Valenzuela Parra - 00000247700
 * @author Juventino López García - 00000248547
 */
public class EjteechiFacade implements IEjteechiFacade{
        
    @Override
    public void cambiarPantalla(JFrame origen, JFrame destino) {
        IManejoPantallas mp = new ManejoPantallas();
        mp.cambiarPantalla(origen, destino);
    }

}
