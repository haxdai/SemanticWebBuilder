/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gob.sep.becas.ws;

import gob.sep.becas.DatosFromCURPSEP;

/**
 *
 * @author serch
 */
public class TestValidaCURPSEP {

    static public void main (String arg[]) throws Exception{
        ValidaCURPSEP wsVC = new ValidaCURPSEP();
        DatosFromCURPSEP datos = wsVC.checa("MAPS740508HDfrcr07");
        if (null==datos) {
            System.out.println("Error");
        } else {
            System.out.println(datos);
        }
    }

}
