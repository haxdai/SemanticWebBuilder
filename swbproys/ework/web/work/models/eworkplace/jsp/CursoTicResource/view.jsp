<%--   
    Document   : view Recurso CursoTicResource
    Created on : 09/02/2012
    Author     : juan.fernandez
--%>

<%@page import="com.infotec.eworkplace.swb.CursoTIC"%>
<%@page import="com.infotec.eworkplace.swb.SituacionAcademica"%>
<%@page import="com.infotec.eworkplace.swb.Carrera"%>
<%@page import="com.infotec.eworkplace.swb.Grado"%>
<%@page import="com.infotec.eworkplace.swb.base.GradoBase"%>
<%@page import="org.semanticwb.model.WebPage"%>
<%@page import="com.infotec.eworkplace.swb.GradoAcademico"%>
<%@page import="com.infotec.eworkplace.swb.Academia"%>
<%@page import="com.infotec.eworkplace.swb.CV"%>
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
            
            int intSize=0;
            Iterator<CursoTIC> ittic = cv.listCursosTICs();
            while(ittic.hasNext()){
                CursoTIC ctic = ittic.next();
                intSize++;
            }
            ittic = cv.listCursosTICs();
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


<h2>Curriculum Vitae</h2>
<div id="icv">
<%@include file="../menucvi.jsp" %>
<div id="icv-data">
<%
            if(action.equals(""))
            {
            
            //SWBResourceURL urlorder = paramRequest.getRenderUrl();

%>

<table class="icv-table">

    <thead>
        <tr>
            <th width="5%" >&nbsp;</th>
            <th width="25%" >Nombre del curso</th>
            <th width="25%" >Institución</th>
            <th width="12%" >Periodo de</th>
            <th width="12%" >Periodo a</th>
            <th width="21%" >Documento obtenido</th>
        </tr>
    </thead>

    <tbody>

        <%
                    //PAGINACION
                    int ps = numPages;
                    int l = intSize;

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
                    if(curso.getInicio()!=null)
                        strPeriodoINI = sdf.format(curso.getInicio());
                    if(curso.getFin()!=null)
                        strPeriodoFIN = sdf.format(curso.getFin());
                    
                    SWBResourceURL urldel = paramRequest.getActionUrl();
                    urldel.setAction("del");
                    urldel.setParameter("id",curso.getId());   
        %>
        <tr>
            <td><span class="icv-borrar"><a href="#" onclick="if(confirm('¿Deseas eliminar este registro?')){window.location='<%=urldel%>';}">borrar</a></span></td>
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
                    urladd.setParameter("act","add");
%>
</p></div>
<p class="icv-txt"><a href="<%=urladd%>">Agregar</a></p>    


 <%
          } else if(action.equals("add")) {
            //String wptitle = wpage.getDisplayName(usr.getLanguage());
              SWBResourceURL urladd = paramRequest.getActionUrl();
              urladd.setAction("add");  
 %>         
<script type="text/javascript">
    dojo.require("dijit.form.DateTextBox");
    dojo.require("dijit.form.Button");
</script>
          <form id="form1" name="form1" method="post" action="<%=urladd%>">
    <!-- input type="hidden" name="" value="" / --> 
<div class="icv-div-grupo">

  <p class="icv-3col">
    <label for="nomcurso"><b>*</b>Nombre del curso</label>
    <input type="text" name="nomcurso" id="nomcurso" />
  </p>
  <p class="icv-3col">
    <label for="nominstitucion"><b>*</b>Institución</label>
    <input type="text" name="nominstitucion" id="nominstitucion" />
  </p> 
  <p class="icv-3col">
    <label for="fechaini"><b>*</b>Pediodo de</label>
    <input type="text" name="fechaini" id="fechaini" dojoType="dijit.form.DateTextBox"  onChange="dijit.byId('fechafin').constraints.min = arguments[0];" />
  </p>
  <p class="icv-3col">
    <label for="fechafin"><b>*</b>Periodo a</label>
    <input type="text" name="fechafin" id="fechafin" dojoType="dijit.form.DateTextBox"  onChange="dijit.byId('fechaini').constraints.max = arguments[0];" />
  </p>
  <p class="icv-3col">
    <label for="docobtenido"><b>*</b>Documento obtenido</label>
    <input type="text" name="docobtenido" id="docobtenido" />
  </p>
<div class="clearer">&nbsp;</div>
</div>

    <div class="centro">
    <input type="submit" name="guardar" id="guardar" value="Guardar" />
</div>
</form>          
<%         
          }
%>
</div><!-- icv-data -->  
</div>


