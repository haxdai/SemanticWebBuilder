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
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Resource;
import org.semanticwb.model.Resourceable;
import org.semanticwb.model.User;
import org.semanticwb.model.WebPage;
import org.semanticwb.model.WebSite;
import org.semanticwb.platform.SemanticProperty;
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
    private static final String Send = "send";
    private static final String Send_VIEW = "sview";
    private static final String Send_EDIT = "sedit";
    public static final String Mode_CHGPHTO = "foto";
    public static final String Mode_VIEWPRFL = "prfl";
    private static final String Send_REQ = "req";
    public static final String Mode_FAV = "fav";
    
    public static final String RH_Role = "RH";
    
    /*public String contentURL;
    @Override
    public void setResourceBase(Resource base) {
        Iterator<Resourceable> res = base.listResourceables();
        while(res.hasNext()) {
            Resourceable re = res.next();
            if( re instanceof WebPage ) {
                contentURL = ((WebPage)re).getUrl();
                break;
            }
        }
    }*/
    
    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String mode = paramRequest.getMode();
        if("fam".equals(mode))
            doFam(request, response, paramRequest);
        else if(Mode_CHGPHTO.equals(mode))
            doChangePhoto(request, response, paramRequest);
        else if(Mode_VIEWPRFL.equals(mode))
            doResume(request, response, paramRequest);
        else
            super.processRequest(request, response, paramRequest);
    }
    
    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        
        User user = paramRequest.getUser();
        if(!user.isSigned())
            return;
        
        Resource base = getResourceBase();
        WebSite wsite = base.getWebSite();
        PrintWriter out =  response.getWriter();

System.out.println("\n\n SWProfileManager.............");
System.out.println("Action = "+paramRequest.getAction());
        
        if(paramRequest.getCallMethod()==paramRequest.Call_STRATEGY) {
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
            if( user.equals(profile.getCreator()) ) {
                final String urlLogout = SWBPlatform.getContextPath()+"/"+SWBPlatform.getEnv("swb/distributor")+"/"+wsite.getId()+"/"+wsite.getHomePage().getId()+"/_lang/"+user.getLanguage();
                final String pimg;
                if(user.getPhoto()==null)
                    pimg = SWBPortal.getWebWorkPath()+"/models/"+wsite.getId()+"/css/user.jpg";
                else
                    pimg = SWBPortal.getWebWorkPath()+profile.getWorkPath()+"/"+user.getPhoto();

                String surl = paramRequest.getWebPage().getUrl();
                Iterator<Resourceable> res = base.listResourceables();
                while(res.hasNext()) {
                    Resourceable re = res.next();
                    if( re instanceof WebPage ) {
                        surl = ((WebPage)re).getUrl();
                        break;
                    }
                }
                final String contentURL = surl;

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
                out.println("      <p><a href=\""+contentURL+"?action="+SWBResourceURL.Action_EDIT+"\" title=\"Editar mi perfil\">Editar mi perfil</a></p>");
                out.println("      <p><a href=\""+SWBPlatform.getContextPath()+"/"+SWBPlatform.getEnv("swb/distributor")+"/"+wsite.getId()+"/"+wsite.getWebPage("Favoritos").getId()+"/_lang/"+user.getLanguage()+"\" title=\"Editar mis favoritos\">Mis favoritos</a></p>");
                out.println("      <p><a href=\""+contentURL+"\" title=\"\">Mis solicitudes</a></p>");
                out.println("      <p><a href=\""+contentURL+"?action="+SWBResourceURL.Action_ADD+"\" title=\"\">Ver mi perfil</a></p>");
                out.println("      <p class=\"salir\"><a href=\""+SWBPlatform.getContextPath()+"/login?wb_logout=true&wb_goto="+urlLogout+"\" title=\"Salir\">Salir</a></p>");
                out.println("    </li>");
                out.println("    <li style=\"clear:both; height:1px;\"></li>");
                out.println("  </ul>");
                out.println("</li>");
            }else {
                System.out.println("<p>Usuario no autorizado</p>");
                log.info("Acceso no autorizado");
            }
        }else {
            final String action = request.getParameter("action");
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
        
        String surl = paramRequest.getWebPage().getUrl();
        Iterator<Resourceable> res = getResourceBase().listResourceables();
        while(res.hasNext()) {
            Resourceable re = res.next();
            if( re instanceof WebPage ) {
                surl = ((WebPage)re).getUrl();
                break;
            }
        }
        final String contentURL = surl;
        
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
        
        final String path = "/work/models/" + paramRequest.getWebPage().getWebSite().getId() + "/jsp/" + this.getClass().getSimpleName() + "/editProfile.jsp";
        RequestDispatcher dis = request.getRequestDispatcher(path);
        try {
            request.setAttribute("paramRequest", paramRequest);
            dis.include(request, response);
        }catch(Exception e) {
            log.error(e);
        }

        
        /*Resource base = getResourceBase();
        WebSite wsite = base.getWebSite();
        PrintWriter out =  response.getWriter();
        
//        SemanticProperty sp = SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#miPerfilSL");
//        SWProfile profile = (SWProfile)user.getExtendedAttribute(sp);
        SWProfile profile = SWProfile.ClassMgr.getSWProfile(user.getId(), wsite);
        if(user.equals(profile.getCreator())) {
            final String lang = user.getLanguage();
            final String axn = paramRequest.getActionUrl().setAction(SWBResourceURL.Action_EDIT).toString();
            StringBuilder htm = new StringBuilder();
            htm.append(script());
            htm.append("<form id=\"profile/user\" method=\"post\" action=\""+axn+"\">");
//htm.append("<div id=\"perfil_usuario\">");
            htm.append("<div id=\"formPerfil\">");
            
            //datos empleado
            htm.append(" <div class=\"perfil divisor\">");
            htm.append("  <h3>Mi perfil | Datos personales | Curriculum Vitae</h3>");

            final String pimg;
            if(user.getPhoto()==null)
                pimg = SWBPortal.getWebWorkPath()+"/models/"+wsite.getId()+"/css/user.jpg";
            else
                pimg = SWBPortal.getWebWorkPath()+profile.getWorkPath()+"/"+user.getPhoto();

            htm.append("  <div class=\"foto\"><img src=\""+pimg+"\" alt=\""+user.getFullName()+"\" /><a href=\""+paramRequest.getRenderUrl().setMode(Mode_CHGPHTO)+"\">Cambiar foto</a></div>");
            htm.append("  <div class=\"usuario\">");
            htm.append("   <p class=\"name\">"+user.getFullName()+"</p>");
            htm.append("  </div>");
            htm.append("  <p class=\"mas_deMi\"><a href=\"javascript:expande('acercade_mi')\">M&aacute;s acerca de m&iacute;</a></p>");
            htm.append("  <div class=\"datos\">");     
            htm.append("   <div id=\"acercade_mi\" class=\"divisor\">");
            htm.append("    <h3>Acerca de mi</h3>");
            htm.append("    <div class=\"text_editor\">");
            htm.append("     <p class=\"status entero\"><label>Mi personalidad</label>");
            htm.append("     <textarea name=\"prsnld\" id=\"prsnld\" rows=\"4\" cols=\"70\">");
            htm.append(profile.getMiPersonalidad()==null?"":profile.getMiPersonalidad());
            htm.append("     </textarea></p>");
            htm.append("    </div>");
            
            htm.append("    <div class=\"text_editor\">");
            htm.append("     <p class=\"status entero\"><label>Mis gustos e intereses</label>");
            htm.append("     <textarea name=\"gsts\" id=\"gsts\" rows=\"4\" cols=\"70\">");
            htm.append(profile.getMisGustos()==null?"":profile.getMisGustos());
            htm.append("     </textarea></p>");
            htm.append("    </div>");
            
            htm.append("    <div class=\"status entero\">");
            htm.append("     <p class=\"status entero\"><label>Mis ideas para mejorar M&eacute;xico y el mundo</label>");
            htm.append("     <textarea name=\"ideas\" id=\"ideas\" rows=\"4\" cols=\"70\">");
            htm.append(profile.getMisIdeas()==null?"":profile.getMisIdeas());
            htm.append("     </textarea></p>");
            htm.append("    </div>");
            
            htm.append("    <a href=\"javascript:collapse('acercade_mi')\">Cerrar</a>");
            htm.append("   </div>");
            
            //adscripción
//            htm.append("    <p class=\"entero\"><label>Direcci&oacute;n de adscripci&oacute;n</label>");
//            htm.append("     <select name=\"da\">");
//            htm.append("      <option>Competitividad</option>");
//            htm.append("     </select></p>");

//            htm.append("   <p class=\"status entero\"><label>&iquest;Qu&eacute; haces o piensas?</label>");
//            htm.append("    <textarea name=\"ideas\" id=\"ideas\" rows=\"2\" cols=\"70\">");
            //SemanticProperty ideas = SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#ideas");
            //htm.append(user.getExtendedAttribute(ideas)==null?"":user.getExtendedAttribute(ideas));
//            htm.append(profile.getMisIdeas()==null?"":profile.getMisIdeas());
//            htm.append("    </textarea></p>");
            htm.append("  </div>");
            htm.append("  <div class=\"clearer\">&nbsp;</div>");
            htm.append(" </div>");

            //contacto interno
            htm.append(" <div class=\"contacto_interno divisor\">");
            htm.append("  <h3>Contacto interno</h3>");
            CV cv = CV.ClassMgr.getCV(user.getId(), wsite);
            Persona persona = cv.getPersona();
            Iterator<Telefono> tels = persona.listTelefonos();
            Telefono tel = null;
            while(tels.hasNext()) {
                tel = tels.next();
                try {
                    Telefono.TipoTelefono.valueOf(tel.getTipo());
                    if(Telefono.TipoTelefono.job.name().equals(tel.getTipo()))
                        break;
                    else
                        tel = null;
                }catch(Exception e) {
                }
            }
            htm.append("  <p class=\"tercio\"><label>Lada</label>");
            htm.append("    <input type=\"text\" name=\"ld\" value=\""+(tel!=null&&tel.getLada()>0?Integer.toString(tel.getLada()):"")+"\"/></p>");
            htm.append("  <p class=\"tercio\"><label>Telefono</label>");
            htm.append("    <input type=\"text\" name=\"tfo\" value=\""+(tel!=null&&tel.getNumero()>0?Integer.toString(tel.getNumero()):"")+"\"/></p>");
            htm.append("  <p class=\"tercio\"><label>Extension</label>");
            htm.append("    <input type=\"text\" name=\"ext\" value=\""+(tel!=null&&tel.getExtension()>0?Integer.toString(tel.getExtension()):"")+"\"/></p>");
//            SemanticProperty ext = SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#extension");
//            htm.append("  <p class=\"medio\"><label>Extensi&oacute;n</label>");
//            htm.append("    <input type=\"text\" name=\"ext\" id=\"ext\" value=\""+(user.getExtendedAttribute(ext)==null?"":user.getExtendedAttribute(ext))+"\"/></p>");
//            htm.append("  <p class\"medio\"><label>Extensi&oacute;n de tu Direcci&oacute;n Adjunta</label>");
//            htm.append("    <input type=\"text\" name=\"extd\" id=\"extd\" value=\"\"/></p>");
            htm.append("  <p class=\"entero\"><label>Correo electr&oacute;nico institucional</label>");
            htm.append("    <input type=\"text\" name=\"email\" id=\"email\" value=\""+user.getEmail()+"\"/></p>");
            htm.append("  <p class=\"entero\"><label>Ubicaci&oacute;n f&iacute;sica de tu lugar u oficina</label><br/>");
            htm.append("   <textarea id=\"loc\" name=\"loc\" rows=\"2\" cols=\"70\">");
            htm.append(profile.getUbicacion()==null?"":profile.getUbicacion());
            htm.append("   </textarea></p>");
            htm.append("  <div class=\"clearer\">&nbsp;</div>");
            htm.append(" </div>"); 
            
            //contacto externo
//            CV cv = CV.ClassMgr.getCV(user.getId(), wsite);
//            if(cv==null) {
//                cv = CV.ClassMgr.createCV(user.getId(), wsite);
//                log.info("Creado objeto CV para usuario "+user.getFullName()+" con id="+user.getId());
//            }
//            Persona persona = cv.getPersona();
//            if(persona==null) {
//                persona = Persona.ClassMgr.createPersona(user.getId(), wsite);
//                cv.setPersona(persona);
//                log.info("Creado y asignado objeto Persona para usuario "+user.getFullName()+" con id="+user.getId());
//            }
//            Domicilio d = persona.getDomicilio();
//            if(d==null) {
//                d = Domicilio.ClassMgr.createDomicilio(user.getId(), wsite);
//                persona.setDomicilio(d);
//                log.info("Creado y asignado objeto Domicilio para usuario "+user.getFullName()+" con id="+user.getId());
//            }
//            htm.append("  <div class=\"contacto_externo divisor\">");
//            htm.append("   <h3>Contacto externo</h3>");
//            htm.append("   <p>Esta informaci&oacute;n es para uso exclusivo de la instituci&oacute;n, no aparecer&aacute; en tu perfil</p>");
//            htm.append("   <p class=\"tercio\"><label for=\"cn\">Calle y n&uacute;mero</label><input type=\"text\" name=\"cn\" id=\"cn\" value=\""+(d.getCalle()==null?"":d.getCalle())+"\" /></p>");
//                                
//            //TODO: cambiar colonia, municipio, estado, CP a objetos, ya son catálogos
//            htm.append("   <p class=\"tercio\"><label for=\"col\">Colonia</label>");
//            //htm.append("     <input type=\"text\" name=\"col\" id=\"col\" value=\""+(d.getColonia()==null?"":d.getColonia())+"\" />");
//            htm.append("   <select name=\"col\" id=\"col\">");
//            Iterator<Colonia> colonias = Colonia.ClassMgr.listColonias(wsite);
//            if(colonias.hasNext()) {
//                Colonia c;
//                while(colonias.hasNext()) {
//                    c = colonias.next();
//                    if(c.equals(d.getColonia()))
//                        htm.append("<option value=\""+c.getId()+"\" selected=\"selected\">"+c.getDisplayTitle(lang)+"</option>");
//                    else
//                        htm.append("<option value=\""+c.getId()+"\">"+c.getDisplayTitle(lang)+"</option>");
//                }
//            }
//            htm.append("   </select>");
//            htm.append("   </p>");
//            htm.append("   <p class=\"tercio\"><label for=\"cd\">Ciudad/Poblaci&oacute;n</label>");
//            htm.append("     <input type=\"text\" name=\"cd\" id=\"cd\" value=\""+(d.getCiudad()==null?"":d.getCiudad())+"\" />");
//            htm.append(   "</p>");
//            htm.append("   <p class=\"tercio\"><label for=\"mun\">Municipio/Delegaci&oacute;n</label>");
//            //htm.append("     <input type=\"text\" name=\"mun\" id=\"mun\" value=\""+(d.getMunicipio()==null?"":d.getMunicipio())+"\" />");
//            htm.append("   <select name=\"mun\" id=\"mun\">");
//            Iterator<Municipio> municipios = Municipio.ClassMgr.listMunicipios(wsite);
//            if(municipios.hasNext()) {
//                Municipio c;
//                while(municipios.hasNext()) {
//                    c = municipios.next();
//                    if(c.equals(d.getMunicipio()))
//                        htm.append("<option value=\""+c.getId()+"\" selected=\"selected\">"+c.getDisplayTitle(lang)+"</option>");
//                    else
//                        htm.append("<option value=\""+c.getId()+"\">"+c.getDisplayTitle(lang)+"</option>");
//                }
//            }
//            htm.append("   </select>");
//            htm.append("   </p>");
//            htm.append("   <p class=\"tercio\"><label for=\"edo\">Estado</label>");
//            //htm.append(     "<input type=\"text\" name=\"edo\" id=\"edo\" value=\""+(d.getEntidad()==null?"":d.getEntidad())+"\" />");
//            htm.append("   <select name=\"edo\" id=\"edo\">");
//            Iterator<EntidadFederativa> entidades = EntidadFederativa.ClassMgr.listEntidadFederativas(wsite);
//            if(entidades.hasNext()) {
//                EntidadFederativa c;
//                while(entidades.hasNext()) {
//                    c = entidades.next();
//                    if(c.equals(d.getEntidad()))
//                        htm.append("<option value=\""+c.getId()+"\" selected=\"selected\">"+c.getDisplayTitle(lang)+"</option>");
//                    else
//                        htm.append("<option value=\""+c.getId()+"\">"+c.getDisplayTitle(lang)+"</option>");
//                }
//            }
//            htm.append("   </select>");
//            htm.append("   </p>");
//            htm.append("   <p class=\"tercio\"><label for=\"cp\">C&oacute;digo postal</label>");
//            //htm.append("     <input type=\"text\" name=\"cp\" id=\"cp\" value=\""+(d.getCp()==null?"":d.getCp())+"\" />");
//            htm.append("   <select name=\"cp\" id=\"cp\">");
//            Iterator<CP> cps = CP.ClassMgr.listCPs(wsite);
//            if(cps.hasNext()) {
//                CP c;
//                while(cps.hasNext()) {
//                    c = cps.next();
//                    if(c.equals(d.getCp()))
//                        htm.append("<option value=\""+c.getId()+"\" selected=\"selected\">"+c.getDisplayTitle(lang)+"</option>");
//                    else
//                        htm.append("<option value=\""+c.getId()+"\">"+c.getDisplayTitle(lang)+"</option>");
//                }
//            }
//            htm.append("   </select>");
//            htm.append("   </p>");
//            htm.append("   <p class=\"medio\"><label for=\"ctry\">Pa&iacute;s</label>");
//            htm.append("   <select name=\"ctry\" id=\"ctry\">");
//            Iterator<Country> countries = Country.ClassMgr.listCountries(wsite);
//            if(countries.hasNext()) {
//                Country c;
//                while(countries.hasNext()) {
//                    c = countries.next();
//                    if(c.equals(d.getPais()))
//                        htm.append("<option value=\""+c.getId()+"\" selected=\"selected\">"+c.getDisplayTitle(lang)+"</option>");
//                    else
//                        htm.append("<option value=\""+c.getId()+"\">"+c.getDisplayTitle(lang)+"</option>");
//                }
//            }
//            htm.append("   </select></p>");
//            htm.append("   <div class=\"clearer\">&nbsp;</div>");
//            htm.append("  </div>");
            
            //datos familiares
//            htm.append("  <div class=\"contacto_externo divisor\">");
//            htm.append("   <h3>Datos familiares</h3>");
//            //htm.append("        <p>Esta informaci&oacute;n es para uso exclusivo de la instituci&oacute;n, no aparecer&aacute; en tu perfil</p>");
//            Iterator<Familia> familiares = persona.listFamilias();
//            htm.append("   <ol id=\"fms\">");
//            if(familiares.hasNext()) {
//                SWBResourceURL rem = paramRequest.getActionUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setAction(SWBResourceURL.Action_REMOVE);
//                Familia f;
//                while(familiares.hasNext()) {
//                    f = familiares.next();
//                    rem.setParameter("fid", f.getId());
//                    htm.append("<li class=\"aaaa\">");
//                    htm.append("  <p class=\"entero\"><label>Nombre completo</label><br/><input type=\"text\" name=\"ncf\" value=\""+f.getNombre()+"\" /></p>");
//                    htm.append("  <p class=\"tercio\"><label>Parentesco</label><br/><input type=\"text\" name=\"p\" value=\""+f.getParentesco()+"\" /></p>");
//                    htm.append("  <p class=\"tercio\"><label>Direcci&oacute;n</label><br/><input type=\"text\" name=\"df\" value=\""+f.getDireccion()+"\" /></p>");
//                    if(f.getTelefono()!=null)
//                        htm.append("  <p class=\"tercio\"><label>Tel&eacute;fono</label><br/><label>Clave</label>:<input type=\"text\" name=\"cve\" value=\""+f.getTelefono().getLada()+"\" />&nbsp;<label>Tel&eacute;fono</label>:<input type=\"text\" name=\"tf\" value=\""+f.getTelefono().getNumero()+"\" /></p>");
//                    else
//                        htm.append("  <p class=\"tercio\"><label>Tel&eacute;fono</label><br/><label>Clave</label>:<input type=\"text\" name=\"cve\" value=\"\" />&nbsp;<label>Tel&eacute;fono</label>:<input type=\"text\" name=\"tf\" value=\"\" /></p>");
//                    htm.append("  <p><input type=\"button\" onclick=\"postHtml('"+rem+"','fms')\" value=\"Eliminar\" /></p>");
//                    htm.append("  <br clear=\"all\" />");
//                    htm.append("</li>");
//                }
//            }else {
//                htm.append("<li class=\"aaaa\">");
//                htm.append("  <p class=\"entero\"><label>Nombre completo</label><br/><input type=\"text\" name=\"ncf\" value=\"\" /></p>");
//                htm.append("  <p class=\"tercio\"><label>Parentesco</label><br/><input type=\"text\" name=\"p\" value=\"\" /></p>");
//                htm.append("  <p class=\"tercio\"><label>Direcci&oacute;n</label><br/><input type=\"text\" name=\"df\" value=\"\" /></p>");
//                htm.append("  <p class=\"tercio\"><label>Tel&eacute;fono</label><br/>");
//                htm.append("   <label>Clave</label>:<input type=\"text\" name=\"cve\" value=\"\" />");
//                htm.append("   <label>Tel&eacute;fono</label>:<input type=\"text\" name=\"tf\" value=\"\" />");
//                htm.append("  </p>");
//                htm.append("  <br clear=\"all\" />");
//                htm.append("</li>");
//            }
//            htm.append("   </ol>");
//            htm.append("   <p><a href=\"javascript:appendChild('_"+base.getId()+"_'+(idx++),'fms')\">Agregar</a></p>");          
//            htm.append("  </div>");
            
//            //experiencia laboral
//            htm.append("    <div class=\"experiencia divisor\">");
//            htm.append("        <h3>Experiencia en Infotec</h3>");
//            htm.append("        <p class=\"entero\">Cliente <select>");
//            htm.append("        <option>Secretar&iacute;a del Trabajo y Previsi&oacute;n Social</option>");
//            htm.append("        </select></p>");
//            htm.append("        <p class=\"entero\">Describe brevemente tus actividades relevantes en el proyecto. (M&aacute;ximo 500 caracteres)</p>");
//            htm.append("        <div class=\"text_editor\"><img src=\"/work/models/eworkplace/css/editor.gif\" alt=\"\" /></div>");
//            htm.append("        <div class=\"clearer\">&nbsp;</div>");
//            htm.append("        <p><a href=\"#\">Agregar</a></p>");
//            htm.append("    </div>");
//            //conocimientos
//            htm.append("    <div class=\"conocimientos divisor\">");
//            htm.append("        <h3>Conocimientos</h3>");
//            htm.append("        <ol>");
//            htm.append("            <li>");
//            htm.append("              <p class=\"tercio\">Conocimiento <br /><input type=\"text\" /></p>");
//            htm.append("              <p class=\"tercio\">Experiencia <br />");
//            htm.append("              <select>");
//            htm.append("                <option>3 a&ntilde;os</option>");
//            htm.append("              </select></p>");
//            htm.append("              <p class=\"tercio\">Domino <br />");
//            htm.append("              <select>");
//            htm.append("                <option>Avanzado</option>");
//            htm.append("              </select></p>");
//            htm.append("              <p><input type=\"button\" value=\"Eliminar\" /></p>");
//            htm.append("            </li>");
//            htm.append("        </ol>");
//            htm.append("        <p><a href=\"#\">Agregar</a></p>");
//            htm.append("    </div>");
//            //habilidades
//            htm.append("    <div class=\"habilidades divisor\">");
//            htm.append("        <h3>Habilidades</h3>");
//            htm.append("        <ol>");
//            htm.append("            <li>");
//            htm.append("            <p class=\"tercio\">Habilidad <br /><input type=\"text\" /></p>");
//            htm.append("            <p class=\"tercio\">Experiencia <br />");
//            htm.append("            <select>");
//            htm.append("            <option>3 a&ntilde;os</option>");
//            htm.append("            </select></p>");
//            htm.append("            <p class=\"tercio\">Domino <br />");
//            htm.append("            <select>");
//            htm.append("            <option>Avanzado</option>");
//            htm.append("            </select></p>");
//            htm.append("            <p><input type=\"button\" value=\"Eliminar\" /></p>");
//            htm.append("            </li>");
//            htm.append("        </ol>");
//            htm.append("        <p><a href=\"#\">Agregar</a></p>");
//            htm.append("    </div>");
            
            // temas de interes
            htm.append(" <div class=\"de_interes divisor\">");
            htm.append("  <h3>Temas de mi inter&eacute;s</h3>");
//            htm.append("  <em>El sistema te ofrecer&aacute; contenidos acordes con tus temas de inter&eacute;s</em>");
            Iterator<TemaInteres> tis = TemaInteres.ClassMgr.listTemaIntereses(wsite);
            if(tis.hasNext()) {
                htm.append("  <ul>");
                TemaInteres ti;
                while(tis.hasNext()) {
                    ti = tis.next();
                    htm.append("   <li class=\"tercio\"><label for=\""+ti.getId()+"\"><input type=\"checkbox\" name=\"mti\" id=\""+ti.getId()+"\" value=\""+ti.getId()+"\"/> "+ti.getDisplayTitle(lang)+"</label></li>");
                }
                htm.append("  </ul>");
            }
            htm.append("  <div class=\"clearer\">&nbsp;</div>");
            htm.append(" </div>");
            
            
            
            htm.append(" <div class=\"guardar\">");
            htm.append("  <input type=\"reset\" value=\"Restablecer\" />");
            htm.append("  <input type=\"submit\" value=\"Guardar\" />");
            htm.append(" </div>");
            htm.append("</div>  ");
//htm.append("</div>");
htm.append("</form>");
            htm.append("\n<script type=\"text/javascript\">\n");
            htm.append("<!--\n");
            htm.append("  dojo.addOnLoad(collapse('acercade_mi'));\n");
            htm.append("-->\n");
            htm.append("</script>\n");            
            out.println(htm.toString());
        }else {
            out.println("usuario distinto al dueño del perfil");
        }*/
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        final User user = response.getUser();
        
        if(!user.isSigned())
            return;
        
        Resource base = getResourceBase();
        final String action = response.getAction();       
        final WebSite wsite = base.getWebSite();
        if(Send_VIEW.equals(action)) {
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
        
        else if(SWBResourceURL.Action_EDIT.equals(action)) {
            SWProfile profile = SWProfile.ClassMgr.getSWProfile(user.getId(), wsite);
            if( user.equals(profile.getCreator()) ) {
//            SemanticProperty sp = SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#miPerfilSL");
//            SWProfile profile = (SWProfile)user.getExtendedAttribute(sp);
//            profile.setMisIdeas(request.getParameter("ideas"));
//            profile.setUbicacion(request.getParameter("loc"));
                boolean isMultipart = ServletFileUpload.isMultipartContent(request);
                if(isMultipart) {
                    try {
                        chgPhto(request, response);
                        /*final String url = SWBPlatform.getContextPath()+"/"+SWBPlatform.getEnv("swb/distributor")+"/"+wsite.getId()+"/editar_datos"+"/_lang/"+user.getLanguage();
                        request.getSession(true).setAttribute(Send, Send_EDIT);
                        response.sendRedirect(url);*/
                    }catch(Exception e) {
                        e.printStackTrace(System.out);
                    }
                }
                else {
                    StringBuilder alertmsg = new StringBuilder();
                    String prsnld = SWBUtils.XML.replaceXMLChars(request.getParameter("prsnld")).trim();
                    if(prsnld.isEmpty()) {
                        alertmsg.append(response.getLocaleString("")).append("\n");
                    }
                    String gsts = SWBUtils.XML.replaceXMLChars(request.getParameter("gsts")).trim();
                    if(gsts.isEmpty()) {
                        alertmsg.append(response.getLocaleString("")).append("\n");
                    }
                    String ideas = SWBUtils.XML.replaceXMLChars(request.getParameter("ideas")).trim();
                    if(ideas.isEmpty()) {
                        alertmsg.append(response.getLocaleString("")).append("\n");
                    }
                    int tfo = 0;
                    try {
                        tfo = Integer.parseInt(request.getParameter("tfo"));
                    }catch(Exception e) {
                        alertmsg.append(response.getLocaleString("")).append("\n");
                    }
                    int xtdr = 0;
                    try {
                        xtdr = Integer.parseInt(request.getParameter("extdr"));
                    }catch(Exception e) {
                        alertmsg.append(response.getLocaleString("")).append("\n");
                    }
                    String email = request.getParameter("email");
                    if(!SWBUtils.EMAIL.isValidEmailAddress(email)) {
                        alertmsg.append(response.getLocaleString("")).append("\n");
                    }
                    String loc = SWBUtils.XML.replaceXMLChars(request.getParameter("loc")).trim();
                    if(loc.isEmpty()) {
                        alertmsg.append(response.getLocaleString("")).append("\n");
                    }
                    
response.setRenderParameter("alertmsg", response.getLocaleString(""));
                    
                    
                    CV cv = CV.ClassMgr.getCV(user.getId(), wsite);
                    Persona persona = cv.getPersona();
                    
                    profile.setMiPersonalidad(SWBUtils.XML.replaceXMLChars(request.getParameter("prsnld")));
                    profile.setMisGustos(SWBUtils.XML.replaceXMLChars(request.getParameter("gsts")));
                    profile.setMisIdeas(SWBUtils.XML.replaceXMLChars(request.getParameter("ideas")));
                    try {
                        int ld, xtn;
                        try {
                            ld = Integer.parseInt(request.getParameter("ld"));
                        }catch(Exception e) {
                            ld = 0;
                        }
                        try {
                            xtn = Integer.parseInt(request.getParameter("ext"));
                        }catch(Exception e) {
                            xtn = 0;
                        }
                        Iterator<Telefono> telefonos = persona.listTelefonoByTipo(Telefono.TipoTelefono.job);
                        while(telefonos.hasNext()) {
                            telefonos.next().remove();
                        }
                        Telefono tel = Telefono.ClassMgr.createTelefono(wsite);
                        tel.setLada(ld);
                        tel.setNumero(tfo);
                        tel.setExtension(xtn);
                        tel.setTipo(Telefono.TipoTelefono.job.name());
                        persona.addTelefono(tel);
                    }catch(Exception nfe) {
                        log.error(nfe);
                    }
                    
                    try {
                        xtdr = Integer.parseInt(request.getParameter("extdr"));
                        //SemanticProperty ext = SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#extension");
                        SemanticProperty ext = SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#noe");
                        user.setExtendedAttribute(ext, new Integer(xtdr));
                    }catch(Exception e) {
e.printStackTrace(System.out);
                    }
                        
                    if(SWBUtils.EMAIL.isValidEmailAddress(request.getParameter("email")))
                        user.setEmail(request.getParameter("email"));
                    profile.setUbicacion(SWBUtils.XML.replaceXMLChars(request.getParameter("loc")));
                    
                    if(request.getParameterValues("mti")!=null && request.getParameterValues("mti").length>0) {
                        profile.removeAllTemaInteres();
                        String[] mtis = request.getParameterValues("mti");
                        for(String mti:mtis)
                            try {
                                profile.addTemaInteres(TemaInteres.ClassMgr.getTemaInteres(mti, wsite));
                            }catch(Exception e) {
                                log.error(e);
                            }
                    }
                    response.setAction(SWBResourceURL.Action_ADD);
                    
//                    Domicilio domicilio = persona.getDomicilio();
//                    domicilio.setCalle(SWBUtils.XML.replaceXMLChars(request.getParameter("cn")));
//                    Colonia colonia = null;
//                    if(request.getParameter("col")!=null){
//                        colonia = Colonia.ClassMgr.getColonia(request.getParameter("col"), wsite); 
//                    }
//                    if(colonia!=null) domicilio.setColonia(colonia);
//                    domicilio.setCiudad(SWBUtils.XML.replaceXMLChars(request.getParameter("cd")));
//                    Municipio municipio = null;
//                    if(request.getParameter("mun")!=null){
//                        municipio = Municipio.ClassMgr.getMunicipio(request.getParameter("mun"), wsite); 
//                    }
//                    if(municipio!=null) domicilio.setMunicipio(municipio);      
//                    EntidadFederativa entidad = null;
//                    if(request.getParameter("edo")!=null){
//                        entidad = EntidadFederativa.ClassMgr.getEntidadFederativa(request.getParameter("edo"), wsite); 
//                    }
//                    if(entidad!=null) domicilio.setEntidad(entidad);
//                    CP cp = null;
//                    if(request.getParameter("cp")!=null){
//                        cp = CP.ClassMgr.getCP(request.getParameter("cp"), wsite); 
//                    }
//                    if(cp!=null) domicilio.setCp(cp);
//                    String countryId = SWBUtils.XML.replaceXMLChars(request.getParameter("ctry"));
//                    if(Country.ClassMgr.hasCountry(countryId, wsite)) {
//                        domicilio.setPais(Country.ClassMgr.getCountry(countryId, wsite));
//                    }
                    
//                    //persona.removeAllFamilia();
//                    Iterator<Familia> familiares = persona.listFamilias();
//                    while(familiares.hasNext()) {
//                        Familia familiar = familiares.next();
//                        if(familiar.getTelefono()!=null)
//                            familiar.getTelefono().remove();
//                        familiar.remove();
//                    }
//                    String[] ncf = request.getParameterValues("ncf");
//                    String[] p = request.getParameterValues("p");
//                    String[] df = request.getParameterValues("df");
//                    String[] cve = request.getParameterValues("cve");
//                    String[] tf = request.getParameterValues("tf");
//                    for(int i=0; i<ncf.length; i++) {
//                        if(ncf[i].isEmpty() || p[i].isEmpty() || df[i].isEmpty() || tf[i].isEmpty())
//                            continue;
//                        Familia fam = Familia.ClassMgr.createFamilia(wsite);
//                        try {
//                            fam.setNombre(SWBUtils.XML.replaceXMLChars(ncf[i]));
//                        }catch(IndexOutOfBoundsException iobe){}
//                        try {
//                            fam.setParentesco(SWBUtils.XML.replaceXMLChars(p[i]));
//                        }catch(IndexOutOfBoundsException iobe){}
//                        try {
//                            fam.setDireccion(SWBUtils.XML.replaceXMLChars(df[i]));
//                        }catch(IndexOutOfBoundsException iobe){}
//                        try {
//                            Telefono tel = Telefono.ClassMgr.createTelefono(wsite);
//                            tel.setLada(Integer.parseInt(SWBUtils.XML.replaceXMLChars(cve[i])));
//                            tel.setNumero(Integer.parseInt(SWBUtils.XML.replaceXMLChars(tf[i])));
//                            fam.setTelefono(tel);
//                        }catch(Exception iobe){
//                        }
//                        persona.addFamilia(fam);
//                    }
                }
            }
        }else if(SWBResourceURL.Action_REMOVE.equals(action)) {
            SWProfile profile = SWProfile.ClassMgr.getSWProfile(user.getId(), wsite);
            if(user.equals(profile.getCreator())) {
                String fid = request.getParameter("fid");
                if(Familia.ClassMgr.hasFamilia(fid, wsite)) {
                    Familia familiar = Familia.ClassMgr.getFamilia(fid, wsite);
                    if(familiar.getTelefono()!=null)
                        familiar.getTelefono().remove();
                    familiar.remove();
                    //Familia.ClassMgr.removeFamilia(fid, wsite);
                    response.setMode("fam");
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
        response.setContentType("text/html; charset=UTF-8");
        Resource base = getResourceBase();
        WebSite wsite = base.getWebSite();
        User user = paramRequest.getUser();
        
        PrintWriter out =  response.getWriter();
        
        SWProfile profile = SWProfile.ClassMgr.getSWProfile(user.getId(), wsite);
        if( user.isSigned() && user.equals(profile.getCreator()) ) {
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
            //htm.append("                <p class=\"tercio\"><a href=\"#\">M&aacute;s acerca de m&iacute;</a></p>");
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
                        user.setPhoto(filename);
                    }
                    break;
                }
            }
        }
    }
}
