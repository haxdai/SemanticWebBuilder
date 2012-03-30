/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.swb.social.lib.Exception;

import org.swb.social.lib.Exception.SWBSocialException;

/**
 *
 * @author jorge.jimenez
 */
public class SWBSocialNetworkException extends SWBSocialException{

     /**
     * Instantiates a new SWBSocialNetworkException exception.
     *
     * @param msg the msg
     */
    public SWBSocialNetworkException(String msg)
    {
        super(msg);
    }

    /**
     * Instantiates a new SWBSocialNetworkException exception.
     *
     * @param msg the msg
     * @param e the e
     */
    public SWBSocialNetworkException(String msg, Exception e)
    {
        super(msg,e);
    }

}
