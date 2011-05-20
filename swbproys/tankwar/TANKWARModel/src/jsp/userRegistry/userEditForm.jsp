<%@page import="org.semanticwb.model.User" %>
<%@page import="org.semanticwb.model.WebPage" %>
<%@page import="org.semanticwb.SWBPlatform" %>
<%@page import="org.semanticwb.portal.api.SWBResourceURL" %>
<%@page import="org.semanticwb.portal.api.SWBParamRequest" %>
<%@page import="org.semanticwb.SWBPortal" %>
<%@page import="org.semanticwb.model.DisplayProperty" %>
<%@page import="org.semanticwb.platform.SemanticProperty" %>
<%@page import="org.semanticwb.platform.SemanticObject" %>
<%@page import="org.semanticwb.portal.SWBFormMgr" %>
<%@page import="java.util.*" %>
<%@page import="org.semanticwb.tankwar.*" %>
<!--script language="javascript" type="text/javascript" src="/swbadmin/js/upload.js"></script-->
<!--style type="text/css">
 @import "/swbadmin/css/upload.css";
</style-->
<%
SWBParamRequest paramRequest = (SWBParamRequest) request.getAttribute("paramRequest");
User user = paramRequest.getUser();
WebPage wpage = paramRequest.getWebPage();
SWBResourceURL acc_url = paramRequest.getActionUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setAction("edit");
String usr_login = user.getLogin();
String id = user.getId();

HashMap<String, SemanticProperty> mapa = new HashMap<String, SemanticProperty>();
Iterator<SemanticProperty> list = org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/tankwar#TankWarExtendedAttributes").listProperties();
while (list.hasNext()) {
    SemanticProperty sp = list.next();    
    mapa.put(sp.getName(),sp);
}

SWBFormMgr frm = new SWBFormMgr(user.getSemanticObject(), null, SWBFormMgr.MODE_EDIT);
frm.setLang(user.getLanguage());
frm.setType(SWBFormMgr.TYPE_DOJO);
String sexo = null;
String likes = null;
try {
    sexo = user.getExtendedAttribute(mapa.get("tankUserSex")).toString();
    likes = user.getExtendedAttribute(mapa.get("userLikes")).toString();
} catch (Exception e) {
    e.printStackTrace();
}
%>

<script type="text/javascript">
    dojo.require("dojo.parser");
    dojo.require("dijit.form.Form");
    dojo.require("dojox.layout.ContentPane");
    dojo.require("dijit.form.ValidationTextBox");
    dojo.require("dijit.form.Button");
    dojo.require("dijit.Dialog");
    dojo.require("dijit.form.FilteringSelect");
    dojo.require("dijit.form.Textarea");
    dojo.require("dijit.Tooltip");

     function enviar(){
        var x=document.getElementById("form_<%=id%>");
        var objd=dijit.byId("form_<%=id%>");
        if (objd.isValid())
        {
            x.submit();
        } else {
            alert("Datos incompletos o erróneos, asegúrate de proporcionar los datos marcados con asterisco");
        }

     }
 </script>

<div id="general_forms" class="formularios">
    <form id="form_<%=id%>" dojoType="dijit.form.Form" class="swbform" action="<%=acc_url%>" method="post">
    <input type="hidden" name="suri" value="$uri"/>
    <input type="hidden" name="scls" value="http://www.semanticwebbuilder.org/swb4/ontology#User"/>
    <input type="hidden" name="smode" value="edit"/>
    <fieldset>
    <legend>Datos del Usuario</legend>
        <h2>Usuario: &nbsp; <%=usr_login%></h2>
        <ul>
            <li>
            <label for="usrFirstName" class="etiqueta">Nombre(s) <em>*</em></label>
            <%=frm.renderElement(request, User.swb_usrFirstName, SWBFormMgr.MODE_EDIT)%>
            </li>
        <li>
            <label for="usrLastName" class="etiqueta">Apellido Paterno <em>*</em></label>
            <%=frm.renderElement(request, User.swb_usrLastName, SWBFormMgr.MODE_EDIT)%>
        </li>
        <li>
            <label for="usrSecondLastName" class="etiqueta">Apellido Materno &nbsp;</label>
                <%=frm.renderElement(request, User.swb_usrSecondLastName, SWBFormMgr.MODE_EDIT)%>
        </li>
        <li>
            <label for="tankUserSex" class="etiqueta">Sexo &nbsp;</label>
            <input type="radio" id="sexoF" name="tankUserSex" value="female"<%=sexo != null && sexo.equalsIgnoreCase("female") ? " checked" : ""%>> <label for="sexoF">Femenino</label>
            <input type="radio" id="sexoM" name="tankUserSex" value="male"<%=sexo != null && sexo.equalsIgnoreCase("male") ? " checked" : ""%>> <label for="sexoM">Masculino</label>
        </li>
        <li>
            <label for="usrEmail" class="etiqueta">Correo Electrónico <em>*</em></label>
            <%=frm.renderElement(request, User.swb_usrEmail, SWBFormMgr.MODE_EDIT)%>
        </li>
        </ul>
    </fieldset>
    <!--fieldset>
        <legend>Informaci&oacute;n complementaria</legend>
    </fieldset-->
    <fieldset>
        <legend>Informaci&oacute;n complementaria</legend>
        <ul>
            <li>
            <label class="etiqueta">Gustos <em>*</em></label>
            <%
            int npair = 1;
            Iterator<UserLike> gustos = UserLike.ClassMgr.listUserLikes(wpage.getWebSite());
            while (gustos.hasNext()) {
                UserLike gusto = gustos.next();
                %>
                <input type="checkbox" <%=(likes != null && likes.contains(gusto.getTitle()))?"checked=\"checked\"":""%> id="usrLike_<%=gusto.getTitle()%>" name="userLikes" value="<%=gusto.getTitle()%>"><label for="usrLike_<%=gusto.getTitle()%>"><%=gusto.getTitle()%></label>
                <%
                if (npair%2 == 0) {
                %><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%
                npair = 0;
                }
                npair++;
            }
            %>
            </li>
        </ul>
    </fieldset>
    <ul>
      <li>
         <label class="etiqueta"></label>
      <input type="button" onClick="enviar()" class="boton_gde" value="Guardar">&nbsp;&nbsp;&nbsp;&nbsp;
      <input type="button" onClick="history.back();" class="boton_gde" value="Cancelar"/>
    </li>
    </ul>
    </form>
    <!--Forma para envío de foto del usuario-->
    <%
        SWBResourceURL url_actPic = paramRequest.getActionUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setAction("upload");
        SWBResourceURL url_chk = paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setMode(SWBResourceURL.Mode_HELP);
    %>
        <script type="text/javascript">
        var uploads_in_progress = 0;

        function beginAsyncUpload(ul,sid) {
            ul.form.submit();
            uploads_in_progress = uploads_in_progress + 1;
            var pb = document.getElementById(ul.name + "_progress");
            pb.parentNode.style.display='block';
        }
    </script>

<p align="left">
    <form id="fupload" name="fupload" enctype="multipart/form-data" class="swbform" dojoType="dijit.form.Form"
    action="<%=url_actPic%>" method="post" target="pictureTransferFrame" >
    <fieldset>
    <legend>Fotograf&iacute;a</legend>
        <ul>
            <li>
                <label for="picture">Fotograf&iacute;a &nbsp;</label>
                <iframe id="pictureTransferFrame" name="pictureTransferFrame" src="" style="display:none" ></iframe>
                <input type="file" name="picture" onchange="beginAsyncUpload(this,'picture');" />
                <div class="progresscontainer" style="display: none;">
                    <div class="progressbar" id="picture_progress"></div>
                </div>
            </li>
	</ul>
    </fieldset>
    </form>
</p>
</div>
<div id="recupera_pass_bottom"></div>
