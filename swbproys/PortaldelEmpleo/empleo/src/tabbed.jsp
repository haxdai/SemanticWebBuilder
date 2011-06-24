<%@page import="java.util.*"%>

<%@page import="org.semanticwb.*"%>
<%@page import="org.semanticwb.SWBUtils.*"%>
<%@page import="org.semanticwb.model.*"%>

<%


    WebPage topic=(WebPage)request.getAttribute("topic");
    User user=(User)request.getAttribute("user");
    HashMap params=(HashMap)request.getAttribute("params");

    System.out.println("topic:"+topic);
    System.out.println("user"+user);
    System.out.println("params"+params);

    String lang=user.getLanguage();

    WebSite site = topic.getWebSite();
    String parentId = (String)params.get("topicid");
    System.out.println("parentId:"+parentId);
    topic = site.getWebPage(parentId);

    System.out.println("topic:"+topic);

    Iterator<WebPage> childs = topic.listChilds();
    while(childs.hasNext()) {
        topic = childs.next();
        if(topic.isActive() && user.haveAccess(topic)) {
            out.println(topic.getTitle());

            ArrayList<WebPage> ct = (ArrayList)SWBUtils.Collections.copyIterator(topic.listChilds());
            for(int i=0; i<3 && i<ct.size(); i++) {
                out.println(ct.get(i).getTitle());
            }
        }
    }

%>