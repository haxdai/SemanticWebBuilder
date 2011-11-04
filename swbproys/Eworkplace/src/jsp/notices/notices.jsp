<%@page import="java.util.Comparator"%>
<%@page import="java.util.HashMap"%>
<%@page import="org.semanticwb.model.User"%>
<%@page import="org.semanticwb.model.WebPage"%>
<%@page import="org.semanticwb.SWBPortal"%>
<%@page import="org.semanticwb.portal.util.SWBPriorityComparator"%>
<%@page import="org.semanticwb.model.SWBComparator"%>
<%@page import="java.util.*"%>
<%@page import="org.semanticwb.model.Resource"%>
<%@page import="org.semanticwb.model.ResourceSubType"%>
<%@page import="org.semanticwb.model.WebSite"%><%!

    String getString(String str)
    {
        if(str==null)
            return "";
        if(str.length()>80)      
            str=str.substring(0, 79)+"...";   
        str=str.replace("'", "");
        return str;
    }
%><%

    User user = (User) request.getAttribute("user");
    String lang = user.getLanguage();
    WebPage topic = (WebPage) request.getAttribute("topic");
    if(topic == null)
        return;
    HashMap params = (HashMap) request.getAttribute("params");
    if(params == null)
        return;
    WebSite site = topic.getWebSite();
    if(site == null)
        return;
    String subtype = (String) params.get("noticessubtype");
    if(subtype == null)
        return;
    ResourceSubType stype = site.getResourceSubType(subtype);
    if(stype == null)
        return;

    String titleFirst=null;
    String descriptionFist=null;
    String urlFist=null;
    Iterator<Resource> it = stype.listResources();
   
    StringBuilder titles = new StringBuilder("var titles = [];\n");
    StringBuilder urls = new StringBuilder("var urls = [];\n");
    int notices = 0;
    while (it.hasNext())
    {
        Resource res = it.next();
        String title = getString(res.getAttribute("msg", "..."));
        if(titleFirst==null)
            titleFirst=title;     
        titles.append("titles.push('"+title+"'); ");
        
        res.incViews();
        String url = res.getAttribute("url","#");
        if(urlFist==null)
            urlFist=url;
        urls.append("urls.push('"+url+"');");
        notices++;
    }
%>

<script type="text/javascript">
<!--
    var currentIndex=0;
    <%=titles%>
    <%=urls%>
                
    changeIndex(0);
    function changeImageBack()
    {
        if(currentIndex>0)
        {
            currentIndex--;
        }
        change();
    }
    function changeIndex(index)
    {
        if(index>=0 & index<titles.length)
        {
            currentIndex=index
        }
        change();
    }
    function changeImageNext()
    {
        if(currentIndex<(titles.length-1))
        {
            currentIndex++;
        }
        change();
    }
    function change()
    {
        if(titles.length==0)
            return;
        /*var carrusel=document.getElementById("imgEnterate");
        if(carrusel)
        {                
            carrusel.style.backgroundImage="url('"+ imageArray[currentIndex] +"')";                
        }*/
        var titleEnterate=document.getElementById("titleEnterate");
        if(titleEnterate)
        {
            titleEnterate.innerHTML=titles[currentIndex];
        }
        /*var descriptionEnterate=document.getElementById("descriptionEnterate");
        if(descriptionEnterate)
        {
            descriptionEnterate.innerHTML=descriptions[currentIndex];
        }*/
        /*var urlEnterate=document.getElementById("urlEnterate");
        if(urlEnterate)
        {
            var host=document.location.protocol+"//"+document.location.host;
            urlEnterate.href=urls[currentIndex];
            var anchor=urlEnterate;
            anchor.target = "_self";
            anchor.onclick =function(){}
            if ((anchor.href && anchor.href.indexOf(host)!=0 && anchor.href.indexOf("javascript")!=0) || anchor.href.indexOf("/_swbextlink/")>0)
            {
                var oldOnClick=anchor.onclick;

                anchor.onclick = function()
                {
                    var r=confirm("La página solicitada está en un sitio externo y se abrirá en una ventana nueva. ¿Deseas continuar?");
                    if(r && oldOnClick)return oldOnClick();
                    return r;
                }
                anchor.target = "_blank";
            }

        }*/

    }
-->
</script>
<h4>Avisos(<%=Integer.toString(notices)%>)</h4>
<div id="carrusel">
<%
    if (notices > 0)
    {
%>
    <div  class="carrusel_transparent">
        <p>
            <%
                if(notices>1)
                {
                    %>
                    <span class="atras"><a href="javascript:changeImageBack()" >anterior</a></span>
                    <%
                }
            %>

            <span class="num">

                <%
                    if(notices>1)
                    {
                                for (int j = 0; j < notices; j++)
                                {
                %>
                <a href="javascript:changeIndex(<%=j%>)" ><%=j + 1%></a>
                <%
                                }
                    }
                %>
            </span>
                <%
                if(notices>1)
                    {
                    %>
                    <span class="adelante"><a href="javascript:changeImageNext()" >siguiente</a></span>
                    <%
                    }
                %>

        </p>
        <p class="noticia"><a id="urlEnterate" href="<%=urlFist%>" >Ir a la noticia</a></p>
    </div>
    <div id="imgEnterate" class="carrusel_fotos">
      </div>
    <h5 id="titleEnterate"><%=titleFirst%></h5>
    
<%
    }
%>
</div> 
