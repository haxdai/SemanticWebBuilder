<%--   
    Document   : view Recurso PublicacionesResource
    Created on : 13/02/2012
    Author     : juan.fernandez
--%>

<%@page import="com.infotec.cvi.swb.Publicacion"%>
<%@page import="com.infotec.cvi.swb.CV"%>
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
            
            long intSize = SWBUtils.Collections.sizeOf(cv.listPublicacions());
            Iterator<Publicacion> itinv = cv.listPublicacions();
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
            
            //SWBResourceURL urlorder = paramRequest.getRenderUrl();

%>

<table class="icv-table">

    <thead>
        <tr>
            <th width="7%" >&nbsp;</th>
            <th width="38%" >Título</th>
            <th width="30%" >Publicado en</th>
            <th width="25%" >Año</th>
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
                while (itinv.hasNext()) {
                    Publicacion inves = itinv.next();

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

                    String strTitulo = "<center>---</center>"; 
                    String strPublicado = "<center>---</center>";                   
                    int intYears = inves.getFechapublicado();

                    if(inves.getTitle()!=null)
                        strTitulo = inves.getTitle();
                    if(inves.getPublicado()!=null)
                        strPublicado = inves.getPublicado();  

                    
                    SWBResourceURL urldel = paramRequest.getActionUrl();
                    urldel.setAction(SWBResourceURL.Action_REMOVE);
                    urldel.setParameter("id",inves.getId()); 

                    SWBResourceURL urledit = paramRequest.getRenderUrl();
                    urledit.setParameter("act",SWBResourceURL.Action_EDIT);
                    urledit.setParameter("id",inves.getId());                                         
        %>
        <tr>
            <td><span class="icv-borrar"><a href="#" onclick="if(confirm('¿Deseas eliminar este registro?')){window.location='<%=urldel%>';}">borrar</a></span>
                <span class="icv-editar"><a href="#" onclick="window.location='<%=urledit%>';">editar</a></span></td>
            <td><%=strTitulo%></td>
            <td><%=strPublicado%></td>
            <td><%=intYears%></td>
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

    function enviar() {
        var objd=dijit.byId('form1pu');
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
          <form id="form1pu" name="form1pu" method="post" action="<%=urladd%>" dojoType="dijit.form.Form">
    <!-- input type="hidden" name="" value="" / --> 
<div class="icv-div-grupo">
  <p class="icv-3col">
    <label for="txttitulo"><b>*</b>Título</label>
    <input type="text" name="txttitulo" id="txttitulo" maxlength="100"  dojoType="dijit.form.ValidationTextBox" required="true" promptMessage="Ingrese el título de la publicación" regExp="[a-zA-Z0-9\u00C0-\u00FF',. /_-]+"/>
  </p>
        <p class="icv-3col">
    <label for="txtpublicado"><b>*</b>Publicado en</label>
    <input type="text" name="txtpublicado" id="txtpublicado" maxlength="100"  dojoType="dijit.form.ValidationTextBox" required="true" promptMessage="Ingrese el nombre de la publicación" regExp="[a-zA-Z0-9\u00C0-\u00FF',. /_-]+"/>
  </p>
  <p class="icv-3col">
    <label for="intfecha"><b>*</b>Año</label>
    <input type="text" name="intfecha" id="intfecha" maxlength="4" dojoType="dijit.form.NumberTextBox" required="true" promptMessage="Ingrese el año de la publicación" constraints="{min:1920,max:2020,pattern:'####'}"/>
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
              Publicacion publi = Publicacion.ClassMgr.getPublicacion(id, wsite);
              
                           
 %>
 <script type="text/javascript">
    <!--
    dojo.require("dijit.layout.ContentPane");
    dojo.require("dijit.form.Form");
    dojo.require("dijit.form.ValidationTextBox");
    dojo.require("dijit.form.Button");
    dojo.require("dijit.form.NumberTextBox");

    function enviar() {
        var objd=dijit.byId('form2pu');
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
          <form id="form2pu" name="form2pu" method="post" action="<%=urladd%>" dojoType="dijit.form.Form">
        <input type="hidden" name="id" value="<%=id%>" /> 
<div class="icv-div-grupo">
  <p class="icv-3col">
    <label for="txttitulo"><b>*</b>Título</label>
    <input type="text" name="txttitulo" id="txttitulo" maxlength="100" value="<%=publi.getTitle()%>" dojoType="dijit.form.ValidationTextBox" required="true" promptMessage="Ingrese el título de la publicación" regExp="[a-zA-Z0-9\u00C0-\u00FF',. /_-]+"/>
  </p>
        <p class="icv-3col">
    <label for="txtpublicado"><b>*</b>Publicado en</label>
    <input type="text" name="txtpublicado" id="txtpublicado" maxlength="100" value="<%=publi.getPublicado()%>" dojoType="dijit.form.ValidationTextBox" required="true" promptMessage="Ingrese el nombre de la publicación" regExp="[a-zA-Z0-9\u00C0-\u00FF',. /_-]+"/>
  </p>
  <p class="icv-3col">
    <label for="intfecha"><b>*</b>Año</label>
    <input type="text" name="intfecha" id="intfecha" maxlength="4" value="<%=publi.getFechapublicado()%>" dojoType="dijit.form.NumberTextBox" required="true" promptMessage="Ingrese el año de la publicación" constraints="{min:1920,max:2020,pattern:'####'}"/>
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


