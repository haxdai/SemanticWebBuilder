package org.semanticwb.questionnaire.base;


public abstract class ResourceQuestionariesBase extends org.semanticwb.portal.api.GenericSemResource 
{
    public static final org.semanticwb.platform.SemanticClass que_Questionnaire=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://org.semanticwb.resources/Questionnaire#Questionnaire");
    public static final org.semanticwb.platform.SemanticProperty que_hasQuestionnaire=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/Questionnaire#hasQuestionnaire");
    public static final org.semanticwb.platform.SemanticClass swb_Resource=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#Resource");
    public static final org.semanticwb.platform.SemanticProperty swb_semanticResourceInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#semanticResourceInv");
    public static final org.semanticwb.platform.SemanticClass que_ResourceQuestionaries=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://org.semanticwb.resources/Questionnaire#ResourceQuestionaries");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://org.semanticwb.resources/Questionnaire#ResourceQuestionaries");

    public ResourceQuestionariesBase()
    {
    }

   /**
   * Constructs a ResourceQuestionariesBase with a SemanticObject
   * @param base The SemanticObject with the properties for the ResourceQuestionaries
   */
    public ResourceQuestionariesBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    /*
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() 
    {
        return getSemanticObject().hashCode();
    }

    /*
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) 
    {
        if(obj==null)return false;
        return hashCode()==obj.hashCode();
    }
   /**
   * Gets all the org.semanticwb.questionnaire.Questionnaire
   * @return A GenericIterator with all the org.semanticwb.questionnaire.Questionnaire
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.Questionnaire> listQuestionnaires()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.Questionnaire>(getSemanticObject().listObjectProperties(que_hasQuestionnaire));
    }

   /**
   * Gets true if has a Questionnaire
   * @param value org.semanticwb.questionnaire.Questionnaire to verify
   * @return true if the org.semanticwb.questionnaire.Questionnaire exists, false otherwise
   */
    public boolean hasQuestionnaire(org.semanticwb.questionnaire.Questionnaire value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(que_hasQuestionnaire,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Questionnaire
   * @param value org.semanticwb.questionnaire.Questionnaire to add
   */

    public void addQuestionnaire(org.semanticwb.questionnaire.Questionnaire value)
    {
        getSemanticObject().addObjectProperty(que_hasQuestionnaire, value.getSemanticObject());
    }
   /**
   * Removes all the Questionnaire
   */

    public void removeAllQuestionnaire()
    {
        getSemanticObject().removeProperty(que_hasQuestionnaire);
    }
   /**
   * Removes a Questionnaire
   * @param value org.semanticwb.questionnaire.Questionnaire to remove
   */

    public void removeQuestionnaire(org.semanticwb.questionnaire.Questionnaire value)
    {
        getSemanticObject().removeObjectProperty(que_hasQuestionnaire,value.getSemanticObject());
    }

   /**
   * Gets the Questionnaire
   * @return a org.semanticwb.questionnaire.Questionnaire
   */
    public org.semanticwb.questionnaire.Questionnaire getQuestionnaire()
    {
         org.semanticwb.questionnaire.Questionnaire ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(que_hasQuestionnaire);
         if(obj!=null)
         {
             ret=(org.semanticwb.questionnaire.Questionnaire)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property Resource
   * @param value Resource to set
   */

    public void setResource(org.semanticwb.model.Resource value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(swb_semanticResourceInv, value.getSemanticObject());
        }else
        {
            removeResource();
        }
    }
   /**
   * Remove the value for Resource property
   */

    public void removeResource()
    {
        getSemanticObject().removeProperty(swb_semanticResourceInv);
    }

   /**
   * Gets the Resource
   * @return a org.semanticwb.model.Resource
   */
    public org.semanticwb.model.Resource getResource()
    {
         org.semanticwb.model.Resource ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_semanticResourceInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.Resource)obj.createGenericInstance();
         }
         return ret;
    }
}
