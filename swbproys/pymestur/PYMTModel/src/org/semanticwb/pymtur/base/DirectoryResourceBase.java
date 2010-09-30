package org.semanticwb.pymtur.base;


public abstract class DirectoryResourceBase extends org.semanticwb.portal.community.DirectoryResource 
{
    public static final org.semanticwb.platform.SemanticClass swbcomm_DirectoryClass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/community#DirectoryClass");
    public static final org.semanticwb.platform.SemanticProperty swbcomm_directoryClass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/community#directoryClass");
    public static final org.semanticwb.platform.SemanticProperty swbcomm_dirAcceptClaimMessage=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/community#dirAcceptClaimMessage");
    public static final org.semanticwb.platform.SemanticProperty swbcomm_dirListJsp=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/community#dirListJsp");
    public static final org.semanticwb.platform.SemanticClass swbcomm_DirectoryObject=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/community#DirectoryObject");
    public static final org.semanticwb.platform.SemanticProperty swbcomm_hasDirectoryObjectInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/community#hasDirectoryObjectInv");
    public static final org.semanticwb.platform.SemanticProperty pymtur_NumMaxPageToDisplay=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#NumMaxPageToDisplay");
    public static final org.semanticwb.platform.SemanticProperty pymtur_numMaxItemsbyPage=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#numMaxItemsbyPage");
    public static final org.semanticwb.platform.SemanticProperty swbcomm_dirEditJsp=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/community#dirEditJsp");
    public static final org.semanticwb.platform.SemanticProperty swbcomm_dirAddJsp=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/community#dirAddJsp");
    public static final org.semanticwb.platform.SemanticProperty swbcomm_dirClaimMessage=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/community#dirClaimMessage");
    public static final org.semanticwb.platform.SemanticProperty swbcomm_dirDetailJsp=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/community#dirDetailJsp");
    public static final org.semanticwb.platform.SemanticClass pymtur_DirectoryResource=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#DirectoryResource");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#DirectoryResource");

    public DirectoryResourceBase()
    {
    }

   /**
   * Constructs a DirectoryResourceBase with a SemanticObject
   * @param base The SemanticObject with the properties for the DirectoryResource
   */
    public DirectoryResourceBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public void setDirectoryClass(org.semanticwb.platform.SemanticObject value)
    {
        getSemanticObject().setObjectProperty(swbcomm_directoryClass, value);
    }

    public void removeDirectoryClass()
    {
        getSemanticObject().removeProperty(swbcomm_directoryClass);
    }

/**
* Gets the DirectoryClass property
* @return the value for the property as org.semanticwb.platform.SemanticObject
*/
    public org.semanticwb.platform.SemanticObject getDirectoryClass()
    {
         org.semanticwb.platform.SemanticObject ret=null;
         ret=getSemanticObject().getObjectProperty(swbcomm_directoryClass);
         return ret;
    }

/**
* Gets the DirAcceptClaimMessage property
* @return String with the DirAcceptClaimMessage
*/
    public String getDirAcceptClaimMessage()
    {
        return getSemanticObject().getProperty(swbcomm_dirAcceptClaimMessage);
    }

/**
* Sets the DirAcceptClaimMessage property
* @param value long with the DirAcceptClaimMessage
*/
    public void setDirAcceptClaimMessage(String value)
    {
        getSemanticObject().setProperty(swbcomm_dirAcceptClaimMessage, value);
    }

/**
* Gets the ListJsp property
* @return String with the ListJsp
*/
    public String getListJsp()
    {
        return getSemanticObject().getProperty(swbcomm_dirListJsp);
    }

/**
* Sets the ListJsp property
* @param value long with the ListJsp
*/
    public void setListJsp(String value)
    {
        getSemanticObject().setProperty(swbcomm_dirListJsp, value);
    }
   /**
   * Gets all the org.semanticwb.portal.community.DirectoryObject
   * @return A GenericIterator with all the org.semanticwb.portal.community.DirectoryObject
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.DirectoryObject> listDirectoryObjects()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.DirectoryObject>(getSemanticObject().listObjectProperties(swbcomm_hasDirectoryObjectInv));
    }

   /**
   * Gets true if has a DirectoryObject
   * @param value org.semanticwb.portal.community.DirectoryObject to verify
   * @return true if the org.semanticwb.portal.community.DirectoryObject exists, false otherwise
   */
    public boolean hasDirectoryObject(org.semanticwb.portal.community.DirectoryObject value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(swbcomm_hasDirectoryObjectInv,value.getSemanticObject());
        }
        return ret;
    }

   /**
   * Gets the DirectoryObject
   * @return a org.semanticwb.portal.community.DirectoryObject
   */
    public org.semanticwb.portal.community.DirectoryObject getDirectoryObject()
    {
         org.semanticwb.portal.community.DirectoryObject ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swbcomm_hasDirectoryObjectInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.portal.community.DirectoryObject)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the NumMaxPageToDisplay property
* @return int with the NumMaxPageToDisplay
*/
    public int getNumMaxPageToDisplay()
    {
        return getSemanticObject().getIntProperty(pymtur_NumMaxPageToDisplay);
    }

/**
* Sets the NumMaxPageToDisplay property
* @param value long with the NumMaxPageToDisplay
*/
    public void setNumMaxPageToDisplay(int value)
    {
        getSemanticObject().setIntProperty(pymtur_NumMaxPageToDisplay, value);
    }

/**
* Gets the NumMaxItemsbyPage property
* @return int with the NumMaxItemsbyPage
*/
    public int getNumMaxItemsbyPage()
    {
        return getSemanticObject().getIntProperty(pymtur_numMaxItemsbyPage);
    }

/**
* Sets the NumMaxItemsbyPage property
* @param value long with the NumMaxItemsbyPage
*/
    public void setNumMaxItemsbyPage(int value)
    {
        getSemanticObject().setIntProperty(pymtur_numMaxItemsbyPage, value);
    }

/**
* Gets the EditJsp property
* @return String with the EditJsp
*/
    public String getEditJsp()
    {
        return getSemanticObject().getProperty(swbcomm_dirEditJsp);
    }

/**
* Sets the EditJsp property
* @param value long with the EditJsp
*/
    public void setEditJsp(String value)
    {
        getSemanticObject().setProperty(swbcomm_dirEditJsp, value);
    }

/**
* Gets the AddJsp property
* @return String with the AddJsp
*/
    public String getAddJsp()
    {
        return getSemanticObject().getProperty(swbcomm_dirAddJsp);
    }

/**
* Sets the AddJsp property
* @param value long with the AddJsp
*/
    public void setAddJsp(String value)
    {
        getSemanticObject().setProperty(swbcomm_dirAddJsp, value);
    }

/**
* Gets the DirClaimMessage property
* @return String with the DirClaimMessage
*/
    public String getDirClaimMessage()
    {
        return getSemanticObject().getProperty(swbcomm_dirClaimMessage);
    }

/**
* Sets the DirClaimMessage property
* @param value long with the DirClaimMessage
*/
    public void setDirClaimMessage(String value)
    {
        getSemanticObject().setProperty(swbcomm_dirClaimMessage, value);
    }

/**
* Gets the DetailJsp property
* @return String with the DetailJsp
*/
    public String getDetailJsp()
    {
        return getSemanticObject().getProperty(swbcomm_dirDetailJsp);
    }

/**
* Sets the DetailJsp property
* @param value long with the DetailJsp
*/
    public void setDetailJsp(String value)
    {
        getSemanticObject().setProperty(swbcomm_dirDetailJsp, value);
    }
}
