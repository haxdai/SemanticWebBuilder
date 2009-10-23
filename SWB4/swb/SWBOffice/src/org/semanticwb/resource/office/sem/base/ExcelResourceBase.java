package org.semanticwb.resource.office.sem.base;


public class ExcelResourceBase extends org.semanticwb.resource.office.sem.OfficeResource 
{
    public static class ClassMgr
    {
       public static final org.semanticwb.platform.SemanticProperty swboffice_content=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/office#content");
       public static final org.semanticwb.platform.SemanticProperty swboffice_versionToShow=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/office#versionToShow");
       public static final org.semanticwb.platform.SemanticProperty swboffice_repositoryName=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/office#repositoryName");
       public static final org.semanticwb.platform.SemanticClass swboffice_ExcelResource=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/office#ExcelResource");
       public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/office#ExcelResource");
    }

    public ExcelResourceBase()
    {
    }

    public ExcelResourceBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public String getContent()
    {
        return getSemanticObject().getProperty(ClassMgr.swboffice_content);
    }

    public void setContent(String value)
    {
        getSemanticObject().setProperty(ClassMgr.swboffice_content, value);
    }

    public String getVersionToShow()
    {
        return getSemanticObject().getProperty(ClassMgr.swboffice_versionToShow);
    }

    public void setVersionToShow(String value)
    {
        getSemanticObject().setProperty(ClassMgr.swboffice_versionToShow, value);
    }

    public String getRepositoryName()
    {
        return getSemanticObject().getProperty(ClassMgr.swboffice_repositoryName);
    }

    public void setRepositoryName(String value)
    {
        getSemanticObject().setProperty(ClassMgr.swboffice_repositoryName, value);
    }
}
