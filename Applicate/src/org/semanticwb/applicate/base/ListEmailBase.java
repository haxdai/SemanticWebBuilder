package org.semanticwb.applicate.base;


public abstract class ListEmailBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticProperty app_verificacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/applicate#verificacion");
    public static final org.semanticwb.platform.SemanticProperty app_email=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/applicate#email");
    public static final org.semanticwb.platform.SemanticClass app_ListEmail=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://org.semanticwb.resources/applicate#ListEmail");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://org.semanticwb.resources/applicate#ListEmail");

    public static class ClassMgr
    {
       /**
       * Returns a list of ListEmail for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.applicate.ListEmail
       */

        public static java.util.Iterator<org.semanticwb.applicate.ListEmail> listListEmails(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.applicate.ListEmail>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.applicate.ListEmail for all models
       * @return Iterator of org.semanticwb.applicate.ListEmail
       */

        public static java.util.Iterator<org.semanticwb.applicate.ListEmail> listListEmails()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.applicate.ListEmail>(it, true);
        }

        public static org.semanticwb.applicate.ListEmail createListEmail(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.applicate.ListEmail.ClassMgr.createListEmail(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.applicate.ListEmail
       * @param id Identifier for org.semanticwb.applicate.ListEmail
       * @param model Model of the org.semanticwb.applicate.ListEmail
       * @return A org.semanticwb.applicate.ListEmail
       */
        public static org.semanticwb.applicate.ListEmail getListEmail(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.applicate.ListEmail)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.applicate.ListEmail
       * @param id Identifier for org.semanticwb.applicate.ListEmail
       * @param model Model of the org.semanticwb.applicate.ListEmail
       * @return A org.semanticwb.applicate.ListEmail
       */
        public static org.semanticwb.applicate.ListEmail createListEmail(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.applicate.ListEmail)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.applicate.ListEmail
       * @param id Identifier for org.semanticwb.applicate.ListEmail
       * @param model Model of the org.semanticwb.applicate.ListEmail
       */
        public static void removeListEmail(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.applicate.ListEmail
       * @param id Identifier for org.semanticwb.applicate.ListEmail
       * @param model Model of the org.semanticwb.applicate.ListEmail
       * @return true if the org.semanticwb.applicate.ListEmail exists, false otherwise
       */

        public static boolean hasListEmail(String id, org.semanticwb.model.SWBModel model)
        {
            return (getListEmail(id, model)!=null);
        }
    }

    public static ListEmailBase.ClassMgr getListEmailClassMgr()
    {
        return new ListEmailBase.ClassMgr();
    }

   /**
   * Constructs a ListEmailBase with a SemanticObject
   * @param base The SemanticObject with the properties for the ListEmail
   */
    public ListEmailBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the Verificacion property
* @return boolean with the Verificacion
*/
    public boolean isVerificacion()
    {
        return getSemanticObject().getBooleanProperty(app_verificacion);
    }

/**
* Sets the Verificacion property
* @param value long with the Verificacion
*/
    public void setVerificacion(boolean value)
    {
        getSemanticObject().setBooleanProperty(app_verificacion, value);
    }

/**
* Gets the Email property
* @return String with the Email
*/
    public String getEmail()
    {
        return getSemanticObject().getProperty(app_email);
    }

/**
* Sets the Email property
* @param value long with the Email
*/
    public void setEmail(String value)
    {
        getSemanticObject().setProperty(app_email, value);
    }
}
