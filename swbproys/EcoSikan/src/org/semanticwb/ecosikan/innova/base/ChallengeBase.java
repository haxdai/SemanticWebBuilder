package org.semanticwb.ecosikan.innova.base;


public abstract class ChallengeBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticClass ecoskn_Idea=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://ecosikan.infotec.com.mx#Idea");
    public static final org.semanticwb.platform.SemanticProperty ecoskn_hasIdea=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://ecosikan.infotec.com.mx#hasIdea");
    public static final org.semanticwb.platform.SemanticProperty ecoskn_phase=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://ecosikan.infotec.com.mx#phase");
    public static final org.semanticwb.platform.SemanticProperty ecoskn_hasExpectations=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://ecosikan.infotec.com.mx#hasExpectations");
    public static final org.semanticwb.platform.SemanticProperty ecoskn_opened=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://ecosikan.infotec.com.mx#opened");
    public static final org.semanticwb.platform.SemanticProperty ecoskn_hasStakeholders=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://ecosikan.infotec.com.mx#hasStakeholders");
    public static final org.semanticwb.platform.SemanticProperty ecoskn_image=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://ecosikan.infotec.com.mx#image");
    public static final org.semanticwb.platform.SemanticClass ecoskn_GobiernoDelEstado=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://ecosikan.infotec.com.mx#GobiernoDelEstado");
    public static final org.semanticwb.platform.SemanticProperty ecoskn_gobierno=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://ecosikan.infotec.com.mx#gobierno");
    public static final org.semanticwb.platform.SemanticProperty ecoskn_hasDesires=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://ecosikan.infotec.com.mx#hasDesires");
    public static final org.semanticwb.platform.SemanticClass ecoskn_Challenge=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://ecosikan.infotec.com.mx#Challenge");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://ecosikan.infotec.com.mx#Challenge");

    public static class ClassMgr
    {
       /**
       * Returns a list of Challenge for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.ecosikan.innova.Challenge
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Challenge> listChallenges(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Challenge>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.ecosikan.innova.Challenge for all models
       * @return Iterator of org.semanticwb.ecosikan.innova.Challenge
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Challenge> listChallenges()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Challenge>(it, true);
        }
       /**
       * Gets a org.semanticwb.ecosikan.innova.Challenge
       * @param id Identifier for org.semanticwb.ecosikan.innova.Challenge
       * @param model Model of the org.semanticwb.ecosikan.innova.Challenge
       * @return A org.semanticwb.ecosikan.innova.Challenge
       */
        public static org.semanticwb.ecosikan.innova.Challenge getChallenge(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.ecosikan.innova.Challenge)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.ecosikan.innova.Challenge
       * @param id Identifier for org.semanticwb.ecosikan.innova.Challenge
       * @param model Model of the org.semanticwb.ecosikan.innova.Challenge
       * @return A org.semanticwb.ecosikan.innova.Challenge
       */
        public static org.semanticwb.ecosikan.innova.Challenge createChallenge(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.ecosikan.innova.Challenge)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.ecosikan.innova.Challenge
       * @param id Identifier for org.semanticwb.ecosikan.innova.Challenge
       * @param model Model of the org.semanticwb.ecosikan.innova.Challenge
       */
        public static void removeChallenge(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.ecosikan.innova.Challenge
       * @param id Identifier for org.semanticwb.ecosikan.innova.Challenge
       * @param model Model of the org.semanticwb.ecosikan.innova.Challenge
       * @return true if the org.semanticwb.ecosikan.innova.Challenge exists, false otherwise
       */

        public static boolean hasChallenge(String id, org.semanticwb.model.SWBModel model)
        {
            return (getChallenge(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Challenge with a determined Idea
       * @param value Idea of the type org.semanticwb.ecosikan.innova.Idea
       * @param model Model of the org.semanticwb.ecosikan.innova.Challenge
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Challenge
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Challenge> listChallengeByIdea(org.semanticwb.ecosikan.innova.Idea value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Challenge> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(ecoskn_hasIdea, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Challenge with a determined Idea
       * @param value Idea of the type org.semanticwb.ecosikan.innova.Idea
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Challenge
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Challenge> listChallengeByIdea(org.semanticwb.ecosikan.innova.Idea value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Challenge> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(ecoskn_hasIdea,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Challenge with a determined Gobierno
       * @param value Gobierno of the type org.semanticwb.ecosikan.innova.GobiernoDelEstado
       * @param model Model of the org.semanticwb.ecosikan.innova.Challenge
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Challenge
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Challenge> listChallengeByGobierno(org.semanticwb.ecosikan.innova.GobiernoDelEstado value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Challenge> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(ecoskn_gobierno, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Challenge with a determined Gobierno
       * @param value Gobierno of the type org.semanticwb.ecosikan.innova.GobiernoDelEstado
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Challenge
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Challenge> listChallengeByGobierno(org.semanticwb.ecosikan.innova.GobiernoDelEstado value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Challenge> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(ecoskn_gobierno,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a ChallengeBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Challenge
   */
    public ChallengeBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Gets all the org.semanticwb.ecosikan.innova.Idea
   * @return A GenericIterator with all the org.semanticwb.ecosikan.innova.Idea
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Idea> listIdeas()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Idea>(getSemanticObject().listObjectProperties(ecoskn_hasIdea));
    }

   /**
   * Gets true if has a Idea
   * @param value org.semanticwb.ecosikan.innova.Idea to verify
   * @return true if the org.semanticwb.ecosikan.innova.Idea exists, false otherwise
   */
    public boolean hasIdea(org.semanticwb.ecosikan.innova.Idea value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(ecoskn_hasIdea,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Idea
   * @param value org.semanticwb.ecosikan.innova.Idea to add
   */

    public void addIdea(org.semanticwb.ecosikan.innova.Idea value)
    {
        getSemanticObject().addObjectProperty(ecoskn_hasIdea, value.getSemanticObject());
    }
   /**
   * Removes all the Idea
   */

    public void removeAllIdea()
    {
        getSemanticObject().removeProperty(ecoskn_hasIdea);
    }
   /**
   * Removes a Idea
   * @param value org.semanticwb.ecosikan.innova.Idea to remove
   */

    public void removeIdea(org.semanticwb.ecosikan.innova.Idea value)
    {
        getSemanticObject().removeObjectProperty(ecoskn_hasIdea,value.getSemanticObject());
    }

   /**
   * Gets the Idea
   * @return a org.semanticwb.ecosikan.innova.Idea
   */
    public org.semanticwb.ecosikan.innova.Idea getIdea()
    {
         org.semanticwb.ecosikan.innova.Idea ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(ecoskn_hasIdea);
         if(obj!=null)
         {
             ret=(org.semanticwb.ecosikan.innova.Idea)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the Phase property
* @return int with the Phase
*/
    public int getPhase()
    {
        return getSemanticObject().getIntProperty(ecoskn_phase);
    }

/**
* Sets the Phase property
* @param value long with the Phase
*/
    public void setPhase(int value)
    {
        getSemanticObject().setIntProperty(ecoskn_phase, value);
    }

    public java.util.Iterator<String> listExpectationses()
    {
        java.util.ArrayList<String> values=new java.util.ArrayList<String>();
        java.util.Iterator<org.semanticwb.platform.SemanticLiteral> it=getSemanticObject().listLiteralProperties(ecoskn_hasExpectations);
        while(it.hasNext())
        {
                org.semanticwb.platform.SemanticLiteral literal=it.next();
                values.add(literal.getString());
        }
        return values.iterator();
    }

    public void addExpectations(String value)
    {
        getSemanticObject().addLiteralProperty(ecoskn_hasExpectations, new org.semanticwb.platform.SemanticLiteral(value));
    }

    public void removeAllExpectations()
    {
        getSemanticObject().removeProperty(ecoskn_hasExpectations);
    }

    public void removeExpectations(String value)
    {
        getSemanticObject().removeLiteralProperty(ecoskn_hasExpectations,new org.semanticwb.platform.SemanticLiteral(value));
    }

/**
* Gets the Opened property
* @return boolean with the Opened
*/
    public boolean isOpened()
    {
        return getSemanticObject().getBooleanProperty(ecoskn_opened);
    }

/**
* Sets the Opened property
* @param value long with the Opened
*/
    public void setOpened(boolean value)
    {
        getSemanticObject().setBooleanProperty(ecoskn_opened, value);
    }

    public java.util.Iterator<String> listStakeholderses()
    {
        java.util.ArrayList<String> values=new java.util.ArrayList<String>();
        java.util.Iterator<org.semanticwb.platform.SemanticLiteral> it=getSemanticObject().listLiteralProperties(ecoskn_hasStakeholders);
        while(it.hasNext())
        {
                org.semanticwb.platform.SemanticLiteral literal=it.next();
                values.add(literal.getString());
        }
        return values.iterator();
    }

    public void addStakeholders(String value)
    {
        getSemanticObject().addLiteralProperty(ecoskn_hasStakeholders, new org.semanticwb.platform.SemanticLiteral(value));
    }

    public void removeAllStakeholders()
    {
        getSemanticObject().removeProperty(ecoskn_hasStakeholders);
    }

    public void removeStakeholders(String value)
    {
        getSemanticObject().removeLiteralProperty(ecoskn_hasStakeholders,new org.semanticwb.platform.SemanticLiteral(value));
    }

/**
* Gets the Image property
* @return String with the Image
*/
    public String getImage()
    {
        return getSemanticObject().getProperty(ecoskn_image);
    }

/**
* Sets the Image property
* @param value long with the Image
*/
    public void setImage(String value)
    {
        getSemanticObject().setProperty(ecoskn_image, value);
    }
   /**
   * Sets the value for the property Gobierno
   * @param value Gobierno to set
   */

    public void setGobierno(org.semanticwb.ecosikan.innova.GobiernoDelEstado value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(ecoskn_gobierno, value.getSemanticObject());
        }else
        {
            removeGobierno();
        }
    }
   /**
   * Remove the value for Gobierno property
   */

    public void removeGobierno()
    {
        getSemanticObject().removeProperty(ecoskn_gobierno);
    }

   /**
   * Gets the Gobierno
   * @return a org.semanticwb.ecosikan.innova.GobiernoDelEstado
   */
    public org.semanticwb.ecosikan.innova.GobiernoDelEstado getGobierno()
    {
         org.semanticwb.ecosikan.innova.GobiernoDelEstado ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(ecoskn_gobierno);
         if(obj!=null)
         {
             ret=(org.semanticwb.ecosikan.innova.GobiernoDelEstado)obj.createGenericInstance();
         }
         return ret;
    }

    public java.util.Iterator<String> listDesireses()
    {
        java.util.ArrayList<String> values=new java.util.ArrayList<String>();
        java.util.Iterator<org.semanticwb.platform.SemanticLiteral> it=getSemanticObject().listLiteralProperties(ecoskn_hasDesires);
        while(it.hasNext())
        {
                org.semanticwb.platform.SemanticLiteral literal=it.next();
                values.add(literal.getString());
        }
        return values.iterator();
    }

    public void addDesires(String value)
    {
        getSemanticObject().addLiteralProperty(ecoskn_hasDesires, new org.semanticwb.platform.SemanticLiteral(value));
    }

    public void removeAllDesires()
    {
        getSemanticObject().removeProperty(ecoskn_hasDesires);
    }

    public void removeDesires(String value)
    {
        getSemanticObject().removeLiteralProperty(ecoskn_hasDesires,new org.semanticwb.platform.SemanticLiteral(value));
    }
}
