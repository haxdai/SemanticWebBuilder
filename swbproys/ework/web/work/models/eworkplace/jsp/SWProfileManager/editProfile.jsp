<%-- 
    Document   : editProfile
    Created on : 12-mar-2012, 20:41:26
    Author     : carlos.ramos
--%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@page import="com.infotec.cvi.swb.*"%>
<%@page import="com.infotec.eworkplace.swb.*"%>
<%@page import="org.semanticwb.SWBPlatform"%>
<%@page import="org.semanticwb.SWBPortal"%>
<%@page import="org.semanticwb.SWBUtils"%>
<%@page import="org.semanticwb.model.*"%>
<%@page import="org.semanticwb.platform.SemanticProperty"%>
<%@page import="org.semanticwb.portal.api.*"%>
<%@page import="java.util.Iterator"%>
<%@page import="static com.infotec.eworkplace.swb.resources.SWProfileManager.Mode_CHGPHTO"  %>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest"/>
<script type="text/javascript">
<!--
    dojo.require("dojo.fx");
    dojo.require("dijit.dijit");

    dojo.require("dijit.layout.ContentPane");
    dojo.require("dijit.form.Form");
    dojo.require("dijit.form.ValidationTextBox");
    dojo.require("dijit.form.Button");
    dojo.require("dijit.form.FilteringSelect");
    dojo.require("dijit.form.CheckBox");

    function enviar() {
        var objd=dijit.byId('form1ud');
        if(objd.validate())
        {
            return true;
        }else {
            alert("Datos incompletos o erroneos");
        }
        return false;
    }

    function expande(domId) {
       var anim1 = dojo.fx.wipeIn( {node:domId, duration:500 });
       var anim2 = dojo.fadeIn({node:domId, duration:650});
       dojo.fx.combine([anim1,anim2]).play();
    }

    function collapse(domId) {
       var anim1 = dojo.fx.wipeOut( {node:domId, duration:500 });
       var anim2 = dojo.fadeOut({node:domId, duration:650});
       dojo.fx.combine([anim1, anim2]).play();
    }
-->
</script>
<%
    User user = paramRequest.getUser();
    if(!user.isSigned())
        return;
    WebSite wsite = paramRequest.getWebPage().getWebSite();
    SWProfile profile = SWProfile.ClassMgr.getSWProfile(user.getId(), wsite);
    if(user.equals(profile.getCreator())) {
        final String lang = user.getLanguage();
        final String axn = paramRequest.getActionUrl().setAction(SWBResourceURL.Action_EDIT).toString();
        StringBuilder htm = new StringBuilder();
        htm.append("<form id=\"profile/user\" method=\"post\" action=\""+axn+"\">");
        htm.append("<div id=\"formPerfil\">");

        //datos empleado
        htm.append(" <div class=\"perfil divisor\">");
        htm.append("  <h3>Mi perfil | Datos personales | C Vitae</h3>");
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

        //adscripci�n
//            htm.append("    <p class=\"entero\"><label>Direcci&oacute;n de adscripci&oacute;n</label>");
//            htm.append("     <select name=\"da\">");
//            htm.append("      <option>Competitividad</option>");
//            htm.append("     </select></p>");

//            htm.append("   <p class=\"status entero\"><label>&iquest;Qu&eacute; haces o piensas?</label>");
//            htm.append("    <textarea name=\"ideas\" id=\"ideas\" rows=\"2\" cols=\"70\">");
        //SemanticProperty ideas = SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#ideas");
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
//            SemanticProperty ext = SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#extension");
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
//            //TODO: cambiar colonia, municipio, estado, CP a objetos, ya son cat�logos
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
        htm.append("</form>");
        htm.append("\n<script type=\"text/javascript\">\n");
        htm.append("<!--\n");
        htm.append("  dojo.addOnLoad(collapse('acercade_mi'));\n");
        htm.append("-->\n");
        htm.append("</script>\n");            
        out.println(htm.toString());
    }else {
        out.println("<p>usuario distinto al due�o del perfil</p>");
    }
%>
