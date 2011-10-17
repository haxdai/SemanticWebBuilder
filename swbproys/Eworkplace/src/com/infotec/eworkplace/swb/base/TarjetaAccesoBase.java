package com.infotec.eworkplace.swb.base;


public abstract class TarjetaAccesoBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticProperty ewp_hasta=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#hasta");
    public static final org.semanticwb.platform.SemanticProperty ewp_nta=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#nta");
    public static final org.semanticwb.platform.SemanticProperty ewp_desde=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#desde");
    public static final org.semanticwb.platform.SemanticClass ewp_TarjetaAcceso=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#TarjetaAcceso");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#TarjetaAcceso");

    public static class ClassMgr
    {
       /**
       * Returns a list of TarjetaAcceso for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.TarjetaAcceso
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.TarjetaAcceso> listTarjetaAccesos(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.TarjetaAcceso>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.TarjetaAcceso for all models
       * @return Iterator of com.infotec.eworkplace.swb.TarjetaAcceso
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.TarjetaAcceso> listTarjetaAccesos()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.TarjetaAcceso>(it, true);
        }

        public static com.infotec.eworkplace.swb.TarjetaAcceso createTarjetaAcceso(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.eworkplace.swb.TarjetaAcceso.ClassMgr.createTarjetaAcceso(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.TarjetaAcceso
       * @param id Identifier for com.infotec.eworkplace.swb.TarjetaAcceso
       * @param model Model of the com.infotec.eworkplace.swb.TarjetaAcceso
       * @return A com.infotec.eworkplace.swb.TarjetaAcceso
       */
        public static com.infotec.eworkplace.swb.TarjetaAcceso getTarjetaAcceso(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.TarjetaAcceso)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.TarjetaAcceso
       * @param id Identifier for com.infotec.eworkplace.swb.TarjetaAcceso
       * @param model Model of the com.infotec.eworkplace.swb.TarjetaAcceso
       * @return A com.infotec.eworkplace.swb.TarjetaAcceso
       */
        public static com.infotec.eworkplace.swb.TarjetaAcceso createTarjetaAcceso(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.TarjetaAcceso)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.TarjetaAcceso
       * @param id Identifier for com.infotec.eworkplace.swb.TarjetaAcceso
       * @param model Model of the com.infotec.eworkplace.swb.TarjetaAcceso
       */
        public static void removeTarjetaAcceso(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.TarjetaAcceso
       * @param id Identifier for com.infotec.eworkplace.swb.TarjetaAcceso
       * @param model Model of the com.infotec.eworkplace.swb.TarjetaAcceso
       * @return true if the com.infotec.eworkplace.swb.TarjetaAcceso exists, false otherwise
       */

        public static boolean hasTarjetaAcceso(String id, org.semanticwb.model.SWBModel model)
        {
            return (getTarjetaAcceso(id, model)!=null);
        }
    }

   /**
   * Constructs a TarjetaAccesoBase with a SemanticObject
   * @param base The SemanticObject with the properties for the TarjetaAcceso
   */
    public TarjetaAccesoBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public java.util.Iterator<java.util.Date> listtas()
    {
        java.util.ArrayList<java.util.Date> values=new java.util.ArrayList<java.util.Date>();
//        java.util.Iterator<org.semanticwb.platform.SemanticLiteral> it=getSemanticObject().listLiteralProperties(ewp_hasta);
//        while(it.hasNext())
//        {
//                org.semanticwb.platform.SemanticLiteral literal=it.next();
//                values.add(literal.getString());
//        }
        return values.iterator();
    }

    public void addta(java.util.Date value)
    {
        getSemanticObject().addLiteralProperty(ewp_hasta, new org.semanticwb.platform.SemanticLiteral(value));
    }

    public void removeAllta()
    {
        getSemanticObject().removeProperty(ewp_hasta);
    }

    public void removeta(java.util.Date value)
    {
        getSemanticObject().removeLiteralProperty(ewp_hasta,new org.semanticwb.platform.SemanticLiteral(value));
    }

/**
* Gets the Nta property
* @return String with the Nta
*/
    public String getNta()
    {
        return getSemanticObject().getProperty(ewp_nta);
    }

/**
* Sets the Nta property
* @param value long with the Nta
*/
    public void setNta(String value)
    {
        getSemanticObject().setProperty(ewp_nta, value);
    }

/**
* Gets the Desde property
* @return java.util.Date with the Desde
*/
    public java.util.Date getDesde()
    {
        return getSemanticObject().getDateProperty(ewp_desde);
    }

/**
* Sets the Desde property
* @param value long with the Desde
*/
    public void setDesde(java.util.Date value)
    {
        getSemanticObject().setDateProperty(ewp_desde, value);
    }
}
