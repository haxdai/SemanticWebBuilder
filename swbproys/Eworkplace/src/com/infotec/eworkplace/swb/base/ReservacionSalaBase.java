package com.infotec.eworkplace.swb.base;


public abstract class ReservacionSalaBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Traceable
{
   /**
   * Un usuario es una persona que tiene relación con el portal a través de un método de acceso.
   */
    public static final org.semanticwb.platform.SemanticClass swb_User=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#User");
    public static final org.semanticwb.platform.SemanticProperty intranet_responsable=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#responsable");
    public static final org.semanticwb.platform.SemanticProperty intranet_de=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#de");
    public static final org.semanticwb.platform.SemanticProperty intranet_fecha=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#fecha");
    public static final org.semanticwb.platform.SemanticProperty intranet_a=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#a");
    public static final org.semanticwb.platform.SemanticClass intranet_Sala=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Sala");
    public static final org.semanticwb.platform.SemanticProperty intranet_sala=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#sala");
    public static final org.semanticwb.platform.SemanticClass intranet_ReservacionSala=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#ReservacionSala");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#ReservacionSala");

    public static class ClassMgr
    {
       /**
       * Returns a list of ReservacionSala for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.ReservacionSala
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.ReservacionSala> listReservacionSalas(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.ReservacionSala>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.ReservacionSala for all models
       * @return Iterator of com.infotec.eworkplace.swb.ReservacionSala
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.ReservacionSala> listReservacionSalas()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.ReservacionSala>(it, true);
        }

        public static com.infotec.eworkplace.swb.ReservacionSala createReservacionSala(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.eworkplace.swb.ReservacionSala.ClassMgr.createReservacionSala(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.ReservacionSala
       * @param id Identifier for com.infotec.eworkplace.swb.ReservacionSala
       * @param model Model of the com.infotec.eworkplace.swb.ReservacionSala
       * @return A com.infotec.eworkplace.swb.ReservacionSala
       */
        public static com.infotec.eworkplace.swb.ReservacionSala getReservacionSala(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.ReservacionSala)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.ReservacionSala
       * @param id Identifier for com.infotec.eworkplace.swb.ReservacionSala
       * @param model Model of the com.infotec.eworkplace.swb.ReservacionSala
       * @return A com.infotec.eworkplace.swb.ReservacionSala
       */
        public static com.infotec.eworkplace.swb.ReservacionSala createReservacionSala(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.ReservacionSala)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.ReservacionSala
       * @param id Identifier for com.infotec.eworkplace.swb.ReservacionSala
       * @param model Model of the com.infotec.eworkplace.swb.ReservacionSala
       */
        public static void removeReservacionSala(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.ReservacionSala
       * @param id Identifier for com.infotec.eworkplace.swb.ReservacionSala
       * @param model Model of the com.infotec.eworkplace.swb.ReservacionSala
       * @return true if the com.infotec.eworkplace.swb.ReservacionSala exists, false otherwise
       */

        public static boolean hasReservacionSala(String id, org.semanticwb.model.SWBModel model)
        {
            return (getReservacionSala(id, model)!=null);
        }
       /**
       * Gets all com.infotec.eworkplace.swb.ReservacionSala with a determined Responsable
       * @param value Responsable of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.ReservacionSala
       * @return Iterator with all the com.infotec.eworkplace.swb.ReservacionSala
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.ReservacionSala> listReservacionSalaByResponsable(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.ReservacionSala> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_responsable, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.ReservacionSala with a determined Responsable
       * @param value Responsable of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.ReservacionSala
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.ReservacionSala> listReservacionSalaByResponsable(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.ReservacionSala> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_responsable,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.ReservacionSala with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.ReservacionSala
       * @return Iterator with all the com.infotec.eworkplace.swb.ReservacionSala
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.ReservacionSala> listReservacionSalaByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.ReservacionSala> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.ReservacionSala with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.ReservacionSala
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.ReservacionSala> listReservacionSalaByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.ReservacionSala> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.ReservacionSala with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.ReservacionSala
       * @return Iterator with all the com.infotec.eworkplace.swb.ReservacionSala
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.ReservacionSala> listReservacionSalaByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.ReservacionSala> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.ReservacionSala with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.ReservacionSala
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.ReservacionSala> listReservacionSalaByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.ReservacionSala> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.ReservacionSala with a determined Sala
       * @param value Sala of the type com.infotec.eworkplace.swb.Sala
       * @param model Model of the com.infotec.eworkplace.swb.ReservacionSala
       * @return Iterator with all the com.infotec.eworkplace.swb.ReservacionSala
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.ReservacionSala> listReservacionSalaBySala(com.infotec.eworkplace.swb.Sala value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.ReservacionSala> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_sala, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.ReservacionSala with a determined Sala
       * @param value Sala of the type com.infotec.eworkplace.swb.Sala
       * @return Iterator with all the com.infotec.eworkplace.swb.ReservacionSala
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.ReservacionSala> listReservacionSalaBySala(com.infotec.eworkplace.swb.Sala value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.ReservacionSala> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_sala,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a ReservacionSalaBase with a SemanticObject
   * @param base The SemanticObject with the properties for the ReservacionSala
   */
    public ReservacionSalaBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Sets the value for the property Responsable
   * @param value Responsable to set
   */

    public void setResponsable(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_responsable, value.getSemanticObject());
        }else
        {
            removeResponsable();
        }
    }
   /**
   * Remove the value for Responsable property
   */

    public void removeResponsable()
    {
        getSemanticObject().removeProperty(intranet_responsable);
    }

   /**
   * Gets the Responsable
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getResponsable()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_responsable);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
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
* Gets the De property
* @return int with the De
*/
    public int getDe()
    {
        return getSemanticObject().getIntProperty(intranet_de);
    }

/**
* Sets the De property
* @param value long with the De
*/
    public void setDe(int value)
    {
        getSemanticObject().setIntProperty(intranet_de, value);
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
* Gets the Fecha property
* @return java.util.Date with the Fecha
*/
    public java.util.Date getFecha()
    {
        return getSemanticObject().getDateProperty(intranet_fecha);
    }

/**
* Sets the Fecha property
* @param value long with the Fecha
*/
    public void setFecha(java.util.Date value)
    {
        getSemanticObject().setDateProperty(intranet_fecha, value);
    }

/**
* Gets the A property
* @return int with the A
*/
    public int getA()
    {
        return getSemanticObject().getIntProperty(intranet_a);
    }

/**
* Sets the A property
* @param value long with the A
*/
    public void setA(int value)
    {
        getSemanticObject().setIntProperty(intranet_a, value);
    }
   /**
   * Sets the value for the property Sala
   * @param value Sala to set
   */

    public void setSala(com.infotec.eworkplace.swb.Sala value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_sala, value.getSemanticObject());
        }else
        {
            removeSala();
        }
    }
   /**
   * Remove the value for Sala property
   */

    public void removeSala()
    {
        getSemanticObject().removeProperty(intranet_sala);
    }

   /**
   * Gets the Sala
   * @return a com.infotec.eworkplace.swb.Sala
   */
    public com.infotec.eworkplace.swb.Sala getSala()
    {
         com.infotec.eworkplace.swb.Sala ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_sala);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.Sala)obj.createGenericInstance();
         }
         return ret;
    }
}
