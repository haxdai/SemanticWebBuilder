<%--
    SemanticWebBuilder Process (SWBP) es una plataforma para la gesti�n de procesos de negocio mediante el uso de 
     tecnolog�a sem�ntica, que permite el modelado, configuraci�n, ejecuci�n y monitoreo de los procesos de negocio
     de una organizaci�n, as� como el desarrollo de componentes y aplicaciones orientadas a la gesti�n de procesos.

     Mediante el uso de tecnolog�a sem�ntica, SemanticWebBuilder Process puede generar contextos de informaci�n
     alrededor de alg�n tema de inter�s o bien integrar informaci�n y aplicaciones de diferentes fuentes asociadas a
     un proceso de negocio, donde a la informaci�n se le asigna un significado, de forma que pueda ser interpretada
     y procesada por personas y/o sistemas. SemanticWebBuilder Process es una creaci�n original del Fondo de 
     Informaci�n y Documentaci�n para la Industria INFOTEC.

     INFOTEC pone a su disposici�n la herramienta SemanticWebBuilder Process a trav�s de su licenciamiento abierto 
     al p�blico (?open source?), en virtud del cual, usted podr� usarlo en las mismas condiciones con que INFOTEC 
     lo ha dise�ado y puesto a su disposici�n; aprender de �l; distribuirlo a terceros; acceder a su c�digo fuente,
     modificarlo y combinarlo (o enlazarlo) con otro software. Todo lo anterior de conformidad con los t�rminos y 
     condiciones de la LICENCIA ABIERTA AL P�BLICO que otorga INFOTEC para la utilizaci�n de SemanticWebBuilder Process. 

     INFOTEC no otorga garant�a sobre SemanticWebBuilder Process, de ninguna especie y naturaleza, ni impl�cita ni 
     expl�cita, siendo usted completamente responsable de la utilizaci�n que le d� y asumiendo la totalidad de los 
     riesgos que puedan derivar de la misma. 

     Si usted tiene cualquier duda o comentario sobre SemanticWebBuilder Process, INFOTEC pone a su disposici�n la
     siguiente direcci�n electr�nica: 
     http://www.semanticwebbuilder.org.mx

    Document   : userTaskInboxConfig
    Created on : 2/08/2011, 05:23:33 PM
    Author     : Hasdai Pacheco {haxdai@gmail.com}
--%>

<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>

<%
SWBParamRequest paramRequest = (SWBParamRequest)request.getAttribute("paramRequest");
String displayCols = (String) request.getAttribute("displayCols");

if (paramRequest.getMode().equals("config")) {
    SWBResourceURL configActionUrl = paramRequest.getActionUrl().setAction("setDisplay");
    %>
    <h2>Configuraci�n del despliegue</h2>
    <form action="<%=configActionUrl%>" method="post">
        <fieldset><legend>Seleccione las columnas a desplegar:</legend>
            <input type="checkbox" name="idCol" <%=displayCols.contains("idCol")?"checked=\"checked\"":""%>/>
            <label for="idCol">Identificador de la instancia</label><br>
            <input type="checkbox" name="pnameCol" <%=displayCols.contains("pnameCol")?"checked=\"checked\"":""%>/>
            <label for="pnameCol">Nombre del proceso</label><br>
            <input type="checkbox" name="nameCol" <%=displayCols.contains("nameCol")?"checked=\"checked\"":""%>/>
            <label for="nameCol">Nombre de la tarea</label><br>
            <input type="checkbox" name="sdateCol" <%=displayCols.contains("sdateCol")?"checked=\"checked\"":""%>/>
            <label for="sdateCol">Fecha de inicio de la instancia</label><br>
            <input type="checkbox" name="edateCol" <%=displayCols.contains("edateCol")?"checked=\"checked\"":""%>/>
            <label for="edateCol">Fecha de fin de la instancia</label><br>
            <!--input type="checkbox" name="actionsCol" <%=displayCols.contains("actionsCol")?"checked=\"checked\"":""%>/-->
            <!--label for="actionsCol">Acciones</label><br-->
        </fieldset>
        <fieldset>
            <input type="submit" value="Guardar" >
            <input type="button" value="Regresar" onclick="window.location='<%=paramRequest.getRenderUrl().setMode(paramRequest.Mode_VIEW)%>';" >
        </fieldset>
    </form>
    <%
}
%>