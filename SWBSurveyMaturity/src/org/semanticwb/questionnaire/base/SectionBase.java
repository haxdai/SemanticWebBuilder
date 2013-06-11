package org.semanticwb.questionnaire.base;


public abstract class SectionBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticClass que_Section=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://org.semanticwb.resources/Questionnaire#Section");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://org.semanticwb.resources/Questionnaire#Section");

    public static class ClassMgr
    {
       /**
       * Returns a list of Section for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.questionnaire.Section
       */

        public static java.util.Iterator<org.semanticwb.questionnaire.Section> listSections(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.Section>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.questionnaire.Section for all models
       * @return Iterator of org.semanticwb.questionnaire.Section
       */

        public static java.util.Iterator<org.semanticwb.questionnaire.Section> listSections()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.Section>(it, true);
        }

        public static org.semanticwb.questionnaire.Section createSection(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.questionnaire.Section.ClassMgr.createSection(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.questionnaire.Section
       * @param id Identifier for org.semanticwb.questionnaire.Section
       * @param model Model of the org.semanticwb.questionnaire.Section
       * @return A org.semanticwb.questionnaire.Section
       */
        public static org.semanticwb.questionnaire.Section getSection(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.questionnaire.Section)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.questionnaire.Section
       * @param id Identifier for org.semanticwb.questionnaire.Section
       * @param model Model of the org.semanticwb.questionnaire.Section
       * @return A org.semanticwb.questionnaire.Section
       */
        public static org.semanticwb.questionnaire.Section createSection(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.questionnaire.Section)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.questionnaire.Section
       * @param id Identifier for org.semanticwb.questionnaire.Section
       * @param model Model of the org.semanticwb.questionnaire.Section
       */
        public static void removeSection(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.questionnaire.Section
       * @param id Identifier for org.semanticwb.questionnaire.Section
       * @param model Model of the org.semanticwb.questionnaire.Section
       * @return true if the org.semanticwb.questionnaire.Section exists, false otherwise
       */

        public static boolean hasSection(String id, org.semanticwb.model.SWBModel model)
        {
            return (getSection(id, model)!=null);
        }
    }

    public static SectionBase.ClassMgr getSectionClassMgr()
    {
        return new SectionBase.ClassMgr();
    }

   /**
   * Constructs a SectionBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Section
   */
    public SectionBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
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
}
