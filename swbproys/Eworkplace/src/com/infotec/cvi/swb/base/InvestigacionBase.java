package com.infotec.cvi.swb.base;


public abstract class InvestigacionBase extends com.infotec.cvi.swb.InvestigacionDocencia 
{
    public static final org.semanticwb.platform.SemanticProperty intranet_fechaTermino=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#fechaTermino");
    public static final org.semanticwb.platform.SemanticProperty intranet_sniConacyt=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#sniConacyt");
    public static final org.semanticwb.platform.SemanticProperty intranet_nombreJefePuesto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#nombreJefePuesto");
    public static final org.semanticwb.platform.SemanticProperty intranet_nombreEmpresa=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#nombreEmpresa");
    public static final org.semanticwb.platform.SemanticProperty intranet_nombrePuesto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#nombrePuesto");
    public static final org.semanticwb.platform.SemanticProperty intranet_numTelefono=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#numTelefono");
    public static final org.semanticwb.platform.SemanticProperty intranet_areaInvestigacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#areaInvestigacion");
    public static final org.semanticwb.platform.SemanticClass intranet_Investigacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Investigacion");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Investigacion");

    public static class ClassMgr
    {
       /**
       * Returns a list of Investigacion for a model
       * @param model Model to find
       * @return Iterator of com.infotec.cvi.swb.Investigacion
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Investigacion> listInvestigacions(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Investigacion>(it, true);
        }
       /**
       * Returns a list of com.infotec.cvi.swb.Investigacion for all models
       * @return Iterator of com.infotec.cvi.swb.Investigacion
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Investigacion> listInvestigacions()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Investigacion>(it, true);
        }

        public static com.infotec.cvi.swb.Investigacion createInvestigacion(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.cvi.swb.Investigacion.ClassMgr.createInvestigacion(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.cvi.swb.Investigacion
       * @param id Identifier for com.infotec.cvi.swb.Investigacion
       * @param model Model of the com.infotec.cvi.swb.Investigacion
       * @return A com.infotec.cvi.swb.Investigacion
       */
        public static com.infotec.cvi.swb.Investigacion getInvestigacion(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.Investigacion)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.cvi.swb.Investigacion
       * @param id Identifier for com.infotec.cvi.swb.Investigacion
       * @param model Model of the com.infotec.cvi.swb.Investigacion
       * @return A com.infotec.cvi.swb.Investigacion
       */
        public static com.infotec.cvi.swb.Investigacion createInvestigacion(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.Investigacion)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.cvi.swb.Investigacion
       * @param id Identifier for com.infotec.cvi.swb.Investigacion
       * @param model Model of the com.infotec.cvi.swb.Investigacion
       */
        public static void removeInvestigacion(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.cvi.swb.Investigacion
       * @param id Identifier for com.infotec.cvi.swb.Investigacion
       * @param model Model of the com.infotec.cvi.swb.Investigacion
       * @return true if the com.infotec.cvi.swb.Investigacion exists, false otherwise
       */

        public static boolean hasInvestigacion(String id, org.semanticwb.model.SWBModel model)
        {
            return (getInvestigacion(id, model)!=null);
        }
    }

   /**
   * Constructs a InvestigacionBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Investigacion
   */
    public InvestigacionBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the FechaTermino property
* @return int with the FechaTermino
*/
    public int getFechaTermino()
    {
        return getSemanticObject().getIntProperty(intranet_fechaTermino);
    }

/**
* Sets the FechaTermino property
* @param value long with the FechaTermino
*/
    public void setFechaTermino(int value)
    {
        getSemanticObject().setIntProperty(intranet_fechaTermino, value);
    }

/**
* Gets the SniConacyt property
* @return String with the SniConacyt
*/
    public String getSniConacyt()
    {
        return getSemanticObject().getProperty(intranet_sniConacyt);
    }

/**
* Sets the SniConacyt property
* @param value long with the SniConacyt
*/
    public void setSniConacyt(String value)
    {
        getSemanticObject().setProperty(intranet_sniConacyt, value);
    }

/**
* Gets the NombreJefePuesto property
* @return String with the NombreJefePuesto
*/
    public String getNombreJefePuesto()
    {
        return getSemanticObject().getProperty(intranet_nombreJefePuesto);
    }

/**
* Sets the NombreJefePuesto property
* @param value long with the NombreJefePuesto
*/
    public void setNombreJefePuesto(String value)
    {
        getSemanticObject().setProperty(intranet_nombreJefePuesto, value);
    }

/**
* Gets the NombreEmpresa property
* @return String with the NombreEmpresa
*/
    public String getNombreEmpresa()
    {
        return getSemanticObject().getProperty(intranet_nombreEmpresa);
    }

/**
* Sets the NombreEmpresa property
* @param value long with the NombreEmpresa
*/
    public void setNombreEmpresa(String value)
    {
        getSemanticObject().setProperty(intranet_nombreEmpresa, value);
    }

/**
* Gets the NombrePuesto property
* @return String with the NombrePuesto
*/
    public String getNombrePuesto()
    {
        return getSemanticObject().getProperty(intranet_nombrePuesto);
    }

/**
* Sets the NombrePuesto property
* @param value long with the NombrePuesto
*/
    public void setNombrePuesto(String value)
    {
        getSemanticObject().setProperty(intranet_nombrePuesto, value);
    }

/**
* Gets the NumTelefono property
* @return int with the NumTelefono
*/
    public int getNumTelefono()
    {
        return getSemanticObject().getIntProperty(intranet_numTelefono);
    }

/**
* Sets the NumTelefono property
* @param value long with the NumTelefono
*/
    public void setNumTelefono(int value)
    {
        getSemanticObject().setIntProperty(intranet_numTelefono, value);
    }

/**
* Gets the AreaInvestigacion property
* @return String with the AreaInvestigacion
*/
    public String getAreaInvestigacion()
    {
        return getSemanticObject().getProperty(intranet_areaInvestigacion);
    }

/**
* Sets the AreaInvestigacion property
* @param value long with the AreaInvestigacion
*/
    public void setAreaInvestigacion(String value)
    {
        getSemanticObject().setProperty(intranet_areaInvestigacion, value);
    }
}
