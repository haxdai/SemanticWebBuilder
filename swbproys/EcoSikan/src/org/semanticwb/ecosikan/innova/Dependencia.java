package org.semanticwb.ecosikan.innova;

import java.util.HashMap;
import java.util.Iterator;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.ecosikan.innova.util.LastComments;
import org.semanticwb.model.Template;
import org.semanticwb.model.TemplateRef;
import org.semanticwb.model.WebSite;
import org.semanticwb.portal.api.SWBActionResponse;


public class Dependencia extends org.semanticwb.ecosikan.innova.base.DependenciaBase {
    private static Logger log = SWBUtils.getLogger(Dependencia.class);
    private static final String Template_ID = "9";
    private static final int List_Last = 4;
    private LastComments lastComments;

    public Dependencia(org.semanticwb.platform.SemanticObject base)
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
        if(!params.containsKey("name")||(params.containsKey("name")&&params.get("name").isEmpty())) {
            response.setRenderParameter("", "");
            throw new Exception("Valor requerido");
        }

        WebSite site = response.getWebPage().getWebSite();
        
        setParent(site.getHomePage());
        setTitle(params.get("name"));
        setDescription((params.get("desc")==null?"":params.get("desc")));
        setImage(params.get("filename"));
        setActive(Boolean.TRUE);

        Template tpl = site.getTemplate(Template_ID);
        TemplateRef tref = site.createTemplateRef();
        tref.setTemplate(tpl);
        tref.setActive(Boolean.TRUE);
        tref.setInherit(TemplateRef.INHERIT_ACTUAL);
        addTemplateRef(tref);
    }
}
