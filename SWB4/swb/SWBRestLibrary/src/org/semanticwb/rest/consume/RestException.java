/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.rest.consume;

/**
 *
 * @author victor.lorenzana
 */
public class RestException extends Exception{
    public RestException(String msg)
    {
        super(msg);
    }
    public RestException(Throwable e)
    {
        super(e);
    }
    public RestException(String msg,Throwable e)
    {
        super(msg,e);
    }
}
