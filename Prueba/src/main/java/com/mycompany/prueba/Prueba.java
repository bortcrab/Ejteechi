
package com.mycompany.prueba;

import ejteechiFacade.EjteechiFacade;
import ejteechiFacade.IEjteechiFacade;
import presentacion.FrmLogin;

/**
 *
 * @author jorge
 */
public class Prueba {

    public static void main(String[] args) {
        IEjteechiFacade ef = new EjteechiFacade();
        ef.cambiarPantalla(null, new FrmLogin(new EjteechiFacade()));
    }
}
