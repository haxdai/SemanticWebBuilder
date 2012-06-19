<%--   
    Document   : view Recurso Temas
    Created on : 19/06/2012
    Author     : juan.fernandez
--%>

<%@page import="com.infotec.cvi.swb.CursoTIC"%>
<%@page import="com.infotec.cvi.swb.CV"%>
<%@page import="org.semanticwb.portal.SWBFormMgr"%>
<%@page import="org.semanticwb.model.WebPage"%>
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
            if(cv==null) {
                cv = CV.ClassMgr.createCV(usr.getId(),wsite);
                cv.setPropietario(usr);
            }
            
            long intSize = SWBUtils.Collections.sizeOf(cv.listCursosTICs());
            Iterator<CursoTIC> ittic = cv.listCursosTICs(); 
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

            SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy", new Locale("es"));

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
    <!-- %@include file="../menucvi.jsp" % -->
<div id="icv-data">
<%
            if(action.equals(""))
            {
            
            SWBResourceURL urlnoaplica = paramRequest.getActionUrl();
            urlnoaplica.setAction("updateNoAplica");
            boolean booNoAplica = cv.isSinCurso();
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
<label for="noAplica">No cuento con Cursos especializados en TIC</label>
<input type="checkbox" id="noAplica" name="noAplica" onclick="updNoAplica(this.form)" value="1" <%=strChecked%>/>
</form>
</div>

<table class="icv-table">

    <thead>
        <tr>
            <th width="7%" >&nbsp;</th>
            <th width="25%" >Nombre del curso</th>
            <th width="25%" >Institución</th>
            <th width="12%" >Periodo de</th>
            <th width="12%" >Periodo a</th>
            <th width="19%" >Documento obtenido</th>
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
            <td colspan="6" >No se encontraron registros</td>
        </tr>
        <%    } else {

                //Iterator<GradoAcademico> itcec = itga.iterator();
                while (ittic.hasNext()) {
                    CursoTIC curso = ittic.next();

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

                    String strCurso = "<center>---</center>";                   
                    String strInstitucion = "<center>---</center>";
                    String strDocumento = "<center>---</center>";
                    String strPeriodoINI = "<center>---</center>";
                    String strPeriodoFIN = "<center>---</center>";

                    if(curso.getTitle()!=null)
                        strCurso = curso.getTitle();
                    if(curso.getNombreInstitucion()!=null)
                        strInstitucion = curso.getNombreInstitucion();  
                    if(curso.getDocumentoObtenido()!=null)
                        strDocumento = curso.getDocumentoObtenido();  
                    strPeriodoINI = Integer.toString(curso.getInicio());
                    strPeriodoFIN = Integer.toString(curso.getFin());
                    
                    SWBResourceURL urldel = paramRequest.getActionUrl();
                    urldel.setAction(SWBResourceURL.Action_REMOVE);
                    urldel.setParameter("id",curso.getId());   
                    
                    SWBResourceURL urledit = paramRequest.getRenderUrl();
                    urledit.setParameter("act",SWBResourceURL.Action_EDIT);
                    urledit.setParameter("id",curso.getId()); 
        %>
        <tr>
            <td>
                <span class="icv-borrar"><a href="#" onclick="if(confirm('¿Deseas eliminar este registro?')){window.location='<%=urldel%>';}">&nbsp;</a></span>
                <span class="icv-editar"><a href="#" onclick="window.location='<%=urledit%>';">&nbsp;</a></span></td>
            <td><%=strCurso%></td>
            <td><%=strInstitucion%></td>
            <td><%=strPeriodoINI%></td>
            <td><%=strPeriodoFIN%></td>
            <td><%=strDocumento%></td>
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
              urladd.setAction(SWBResourceURL.Action_ADD);  
              
 %>         
<script type="text/javascript">
    <!--
    dojo.require("dijit.layout.ContentPane");
    dojo.require("dijit.form.Form");
    dojo.require("dijit.form.ValidationTextBox");
    dojo.require("dijit.form.Button");
    dojo.require("dijit.form.NumberTextBox");

    //var objff=dijit.byId('fechafin');
   // dojo.mixin(objff.constraints, {min: dijit.byId("fechaini").attr("value")});

    function enviar() {
        var objd=dijit.byId('form1ct');

    //var objff=dijit.byId('fechafin');
    //dojo.mixin(objff.constraints, {min: dijit.byId("fechaini").attr("value")});

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
          <form  id="form1ct" name="form1ct" method="post" dojoType="dijit.form.Form" action="<%=urladd%>">
    <!-- input type="hidden" name="" value="" / --> 
<div class="icv-div-grupo">

  <p class="icv-3col">
    <label for="nomcurso"><b>*</b>Nombre del curso</label>
    <input type="text" name="nomcurso" id="nomcurso" maxlength="100" dojoType="dijit.form.ValidationTextBox" required="true" promptMessage="Ingrese nombre del curso" regExp="[a-zA-Z0-9\u00C0-\u00FF' /_-]+"/>
  </p>
  <p class="icv-3col">
    <label for="nominstitucion"><b>*</b>Institución</label>
    <input type="text" name="nominstitucion" id="nominstitucion" maxlength="150" dojoType="dijit.form.ValidationTextBox" required="true" promptMessage="Ingrese la institucion" regExp="[a-zA-Z0-9\u00C0-\u00FF' /_-]+" />
  </p> 
  <p class="icv-3col">
    <label for="fechaini"><b>*</b>Pediodo de (Año)</label>
    <input type="text" name="fechaini" id="fechaini" maxlength="4" dojoType="dijit.form.NumberTextBox" required="true" promptMessage="Ingrese el año de inicio del curso" constraints="{min:1920,max:2020,pattern:'####'}"/>
  </p>
  <div class="clearer">&nbsp;</div>
  </div>
  <div class="icv-div-grupo">
  <p class="icv-3col">
    <label for="fechafin"><b>*</b>Periodo a (Año)</label>
    <input type="text" name="fechafin" id="fechafin" maxlength="4" dojoType="dijit.form.NumberTextBox" required="true" promptMessage="Ingrese el año de fin del curso" constraints="{min:1920,max:2020,pattern:'####'}"/>
  </p>
  <p class="icv-3col">
    <label for="docobtenido"><b>*</b>Documento obtenido</label>
    <input type="text" name="docobtenido" id="docobtenido" dojoType="dijit.form.ValidationTextBox" required="true" promptMessage="Ingrese documento obtenido" regExp="[a-zA-Z0-9\u00C0-\u00FF' /_-]+"/>
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
              CursoTIC ctic = CursoTIC.ClassMgr.getCursoTIC(id, wsite);
              
 %>  
 <script type="text/javascript">
    <!--
    dojo.require("dijit.layout.ContentPane");
    dojo.require("dijit.form.Form");
    dojo.require("dijit.form.ValidationTextBox");
    dojo.require("dijit.form.Button");
    dojo.require("dijit.form.NumberTextBox");

    function enviar() {
        var objd=dijit.byId('form2ct');

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
          <form id="form2ct" name="form2ct" method="post" action="<%=urladd%>">
              <input type="hidden" name="id" value="<%=id%>" /> 
<div class="icv-div-grupo">

  <p class="icv-3col">
    <label for="nomcurso"><b>*</b>Nombre del curso</label>
    <input type="text" name="nomcurso" id="nomcurso" maxlength="100" value="<%=ctic.getTitle()%>" dojoType="dijit.form.ValidationTextBox" required="true" promptMessage="Ingrese nombre del curso" regExp="[a-zA-Z0-9\u00C0-\u00FF' /_-]+"/>
  </p>
  <p class="icv-3col">
    <label for="nominstitucion"><b>*</b>Institución</label>
    <input type="text" name="nominstitucion" id="nominstitucion" maxlength="150" value="<%=ctic.getNombreInstitucion()%>" dojoType="dijit.form.ValidationTextBox" required="true" promptMessage="Ingrese la institucion" regExp="[a-zA-Z0-9\u00C0-\u00FF' /_-]+"/>
  </p> 
  <p class="icv-3col">
    <label for="fechaini"><b>*</b>Pediodo de (Año)</label>
    <input type="text" name="fechaini" id="fechaini" maxlength="4" value="<%=ctic.getInicio()%>" dojoType="dijit.form.NumberTextBox" required="true" promptMessage="Ingrese el año de inicio del curso" constraints="{min:1920,max:2020,pattern:'####'}"/>
  </p>
    <div class="clearer">&nbsp;</div>
  </div>
  <div class="icv-div-grupo">
  <p class="icv-3col">
    <label for="fechafin"><b>*</b>Periodo a (Año)</label>
    <input type="text" name="fechafin" id="fechafin" maxlength="4" value="<%=ctic.getFin()%>" dojoType="dijit.form.NumberTextBox" required="true" promptMessage="Ingrese el año de fin del curso" constraints="{min:1920,max:2020,pattern:'####'}"/>
  </p>
  <p class="icv-3col">
    <label for="docobtenido"><b>*</b>Documento obtenido</label>
    <input type="text" name="docobtenido" id="docobtenido" value="<%=ctic.getDocumentoObtenido()%>" dojoType="dijit.form.ValidationTextBox" required="true" promptMessage="Ingrese documento obtenido" regExp="[a-zA-Z0-9\u00C0-\u00FF' /_-]+"/>
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

