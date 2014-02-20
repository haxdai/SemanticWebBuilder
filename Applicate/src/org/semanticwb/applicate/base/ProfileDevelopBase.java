package org.semanticwb.applicate.base;


public abstract class ProfileDevelopBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticProperty app_pais=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/applicate#pais");
    public static final org.semanticwb.platform.SemanticProperty app_suscripcion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/applicate#suscripcion");
   /**
   * Un usuario es una persona que tiene relación con el portal a través de un método de acceso.
   */
    public static final org.semanticwb.platform.SemanticClass swb_User=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#User");
    public static final org.semanticwb.platform.SemanticProperty app_userProfileDevelop=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/applicate#userProfileDevelop");
    public static final org.semanticwb.platform.SemanticProperty app_imagenProfileDevelop=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/applicate#imagenProfileDevelop");
    public static final org.semanticwb.platform.SemanticProperty app_fechanacimiento=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/applicate#fechanacimiento");
    public static final org.semanticwb.platform.SemanticProperty app_genero=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/applicate#genero");
    public static final org.semanticwb.platform.SemanticProperty app_hasAreasExpertiseDevelop=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/applicate#hasAreasExpertiseDevelop");
    public static final org.semanticwb.platform.SemanticProperty app_estado=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/applicate#estado");
    public static final org.semanticwb.platform.SemanticProperty app_bio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/applicate#bio");
    public static final org.semanticwb.platform.SemanticClass app_ProfileDevelop=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://org.semanticwb.resources/applicate#ProfileDevelop");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://org.semanticwb.resources/applicate#ProfileDevelop");

    public static class ClassMgr
    {
       /**
       * Returns a list of ProfileDevelop for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.applicate.ProfileDevelop
       */

        public static java.util.Iterator<org.semanticwb.applicate.ProfileDevelop> listProfileDevelops(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.applicate.ProfileDevelop>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.applicate.ProfileDevelop for all models
       * @return Iterator of org.semanticwb.applicate.ProfileDevelop
       */

        public static java.util.Iterator<org.semanticwb.applicate.ProfileDevelop> listProfileDevelops()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.applicate.ProfileDevelop>(it, true);
        }

        public static org.semanticwb.applicate.ProfileDevelop createProfileDevelop(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.applicate.ProfileDevelop.ClassMgr.createProfileDevelop(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.applicate.ProfileDevelop
       * @param id Identifier for org.semanticwb.applicate.ProfileDevelop
       * @param model Model of the org.semanticwb.applicate.ProfileDevelop
       * @return A org.semanticwb.applicate.ProfileDevelop
       */
        public static org.semanticwb.applicate.ProfileDevelop getProfileDevelop(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.applicate.ProfileDevelop)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.applicate.ProfileDevelop
       * @param id Identifier for org.semanticwb.applicate.ProfileDevelop
       * @param model Model of the org.semanticwb.applicate.ProfileDevelop
       * @return A org.semanticwb.applicate.ProfileDevelop
       */
        public static org.semanticwb.applicate.ProfileDevelop createProfileDevelop(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.applicate.ProfileDevelop)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.applicate.ProfileDevelop
       * @param id Identifier for org.semanticwb.applicate.ProfileDevelop
       * @param model Model of the org.semanticwb.applicate.ProfileDevelop
       */
        public static void removeProfileDevelop(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.applicate.ProfileDevelop
       * @param id Identifier for org.semanticwb.applicate.ProfileDevelop
       * @param model Model of the org.semanticwb.applicate.ProfileDevelop
       * @return true if the org.semanticwb.applicate.ProfileDevelop exists, false otherwise
       */

        public static boolean hasProfileDevelop(String id, org.semanticwb.model.SWBModel model)
        {
            return (getProfileDevelop(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.applicate.ProfileDevelop with a determined UserProfileDevelop
       * @param value UserProfileDevelop of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.applicate.ProfileDevelop
       * @return Iterator with all the org.semanticwb.applicate.ProfileDevelop
       */

        public static java.util.Iterator<org.semanticwb.applicate.ProfileDevelop> listProfileDevelopByUserProfileDevelop(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.applicate.ProfileDevelop> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(app_userProfileDevelop, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.applicate.ProfileDevelop with a determined UserProfileDevelop
       * @param value UserProfileDevelop of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.applicate.ProfileDevelop
       */

        public static java.util.Iterator<org.semanticwb.applicate.ProfileDevelop> listProfileDevelopByUserProfileDevelop(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.applicate.ProfileDevelop> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(app_userProfileDevelop,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static ProfileDevelopBase.ClassMgr getProfileDevelopClassMgr()
    {
        return new ProfileDevelopBase.ClassMgr();
    }

   /**
   * Constructs a ProfileDevelopBase with a SemanticObject
   * @param base The SemanticObject with the properties for the ProfileDevelop
   */
    public ProfileDevelopBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the Pais property
* @return String with the Pais
*/
    public String getPais()
    {
        return getSemanticObject().getProperty(app_pais);
    }

/**
* Sets the Pais property
* @param value long with the Pais
*/
    public void setPais(String value)
    {
        getSemanticObject().setProperty(app_pais, value);
    }

/**
* Gets the Suscripcion property
* @return boolean with the Suscripcion
*/
    public boolean isSuscripcion()
    {
        return getSemanticObject().getBooleanProperty(app_suscripcion);
    }

/**
* Sets the Suscripcion property
* @param value long with the Suscripcion
*/
    public void setSuscripcion(boolean value)
    {
        getSemanticObject().setBooleanProperty(app_suscripcion, value);
    }
   /**
   * Sets the value for the property UserProfileDevelop
   * @param value UserProfileDevelop to set
   */

    public void setUserProfileDevelop(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(app_userProfileDevelop, value.getSemanticObject());
        }else
        {
            removeUserProfileDevelop();
        }
    }
   /**
   * Remove the value for UserProfileDevelop property
   */

    public void removeUserProfileDevelop()
    {
        getSemanticObject().removeProperty(app_userProfileDevelop);
    }

   /**
   * Gets the UserProfileDevelop
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getUserProfileDevelop()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(app_userProfileDevelop);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the ImagenProfileDevelop property
* @return String with the ImagenProfileDevelop
*/
    public String getImagenProfileDevelop()
    {
        return getSemanticObject().getProperty(app_imagenProfileDevelop);
    }

/**
* Sets the ImagenProfileDevelop property
* @param value long with the ImagenProfileDevelop
*/
    public void setImagenProfileDevelop(String value)
    {
        getSemanticObject().setProperty(app_imagenProfileDevelop, value);
    }

/**
* Gets the Fechanacimiento property
* @return java.util.Date with the Fechanacimiento
*/
    public java.util.Date getFechanacimiento()
    {
        return getSemanticObject().getDateProperty(app_fechanacimiento);
    }

/**
* Sets the Fechanacimiento property
* @param value long with the Fechanacimiento
*/
    public void setFechanacimiento(java.util.Date value)
    {
        getSemanticObject().setDateProperty(app_fechanacimiento, value);
    }

/**
* Gets the Genero property
* @return String with the Genero
*/
    public String getGenero()
    {
        return getSemanticObject().getProperty(app_genero);
    }

/**
* Sets the Genero property
* @param value long with the Genero
*/
    public void setGenero(String value)
    {
        getSemanticObject().setProperty(app_genero, value);
    }

    public java.util.Iterator<String> listAreasExpertiseDevelops()
    {
        java.util.ArrayList<String> values=new java.util.ArrayList<String>();
        java.util.Iterator<org.semanticwb.platform.SemanticLiteral> it=getSemanticObject().listLiteralProperties(app_hasAreasExpertiseDevelop);
        while(it.hasNext())
        {
                org.semanticwb.platform.SemanticLiteral literal=it.next();
                values.add(literal.getString());
        }
        return values.iterator();
    }

    public void addAreasExpertiseDevelop(String value)
    {
        getSemanticObject().addLiteralProperty(app_hasAreasExpertiseDevelop, new org.semanticwb.platform.SemanticLiteral(value));
    }

    public void removeAllAreasExpertiseDevelop()
    {
        getSemanticObject().removeProperty(app_hasAreasExpertiseDevelop);
    }

    public void removeAreasExpertiseDevelop(String value)
    {
        getSemanticObject().removeLiteralProperty(app_hasAreasExpertiseDevelop,new org.semanticwb.platform.SemanticLiteral(value));
    }

/**
* Gets the Estado property
* @return String with the Estado
*/
    public String getEstado()
    {
        return getSemanticObject().getProperty(app_estado);
    }

/**
* Sets the Estado property
* @param value long with the Estado
*/
    public void setEstado(String value)
    {
        getSemanticObject().setProperty(app_estado, value);
    }

/**
* Gets the Bio property
* @return String with the Bio
*/
    public String getBio()
    {
        return getSemanticObject().getProperty(app_bio);
    }

/**
* Sets the Bio property
* @param value long with the Bio
*/
    public void setBio(String value)
    {
        getSemanticObject().setProperty(app_bio, value);
    }
}
