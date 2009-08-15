/**
* SemanticWebBuilder es una plataforma para el desarrollo de portales y aplicaciones de integración,
* colaboración y conocimiento, que gracias al uso de tecnología semántica puede generar contextos de
* información alrededor de algún tema de interés o bien integrar información y aplicaciones de diferentes
* fuentes, donde a la información se le asigna un significado, de forma que pueda ser interpretada y
* procesada por personas y/o sistemas, es una creación original del Fondo de Información y Documentación
* para la Industria INFOTEC, cuyo registro se encuentra actualmente en trámite.
*
* INFOTEC pone a su disposición la herramienta SemanticWebBuilder a través de su licenciamiento abierto al público (‘open source’),
* en virtud del cual, usted podrá usarlo en las mismas condiciones con que INFOTEC lo ha diseñado y puesto a su disposición;
* aprender de él; distribuirlo a terceros; acceder a su código fuente y modificarlo, y combinarlo o enlazarlo con otro software,
* todo ello de conformidad con los términos y condiciones de la LICENCIA ABIERTA AL PÚBLICO que otorga INFOTEC para la utilización
* del SemanticWebBuilder 4.0.
*
* INFOTEC no otorga garantía sobre SemanticWebBuilder, de ninguna especie y naturaleza, ni implícita ni explícita,
* siendo usted completamente responsable de la utilización que le dé y asumiendo la totalidad de los riesgos que puedan derivar
* de la misma.
*
* Si usted tiene cualquier duda o comentario sobre SemanticWebBuilder, INFOTEC pone a su disposición la siguiente
* dirección electrónica:
*  http://www.semanticwebbuilder.org
**/
import org.semanticwb.model.User
import org.semanticwb.model.WebPage
import org.semanticwb.portal.api.SWBResourceURL

def paramRequest=request.getAttribute("paramRequest")
User user = paramRequest.getUser()
WebPage wpage=paramRequest.getWebPage()

def uri = ""
try {uri = user.getEncodedURI()} catch (Exception e) {}
def acc_url = paramRequest.getActionUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setAction("edit")
def url_chk = paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setMode(SWBResourceURL.Mode_HELP)
def url_actPic = paramRequest.getActionUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setAction("upload")
def id = user.getId()
def usr_name = (user.getFirstName()==null?"":user.getFirstName())
def usr_lname = (user.getLastName()==null?"":user.getLastName())
def usr_sname = (user.getSecondLastName()==null?"":user.getSecondLastName())
def usr_mail = (user.getEmail()==null?"":user.getEmail())
def usr_login = user.getLogin()

//onsubmit="submitForm('http://www.semanticwb.org/uradm#swb_User:$id/form');return false;"

println """
<script language="javascript" type="text/javascript" src="/swbadmin/js/upload.js"></script>

	<style type="text/css">
 @import "/swbadmin/css/upload.css";
 </style>
    <script type="text/javascript">
    var uploads_in_progress = 0;

    function beginAsyncUpload(ul,sid) {
      ul.form.submit();
    	uploads_in_progress = uploads_in_progress + 1;
    	var pb = document.getElementById(ul.name + "_progress");
    	pb.parentNode.style.display='block';
    	new ProgressTracker(sid,{
    		progressBar: pb,
    		onComplete: function() {
    			var inp_id = pb.id.replace("_progress","");
    			uploads_in_progress = uploads_in_progress - 1;
    			var inp = document.getElementById(inp_id);
    			if(inp) {
    				inp.value = sid;
    			}
    			pb.parentNode.style.display='none';
    		},
    		onFailure: function(msg) {
    			pb.parentNode.style.display='none';
    			alert(msg);
    			uploads_in_progress = uploads_in_progress - 1;
    		},
            url: '$url_chk'
    	});
    }

	</script>
<script type="text/javascript">
           dojo.require("dojo.parser");
                   dojo.require("dijit.form.Form");
                   dojo.require("dojox.layout.ContentPane");
                   dojo.require("dijit.form.ValidationTextBox");
                   dojo.require("dijit.form.Button");
                   dojo.require("dijit.Dialog");
        </script>
<form id="http://www.semanticwb.org/uradm#swb_User:$id/form" dojoType="dijit.form.Form" class="swbform"
action="$acc_url"   method="post">
    <input type="hidden" name="suri" value="$uri"/>
    <input type="hidden" name="scls" value="http://www.semanticwebbuilder.org/swb4/ontology#User"/>
    <input type="hidden" name="smode" value="edit"/>
	<fieldset>
	    <legend>Datos Personales</legend>
	    <table>
                <tr><td width="200px" align="right">Identificador &nbsp;</td>
                <td>$usr_login</td></tr>
                <tr><td width="200px" align="right"><label for="usrFirstName">Nombre(s) &nbsp;</label></td>
                <td><input _id="usrFirstName" name="usrFirstName" value="$usr_name" dojoType="dijit.form.ValidationTextBox"
                required="false" promptMessage="Captura Nombre(s)" invalidMessage="Dato Invalido" style="width:300px;"  trim="true"/></td></tr>
                <tr><td width="200px" align="right"><label for="usrLastName">Primer Apellido &nbsp;</label></td>
                <td><input _id="usrLastName" name="usrLastName" value="$usr_lname" dojoType="dijit.form.ValidationTextBox" required="false" promptMessage="Captura Primer Apellido" invalidMessage="Dato Invalido" style="width:300px;"  trim="true"/></td></tr>
                <tr><td width="200px" align="right"><label for="usrSecondLastName">Segundo Apellido &nbsp;</label></td>
                <td><input _id="usrSecondLastName" name="usrSecondLastName" value="$usr_sname" dojoType="dijit.form.ValidationTextBox" required="false" promptMessage="Captura Segundo Apellido" invalidMessage="Dato Invalido" style="width:300px;"  trim="true"/></td></tr>
                <tr><td width="200px" align="right"><label for="usrEmail">Correo Electr&oacute;nico &nbsp;</label></td>
                <td><input _id="usrEmail" name="usrEmail" value="$usr_mail" dojoType="dijit.form.ValidationTextBox"
                required="false" promptMessage="Captura Correo Electr&oacute;nico" invalidMessage="Dato Invalido" style="width:300px;"  trim="true"/></td></tr>
                </table></fieldset>
<fieldset><span align="center">
    <button dojoType="dijit.form.Button" type="submit">Guardar</button>
</span></fieldset>
</form>
<fieldset>
	    <legend>Fotograf&iacute;a</legend>
	    <table>
            <tr><td width="200px" align="right"><label for="picture">Fotograf&iacute;a &nbsp;</label></td>
                    <td><iframe id="pictureTransferFrame" name="pictureTransferFrame" src="" style="display:none" ></iframe>
                        <form id="fupload" name="fupload" enctype="multipart/form-data"
                        action="$url_actPic"
                        method="post" target="pictureTransferFrame" >
                        <input type="file" name="picture"
                        onchange="beginAsyncUpload(this,'picture');" />
                        <div class="progresscontainer" style="display: none;"><div class="progressbar" id="picture_progress"></div></div>
                        </form>
                    </td></tr>
	    </table>
	</fieldset>
"""
