package com.infotec.cvi.swb.base;


public abstract class CPBase extends com.infotec.cvi.swb.Catalogo implements org.semanticwb.model.Traceable,org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticClass intranet_Municipio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Municipio");
    public static final org.semanticwb.platform.SemanticProperty intranet_municipioCPInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#municipioCPInv");
    public static final org.semanticwb.platform.SemanticClass intranet_Colonia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Colonia");
    public static final org.semanticwb.platform.SemanticProperty intranet_coloniaCP=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#coloniaCP");
    public static final org.semanticwb.platform.SemanticClass intranet_CP=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#CP");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#CP");

    public static class ClassMgr
    {
       /**
       * Returns a list of CP for a model
       * @param model Model to find
       * @return Iterator of com.infotec.cvi.swb.CP
       */

        public static java.util.Iterator<com.infotec.cvi.swb.CP> listCPs(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.CP>(it, true);
        }
       /**
       * Returns a list of com.infotec.cvi.swb.CP for all models
       * @return Iterator of com.infotec.cvi.swb.CP
       */

        public static java.util.Iterator<com.infotec.cvi.swb.CP> listCPs()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.CP>(it, true);
        }

        public static com.infotec.cvi.swb.CP createCP(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.cvi.swb.CP.ClassMgr.createCP(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.cvi.swb.CP
       * @param id Identifier for com.infotec.cvi.swb.CP
       * @param model Model of the com.infotec.cvi.swb.CP
       * @return A com.infotec.cvi.swb.CP
       */
        public static com.infotec.cvi.swb.CP getCP(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.CP)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.cvi.swb.CP
       * @param id Identifier for com.infotec.cvi.swb.CP
       * @param model Model of the com.infotec.cvi.swb.CP
       * @return A com.infotec.cvi.swb.CP
       */
        public static com.infotec.cvi.swb.CP createCP(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.CP)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.cvi.swb.CP
       * @param id Identifier for com.infotec.cvi.swb.CP
       * @param model Model of the com.infotec.cvi.swb.CP
       */
        public static void removeCP(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.cvi.swb.CP
       * @param id Identifier for com.infotec.cvi.swb.CP
       * @param model Model of the com.infotec.cvi.swb.CP
       * @return true if the com.infotec.cvi.swb.CP exists, false otherwise
       */

        public static boolean hasCP(String id, org.semanticwb.model.SWBModel model)
        {
            return (getCP(id, model)!=null);
        }
       /**
       * Gets all com.infotec.cvi.swb.CP with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.CP
       * @return Iterator with all the com.infotec.cvi.swb.CP
       */

        public static java.util.Iterator<com.infotec.cvi.swb.CP> listCPByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.CP> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.CP with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.CP
       */

        public static java.util.Iterator<com.infotec.cvi.swb.CP> listCPByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.CP> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.CP with a determined MunicipioCPInv
       * @param value MunicipioCPInv of the type com.infotec.cvi.swb.Municipio
       * @param model Model of the com.infotec.cvi.swb.CP
       * @return Iterator with all the com.infotec.cvi.swb.CP
       */

        public static java.util.Iterator<com.infotec.cvi.swb.CP> listCPByMunicipioCPInv(com.infotec.cvi.swb.Municipio value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.CP> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_municipioCPInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.CP with a determined MunicipioCPInv
       * @param value MunicipioCPInv of the type com.infotec.cvi.swb.Municipio
       * @return Iterator with all the com.infotec.cvi.swb.CP
       */

        public static java.util.Iterator<com.infotec.cvi.swb.CP> listCPByMunicipioCPInv(com.infotec.cvi.swb.Municipio value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.CP> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_municipioCPInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.CP with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.CP
       * @return Iterator with all the com.infotec.cvi.swb.CP
       */

        public static java.util.Iterator<com.infotec.cvi.swb.CP> listCPByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.CP> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.CP with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.CP
       */

        public static java.util.Iterator<com.infotec.cvi.swb.CP> listCPByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.CP> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.CP with a determined ColoniaCP
       * @param value ColoniaCP of the type com.infotec.cvi.swb.Colonia
       * @param model Model of the com.infotec.cvi.swb.CP
       * @return Iterator with all the com.infotec.cvi.swb.CP
       */

        public static java.util.Iterator<com.infotec.cvi.swb.CP> listCPByColoniaCP(com.infotec.cvi.swb.Colonia value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.CP> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_coloniaCP, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.CP with a determined ColoniaCP
       * @param value ColoniaCP of the type com.infotec.cvi.swb.Colonia
       * @return Iterator with all the com.infotec.cvi.swb.CP
       */

        public static java.util.Iterator<com.infotec.cvi.swb.CP> listCPByColoniaCP(com.infotec.cvi.swb.Colonia value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.CP> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_coloniaCP,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a CPBase with a SemanticObject
   * @param base The SemanticObject with the properties for the CP
   */
    public CPBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Sets the value for the property MunicipioCPInv
   * @param value MunicipioCPInv to set
   */

    public void setMunicipioCPInv(com.infotec.cvi.swb.Municipio value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_municipioCPInv, value.getSemanticObject());
        }else
        {
            removeMunicipioCPInv();
        }
    }
   /**
   * Remove the value for MunicipioCPInv property
   */

    public void removeMunicipioCPInv()
    {
        getSemanticObject().removeProperty(intranet_municipioCPInv);
    }

   /**
   * Gets the MunicipioCPInv
   * @return a com.infotec.cvi.swb.Municipio
   */
    public com.infotec.cvi.swb.Municipio getMunicipioCPInv()
    {
         com.infotec.cvi.swb.Municipio ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_municipioCPInv);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.Municipio)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property ColoniaCP
   * @param value ColoniaCP to set
   */

    public void setColoniaCP(com.infotec.cvi.swb.Colonia value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_coloniaCP, value.getSemanticObject());
        }else
        {
            removeColoniaCP();
        }
    }
   /**
   * Remove the value for ColoniaCP property
   */

    public void removeColoniaCP()
    {
        getSemanticObject().removeProperty(intranet_coloniaCP);
    }

   /**
   * Gets the ColoniaCP
   * @return a com.infotec.cvi.swb.Colonia
   */
    public com.infotec.cvi.swb.Colonia getColoniaCP()
    {
         com.infotec.cvi.swb.Colonia ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_coloniaCP);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.Colonia)obj.createGenericInstance();
         }
         return ret;
    }
}
