<%--   
    Document   : view Recurso AreasTalentoResource
    Created on : 16/02/2012
    Author     : carlos.ramos
--%>
<%@page import="com.infotec.cvi.swb.resources.AreasTalentoResource"%>
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
<%@page import="static com.infotec.cvi.swb.resources.AreasTalentoResource.Mode_TLNT"%>
<%@page import="static com.infotec.cvi.swb.resources.AreasTalentoResource.Mode_HBLDS"%>
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

    long intSize = SWBUtils.Collections.sizeOf(cv.listAreaTalentos());
    Iterator<AreaTalento> itga = cv.listAreaTalentos();
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
        strMsg = strMsg.replace("<br>", "\\n\\r");
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
%>
<table class="icv-table">
    <thead>
        <tr>
            <th>&nbsp;</th>
            <th>Area de talento o interes</th>
            <th>Habilidad</th>
            <th>Años de experiencia</th>
            <th>Otro</th>
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
            SWBResourceURL urldel = paramRequest.getActionUrl().setAction(SWBResourceURL.Action_REMOVE);
            SWBResourceURL urledit = paramRequest.getRenderUrl().setParameter("act",SWBResourceURL.Action_EDIT);
            while (itga.hasNext()) {
                AreaTalento talento = itga.next();

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
                urldel.setParameter("id", talento.getId());   
                urledit.setParameter("id", talento.getId());                     
        %>
    <tr>
        <td>
            <span class="icv-borrar"><a href="javascript:if(confirm('¿Deseas eliminar este registro?')){window.location.href='<%=urldel%>';}" title="eliminar registro">borrar</a></span>
            <span class="icv-editar"><a href="javascript:window.location.href='<%=urledit%>'" title="editar registro">editar</a></span>
        </td>
        <td><%=talento.getTipoAreaTalento().getTitle()%></td>
        <td><%=talento.getHabilidad().getTitle()%></td>
        <td><%=talento.getYearExperienceTalento()%></td>
        <td><%=talento.getOtraHabilidad()%></td>
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
    dojo.require('dojo.data.ItemFileReadStore');

    function enviar() {
        var objd=dijit.byId('form1ga');
        if(objd.validate())
        {
                return true;
        }else {
            alert("Datos incompletos o incorrectos");
        }
        return false;
    }
    function isEmpty(objid) {
        var obj = dojo.byId(objid);
        if (obj==null || obj.value=='' || isNaN(obj.value) || obj.value.charAt(0) == ' ') {
            return true;
        }else {
            return false;
        }
    }
-->
</script>
<form id="form1ga" method="post" dojoType="dijit.form.Form" action="<%=urladd%>">
 <div class="icv-div-grupo">
<%
    SWBResourceURL urlMS = paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT);
%>
  <div dojoType="dojo.data.ItemFileReadStore" jsId="talentos_<%=base.getId()%>" url="<%=urlMS.setMode(Mode_TLNT)%>"></div>
  <div dojoType="dojo.data.ItemFileReadStore" jsId="habilidades_<%=base.getId()%>" url="<%=urlMS.setMode(Mode_HBLDS)%>"></div>
  
  <p class="icv-3col"><label><em>*</em>Área de talento</label><input dojoType="dijit.form.FilteringSelect" value="" required="true" store="talentos_<%=base.getId()%>" name="tlnt" id="tlnt_<%=base.getId()%>" onChange="dijit.byId('hbld_<%=base.getId()%>').attr('value','');dijit.byId('hbld_<%=base.getId()%>').query.tipo = this.value || '*';" promptMessage="Talento" invalidMessage="El talento requerido" /></p>
  <p class="icv-3col"><label><em>*</em>Habilidad</label><input dojoType="dijit.form.FilteringSelect" value="" required="true" store="habilidades_<%=base.getId()%>" name="hbld" id="hbld_<%=base.getId()%>" promptMessage="Habilidad" invalidMessage="La habilidad es requerida" /></p>
  <p class="icv-3col"><label><em>*</em>Años de experiencia</label><input type="text" name="ytlnt" value="" size="3" maxlength="2" dojoType="dijit.form.ValidationTextBox" promptMessage="Registrar el tiempo en años de la experiencia" invalidMessage="Años de experiencia incorrecto" regExp="\d{1,2}" /></p>
  <p class="icv-3col"><label>En caso de otro, especificar</label><input type="text" name="othr" value="" dojoType="dijit.form.ValidationTextBox" promptMessage="En caso de elegir otra habilidad, especifcar" />
  
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

        AreaTalento talento = AreaTalento.ClassMgr.getAreaTalento(id, wsite);

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
    dojo.require('dojo.data.ItemFileReadStore');

    function enviar() {
        var objd=dijit.byId('form2ga');
        if(objd.validate())
        {
                return true;
        }else {
            alert("Datos incompletos o incorrectos");
        }
        return false;
    }
    function isEmpty(objid) {
        var obj = dojo.byId(objid);
        if (obj==null || obj.value=='' || isNaN(obj.value) || obj.value.charAt(0) == ' ') {
            return true;
        }else {
            return false;
        }
    }
    
    /*dojo.addOnLoad(
        function() {
            dijit.byId('hbld_<%=base.getId()%>').query.tipo = <%=(talento.getTipoAreaTalento().getId())%>;
        }
    );*/
-->
</script>
<form id="form2ga" method="post" dojoType="dijit.form.Form" action="<%=urladd%>">
 <div class="icv-div-grupo">
<%
    SWBResourceURL urlMS = paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT);
%>
   <div dojoType="dojo.data.ItemFileReadStore" jsId="talentos_<%=base.getId()%>" url="<%=urlMS.setMode(Mode_TLNT)%>"></div>
   <div dojoType="dojo.data.ItemFileReadStore" jsId="habilidades_<%=base.getId()%>" url="<%=urlMS.setMode(Mode_HBLDS)%>"></div>
  
   <p class="icv-3col"><label><em>*</em>Área de talento</label><input dojoType="dijit.form.FilteringSelect" value="<%=talento.getTipoAreaTalento().getId()%>" required="true" store="talentos_<%=base.getId()%>" name="tlnt" id="tlnt_<%=base.getId()%>" onChange="dijit.byId('hbld_<%=base.getId()%>').attr('value','');dijit.byId('hbld_<%=base.getId()%>').query.tipo = this.value || '*';" promptMessage="Talento" invalidMessage="El talento requerido" /></p>
   <p class="icv-3col"><label><em>*</em>Habilidad</label><input dojoType="dijit.form.FilteringSelect" value="<%=talento.getHabilidad().getId()%>" required="true" store="habilidades_<%=base.getId()%>" name="hbld" id="hbld_<%=base.getId()%>" promptMessage="Habilidad" invalidMessage="La habilidad es requerida" /></p>
   <p class="icv-3col"><label><em>*</em>Años de experiencia</label><input type="text" name="ytlnt" value="<%=talento.getYearExperienceTalento()%>" size="3" maxlength="2" dojoType="dijit.form.ValidationTextBox" promptMessage="Registrar el tiempo en años de la experiencia" invalidMessage="Años de experiencia incorrecto" regExp="\d{1,2}" /></p>
   <p class="icv-3col"><label><em>*</em>En caso de otro, especificar</label><input type="text" name="othr" value="<%=talento.getOtraHabilidad()%>" dojoType="dijit.form.ValidationTextBox" promptMessage="En caso de elegir otra habilidad, especifcar" />
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
<script type="text/javascript">
<!--
    dojo.addOnLoad(
        function() {
            dijit.byId('hbld_<%=base.getId()%>').query.tipo = <%=(talento.getTipoAreaTalento().getId())%>;
        }
    );
-->
</script>
<%         
          }
%>
</div><!-- icv-data -->  
</div>
</div>