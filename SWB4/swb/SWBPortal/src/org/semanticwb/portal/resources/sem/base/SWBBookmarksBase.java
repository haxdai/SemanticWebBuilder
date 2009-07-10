package org.semanticwb.portal.resources.sem.base;


public class SWBBookmarksBase extends org.semanticwb.portal.api.GenericSemResource 
{
    public static final org.semanticwb.platform.SemanticProperty swb_res_bkm_displayMode=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/portal/resources/sem/SWBBookmarks#displayMode");
    public static final org.semanticwb.platform.SemanticProperty swb_res_bkm_admUrl=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/portal/resources/sem/SWBBookmarks#admUrl");
    public static final org.semanticwb.platform.SemanticClass swb_res_bkm_BookmarkGroup=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/portal/resources/sem/SWBBookmarks#BookmarkGroup");
    public static final org.semanticwb.platform.SemanticProperty swb_res_bkm_hasGroup=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/portal/resources/sem/SWBBookmarks#hasGroup");
    public static final org.semanticwb.platform.SemanticProperty swb_res_bkm_sortType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/portal/resources/sem/SWBBookmarks#sortType");
    public static final org.semanticwb.platform.SemanticClass swb_res_bkm_SWBBookmarks=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/portal/resources/sem/SWBBookmarks#SWBBookmarks");

    public SWBBookmarksBase()
    {
    }

    public SWBBookmarksBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/portal/resources/sem/SWBBookmarks#SWBBookmarks");

    public int getDisplayMode()
    {
        return getSemanticObject().getIntProperty(swb_res_bkm_displayMode);
    }

    public void setDisplayMode(int displayMode)
    {
        getSemanticObject().setIntProperty(swb_res_bkm_displayMode, displayMode);
    }

    public String getAdmUrl()
    {
        return getSemanticObject().getProperty(swb_res_bkm_admUrl);
    }

    public void setAdmUrl(String admUrl)
    {
        getSemanticObject().setProperty(swb_res_bkm_admUrl, admUrl);
    }

    public org.semanticwb.model.GenericIterator<org.semanticwb.portal.resources.sem.BookmarkGroup> listGroups()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.portal.resources.sem.BookmarkGroup>(getSemanticObject().listObjectProperties(swb_res_bkm_hasGroup));
    }

    public boolean hasGroup(org.semanticwb.portal.resources.sem.BookmarkGroup bookmarkgroup)
    {
        if(bookmarkgroup==null)return false;
        return getSemanticObject().hasObjectProperty(swb_res_bkm_hasGroup,bookmarkgroup.getSemanticObject());
    }

    public void addGroup(org.semanticwb.portal.resources.sem.BookmarkGroup bookmarkgroup)
    {
        getSemanticObject().addObjectProperty(swb_res_bkm_hasGroup, bookmarkgroup.getSemanticObject());
    }

    public void removeAllGroup()
    {
        getSemanticObject().removeProperty(swb_res_bkm_hasGroup);
    }

    public void removeGroup(org.semanticwb.portal.resources.sem.BookmarkGroup bookmarkgroup)
    {
        getSemanticObject().removeObjectProperty(swb_res_bkm_hasGroup,bookmarkgroup.getSemanticObject());
    }

    public org.semanticwb.portal.resources.sem.BookmarkGroup getGroup()
    {
         org.semanticwb.portal.resources.sem.BookmarkGroup ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_res_bkm_hasGroup);
         if(obj!=null)
         {
             ret=(org.semanticwb.portal.resources.sem.BookmarkGroup)obj.createGenericInstance();
         }
         return ret;
    }

    public int getSortType()
    {
        return getSemanticObject().getIntProperty(swb_res_bkm_sortType);
    }

    public void setSortType(int sortType)
    {
        getSemanticObject().setIntProperty(swb_res_bkm_sortType, sortType);
    }
}
