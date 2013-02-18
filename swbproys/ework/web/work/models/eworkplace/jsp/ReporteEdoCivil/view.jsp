<%--   
    Document   : view Recurso ReporteEdoCivil
    Created on : 01/02/2013
    Author     : juan.fernandez
--%>

<%@page import="java.util.Calendar"%>
<%@page import="com.infotec.eworkplace.swb.Familia"%>
<%@page import="com.infotec.eworkplace.swb.Persona"%>
<%@page import="com.infotec.cvi.swb.Distincion"%>
<%@page import="com.infotec.cvi.swb.Publicacion"%>
<%@page import="com.infotec.cvi.swb.Docencia"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="com.infotec.cvi.swb.Investigacion"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURLImp"%>
<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<%@page import="java.util.StringTokenizer"%>
<%@page import="com.infotec.cvi.swb.util.UtilsCVI"%>
<%@page import="org.semanticwb.model.WebPage"%>
<%@page import="com.infotec.cvi.swb.CV"%>
<%@page import="java.util.Set"%>
<%@page import="org.semanticwb.model.SWBComparator"%>
<%@page import="java.util.Locale"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="org.semanticwb.model.WebSite"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.semanticwb.model.User"%>
<%@page import="org.semanticwb.model.Role"%>
<%@page import="org.semanticwb.model.Resource"%> 
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="org.semanticwb.SWBUtils"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest" />

<%

    WebPage wpage = paramRequest.getWebPage();
    WebSite wsite = wpage.getWebSite();
    User usr = paramRequest.getUser();
    Role role = null;

    Resource base = paramRequest.getResourceBase();
    String strNumItems = base.getAttribute("numPageItems", "10");
    String npage = request.getParameter("page");
    String orderby = request.getParameter("order");
    String action = request.getParameter("act");
    String MODE_EXPORT = "export";

    String export = request.getParameter("export");
    if (null == export) {
        export = "";
    }
    int numPages = 10;
    try {
        numPages = Integer.parseInt(strNumItems);
    } catch (Exception e) {
        numPages = 10;
    }

    if (action == null) {
        action = "";
    }

    StringBuffer ret = new StringBuffer();
%>
<script type="text/javascript">
    <!--
    dojo.require("dijit.layout.ContentPane");
    dojo.require("dijit.form.Form");
    dojo.require("dijit.form.ValidationTextBox");
    dojo.require("dijit.form.Button");
    dojo.require("dijit.form.FilteringSelect");
    dojo.require("dojo.data.ItemFileReadStore");
    
    function enviar() {
        var objd=dijit.byId('form1cm');
        if(objd.validate()&&validData()){
            return true;
        }else {
            alert("Datos incompletos");
        }
        return false;
    }

    function validData(){
        var objHijos=dijit.byId('hijos');
        var objFiltro=dijit.byId('edadfiltro');
        var objEdad=dijit.byId('edad');
        if(objHijos.value=='1' && objFiltro.value!='0'){
            if((!isEmpty(objEdad))){
                return true;
            }else{
                return false;
            }
        } else {
            return true;
        }
    }
    
    function isEmpty(obj){
        if(typeof obj != "undefined"&&
            obj!=null &&
            obj!=''){
            return false;
        }else{
            return true;
        }
    }
    
    function chkHijos(){
        var objHijos=dijit.byId('hijos');
        var objFiltro=dijit.byId('edadfiltro');
        var objNum=dijit.byId('numhijos');
        var objEdad=dijit.byId('edad');
        if(objHijos.value=='1'){
            objFiltro.setDisabled(false);
            objNum.setDisabled(false);    
            objEdad.setDisabled(false);
        } else {
            objFiltro.setDisabled(true);
            objNum.setDisabled(true);  
            objEdad.setDisabled(true);          
        }
    }
    
    function chkAge(){
        var objFiltro=dijit.byId('edadfiltro');
        var objEdad=dijit.byId('edad');
        if(objFiltro.value=='0'){
            objEdad.attr('required',false);
        } else {
            objEdad.attr('required',true);
        }
    }
    
    -->
</script>
<div >
    <div id="icv">
        <div id="icv-data"><div><span>
                    <%
                        if (action.equals("")) {
                            SWBResourceURL urlact = paramRequest.getRenderUrl();
                    %>
                    <form id="form1cm" dojoType="dijit.form.Form" class="swbform" action="<%=urlact%>" method="post">
                        <input type="hidden" name="act" value="edocivil" />
                        <div class="icv-div-grupo">
                            <%
                                SWBResourceURL url = paramRequest.getRenderUrl();
                                url.setCallMethod(SWBResourceURL.Call_DIRECT);
                            %>
                            <p class="icv-3col">
                                <label for="sexo">Genero</label>
                                <select name="sexo" id="sexo" dojoType="dijit.form.FilteringSelect" >
                                    <option value="2" selected="selected">Indistinto</option>
                                    <option value="1">Femenino</option>
                                    <option value="0">Masculino</option>
                                </select> 
                            </p>
                            <p class="icv-3col">
                                <label for="edocivil">Estado civil</label>
                                <select name="edocivil" id="edocivil" dojoType="dijit.form.FilteringSelect" >
                                    <option value="2" selected="selected">Indistinto</option>
                                    <option value="1">Casado</option>
                                    <option value="0">Soltero</option>
                                </select>
                            </p>
                            <p class="icv-3col">
                                <label for="hijos">Hijos</label>
                                <select name="hijos" id="hijos" dojoType="dijit.form.FilteringSelect" required="false" onchange="chkHijos()">
                                    <option value="" selected="selected">Seleccione...</option>
                                    <option value="0">Sin hijos</option>
                                    <option value="1">Con hijos</option>
                                </select>
                            </p>
                            <div class="clearer">&nbsp;</div>
                        </div>
                        <div class="icv-div-grupo">
                            <p class="icv-3col">
                                <label for="numhijos">Número de hijos</label>
                                <input type="text" name="numhijos" id="numhijos" value="" required="false"  dojoType="dijit.form.ValidationTextBox" disabled="true"/>
                            </p>
                            <p class="icv-3col">
                                <label for="edadfiltro">Que la edad de los hijos sea</label>
                                <select name="edadfiltro" id="edadfiltro" dojoType="dijit.form.FilteringSelect" disabled="true" onchange="chkAge()">
                                    <option value="0" selected="selected">Seleccione...</option>
                                    <option value="=">Igual a</option>
                                    <option value="<">Menor a</option>
                                    <option value="<=">Menor o igual a</option>
                                    <option value=">">Mayor a</option>
                                    <option value=">=">Mayor o igual a</option>
                                    <option value="<>">Diferente a</option>
                                </select>
                            </p>
                            <p class="icv-3col">
                                <label for="edad">edad</label>
                                <input type="text" name="edad" id="edad" value=""   dojoType="dijit.form.ValidationTextBox" disabled="true"/>
                            </p>
                            <div class="clearer">&nbsp;</div>
                        </div>
                        <div class="centro">
                            <input type="button" onclick="javascript:history.back(1)" value="Regresar"/>
                            <input type="reset" value="Borrar"/>
                            <input type="submit" onclick="return enviar()" value="Enviar"/>
                        </div>
                    </form>

                    <%

                    } else if ("edocivil".equals(action)) {
                        String wptitle = "Reporte Genero, Estado Civil, Hijos";
                        String txtCriteria = "";

                        String step = "1";
                        if (request.getParameter("step") != null) {
                            step = request.getParameter("step");
                        }

                        // parámetros para filtro
                        String sexo = request.getParameter("sexo");
                        if (sexo == null) {
                            sexo = "2"; //indistinto
                        }
                        txtCriteria = "Genero: ";
                        if (sexo.equals("0")) {
                            txtCriteria += "Masculino";
                        } else if (sexo.equals("1")) {
                            txtCriteria += "Femenino";
                        } else if (sexo.equals("2")) {
                            txtCriteria += "Indistinto";
                        }

                        String edocivil = request.getParameter("edocivil");
                        if (edocivil == null) {
                            edocivil = "2"; //indistinto
                        }

                        txtCriteria += ", Estado Civil: ";
                        if (edocivil.equals("0")) {
                            txtCriteria += "Soltero";
                        } else if (edocivil.equals("1")) {
                            txtCriteria += "Casado";
                        } else if (edocivil.equals("2")) {
                            txtCriteria += "Indistinto";
                        }

                        String hijos = request.getParameter("hijos");
                        if (hijos == null) {
                            hijos = "";
                        }

                        String numhijos = request.getParameter("numhijos");
                        if (numhijos == null) {
                            numhijos = "";
                        }

                        String edadfiltro = request.getParameter("edadfiltro");
                        if (edadfiltro == null) {
                            edadfiltro = "0";
                        }
                        String edad = request.getParameter("edad");
                        if (edad == null) {
                            edad = "";
                        }

                        if (hijos.equals("0")) {
                            txtCriteria += ", que no tengan hijos";
                        } else if (hijos.equals("1")) {

                            if (!numhijos.equals("")) {
                                txtCriteria += ", que tengan al menos " + numhijos + " hijos ";
                            } else {
                                txtCriteria += ", que tengan por lo menos un hijo ";
                            }

                            if (!edadfiltro.equals("0")) {
                                txtCriteria += "y que la edad sea ";
                                if (edadfiltro.equals("=")) {
                                    txtCriteria += " igual a ";
                                } else if (edadfiltro.equals("<")) {
                                    txtCriteria += " menor a ";
                                } else if (edadfiltro.equals("<=")) {
                                    txtCriteria += " menor o igual a ";
                                } else if (edadfiltro.equals(">")) {
                                    txtCriteria += " mayor a ";
                                } else if (edadfiltro.equals(">=")) {
                                    txtCriteria += " mayor o igual a ";
                                } else if (edadfiltro.equals("<>")) {
                                    txtCriteria += " diferente a ";
                                }
                                txtCriteria += edad + " años";
                            }

                        }


                        if ("1".equals(step)) {
                            HashMap<String, Persona> hm = new HashMap<String, Persona>(); // cvs encontrados
                            HashMap<String, Persona> hmfiltro = new HashMap<String, Persona>();
                            HashMap<String, String> hmorder = new HashMap<String, String>(); //


                            boolean aplica = Boolean.FALSE;
                            long acum = 0, acumno = 0;
                            // filtrado por genero
                            Iterator<Persona> itper = Persona.ClassMgr.listPersonas(wsite);
                            while (itper.hasNext()) {
                                Persona per = itper.next();
                                User usercv = per.getOwner();
                                if (usercv != null) {
                                    if (!sexo.equals("2")) {  // para saber si se van a contar por genero o no
                                        if (sexo.equals("1") && per.isGenero()) {  //femenino en true
                                            hm.put(per.getId(), per);
                                        } else if (sexo.equals("0") && !per.isGenero()) {  //masculino en false
                                            hm.put(per.getId(), per);
                                        }
                                    } else {  //genero indistinto
                                        hm.put(per.getId(), per);
                                    }
                                }
                            }

                            // filtro por edo civil
                            if (!edocivil.equals("2")) {
                                hmfiltro = new HashMap<String, Persona>();
                                itper = hm.values().iterator();
                                while (itper.hasNext()) {
                                    Persona per = itper.next();
                                    User usercv = per.getOwner();
                                    if (edocivil.equals("1")) {
                                        if (per.isCasado()) {  // está casado
                                            hmfiltro.put(per.getId(), per);
                                        }
                                    } else if (edocivil.equals("0")) {
                                        if (!per.isCasado()) {  // no está casado
                                            hmfiltro.put(per.getId(), per);
                                        }
                                    }
                                }
                                hm = hmfiltro;
                            }

                            // filtro hijos
                            if (!hijos.equals("")) {
                                hmfiltro = new HashMap<String, Persona>();
                                itper = hm.values().iterator();
                                while (itper.hasNext()) {
                                    Persona per = itper.next();
                                    User usercv = per.getOwner();
                                    if (hijos.equals("1")) {  // con hijos
                                        if (!numhijos.equals("")) {  // con un determinado numero de hijos
                                            int i_numhijos = 0;
                                            try {
                                                i_numhijos = Integer.parseInt(numhijos);
                                            } catch (Exception e) {
                                                i_numhijos = 0;
                                            }
                                            if (i_numhijos > 0) {
                                                int cuentahijos = 0;
                                                Iterator<Familia> itfam = per.listFamilias();
                                                while (itfam.hasNext()) {
                                                    Familia fam = itfam.next();
                                                    if (fam.getParentesco().equals("son")) {
                                                        cuentahijos++;
                                                    }
                                                }
                                                if (cuentahijos >= i_numhijos) {  // tiene los hijos solicitados o más
                                                    hmfiltro.put(per.getId(), per);
                                                }
                                            }
                                        } else {  // usuario que por lo menos con hijos sin importar el numero de hijos
                                            Iterator<Familia> itfam = per.listFamilias();
                                            while (itfam.hasNext()) {
                                                Familia fam = itfam.next();
                                                if (fam.getParentesco().equals("son")) {  // tiene por lo menos un hijo
                                                    hmfiltro.put(per.getId(), per);
                                                    break;
                                                }
                                            }
                                        }
                                    } else if (hijos.equals("0")) {  // sin hijos
                                        Iterator<Familia> itfam = per.listFamilias();
                                        if (!itfam.hasNext()) {
                                            hmfiltro.put(per.getId(), per);
                                        } else {
                                            boolean familiar = false;
                                            while (itfam.hasNext()) {
                                                Familia fam = itfam.next();
                                                if (fam.getParentesco().equals("son")) {
                                                    familiar = true;
                                                    break;
                                                }
                                            }
                                            if (!familiar) {  // no tiene familiar que sea hijo o hija
                                                hmfiltro.put(per.getId(), per);
                                            }
                                        }
                                    }
                                }
                                hm = hmfiltro;  // filtro hijos

                                if (!edadfiltro.equals("0") && !edad.equals("")) {
                                    hmfiltro = new HashMap<String, Persona>();
                                    itper = hm.values().iterator();
                                    while (itper.hasNext()) {
                                        Persona per = itper.next();
                                        User usercv = per.getOwner();
                                        if (hijos.equals("1")) {  // con hijos
                                            String operador = edadfiltro;
                                            Iterator<Familia> itfam = per.listFamilias();
                                            while (itfam.hasNext()) {
                                                Familia fam = itfam.next();
                                                if (fam.getParentesco().equals("son")) {
                                                    boolean cumple = calculaEdad(fam, operador, edad);
                                                    if (cumple) {
                                                        hmfiltro.put(per.getId(), per);
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                hm = hmfiltro;
                            }


                            acum = SWBUtils.Collections.sizeOf(hm.keySet().iterator());

                            if (acum == 0) {
                    %>    
                    <p>No se encontraron registros.....</p> 
                    <button type="button" onclick="window.location='<%=wpage.getUrl()%>';">Regresar</button>
                    <%            } else {
                    %>    

                    <table>
                        <caption><%=wptitle%><br/><%=txtCriteria%></caption>
                        <thead> 
                            <tr>
                                <th>&nbsp;</th>
                                <th>Encontrados</th>
                                <th>Detalle</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                SWBResourceURL urldetail = paramRequest.getRenderUrl();
                                urldetail.setParameter("step", "2");
                                urldetail.setParameter("act", "edocivil");
                                //urldetail.setParameter("reptype", "linea");
                                urldetail.setParameter("sexo", sexo);
                                urldetail.setParameter("edocivil", edocivil);
                                urldetail.setParameter("hijos", hijos);
                                urldetail.setParameter("numhijos", numhijos);
                                urldetail.setParameter("edadfiltro", edadfiltro);
                                urldetail.setParameter("edad", edad);

                            %>
                            <tr>
                                <td>Registros encontrados</td>
                                <td><%=acum%></td>
                                <%
                                    if (!export.equals("excel")) {
                                %>
                                <td><a href="<%=urldetail.toString()%>">ver</a></td>
                                <%
                                } else {
                                %>     
                                <td>&nbsp;</td>
                                <%                   }
                                %>
                            </tr>
                        </tbody>
                    </table>

                    <%
                        if (!export.equals("excel")) {
                            SWBResourceURL urlExport = paramRequest.getRenderUrl();
                            urlExport.setCallMethod(SWBResourceURL.Call_DIRECT);
                            urlExport.setMode(MODE_EXPORT);
                    %>
                    <form action="<%=urlExport.toString()%>" method="post">

                        <input type="hidden" name="act" value="<%=request.getParameter("act")%>">
                        <input type="hidden" name="sexo" value="<%=sexo%>">
                        <input type="hidden" name="edocivil" value="<%=edocivil%>">
                        <input type="hidden" name="hijos" value="<%=hijos%>">
                        <input type="hidden" name="numhijos" value="<%=numhijos%>">
                        <input type="hidden" name="edadfiltro" value="<%=edadfiltro%>">
                        <input type="hidden" name="edad" value="<%=edad%>">

                        <input type="hidden" name="export" value="excel">
                        <%
                            if (request.getParameter("step") != null) {
                        %>
                        <input type="hidden" name="step" value="<%=request.getParameter("step")%>">
                        <%
                            }
                            if (request.getParameter("act") != null) {
                        %>
                        <input type="hidden" name="act" value="<%=request.getParameter("act")%>">
                        <%
                            }

                        %>

                        <button type="button" onclick="window.location='<%=wpage.getUrl()%>';">Regresar</button>
                        <button type="submit" >Guardar Excel</button> 
                    </form>
                    <%
                            }


                        }
                    } else { //step 2 


                        HashMap<String, Persona> hm = new HashMap<String, Persona>(); // cvs encontrados
                        HashMap<String, Persona> hmfiltro = new HashMap<String, Persona>();
                        HashMap<String, String> hmorder = new HashMap<String, String>(); //


                        boolean aplica = Boolean.FALSE;
                        long acum = 0, acumno = 0;
                        // filtrado por genero
                        Iterator<Persona> itper = Persona.ClassMgr.listPersonas(wsite);
                        while (itper.hasNext()) {
                            Persona per = itper.next();
                            User usercv = per.getOwner();
                            if (usercv != null) {
                                if (!sexo.equals("2")) {  // para saber si se van a contar por genero o no
                                    if (sexo.equals("1") && per.isGenero()) {  //femenino en true
                                        hm.put(per.getId(), per);
                                    } else if (sexo.equals("0") && !per.isGenero()) {  //masculino en false
                                        hm.put(per.getId(), per);
                                        hmorder.put(usercv.getFullName() != null ? usercv.getFullName() : usercv.getLogin(), usercv.getId());
                                    }
                                } else {  //genero indistinto
                                    hm.put(per.getId(), per);
                                    hmorder.put(usercv.getFullName() != null ? usercv.getFullName() : usercv.getLogin(), usercv.getId());
                                }
                            }
                        }

                        // filtro por edo civil
                        if (!edocivil.equals("2")) {
                            hmfiltro = new HashMap<String, Persona>();
                            hmorder = new HashMap<String, String>();
                            itper = hm.values().iterator();
                            while (itper.hasNext()) {
                                Persona per = itper.next();
                                User usercv = per.getOwner();
                                if (edocivil.equals("1")) {
                                    if (per.isCasado()) {  // está casado
                                        hmfiltro.put(per.getId(), per);
                                        hmorder.put(usercv.getFullName() != null ? usercv.getFullName() : usercv.getLogin(), usercv.getId());
                                    }
                                } else if (edocivil.equals("0")) {
                                    if (!per.isCasado()) {  // no está casado
                                        hmfiltro.put(per.getId(), per);
                                        hmorder.put(usercv.getFullName() != null ? usercv.getFullName() : usercv.getLogin(), usercv.getId());
                                    }
                                }
                            }
                            hm = hmfiltro;
                        }

                        // filtro hijos
                        if (!hijos.equals("")) {
                            hmfiltro = new HashMap<String, Persona>();
                            hmorder = new HashMap<String, String>();
                            itper = hm.values().iterator();
                            while (itper.hasNext()) {
                                Persona per = itper.next();
                                User usercv = per.getOwner();
                                if (hijos.equals("1")) {  // con hijos
                                    if (!numhijos.equals("")) {  // con un determinado numero de hijos
                                        int i_numhijos = 0;
                                        try {
                                            i_numhijos = Integer.parseInt(numhijos);
                                        } catch (Exception e) {
                                            i_numhijos = 0;
                                        }
                                        if (i_numhijos > 0) {
                                            int cuentahijos = 0;
                                            Iterator<Familia> itfam = per.listFamilias();
                                            while (itfam.hasNext()) {
                                                Familia fam = itfam.next();
                                                if (fam.getParentesco().equals("son")) {
                                                    cuentahijos++;
                                                }
                                            }
                                            if (cuentahijos >= i_numhijos) {  // tiene los hijos solicitados o más
                                                hmfiltro.put(per.getId(), per);
                                                hmorder.put(usercv.getFullName() != null ? usercv.getFullName() : usercv.getLogin(), usercv.getId());
                                            }
                                        }
                                    } else {  // usuario que por lo menos con hijos sin importar el numero de hijos
                                        Iterator<Familia> itfam = per.listFamilias();
                                        while (itfam.hasNext()) {
                                            Familia fam = itfam.next();
                                            if (fam.getParentesco().equals("son")) {  // tiene por lo menos un hijo
                                                hmfiltro.put(per.getId(), per);
                                                hmorder.put(usercv.getFullName() != null ? usercv.getFullName() : usercv.getLogin(), usercv.getId());
                                                break;
                                            }
                                        }
                                    }
                                } else if (hijos.equals("0")) {  // sin hijos
                                    Iterator<Familia> itfam = per.listFamilias();
                                    if (!itfam.hasNext()) {
                                        hmfiltro.put(per.getId(), per);
                                        hmorder.put(usercv.getFullName() != null ? usercv.getFullName() : usercv.getLogin(), usercv.getId());
                                    } else {
                                        boolean familiar = false;
                                        while (itfam.hasNext()) {
                                            Familia fam = itfam.next();
                                            if (fam.getParentesco().equals("son")) {
                                                familiar = true;
                                                break;
                                            }
                                        }
                                        if (!familiar) {  // no tiene familiar que sea hijo o hija
                                            hmfiltro.put(per.getId(), per);
                                            hmorder.put(usercv.getFullName() != null ? usercv.getFullName() : usercv.getLogin(), usercv.getId());
                                        }
                                    }
                                }
                            }
                            hm = hmfiltro;  // filtro hijos

                            if (!edadfiltro.equals("0") && !edad.equals("")) {
                                hmfiltro = new HashMap<String, Persona>();
                                hmorder = new HashMap<String, String>();
                                itper = hm.values().iterator();
                                while (itper.hasNext()) {
                                    Persona per = itper.next();
                                    User usercv = per.getOwner();
                                    if (hijos.equals("1")) {  // con hijos
                                        String operador = edadfiltro;
                                        Iterator<Familia> itfam = per.listFamilias();
                                        while (itfam.hasNext()) {
                                            Familia fam = itfam.next();
                                            if (fam.getParentesco().equals("son")) {
                                                boolean cumple = calculaEdad(fam, operador, edad);
                                                if (cumple) {
                                                    hmfiltro.put(per.getId(), per);
                                                    hmorder.put(usercv.getFullName() != null ? usercv.getFullName() : usercv.getLogin(), usercv.getId());
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            hm = hmfiltro;
                        }
                        acum = SWBUtils.Collections.sizeOf(hm.keySet().iterator());
                        String reptype = request.getParameter("reptype");
                        String reporte = "";

                        reporte = listReport(hm, hmorder, "Genero, Estado Civil, Hijos", txtCriteria, paramRequest, request);


                        out.println(reporte);

                        /////////////////////////
                        if (!export.equals("excel") && (acum > 0 || acumno > 0)) {
                            SWBResourceURL urlExport = paramRequest.getRenderUrl();
                            urlExport.setCallMethod(SWBResourceURL.Call_DIRECT);
                            urlExport.setMode(MODE_EXPORT);
                    %>
                    <form action="<%=urlExport.toString()%>" method="post">
                        <input type="hidden" name="sexo" value="<%=sexo%>">
                        <input type="hidden" name="edocivil" value="<%=edocivil%>">
                        <input type="hidden" name="hijos" value="<%=hijos%>">
                        <input type="hidden" name="numhijos" value="<%=numhijos%>">
                        <input type="hidden" name="edadfiltro" value="<%=edadfiltro%>">
                        <input type="hidden" name="edad" value="<%=edad%>">
                        <input type="hidden" name="export" value="excel">
                        <%
                            if (request.getParameter("step") != null) {
                        %>
                        <input type="hidden" name="step" value="<%=request.getParameter("step")%>">
                        <%
                            }
                            if (request.getParameter("act") != null) {
                        %>
                        <input type="hidden" name="act" value="<%=request.getParameter("act")%>">
                        <%
                            }
                            if (request.getParameter("reptype") != null) {
                        %>
                        <input type="hidden" name="reptype" value="<%=request.getParameter("reptype")%>">
                        <%
                            }
                        %>

                        <button type="button" onclick="window.location='<%=wpage.getUrl()%>';">Regresar</button>
                        <button type="submit" >Guardar Excel</button>
                    </form>
                    <%
                                }

                            }

                        }
                    %>  
                </span></div>
        </div><!-- icv-data -->  
    </div>
</div>

<%!
    public String listReport(HashMap<String, Persona> hm, HashMap<String, String> hmorder, String txttype, String criteria, SWBParamRequest paramRequest, HttpServletRequest request) {
        StringBuilder ret = new StringBuilder();
        String export = request.getParameter("export");
        if (null == export) {
            export = "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        WebSite wsite = paramRequest.getWebPage().getWebSite();
        ret.append("<script type=\"text/javascript\">");
        ret.append(" function newWin(url){");
        ret.append("    window.open(url,'CVI','menubar=0,location=0,scrollbars=1,width=650,height=600');");
        ret.append("}");
        ret.append("</script>");

        ret.append("        <table>");
        ret.append("        <caption>");
        ret.append(txttype);
        ret.append(" que contengan:<br/> ");
        ret.append(criteria);
        ret.append("        </caption>");
        ret.append("            <thead>");
        ret.append("                <tr>");
        ret.append("                    <th>Usuario</th><th>Casado</th><th>Num. Hijos</th><th>Hijos</th><th>Fecha nacimiento</th><th>Detalle</th>");
        ret.append("                </tr>");
        ret.append("            </thead>");
        ret.append("            <tbody>");

        WebSite ws = paramRequest.getWebPage().getWebSite();

        ArrayList<String> list = new ArrayList(hmorder.keySet());
        Collections.sort(list);

        Iterator<String> itstr = list.iterator();
        while (itstr.hasNext()) {
            String key = itstr.next();
            String keyorder = hmorder.get(key);

            User usrcv = wsite.getUserRepository().getUser(keyorder);
            if(usrcv==null) continue; 

            Persona per = Persona.ClassMgr.getPersona(usrcv.getId(), ws); 
            if(per==null) per = Persona.ClassMgr.createPersona(usrcv.getId(), ws);
            String casado = per.isCasado() ? "Sí" : "No";
            Iterator<Familia> itfam = per.listFamilias();
            int numhijos = 0;
            HashMap<String, String> hmsons = new HashMap<String, String>();
            while (itfam.hasNext()) {
                Familia myfam = itfam.next();
                if (null != myfam) {
                    if (myfam.getParentesco() != null && myfam.getParentesco().equals("son")) {
                        numhijos++;
                        hmsons.put(myfam.getNombre(), myfam.getNacimiento() != null ? sdf.format(myfam.getNacimiento()) : "No disponible");
                    }
                }
            }

            WebPage wpage = wsite.getWebPage("ver_CV");
            ret.append("                 <tr>");
            ret.append("                     <td>");
            if (usrcv == null) {
                continue;
            }
            String fullname = usrcv.getFullName();
            if (fullname == null) {
                fullname = usrcv.getFirstName() != null ? usrcv.getFirstName() : "" + usrcv.getLastName() != null ? usrcv.getLastName() : "";
                if (fullname == null || fullname.trim().length() == 0) {
                    fullname = usrcv.getLogin();
                }
            }
            ret.append(fullname);
            ret.append("                     </td>");
            ret.append("<td>");  //edo. civil
            ret.append(casado);
            ret.append("                     </td>");
            ret.append("<td>");  // numero de hijos
            ret.append(numhijos);
            ret.append("                     </td>");
            ret.append("<td>");  // nombre de hijos
            Iterator<String> itson = hmsons.keySet().iterator();
            while (itson.hasNext()) {
                String nombre = itson.next();
                ret.append(nombre);
                if (itson.hasNext()) {
                    ret.append("<br/>");
                }
            }
            ret.append("                     </td>");
            ret.append("<td>");  // fecha de nacimiento de hijos
            itson = hmsons.keySet().iterator();
            while (itson.hasNext()) {
                String nombre = itson.next();
                ret.append(hmsons.get(nombre));
                if (itson.hasNext()) {
                    ret.append("<br/>");
                }
            }
            ret.append("                     </td>");
            ret.append("<td>");
            if (!export.equals("excel")) {
                ret.append("<a href=\"#\" ");
                ret.append("onclick=\"javascript:newWin('");
                ret.append(wpage.getUrl() + "?id=" + usrcv.getId());
                ret.append("');return false;\" target=\"_blank\">ver</a>");
            } else {
                ret.append("&nbsp;");
            }
            ret.append("                   </td>");
            ret.append("                  </tr>");
        }
        ret.append("               </tbody>");
        ret.append("          </table>");

        return ret.toString();
    }

    boolean calculaEdad(Familia fam, String operador, String edad) {
        boolean cumple = false;
        int i_edad = 0;
        try {
            i_edad = Integer.parseInt(edad);
        } catch (Exception e) {
            i_edad = -1;
        }
        if (fam.getNacimiento() != null && i_edad != -1) {
            Calendar today = Calendar.getInstance();
            Calendar fechaNac = Calendar.getInstance();
            fechaNac.setTime(fam.getNacimiento());

            int diff_year = today.get(Calendar.YEAR) - fechaNac.get(Calendar.YEAR);
            int diff_month = today.get(Calendar.MONTH) - fechaNac.get(Calendar.MONTH);
            int diff_day = today.get(Calendar.DAY_OF_MONTH) - fechaNac.get(Calendar.DAY_OF_MONTH);

            //Si está en ese año pero todavía no los ha cumplido
            if (diff_month < 0 || (diff_month == 0 && diff_day < 0)) {
                diff_year = diff_year - 1;
            }
            //diff_year;
            if (operador.equals("=")) {
                if (diff_year == i_edad) {
                    cumple = true;
                }
            } else if (operador.equals("<")) {
                if (diff_year < i_edad) {
                    cumple = true;
                }
            } else if (operador.equals("<=")) {
                if (diff_year <= i_edad) {
                    cumple = true;
                }
            } else if (operador.equals(">")) {
                if (diff_year > i_edad) {
                    cumple = true;
                }
            } else if (operador.equals(">=")) {
                if (diff_year >= i_edad) {
                    cumple = true;
                }
            } else if (operador.equals("<>")) {
                if (diff_year != i_edad) {
                    cumple = true;
                }
            } else {
                cumple = false;
            }
        }

        return cumple;
    }

%>