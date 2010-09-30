package org.semanticwb.pymtur.base;


   /**
   * Clase que se encarga de administrar Ligas de interes para los micrositios (premier-páginas web) 
   */
public abstract class InteresLinkBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable
{
   /**
   * Hipervinculo requerido
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_link=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#link");
   /**
   * Clase que se encarga de administrar Ligas de interes para los micrositios (premier-páginas web)
   */
    public static final org.semanticwb.platform.SemanticClass pymtur_InteresLink=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#InteresLink");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#InteresLink");

    public static class ClassMgr
    {
       /**
       * Returns a list of InteresLink for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.pymtur.InteresLink
       */

        public static java.util.Iterator<org.semanticwb.pymtur.InteresLink> listInteresLinks(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.InteresLink>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.pymtur.InteresLink for all models
       * @return Iterator of org.semanticwb.pymtur.InteresLink
       */

        public static java.util.Iterator<org.semanticwb.pymtur.InteresLink> listInteresLinks()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.InteresLink>(it, true);
        }

        public static org.semanticwb.pymtur.InteresLink createInteresLink(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.pymtur.InteresLink.ClassMgr.createInteresLink(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.pymtur.InteresLink
       * @param id Identifier for org.semanticwb.pymtur.InteresLink
       * @param model Model of the org.semanticwb.pymtur.InteresLink
       * @return A org.semanticwb.pymtur.InteresLink
       */
        public static org.semanticwb.pymtur.InteresLink getInteresLink(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.InteresLink)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.pymtur.InteresLink
       * @param id Identifier for org.semanticwb.pymtur.InteresLink
       * @param model Model of the org.semanticwb.pymtur.InteresLink
       * @return A org.semanticwb.pymtur.InteresLink
       */
        public static org.semanticwb.pymtur.InteresLink createInteresLink(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.InteresLink)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.pymtur.InteresLink
       * @param id Identifier for org.semanticwb.pymtur.InteresLink
       * @param model Model of the org.semanticwb.pymtur.InteresLink
       */
        public static void removeInteresLink(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.pymtur.InteresLink
       * @param id Identifier for org.semanticwb.pymtur.InteresLink
       * @param model Model of the org.semanticwb.pymtur.InteresLink
       * @return true if the org.semanticwb.pymtur.InteresLink exists, false otherwise
       */

        public static boolean hasInteresLink(String id, org.semanticwb.model.SWBModel model)
        {
            return (getInteresLink(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.pymtur.InteresLink with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.pymtur.InteresLink
       * @return Iterator with all the org.semanticwb.pymtur.InteresLink
       */

        public static java.util.Iterator<org.semanticwb.pymtur.InteresLink> listInteresLinkByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.InteresLink> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.InteresLink with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.pymtur.InteresLink
       */

        public static java.util.Iterator<org.semanticwb.pymtur.InteresLink> listInteresLinkByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.InteresLink> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.InteresLink with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.pymtur.InteresLink
       * @return Iterator with all the org.semanticwb.pymtur.InteresLink
       */

        public static java.util.Iterator<org.semanticwb.pymtur.InteresLink> listInteresLinkByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.InteresLink> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.InteresLink with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.pymtur.InteresLink
       */

        public static java.util.Iterator<org.semanticwb.pymtur.InteresLink> listInteresLinkByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.InteresLink> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a InteresLinkBase with a SemanticObject
   * @param base The SemanticObject with the properties for the InteresLink
   */
    public InteresLinkBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the Created property
* @return java.util.Date with the Created
*/
    public java.util.Date getCreated()
    {
        return getSemanticObject().getDateProperty(swb_created);
    }

/**
* Sets the Created property
* @param value long with the Created
*/
    public void setCreated(java.util.Date value)
    {
        getSemanticObject().setDateProperty(swb_created, value);
    }

/**
* Gets the Link property
* @return String with the Link
*/
    public String getLink()
    {
        return getSemanticObject().getProperty(pymtur_link);
    }

/**
* Sets the Link property
* @param value long with the Link
*/
    public void setLink(String value)
    {
        getSemanticObject().setProperty(pymtur_link, value);
    }
   /**
   * Sets the value for the property Creator
   * @param value Creator to set
   */

    public void setCreator(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(swb_creator, value.getSemanticObject());
        }else
        {
            removeCreator();
        }
    }
   /**
   * Remove the value for Creator property
   */

    public void removeCreator()
    {
        getSemanticObject().removeProperty(swb_creator);
    }

   /**
   * Gets the Creator
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getCreator()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_creator);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property ModifiedBy
   * @param value ModifiedBy to set
   */

    public void setModifiedBy(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(swb_modifiedBy, value.getSemanticObject());
        }else
        {
            removeModifiedBy();
        }
    }
   /**
   * Remove the value for ModifiedBy property
   */

    public void removeModifiedBy()
    {
        getSemanticObject().removeProperty(swb_modifiedBy);
    }

   /**
   * Gets the ModifiedBy
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getModifiedBy()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_modifiedBy);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the Title property
* @return String with the Title
*/
    public String getTitle()
    {
        return getSemanticObject().getProperty(swb_title);
    }

/**
* Sets the Title property
* @param value long with the Title
*/
    public void setTitle(String value)
    {
        getSemanticObject().setProperty(swb_title, value);
    }

    public String getTitle(String lang)
    {
        return getSemanticObject().getProperty(swb_title, null, lang);
    }

    public String getDisplayTitle(String lang)
    {
        return getSemanticObject().getLocaleProperty(swb_title, lang);
    }

    public void setTitle(String title, String lang)
    {
        getSemanticObject().setProperty(swb_title, title, lang);
    }

/**
* Gets the Updated property
* @return java.util.Date with the Updated
*/
    public java.util.Date getUpdated()
    {
        return getSemanticObject().getDateProperty(swb_updated);
    }

/**
* Sets the Updated property
* @param value long with the Updated
*/
    public void setUpdated(java.util.Date value)
    {
        getSemanticObject().setDateProperty(swb_updated, value);
    }

/**
* Gets the Description property
* @return String with the Description
*/
    public String getDescription()
    {
        return getSemanticObject().getProperty(swb_description);
    }

/**
* Sets the Description property
* @param value long with the Description
*/
    public void setDescription(String value)
    {
        getSemanticObject().setProperty(swb_description, value);
    }

    public String getDescription(String lang)
    {
        return getSemanticObject().getProperty(swb_description, null, lang);
    }

    public String getDisplayDescription(String lang)
    {
        return getSemanticObject().getLocaleProperty(swb_description, lang);
    }

    public void setDescription(String description, String lang)
    {
        getSemanticObject().setProperty(swb_description, description, lang);
    }

   /**
   * Gets the PyMesWebSite
   * @return a instance of org.semanticwb.pymtur.PyMesWebSite
   */
    public org.semanticwb.pymtur.PyMesWebSite getPyMesWebSite()
    {
        return (org.semanticwb.pymtur.PyMesWebSite)getSemanticObject().getModel().getModelObject().createGenericInstance();
    }
}
