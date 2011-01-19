package org.semanticwb.ecosikan.innova.base;


public abstract class IdeaBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable
{
    public static final org.semanticwb.platform.SemanticProperty ecoskn_votesP=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://ecosikan.infotec.com.mx#votesP");
    public static final org.semanticwb.platform.SemanticProperty ecoskn_conclusion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://ecosikan.infotec.com.mx#conclusion");
    public static final org.semanticwb.platform.SemanticProperty ecoskn_selected=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://ecosikan.infotec.com.mx#selected");
    public static final org.semanticwb.platform.SemanticProperty ecoskn_votesN=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://ecosikan.infotec.com.mx#votesN");
    public static final org.semanticwb.platform.SemanticClass ecoskn_Category=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://ecosikan.infotec.com.mx#Category");
    public static final org.semanticwb.platform.SemanticProperty ecoskn_category=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://ecosikan.infotec.com.mx#category");
   /**
   * Una Página Web es el elemento de SemanticWebBuilder a través del cual se estructura la información del portal.
   */
    public static final org.semanticwb.platform.SemanticClass swb_WebPage=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#WebPage");
    public static final org.semanticwb.platform.SemanticProperty ecoskn_wp=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://ecosikan.infotec.com.mx#wp");
    public static final org.semanticwb.platform.SemanticProperty ecoskn_status=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://ecosikan.infotec.com.mx#status");
    public static final org.semanticwb.platform.SemanticClass ecoskn_Comment=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://ecosikan.infotec.com.mx#Comment");
    public static final org.semanticwb.platform.SemanticProperty ecoskn_hasComment=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://ecosikan.infotec.com.mx#hasComment");
    public static final org.semanticwb.platform.SemanticClass ecoskn_Idea=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://ecosikan.infotec.com.mx#Idea");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://ecosikan.infotec.com.mx#Idea");

    public static class ClassMgr
    {
       /**
       * Returns a list of Idea for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.ecosikan.innova.Idea
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Idea> listIdeas(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Idea>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.ecosikan.innova.Idea for all models
       * @return Iterator of org.semanticwb.ecosikan.innova.Idea
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Idea> listIdeas()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Idea>(it, true);
        }

        public static org.semanticwb.ecosikan.innova.Idea createIdea(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.ecosikan.innova.Idea.ClassMgr.createIdea(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.ecosikan.innova.Idea
       * @param id Identifier for org.semanticwb.ecosikan.innova.Idea
       * @param model Model of the org.semanticwb.ecosikan.innova.Idea
       * @return A org.semanticwb.ecosikan.innova.Idea
       */
        public static org.semanticwb.ecosikan.innova.Idea getIdea(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.ecosikan.innova.Idea)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.ecosikan.innova.Idea
       * @param id Identifier for org.semanticwb.ecosikan.innova.Idea
       * @param model Model of the org.semanticwb.ecosikan.innova.Idea
       * @return A org.semanticwb.ecosikan.innova.Idea
       */
        public static org.semanticwb.ecosikan.innova.Idea createIdea(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.ecosikan.innova.Idea)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.ecosikan.innova.Idea
       * @param id Identifier for org.semanticwb.ecosikan.innova.Idea
       * @param model Model of the org.semanticwb.ecosikan.innova.Idea
       */
        public static void removeIdea(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.ecosikan.innova.Idea
       * @param id Identifier for org.semanticwb.ecosikan.innova.Idea
       * @param model Model of the org.semanticwb.ecosikan.innova.Idea
       * @return true if the org.semanticwb.ecosikan.innova.Idea exists, false otherwise
       */

        public static boolean hasIdea(String id, org.semanticwb.model.SWBModel model)
        {
            return (getIdea(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Idea with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.ecosikan.innova.Idea
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Idea
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Idea> listIdeaByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Idea> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Idea with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Idea
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Idea> listIdeaByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Idea> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Idea with a determined Category
       * @param value Category of the type org.semanticwb.ecosikan.innova.Category
       * @param model Model of the org.semanticwb.ecosikan.innova.Idea
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Idea
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Idea> listIdeaByCategory(org.semanticwb.ecosikan.innova.Category value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Idea> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(ecoskn_category, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Idea with a determined Category
       * @param value Category of the type org.semanticwb.ecosikan.innova.Category
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Idea
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Idea> listIdeaByCategory(org.semanticwb.ecosikan.innova.Category value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Idea> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(ecoskn_category,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Idea with a determined Wp
       * @param value Wp of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.ecosikan.innova.Idea
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Idea
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Idea> listIdeaByWp(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Idea> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(ecoskn_wp, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Idea with a determined Wp
       * @param value Wp of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Idea
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Idea> listIdeaByWp(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Idea> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(ecoskn_wp,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Idea with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.ecosikan.innova.Idea
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Idea
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Idea> listIdeaByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Idea> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Idea with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Idea
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Idea> listIdeaByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Idea> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Idea with a determined Comment
       * @param value Comment of the type org.semanticwb.ecosikan.innova.Comment
       * @param model Model of the org.semanticwb.ecosikan.innova.Idea
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Idea
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Idea> listIdeaByComment(org.semanticwb.ecosikan.innova.Comment value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Idea> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(ecoskn_hasComment, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.Idea with a determined Comment
       * @param value Comment of the type org.semanticwb.ecosikan.innova.Comment
       * @return Iterator with all the org.semanticwb.ecosikan.innova.Idea
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Idea> listIdeaByComment(org.semanticwb.ecosikan.innova.Comment value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Idea> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(ecoskn_hasComment,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a IdeaBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Idea
   */
    public IdeaBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the VotesP property
* @return long with the VotesP
*/
    public long getVotesP()
    {
        return getSemanticObject().getLongProperty(ecoskn_votesP);
    }

/**
* Sets the VotesP property
* @param value long with the VotesP
*/
    public void setVotesP(long value)
    {
        getSemanticObject().setLongProperty(ecoskn_votesP, value);
    }

/**
* Gets the Conclusion property
* @return String with the Conclusion
*/
    public String getConclusion()
    {
        return getSemanticObject().getProperty(ecoskn_conclusion);
    }

/**
* Sets the Conclusion property
* @param value long with the Conclusion
*/
    public void setConclusion(String value)
    {
        getSemanticObject().setProperty(ecoskn_conclusion, value);
    }

/**
* Gets the Selected property
* @return boolean with the Selected
*/
    public boolean isSelected()
    {
        return getSemanticObject().getBooleanProperty(ecoskn_selected);
    }

/**
* Sets the Selected property
* @param value long with the Selected
*/
    public void setSelected(boolean value)
    {
        getSemanticObject().setBooleanProperty(ecoskn_selected, value);
    }

/**
* Gets the Created property
* @return java.util.Date with the Created
*/
    public java.util.Date getCreated()
    {
        return getSemanticObject().getDateProperty(swb_created);
    }

/**
* Sets the Created property
* @param value long with the Created
*/
    public void setCreated(java.util.Date value)
    {
        getSemanticObject().setDateProperty(swb_created, value);
    }
   /**
   * Sets the value for the property ModifiedBy
   * @param value ModifiedBy to set
   */

    public void setModifiedBy(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(swb_modifiedBy, value.getSemanticObject());
        }else
        {
            removeModifiedBy();
        }
    }
   /**
   * Remove the value for ModifiedBy property
   */

    public void removeModifiedBy()
    {
        getSemanticObject().removeProperty(swb_modifiedBy);
    }

   /**
   * Gets the ModifiedBy
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getModifiedBy()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_modifiedBy);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
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

/**
* Gets the VotesN property
* @return long with the VotesN
*/
    public long getVotesN()
    {
        return getSemanticObject().getLongProperty(ecoskn_votesN);
    }

/**
* Sets the VotesN property
* @param value long with the VotesN
*/
    public void setVotesN(long value)
    {
        getSemanticObject().setLongProperty(ecoskn_votesN, value);
    }

/**
* Gets the Updated property
* @return java.util.Date with the Updated
*/
    public java.util.Date getUpdated()
    {
        return getSemanticObject().getDateProperty(swb_updated);
    }

/**
* Sets the Updated property
* @param value long with the Updated
*/
    public void setUpdated(java.util.Date value)
    {
        getSemanticObject().setDateProperty(swb_updated, value);
    }
   /**
   * Sets the value for the property Category
   * @param value Category to set
   */

    public void setCategory(org.semanticwb.ecosikan.innova.Category value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(ecoskn_category, value.getSemanticObject());
        }else
        {
            removeCategory();
        }
    }
   /**
   * Remove the value for Category property
   */

    public void removeCategory()
    {
        getSemanticObject().removeProperty(ecoskn_category);
    }

   /**
   * Gets the Category
   * @return a org.semanticwb.ecosikan.innova.Category
   */
    public org.semanticwb.ecosikan.innova.Category getCategory()
    {
         org.semanticwb.ecosikan.innova.Category ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(ecoskn_category);
         if(obj!=null)
         {
             ret=(org.semanticwb.ecosikan.innova.Category)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property Wp
   * @param value Wp to set
   */

    public void setWp(org.semanticwb.model.WebPage value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(ecoskn_wp, value.getSemanticObject());
        }else
        {
            removeWp();
        }
    }
   /**
   * Remove the value for Wp property
   */

    public void removeWp()
    {
        getSemanticObject().removeProperty(ecoskn_wp);
    }

   /**
   * Gets the Wp
   * @return a org.semanticwb.model.WebPage
   */
    public org.semanticwb.model.WebPage getWp()
    {
         org.semanticwb.model.WebPage ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(ecoskn_wp);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.WebPage)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the Status property
* @return String with the Status
*/
    public String getStatus()
    {
        return getSemanticObject().getProperty(ecoskn_status);
    }

/**
* Sets the Status property
* @param value long with the Status
*/
    public void setStatus(String value)
    {
        getSemanticObject().setProperty(ecoskn_status, value);
    }
   /**
   * Sets the value for the property Creator
   * @param value Creator to set
   */

    public void setCreator(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(swb_creator, value.getSemanticObject());
        }else
        {
            removeCreator();
        }
    }
   /**
   * Remove the value for Creator property
   */

    public void removeCreator()
    {
        getSemanticObject().removeProperty(swb_creator);
    }

   /**
   * Gets the Creator
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getCreator()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_creator);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the org.semanticwb.ecosikan.innova.Comment
   * @return A GenericIterator with all the org.semanticwb.ecosikan.innova.Comment
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Comment> listComments()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Comment>(getSemanticObject().listObjectProperties(ecoskn_hasComment));
    }

   /**
   * Gets true if has a Comment
   * @param value org.semanticwb.ecosikan.innova.Comment to verify
   * @return true if the org.semanticwb.ecosikan.innova.Comment exists, false otherwise
   */
    public boolean hasComment(org.semanticwb.ecosikan.innova.Comment value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(ecoskn_hasComment,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Comment
   * @param value org.semanticwb.ecosikan.innova.Comment to add
   */

    public void addComment(org.semanticwb.ecosikan.innova.Comment value)
    {
        getSemanticObject().addObjectProperty(ecoskn_hasComment, value.getSemanticObject());
    }
   /**
   * Removes all the Comment
   */

    public void removeAllComment()
    {
        getSemanticObject().removeProperty(ecoskn_hasComment);
    }
   /**
   * Removes a Comment
   * @param value org.semanticwb.ecosikan.innova.Comment to remove
   */

    public void removeComment(org.semanticwb.ecosikan.innova.Comment value)
    {
        getSemanticObject().removeObjectProperty(ecoskn_hasComment,value.getSemanticObject());
    }

   /**
   * Gets the Comment
   * @return a org.semanticwb.ecosikan.innova.Comment
   */
    public org.semanticwb.ecosikan.innova.Comment getComment()
    {
         org.semanticwb.ecosikan.innova.Comment ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(ecoskn_hasComment);
         if(obj!=null)
         {
             ret=(org.semanticwb.ecosikan.innova.Comment)obj.createGenericInstance();
         }
         return ret;
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
}
