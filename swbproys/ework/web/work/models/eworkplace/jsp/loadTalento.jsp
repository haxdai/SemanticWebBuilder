<%-- 
    Document   : loadTalento
    Created on : 6/03/2012, 06:32:11 PM
    Author     : juan.fernandez
--%>

<%@page import="com.infotec.cvi.swb.TipoTalento"%>
<%@page import="com.infotec.cvi.swb.Habilidad"%>
<%@page import="org.semanticwb.SWBUtils"%>
<%@page import="org.semanticwb.SWBPlatform"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.infotec.cvi.swb.EntidadFederativa"%>
<%@page import="com.infotec.cvi.swb.Colonia"%>
<%@page import="com.infotec.cvi.swb.Municipio"%>
<%@page import="com.infotec.cvi.swb.CP"%>
<%@page import="java.util.StringTokenizer"%>
<%@page import="org.semanticwb.SWBPortal"%>
<%@page import="java.util.Iterator, java.io.*"%>
<%@page import="org.semanticwb.model.*" %>

<%
            String wsid = request.getParameter("wsid");
            String fileid = request.getParameter("csvfile");

            if (wsid == null) {
                wsid = "";
            }
            wsid="eworkplace";
            WebSite wsite = WebSite.ClassMgr.getWebSite(wsid);
            if(request.getParameter("del")!=null&&request.getParameter("del").equals("true")){
                Iterator<Habilidad> itdest = Habilidad.ClassMgr.listHabilidads(wsite);
                wsite.begin(); 
                while(itdest.hasNext()){
                    Habilidad t_col = itdest.next();
                    t_col.remove();
                }
                
                System.out.println("Se eliminaron Habilidades");
                Iterator<TipoTalento> itest = TipoTalento.ClassMgr.listTipoTalentos(wsite); 
                while(itest.hasNext()){
                    TipoTalento t_cp = itest.next();
                    t_cp.remove();
                } 
                System.out.println("Se eliminaron Tipo Talento");
                wsite.commit();
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

                    //fileid = "C:\\data_jafa\\Java\\tomcatCVI\\apache-tomcat-7.0.25\\webapps\\ROOT\\work\\models\\eworkplace\\data\\talento.csv";
                    fileid = "/opt/tomcat/webapps/ROOT/work/models/eworkplace/data/talento.csv";
        
                    //fileid=null;
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
            // Se tiene que brincar los dos primeros renglones
                            TipoTalento ttalento = null;
                            Habilidad habilidad = null;
                                
                            String strTalento = null; //1a. Talento
                            String idTalento = null;

                            String strHabil = null; //2a. Habilidad
                            String idHabil = null;

                            int num=0;
                            while ((thisLine = myInput.readLine()) != null) {
                                num++;
                                out.print("<tr>");
                                StringTokenizer strar = new StringTokenizer(thisLine,"|");
                                
                                if(strar.hasMoreTokens()) strTalento = strar.nextToken(); //1a. Talento
                                idTalento = SWBUtils.TEXT.replaceSpecialCharacters(strTalento, true);
                                
                                if(strar.hasMoreTokens()) strHabil = strar.nextToken(); //4a. Municipio
                                idHabil = SWBUtils.TEXT.replaceSpecialCharacters(strHabil, true);                                                                                            

                                ttalento = TipoTalento.ClassMgr.getTipoTalento(idTalento, wsite);
                                if(null==ttalento){
                                   ttalento = TipoTalento.ClassMgr.createTipoTalento(idTalento, wsite); 
                                   ttalento.setTitle(strTalento);
                                }
                                
                                habilidad = Habilidad.ClassMgr.getHabilidad(idHabil, wsite);
                                if(null==habilidad){
                                    habilidad = Habilidad.ClassMgr.createHabilidad(idHabil, wsite);
                                    habilidad.setTitle(strHabil);
                                }
                                
                                if(ttalento!=null&&habilidad!=null){
                                    habilidad.setTipoTalento(ttalento);
                                }
                                   
                                out.print("<td>" + thisLine + "</td>");                                                            
                                out.print("<td>" + strTalento + "</td>");
                                out.print("<td>" + strHabil + "</td>");
                                
                                if (ttalento!=null&&habilidad != null) {
                                    out.print("<td> ok </td>");
                                } else {
                                    out.print("<td> No se pudo crear </td>");
                                }
                                out.println("</tr>");
                                i++;
                            }
%>
<tr><td colspan="4">Se generaron <%=i%> registros al catalogo de Tipo Talento - Habilidad  </td></tr>
<%
                            }
            %>
        </table>
    </body>
</html>
