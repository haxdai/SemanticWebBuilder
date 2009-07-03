package org.semanticwb.resource.office.sem.base;


public class WordResourceBase extends org.semanticwb.resource.office.sem.OfficeResource 
{
    public static final org.semanticwb.platform.SemanticProperty swboffice_txtAnt=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/office#txtAnt");
    public static final org.semanticwb.platform.SemanticProperty swboffice_position=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/office#position");
    public static final org.semanticwb.platform.SemanticProperty swboffice_txtSig=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/office#txtSig");
    public static final org.semanticwb.platform.SemanticProperty swboffice_font=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/office#font");
    public static final org.semanticwb.platform.SemanticProperty swboffice_numberOfPages=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/office#numberOfPages");
    public static final org.semanticwb.platform.SemanticProperty swboffice_content=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/office#content");
    public static final org.semanticwb.platform.SemanticProperty swboffice_versionToShow=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/office#versionToShow");
    public static final org.semanticwb.platform.SemanticProperty swboffice_Paginated=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/office#Paginated");
    public static final org.semanticwb.platform.SemanticProperty swboffice_repositoryName=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/office#repositoryName");
    public static final org.semanticwb.platform.SemanticClass swboffice_WordResource=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/office#WordResource");

    public WordResourceBase()
    {
    }

    public WordResourceBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/office#WordResource");

    public String getTxtAnt()
    {
        return getSemanticObject().getProperty(swboffice_txtAnt);
    }

    public void setTxtAnt(String txtAnt)
    {
        getSemanticObject().setProperty(swboffice_txtAnt, txtAnt);
    }

    public int getPosition()
    {
        return getSemanticObject().getIntProperty(swboffice_position);
    }

    public void setPosition(int position)
    {
        getSemanticObject().setLongProperty(swboffice_position, position);
    }

    public String getTxtSig()
    {
        return getSemanticObject().getProperty(swboffice_txtSig);
    }

    public void setTxtSig(String txtSig)
    {
        getSemanticObject().setProperty(swboffice_txtSig, txtSig);
    }

    public String getFont()
    {
        return getSemanticObject().getProperty(swboffice_font);
    }

    public void setFont(String font)
    {
        getSemanticObject().setProperty(swboffice_font, font);
    }

    public int getNumberOfPages()
    {
        return getSemanticObject().getIntProperty(swboffice_numberOfPages);
    }

    public void setNumberOfPages(int numberOfPages)
    {
        getSemanticObject().setLongProperty(swboffice_numberOfPages, numberOfPages);
    }

    public String getContent()
    {
        return getSemanticObject().getProperty(swboffice_content);
    }

    public void setContent(String content)
    {
        getSemanticObject().setProperty(swboffice_content, content);
    }

    public String getVersionToShow()
    {
        return getSemanticObject().getProperty(swboffice_versionToShow);
    }

    public void setVersionToShow(String versionToShow)
    {
        getSemanticObject().setProperty(swboffice_versionToShow, versionToShow);
    }

    public boolean isPaginated()
    {
        return getSemanticObject().getBooleanProperty(swboffice_Paginated);
    }

    public void setPaginated(boolean Paginated)
    {
        getSemanticObject().setBooleanProperty(swboffice_Paginated, Paginated);
    }

    public String getRepositoryName()
    {
        return getSemanticObject().getProperty(swboffice_repositoryName);
    }

    public void setRepositoryName(String repositoryName)
    {
        getSemanticObject().setProperty(swboffice_repositoryName, repositoryName);
    }
}
