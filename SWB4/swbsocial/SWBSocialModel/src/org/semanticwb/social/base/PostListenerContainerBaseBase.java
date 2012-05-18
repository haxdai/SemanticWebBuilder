package org.semanticwb.social.base;


   /**
   * Clase que va ha contener los Post que han sido tomados como base (es decir, que llegan por el listener y que se guardan en la clase PostListenerContainer) para crear un nuevo Post desde la herramienta y que se envía hacia las redes sociales. 
   */
public abstract class PostListenerContainerBaseBase extends org.semanticwb.model.SWBClass 
{
   /**
   * Clase que comprende todos los tipos de Post que pueden ir siendo creados en la herramienta.
   */
    public static final org.semanticwb.platform.SemanticClass social_Post=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/social#Post");
   /**
   * Referencia al Post que es creado por un post que llega por el Listener  y que es tomado como base para crear un nuevo post desde la herramienta y que sera enviado a una o mas redes sociales.
   */
    public static final org.semanticwb.platform.SemanticProperty social_plcb_Post=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/social#plcb_Post");
    public static final org.semanticwb.platform.SemanticClass social_SocialNetwork=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/social#SocialNetwork");
   /**
   * Cuenta de Red Social a la que pertenece el post que llega por el Listener y que es tomado como base para crear un nuevo post desde la herramienta y que sera enviado a una o mas redes sociales.
   */
    public static final org.semanticwb.platform.SemanticProperty social_plcb_SocialNetwork=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/social#plcb_SocialNetwork");
   /**
   * Propiedad inversa que nos proporciona todos los post que han sido creados desde el SSMCC en cuencecuencia de una instancia de Post que llega por el listener, es decir, de un post que es tomado como base para crear nuevos post, estos post que son tomados como base, estan en la clase PostListenerContainerBase (Osea en esta)
   */
    public static final org.semanticwb.platform.SemanticProperty social_hasNewCreatedPostInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/social#hasNewCreatedPostInv");
   /**
   * Clase que va ha contener los Post que han sido tomados como base (es decir, que llegan por el listener y que se guardan en la clase PostListenerContainer) para crear un nuevo Post desde la herramienta y que se envía hacia las redes sociales.
   */
    public static final org.semanticwb.platform.SemanticClass social_PostListenerContainerBase=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/social#PostListenerContainerBase");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/social#PostListenerContainerBase");

    public static class ClassMgr
    {
       /**
       * Returns a list of PostListenerContainerBase for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.social.PostListenerContainerBase
       */

        public static java.util.Iterator<org.semanticwb.social.PostListenerContainerBase> listPostListenerContainerBases(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.social.PostListenerContainerBase>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.social.PostListenerContainerBase for all models
       * @return Iterator of org.semanticwb.social.PostListenerContainerBase
       */

        public static java.util.Iterator<org.semanticwb.social.PostListenerContainerBase> listPostListenerContainerBases()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.social.PostListenerContainerBase>(it, true);
        }
       /**
       * Gets a org.semanticwb.social.PostListenerContainerBase
       * @param id Identifier for org.semanticwb.social.PostListenerContainerBase
       * @param model Model of the org.semanticwb.social.PostListenerContainerBase
       * @return A org.semanticwb.social.PostListenerContainerBase
       */
        public static org.semanticwb.social.PostListenerContainerBase getPostListenerContainerBase(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.social.PostListenerContainerBase)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.social.PostListenerContainerBase
       * @param id Identifier for org.semanticwb.social.PostListenerContainerBase
       * @param model Model of the org.semanticwb.social.PostListenerContainerBase
       * @return A org.semanticwb.social.PostListenerContainerBase
       */
        public static org.semanticwb.social.PostListenerContainerBase createPostListenerContainerBase(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.social.PostListenerContainerBase)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.social.PostListenerContainerBase
       * @param id Identifier for org.semanticwb.social.PostListenerContainerBase
       * @param model Model of the org.semanticwb.social.PostListenerContainerBase
       */
        public static void removePostListenerContainerBase(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.social.PostListenerContainerBase
       * @param id Identifier for org.semanticwb.social.PostListenerContainerBase
       * @param model Model of the org.semanticwb.social.PostListenerContainerBase
       * @return true if the org.semanticwb.social.PostListenerContainerBase exists, false otherwise
       */

        public static boolean hasPostListenerContainerBase(String id, org.semanticwb.model.SWBModel model)
        {
            return (getPostListenerContainerBase(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.social.PostListenerContainerBase with a determined Plcb_Post
       * @param value Plcb_Post of the type org.semanticwb.social.Post
       * @param model Model of the org.semanticwb.social.PostListenerContainerBase
       * @return Iterator with all the org.semanticwb.social.PostListenerContainerBase
       */

        public static java.util.Iterator<org.semanticwb.social.PostListenerContainerBase> listPostListenerContainerBaseByPlcb_Post(org.semanticwb.social.Post value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.PostListenerContainerBase> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(social_plcb_Post, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.social.PostListenerContainerBase with a determined Plcb_Post
       * @param value Plcb_Post of the type org.semanticwb.social.Post
       * @return Iterator with all the org.semanticwb.social.PostListenerContainerBase
       */

        public static java.util.Iterator<org.semanticwb.social.PostListenerContainerBase> listPostListenerContainerBaseByPlcb_Post(org.semanticwb.social.Post value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.PostListenerContainerBase> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(social_plcb_Post,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.social.PostListenerContainerBase with a determined Plcb_SocialNetwork
       * @param value Plcb_SocialNetwork of the type org.semanticwb.social.SocialNetwork
       * @param model Model of the org.semanticwb.social.PostListenerContainerBase
       * @return Iterator with all the org.semanticwb.social.PostListenerContainerBase
       */

        public static java.util.Iterator<org.semanticwb.social.PostListenerContainerBase> listPostListenerContainerBaseByPlcb_SocialNetwork(org.semanticwb.social.SocialNetwork value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.PostListenerContainerBase> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(social_plcb_SocialNetwork, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.social.PostListenerContainerBase with a determined Plcb_SocialNetwork
       * @param value Plcb_SocialNetwork of the type org.semanticwb.social.SocialNetwork
       * @return Iterator with all the org.semanticwb.social.PostListenerContainerBase
       */

        public static java.util.Iterator<org.semanticwb.social.PostListenerContainerBase> listPostListenerContainerBaseByPlcb_SocialNetwork(org.semanticwb.social.SocialNetwork value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.PostListenerContainerBase> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(social_plcb_SocialNetwork,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.social.PostListenerContainerBase with a determined NewCreatedPostInv
       * @param value NewCreatedPostInv of the type org.semanticwb.social.Post
       * @param model Model of the org.semanticwb.social.PostListenerContainerBase
       * @return Iterator with all the org.semanticwb.social.PostListenerContainerBase
       */

        public static java.util.Iterator<org.semanticwb.social.PostListenerContainerBase> listPostListenerContainerBaseByNewCreatedPostInv(org.semanticwb.social.Post value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.PostListenerContainerBase> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(social_hasNewCreatedPostInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.social.PostListenerContainerBase with a determined NewCreatedPostInv
       * @param value NewCreatedPostInv of the type org.semanticwb.social.Post
       * @return Iterator with all the org.semanticwb.social.PostListenerContainerBase
       */

        public static java.util.Iterator<org.semanticwb.social.PostListenerContainerBase> listPostListenerContainerBaseByNewCreatedPostInv(org.semanticwb.social.Post value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.PostListenerContainerBase> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(social_hasNewCreatedPostInv,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a PostListenerContainerBaseBase with a SemanticObject
   * @param base The SemanticObject with the properties for the PostListenerContainerBase
   */
    public PostListenerContainerBaseBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Sets the value for the property Plcb_Post
   * @param value Plcb_Post to set
   */

    public void setPlcb_Post(org.semanticwb.social.Post value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(social_plcb_Post, value.getSemanticObject());
        }else
        {
            removePlcb_Post();
        }
    }
   /**
   * Remove the value for Plcb_Post property
   */

    public void removePlcb_Post()
    {
        getSemanticObject().removeProperty(social_plcb_Post);
    }

   /**
   * Gets the Plcb_Post
   * @return a org.semanticwb.social.Post
   */
    public org.semanticwb.social.Post getPlcb_Post()
    {
         org.semanticwb.social.Post ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(social_plcb_Post);
         if(obj!=null)
         {
             ret=(org.semanticwb.social.Post)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property Plcb_SocialNetwork
   * @param value Plcb_SocialNetwork to set
   */

    public void setPlcb_SocialNetwork(org.semanticwb.social.SocialNetwork value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(social_plcb_SocialNetwork, value.getSemanticObject());
        }else
        {
            removePlcb_SocialNetwork();
        }
    }
   /**
   * Remove the value for Plcb_SocialNetwork property
   */

    public void removePlcb_SocialNetwork()
    {
        getSemanticObject().removeProperty(social_plcb_SocialNetwork);
    }

   /**
   * Gets the Plcb_SocialNetwork
   * @return a org.semanticwb.social.SocialNetwork
   */
    public org.semanticwb.social.SocialNetwork getPlcb_SocialNetwork()
    {
         org.semanticwb.social.SocialNetwork ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(social_plcb_SocialNetwork);
         if(obj!=null)
         {
             ret=(org.semanticwb.social.SocialNetwork)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the org.semanticwb.social.Post
   * @return A GenericIterator with all the org.semanticwb.social.Post
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.social.Post> listNewCreatedPostInvs()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.social.Post>(getSemanticObject().listObjectProperties(social_hasNewCreatedPostInv));
    }

   /**
   * Gets true if has a NewCreatedPostInv
   * @param value org.semanticwb.social.Post to verify
   * @return true if the org.semanticwb.social.Post exists, false otherwise
   */
    public boolean hasNewCreatedPostInv(org.semanticwb.social.Post value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(social_hasNewCreatedPostInv,value.getSemanticObject());
        }
        return ret;
    }

   /**
   * Gets the NewCreatedPostInv
   * @return a org.semanticwb.social.Post
   */
    public org.semanticwb.social.Post getNewCreatedPostInv()
    {
         org.semanticwb.social.Post ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(social_hasNewCreatedPostInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.social.Post)obj.createGenericInstance();
         }
         return ret;
    }
}
