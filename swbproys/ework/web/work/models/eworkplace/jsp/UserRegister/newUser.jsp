<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@page import="org.semanticwb.SWBPortal
        ,org.semanticwb.model.User
        ,org.semanticwb.model.WebPage
        ,org.semanticwb.SWBPlatform
        ,org.semanticwb.portal.api.SWBResourceURL" %>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest"/>
<%
    String context = SWBPortal.getContextPath();
    String firstName = "";
    if (request.getParameter("firstName") != null) {
        firstName = request.getParameter("firstName");
    }
    String lastName = "";
    if (request.getParameter("lastName") != null) {
        lastName = request.getParameter("lastName");
    }
    String secondLastName = "";
    if (request.getParameter("secondLastName") != null) {
        secondLastName = request.getParameter("secondLastName");
    }
    String email = "";
    if (request.getParameter("email") != null) {
        email = request.getParameter("email");
    }
    String birthday = "";
    if (request.getParameter("birthday") != null) {
        birthday = request.getParameter("birthday");
    }

    User user = paramRequest.getUser();
    WebPage wpage = paramRequest.getWebPage();
    String contextPath = SWBPlatform.getContextPath();
    String url = paramRequest.getActionUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setAction(paramRequest.Action_ADD).toString();
    String repositoryId = wpage.getWebSite().getUserRepository().getId();     
%>
<script type="text/javascript">
    <!--
    dojo.require("dijit.layout.ContentPane");
    dojo.require("dijit.form.Form");
    dojo.require("dijit.form.ValidationTextBox");
    dojo.require("dijit.form.Button");
    dojo.require("dijit.form.CheckBox");
    dojo.require("dijit.form.SimpleTextarea");
    
    function enviar() {
        var objd=dijit.byId('form1ru');

        if(objd.validate())
        {
            if(isEmpty('cmnt_seccode')) {
                alert('Para registrarte es necesario que escribas el texto de la imagen.\\nEn caso de no ser claro puedes cambiarlo haciendo clic en <<Cambiar imagen>>.');
            }else{
                if (!validateReadAgree()){
                    alert('Para registrarte es necesario que aceptar los términos y condiciones');
                }else{
                   return true;
                    //alert("enviar");
                }
            }
        }else {
            alert("Datos incompletos");
        }
        return false;
    }
    function validateReadAgree(){
        var ret=false;
        ret=dijit.byId("acept").checked;
        //alert(ret);
        return ret;
    }
    function changeSecureCodeImage(imgid) {
        var img = dojo.byId(imgid);
        if(img) {
            var rn = Math.floor(Math.random()*99999);
            img.src = "<%=context%>/swbadmin/jsp/securecode.jsp?sAttr=cdlog&nc="+rn;
        }
    }

   /* function isValidThisEmail() {
        var valid = false;
        var email = dijit.byId("email");
        if( isValidEmail(email.getValue()) && canAddEmail('<%//=repositoryId%>',email.getValue()) ) {
            valid = true;
        }
        else {
            email.displayMessage( "<%//=paramRequest.getLocaleString("lblEmailFault")%>" );
        }
        return valid;
    }*/
    function isValidThisEmail(){
        var valid=false;
        var email = dijit.byId( "email2" );
        var strEmail = email.getValue();
        if(strEmail!=""){
            //alert(strEmail);
            if(isValidEmail(strEmail)){
                if(canAddEmail('<%=repositoryId%>',strEmail)){
                    valid=true;
                }else{
                    email.displayMessage( "<%=paramRequest.getLocaleString("lblEmailDupl")%>" );
                }
            }else{
                email.displayMessage( "<%=paramRequest.getLocaleString("lblEmailFault")%>" );
            }
        }
        return valid;
    }
    function isValidLogin(){
        var valid=false;
        var login = dijit.byId( "login" );
        var filter = /^[a-zA-Z0-9.@]+$/;
        var strLogin = login.getValue();
        if(strLogin!=""){
            if(filter.test(strLogin)){
                if(canAddLogin('<%=repositoryId%>',strLogin)){
                    valid=true;
                }else{
                    login.displayMessage( "<%=paramRequest.getLocaleString("lblLoginDupl")%>" );
                }
            }else{
                login.displayMessage( "<%=paramRequest.getLocaleString("lblLoginFault")%>" );
            }
        }
        return valid;
    }

    function isValidPass() {
        var valid = false;
        var passwd = dijit.byId("passwd").getValue();
        var login = dijit.byId( "login" ).getValue();
        if(!isEmpty(passwd) && passwd!=login){
            valid = true;
        }
        return valid;
    }
    function isSamePass() {
        var valid = false;
        var passwd = dijit.byId("passwd").getValue();
        var cpasswd = dijit.byId( "cpasswd" ).getValue();
//console.log('ps1='+passwd+', ps2='+cpasswd+', e1='+isEmpty(passwd)+', e2='+isEmpty(cpasswd));
        if(!isEmpty(passwd) && !isEmpty(cpasswd) && passwd==cpasswd){
            valid = true;
        }
        return valid;
    }
    function isValidDate() {
        var valid=false;
        if(dijit.byId("birthday")!=null && !isEmpty(dijit.byId( "birthday" ).getValue())) {
            var birth = dijit.byId( "birthday" ).getValue().split("/");
            var dayField = birth[0]
            var monthField = birth[1]
            var yearField = birth[2]
            /*if(isInteger(dayField) && isInteger(monthField) && isInteger(yearField)) {
                if(!isNaN(Date.UTC(yearField, monthField-1, dayField)))
                    valid = true;
            }*/
            var dayobj = new Date(yearField, monthField-1, dayField);
            var today = new Date();
            if ((dayobj.getMonth()+1==monthField)&&
                (dayobj.getDate()==dayField)&&
                (dayobj.getFullYear()==yearField)&&
                (dayobj.getFullYear()>1900)&&
                (dayobj<today)){
                valid=true;
            }
        }
        return valid;
    }
    -->
</script>
<div id="icv">
    <div id="icv-data">
        <form id="form1ru" dojoType="dijit.form.Form" class="swbform" action="<%=url%>" method="post">
            <div class="icv-div-grupo">
                <p class="icv-3col">
                    <label for="firstName"><b>*</b><%=paramRequest.getLocaleString("lblFirstName")%></label>
                    <input type="text" name="firstName" id="firstName" dojoType="dijit.form.ValidationTextBox" value="<%=firstName%>"  required="true" promptMessage="<%=paramRequest.getLocaleString("promptMsgFirstName")%>" invalidMessage="<%=paramRequest.getLocaleString("lblFirstNameFault")%>" trim="true" regExp="[a-zA-Z\u00C0-\u00FF' ]+"/>
                </p>
                <p class="icv-3col">
                    <label for="lastName"><b>*</b><%=paramRequest.getLocaleString("lblLastName")%></label>
                    <input type="text" name="lastName" id="lastName" dojoType="dijit.form.ValidationTextBox" value="<%=lastName%>" required="true" promptMessage="<%=paramRequest.getLocaleString("promptMsgLastName")%>" invalidMessage="<%=paramRequest.getLocaleString("lblLastNameFault")%>" trim="true" regExp="[a-zA-Z\u00C0-\u00FF' ]+" />
                </p>
                <p class="icv-3col">
                    <label for="secondLastName"><%=paramRequest.getLocaleString("lblSecondLastName")%></label>
                    <input type="text" name="secondLastName" id="secondLastName" dojoType="dijit.form.ValidationTextBox" value="<%=secondLastName%>" required="false" promptMessage="<%=paramRequest.getLocaleString("promptMsgSecondLastName")%>" trim="true" regExp="[a-zA-Z\u00C0-\u00FF' ]+"/>
                </p>
                <div class="clearer">&nbsp;</div>
            </div>
            <div class="icv-div-grupo">
                <p class="icv-3col">
                    <label for="email"><b>*</b><%=paramRequest.getLocaleString("lblEmail")%></label>
                    <input type="text" name="email" id="email2" dojoType="dijit.form.ValidationTextBox" value="<%=email%>" maxlength="60" required="true" promptMessage="<%=paramRequest.getLocaleString("promptMsgEmail")%>" invalidMessage="<%=paramRequest.getLocaleString("lblEmailFault")%>" isValid="return isValidThisEmail()" trim="true"/>
                </p>
                <p class="icv-3col">
                    <label for="birthday"><b>*</b><%=paramRequest.getLocaleString("lblBirthday")%>(dd/mm/aaaa)</label>
                    <input type="text" name="birthday" id="birthday" dojoType="dijit.form.ValidationTextBox" value="<%=birthday%>" maxlength="14" required="true" promptMessage="<%=paramRequest.getLocaleString("promptMsgBirthday")%>" invalidMessage="<%=paramRequest.getLocaleString("lblBirthdayFault")%>" regExp="(0[1-9]|[12][0-9]|3[01])[/](0[1-9]|1[012])[/](19|20)\d\d" isValid="return isValidDate()" trim="true"/>
                </p>
                <div class="clearer">&nbsp;</div>
            </div>
            <div class="icv-div-grupo">
                <p class="icv-3col">
                    <label for="login"><b>*</b><%=paramRequest.getLocaleString("lblLogin")%></label>
                    <input type="text" name="login" id="login" dojoType="dijit.form.ValidationTextBox" value="" maxlength="18" required="true" promptMessage="<%=paramRequest.getLocaleString("promptMsgLogin")%>" invalidMessage="<%=paramRequest.getLocaleString("lblLoginFault")%>"  isValid="return isValidLogin()" trim="true" />
                </p>
                <p class="icv-3col">
                    <label for="passwd"><b>*</b><%=paramRequest.getLocaleString("lblPassword")%></label>
                    <input type="password" name="passwd" id="passwd" dojoType="dijit.form.ValidationTextBox" value="" maxlength="12" required="true" promptMessage="<%=paramRequest.getLocaleString("promptMsgPassword")%>" invalidMessage="<%=paramRequest.getLocaleString("lblPasswordFault")%>" isValid="return isValidPass();" trim="true" />
                </p>
                <p class="icv-3col">
                    <label for="cpasswd"><b>*</b><%=paramRequest.getLocaleString("lblPasswordConfirm")%></label>
                    <input type="password" name="cpasswd" id="cpasswd" dojoType="dijit.form.ValidationTextBox" value="" maxlength="12" required="true" promptMessage="<%=paramRequest.getLocaleString("promptMsgPasswordConfirm")%>" invalidMessage="<%=paramRequest.getLocaleString("lblPasswordConfirmFault")%>"  isValid="return isSamePass();" trim="true" />
                </p>
                <div class="clearer">&nbsp;</div>
            </div>
            <div class="icv-div-grupo">
                <p class="icv-3col">
                    <img src="<%=context%>/swbadmin/jsp/securecode.jsp?sAttr=cdlog" id="imgseccode" width="200" height="100" alt="" />
                    <br/><%=paramRequest.getLocaleString("lblTryRead")%>&nbsp;<a href="#" onclick="changeSecureCodeImage('imgseccode');"><%=paramRequest.getLocaleString("lblTryAnotherText")%></a>
                </p>    
                <p class="icv-3col">
                    <label for="cmnt_seccode"><b>*</b><%=paramRequest.getLocaleString("lblCaptcha")%>:</label>
                    <input type="text" name="cmnt_seccode" id="cmnt_seccode" maxlength="8" value="" dojoType="dijit.form.ValidationTextBox" required="true" promptMessage="<%=paramRequest.getLocaleString("promptMsgCaptcha")%>" invalidMessage="<%=paramRequest.getLocaleString("lblCaptchaFault")%>" trim="true"/>                    
                </p>
                
                <div class="clearer">&nbsp;</div>
            </div>
            <!--div class="icv-div-grupo">
                <p class="icv-3col">
                    <label for="tcText"><b>*</b>Terminos y condiciones:</label>
                    <textarea name="tcText" id="tcText" dojoType="dijit.form.SimpleTextarea" cols="80" rows="10">
                    </textarea>
                </p>
                <div class="clearer">&nbsp;</div>
            </div-->
            <div class="icv-div-grupo">
                <p class="icv-3col">
                    <a href="#" onclick="openSplash();return false;">Términos y condiciones</a>
                </p>
                <p class="icv-3col">
                    <label for="acept"><b>*</b>Acepto los términos y condiciones:</label>
                    <input type="checkbox" name="acept" id="acept" maxlength="8" value="true" dojoType="dijit.form.CheckBox" required="true" promptMessage="promp" invalidMessage="invalid" isValid="return confirm('this.checkbox.value==true')"/>
                </p>
                <div class="clearer">&nbsp;</div>
            </div>
            <div class="centro">
                <input type="reset" value="<%=paramRequest.getLocaleString("lblReset")%>"/>
                <input type="submit" onclick="return enviar()" value="<%=paramRequest.getLocaleString("lblSubmit")%>"/>
            </div>
        </form>
    </div>
</div>
<script type="text/javascript">

    function createCoverDiv() {
        var divId='cover01';
        var bgcolor='#101010';
        var opacity=80;
        var layer=document.createElement('div');
        layer.id=divId;
        layer.style.width='100%';
        layer.style.height='100%';
        layer.style.backgroundColor=bgcolor;
        layer.style.position='fixed';
        layer.style.top=0;
        layer.style.left=0;
        layer.style.zIndex=1000;
        layer.style.filter='alpha(opacity='+opacity+')';
        layer.style.opacity=opacity/100;
        document.body.appendChild(layer);
    }
    function removeCoverDiv(){//divId) {
        var divId='cover01';
        var layer=document.getElementById(divId);
        if(layer ){//&& superlayer) {
            document.body.removeChild(layer);
        }
    }
    function agreeSplash(){
        var ret=false;
        ret=dojo.byId("aceptSplash").checked;
        return ret;
    }
    function closeSplash() {
        dojo.byId("splash").style.display = "none";
        removeCoverDiv();
    }
    function openSplash() {
        createCoverDiv();
        dojo.byId("splash").style.display = "block";
    }
</script>
<div id="splash" class="icv-terminos" style="z-index: 1001; width: 50%; height:60%;  position:fixed; top: 20%; left:20%; background-color: #FFFFFF; display:none;">
    <div class="splash-titulo">
        <p>Terminos y condiciones</p>
    </div>
    <div class="splash-contenido" style="overflow: auto; height:80%">
        <%=paramRequest.getResourceBase().getAttribute("agreement")%>
    </div>
    <div class="splash-pie">
        <!--label for="aceptSplash"><b>*</b>Acepto los terminos y condiciones:</label>
        <input type="checkbox" name="aceptSplash" id="aceptSplash" value="true"/-->
        <a href="#" onclick="closeSplash();return false;">Cerrar</a>
    </div>
</div>