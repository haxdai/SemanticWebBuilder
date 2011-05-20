<%@page import="org.semanticwb.portal.api.*" %>
<%@page import="org.semanticwb.model.*" %>
<%@page import="org.semanticwb.SWBPortal" %>
<%@page import="org.semanticwb.SWBPlatform" %>
<%@page import="org.semanticwb.platform.*" %>
<%@page import="java.util.HashMap" %>
<%@page import="java.util.Iterator" %>
<%@page import="org.semanticwb.platform.SemanticProperty" %>
<%@page import="org.semanticwb.portal.SWBFormMgr" %>
<%@page import="org.semanticwb.tankwar.*" %>
<%

        SWBParamRequest paramRequest = (SWBParamRequest) request.getAttribute("paramRequest");
        String msg = request.getParameter("msg");
        String login="";
        String pwd="";
        String firstName="";
        String lastName="";
        String secondLastName="";
        String email="";
        if(request.getParameter("login")!=null) login=request.getParameter("login");
        if(request.getParameter("pwd")!=null) pwd=request.getParameter("pwd");
        if(request.getParameter("firstName")!=null) firstName=request.getParameter("firstName");
        if(request.getParameter("lastName")!=null) lastName=request.getParameter("lastName");
        if(request.getParameter("secondLastName")!=null) secondLastName=request.getParameter("secondLastName");
        if(request.getParameter("email")!=null) email=request.getParameter("email");

        User user = paramRequest.getUser();
        WebPage wpage=paramRequest.getWebPage();
        SWBResourceURL url = paramRequest.getActionUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setAction("create").setMode(SWBResourceURL.Mode_EDIT);
        String repository = wpage.getWebSite().getUserRepository().getId();
%>
     <script type="text/javascript">
       dojo.require("dojo.parser");
       dojo.require("dijit.layout.ContentPane");
       dojo.require("dijit.form.Form");
       dojo.require("dijit.form.ValidationTextBox");
       dojo.require("dijit.form.Button");
       dojo.require("dijit.form.FilteringSelect");
       dojo.require("dijit.Tooltip");
    </script>


    <div id="general_forms" class="formularios">
    <form id="org.semanticwb.community.User/com/create" dojoType="dijit.form.Form" class="swbform" action="<%=url%>" method="POST">
    <fieldset><legend>Registro de Nuevo Usuario</legend>
        <h2>
            Para crear tu tanque y competir es necesario que seas un usuario registrado, para ello por favor completa el siguiente formato.<br>
        </h2>
    <ul
    <li>
        <label for="login" class="etiqueta">Usuario <em>*</em></label><!-- -->
        <input type="text" name="login" dojoType="dijit.form.ValidationTextBox" value="<%=login%>"
               id="login" required="true"
               promptMessage="Captura m&iacute;nimo 6 caracteres, sin espacios y sin caracteres especiales ni acentos. Puede contener puntos (.), gui&oacute;n medio (-), gui&oacute;n bajo (_). El sistema distingue entre may&uacute;sculas y min&uacute;sculas."
               invalidMessage="El identificador de usuario es invalido <br> o ya existe, por lo menos debe tener 6 caracteres."
               isValid="return canAddLogin('<%=repository%>',this.textbox.value);" trim="true" />
        <img src="<%=SWBPortal.getWebWorkPath()%>/models/<%=wpage.getWebSiteId()%>/css/images/ico_duda.png" id="ttusr" alt="Ayuda" />
        <span dojoType="dijit.Tooltip" connectId="ttusr" position="below" id="usrtooltip">
            Es importante que recuerdes tu usuario ya que te servir&aacute; para que inicies sesi&oacute;n cada vez que necesites editar tu informaci&oacute;n.
        </span>
    </li>
    <li>
        <label for="pwd" class="etiqueta">Contrase&ntilde;a <em>*</em></label>
        <input type="password" name="passwd" dojoType="dijit.form.ValidationTextBox" value="<%=pwd%>"
               id="pwd" required="true"
               promptMessage="Captura m&iacute;nimo 6 caracteres, sin espacios y sin caracteres especiales ni acentos. Puede contener puntos (.), gui&oacute;n medio (-), gui&oacute;n bajo (_). El sistema distingue entre may&uacute;sculas y min&uacute;sculas."
               invalidMessage="La contrase&ntilde;a de usuario es requerida." trim="true" />
        <img src="<%=SWBPortal.getWebWorkPath()%>/models/<%=wpage.getWebSiteId()%>/css/images/ico_duda.png" id="ttpwd" alt="Ayuda" />
        <span dojoType="dijit.Tooltip" connectId="ttpwd" position="below" id="pwdtooltip">
            Recuerda tu contrase&ntilde;a la necesitar&aacute;s como complemento del usuario, para poder iniciar una sesi&oacute;n.
        </span>
    </li>
    <li>
        <label for="pwdConf" class="etiqueta">Confirma tu contrase&ntilde;a <em>*</em></label>
        <input type="password" name="passwdc" dojoType="dijit.form.ValidationTextBox" value="<%=pwd%>"
               id="pwdConf" required="true"
               promptMessage="Vuelve a escribir tu contrase&ntilde;a, tal y como la capturaste en el campo anterior.."
               invalidMessage="La confirmación de contrase&ntilde;a de usuario es requerida." trim="true" />
        <!--img src="<%=SWBPortal.getWebWorkPath()%>/models/<%=wpage.getWebSiteId()%>/css/images/ico_duda.png" id="ttpwdc" alt="Ayuda" />
        <span dojoType="dijit.Tooltip" connectId="ttpwdc" position="below" id="pwdctooltip"
             style="width: 200px; text-align: justify; cursor: pointer">
            Escribe
        </span-->
    </li>
    <li>
        <label for="usrFirstName" class="etiqueta">Nombre(s) <em>*</em></label>
        <input name="firstName" value="<%=firstName%>" dojoType="dijit.form.ValidationTextBox"
               id="usrFirstName" required="true"
               promptMessage="Escribe tu(s) nombre(s) sin apellidos"
               invalidMessage="El nombre es requerido" style="width:300px;"  trim="true"/>
    </li>
    <li>
        <label for="usrLastName" class="etiqueta">Apellido Paterno <em>*</em></label>
        <input name="lastName" value="<%=lastName%>" dojoType="dijit.form.ValidationTextBox"
               id="usrLastName" required="true"
               promptMessage="Escribe s&oacute;lo tu apellido paterno"
               invalidMessage="El apellido paterno es requerido" style="width:300px;"  trim="true"/>
    </li>
    <li>
        <label for="usrSecondLastName" class="etiqueta">Apellido Materno &nbsp;</label>
        <input name="secondLastName" value="<%=secondLastName%>"
               id="usrSecondLastName" dojoType="dijit.form.ValidationTextBox" required="false"
               promptMessage="Escribe s&oacute;lo tu apellido materno"
               invalidMessage="Dato Invalido" style="width:300px;"  trim="true"/>
    </li>
    <li>
        <label for="usrSex" class="etiqueta">Sexo &nbsp;</label>
               <input type="radio" id="sexoF" name="tankUserSex" value="female"> <label for="sexoF">Femenino</label>
               <input type="radio" id="sexoM" name="tankUserSex" value="male"> <label for="sexoM">Masculino</label>
    </li>
    <li>
        <label for="usrEmail" class="etiqueta">Correo Electr&oacute;nico<em>*</em></label> <!-- promptMessage="Captura Correo Electr&oacute;nico" -->
        <input name="email" dojoType="dijit.form.ValidationTextBox" required="true"
               id="usrEmail"
               invalidMessage="La cuenta de correo electr&oacute;nico es invalida o ya existe en el sistema."
               isValid="return canAddEmail('<%=repository%>',this.textbox.value);"
               style="width:300px;"  value="<%=email%>" trim="true"/>
        <img src="<%=SWBPortal.getWebWorkPath()%>/models/<%=wpage.getWebSiteId()%>/css/images/ico_duda.png" id="ttemail" alt="Ayuda" />
        <span dojoType="dijit.Tooltip" connectId="ttemail" position="below" id="emailtooltip">
            Escribe un correo electrónico a donde te podamos contactar si es necesario, o enviar tu usuario y contraseña en caso de que los olvides.
        </span>
    </li>
   </ul>
    <%
    HashMap mapa = new HashMap();
    Iterator<SemanticProperty> list = org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/tankwar#TankWarExtendedAttributes").listProperties();
    while(list.hasNext()){
        SemanticProperty sp = list.next();
        mapa.put(sp.getName(),sp);
    }

    SWBFormMgr frm = new SWBFormMgr(user.getSemanticObject(), null, SWBFormMgr.MODE_CREATE);
    frm.setLang(user.getLanguage());
    frm.setType(SWBFormMgr.TYPE_DOJO);
    %>
    <ul>
    <li>
        <label class="etiqueta">Gustos <em>*</em></label>
        <%
        int npair = 1;
        Iterator<UserLike> gustos = UserLike.ClassMgr.listUserLikes(wpage.getWebSite());
        while (gustos.hasNext()) {
            UserLike gusto = gustos.next();
            %>
            <input type="checkbox" id="usrLike_<%=gusto.getTitle()%>" name="userLikes" value="<%=gusto.getTitle()%>"><label for="usrLike_<%=gusto.getTitle()%>"><%=gusto.getTitle()%></label>
            <%
            if (npair%2 == 0) {
            %><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%
            npair = 0;
            }
            npair++;
        }
        %>
    </li>
    <li>
    <div class="captcha">
        <img src="/swbadmin/jsp/securecode.jsp?sAttr=cdlog" id="imgseccode" width="155" height="65" />
        <a href="#" onclick="changeSecureCodeImage('imgseccode');">Cambiar imagen</a>
    </div>
        <label for="cmnt_seccode" class="etiqueta">El texto de la imagen es <em>*</em></label> <!-- promptMessage="Captura el texto de la imagen anterior" -->
        <input type="text" id="cmnt_seccode" name="cmnt_seccode" required="true"
               dojoType="dijit.form.ValidationTextBox" size="45" style="width:300px;"/>
               <%if (msg != null && msg.equals("regfail")) {%><font color="RED"><b>*</b></font><%}%>
        <img src="<%=SWBPortal.getWebWorkPath()%>/models/<%=wpage.getWebSiteId()%>/css/images/ico_duda.png" id="ttsecimg" alt="Ayuda" />
        <span dojoType="dijit.Tooltip" connectId="ttsecimg" position="below" id="secimgtooltip">
            Escribe los caracteres que aparecen en la imagen de arriba, si no te es clara, haz clic en &quot;Cambiar imagen&quot;
        </span>
    </li>
    <li>
    <div class="botones_forms">
        <!--a href="javascript:enviar()" class="boton_gde">Guardar</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:history.back();" class="boton_gde">Cancelar</a-->
        <input type="button" onClick="enviar()" value="Guardar">&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" onClick="history.back();" value="Cancelar"/>
    </div>
    </li>
  </ul>
    <script type="text/javascript">

         function enviar(){
            var x=document.getElementById('org.semanticwb.community.User/com/create');
            var objd=dijit.byId('org.semanticwb.community.User/com/create');
            var contra = dijit.byId("pwd");
            var confirma = dijit.byId("pwdConf");
            var contraConfirmada = false;

            if (!isEmpty("pwd") && !isEmpty("pwdConf") && contra.value == confirma.value) {
                contraConfirmada = true;
            }
            if (objd.isValid()) {
                if (!contraConfirmada) {
                    alert("La contraseña y su confirmación no son iguales, por favor captúralas de nuevo");
                } else if (isEmpty('cmnt_seccode')) {
                    alert('Para poder registrar tu usuario es necesario que ingreses el código de la imagen.\\nEn caso de que no sea claro, puedes cambiarlo haciendo clic en "Cambiar imagen".');
                } else {
                    x.submit();
                }
            } else {
                alert("Datos incompletos o erróneos, asegúrate de proporcionar los datos marcados con asterisco");
            }
         }

           function changeSecureCodeImage(imgid) {
             var img = dojo.byId(imgid);
             if (img) {
                var rn = Math.floor(Math.random() * 99999);
                img.src = "/swbadmin/jsp/securecode.jsp?sAttr=cdlog&nc=" + rn;
             }
           }

            function isEmpty(objid) {
                var obj = dojo.byId(objid);
                if (obj==null || obj.value=='' || !isNaN(obj.value) || obj.value.charAt(0) == ' ') {
                    return true;
                }else {
                    return false;
                }
            }


        </script>
	</fieldset>
</form>
</div>

<div id="recupera_pass_bottom"></div>
