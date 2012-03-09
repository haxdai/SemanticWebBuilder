<%-- 
Document   : userData
Created on : 31/01/2012, 06:54:51 PM
Author     : rene.jara
--%><%@page import="com.infotec.cvi.swb.resources.UserPersonalData"%>
<%@page import="com.infotec.cvi.swb.EntidadFederativa"%>
<%@page import="com.infotec.cvi.swb.Municipio"%>
<%@page import="com.infotec.cvi.swb.Colonia"%>
<%@page import="com.infotec.cvi.swb.CP"%>
<%@page import="com.infotec.cvi.swb.Candidato"%>
<%@page import="com.infotec.eworkplace.swb.Telefono"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.semanticwb.model.WebSite"%>
<%@page import="org.semanticwb.model.Country"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.infotec.eworkplace.swb.*"%>
<%@page import="org.semanticwb.SWBPortal
        ,org.semanticwb.model.User
        ,org.semanticwb.model.WebPage
        ,org.semanticwb.SWBPlatform
        ,org.semanticwb.portal.api.SWBResourceURL" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest"/>
<%
            WebSite ws = paramRequest.getWebPage().getWebSite();
            User user = paramRequest.getUser();
            String repositoryId = ws.getUserRepository().getId();
            Persona persona = Persona.ClassMgr.getPersona(user.getId(), ws);
            Candidato candidato = Candidato.ClassMgr.getCandidato(user.getId(), ws);
            Domicilio domicilio;

            String curp = "";

            String firstName = "";
            String lastName = "";
            String secondLastName = "";

            String gender = "";
            String birthday = "";
            String state = "";

            String nationality = "";
            boolean fm2 = false;

            String addrStreet = "";
            String addrNumE = "";
            String addrNumI = "";
            String addrZip = "";
            String addrCol = "";
            String addrColLab = "";
            String addrMun = "";
            String addrMunLab = "";
            String addrState = "";
            String addrStateLab = "";
            String addrCountry = "";

            int sLabor = 0;
            int availability = 0;

            String email = "";
            String facebook = "";

            String skype = "";
            String msn = "";

            String linkedin = "";
            String twitter = "";

            if (user.getFirstName() != null) {
                firstName = user.getFirstName();
            }
            if (user.getLastName() != null) {
                lastName = user.getLastName();
            }
            if (user.getSecondLastName() != null) {
                secondLastName = user.getSecondLastName();
            }
            if (user.getEmail() != null) {
                email = user.getEmail();
            }
            if (persona != null) {
                if (persona.getCurp() != null) {
                    curp = persona.getCurp();
                }
                if (persona.isGenero() == true) {
                    gender = "f";
                } else {
                    gender = "m";
                }
                if (persona.getNacimiento() != null) {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    birthday = sdf.format(persona.getNacimiento());
                }
                if (persona.getEstadoNacimiento() != null) {
                    state = persona.getEstadoNacimiento().getId();
                }
                if (persona.getNacionalidad() != null) {
                    nationality = persona.getNacionalidad().getId();
                }
//if (persona.isFM2() != null) {
                fm2 = persona.isFM2();
//}
                if (persona.getDomicilio() != null) {
                    domicilio = persona.getDomicilio();
                    if (domicilio.getCalle() != null) {
                        addrStreet = domicilio.getCalle();
                    }
                    if (domicilio.getNumExterior() != null) {
                        addrNumE = domicilio.getNumExterior();
                    }
                    if (domicilio.getNumInterior() != null) {
                        addrNumI = domicilio.getNumInterior();
                    }
                    if (domicilio.getCp() != null) {
                        addrZip = domicilio.getCp().getId();
                    }
                    if (domicilio.getColonia() != null) {
                        addrCol = domicilio.getColonia().getId();
                        addrColLab = domicilio.getColonia().getTitle();
                    }
                    if (domicilio.getMunicipio() != null) {
                        addrMun = domicilio.getMunicipio().getId();
                        addrMunLab = domicilio.getMunicipio().getTitle();
                    }
                    if (domicilio.getEntidad() != null) {
                        addrState = domicilio.getEntidad().getId();
                        addrStateLab = domicilio.getEntidad().getTitle();
                    }
                    if (domicilio.getPais() != null) {
                        addrCountry = domicilio.getPais().getId();
                    }
                }
                if (persona.getFacebook() != null) {
                    facebook = persona.getFacebook();
                }
                if (persona.getSkype() != null) {
                    skype = persona.getSkype();
                }
                if (persona.getMsn() != null) {
                    msn = persona.getMsn();
                }
                if (persona.getLinkedin() != null) {
                    linkedin = persona.getLinkedin();
                }
                if (persona.getTwitter() != null) {
                    twitter = persona.getTwitter();
                }
            }
            if (candidato != null) {
                sLabor = candidato.getSituacionLaboral();
                availability = candidato.getDisponibilidad();
            }
            String url = paramRequest.getActionUrl().setCallMethod(SWBResourceURL.Call_CONTENT).setAction(paramRequest.Action_ADD).toString();
            String ajaxUrl = paramRequest.getActionUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setMode(UserPersonalData.Mode_AJAX).toString();
%>
<script type="text/javascript">
    <!--
    dojo.require("dijit.layout.ContentPane");
    dojo.require("dijit.form.Form");
    dojo.require("dijit.form.ValidationTextBox");
    dojo.require("dijit.form.Button");
    dojo.require("dijit.form.FilteringSelect");
    dojo.require("dijit.form.RadioButton");
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
    /*function isEmpty(objid) {
var obj = dojo.byId(objid);
if (obj==null || obj.value=='' || !isNaN(obj.value) || obj.value.charAt(0) == ' ') {
return true;
}else {
return false;
}
}*/
    function isValidDate() {
        var valid=false;
        if(dijit.byId("birthday")!=null && !isEmpty(dijit.byId( "birthday" ).getValue())) {
            var birth = dijit.byId( "birthday" ).getValue().split("/");
            var dayField = birth[0];
            var monthField = birth[1];
            var yearField = birth[2];
            /*if(isInteger(dayField) && isInteger(monthField) && isInteger(yearField)) {
if(!isNaN(Date.UTC(yearField, monthField-1, dayField)))
valid = true;
}*/
            var dayobj = new Date(yearField, monthField-1, dayField)
            if ((dayobj.getMonth()+1==monthField)&&
                (dayobj.getDate()==dayField)&&
                (dayobj.getFullYear()==yearField)){
                valid=true;
            }
        }
        return valid;
    }
    function validateFM2(){
        var objd=dijit.byId('nationality').getValue();
        var objf=dijit.byId('fm2');
        if(objd=="mx"){
            objf.attr('value',false);
            objf.disabled=true;
        }else{
            objf.disabled=false;
        }

    }
    /*function validateAddrCountry(){
alert("addr")
var objd=dijit.byId('addrCountry').getValue();
var objf=dojo.query('spAddres');
alert(objf);
if(objd=="mx"){
objf.setAttribute('displayed', 'off');
//objf.style("display","none");
//objf.display="none";
//objf.style("visibility","hidden");
}else{
objf.setAttribute('displayed', 'on');
//objf.style("display","block");
//objf.display="block";
//objf.style("visibility","visible");
}

}*/
    var cpValue='<%=addrZip%>';
    function validateCP(){
        var valid=false;
        var cpv=dijit.byId('addrZip').getValue();
//console.log("validate:old:"+cpValue+" new:"+cpv);
        var filter = /^\d{5}$/;
        if(cpv!=null&&cpv!=''&&filter.test(cpv)){
            if(isCPValid(cpv)){
                valid = true;
                if(cpv!=cpValue){
                    loadCPData();
                }
            }
        }
        cpValue=cpv;
//console.log("valid:"+valid);
        return valid;
    }
    function isCPValid(val){
        var valid=false;
        valid=getJSON("<%=ajaxUrl%>?zip="+val);
        return valid;
    }
    function loadCPData(){
//console.log("load;"+cpValue);
        var cpv=dijit.byId('addrZip').getValue();
        var idcol="";
        var objcol=dijit.byId('addrCol');
        var objmun=dijit.byId('addrMun');
        var objsta=dijit.byId('addrState');
        if(typeof objcol != "undefined"){
            idcol=objcol.getValue();
        }else{
            idcol="<%=addrCol%>";
        }
//        var filter = /^\d{5}$/;
//        if(cpv!=null&&cpv!=''&&filter.test(cp)){
            //if(cpValid){
                if(typeof objcol != "undefined"){
                    objcol.destroy();
                }
                getHtml("<%=ajaxUrl%>?col="+cpv+"&amp;id="+idcol, "spAddrCol", true, false);
                if(typeof objmun != "undefined"){
                    objmun.destroy();
                }
                getHtml("<%=ajaxUrl%>?mun="+cpv, "spAddrMun", true, false);
                if(typeof objstate != "undefined"){
                    objsta.destroy();
                }
                getHtml("<%=ajaxUrl%>?sta="+cpv, "spAddrState", true, false);
           // }
//        }
    }
    var pc=1;
    function appendPhone() {
        var s = '';
        var parentId='phoneList';
        s="<div id=\"phoneId_"+pc+"\">"+
            "<div class=\"icv-div-grupo\">"+
            "<p class=\"icv-3col\">"+
            "<label for=\"phoneType_"+pc+"\"><%=paramRequest.getLocaleString("lblPhoneType")%></label>"+
            "<select name=\"phoneType_"+pc+"\" id=\"phoneType_"+pc+"\"  dojoType=\"dijit.form.FilteringSelect\" required=\"false\" promptMessage=\"<%=paramRequest.getLocaleString("promptMsgPhoneType")%>\">"+
            "<option value=\"Fijo\">Fijo</option>"+
            "<option value=\"Movil\">Movil</option>"+
            "<option value=\"Trabajo\">Trabajo</option>"+
            "<option value=\"Recados\">Recados</option>"+
            "</select>"+
            "</p>"+
            "<p class=\"icv-txt\">"+
            "<a href=\"#\" onclick=\"deletePhone('_"+pc+"');return false;\">Eliminar</a>"+
            "</p>"+
            "<div class=\"clearer borde\">&nbsp;</div>"+
            "</div>"+
            "<div class=\"icv-div-grupo\">"+
            "<p class=\"icv-3col\">"+
            "<label for=\"phoneLada_"+pc+"\"><%=paramRequest.getLocaleString("lblPhoneLada")%></label>"+
            "<input type=\"text\" name=\"phoneLada_"+pc+"\" id=\"phoneLada_"+pc+"\" dojoType=\"dijit.form.ValidationTextBox\" value=\"\" maxlength=\"14\"  promptMessage=\"<%=paramRequest.getLocaleString("promptMsgPhone")%>\" invalidMessage=\"<%=paramRequest.getLocaleString("lblPhoneFault")%>\" regExp=\"\\d{2,3}\" trim=\"true\"/>"+
            "</p>"+
            "<p class=\"icv-3col\">"+
            "<label for=\"phoneNum_"+pc+"\"><%=paramRequest.getLocaleString("lblPhoneNum")%></label>"+
            "<input type=\"text\" name=\"phoneNum_"+pc+"\" id=\"phoneNum_"+pc+"\" dojoType=\"dijit.form.ValidationTextBox\" value=\"\" maxlength=\"14\"  promptMessage=\"<%=paramRequest.getLocaleString("promptMsgPhone")%>\" invalidMessage=\"<%=paramRequest.getLocaleString("lblPhoneFault")%>+\" regExp=\"\\d{7,8}\" trim=\"true\"/>"+
            "</p>"+
            "<p class=\"icv-3col\">"+
            "<label for=\"phoneExt_"+pc+"\"><%=paramRequest.getLocaleString("lblPhoneExt")%></label>"+
            "<input type=\"text\" name=\"phoneExt_"+pc+"\" id=\"phoneExt_"+pc+"\" dojoType=\"dijit.form.ValidationTextBox\" value=\"\" maxlength=\"14\"  promptMessage=\"<%=paramRequest.getLocaleString("promptMsgPhone")%>\" invalidMessage=\"<%=paramRequest.getLocaleString("lblPhoneFault")%>\" regExp=\"\\d+\" trim=\"true\"/>"+
            "</p>"+
            "<div class=\"clearer borde\">&nbsp;</div>"+
            "</div>"+
            "</div>";
        dojo.place(s, parentId, 'last');
        pc++;
    }
    function deletePhone(id) {
        s="<input type=\"hidden\" name=\"phoneNum"+id+"\" id=\"phoneNum"+id+"\" value=\"\" />";//+
        dojo.place(s, "phoneId"+id, 'replace');
    }
    function appendEmail() {
        var s = '';
        var parentId='pEmailList';
        s="<div id=\"pEmailId_"+pc+"\">"+
            "<div class=\"icv-div-grupo\">"+
            "<p class=\"icv-3col\">"+
            "<label for=\"pEmail_"+pc+"\"><%=paramRequest.getLocaleString("lblEmail")%></label>"+
            "<input type=\"text\" name=\"pEmail_"+pc+"\" id=\"pEmail_"+pc+"\" dojoType=\"dijit.form.ValidationTextBox\" value=\"\" maxlength=\"60\"  promptMessage=\"<%=paramRequest.getLocaleString("promptMsgEmail")%>\" invalidMessage=\"<%=paramRequest.getLocaleString("lblEmailFault")%>\"  trim=\"true\"/>"+
            "</p>"+
            "<p class=\"icv-txt\">"+
            "<a href=\"#\" onclick=\"deleteEmail('_"+pc+"');return false;\">Eliminar</a>"+
            "</p>"+
            "<div class=\"clearer borde\">&nbsp;</div>"+
            "</div>"+
            "</div>";
        dojo.place(s, parentId, 'last');
        pc++;
    }
    function deleteEmail(id) {
        s="<div/>";
        dojo.place(s, "pEmailId"+id, 'replace');
    }
    function isValidThisEmail(){
        var valid=false;
        var email = dijit.byId( "email" );
        var strEmail = email.getValue();
        if(strEmail!=""){
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
    dojo.addOnLoad(validateFM2);
    //dojo.addOnLoad(validateAddrCountry);
    -->
</script>
<div id="icv">
    <%@include file="../menucvi.jsp" %>
    <div id="icv-data">
        <form id="form1ud" dojoType="dijit.form.Form" class="swbform" action="<%=url%>" method="post">
            <div class="icv-div-grupo">
                <p class="icv-3col">
                    <label for="curp"><%=paramRequest.getLocaleString("lblCurp")%></label>
                    <input type="text" name="curp" id="curp" dojoType="dijit.form.ValidationTextBox" value="<%=curp%>" maxlength="18" promptMessage="<%=paramRequest.getLocaleString("promptMsgCurp")%>" invalidMessage="<%=paramRequest.getLocaleString("lblCurpFault")%>" uppercase="true" regExp="[a-zA-Z]{4}\d{6}[a-zA-Z]{6}\d{2}"  trim="true"/>
                </p>
                <p class="icv-3col curp">
                    <!--input type="checkbox" name="nocurp" id="nocurp" />
                    <label for="nocurp">No conozco mi CURP</label-->
                </p>
                <div class="clearer">&nbsp;</div>
            </div>
            <div class="icv-div-grupo">
                <p class="icv-3col">
                    <label for="firstName"><b>*</b><%=paramRequest.getLocaleString("lblFirstName")%></label>
                    <input type="text" name="firstName" id="firstName" dojoType="dijit.form.ValidationTextBox" value="<%=firstName%>" maxlength="35" required="true" promptMessage="<%=paramRequest.getLocaleString("promptMsgFirstName")%>" invalidMessage="<%=paramRequest.getLocaleString("lblFirstNameFault")%>" trim="true" regExp="[a-zA-Z\u00C0-\u00FF' ]+"/>
                </p>
                <p class="icv-3col">
                    <label for="lastName"><b>*</b><%=paramRequest.getLocaleString("lblLastName")%></label>
                    <input type="text" name="lastName" id="lastName" dojoType="dijit.form.ValidationTextBox" value="<%=lastName%>" maxlength="35" required="true" promptMessage="<%=paramRequest.getLocaleString("promptMsgLastName")%>" invalidMessage="<%=paramRequest.getLocaleString("lblLastNameFault")%>" trim="true" regExp="[a-zA-Z\u00C0-\u00FF' ]+"/>
                </p>
                <p class="icv-3col">
                    <label for="secondLastName"><%=paramRequest.getLocaleString("lblSecondLastName")%></label>
                    <input type="text" name="secondLastName" id="secondLastName" dojoType="dijit.form.ValidationTextBox" value="<%=secondLastName%>" maxlength="35" required="false" promptMessage="<%=paramRequest.getLocaleString("promptMsgSecondLastName")%>" invalidMessage="<%=paramRequest.getLocaleString("lblSecondLastNameFault")%>" trim="true" regExp="[a-zA-Z\u00C0-\u00FF' ]+"/>
                </p>
                <div class="clearer">&nbsp;</div>
            </div>
            <div class="icv-div-grupo">
                <p class="icv-3col">
                    <label ><%=paramRequest.getLocaleString("lblGender")%></label>
                    <input type="radio" dojoType="dijit.form.RadioButton" name="gender" id="radioOne" class="icv-radio2" <%=gender == "f" ? "checked" : ""%> value="f"/>
                    <label for="radioOne" class="icv-label-negro"><%=paramRequest.getLocaleString("lblGenderFem")%></label>
                    <input type="radio" dojoType="dijit.form.RadioButton" name="gender" id="radioTwo" class="icv-radio2" <%=gender == "m" ? "checked" : ""%> value="m"/>
                    <label for="radioTwo" class="icv-label-negro"><%=paramRequest.getLocaleString("lblGenderMas")%></label>
                </p>
                <p class="icv-3col">
                    <label for="birthday"><b>*</b><%=paramRequest.getLocaleString("lblBirthday")%></label>
                    <input type="text" name="birthday" id="birthday" class="icv-calendario" dojoType="dijit.form.ValidationTextBox" value="<%=birthday%>" required="true" promptMessage="<%=paramRequest.getLocaleString("promptMsgBirthday")%>" invalidMessage="<%=paramRequest.getLocaleString("lblBirthdayFault")%>" regExp="(0[1-9]|[12][0-9]|3[01])[/](0[1-9]|1[012])[/](19|20)\d\d" trim="true"/>
                </p>
                <p class="icv-3col">
                    <label for="state"><%=paramRequest.getLocaleString("lblState")%></label>
                    <select name="state" id="state" dojoType="dijit.form.FilteringSelect" required="false" promptMessage=""<%=paramRequest.getLocaleString("promptMsgState")%>">
                            <%
                                        Iterator<EntidadFederativa> iten = EntidadFederativa.ClassMgr.listEntidadFederativas(ws);
                                        while (iten.hasNext()) {
                                            EntidadFederativa entidadFederativa = iten.next();%>
                            <option value="<%=entidadFederativa.getId()%>" <%=entidadFederativa.getId().equals(state) ? "selected" : ""%>><%=entidadFederativa.getTitle()%></option>
                        <%
                                    }
                        %>
                    </select>
                </p>
                <div class="clearer">&nbsp;</div>
            </div>
            <div class="icv-div-grupo">
                <p class="icv-3col">
                    <label for="nationality"><%=paramRequest.getLocaleString("lblNationality")%></label>
                    <select name="nationality" id="nationality" dojoType="dijit.form.FilteringSelect" required="false" onchange="validateFM2()">
                        <option value="" ><%=paramRequest.getLocaleString("promptMsgNationality")%></option>
                        <% Iterator<Country> itc = Country.ClassMgr.listCountries(ws);
                                    while (itc.hasNext()) {
                                        Country country = itc.next();%>
                        <option value="<%=country.getId()%>" <%=country.getId().equals(nationality) ? "selected" : ""%>><%=country.getTitle()%></option>
                        <%
                                    }
                        %>
                    </select>
                </p>
                <p class="icv-3col">
                    <label for="fm2"><%=paramRequest.getLocaleString("lblFm2")%></label>
                    <input type="checkbox" name="fm2" id="fm2" dojoType="dijit.form.CheckBox" value="true" checked="<%=fm2 ? "true" : "false"%>" promptMessage="<%=paramRequest.getLocaleString("promptMsgFm2")%>" invalidMessage="<%=paramRequest.getLocaleString("lblFm2Fault")%>"/>
                </p>
                <div class="clearer">&nbsp;</div>
            </div>
            <div class="icv-div-grupo">
                <p class="icv-2col">
                    <label for="sLabor"><%=paramRequest.getLocaleString("lblSLabor")%></label>
                    <select name="sLabor" id="sLabor"  dojoType="dijit.form.FilteringSelect" required="false">
                        <option value="" ><%=paramRequest.getLocaleString("promptMsgSLabor")%></option>
                        <option value="1" <%=sLabor == 1 ? "selected" : ""%>>Empleado</option>
                        <option value="2" <%=sLabor == 2 ? "selected" : ""%>>Desempleado</option>
                        <option value="3" <%=sLabor == 3 ? "selected" : ""%>>Estudiante</option>
                        <option value="4" <%=sLabor == 4 ? "selected" : ""%>>Jubilado</option>
                    </select>
                </p>
                <p class="icv-2col">
                    <label for="availability"><%=paramRequest.getLocaleString("lblAvailability")%></label>
                    <input type="text" name="availability" id="availability" dojoType="dijit.form.ValidationTextBox" value="<%=availability%>" maxlength="60" promptMessage="<%=paramRequest.getLocaleString("promptMsgAvailability")%>" invalidMessage="<%=paramRequest.getLocaleString("lblAvailabilityFault")%>" regExp="[0-9]+"  trim="true"/>
                </p>
                <div class="clearer">&nbsp;</div>
            </div>
            <!--            <div class="icv-div-grupo">
            <p class="icv-3col">
            <label for="addrCountry">Pa�s</label>
            <select name="addrCountry" id="addrCountry" dojoType="dijit.form.FilteringSelect" required="false" promptMessage="<%=paramRequest.getLocaleString("promptMsgAddrCountry")%>" onchange="validateAddrCountry()">
            <% //Iterator<Country> itac = Country.ClassMgr.listCountries(ws);
            // while (itac.hasNext()) {
            //Country country = itac.next();%>
            <option value="<%//=country.getId()%>" <%//=country.getId().equals(addrCountry) ? "selected" : ""%>><%//=country.getTitle()%></option>
            <%
            //}
            %>
            </select>
            </p>
            <p class="icv-3col" id="spAddres">
            <label for="addres">Direccion</label>
            <input type="text" name="addres" id="addres" dojoType="dijit.form.ValidationTextBox" value="<%//=addrStreet%>" maxlength="60" promptMessage="<%//=paramRequest.getLocaleString("promptMsgAddres")%>" invalidMessage="<%//=paramRequest.getLocaleString("lblAddresFault")%>" regExp="[a-zA-Z0-9\u00C0-\u00FF'.,\- ]+"  trim="true"/>
            </p>
            <div class="clearer">&nbsp;</div>
            </div>-->
            <div class="icv-div-grupo">
                <p class="icv-3col">
                    <label for="addrStreet">Calle</label>
                    <input type="text" name="addrStreet" id="addrStreet" dojoType="dijit.form.ValidationTextBox" value="<%=addrStreet%>" maxlength="60" promptMessage="<%=paramRequest.getLocaleString("promptMsgAddrStreet")%>" invalidMessage="<%=paramRequest.getLocaleString("lblAddrStreetFault")%>" regExp="[a-zA-Z0-9\u00C0-\u00FF'.,\- ]+"  trim="true"/>
                </p>
                <p class="icv-3col">
                    <label for="addrNumE">N�mero exterior</label>
                    <input type="text" name="addrNumE" id="addrNumE" dojoType="dijit.form.ValidationTextBox" value="<%=addrNumE%>" maxlength="60" promptMessage="<%=paramRequest.getLocaleString("promptMsgAddrNumE")%>" invalidMessage="<%=paramRequest.getLocaleString("lblAddrNumEFault")%>" regExp="[a-zA-Z0-9\u00C0-\u00FF'.,\- ]+"  trim="true"/>
                </p>
                <p class="icv-3col">
                    <label for="addrNumI">N�mero interior</label>
                    <input type="text" name="addrNumI" id="addrNumI" dojoType="dijit.form.ValidationTextBox" value="<%=addrNumI%>" maxlength="60" promptMessage="<%=paramRequest.getLocaleString("promptMsgAddrNumI")%>" invalidMessage="<%=paramRequest.getLocaleString("lblAddrNumIFault")%>" regExp="[a-zA-Z0-9\u00C0-\u00FF'.,\- ]+"  trim="true"/>
                </p>
                <div class="clearer">&nbsp;</div>
            </div>
            <div class="icv-div-grupo">
                <p class="icv-3col">
                    <label for="addrZip">C�digo Postal</label>
                    <input type="text" name="addrZip" id="addrZip" value="<%=addrZip%>" maxlength="5"  dojoType="dijit.form.ValidationTextBox" promptMessage="<%=paramRequest.getLocaleString("promptMsgAddrZip")%>" invalidMessage="<%=paramRequest.getLocaleString("lblAddrZipFault")%>" isValid="return validateCP()" trim="true"/>
                </p>
                <p class="icv-3col" >
                    <label for="addrColro">Colonia</label>
                    <span id="spAddrCol"><input type="text" name="addrColro" id="addrColro" value="<%=addrColLab%>" readonly="true" dojoType="dijit.form.ValidationTextBox"  /></span>
                </p>
                <p class="icv-3col">
                    <label for="addrMun">Municipio/Delegaci�n</label>
                    <span id="spAddrMun"><input type="text" name="addrMunro" id="addrMunro" value="<%=addrMunLab%>" readonly="true"  dojoType="dijit.form.ValidationTextBox" /></span>
                </p>
                <div class="clearer">&nbsp;</div>
            </div>

            <div class="icv-div-grupo">
                <p class="icv-3col">
                    <label for="addrState">Estado</label>
                    <span id="spAddrState"><input type="text" name="addrStatero" id="addrStatero" value="<%=addrStateLab%>" readonly="true" dojoType="dijit.form.ValidationTextBox"/></span>
                </p>
                <p class="icv-3col">
                    <label for="addrCountry">Pa�s</label>
                    <select name="addrCountry" id="addrCountry" dojoType="dijit.form.FilteringSelect" required="false" promptMessage="<%=paramRequest.getLocaleString("promptMsgAddrCountry")%>" onchange_="validateAddrCountry()">
                        <% Iterator<Country> itac = Country.ClassMgr.listCountries(ws);
                                    while (itac.hasNext()) {
                                        Country country = itac.next();%>
                        <option value="<%=country.getId()%>" <%=country.getId().equals(addrCountry) ? "selected" : ""%>><%=country.getTitle()%></option>
                        <%
                                    }
                        %>
                    </select>
                </p>
                <div class="clearer">&nbsp;</div>
            </div>
            <h3>Medio de contacto</h3>
            <div id="phoneList">
                <%
                            if (persona != null) {
                                Iterator<Telefono> itt = persona.listTelefonos();
                                while (itt.hasNext()) {
                                    Telefono telefono = itt.next();
                                    String phoneId = telefono.getId();
                                    String phoneLada = telefono.getLada() > 0 ? "" + telefono.getLada() : "";
                                    String phoneNum = telefono.getNumero() > 0 ? "" + telefono.getNumero() : "";
                                    String phoneExt = telefono.getExtension() > 0 ? "" + telefono.getExtension() : "";
                                    String phoneType = telefono.getTipo() != null ? telefono.getTipo() : "";
                %>
                <div  id="phoneId<%=phoneId%>">
                    <div class="icv-div-grupo">
                        <p class="icv-3col">
                            <label for="phoneType<%=phoneId%>"><%=paramRequest.getLocaleString("lblPhoneType")%></label>
                            <select name="phoneType<%=phoneId%>" id="phoneType<%=phoneId%>"  dojoType="dijit.form.FilteringSelect" promptMessage="<%=paramRequest.getLocaleString("promptMsgPhoneType")%>">
                                <option value="Fijo" <%=phoneType.equals("Fijo") ? "selected" : ""%>>Fijo</option>
                                <option value="Movil" <%=phoneType.equals("Movil") ? "selected" : ""%>>Movil</option>
                                <option value="Trabajo" <%=phoneType.equals("Trabajo") ? "selected" : ""%>>Trabajo</option>
                                <option value="Recados" <%=phoneType.equals("Recados") ? "selected" : ""%>>Recados</option>
                            </select>
                        </p>
                        <p class="icv-txt">
                            <a href="#" onclick="deletePhone('<%=phoneId%>');return false;">Eliminar</a>
                        </p>
                        <div class="clearer borde">&nbsp;</div>
                    </div>
                    <div class="icv-div-grupo">
                        <p class="icv-3col">
                            <label for="phoneLada<%=phoneId%>"><%=paramRequest.getLocaleString("lblPhoneLada")%></label>
                            <input type="text" name="phoneLada<%=phoneId%>" id="phoneLada<%=phoneId%>" dojoType="dijit.form.ValidationTextBox" value="<%=phoneLada%>" maxlength="14"  promptMessage="<%=paramRequest.getLocaleString("promptMsgPhone")%>" invalidMessage="<%=paramRequest.getLocaleString("lblPhoneFault")%>" regExp="\d{2,3}" trim="true"/>
                        </p>
                        <p class="icv-3col">
                            <label for="phoneNum<%=phoneId%>"><%=paramRequest.getLocaleString("lblPhoneNum")%></label>
                            <input type="text" name="phoneNum<%=phoneId%>" id="phoneNum<%=phoneId%>" dojoType="dijit.form.ValidationTextBox" value="<%=phoneNum%>" maxlength="14"  promptMessage="<%=paramRequest.getLocaleString("promptMsgPhone")%>" invalidMessage="<%=paramRequest.getLocaleString("lblPhoneFault")%>" regExp="\d{7,8}" trim="true"/>
                        </p>
                        <p class="icv-3col">
                            <label for="phoneExt<%=phoneId%>"><%=paramRequest.getLocaleString("lblPhoneExt")%></label>
                            <input type="text" name="phoneExt<%=phoneId%>" id="phoneExt<%=phoneId%>" dojoType="dijit.form.ValidationTextBox" value="<%=phoneExt%>" maxlength="14"  promptMessage="<%=paramRequest.getLocaleString("promptMsgPhone")%>" invalidMessage="<%=paramRequest.getLocaleString("lblPhoneFault")%>" regExp="\d+" trim="true"/>
                        </p>
                        <div class="clearer borde">&nbsp;</div>
                    </div>
                </div>
                <%
                                }
                            }
                %>
            </div>
            <div class="icv-div-grupo">
                <p class="icv-txt"><a href="#" onclick="appendPhone();return false;">Agregar otro tel�fono</a></p>
                <div class="clearer borde">&nbsp;</div>
            </div>
            <div class="icv-div-grupo">
                <p class="icv-2col">
                    <label for="emailro"><%=paramRequest.getLocaleString("lblEmail")%></label>
                    <input type="text" name="emailro" id="emailro" dojoType="dijit.form.ValidationTextBox" value="<%=email%>" readonly="true" maxlength="60"  required_="true" promptMessage="<%=paramRequest.getLocaleString("promptMsgEmail")%>" invalidMessage="<%=paramRequest.getLocaleString("lblEmailFault")%>" isValid_="return isValidThisEmail()" trim="true" />
                </p>
                <div class="clearer borde">&nbsp;</div>
            </div>
            <div id="pEmailList">
                <%
                            if (persona != null) {
                                Iterator<String> item = persona.listPEmails();
                                int emailId = 0;
                                while (item.hasNext()) {
                                    String pEmail = item.next();
                %>
                <div  id="pEmailId<%=emailId%>">
                    <div class="icv-div-grupo">
                        <p class="icv-3col">
                            <label for="pEmail<%=emailId%>"><%=paramRequest.getLocaleString("lblEmail")%></label>
                            <input type="text" name="pEmail<%=emailId%>" id="pEmail<%=emailId%>" dojoType="dijit.form.ValidationTextBox" value="<%=pEmail%>" maxlength="60" promptMessage="<%=paramRequest.getLocaleString("promptMsgEmail")%>" invalidMessage="<%=paramRequest.getLocaleString("lblEmailFault")%>" isValid="return isValidEmail(this.textbox.value)" trim="true"/>
                        </p>
                        <p class="icv-txt">
                            <a href="#" onclick="deleteEmail('<%=emailId%>');return false;">Eliminar</a>
                        </p>
                        <div class="clearer borde">&nbsp;</div>
                    </div>
                </div>
                <%
                                    emailId++;
                                }
                            }
                %>
            </div>
            <div class="icv-div-grupo">
                <p class="icv-txt"><a href="#" onclick="appendEmail();return false;">Agregar otro Correo eletr�nico</a></p>
                <div class="clearer borde">&nbsp;</div>
            </div>
            <div class="icv-div-grupo">
                <p class="icv-2col">
                    <label for="facebook"><%=paramRequest.getLocaleString("lblFacebook")%></label>
                    <input type="text" name="facebook" id="facebook" dojoType="dijit.form.ValidationTextBox" value="<%=facebook%>" maxlength="35"  promptMessage="<%=paramRequest.getLocaleString("promptMsgFacebook")%>" invalidMessage="<%=paramRequest.getLocaleString("lblFacebookFault")%>"  trim="true" regExp="[a-zA-Z0-9\u00C0-\u00FF'_\-./ ]+"/>
                </p>
                <p class="icv-2col">
                    <label for="skype"><%=paramRequest.getLocaleString("lblSkype")%></label>
                    <input type="text" name="skype" id="skype" dojoType="dijit.form.ValidationTextBox" value="<%=skype%>" maxlength="35"  promptMessage="<%=paramRequest.getLocaleString("promptMsgSkype")%>" invalidMessage="<%=paramRequest.getLocaleString("lblSkypeFault")%>" trim="true" regExp="[a-zA-Z0-9\u00C0-\u00FF'_\- ]+"/>
                </p>
                <div class="clearer borde">&nbsp;</div>
            </div>
            <div class="icv-div-grupo">
                <p class="icv-2col">
                    <label for="msn"><%=paramRequest.getLocaleString("lblMsn")%></label>
                    <input type="text" name="msn" id="msn" dojoType="dijit.form.ValidationTextBox" value="<%=msn%>" maxlength="35"  promptMessage="<%=paramRequest.getLocaleString("promptMsgMsn")%>" invalidMessage="<%=paramRequest.getLocaleString("lblMsnFault")%>" trim="true" regExp="[a-zA-Z0-9\u00C0-\u00FF'_\- ]+"/>
                </p>
                <p class="icv-2col">
                    <label for="linkedin"><%=paramRequest.getLocaleString("lblLinkedin")%></label>
                    <input type="text" name="linkedin" id="linkedin" dojoType="dijit.form.ValidationTextBox" value="<%=linkedin%>" maxlength="35"  promptMessage="<%=paramRequest.getLocaleString("promptMsgLinkedin")%>" invalidMessage="<%=paramRequest.getLocaleString("lblLinkedinFault")%>" trim="true" regExp="[a-zA-Z0-9\u00C0-\u00FF'_\- ]+"/>
                </p>
                <div class="clearer borde">&nbsp;</div>
            </div>
            <div class="icv-div-grupo">
                <p class="icv-2col">
                    <label for="twitter"><%=paramRequest.getLocaleString("lblTwitter")%></label>
                    <input type="text" name="twitter" id="twitter" dojoType="dijit.form.ValidationTextBox" value="<%=twitter%>" maxlength="35"  promptMessage="<%=paramRequest.getLocaleString("promptMsgTwitter")%>" invalidMessage="<%=paramRequest.getLocaleString("lblTwitterFault")%>" trim="true" regExp="[a-zA-Z0-9\u00C0-\u00FF'@_\- ]+"/>
                </p>
                <div class="clearer borde">&nbsp;</div>
            </div>
            <div class="">
                <p>
                <!--input type="button" value="<%=paramRequest.getLocaleString("lblReset")%>"  onclick="history.back()"-->
                    <input type="submit" value="<%=paramRequest.getLocaleString("lblSave")%>"  onclick="return enviar()"/>
                </p>
            </div>
        </form>
    </div>
</div>