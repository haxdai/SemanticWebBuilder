<%-- 
    Document   : loadEdoMuniColCP
    Created on : 5/03/2012, 12:40:09 PM
    Author     : juan.fernandez
--%>

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
                wsite.getSemanticObject().getModel().setTraceable(false); 
                Iterator<Colonia> itdest = Colonia.ClassMgr.listColonias(wsite);
                wsite.begin(); 
                while(itdest.hasNext()){
                    
                    Colonia t_col = itdest.next();
                    t_col.remove();
                }
                
                System.out.println("Se eliminaron Colonias");
                
                Iterator<CP> itest = CP.ClassMgr.listCPs(wsite);
                while(itest.hasNext()){
                    CP t_cp = itest.next();
                    t_cp.remove();
                } 
                System.out.println("Se eliminaron CP");
                
                Iterator<Municipio> itaest = Municipio.ClassMgr.listMunicipios(wsite);
                while(itaest.hasNext()){
                    Municipio t_est = itaest.next();
                    t_est.remove();
                } 
                System.out.println("Se eliminaron Municipios");
                
                Iterator<EntidadFederativa> ittest = EntidadFederativa.ClassMgr.listEntidadFederativas(wsite);
                while(ittest.hasNext()){
                    EntidadFederativa  t_est = ittest.next();
                    t_est.remove();
                } 
                wsite.commit();
                wsite.getSemanticObject().getModel().setTraceable(true);
                System.out.println("Se eliminaron Estados"); 
                System.out.println("Catalogo Eliminado");                                 
            }                   

%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Creaci&oacute;n de catalogo de CP con archivo csv.</h1>
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
        
                    String estado = "aguascalientes";
                    if(request.getParameter("edo")!=null) estado = request.getParameter("edo");

                    //fileid = "C:\\data_jafa\\Java\\tomcatCVI\\apache-tomcat-7.0.25\\webapps\\ROOT\\work\\models\\eworkplace\\data\\aguascalientesCP.csv";
                    //fileid = "/opt/tomcat/webapps/ROOT/work/models/eworkplace/data/"+estado+"CP.csv";
        
                    fileid = SWBUtils.getApplicationPath()+"work/models/eworkplace/data/"+estado+"CP.csv";
                    //fileid=null;
                    //WebSite wsite = WebSite.ClassMgr.getWebSite(wsid);

                    //CP cptmp = CP.ClassMgr.getCP("31124", wsite); 
                    //Colonia coltmp = Colonia.ClassMgr.createColonia(SWBUtils.TEXT.replaceSpecialCharacters("Misiones Universidad I, II y III", true), wsite);
                    //coltmp.setTitle("Misiones Universidad I, II y III");
                    //EntidadFederativa enttmp = EntidadFederativa.ClassMgr.getEntidadFederativa(SWBUtils.TEXT.replaceSpecialCharacters("Chihuahua", true), wsite);
                    //Municipio munitmp = Municipio.ClassMgr.getMunicipio(SWBUtils.TEXT.replaceSpecialCharacters("Chihuahua", true), wsite);
                    
                    //cptmp.addColonia(coltmp);
                    //coltmp.setCpInv(cptmp);
                    //munitmp.addColonias(coltmp);
                    //coltmp.setMunicipioColoniasInv(munitmp);
                    
                    //31124|Misiones Universidad I, II y III|Chihuahua|Chihuahua
                    
                    if (wsite != null && fileid != null) {
                        String fName = fileid;
                        String thisLine;
                        FileInputStream fis = new FileInputStream(fName);
                        DataInputStream myInput = new DataInputStream(fis);
                        int i = 0;
        %>
        <h2><%=estado%></h2>
        <table border="1" style="font-family: arial; font-size: 9px;">
            <%
            // Se tiene que brincar los dos primeros renglones
                            EntidadFederativa entidad = null;
                            Municipio municipio = null;
                            Colonia colonia = null;
                            CP cp = null;
                            
                            String noTomar = null;;
                                
                            String strCol = null; //2a. Colonia
                            String idCol = null;

                            String strMuni = null; //4a. Municipio
                            String idMuni = null;

                            String strEdo = null; //5a. Estado
                            String idEdo = null;

                            String strCP = null; //7a. CP
                            String idCP = null;
                            wsite.getSemanticObject().getModel().setTraceable(false);
                            wsite.begin();
                            int num=0;
                            while ((thisLine = myInput.readLine()) != null) {
                                num++;
                                if(num==1) continue;

                                out.print("<tr>");
                                StringTokenizer strar = new StringTokenizer(thisLine,"|");

                                if(strar.hasMoreTokens()) strCP = strar.nextToken(); //1a. CP
                                idCP = SWBUtils.TEXT.replaceSpecialCharacters(strCP, true);
                                
                                if(strar.hasMoreTokens()) strCol = strar.nextToken(); //2a. Colonia
                                idCol = SWBUtils.TEXT.replaceSpecialCharacters(strCol, true);
                                
                                if(strar.hasMoreTokens()) strMuni = strar.nextToken(); //3a. Municipio
                                idMuni = SWBUtils.TEXT.replaceSpecialCharacters(strMuni, true);
                                
                                if(strar.hasMoreTokens()) strEdo = strar.nextToken(); //4a. Estado
                                idEdo = SWBUtils.TEXT.replaceSpecialCharacters(strEdo, true);                                                                                         

                                if(entidad!=null&&!idEdo.equals(entidad.getId())) entidad=null;
                                    
                                if(null==entidad) entidad = EntidadFederativa.ClassMgr.getEntidadFederativa(idEdo, wsite);
                                if(null==entidad){
                                   entidad = EntidadFederativa.ClassMgr.createEntidadFederativa(idEdo, wsite); 
                                   entidad.setTitle(strEdo);
                                }
                                 
                                if(municipio!=null&&!idMuni.equals(municipio.getId())) municipio=null;
                                if(municipio==null) municipio = Municipio.ClassMgr.getMunicipio(idMuni, wsite);
                                if(null==municipio){
                                    municipio = Municipio.ClassMgr.createMunicipio(idMuni, wsite);
                                    municipio.setTitle(strMuni);
                                }
                                
                                if(entidad!=null&&municipio!=null){
                                    if(!entidad.hasMunicipios(municipio)){
                                        entidad.addMunicipios(municipio);
                                        municipio.setEntidadInv(entidad);
                                    }
                                }
                                
                                idCol = idEdo.substring(0,2)+"_"+idMuni.substring(0,2)+"_"+idCol;
                                
                                if(colonia!=null&&!idCol.equals(colonia.getId())) colonia = null; 
                                if(colonia==null) colonia = Colonia.ClassMgr.getColonia(idCol, wsite);
                                if(null==colonia){
                                    colonia = Colonia.ClassMgr.createColonia(idCol, wsite);
                                    colonia.setTitle(strCol);
                                }
                                
                                
                                if(cp!=null&&!idCP.equals(cp.getId())) cp = null; 
                                if(cp==null) cp = CP.ClassMgr.getCP(idCP, wsite);
                                if(null==cp){
                                    cp = CP.ClassMgr.createCP(idCP, wsite);
                                    cp.setTitle(strCP); 
                                }
                                
                                if(municipio!=null&&colonia!=null&&cp!=null){
                                    if(!municipio.hasColonias(colonia)){
                                        municipio.addColonias(colonia);
                                    }
                                    if(!municipio.hasCP(cp)){
                                        municipio.addCP(cp);
                                    }
                                    colonia.setMunicipioColoniasInv(municipio);
                                    colonia.setCpInv(cp);
                                    cp.setMunicipioCPInv(municipio);
                                    if(!cp.hasColonia(colonia)){
                                        cp.addColonia(colonia);
                                    }
                                }
                                
                                out.print("<td>" + strEdo + "</td>");
                                out.print("<td>" + strMuni + "</td>");
                                out.print("<td>" + strCP + "</td>");
                                out.print("<td>" + strCol + "</td>");
                                
                                if (entidad!=null&&municipio != null&&colonia!=null&&cp!=null) {
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
<tr><td colspan="4">Se generaron <%=i%> registros al catalogo de Entidad - Municipio - Colonia - CP  </td></tr>
<%
                            }
            %>
        </table>
    </body>
</html>
