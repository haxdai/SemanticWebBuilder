<%--   
    Document   : view Recurso InvestigacionResource
    Created on : 09/02/2012
    Author     : juan.fernandez
--%>

<%@page import="com.infotec.cvi.swb.Investigacion"%>
<%@page import="com.infotec.cvi.swb.CV"%>
<%@page import="com.infotec.cvi.swb.Idioma"%>
<%@page import="org.semanticwb.model.WebPage"%>
<%@page import="java.util.Locale"%>
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
            if(cv==null) {
                cv = CV.ClassMgr.createCV(usr.getId(),wsite);
                cv.setPropietario(usr);
            }
            
            long intSize = SWBUtils.Collections.sizeOf(cv.listInvestigacions());
            Iterator<Investigacion> itinv = cv.listInvestigacions();
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
            boolean booNoAplica = cv.isSinInvestigacion();
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
<label for="noAplica">No cuento con Investigaciones</label>
<input type="checkbox" id="noAplica" name="noAplica" onclick="updNoAplica(this.form)" value="1" <%=strChecked%>/>
</form>
</div>

<table class="icv-table">

    <thead>
        <tr>
            <th width="7%" >&nbsp;</th>
            <th width="15%" >Empresa</th>
            <th width="15%" >Área de investigación</th>
            <th width="15%" >Puesto</th>
            <th width="10%" >Teléfono</th>
            <th width="8%" >Año de término</th>
            <th width="15%" >Nombre y Puesto Jefe</th>
            <th width="15%" >S.N.I. Conacyt</th>
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
            <td colspan="8" >No se encontraron registros</td>
        </tr>
        <%    } else {

                //Iterator<GradoAcademico> itcec = itga.iterator();
                while (itinv.hasNext()) {
                    Investigacion inves = itinv.next();

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

                    String strArea = "<center>---</center>"; 
                    String strEmpresa = "<center>---</center>";                   
                    String strNomJefe = "<center>---</center>";
                    String strPuesto = "<center>---</center>";
                    String strTel = ""+inves.getNumTelefono();
                    String strFechaFin = ""+inves.getFechaTermino();
                    String strSNIC = "<center>---</center>";

                    if(inves.getAreaInvestigacion()!=null)
                        strArea = inves.getAreaInvestigacion();
                    if(inves.getNombreEmpresa()!=null)
                        strEmpresa = inves.getNombreEmpresa();  
                    if(inves.getNombreJefePuesto()!=null)
                        strNomJefe = inves.getNombreJefePuesto();  
                    if(inves.getNombrePuesto()!=null)
                        strPuesto = inves.getNombrePuesto();
                    if(inves.getSniConacyt()!=null)
                        strSNIC = inves.getSniConacyt();
                    
                    
                    SWBResourceURL urldel = paramRequest.getActionUrl();
                    urldel.setAction(SWBResourceURL.Action_REMOVE);
                    urldel.setParameter("id",inves.getId());   
                    
                    SWBResourceURL urledit = paramRequest.getRenderUrl();
                    urledit.setParameter("act",SWBResourceURL.Action_EDIT);
                    urledit.setParameter("id",inves.getId()); 
        %>
        <tr>
            <td><span class="icv-borrar"><a href="#" onclick="if(confirm('¿Deseas eliminar este registro?')){window.location='<%=urldel%>';}">&nbsp;</a></span>
                <span class="icv-editar"><a href="#" onclick="window.location='<%=urledit%>';">&nbsp;</a></span></td>
            <td><%=strEmpresa%></td>
            <td><%=strArea%></td>
            <td><%=strPuesto%></td>
            <td><%=strTel%></td>
            <td><%=strFechaFin%></td>
            <td><%=strNomJefe%></td>
            <td><%=strSNIC%></td>
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
            String wptitle = wpage.getDisplayName(usr.getLanguage());
              SWBResourceURL urladd = paramRequest.getActionUrl();
              urladd.setAction("add");  
 %>         
          <h3><%=wptitle%></h3>
<script type="text/javascript">
    <!--
    dojo.require("dijit.layout.ContentPane");
    dojo.require("dijit.form.Form");
    dojo.require("dijit.form.ValidationTextBox");
    dojo.require("dijit.form.Button");
    dojo.require("dijit.form.NumberTextBox");
    dojo.require("dijit.form.FilteringSelect");

    function enviar() {
        var objd=dijit.byId('form1in');
        if(objd.validate())
        {
                return true;
        }else {
            alert("Datos incompletos o erroneos");
        }
        return false;
    }
    -->
</script>
          <form id="form1in" name="form1in" method="post" action="<%=urladd%>" dojoType="dijit.form.Form">
    <!-- input type="hidden" name="" value="" / --> 
<div class="icv-div-grupo">
      <p class="icv-3col">
    <label for="txtempresa"><b>*</b>Empresa o Institución</label>
    <input type="text" name="txtempresa" id="txtempresa" maxlength="150" dojoType="dijit.form.ValidationTextBox" required="true" promptMessage="Ingrese la empresa o institución" regExp="[a-zA-Z0-9\u00C0-\u00FF',. /_-]+"/>
  </p>
    <p class="icv-3col">
    <label for="txtareainv"><b>*</b>Área de Investigación</label>
    <input type="text" name="txtareainv" id="txtareainv" maxlength="100" dojoType="dijit.form.ValidationTextBox" required="true" promptMessage="Ingrese el área de investigación" regExp="[a-zA-Z0-9\u00C0-\u00FF',. /_-]+"/>
  </p>
    <p class="icv-3col">
    <label for="txtnompuesto"><b>*</b>Puesto</label>
    <input type="text" name="txtnompuesto" id="txtnompuesto" maxlength="100" dojoType="dijit.form.ValidationTextBox" required="true" promptMessage="Ingrese el puesto" regExp="[a-zA-Z0-9\u00C0-\u00FF',. /_-]+"/>
  </p>
  <div class="clearer">&nbsp;</div>
</div>
  
  <div class="icv-div-grupo">
    <p class="icv-3col">
    <label for="numtel">Teléfono</label>
    <input type="text" name="numtel" id="numtel" maxlength="10" dojoType="dijit.form.ValidationTextBox" promptMessage="Ingrese el telefono" regExp="\d{7,10}" trim="true"/>
  </p>
    <p class="icv-3col">
    <label for="txtfechafin">Fecha de término (Año)</label>
    <input type="text" name="txtfechafin" id="txtfechafin" maxlength="4" dojoType="dijit.form.NumberTextBox"  promptMessage="Ingrese el año de termino" constraints="{min:1920,max:2020,pattern:'####'}"/>
  </p>
    <p class="icv-3col">
    <label for="txtnomjefe">Nombre y puesto del jefe inmediato</label>
    <input type="text" name="txtnomjefe" id="txtnomjefe" maxlength="150" dojoType="dijit.form.ValidationTextBox" promptMessage="Ingrese el nombre y puesto del jefe inmediato" regExp="[a-zA-Z0-9\u00C0-\u00FF',. /_-]+"/>
  </p>
  <div class="clearer">&nbsp;</div>
</div>
  <div class="icv-div-grupo">
  <p class="icv-3col">
    <label for="idsniconacyt">S.N.I. Conacyt</label>
    <input type="text" name="idsniconacyt" id="txtnomjefe" maxlength="150" dojoType="dijit.form.ValidationTextBox" promptMessage="Ingrese el nombre del S.N.I. CONACYT" required="false"/>
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

              Investigacion inves = Investigacion.ClassMgr.getInvestigacion(id, wsite);
 %>
  <script type="text/javascript">
    <!--
    dojo.require("dijit.layout.ContentPane");
    dojo.require("dijit.form.Form");
    dojo.require("dijit.form.ValidationTextBox");
    dojo.require("dijit.form.Button");
    dojo.require("dijit.form.NumberTextBox");
    dojo.require("dijit.form.FilteringSelect");

    function enviar() {
        var objd=dijit.byId('form2in');
//alert(objd);
        if(objd.validate())
        {
                return true;
        }else {
            alert("Datos incompletos o erroneos");
        }
        return false;
    }
    -->
</script>
          <h3><%=wptitle%></h3>
          <form id="form2in" name="form2in" method="post" action="<%=urladd%>" dojoType="dijit.form.Form">
    <input type="hidden" name="id" value="<%=id%>" /> 
<div class="icv-div-grupo">
      <p class="icv-3col">
    <label for="txtempresa"><b>*</b>Empresa o Institución</label>
    <input type="text" name="txtempresa" id="txtempresa" maxlength="150" value="<%=inves.getNombreEmpresa()%>" dojoType="dijit.form.ValidationTextBox" required="true" promptMessage="Ingrese la empresa o institución" regExp="[a-zA-Z0-9\u00C0-\u00FF',. /_-]+"/>
  </p>
    <p class="icv-3col">
    <label for="txtareainv"><b>*</b>Área de Investigación</label>
    <input type="text" name="txtareainv" id="txtareainv" maxlength="100" value="<%=inves.getAreaInvestigacion()%>" dojoType="dijit.form.ValidationTextBox" required="true" promptMessage="Ingrese el área de investigación" regExp="[a-zA-Z0-9\u00C0-\u00FF',. /_-]+"/>
  </p>
    <p class="icv-3col">
    <label for="txtnompuesto"><b>*</b>Puesto</label>
    <input type="text" name="txtnompuesto" id="txtnompuesto" maxlength="100" value="<%=inves.getNombrePuesto()%>" dojoType="dijit.form.ValidationTextBox" required="true" promptMessage="Ingrese el puesto" regExp="[a-zA-Z0-9\u00C0-\u00FF',. /_-]+"/>
  </p>
    <div class="clearer">&nbsp;</div>
</div>
  
  <div class="icv-div-grupo">
    <p class="icv-3col">
    <label for="numtel">Teléfono</label>
    <input type="text" name="numtel" id="numtel" maxlength="10" value="<%=inves.getNumTelefono()%>" dojoType="dijit.form.ValidationTextBox" promptMessage="Ingrese el telefono" regExp="\d{7,10}" trim="true"/>
  </p>
    <p class="icv-3col">
    <label for="txtfechafin">Fecha de término (Año)</label>
    <input type="text" name="txtfechafin" id="txtfechafin" maxlength="4" value="<%=inves.getFechaTermino()%>" dojoType="dijit.form.NumberTextBox"  promptMessage="Ingrese el año de termino" constraints="{min:1920,max:2020,pattern:'####'}"/>
  </p>
    <p class="icv-3col">
    <label for="txtnomjefe">Nombre y puesto del jefe inmediato</label>
    <input type="text" name="txtnomjefe" id="txtnomjefe" maxlength="150" value="<%=inves.getNombreJefePuesto()%>" dojoType="dijit.form.ValidationTextBox" promptMessage="Ingrese el nombre y puesto del jefe inmediato" regExp="[a-zA-Z0-9\u00C0-\u00FF',. /_-]+"/>
  </p>
    <div class="clearer">&nbsp;</div>
</div>
  
  <div class="icv-div-grupo">
  <p class="icv-3col">
    <label for="idsniconacyt">S.N.I. Conacyt</label>
    <input type="text" name="idsniconacyt" id="txtnomjefe" maxlength="150" value="<%=inves.getSniConacyt()%>" dojoType="dijit.form.ValidationTextBox" promptMessage="Ingrese el nombre del S.N.I. CONACYT" required="false"/>
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


