<%@page import="java.util.*"%>
<%@page import="org.semanticwb.*"%>
<%@page import="org.semanticwb.SWBUtils.*"%>
<%@page import="org.semanticwb.model.*"%>

<%
    WebPage topic=(WebPage)request.getAttribute("topic");
    User user=(User)request.getAttribute("user");
    HashMap params=(HashMap)request.getAttribute("params");

    String lang=user.getLanguage();

    WebSite site = topic.getWebSite();
    //String parentId = (String)params.get("topicid");
    //topic = site.getWebPage(parentId);

    StringBuilder htm = new StringBuilder();
    Random r = new Random((new Date()).getTime());
    int k;

    String ids = (String)params.get("children");
    String[] children = ids.split(",");

    //Iterator<WebPage> childs = topic.listChilds();
    out.println("<div class=\"TabbedPanels\" id=\"TabbedPanels1\">");
    out.println("<ul class=\"TabbedPanelsTabGroup\">");
    //for(int i=0; i<6 && childs.hasNext(); i++) {
        //topic = childs.next();
    for(String c:children) {
        topic = site.getWebPage(c);
        if(topic!=null && topic.isActive() && user.haveAccess(topic)) {
            out.println("<li class=\"TabbedPanelsTab\">"+topic.getTitle()+"</li>");
            ArrayList<WebPage> ct = (ArrayList)SWBUtils.Collections.copyIterator(topic.listChilds());
            htm.append("<div class=\"TabbedPanelsContent TabbedPanelsContentVisible\" style=\"display:block;\">\n");
            htm.append(" <div style=\"overflow: hidden; display: block; width: 100%; height: 73px;\">\n");
            htm.append("  <p style=\"padding:0 10px 0 10px\">"+(topic.getDescription()==null?"Agregar descripci&oacute;n":topic.getDescription())+"</p>\n");
            htm.append(" </div>\n");
            htm.append(" <div style=\"display: block; height: 90px; width: 603px; position: relative; z-index: 1; top: 0pt;\">\n");
            htm.append("  <a class=\"ir_a_seccion\" href=\""+topic.getRealUrl()+"\">ir a la sección</a>\n");
            htm.append("  <div class=\"perfil_relacionado\">\n");
            for(int j=0; j<3 && 0<ct.size(); j++) {
                k = r.nextInt(ct.size());
                WebPage child = ct.get(k);
                if(child.isActive() && user.haveAccess(child))
                    htm.append("<a href=\""+child.getRealUrl()+"\">"+child.getTitle()+"</a>\n");
                else
                    htm.append("&nbsp;\n");
                ct.remove(k);
            }
            htm.append("  </div>\n");
            htm.append(" </div>\n");
            htm.append("</div>\n");
        }
    }
    out.println("</ul>");
    out.println("<div class=\"TabbedPanelsContentGroup\">");
    out.println(htm);
    out.println("</div>");
    out.println("</div>");
%>