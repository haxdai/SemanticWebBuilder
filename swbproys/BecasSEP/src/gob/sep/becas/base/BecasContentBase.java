package gob.sep.becas.base;


public abstract class BecasContentBase extends org.semanticwb.portal.resources.sem.HTMLContent implements org.semanticwb.model.Versionable,org.semanticwb.model.ResourceVersionable
{
    public static final org.semanticwb.platform.SemanticProperty becas_bcFechaFinConvocatoria=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/sep/becas.owl#bcFechaFinConvocatoria");
    public static final org.semanticwb.platform.SemanticClass swb_VersionInfo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#VersionInfo");
    public static final org.semanticwb.platform.SemanticProperty swb_actualVersion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#actualVersion");
    public static final org.semanticwb.platform.SemanticClass becas_Genero=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/sep/becas.owl#Genero");
    public static final org.semanticwb.platform.SemanticProperty becas_bcGenero=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/sep/becas.owl#bcGenero");
    public static final org.semanticwb.platform.SemanticProperty becas_bcFechaIniConvocatoria=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/sep/becas.owl#bcFechaIniConvocatoria");
    public static final org.semanticwb.platform.SemanticClass swb_Resource=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#Resource");
    public static final org.semanticwb.platform.SemanticProperty swb_semanticResourceInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#semanticResourceInv");
    public static final org.semanticwb.platform.SemanticProperty swbres_nextLinkText=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/resource/ontology#nextLinkText");
    public static final org.semanticwb.platform.SemanticProperty swbres_contentPaginated=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/resource/ontology#contentPaginated");
    public static final org.semanticwb.platform.SemanticClass becas_Institucion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/sep/becas.owl#Institucion");
    public static final org.semanticwb.platform.SemanticProperty becas_bcInstitucion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/sep/becas.owl#bcInstitucion");
    public static final org.semanticwb.platform.SemanticClass becas_NivelEstudio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/sep/becas.owl#NivelEstudio");
    public static final org.semanticwb.platform.SemanticProperty becas_bcNivelEstudios=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/sep/becas.owl#bcNivelEstudios");
    public static final org.semanticwb.platform.SemanticProperty swbres_formerLinkText=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/resource/ontology#formerLinkText");
    public static final org.semanticwb.platform.SemanticProperty swbres_deleteStyles=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/resource/ontology#deleteStyles");
    public static final org.semanticwb.platform.SemanticProperty swbres_fontStyle=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/resource/ontology#fontStyle");
    public static final org.semanticwb.platform.SemanticProperty swb_lastVersion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#lastVersion");
    public static final org.semanticwb.platform.SemanticClass becas_BecasContent=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/sep/becas.owl#BecasContent");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/sep/becas.owl#BecasContent");

    public BecasContentBase()
    {
    }

   /**
   * Constructs a BecasContentBase with a SemanticObject
   * @param base The SemanticObject with the properties for the BecasContent
   */
    public BecasContentBase(org.semanticwb.platform.SemanticObject base)
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
* Gets the BcFechaFinConvocatoria property
* @return java.util.Date with the BcFechaFinConvocatoria
*/
    public java.util.Date getBcFechaFinConvocatoria()
    {
        return getSemanticObject().getDateProperty(becas_bcFechaFinConvocatoria);
    }

/**
* Sets the BcFechaFinConvocatoria property
* @param value long with the BcFechaFinConvocatoria
*/
    public void setBcFechaFinConvocatoria(java.util.Date value)
    {
        getSemanticObject().setDateProperty(becas_bcFechaFinConvocatoria, value);
    }
   /**
   * Sets the value for the property ActualVersion
   * @param value ActualVersion to set
   */

    public void setActualVersion(org.semanticwb.model.VersionInfo value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(swb_actualVersion, value.getSemanticObject());
        }else
        {
            removeActualVersion();
        }
    }
   /**
   * Remove the value for ActualVersion property
   */

    public void removeActualVersion()
    {
        getSemanticObject().removeProperty(swb_actualVersion);
    }

   /**
   * Gets the ActualVersion
   * @return a org.semanticwb.model.VersionInfo
   */
    public org.semanticwb.model.VersionInfo getActualVersion()
    {
         org.semanticwb.model.VersionInfo ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_actualVersion);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.VersionInfo)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property BcGenero
   * @param value BcGenero to set
   */

    public void setBcGenero(gob.sep.becas.Genero value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(becas_bcGenero, value.getSemanticObject());
        }else
        {
            removeBcGenero();
        }
    }
   /**
   * Remove the value for BcGenero property
   */

    public void removeBcGenero()
    {
        getSemanticObject().removeProperty(becas_bcGenero);
    }

   /**
   * Gets the BcGenero
   * @return a gob.sep.becas.Genero
   */
    public gob.sep.becas.Genero getBcGenero()
    {
         gob.sep.becas.Genero ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(becas_bcGenero);
         if(obj!=null)
         {
             ret=(gob.sep.becas.Genero)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the BcFechaIniConvocatoria property
* @return java.util.Date with the BcFechaIniConvocatoria
*/
    public java.util.Date getBcFechaIniConvocatoria()
    {
        return getSemanticObject().getDateProperty(becas_bcFechaIniConvocatoria);
    }

/**
* Sets the BcFechaIniConvocatoria property
* @param value long with the BcFechaIniConvocatoria
*/
    public void setBcFechaIniConvocatoria(java.util.Date value)
    {
        getSemanticObject().setDateProperty(becas_bcFechaIniConvocatoria, value);
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
* Gets the NextLinkText property
* @return String with the NextLinkText
*/
    public String getNextLinkText()
    {
        return getSemanticObject().getProperty(swbres_nextLinkText);
    }

/**
* Sets the NextLinkText property
* @param value long with the NextLinkText
*/
    public void setNextLinkText(String value)
    {
        getSemanticObject().setProperty(swbres_nextLinkText, value);
    }

/**
* Gets the ContentPaginated property
* @return boolean with the ContentPaginated
*/
    public boolean isContentPaginated()
    {
        return getSemanticObject().getBooleanProperty(swbres_contentPaginated);
    }

/**
* Sets the ContentPaginated property
* @param value long with the ContentPaginated
*/
    public void setContentPaginated(boolean value)
    {
        getSemanticObject().setBooleanProperty(swbres_contentPaginated, value);
    }
   /**
   * Sets the value for the property BcInstitucion
   * @param value BcInstitucion to set
   */

    public void setBcInstitucion(gob.sep.becas.Institucion value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(becas_bcInstitucion, value.getSemanticObject());
        }else
        {
            removeBcInstitucion();
        }
    }
   /**
   * Remove the value for BcInstitucion property
   */

    public void removeBcInstitucion()
    {
        getSemanticObject().removeProperty(becas_bcInstitucion);
    }

   /**
   * Gets the BcInstitucion
   * @return a gob.sep.becas.Institucion
   */
    public gob.sep.becas.Institucion getBcInstitucion()
    {
         gob.sep.becas.Institucion ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(becas_bcInstitucion);
         if(obj!=null)
         {
             ret=(gob.sep.becas.Institucion)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property BcNivelEstudios
   * @param value BcNivelEstudios to set
   */

    public void setBcNivelEstudios(gob.sep.becas.NivelEstudio value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(becas_bcNivelEstudios, value.getSemanticObject());
        }else
        {
            removeBcNivelEstudios();
        }
    }
   /**
   * Remove the value for BcNivelEstudios property
   */

    public void removeBcNivelEstudios()
    {
        getSemanticObject().removeProperty(becas_bcNivelEstudios);
    }

   /**
   * Gets the BcNivelEstudios
   * @return a gob.sep.becas.NivelEstudio
   */
    public gob.sep.becas.NivelEstudio getBcNivelEstudios()
    {
         gob.sep.becas.NivelEstudio ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(becas_bcNivelEstudios);
         if(obj!=null)
         {
             ret=(gob.sep.becas.NivelEstudio)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the FormerLinkText property
* @return String with the FormerLinkText
*/
    public String getFormerLinkText()
    {
        return getSemanticObject().getProperty(swbres_formerLinkText);
    }

/**
* Sets the FormerLinkText property
* @param value long with the FormerLinkText
*/
    public void setFormerLinkText(String value)
    {
        getSemanticObject().setProperty(swbres_formerLinkText, value);
    }

/**
* Gets the DeleteStyles property
* @return boolean with the DeleteStyles
*/
    public boolean isDeleteStyles()
    {
        return getSemanticObject().getBooleanProperty(swbres_deleteStyles);
    }

/**
* Sets the DeleteStyles property
* @param value long with the DeleteStyles
*/
    public void setDeleteStyles(boolean value)
    {
        getSemanticObject().setBooleanProperty(swbres_deleteStyles, value);
    }

/**
* Gets the FontStyle property
* @return String with the FontStyle
*/
    public String getFontStyle()
    {
        return getSemanticObject().getProperty(swbres_fontStyle);
    }

/**
* Sets the FontStyle property
* @param value long with the FontStyle
*/
    public void setFontStyle(String value)
    {
        getSemanticObject().setProperty(swbres_fontStyle, value);
    }
   /**
   * Sets the value for the property LastVersion
   * @param value LastVersion to set
   */

    public void setLastVersion(org.semanticwb.model.VersionInfo value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(swb_lastVersion, value.getSemanticObject());
        }else
        {
            removeLastVersion();
        }
    }
   /**
   * Remove the value for LastVersion property
   */

    public void removeLastVersion()
    {
        getSemanticObject().removeProperty(swb_lastVersion);
    }

   /**
   * Gets the LastVersion
   * @return a org.semanticwb.model.VersionInfo
   */
    public org.semanticwb.model.VersionInfo getLastVersion()
    {
         org.semanticwb.model.VersionInfo ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_lastVersion);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.VersionInfo)obj.createGenericInstance();
         }
         return ret;
    }
}
