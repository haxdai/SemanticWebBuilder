<%-- 
    Document   : loadCatalogCarrera
    Created on : 17/02/2012, 01:47:52 PM
    Author     : juan.fernandez
--%>

<%@page import="java.util.StringTokenizer"%>
<%@page import="com.infotec.cvi.swb.Carrera"%>
<%@page import="com.infotec.cvi.swb.AreaCarrera"%>
<%@page import="com.infotec.cvi.swb.TipoCarrera"%>
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
                Iterator<Carrera> itc = Carrera.ClassMgr.listCarreras(wsite);
                while(itc.hasNext()){
                    Carrera this_c = itc.next();
                    this_c.remove();
                }  
                Iterator<AreaCarrera> itac = AreaCarrera.ClassMgr.listAreaCarreras(wsite);
                while(itac.hasNext()){
                    AreaCarrera this_ac = itac.next();
                    this_ac.remove();
                }
                Iterator<TipoCarrera> ittc = TipoCarrera.ClassMgr.listTipoCarreras(wsite);
                while(ittc.hasNext()){
                    TipoCarrera this_tc = ittc.next();
                    this_tc.remove();
                }
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
                                        Iterator<WebSite> it = WebSite.ClassMgr.listWebSites();
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

        //fileid = "C:\\data_jafa\\Java\\tomcatCVI\\apache-tomcat-7.0.25\\webapps\\ROOT\\work\\models\\eworkplace\\data\\licenciaturas.csv"; /opt/tomcat/webapps/ROOT/work/models/eworkplace/data
                    fileid = "/opt/tomcat/webapps/ROOT/work/models/eworkplace/data/licenciaturas.csv";
        
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
                            TipoCarrera tcarr = null;
                            AreaCarrera acarr = null;
                            Carrera carr = null;
                            while ((thisLine = myInput.readLine()) != null) {

                                out.print("<tr>");
                                StringTokenizer strar = new StringTokenizer(thisLine,"|");
                                //TipoCarrera, AreaCarrera, Carrera
                                
                                String tipoCarrera = strar.nextToken();
                                String areaCarrera = null;
                                if(strar.hasMoreTokens()) areaCarrera=strar.nextToken();
                                String carrera = null;
                                if(strar.hasMoreTokens()) carrera = strar.nextToken();

                                if(tcarr!=null&&tipoCarrera!=null&&tipoCarrera.trim().length()>0){
                                    tcarr=null; 
                                }
                                
                                if(tcarr==null&&tipoCarrera!=null&&tipoCarrera.trim().length()>0){
                                        
                                    tcarr = TipoCarrera.ClassMgr.createTipoCarrera(wsite);
                                    tipoCarrera = tipoCarrera.trim();
                                    tcarr.setTitle(tipoCarrera);
                                }
                                if(acarr!=null&&areaCarrera!=null&&areaCarrera.trim().length()>0){
                                    acarr=null; 
                                }
                                if(tcarr!=null&&acarr==null&&areaCarrera!=null&&areaCarrera.trim().length()>0){
                                    acarr = AreaCarrera.ClassMgr.createAreaCarrera(wsite);
                                    areaCarrera = areaCarrera.trim();
                                    acarr.setTitle(areaCarrera);
                                    tcarr.addArea(acarr);
                                    acarr.setTipoCarreraInv(tcarr);
                                }
                                if(carr!=null&&carrera!=null&&carrera.trim().length()>0){
                                    carr=null; 
                                }
                                if(acarr!=null&&carr==null&&carrera!=null&&carrera.trim().length()>0){
                                    carr = Carrera.ClassMgr.createCarrera(wsite);
                                    carrera = carrera.trim();
                                    carr.setTitle(carrera);
                                    carr.setAreaCarrera(acarr);

                                }

                                out.print("<td>" + tipoCarrera + "</td>");
                                out.print("<td>" + areaCarrera + "</td>");
                                out.print("<td>" + carrera + "</td>");
                                
                                if (tcarr != null&&acarr!=null&&carr!=null) {
                                    out.print("<td> ok </td>");
                                } else {
                                    out.print("<td> No se pudo crear </td>");
                                }
                                out.println("</tr>");
                                i++;
                            }
%>
<tr><td colspan="4">Se generaron <%=i%> registros al catalogo de carreras</td></tr>
<%
                            }
            %>
        </table>
    </body>
</html>


