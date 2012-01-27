package org.semanticwb.cptm.base;


public abstract class CompanyLineBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Searchable
{
   /**
   * Interface para datos generales de Cadenas, Marcas y Empresas
   */
    public static final org.semanticwb.platform.SemanticClass cptm_GeneralCompany=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#GeneralCompany");
    public static final org.semanticwb.platform.SemanticProperty cptm_CompLineCompanyDataInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#CompLineCompanyDataInv");
    public static final org.semanticwb.platform.SemanticClass cptm_CompanyLine=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#CompanyLine");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#CompanyLine");

    public static class ClassMgr
    {
       /**
       * Returns a list of CompanyLine for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.cptm.CompanyLine
       */

        public static java.util.Iterator<org.semanticwb.cptm.CompanyLine> listCompanyLines(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CompanyLine>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.cptm.CompanyLine for all models
       * @return Iterator of org.semanticwb.cptm.CompanyLine
       */

        public static java.util.Iterator<org.semanticwb.cptm.CompanyLine> listCompanyLines()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CompanyLine>(it, true);
        }
       /**
       * Gets a org.semanticwb.cptm.CompanyLine
       * @param id Identifier for org.semanticwb.cptm.CompanyLine
       * @param model Model of the org.semanticwb.cptm.CompanyLine
       * @return A org.semanticwb.cptm.CompanyLine
       */
        public static org.semanticwb.cptm.CompanyLine getCompanyLine(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.CompanyLine)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.cptm.CompanyLine
       * @param id Identifier for org.semanticwb.cptm.CompanyLine
       * @param model Model of the org.semanticwb.cptm.CompanyLine
       * @return A org.semanticwb.cptm.CompanyLine
       */
        public static org.semanticwb.cptm.CompanyLine createCompanyLine(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.CompanyLine)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.cptm.CompanyLine
       * @param id Identifier for org.semanticwb.cptm.CompanyLine
       * @param model Model of the org.semanticwb.cptm.CompanyLine
       */
        public static void removeCompanyLine(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.cptm.CompanyLine
       * @param id Identifier for org.semanticwb.cptm.CompanyLine
       * @param model Model of the org.semanticwb.cptm.CompanyLine
       * @return true if the org.semanticwb.cptm.CompanyLine exists, false otherwise
       */

        public static boolean hasCompanyLine(String id, org.semanticwb.model.SWBModel model)
        {
            return (getCompanyLine(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.cptm.CompanyLine with a determined CompLineCompanyDataInv
       * @param value CompLineCompanyDataInv of the type org.semanticwb.cptm.GeneralCompany
       * @param model Model of the org.semanticwb.cptm.CompanyLine
       * @return Iterator with all the org.semanticwb.cptm.CompanyLine
       */

        public static java.util.Iterator<org.semanticwb.cptm.CompanyLine> listCompanyLineByCompLineCompanyDataInv(org.semanticwb.cptm.GeneralCompany value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CompanyLine> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_CompLineCompanyDataInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CompanyLine with a determined CompLineCompanyDataInv
       * @param value CompLineCompanyDataInv of the type org.semanticwb.cptm.GeneralCompany
       * @return Iterator with all the org.semanticwb.cptm.CompanyLine
       */

        public static java.util.Iterator<org.semanticwb.cptm.CompanyLine> listCompanyLineByCompLineCompanyDataInv(org.semanticwb.cptm.GeneralCompany value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CompanyLine> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_CompLineCompanyDataInv,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a CompanyLineBase with a SemanticObject
   * @param base The SemanticObject with the properties for the CompanyLine
   */
    public CompanyLineBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Sets the value for the property CompLineCompanyDataInv
   * @param value CompLineCompanyDataInv to set
   */

    public void setCompLineCompanyDataInv(org.semanticwb.cptm.GeneralCompany value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(cptm_CompLineCompanyDataInv, value.getSemanticObject());
        }else
        {
            removeCompLineCompanyDataInv();
        }
    }
   /**
   * Remove the value for CompLineCompanyDataInv property
   */

    public void removeCompLineCompanyDataInv()
    {
        getSemanticObject().removeProperty(cptm_CompLineCompanyDataInv);
    }

   /**
   * Gets the CompLineCompanyDataInv
   * @return a org.semanticwb.cptm.GeneralCompany
   */
    public org.semanticwb.cptm.GeneralCompany getCompLineCompanyDataInv()
    {
         org.semanticwb.cptm.GeneralCompany ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_CompLineCompanyDataInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.GeneralCompany)obj.createGenericInstance();
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
