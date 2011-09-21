<%@page import="java.util.ArrayList"%><%@page import="org.semanticwb.portal.indexer.searcher.SearchTerm"%><%@page import="org.semanticwb.model.Resourceable"%><%@page import="org.semanticwb.portal.indexer.searcher.SearchDocument"%><%@page import="org.semanticwb.portal.indexer.searcher.SearchResults"%><%@page import="org.semanticwb.portal.indexer.searcher.SearchQuery"%><%@page import="org.semanticwb.portal.indexer.SWBIndexer"%><%@page import="java.util.HashMap"%><%@page import="org.semanticwb.model.User"%><%@page import="org.semanticwb.model.WebPage"%><%@page import="org.semanticwb.SWBPortal"%><%@page import="org.semanticwb.portal.util.SWBPriorityComparator"%><%@page import="org.semanticwb.model.SWBComparator"%><%@page import="java.util.*"%><%@page import="org.semanticwb.model.Resource"%><%@page import="org.semanticwb.model.ResourceSubType"%><%@page import="org.semanticwb.model.WebSite"%>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest"/>
<%!
    public String clear(String var)
    {
        return var;
    }

    public void addScore(WebPage page, double newscore, Hashtable<WebPage, Double> score)
    {
        if (!score.containsKey(page))
        {
            score.put(page, newscore);
        }
        else
        {
            double oldscore = score.get(page).doubleValue();
            if (oldscore < newscore)
            {
                score.put(page, newscore);
            }
        }
    }

    class WebPageInfoComparator implements Comparator<WebPageInfo>
    {

        public int compare(WebPageInfo o1, WebPageInfo o2)
        {
            Double d1 = o1.score;
            Double d2 = o2.score;
            return d1.compareTo(d2);
        }
    }

    public ArrayList<WebPage> get(Hashtable<WebPage, Double> score, int limit, WebPage topic)
    {
        ArrayList<WebPage> get = new ArrayList<WebPage>();
        score.remove(topic);
        ArrayList<WebPageInfo> temp = new ArrayList<WebPageInfo>();
        for (WebPage key : score.keySet())
        {
            WebPageInfo info = new WebPageInfo();
            info.page = key;
            info.score = score.get(key);
            temp.add(info);
        }
        Collections.sort(temp, new WebPageInfoComparator());
        if (limit >= 0)
        {
            if (limit > temp.size())
            {
                limit = temp.size();
            }
            for (int i = 0; i < limit; i++)
            {
                WebPageInfo info = temp.get(i);
                get.add(info.page);
            }
        }
        else
        {
            for (WebPageInfo info : temp)
            {
                get.add(info.page);
            }
        }
        return get;

    }

    class WebPageInfo
    {

        WebPage page;
        double score;
    }

%><%
            User user = (User) paramRequest.getUser();
            String lang = user.getLanguage();
            WebPage topic = (WebPage) paramRequest.getWebPage();
            if (topic == null)
                return;


            HashSet<String> tags = new HashSet<String>();
            Hashtable<WebPage, Double> score = new Hashtable<WebPage, Double>();
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
                if ("HTMLContent".equals(resource.getResourceType().getId()))
                {
                    String stags = resource.getTags(lang);
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


            if (tags.size() > 0)
            {
                WebSite wsite = topic.getWebSite();
                SWBIndexer indexer = SWBPortal.getIndexMgr().getModelIndexer(wsite);
                SearchQuery query = new SearchQuery();
                for (String token : tags)
                {

                    query.addTerm(new SearchTerm(SWBIndexer.ATT_TAGS, token, SearchTerm.OPER_OR));
                    query.addTerm(new SearchTerm(SWBIndexer.ATT_DATA, token, SearchTerm.OPER_OR));
                    query.addTerm(new SearchTerm(SWBIndexer.ATT_TITLE, token, SearchTerm.OPER_OR));
                    query.addTerm(new SearchTerm(SWBIndexer.ATT_DESCRIPTION, token, SearchTerm.OPER_OR));
                }
                SearchResults results = indexer.search(query, user);
                Iterator<SearchDocument> documents = results.listDocuments();
                while (documents.hasNext())
                {
                    SearchDocument document = documents.next();

                    if (document.getSearchable() != null && document.getSearchable() instanceof WebPage)
                    {
                        WebPage spage = (WebPage) document.getSearchable();

                        addScore(spage, document.getScore(), score);
                    }
                    else if (document.getSearchable() != null && document.getSearchable() instanceof Resource)
                    {
                        Resource sresource = (Resource) document.getSearchable();
                        if ("HTMLContent".equals(sresource.getResourceType().getId()))
                        {
                            Iterator<Resourceable> resourceables = sresource.listResourceables();
                            while (resourceables.hasNext())
                            {
                                Resourceable resourceable = resourceables.next();
                                if (resourceable instanceof WebPage)
                                {
                                    WebPage spage = (WebPage) resourceable;

                                    addScore(spage, document.getScore(), score);
                                }
                            }
                        }
                    }
                }

            }

            ArrayList<WebPage> tagInfos = get(score, 5, topic);
            if (tagInfos.size() > 0)
            {
%>
<div id="contenidos_relacionados">
    <h3>CONTENIDOS RELACIONADOS</h3>
    <ul><%


                    for (WebPage webpage : tagInfos)
                    {

                        String title = webpage.getDisplayName(lang);
                        String url = webpage.getRealUrl();
        %><li><a href="<%=url%>" ><%=title%></a></li><%
                        }

        %></ul></div><%
                    }
%>