package gob.sep.becas.base;


   /**
   * Contenedor de usuarios para lista de correo 
   */
public abstract class SubscrpcionCorreoBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticProperty becas_subCMail=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/sep/becas.owl#subCMail");
    public static final org.semanticwb.platform.SemanticProperty becas_subActivo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/sep/becas.owl#subActivo");
    public static final org.semanticwb.platform.SemanticClass becas_Estado=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/sep/becas.owl#Estado");
    public static final org.semanticwb.platform.SemanticProperty becas_subEstado=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/sep/becas.owl#subEstado");
    public static final org.semanticwb.platform.SemanticClass becas_NivelEstudio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/sep/becas.owl#NivelEstudio");
    public static final org.semanticwb.platform.SemanticProperty becas_subCNivelEdu=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/sep/becas.owl#subCNivelEdu");
    public static final org.semanticwb.platform.SemanticClass becas_Municipio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/sep/becas.owl#Municipio");
    public static final org.semanticwb.platform.SemanticProperty becas_subMunicipio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/sep/becas.owl#subMunicipio");
   /**
   * Catalogo de paises
   */
    public static final org.semanticwb.platform.SemanticClass swb_Country=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#Country");
    public static final org.semanticwb.platform.SemanticProperty becas_subCountry=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/sep/becas.owl#subCountry");
    public static final org.semanticwb.platform.SemanticProperty becas_subSexo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/sep/becas.owl#subSexo");
    public static final org.semanticwb.platform.SemanticProperty becas_subRangoEdad=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/sep/becas.owl#subRangoEdad");
    public static final org.semanticwb.platform.SemanticClass becas_Institucion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/sep/becas.owl#Institucion");
    public static final org.semanticwb.platform.SemanticProperty becas_hasSubCInstitucion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/sep/becas.owl#hasSubCInstitucion");
   /**
   * Contenedor de usuarios para lista de correo
   */
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

        public static gob.sep.becas.SubscrpcionCorreo createSubscrpcionCorreo(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return gob.sep.becas.SubscrpcionCorreo.ClassMgr.createSubscrpcionCorreo(String.valueOf(id), model);
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
       * Gets all gob.sep.becas.SubscrpcionCorreo with a determined SubEstado
       * @param value SubEstado of the type gob.sep.becas.Estado
       * @param model Model of the gob.sep.becas.SubscrpcionCorreo
       * @return Iterator with all the gob.sep.becas.SubscrpcionCorreo
       */

        public static java.util.Iterator<gob.sep.becas.SubscrpcionCorreo> listSubscrpcionCorreoBySubEstado(gob.sep.becas.Estado value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<gob.sep.becas.SubscrpcionCorreo> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(becas_subEstado, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all gob.sep.becas.SubscrpcionCorreo with a determined SubEstado
       * @param value SubEstado of the type gob.sep.becas.Estado
       * @return Iterator with all the gob.sep.becas.SubscrpcionCorreo
       */

        public static java.util.Iterator<gob.sep.becas.SubscrpcionCorreo> listSubscrpcionCorreoBySubEstado(gob.sep.becas.Estado value)
        {
            org.semanticwb.model.GenericIterator<gob.sep.becas.SubscrpcionCorreo> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(becas_subEstado,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all gob.sep.becas.SubscrpcionCorreo with a determined NivelEducativo
       * @param value NivelEducativo of the type gob.sep.becas.NivelEstudio
       * @param model Model of the gob.sep.becas.SubscrpcionCorreo
       * @return Iterator with all the gob.sep.becas.SubscrpcionCorreo
       */

        public static java.util.Iterator<gob.sep.becas.SubscrpcionCorreo> listSubscrpcionCorreoByNivelEducativo(gob.sep.becas.NivelEstudio value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<gob.sep.becas.SubscrpcionCorreo> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(becas_subCNivelEdu, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all gob.sep.becas.SubscrpcionCorreo with a determined NivelEducativo
       * @param value NivelEducativo of the type gob.sep.becas.NivelEstudio
       * @return Iterator with all the gob.sep.becas.SubscrpcionCorreo
       */

        public static java.util.Iterator<gob.sep.becas.SubscrpcionCorreo> listSubscrpcionCorreoByNivelEducativo(gob.sep.becas.NivelEstudio value)
        {
            org.semanticwb.model.GenericIterator<gob.sep.becas.SubscrpcionCorreo> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(becas_subCNivelEdu,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all gob.sep.becas.SubscrpcionCorreo with a determined SubMunicipio
       * @param value SubMunicipio of the type gob.sep.becas.Municipio
       * @param model Model of the gob.sep.becas.SubscrpcionCorreo
       * @return Iterator with all the gob.sep.becas.SubscrpcionCorreo
       */

        public static java.util.Iterator<gob.sep.becas.SubscrpcionCorreo> listSubscrpcionCorreoBySubMunicipio(gob.sep.becas.Municipio value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<gob.sep.becas.SubscrpcionCorreo> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(becas_subMunicipio, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all gob.sep.becas.SubscrpcionCorreo with a determined SubMunicipio
       * @param value SubMunicipio of the type gob.sep.becas.Municipio
       * @return Iterator with all the gob.sep.becas.SubscrpcionCorreo
       */

        public static java.util.Iterator<gob.sep.becas.SubscrpcionCorreo> listSubscrpcionCorreoBySubMunicipio(gob.sep.becas.Municipio value)
        {
            org.semanticwb.model.GenericIterator<gob.sep.becas.SubscrpcionCorreo> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(becas_subMunicipio,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all gob.sep.becas.SubscrpcionCorreo with a determined SubCountry
       * @param value SubCountry of the type org.semanticwb.model.Country
       * @param model Model of the gob.sep.becas.SubscrpcionCorreo
       * @return Iterator with all the gob.sep.becas.SubscrpcionCorreo
       */

        public static java.util.Iterator<gob.sep.becas.SubscrpcionCorreo> listSubscrpcionCorreoBySubCountry(org.semanticwb.model.Country value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<gob.sep.becas.SubscrpcionCorreo> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(becas_subCountry, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all gob.sep.becas.SubscrpcionCorreo with a determined SubCountry
       * @param value SubCountry of the type org.semanticwb.model.Country
       * @return Iterator with all the gob.sep.becas.SubscrpcionCorreo
       */

        public static java.util.Iterator<gob.sep.becas.SubscrpcionCorreo> listSubscrpcionCorreoBySubCountry(org.semanticwb.model.Country value)
        {
            org.semanticwb.model.GenericIterator<gob.sep.becas.SubscrpcionCorreo> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(becas_subCountry,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all gob.sep.becas.SubscrpcionCorreo with a determined Instituciones
       * @param value Instituciones of the type gob.sep.becas.Institucion
       * @param model Model of the gob.sep.becas.SubscrpcionCorreo
       * @return Iterator with all the gob.sep.becas.SubscrpcionCorreo
       */

        public static java.util.Iterator<gob.sep.becas.SubscrpcionCorreo> listSubscrpcionCorreoByInstituciones(gob.sep.becas.Institucion value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<gob.sep.becas.SubscrpcionCorreo> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(becas_hasSubCInstitucion, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all gob.sep.becas.SubscrpcionCorreo with a determined Instituciones
       * @param value Instituciones of the type gob.sep.becas.Institucion
       * @return Iterator with all the gob.sep.becas.SubscrpcionCorreo
       */

        public static java.util.Iterator<gob.sep.becas.SubscrpcionCorreo> listSubscrpcionCorreoByInstituciones(gob.sep.becas.Institucion value)
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
* Gets the EMail property
* @return String with the EMail
*/
    public String getEMail()
    {
        return getSemanticObject().getProperty(becas_subCMail);
    }

/**
* Sets the EMail property
* @param value long with the EMail
*/
    public void setEMail(String value)
    {
        getSemanticObject().setProperty(becas_subCMail, value);
    }

/**
* Gets the SubActivo property
* @return boolean with the SubActivo
*/
    public boolean isSubActivo()
    {
        return getSemanticObject().getBooleanProperty(becas_subActivo);
    }

/**
* Sets the SubActivo property
* @param value long with the SubActivo
*/
    public void setSubActivo(boolean value)
    {
        getSemanticObject().setBooleanProperty(becas_subActivo, value);
    }
   /**
   * Sets the value for the property SubEstado
   * @param value SubEstado to set
   */

    public void setSubEstado(gob.sep.becas.Estado value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(becas_subEstado, value.getSemanticObject());
        }else
        {
            removeSubEstado();
        }
    }
   /**
   * Remove the value for SubEstado property
   */

    public void removeSubEstado()
    {
        getSemanticObject().removeProperty(becas_subEstado);
    }

   /**
   * Gets the SubEstado
   * @return a gob.sep.becas.Estado
   */
    public gob.sep.becas.Estado getSubEstado()
    {
         gob.sep.becas.Estado ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(becas_subEstado);
         if(obj!=null)
         {
             ret=(gob.sep.becas.Estado)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property NivelEducativo
   * @param value NivelEducativo to set
   */

    public void setNivelEducativo(gob.sep.becas.NivelEstudio value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(becas_subCNivelEdu, value.getSemanticObject());
        }else
        {
            removeNivelEducativo();
        }
    }
   /**
   * Remove the value for NivelEducativo property
   */

    public void removeNivelEducativo()
    {
        getSemanticObject().removeProperty(becas_subCNivelEdu);
    }

   /**
   * Gets the NivelEducativo
   * @return a gob.sep.becas.NivelEstudio
   */
    public gob.sep.becas.NivelEstudio getNivelEducativo()
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
   * Sets the value for the property SubMunicipio
   * @param value SubMunicipio to set
   */

    public void setSubMunicipio(gob.sep.becas.Municipio value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(becas_subMunicipio, value.getSemanticObject());
        }else
        {
            removeSubMunicipio();
        }
    }
   /**
   * Remove the value for SubMunicipio property
   */

    public void removeSubMunicipio()
    {
        getSemanticObject().removeProperty(becas_subMunicipio);
    }

   /**
   * Gets the SubMunicipio
   * @return a gob.sep.becas.Municipio
   */
    public gob.sep.becas.Municipio getSubMunicipio()
    {
         gob.sep.becas.Municipio ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(becas_subMunicipio);
         if(obj!=null)
         {
             ret=(gob.sep.becas.Municipio)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property SubCountry
   * @param value SubCountry to set
   */

    public void setSubCountry(org.semanticwb.model.Country value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(becas_subCountry, value.getSemanticObject());
        }else
        {
            removeSubCountry();
        }
    }
   /**
   * Remove the value for SubCountry property
   */

    public void removeSubCountry()
    {
        getSemanticObject().removeProperty(becas_subCountry);
    }

   /**
   * Gets the SubCountry
   * @return a org.semanticwb.model.Country
   */
    public org.semanticwb.model.Country getSubCountry()
    {
         org.semanticwb.model.Country ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(becas_subCountry);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.Country)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the SubSexo property
* @return String with the SubSexo
*/
    public String getSubSexo()
    {
        return getSemanticObject().getProperty(becas_subSexo);
    }

/**
* Sets the SubSexo property
* @param value long with the SubSexo
*/
    public void setSubSexo(String value)
    {
        getSemanticObject().setProperty(becas_subSexo, value);
    }

/**
* Gets the SubRangoEdad property
* @return String with the SubRangoEdad
*/
    public String getSubRangoEdad()
    {
        return getSemanticObject().getProperty(becas_subRangoEdad);
    }

/**
* Sets the SubRangoEdad property
* @param value long with the SubRangoEdad
*/
    public void setSubRangoEdad(String value)
    {
        getSemanticObject().setProperty(becas_subRangoEdad, value);
    }
   /**
   * Gets all the gob.sep.becas.Institucion
   * @return A GenericIterator with all the gob.sep.becas.Institucion
   */

    public org.semanticwb.model.GenericIterator<gob.sep.becas.Institucion> listInstitucioneses()
    {
        return new org.semanticwb.model.GenericIterator<gob.sep.becas.Institucion>(getSemanticObject().listObjectProperties(becas_hasSubCInstitucion));
    }

   /**
   * Gets true if has a Instituciones
   * @param value gob.sep.becas.Institucion to verify
   * @return true if the gob.sep.becas.Institucion exists, false otherwise
   */
    public boolean hasInstituciones(gob.sep.becas.Institucion value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(becas_hasSubCInstitucion,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Instituciones
   * @param value gob.sep.becas.Institucion to add
   */

    public void addInstituciones(gob.sep.becas.Institucion value)
    {
        getSemanticObject().addObjectProperty(becas_hasSubCInstitucion, value.getSemanticObject());
    }
   /**
   * Removes all the Instituciones
   */

    public void removeAllInstituciones()
    {
        getSemanticObject().removeProperty(becas_hasSubCInstitucion);
    }
   /**
   * Removes a Instituciones
   * @param value gob.sep.becas.Institucion to remove
   */

    public void removeInstituciones(gob.sep.becas.Institucion value)
    {
        getSemanticObject().removeObjectProperty(becas_hasSubCInstitucion,value.getSemanticObject());
    }

   /**
   * Gets the Instituciones
   * @return a gob.sep.becas.Institucion
   */
    public gob.sep.becas.Institucion getInstituciones()
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
