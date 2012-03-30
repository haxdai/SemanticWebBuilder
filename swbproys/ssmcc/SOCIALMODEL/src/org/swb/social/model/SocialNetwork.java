package org.swb.social.model;

import org.swb.social.lib.SocialNetWorkInt;


   /**
   * Objeto que se encarga de almacenar todos los datos de una red social 
   */
public abstract class SocialNetwork extends org.swb.social.model.base.SocialNetworkBase implements SocialNetWorkInt
{
    public String msg=null;
    String photo=null;
    String video=null;

    public SocialNetwork(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    
    

}
