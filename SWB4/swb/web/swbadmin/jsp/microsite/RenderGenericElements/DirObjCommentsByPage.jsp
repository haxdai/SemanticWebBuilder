<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.semanticwb.portal.api.*,org.semanticwb.portal.community.*,org.semanticwb.*,org.semanticwb.model.*,java.util.*"%>
<%!
    private static final int COMMENTS_IN_PAGE = 5;
%>

<%
    DirectoryObject mse = (DirectoryObject) request.getAttribute("DirectoryObject");
    SWBParamRequest paramRequest = (SWBParamRequest) request.getAttribute("paramRequest");
    User mem = paramRequest.getUser();
    long lpage = (Long) request.getAttribute("page");
    String perfilPath = paramRequest.getWebPage().getWebSite().getWebPage("perfil").getUrl();

    Iterator iterator = mse.listComments();
    int ordinal = 0;
    long firstInPage = ((lpage - 1) * COMMENTS_IN_PAGE) + 1;
    long lastInPage = lpage * COMMENTS_IN_PAGE;

    iterator = SWBComparator.sortByCreated(iterator, false);
    while (iterator.hasNext()) {
        Comment comment = (Comment) iterator.next();
        ordinal++;

        if (ordinal < firstInPage) {
            continue;
        } else if (ordinal > lastInPage) {
            break;
        }

        //String spamMark = (comment.isSpam() ? "[es spam]" : "[marcar como spam]");
        String spamMark="[marcar como spam]";
%>
        <div id="comment<%=comment.getId()%>" class="comment">
            <%
            try {
                if (comment.getCreator()!=null && comment.getCreator().getPhoto()!=null) {%>
                    <img src="<%=SWBPortal.getWebWorkPath()%><%=comment.getCreator().getPhoto()%>" alt="foto">
                <%
                } else {
                %>
                <img src="<%=SWBPortal.getWebWorkPath()%>/models/<%=paramRequest.getWebPage().getWebSite().getTitle()%>/css/images/commentImageplaceHolder.jpg" alt="foto">
                <%
                }
            } catch (NullPointerException npe) {}
                //out.write("<span class="comment-auth">");
            %>
            <div class="commentText">
                <p>Escrito por
                <%
                    try {
                        if (comment.getCreator()!=null && !comment.getCreator().getFullName().equals("")) {
                        %>
                            <a href="<%=perfilPath%>?user=<%=comment.getCreator().getEncodedURI()%>"><%=comment.getCreator().getFullName()%></a>
                        <%
                        } else {
                        %>
                            Desconocido
                        <%
                        }
                    } catch (NullPointerException npe) {
                        %>Desconocido<%
                    }
                    %>
                        <%=SWBUtils.TEXT.getTimeAgo(comment.getCreated(), mem.getLanguage())%>
                </p>
                <p><%=comment.getDescription()%></p>
                <%
                if (mem.isSigned()) {
                %>
                    <p><a href="javascript:spam(<%=comment.getId()%>)" id="spamMark<%=comment.getId()%>"><%=spamMark%></a></p>
                <%
                }
        %>
        <p><%=spamMark%></p>
            </div>
        </div>
        <%
    }
%>