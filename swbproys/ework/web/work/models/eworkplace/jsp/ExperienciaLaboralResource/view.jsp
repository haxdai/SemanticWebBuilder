<%--   
    Document   : view Recurso ExperienciaLaboralResource
    Created on : 15/02/2012
    Author     : carlos.ramos
--%>

<%@page import="org.semanticwb.model.WebPage"%>
<%@page import="com.infotec.cvi.swb.ExperienciaLaboral"%>
<%@page import="com.infotec.cvi.swb.Sector"%>
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
            Role role=null;
            
            CV cv = CV.ClassMgr.getCV(usr.getId(), wsite);
            /*if(cv==null) {
                cv = CV.ClassMgr.createCV(usr.getId(),wsite);
                cv.setPropietario(usr);
            }
             
            Academia aca = cv.getAcademia();
            if(aca==null){
                aca = Academia.ClassMgr.createAcademia(wsite);
                cv.setAcademia(aca);
            }*/
            
            long intSize = SWBUtils.Collections.sizeOf(cv.listExperienciaLaborals());
            Iterator<ExperienciaLaboral> itga;
            /*while(itga.hasNext()){
                GradoAcademico grado = itga.next();
                intSize++;
            }*/
            itga = cv.listExperienciaLaborals();
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
<%-- @include file="../menucvi.jsp" --%>
<div id="icv-data">
<%
            if(action.equals(""))
            {
            
            //SWBResourceURL urlorder = paramRequest.getRenderUrl();

%>
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
            <th>telefono</th>
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
        <%    } else {

                //Iterator<GradoAcademico> itcec = itga.iterator();
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

                    /*String strGrado = "<center>---</center>"; 
                    String strCarrera = "<center>---</center>";                   
                    String strInstitucion = "<center>---</center>";
                    String strSituacion = "<center>---</center>";
                    int strPeriodo = ga.getPeriodoYears();

                    if(ga.getGrado()!=null&&ga.getGrado().getTitle()!=null)
                        strGrado = ga.getGrado().getTitle();
                    if(ga.getSituacionAcademica()!=null&&ga.getSituacionAcademica().getTitle()!=null)
                        strSituacion = ga.getSituacionAcademica().getTitle();  
                    if(ga.getCarrera()!=null&&ga.getCarrera().getTitle()!=null)
                        strCarrera = ga.getCarrera().getTitle();  
                    if(ga.getNombreInstitucion()!=null)
                        strInstitucion = ga.getNombreInstitucion();*/
                    
                    
                    
                    
                    SWBResourceURL urldel = paramRequest.getActionUrl();
                    urldel.setAction(SWBResourceURL.Action_REMOVE);
                    urldel.setParameter("id",ga.getId());   

                    SWBResourceURL urledit = paramRequest.getRenderUrl();
                    urledit.setParameter("act",SWBResourceURL.Action_EDIT);
                    urledit.setParameter("id",ga.getId());                     
        %>
        <tr>
            <td>
                <span class="icv-borrar"><a href="javascript:if(confirm('¿Deseas eliminar este registro?')){window.location.href='<%=urldel%>';}" title="eliminar registro">borrar</a></span>
                <span class="icv-editar"><a href="javascript:window.location.href='<%=urledit%>'" title="editar registro">editar</a></span>
            </td>
            <td><%=(ga.isActual()?"x":"")%></td>
            <td><%=ga.getEmpresa()%></td>
            <td><%=(ga.getSector()==null?"---":(ga.getSector().getTitle()==null?"---":ga.getSector().getTitle()))%></td>
            <td><%=ga.getFechaIni()%></td>
            <td><%=ga.getFechaFin()%></td>
            <td><%=ga.getCargo()%></td>
            <td><%=ga.getFuncionesPrincipales()%></td>
            <td><%=(ga.getJefe()==null?"---":ga.getJefe())%></td>
            <td>
                <%=(ga.getTelefono()==null?"":(ga.getTelefono().getLada()==0?"":"("+ga.getTelefono().getLada())+")")%>
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
<p class="icv-txt"><a href="<%=urladd%>" title="Agregar registro">Agregar</a></p>    


 <%
          }else if(SWBResourceURL.Action_ADD.equals(action)) {
            String wptitle = wpage.getDisplayName(usr.getLanguage());
              SWBResourceURL urladd = paramRequest.getActionUrl();
              urladd.setAction(SWBResourceURL.Action_ADD);  
 %>         
          <h3><%=wptitle%></h3>
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
            <option value="<%=sector.getId()%>"><%=sector.getDisplayTitle(usr.getLanguage())%></option>
            <%
        }
%>
    </select>
    </p>
  <p class="icv-3col"><label><em>*</em>Fecha inicial</label><input type="text" name="fi" value="" dojoType="dijit.form.DateTextBox" required="true" constraints="{datePattern:'dd/MM/yyyy'}" maxlength="10" hasDownArrow="true"/></p>
  <p class="icv-3col"><label>Fecha final</label><input type="text" name="ff" value="" dojoType="dijit.form.DateTextBox" required="false" constraints="{datePattern:'dd/MM/yyyy'}" maxlength="10" hasDownArrow="true"/></p>
<p class="icv-3col"><label><em>*</em>Puesto</label><input type="text" name="crg" value="" dojoType="dijit.form.ValidationTextBox" required="true" promptMessage="Puesto ocupado" invalidMessage="El nombre del puesto es requerido"/></p>
<p class="icv-3col"><label><em>*</em>Funciones principales</label><textarea name="mfncs" dojoType="dijit.form.Textarea" required="true" promptMessage="Funciones realizadas en el puesto ocupado" invalidMessage="Las funciones realizadas son requeridas"></textarea></p>
<p class="icv-3col"><label>Nombre y puesto del jefe inmediato</label><input type="text" name="jf" value="" /></p>
<p class="icv-3col"><label>Tel&eacute;fono (clave lada, n&uacute;mero y extensi&oacute;n)</label>
<input type="text" name="cve" value="" size="3" maxlength="3" dojoType="dijit.form.ValidationTextBox" promptMessage="Clave lada" invalidMessage="Clave lada incorrecta" regExp="\d{2,3}" />&nbsp;
<input type="text" name="tf" value="" size="8" maxlength="8" dojoType="dijit.form.ValidationTextBox" promptMessage="Numero telefonico" invalidMessage="Numero telefonico incorrecto" regExp="\d{7,8}" />&nbsp;
<input type="text" name="ext" value="" size="5" maxlength="5" dojoType="dijit.form.ValidationTextBox" promptMessage="Extension telefonica" invalidMessage="Extension telefonica incorrecta" regExp="\d{1,5}" />
</p>
</div>
    <div class="centro">
    <input type="submit" name="guardar" id="guardar" value="Guardar" onclick="return enviar()"/>
    </div>
</form>   
<%
          } else if(SWBResourceURL.Action_EDIT.equals(action)) {
              String id = request.getParameter("id");
              
              String wptitle = wpage.getDisplayName(usr.getLanguage());
              SWBResourceURL urladd = paramRequest.getActionUrl();
              urladd.setAction(SWBResourceURL.Action_EDIT); 
              ExperienciaLaboral gradoAca = ExperienciaLaboral.ClassMgr.getExperienciaLaboral(id, wsite);              
 %>         
          <h3><%=wptitle%></h3>
<script type="text/javascript">
    <!--
    dojo.require("dijit.layout.ContentPane");
    dojo.require("dijit.form.Form");
    dojo.require("dijit.form.ValidationTextBox");
    dojo.require("dijit.form.Button");
    dojo.require("dijit.form.FilteringSelect");

    function enviar() {
        var objd=dijit.byId('form2ga');
//alert(objd);
        if(objd.validate())//.isValid()&&
           // !isEmpty('idgrado')&&
           // !isEmpty('idcarrera')&&
           // !isEmpty('idsituacion'))
        {
                return true;
        }else {
            alert("Datos incompletos o erroneos");
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

          <form id="form2ga" name="form1ga" method="post" dojoType="dijit.form.Form" action="<%=urladd%>">
    <input type="hidden" name="id" value="<%=id%>" /> 
<div class="icv-div-grupo">
  <p class="icv-3col">
    <label for="idgrado"><b>*</b>Grado</label>

  </p>
    <p class="icv-3col">
    <label for="idcarrera"><b>*</b>Carrera o Especialidad</label>

  </p>
  <p class="icv-3col">
    <label for="txtInstitucion"><b>*</b>Institución</label>
    <input type="text" name="txtInstitucion" id="txtInstitucion" maxlength="150" dojoType="dijit.form.ValidationTextBox" required="true" promptMessage="Ingrese institución" value="" />
  </p>
  <div class="clearer">&nbsp;</div>
</div>
  <div class="icv-div-grupo">
    <p class="icv-3col">
    <label for="idsituacion"><b>*</b>Situación Académica</label>

  </p>
 
 
  <p class="icv-3col">
    <label for="periodo"><b>*</b>Periodo en años</label>
    <input type="text" name="periodo" id="periodo" maxlength="2" dojoType="dijit.form.ValidationTextBox" required="true" promptMessage="Ingrese periodo en años" regExp="\d{1,2}" value=""/>
  </p>
<div class="clearer">&nbsp;</div>
</div>

    <div class="centro">
    <input type="submit" name="guardar" id="guardar" value="Guardar" onclick="return enviar()"/>
</div>
</form>   
<%         
          }
%>
</div><!-- icv-data -->  
</div>
</div>

