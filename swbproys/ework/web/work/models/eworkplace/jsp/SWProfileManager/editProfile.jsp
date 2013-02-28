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
<%@page import="org.semanticwb.platform.SemanticProperty"%>
<%@page import="org.semanticwb.portal.api.*"%>
<%@page import="java.util.Iterator"%>
<%@page import="static com.infotec.eworkplace.swb.resources.SWProfileManager.*"  %>
<!--jsp:useBean id="me" scope="request" type="com.infotec.eworkplace.swb.resources.SWProfileManager"/-->
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest"/>
<jsp:useBean id="contentURL" scope="request" type="java.lang.String"/>
<%
    User user = paramRequest.getUser();
    if(!user.isSigned())
        return;
    WebSite wsite = paramRequest.getWebPage().getWebSite();
    SWProfile profile = SWProfile.ClassMgr.getSWProfile(user.getId(), wsite);
    if(user.equals(profile.getCreator())) {
%>
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
dojo.require('dojo.data.ItemFileReadStore');

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
        final String lang = user.getLanguage();
        final String axn = paramRequest.getActionUrl().setAction(SWBResourceURL.Action_EDIT).toString();
%>
        <form id="form1ep" dojoType="dijit.form.Form" class="swbform" method="post" action="<%=axn%>">
        <div id="formPerfil">
        <div id="menu_perfil">
         <ul>
          <li>Editar mi perfil</li>
          <li><a href="<%=(SWBPlatform.getContextPath()+"/"+SWBPlatform.getEnv("swb/distributor")+"/"+wsite.getId()+"/"+wsite.getWebPage("Favoritos").getId()+"/_lang/"+lang)%>" title="Ir a mis favoritos">Mis favoritos</a></li>
          <li><a href="<%=(SWBPlatform.getContextPath()+"/"+SWBPlatform.getEnv("swb/distributor")+"/"+wsite.getId()+"/Mis_tareas"+"/_lang/"+user.getLanguage())%>" title="Ir a mis solicitudes">Mis solicitudes</a></li>
          <li><a href="<%=(contentURL+"?act="+SWBResourceURL.Action_ADD)%>" title="Ver mi perfil">Mi perfil</a></li>
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
              <a href="<%=paramRequest.getRenderUrl().setMode(Mode_CHGPHTO)%>" title="<%=paramRequest.getLocaleString("lblChangePhoto")%>">
                  <img src="<%=pimg%>" alt="<%=user.getFullName()%>" />
                  <span><%=paramRequest.getLocaleString("lblChangePhoto")%></span>
              </a>
          </div>
          <div class="usuario">     
           <p class="name">
            <a href="javascript:expande('acercade_mi')" title="<%=paramRequest.getLocaleString("lblAboutMe")%>"><%=paramRequest.getLocaleString("lblAboutMe")%></a><br/>
            <%=user.getFullName()%>
           </p>
<p>
 <label for="pos"><%=paramRequest.getLocaleString("lblPosition")%></label>
 <input type="text" name="pos" id="pos" dojoType="dijit.form.ValidationTextBox" required="true" value="<%=(request.getParameter("pos")!=null?request.getParameter("pos"):profile.getPuesto()==null?"":profile.getPuesto())%>" promptMessage="<%=paramRequest.getLocaleString("promptMsgPosition")%>" invalidMessage="<%=paramRequest.getLocaleString("promptMsgFaultPosition")%>" trim="true" />
</p>
<div class="postit">
 <label for="postit"><%=paramRequest.getLocaleString("lblPostit")%></label>
 <div class="dialogo_postit"></div>
 <input onfocus="if(this.textbox.value=='<%=paramRequest.getLocaleString("lblPostit")%>')this.textbox.value=''" onblur="if(isEmpty(this.textbox.value))this.textbox.value='<%=paramRequest.getLocaleString("lblPostit")%>'" type="text" name="postit" id="postit" dojoType="dijit.form.ValidationTextBox" value="<%=(request.getParameter("postit")!=null?request.getParameter("postit"):profile.getPostit()==null||profile.getPostit().isEmpty()?paramRequest.getLocaleString("lblPostit"):profile.getPostit())%>" promptMessage="<%=paramRequest.getLocaleString("promptMsgPostit")%>" trim="true"  />
</div>
          </div>
          <!--p class="mas_deMi">
              <a href="javascript:expande('acercade_mi')" title="<%=paramRequest.getLocaleString("lblAboutMe")%>"><%=paramRequest.getLocaleString("lblAboutMe")%></a>
          </p-->
          <div class="datos">
           <div id="acercade_mi" class="divisor">
            <h3><%=paramRequest.getLocaleString("titleAboutMe")%></h3>
            <div class="text_editor">
             <p class="status entero">
              <label for="prsnld"><%=paramRequest.getLocaleString("lblPersonality")%></label>
              <textarea name="prsnld" id="prsnld" rows="2" cols="70" dojoType="ValidationTextarea" required="false" promptMessage="<%=paramRequest.getLocaleString("promptMsgPersonality")%>" invalidMessage="<%=paramRequest.getLocaleString("promptMsgFaultPersonality")%>" trim="true"><%=(request.getParameter("prsnld")!=null?request.getParameter("prsnld"):profile.getMiPersonalidad()==null?"":profile.getMiPersonalidad())%></textarea>
             </p>
            </div>

            <div class="text_editor">
             <p class="status entero">
              <label for="gsts"><%=paramRequest.getLocaleString("lblLikes")%></label>
              <textarea name="gsts" id="gsts" rows="2" cols="70" dojoType="ValidationTextarea" required="false" promptMessage="<%=paramRequest.getLocaleString("promptMsgLikes")%>" invalidMessage="<%=paramRequest.getLocaleString("promptMsgFaultLikes")%>" trim="true"><%=(request.getParameter("gsts")!=null?request.getParameter("gsts"):profile.getMisGustos()==null?"":profile.getMisGustos())%></textarea>
             </p>
            </div>

            <div class="status entero">
             <p class="status entero">
              <label for="ideas"><%=paramRequest.getLocaleString("lblIdeas")%></label>
              <textarea name="ideas" id="ideas" rows="2" cols="70" dojoType="ValidationTextarea" required="false" promptMessage="<%=paramRequest.getLocaleString("promptMsgIdeas")%>" invalidMessage="<%=paramRequest.getLocaleString("promptMsgFaultIdeas")%>" trim="true"><%=(request.getParameter("ideas")!=null?request.getParameter("ideas"):profile.getMisIdeas()==null?"":profile.getMisIdeas())%></textarea>
             </p>
            </div>
            <a href="javascript:collapse('acercade_mi')"><%=paramRequest.getLocaleString("lblClose")%></a>
           </div>
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
              <label for="email"><em>*</em><%=paramRequest.getLocaleString("lblEmail")%></label>
           <input type="text" name="email" id="email"  dojoType="dijit.form.ValidationTextBox" required="true" value="<%=(request.getParameter("email")!=null?request.getParameter("email"):user.getEmail())%>" maxlength="60" promptMessage="<%=paramRequest.getLocaleString("promptMsgEmail")%>" invalidMessage="<%=paramRequest.getLocaleString("promptMsgFaultEmail")%>" isValid="return isValidEmail(this.textbox.value)" trim="true" style="width:300px" />
          </p>
          
          <p class="tercio">
           <label for="ld"><%=paramRequest.getLocaleString("lblPhoneLada")%></label>
           <input type="text" name="ld" id="ld" dojoType="dijit.form.ValidationTextBox" value="<%=(request.getParameter("ld")!=null?request.getParameter("ld"):tel!=null&&tel.getLada()>0?Integer.toString(tel.getLada()):"")%>" maxlength="3" promptMessage="<%=paramRequest.getLocaleString("promptMsgPhoneLada")%>" invalidMessage="<%=paramRequest.getLocaleString("promptMsgFaultPhoneLada")%>" regExp="\d{2,3}" trim="true" />
          </p>
          <p class="tercio">
              <label for="tfo"><em>*</em><%=paramRequest.getLocaleString("lblPhoneNum")%></label>
           <input type="text" name="tfo" id="tfo" dojoType="dijit.form.ValidationTextBox" required="true" value="<%=(request.getParameter("tfo")!=null?request.getParameter("tfo"):tel!=null&&tel.getNumero()>0?Integer.toString(tel.getNumero()):"")%>" maxlength="8" promptMessage="<%=paramRequest.getLocaleString("promptMsgPhone")%>" invalidMessage="<%=paramRequest.getLocaleString("promptMsgFaultPhone")%>" regExp="\d{7,8}" trim="true"/>
          </p>
          <p class="tercio">
           <label for="ext"><%=paramRequest.getLocaleString("lblPhoneExt")%></label>
           <input type="text" name="ext" id="ext" dojoType="dijit.form.ValidationTextBox" value="<%=(request.getParameter("ext")!=null?request.getParameter("ext"):tel!=null&&tel.getExtension()>0?Integer.toString(tel.getExtension()):"")%>" maxlength="6" promptMessage="<%=paramRequest.getLocaleString("promptMsgPhoneExt")%>" invalidMessage="<%=paramRequest.getLocaleString("promptMsgFaultExt")%>" regExp="\d{1,6}" trim="true"/>
          </p>
          
          <p class="entero">
              <label for="loc"><em>*</em><%=paramRequest.getLocaleString("lblLoc")%></label>
           <textarea name="loc" id="loc" rows="2" dojoType="ValidationTextarea" required="true" promptMessage="<%=paramRequest.getLocaleString("promptMsgLoc")%>" invalidMessage="<%=paramRequest.getLocaleString("promptMsgFaultLoc")%>" trim="true"><%=(request.getParameter("loc")!=null?request.getParameter("loc"):profile.getUbicacion()==null?"":profile.getUbicacion())%></textarea>
          </p>         
<%
        UserRepository ur = wsite.getUserRepository();
        UserGroup infotec = ur.getUserGroup("OU:Corporativo");
        //UserGroup infotec = me.getInfotec();
        UserGroup adscription = null;
        Iterator<UserGroup> it = infotec.listChilds();
        while(it.hasNext()) {
            adscription = it.next();
            if(user.hasUserGroup(adscription)) {         
                break;
            }
        }
        SemanticProperty ext = SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#noe");
        SWBResourceURL urlMando = paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT);
        String provisional = "http://comunidad.infotec.com.mx/work/models/eworkplace/jsp/newjsp.jsp";
%>
          <div dojoType="dojo.data.ItemFileReadStore" jsId="strads" url="<%=urlMando.setMode(Mode_ADS)%>"></div>
          <div dojoType="dojo.data.ItemFileReadStore" jsId="strichief" url="<%=urlMando.setMode(Mode_IBSS)%>"></div>
          <!--div dojoType="dojo.data.ItemFileReadStore" jsId="strichief" url="<%=provisional%>"></div-->
          <p class="tercio">
              <label for="ads"><em>*</em><%=paramRequest.getLocaleString("lblDr")%></label>
              <input name="ads" id="ads" dojoType="dijit.form.FilteringSelect" required="true" value="<%=(request.getParameter("ads")!=null?request.getParameter("ads"):adscription==null?"":adscription.getId())%>" store="strads" onblur="dijit.byId('chief').attr('value','');dijit.byId('chief').query.dir = this.value;" onChange="dijit.byId('chief').attr('value','');dijit.byId('chief').query.dir = this.value;" promptMessage="<%=paramRequest.getLocaleString("promptMsgDr")%>" invalidMessage="<%=paramRequest.getLocaleString("promptMsgFaultDr")%>" />
          </p>
          <p class="tercio">
              <label for="chief"><em>*</em><%=paramRequest.getLocaleString("lblIBoss")%></label>
              <input name="chief" id="chief" dojoType="dijit.form.FilteringSelect" required="true" value="<%=(request.getParameter("chief")!=null?request.getParameter("chief"):profile.getJefeInmediato()==null?"":profile.getJefeInmediato().getId())%>" store="strichief" promptMessage="<%=paramRequest.getLocaleString("promptMsgIBoss")%>" invalidMessage="<%=paramRequest.getLocaleString("promptMsgFaultIBoss")%>" />
          </p>
          
          <!--p class="tercio">
              <label for="extdr"><em>*</em><%=paramRequest.getLocaleString("lblPhoneExtDr")%></label>
           <input type="text" name="extdr" id="extdr" dojoType="dijit.form.ValidationTextBox" required="false" value="<%=(request.getParameter("extdr")!=null?request.getParameter("extdr"):user.getExtendedAttribute(ext)==null?"":user.getExtendedAttribute(ext))%>" maxlength="6" promptMessage="<%=paramRequest.getLocaleString("promptMsgPhoneExtDr")%>" invalidMessage="<%=paramRequest.getLocaleString("promptMsgFaultPhoneExtDr")%>" regExp="\d{1,6}" trim="true" />
          </p-->
          
          
          <div class="clearer">&nbsp;</div>
         </div>

         <!-- // temas de interes -->
         <div class="de_interes divisor">
          <h3><%=paramRequest.getLocaleString("titleITopics")%></h3>
          <em>Te ofrecemos contenidos acordes con tus temas de inter&eacute;s</em>
<%
        Iterator<TemaInteres> tis = TemaInteres.ClassMgr.listTemaIntereses();
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
          <input type="reset" value="<%=paramRequest.getLocaleString("lblReset")%>" />
          <input type="submit" value="<%=paramRequest.getLocaleString("lblSave")%>" onclick="return enviar(this.form.id)" />
         </div>
        </div>
        </form>
        <script type="text/javascript">
        <!--
          dojo.addOnLoad(function(){
              collapse('acercade_mi');
<%
        if(request.getParameter("ads")!=null) {
            out.println("dijit.byId('chief').query.dir='"+request.getParameter("ads")+"';");
        }else if(adscription!=null) {
            out.println("dijit.byId('chief').query.dir='"+adscription.getId()+"';");
        }else {
            out.println("dijit.byId('chief').query.dir='null';");
        }

        if(request.getParameter("alertmsg")!=null) {
            out.println("alert('"+request.getParameter("alertmsg")+"');");
        }
%>       
          });
        -->
        </script>
<%
    }else {
%>
        <p>usuario distinto al dueño del perfil</p>
<%
    }
%>