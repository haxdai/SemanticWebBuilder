package com.infotec.eworkplace.swb.resources.sem.base;


public abstract class ReservaSalaManagerBase extends org.semanticwb.portal.api.GenericSemResource 
{
    public static final org.semanticwb.platform.SemanticClass ewp_ReservaSala=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#ReservaSala");
    public static final org.semanticwb.platform.SemanticProperty ewp_hasReservaSala=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#hasReservaSala");
    public static final org.semanticwb.platform.SemanticClass swb_Resource=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#Resource");
    public static final org.semanticwb.platform.SemanticProperty swb_semanticResourceInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#semanticResourceInv");
    public static final org.semanticwb.platform.SemanticClass ewp_ReservaSalaManager=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#ReservaSalaManager");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#ReservaSalaManager");

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
   * Gets all the com.infotec.eworkplace.swb.ReservaSala
   * @return A GenericIterator with all the com.infotec.eworkplace.swb.ReservaSala
   */

    public org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.ReservaSala> listReservaSalas()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.ReservaSala>(getSemanticObject().listObjectProperties(ewp_hasReservaSala));
    }

   /**
   * Gets true if has a ReservaSala
   * @param value com.infotec.eworkplace.swb.ReservaSala to verify
   * @return true if the com.infotec.eworkplace.swb.ReservaSala exists, false otherwise
   */
    public boolean hasReservaSala(com.infotec.eworkplace.swb.ReservaSala value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(ewp_hasReservaSala,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a ReservaSala
   * @param value com.infotec.eworkplace.swb.ReservaSala to add
   */

    public void addReservaSala(com.infotec.eworkplace.swb.ReservaSala value)
    {
        getSemanticObject().addObjectProperty(ewp_hasReservaSala, value.getSemanticObject());
    }
   /**
   * Removes all the ReservaSala
   */

    public void removeAllReservaSala()
    {
        getSemanticObject().removeProperty(ewp_hasReservaSala);
    }
   /**
   * Removes a ReservaSala
   * @param value com.infotec.eworkplace.swb.ReservaSala to remove
   */

    public void removeReservaSala(com.infotec.eworkplace.swb.ReservaSala value)
    {
        getSemanticObject().removeObjectProperty(ewp_hasReservaSala,value.getSemanticObject());
    }

   /**
   * Gets the ReservaSala
   * @return a com.infotec.eworkplace.swb.ReservaSala
   */
    public com.infotec.eworkplace.swb.ReservaSala getReservaSala()
    {
         com.infotec.eworkplace.swb.ReservaSala ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(ewp_hasReservaSala);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.ReservaSala)obj.createGenericInstance();
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
