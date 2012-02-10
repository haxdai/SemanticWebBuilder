package com.infotec.eworkplace.swb.base;


public abstract class DateBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticProperty intranet_date=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#date");
    public static final org.semanticwb.platform.SemanticClass intranet_Date=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Date");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Date");

    public static class ClassMgr
    {
       /**
       * Returns a list of Date for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.Date
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Date> listDates(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Date>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.Date for all models
       * @return Iterator of com.infotec.eworkplace.swb.Date
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Date> listDates()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Date>(it, true);
        }

        public static com.infotec.eworkplace.swb.Date createDate(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.eworkplace.swb.Date.ClassMgr.createDate(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.Date
       * @param id Identifier for com.infotec.eworkplace.swb.Date
       * @param model Model of the com.infotec.eworkplace.swb.Date
       * @return A com.infotec.eworkplace.swb.Date
       */
        public static com.infotec.eworkplace.swb.Date getDate(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Date)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.Date
       * @param id Identifier for com.infotec.eworkplace.swb.Date
       * @param model Model of the com.infotec.eworkplace.swb.Date
       * @return A com.infotec.eworkplace.swb.Date
       */
        public static com.infotec.eworkplace.swb.Date createDate(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Date)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.Date
       * @param id Identifier for com.infotec.eworkplace.swb.Date
       * @param model Model of the com.infotec.eworkplace.swb.Date
       */
        public static void removeDate(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.Date
       * @param id Identifier for com.infotec.eworkplace.swb.Date
       * @param model Model of the com.infotec.eworkplace.swb.Date
       * @return true if the com.infotec.eworkplace.swb.Date exists, false otherwise
       */

        public static boolean hasDate(String id, org.semanticwb.model.SWBModel model)
        {
            return (getDate(id, model)!=null);
        }
    }

   /**
   * Constructs a DateBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Date
   */
    public DateBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the Date property
* @return java.util.Date with the Date
*/
    public java.util.Date getDate()
    {
        return getSemanticObject().getDateProperty(intranet_date);
    }

/**
* Sets the Date property
* @param value long with the Date
*/
    public void setDate(java.util.Date value)
    {
        getSemanticObject().setDateProperty(intranet_date, value);
    }
}
