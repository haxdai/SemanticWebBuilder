<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<%@page import="org.semanticwb.model.WebSite"%>
<%@page import="org.semanticwb.model.User"%>
<%
    String msg=request.getParameter("msg");
    if(msg!=null)
    {
        if(msg.equals("ok")){
            %>
 <pre>
    <b>Gracias por registrarse en este portal, se le ha enviado un correo electr�nico para que usted
    confirme su registro.
    </b>
 </pre>
            <%
        }else if(msg.equals("regfail")){
            %>
                <pre>
                    <b><font color="red">Error al registrar el usuario, favor de volverlo a intentar
                    <a href="javascript:history.go(-1);">Regresar</a></font></b>
                </pre>
            <%
        }
    }else if(request.getAttribute("2confirm")!=null){
        SWBParamRequest paramRequest=(SWBParamRequest)request.getAttribute("paramRequest");
        WebSite website=paramRequest.getWebPage().getWebSite();
        User user=(User)request.getAttribute("user");
        %>
            <pre>
                <b>
                Hola <%=user.getFullName()%>,<br/>
                te damos la m�s cordial bienvenida a este sitio y te informamos<br>
                que haz quedado registrado en el portal de <%=website.getDisplayTitle(user.getLanguage())%>
                </b>
            </pre>
            <meta http-equiv="refresh" content="3;url=<%=website.getHomePage().getUrl()%>" />

        <%
    }
   
%>
