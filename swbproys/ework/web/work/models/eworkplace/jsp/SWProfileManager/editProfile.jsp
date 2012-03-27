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

    function enviar(frmId) {
        var objd=dijit.byId(frmId);
        if(objd.validate())
        {
            return true;
        }else {
            alert("Datos incompletos o incorrectos");
        }
        return false;
    }
    
dojo.provide("ValidationTextarea");
dojo.require("dijit.form.SimpleTextarea");
dojo.require("dijit.form.ValidationTextBox");
dojo.require("dijit.form.FilteringSelect");

dojo.declare(
    "ValidationTextarea",
    [dijit.form.ValidationTextBox, dijit.form.SimpleTextarea],
    {
        invalidMessage: "Este dato es requerido",
        promptMessage: "Ingresa",
        postCreate: function() {
            this.inherited(arguments);
        },
        validate: function() {
            if(arguments.length==0)
                return this.validate(false);
            return this.inherited(arguments);
        },
        onFocus: function() {
            if(!this.isValid()) {
                this.displayMessage(this.getErrorMessage());
            }
        },
        onBlur: function() {
            this.validate(false);
        }
     }
);


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
        //StringBuilder htm = new StringBuilder();
%>
        <form id="form1ep" dojoType="dijit.form.Form" class="swbform" method="post" action="<%=axn%>">
        <div id="formPerfil">
        <!-- //datos empleado -->
         <div class="perfil divisor">
          <h3>Mi perfil | Datos personales | CVI</h3>
<%
        final String pimg;
        if(user.getPhoto()==null)
            pimg = SWBPortal.getWebWorkPath()+"/models/"+wsite.getId()+"/css/user.jpg";
        else
            pimg = SWBPortal.getWebWorkPath()+profile.getWorkPath()+"/"+user.getPhoto();
%>
          <div class="foto">
              <img src="<%=pimg%>" alt="<%=user.getFullName()%>" />
              <a href="<%=paramRequest.getRenderUrl().setMode(Mode_CHGPHTO)%>">Cambiar foto</a>
          </div>
          <div class="usuario">
           <p class="name"><%=user.getFullName()%></p>
          </div>
          <p class="mas_deMi">
              <a href="javascript:expande('acercade_mi')">M&aacute;s acerca de m&iacute;</a>
          </p>
          <div class="datos">
           <div id="acercade_mi" class="divisor">
            <h3>Acerca de mi</h3>
            <div class="text_editor">
             <p class="status entero">
              <label for="prsnld">Mi personalidad</label>
              <textarea name="prsnld" id="prsnld" rows="2" cols="70" dojoType="ValidationTextarea" promptMessage="<%=paramRequest.getLocaleString("promptMsgPersonality")%>" invalidMessage="<%=paramRequest.getLocaleString("promptMsgFaultPersonality")%>" required="true" trim="true"><%=profile.getMiPersonalidad()==null?"":profile.getMiPersonalidad()%></textarea>
             </p>
            </div>

            <div class="text_editor">
             <p class="status entero">
              <label for="gsts">Mis gustos e intereses</label>
              <textarea name="gsts" id="gsts" rows="2" cols="70" dojoType="ValidationTextarea" promptMessage="<%=paramRequest.getLocaleString("promptMsgLikes")%>" invalidMessage="<%=paramRequest.getLocaleString("promptMsgFaultLikes")%>" required="true" trim="true"><%=profile.getMisGustos()==null?"":profile.getMisGustos()%></textarea>
             </p>
            </div>

            <div class="status entero">
             <p class="status entero">
              <label for="ideas">Mis ideas para mejorar M&eacute;xico y el mundo</label>
              <textarea name="ideas" id="ideas" rows="2" cols="70" dojoType="ValidationTextarea" promptMessage="<%=paramRequest.getLocaleString("promptMsgIdeas")%>" invalidMessage="<%=paramRequest.getLocaleString("promptMsgFaultIdeas")%>" required="true" trim="true"><%=profile.getMisIdeas()==null?"":profile.getMisIdeas()%></textarea>
             </p>
            </div>
            <a href="javascript:collapse('acercade_mi')">Cerrar</a>
           </div>

        <!-- //adscripción -->
<%
/*UserRepository ur = wsite.getUserRepository();
UserGroup infotec = ur.getUserGroup("Infotec");
System.out.println("GRUPO infotec "+infotec.getId());
Iterator<UserGroup> it = infotec.listAllChilds();
while(it.hasNext()) {
    System.out.println(it.next().getTitle());
}
System.out.println("-------------");
it = infotec.listChilds();
while(it.hasNext()) {
    System.out.println(it.next().getTitle());
}*/


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
%>
          </div>
          <div class="clearer">&nbsp;</div>
         </div>

        <!-- //contacto interno -->
         <div class="contacto_interno divisor">
          <h3>Contacto interno</h3>
<%
        CV cv = CV.ClassMgr.getCV(user.getId(), wsite);
        Persona persona = cv.getPersona();
        Iterator<Telefono> tels = persona.listTelefonos();
        Telefono tel = null;
        while(tels.hasNext()) {
            tel = tels.next();
            try {
                Telefono.TipoTelefono.valueOf(tel.getTipo());
                if(Telefono.TipoTelefono.Trabajo.name().equals(tel.getTipo()))
                    break;
                else
                    tel = null;
            }catch(Exception e) {
            }
        }
%>
          <p class="entero">
           <label for="email">Correo electr&oacute;nico institucional</label>
           <input type="text" name="email" id="email"  dojoType="dijit.form.ValidationTextBox" required="true" value="<%=user.getEmail()%>" maxlength="60" promptMessage="<%=paramRequest.getLocaleString("promptMsgEmail")%>" invalidMessage="<%=paramRequest.getLocaleString("promptMsgFaultEmail")%>" isValid="return isValidEmail(this.textbox.value)" trim="true" style="width:280px" />
          </p>
          
          <p class="tercio">
           <label for="ld">Clave Lada</label>
           <input type="text" name="ld" id="ld" dojoType="dijit.form.ValidationTextBox" value="<%=tel!=null&&tel.getLada()>0?Integer.toString(tel.getLada()):""%>" maxlength="3" promptMessage="<%=paramRequest.getLocaleString("promptMsgPhoneLada")%>" invalidMessage="<%=paramRequest.getLocaleString("promptMsgFaultPhoneLada")%>" regExp="\d{2,3}" trim="true" />
          </p>
          <p class="tercio">
           <label for="tfo">Telefono</label>
           <input type="text" name="tfo" id="tfo" dojoType="dijit.form.ValidationTextBox" value="<%=tel!=null&&tel.getNumero()>0?Integer.toString(tel.getNumero()):""%>" maxlength="8" required="true" promptMessage="<%=paramRequest.getLocaleString("promptMsgPhone")%>" invalidMessage="<%=paramRequest.getLocaleString("promptMsgFaultPhone")%>" regExp="\d{7,8}" trim="true"/>
          </p>
          <p class="tercio">
           <label for="ext">Extension</label>
           <input type="text" name="ext" id="ext" dojoType="dijit.form.ValidationTextBox" value="<%=tel!=null&&tel.getExtension()>0?Integer.toString(tel.getExtension()):""%>" maxlength="6" promptMessage="<%=paramRequest.getLocaleString("promptMsgPhoneExt")%>" invalidMessage="<%=paramRequest.getLocaleString("promptMsgFaultExt")%>" regExp="\d{1,6}" trim="true"/>
          </p>
          
          <p class="entero">
              <label for="loc">Ubicaci&oacute;n <a href="#" title="Ver mapa de ubicación">Ver mapa</a></label>
           <textarea name="loc" id="loc" rows="2" dojoType="ValidationTextarea" promptMessage="<%=paramRequest.getLocaleString("promptMsgLocation")%>" invalidMessage="<%=paramRequest.getLocaleString("promptMsgFaultLocation")%>" required="true" trim="true"><%=profile.getUbicacion()==null?"":profile.getUbicacion()%></textarea>
          </p>
          
<%
    SemanticProperty ext = SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#noe");
    
%>
          <p class="entero">
           <label for="ads">Adscripci&oacute;n</label>
           <select name="ads" id="ads"  dojoType="dijit.form.FilteringSelect" required="true" promptMessage="Adscripción" invalidMessage="La adscripción es requerida" style="width:350px">
               <option value=""></option>
<%
        UserRepository ur = wsite.getUserRepository();
System.out.println("ur="+ur.getTitle()+","+ur.getId());
        UserGroup infotec = ur.getUserGroup("Infotec");
        UserGroup ug;
        Iterator<UserGroup> it = infotec.listAllChilds();
        it = SWBComparator.sortByDisplayName(it, user.getLanguage());
        while(it.hasNext()) {
            ug = it.next();
System.out.println("... ug="+ug);
System.out.println("... user.getUserGroup()="+user.getUserGroup());
System.out.println("......ug.equals(user.getUserGroup())="+ug.equals(user.getUserGroup()));
            if(ug.equals(infotec))
                continue;
%>
            <option <%=(ug.equals(user.getUserGroup())?"selected=\"selected\"":"")%> value="<%=(ug.getId())%>"><%=(ug.getDescription())%></option>
<%
        }
%>
           </select>
          </p>
          
          <p class="tercio">
           <label for="extdr">Extensi&oacute;n de tu adscripci&oacute;n</label>
           <input type="text" name="extdr" id="extdr" dojoType="dijit.form.ValidationTextBox" value="<%=user.getExtendedAttribute(ext)==null?"":user.getExtendedAttribute(ext)%>" maxlength="6" required="true" promptMessage="<%=paramRequest.getLocaleString("promptMsgPhoneExtDr")%>" invalidMessage="<%=paramRequest.getLocaleString("promptMsgFaultExt")%>" regExp="\d{1,6}" trim="true" />
          </p>
          
          
          <div class="clearer">&nbsp;</div>
         </div>

        <!-- //contacto externo -->
<%
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
%>
        <!-- // temas de interes -->
         <div class="de_interes divisor">
          <h3>Temas de mi inter&eacute;s</h3>
              <!--em>El sistema te ofrecer&aacute; contenidos acordes con tus temas de inter&eacute;s</em-->
<%
        Iterator<TemaInteres> tis = TemaInteres.ClassMgr.listTemaIntereses(wsite);
        if(tis.hasNext()) {
%>
              <ul>
<%
            TemaInteres ti;
            while(tis.hasNext()) {
                ti = tis.next();
%>
                   <li class="tercio"><label for="<%=ti.getId()%>"><input type="checkbox" name="mti" id="<%=ti.getId()%>" value="<%=ti.getId()%>" <%=profile.hasTemaInteres(ti)?"checked=\"checked\"":""%> /><%=ti.getDisplayTitle(lang)%></label></li>
<%
            }
%>
              </ul>
<%
        }
%>
          <div class="clearer">&nbsp;</div>
         </div>

         <div class="guardar">
          <input type="reset" value="Restablecer" />
          <input type="submit" value="Guardar" onclick="return enviar(this.form.id)" />
         </div>
        </div>
        </form>
        <script type="text/javascript">
        <!--
          dojo.addOnLoad(collapse('acercade_mi'));
        -->
        </script>
<%
    }else {
%>
        <p>usuario distinto al dueño del perfil</p>
<%
    }
%>
