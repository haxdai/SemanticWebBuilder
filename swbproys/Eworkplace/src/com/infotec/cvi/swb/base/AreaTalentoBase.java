package com.infotec.cvi.swb.base;


public abstract class AreaTalentoBase extends com.infotec.cvi.swb.ExperienciaProfesional implements org.semanticwb.model.Traceable
{
    public static final org.semanticwb.platform.SemanticProperty intranet_areaDestrezaTI=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#areaDestrezaTI");
    public static final org.semanticwb.platform.SemanticProperty intranet_areaTalento=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#areaTalento");
    public static final org.semanticwb.platform.SemanticProperty intranet_yearExperienceTalento=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#yearExperienceTalento");
    public static final org.semanticwb.platform.SemanticProperty intranet_yearExpirienceTI=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#yearExpirienceTI");
    public static final org.semanticwb.platform.SemanticClass intranet_AreaTalento=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#AreaTalento");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#AreaTalento");

    public static class ClassMgr
    {
       /**
       * Returns a list of AreaTalento for a model
       * @param model Model to find
       * @return Iterator of com.infotec.cvi.swb.AreaTalento
       */

        public static java.util.Iterator<com.infotec.cvi.swb.AreaTalento> listAreaTalentos(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.AreaTalento>(it, true);
        }
       /**
       * Returns a list of com.infotec.cvi.swb.AreaTalento for all models
       * @return Iterator of com.infotec.cvi.swb.AreaTalento
       */

        public static java.util.Iterator<com.infotec.cvi.swb.AreaTalento> listAreaTalentos()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.AreaTalento>(it, true);
        }

        public static com.infotec.cvi.swb.AreaTalento createAreaTalento(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.cvi.swb.AreaTalento.ClassMgr.createAreaTalento(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.cvi.swb.AreaTalento
       * @param id Identifier for com.infotec.cvi.swb.AreaTalento
       * @param model Model of the com.infotec.cvi.swb.AreaTalento
       * @return A com.infotec.cvi.swb.AreaTalento
       */
        public static com.infotec.cvi.swb.AreaTalento getAreaTalento(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.AreaTalento)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.cvi.swb.AreaTalento
       * @param id Identifier for com.infotec.cvi.swb.AreaTalento
       * @param model Model of the com.infotec.cvi.swb.AreaTalento
       * @return A com.infotec.cvi.swb.AreaTalento
       */
        public static com.infotec.cvi.swb.AreaTalento createAreaTalento(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.AreaTalento)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.cvi.swb.AreaTalento
       * @param id Identifier for com.infotec.cvi.swb.AreaTalento
       * @param model Model of the com.infotec.cvi.swb.AreaTalento
       */
        public static void removeAreaTalento(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.cvi.swb.AreaTalento
       * @param id Identifier for com.infotec.cvi.swb.AreaTalento
       * @param model Model of the com.infotec.cvi.swb.AreaTalento
       * @return true if the com.infotec.cvi.swb.AreaTalento exists, false otherwise
       */

        public static boolean hasAreaTalento(String id, org.semanticwb.model.SWBModel model)
        {
            return (getAreaTalento(id, model)!=null);
        }
       /**
       * Gets all com.infotec.cvi.swb.AreaTalento with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.AreaTalento
       * @return Iterator with all the com.infotec.cvi.swb.AreaTalento
       */

        public static java.util.Iterator<com.infotec.cvi.swb.AreaTalento> listAreaTalentoByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.AreaTalento> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.AreaTalento with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.AreaTalento
       */

        public static java.util.Iterator<com.infotec.cvi.swb.AreaTalento> listAreaTalentoByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.AreaTalento> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.AreaTalento with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.AreaTalento
       * @return Iterator with all the com.infotec.cvi.swb.AreaTalento
       */

        public static java.util.Iterator<com.infotec.cvi.swb.AreaTalento> listAreaTalentoByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.AreaTalento> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.AreaTalento with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.AreaTalento
       */

        public static java.util.Iterator<com.infotec.cvi.swb.AreaTalento> listAreaTalentoByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.AreaTalento> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a AreaTalentoBase with a SemanticObject
   * @param base The SemanticObject with the properties for the AreaTalento
   */
    public AreaTalentoBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the AreaDestrezaTI property
* @return String with the AreaDestrezaTI
*/
    public String getAreaDestrezaTI()
    {
        return getSemanticObject().getProperty(intranet_areaDestrezaTI);
    }

/**
* Sets the AreaDestrezaTI property
* @param value long with the AreaDestrezaTI
*/
    public void setAreaDestrezaTI(String value)
    {
        getSemanticObject().setProperty(intranet_areaDestrezaTI, value);
    }

/**
* Gets the AreaTalento property
* @return String with the AreaTalento
*/
    public String getAreaTalento()
    {
        return getSemanticObject().getProperty(intranet_areaTalento);
    }

/**
* Sets the AreaTalento property
* @param value long with the AreaTalento
*/
    public void setAreaTalento(String value)
    {
        getSemanticObject().setProperty(intranet_areaTalento, value);
    }

/**
* Gets the YearExperienceTalento property
* @return int with the YearExperienceTalento
*/
    public int getYearExperienceTalento()
    {
        return getSemanticObject().getIntProperty(intranet_yearExperienceTalento);
    }

/**
* Sets the YearExperienceTalento property
* @param value long with the YearExperienceTalento
*/
    public void setYearExperienceTalento(int value)
    {
        getSemanticObject().setIntProperty(intranet_yearExperienceTalento, value);
    }

/**
* Gets the YearExpirienceTI property
* @return int with the YearExpirienceTI
*/
    public int getYearExpirienceTI()
    {
        return getSemanticObject().getIntProperty(intranet_yearExpirienceTI);
    }

/**
* Sets the YearExpirienceTI property
* @param value long with the YearExpirienceTI
*/
    public void setYearExpirienceTI(int value)
    {
        getSemanticObject().setIntProperty(intranet_yearExpirienceTI, value);
    }
}
