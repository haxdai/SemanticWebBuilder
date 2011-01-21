package org.semanticwb.ecosikan.innova;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.ecosikan.innova.util.LastComments;
import org.semanticwb.model.Template;
import org.semanticwb.model.TemplateRef;
import org.semanticwb.model.WebSite;
import org.semanticwb.portal.api.SWBActionResponse;

public class Theme extends org.semanticwb.ecosikan.innova.base.ThemeBase {
    private static Logger log = SWBUtils.getLogger(Theme.class);
    private static final String Template_ID = "10";
    private static final int List_Last = 3;
    private LastComments lastComments;

    public Theme(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
        lastComments = new LastComments(List_Last);
    }

    public boolean offer(Comment c) {
        return lastComments.offer(c);
    }

    public Iterator<Comment> listLastComments() {
        return lastComments.iterator();
    }

    public void addData(SWBActionResponse response, HashMap<String,String> params) throws Exception {
        if(!params.containsKey("title")||(params.containsKey("title")&&params.get("title").isEmpty())) {
            response.setRenderParameter("", "");
            throw new Exception("Valor requerido");
        }
        if(!params.containsKey("desc")||(params.containsKey("desc")&&params.get("desc").isEmpty())) {
            response.setRenderParameter("", "");
            throw new Exception("Valor requerido");
        }

        WebSite site = response.getWebPage().getWebSite();

        setParent(response.getWebPage());
        this.setTitle(params.get("title"));
        setDescription(params.get("desc"));
        setImage(params.get("filename"));
        setActive(Boolean.TRUE);

        Template tpl = site.getTemplate(Template_ID);
        TemplateRef tref = site.createTemplateRef();
        tref.setTemplate(tpl);
        tref.setActive(Boolean.TRUE);
        tref.setInherit(TemplateRef.INHERIT_ACTUAL);
        addTemplateRef(tref);
    }

    public static class SortedThemeByIdeasCount implements Comparator<Theme>{
        public int compare(Theme theme1, Theme theme2) {
            Long s1 = SWBUtils.Collections.sizeOf(theme1.listIdeas());
            Long s2 = SWBUtils.Collections.sizeOf(theme2.listIdeas());
            return s1.compareTo(s2);
        }
    }
}
