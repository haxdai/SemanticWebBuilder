/**
 *
 * @author carlos.ramos
 */

package org.semanticwb.pymtur.microsites;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.GenericObject;
import org.semanticwb.model.Resource;
import org.semanticwb.model.Role;
import org.semanticwb.model.User;
import org.semanticwb.model.UserGroup;
import org.semanticwb.model.WebPage;
import org.semanticwb.model.WebSite;
import org.semanticwb.platform.SemanticOntology;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.GenericAdmResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;
import org.semanticwb.pymtur.MicroSitePyme;
import org.semanticwb.pymtur.Rate;
import org.semanticwb.pymtur.ServiceProvider;

public class RateManager extends GenericAdmResource {
    private static Logger log = SWBUtils.getLogger(RateManager.class);

    private static final String ADMIN_AXN = "admin_update";
    private static final String MGR_ATTR = "edit";
    private static final String UPDATE_DONE = "ok";

    /*private String webWorkPath= null;

    @Override
    public void setResourceBase(Resource base) {
        try {
            super.setResourceBase(base);
            webWorkPath = SWBPortal.getWebWorkPath() +  base.getWorkPath();
        }catch(Exception e) {
            log.error("Error while setting resource base: "+base.getId() +"-"+ base.getTitle(), e);
        }
    }*/

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramsRequest) throws SWBResourceException, IOException {
        super.processRequest(request, response, paramsRequest);

    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramsRequest) throws SWBResourceException, IOException {
        response.setContentType("text/html; charset=ISO-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");

        ServiceProvider sprovider = null;
        WebPage community = null;
        WebPage currentpage = (WebPage) request.getAttribute("webpage");
        if(currentpage == null) {
            currentpage = paramsRequest.getWebPage();
        }
        if(currentpage instanceof MicroSitePyme) {
            community = currentpage;
        }else {
            community = currentpage.getParent();
        }
        MicroSitePyme ms = (MicroSitePyme)community;
        sprovider = ms.getServiceProvider();

        /*Rate r= SemanticObject.createSemanticObject(Rate.ClassMgr.)
        r.getCapacity();*/

        if(userCanEdit(paramsRequest.getUser())) {
            response.getWriter().print(getFormManager());
        }else {
            response.getWriter().print(getFormView());
        }
    }

    private String getFormManager() {
        return "<p>vamos a admnistrar</p>";
    }

    private String getFormView() {
        return "<p>vamos a ver</p>";
    }

    @Override
    public void doAdmin(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("text/html; charset=ISO-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");

        Resource base = getResourceBase();
        PrintWriter out = response.getWriter();
        User user = paramRequest.getUser();

        WebPage wpage = paramRequest.getWebPage();
        WebSite wsite = wpage.getWebSite();

        if(request.getParameter(UPDATE_DONE)!=null) {
            out.println("<script type=\"text/javascript\">");
            out.println("   alert('Se actualizó exitosamente el recurso con identificador "+base.getId()+"');");
            out.println("   location='"+paramRequest.getRenderUrl()+"';");
            out.println("</script>");
        }else {
            SWBResourceURL urlA = paramRequest.getActionUrl();
            urlA.setAction(ADMIN_AXN);
            out.println("<div class=\"swbform\">");
            out.println("<form id=\"frm_ratemgr_"+base.getId()+"\" name=\"frm_ratemgr_"+getResourceBase().getId()+"\" action=\""+urlA+"\" method=\"post\">");
            out.println("<fieldset>");
            out.println("<legend>");
            out.println("Datos");
            out.println("</legend>");
            out.println("<table width=\"100%\"  border=\"0\" cellpadding=\"5\" cellspacing=\"0\">");

            String roleName = base.getAttribute(MGR_ATTR, "0");
            StringBuffer rulesScript = new StringBuffer("");
            String selected = "";
            if(roleName.equals("0"))
                selected = " selected=\"selected\" ";
            rulesScript.append("<option value=\"0\" "+selected+">Ninguno</option>");

            Iterator<Role> roles = wsite.getUserRepository().listRoles();
            if(roles.hasNext()) {
                rulesScript.append("<optgroup label=\"Roles\">");
                while (roles.hasNext()) {
                    Role oRole = roles.next();
                    selected = "";
                    if (roleName.equalsIgnoreCase(oRole.getURI())) {
                        selected = " selected=\"selected\" ";
                    }
                    rulesScript.append("<option value=\""+URLEncoder.encode(oRole.getURI(), "UTF-8")+"\" "+selected+">"+oRole.getDisplayTitle(user.getLanguage())+"</option>");
                }
                rulesScript.append("</optgroup>");
            }

            Iterator<UserGroup> ugroups = wsite.getUserRepository().listUserGroups();
            if(ugroups.hasNext()) {
                rulesScript.append("<optgroup label=\"User Groups\">");
                while (ugroups.hasNext()) {
                    UserGroup oUG = ugroups.next();
                    selected = "";
                    if (roleName.equalsIgnoreCase(oUG.getURI())) {
                        selected = " selected=\"selected\" ";
                    }
                    rulesScript.append("<option value=\""+URLEncoder.encode(oUG.getURI(), "UTF-8")+"\" "+selected+">"+oUG.getDisplayTitle(user.getLanguage())+"</option>");
                }
                rulesScript.append("</optgroup>");
            }
            out.println("<tr><td align=\"right\" width=\"40%\">Rol/Grupo de usuarios para admnistración de tarifas: </td>");
            out.println("<td><select name=\""+MGR_ATTR+"\">"+rulesScript+"</select></td></tr>");
            out.println("</table>");
            out.println("</fieldset>");

            out.println("<fieldset> ");
            out.println("<table width=\"100%\" border=\"0\" cellpadding=\"5\" cellspacing=\"0\"> ");
            out.println(" <tr><td>");
            out.println(" <button dojoType=\"dijit.form.Button\" type=\"submit\" name=\"submit\" value=\"Submit\" onclick=\"if(jsValida())return true; else return false; \">Guardar</button>&nbsp;");
            out.println(" <button dojoType=\"dijit.form.Button\" type=\"reset\">Restablecer</button>");
            out.println(" </td></tr>");
            out.println("</table> ");
            out.println("</fieldset> ");
            out.println("</form>");
            out.println("</div>");

            out.println("<script type=\"text/javascript\">");
            out.println("function jsValida() {");
            out.println("    return true;");
            out.println("}");
            out.println("</script>");
        }
        out.flush();
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        String action = response.getAction();
        if(action.equalsIgnoreCase(ADMIN_AXN)) {
            String editaccess = request.getParameter(MGR_ATTR);
            if( editaccess!=null ) {
                getResourceBase().setAttribute(MGR_ATTR, URLDecoder.decode(editaccess, "UTF-8"));
                try {
                    getResourceBase().updateAttributesToDB();
                    response.setRenderParameter(UPDATE_DONE, UPDATE_DONE);
                } catch (Exception e) {
                    log.error("Error al guardar Role/UserGroup para acceso al RateManager. ", e);
                }
            }
        }
    }

    private boolean userCanEdit(final User user) {
        boolean access = false;
        String roleName = getResourceBase().getAttribute("editRole", "0");        
        try {
            if( user!=null && !roleName.equals("0") ) {
                SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
                GenericObject gobj = null;
                try {
                    gobj = ont.getGenericObject(roleName);
                } catch (Exception e) {
                    log.error("Errror InlineEdit.userCanEdit()", e);
                }

                UserGroup ugrp = null;
                Role urole = null;

                if(!roleName.equals("0")) {
                    if(gobj != null) {
                        if(gobj instanceof UserGroup) {
                            ugrp = (UserGroup) gobj;
                            if(user.hasUserGroup(ugrp)) {
                                access = true;
                            }
                        }else if(gobj instanceof Role) {
                            urole = (Role) gobj;
                            if(user.hasRole(urole)) {
                                access = true;
                            }
                        }
                    }else {
                        access = true;
                    }
                }else {
                    access = true;
                }
            }
        }catch(Exception e) {
            access = false;
        }

        if( roleName.equals("0") || user==null )
            access=true;

        return access ;
    }
}
