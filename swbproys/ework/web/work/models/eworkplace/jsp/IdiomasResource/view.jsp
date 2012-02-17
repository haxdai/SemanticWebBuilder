<%--   
    Document   : view Recurso IdiomasResource
    Created on : 09/02/2012
    Author     : juan.fernandez
--%>

<%@page import="org.semanticwb.model.Language"%>
<%@page import="com.infotec.cvi.swb.Escritura"%>
<%@page import="com.infotec.cvi.swb.Lectura"%>
<%@page import="com.infotec.cvi.swb.Conversacion"%>
<%@page import="com.infotec.cvi.swb.Idioma"%>
<%@page import="org.semanticwb.model.WebPage"%>
<%@page import="com.infotec.cvi.swb.CV"%>
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
            Iterator<Idioma> itid = cv.listIdiomas();
            while(itid.hasNext()){
                Idioma idioma = itid.next();
                intSize++;
            }
            itid = cv.listIdiomas();
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
            <th width="33%" >Idioma</th>
            <th width="20%" >Conversación</th>
            <th width="20%" >Lectura</th>
            <th width="20%" >Escritura</th>
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
            <td colspan="5" >No se encontraron registros</td>
        </tr>
        <%    } else {

                //Iterator<GradoAcademico> itcec = itga.iterator();
                while (itid.hasNext()) {
                    Idioma ga = itid.next();

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

                    String strIdioma = "<center>---</center>"; 
                    String strCoversacion = "<center>---</center>";                   
                    String strLectura = "<center>---</center>";
                    String strEscritura = "<center>---</center>";
                    

                    if(ga.getIdiomas()!=null&&ga.getIdiomas().getTitle()!=null)
                        strIdioma = ga.getIdiomas().getTitle();
                    if(ga.getConversacion()!=null&&ga.getConversacion().getTitle()!=null)
                        strCoversacion = ga.getConversacion().getTitle();  
                    if(ga.getLectura()!=null&&ga.getLectura().getTitle()!=null)
                        strLectura = ga.getLectura().getTitle();  
                    if(ga.getEscritura()!=null&&ga.getEscritura().getTitle()!=null)
                        strEscritura = ga.getEscritura().getTitle();
                    
                    SWBResourceURL urldel = paramRequest.getActionUrl();
                    urldel.setAction(SWBResourceURL.Action_REMOVE);
                    urldel.setParameter("id",ga.getId());  

                    SWBResourceURL urledit = paramRequest.getRenderUrl();
                    urledit.setParameter("act",SWBResourceURL.Action_EDIT);
                    urledit.setParameter("id",ga.getId());
        %>
        <tr>
            <td><span class="icv-borrar"><a href="#" onclick="if(confirm('¿Deseas eliminar este registro?')){window.location='<%=urldel%>';}">borrar</a></span>
                <span class="icv-editar"><a href="#" onclick="window.location='<%=urledit%>';">editar</a></span></td>
            <td><%=strIdioma%></td>
            <td><%=strCoversacion%></td>
            <td><%=strLectura%></td>
            <td><%=strEscritura%></td>
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
    dojo.require("dijit.form.FilteringSelect");

    function enviar() {
        var objd=dijit.byId('form1id');
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
          <form id="form1id" name="form1id" method="post" action="<%=urladd%>" dojoType="dijit.form.Form">
    <!-- input type="hidden" name="" value="" / --> 
<div class="icv-div-grupo">
  <p class="icv-4col">
    <label for="ididoma"><b>*</b>Idioma</label>
    <select name="ididoma" id="ididoma" dojoType="dijit.form.FilteringSelect" required="true">
      <option value="" selected="selected">Seleccione...</option>
<%
    Iterator<Language> itidioma = wsite.listLanguages();
        while (itidioma.hasNext()) {
            Language ids = itidioma.next();
            %>
            <option value="<%=ids.getId()%>"><%=ids.getDisplayTitle(usr.getLanguage())%></option>
            <%
        }
%>
    </select>
  </p>
    <p class="icv-4col">
    <label for="idconversacion"><b>*</b>Conversación</label>
    <select name="idconversacion" id="idconversacion" dojoType="dijit.form.FilteringSelect" required="true">
      <option value="" selected="selected">Seleccione...</option>
<%
    Iterator<Conversacion> itconv = Conversacion.ClassMgr.listConversacions(wsite); 
        while (itconv.hasNext()) {
            Conversacion conv = itconv.next();
            %>
            <option value="<%=conv.getId()%>"><%=conv.getDisplayTitle(usr.getLanguage())%></option>
            <%
        }
%>
    </select>
  </p>
    <p class="icv-4col">
    <label for="idlectura"><b>*</b>Lectura</label>
    <select name="idlectura" id="idlectura" dojoType="dijit.form.FilteringSelect" required="true">
      <option value="" selected="selected">Seleccione...</option>
<%
    Iterator<Lectura> itlec = Lectura.ClassMgr.listLecturas(wsite); 
        while (itlec.hasNext()) {
            Lectura lec = itlec.next();
            %>
            <option value="<%=lec.getId()%>"><%=lec.getDisplayTitle(usr.getLanguage())%></option>
            <%
        }
%>
    </select>
  </p>
    <p class="icv-4col">
    <label for="idescritura"><b>*</b>Escritura</label>
    <select name="idescritura" id="idescritura" dojoType="dijit.form.FilteringSelect" required="true">
      <option value="" selected="selected">Seleccione...</option>
<%
    Iterator<Escritura> itesc = Escritura.ClassMgr.listEscrituras(wsite); 
        while (itesc.hasNext()) {
            Escritura esc = itesc.next();
            %>
            <option value="<%=esc.getId()%>"><%=esc.getDisplayTitle(usr.getLanguage())%></option>
            <%
        }
%>
    </select>
  </p>
<div class="clearer">&nbsp;</div>
</div>

    <div class="centro">
    <input type="submit" name="guardar" id="guardar" value="Guardar" onclick="return enviar()" />
</div>
</form> 
<%
          } else if(action.equals(SWBResourceURL.Action_EDIT)) {
              String id = request.getParameter("id");
              
              String wptitle = wpage.getDisplayName(usr.getLanguage());
              SWBResourceURL urladd = paramRequest.getActionUrl();
              urladd.setAction(SWBResourceURL.Action_EDIT);  
              
              Idioma idioma = Idioma.ClassMgr.getIdioma(id, wsite);
 %>         
<script type="text/javascript">
    <!--
    dojo.require("dijit.layout.ContentPane");
    dojo.require("dijit.form.Form");
    dojo.require("dijit.form.ValidationTextBox");
    dojo.require("dijit.form.Button");
    dojo.require("dijit.form.FilteringSelect");
    
    function enviar() {
        var objd=dijit.byId('form2id');

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
          <form id="form2id" name="form2id" method="post"  action="<%=urladd%>" dojoType="dijit.form.Form">
    <input type="hidden" name="id" value="<%=id%>" /> 
<div class="icv-div-grupo">
  <p class="icv-4col">
    <label for="ididoma"><b>*</b>Idioma</label>
    <select name="ididoma" id="ididoma" dojoType="dijit.form.FilteringSelect" required="true">
      <option value="" selected="selected">Seleccione...</option>
<%
    Iterator<Language> itidioma = wsite.listLanguages();
        while (itidioma.hasNext()) {
            Language ids = itidioma.next();
            String strSelected = "";
            if(ids.equals(idioma.getIdiomas())) strSelected="selected"; 
            %>
            <option value="<%=ids.getId()%>" <%=strSelected%> ><%=ids.getDisplayTitle(usr.getLanguage())%></option>
            <%
        }
%>
    </select>
  </p>
    <p class="icv-4col">
    <label for="idconversacion"><b>*</b>Conversación</label>
    <select name="idconversacion" id="idconversacion" dojoType="dijit.form.FilteringSelect" required="true">
      <option value="" selected="selected">Seleccione...</option>
<%
    Iterator<Conversacion> itconv = Conversacion.ClassMgr.listConversacions(wsite); 
        while (itconv.hasNext()) {
            Conversacion conv = itconv.next();
            String strSelected = "";
            if(conv.equals(idioma.getConversacion())) strSelected="selected";
            %>
            <option value="<%=conv.getId()%>" <%=strSelected%> ><%=conv.getDisplayTitle(usr.getLanguage())%></option>
            <%
        }
%>
    </select>
  </p>
    <p class="icv-4col">
    <label for="idlectura"><b>*</b>Lectura</label>
    <select name="idlectura" id="idlectura" dojoType="dijit.form.FilteringSelect" required="true">
      <option value="" selected="selected">Seleccione...</option>
<%
    Iterator<Lectura> itlec = Lectura.ClassMgr.listLecturas(wsite); 
        while (itlec.hasNext()) {
            Lectura lec = itlec.next();
            String strSelected = "";
            if(lec.equals(idioma.getLectura())) strSelected="selected";
            %>
            <option value="<%=lec.getId()%>" <%=strSelected%> ><%=lec.getDisplayTitle(usr.getLanguage())%></option>
            <%
        }
%>
    </select>
  </p>
    <p class="icv-4col">
    <label for="idescritura"><b>*</b>Escritura</label>
    <select name="idescritura" id="idescritura" dojoType="dijit.form.FilteringSelect" required="true">
      <option value="" selected="selected">Seleccione...</option>
<%
    Iterator<Escritura> itesc = Escritura.ClassMgr.listEscrituras(wsite); 
        while (itesc.hasNext()) {
            Escritura esc = itesc.next();
            String strSelected = "";
            if(esc.equals(idioma.getEscritura())) strSelected="selected";
            %>
            <option value="<%=esc.getId()%>" <%=strSelected%> ><%=esc.getDisplayTitle(usr.getLanguage())%></option>
            <%
        }
%>
    </select>
  </p>
<div class="clearer">&nbsp;</div>
</div>

    <div class="centro">
    <input type="submit" name="guardar" id="guardar" value="Guardar" onclick="return enviar()" />
</div>
</form> 
<%         
          }
%>
</div><!-- icv-data -->  
</div>
</div>


