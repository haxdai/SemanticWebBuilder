<%@page import="org.semanticwb.model.ResourceType"%>
<%@page import="org.semanticwb.model.ResourceCollection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURLImp"%>
<%@page import="org.semanticwb.portal.resources.sem.news.SWBNews"%>
<%@page import="org.semanticwb.portal.resources.sem.news.SWBNewContent"%>
<%@page import="org.semanticwb.model.ResourceCollectionCategory"%>
<%@page import="org.semanticwb.portal.resources.sem.news.base.*"%>
<%@page import="java.util.*"%><%@page import="org.semanticwb.portal.indexer.searcher.SearchTerm"%><%@page import="org.semanticwb.model.Resourceable"%><%@page import="org.semanticwb.portal.indexer.searcher.SearchDocument"%><%@page import="org.semanticwb.portal.indexer.searcher.SearchResults"%><%@page import="org.semanticwb.portal.indexer.searcher.SearchQuery"%><%@page import="org.semanticwb.portal.indexer.SWBIndexer"%><%@page import="java.util.HashMap"%><%@page import="org.semanticwb.model.User"%><%@page import="org.semanticwb.model.WebPage"%><%@page import="org.semanticwb.SWBPortal"%><%@page import="org.semanticwb.portal.util.SWBPriorityComparator"%><%@page import="org.semanticwb.model.SWBComparator"%><%@page import="java.util.*"%><%@page import="org.semanticwb.model.Resource"%><%@page import="org.semanticwb.model.ResourceSubType"%><%@page import="org.semanticwb.model.WebSite"%>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest"/>
<%!
    class SWBNewContentComparator implements Comparator<SWBNewContent>
    {

        public int compare(SWBNewContent o1, SWBNewContent o2)
        {
            Date d1 = o1.getPublishDate();
            Date d2 = o2.getPublishDate();
            if (d1 == null)
            {
                d1 = o1.getResource().getCreated();
            }
            if (d2 == null)
            {
                d2 = o2.getResource().getCreated();
            }
            if (d1 != null && d2 != null)
            {
                return d1.compareTo(d2);
            }
            else
            {
                return o1.getResourceBase().getIndex() >= o2.getResourceBase().getIndex() ? 1 : -1;
            }
        }
    }

    private List<SWBNewContent> getNews(String uri, User user, SWBNews swbNews)
    {
        List<SWBNewContent> news = new ArrayList<SWBNewContent>();
        Iterator<Resource> resources = null;
        if (swbNews.getCollection() != null && swbNews.getCollection().getResourceCollectionType().getResourceClassName().equals(SWBNewContent.class.getCanonicalName()))
        {
            if (swbNews.getCategory() == null)
            {
                resources = swbNews.getCollection().listResources();
            }
            else
            {
                boolean isCategoryOfCallection = false;
                Iterator<ResourceCollectionCategory> categories = swbNews.getCollection().listCategories();
                while (categories.hasNext())
                {
                    ResourceCollectionCategory category = categories.next();
                    if (category.getURI().equals(swbNews.getCategory().getURI()))
                    {
                        isCategoryOfCallection = true;
                        break;
                    }
                }
                if (isCategoryOfCallection)
                {
                    resources = swbNews.getCategory().listResources();
                }
                else
                {
                    resources = swbNews.getCollection().listResources();
                }
            }
        }
        if (resources != null)
        {
            while (resources.hasNext())
            {
                Resource resource = resources.next();
                if (resource.isActive() && !resource.isDeleted() && user.haveAccess(resource))
                {
                    SWBNewContent object = (SWBNewContent) resource.getResourceData().createGenericInstance();
                    if (uri == null)
                    {
                        try
                        {
                            object.setResourceBase(resource);
                            news.add(object);
                        }
                        catch (Exception e)
                        {
                        }
                    }
                    else
                    {
                        if (uri.equals(resource.getURI()))
                        {

                            try
                            {
                                object.setResourceBase(resource);
                                news.add(object);
                            }
                            catch (Exception e)
                            {
                            }
                        }
                    }

                }
            }
        }
        return news;
    }

    public String clear(String var)
    {
        return var;
    }

    class WebPageInfo
    {

        String url;
        String title;

        public WebPageInfo(String url, String title)
        {
            this.url = url;
            this.title = title;
        }

        @Override
        public int hashCode()
        {
            return url.hashCode();
        }
        @Override
        public boolean equals(Object obj)
        {
            if(obj instanceof WebPageInfo)
                {
                WebPageInfo info=(WebPageInfo)obj;
                return info.url.equals(this.url);
                }
            return false;
        }
    }

    class TagInfo
    {

        final String tag;
        final ArrayList<WebPageInfo> pages = new ArrayList<WebPageInfo>();

        public TagInfo(String tag, HashSet<WebPageInfo> pages, WebPageInfo topic)
        {
            this.tag = tag;
            pages.remove(topic);
            this.pages.addAll(pages);
        }
    }
%><%
            User user = (User) paramRequest.getUser();
            String lang = user.getLanguage();
            WebPage topic = (WebPage) paramRequest.getWebPage();
            if (topic == null)
                return;


            HashSet<String> tags = new HashSet<String>();

            if (topic.getTags() != null)
            {
                StringTokenizer st = new StringTokenizer(topic.getTags(), " ");
                while (st.hasMoreTokens())
                {
                    String token = st.nextToken();
                    if (token != null)
                    {
                        token = token.trim();
                        if (!"".equals(token) && token.length() > 1)
                        {
                            tags.add(token);
                        }
                    }
                }
            }

            Iterator<Resource> resources = topic.listResources();
            while (resources.hasNext())
            {

                Resource resource = resources.next();

                if ("Grupo_de_noticias".equals(resource.getResourceType().getId()))
                {
                    SWBNews news = new SWBNews(resource.getResourceData());
                    List<SWBNewContent> listnews = getNews(null, user, news);
                    Collections.sort(listnews, new SWBNewContentComparator());
                    String uri = request.getParameter("uri");
                    if (uri == null)
                    {
                        for (SWBNewContent content : listnews)
                        {
                            if (content.getResourceBase().isValid())
                            {

                                String stags = content.getResourceBase().getTags();
                                if (stags != null)
                                {

                                    StringTokenizer st = new StringTokenizer(stags, " ");
                                    while (st.hasMoreTokens())
                                    {
                                        String token = st.nextToken();
                                        if (token != null)
                                        {
                                            token = token.trim();
                                            if (!"".equals(token) && token.length() > 1)
                                            {
                                                tags.add(token);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    else
                    {


                        for (int icontent = 0; icontent < listnews.size(); icontent++)
                        {
                            SWBNewContent temp = listnews.get(icontent);
                            if (temp.getResourceBase().getURI().equals(uri))
                            {

                                String stags = temp.getResourceBase().getTags();

                                if (stags != null)
                                {
                                    StringTokenizer st = new StringTokenizer(stags, " ");
                                    while (st.hasMoreTokens())
                                    {
                                        String token = st.nextToken();
                                        if (token != null)
                                        {
                                            token = token.trim();
                                            if (!"".equals(token) && token.length() > 1)
                                            {
                                                tags.add(token);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if ("HTMLContent".equals(resource.getResourceType().getId()))
                {
                    String stags = resource.getTags();
                    if (stags != null)
                    {
                        StringTokenizer st = new StringTokenizer(stags, " ");
                        while (st.hasMoreTokens())
                        {
                            String token = st.nextToken();
                            if (token != null)
                            {
                                token = token.trim();
                                if (!"".equals(token) && token.length() > 1)
                                {
                                    tags.add(token);
                                }
                            }
                        }
                    }
                }
            }

            ArrayList<TagInfo> tagInfos = new ArrayList<TagInfo>();
            if (tags.size() > 0)
            {
                WebSite wsite = topic.getWebSite();
                SWBIndexer indexer = SWBPortal.getIndexMgr().getModelIndexer(wsite);
                for (String token : tags)
                {
                    SearchQuery query = new SearchQuery();
                    query.addTerm(new SearchTerm(SWBIndexer.ATT_TAGS, token, SearchTerm.OPER_OR));
                    query.addTerm(new SearchTerm(SWBIndexer.ATT_DATA, token, SearchTerm.OPER_OR));
                    query.addTerm(new SearchTerm(SWBIndexer.ATT_TITLE, token, SearchTerm.OPER_OR));
                    query.addTerm(new SearchTerm(SWBIndexer.ATT_DESCRIPTION, token, SearchTerm.OPER_OR));

                    SearchResults results = indexer.search(query, user);
                    HashSet<WebPageInfo> pages = new HashSet<WebPageInfo>();
                    

                    Iterator<SearchDocument> documents = results.listDocuments();
                    while (documents.hasNext())
                    {
                        SearchDocument document = documents.next();

                        if (document.getSearchable() != null && document.getSearchable() instanceof WebPage)
                        {
                            WebPage spage = (WebPage) document.getSearchable();
                            WebPageInfo info = new WebPageInfo(spage.getUrl(), spage.getDisplayTitle(lang));
                            
                                pages.add(info);
                            

                        }
                        else if (document.getSearchable() != null && document.getSearchable() instanceof Resource)
                        {
                            Resource sresource = (Resource) document.getSearchable();

                            if ("Noticias".equals(sresource.getResourceType().getId()))
                            {
                                String uri = sresource.getEncodedURI();
                                ResourceType resourceType = paramRequest.getWebPage().getWebSite().getResourceType("Grupo_de_noticias");
                                Iterator<ResourceCollection> collections = ResourceCollection.ClassMgr.listResourceCollectionByResource(sresource, paramRequest.getWebPage().getWebSite());
                                while (collections.hasNext())
                                {
                                    ResourceCollection collection = collections.next();
                                    Iterator<Resource> itresources = resourceType.listResources();
                                    while (itresources.hasNext())
                                    {
                                        Resource resource = itresources.next();
                                        SWBNews news = new SWBNews(resource.getResourceData());
                                        if (news.getCollection() != null && collection.getURI().equals(news.getCollection().getURI()))
                                        {
                                            Iterator<Resourceable> resourceables = news.getResourceBase().listResourceables();
                                            while (resourceables.hasNext())
                                            {
                                                Resourceable resourceable = resourceables.next();

                                                if (resourceable instanceof WebPage)
                                                {
                                                    WebPage spage = (WebPage) resourceable;
                                                    String url = spage.getUrl();

                                                    if (spage.getId().equals("Noticias") || spage.getId().equals("Prensa"))
                                                    {
                                                        url = spage.getUrl() + "?uri=" + uri;
                                                    }
                                                    WebPageInfo info = new WebPageInfo(url, sresource.getDisplayTitle(lang));
                                                    
                                                        pages.add(info);
                                                    
                                                }
                                            }
                                        }



                                    }


                                }
                            }
                            if ("HTMLContent".equals(sresource.getResourceType().getId()))
                            {
                                Iterator<Resourceable> resourceables = sresource.listResourceables();
                                while (resourceables.hasNext())
                                {
                                    Resourceable resourceable = resourceables.next();
                                    if (resourceable instanceof WebPage)
                                    {
                                        WebPage spage = (WebPage) resourceable;
                                        String url = spage.getUrl();
                                        WebPageInfo info = new WebPageInfo(url, spage.getDisplayTitle(lang));
                                        
                                            pages.add(info);
                                        
                                    }
                                }
                            }
                        }
                    }
                    String url = topic.getUrl();
                    if (topic.getId().equals("Noticias") || topic.getId().equals("Prensa"))
                    {
                        String uri = request.getParameter("uri");
                        if (uri != null)
                        {
                            url += "?uri=" + java.net.URLEncoder.encode(uri);
                        }
                    }
                    WebPageInfo info = new WebPageInfo(url, topic.getDisplayTitle(lang));
                    TagInfo tag = new TagInfo(token, pages, info);
                    tagInfos.add(tag);
                }
            }
            if (tagInfos.size() > 0)
            {
                int total = 0;
                for (TagInfo tag : tagInfos)
                {
                    total += tag.pages.size();
                }

%>
<script type="text/javascript" >
    var djConfig = {
        parseOnLoad: true,
        isDebug: false
    };
</script>



<div id="tag_cloud">
    <%
                    int id = 0;

                    for (TagInfo tag : tagInfos)
                    {
                        id++;
                        String iddiv = "tag_" + id;
                        String token = tag.tag;
                        double p = (double) tag.pages.size() / (double) total;
                        int percent = (int) ((p * 100));
                        String className = "rank30";
                        if (percent <= 30)
                        {
                            className = "rank30";
                        }
                        else if (percent >= 40 && percent < 50)
                        {
                            className = "rank40";
                        }
                        else if (percent >= 50 && percent < 70)
                        {
                            className = "rank50";
                        }
                        else if (percent >= 70 && percent < 80)
                        {
                            className = "rank70";
                        }
                        else if (percent >= 80 && percent < 90)
                        {
                            className = "rank80";
                        }
                        else if (percent > 90)
                        {
                            className = "rank100";
                        }

                        //String tagName = "_" + clear(token);
                        String href = "#";
                        if (tag.pages.size() == 1)
                        {
                            href = tag.pages.get(0).url;
    %>
    <a  href="<%=href%>" class="<%=className%>" ><%=token%></a>
    <%
                            }
                            else if (tag.pages.size() > 1)
                            {

    %>
    <a  id="link<%=iddiv%>"  onclick="display_menu('link<%=iddiv%>','divlink<%=iddiv%>')" class="<%=className%>" ><%=token%></a>   

    <%

                        }


                    }

    %>
    <div id="bottom_tagCloud"></div>

</div>
<%
            }
            int id = 0;
            StringBuilder menus = new StringBuilder("var menus =[ ");
            for (TagInfo tag : tagInfos)
            {
                id++;
                String iddiv = "tag_" + id;
                if (tag.pages.size() > 1)
                {
%>
<div id="divlink<%=iddiv%>" class="MenuBarHorizontal">
    <ul>

        <%

                            menus.append("'");
                            menus.append("divlink");
                            menus.append(iddiv);
                            menus.append("'");
                            menus.append(",");
                            int i = 0;
                            for (WebPageInfo linkpage : tag.pages)
                            {
                                i++;
                                if (i > 5)
                                {
                                    break;
                                }
                                String url = linkpage.url;

                                String title = linkpage.title;

        %>
        <li class="MenuBarItemSubmenu"><a href="<%=url%>"><%=title%></a></li>

        <%
                            }



        %>
    </ul>
</div>


<%
                }
            }
            menus.append("];");
            menus.deleteCharAt(menus.length() - 1);
%>
<script type="text/javascript" >
    <!--
    <%=menus%>
        -->
</script>
<%
%>

<script type="text/javascript">
    <!--
    function findPos(obj) {
        var curleft = curtop = 0;
        if (obj.offsetParent) {
            curleft = obj.offsetLeft ;
            curtop = obj.offsetTop;
            while (obj == obj.offsetParent) {
                curleft += obj.offsetLeft;
                curtop += obj.offsetTop;
            }
        }
        return [curleft, curtop];
    }
    //Display a named menu, at the position of another object

    function display_menu(parent, named) {
        //get the named menu
        
        var menu_element = document.getElementById(named);
        if(menu_element.style.display=="")
        {
            hide_menu(named);
            return;
        }
        hideAll();
        //override the 'display:none;' style attribute
        menu_element.style.display = "";
        //get the placement of the element that invoked the menu...
        var placement = findPos(parent);
        //...and put the menu there
        menu_element.style.left = placement[0] + "px";
        menu_element.style.top = placement[1] + "px";
        menu_element.style.zIndex=100;
    }
    //Hide a named menu

    function hide_menu(named) {
        //get the named menu
        
        var menu_element = document.getElementById(named);
        //hide it with a style attribute
        menu_element.style.display = "none";
    }
    function hideAll()
    {
        var i=0;
        for(i=0;i<menus.length;i++)
        {
            var menu=menus[i];
            if(menu)
                hide_menu(menu);
        }
    }
    hideAll();
    -->
</script>