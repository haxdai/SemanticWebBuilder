<%@page import="org.semanticwb.portal.api.*"%>
<%@page import="org.semanticwb.model.WebSite"%>
<%@page import="org.semanticwb.model.User"%>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest"/>
<%
            String url = (String) request.getAttribute("url");
            /*   String msg = request.getParameter("msg");
            if(msg==null)
            msg = (String)request.getAttribute("msg");
            if(msg!=null) {
            if(msg.equalsIgnoreCase("ok")){
             */%>
<%/*
            }
            }else if(request.getAttribute("2confirm")!=null) {
            WebSite website = paramRequest.getWebPage().getWebSite();
            User user=(User)request.getAttribute("user");
             */%>
<div id="icv">
    <%//@include file="../menucvi.jsp" %>
    <div id="icv-data">
        <pre>
                <strong>
                Hola <%//=user.getFullName()%>,<br/>
                te damos la más cordial bienvenida a este sitio y te informamos<br/>
                que haz quedado registrado en el portal de <%//=website.getDisplayTitle(user.getLanguage())%>.<br/><br/>
                Es importante que te firmes en el portal con tu clave y password que nos
                proporcionaste e ingreses a la página de tu perfil a actualizar tus datos.
                </strong>
<a href="<%=url%>">entrar</a>
        </pre>
        <script type="text/javascript">
            <!--
            //setTimeout("function(){window.location.href='<%//=website.getHomePage().getUrl()%>'}",5000);
            -->
        </script>
    </div>
</div>
<%
//    }

%>
