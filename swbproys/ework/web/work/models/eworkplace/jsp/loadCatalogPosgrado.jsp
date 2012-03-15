<%-- 
    Document   : loadCatalogPosgrado
    Created on : 17/02/2012, 05:41:13 PM
    Author     : juan.fernandez
--%>

<%@page import="org.semanticwb.SWBUtils"%>
<%@page import="com.infotec.cvi.swb.Estudios"%>
<%@page import="com.infotec.cvi.swb.AreaEstudio"%>
<%@page import="com.infotec.cvi.swb.DisciplinaEstudio"%>
<%@page import="com.infotec.cvi.swb.TipoEstudio"%>
<%@page import="java.util.StringTokenizer"%>
<%@page import="org.semanticwb.SWBPortal"%>
<%@page import="java.util.Iterator, java.io.*"%>
<%@page import="org.semanticwb.model.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<%
            String wsid = request.getParameter("wsid");
            String fileid = request.getParameter("csvfile");

            if (wsid == null) {
                wsid = "";
            }
            wsid="eworkplace";
            WebSite wsite = WebSite.ClassMgr.getWebSite(wsid);
            if(request.getParameter("del")!=null&&request.getParameter("del").equals("true")){
                wsite.getSemanticObject().getModel().setTraceable(false);
                wsite.begin();
                System.out.println("Eliminando catalogo estudios");
                Iterator<Estudios> itest = Estudios.ClassMgr.listEstudioses(wsite);
                while(itest.hasNext()){
                    Estudios t_est = itest.next();
                    t_est.remove();
                } 
                Iterator<AreaEstudio> itaest = AreaEstudio.ClassMgr.listAreaEstudios(wsite);
                while(itaest.hasNext()){
                    AreaEstudio t_est = itaest.next();
                    t_est.remove();
                } 
                Iterator<DisciplinaEstudio> itdest = DisciplinaEstudio.ClassMgr.listDisciplinaEstudios(wsite);
                while(itdest.hasNext()){
                    DisciplinaEstudio t_est = itdest.next();
                    t_est.remove();
                }
                Iterator<TipoEstudio> ittest = TipoEstudio.ClassMgr.listTipoEstudios(wsite);
                while(ittest.hasNext()){
                    TipoEstudio t_est = ittest.next();
                    t_est.remove();
                }  
                wsite.commit();
                wsite.getSemanticObject().getModel().setTraceable(true);
                System.out.println("Catalogo Eliminado");
            }                   
            
%>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Creaci&oacute;n de estructura con archivo csv.</h1>
        <form name="createwp" action="" method="post">
            <table>
                <tr>
                    <td>
                        Selecciona el sitio:
                    </td>
                    <td><select name="wsid">
                            <option value="0"> --- </option>
                            <%
                                        String wsSelected = "";
                                        Iterator<WebSite> it = SWBContext.listWebSites();
                                        while (it.hasNext()) {
                                            WebSite ws = it.next();
                                            wsSelected = "";
                                            if (ws.getId().equals(wsid)) {
                                                wsSelected = "selected";
                                            }
                            %>
                            <option value="<%=ws.getId()%>"  <%=wsSelected%> ><%=ws.getDisplayTitle("es")%></option>
                            <%
                                        }
                            %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <% if (fileid == null) {
                    %>
                    <td>
                        Selecciona el archivo excel (csv):
                    </td>
                    <td>
                        <input type="file" name="csvfile">
                    </td>
                    <%                 } else {
                    %>
                    <td>
                        Procesando el archivo excel (csv):
                    </td>
                    <td>
                        <input type="text" readonly name="csvfile" value="<%=fileid%>">
                    </td>

                    <%
                                }
                    %>
                </tr>
                <tr>
                    <td colspan="2">
                        <button type="submit">enviar</button>
                    </td>
                </tr>
            </table>
        </form>

        <%

        //fileid = "C:\\data_jafa\\Java\\tomcatCVI\\apache-tomcat-7.0.25\\webapps\\ROOT\\work\\models\\eworkplace\\data\\posgrado.csv";
                    //fileid = "/opt/tomcat/webapps/ROOT/work/models/eworkplace/data/posgrado.csv";
                    fileid = SWBUtils.getApplicationPath()+"work/models/eworkplace/data/posgrado.csv";
        
                    //WebSite wsite = WebSite.ClassMgr.getWebSite(wsid);

                    if (wsite != null && fileid != null) {
                        String fName = fileid;
                        String thisLine;
                        FileInputStream fis = new FileInputStream(fName);
                        DataInputStream myInput = new DataInputStream(fis);
                        int i = 0;
        %>
        <table border="1" style="font-family: arial; font-size: 9px;">
            <%
                            TipoEstudio tipoest = null;
                            DisciplinaEstudio disest = null;
                            AreaEstudio areaest = null;
                            Estudios est = null;
                            wsite.getSemanticObject().getModel().setTraceable(false);
                            wsite.begin();
                            while ((thisLine = myInput.readLine()) != null) {
                                out.print("<tr>");
                                StringTokenizer strar = new StringTokenizer(thisLine,"|");
                                String tipoEstudio = strar.nextToken();
                                String disEstudio = null;
                                if(strar.hasMoreTokens()) disEstudio = strar.nextToken();
                                String areaEstudio = null;
                                if(strar.hasMoreTokens()) areaEstudio = strar.nextToken();
                                String estudio = null;
                                if(strar.hasMoreTokens()) estudio = strar.nextToken();

                                if(tipoest!=null&&tipoEstudio!=null&&tipoEstudio.trim().length()>0){
                                    tipoest=null; 
                                }
                                
                                if(tipoest==null&&tipoEstudio!=null&&tipoEstudio.trim().length()>0){
                                    tipoest = TipoEstudio.ClassMgr.createTipoEstudio(wsite);
                                    tipoEstudio = tipoEstudio.trim();
                                    tipoest.setTitle(tipoEstudio);
                                }
                                if(disest!=null&&disEstudio!=null&&disEstudio.trim().length()>0){
                                    disest=null; 
                                }
                                if(tipoest!=null&&disest==null&&disEstudio!=null&&disEstudio.trim().length()>0){
                                    disest = DisciplinaEstudio.ClassMgr.createDisciplinaEstudio(wsite);
                                    disEstudio = disEstudio.trim();
                                    disest.setTitle(disEstudio);
                                    tipoest.addDisciplina(disest);
                                    disest.setTipoEstudioInv(tipoest);
                                }
                                if(areaest!=null&&areaEstudio!=null&&areaEstudio.trim().length()>0){
                                    areaest=null; 
                                }
                                if(disest!=null&&areaest==null&&areaEstudio!=null&&areaEstudio.trim().length()>0){
                                    areaest = AreaEstudio.ClassMgr.createAreaEstudio(wsite);
                                    areaEstudio = areaEstudio.trim();
                                    areaest.setTitle(areaEstudio);
                                    disest.addAreaEstudio(areaest);
                                    areaest.setDisciplinaInv(disest);
                                }
                                if(est!=null&&estudio!=null&&estudio.trim().length()>0){
                                    est=null; 
                                }
                                if(areaest!=null&&est==null&&estudio!=null&&estudio.trim().length()>0){
                                    est = Estudios.ClassMgr.createEstudios(wsite);
                                    estudio = estudio.trim();
                                    est.setTitle(estudio);
                                    est.setAreaEstudio(areaest);
                                }

                                out.print("<td>" + tipoEstudio + "</td>");
                                out.print("<td>" + disEstudio + "</td>");
                                out.print("<td>" + areaEstudio + "</td>");
                                out.print("<td>" + estudio + "</td>");
                                
                                if (tipoest!=null&&disest != null&&est!=null&&areaest!=null) {
                                    out.print("<td> ok </td>");
                                } else {
                                    out.print("<td> No se pudo crear </td>");
                                }
                                out.println("</tr>");
                                i++;
                            }
                            wsite.commit();
                            wsite.getSemanticObject().getModel().setTraceable(true);
%>
<tr><td colspan="4">Se generaron <%=i%> registros al catalogo de posgrado</td></tr>
<%
                            }
            %>
        </table>
    </body>
</html>



