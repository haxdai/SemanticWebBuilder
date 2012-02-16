
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

    int intSize=0;
    Iterator<GradoAcademico> itga = aca.listGradoAcademicos();
    while(itga.hasNext()){
        GradoAcademico grado = itga.next();
        intSize++;
    }
    itga = aca.listGradoAcademicos();
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
<div>
    
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
            <th width="23%" >Grado académico</th>
            <th width="28%" >Carrera o especialidad</th>
            <th width="24%" >Institución</th>
            <th width="13%" >Situación</th>
            <th width="7%" >Años</th>
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
                while (itga.hasNext()) {
                    GradoAcademico ga = itga.next();

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

                    String strGrado = "<center>---</center>"; 
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
                        strInstitucion = ga.getNombreInstitucion();
                    
                    SWBResourceURL urldel = paramRequest.getActionUrl();
                    urldel.setAction(SWBResourceURL.Action_REMOVE);
                    urldel.setParameter("id",ga.getId());   
        %>
        <tr>
            <td><span class="icv-borrar"><a href="#" onclick="if(confirm('¿Deseas eliminar este registro?')){window.location='<%=urldel%>';}">borrar</a></span></td>
            <td><%=strGrado%></td>
            <td><%=strCarrera%></td>
            <td><%=strInstitucion%></td>
            <td><%=strSituacion%></td>
            <td><%=strPeriodo%></td>
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
          } else if(SWBResourceURL.Action_ADD.equals(action)) {
            String wptitle = wpage.getDisplayName(usr.getLanguage());
              SWBResourceURL urladd = paramRequest.getActionUrl();
              urladd.setAction(SWBResourceURL.Action_ADD);  
 %>         
          <h3><%=wptitle%></h3>
          <form id="form1" name="form1" method="post" action="<%=urladd%>">
    <!-- input type="hidden" name="" value="" / --> 
<div class="icv-div-grupo">
  <p class="icv-3col">
    <label for="idgrado">Grado</label>
    <select name="idgrado" id="idgrado">
      <option selected="selected">Seleccione...</option>
<%
    Iterator<Grado> itgrado = Grado.ClassMgr.listGrados(wsite); 
        while (itgrado.hasNext()) {
            Grado grado = itgrado.next();
            %>
            <option value="<%=grado.getId()%>"><%=grado.getDisplayTitle(usr.getLanguage())%></option>
            <%
        }
%>
    </select>
  </p>
    <p class="icv-3col">
    <label for="idcarrera">Carrera o Especialidad</label>
    <select name="idcarrera" id="idcarrera">
      <option selected="selected">Seleccione...</option>
<%
    Iterator<Carrera> itcarrera = Carrera.ClassMgr.listCarreras(wsite); 
        while (itcarrera.hasNext()) {
            Carrera carrera = itcarrera.next();
            %>
            <option value="<%=carrera.getId()%>"><%=carrera.getDisplayTitle(usr.getLanguage())%></option>
            <%
        }
%>
    </select>
  </p>
  <p class="icv-3col">
    <label for="txtInstitucion"><b>*</b>Institución</label>
    <input type="text" name="txtInstitucion" id="txtInstitucion" />
  </p>
    <p class="icv-3col">
    <label for="idsituacion">Situación Académica</label>
    <select name="idsituacion" id="idsituacion">
      <option selected="selected">Seleccione...</option>
<%
    Iterator<SituacionAcademica> itsit = SituacionAcademica.ClassMgr.listSituacionAcademicas(wsite); 
        while (itsit.hasNext()) {
            SituacionAcademica situacionAcademica = itsit.next();
            %>
            <option value="<%=situacionAcademica.getId()%>"><%=situacionAcademica.getDisplayTitle(usr.getLanguage())%></option>
            <%
        }
%>
    </select>
  </p>
 
 
  <p class="icv-3col">
    <label for="periodo"><b>*</b>Periodo en años</label>
    <input type="text" name="periodo" id="periodo" />
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
</div>

