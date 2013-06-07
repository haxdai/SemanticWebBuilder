package org.semanticwb.model.survey.base;


public abstract class CostoAplicacionBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticProperty cts_P_Total_del_Portafolio_de_servicios_de_aplicaciones=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#P_Total_del_Portafolio_de_servicios_de_aplicaciones");
    public static final org.semanticwb.platform.SemanticClass cts_CostoAplicacionAnio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.survey/costs#CostoAplicacionAnio");
    public static final org.semanticwb.platform.SemanticProperty cts_hasCostoAplicacionAnio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#hasCostoAplicacionAnio");
    public static final org.semanticwb.platform.SemanticClass cts_Aplicacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.survey/costs#Aplicacion");
    public static final org.semanticwb.platform.SemanticProperty cts_aplicacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.survey/costs#aplicacion");
    public static final org.semanticwb.platform.SemanticClass cts_CostoAplicacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.survey/costs#CostoAplicacion");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.survey/costs#CostoAplicacion");

    public static class ClassMgr
    {
       /**
       * Returns a list of CostoAplicacion for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.model.survey.CostoAplicacion
       */

        public static java.util.Iterator<org.semanticwb.model.survey.CostoAplicacion> listCostoAplicacions(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.model.survey.CostoAplicacion>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.model.survey.CostoAplicacion for all models
       * @return Iterator of org.semanticwb.model.survey.CostoAplicacion
       */

        public static java.util.Iterator<org.semanticwb.model.survey.CostoAplicacion> listCostoAplicacions()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.model.survey.CostoAplicacion>(it, true);
        }

        public static org.semanticwb.model.survey.CostoAplicacion createCostoAplicacion(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.model.survey.CostoAplicacion.ClassMgr.createCostoAplicacion(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.model.survey.CostoAplicacion
       * @param id Identifier for org.semanticwb.model.survey.CostoAplicacion
       * @param model Model of the org.semanticwb.model.survey.CostoAplicacion
       * @return A org.semanticwb.model.survey.CostoAplicacion
       */
        public static org.semanticwb.model.survey.CostoAplicacion getCostoAplicacion(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.model.survey.CostoAplicacion)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.model.survey.CostoAplicacion
       * @param id Identifier for org.semanticwb.model.survey.CostoAplicacion
       * @param model Model of the org.semanticwb.model.survey.CostoAplicacion
       * @return A org.semanticwb.model.survey.CostoAplicacion
       */
        public static org.semanticwb.model.survey.CostoAplicacion createCostoAplicacion(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.model.survey.CostoAplicacion)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.model.survey.CostoAplicacion
       * @param id Identifier for org.semanticwb.model.survey.CostoAplicacion
       * @param model Model of the org.semanticwb.model.survey.CostoAplicacion
       */
        public static void removeCostoAplicacion(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.model.survey.CostoAplicacion
       * @param id Identifier for org.semanticwb.model.survey.CostoAplicacion
       * @param model Model of the org.semanticwb.model.survey.CostoAplicacion
       * @return true if the org.semanticwb.model.survey.CostoAplicacion exists, false otherwise
       */

        public static boolean hasCostoAplicacion(String id, org.semanticwb.model.SWBModel model)
        {
            return (getCostoAplicacion(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.model.survey.CostoAplicacion with a determined CostoAplicacionAnio
       * @param value CostoAplicacionAnio of the type org.semanticwb.model.survey.CostoAplicacionAnio
       * @param model Model of the org.semanticwb.model.survey.CostoAplicacion
       * @return Iterator with all the org.semanticwb.model.survey.CostoAplicacion
       */

        public static java.util.Iterator<org.semanticwb.model.survey.CostoAplicacion> listCostoAplicacionByCostoAplicacionAnio(org.semanticwb.model.survey.CostoAplicacionAnio value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.model.survey.CostoAplicacion> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cts_hasCostoAplicacionAnio, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.model.survey.CostoAplicacion with a determined CostoAplicacionAnio
       * @param value CostoAplicacionAnio of the type org.semanticwb.model.survey.CostoAplicacionAnio
       * @return Iterator with all the org.semanticwb.model.survey.CostoAplicacion
       */

        public static java.util.Iterator<org.semanticwb.model.survey.CostoAplicacion> listCostoAplicacionByCostoAplicacionAnio(org.semanticwb.model.survey.CostoAplicacionAnio value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.model.survey.CostoAplicacion> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cts_hasCostoAplicacionAnio,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.model.survey.CostoAplicacion with a determined Aplicacion
       * @param value Aplicacion of the type org.semanticwb.model.survey.Aplicacion
       * @param model Model of the org.semanticwb.model.survey.CostoAplicacion
       * @return Iterator with all the org.semanticwb.model.survey.CostoAplicacion
       */

        public static java.util.Iterator<org.semanticwb.model.survey.CostoAplicacion> listCostoAplicacionByAplicacion(org.semanticwb.model.survey.Aplicacion value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.model.survey.CostoAplicacion> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cts_aplicacion, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.model.survey.CostoAplicacion with a determined Aplicacion
       * @param value Aplicacion of the type org.semanticwb.model.survey.Aplicacion
       * @return Iterator with all the org.semanticwb.model.survey.CostoAplicacion
       */

        public static java.util.Iterator<org.semanticwb.model.survey.CostoAplicacion> listCostoAplicacionByAplicacion(org.semanticwb.model.survey.Aplicacion value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.model.survey.CostoAplicacion> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cts_aplicacion,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static CostoAplicacionBase.ClassMgr getCostoAplicacionClassMgr()
    {
        return new CostoAplicacionBase.ClassMgr();
    }

   /**
   * Constructs a CostoAplicacionBase with a SemanticObject
   * @param base The SemanticObject with the properties for the CostoAplicacion
   */
    public CostoAplicacionBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the P_Total_del_Portafolio_de_servicios_de_aplicaciones property
* @return int with the P_Total_del_Portafolio_de_servicios_de_aplicaciones
*/
    public int getP_Total_del_Portafolio_de_servicios_de_aplicaciones()
    {
        return getSemanticObject().getIntProperty(cts_P_Total_del_Portafolio_de_servicios_de_aplicaciones);
    }

/**
* Sets the P_Total_del_Portafolio_de_servicios_de_aplicaciones property
* @param value long with the P_Total_del_Portafolio_de_servicios_de_aplicaciones
*/
    public void setP_Total_del_Portafolio_de_servicios_de_aplicaciones(int value)
    {
        getSemanticObject().setIntProperty(cts_P_Total_del_Portafolio_de_servicios_de_aplicaciones, value);
    }
   /**
   * Gets all the org.semanticwb.model.survey.CostoAplicacionAnio
   * @return A GenericIterator with all the org.semanticwb.model.survey.CostoAplicacionAnio
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.model.survey.CostoAplicacionAnio> listCostoAplicacionAnios()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.survey.CostoAplicacionAnio>(getSemanticObject().listObjectProperties(cts_hasCostoAplicacionAnio));
    }

   /**
   * Gets true if has a CostoAplicacionAnio
   * @param value org.semanticwb.model.survey.CostoAplicacionAnio to verify
   * @return true if the org.semanticwb.model.survey.CostoAplicacionAnio exists, false otherwise
   */
    public boolean hasCostoAplicacionAnio(org.semanticwb.model.survey.CostoAplicacionAnio value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cts_hasCostoAplicacionAnio,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a CostoAplicacionAnio
   * @param value org.semanticwb.model.survey.CostoAplicacionAnio to add
   */

    public void addCostoAplicacionAnio(org.semanticwb.model.survey.CostoAplicacionAnio value)
    {
        getSemanticObject().addObjectProperty(cts_hasCostoAplicacionAnio, value.getSemanticObject());
    }
   /**
   * Removes all the CostoAplicacionAnio
   */

    public void removeAllCostoAplicacionAnio()
    {
        getSemanticObject().removeProperty(cts_hasCostoAplicacionAnio);
    }
   /**
   * Removes a CostoAplicacionAnio
   * @param value org.semanticwb.model.survey.CostoAplicacionAnio to remove
   */

    public void removeCostoAplicacionAnio(org.semanticwb.model.survey.CostoAplicacionAnio value)
    {
        getSemanticObject().removeObjectProperty(cts_hasCostoAplicacionAnio,value.getSemanticObject());
    }

   /**
   * Gets the CostoAplicacionAnio
   * @return a org.semanticwb.model.survey.CostoAplicacionAnio
   */
    public org.semanticwb.model.survey.CostoAplicacionAnio getCostoAplicacionAnio()
    {
         org.semanticwb.model.survey.CostoAplicacionAnio ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cts_hasCostoAplicacionAnio);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.survey.CostoAplicacionAnio)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property Aplicacion
   * @param value Aplicacion to set
   */

    public void setAplicacion(org.semanticwb.model.survey.Aplicacion value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(cts_aplicacion, value.getSemanticObject());
        }else
        {
            removeAplicacion();
        }
    }
   /**
   * Remove the value for Aplicacion property
   */

    public void removeAplicacion()
    {
        getSemanticObject().removeProperty(cts_aplicacion);
    }

   /**
   * Gets the Aplicacion
   * @return a org.semanticwb.model.survey.Aplicacion
   */
    public org.semanticwb.model.survey.Aplicacion getAplicacion()
    {
         org.semanticwb.model.survey.Aplicacion ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cts_aplicacion);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.survey.Aplicacion)obj.createGenericInstance();
         }
         return ret;
    }
}
