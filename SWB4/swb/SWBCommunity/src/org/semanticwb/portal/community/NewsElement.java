package org.semanticwb.portal.community;


public class NewsElement extends org.semanticwb.portal.community.base.NewsElementBase 
{
    public NewsElement(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
    @Override
    public String getURL()
    {
        String url = "#";
        url=this.getNewsWebPage().getUrl();
        return url;
    }
}
