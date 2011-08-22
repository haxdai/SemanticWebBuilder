<%@page import="org.semanticwb.portal.api.*,org.semanticwb.portal.resources.sem.news.*,org.w3c.dom.*,org.semanticwb.portal.community.*,java.util.*,org.semanticwb.model.WebPage,org.semanticwb.platform.SemanticObject"%><%@page import="org.semanticwb.model.*,org.semanticwb.SWBUtils,org.semanticwb.SWBPortal,org.semanticwb.SWBPlatform,org.semanticwb.platform.*,org.semanticwb.portal.api.SWBResourceURL"%><%!    private static String idNoticias = "Noticias";

    class SWBEventComparator implements Comparator<WebPage>
    {

        public int compare(WebPage o1, WebPage o2)
        {
            Date d1 = o1.getExpiration();
            Date d2 = o2.getExpiration();
            if (d1 == null)
            {
                d1 = o1.getCreated();
            }
            if (d2 == null)
            {
                d2 = o2.getCreated();
            }
            return d1.compareTo(d2);
        }
    }

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
                return d2.compareTo(d1);
            }
            else
            {
                return o1.getResourceBase().getIndex() >= o2.getResourceBase().getIndex() ? 1 : -1;
            }
        }
    }

    private Element addAtribute(Element ele, String name, String value)
    {
        Document doc = ele.getOwnerDocument();
        Element n = doc.createElement(name);
        ele.appendChild(n);
        n.appendChild(doc.createTextNode(value));
        return n;
    }

%><%    int limit = 15;
            if (request.getAttribute("paramRequest") != null)
            {
                String port = "";
                if (request.getServerPort() != 80)
                {
                    port = ":" + request.getServerPort();
                }
                String host = request.getServerName();
                String baserequest = request.getScheme() + "://" + host + port;
                SWBParamRequest paramRequest = (SWBParamRequest) request.getAttribute("paramRequest");
                List<SWBNewContent> news = (List<SWBNewContent>) request.getAttribute("news");
                Collections.sort(news, new SWBNewContentComparator());
                //SWBResourceURL url=(SWBResourceURL) request.getAttribute("url");
                String url = (String) request.getAttribute("url");
                response.setContentType("application/rss+xml");
                Document doc = org.semanticwb.SWBUtils.XML.getNewDocument();
                Element rss = doc.createElement("rss");
                rss.setAttribute("version", "2.0");
                doc.appendChild(rss);

                Element channel = doc.createElement("channel");
                rss.appendChild(channel);
                addAtribute(channel, "title", "Noticias y Eventos");
                addAtribute(channel, "link", baserequest+paramRequest.getWebPage().getUrl());
                addAtribute(channel, "description", "Canal de noticias y eventos en formato RSS");
                int inew = 0;
                for (SWBNewContent element : news)
                {
                    inew++;
                    Element item = doc.createElement("item");
                    channel.appendChild(item);
                    String title = element.getResourceBase().getTitle(paramRequest.getUser().getLanguage());
                    if (title == null || title.trim().equals(""))
                    {
                        title = element.getResourceBase().getTitle();

                    }
                    if (title != null)
                    {
                        title = title.replace('"', '\'');
                    }
                    addAtribute(item, "title", title);
                    //addAtribute(item, "link",  baserequest+url + "?uri=" + element.getResourceBase().getEncodedURI());
                    addAtribute(item, "link",  baserequest+url + "?uri=" + element.getResourceBase().getId());
                    Element category = doc.createElement("category");
                    item.appendChild(category);
                    category.appendChild(doc.createTextNode("Noticias"));
                    addAtribute(item, "description", element.getResourceBase().getDescription());
                    if (element.getPublishDate() != null)
                    {
                        addAtribute(item, "pubDate", element.getPublishDate().toGMTString());
                    }
                    else
                    {
                        addAtribute(item, "pubDate", new Date().toGMTString());
                    }
                    //addAtribute(item, "guid", "cd_digital" + element.getURL() + "#rid" + element.getId());
                    if (inew >= limit)
                    {
                        break;
                    }
                }
                
                String id = "Eventos_relevantes";
                WebPage eventoWebPage = paramRequest.getWebPage().getWebSite().getWebPage(id);
                if (eventoWebPage != null)
                {
                    Iterator<WebPage> eventos = eventoWebPage.listChilds(paramRequest.getUser().getLanguage(), true, false, false, true);
                    
                    ArrayList<WebPage> pages=new ArrayList<WebPage>();
                    while (eventos.hasNext())
                    {
                        WebPage event = eventos.next();
                        pages.add(event);
                    }
                    Collections.sort(pages, new SWBEventComparator());
                    
                    for(WebPage event : pages)
                    {                      
                        
                        Element item = doc.createElement("item");
                        channel.appendChild(item);
                        String title = event.getTitle(paramRequest.getUser().getLanguage());
                        if (title == null || title.trim().equals(""))
                        {
                            title = event.getTitle();

                        }
                        if (title != null)
                        {
                            title = title.replace('"', '\'');
                        }
                        String description = "";
                        if (event.getDescription() != null)
                        {
                            description = event.getDescription();
                        }
                         Element category = doc.createElement("category");
                    item.appendChild(category);
                    category.appendChild(doc.createTextNode("Eventos"));
                        addAtribute(item, "title", title);
                        addAtribute(item, "link",  baserequest+event.getUrl());
                        addAtribute(item, "description", description);
                        if (event.getExpiration() != null)
                        {
                            addAtribute(item, "pubDate", event.getExpiration().toGMTString());
                        }
                        else
                        {
                            addAtribute(item, "pubDate", new Date().toGMTString());
                        }
                    }
                }
                out.write(org.semanticwb.SWBUtils.XML.domToXml(doc));
            }
            else
            {
                WebSite site = ((WebPage) request.getAttribute("webpage")).getWebSite();
                Iterator<ResourceType> resourceTypes = ResourceType.ClassMgr.listResourceTypes(site);
                while (resourceTypes.hasNext())
                {
                    ResourceType resourceType = resourceTypes.next();
                    if (resourceType.getResourceClassName().equals(SWBNews.class.getCanonicalName()))
                    {
                        Iterator<Resource> resources = Resource.ClassMgr.listResourceByResourceType(resourceType, site);
                        while (resources.hasNext())
                        {
                            Resource resource = resources.next();
                            if (resource.getResourceable() instanceof WebPage)
                            {
                                WebPage resourcewp = (WebPage) resource.getResourceable();
                                if (resourcewp.getId().equals(idNoticias))
                                {
                                    SWBResourceURLImp url = new SWBResourceURLImp(request, resource, resourcewp, SWBResourceURLImp.UrlType_RENDER);
                                    url.setCallMethod(url.Call_DIRECT);
                                    url.setMode("rss");

                                    HashMap params = (HashMap) request.getAttribute("params");
                                    if ("link".equals(params.get("view")))
                                    {
%>
<link rel="alternate" type="application/rss+xml" title="Fondo de Informaci�n y Documentacion para la industria (INFOTEC)" href="<%=url%>" />
<%
                                    }
                                    else
                                    {
%>
<a id="rss" href="<%=url%>" >RSS</a>
<%
                                    }


                                    break;
                                }
                            }
                        }
                    }
                }

            }
%>
