<%@page import="java.util.HashMap"%>
<%@page import="java.io.File"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.infotec.eworkplace.swb.Proyecto"%>
<%@page import="org.semanticwb.model.WebSite"%>
<%@page import="org.semanticwb.SWBPortal"%>
<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>

<%
SWBParamRequest paramRequest = (SWBParamRequest)request.getAttribute("paramRequest");
String path = SWBPortal.getWorkPath() + "/PS_Tableros.csv";
String siteid = "eworkplace";

WebSite site = WebSite.ClassMgr.getWebSite(siteid);
HashMap<String, Proyecto> proyectos = new HashMap<String, Proyecto>();

//Crear mapa de proyectos existentes
Iterator<Proyecto> it_proyectos = Proyecto.ClassMgr.listProyectos(site);
while (it_proyectos.hasNext())  {
    Proyecto proy = it_proyectos.next();
    proyectos.put(proy.getNumeroProyecto(), proy);
}

int cProys = 0;
int mProys = 0;

try {
    
    BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(new File(path))));
    String aux = null;
    while((aux = in.readLine()) != null) {
        String [] data = aux.split(",");
        if (data.length == 3) {
            if (proyectos.containsKey(data[0].trim())) {
                proyectos.get(data[0]).setTitle(data[1].trim().toUpperCase());
                proyectos.get(data[0]).setUbicacionProyecto(data[2].trim().toUpperCase());
                %>Proyecto <b><%=data[1]%></b> modificado<br/><%
                mProys++;
            } else {
                Proyecto proy = Proyecto.ClassMgr.createProyecto(site);
                proy.setNumeroProyecto(data[0].trim());
                proy.setTitle(data[1].trim().toUpperCase());
                proy.setUbicacionProyecto(data[2].trim().toUpperCase());
                %>Proyecto <%=data[1]%> creado<%
                cProys++;
            }
        }
    }
    in.close();  
} catch (Exception e){

}
%>
<br/>Carga de (<%=(cProys+mProys)%>) proyectos finalizada: <%=cProys%> proyectos creados, <%=mProys%> proyectos modificados.