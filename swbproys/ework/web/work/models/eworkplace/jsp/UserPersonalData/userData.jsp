<%-- 
    Document   : userData
    Created on : 31/01/2012, 06:54:51 PM
    Author     : rene.jara
--%><%@page import="com.infotec.cvi.swb.Candidato"%>
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
            // try {
            //Persona persona = (Persona) request.getAttribute("persona");
            String repositoryId = paramRequest.getWebPage().getWebSite().getUserRepository().getId();
            WebSite ws = paramRequest.getWebPage().getWebSite();
            User user = paramRequest.getUser();
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
            String fm2 = "";

            String addrStreet="";
            String addrNumE="";
            String addrNumI="";
            String addrZip="";
            String addrCol="";
            String addrMun="";
            String addrState="";
            String addrCountry="";

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
                if (persona.getFM2() != null) {
                    fm2 = persona.getFM2();
                }
                if(persona.getDomicilio()!=null){
                    domicilio=persona.getDomicilio();
                    if(domicilio.getCalle()!=null){
                        addrStreet=domicilio.getCalle();
                    }
                    if(domicilio.getNumExterior()!=null){
                        addrNumE=domicilio.getNumExterior();
                    }
                    if(domicilio.getNumInterior()!=null){
                        addrNumI=domicilio.getNumInterior();
                    }
                    if(domicilio.getCp()!=null){
                        addrZip=domicilio.getCp().getId();
                    }
                    if(domicilio.getColonia()!=null){
                        addrCol=domicilio.getColonia().getId();
                    }
                    if(domicilio.getMunicipio()!=null){
                        addrMun=domicilio.getMunicipio().getId();
                    }
                    if(domicilio.getEntidad()!=null){
                        addrState=domicilio.getEntidad().getId();
                    }
                    if(domicilio.getPais()!=null){
                        addrCountry=domicilio.getPais().getId();
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
    function isEmpty(objid) {
        var obj = dojo.byId(objid);
        if (obj==null || obj.value=='' || !isNaN(obj.value) || obj.value.charAt(0) == ' ') {
            return true;
        }else {
            return false;
        }
    }
    function isValidDate(){
        var valid=false;
        var birth = dijit.byId( "birthday" ).getValue();
        var dayfield=birth.split("/")[0]
        var monthfield=birth.split("/")[1]
        var yearfield=birth.split("/")[2]
        var dayobj = new Date(yearfield, monthfield-1, dayfield)
        if ((dayobj.getMonth()+1==monthfield)&&
            (dayobj.getDate()==dayfield)&&
            (dayobj.getFullYear()==yearfield)){
            returnval=true;
        }
        return valid;
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
            "<option value=\"Casaa\">Casa</option>"+
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
    -->
</script>
<div id="icv">
    <%@include file="../menucvi.jsp" %>
    <div id="icv-data">
        <form id="form1ud" dojoType="dijit.form.Form" class="swbform" action="<%=url%>" method="post">
            <div class="icv-div-grupo">
                <p class="icv-3col">
                    <label for="curp"><%=paramRequest.getLocaleString("lblCurp")%></label>
                    <input type="text" name="curp" id="curp" dojoType="dijit.form.ValidationTextBox" value="<%=curp%>" maxlength="60" promptMessage="<%=paramRequest.getLocaleString("promptMsgCurp")%>" invalidMessage="<%=paramRequest.getLocaleString("lblCurpFault")%>" uppercase="true" regExp="[a-zA-Z]{4}\d{6}[a-zA-Z]{6}\d{2}"  trim="true"/>
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
                    <input type="text" name="firstName" id="firstName" dojoType="dijit.form.ValidationTextBox" value="<%=firstName%>" maxlength="25" required="true" promptMessage="<%=paramRequest.getLocaleString("promptMsgFirstName")%>" invalidMessage="<%=paramRequest.getLocaleString("lblFirstNameFault")%>" trim="true" regExp="[a-zA-Z\u00C0-\u00FF' ]+"/>
                </p>
                <p class="icv-3col">
                    <label for="lastName"><b>*</b><%=paramRequest.getLocaleString("lblLastName")%></label>
                    <input type="text" name="lastName" id="lastName" dojoType="dijit.form.ValidationTextBox" value="<%=lastName%>" maxlength="25" required="true" promptMessage="<%=paramRequest.getLocaleString("promptMsgLastName")%>" invalidMessage="<%=paramRequest.getLocaleString("lblLastNameFault")%>" trim="true" regExp="[a-zA-Z\u00C0-\u00FF' ]+"/>
                </p>
                <p class="icv-3col">
                    <label for="secondLastName"><%=paramRequest.getLocaleString("lblSecondLastName")%></label>
                    <input type="text" name="secondLastName" id="secondLastName" dojoType="dijit.form.ValidationTextBox" value="<%=secondLastName%>" maxlength="25" required="false" promptMessage="<%=paramRequest.getLocaleString("promptMsgSecondLastName")%>" invalidMessage="<%=paramRequest.getLocaleString("lblSecondLastNameFault")%>" trim="true" regExp="[a-zA-Z\u00C0-\u00FF' ]+"/>
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
                    <select name="state" id="state" dojoType="dijit.form.FilteringSelect" required="false">
                        <option value="" ><%=paramRequest.getLocaleString("promptMsgState")%></option>
                        <option value="df">distrito Federal</option>
                        <option value="mc">estado de mexico</option>

                    </select>
                </p>
                <div class="clearer">&nbsp;</div>
            </div>

            <div class="icv-div-grupo">
                <p class="icv-3col">
                    <label for="nationality"><%=paramRequest.getLocaleString("lblNationality")%></label>
                    <select name="nationality" id="nationality" dojoType="dijit.form.FilteringSelect" required="false">
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
                    <input type="text" name="fm2" id="fm2" dojoType="dijit.form.ValidationTextBox" value="<%=fm2%>" maxlength="25"  promptMessage="<%=paramRequest.getLocaleString("promptMsgFm2")%>" invalidMessage="<%=paramRequest.getLocaleString("lblFm2Fault")%>" trim="true" regExp="\d+"/>
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
                    <select name="availability" id="availability"  dojoType="dijit.form.FilteringSelect" required="false">
                        <option value="" ><%=paramRequest.getLocaleString("promptMsgAvailability")%></option>
                        <option value="1" <%=availability == 1 ? "selected" : ""%>>1</option>
                        <option value="2" <%=availability == 2 ? "selected" : ""%>>2</option>
                        <option value="3" <%=availability == 3 ? "selected" : ""%>>3</option>
                        <option value="4" <%=availability == 4 ? "selected" : ""%>>4</option>
                        <option value="5" <%=availability == 5 ? "selected" : ""%>>5</option>
                        <option value="6" <%=availability == 6 ? "selected" : ""%>>6</option>
                        <option value="7" <%=availability == 7 ? "selected" : ""%>>7</option>
                    </select>
                </p>
                <div class="clearer">&nbsp;</div>
            </div>
            <div class="icv-div-grupo">
                <p class="icv-3col">
                    <label for="addrStreet">Calle</label>
                    <input type="text" name="addrStreet" id="addrStreet" dojoType="dijit.form.ValidationTextBox" value="<%=addrStreet%>" maxlength="60" promptMessage="<%=paramRequest.getLocaleString("promptMsgCurp")%>" invalidMessage="<%=paramRequest.getLocaleString("lblCurpFault")%>" regExp="[a-zA-Z0-9\u00C0-\u00FF'., ]+"  trim="true"/>
                </p>
                <p class="icv-3col">
                    <label for="addrNumE">Número exterior</label>
                    <input type="text" name="addrNumE" id="addrNumE" dojoType="dijit.form.ValidationTextBox" value="<%=addrNumE%>" maxlength="60" promptMessage="<%=paramRequest.getLocaleString("promptMsgCurp")%>" invalidMessage="<%=paramRequest.getLocaleString("lblCurpFault")%>" regExp="[a-zA-Z0-9\u00C0-\u00FF'., ]+"  trim="true"/>
                </p>
                <p class="icv-3col">
                    <label for="addrNumI">Número interior</label>
                    <input type="text" name="addrNumI" id="addrNumI" dojoType="dijit.form.ValidationTextBox" value="<%=addrNumI%>" maxlength="60" promptMessage="<%=paramRequest.getLocaleString("promptMsgCurp")%>" invalidMessage="<%=paramRequest.getLocaleString("lblCurpFault")%>" regExp="[a-zA-Z0-9\u00C0-\u00FF'., ]+"  trim="true"/>
                </p>
                <div class="clearer">&nbsp;</div>
            </div>
            <div class="icv-div-grupo">
                <p class="icv-3col">
                    <label for="addrZip">Código Postal</label>
                    <select name="addrZip" id="addrZip" dojoType="dijit.form.FilteringSelect" required="false" promptMessage=<%=paramRequest.getLocaleString("promptMsgNationality")%>">
                        <% //Iterator<Country> itc = Country.ClassMgr.listCountries(ws);
                                    //while (itc.hasNext()) {
                                        //Country country = itc.next();%>
                        <option value="<%//=country.getId()%>" <%//=country.getId().equals(nationality) ? "selected" : ""%>><%//=country.getTitle()%></option>
                        <%
                                   // }
                        %>
                    </select>
                </p>
                <p class="icv-3col">
                    <label for="addrCol">Colonia</label>
                    <select name="addrCol" id="addrCol" dojoType="dijit.form.FilteringSelect" required="false" promptMessage=<%=paramRequest.getLocaleString("promptMsgNationality")%>">
                        <% //Iterator<Country> itc = Country.ClassMgr.listCountries(ws);
                                    //while (itc.hasNext()) {
                                        //Country country = itc.next();%>
                        <option value="<%//=country.getId()%>" <%//=country.getId().equals(nationality) ? "selected" : ""%>><%//=country.getTitle()%></option>
                        <%
                                   // }
                        %>
                    </select>
                </p>
                <p class="icv-3col">
                    <label for="addrMun">Municipio/Delegación</label>
                    <select name="addrMun" id="addrMun" dojoType="dijit.form.FilteringSelect" required="false" promptMessage=<%=paramRequest.getLocaleString("promptMsgNationality")%>">
                        <% //Iterator<Country> itc = Country.ClassMgr.listCountries(ws);
                                    //while (itc.hasNext()) {
                                        //Country country = itc.next();%>
                        <option value="<%//=country.getId()%>" <%//=country.getId().equals(nationality) ? "selected" : ""%>><%//=country.getTitle()%></option>
                        <%
                                   // }
                        %>
                    </select>
                </p>
                <div class="clearer">&nbsp;</div>
            </div>
            <div class="icv-div-grupo">
                <p class="icv-3col">
                    <label for="addrState">Estado</label>
                    <select name="addrState" id="addrState" dojoType="dijit.form.FilteringSelect" required="false" promptMessage=<%=paramRequest.getLocaleString("promptMsgNationality")%>">
                        <% //Iterator<Country> itc = Country.ClassMgr.listCountries(ws);
                                    //while (itc.hasNext()) {
                                        //Country country = itc.next();%>
                        <option value="<%//=country.getId()%>" <%//=country.getId().equals(nationality) ? "selected" : ""%>><%//=country.getTitle()%></option>
                        <%
                                   // }
                        %>
                    </select>
                </p>
                <p class="icv-3col">
                    <label for="addrCountry">País</label>
                    <select name="addrCountry" id="addrCountry" dojoType="dijit.form.FilteringSelect" required="false" promptMessage=<%=paramRequest.getLocaleString("promptMsgNationality")%>">
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
                if(persona!=null){
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
                                    <!--option value=""><%//=paramRequest.getLocaleString("promptMsgPhoneType")%></option-->
                                <option value="Casa" <%=phoneType.equals("Casa") ? "selected" : ""%>>Casa</option>
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
                <p class="icv-txt"><a href="#" onclick="appendPhone();return false;">Agregar otro teléfono</a></p>
                <div class="clearer borde">&nbsp;</div>
            </div>

            <div class="icv-div-grupo">
                <p class="icv-2col">
                    <label for="emailro"><%=paramRequest.getLocaleString("lblEmail")%></label>
                    <input type="text" name="emailro" id="emailro" dojoType="dijit.form.ValidationTextBox" value="<%=email%>" maxlength="60" readonly="true" />
                </p>
                <p class="icv-2col">
                    <label for="facebook"><%=paramRequest.getLocaleString("lblFacebook")%></label>
                    <input type="text" name="facebook" id="facebook" dojoType="dijit.form.ValidationTextBox" value="<%=facebook%>" maxlength="25"  promptMessage="<%=paramRequest.getLocaleString("promptMsgFacebook")%>" invalidMessage="<%=paramRequest.getLocaleString("lblFacebookFault")%>"  trim="true" regExp="[a-zA-Z\u00C0-\u00FF' ]+"/>
                </p>
                <div class="clearer borde">&nbsp;</div>
            </div>
            <div class="icv-div-grupo">
                <p class="icv-2col">
                    <label for="skype"><%=paramRequest.getLocaleString("lblSkype")%></label>
                    <input type="text" name="skype" id="skype" dojoType="dijit.form.ValidationTextBox" value="<%=skype%>" maxlength="25"  promptMessage="<%=paramRequest.getLocaleString("promptMsgSkype")%>" invalidMessage="<%=paramRequest.getLocaleString("lblSkypeFault")%>" trim="true" regExp="[a-zA-Z\u00C0-\u00FF' ]+"/>
                </p>
                <p class="icv-2col">
                    <label for="msn"><%=paramRequest.getLocaleString("lblMsn")%></label>
                    <input type="text" name="msn" id="msn" dojoType="dijit.form.ValidationTextBox" value="<%=msn%>" maxlength="25"  promptMessage="<%=paramRequest.getLocaleString("promptMsgMsn")%>" invalidMessage="<%=paramRequest.getLocaleString("lblMsnFault")%>" trim="true" regExp="[a-zA-Z\u00C0-\u00FF' ]+"/>
                </p>
                <div class="clearer borde">&nbsp;</div>
            </div>
            <div class="icv-div-grupo">
                <p class="icv-2col">
                    <label for="linkedin"><%=paramRequest.getLocaleString("lblLinkedin")%></label>
                    <input type="text" name="linkedin" id="linkedin" dojoType="dijit.form.ValidationTextBox" value="<%=linkedin%>" maxlength="25"  promptMessage="<%=paramRequest.getLocaleString("promptMsgLinkedin")%>" invalidMessage="<%=paramRequest.getLocaleString("lblLinkedinFault")%>" trim="true" regExp="[a-zA-Z\u00C0-\u00FF' ]+"/>
                </p>
                <p class="icv-2col">
                    <label for="twitter"><%=paramRequest.getLocaleString("lblTwitter")%></label>
                    <input type="text" name="twitter" id="twitter" dojoType="dijit.form.ValidationTextBox" value="<%=twitter%>" maxlength="25"  promptMessage="<%=paramRequest.getLocaleString("promptMsgTwitter")%>" invalidMessage="<%=paramRequest.getLocaleString("lblTwitterFault")%>" trim="true" regExp="[a-zA-Z\u00C0-\u00FF' ]+"/>
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
<%
            //} catch (Exception e) {
            // e.printStackTrace(System.out);
            //out.println(e.getMessage());
            //}
%>