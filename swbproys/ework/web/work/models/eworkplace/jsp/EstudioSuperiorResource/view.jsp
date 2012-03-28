<%--   
    Document   : view Recurso EstudioSuperiorResource
    Created on : 09/02/2012
    Author     : juan.fernandez
--%>

<%@page import="java.util.Collections"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.infotec.cvi.swb.Estudios"%>
<%@page import="com.infotec.cvi.swb.Avance"%>
<%@page import="com.infotec.cvi.swb.EstudioSuperior"%>
<%@page import="com.infotec.cvi.swb.SituacionAcademica"%>
<%@page import="org.semanticwb.model.WebPage"%>
<%@page import="com.infotec.cvi.swb.GradoAcademico"%>
<%@page import="com.infotec.cvi.swb.Academia"%>
<%@page import="com.infotec.cvi.swb.CV"%>
<%@page import="java.util.Set"%>
<%@page import="org.semanticwb.model.SWBComparator"%>
<%@page import="java.util.Locale"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="org.semanticwb.model.WebSite"%>

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
            Role role=null;
            
            CV cv = CV.ClassMgr.getCV(usr.getId(), wsite);
            if(cv==null) {
                cv = CV.ClassMgr.createCV(usr.getId(),wsite);
                cv.setPropietario(usr);
            }
             
            Academia aca = cv.getAcademia();
            if(aca==null){
                aca = Academia.ClassMgr.createAcademia(wsite);
                cv.setAcademia(aca);
            }
            
            long intSize = SWBUtils.Collections.sizeOf(aca.listEstudioSuperiors());
            Iterator<EstudioSuperior> itga = aca.listEstudioSuperiors();
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

            //if (orderby == null) {
            //    orderby = "date";
            //}

            if (action == null) {
                action = "";
            }

            //SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy", new Locale("es"));

            //Set<GradoAcademico> list = null;

            //String strOrder = "";
             
            //todo: ordenamiento
//            list=SWBComparator.sortByCreatedSet(GradoAcademico.ClassMgr.listG(usuario, wsite),false);



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
<%@include file="../menucvi.jsp" %>
<div id="icv-data">
<%
            if(action.equals(""))
            {
            
            SWBResourceURL urlnoaplica = paramRequest.getActionUrl();
            urlnoaplica.setAction("updateNoAplica");
            boolean booNoAplica = aca.isNoAplicaEstudioSuperior();
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
<label for="noAplica">No cuento con Estudios Superiores</label>
<input type="checkbox" id="noAplica" name="noAplica" onclick="updNoAplica(this.form)" value="1" <%=strChecked%>/>
</form>
</div>
<table class="icv-table">

    <thead>
        <tr>
            <th width="7%" >&nbsp;</th>
            <th width="35%" >Estudios Superiores</th>
            <th width="35%" >Periodo en Años</th>
            <th width="23%" >% avance</th>
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
            <td colspan="4" >No se encontraron registros</td>
        </tr>
        <%    } else {

                //Iterator<GradoAcademico> itcec = itga.iterator();
                while (itga.hasNext()) {
                    EstudioSuperior ga = itga.next();

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

                    String strAvance = "<center>---</center>"; 
                    String strEstudio = "<center>---</center>";                   
                    int strPeriodo = ga.getPeriodoYears();

                    if(ga.getGradoAvance() !=null&&ga.getGradoAvance().getTitle()!=null)
                        strAvance = ga.getGradoAvance().getTitle();
                    if(ga.getEstudiosSuperiores()!=null&&ga.getEstudiosSuperiores().getTitle()!=null){
                        Estudios estudio = ga.getEstudiosSuperiores();
                        String idarea = estudio.getAreaEstudio().getId();
                        if(estudio.getId().endsWith("_otro")&&estudio.getTitle().equals("Otro")){
                            strEstudio = "Otro / "+ga.getOtroEstudio();
                        } else strEstudio = ga.getEstudiosSuperiores().getTitle();
                    }
                          
                    
                    SWBResourceURL urldel = paramRequest.getActionUrl();
                    urldel.setAction(SWBResourceURL.Action_REMOVE);
                    urldel.setParameter("id",ga.getId());   
                    
                    SWBResourceURL urledit = paramRequest.getRenderUrl();
                    urledit.setParameter("act",SWBResourceURL.Action_EDIT);
                    urledit.setParameter("id",ga.getId());
        %>
        <tr>
            <td><span class="icv-borrar"><a href="#" onclick="if(confirm('¿Deseas eliminar este registro?')){window.location='<%=urldel%>';}">&nbsp;</a></span>
                <span class="icv-editar"><a href="#" onclick="window.location='<%=urledit%>';">&nbsp;</a></span></td>
            <td><%=strEstudio%></td>
            <td><%=strPeriodo%></td>
            <td><%=strAvance%></td>
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

                //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                
                 int inicia = 0;
                    int finaliza = pages;


                    int rangoinicial = p - 5;
                    int rangofinal = p + 5;
                    if (pages <= 10) {
                        inicia = 0;
                        finaliza = pages;
                    } else {
                        if (rangoinicial < 0) {
                            inicia = 0;
                            finaliza = Math.abs(rangoinicial) + rangofinal;
                        } else if (rangofinal > pages) {
                            inicia = pages - 10;
                            finaliza = pages;
                        } else {
                            inicia = rangoinicial;
                            finaliza = rangofinal;
                        }
                    }

                    if (pages > 10) {
                        SWBResourceURL urlNext = paramRequest.getRenderUrl();                        
                        urlNext.setParameter("page", "" + 0);                                               
                        out.println("<a href=\"#\" onclick=\"window.location='" + urlNext + "';\">Ir al inicio</a> ");
                    }

                    for (int z = inicia; z < finaliza; z++) {
                        SWBResourceURL urlNext = paramRequest.getRenderUrl();                        
                        urlNext.setParameter("page", "" + z);                       

                        if (z != p) {
                            out.println("<a href=\"#\" onclick=\"window.location='" + urlNext + "';\">" + (z + 1) + "</a> ");
                        } else {
                            out.println((z + 1) + " ");
                        }

                    }
                    if(pages>10){
                        SWBResourceURL urlNext = paramRequest.getRenderUrl();                        
                        urlNext.setParameter("page", "" +(pages-1));                                                
                        out.println("<a href=\"#\" onclick=\"window.location='" + urlNext + "';\">Ir al final</a> ");
                     }

            }
                    
                    SWBResourceURL urladd = paramRequest.getRenderUrl();
                    urladd.setParameter("act",SWBResourceURL.Action_ADD);
%>
</p></div>
<p class="icv-txt"><a href="<%=urladd%>">Agregar</a></p>    


 <%
          } else if(action.equals(SWBResourceURL.Action_ADD)) {
            //String wptitle = wpage.getDisplayName(usr.getLanguage());
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
    dojo.require("dojo.data.ItemFileReadStore"); 

    function enviar() {
        var objd=dijit.byId('form1es');
//alert(objd);
        if(objd.validate())//isValid()&&!isEmpty('idgavance')&&!isEmpty('idestudio'))
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
    
   function revisa(chk,sel,otro){
     var fltr = dijit.byId(sel);
     if(chk.checked){
         otro.disabled=false;
         otro.focus();
         fltr.setDisabled(true);
     } else {
         otro.disabled=true;
         fltr.setDisabled(false);
         fltr.domNode.focus();
     };
  }
    -->
</script>
          <form id="form1es" name="form1es" method="post"  action="<%=urladd%>" dojoType="dijit.form.Form">
    <!-- input type="hidden" name="" value="" / --> 

    <div class="icv-div-grupo">
<%          
            SWBResourceURL url = paramRequest.getRenderUrl();
            url.setCallMethod(SWBResourceURL.Call_DIRECT);
%>
            <div dojoType="dojo.data.ItemFileReadStore" jsId="tipoStore<%=base.getId()%>" url="<%=url.setMode("mod_tipo")%>"></div>
            <div dojoType="dojo.data.ItemFileReadStore" jsId="disciplinaStore<%=base.getId()%>" url="<%=url.setMode("mod_disciplina")%>"></div>
            <div dojoType="dojo.data.ItemFileReadStore" jsId="areaStore<%=base.getId()%>" url="<%=url.setMode("mod_area")%>"></div>
            <div dojoType="dojo.data.ItemFileReadStore" jsId="estudioStore<%=base.getId()%>" url="<%=url.setMode("mod_posgrado")%>"></div>

<p class="icv-3col">           
            <label for="sel_Tipo"><b>*</b>Tipo</label>             
            <input dojoType="dijit.form.FilteringSelect" value="" autoComplete="true" store="tipoStore<%=base.getId()%>" name="sel_Tipo" id="sel_Tipo<%=base.getId()%>" onChange="dijit.byId('sel_Disciplina<%=base.getId()%>').query.tipo = this.value || '*';" />        
</p>
<p class="icv-3col">           
            <label for="sel_Disciplina"><b>*</b>Disciplina</label>             
            <input dojoType="dijit.form.FilteringSelect" value="" autoComplete="true" store="disciplinaStore<%=base.getId()%>" name="sel_Disciplina" id="sel_Disciplina<%=base.getId()%>" onChange="dijit.byId('sel_Area<%=base.getId()%>').query.disciplina = this.value || '*'; dijit.byId('sel_Tipo<%=base.getId()%>').attr('value', (dijit.byId('sel_Disciplina<%=base.getId()%>').item || {tipo: ''}).tipo);"/>        
</p>
            
<p class="icv-3col">
            <label for="sel_Area"><b>*</b>Area</label>
            <input dojoType="dijit.form.FilteringSelect" value="" autoComplete="true" store="areaStore<%=base.getId()%>" name="sel_Area" id="sel_Area<%=base.getId()%>" onChange="dijit.byId('sel_Estudio<%=base.getId()%>').query.area = this.value || '*'; dijit.byId('sel_Disciplina<%=base.getId()%>').attr('value', (dijit.byId('sel_Area<%=base.getId()%>').item || {disciplina: ''}).disciplina);" />          <!-- dijit.byId('sel_Carrera<%//=base.getId()%>').attr('value',''); -->
</p>

<div class="clearer">&nbsp;</div>
</div>
  
<div class="icv-div-grupo">

<p class="icv-3col">
            <label for="sel_Estudio"><b>*</b>Estudio Superior</label>
            <input dojoType="dijit.form.FilteringSelect" value="" autoComplete="true" store="estudioStore<%=base.getId()%>" name="sel_Estudio" id="sel_Estudio<%=base.getId()%>" onChange="dijit.byId('sel_Area<%=base.getId()%>').attr('value', (dijit.byId('sel_Estudio<%=base.getId()%>').item || {area: ''}).area);" />       
</p>
<p class="icv-3col">
    <label for="chkOtro">Otro Estudio Superior</label>
    <input type="checkbox" value="1" name="chkOtro" onclick="revisa(this,'sel_Estudio<%=base.getId()%>',txtOtro)"/>
    </p>
<p class="icv-3col"><input type="text" value="" name="txtOtro" id="txtOtro" disabled="true" />
</p>
  <div class="clearer">&nbsp;</div>
</div>
  
<div class="icv-div-grupo">
  
    <p class="icv-3col">
    <label for="idgavance"><b>*</b>% avance</label>
    <select name="idgavance" id="idgavance" dojoType="dijit.form.FilteringSelect" required="true">
      <option value="" selected="selected">Seleccione...</option>
<%
    Iterator<Avance> itsit = Avance.ClassMgr.listAvances(wsite); 
        while (itsit.hasNext()) {
            Avance avance = itsit.next();
            %>
            <option value="<%=avance.getId()%>"><%=avance.getDisplayTitle(usr.getLanguage())%></option>
            <%
        }
%>
    </select>
  </p>
 
 
  <p class="icv-3col">
    <label for="periodo"><b>*</b>Periodo en años</label>
    <input type="text" name="periodo" id="periodo" maxlength="2" dojoType="dijit.form.ValidationTextBox" required="true" promptMessage="Ingrese periodo en años" regExp="\d{1,2}" />
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
          } else if(action.equals(SWBResourceURL.Action_EDIT)) {
              String id = request.getParameter("id");
              
              String wptitle = wpage.getDisplayName(usr.getLanguage());
              SWBResourceURL urladd = paramRequest.getActionUrl();
              urladd.setAction(SWBResourceURL.Action_EDIT);  
              EstudioSuperior estudioSup = EstudioSuperior.ClassMgr.getEstudioSuperior(id, wsite);
 %>
 <h3><%=wptitle%></h3>
<script type="text/javascript">
    <!--
    dojo.require("dijit.layout.ContentPane");
    dojo.require("dijit.form.Form");
    dojo.require("dijit.form.ValidationTextBox");
    dojo.require("dijit.form.Button");
    dojo.require("dijit.form.FilteringSelect");
    dojo.require("dojo.data.ItemFileReadStore"); 

    function enviar() {
        var objd=dijit.byId('form2es');
//alert(objd);
        if(objd.validate())//isValid()&&!isEmpty('idgavance')&&!isEmpty('idestudio'))
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
    
   function revisa(chk,sel,otro){
     var fltr = dijit.byId(sel);
     if(chk.checked){
         otro.disabled=false;
         otro.focus();
         fltr.setDisabled(true);
     } else {
         otro.disabled=true;
         fltr.setDisabled(false);
         fltr.domNode.focus();
     };
  }

    -->
</script>
          <form id="form2es" name="form2es" method="post" action="<%=urladd%>"  dojoType="dijit.form.Form">
    <input type="hidden" name="id" value="<%=id%>" /> 
    
    <div class="icv-div-grupo">
<%          
            SWBResourceURL url = paramRequest.getRenderUrl();
            url.setCallMethod(SWBResourceURL.Call_DIRECT);
            String idEstudio = estudioSup.getEstudiosSuperiores().getId();
            String idArea = estudioSup.getEstudiosSuperiores().getAreaEstudio().getId();
            String idDisciplina = estudioSup.getEstudiosSuperiores().getAreaEstudio().getDisciplinaInv().getId();
            String idTipo = estudioSup.getEstudiosSuperiores().getAreaEstudio().getDisciplinaInv().getTipoEstudioInv().getId();
%>
            <div dojoType="dojo.data.ItemFileReadStore" jsId="tipoStore<%=base.getId()%>" url="<%=url.setMode("mod_tipo")%>"></div>
            <div dojoType="dojo.data.ItemFileReadStore" jsId="disciplinaStore<%=base.getId()%>" url="<%=url.setMode("mod_disciplina")%>"></div>
            <div dojoType="dojo.data.ItemFileReadStore" jsId="areaStore<%=base.getId()%>" url="<%=url.setMode("mod_area")%>"></div>
            <div dojoType="dojo.data.ItemFileReadStore" jsId="estudioStore<%=base.getId()%>" url="<%=url.setMode("mod_posgrado")%>"></div>

<p class="icv-3col">           
            <label for="sel_Tipo"><b>*</b>Tipo</label>             
            <input dojoType="dijit.form.FilteringSelect" value="<%=idTipo%>" autoComplete="true" store="tipoStore<%=base.getId()%>" name="sel_Tipo" id="sel_Tipo<%=base.getId()%>" onChange="dijit.byId('sel_Disciplina<%=base.getId()%>').query.tipo = this.value || '*';" />        
</p>
<p class="icv-3col">           
            <label for="sel_Disciplina"><b>*</b>Disciplina</label>             
            <input dojoType="dijit.form.FilteringSelect" value="<%=idDisciplina%>" autoComplete="true" store="disciplinaStore<%=base.getId()%>" name="sel_Disciplina" id="sel_Disciplina<%=base.getId()%>" onChange="dijit.byId('sel_Area<%=base.getId()%>').query.disciplina = this.value || '*'; dijit.byId('sel_Tipo<%=base.getId()%>').attr('value', (dijit.byId('sel_Disciplina<%=base.getId()%>').item || {tipo: ''}).tipo);" />        
</p>
            
<p class="icv-3col">
            <label for="sel_Area"><b>*</b>Area</label>
            <input dojoType="dijit.form.FilteringSelect" value="<%=idArea%>" autoComplete="true" store="areaStore<%=base.getId()%>" name="sel_Area" id="sel_Area<%=base.getId()%>" onChange="dijit.byId('sel_Estudio<%=base.getId()%>').query.area = this.value || '*'; dijit.byId('sel_Disciplina<%=base.getId()%>').attr('value', (dijit.byId('sel_Area<%=base.getId()%>').item || {disciplina: ''}).disciplina);" />          <!-- dijit.byId('sel_Carrera<%//=base.getId()%>').attr('value',''); -->
</p>
<div class="clearer">&nbsp;</div>
</div>
    
    
    
<div class="icv-div-grupo">
<p class="icv-3col">
            <label for="sel_Estudio"><b>*</b>Estudio Superior</label>
            <input dojoType="dijit.form.FilteringSelect" value="<%=idEstudio%>" autoComplete="true" store="estudioStore<%=base.getId()%>" name="sel_Estudio" id="sel_Estudio<%=base.getId()%>" onChange="dijit.byId('sel_Area<%=base.getId()%>').attr('value', (dijit.byId('sel_Estudio<%=base.getId()%>').item || {area: ''}).area);" />       
</p>
<%
    String strDisabled = "disable=\"true\"";
    String strChecked = "";
    String strOtro = "";
    if(idEstudio.endsWith("_otro")&&estudioSup.getEstudiosSuperiores().getTitle().equals("Otro"))
    {
        strChecked = "checked";
        strOtro = estudioSup.getOtroEstudio(); 
        strDisabled =""; 
    }

%>
<p class="icv-3col">
    <label for="chkOtro">Otro Estudio Superior</label>
    <input type="checkbox" value="1" name="chkOtro" onclick="revisa(this,'sel_Estudio<%=base.getId()%>',txtOtro)" <%=strChecked%>/>
    </p>
<p class="icv-3col"><input type="text" name="txtOtro" id="txtOtro" <%=strDisabled%> value="<%=strOtro%>"/>
</p>  
  <div class="clearer">&nbsp;</div>
</div>
 <div class="icv-div-grupo"> 
    <p class="icv-3col">
    <label for="idgavance"><b>*</b>% avance</label>
    <select name="idgavance" id="idgavance" dojoType="dijit.form.FilteringSelect" required="true">
      <option value="" selected="selected">Seleccione...</option>
<%
    Iterator<Avance> itsit = Avance.ClassMgr.listAvances(wsite); 
        while (itsit.hasNext()) {
            Avance avance = itsit.next();
            String strSelected = "";
            if(avance.equals(estudioSup.getGradoAvance())) strSelected="selected";
            %>
            <option value="<%=avance.getId()%>" <%=strSelected%> ><%=avance.getDisplayTitle(usr.getLanguage())%></option>
            <%
        }
%>
    </select>
  </p>
 
 
  <p class="icv-3col">
    <label for="periodo"><b>*</b>Periodo en años</label>
    <input type="text" name="periodo" id="periodo" maxlength="2" value="<%=estudioSup.getPeriodoYears()%>" dojoType="dijit.form.ValidationTextBox" required="true" promptMessage="Ingrese periodo en años" regExp="\d{1,2}" />
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

