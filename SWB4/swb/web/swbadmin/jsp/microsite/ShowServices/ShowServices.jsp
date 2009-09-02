<%@page import="java.text.*,java.net.*,org.semanticwb.platform.SemanticObject,org.semanticwb.portal.api.*,org.semanticwb.portal.community.*,org.semanticwb.*,org.semanticwb.model.*,java.util.*" %>
<div class="tabsTemas">
<ul>
<%
    User user=(User)request.getAttribute("user");
    String lang="es";
    if(user.getLanguage()!=null)
    {
        lang=user.getLanguage();
    }
    WebPage webpage = (WebPage) request.getAttribute("webpage");
    WebPage servicios = webpage.getWebSite().getWebPage("Servicios");
    Iterator<WebPage> pages=servicios.listVisibleChilds(lang); // ordenados por nombre
    int count=0;
    while(pages.hasNext())
    {
        WebPage child=pages.next();
        %>
        <li><img src="/work/models/Ciudad_Digital/css/iconos/hotel.png" alt="<%=child.getTitle()%>"><a href="<%=child.getUrl()%>"><%=child.getTitle()%></a></li>
        <%
        count++;
        if(count==8)
        {
            break;
        }

    }

%>
    </ul>
    <div class="clear">&nbsp;</div>
</div>
<div class="ademas">
    <div class="ademasHeader">
        <%
            if(pages.hasNext())
            {
                %>
                <p>Adem�s...</p>
                <%
            }
        %>
        <a href="<%=servicios.getUrl()%>">ver listado completo</a></div>
        <ul class="ademasContent">
        <%
            count=0;
            while(pages.hasNext())
            {
                WebPage child=pages.next();
                %>
                    <li><a href="<%=child.getUrl()%>"><%=child.getTitle()%></a></li>
                <%
                count++;
                if(count==15)
                {
                    break;
                }
            }
        %>
        <!--
        <li><a href="#">Galer�a de arte</a></li>
        <li><a href="#">Plaza p�blica</a></li>
        <li><a href="#">Clubes deportivos</a></li>
        <li><a href="#">Negocios</a></li>
        <li><a href="#">Playas</a></li>
        <li><a href="#">Cines</a></li>
        <li><a href="#">Industria</a></li>
        <li><a href="#">Barrios</a></li>
        <li><a href="#">Kioskos electr�nicos</a></li>
        <li><a href="#">Polic�a</a></li>
        <li><a href="#">Transporte</a></li>
        <li><a href="#">Bibliotecas</a></li>
        <li><a href="#">Avenidas principales</a></li>
        <li><a href="#">Iglesias</a></li> -->
    </ul>
    <div class="clear">&nbsp;</div>
</div>
