package org.semanticwb.bsc.formelement;

import javax.servlet.http.HttpServletRequest;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.platform.SemanticProperty;

public class UrlGo extends org.semanticwb.bsc.formelement.base.UrlGoBase 
{
    private static final Logger log = SWBUtils.getLogger(Ordinal.class);
    
    public UrlGo(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
    
    @Override
    public String renderElement(HttpServletRequest request, SemanticObject obj, SemanticProperty prop, String propName, String type, String mode, String lang) {
        if (obj == null) {
            obj = new SemanticObject();
        }
        StringBuilder   ret      = new StringBuilder();
        ret.append("<a href=\"#\" onclick=\"window.open('").append(obj.getSemanticClass().getName()).append("','swbstgyhelp','location=0,menubar=0,status=0,toolbar=0,width=600,height=400',false)\" title=\"Ver ayuda\">Ayuda</a>");
        return ret.toString();
    }

    @Override
    public String renderLabel(HttpServletRequest request, SemanticObject obj, SemanticProperty prop, String propName, String type, String mode, String lang, String label) {
        String ret="";
        return ret;
    }
    
}
