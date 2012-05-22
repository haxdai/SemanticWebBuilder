package com.infotec.rh.syr.swb.base;


public abstract class SeleccionBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticProperty intranet_vigenciaContrato=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#vigenciaContrato");
   /**
   * Un usuario es una persona que tiene relación con el portal a través de un método de acceso.
   */
    public static final org.semanticwb.platform.SemanticClass swb_User=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#User");
   /**
   * Persona seleccionada en un proceso de reclutamiento y selección
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_seleccionado=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#seleccionado");
    public static final org.semanticwb.platform.SemanticProperty intranet_salario=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#salario");
    public static final org.semanticwb.platform.SemanticProperty intranet_fechaDeIngreso=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#fechaDeIngreso");
    public static final org.semanticwb.platform.SemanticClass intranet_Seleccion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Seleccion");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Seleccion");

    public static class ClassMgr
    {
       /**
       * Returns a list of Seleccion for a model
       * @param model Model to find
       * @return Iterator of com.infotec.rh.syr.swb.Seleccion
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.Seleccion> listSeleccions(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.Seleccion>(it, true);
        }
       /**
       * Returns a list of com.infotec.rh.syr.swb.Seleccion for all models
       * @return Iterator of com.infotec.rh.syr.swb.Seleccion
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.Seleccion> listSeleccions()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.Seleccion>(it, true);
        }

        public static com.infotec.rh.syr.swb.Seleccion createSeleccion(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.rh.syr.swb.Seleccion.ClassMgr.createSeleccion(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.rh.syr.swb.Seleccion
       * @param id Identifier for com.infotec.rh.syr.swb.Seleccion
       * @param model Model of the com.infotec.rh.syr.swb.Seleccion
       * @return A com.infotec.rh.syr.swb.Seleccion
       */
        public static com.infotec.rh.syr.swb.Seleccion getSeleccion(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.rh.syr.swb.Seleccion)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.rh.syr.swb.Seleccion
       * @param id Identifier for com.infotec.rh.syr.swb.Seleccion
       * @param model Model of the com.infotec.rh.syr.swb.Seleccion
       * @return A com.infotec.rh.syr.swb.Seleccion
       */
        public static com.infotec.rh.syr.swb.Seleccion createSeleccion(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.rh.syr.swb.Seleccion)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.rh.syr.swb.Seleccion
       * @param id Identifier for com.infotec.rh.syr.swb.Seleccion
       * @param model Model of the com.infotec.rh.syr.swb.Seleccion
       */
        public static void removeSeleccion(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.rh.syr.swb.Seleccion
       * @param id Identifier for com.infotec.rh.syr.swb.Seleccion
       * @param model Model of the com.infotec.rh.syr.swb.Seleccion
       * @return true if the com.infotec.rh.syr.swb.Seleccion exists, false otherwise
       */

        public static boolean hasSeleccion(String id, org.semanticwb.model.SWBModel model)
        {
            return (getSeleccion(id, model)!=null);
        }
       /**
       * Gets all com.infotec.rh.syr.swb.Seleccion with a determined Seleccionado
       * @param value Seleccionado of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.rh.syr.swb.Seleccion
       * @return Iterator with all the com.infotec.rh.syr.swb.Seleccion
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.Seleccion> listSeleccionBySeleccionado(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.Seleccion> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_seleccionado, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.Seleccion with a determined Seleccionado
       * @param value Seleccionado of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.rh.syr.swb.Seleccion
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.Seleccion> listSeleccionBySeleccionado(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.Seleccion> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_seleccionado,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a SeleccionBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Seleccion
   */
    public SeleccionBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the VigenciaContrato property
* @return java.util.Date with the VigenciaContrato
*/
    public java.util.Date getVigenciaContrato()
    {
        return getSemanticObject().getDateProperty(intranet_vigenciaContrato);
    }

/**
* Sets the VigenciaContrato property
* @param value long with the VigenciaContrato
*/
    public void setVigenciaContrato(java.util.Date value)
    {
        getSemanticObject().setDateProperty(intranet_vigenciaContrato, value);
    }
   /**
   * Sets the value for the property Seleccionado
   * @param value Seleccionado to set
   */

    public void setSeleccionado(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_seleccionado, value.getSemanticObject());
        }else
        {
            removeSeleccionado();
        }
    }
   /**
   * Remove the value for Seleccionado property
   */

    public void removeSeleccionado()
    {
        getSemanticObject().removeProperty(intranet_seleccionado);
    }

   /**
   * Gets the Seleccionado
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getSeleccionado()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_seleccionado);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the Salario property
* @return int with the Salario
*/
    public int getSalario()
    {
        return getSemanticObject().getIntProperty(intranet_salario);
    }

/**
* Sets the Salario property
* @param value long with the Salario
*/
    public void setSalario(int value)
    {
        getSemanticObject().setIntProperty(intranet_salario, value);
    }

/**
* Gets the FechaDeIngreso property
* @return java.util.Date with the FechaDeIngreso
*/
    public java.util.Date getFechaDeIngreso()
    {
        return getSemanticObject().getDateProperty(intranet_fechaDeIngreso);
    }

/**
* Sets the FechaDeIngreso property
* @param value long with the FechaDeIngreso
*/
    public void setFechaDeIngreso(java.util.Date value)
    {
        getSemanticObject().setDateProperty(intranet_fechaDeIngreso, value);
    }
}
