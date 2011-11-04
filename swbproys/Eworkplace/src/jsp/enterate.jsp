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
    static List<Resource> ramdomSelect(List<Resource> collection, int number)
    {
        if (collection.size() <= number)
        {
            return collection;
        }
        List<Resource> select = new ArrayList<Resource>();
        Random r = new Random();
        for (int i = 0; i < number; i++)
        {
            int index = r.nextInt(collection.size());
            Resource value = collection.get(index);
            select.add(value);
            collection.remove(index);
        }
        return select;
    }
   
    String getString(String str)
    {
        if (str == null)
            return "";
        /*if (str.length() > 91)
        {
            str = str.substring(0, 91) + "...";
        }*/
        str = str.replace("'", "");
        return str;
    }
%>


<%

            User user = (User) request.getAttribute("user");
            String lang = user.getLanguage();
            WebPage topic = (WebPage) request.getAttribute("topic");
            if (topic == null)
                return;
            HashMap params = (HashMap) request.getAttribute("params");
            if (params == null)
                return;
            WebSite site = topic.getWebSite();
            if (site == null)
                return;
            String bannertype = (String) params.get("bannersubtype");
            if (bannertype == null)
                return;
            ResourceSubType stype = site.getResourceSubType(bannertype);
            if (stype == null)
                return;

            String titleFirst = null;
            String descriptionFist = null;
            String urlFist = null;
            Iterator<Resource> it = stype.listResources();
            TreeSet set = new TreeSet(new Comparator()
            {

                public int compare(java.lang.Object obj, java.lang.Object obj1)
                {

                    Resource res1 = ((Resource) obj);
                    Resource res2 = ((Resource) obj1);
                    int index1 = 0;
                    int index2 = 0;
                    try
                    {
                        if (res1.getAttribute("index") != null && !res1.getAttribute("index").trim().equals(""))
                        {
                            try
                            {
                                index1 = Integer.parseInt(res1.getAttribute("index"));

                            }
                            catch (NumberFormatException nfe)
                            {
                            }
                        }

                        if (res2.getAttribute("index") != null && !res2.getAttribute("index").trim().equals(""))
                        {
                            try
                            {
                                index2 = Integer.parseInt(res2.getAttribute("index"));

                            }
                            catch (NumberFormatException nfe)
                            {
                            }
                        }
                    }
                    catch (Throwable t)
                    {
                    }
                    if (index1 > index2)
                        return 1;
                    else
                        return -1;


                }
            });
            int i = 0;
            while (it.hasNext())
            {
                Resource res = it.next();
                if (res.isActive() && user.haveAccess(res) && res.getAttribute("img") != null && !res.getAttribute("img").toLowerCase().endsWith(".swf"))
                {
                    set.add(res);
                    i++;
                    //if (i == 5)
                    //    break;

                }
            }
            List<Resource> resources = new ArrayList<Resource>();
            resources.addAll(set);
            resources = ramdomSelect(resources, 5);
            Iterator<Resource> it2 = resources.iterator();
            StringBuilder alts = new StringBuilder("var alts =[ ");
            StringBuilder descriptions = new StringBuilder("var descriptions =[ ");
            StringBuilder titles = new StringBuilder("var titles =[ ");
            StringBuilder images = new StringBuilder("var imageArray =[ ");
            StringBuilder urls = new StringBuilder("var urls =[ ");
            while (it2.hasNext())
            {
                Resource res = it2.next();
                String title = res.getDisplayTitle(lang);
                if (titleFirst == null)
                {
                    titleFirst = title;
                }
                titles.append("'");
                titles.append(title);
                titles.append("'");
                titles.append(",");
                String desc = getString(res.getDisplayDescription(lang));
                if (descriptionFist == null)
                {
                    descriptionFist = desc;
                }
                descriptions.append("'");
                descriptions.append(desc);
                descriptions.append("'");
                descriptions.append(",");
                String alt=res.getAttribute("alt","");
                String img = SWBPortal.getWebWorkPath() + res.getWorkPath() + "/" + res.getAttribute("img");
                res.incViews();
                String url = res.getAttribute("url");
                images.append("'");
                images.append(img);
                images.append("'");
                images.append(",");
                if (url == null)
                    url = "#";

                if (urlFist == null)
                {
                    urlFist = url;
                }
                urls.append("'");
                urls.append(url);
                urls.append("'");
                urls.append(",");

                alts.append("'");
                alts.append(alt);
                alts.append("'");
                alts.append(",");
            }
            images.deleteCharAt(images.length() - 1);
            titles.deleteCharAt(titles.length() - 1);
            descriptions.deleteCharAt(descriptions.length() - 1);
            urls.deleteCharAt(urls.length() - 1);

            images.append("];");
            titles.append("];");
            alts.append("];");
            descriptions.append("];");
            urls.append("];");
%>

<script type="text/javascript">
    <!--
    var currentIndex=0;
    <%=images%>
    <%=titles%>
    <%=descriptions%>
    <%=urls%>
        <%=alts%>
                
        
        function changeImageBack()
        {
            if(currentIndex>0)
            {
                currentIndex--;
            }
            changeImageCarrusel();
        }
        function changeIndex(index)
        {            
            if(index>=0 & index<imageArray.length)
            {
                currentIndex=index
            }            
            changeImageCarrusel();
        }
        function changeImageNext()
        {
            if(currentIndex<(imageArray.length-1))
            {
                currentIndex++;
            }
            changeImageCarrusel();
        }
        function changeImageCarrusel()
        {            
            if(imageArray.length==0)return;
            var carrusel=document.getElementById("TabbedPanelsContent");         
            if(carrusel)
            {                
                carrusel.style.backgroundImage="url('"+ imageArray[currentIndex] +"')";                
            }
            var titleEnterate=document.getElementById("titleEnterate");
            if(titleEnterate)
            {
                titleEnterate.innerHTML=titles[currentIndex];
            }
            var descriptionEnterate=document.getElementById("descriptionEnterate");
            if(descriptionEnterate)
            {
                descriptionEnterate.innerHTML=descriptions[currentIndex];
            }
            var altEnterate=document.getElementById("altEnterate");
            if(altEnterate)
            {
                altEnterate.innerHTML=alts[currentIndex];
            }
            var urlEnterate=document.getElementById("urlEnterate");
            if(urlEnterate)
            {
                urlEnterate.href=urls[currentIndex];
            }

        }
        -->
</script>
<script type="text/javascript">
    function changeBkPromoAccs(id,url)
    {
        var element=document.getElementById(id);
        if(element)
        {
            element.style.backgroundImage="url('"+ url +"')";
            element.style.backgroundRepeat ='no-repeat';
        }
    }
</script>

<div id="selector">&nbsp;</div>
<div id="TabbedPanels1" class="TabbedPanels">
    <ul class="TabbedPanelsTabGroup">
        <%
                    for (int j = 0; j < i; j++)
                    {
        %>
        <li class="TabbedPanelsTab"><%=j%></li>
        <%
                    }
        %>

    </ul>
    <div class="TabbedPanelsContentGroup">
        <%
        it2 = resources.iterator();
        while (it2.hasNext())
            {
                Resource res = it2.next();
                String title = res.getDisplayTitle(lang);

                String desc = getString(res.getDisplayDescription(lang));
                String alt=res.getAttribute("alt","");
                String url=res.getAttribute("url","#");
                String id="swb_ent_"+res.getId();
                String img = SWBPortal.getWebWorkPath() + res.getWorkPath() + "/" + res.getAttribute("img");
                %>
                 <div id="<%=id%>" class="TabbedPanelsContent">
            <div class="esbozo">
                <h3 id="titleEnterate"><%=title%></h3>
                <span id="altEnterate" class="tagline"><%=alt%></span>
                <p id="descriptionEnterate"> <%=desc%></p>
                <p><a id="urlEnterate" href="<%=url%>" >Ver más</a></p>
            </div>
                <script type="text/javascript">
                    changeBkPromoAccs('<%=id%>','<%=img%>');
                </script>
        </div>
                <%
                }
        %>
       
        <!-- <div class="TabbedPanelsContent">Content 2</div>
        <div class="TabbedPanelsContent">Content 3</div>
        <div class="TabbedPanelsContent">Content 4</div>
        <div class="TabbedPanelsContent">Content 5</div> -->
    </div>
</div>


<script type="text/javascript">
    //changeIndex(0);
     var currentIndex=0;
var TabbedPanels1 = new Spry.Widget.TabbedPanels("TabbedPanels1");
var timerID=0;
function fTimer() {
            
            var index=currentIndex+1;
        if(index==5)
            {
                index=0;
            }
        if(index>=0 & index<5)
            {                
                currentIndex=index;
                        timerID = setTimeout("fTimer()", 6000);
                        TabbedPanels1.showPanel(index);
                    
            }
        }
timerID = setTimeout("fTimer()", 6000);
TabbedPanels1.onTabClick=function(e, tab)
{    
    clearTimeout(timerID);
    TabbedPanels1.showPanel(tab);
    return TabbedPanels1.cancelEvent(e);
}

</script>