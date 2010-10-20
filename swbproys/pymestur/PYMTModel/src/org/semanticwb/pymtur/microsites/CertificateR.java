/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.pymtur.microsites;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.FormValidateException;
import org.semanticwb.model.Role;
import org.semanticwb.model.SWBComparator;
import org.semanticwb.model.User;
import org.semanticwb.model.WebPage;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.portal.SWBFormMgr;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;
import org.semanticwb.portal.community.MicroSiteType;
import org.semanticwb.pymtur.Certificates;
import org.semanticwb.pymtur.Hospedaje;
import org.semanticwb.pymtur.MicroSitePyme;
import org.semanticwb.pymtur.ServiceProvider;

/**
 *
 * @author martha.jimenez
 */
public class CertificateR extends GenericResource{
    private static Logger log = SWBUtils.getLogger(CertificateR.class);

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        PrintWriter out = response.getWriter();
        if(paramRequest.getCallMethod()!=paramRequest.Call_STRATEGY)
        {
            RequestDispatcher dis = null;
            WebPage wp = paramRequest.getWebPage();
            WebPage community = null;
            String path = null;
            String action = paramRequest.getAction();
            if (wp instanceof MicroSitePyme) {
                community = wp;
            } else {
                community = wp.getParent();
            }
            String siteUri = ((MicroSitePyme) community).getType().getURI();

            if (MicroSiteType.ClassMgr.getMicroSiteType("MiPymeSite", wp.getWebSite()).getURI().equals(siteUri)) {
                path = "/work/models/etour/jsp/pymestur/microsite/editRegistered.jsp";
            } else if (MicroSiteType.ClassMgr.getMicroSiteType("MiPymeSitePlus", wp.getWebSite()).getURI().equals(siteUri)) {
                if (action != null && action.equalsIgnoreCase("editCertif"))
                {
                    path = "/work/models/etour/jsp/pymestur/premier/editCertificated.jsp";
                } 
            }
            dis = request.getRequestDispatcher(path);
            try {
                request.setAttribute("paramRequest", paramRequest);
                dis.include(request, response);
            } catch (Exception e) {
                log.error(e);
            }
        }else
        {
            ServiceProvider sprovider = null;
            WebPage community = null;
            WebPage currentpage = (WebPage) request.getAttribute("webpage");
            if(currentpage == null)
            {
                currentpage = paramRequest.getWebPage();
            }
            if(currentpage instanceof MicroSitePyme)
            {
                community = currentpage;
            }else
            {
                community = currentpage.getParent();
            }
            MicroSitePyme ms = (MicroSitePyme)community;
            sprovider = ms.getServiceProvider();

            SWBResourceURL url = paramRequest.getRenderUrl().setAction("editCertif");
            url.setCallMethod(SWBResourceURL.Call_DIRECT);
            out.println("<script type=\"text/javascript\">");
            out.println("function displayCertif() {");
            out.println("   var certif = document.createElement('div');");
            out.println("   var s=\"\";");
            out.println("   s = s.concat(\"<div position='absolute' top='9%' left='20%' width='60%' height='75%'>\");");
            out.println("   s = s.concat(\"<iframe style='z-index: 10005;background-color:white; position: absolute; top: 9%; left: 20%; width: 60%; height: 75%; border: 3px double white; padding: 5px;'  src='"+url+"'></iframe>\");");
            out.println("   s = s.concat(\"</div>\");");
            out.println("   certif.innerHTML = s;");
            out.println("   certif.id = 'editCertificados'");
            out.println("   certif.style.zIndex=10000;");
            out.println("   certif.style.position='absolute';");
            out.println("   certif.style.top='0%';");
            out.println("   certif.style.left='0%';");
            out.println("   certif.style.width='100%';");
            out.println("   certif.style.height='100%';");
            out.println("   certif.style.background='#000000';");
            out.println("   document.body.appendChild(certif);}");
            out.println("</script>");
            out.println("<STYLE type=\"text/css\">");
            out.println(".certif a{background:none; padding:0px; margin:0px; display:inline; float:left; border:solid 1px #b6b6b6; padding:2px; margin:1px 0 1px 2px; clear:none;width:80px; height:80px; text-align:center}");
            out.println(".certif .img{display:inline-block;}");
            out.println(" </STYLE>");
            boolean userCanEdit = false;
            User user = paramRequest.getUser();
            Role superAdm = user.getUserRepository().getRole("superAdmProviders");

            if (user.getURI() != null && (sprovider.getCreator().getURI().equals(user.getURI()) || user.hasRole(superAdm))) {
                userCanEdit = true;
            }
            if (userCanEdit) {
                out.println("<a href=\"#\" onclick=\"javascript:displayCertif()\">Editar</a>");
            }
            Iterator<Certificates> itcertifi = sprovider.listCertificates();
            if(itcertifi.hasNext()) {
                itcertifi = SWBComparator.sortByDisplayName(sprovider.listCertificates(), user.getLanguage());
                out.println("<div class=\"certif\">");
                while(itcertifi.hasNext()) {
                    Certificates certif = itcertifi.next();
                    String ref = "";
                    if(certif.getCerURL()==null)
                    {
                        ref = "<a href=\"#\">";
                    }else
                    {
                        ref = "<a href=\""+certif.getCerURL()+"\" target=\"_blank\">";
                    }
                    out.println("  <div class=\"img\">"+ref+"<img alt=\""+certif.getDisplayTitle(user.getLanguage())+"\" width=\"60\" height=\"60\" border=\"0\" src=\"/work/"+certif.getCerImage()+"\"></a></div>");
                }
                out.println("</div>");
            }
            out.flush();
        }
    }
        @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        String action = response.getAction();
        try {
            if (request.getParameter("uri") != null && action != null && action.equalsIgnoreCase("saveCertific")) {
                SemanticObject semObject = SemanticObject.createSemanticObject(request.getParameter("uri"));
                SWBFormMgr mgr = new SWBFormMgr(semObject, null, SWBFormMgr.MODE_EDIT);
                mgr.clearProperties();
                mgr.addProperty(Hospedaje.pymtur_hasCertificate);
                if(request.getParameterValues(Hospedaje.pymtur_hasCertificate.getName())==null)
                {
                    ServiceProvider sprovider = (ServiceProvider)semObject.createGenericInstance();
                    Iterator it = sprovider.listCertificates();
                    while(it.hasNext())
                    {
                        sprovider.removeCertificate((Certificates)it.next());
                    }
                }
                mgr.processForm(request);
            }
        } catch (FormValidateException e) {
            log.error(e);
        }
        String other = request.getParameter("other");
        response.sendRedirect(other);
    }
}
