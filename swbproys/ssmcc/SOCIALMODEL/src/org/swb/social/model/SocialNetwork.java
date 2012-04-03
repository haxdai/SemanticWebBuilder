package org.swb.social.model;


   /**
   * Objeto que se encarga de almacenar todos los datos de una red social 
   */
public class SocialNetwork extends org.swb.social.model.base.SocialNetworkBase
{
    public String msg=null;
    String photo=null;
    String video=null;

    public SocialNetwork(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public static java.util.Iterator<org.swb.social.model.SocialNetwork> listSocialNetworkByClassName(String value,org.semanticwb.model.SWBModel model)
    {
        org.semanticwb.model.GenericIterator<org.swb.social.model.SocialNetwork> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(smcc_sn_name, value));
        return it;
    }
  
}
