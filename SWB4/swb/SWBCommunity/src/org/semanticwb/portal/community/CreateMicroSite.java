/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.portal.community;


import java.io.IOException;

import java.io.PrintWriter;
import java.util.Iterator;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;

import org.semanticwb.SWBUtils;
import org.semanticwb.model.GenericObject;
import org.semanticwb.model.Priorityable;
import org.semanticwb.model.Template;
import org.semanticwb.model.TemplateGroup;
import org.semanticwb.model.TemplateRef;
import org.semanticwb.model.User;
import org.semanticwb.model.WebPage;
import org.semanticwb.model.WebSite;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.platform.SemanticOntology;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;
import org.semanticwb.portal.lib.SWBRequest;

/**
 *
 * @author javier.solis
 */
public class CreateMicroSite extends GenericResource
{
    private static Logger log=SWBUtils.getLogger(CreateMicroSite.class);

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String act=request.getParameter("act");
        if(act==null)act="view";
        String path="/swbadmin/jsp/microsite/CreateMicroSite/view.jsp";
        if(act.equals("add"))path="/swbadmin/jsp/microsite/CreateMicroSite/add.jsp";
        if(act.equals("edit"))path="/swbadmin/jsp/microsite/CreateMicroSite/edit.jsp";
        if(act.equals("detail"))path="/swbadmin/jsp/microsite/CreateMicroSite/detail.jsp";

        RequestDispatcher dis=request.getRequestDispatcher(path);
        try
        {
            request.setAttribute("paramRequest", paramRequest);
            dis.include(request, response);
        }catch(Exception e){log.error(e);}
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException 
    {
        WebPage page=response.getWebPage();
        WebSite model = page.getWebSite();
        User user = response.getUser();
        String action=request.getParameter("act");

        SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();

        //System.out.println("act:"+action);
        if("add".equals(action))
        {
            String title=request.getParameter("title");
            String id=request.getParameter("id");
            String description=request.getParameter("description");
            String tags=request.getParameter("tags");
            String type=request.getParameter("type");
            boolean bprivate=request.getParameter("private")!=null?true:false;
            boolean bmoderate=request.getParameter("moderate")!=null?true:false;
            String utils[]=request.getParameterValues("hasMicroSiteUtil");
            //System.out.println("title:"+title);
            //System.out.println("description:"+description);
            //System.out.println("utils:"+utils+", size:"+utils.length);

            MicroSite ms = MicroSite.ClassMgr.createMicroSite(id,model);
            ms.setParent(page);
            ms.setTitle(title);
            ms.setDescription(description);
            ms.setTags(tags);
            ms.setActive(Boolean.TRUE);

            if(null!=type)
            {
                SemanticObject sotype = ont.getSemanticObject(type);
                MicroSiteType mstype = null;
                if(sotype.getGenericInstance() instanceof MicroSiteType)
                {
                   mstype = (MicroSiteType)sotype.getGenericInstance();
                   ms.setType(mstype);
                }
            }

            ms.setPrivate(bprivate);
            ms.setModerate(bmoderate);

            String tplURI = getResourceBase().getAttribute("defaultTemplate","");
            if(!"".equals(tplURI))
            {
                GenericObject got = ont.getGenericObject(tplURI);
                if(got instanceof Template)
                {
                    Template template = (Template)got;
                    TemplateRef tmpRef = model.createTemplateRef();
                    tmpRef.setTemplate(template);
                    tmpRef.setActive(Boolean.TRUE);
                    tmpRef.setInherit(TemplateRef.INHERIT_ACTUALANDCHILDS);
                    tmpRef.setValid(Boolean.TRUE);
                    tmpRef.setPriority(3);
                    ms.addTemplateRef(tmpRef);
                }
            }

            if(null!=utils&&utils.length>0)
            {

                for(int i=0;i<utils.length;i++)
                {
                    //System.out.println("i:"+i+", wputil:"+utils[i]);
                    GenericObject sowpu = ont.getGenericObject(utils[i]);

                    //System.out.println("tipo: "+sowpu.getSemanticObject().getSemanticClass());


                    if(sowpu!=null && sowpu instanceof MicroSiteUtil )
                    {
                        MicroSiteUtil msu = (MicroSiteUtil)sowpu;
                        MicroSiteWebPageUtil mswpu = MicroSiteWebPageUtil.ClassMgr.createMicroSiteWebPageUtil(ms.getId()+"_"+msu.getId(), model);
                        
                        mswpu.setTitle(msu.getTitle());
                        
                        
                        mswpu.setMicroSite(ms);
                        mswpu.setMicroSiteUtil(msu);

                        mswpu.setParent(ms);
                        mswpu.setActive(Boolean.TRUE);

                        //System.out.println("MicroSiteUtil:"+utils[i]);
                    }
                }
            }

            // Suscribo al creador de la nueva comunidad a esta.

            Member member=Member.ClassMgr.createMember(page.getWebSite());
            member.setAccessLevel(Member.LEVEL_OWNER); //Member.LEVEL_EDIT
            member.setUser(user);
            member.setMicroSite(ms);

        }
        else if("updateConfig".equals(action))
        {
            try {
                getResourceBase().setAttribute("defaultTemplate", request.getParameter("defaultTemp"));
                getResourceBase().updateAttributesToDB();
            } catch (Exception e) {
            }

        }
        else super.processAction(request, response);
    }

    @Override
    public void doAdmin(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        PrintWriter out = response.getWriter();
        WebPage wp = paramRequest.getWebPage();
        WebSite ws = wp.getWebSite();
        User user = paramRequest.getUser();
        SWBResourceURL urla = paramRequest.getActionUrl();
        String tmpSel = getResourceBase().getAttribute("defaultTemplate","");
        urla.setParameter("act","updateConfig");
        out.println("<div class=\"swbform\">");
        out.println("<form action=\""+urla+"\" method=\"post\" id=\"frm_cfgTemp\">");
        out.println("<fieldset>");
        out.println("<legend>Datos</legend>");
        out.println("<laber for=\"defaultTemp\">Selecciona el template por default para el MicroSitio</label>");
        out.println("<select name=\"defaultTemp\" id=\"defaultTemp\">");
        Iterator<TemplateGroup> ittg = ws.listTemplateGroups();
        while(ittg.hasNext())
        {
            TemplateGroup tg = ittg.next();
            out.println("<optgroup label=\""+tg.getDisplayTitle(user.getLanguage())+"\">");
            tg.getTitle();
            Iterator<Template> itt = tg.listTemplates();
            while(itt.hasNext())
            {
                Template tem = itt.next();
                if(tem.isValid())
                {
                    out.println("<option value=\"" + tem.getURI() + "\" "+(tmpSel.equals(tem.getURI())?"selected":"")+">" + tem.getDisplayTitle(user.getLanguage()) + "</option>");
                }
            }
            out.println("</optgroup>");
        }
        out.println("</select>");
        out.println("</fieldset>");
        out.println("<fieldset>");
        out.println("<button dojoType=\"dijit.form.Button\" type=\"submit\" name=\"btnSend\">Guardar</button>");
        out.println("</fieldset>");
        out.println("</form>");
        out.println("</div>");

    }




}
