<%--   
    Document   : view Recurso InvestigacionResource
    Created on : 09/02/2012
    Author     : juan.fernandez
--%>

<%@page import="com.infotec.cvi.swb.SNIConacyt"%>
<%@page import="com.infotec.cvi.swb.Investigacion"%>
<%@page import="com.infotec.cvi.swb.Escritura"%>
<%@page import="com.infotec.cvi.swb.Lectura"%>
<%@page import="com.infotec.cvi.swb.Conversacion"%>
<%@page import="com.infotec.cvi.swb.Idiomas"%>
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
            
            int intSize=0;
            Iterator<Investigacion> itinv = cv.listInvestigacions();
            while(itinv.hasNext()){
                Investigacion inves = itinv.next();
                intSize++;
            }
            itinv = cv.listInvestigacions();
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
            <th width="15%" >Empresa</th>
            <th width="15%" >Area de investigación</th>
            <th width="15%" >Puesto</th>
            <th width="10%" >Teléfono</th>
            <th width="10%" >Año de término</th>
            <th width="15%" >Nombre y Puesto Jefe</th>
            <th width="15%" >S.N.I. Conacyt</th>
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
                    if(inves.getSniConacyt()!=null&&inves.getSniConacyt().getDisplayTitle(usr.getLanguage())!=null)
                        strSNIC = inves.getSniConacyt().getDisplayTitle(usr.getLanguage());
                    
                    
                    SWBResourceURL urldel = paramRequest.getActionUrl();
                    urldel.setAction(SWBResourceURL.Action_REMOVE);
                    urldel.setParameter("id",inves.getId());   
        %>
        <tr>
            <td><span class="icv-borrar"><a href="#" onclick="if(confirm('¿Deseas eliminar este registro?')){window.location='<%=urldel%>';}">borrar</a></span></td>
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
          <form id="form1" name="form1" method="post" action="<%=urladd%>">
    <!-- input type="hidden" name="" value="" / --> 
<div class="icv-div-grupo">
      <p class="icv-3col">
    <label for="txtempresa"><b>*</b>Empresa o Institución</label>
    <input type="text" name="txtempresa" id="txtempresa" maxlength="150" />
  </p>
    <p class="icv-3col">
    <label for="txtareainv"><b>*</b>'Area de Investigación</label>
    <input type="text" name="txtareainv" id="txtareainv" maxlength="100" />
  </p>
    <p class="icv-3col">
    <label for="txtnompuesto"><b>*</b>Puesto</label>
    <input type="text" name="txtnompuesto" id="txtnompuesto" maxlength="100" />
  </p>
    <p class="icv-3col">
    <label for="numtel">Teléfono</label>
    <input type="text" name="numtel" id="numtel" maxlength="8" />
  </p>
    <p class="icv-3col">
    <label for="txtfechafin">Fecha de término (Año)</label>
    <input type="text" name="txtfechafin" id="txtfechafin" maxlength="4" />
  </p>
    <p class="icv-3col">
    <label for="txtnomjefe">Nombre y puesto del jefe inmediato</label>
    <input type="text" name="txtnomjefe" id="txtnomjefe" maxlength="150" />
  </p>
  <p class="icv-3col">
    <label for="idsniconacyt">S.N.I. Conacyt</label>
    <select name="idsniconacyt" id="idsniconacyt">
      <option selected="selected">Seleccione...</option>
<%
    Iterator<SNIConacyt> itsni = SNIConacyt.ClassMgr.listSNIConacyts(wsite); 
        while (itsni.hasNext()) {
            SNIConacyt sni = itsni.next();
            %>
            <option value="<%=sni.getId()%>"><%=sni.getDisplayTitle(usr.getLanguage())%></option>
            <%
        }
%>
    </select>
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


