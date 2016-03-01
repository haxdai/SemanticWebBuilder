<%-- 
    Document   : userTaskInboxDetail
    Created on : 4/07/2013, 10:14:08 PM
    Author     : Hasdai Pacheco <ebenezer.sanchez@infotec.com.mx>
--%>
<%@page import="org.semanticwb.process.model.Activity"%>
<%@page import="org.semanticwb.SWBUtils"%>
<%@page import="org.semanticwb.process.model.UserTask"%>
<%@page import="org.semanticwb.process.model.Instance"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.semanticwb.platform.SemanticOntology"%>
<%@page import="org.semanticwb.SWBPlatform"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="org.semanticwb.process.model.FlowNodeInstance"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.semanticwb.process.model.ProcessInstance"%>
<%@page import="org.semanticwb.process.model.Process"%>
<%@page import="org.semanticwb.process.resources.taskinbox.UserTaskInboxResource"%>
<%@page import="org.semanticwb.model.WebPage"%>
<%@page import="org.semanticwb.model.Resource"%>
<%@page import="org.semanticwb.model.User"%>
<%@page import="org.semanticwb.model.WebSite"%>
<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    SWBParamRequest paramRequest = (SWBParamRequest) request.getAttribute("paramRequest");
    WebSite site = paramRequest.getWebPage().getWebSite();
    User user = paramRequest.getUser();
    Resource base = (Resource) request.getAttribute("base");
    String lang = user.getLanguage();
    String sortType = request.getParameter("sort");
    String pFilter = request.getParameter("pf");
    String sFilter = request.getParameter("sf");
    String _config = (String) request.getAttribute("graphConfig");
    if (null == _config) _config = "";
    
    boolean applyFilter = true;

    if (user.getLanguage() != null) {
        lang = user.getLanguage();
    }

    if (sortType != null && !sortType.trim().equals("")) {
        sortType = sortType.trim();
    } else {
        sortType = "1";
    }
    if (pFilter == null || pFilter.trim().equals("")) {
        pFilter = "";
        applyFilter = false;
    }
    if (sFilter == null || sFilter.trim().equals("")) {
        sFilter = String.valueOf(ProcessInstance.STATUS_PROCESSING);
    }

    ArrayList<String> cols = new ArrayList<>();
    int i = 1;
    while (!base.getAttribute(UserTaskInboxResource.ATT_COLS + i, "").equals("")) {
        String val = base.getAttribute(UserTaskInboxResource.ATT_COLS + i);
        cols.add(val);
        i++;
    }

    SWBResourceURL optsUrl1 = paramRequest.getRenderUrl();
    optsUrl1.setParameter("sort", sortType);
    if (applyFilter) {
        optsUrl1.setParameter("pf", pFilter);
    }
    optsUrl1.setParameter("sf", String.valueOf(FlowNodeInstance.STATUS_PROCESSING));
    String pNum = request.getParameter("p");
    String suri = request.getParameter("suri");
    String suriInstance = request.getParameter("suriInstance");
    ProcessInstance instance = (ProcessInstance) SWBPlatform.getSemanticMgr().getOntology().getGenericObject(suriInstance);
    String engine = "d3";//harcoded to always use D3
    
    boolean showGraphs = false;
    if (_config.contains(UserTaskInboxResource.ATT_SHOWPERFORMANCE)) {
        showGraphs = true;
    }
    /*if (base != null && base.getAttribute(UserTaskInboxResource.ATT_SHOWPERFORMANCE, "").equals("yes")) {
        showGraphs = true;
    }*/

    
    /*if (base != null && base.getAttribute(UserTaskInboxResource.ATT_GRAPHSENGINE, "").equals("d3")) {
        engine = "d3";
    }*/

    int pageNum = 1;
    if (user != null && user.getLanguage() != null) {
        lang = user.getLanguage();
    }
    SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();

    if (!user.isSigned()) {
        if (paramRequest.getCallMethod() == SWBParamRequest.Call_CONTENT) {
        %>
        <div class="alert alert-block alert-danger fade in">
            <h4><span class="fa fa-ban"></span> <%=paramRequest.getLocaleString("msgNoAccessTitle")%></h4>
            <p><%=paramRequest.getLocaleString("msgNoAccess")%></p>
            <p>
                <a class="btn btn-default" href="/login/<%=site.getId()%>/<%=paramRequest.getWebPage().getId()%>"><%=paramRequest.getLocaleString("btnLogin")%></a>
            </p>
        </div>
        <%
    }
} else if (paramRequest.getCallMethod() == SWBParamRequest.Call_STRATEGY) {
    SWBResourceURL createPiUrl = paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT);
    createPiUrl.setMode(UserTaskInboxResource.MODE_CREATEPI);
    SWBResourceURL optsUrl = paramRequest.getRenderUrl().setMode(SWBResourceURL.Mode_VIEW);
    %>
    <a href="<%=createPiUrl%>" class="btn btn-sm btn-success swbp-btn-start" data-toggle="modal" data-target="#modalDialog"><span class="fa fa-play-circle fa-lg fa-fw"></span> <%=paramRequest.getLocaleString("createCase")%></a>
    <div class="swbp-left-menu">
        <ul class="list-unstyled">
            <li>
                <a href="<%=optsUrl%>"><%=paramRequest.getLocaleString("pendingTasks")%></a>
            </li>
            <li>
                <a href="<%=optsUrl.setParameter("sf", String.valueOf(FlowNodeInstance.STATUS_CLOSED))%>"><%=paramRequest.getLocaleString("closedTasks")%></a>
            </li>
            <li>
                <a href="<%=optsUrl.setParameter("sf", String.valueOf(FlowNodeInstance.STATUS_ABORTED))%>"><%=paramRequest.getLocaleString("abortedTasks")%></a>
            </li>
        </ul>
    </div>
    <%
} else {
    ArrayList<ProcessInstance> tinstancesPI = (ArrayList<ProcessInstance>) request.getAttribute("instances");
    SWBResourceURL viewUrl = paramRequest.getRenderUrl().setMode(SWBResourceURL.Mode_VIEW);
    int maxPages = (Integer) request.getAttribute("maxPages"); //Sólo viene si se invoca como contenido

    if (pNum != null && !pNum.trim().equals("")) {
        pageNum = Integer.valueOf(pNum);
        if (pageNum > maxPages) {
            pageNum = maxPages;
        }
    }

    Process p = (Process) ont.getGenericObject(suri);
    if (p == null) {
        %><script>window.location = '<%=viewUrl%>';</script><%
    } else {
        %>
        <div class="row swbp-pad">
            <div class="col-lg-3 col-lg-offset-9 col-md-4 col-md-offset-8 col-sm-4 col-sm-offset-8 col-xs-12 swbp-raised-button">
                <a class="btn btn-block swbp-btn-block" href="<%=viewUrl%>">Regresar</a>
            </div>
        </div> 
        <hr>
        <%
        if (tinstancesPI != null && !tinstancesPI.isEmpty() && showGraphs) {
        %>
            <div class="row hidden-margin">
                <%
                if (engine.equals("google")) {
                    %><jsp:include page="/swbadmin/jsp/process/taskInbox/userTaskInboxGoogleGraphs.jsp" flush="true"/><%
                } else {
                    %><jsp:include page="/swbadmin/jsp/process/taskInbox/userTaskInboxD3Graphs.jsp" flush="true"/><%
                }
                %>
            </div>
            <%
        }
        
        if (tinstancesPI != null && !tinstancesPI.isEmpty()) {
            %>
            <div class="panel panel-default swbp-panel-head hidden-margin">
                <div class="panel-heading text-center"><%=paramRequest.getLocaleString("lblInstances")%></div>
                <div class="panel-body swbp-panel-body-card swbp-tray-body-panel">
                    <div class="table-responsive-vertical shadow-z-1 swbp-table-responsive">   
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th><%=paramRequest.getLocaleString("lblCreator")%></th>
                                    <th><%=paramRequest.getLocaleString("lblStatus")%></th>
                                    <th><%=paramRequest.getLocaleString("pStatusInit")%></th>
                                    <th><%=paramRequest.getLocaleString("pStatusClosed")%></th>
                                    <th><%=paramRequest.getLocaleString("lblActiveTasks")%></th>
                                </tr>
                            </thead>
                            <tbody>
                            <%
                            Iterator<ProcessInstance> it = tinstancesPI.iterator();
                            while (it.hasNext()) {
                                ProcessInstance pi = it.next();
                                String status = "";

                                if (pi.getStatus() == ProcessInstance.STATUS_PROCESSING) {
                                    status = paramRequest.getLocaleString("pStatusPending");
                                }
                                if (pi.getStatus() == ProcessInstance.STATUS_ABORTED) {
                                    status = paramRequest.getLocaleString("pStatusAborted");
                                }
                                if (pi.getStatus() == ProcessInstance.STATUS_CLOSED) {
                                    status = paramRequest.getLocaleString("pStatusClosed");
                                }
                                %>
                                <tr>
                                    <td data-title="ID"><%=pi.getId()%></td>
                                    <td data-title="<%=paramRequest.getLocaleString("lblCreator")%>"><%=pi.getCreator() == null ? "--" : pi.getCreator().getFullName()%></td>
                                    <td data-title="<%=paramRequest.getLocaleString("lblStatus")%>"><%=status%></td>
                                    <td data-title="<%=paramRequest.getLocaleString("pStatusInit")%>"><%=SWBUtils.TEXT.getStrDate(pi.getCreated(), lang, "dd/mm/yy - hh:%m:ss")%></td>
                                    <td data-title="<%=paramRequest.getLocaleString("pStatusClosed")%>"><%=pi.getEnded() == null ? "--" : SWBUtils.TEXT.getStrDate(pi.getEnded(), lang, "dd/mm/yy - hh:%m:ss")%></td>
                                    <td data-title="<%=paramRequest.getLocaleString("lblActiveTasks")%>">
                                        <%
                                        if (pi.getStatus() == ProcessInstance.STATUS_PROCESSING) {
                                            Iterator<FlowNodeInstance> actit = pi.listAllFlowNodeInstance();
                                            ArrayList<FlowNodeInstance> activities = new ArrayList<>();
                                            if (actit.hasNext()) {
                                                while (actit.hasNext()) {
                                                    FlowNodeInstance fni = actit.next();
                                                    if (fni.getFlowNodeType() instanceof Activity && fni.getStatus() == FlowNodeInstance.STATUS_PROCESSING) {
                                                        activities.add(fni);
                                                    }
                                                }
                                            }

                                            if (!activities.isEmpty()) {
                                                actit = activities.iterator();
                                                %>
                                                <ul>
                                                    <%
                                                    while (actit.hasNext()) {
                                                    FlowNodeInstance fni = actit.next();
                                                        %><li><%=fni.getFlowNodeType().getTitle()%></li><%
                                                    }
                                                    %>
                                                </ul>
                                                <%
                                            }
                                        }
                                        %>
                                    </td>
                                </tr>
                                <%
                            }
                            %>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
    <div class="panel-footer swbp-footer-pagination">
        <div class="col-lg-8 col-md-8 col-sm-6 col-xs-12 swbp-pagination-title"><%=paramRequest.getLocaleString("pagPage")%> <%=pageNum%> <%=paramRequest.getLocaleString("pagDelim")%> <%=maxPages%></div>
        <%if (maxPages > 1) {%>
        <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 swbp-pagination-number">
            <ul class="pagination">
                <%
                    int pagSlice = 5;
                    int sliceIdx = 1;
                    int start = 1;
                    int end = pagSlice * sliceIdx;

                    if (pageNum > end) {
                        do {
                            sliceIdx++;
                            end = pagSlice * sliceIdx;
                        } while (pageNum > end);
                    }
                    end = pagSlice * sliceIdx;

                    if (end > maxPages) {
                        end = maxPages;
                    }

                    start = (end - pagSlice) + 1;
                    if (start < 1) {
                        start = 1;
                    }

                    SWBResourceURL nav = paramRequest.getRenderUrl();
                    nav.setParameter("suri", suri);

                    if (sliceIdx != 1) {
                %><li><a href="<%=nav.setParameter("p", String.valueOf(pageNum - 1))%>">&laquo;</a></li><%
                          }

                          for (int k = start; k <= end; k++) {
                    %>
                <li <%=(k == pageNum ? "class=\"active\"" : "")%>><a href="<%=nav.setParameter("p", String.valueOf(k))%>"><%=k%></a></li>
                    <%
                        }

                        if (end < maxPages) {
                    %><li><a href="<%=nav.setParameter("p", String.valueOf(pageNum + 1))%>">&raquo;</a></li><%
                                                  }
                                              }%>
            </ul>
        </div>
    </div>
</div>
<%
} else {
%>
<div class="alert alert-warning">
    <span class="fa fa-exclamation-triangle"></span> <strong><%=paramRequest.getLocaleString("msgNoInstances")%></strong>
</div>
<%
            }
        }
    }
%>