package com.infotec.eworkplace.swb.resources.sem.base;


public abstract class ReservaSalaManagerBase extends org.semanticwb.portal.api.GenericSemResource 
{
    public static final org.semanticwb.platform.SemanticClass swb_Role=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#Role");
    public static final org.semanticwb.platform.SemanticProperty intranet_editAccess=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#editAccess");
    public static final org.semanticwb.platform.SemanticClass intranet_ReservacionSala=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#ReservacionSala");
    public static final org.semanticwb.platform.SemanticProperty intranet_hasReservacionSala=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasReservacionSala");
    public static final org.semanticwb.platform.SemanticClass swb_Resource=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#Resource");
    public static final org.semanticwb.platform.SemanticProperty swb_semanticResourceInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#semanticResourceInv");
    public static final org.semanticwb.platform.SemanticClass intranet_ReservaSalaManager=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#ReservaSalaManager");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#ReservaSalaManager");

    public ReservaSalaManagerBase()
    {
    }

   /**
   * Constructs a ReservaSalaManagerBase with a SemanticObject
   * @param base The SemanticObject with the properties for the ReservaSalaManager
   */
    public ReservaSalaManagerBase(org.semanticwb.platform.SemanticObject base)
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
   * Sets the value for the property EditAccess
   * @param value EditAccess to set
   */

    public void setEditAccess(org.semanticwb.model.Role value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_editAccess, value.getSemanticObject());
        }else
        {
            removeEditAccess();
        }
    }
   /**
   * Remove the value for EditAccess property
   */

    public void removeEditAccess()
    {
        getSemanticObject().removeProperty(intranet_editAccess);
    }

   /**
   * Gets the EditAccess
   * @return a org.semanticwb.model.Role
   */
    public org.semanticwb.model.Role getEditAccess()
    {
         org.semanticwb.model.Role ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_editAccess);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.Role)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the com.infotec.eworkplace.swb.ReservacionSala
   * @return A GenericIterator with all the com.infotec.eworkplace.swb.ReservacionSala
   */

    public org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.ReservacionSala> listReservacionSalas()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.ReservacionSala>(getSemanticObject().listObjectProperties(intranet_hasReservacionSala));
    }

   /**
   * Gets true if has a ReservacionSala
   * @param value com.infotec.eworkplace.swb.ReservacionSala to verify
   * @return true if the com.infotec.eworkplace.swb.ReservacionSala exists, false otherwise
   */
    public boolean hasReservacionSala(com.infotec.eworkplace.swb.ReservacionSala value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(intranet_hasReservacionSala,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a ReservacionSala
   * @param value com.infotec.eworkplace.swb.ReservacionSala to add
   */

    public void addReservacionSala(com.infotec.eworkplace.swb.ReservacionSala value)
    {
        getSemanticObject().addObjectProperty(intranet_hasReservacionSala, value.getSemanticObject());
    }
   /**
   * Removes all the ReservacionSala
   */

    public void removeAllReservacionSala()
    {
        getSemanticObject().removeProperty(intranet_hasReservacionSala);
    }
   /**
   * Removes a ReservacionSala
   * @param value com.infotec.eworkplace.swb.ReservacionSala to remove
   */

    public void removeReservacionSala(com.infotec.eworkplace.swb.ReservacionSala value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasReservacionSala,value.getSemanticObject());
    }

   /**
   * Gets the ReservacionSala
   * @return a com.infotec.eworkplace.swb.ReservacionSala
   */
    public com.infotec.eworkplace.swb.ReservacionSala getReservacionSala()
    {
         com.infotec.eworkplace.swb.ReservacionSala ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasReservacionSala);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.ReservacionSala)obj.createGenericInstance();
         }
         return ret;
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
}
