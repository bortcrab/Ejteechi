/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import javax.swing.JFrame;

/**
 *
 * @author
 */
public class ControlNavegacion {

    public void cambiarPantalla(JFrame origen, JFrame destino) {
        destino.setVisible(true);
        if (origen != null) {
            origen.dispose();
        }
    }
    
}
