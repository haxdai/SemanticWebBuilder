package org.semanticwb.bsc.formelement;

import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.DisplayProperty;
import org.semanticwb.model.SWBContext;
import org.semanticwb.model.User;
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

        Locale locale;
        locale = new Locale(lang);
        User user;
        user = SWBContext.getSessionUser(SWBContext.USERREPOSITORY_ADMIN);
        if(user==null) {
            ret.append(SWBUtils.TEXT.getLocaleString("locale_swbstrategy_util","lblHelp",locale));
        }else {
            SemanticObject sobj  = prop.getDisplayProperty();
            DisplayProperty dobj = new DisplayProperty(sobj);
            String url = request.getScheme()+"://"+request.getServerName()+":"
                +request.getServerPort()+SWBPlatform.getContextPath()+"/"
                +lang+"/"+SWBContext.WEBSITE_ADMIN+"/"+obj.getSemanticClass().getName();
            //ret.append("<a href=\"#\" onclick=\"window.open('").append(obj.getSemanticClass().getName());
            ret.append("<a href=\"#\" onclick=\"window.open('").append(url);
            ret.append("','swbstgyhelp','location=0,menubar=0,status=0,toolbar=0,width=600,height=400',false)\"");
            ret.append(" title=\"").append(dobj.getDisplayPromptMessage(lang)).append("\">");
            ret.append(SWBUtils.TEXT.getLocaleString("locale_swbstrategy_util","lblHelp",locale));
            ret.append("</a>");
        }
        return ret.toString();
    }

    @Override
    public String renderLabel(HttpServletRequest request, SemanticObject obj, SemanticProperty prop, String propName, String type, String mode, String lang, String label) {
        String ret;
        ret = "";
        return ret;
    }
    
}
