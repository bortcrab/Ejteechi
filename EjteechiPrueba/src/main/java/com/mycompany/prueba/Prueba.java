
package com.mycompany.prueba;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import presentacion.ControlNavegacion;
import presentacion.FrmLogin;

/**
 *
 * @author jorge
 */
public class Prueba {

    public static void main(String[] args) {
        // Asignamos el look and feel Flatlaf Mac Light.
        try {
            UIManager.setLookAndFeel(new FlatMacLightLaf());
        } catch (UnsupportedLookAndFeelException e) {
            
        }
        
        ControlNavegacion control = new ControlNavegacion();
        control.cambiarPantalla(null, new FrmLogin());
    }
}
