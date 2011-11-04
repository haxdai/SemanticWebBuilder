<%@page import="java.util.Comparator"%><%@page import="java.util.HashMap"%><%@page import="org.semanticwb.model.User"%><%@page import="org.semanticwb.model.WebPage"%><%@page import="org.semanticwb.SWBPortal"%><%@page import="org.semanticwb.portal.util.SWBPriorityComparator"%><%@page import="org.semanticwb.model.SWBComparator"%><%@page import="java.util.*"%><%@page import="org.semanticwb.model.Resource"%><%@page import="org.semanticwb.model.ResourceSubType"%><%@page import="org.semanticwb.model.WebSite"%>
<%!
    class ResourceComparator implements Comparator<Resource>
    {
        final String lang;
        public ResourceComparator(String lang)
                {
            this.lang=lang;
            }
        public int compare(Resource o1, Resource o2)
        {
            return o1.getDisplayTitle(lang).toLowerCase().compareTo(o2.getDisplayTitle(lang).toLowerCase());
        }
    }

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
        if (str.length() > 41)
        {
            str = str.substring(0, 41) + "...";
        }
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
            String subtype = (String) params.get("subtype");
            if (subtype == null)
                return;
            ResourceSubType stype = site.getResourceSubType(subtype);
            if (stype == null)
                return;

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
            while (it.hasNext())
            {
                Resource res = it.next();
                if (res.isActive() && user.haveAccess(res))
                {
                    set.add(res);
                }
            }
            List<Resource> resources = new ArrayList<Resource>();
            resources.addAll(set);
            resources = ramdomSelect(resources, 5);
%>
<ul>
    <li>
        <div class="hypermenu">
            <%
                        //Collections.sort(resources, new ResourceComparator(lang));
                        for (Resource resource : resources)
                        {
                            String title = "";
                            if (resource.getDisplayTitle(lang) != null)
                            {
                                title = resource.getDisplayTitle(lang);
                            }
                            String description = "";
                            if (resource.getDisplayDescription(lang) != null)
                            {
                                description = resource.getDisplayDescription(lang);
                            }
                            description = getString(description);
                            String url = resource.getAttribute("url", "#");
                            String image = null;
                            String webWorkPath = SWBPortal.getWebWorkPath() + resource.getWorkPath() + "/";
                            if (resource.getAttribute("imgfile") != null)
                            {
                                image = webWorkPath + resource.getAttribute("imgfile");
                            }
                            String id = "mh_" + resource.getId();


            %>
            <div class="block">          
                <h3 id="<%=id%>"><%=title%></h3>
                <p><%=description%></p>
                <%-- <span class="ver_mas2" onclick="document.location='<%=url%>'"><a href="<%=url%>">ver más</a></span> --%>
                <span class="ver_mas2"><a href="<%=url%>">ver más</a></span>
            </div>
            <%                            }
            %>
        </div></li>
</ul>
