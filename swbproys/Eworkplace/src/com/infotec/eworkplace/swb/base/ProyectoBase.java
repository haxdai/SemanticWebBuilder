package com.infotec.eworkplace.swb.base;


public abstract class ProyectoBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticClass ewp_Cliente=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#Cliente");
    public static final org.semanticwb.platform.SemanticProperty ewp_cliente=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#cliente");
    public static final org.semanticwb.platform.SemanticClass ewp_Proyecto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#Proyecto");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#Proyecto");

    public static class ClassMgr
    {
       /**
       * Returns a list of Proyecto for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.Proyecto
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Proyecto> listProyectos(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Proyecto>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.Proyecto for all models
       * @return Iterator of com.infotec.eworkplace.swb.Proyecto
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Proyecto> listProyectos()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Proyecto>(it, true);
        }

        public static com.infotec.eworkplace.swb.Proyecto createProyecto(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.eworkplace.swb.Proyecto.ClassMgr.createProyecto(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.Proyecto
       * @param id Identifier for com.infotec.eworkplace.swb.Proyecto
       * @param model Model of the com.infotec.eworkplace.swb.Proyecto
       * @return A com.infotec.eworkplace.swb.Proyecto
       */
        public static com.infotec.eworkplace.swb.Proyecto getProyecto(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Proyecto)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.Proyecto
       * @param id Identifier for com.infotec.eworkplace.swb.Proyecto
       * @param model Model of the com.infotec.eworkplace.swb.Proyecto
       * @return A com.infotec.eworkplace.swb.Proyecto
       */
        public static com.infotec.eworkplace.swb.Proyecto createProyecto(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Proyecto)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.Proyecto
       * @param id Identifier for com.infotec.eworkplace.swb.Proyecto
       * @param model Model of the com.infotec.eworkplace.swb.Proyecto
       */
        public static void removeProyecto(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.Proyecto
       * @param id Identifier for com.infotec.eworkplace.swb.Proyecto
       * @param model Model of the com.infotec.eworkplace.swb.Proyecto
       * @return true if the com.infotec.eworkplace.swb.Proyecto exists, false otherwise
       */

        public static boolean hasProyecto(String id, org.semanticwb.model.SWBModel model)
        {
            return (getProyecto(id, model)!=null);
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Proyecto with a determined Cliente
       * @param value Cliente of the type com.infotec.eworkplace.swb.Cliente
       * @param model Model of the com.infotec.eworkplace.swb.Proyecto
       * @return Iterator with all the com.infotec.eworkplace.swb.Proyecto
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Proyecto> listProyectoByCliente(com.infotec.eworkplace.swb.Cliente value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Proyecto> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(ewp_cliente, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Proyecto with a determined Cliente
       * @param value Cliente of the type com.infotec.eworkplace.swb.Cliente
       * @return Iterator with all the com.infotec.eworkplace.swb.Proyecto
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Proyecto> listProyectoByCliente(com.infotec.eworkplace.swb.Cliente value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Proyecto> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(ewp_cliente,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a ProyectoBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Proyecto
   */
    public ProyectoBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
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
   /**
   * Sets the value for the property Cliente
   * @param value Cliente to set
   */

    public void setCliente(com.infotec.eworkplace.swb.Cliente value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(ewp_cliente, value.getSemanticObject());
        }else
        {
            removeCliente();
        }
    }
   /**
   * Remove the value for Cliente property
   */

    public void removeCliente()
    {
        getSemanticObject().removeProperty(ewp_cliente);
    }

   /**
   * Gets the Cliente
   * @return a com.infotec.eworkplace.swb.Cliente
   */
    public com.infotec.eworkplace.swb.Cliente getCliente()
    {
         com.infotec.eworkplace.swb.Cliente ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(ewp_cliente);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.Cliente)obj.createGenericInstance();
         }
         return ret;
    }
}
