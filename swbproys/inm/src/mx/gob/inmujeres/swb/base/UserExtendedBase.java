package mx.gob.inmujeres.swb.base;


public abstract class UserExtendedBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticProperty inm_extensionUser=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#extensionUser");
    public static final org.semanticwb.platform.SemanticProperty inm_level=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#level");
    public static final org.semanticwb.platform.SemanticProperty inm_noEmpleado=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#noEmpleado");
    public static final org.semanticwb.platform.SemanticProperty inm_areaAdscripcion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#areaAdscripcion");
    public static final org.semanticwb.platform.SemanticProperty inm_puesto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#puesto");
    public static final org.semanticwb.platform.SemanticProperty inm_rfc=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#rfc");
    public static final org.semanticwb.platform.SemanticProperty inm_area=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#area");
   /**
   * Un usuario es una persona que tiene relación con el portal a través de un método de acceso.
   */
    public static final org.semanticwb.platform.SemanticClass swb_User=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#User");
    public static final org.semanticwb.platform.SemanticProperty inm_hasSubordinado=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#hasSubordinado");
    public static final org.semanticwb.platform.SemanticClass inm_UserExtended=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#UserExtended");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#UserExtended");

    public static class ClassMgr
    {
       /**
       * Returns a list of UserExtended for a model
       * @param model Model to find
       * @return Iterator of mx.gob.inmujeres.swb.UserExtended
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.UserExtended> listUserExtendeds(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.UserExtended>(it, true);
        }
       /**
       * Returns a list of mx.gob.inmujeres.swb.UserExtended for all models
       * @return Iterator of mx.gob.inmujeres.swb.UserExtended
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.UserExtended> listUserExtendeds()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.UserExtended>(it, true);
        }

        public static mx.gob.inmujeres.swb.UserExtended createUserExtended(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return mx.gob.inmujeres.swb.UserExtended.ClassMgr.createUserExtended(String.valueOf(id), model);
        }
       /**
       * Gets a mx.gob.inmujeres.swb.UserExtended
       * @param id Identifier for mx.gob.inmujeres.swb.UserExtended
       * @param model Model of the mx.gob.inmujeres.swb.UserExtended
       * @return A mx.gob.inmujeres.swb.UserExtended
       */
        public static mx.gob.inmujeres.swb.UserExtended getUserExtended(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.gob.inmujeres.swb.UserExtended)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a mx.gob.inmujeres.swb.UserExtended
       * @param id Identifier for mx.gob.inmujeres.swb.UserExtended
       * @param model Model of the mx.gob.inmujeres.swb.UserExtended
       * @return A mx.gob.inmujeres.swb.UserExtended
       */
        public static mx.gob.inmujeres.swb.UserExtended createUserExtended(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.gob.inmujeres.swb.UserExtended)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a mx.gob.inmujeres.swb.UserExtended
       * @param id Identifier for mx.gob.inmujeres.swb.UserExtended
       * @param model Model of the mx.gob.inmujeres.swb.UserExtended
       */
        public static void removeUserExtended(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a mx.gob.inmujeres.swb.UserExtended
       * @param id Identifier for mx.gob.inmujeres.swb.UserExtended
       * @param model Model of the mx.gob.inmujeres.swb.UserExtended
       * @return true if the mx.gob.inmujeres.swb.UserExtended exists, false otherwise
       */

        public static boolean hasUserExtended(String id, org.semanticwb.model.SWBModel model)
        {
            return (getUserExtended(id, model)!=null);
        }
       /**
       * Gets all mx.gob.inmujeres.swb.UserExtended with a determined Subordinado
       * @param value Subordinado of the type org.semanticwb.model.User
       * @param model Model of the mx.gob.inmujeres.swb.UserExtended
       * @return Iterator with all the mx.gob.inmujeres.swb.UserExtended
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.UserExtended> listUserExtendedBySubordinado(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.UserExtended> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_hasSubordinado, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.UserExtended with a determined Subordinado
       * @param value Subordinado of the type org.semanticwb.model.User
       * @return Iterator with all the mx.gob.inmujeres.swb.UserExtended
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.UserExtended> listUserExtendedBySubordinado(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.UserExtended> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_hasSubordinado,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static UserExtendedBase.ClassMgr getUserExtendedClassMgr()
    {
        return new UserExtendedBase.ClassMgr();
    }

   /**
   * Constructs a UserExtendedBase with a SemanticObject
   * @param base The SemanticObject with the properties for the UserExtended
   */
    public UserExtendedBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the ExtensionUser property
* @return String with the ExtensionUser
*/
    public String getExtensionUser()
    {
        return getSemanticObject().getProperty(inm_extensionUser);
    }

/**
* Sets the ExtensionUser property
* @param value long with the ExtensionUser
*/
    public void setExtensionUser(String value)
    {
        getSemanticObject().setProperty(inm_extensionUser, value);
    }

/**
* Gets the Level property
* @return String with the Level
*/
    public String getLevel()
    {
        return getSemanticObject().getProperty(inm_level);
    }

/**
* Sets the Level property
* @param value long with the Level
*/
    public void setLevel(String value)
    {
        getSemanticObject().setProperty(inm_level, value);
    }

/**
* Gets the NoEmpleado property
* @return String with the NoEmpleado
*/
    public String getNoEmpleado()
    {
        return getSemanticObject().getProperty(inm_noEmpleado);
    }

/**
* Sets the NoEmpleado property
* @param value long with the NoEmpleado
*/
    public void setNoEmpleado(String value)
    {
        getSemanticObject().setProperty(inm_noEmpleado, value);
    }

/**
* Gets the AreaAdscripcion property
* @return String with the AreaAdscripcion
*/
    public String getAreaAdscripcion()
    {
        return getSemanticObject().getProperty(inm_areaAdscripcion);
    }

/**
* Sets the AreaAdscripcion property
* @param value long with the AreaAdscripcion
*/
    public void setAreaAdscripcion(String value)
    {
        getSemanticObject().setProperty(inm_areaAdscripcion, value);
    }

/**
* Gets the Puesto property
* @return String with the Puesto
*/
    public String getPuesto()
    {
        return getSemanticObject().getProperty(inm_puesto);
    }

/**
* Sets the Puesto property
* @param value long with the Puesto
*/
    public void setPuesto(String value)
    {
        getSemanticObject().setProperty(inm_puesto, value);
    }

/**
* Gets the Rfc property
* @return String with the Rfc
*/
    public String getRfc()
    {
        return getSemanticObject().getProperty(inm_rfc);
    }

/**
* Sets the Rfc property
* @param value long with the Rfc
*/
    public void setRfc(String value)
    {
        getSemanticObject().setProperty(inm_rfc, value);
    }

/**
* Gets the Area property
* @return String with the Area
*/
    public String getArea()
    {
        return getSemanticObject().getProperty(inm_area);
    }

/**
* Sets the Area property
* @param value long with the Area
*/
    public void setArea(String value)
    {
        getSemanticObject().setProperty(inm_area, value);
    }
   /**
   * Gets all the org.semanticwb.model.User
   * @return A GenericIterator with all the org.semanticwb.model.User
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.model.User> listSubordinados()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.User>(getSemanticObject().listObjectProperties(inm_hasSubordinado));
    }

   /**
   * Gets true if has a Subordinado
   * @param value org.semanticwb.model.User to verify
   * @return true if the org.semanticwb.model.User exists, false otherwise
   */
    public boolean hasSubordinado(org.semanticwb.model.User value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(inm_hasSubordinado,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Subordinado
   * @param value org.semanticwb.model.User to add
   */

    public void addSubordinado(org.semanticwb.model.User value)
    {
        getSemanticObject().addObjectProperty(inm_hasSubordinado, value.getSemanticObject());
    }
   /**
   * Removes all the Subordinado
   */

    public void removeAllSubordinado()
    {
        getSemanticObject().removeProperty(inm_hasSubordinado);
    }
   /**
   * Removes a Subordinado
   * @param value org.semanticwb.model.User to remove
   */

    public void removeSubordinado(org.semanticwb.model.User value)
    {
        getSemanticObject().removeObjectProperty(inm_hasSubordinado,value.getSemanticObject());
    }

   /**
   * Gets the Subordinado
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getSubordinado()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_hasSubordinado);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }
}
