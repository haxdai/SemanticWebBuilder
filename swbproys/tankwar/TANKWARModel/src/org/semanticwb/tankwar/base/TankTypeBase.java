package org.semanticwb.tankwar.base;


   /**
   * Tipo de Tanque 
   */
public abstract class TankTypeBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable
{
   /**
   * Clase principal. Es la clase que representa a cada uno de los Tanques
   */
    public static final org.semanticwb.platform.SemanticClass tank_Tank=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/tankwar#Tank");
    public static final org.semanticwb.platform.SemanticProperty tank_hasTanksInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/tankwar#hasTanksInv");
   /**
   * Imagen del tipo de tanque
   */
    public static final org.semanticwb.platform.SemanticProperty tank_tankTypeImage=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/tankwar#tankTypeImage");
   /**
   * Color de Tanque
   */
    public static final org.semanticwb.platform.SemanticProperty tank_tankColor=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/tankwar#tankColor");
   /**
   * Tipo de Tanque
   */
    public static final org.semanticwb.platform.SemanticClass tank_TankType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/tankwar#TankType");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/tankwar#TankType");

    public static class ClassMgr
    {
       /**
       * Returns a list of TankType for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.tankwar.TankType
       */

        public static java.util.Iterator<org.semanticwb.tankwar.TankType> listTankTypes(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.tankwar.TankType>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.tankwar.TankType for all models
       * @return Iterator of org.semanticwb.tankwar.TankType
       */

        public static java.util.Iterator<org.semanticwb.tankwar.TankType> listTankTypes()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.tankwar.TankType>(it, true);
        }

        public static org.semanticwb.tankwar.TankType createTankType(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.tankwar.TankType.ClassMgr.createTankType(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.tankwar.TankType
       * @param id Identifier for org.semanticwb.tankwar.TankType
       * @param model Model of the org.semanticwb.tankwar.TankType
       * @return A org.semanticwb.tankwar.TankType
       */
        public static org.semanticwb.tankwar.TankType getTankType(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.tankwar.TankType)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.tankwar.TankType
       * @param id Identifier for org.semanticwb.tankwar.TankType
       * @param model Model of the org.semanticwb.tankwar.TankType
       * @return A org.semanticwb.tankwar.TankType
       */
        public static org.semanticwb.tankwar.TankType createTankType(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.tankwar.TankType)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.tankwar.TankType
       * @param id Identifier for org.semanticwb.tankwar.TankType
       * @param model Model of the org.semanticwb.tankwar.TankType
       */
        public static void removeTankType(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.tankwar.TankType
       * @param id Identifier for org.semanticwb.tankwar.TankType
       * @param model Model of the org.semanticwb.tankwar.TankType
       * @return true if the org.semanticwb.tankwar.TankType exists, false otherwise
       */

        public static boolean hasTankType(String id, org.semanticwb.model.SWBModel model)
        {
            return (getTankType(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.tankwar.TankType with a determined TanksInv
       * @param value TanksInv of the type org.semanticwb.tankwar.Tank
       * @param model Model of the org.semanticwb.tankwar.TankType
       * @return Iterator with all the org.semanticwb.tankwar.TankType
       */

        public static java.util.Iterator<org.semanticwb.tankwar.TankType> listTankTypeByTanksInv(org.semanticwb.tankwar.Tank value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.tankwar.TankType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(tank_hasTanksInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.tankwar.TankType with a determined TanksInv
       * @param value TanksInv of the type org.semanticwb.tankwar.Tank
       * @return Iterator with all the org.semanticwb.tankwar.TankType
       */

        public static java.util.Iterator<org.semanticwb.tankwar.TankType> listTankTypeByTanksInv(org.semanticwb.tankwar.Tank value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.tankwar.TankType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(tank_hasTanksInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.tankwar.TankType with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.tankwar.TankType
       * @return Iterator with all the org.semanticwb.tankwar.TankType
       */

        public static java.util.Iterator<org.semanticwb.tankwar.TankType> listTankTypeByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.tankwar.TankType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.tankwar.TankType with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.tankwar.TankType
       */

        public static java.util.Iterator<org.semanticwb.tankwar.TankType> listTankTypeByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.tankwar.TankType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.tankwar.TankType with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.tankwar.TankType
       * @return Iterator with all the org.semanticwb.tankwar.TankType
       */

        public static java.util.Iterator<org.semanticwb.tankwar.TankType> listTankTypeByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.tankwar.TankType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.tankwar.TankType with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.tankwar.TankType
       */

        public static java.util.Iterator<org.semanticwb.tankwar.TankType> listTankTypeByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.tankwar.TankType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a TankTypeBase with a SemanticObject
   * @param base The SemanticObject with the properties for the TankType
   */
    public TankTypeBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
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
   * Gets all the org.semanticwb.tankwar.Tank
   * @return A GenericIterator with all the org.semanticwb.tankwar.Tank
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.tankwar.Tank> listTanksInvs()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.tankwar.Tank>(getSemanticObject().listObjectProperties(tank_hasTanksInv));
    }

   /**
   * Gets true if has a TanksInv
   * @param value org.semanticwb.tankwar.Tank to verify
   * @return true if the org.semanticwb.tankwar.Tank exists, false otherwise
   */
    public boolean hasTanksInv(org.semanticwb.tankwar.Tank value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(tank_hasTanksInv,value.getSemanticObject());
        }
        return ret;
    }

   /**
   * Gets the TanksInv
   * @return a org.semanticwb.tankwar.Tank
   */
    public org.semanticwb.tankwar.Tank getTanksInv()
    {
         org.semanticwb.tankwar.Tank ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(tank_hasTanksInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.tankwar.Tank)obj.createGenericInstance();
         }
         return ret;
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
* Gets the TankTypeImage property
* @return String with the TankTypeImage
*/
    public String getTankTypeImage()
    {
        return getSemanticObject().getProperty(tank_tankTypeImage);
    }

/**
* Sets the TankTypeImage property
* @param value long with the TankTypeImage
*/
    public void setTankTypeImage(String value)
    {
        getSemanticObject().setProperty(tank_tankTypeImage, value);
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
* Gets the TankColor property
* @return String with the TankColor
*/
    public String getTankColor()
    {
        return getSemanticObject().getProperty(tank_tankColor);
    }

/**
* Sets the TankColor property
* @param value long with the TankColor
*/
    public void setTankColor(String value)
    {
        getSemanticObject().setProperty(tank_tankColor, value);
    }
}
