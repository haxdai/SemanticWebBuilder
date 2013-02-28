package com.infotec.eworkplace.swb.resources;

import com.infotec.cvi.swb.CV;
import com.infotec.eworkplace.swb.Familia;
import com.infotec.eworkplace.swb.Persona;
import com.infotec.eworkplace.swb.SWProfile;
import com.infotec.eworkplace.swb.Telefono;
import com.infotec.eworkplace.swb.TemaInteres;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.JSONArray;
import org.json.JSONObject;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.base.util.ImageResizer;
import org.semanticwb.model.Resource;
import org.semanticwb.model.Resourceable;
import org.semanticwb.model.SWBComparator;
import org.semanticwb.model.User;
import org.semanticwb.model.UserGroup;
import org.semanticwb.model.UserGroupable;
import org.semanticwb.model.UserRepository;
import org.semanticwb.model.WebPage;
import org.semanticwb.model.WebSite;
import org.semanticwb.portal.api.GenericAdmResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;

/**
 *
 * @author carlos.ramos
 */

public class SWProfileManager extends GenericAdmResource {
    private static Logger log = SWBUtils.getLogger(SWProfileManager.class);
    
    public static final String Mode_CHGPHTO = "foto";
    public static final String Mode_VIEWPRFL = "prfl";
    public static final String Mode_FAV = "fav";
    
    public static final String RH_Role = "RH";
    
    public static final String Mode_ADS = "ous";
    public static final String Mode_IBSS = "ibss";
    
    //private Role subgerente, gerente, director;
    private UserGroup infotec;
    private final String ugCorpId = "OU:Corporativo";
    
    private String contentURL;
    public String ibssJsonStore;

    /**
     * @return the infotec
     */
    public UserGroup getInfotec() {
        return infotec;
    }
    
        
    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        final String mode = paramRequest.getMode();
        if(Mode_ADS.equals(mode))
            doAds(request, response, paramRequest);
        else if(Mode_IBSS.equals(mode))
            doInmediateBoss(request, response, paramRequest);
//        else if("fam".equals(mode))
//            doFam(request, response, paramRequest);
        else if(Mode_CHGPHTO.equals(mode))
            doChangePhoto(request, response, paramRequest);
        else if(Mode_VIEWPRFL.equals(mode))
            doResume(request, response, paramRequest);
        else
            super.processRequest(request, response, paramRequest);
    }
    
    @Override
    public void setResourceBase(Resource res) throws SWBResourceException {
        super.setResourceBase(res);
        UserRepository ur = res.getWebSite().getUserRepository();
//        subgerente = ur.getRole("Subgerente");
//        gerente = ur.getRole("Gerente");
//        director = ur.getRole("Director");
        infotec = ur.getUserGroup(ugCorpId);
        
        try {
            JSONObject base = new JSONObject();
            base.put("identifier", "id");
            base.put("label", "name");
            JSONArray items = new JSONArray();
            base.put("items", items);
            
            User user;
            UserGroup ug;
            Iterator<UserGroup> it = getInfotec().listChilds();
            while(it.hasNext()) {
                ug = it.next();
                if(ug==null)
                    continue;
                Iterator<UserGroupable> ugbles = ug.listUsers();
                while(ugbles.hasNext()) {
                    UserGroupable ugble = ugbles.next();
                    if(ugble instanceof User) {
                        user = (User)ugble;
//                        if(user.hasRole(subgerente)||user.hasRole(gerente)||user.hasRole(director)) {
                            JSONObject jtipo = new JSONObject();
                            items.put(jtipo);
                            jtipo.put("id", user.getId());
                            jtipo.put("name", user.getFullName());
                            jtipo.put("dir", ug.getId());
//                        }
                    }
                }
            }      
            ibssJsonStore = base.toString();
        } catch (Exception e) {
            log.error(e);
        }
        
        Iterator<Resourceable> resourceables = getResourceBase().listResourceables();
        while(resourceables.hasNext()) {
            Resourceable resourceable = resourceables.next();
            if( resourceable instanceof WebPage ) {
                contentURL = ((WebPage)resourceable).getUrl();
                break;
            }
        }        
    }
    
    public void doAds(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("application/json; charset=ISO-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        
        User user = paramRequest.getUser();
        if(!user.isSigned()) {
            return;
        }
        
        PrintWriter out = response.getWriter();
        try {
            JSONObject base = new JSONObject();
            base.put("identifier", "id");
            base.put("label", "name");
            JSONArray items = new JSONArray();
            base.put("items", items);
            UserGroup ug;
            Iterator<UserGroup> it = getInfotec().listChilds();
            it = SWBComparator.sortByDisplayName(it, user.getLanguage());
            while(it.hasNext()) {
                ug = it.next();
                if(!user.hasUserGroup(ug)) {
                    continue;
                }
                JSONObject jtipo = new JSONObject();
                items.put(jtipo);
                jtipo.put("id", ug.getId());
                jtipo.put("name", ug.getTitle());
                break;
            }
            out.print(base.toString());
        } catch (Exception e) {
            log.error(e);
            out.println("no data");
        }
        out.flush();
        out.close();
    }
    
    public void doInmediateBoss(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("application/json; charset=ISO-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        
        PrintWriter out = response.getWriter();
        
//        String ret = "";
//        try {
//            JSONObject base = new JSONObject();
//            base.put("identifier", "id");
//            base.put("label", "name");
//            JSONArray items = new JSONArray();
//            base.put("items", items);
//            
//            User user;
//            UserGroup ug;
//            Iterator<UserGroup> it = infotec.listChilds();
//            while(it.hasNext()) {
//                ug = it.next();
//                if(ug==null)
//                    continue;
//                Iterator<UserGroupable> ugbles = ug.listUsers();
//                while(ugbles.hasNext()) {
//                    UserGroupable ugble = ugbles.next();
//                    if(ugble instanceof User) {
//                        user = (User)ugble;
//                        if(user.hasRole(subgerente)||user.hasRole(gerente)||user.hasRole(director)) {
//                            JSONObject jtipo = new JSONObject();
//                            items.put(jtipo);
//                            jtipo.put("id", user.getId());
//                            jtipo.put("name", user.getFullName());
//                            jtipo.put("dir", ug.getId());
//                        }
//                    }
//                }
//            }      
//            ret = base.toString();
//        } catch (Exception e) {
//            log.error(e);
//        }
        out.print(ibssJsonStore);
        out.flush();
        out.close();
    }
    
    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("text/html; charset=ISO-8859-1");
        
        User user = paramRequest.getUser();
        if(!user.isSigned())
            return;
        
        Resource base = getResourceBase();
        WebSite wsite = base.getWebSite();
        PrintWriter out =  response.getWriter();
        if(paramRequest.getCallMethod()==SWBParamRequest.Call_STRATEGY) {
//                SemanticProperty sp = SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#miPerfilSL");
//                SWProfile profile = (SWProfile)user.getExtendedAttribute(sp);
//                if(profile==null) {
//                    profile = SWProfile.ClassMgr.createSWProfile(user.getId(), wsite);
//                    try {
//                        user.setExtendedAttribute(sp, profile);
//                    }catch(SWBException swbe) {
//                        swbe.printStackTrace(System.out);
//                    }
//                }
            SWProfile profile = SWProfile.ClassMgr.getSWProfile(user.getId(), wsite);
            if(profile==null) {
                profile = SWProfile.ClassMgr.createSWProfile(user.getId(), wsite);
            }
            //out.println("creator="+profile.getCreator().getLogin());
            //out.println("user="+user.getLogin());
            //out.println("user.equals(profile.getCreator())="+user.equals(profile.getCreator()));
            if( user.equals(profile.getCreator()) ) {
                final String urlLogout = SWBPlatform.getContextPath()+"/"+SWBPlatform.getEnv("swb/distributor")+"/"+wsite.getId()+"/"+wsite.getHomePage().getId()+"/_lang/"+user.getLanguage();
                final String pimg;
                if(user.getPhoto()==null)
                    pimg = SWBPortal.getWebWorkPath()+"/models/"+wsite.getId()+"/css/user.jpg";
                else
                    pimg = SWBPortal.getWebWorkPath()+profile.getWorkPath()+"/"+user.getPhoto();

//                String surl = paramRequest.getWebPage().getUrl();
//                Iterator<Resourceable> res = base.listResourceables();
//                while(res.hasNext()) {
//                    Resourceable re = res.next();
//                    if( re instanceof WebPage ) {
//                        surl = ((WebPage)re).getUrl();
//                        break;
//                    }
//                }
//                final String contentURL = surl;

                out.println("<li class=\"herr2\">");
                out.println("  <a class=\"MenuBarItemSubmenu\" href=\""+SWBPlatform.getContextPath()+"/"+SWBPlatform.getEnv("swb/distributor")+"/"+wsite.getId()+"/espacio_personal\" title=\"\">Entrar a mi espacio</a>");
                out.println("  <ul>");
                out.println("    <li>");
                out.println("      <div class=\"user\">");
                out.println("        <img src=\""+pimg+"\" alt=\""+user.getLogin()+"\" />");
                out.println("        <strong>"+user.getFullName()+"</strong>");
                out.println("      </div>");
                out.println("    </li>");
                out.println("    <li class=\"perfil\">");
                out.println("      <p><a href=\""+contentURL+"?act="+SWBResourceURL.Action_EDIT+"\" title=\"Editar mi perfil\">Editar mi perfil</a></p>");
                out.println("      <p><a href=\""+SWBPlatform.getContextPath()+"/"+SWBPlatform.getEnv("swb/distributor")+"/"+wsite.getId()+"/"+wsite.getWebPage("Favoritos").getId()+"/_lang/"+user.getLanguage()+"\" title=\"Ir a mis favoritos\">Mis favoritos</a></p>");
                out.println("      <p><a href=\""+SWBPlatform.getContextPath()+"/"+SWBPlatform.getEnv("swb/distributor")+"/"+wsite.getId()+"/Mis_tareas"+"/_lang/"+user.getLanguage()+"\" title=\"Ir a mis solicitudes\">Mis solicitudes</a></p>");
                out.println("      <p><a href=\""+contentURL+"?act="+SWBResourceURL.Action_ADD+"\" title=\"Ver mi perfil\">Ver mi perfil</a></p>");
                out.println("      <p class=\"salir\"><a href=\""+SWBPlatform.getContextPath()+"/login?wb_logout=true&wb_goto="+urlLogout+"\" title=\"Salir\">Salir</a></p>");
                out.println("    </li>");
                out.println("    <li style=\"clear:both; height:1px;\"></li>");
                out.println("  </ul>");
                out.println("</li>");
            }else {
                out.println("<p>Usuario no autorizado</p>");
                log.info("Acceso no autorizado");
            }
        }else {
            final String action = request.getParameter("act");
            if(SWBResourceURL.Action_EDIT.equals(action)) {
                SWProfile profile = SWProfile.ClassMgr.getSWProfile(user.getId(), wsite);
                if( user.equals(profile.getCreator()) ) {
                    doEdit(request, response, paramRequest);
                }
            }else {
                doResume(request, response, paramRequest);
            }
            
            
//            if(user.isSigned()) {
//                WebSite wsite = base.getWebSite();
            
//                SWProfile profile = SWProfile.ClassMgr.getSWProfile(user.getId(), wsite);
//                SWProfile profile = SWProfile.ClassMgr.listSWProfileByCreator(user).next();
//                if( user.equals(profile.getCreator()) ) {
//                    final String action = request.getParameter("action"); 
//                    HttpSession session = request.getSession(true);
//                    String send = (String)session.getAttribute(Send);
//                    session.removeAttribute(Send);
//                    if(SWBResourceURL.Action_EDIT.equals(action)) {
//                        doEdit(request, response, paramRequest);
//                    }
//                    else if(Mode_CHGPHTO.equals(send)) {
//                        doChangePhoto(request, response, paramRequest);
//                    }else {
//                        //out.println("vista del perfil de "+user.getFullName());
//                        try {
//                            final String jsp = "/work/models/"+paramRequest.getWebPage().getWebSiteId()+"/jsp/swprofile/view.jsp";
//                            request.setAttribute("paramRequest", paramRequest);
//                            RequestDispatcher rd = request.getRequestDispatcher(jsp);
//                            rd.include(request, response);
//                        }catch(Exception e) {
//                            log.error(e);
//                        }
//                    }
//                }
//                else {
//                    WebSite site = base.getWebSite();
//                    UserRepository ur = site.getUserRepository();
//                    Role role = ur.getRole(RH_Role);
//                    if(user.hasRole(role)) {
//                         try {
//                            final String jsp = "/work/models/"+paramRequest.getWebPage().getWebSiteId()+"/jsp/swprofile/rhedit.jsp";
//                            request.setAttribute("paramRequest", paramRequest);
//                            RequestDispatcher rd = request.getRequestDispatcher(jsp);
//                            rd.include(request, response);
//                        }catch(Exception e) {
//                            log.error(e);
//                        }
//                    }else {
//                        try {
//                            final String jsp = "/work/models/"+paramRequest.getWebPage().getWebSiteId()+"/jsp/swprofile/view.jsp";
//                            request.setAttribute("paramRequest", paramRequest);
//                            RequestDispatcher rd = request.getRequestDispatcher(jsp);
//                            rd.include(request, response);
//                        }catch(Exception e) {
//                            log.error(e);
//                        }
//                    } 
//                }
//            }
        }
    }
    
    public void doResume(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        User user = paramRequest.getUser();
        if(!user.isSigned())
            return;
        
//        String surl = paramRequest.getWebPage().getUrl();
//        Iterator<Resourceable> res = getResourceBase().listResourceables();
//        while(res.hasNext()) {
//            Resourceable re = res.next();
//            if( re instanceof WebPage ) {
//                surl = ((WebPage)re).getUrl();
//                break;
//            }
//        }
//        final String contentURL = surl;
        
        final String path = "/work/models/" + paramRequest.getWebPage().getWebSite().getId() + "/jsp/" + this.getClass().getSimpleName() + "/viewProfile.jsp";
        RequestDispatcher dis = request.getRequestDispatcher(path);
        try {
            request.setAttribute("paramRequest", paramRequest);
            request.setAttribute("contentURL", contentURL);
            dis.include(request, response);
        }catch(Exception e) {
            log.error(e);
        }
        /*response.setContentType("text/html; charset=UTF-8");
        
        User user = paramRequest.getUser();
        if(!user.isSigned())
            return;
        
        Resource base = getResourceBase();
        WebSite wsite = base.getWebSite();
        PrintWriter out =  response.getWriter();
        
        SWProfile profile = SWProfile.ClassMgr.getSWProfile(user.getId(), wsite);
        if( user.equals(profile.getCreator()) ) {
            out.println("<div id=\"cuerpo_texto\">");
            out.println(" <div id=\"perfil_usuario\">");
            out.println("  <div id=\"formPerfil\">");
            out.println("   <div id=\"menu_perfil\">");
            out.println("    <ul>");
            out.println("     <li><a href=\""+paramRequest.getRenderUrl().setMode(SWBResourceURL.Mode_EDIT)+"\">Editar mi perfil</a></li>");
            out.println("     <li><a href=\"#\">Mis favoritos</a></li>");
            out.println("     <li><a href=\"#\">Mis solicitudes</a></li>");
            out.println("     <li><a href=\"#\">Mi perfil</a></li>");
            out.println("    </ul>");
            out.println("   </div>");
            out.println("   <div class=\"pBase\">");
            out.println("    <div class=\"pModulos\">");
            final String pimg;
            if(user.getPhoto()==null)
                pimg = SWBPortal.getWebWorkPath()+"/models/"+wsite.getId()+"/css/user.jpg";
            else
                pimg = SWBPortal.getWebWorkPath()+profile.getWorkPath()+"/"+user.getPhoto();

            out.println("   <div class=\"foto\"><img src=\""+pimg+"\" alt=\""+user.getFullName()+"\" /></div>");
            out.println("   <div class=\"user\">");
            out.println("    <p class=\"name\">"+user.getFullName()+"</p>");
            out.println("     <p clas=\"pOcupacion\">"+profile.getPuesto()+"</p>");
            out.println("     <p>"+(profile.getPuesto()==null?"":profile.getPuesto())+"</p>");
            out.println("   </div>");
            
            
            
            
            
            out.println("    <a href=\"#\" class=\"pCM\">Conoce m&aacute;s de Rosy</a>");
            out.println("   </div>");
            out.println("   <div class=\"pModulos\">");
            out.println("    <div class=\"pColumnsx\">");
            out.println("     <p class=\"pOcupacion\">Contacto Interno</p>");
            out.println("     <p>&nbsp;</p>");
            SemanticProperty ext = SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#extension");
            out.println("     <p>Ext. "+(user.getExtendedAttribute(ext)==null?"":user.getExtendedAttribute(ext))+"</p>");
            out.println("     <p>e-mail: <a href=\"#\">"+user.getEmail()+"</a></p>");
            out.println("     <p>&nbsp;</p>");
            out.println("     <p>"+profile.getUbicacion()+"</p>");
            out.println("    </div>");
            out.println("    <div class=\"pColumnsx\">");
            out.println("     <p class=\"pOcupacion\">Colaboradores Asociados</p>");
            out.println("     <p>&nbsp;</p>");
            out.println("     <p>Fernando L&oacute;pez</p>");
            out.println("     <p>Carlos Espinoza</p>");
            out.println("     <p>Edgar Aguilar</p>");
            out.println("     <p>Eva Pedroza</p>");
            out.println("     <p>Manuel Menchca</p>");
            out.println("     <p>&nbsp;</p>");
            out.println("     <p><a href=\"#\">Ver todos</a></p>");
            out.println("    </div>");
            out.println("   </div>");
            out.println("   <div class=\"pModulos\">");
            out.println("    <div class=\"pColumnsx\">");
            out.println("     <p class=\"pOcupacion\">Experiencia en infotec</p>");
            out.println("     <p>&nbsp;</p>");
            out.println("     <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam at   libero a elit sollicitudin sollicitudin. Aenean sem felis, mattis quis   elementum lacinia, consectetur ac lacus. Vestibulum facilisis tortor   quis mi facilisis tempus. Donec laoreet enim in justo lacinia   consectetur.</p>");
            out.println("     <p>&nbsp;</p>");
            out.println("     <p class=\"pSubP\"><span class=\"pOcupacion\">Ha participado en</span></p>");
            out.println("     <p>&nbsp;</p>");
            out.println("     <p>Vivamus tempor tortor</p>");
            out.println("     <p>Vel libero varius viverra</p>");
            out.println("     <p>Maecenas   ullamcorper</p>");
            out.println("     <p> Ligula vel interdum ultricies</p>");
            out.println("     <p>&nbsp;</p>");
            out.println("     <p><a href=\"#\">Seguir leyendo</a></p>");
            out.println("    </div>");
            out.println("    <div class=\"pColumnsx\">");
            out.println("     <p class=\"pOcupacion\">Habilidades</p>");
            out.println("     <p>&nbsp;</p>");
            out.println("     <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam at   libero a elit sollicitudin sollicitudin. Aenean sem felis, mattis quis   elementum lacinia, consectetur ac lacus. Vestibulum facilisis tortor   quis mi facilisis tempus. Donec laoreet enim in justo lacinia   consectetur.</p>");
            out.println("     <p>&nbsp;</p>");
            out.println("     <p><span class=\"pOcupacion\">Conocimientos</span></p>");
            out.println("     <p>&nbsp;</p>");
            out.println("     <p>Vivamus tempor tortor</p>");
            out.println("     <p>Vel libero varius viverra</p>");
            out.println("     <p>Maecenas   ullamcorper</p>");
            out.println("     <p>Ligula vel interdum ultricies</p>");
            out.println("     <p>&nbsp;</p>");
            out.println("     <p><a href=\"#\">Seguir leyendo</a></p>");
            out.println("    </div>");
            out.println("   </div>");
            out.println("   <br class=\"clear\" />");
            out.println("  </div>");
            out.println(" </div>");
            out.println("</div>");
        }*/
    }

    @Override
    public void doEdit(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        User user = paramRequest.getUser();
        if(!user.isSigned())
            return;
        
        WebSite wsite = getResourceBase().getWebSite();

        Persona persona = Persona.ClassMgr.getPersona(user.getId(), wsite);
        if(persona==null) {
            persona = Persona.ClassMgr.createPersona(user.getId(), wsite);
        }
        
        final String path = "/work/models/" + wsite.getId() + "/jsp/" + this.getClass().getSimpleName() + "/editProfile.jsp";
        RequestDispatcher dis = request.getRequestDispatcher(path);
        try {
            request.setAttribute("this", this);
            request.setAttribute("paramRequest", paramRequest);
            request.setAttribute("contentURL", contentURL);
            dis.include(request, response);
        }catch(Exception e) {
            log.error(e);
        }
    }

    private void setRenderParameter(HttpServletRequest request, SWBActionResponse response) {
        response.setRenderParameter("email", request.getParameter("email"));
        response.setRenderParameter("pos", request.getParameter("pos"));
        response.setRenderParameter("postit", request.getParameter("postit"));
        response.setRenderParameter("prsnld", request.getParameter("prsnld"));
        response.setRenderParameter("gsts", request.getParameter("gsts"));
        response.setRenderParameter("ideas", request.getParameter("ideas"));
        if(!request.getParameter("ld").isEmpty())
            response.setRenderParameter("ld", request.getParameter("ld"));
        response.setRenderParameter("tfo", request.getParameter("tfo"));
        if(!request.getParameter("ext").isEmpty())
            response.setRenderParameter("ext", request.getParameter("ext"));
        response.setRenderParameter("loc", request.getParameter("loc"));
        response.setRenderParameter("ads", request.getParameter("ads"));
        response.setRenderParameter("chief", request.getParameter("chief"));
        response.setRenderParameter("extdr", request.getParameter("extdr"));
    }
    
    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        final User user = response.getUser();        
        if(!user.isSigned())
            return;     
        Resource base = getResourceBase();
        final String action = response.getAction();       
        final WebSite wsite = base.getWebSite();
        /*if(Send_VIEW.equals(action)) {
            final String url = SWBPlatform.getContextPath()+"/"+SWBPlatform.getEnv("swb/distributor")+"/"+wsite.getId()+"/vista_perfil"+"/_lang/"+user.getLanguage();
            response.sendRedirect(url);
        }else if(Send_EDIT.equals(action)) {
            response.setMode(SWBResourceURL.Mode_EDIT);
            final String url = SWBPlatform.getContextPath()+"/"+SWBPlatform.getEnv("swb/distributor")+"/"+wsite.getId()+"/editar_datos"+"/_lang/"+user.getLanguage();
            request.getSession(true).setAttribute(Send, Send_EDIT);
            response.sendRedirect(url);
        }else if(Mode_CHGPHTO.equals(action)) {
            final String url = SWBPlatform.getContextPath()+"/"+SWBPlatform.getEnv("swb/distributor")+"/"+wsite.getId()+"/editar_foto"+"/_lang/"+user.getLanguage();
            request.getSession(true).setAttribute(Send, Mode_CHGPHTO);
            response.sendRedirect(url);
        }else if(Send_REQ.equals(action)) {
            final String url = SWBPlatform.getContextPath()+"/"+SWBPlatform.getEnv("swb/distributor")+"/"+wsite.getId()+"/solicitudes"+"/_lang/"+user.getLanguage();
            response.sendRedirect(url);
        }else if(Mode_FAV.equals(action)) {
            final String url = SWBPlatform.getContextPath()+"/"+SWBPlatform.getEnv("swb/distributor")+"/"+wsite.getId()+"/favoritos"+"/_lang/"+user.getLanguage();
            response.sendRedirect(url);
        }
        else */
        if(SWBResourceURL.Action_EDIT.equals(action)) {
System.out.println("\n\n\nprocessAction edit............");
            SWProfile profile = SWProfile.ClassMgr.getSWProfile(user.getId(), wsite);
            if( user.equals(profile.getCreator()) ) {
//            SemanticProperty sp = SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#miPerfilSL");
//            SWProfile profile = (SWProfile)user.getExtendedAttribute(sp);
//            profile.setMisIdeas(request.getParameter("ideas"));
//            profile.setUbicacion(request.getParameter("loc"));
                
                response.setMode(SWBResourceURL.Mode_VIEW);
                boolean isMultipart = ServletFileUpload.isMultipartContent(request);
                if(isMultipart) {
                    try {
                        chgPhto(request, response);
                        /*final String url = SWBPlatform.getContextPath()+"/"+SWBPlatform.getEnv("swb/distributor")+"/"+wsite.getId()+"/editar_datos"+"/_lang/"+user.getLanguage();
                        request.getSession(true).setAttribute(Send, Send_EDIT);
                        response.sendRedirect(url);*/
                    }catch(Exception e) {
                        response.setRenderParameter("act",SWBResourceURL.Action_EDIT);
                    }
                }
                else {
System.out.println("else");
                    try {
                    UserRepository ur = wsite.getUserRepository();
                    Persona persona = Persona.ClassMgr.getPersona(user.getId(), wsite);
                    
                    String email = request.getParameter("email");
System.out.println("email="+email);
                    if(!SWBUtils.EMAIL.isValidEmailAddress(email)) {
System.out.println("problemas 1");
                        throw new Exception(response.getLocaleString("promptMsgFaultEmail"));
                    }
System.out.println("paso validacion email");
//                    if(!"usuario.desconocido@infotec.com.mx".equals(user.getEmail())) { // quitar esta línea después
                        if(ur.getUserByEmail(email)==null) {
System.out.println("problemas 2");
                            throw new Exception(response.getLocaleString("promptMsgErrNoUser"));
                        }
                        if(ur.getUserByEmail(email)!=null && !user.equals(ur.getUserByEmail(email))) {
System.out.println("problemas 3");
                            throw new Exception(response.getLocaleString("promptMsgErrSurrogacy"));
                        }
//                    }
                    
                    String pos = SWBUtils.XML.replaceXMLChars(request.getParameter("pos")).trim();
                    if(pos.isEmpty()) {
System.out.println("problemas 4");
                        throw new Exception(response.getLocaleString("promptMsgFaultPosition"));
                    }
                    String postit = SWBUtils.XML.replaceXMLChars(request.getParameter("postit"));
                    String prsnld = SWBUtils.XML.replaceXMLChars(request.getParameter("prsnld")).trim();
                    /*if(prsnld.isEmpty()) {
                        throw new Exception(response.getLocaleString("promptMsgFaultPersonality"));
                    }*/
                    String gsts = SWBUtils.XML.replaceXMLChars(request.getParameter("gsts")).trim();
                    /*if(gsts.isEmpty()) {
                        throw new Exception(response.getLocaleString("promptMsgFaultLikes"));
                    }*/
                    String ideas = SWBUtils.XML.replaceXMLChars(request.getParameter("ideas")).trim();
                    /*if(ideas.isEmpty()) {
                        throw new Exception(response.getLocaleString("promptMsgFaultIdeas"));
                    }*/
                    int tfo = 0;
                    try {
                        tfo = Integer.parseInt(request.getParameter("tfo"));
                    }catch(Exception e) {
System.out.println("problemas 5");
                        throw new Exception(response.getLocaleString("promptMsgFaultPhone"));
                    }
                    String loc = SWBUtils.XML.replaceXMLChars(request.getParameter("loc")).trim();
                    if(loc.isEmpty()) {
System.out.println("problemas 6");
                        throw new Exception(response.getLocaleString("promptMsgFaultLoc"));
                    }
                    String adsId = request.getParameter("ads");
System.out.println("adsId="+adsId);
                    UserGroup adscription = null;
                    adscription = ur.getUserGroup(adsId);
System.out.println("adscription="+adscription);
                    if(!infotec.hasChild(adscription)) {
System.out.println("infotec no tiene hijo "+adscription);
                        throw new Exception(response.getLocaleString("promptMsgFaultgDr"));
                    }
                    String ichiefId = request.getParameter("chief");
System.out.println("ichiefId="+ichiefId);
                    if(ichiefId==null) {
                        throw new Exception(response.getLocaleString("promptMsgFaultIBoss"));
                    }
                    if(ur.getUser(ichiefId)==null) {
System.out.println("no existe jefe");
                        throw new Exception(response.getLocaleString("promptMsgErrNoUser"));
                    }
                    /*if(user.equals(ur.getUser(ichiefId))) {
                        throw new Exception(response.getLocaleString("promptMsgErrLoopRef"));
                    }*/
                    int xtdr=0;

/*SemanticClass sc = org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Empleado");
SemanticProperty sp = sc.getProperty("extension");
System.out.println("extension="+sp);
user.setExtendedAttribute(sp, new Integer(911));
Object obj = user.getExtendedAttribute(sp);
System.out.println("obj="+obj);*/
/*Iterator<SemanticProperty> list = org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Empleado").listProperties();
while (list.hasNext()) {
    SemanticProperty sp = list.next();
    if(sp.isInt() && "intranet:extension".equals(sp.getPropId())) {
        SemanticObject dp = sp.getDisplayProperty();
        System.out.println("Processing..." + sp.getDisplayName()+".");
        System.out.println("sp.getURI()=" + sp.getURI()+".");
        System.out.println("sp.getName()=" + sp.getName()+".");
        System.out.println("sp.getDisplayName()=" + sp.getDisplayName()+".");
        System.out.println("sp.getPropId()=" + sp.getPropId()+".");
        System.out.println("---------");
        user.setExtendedAttribute(sp, new Integer(911));
        Object obj = user.getExtendedAttribute(sp);
        System.out.println("obj="+obj);
    }
}*/

//                    try {
//                        SemanticProperty ext = SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#noe");
//                        xtdr = Integer.parseInt(request.getParameter("extdr"));
//                        user.setExtendedAttribute(ext, xtdr);
//                    }catch(Exception e) {
//                        alertmsg.append(response.getLocaleString("promptMsgFaultPhoneExtDr")).append("\n");
//                    }
System.out.println("pos="+pos);
System.out.println("postit="+postit);
System.out.println("prsnld="+prsnld);
System.out.println("gsts="+gsts);
System.out.println("ideas="+ideas);
System.out.println("email="+email);
                    profile.setPuesto(pos);
                    profile.setPostit(postit);
                    profile.setMiPersonalidad(prsnld);
                    profile.setMisGustos(gsts);
                    profile.setMisIdeas(ideas);
                    user.setEmail(email);
//                    try {
                        int ld, xtn;
                        try {
                            ld = Integer.parseInt(request.getParameter("ld"));
                        }catch(NumberFormatException e) {
                            ld = 0;
                        }
                        try {
                            xtn = Integer.parseInt(request.getParameter("ext"));
                        }catch(NumberFormatException e) {
                            xtn = 0;
                        }
System.out.println("ld="+ld);
System.out.println("tfo="+tfo);
System.out.println("xtn="+xtn);
                        persona.removeAllTelefonoByTipo(Telefono.TipoTelefono.Trabajo);
                        Telefono tel = Telefono.ClassMgr.createTelefono(wsite);
                        tel.setLada(ld);
                        tel.setNumero(tfo);
                        tel.setExtension(xtn);
                        tel.setTipo(Telefono.TipoTelefono.Trabajo.name());
                        persona.addTelefono(tel);
//                    }catch(Exception nfe) {
//                    }
System.out.println("loc="+loc);
                    profile.setUbicacion(loc);
                    profile.setJefeInmediato(ur.getUser(ichiefId));
                    if(!user.hasUserGroup(adscription)) {
                        user.removeAllUserGroup();
                        user.addUserGroup(getInfotec());
                        user.addUserGroup(adscription);
                    }
                    if(request.getParameterValues("mti")!=null && request.getParameterValues("mti").length>0) {
                        profile.removeAllTemaInteres();
                        String[] mtis = request.getParameterValues("mti");
                        for(String mti:mtis)
                            try {
                                profile.addTemaInteres(TemaInteres.ClassMgr.getTemaInteres(mti, wsite));
                            }catch(Exception e) {
                                log.error(e);
                            }
                    }else {
                        profile.removeAllTemaInteres();
                    }
                    }catch(Exception e) {
                        response.setRenderParameter("act",SWBResourceURL.Action_EDIT);
                        response.setRenderParameter("alertmsg", e.getMessage());
                        setRenderParameter(request, response);
                    }
                }
            }
        }
    }
    
    public void doFam(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        
        Resource base = getResourceBase();
        WebSite wsite = base.getWebSite();
        User user = paramRequest.getUser();
        
        PrintWriter out =  response.getWriter();
        StringBuilder htm = new StringBuilder();
        
        SWProfile profile = SWProfile.ClassMgr.getSWProfile(user.getId(), wsite);
        if( user.isSigned() && user.equals(profile.getCreator()) ) {
            CV cv = CV.ClassMgr.getCV(user.getId(), wsite);
            Persona p = cv.getPersona();
            Iterator<Familia> familiares = p.listFamilias();
            if(familiares.hasNext()) {
                SWBResourceURL rem = paramRequest.getActionUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setAction(SWBResourceURL.Action_REMOVE);
                Familia f;
                while(familiares.hasNext()) {
                    f = familiares.next();
                    rem.setParameter("fid", f.getId());
                    htm.append("<li>");
                    htm.append("  <p class=\"tercio\">Nombre completo <br /><input type=\"text\" name=\"ncf\" value=\""+f.getNombre()+"\" /></p>");
                    htm.append("  <p class=\"tercio\">Parentesco <br /><input type=\"text\" name=\"p\" value=\""+f.getParentesco()+"\" /></p>");
                    htm.append("  <p class=\"tercio\">Direcci&oacute;n <br /><input type=\"text\" name=\"df\" value=\""+f.getDireccion()+"\" /></p>");
                    if(f.getTelefono()!=null)
                        htm.append("  <p class=\"tercio\"><label>Tel&eacute;fono</label><br/><label>Clave</label>:<input type=\"text\" name=\"cve\" value=\""+f.getTelefono().getLada()+"\" />&nbsp;<label>Tel&eacute;fono</label>:<input type=\"text\" name=\"tf\" value=\""+f.getTelefono().getNumero()+"\" /></p>");
                    else
                        htm.append("  <p class=\"tercio\"><label>Tel&eacute;fono</label><br/><label>Clave</label>:<input type=\"text\" name=\"cve\" value=\"\" />&nbsp;<label>Tel&eacute;fono</label>:<input type=\"text\" name=\"tf\" value=\"\" /></p>");
                    htm.append("  <p><input type=\"button\" onclick=\"postHtml('"+rem+"','fms')\" value=\"Eliminar\" /></p>");
                    htm.append("</li>");
                }
            }else {
                htm.append("<li>");
                htm.append("  <p class=\"tercio\">Nombre completo <br /><input type=\"text\" name=\"ncf\" value=\"\" /></p>");
                htm.append("  <p class=\"tercio\">Parentesco <br /><input type=\"text\" name=\"p\" value=\"\" /></p>");
                htm.append("  <p class=\"tercio\">Direcci&oacute;n <br /><input type=\"text\" name=\"df\" value=\"\" /></p>");
                htm.append("  <p class=\"tercio\"><label>Tel&eacute;fono</label><br/>");
                htm.append("   <label>Clave</label>:<input type=\"text\" name=\"cve\" value=\"\" />");
                htm.append("   <label>Tel&eacute;fono</label>:<input type=\"text\" name=\"tf\" value=\"\" />");
                htm.append("  </p>");
                htm.append("</li>");
            }
        }
        out.println(htm.toString());
    }
    
    public void doChangePhoto(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("text/html; charset=ISO-8859-1");
        
        User user = paramRequest.getUser();
        if(!user.isSigned())
            return;
        
        Resource base = getResourceBase();
        WebSite wsite = base.getWebSite();
        PrintWriter out =  response.getWriter();
        
        SWProfile profile = SWProfile.ClassMgr.getSWProfile(user.getId(), wsite);
        if( user.equals(profile.getCreator()) ) {
            if(paramRequest.getCallMethod()==paramRequest.Call_STRATEGY) {
                doView(request, response, paramRequest);
            }else {
                final String lang = user.getLanguage();
                final String axn = paramRequest.getActionUrl().setAction(SWBResourceURL.Action_EDIT).toString();
                StringBuilder htm = new StringBuilder();
                htm.append(script());
                htm.append("<form id=\"profile/user\" method=\"post\" enctype=\"multipart/form-data\" action=\""+axn+"\">");
                htm.append("<div id=\"perfil_usuario\">");
                htm.append("    <div id=\"formPerfil\">");
                htm.append("        <div class=\"perfil divisor\">");
                htm.append("            <h3>Mi perfil</h3>");
                final String pimg;
                if(user.getPhoto()==null)
                    pimg = SWBPortal.getWebWorkPath()+"/models/"+wsite.getId()+"/css/user.jpg";
                else
                    pimg = SWBPortal.getWebWorkPath()+profile.getWorkPath()+"/"+user.getPhoto();
                htm.append("            <div class=\"foto\"><img src=\""+pimg+"\" alt=\"\" /></div>");
                htm.append("            <div class=\"user\">");
                htm.append("                <p class=\"name\">"+user.getFullName()+"</p>");
                htm.append("                <p class=\"tercio\"><label for=\"foto\">Cambiar mi foto</label><input type=\"file\" name=\"foto\" id=\"foto\" value=\"\" /></p>");
                htm.append("            </div>");
                htm.append("            <div class=\"clearer\">&nbsp;</div>");
                htm.append("        </div>");
                htm.append("    </div>");
                htm.append("    <div class=\"guardar\"><input type=\"submit\" value=\"Guardar\" /></div>");
                htm.append("</div>");
                htm.append("</form>");
                out.println(htm.toString());
            }
        }
    }
    
    private String script() {
        StringBuilder js = new StringBuilder();
        js.append("\n");
        js.append("<script type=\"text/javascript\">\n");
        js.append("<!--\n");
        
        js.append("dojo.require(\"dojo.fx\");\n");
        js.append("dojo.require(\"dijit.dijit\");\n");
        
        js.append("function expande(domId) {\n");
        js.append("   var anim1 = dojo.fx.wipeIn( {node:domId, duration:500 });\n");
        js.append("   var anim2 = dojo.fadeIn({node:domId, duration:650});\n");
        js.append("   dojo.fx.combine([anim1,anim2]).play();\n");
        js.append("}\n");

        js.append("function collapse(domId) {\n");
        js.append("   var anim1 = dojo.fx.wipeOut( {node:domId, duration:500 });\n");
        js.append("   var anim2 = dojo.fadeOut({node:domId, duration:650});\n");
        js.append("   dojo.fx.combine([anim1, anim2]).play();\n");
        js.append(" }\n");        
                
        js.append("  var idx=0;\n");
        js.append("  function appendChild(childId, parentId) {\n");
        js.append("    var s = new String('');\n");
        js.append("    s = s.concat('<li class=\"aaaa\" id=\"');\n");
        js.append("    s = s.concat(childId);\n");
        js.append("    s = s.concat('\">');\n");
        js.append("    s = s.concat('<p class=\"entero\"><label>Nombre completo</label><br/><input type=\"text\" name=\"ncf\" value=\"\" /></p>');\n");
        js.append("    s = s.concat('<p class=\"tercio\"><label>Parentesco</label><br/><input type=\"text\" name=\"p\" value=\"\" /></p>');\n");
        js.append("    s = s.concat('<p class=\"tercio\"><label>Direcci&oacute;n</label><br/><input type=\"text\" name=\"df\" value=\"\" /></p>');\n");
        js.append("    s = s.concat('<p class=\"tercio\"><label>Tel&eacute;fono</label><br/>');\n");
        js.append("    s = s.concat('<label>Clave</label>:<input type=\"text\" name=\"cve\" value=\"\" />&nbsp;');\n");
        js.append("    s = s.concat('<label>N&uacute;mero</label>:<input type=\"text\" name=\"tf\" value=\"\" />');\n");
        js.append("    s = s.concat('</p>');\n");
        js.append("    s = s.concat('<p><input type=\"button\" onclick=\"dojo.destroy(\\''+childId+'\\')\" value=\"Eliminar\" /></p>');\n");
        js.append("    s = s.concat('<br clear=\"all\"/>');\n");
        js.append("    s = s.concat('</li>');\n");
        js.append("    dojo.place(s, parentId, 'last');\n");
        js.append("  }\n");
        js.append("-->\n");
        js.append("</script>\n");
        return js.toString();
    }
    
    private void chgPhto(HttpServletRequest request, SWBActionResponse response) throws Exception {
        Resource base = getResourceBase();    
        User user = response.getUser();
        SWProfile profile = SWProfile.ClassMgr.getSWProfile(user.getId(), base.getWebSite());
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (isMultipart && user.equals(profile.getCreator())) {
            //final String path = SWBPortal.getWebWorkPath()+base.getWorkPath()+"/"+user.getPhoto();
            final String path = SWBPortal.getWorkPath()+profile.getWorkPath();
            File file = new File(path);
            if(!file.exists()) {
                file.mkdirs();
            }
            Iterator<FileItem> iter = SWBUtils.IO.fileUpload(request, null);
            while(iter.hasNext()) {
                FileItem item = iter.next();
                if(item.isFormField()) {
                    continue;
                }else {
                    String filename = item.getName().toLowerCase();
                    if(!filename.isEmpty() && (filename.endsWith(".jpg")||filename.endsWith(".jpeg")||filename.endsWith(".gif")||filename.endsWith(".png"))) {
                        file = new File(path+"/"+filename);
                        item.write(file);
ImageResizer.shrinkTo(file, 135, 166, file, "png");
ImageResizer.resize(file, 135, 166, true, file, "png");
                        user.setPhoto(filename);
                    }
                    break;
                }
            }
        }
    }
}
