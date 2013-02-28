<%-- 
    Document   : editProfile
    Created on : 12-mar-2012, 20:41:26
    Author     : carlos.ramos
--%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@page import="com.infotec.eworkplace.swb.*"%>
<%@page import="org.semanticwb.SWBPlatform"%>
<%@page import="org.semanticwb.SWBPortal"%>
<%@page import="org.semanticwb.SWBUtils"%>
<%@page import="org.semanticwb.model.*"%>
<%@page import="org.semanticwb.platform.*"%>
<%@page import="org.semanticwb.portal.api.*"%>
<%@page import="java.util.Iterator"%>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest"/>
<jsp:useBean id="contentURL" scope="request" type="java.lang.String"/>
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
        //final String axn = paramRequest.getActionUrl().setAction(SWBResourceURL.Action_EDIT).toString();
%>
        <form id="form1ud" dojoType="dijit.form.Form" class="swbform">
        <div id="formPerfil">
        <div id="menu_perfil">
         <ul>
          <li><a href="<%=(contentURL+"?act="+SWBResourceURL.Action_EDIT)%>" title="Editar mi perfil">Editar mi perfil</a></li>
          <li><a href="<%=(SWBPlatform.getContextPath()+"/"+SWBPlatform.getEnv("swb/distributor")+"/"+wsite.getId()+"/"+wsite.getWebPage("Favoritos").getId()+"/_lang/"+lang)%>" title="Ir a mis favoritos">Mis favoritos</a></li>
          <li><a href="<%=(SWBPlatform.getContextPath()+"/"+SWBPlatform.getEnv("swb/distributor")+"/"+wsite.getId()+"/Mis_tareas"+"/_lang/"+user.getLanguage())%>" title="Ir a mis solicitudes">Mis solicitudes</a></li>
          <li>Mi perfil</li>
         </ul>
        </div>
        <!-- //datos empleado -->
         <div class="perfil divisor">
<%
        final String pimg;
        if(user.getPhoto()==null)
            pimg = SWBPortal.getWebWorkPath()+"/models/"+wsite.getId()+"/css/user.jpg";
        else
            pimg = SWBPortal.getWebWorkPath()+profile.getWorkPath()+"/"+user.getPhoto();
%>
          <div class="foto">
              <img src="<%=pimg%>" alt="<%=user.getFullName()%>" />
          </div>
          <div class="usuario">
           <p class="name">
            <a href="javascript:expande('acercade_mi')" title="<%=paramRequest.getLocaleString("lblAboutMe")%>"><%=paramRequest.getLocaleString("lblAboutMe")%></a><br/>
            <%=user.getFullName()%>
           </p>
           <p>
            <label for="pos"><%=paramRequest.getLocaleString("lblPosition")%></label>
            <input type="text" name="pos" id="pos" dojoType="dijit.form.ValidationTextBox" required="true" value="<%=profile.getPuesto()==null?"":profile.getPuesto()%>" promptMessage="<%=paramRequest.getLocaleString("promptMsgPosition")%>" invalidMessage="<%=paramRequest.getLocaleString("promptMsgFaultPosition")%>" trim="true" readonly="readonly" />
           </p>
           <div class="postit">
            <label for="postit"><%=paramRequest.getLocaleString("lblPostit")%></label>
            <div class="dialogo_postit"></div>
            <input type="text" name="postit" id="postit" dojoType="dijit.form.ValidationTextBox" value="<%=profile.getPostit()==null?"":profile.getPostit()%>" promptMessage="<%=paramRequest.getLocaleString("promptMsgPostit")%>" trim="true" />
           </div>
          </div>
          <div class="datos">
           <div id="acercade_mi" class="divisor">
            <h3><%=paramRequest.getLocaleString("titleAboutMe")%></h3>
            <div class="text_editor">
             <p class="status entero">
              <label for="prsnld"><%=paramRequest.getLocaleString("lblPersonality")%></label>
              <textarea name="prsnld" id="prsnld" rows="4" cols="70" readonly="readonly"><%=profile.getMiPersonalidad()==null?"":profile.getMiPersonalidad()%></textarea>
             </p>
            </div>

            <div class="text_editor">
             <p class="status entero">
              <label for="gsts"><%=paramRequest.getLocaleString("lblLikes")%></label>
              <textarea name="gsts" id="gsts" rows="4" cols="70" readonly="readonly"><%=profile.getMisGustos()==null?"":profile.getMisGustos()%></textarea>
             </p>
            </div>

            <div class="status entero">
             <p class="status entero">
              <label for="ideas"><%=paramRequest.getLocaleString("lblIdeas")%></label>
              <textarea name="ideas" id="ideas" rows="4" cols="70" readonly="readonly"><%=profile.getMisIdeas()==null?"":profile.getMisIdeas()%></textarea>
             </p>
            </div>
            <a href="javascript:collapse('acercade_mi')"><%=paramRequest.getLocaleString("lblClose")%></a>
           </div>

        <!-- //adscripción -->
          </div>
          <div class="clearer">&nbsp;</div>
         </div>

        <!-- //contacto interno -->
         <div class="contacto_interno divisor">
          <h3><%=paramRequest.getLocaleString("titleIContact")%></h3>
<%
        Persona persona = Persona.ClassMgr.getPersona(user.getId(), wsite);
        Telefono tel = persona.getTelefonoByTipo(Telefono.TipoTelefono.Trabajo);
%>
          <p class="entero">
           <label for="email"><%=paramRequest.getLocaleString("lblEmail")%></label>
           <input type="text" name="email" id="email"  dojoType="dijit.form.ValidationTextBox" value="<%=user.getEmail()%>" trim="true" readonly="readonly" style=" width:300px" />
          </p>
          
          <p class="tercio">
           <label for="ld"><%=paramRequest.getLocaleString("lblPhoneLada")%></label>
           <input type="text" name="ld" id="ld" dojoType="dijit.form.ValidationTextBox" value="<%=tel!=null&&tel.getLada()>0?Integer.toString(tel.getLada()):""%>" trim="true" readonly="readonly" />
          </p>
          <p class="tercio">
           <label for="tfo"><%=paramRequest.getLocaleString("lblPhoneNum")%></label>
           <input type="text" name="tfo" id="tfo" dojoType="dijit.form.ValidationTextBox" value="<%=tel!=null&&tel.getNumero()>0?Integer.toString(tel.getNumero()):""%>" trim="true" readonly="readonly"/>
          </p>
          <p class="tercio">
           <label for="ext"><%=paramRequest.getLocaleString("lblPhoneExt")%></label>
           <input type="text" name="ext" id="ext" dojoType="dijit.form.ValidationTextBox" value="<%=tel!=null&&tel.getExtension()>0?Integer.toString(tel.getExtension()):""%>" trim="true" readonly="readonly" />
          </p>
          
          <p class="entero">
           <label for="loc"><%=paramRequest.getLocaleString("lblLoc")%></label>
           <textarea name="loc" id="loc" rows="2" dojoType="ValidationTextarea" trim="true" readonly="readonly"><%=profile.getUbicacion()==null?"":profile.getUbicacion()%></textarea>
          </p>
<%
        UserRepository ur = wsite.getUserRepository();
        UserGroup infotec = ur.getUserGroup("OU:Corporativo");
        UserGroup adscription = null;
        Iterator<UserGroup> it = infotec.listChilds();
        while(it.hasNext()) {
            adscription = it.next();
            if(user.hasUserGroup(adscription)) {          
                break;
            }
        }
%>

<%
%>        
          <p class="tercio">
           <label for="ads"><%=paramRequest.getLocaleString("lblDr")%></label>
           <input type="text" name="ads" id="ads" dojoType="dijit.form.ValidationTextBox" value="<%=adscription==null?"":adscription.getDisplayTitle(lang)%>" trim="true" readonly="readonly" />
          </p>
          
          <p class="tercio">
           <label for="iboss"><%=paramRequest.getLocaleString("lblIBoss")%></label>
           <input type="text" name="iboss" id="iboss"  dojoType="dijit.form.ValidationTextBox" value="<%=profile.getJefeInmediato()==null?"":profile.getJefeInmediato().getFullName()%>" trim="true" readonly="readonly" />
          </p>
 <%
    //SemanticProperty ext = SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#noe");
    SemanticClass sc = org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Empleado");
    SemanticProperty sp = sc.getProperty("extension");
%>         
          <!--p class="tercio">
           <label for="extdr"><%=paramRequest.getLocaleString("lblPhoneExtDr")%></label>
           <input type="text" name="extdr" id="extdr" dojoType="dijit.form.ValidationTextBox" value="<%=user.getExtendedAttribute(sp)==null?"10":user.getExtendedAttribute(sp)%>" trim="true" readonly="readonly" />
          </p-->
          
          <div class="clearer">&nbsp;</div>
         </div>

        <!-- //contacto externo -->
         <div class="de_interes divisor">
          <h3>Temas de mi inter&eacute;s</h3>
<%
        Iterator<TemaInteres> tis = profile.listTemaIntereses();
        if(tis.hasNext()) {
%>          
          <ul>
<%
            TemaInteres ti;
            while(tis.hasNext()) {
                ti = tis.next();
                if(profile.hasTemaInteres(ti)) {
%>
               <li class="tercio"><%=ti.getDisplayTitle(lang)%></li>
<%
               }
            }
%>
          </ul>
<%
       }else {
%>
          <p><%=(user.getFirstName())%> no ha agregado temas de inter&eacute;s</p> 
<%
       }
%>
          <div class="clearer">&nbsp;</div>
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
        <p>&excl;usuario distinto al dueño del perfil¡</p>
<%
    }
%>