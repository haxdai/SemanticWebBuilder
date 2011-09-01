package gob.sep.becas.base;


public abstract class SubscrpcionCorreoBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticProperty becas_subCMail=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/sep/becas.owl#subCMail");
    public static final org.semanticwb.platform.SemanticClass becas_NivelEstudio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/sep/becas.owl#NivelEstudio");
    public static final org.semanticwb.platform.SemanticProperty becas_subCNivelEdu=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/sep/becas.owl#subCNivelEdu");
    public static final org.semanticwb.platform.SemanticClass becas_Institucion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/sep/becas.owl#Institucion");
    public static final org.semanticwb.platform.SemanticProperty becas_hasSubCInstitucion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/sep/becas.owl#hasSubCInstitucion");
    public static final org.semanticwb.platform.SemanticClass becas_SubscrpcionCorreo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/sep/becas.owl#SubscrpcionCorreo");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/sep/becas.owl#SubscrpcionCorreo");

    public static class ClassMgr
    {
       /**
       * Returns a list of SubscrpcionCorreo for a model
       * @param model Model to find
       * @return Iterator of gob.sep.becas.SubscrpcionCorreo
       */

        public static java.util.Iterator<gob.sep.becas.SubscrpcionCorreo> listSubscrpcionCorreos(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<gob.sep.becas.SubscrpcionCorreo>(it, true);
        }
       /**
       * Returns a list of gob.sep.becas.SubscrpcionCorreo for all models
       * @return Iterator of gob.sep.becas.SubscrpcionCorreo
       */

        public static java.util.Iterator<gob.sep.becas.SubscrpcionCorreo> listSubscrpcionCorreos()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<gob.sep.becas.SubscrpcionCorreo>(it, true);
        }
       /**
       * Gets a gob.sep.becas.SubscrpcionCorreo
       * @param id Identifier for gob.sep.becas.SubscrpcionCorreo
       * @param model Model of the gob.sep.becas.SubscrpcionCorreo
       * @return A gob.sep.becas.SubscrpcionCorreo
       */
        public static gob.sep.becas.SubscrpcionCorreo getSubscrpcionCorreo(String id, org.semanticwb.model.SWBModel model)
        {
            return (gob.sep.becas.SubscrpcionCorreo)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a gob.sep.becas.SubscrpcionCorreo
       * @param id Identifier for gob.sep.becas.SubscrpcionCorreo
       * @param model Model of the gob.sep.becas.SubscrpcionCorreo
       * @return A gob.sep.becas.SubscrpcionCorreo
       */
        public static gob.sep.becas.SubscrpcionCorreo createSubscrpcionCorreo(String id, org.semanticwb.model.SWBModel model)
        {
            return (gob.sep.becas.SubscrpcionCorreo)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a gob.sep.becas.SubscrpcionCorreo
       * @param id Identifier for gob.sep.becas.SubscrpcionCorreo
       * @param model Model of the gob.sep.becas.SubscrpcionCorreo
       */
        public static void removeSubscrpcionCorreo(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a gob.sep.becas.SubscrpcionCorreo
       * @param id Identifier for gob.sep.becas.SubscrpcionCorreo
       * @param model Model of the gob.sep.becas.SubscrpcionCorreo
       * @return true if the gob.sep.becas.SubscrpcionCorreo exists, false otherwise
       */

        public static boolean hasSubscrpcionCorreo(String id, org.semanticwb.model.SWBModel model)
        {
            return (getSubscrpcionCorreo(id, model)!=null);
        }
       /**
       * Gets all gob.sep.becas.SubscrpcionCorreo with a determined SubCNivelEdu
       * @param value SubCNivelEdu of the type gob.sep.becas.NivelEstudio
       * @param model Model of the gob.sep.becas.SubscrpcionCorreo
       * @return Iterator with all the gob.sep.becas.SubscrpcionCorreo
       */

        public static java.util.Iterator<gob.sep.becas.SubscrpcionCorreo> listSubscrpcionCorreoBySubCNivelEdu(gob.sep.becas.NivelEstudio value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<gob.sep.becas.SubscrpcionCorreo> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(becas_subCNivelEdu, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all gob.sep.becas.SubscrpcionCorreo with a determined SubCNivelEdu
       * @param value SubCNivelEdu of the type gob.sep.becas.NivelEstudio
       * @return Iterator with all the gob.sep.becas.SubscrpcionCorreo
       */

        public static java.util.Iterator<gob.sep.becas.SubscrpcionCorreo> listSubscrpcionCorreoBySubCNivelEdu(gob.sep.becas.NivelEstudio value)
        {
            org.semanticwb.model.GenericIterator<gob.sep.becas.SubscrpcionCorreo> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(becas_subCNivelEdu,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all gob.sep.becas.SubscrpcionCorreo with a determined SubCInstitucion
       * @param value SubCInstitucion of the type gob.sep.becas.Institucion
       * @param model Model of the gob.sep.becas.SubscrpcionCorreo
       * @return Iterator with all the gob.sep.becas.SubscrpcionCorreo
       */

        public static java.util.Iterator<gob.sep.becas.SubscrpcionCorreo> listSubscrpcionCorreoBySubCInstitucion(gob.sep.becas.Institucion value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<gob.sep.becas.SubscrpcionCorreo> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(becas_hasSubCInstitucion, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all gob.sep.becas.SubscrpcionCorreo with a determined SubCInstitucion
       * @param value SubCInstitucion of the type gob.sep.becas.Institucion
       * @return Iterator with all the gob.sep.becas.SubscrpcionCorreo
       */

        public static java.util.Iterator<gob.sep.becas.SubscrpcionCorreo> listSubscrpcionCorreoBySubCInstitucion(gob.sep.becas.Institucion value)
        {
            org.semanticwb.model.GenericIterator<gob.sep.becas.SubscrpcionCorreo> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(becas_hasSubCInstitucion,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a SubscrpcionCorreoBase with a SemanticObject
   * @param base The SemanticObject with the properties for the SubscrpcionCorreo
   */
    public SubscrpcionCorreoBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the SubCMail property
* @return String with the SubCMail
*/
    public String getSubCMail()
    {
        return getSemanticObject().getProperty(becas_subCMail);
    }

/**
* Sets the SubCMail property
* @param value long with the SubCMail
*/
    public void setSubCMail(String value)
    {
        getSemanticObject().setProperty(becas_subCMail, value);
    }
   /**
   * Sets the value for the property SubCNivelEdu
   * @param value SubCNivelEdu to set
   */

    public void setSubCNivelEdu(gob.sep.becas.NivelEstudio value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(becas_subCNivelEdu, value.getSemanticObject());
        }else
        {
            removeSubCNivelEdu();
        }
    }
   /**
   * Remove the value for SubCNivelEdu property
   */

    public void removeSubCNivelEdu()
    {
        getSemanticObject().removeProperty(becas_subCNivelEdu);
    }

   /**
   * Gets the SubCNivelEdu
   * @return a gob.sep.becas.NivelEstudio
   */
    public gob.sep.becas.NivelEstudio getSubCNivelEdu()
    {
         gob.sep.becas.NivelEstudio ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(becas_subCNivelEdu);
         if(obj!=null)
         {
             ret=(gob.sep.becas.NivelEstudio)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the gob.sep.becas.Institucion
   * @return A GenericIterator with all the gob.sep.becas.Institucion
   */

    public org.semanticwb.model.GenericIterator<gob.sep.becas.Institucion> listSubCInstitucions()
    {
        return new org.semanticwb.model.GenericIterator<gob.sep.becas.Institucion>(getSemanticObject().listObjectProperties(becas_hasSubCInstitucion));
    }

   /**
   * Gets true if has a SubCInstitucion
   * @param value gob.sep.becas.Institucion to verify
   * @return true if the gob.sep.becas.Institucion exists, false otherwise
   */
    public boolean hasSubCInstitucion(gob.sep.becas.Institucion value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(becas_hasSubCInstitucion,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a SubCInstitucion
   * @param value gob.sep.becas.Institucion to add
   */

    public void addSubCInstitucion(gob.sep.becas.Institucion value)
    {
        getSemanticObject().addObjectProperty(becas_hasSubCInstitucion, value.getSemanticObject());
    }
   /**
   * Removes all the SubCInstitucion
   */

    public void removeAllSubCInstitucion()
    {
        getSemanticObject().removeProperty(becas_hasSubCInstitucion);
    }
   /**
   * Removes a SubCInstitucion
   * @param value gob.sep.becas.Institucion to remove
   */

    public void removeSubCInstitucion(gob.sep.becas.Institucion value)
    {
        getSemanticObject().removeObjectProperty(becas_hasSubCInstitucion,value.getSemanticObject());
    }

   /**
   * Gets the SubCInstitucion
   * @return a gob.sep.becas.Institucion
   */
    public gob.sep.becas.Institucion getSubCInstitucion()
    {
         gob.sep.becas.Institucion ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(becas_hasSubCInstitucion);
         if(obj!=null)
         {
             ret=(gob.sep.becas.Institucion)obj.createGenericInstance();
         }
         return ret;
    }
}
