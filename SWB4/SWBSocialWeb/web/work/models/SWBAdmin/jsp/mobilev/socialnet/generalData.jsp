<%-- 
    Document   : generalData
    Created on : 21/10/2014, 03:56:43 PM
    Author     : jorge.jimenez
--%>
<%@page import="javax.swing.colorchooser.ColorSelectionModel"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="org.semanticwb.SWBPortal"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.semanticwb.platform.SemanticObject"%>
<%@page import="org.semanticwb.SWBPortal"%>
<%@page import="org.semanticwb.model.*"%>
<%@page import="org.semanticwb.social.*"%>
<%@page import="org.semanticwb.social.Country"%>
<%@page import="org.semanticwb.model.Collection"%>
<%@page import="org.semanticwb.social.util.SWBSocialUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.*"%>
<%@page import="java.text.*"%>
<%@page contentType="text/html" pageEncoding="x-iso-8859-11"%>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest"/>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script src="/swbadmin/js/jquery/jquery-1.4.4.min.js" type="text/javascript"></script>
<script src="/swbadmin/js/jquery/jquery.ui.draggable.js" type="text/javascript"></script>

<!-- Core files -->
<script src="/swbadmin/js/jquery/jquery.alerts.mod.js" type="text/javascript"></script>
<link href="/swbadmin/js/jquery/jquery.alerts.css" rel="stylesheet" type="text/css" media="screen" />
<style>
    #chart {
              height: 100%;
              width: 100%;
            }
    
   
</style>
<%
    if(request.getParameter("semObj")==null) return; 
    
    SemanticObject semObj=SemanticObject.getSemanticObject(request.getParameter("semObj"));
    SocialNetwork socialnet=null;
    try{
        socialnet=(SocialNetwork) semObj.getGenericInstance();
        if(socialnet==null) return; 
    }catch(Exception e){
        e.printStackTrace(); 
        %>
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Oops, parece que ha sucedido un error: Cuenta de Red Social No encontrada</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
        <%
    }
    User user=paramRequest.getUser();
    //long streamPostIns = Integer.parseInt(getAllPostInStream_Query(stream));
    
    SWBResourceURL urlAction=paramRequest.getActionUrl();
    urlAction.setAction(SWBResourceURL.Action_EDIT);

    //node.put("streamMsgNum", streamPostIns); 
%>
<script type="text/javascript">
     function changeValue(field){
          if(field.checked) {document.getElementById("strAct").value="1";}
          else {document.getElementById("strAct").value="0";}
          document.getElementById("socialNetUri").value="<%=socialnet.getURI()%>";
          field.form.action="<%=urlAction%>";
          field.form.submit();
      }
</script>

<div class="row"> 
    <div class="col-lg-12"> 
        <div class="panel panel-default">
                <div class="panel-heading">
                    <i class="fa fa-fw"></i> Datos Generales 
                       <%if(socialnet.isActive()){%>
                            <img class="swbIcon<%=socialnet.getClass().getSimpleName()%>" src="/swbadmin/js/dojo/dojo/resources/blank.gif"/> 
                       <%}else{%>
                            <img class="swbIcon<%=socialnet.getClass().getSimpleName()%>U" src="/swbadmin/js/dojo/dojo/resources/blank.gif"/> 
                       <%}%>     
                </div>
                <div class="panel-body">
                    <form name="streamGrlData" action=""> 
                        <p>
                        Cuenta de Red Social:<%=socialnet.getDisplayTitle(user.getLanguage())%>
                        </p>
                        <p>
                        <%if(socialnet.getDisplayDescription(user.getLanguage())!=null){%>
                        <%=socialnet.getDisplayDescription(user.getLanguage())%>
                        </p>
                        <%}%>
                        <%if(socialnet.isActive()) {%><label for = "socialNActive0">Activo</label><input type="checkbox" id="socialNActive0" name="socialNActive" value="0" checked onChange="changeValue(this);"><%
                        }else {%><label for = "socialNActive1">Activo</label><input type="checkbox" id="socialNActive1" name="socialNActive" value="1" onChange="changeValue(this);"> <%}
                        %>
                        <input type="hidden" name="active" id="strAct" value=""/>
                        <input type="hidden" name="socialNetUri" id="socialNetUri" value=""/>                        
                    </form>    
                </div>
         </div>
        <!-- /.panel-body -->
    </div>
    <!-- First Pair of Charts -->
    <div class="col-lg-6 col-md-12">
        <div class="panel panel-default">
                <div class="panel-heading">
                    <i class="fa fa-bar-chart-o fa-fw"></i> Pie Chart
                </div>
                <div class="panel-body">
                    <div id="chart_div" class="chart"></div>
                    <a href="#" class="btn btn-default btn-block">View Details</a>
                </div>
         </div>
        <!-- /.panel-body -->
    </div>
    <div class="col-lg-6 col-md-12">
        <div class="panel panel-default">
           <div class="panel-heading">
                <i class="fa fa-bar-chart-o fa-fw"></i> Pie Chart
            </div>
            <div class="panel-body">
                <div id="chart_div1" class="chart"></div>
                <a href="#" class="btn btn-default btn-block">View Details</a>
            </div>
            <!-- /.panel-body -->
         </div>
    </div>   
    <!-- Second Pair of Charts -->
    <div class="col-lg-6 col-md-12">
        <div class="panel panel-default">
                <div class="panel-heading">
                    <i class="fa fa-bar-chart-o fa-fw"></i> Pie Chart
                </div>
                <div class="panel-body">
                    <div id="chart_divStates" class="chart"></div>
                    <a href="#" class="btn btn-default btn-block">View Details</a>
                </div>
         </div>
        <!-- /.panel-body -->
    </div>
    <div class="col-lg-6 col-md-12">
        <div class="panel panel-default">
           <div class="panel-heading">
                <i class="fa fa-bar-chart-o fa-fw"></i> Pie Chart
            </div>
            <div class="panel-body">
                <div id="chart_divUsStates" class="chart"></div>
                <a href="#" class="btn btn-default btn-block">View Details</a>
            </div>
            <!-- /.panel-body -->
         </div>
    </div>   
    
    
</div>
<%!
     private String getAllPostInStream_Query(Stream stream) {
        String query =
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
                + "PREFIX social: <http://www.semanticwebbuilder.org/swb4/social#>"
                + "\n";
        //query+="select count(*)\n";    
        query += "select DISTINCT (COUNT(?postUri) AS ?c1) \n";    //Para Gena
        query +=
                "where {\n"
                + "  ?postUri social:postInStream <" + stream.getURI() + ">. \n"
                + "  }\n";
        ////System.out.println("query:"+query);
        WebSite wsite = WebSite.ClassMgr.getWebSite(stream.getSemanticObject().getModel().getName());
        query = SWBSocial.executeQuery(query, wsite);
        return query;
    }
     
    public double round(float number) {
        return Math.rint(number * 100) / 100;
    }

    public ArrayList addArray(Object lista, PostIn postIn) {
        if (lista == null) {
            lista = new ArrayList<PostIn>();
        }
        ArrayList l = (ArrayList) lista;
        l.add(postIn);
        return l;

    }

    public String replace(String cadena) {
        String original = "??????????????u???????????????????";
        // Cadena de caracteres ASCII que reemplazar?n los originales.
        String ascii = "aaaeeeiiiooouuunAAAEEEIIIOOOUUUNcC";
        String output = cadena;
        for (int i = 0; i < original.length(); i++) {
            // Reemplazamos los caracteres especiales.
            output = output.replace(original.charAt(i), ascii.charAt(i));
        }//for i

        return output;
    }

%>