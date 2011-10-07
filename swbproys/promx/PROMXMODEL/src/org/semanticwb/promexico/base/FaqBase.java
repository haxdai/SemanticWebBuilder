package org.semanticwb.promexico.base;


   /**
   * Preguntas Frecuentes 
   */
public abstract class FaqBase extends org.semanticwb.model.SWBClass implements org.semanticwb.promexico.ProSearchAble,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Searchable,org.semanticwb.model.Traceable,org.semanticwb.model.Tagable
{
   /**
   * Temas de Preguntas Frecuentes
   */
    public static final org.semanticwb.platform.SemanticClass promx_FaqTopic=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#FaqTopic");
   /**
   * Tema asociado a la pregunta frecuente
   */
    public static final org.semanticwb.platform.SemanticProperty promx_faqTopic=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#faqTopic");
   /**
   * Servicios
   */
    public static final org.semanticwb.platform.SemanticClass promx_Service=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#Service");
    public static final org.semanticwb.platform.SemanticProperty promx_hasFaqService=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#hasFaqService");
   /**
   * Preguntas Frecuentes
   */
    public static final org.semanticwb.platform.SemanticClass promx_Faq=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#Faq");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#Faq");

    public static class ClassMgr
    {
       /**
       * Returns a list of Faq for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.promexico.Faq
       */

        public static java.util.Iterator<org.semanticwb.promexico.Faq> listFaqs(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Faq>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.promexico.Faq for all models
       * @return Iterator of org.semanticwb.promexico.Faq
       */

        public static java.util.Iterator<org.semanticwb.promexico.Faq> listFaqs()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Faq>(it, true);
        }

        public static org.semanticwb.promexico.Faq createFaq(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.promexico.Faq.ClassMgr.createFaq(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.promexico.Faq
       * @param id Identifier for org.semanticwb.promexico.Faq
       * @param model Model of the org.semanticwb.promexico.Faq
       * @return A org.semanticwb.promexico.Faq
       */
        public static org.semanticwb.promexico.Faq getFaq(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.promexico.Faq)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.promexico.Faq
       * @param id Identifier for org.semanticwb.promexico.Faq
       * @param model Model of the org.semanticwb.promexico.Faq
       * @return A org.semanticwb.promexico.Faq
       */
        public static org.semanticwb.promexico.Faq createFaq(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.promexico.Faq)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.promexico.Faq
       * @param id Identifier for org.semanticwb.promexico.Faq
       * @param model Model of the org.semanticwb.promexico.Faq
       */
        public static void removeFaq(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.promexico.Faq
       * @param id Identifier for org.semanticwb.promexico.Faq
       * @param model Model of the org.semanticwb.promexico.Faq
       * @return true if the org.semanticwb.promexico.Faq exists, false otherwise
       */

        public static boolean hasFaq(String id, org.semanticwb.model.SWBModel model)
        {
            return (getFaq(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.promexico.Faq with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.promexico.Faq
       * @return Iterator with all the org.semanticwb.promexico.Faq
       */

        public static java.util.Iterator<org.semanticwb.promexico.Faq> listFaqByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Faq> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Faq with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.promexico.Faq
       */

        public static java.util.Iterator<org.semanticwb.promexico.Faq> listFaqByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Faq> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Faq with a determined FaqTopic
       * @param value FaqTopic of the type org.semanticwb.promexico.FaqTopic
       * @param model Model of the org.semanticwb.promexico.Faq
       * @return Iterator with all the org.semanticwb.promexico.Faq
       */

        public static java.util.Iterator<org.semanticwb.promexico.Faq> listFaqByFaqTopic(org.semanticwb.promexico.FaqTopic value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Faq> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(promx_faqTopic, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Faq with a determined FaqTopic
       * @param value FaqTopic of the type org.semanticwb.promexico.FaqTopic
       * @return Iterator with all the org.semanticwb.promexico.Faq
       */

        public static java.util.Iterator<org.semanticwb.promexico.Faq> listFaqByFaqTopic(org.semanticwb.promexico.FaqTopic value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Faq> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(promx_faqTopic,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Faq with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.promexico.Faq
       * @return Iterator with all the org.semanticwb.promexico.Faq
       */

        public static java.util.Iterator<org.semanticwb.promexico.Faq> listFaqByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Faq> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Faq with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.promexico.Faq
       */

        public static java.util.Iterator<org.semanticwb.promexico.Faq> listFaqByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Faq> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Faq with a determined FaqService
       * @param value FaqService of the type org.semanticwb.promexico.Service
       * @param model Model of the org.semanticwb.promexico.Faq
       * @return Iterator with all the org.semanticwb.promexico.Faq
       */

        public static java.util.Iterator<org.semanticwb.promexico.Faq> listFaqByFaqService(org.semanticwb.promexico.Service value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Faq> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(promx_hasFaqService, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Faq with a determined FaqService
       * @param value FaqService of the type org.semanticwb.promexico.Service
       * @return Iterator with all the org.semanticwb.promexico.Faq
       */

        public static java.util.Iterator<org.semanticwb.promexico.Faq> listFaqByFaqService(org.semanticwb.promexico.Service value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Faq> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(promx_hasFaqService,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a FaqBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Faq
   */
    public FaqBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
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
   * Sets the value for the property FaqTopic
   * @param value FaqTopic to set
   */

    public void setFaqTopic(org.semanticwb.promexico.FaqTopic value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(promx_faqTopic, value.getSemanticObject());
        }else
        {
            removeFaqTopic();
        }
    }
   /**
   * Remove the value for FaqTopic property
   */

    public void removeFaqTopic()
    {
        getSemanticObject().removeProperty(promx_faqTopic);
    }

   /**
   * Gets the FaqTopic
   * @return a org.semanticwb.promexico.FaqTopic
   */
    public org.semanticwb.promexico.FaqTopic getFaqTopic()
    {
         org.semanticwb.promexico.FaqTopic ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(promx_faqTopic);
         if(obj!=null)
         {
             ret=(org.semanticwb.promexico.FaqTopic)obj.createGenericInstance();
         }
         return ret;
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
* Gets the ProSearchDescription property
* @return String with the ProSearchDescription
*/
    public String getProSearchDescription()
    {
        return getSemanticObject().getProperty(promx_proSearchDescription);
    }

/**
* Sets the ProSearchDescription property
* @param value long with the ProSearchDescription
*/
    public void setProSearchDescription(String value)
    {
        getSemanticObject().setProperty(promx_proSearchDescription, value);
    }

    public String getProSearchDescription(String lang)
    {
        return getSemanticObject().getProperty(promx_proSearchDescription, null, lang);
    }

    public String getDisplayProSearchDescription(String lang)
    {
        return getSemanticObject().getLocaleProperty(promx_proSearchDescription, lang);
    }

    public void setProSearchDescription(String proSearchDescription, String lang)
    {
        getSemanticObject().setProperty(promx_proSearchDescription, proSearchDescription, lang);
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
   * Gets all the org.semanticwb.promexico.Service
   * @return A GenericIterator with all the org.semanticwb.promexico.Service
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Service> listFaqServices()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Service>(getSemanticObject().listObjectProperties(promx_hasFaqService));
    }

   /**
   * Gets true if has a FaqService
   * @param value org.semanticwb.promexico.Service to verify
   * @return true if the org.semanticwb.promexico.Service exists, false otherwise
   */
    public boolean hasFaqService(org.semanticwb.promexico.Service value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(promx_hasFaqService,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a FaqService
   * @param value org.semanticwb.promexico.Service to add
   */

    public void addFaqService(org.semanticwb.promexico.Service value)
    {
        getSemanticObject().addObjectProperty(promx_hasFaqService, value.getSemanticObject());
    }
   /**
   * Removes all the FaqService
   */

    public void removeAllFaqService()
    {
        getSemanticObject().removeProperty(promx_hasFaqService);
    }
   /**
   * Removes a FaqService
   * @param value org.semanticwb.promexico.Service to remove
   */

    public void removeFaqService(org.semanticwb.promexico.Service value)
    {
        getSemanticObject().removeObjectProperty(promx_hasFaqService,value.getSemanticObject());
    }

   /**
   * Gets the FaqService
   * @return a org.semanticwb.promexico.Service
   */
    public org.semanticwb.promexico.Service getFaqService()
    {
         org.semanticwb.promexico.Service ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(promx_hasFaqService);
         if(obj!=null)
         {
             ret=(org.semanticwb.promexico.Service)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the Tags property
* @return String with the Tags
*/
    public String getTags()
    {
        return getSemanticObject().getProperty(swb_tags);
    }

/**
* Sets the Tags property
* @param value long with the Tags
*/
    public void setTags(String value)
    {
        getSemanticObject().setProperty(swb_tags, value);
    }

    public String getTags(String lang)
    {
        return getSemanticObject().getProperty(swb_tags, null, lang);
    }

    public String getDisplayTags(String lang)
    {
        return getSemanticObject().getLocaleProperty(swb_tags, lang);
    }

    public void setTags(String tags, String lang)
    {
        getSemanticObject().setProperty(swb_tags, tags, lang);
    }

   /**
   * Gets the ProMexico
   * @return a instance of org.semanticwb.promexico.ProMexico
   */
    public org.semanticwb.promexico.ProMexico getProMexico()
    {
        return (org.semanticwb.promexico.ProMexico)getSemanticObject().getModel().getModelObject().createGenericInstance();
    }
}
