<%--   
    Document   : view Recurso ExperienciaLaboralResource
    Created on : 15/02/2012
    Author     : carlos.ramos
--%>
<%@page import="com.infotec.cvi.swb.*"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Locale"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.semanticwb.model.User"%>
<%@page import="org.semanticwb.model.Role"%>
<%@page import="org.semanticwb.model.WebSite"%>
<%@page import="org.semanticwb.model.WebPage"%>
<%@page import="org.semanticwb.model.Resource"%> 
<%@page import="org.semanticwb.model.SWBComparator"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="org.semanticwb.SWBUtils"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest" />
<%
    User usr = paramRequest.getUser();
    if(!usr.isSigned())
        return;

    WebPage wpage = paramRequest.getWebPage(); 
    WebSite wsite = wpage.getWebSite();

    final String lang = usr.getLanguage();
    Locale locale = new Locale(lang,(usr.getCountry()==null?"MX":usr.getCountry()));

    Role role=null;

    CV cv = CV.ClassMgr.getCV(usr.getId(), wsite);

    long intSize = SWBUtils.Collections.sizeOf(cv.listExperienciaLaborals());
    Iterator<ExperienciaLaboral> itga = cv.listExperienciaLaborals();
    Resource base = paramRequest.getResourceBase();
    String strNumItems = base.getAttribute("numPageItems", "10");
    String npage = request.getParameter("page");
    String orderby = request.getParameter("order");
    String action = request.getParameter("act");

    int numPages = 10;
    try {
        numPages = Integer.parseInt(strNumItems);
    } catch (Exception e) {
        numPages = 10;
    }

    if (action == null) {
        action = "";
    }

    if(request.getParameter("alertmsg")!=null)
    {
        String strMsg = request.getParameter("alertmsg");
        strMsg = strMsg.replace("<br/>", "\\n\\r");
%>
<script type="text/javascript">
    alert('<%=strMsg%>');
</script>
<%
    }
%>
<div >  
<div id="icv">
<%@include file="../menucvi.jsp"%>
<div id="icv-data">
<%
    if(action.equals(""))
    {
            SWBResourceURL urlnoaplica = paramRequest.getActionUrl();
            urlnoaplica.setAction("updateNoAplica");
            boolean booNoAplica = cv.isSinExperiencia();
            String strChecked ="";
            if(booNoAplica)  strChecked ="checked";

%>
<script type="text/javascript">
    function updNoAplica(forma)
    {
        forma.action='<%=urlnoaplica%>?noAplica='+forma.noAplica.checked;
        forma.submit();       
    }
</script>
<div id="icv-noaplica">
<form action="" method="post">
<label for="noAplica">No cuento con Experiencia Laboral</label>
<input type="checkbox" id="noAplica" name="noAplica" onclick="updNoAplica(this.form)" value="1" <%=strChecked%>/>
</form>
</div>

<table class="icv-table">
    <thead>
        <tr>
            <th>&nbsp;</th>
            <th>Actual</th>
            <th>Empresa</th>
            <th>Sector</th>
            <th>Fecha inicial</th>
            <th>Fecha final</th>
            <th>Puesto</th>
            <th>Funciones principales</th>
            <th>Nombre y puesto del jefe inmediato</th>
            <th>Teléfono</th>
        </tr>
    </thead>
    <tbody>

<%
        //PAGINACION
        int ps = numPages;
        long l = intSize;

        int p = 0;
        if (npage != null) {
            p = Integer.parseInt(npage);
        }
        int x = 0;
        if (l == 0) {
%>
    <tr >
        <td colspan="10" >No se encontraron registros</td>
    </tr>
<%    
        }else {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy", locale);
            SWBResourceURL urldel = paramRequest.getActionUrl().setAction(SWBResourceURL.Action_REMOVE);
            SWBResourceURL urledit = paramRequest.getRenderUrl().setParameter("act",SWBResourceURL.Action_EDIT);
            while (itga.hasNext()) {
                ExperienciaLaboral ga = itga.next();

                //PAGINACION ////////////////////
                if (x < p * ps) {
                    x++;
                    continue;
                }
                if (x == (p * ps + ps) || x == l) {
                    break;
                }
                x++;
                /////////////////////////////////
                urldel.setParameter("id",ga.getId());   
                urledit.setParameter("id",ga.getId());                     
        %>
    <tr>
        <td>
            <span class="icv-borrar"><a href="javascript:if(confirm('¿Deseas eliminar este registro?')){window.location.href='<%=urldel%>';}" title="eliminar registro">&nbsp;</a></span>
            <span class="icv-editar"><a href="javascript:window.location.href='<%=urledit%>'" title="editar registro">&nbsp;</a></span>
        </td>
        <td><%=(ga.isActual()?"x":"")%></td>
        <td><%=ga.getEmpresa()%></td>
        <td><%=(ga.getSector()==null?"---":(ga.getSector().getTitle()==null?"---":ga.getSector().getTitle()))%></td>
        <td><%=sdf.format(ga.getFechaIni())%></td>
        <td><%=(ga.getFechaFin()!=null?sdf.format(ga.getFechaFin()):"")%></td>
        <td><%=ga.getCargo()%></td>
        <td><%=ga.getFuncionesPrincipales()%></td>
        <td><%=(ga.getJefe()==null?"---":ga.getJefe())%></td>
        <td>
            <%=(ga.getTelefono()==null?"":(ga.getTelefono().getLada()==0?"":"("+ga.getTelefono().getLada()+")"))%>
            <%=(ga.getTelefono()==null?"---":(ga.getTelefono().getNumero()==0?"":ga.getTelefono().getNumero()))%>
            <%=(ga.getTelefono()==null?"":(ga.getTelefono().getExtension()==0?"":" ext."+ga.getTelefono().getExtension()))%>
        </td>
    </tr>
<%
            }
        }
%>
    </tbody>
</table>
<div class="paginar">
    <p>
<%
        if (p > 0 || x < l) //Requiere paginacion
        {
            int pages = (int) (l / ps);
            if ((l % ps) > 0) {
                pages++;
            }

            int inicia = 0;
            int finaliza = pages;
            int rangoinicial = p - 5;
            int rangofinal = p + 5;
            if (pages <= 10) {
                inicia = 0;
                finaliza = pages;
            }else {
                if(rangoinicial < 0) {
                    inicia = 0;
                    finaliza = Math.abs(rangoinicial) + rangofinal;
                }else if (rangofinal > pages) {
                    inicia = pages - 10;
                    finaliza = pages;
                }else {
                    inicia = rangoinicial;
                    finaliza = rangofinal;
                }
            }

            if(pages > 10) {
                SWBResourceURL urlNext = paramRequest.getRenderUrl();                        
                urlNext.setParameter("page", "" + 0);                                               
                out.println("<a href=\"#\" onclick=\"window.location='" + urlNext + "';\">Ir al inicio</a> ");
            }

            for(int z = inicia; z < finaliza; z++) {
                SWBResourceURL urlNext = paramRequest.getRenderUrl();                        
                urlNext.setParameter("page", "" + z);                       

                if(z != p) {
                    out.println("<a href=\"#\" onclick=\"window.location='" + urlNext + "';\">" + (z + 1) + "</a> ");
                }else {
                    out.println((z + 1) + " ");
                }
            }
            
            if(pages>10) {
                SWBResourceURL urlNext = paramRequest.getRenderUrl();                        
                urlNext.setParameter("page", "" +(pages-1));                                                
                out.println("<a href=\"#\" onclick=\"window.location='" + urlNext + "';\">Ir al final</a> ");
            }
        }
        SWBResourceURL urladd = paramRequest.getRenderUrl();
        urladd.setParameter("act",SWBResourceURL.Action_ADD);
%>
    </p>
</div>
<p class="icv-txt"><a href="<%=urladd%>" title="Agregar registro">Agregar</a></p>    
 <%
    }else if(SWBResourceURL.Action_ADD.equals(action)) {
        SWBResourceURL urladd = paramRequest.getActionUrl();
        urladd.setAction(SWBResourceURL.Action_ADD);  
 %>         
<script type="text/javascript">
<!--
    dojo.require("dijit.layout.ContentPane");
    dojo.require("dijit.form.Form");
    dojo.require("dijit.form.ValidationTextBox");
    dojo.require("dijit.form.Button");
    dojo.require("dijit.form.FilteringSelect");
    dojo.require('dijit.form.Textarea');
    dojo.require('dijit.form.DateTextBox');

    function enviar() {
        var objd=dijit.byId('form1ga');
        if(objd.validate() && !isEmpty(dojo.byId('mfncs').value))
        {
            return true;
        }else {
            alert("Datos incompletos o incorrectos");
        }
        return false;
    }
    /*function isEmpty(objid) {
        var obj = dojo.byId(objid);
        if (obj==null || obj.value=='' || isNaN(obj.value) || obj.value.charAt(0) == ' ') {
            return true;
        }else {
            return false;
        }
    }*/
-->
</script>
<form id="form1ga" method="post" dojoType="dijit.form.Form" action="<%=urladd%>">
 <div class="icv-div-grupo">
  <p class="icv-3col"><label>Trabajo actual <input type="checkbox" name="cur" value="1"/></label></p>
  <p class="icv-3col"><label><em>*</em>Empresa</label><input type="text" name="emp" value="" dojoType="dijit.form.ValidationTextBox" required="true" promptMessage="Nombre de la empresa" invalidMessage="El nombre de la empresa es requerido"/></p>  
  <p class="icv-3col">
   <label><em>*</em>Sector</label>
   <select name="sctr" id="idsctr" dojoType="dijit.form.FilteringSelect" required="true">
    <option value="" selected="selected">Seleccione...</option>
<%
        Iterator<Sector> sectors = Sector.ClassMgr.listSectors(wsite);
        while(sectors.hasNext()) {
        Sector sector = sectors.next();
%>
            <option value="<%=sector.getId()%>"><%=sector.getDisplayTitle(lang)%></option>
<%
        }
%>
   </select>
  </p>
  <div class="clearer">&nbsp;</div>
 </div>
  <div class="icv-div-grupo">
  <p class="icv-3col"><label><em>*</em>Fecha inicial</label><input type="text" name="fi" value="" dojoType="dijit.form.DateTextBox" required="true" constraints="{datePattern:'dd/MM/yyyy'}" maxlength="10" hasDownArrow="true"/></p>
  <p class="icv-3col"><label>Fecha final</label><input type="text" name="ff" value="" dojoType="dijit.form.DateTextBox" required="false" constraints="{datePattern:'dd/MM/yyyy'}" maxlength="10" hasDownArrow="true"/></p>
  <p class="icv-3col"><label><em>*</em>Puesto</label><input type="text" name="crg" value="" dojoType="dijit.form.ValidationTextBox" required="true" promptMessage="Puesto ocupado" invalidMessage="El nombre del puesto es requerido"/></p>
  <div class="clearer">&nbsp;</div>
 </div>
  <div class="icv-div-grupo">
  <p class="icv-3col"><label><em>*</em>Funciones principales</label><textarea name="mfncs" id="mfncs" cols="34" rows="3"></textarea></p>
  <p class="icv-3col"><label>Nombre y puesto del jefe inmediato</label><input type="text" name="jf" value="" dojoType="dijit.form.ValidationTextBox" promptMessage="Nombre y puesto del jefe inmediato" /></p>
  <p class="icv-3col"><label>Tel&eacute;fono (clave lada, n&uacute;mero, extensi&oacute;n)</label>
   <input type="text" name="cve" value="" size="3" maxlength="3" style="width:50px;float:left" dojoType="dijit.form.ValidationTextBox" promptMessage="Clave lada" invalidMessage="Clave lada incorrecta" regExp="\d{2,3}" />&nbsp;
   <input type="text" name="tf" value="" size="8" maxlength="8" style="width:80px;float:left" dojoType="dijit.form.ValidationTextBox" promptMessage="Numero telefonico" invalidMessage="Numero telefonico incorrecto" regExp="\d{7,8}" />&nbsp;
   <input type="text" name="ext" value="" size="5" maxlength="5" style="width:60px;float:left" dojoType="dijit.form.ValidationTextBox" promptMessage="Extension telefonica" invalidMessage="Extension telefonica incorrecta" regExp="\d{1,5}" />
  </p>
  <div class="clearer">&nbsp;</div>
 </div>
 <div class="centro">
     <%
    SWBResourceURL urlBack = paramRequest.getRenderUrl();
    urlBack.setParameter("act", "");
%>
        <input type="button" name="regresar" id="regresar" value="Regresar" onclick="window.location='<%=urlBack%>'; return false;"/>
  <input type="submit" name="guardar" id="guardar" value="Guardar" onclick="return enviar()"/>
 </div>
</form>   
<%
    }else if(SWBResourceURL.Action_EDIT.equals(action)) {
        String id = request.getParameter("id");

        ExperienciaLaboral gradoAca = ExperienciaLaboral.ClassMgr.getExperienciaLaboral(id, wsite);
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", locale);

        SWBResourceURL urladd = paramRequest.getActionUrl();
        urladd.setAction(SWBResourceURL.Action_EDIT);
        urladd.setParameter("id", id);
 %>         
<script type="text/javascript">
<!--
    dojo.require("dijit.layout.ContentPane");
    dojo.require("dijit.form.Form");
    dojo.require("dijit.form.ValidationTextBox");
    dojo.require("dijit.form.Button");
    dojo.require("dijit.form.FilteringSelect");
    dojo.require('dijit.form.Textarea');
    dojo.require('dijit.form.DateTextBox');

    function enviar() {
        var objd=dijit.byId('form2ga');
        if(objd.validate() && !isEmpty(dojo.byId('mfncs').value))
        {
            return true;
        }else {
            alert("Datos incompletos o incorrectos");
        }
        return false;
    }
    /*function isEmpty(objid) {
        var obj = dojo.byId(objid);
        if (obj==null || obj.value=='' || isNaN(obj.value) || obj.value.charAt(0) == ' ') {
            return true;
        }else {
            return false;
        }
    }*/
-->
</script>
<form id="form2ga" method="post" dojoType="dijit.form.Form" action="<%=urladd%>">
 <div class="icv-div-grupo">
  <p class="icv-3col"><label>Trabajo actual <input type="checkbox" name="cur" value="1" <%=(gradoAca.isActual()?"checked=\"checked\"":"")%> /></label></p>
  <p class="icv-3col"><label><em>*</em>Empresa</label><input type="text" name="emp" value="<%=gradoAca.getEmpresa()%>" dojoType="dijit.form.ValidationTextBox" required="true" promptMessage="Nombre de la empresa" invalidMessage="El nombre de la empresa es requerido"/></p>  
  <p class="icv-3col">
   <label><em>*</em>Sector</label>
   <select name="sctr" id="idsctr" dojoType="dijit.form.FilteringSelect" required="true">
<%
        Iterator<Sector> sectors = Sector.ClassMgr.listSectors(wsite);
        while(sectors.hasNext()) {
            Sector sector = sectors.next();
            if(sector.equals(gradoAca.getSector())) {
                %>
                <option value="<%=sector.getId()%>" selectted="selected"><%=sector.getDisplayTitle(lang)%></option>
                <%
            }else {
                %>
                <option value="<%=sector.getId()%>"><%=sector.getDisplayTitle(lang)%></option>
                <%
            }
        }
%>
   </select>
  </p>
  <div class="clearer">&nbsp;</div>
 </div>
  <div class="icv-div-grupo">
  <p class="icv-3col"><label><em>*</em>Fecha inicial</label><input type="text" name="fi" value="<%=sdf.format(gradoAca.getFechaIni())%>" dojoType="dijit.form.DateTextBox" required="true" constraints="{datePattern:'dd/MM/yyyy'}" maxlength="10" hasDownArrow="true"/></p>
  <p class="icv-3col"><label>Fecha final</label><input type="text" name="ff" value="<%=(gradoAca.getFechaFin()!=null?sdf.format(gradoAca.getFechaFin()):"")%>" dojoType="dijit.form.DateTextBox" required="false" constraints="{datePattern:'dd/MM/yyyy'}" maxlength="10" hasDownArrow="true"/></p>
  <p class="icv-3col"><label><em>*</em>Puesto</label><input type="text" name="crg" value="<%=gradoAca.getCargo()%>" dojoType="dijit.form.ValidationTextBox" required="true" promptMessage="Puesto ocupado" invalidMessage="El nombre del puesto es requerido"/></p>
  <div class="clearer">&nbsp;</div>
 </div>
  <div class="icv-div-grupo">
  <p class="icv-3col"><label><em>*</em>Funciones principales</label><textarea name="mfncs" id="mfncs" cols="34" rows="3"><%=gradoAca.getFuncionesPrincipales()%></textarea></p>
  <p class="icv-3col"><label>Nombre y puesto del jefe inmediato</label><input type="text" name="jf" value="<%=gradoAca.getJefe()%>" /></p>
  <p class="icv-3col"><label>Tel&eacute;fono (clave lada, n&uacute;mero, extensi&oacute;n)</label>
   <input type="text" name="cve" size="3" maxlength="3" style="width:50px;float:left" value="<%=(gradoAca.getTelefono()==null?"":(gradoAca.getTelefono().getLada()==0?"":gradoAca.getTelefono().getLada()))%>" dojoType="dijit.form.ValidationTextBox" promptMessage="Clave lada" invalidMessage="Clave lada incorrecta" regExp="\d{2,3}" />&nbsp;
   <input type="text" name="tf" size="8" maxlength="8" style="width:80px;float:left" value="<%=(gradoAca.getTelefono()==null?"":(gradoAca.getTelefono().getNumero()==0?"":gradoAca.getTelefono().getNumero()))%>" dojoType="dijit.form.ValidationTextBox" promptMessage="Numero telefonico" invalidMessage="Numero telefonico incorrecto" regExp="\d{7,8}" />&nbsp;
   <input type="text" name="ext" size="5" maxlength="5" style="width:60px;float:left" value="<%=(gradoAca.getTelefono()==null?"":(gradoAca.getTelefono().getExtension()==0?"":gradoAca.getTelefono().getExtension()))%>" dojoType="dijit.form.ValidationTextBox" promptMessage="Extension telefonica" invalidMessage="Extension telefonica incorrecta" regExp="\d{1,5}" />
  </p>
  <div class="clearer">&nbsp;</div>
 </div>
 <div class="centro">
     <%
    SWBResourceURL urlBack = paramRequest.getRenderUrl();
    urlBack.setParameter("act", "");
%>
        <input type="button" name="regresar" id="regresar" value="Regresar" onclick="window.location='<%=urlBack%>'; return false;"/>
  <input type="submit" name="guardar" id="guardar" value="Guardar" onclick="return enviar()"/>
 </div>
</form>   
<%         
          }
%>
</div><!-- icv-data -->  
</div>
</div>