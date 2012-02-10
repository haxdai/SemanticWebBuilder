package com.infotec.cvi.swb.base;


public abstract class AreasTalentoBase extends com.infotec.cvi.swb.ExperienciaProfesional implements org.semanticwb.model.Traceable
{
    public static final org.semanticwb.platform.SemanticProperty intranet_areaTalento=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#areaTalento");
    public static final org.semanticwb.platform.SemanticProperty intranet_areaDestrezaTI=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#areaDestrezaTI");
    public static final org.semanticwb.platform.SemanticProperty intranet_yearExperienceTalento=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#yearExperienceTalento");
    public static final org.semanticwb.platform.SemanticProperty intranet_yearExpirienceTI=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#yearExpirienceTI");
    public static final org.semanticwb.platform.SemanticClass intranet_AreasTalento=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#AreasTalento");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#AreasTalento");

    public static class ClassMgr
    {
       /**
       * Returns a list of AreasTalento for a model
       * @param model Model to find
       * @return Iterator of com.infotec.cvi.swb.AreasTalento
       */

        public static java.util.Iterator<com.infotec.cvi.swb.AreasTalento> listAreasTalentos(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.AreasTalento>(it, true);
        }
       /**
       * Returns a list of com.infotec.cvi.swb.AreasTalento for all models
       * @return Iterator of com.infotec.cvi.swb.AreasTalento
       */

        public static java.util.Iterator<com.infotec.cvi.swb.AreasTalento> listAreasTalentos()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.AreasTalento>(it, true);
        }

        public static com.infotec.cvi.swb.AreasTalento createAreasTalento(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.cvi.swb.AreasTalento.ClassMgr.createAreasTalento(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.cvi.swb.AreasTalento
       * @param id Identifier for com.infotec.cvi.swb.AreasTalento
       * @param model Model of the com.infotec.cvi.swb.AreasTalento
       * @return A com.infotec.cvi.swb.AreasTalento
       */
        public static com.infotec.cvi.swb.AreasTalento getAreasTalento(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.AreasTalento)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.cvi.swb.AreasTalento
       * @param id Identifier for com.infotec.cvi.swb.AreasTalento
       * @param model Model of the com.infotec.cvi.swb.AreasTalento
       * @return A com.infotec.cvi.swb.AreasTalento
       */
        public static com.infotec.cvi.swb.AreasTalento createAreasTalento(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.AreasTalento)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.cvi.swb.AreasTalento
       * @param id Identifier for com.infotec.cvi.swb.AreasTalento
       * @param model Model of the com.infotec.cvi.swb.AreasTalento
       */
        public static void removeAreasTalento(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.cvi.swb.AreasTalento
       * @param id Identifier for com.infotec.cvi.swb.AreasTalento
       * @param model Model of the com.infotec.cvi.swb.AreasTalento
       * @return true if the com.infotec.cvi.swb.AreasTalento exists, false otherwise
       */

        public static boolean hasAreasTalento(String id, org.semanticwb.model.SWBModel model)
        {
            return (getAreasTalento(id, model)!=null);
        }
       /**
       * Gets all com.infotec.cvi.swb.AreasTalento with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.AreasTalento
       * @return Iterator with all the com.infotec.cvi.swb.AreasTalento
       */

        public static java.util.Iterator<com.infotec.cvi.swb.AreasTalento> listAreasTalentoByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.AreasTalento> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.AreasTalento with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.AreasTalento
       */

        public static java.util.Iterator<com.infotec.cvi.swb.AreasTalento> listAreasTalentoByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.AreasTalento> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.AreasTalento with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.AreasTalento
       * @return Iterator with all the com.infotec.cvi.swb.AreasTalento
       */

        public static java.util.Iterator<com.infotec.cvi.swb.AreasTalento> listAreasTalentoByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.AreasTalento> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.AreasTalento with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.AreasTalento
       */

        public static java.util.Iterator<com.infotec.cvi.swb.AreasTalento> listAreasTalentoByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.AreasTalento> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a AreasTalentoBase with a SemanticObject
   * @param base The SemanticObject with the properties for the AreasTalento
   */
    public AreasTalentoBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
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
