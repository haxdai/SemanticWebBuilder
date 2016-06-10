<%@page import="org.semanticwb.portal.api.SWBResourceURL"%><%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<%
SWBParamRequest paramRequest = (SWBParamRequest) request.getAttribute("paramRequest");

//Get page param, defaults to "p"
String pageParam = request.getParameter("pageParam");
if (pageParam == null || pageParam.length() == 0) pageParam = "p";

//Get maxPages, by default it is taken from request attributes
String maxPParam = request.getParameter("maxPages");

//Get show page count config
boolean showPageOfPage = request.getParameter("showPageOfPage")!= null ? true : false;

String pNum = request.getParameter(pageParam);
int pageNum = 1;
int maxPages = 1;
if (maxPParam == null|| maxPParam.length() == 0) maxPages = (Integer) request.getAttribute("maxPages");

if (pNum != null && !pNum.trim().equals("")) {
    pageNum = Integer.valueOf(pNum);
    if (pageNum > maxPages) {
        pageNum = maxPages;
    }
}

SWBResourceURL nav = paramRequest.getRenderUrl();

//Set mode from parameter
String navUrlMode = request.getParameter("navUrlMode");
if (navUrlMode != null && navUrlMode.length() > 0) nav.setMode(navUrlMode);

//Set params from parameter
String [] navParams = request.getParameterValues("navUrlParams");
if (navParams != null && navParams.length > 0) {
    for (int i = 0; i < navParams.length; i++) {
        String str = navParams[i];
        if (str != null && str.contains("|")) {
            String [] strSplit = str.split("\\|");
            if (strSplit.length == 2) {
                nav.setParameter(strSplit[0], strSplit[1]);
            }
        }
    }
}

if (maxPages > 1) {
    if (showPageOfPage) {
        %>
        <span class="hidden-sm hidden-xs swbp-page-number"><small><%=paramRequest.getLocaleString("pagPage")%> <%=pageNum%> <%=paramRequest.getLocaleString("pagDelim")%> <%=maxPages%></small></span>
        <%
    }
    %>
    <nav class="pull-right">
        <ul class="pagination swbp-pagination">
            <%
            int pagSlice = 5;
            int sliceIdx = 1;
            int start = 1;
            int end = pagSlice * sliceIdx;

            if (pageNum > end) {
                do {
                    sliceIdx++;
                    end = pagSlice * sliceIdx;
                } while(pageNum > end);
            }
            end = pagSlice * sliceIdx;

            if (end > maxPages) {
                end = maxPages;
            }

            start = (end-pagSlice)+1;
            if (start < 1) {
                start = 1;
            }

            if (sliceIdx != 1) {
                nav.setParameter(pageParam, String.valueOf(pageNum-1));
                %><li><a href="<%=nav%>" class="fa fa-angle-double-left"></a></li><%
            }

            for(int k = start; k <= end; k++) {
                nav.setParameter(pageParam, String.valueOf(k));
                %>
                <li <%=(k==pageNum?"class=\"active\"":"")%>><a href="<%=nav%>"><%=k%></a></li>
                <%
            }

            if (end < maxPages) {
                nav.setParameter(pageParam, String.valueOf(pageNum+1));
                %><li><a href="<%=nav%>" class="fa fa-angle-double-right"></a></li><%
            }
            %>
        </ul>
    </nav>
    <%
}
%>