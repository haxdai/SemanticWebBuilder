package com.infotec.eworkplace.swb.resources;

import com.infotec.eworkplace.swb.CV;
import com.infotec.eworkplace.swb.Domicilio;
import com.infotec.eworkplace.swb.Familia;
import com.infotec.eworkplace.swb.Persona;
import com.infotec.eworkplace.swb.SWProfile;
import com.infotec.eworkplace.swb.TemaInteres;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.semanticwb.Logger;
import org.semanticwb.SWBException;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Country;
import org.semanticwb.model.Resource;
import org.semanticwb.model.User;
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
    private static final String Send_CHGPHTO = "phto";
    private static final String Send_REQ = "req";
    private static final String Send_FAV = "fav";
    
    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String mode = paramRequest.getMode();
        if("fam".equals(mode))
            doFam(request, response, paramRequest);
        else
            super.processRequest(request, response, paramRequest);
    }

    
    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        Resource base = getResourceBase();
        User user = paramRequest.getUser();
        PrintWriter out =  response.getWriter();        
        
        if(paramRequest.getCallMethod()==paramRequest.Call_STRATEGY) {
            if(user.isSigned()) {
                WebSite wsite = base.getWebSite();
                
//                SemanticProperty sp = SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#miPerfilSL");
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

                    out.println("<li class=\"herr2\">");
                    out.println("  <a class=\"MenuBarItemSubmenu\" href=\"{distpath}/{websiteid}/espacio_personal\" title=\"\">Entrar a mi espacio</a>");
                    out.println("  <ul>");
                    out.println("    <li>");
                    out.println("      <div class=\"user\">");
                    out.println("        <img src=\""+pimg+"\" alt=\""+user.getLogin()+"\" />");
                    out.println("        <strong>"+user.getFullName()+"</strong>");
                    out.println("      </div>");
                    out.println("    </li>");
                    out.println("    <li class=\"perfil\">");
                    //out.println("      <p><a href=\""+SWBPlatform.getContextPath()+"/"+SWBPlatform.getEnv("swb/distributor")+"/"+wsite.getId()+"/editar_datos"+"/_lang/"+user.getLanguage()+"\" title=\"Editar mi perfil\">Editar mi perfil</a></p>");
                    out.println("      <p><a href=\""+paramRequest.getActionUrl().setAction(Send_EDIT).toString()+"\" title=\"Editar mi perfil\">Editar mi perfil</a></p>");
                    out.println("      <p><a href=\""+paramRequest.getActionUrl().setAction(Send_FAV).toString()+"\" title=\"Editar mis favoritos\">Mis favoritos</a></p>");
                    out.println("      <p><a href=\""+paramRequest.getActionUrl().setAction(Send_REQ).toString()+"\" title=\"\">Mis solicitudes</a></p>");
                    out.println("      <p><a href=\""+paramRequest.getActionUrl().setAction(Send_VIEW).toString()+"\" title=\"\">Ver mi perfil</a></p>");
                    out.println("      <p class=\"salir\"><a href=\""+SWBPlatform.getContextPath()+"/login?wb_logout=true&wb_goto="+urlLogout+"\" title=\"Salir\">Salir</a></p>");
                    out.println("    </li>");
                    out.println("    <li style=\"clear:both; height:1px;\"></li>");
                    out.println("  </ul>");
                    out.println("</li>");
                }else {
                    System.out.println("<p>Usuario no autorizado</p>");
                    log.info("Acceso no autorizado");
                }
            }
        }else {
            if(user.isSigned()) {
                WebSite wsite = base.getWebSite();
                SWProfile profile = SWProfile.ClassMgr.getSWProfile(user.getId(), wsite);
                
                HttpSession session = request.getSession(true);
                String send = (String)session.getAttribute(Send);
                session.removeAttribute(Send);
                if(Send_EDIT.equals(send) && user.equals(profile.getCreator())) {
                    doEdit(request, response, paramRequest);
                }else if(Send_CHGPHTO.equals(send) && user.equals(profile.getCreator())) {
                    doChgPhto(request, response, paramRequest);
                }else {
                    out.println("vista del perfil de "+user.getFullName());
                }
            }
        }
    }

    @Override
    public void doEdit(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        Resource base = getResourceBase();
        WebSite wsite = base.getWebSite();
        User me = paramRequest.getUser();
        
        PrintWriter out =  response.getWriter();
        
//        SemanticProperty sp = SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#miPerfilSL");
//        SWProfile profile = (SWProfile)me.getExtendedAttribute(sp);
        SWProfile profile = SWProfile.ClassMgr.getSWProfile(me.getId(), wsite);
        if( me.isSigned() && me.equals(profile.getCreator()) ) {
            final String lang = me.getLanguage();
            final String axn = paramRequest.getActionUrl().setAction(SWBResourceURL.Action_EDIT).toString();
            StringBuilder htm = new StringBuilder();
            htm.append(script());
            htm.append("<form id=\"profile/user\" method=\"post\" action=\""+axn+"\">");
            htm.append("<div id=\"perfil_usuario\">");
            htm.append("    <div id=\"formPerfil\">");
            
            //datos empleado
            htm.append("        <div class=\"perfil divisor\">");
            htm.append("            <h3>Mi perfil</h3>");
            final String pimg;
            if(me.getPhoto()==null)
                pimg = SWBPortal.getWebWorkPath()+"/models/"+wsite.getId()+"/css/user.jpg";
            else
                pimg = SWBPortal.getWebWorkPath()+profile.getWorkPath()+"/"+me.getPhoto();
            final String urlChgPhto = paramRequest.getActionUrl().setAction(Send_CHGPHTO).toString();
            htm.append("            <div class=\"foto\"><img src=\""+pimg+"\" alt=\""+me.getFullName()+"\" /><a href=\""+urlChgPhto+"\">Cambiar foto</a></div>");
            htm.append("            <div class=\"user\">");
            htm.append("                <p class=\"name\">"+me.getFullName()+"</p>");
            htm.append("                <p class=\"tercio\"><a href=\"javascript:expande('acercade_mi')\">M&aacute;s acerca de m&iacute;</a></p>");
            htm.append("            </div>");
            htm.append("            <div class=\"datos\">");
            
            htm.append("              <div id=\"acercade_mi\">");
            htm.append("                <div class=\"text_editor\">");
            htm.append("                  <h3>Mi personalidad</h3>");
            htm.append("                  <textarea name=\"prsnld\" id=\"prsnld\" rows=\"2\" cols=\"70\"></textarea>");
            htm.append("                </div>");
            htm.append("                <div class=\"text_editor\">");
            htm.append("                  <h3>Mis gustos e intereses</h3>");
            htm.append("                  <textarea name=\"gsts\" id=\"gsts\" rows=\"2\" cols=\"70\"></textarea>");
            htm.append("                </div>");
            htm.append("                <a href=\"javascript:collapse('acercade_mi')\">Cerrar</a>");
            htm.append("              </div>");
            
            htm.append("              <p class=\"tercio\"><label>Direcci&oacute;n de adscripci&oacute;n</label><select name=\"da\">");
            htm.append("                <option>Competitividad</option>");
            htm.append("              </select></p>");
            htm.append("              <p class=\"tercio\"><label>Gerencia</label><select name=\"mngt\">");
            htm.append("                <option>Modelado de portales</option>");
            htm.append("              </select></p>");
            htm.append("              <p class=\"tercio\"><label>Cargo o nombre del puesto designado</label><select name=\"pto\">");
            htm.append("                <option>Consultor en portales</option>");
            htm.append("              </select></p>");
            htm.append("              <p class=\"status entero\"><label>&iquest;Qu&eacute; haces o piensas?</label>");
            htm.append("              <textarea name=\"ideas\" id=\"ideas\" rows=\"2\" cols=\"70\">");
            //SemanticProperty ideas = SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#ideas");
            //htm.append(me.getExtendedAttribute(ideas)==null?"":me.getExtendedAttribute(ideas));
            htm.append(               profile.getMisIdeas()==null?"":profile.getMisIdeas());
            htm.append("              </textarea></p>");
            htm.append("            </div>");
            htm.append("            <div class=\"clearer\">&nbsp;</div>");
            htm.append("        </div>");
            /////////////////////htm.append("    </div>");
            /////////////////////htm.append("</div>"); 
            //contacto interno
            htm.append("        <div class=\"contacto_interno divisor\">");
            htm.append("            <h3>Contacto interno</h3>");
            SemanticProperty ext = SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#extension");
            htm.append("            <p class=\"medio\"><label>Extensi&oacute;n</label>");
            htm.append("                <input type=\"text\" name=\"ext\" id=\"ext\" value=\""+(me.getExtendedAttribute(ext)==null?"":me.getExtendedAttribute(ext))+"\"/></p>");
            htm.append("            <p class\"medio\"><label>Extensi&oacute;n de tu Direcci&oacute;n Adjunta</label> <input type=\"text\" /></p>");
            htm.append("            <p class=\"entero\"><label>Correo electr&oacute;nico institucional</label>");
            htm.append("                <input type=\"text\" name=\"emaili\" id=\"emaili\" value=\""+me.getEmail()+"\"/></p>");
            htm.append("            <p class=\"entero\"><label>Ubicaci&oacute;n f&iacute;sica de tu lugar u oficina</label><br />");
            htm.append("                <textarea id=\"loc\" name=\"loc\" rows=\"2\" cols=\"70\">");
            htm.append(                 profile.getUbicacion()==null?"":profile.getUbicacion());
            htm.append("                </textarea></p>");
            htm.append("            <div class=\"clearer\">&nbsp;</div>");
            htm.append("        </div>");   
            //contacto externo
            CV cv = CV.ClassMgr.getCV(me.getId(), wsite);
            if(cv==null) {
                cv = CV.ClassMgr.createCV(me.getId(), wsite);
                log.info("Creado objeto CV para usuario "+me.getFullName()+" con id="+me.getId());
            }
            Persona p = cv.getPersona();
            if(p==null) {
                p = Persona.ClassMgr.createPersona(me.getId(), wsite);
                cv.setPersona(p);
                log.info("Creado y asignado objeto Persona para usuario "+me.getFullName()+" con id="+me.getId());
            }
            Domicilio d = p.getDomicilio();
            if(d==null) {
                d = Domicilio.ClassMgr.createDomicilio(me.getId(), wsite);
                p.setDomicilio(d);
                log.info("Creado y asignado objeto Domicilio para usuario "+me.getFullName()+" con id="+me.getId());
            }
            htm.append("        <div class=\"contacto_externo divisor\">");
            htm.append("            <h3>Contacto externo</h3>");
            htm.append("            <p>Esta informaci&oacute;n es para uso exclusivo de la instituci&oacute;n, no aparecer&aacute; en tu perfil</p>");
            htm.append("            <p class=\"tercio\"><label for=\"cn\">Calle y n&uacute;mero</label><input type=\"text\" name=\"cn\" id=\"cn\" value=\""+(d.getCalle()==null?"":d.getCalle())+"\" /></p>");
            htm.append("            <p class=\"tercio\"><label for=\"col\">Colonia</label><input type=\"text\" name=\"col\" id=\"col\" value=\""+(d.getColonia()==null?"":d.getColonia())+"\" /></p>");
            htm.append("            <p class=\"tercio\"><label for=\"cd\">Ciudad/Poblaci&oacute;n</label><input type=\"text\" name=\"cd\" id=\"cd\" value=\""+(d.getCiudad()==null?"":d.getCiudad())+"\" /></p>");
            htm.append("            <p class=\"tercio\"><label for=\"mun\">Municipio/Delegaci&oacute;n</label><input type=\"text\" name=\"mun\" id=\"mun\" value=\""+(d.getMunicipio()==null?"":d.getMunicipio())+"\" /></p>");
            htm.append("            <p class=\"tercio\"><label for=\"edo\">Estado</label><input type=\"text\" name=\"edo\" id=\"edo\" value=\""+(d.getEntidad()==null?"":d.getEntidad())+"\" /></p>");
            htm.append("            <p class=\"tercio\"><label for=\"cp\">C&oacute;digo postal</label><input type=\"text\" name=\"cp\" id=\"cp\" value=\""+(d.getCp()==null?"":d.getCp())+"\" /></p>");
            htm.append("            <p class=\"medio\"><label for=\"ctry\">Pa&iacute;s</label>");
            htm.append("            <select name=\"ctry\" id=\"ctry\">");
            Iterator<Country> countries = Country.ClassMgr.listCountries(wsite);
            if(countries.hasNext()) {
                Country c;
                while(countries.hasNext()) {
                    c = countries.next();
                    if(c.equals(d.getPais()))
                        htm.append("<option value=\""+c.getId()+"\" selected=\"selected\">"+c.getDisplayTitle(lang)+"</option>");
                    else
                        htm.append("<option value=\""+c.getId()+"\">"+c.getDisplayTitle(lang)+"</option>");
                }
            }
            htm.append("            </select></p>");
            htm.append("            <div class=\"clearer\">&nbsp;</div>");
            htm.append("        </div>");
            //datos familiares
            htm.append("        <div class=\"contacto_externo divisor\">");
            htm.append("            <h3>Datos familiares</h3>");
            //htm.append("        <p>Esta informaci&oacute;n es para uso exclusivo de la instituci&oacute;n, no aparecer&aacute; en tu perfil</p>");
            Iterator<Familia> familiares = p.listFamilias();
            htm.append("            <ol id=\"fms\">");
            if(familiares.hasNext()) {
                SWBResourceURL rem = paramRequest.getActionUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setAction(SWBResourceURL.Action_REMOVE);
                Familia f;
                while(familiares.hasNext()) {
                    f = familiares.next();
                    rem.setParameter("fid", f.getId());
                    htm.append("<li>");
                    htm.append("  <p class=\"tercio\">Nombre completo <br /><input type=\"text\" name=\"ncf\" value=\""+f.getMiembro()+"\" /></p>");
                    htm.append("  <p class=\"tercio\">Parentesco <br /><input type=\"text\" name=\"p\" value=\""+f.getParentesco()+"\" /></p>");
                    htm.append("  <p class=\"tercio\">Direcci&oacute;n <br /><input type=\"text\" name=\"df\" value=\""+f.getDireccion()+"\" /></p>");
                    htm.append("  <p class=\"tercio\">Tel&eacute;fono <br /><input type=\"text\" name=\"tf\" value=\""+f.getTelefono()+"\" /></p>");
                    htm.append("  <p><input type=\"button\" onclick=\"postHtml('"+rem+"','fms')\" value=\"Eliminar\" /></p>");
                    htm.append("</li>");
                }
            }else {
                htm.append("<li id=\"aaaa\">");
                htm.append("  <p class=\"tercio\">Nombre completo <br /><input type=\"text\" name=\"ncf\" value=\"\" /></p>");
                htm.append("  <p class=\"tercio\">Parentesco <br /><input type=\"text\" name=\"p\" value=\"\" /></p>");
                htm.append("  <p class=\"tercio\">Direcci&oacute;n <br /><input type=\"text\" name=\"df\" value=\"\" /></p>");
                htm.append("  <p class=\"tercio\">Tel&eacute;fono <br /><input type=\"text\" name=\"tf\" value=\"\" /></p>");
                htm.append("</li>");
            }
            htm.append("            </ol>");
            htm.append("            <p><a href=\"javascript:appendChild('_"+base.getId()+"_'+(idx++),'fms')\">Agregar</a></p>");
            htm.append("        </div>");
            
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
            htm.append("        <div class=\"de_interes divisor\">");
            htm.append("            <h3>Temas de tu inter&eacute;s</h3>");
            htm.append("            <p>El sistema te ofrecer&aacute; contenidos acordes con tus temas de inter&eacute;s</p>");
            Iterator<TemaInteres> tis = TemaInteres.ClassMgr.listTemaIntereses(wsite);
            if(tis.hasNext()) {
                htm.append("<ul>");
                TemaInteres ti;
                while(tis.hasNext()) {
                    ti = tis.next();
                    htm.append("  <li class=\"tercio\"><label for=\""+ti.getId()+"\"><input type=\"checkbox\" id=\""+ti.getId()+"\" value=\""+ti.getId()+"\"/> "+ti.getTitle(lang)+"</label></li>");
                }
                htm.append("</ul>");
            }
            htm.append("            <div class=\"clearer\">&nbsp;</div>");
            htm.append("        </div>");
            htm.append("        <div class=\"guardar\"><input type=\"submit\" value=\"Guardar\" /></div>");
            htm.append("    </div>  ");
            htm.append("</div>");
            htm.append("</form>");
            htm.append("\n<script type=\"text/javascript\">\n");
            htm.append("<!--\n");
            htm.append("  dojo.addOnLoad(collapse('acercade_mi'));\n");
            htm.append("-->\n");
            htm.append("</script>\n");            
            out.println(htm.toString());
        }
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
            final String url = SWBPlatform.getContextPath()+"/"+SWBPlatform.getEnv("swb/distributor")+"/"+wsite.getId()+"/editar_datos"+"/_lang/"+user.getLanguage();
            request.getSession(true).setAttribute(Send, Send_EDIT);
            response.sendRedirect(url);
        }else if(Send_CHGPHTO.equals(action)) {
            final String url = SWBPlatform.getContextPath()+"/"+SWBPlatform.getEnv("swb/distributor")+"/"+wsite.getId()+"/editar_foto"+"/_lang/"+user.getLanguage();
            request.getSession(true).setAttribute(Send, Send_CHGPHTO);
            response.sendRedirect(url);
        }else if(Send_REQ.equals(action)) {
            final String url = SWBPlatform.getContextPath()+"/"+SWBPlatform.getEnv("swb/distributor")+"/"+wsite.getId()+"/solicitudes"+"/_lang/"+user.getLanguage();
            response.sendRedirect(url);
        }else if(Send_FAV.equals(action)) {
            final String url = SWBPlatform.getContextPath()+"/"+SWBPlatform.getEnv("swb/distributor")+"/"+wsite.getId()+"/favoritos"+"/_lang/"+user.getLanguage();
            response.sendRedirect(url);
        }
        
        else if(SWBResourceURL.Action_EDIT.equals(action)) {
            SWProfile profile = SWProfile.ClassMgr.getSWProfile(user.getId(), wsite);
            if(user.equals(profile.getCreator())) {
//            SemanticProperty sp = SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#miPerfilSL");
//            SWProfile profile = (SWProfile)user.getExtendedAttribute(sp);
//            profile.setMisIdeas(request.getParameter("ideas"));
//            profile.setUbicacion(request.getParameter("loc"));
                boolean isMultipart = ServletFileUpload.isMultipartContent(request);
                if(isMultipart) {
                    try {
                        chgPhto(request, response);
                        final String url = SWBPlatform.getContextPath()+"/"+SWBPlatform.getEnv("swb/distributor")+"/"+wsite.getId()+"/editar_datos"+"/_lang/"+user.getLanguage();
                        request.getSession(true).setAttribute(Send, Send_EDIT);
                        response.sendRedirect(url);
                    }catch(Exception e) {
                        e.printStackTrace(System.out);
                    }
                }else {
                    profile.setMisIdeas(SWBUtils.XML.replaceXMLChars(request.getParameter("ideas")));
                    SemanticProperty ext = SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#extension");
                    try {
                        user.setExtendedAttribute(ext, new Integer(request.getParameter("ext")));
                    }catch(NumberFormatException nfe) {
                        log.error(nfe);
                    }catch(SWBException swbe) {
                        swbe.printStackTrace(System.out);
                        log.error(swbe);
                    }                
                    profile.setUbicacion(SWBUtils.XML.replaceXMLChars(request.getParameter("loc")));
                    CV cv = CV.ClassMgr.getCV(user.getId(), wsite);
                    Persona person = cv.getPersona();
                    Domicilio domicilio = person.getDomicilio();
                    domicilio.setCalle(SWBUtils.XML.replaceXMLChars(request.getParameter("cn")));
                    domicilio.setColonia(SWBUtils.XML.replaceXMLChars(request.getParameter("col")));
                    domicilio.setCiudad(SWBUtils.XML.replaceXMLChars(request.getParameter("cd")));
                    domicilio.setMunicipio(SWBUtils.XML.replaceXMLChars(request.getParameter("mun")));
                    domicilio.setEntidad(SWBUtils.XML.replaceXMLChars(request.getParameter("edo")));
                    try {
                        domicilio.setCp(Integer.toString(Integer.parseInt(SWBUtils.XML.replaceXMLChars(request.getParameter("cp")))));
                    }catch(Exception nfe) {
                    }
                    String countryId = SWBUtils.XML.replaceXMLChars(request.getParameter("ctry"));
                    if(Country.ClassMgr.hasCountry(countryId, wsite)) {
                        domicilio.setPais(Country.ClassMgr.getCountry(countryId, wsite));
                    }
                    String[] ncf = request.getParameterValues("ncf");
                    String[] p = request.getParameterValues("p");
                    String[] df = request.getParameterValues("df");
                    String[] tf = request.getParameterValues("tf");
                    for(int i=0; i<ncf.length; i++) {
                        Familia fam = Familia.ClassMgr.createFamilia(wsite);
                        try{fam.setMiembro(ncf[i]);}catch(IndexOutOfBoundsException iobe){}
                        try{fam.setParentesco(p[i]);}catch(IndexOutOfBoundsException iobe){}
                        try{fam.setDireccion(df[i]);}catch(IndexOutOfBoundsException iobe){}
                        try{fam.setTelefono(tf[i]);}catch(IndexOutOfBoundsException iobe){}
                        person.addFamilia(fam);
                    }
                    request.getSession(true).setAttribute(Send_EDIT, Send_EDIT);
                }
            }
        }else if(SWBResourceURL.Action_REMOVE.equals(action)) {
            SWProfile profile = SWProfile.ClassMgr.getSWProfile(user.getId(), wsite);
            if(user.equals(profile.getCreator())) {
                    String fid = request.getParameter("fid");
                if(Familia.ClassMgr.hasFamilia(fid, wsite)) {
                    Familia.ClassMgr.removeFamilia(fid, wsite);
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
        User me = paramRequest.getUser();
        
        PrintWriter out =  response.getWriter();
        StringBuilder htm = new StringBuilder();
        
        SWProfile profile = SWProfile.ClassMgr.getSWProfile(me.getId(), wsite);
        if( me.isSigned() && me.equals(profile.getCreator()) ) {
            CV cv = CV.ClassMgr.getCV(me.getId(), wsite);
            Persona p = cv.getPersona();
            Iterator<Familia> familiares = p.listFamilias();
            if(familiares.hasNext()) {
                SWBResourceURL rem = paramRequest.getActionUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setAction(SWBResourceURL.Action_REMOVE);
                Familia f;
                while(familiares.hasNext()) {
                    f = familiares.next();
                    rem.setParameter("fid", f.getId());
                    htm.append("<li>");
                    htm.append("  <p class=\"tercio\">Nombre completo <br /><input type=\"text\" name=\"ncf\" value=\""+f.getMiembro()+"\" /></p>");
                    htm.append("  <p class=\"tercio\">Parentesco <br /><input type=\"text\" name=\"p\" value=\""+f.getParentesco()+"\" /></p>");
                    htm.append("  <p class=\"tercio\">Direcci&oacute;n <br /><input type=\"text\" name=\"df\" value=\""+f.getDireccion()+"\" /></p>");
                    htm.append("  <p class=\"tercio\">Tel&eacute;fono <br /><input type=\"text\" name=\"tf\" value=\""+f.getTelefono()+"\" /></p>");
                    htm.append("  <p><input type=\"button\" onclick=\"postHtml('"+rem+"','fms')\" value=\"Eliminar\" /></p>");
                    htm.append("</li>");
                }
            }else {
                htm.append("<li>");
                htm.append("  <p class=\"tercio\">Nombre completo <br /><input type=\"text\" name=\"ncf\" value=\"\" /></p>");
                htm.append("  <p class=\"tercio\">Parentesco <br /><input type=\"text\" name=\"p\" value=\"\" /></p>");
                htm.append("  <p class=\"tercio\">Direcci&oacute;n <br /><input type=\"text\" name=\"df\" value=\"\" /></p>");
                htm.append("  <p class=\"tercio\">Tel&eacute;fono <br /><input type=\"text\" name=\"tf\" value=\"\" /></p>");
                htm.append("</li>");
            }
        }
        out.println(htm.toString());
    }
    
    public void doChgPhto(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        Resource base = getResourceBase();
        WebSite wsite = base.getWebSite();
        User me = paramRequest.getUser();
        
        PrintWriter out =  response.getWriter();
        
        SWProfile profile = SWProfile.ClassMgr.getSWProfile(me.getId(), wsite);
        if( me.isSigned() && me.equals(profile.getCreator()) ) {
            final String lang = me.getLanguage();
            final String axn = paramRequest.getActionUrl().setAction(SWBResourceURL.Action_EDIT).toString();
            StringBuilder htm = new StringBuilder();
            htm.append(script());
            htm.append("<form id=\"profile/user\" method=\"post\" enctype=\"multipart/form-data\" action=\""+axn+"\">");
            htm.append("<div id=\"perfil_usuario\">");
            htm.append("    <div id=\"formPerfil\">");
            htm.append("        <div class=\"perfil divisor\">");
            htm.append("            <h3>Mi perfil</h3>");
            final String pimg;
            if(me.getPhoto()==null)
                pimg = SWBPortal.getWebWorkPath()+"/models/"+wsite.getId()+"/css/user.jpg";
            else
                pimg = SWBPortal.getWebWorkPath()+profile.getWorkPath()+"/"+me.getPhoto();
            htm.append("            <div class=\"foto\"><img src=\""+pimg+"\" alt=\"\" /></div>");
            htm.append("            <div class=\"user\">");
            htm.append("                <p class=\"name\">"+me.getFullName()+"</p>");
            htm.append("                <p class=\"tercio\"><a href=\"#\">M&aacute;s acerca de m&iacute;</a></p>");
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
        js.append("    s = s.concat('<li id=\"');\n");
        js.append("    s = s.concat(childId);\n");
        js.append("    s = s.concat('\">');\n");
        js.append("    s = s.concat('  <p class=\"tercio\">Nombre completo <br /><input type=\"text\" name=\"ncf\" value=\"\" /></p>');\n");
        js.append("    s = s.concat('  <p class=\"tercio\">Parentesco <br /><input type=\"text\" name=\"p\" value=\"\" /></p>');\n");
        js.append("    s = s.concat('  <p class=\"tercio\">Direcci&oacute;n <br /><input type=\"text\" name=\"df\" value=\"\" /></p>');\n");
        js.append("    s = s.concat('  <p class=\"tercio\">Tel&eacute;fono <br /><input type=\"text\" name=\"tf\" value=\"\" /></p>');\n");
        js.append("    s = s.concat('  <p><input type=\"button\" onclick=\"dojo.destroy(\\''+childId+'\\')\" value=\"Eliminar\" /></p>');\n");
        js.append("    s = s.concat('</li>');\n");
        js.append("    dojo.place(s, parentId, 'last');\n");
        js.append("  }\n");
        js.append("-->\n");
        js.append("</script>\n");
        return js.toString();
    }
    
    private void chgPhto(HttpServletRequest request, SWBActionResponse response) throws Exception {
        Resource base = getResourceBase();    
        User me = response.getUser();
        SWProfile profile = SWProfile.ClassMgr.getSWProfile(me.getId(), base.getWebSite());
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (isMultipart && me.equals(profile.getCreator())) {
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
                        me.setPhoto(filename);
                    }
                    break;
                }
            }
        }
    }
}
