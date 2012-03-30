/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.swb.social.lib.Exception;

/**
 *
 * @author jorge.jimenez
 */
public class SWBSocialException extends java.lang.Exception
{
    /**
     * Generates an instance of this exception with a specified detail message.
     * <p>Genera una instancia de esta excepci&oacute;n con un mensaje de detalle
     * especificado.</p>
     * @param msg the detail message (which is saved for later retrieval by the
     *            {@link Throwable.getMessage() Throwable.getMessage()} method)
     */
    public SWBSocialException(String msg)
    {
        super(msg);
    }

    /**
     * Generates an instance of this exception with the specified detail message and cause.
     * <p>Genera una instancia de esta excepci&oacute;n con el mensaje de detalle
     * y causa especificados.</p>
     * @param msg the detail message (which is saved for later retrieval by the
     *            Throwable.getMessage() method)
     * @param e the cause (which is saved for later retrieval by the {@link Throwable.getCause() Throwable.getCause()}
     *          method). (A {@code null} value is permitted, and indicates that
     *          the cause is nonexistent or unknown.)
     */
    public SWBSocialException(String msg, Exception e)
    {
        super(msg, e);
    }
}
