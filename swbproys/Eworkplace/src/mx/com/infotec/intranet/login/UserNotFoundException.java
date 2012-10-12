/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.infotec.intranet.login;

/**
 *
 * @author victor.lorenzana
 */
public class UserNotFoundException extends Exception {

    public UserNotFoundException(String user)
    {
        super(user);
    }
}
