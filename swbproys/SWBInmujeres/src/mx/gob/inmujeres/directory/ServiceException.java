package mx.gob.inmujeres.directory;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author victor.lorenzana
 */
public class ServiceException extends Exception {

    private String login;
    public ServiceException(String message,String login)
    {
        super(message);
        this.login=login;
    }

    public ServiceException(String message,Throwable e,String login)
    {
        super(message,e);
        this.login=login;
    }
    public ServiceException(String message,Throwable e)
    {
        super(message,e);
        
    }
    public ServiceException(String message)
    {
        super(message);

    }
    public String getLogin()
    {
        return login;
    }
}
