package org.semanticwb.ecosikan.innova.base;


public abstract class GobiernoDelEstadoBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticClass ecoskn_Secretaria=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://ecosikan.infotec.com.mx#Secretaria");
    public static final org.semanticwb.platform.SemanticProperty ecoskn_hasSecretarias=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://ecosikan.infotec.com.mx#hasSecretarias");
    public static final org.semanticwb.platform.SemanticClass ecoskn_GobiernoDelEstado=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://ecosikan.infotec.com.mx#GobiernoDelEstado");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://ecosikan.infotec.com.mx#GobiernoDelEstado");

    public static class ClassMgr
    {
       /**
       * Returns a list of GobiernoDelEstado for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.ecosikan.innova.GobiernoDelEstado
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.GobiernoDelEstado> listGobiernoDelEstados(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.GobiernoDelEstado>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.ecosikan.innova.GobiernoDelEstado for all models
       * @return Iterator of org.semanticwb.ecosikan.innova.GobiernoDelEstado
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.GobiernoDelEstado> listGobiernoDelEstados()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.GobiernoDelEstado>(it, true);
        }
       /**
       * Gets a org.semanticwb.ecosikan.innova.GobiernoDelEstado
       * @param id Identifier for org.semanticwb.ecosikan.innova.GobiernoDelEstado
       * @param model Model of the org.semanticwb.ecosikan.innova.GobiernoDelEstado
       * @return A org.semanticwb.ecosikan.innova.GobiernoDelEstado
       */
        public static org.semanticwb.ecosikan.innova.GobiernoDelEstado getGobiernoDelEstado(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.ecosikan.innova.GobiernoDelEstado)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.ecosikan.innova.GobiernoDelEstado
       * @param id Identifier for org.semanticwb.ecosikan.innova.GobiernoDelEstado
       * @param model Model of the org.semanticwb.ecosikan.innova.GobiernoDelEstado
       * @return A org.semanticwb.ecosikan.innova.GobiernoDelEstado
       */
        public static org.semanticwb.ecosikan.innova.GobiernoDelEstado createGobiernoDelEstado(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.ecosikan.innova.GobiernoDelEstado)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.ecosikan.innova.GobiernoDelEstado
       * @param id Identifier for org.semanticwb.ecosikan.innova.GobiernoDelEstado
       * @param model Model of the org.semanticwb.ecosikan.innova.GobiernoDelEstado
       */
        public static void removeGobiernoDelEstado(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.ecosikan.innova.GobiernoDelEstado
       * @param id Identifier for org.semanticwb.ecosikan.innova.GobiernoDelEstado
       * @param model Model of the org.semanticwb.ecosikan.innova.GobiernoDelEstado
       * @return true if the org.semanticwb.ecosikan.innova.GobiernoDelEstado exists, false otherwise
       */

        public static boolean hasGobiernoDelEstado(String id, org.semanticwb.model.SWBModel model)
        {
            return (getGobiernoDelEstado(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.GobiernoDelEstado with a determined Secretarias
       * @param value Secretarias of the type org.semanticwb.ecosikan.innova.Secretaria
       * @param model Model of the org.semanticwb.ecosikan.innova.GobiernoDelEstado
       * @return Iterator with all the org.semanticwb.ecosikan.innova.GobiernoDelEstado
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.GobiernoDelEstado> listGobiernoDelEstadoBySecretarias(org.semanticwb.ecosikan.innova.Secretaria value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.GobiernoDelEstado> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(ecoskn_hasSecretarias, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.GobiernoDelEstado with a determined Secretarias
       * @param value Secretarias of the type org.semanticwb.ecosikan.innova.Secretaria
       * @return Iterator with all the org.semanticwb.ecosikan.innova.GobiernoDelEstado
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.GobiernoDelEstado> listGobiernoDelEstadoBySecretarias(org.semanticwb.ecosikan.innova.Secretaria value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.GobiernoDelEstado> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(ecoskn_hasSecretarias,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a GobiernoDelEstadoBase with a SemanticObject
   * @param base The SemanticObject with the properties for the GobiernoDelEstado
   */
    public GobiernoDelEstadoBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Gets all the org.semanticwb.ecosikan.innova.Secretaria
   * @return A GenericIterator with all the org.semanticwb.ecosikan.innova.Secretaria
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Secretaria> listSecretariases()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Secretaria>(getSemanticObject().listObjectProperties(ecoskn_hasSecretarias));
    }

   /**
   * Gets true if has a Secretarias
   * @param value org.semanticwb.ecosikan.innova.Secretaria to verify
   * @return true if the org.semanticwb.ecosikan.innova.Secretaria exists, false otherwise
   */
    public boolean hasSecretarias(org.semanticwb.ecosikan.innova.Secretaria value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(ecoskn_hasSecretarias,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Secretarias
   * @param value org.semanticwb.ecosikan.innova.Secretaria to add
   */

    public void addSecretarias(org.semanticwb.ecosikan.innova.Secretaria value)
    {
        getSemanticObject().addObjectProperty(ecoskn_hasSecretarias, value.getSemanticObject());
    }
   /**
   * Removes all the Secretarias
   */

    public void removeAllSecretarias()
    {
        getSemanticObject().removeProperty(ecoskn_hasSecretarias);
    }
   /**
   * Removes a Secretarias
   * @param value org.semanticwb.ecosikan.innova.Secretaria to remove
   */

    public void removeSecretarias(org.semanticwb.ecosikan.innova.Secretaria value)
    {
        getSemanticObject().removeObjectProperty(ecoskn_hasSecretarias,value.getSemanticObject());
    }

   /**
   * Gets the Secretarias
   * @return a org.semanticwb.ecosikan.innova.Secretaria
   */
    public org.semanticwb.ecosikan.innova.Secretaria getSecretarias()
    {
         org.semanticwb.ecosikan.innova.Secretaria ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(ecoskn_hasSecretarias);
         if(obj!=null)
         {
             ret=(org.semanticwb.ecosikan.innova.Secretaria)obj.createGenericInstance();
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
}
