package org.semanticwb.ecosikan.innova.base;


public abstract class ChallengeManagerBase extends org.semanticwb.portal.api.GenericSemResource 
{
    public static final org.semanticwb.platform.SemanticClass swb_Resource=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#Resource");
    public static final org.semanticwb.platform.SemanticProperty swb_semanticResourceInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#semanticResourceInv");
    public static final org.semanticwb.platform.SemanticClass ecoskn_Challenge=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://ecosikan.infotec.com.mx#Challenge");
    public static final org.semanticwb.platform.SemanticProperty ecoskn_hasChallenges=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://ecosikan.infotec.com.mx#hasChallenges");
    public static final org.semanticwb.platform.SemanticClass ecoskn_ChallengeManager=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://ecosikan.infotec.com.mx#ChallengeManager");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://ecosikan.infotec.com.mx#ChallengeManager");

    public ChallengeManagerBase()
    {
    }

   /**
   * Constructs a ChallengeManagerBase with a SemanticObject
   * @param base The SemanticObject with the properties for the ChallengeManager
   */
    public ChallengeManagerBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
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
   /**
   * Gets all the org.semanticwb.ecosikan.innova.Challenge
   * @return A GenericIterator with all the org.semanticwb.ecosikan.innova.Challenge
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Challenge> listChallengeses()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Challenge>(getSemanticObject().listObjectProperties(ecoskn_hasChallenges));
    }

   /**
   * Gets true if has a Challenges
   * @param value org.semanticwb.ecosikan.innova.Challenge to verify
   * @return true if the org.semanticwb.ecosikan.innova.Challenge exists, false otherwise
   */
    public boolean hasChallenges(org.semanticwb.ecosikan.innova.Challenge value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(ecoskn_hasChallenges,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Challenges
   * @param value org.semanticwb.ecosikan.innova.Challenge to add
   */

    public void addChallenges(org.semanticwb.ecosikan.innova.Challenge value)
    {
        getSemanticObject().addObjectProperty(ecoskn_hasChallenges, value.getSemanticObject());
    }
   /**
   * Removes all the Challenges
   */

    public void removeAllChallenges()
    {
        getSemanticObject().removeProperty(ecoskn_hasChallenges);
    }
   /**
   * Removes a Challenges
   * @param value org.semanticwb.ecosikan.innova.Challenge to remove
   */

    public void removeChallenges(org.semanticwb.ecosikan.innova.Challenge value)
    {
        getSemanticObject().removeObjectProperty(ecoskn_hasChallenges,value.getSemanticObject());
    }

   /**
   * Gets the Challenges
   * @return a org.semanticwb.ecosikan.innova.Challenge
   */
    public org.semanticwb.ecosikan.innova.Challenge getChallenges()
    {
         org.semanticwb.ecosikan.innova.Challenge ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(ecoskn_hasChallenges);
         if(obj!=null)
         {
             ret=(org.semanticwb.ecosikan.innova.Challenge)obj.createGenericInstance();
         }
         return ret;
    }
}
