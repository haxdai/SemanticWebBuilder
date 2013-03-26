package mx.gob.inmujeres.directory;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import org.semanticwb.base.SWBAppObject;

/**
 *
 * @author victor.lorenzana
 */
public class StartUp implements SWBAppObject{

    public void init()
    {
        Directorio.start();
    }

    public void destroy()
    {
        Directorio.stop();
    }

    public void refresh()
    {
        
    }

}
