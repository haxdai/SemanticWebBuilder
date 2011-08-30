package gob.sep.becas.base;


public abstract class BecariosBase extends org.semanticwb.model.UserTypeDef 
{
    public static final org.semanticwb.platform.SemanticProperty becas_usrEntidadFederativa=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/sep/becas.owl#usrEntidadFederativa");
    public static final org.semanticwb.platform.SemanticProperty becas_usrTelefono=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/sep/becas.owl#usrTelefono");
    public static final org.semanticwb.platform.SemanticProperty becas_usrCURP=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/sep/becas.owl#usrCURP");
    public static final org.semanticwb.platform.SemanticProperty becas_usrCP=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/sep/becas.owl#usrCP");
    public static final org.semanticwb.platform.SemanticProperty becas_usrMunicipio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/sep/becas.owl#usrMunicipio");
    public static final org.semanticwb.platform.SemanticProperty becas_usrExtTel=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/sep/becas.owl#usrExtTel");
    public static final org.semanticwb.platform.SemanticProperty becas_usrFechaNac=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/sep/becas.owl#usrFechaNac");
    public static final org.semanticwb.platform.SemanticProperty becas_usrDireccion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/sep/becas.owl#usrDireccion");
    public static final org.semanticwb.platform.SemanticProperty becas_usrTipoTel=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/sep/becas.owl#usrTipoTel");
    public static final org.semanticwb.platform.SemanticProperty becas_usrClaveTel=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/sep/becas.owl#usrClaveTel");
    public static final org.semanticwb.platform.SemanticProperty becas_usrCveEntidadNac=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/sep/becas.owl#usrCveEntidadNac");
    public static final org.semanticwb.platform.SemanticClass becas_Institucion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/sep/becas.owl#Institucion");
    public static final org.semanticwb.platform.SemanticProperty becas_hasInterestIn=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/sep/becas.owl#hasInterestIn");
    public static final org.semanticwb.platform.SemanticProperty becas_usrColonia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/sep/becas.owl#usrColonia");
    public static final org.semanticwb.platform.SemanticProperty becas_usrSexo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/sep/becas.owl#usrSexo");
    public static final org.semanticwb.platform.SemanticClass becas_NivelEstudio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/sep/becas.owl#NivelEstudio");
    public static final org.semanticwb.platform.SemanticProperty becas_usrNivelEstudios=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/sep/becas.owl#usrNivelEstudios");
    public static final org.semanticwb.platform.SemanticClass becas_Becarios=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/sep/becas.owl#Becarios");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/sep/becas.owl#Becarios");

    public static class ClassMgr
    {
       /**
       * Returns a list of Becarios for a model
       * @param model Model to find
       * @return Iterator of gob.sep.becas.Becarios
       */

        public static java.util.Iterator<gob.sep.becas.Becarios> listBecarioses(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<gob.sep.becas.Becarios>(it, true);
        }
       /**
       * Returns a list of gob.sep.becas.Becarios for all models
       * @return Iterator of gob.sep.becas.Becarios
       */

        public static java.util.Iterator<gob.sep.becas.Becarios> listBecarioses()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<gob.sep.becas.Becarios>(it, true);
        }
       /**
       * Gets a gob.sep.becas.Becarios
       * @param id Identifier for gob.sep.becas.Becarios
       * @param model Model of the gob.sep.becas.Becarios
       * @return A gob.sep.becas.Becarios
       */
        public static gob.sep.becas.Becarios getBecarios(String id, org.semanticwb.model.SWBModel model)
        {
            return (gob.sep.becas.Becarios)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a gob.sep.becas.Becarios
       * @param id Identifier for gob.sep.becas.Becarios
       * @param model Model of the gob.sep.becas.Becarios
       * @return A gob.sep.becas.Becarios
       */
        public static gob.sep.becas.Becarios createBecarios(String id, org.semanticwb.model.SWBModel model)
        {
            return (gob.sep.becas.Becarios)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a gob.sep.becas.Becarios
       * @param id Identifier for gob.sep.becas.Becarios
       * @param model Model of the gob.sep.becas.Becarios
       */
        public static void removeBecarios(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a gob.sep.becas.Becarios
       * @param id Identifier for gob.sep.becas.Becarios
       * @param model Model of the gob.sep.becas.Becarios
       * @return true if the gob.sep.becas.Becarios exists, false otherwise
       */

        public static boolean hasBecarios(String id, org.semanticwb.model.SWBModel model)
        {
            return (getBecarios(id, model)!=null);
        }
       /**
       * Gets all gob.sep.becas.Becarios with a determined InterestIn
       * @param value InterestIn of the type gob.sep.becas.Institucion
       * @param model Model of the gob.sep.becas.Becarios
       * @return Iterator with all the gob.sep.becas.Becarios
       */

        public static java.util.Iterator<gob.sep.becas.Becarios> listBecariosByInterestIn(gob.sep.becas.Institucion value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<gob.sep.becas.Becarios> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(becas_hasInterestIn, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all gob.sep.becas.Becarios with a determined InterestIn
       * @param value InterestIn of the type gob.sep.becas.Institucion
       * @return Iterator with all the gob.sep.becas.Becarios
       */

        public static java.util.Iterator<gob.sep.becas.Becarios> listBecariosByInterestIn(gob.sep.becas.Institucion value)
        {
            org.semanticwb.model.GenericIterator<gob.sep.becas.Becarios> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(becas_hasInterestIn,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all gob.sep.becas.Becarios with a determined UsrNivelEstudios
       * @param value UsrNivelEstudios of the type gob.sep.becas.NivelEstudio
       * @param model Model of the gob.sep.becas.Becarios
       * @return Iterator with all the gob.sep.becas.Becarios
       */

        public static java.util.Iterator<gob.sep.becas.Becarios> listBecariosByUsrNivelEstudios(gob.sep.becas.NivelEstudio value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<gob.sep.becas.Becarios> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(becas_usrNivelEstudios, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all gob.sep.becas.Becarios with a determined UsrNivelEstudios
       * @param value UsrNivelEstudios of the type gob.sep.becas.NivelEstudio
       * @return Iterator with all the gob.sep.becas.Becarios
       */

        public static java.util.Iterator<gob.sep.becas.Becarios> listBecariosByUsrNivelEstudios(gob.sep.becas.NivelEstudio value)
        {
            org.semanticwb.model.GenericIterator<gob.sep.becas.Becarios> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(becas_usrNivelEstudios,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a BecariosBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Becarios
   */
    public BecariosBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the UsrEntidadFederativa property
* @return String with the UsrEntidadFederativa
*/
    public String getUsrEntidadFederativa()
    {
        return getSemanticObject().getProperty(becas_usrEntidadFederativa);
    }

/**
* Sets the UsrEntidadFederativa property
* @param value long with the UsrEntidadFederativa
*/
    public void setUsrEntidadFederativa(String value)
    {
        getSemanticObject().setProperty(becas_usrEntidadFederativa, value);
    }

/**
* Gets the UsrTelefono property
* @return String with the UsrTelefono
*/
    public String getUsrTelefono()
    {
        return getSemanticObject().getProperty(becas_usrTelefono);
    }

/**
* Sets the UsrTelefono property
* @param value long with the UsrTelefono
*/
    public void setUsrTelefono(String value)
    {
        getSemanticObject().setProperty(becas_usrTelefono, value);
    }

/**
* Gets the UsrCURP property
* @return String with the UsrCURP
*/
    public String getUsrCURP()
    {
        return getSemanticObject().getProperty(becas_usrCURP);
    }

/**
* Sets the UsrCURP property
* @param value long with the UsrCURP
*/
    public void setUsrCURP(String value)
    {
        getSemanticObject().setProperty(becas_usrCURP, value);
    }

/**
* Gets the UsrCP property
* @return String with the UsrCP
*/
    public String getUsrCP()
    {
        return getSemanticObject().getProperty(becas_usrCP);
    }

/**
* Sets the UsrCP property
* @param value long with the UsrCP
*/
    public void setUsrCP(String value)
    {
        getSemanticObject().setProperty(becas_usrCP, value);
    }

/**
* Gets the UsrMunicipio property
* @return String with the UsrMunicipio
*/
    public String getUsrMunicipio()
    {
        return getSemanticObject().getProperty(becas_usrMunicipio);
    }

/**
* Sets the UsrMunicipio property
* @param value long with the UsrMunicipio
*/
    public void setUsrMunicipio(String value)
    {
        getSemanticObject().setProperty(becas_usrMunicipio, value);
    }

/**
* Gets the UsrExtTel property
* @return String with the UsrExtTel
*/
    public String getUsrExtTel()
    {
        return getSemanticObject().getProperty(becas_usrExtTel);
    }

/**
* Sets the UsrExtTel property
* @param value long with the UsrExtTel
*/
    public void setUsrExtTel(String value)
    {
        getSemanticObject().setProperty(becas_usrExtTel, value);
    }

/**
* Gets the UsrFechaNac property
* @return String with the UsrFechaNac
*/
    public String getUsrFechaNac()
    {
        return getSemanticObject().getProperty(becas_usrFechaNac);
    }

/**
* Sets the UsrFechaNac property
* @param value long with the UsrFechaNac
*/
    public void setUsrFechaNac(String value)
    {
        getSemanticObject().setProperty(becas_usrFechaNac, value);
    }

/**
* Gets the UsrDireccion property
* @return String with the UsrDireccion
*/
    public String getUsrDireccion()
    {
        return getSemanticObject().getProperty(becas_usrDireccion);
    }

/**
* Sets the UsrDireccion property
* @param value long with the UsrDireccion
*/
    public void setUsrDireccion(String value)
    {
        getSemanticObject().setProperty(becas_usrDireccion, value);
    }

/**
* Gets the UsrTipoTel property
* @return String with the UsrTipoTel
*/
    public String getUsrTipoTel()
    {
        return getSemanticObject().getProperty(becas_usrTipoTel);
    }

/**
* Sets the UsrTipoTel property
* @param value long with the UsrTipoTel
*/
    public void setUsrTipoTel(String value)
    {
        getSemanticObject().setProperty(becas_usrTipoTel, value);
    }

/**
* Gets the UsrClaveTel property
* @return String with the UsrClaveTel
*/
    public String getUsrClaveTel()
    {
        return getSemanticObject().getProperty(becas_usrClaveTel);
    }

/**
* Sets the UsrClaveTel property
* @param value long with the UsrClaveTel
*/
    public void setUsrClaveTel(String value)
    {
        getSemanticObject().setProperty(becas_usrClaveTel, value);
    }

/**
* Gets the UsrCveEntidadNac property
* @return String with the UsrCveEntidadNac
*/
    public String getUsrCveEntidadNac()
    {
        return getSemanticObject().getProperty(becas_usrCveEntidadNac);
    }

/**
* Sets the UsrCveEntidadNac property
* @param value long with the UsrCveEntidadNac
*/
    public void setUsrCveEntidadNac(String value)
    {
        getSemanticObject().setProperty(becas_usrCveEntidadNac, value);
    }
   /**
   * Gets all the gob.sep.becas.Institucion
   * @return A GenericIterator with all the gob.sep.becas.Institucion
   */

    public org.semanticwb.model.GenericIterator<gob.sep.becas.Institucion> listInterestIns()
    {
        return new org.semanticwb.model.GenericIterator<gob.sep.becas.Institucion>(getSemanticObject().listObjectProperties(becas_hasInterestIn));
    }

   /**
   * Gets true if has a InterestIn
   * @param value gob.sep.becas.Institucion to verify
   * @return true if the gob.sep.becas.Institucion exists, false otherwise
   */
    public boolean hasInterestIn(gob.sep.becas.Institucion value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(becas_hasInterestIn,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a InterestIn
   * @param value gob.sep.becas.Institucion to add
   */

    public void addInterestIn(gob.sep.becas.Institucion value)
    {
        getSemanticObject().addObjectProperty(becas_hasInterestIn, value.getSemanticObject());
    }
   /**
   * Removes all the InterestIn
   */

    public void removeAllInterestIn()
    {
        getSemanticObject().removeProperty(becas_hasInterestIn);
    }
   /**
   * Removes a InterestIn
   * @param value gob.sep.becas.Institucion to remove
   */

    public void removeInterestIn(gob.sep.becas.Institucion value)
    {
        getSemanticObject().removeObjectProperty(becas_hasInterestIn,value.getSemanticObject());
    }

   /**
   * Gets the InterestIn
   * @return a gob.sep.becas.Institucion
   */
    public gob.sep.becas.Institucion getInterestIn()
    {
         gob.sep.becas.Institucion ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(becas_hasInterestIn);
         if(obj!=null)
         {
             ret=(gob.sep.becas.Institucion)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the UsrColonia property
* @return String with the UsrColonia
*/
    public String getUsrColonia()
    {
        return getSemanticObject().getProperty(becas_usrColonia);
    }

/**
* Sets the UsrColonia property
* @param value long with the UsrColonia
*/
    public void setUsrColonia(String value)
    {
        getSemanticObject().setProperty(becas_usrColonia, value);
    }

/**
* Gets the UsrSexo property
* @return String with the UsrSexo
*/
    public String getUsrSexo()
    {
        return getSemanticObject().getProperty(becas_usrSexo);
    }

/**
* Sets the UsrSexo property
* @param value long with the UsrSexo
*/
    public void setUsrSexo(String value)
    {
        getSemanticObject().setProperty(becas_usrSexo, value);
    }
   /**
   * Sets the value for the property UsrNivelEstudios
   * @param value UsrNivelEstudios to set
   */

    public void setUsrNivelEstudios(gob.sep.becas.NivelEstudio value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(becas_usrNivelEstudios, value.getSemanticObject());
        }else
        {
            removeUsrNivelEstudios();
        }
    }
   /**
   * Remove the value for UsrNivelEstudios property
   */

    public void removeUsrNivelEstudios()
    {
        getSemanticObject().removeProperty(becas_usrNivelEstudios);
    }

   /**
   * Gets the UsrNivelEstudios
   * @return a gob.sep.becas.NivelEstudio
   */
    public gob.sep.becas.NivelEstudio getUsrNivelEstudios()
    {
         gob.sep.becas.NivelEstudio ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(becas_usrNivelEstudios);
         if(obj!=null)
         {
             ret=(gob.sep.becas.NivelEstudio)obj.createGenericInstance();
         }
         return ret;
    }
}
