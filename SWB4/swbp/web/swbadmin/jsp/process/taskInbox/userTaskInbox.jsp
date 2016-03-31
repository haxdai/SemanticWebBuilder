<%-- 
    Document   : userTaskInbox
    Created on : 2/08/2011, 10:10:59 AM
    Author     : Hasdai Pacheco {ebenezer.sanchez@infotec.com.mx}
--%>

<%@page import="java.util.HashMap"%>
<%@page import="org.semanticwb.SWBUtils"%>
<%@page import="org.semanticwb.process.model.UserTask"%>
<%@page import="org.semanticwb.process.model.Instance"%>
<%@page import="org.semanticwb.model.SWBComparator"%>
<%@page import="org.semanticwb.process.model.ProcessGroup"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="org.semanticwb.process.model.FlowNodeInstance"%>
<%@page import="org.semanticwb.process.model.Process"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.semanticwb.process.model.ProcessInstance"%>
<%@page import="org.semanticwb.model.Resource"%>
<%@page import="org.semanticwb.model.Role"%>
<%@page import="org.semanticwb.model.WebSite"%>
<%@page import="org.semanticwb.model.WebPage"%>
<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<%@page import="org.semanticwb.process.resources.taskinbox.UserTaskInboxResource"%>
<%@page import="org.semanticwb.model.User"%>
<%!
public boolean isAdminUser(User user, UserTaskInboxResource base) {
    if (user == null) return false;
    Role admRole = base.getAdminRole();
    return admRole != null && user.hasRole(admRole);
}
%>
<%
SWBParamRequest paramRequest = (SWBParamRequest) request.getAttribute("paramRequest");
User user = paramRequest.getUser();
WebPage statusWp = (WebPage) request.getAttribute("statusWp");
String lang = user.getLanguage();
String sortType = request.getParameter("sort");
String pFilter = request.getParameter("pf");
String sFilter = request.getParameter("sf");
String pNum = request.getParameter("p");
Resource base = (Resource) request.getAttribute("base");
UserTaskInboxResource utir = (UserTaskInboxResource) request.getAttribute("me");
WebSite site = paramRequest.getWebPage().getWebSite();

boolean showPwpLink = false;
if (request.getAttribute("showPWpLink") != null) {
    showPwpLink = (Boolean) request.getAttribute("showPWpLink");
}

boolean allowForward = false;
if (request.getAttribute("allowForward") != null) {
    allowForward = (Boolean) request.getAttribute("allowForward");
}
int maxPages = (Integer) request.getAttribute("maxPages");
int pageNum = 1;
boolean applyFilter = true;

if (user.getLanguage() != null) {
    lang = user.getLanguage();
}
if (pNum != null && !pNum.trim().equals("")) {
    pageNum = Integer.valueOf(pNum);
    if (pageNum > maxPages) {
        pageNum = maxPages;
    }
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

HashMap<String, String> cols = new HashMap<>();
int i = 1;
while(!base.getAttribute(UserTaskInboxResource.ATT_COLS+i, "").equals("")) {
    String[] val = base.getAttribute(UserTaskInboxResource.ATT_COLS+i).split("\\|");
    if (val.length == 2) {
        cols.put(val[0], val[1]);
    }
    i++;
}

ArrayList<FlowNodeInstance> tinstances = (ArrayList<FlowNodeInstance>) request.getAttribute("instances");
SWBResourceURL optsUrl = paramRequest.getRenderUrl();
optsUrl.setParameter("sort", sortType);
if (applyFilter) {
    optsUrl.setParameter("pf", pFilter);
}
optsUrl.setParameter("sf", String.valueOf(FlowNodeInstance.STATUS_PROCESSING));
SWBResourceURL createPiUrl = paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT);
createPiUrl.setMode(UserTaskInboxResource.MODE_CREATEPI);

/*File source = new File(SWBUtils.getApplicationPath()+"/swbadmin/jsp/process/commons/sass/swbp.scss");
ScssStylesheet scss = ScssStylesheet.get(source.getCanonicalPath(), null, new SCSSDocumentHandlerImpl(), new SCSSErrorHandler());
scss.compile();

FileWriter fwr = new FileWriter(SWBUtils.getApplicationPath()+"/swbadmin/jsp/process/commons/css/swbp.css");
scss.write(fwr, true);
fwr.close();*/

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
} else {
    if (paramRequest.getCallMethod() == SWBParamRequest.Call_STRATEGY) {
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
    String pid = (String) request.getSession(true).getAttribute("processInstance");
    if (null != pid && !pid.isEmpty()) {
        %>
        <script>
            (function(){
                $(function() {
                    if (window.toastr) {
                        toastr.options.closeButton = true;
                        toastr.options.positionClass = "toast-bottom-full-width";
                        toastr.success("Se ha creado la instancia <%= pid %>");
                    }
                });
            })();
        </script>
        <%
        request.getSession(true).removeAttribute("processInstance");
    }
    %>
    <div class="row swbp-pad">
        <div class="col-lg-3 col-lg-offset-9 col-md-4 col-md-offset-8 col-sm-4 col-sm-offset-8 col-xs-12 swbp-raised-button">
            <a href="<%=createPiUrl%>" class="btn btn-block swbp-btn-block" data-toggle="modal" data-target="#modalDialog">Crear instancia</a>
        </div>
    </div> 
<hr>    
<div class="row form-group swbp-filters">
    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 ">
        <div class="col-lg-4 col-md-4 hidden-sm hidden-xs text-right">
            <label for="">Mostrar:</label>
        </div>
        <div class="col-lg-8 col-md-8 col-sm-12 col-xs-12 hidden-padding">
            <%
        optsUrl = paramRequest.getRenderUrl(); 
        optsUrl.setParameter("sort", sortType);
        optsUrl.setParameter("sf", sFilter);
            %>
            <select class="form-control" onchange="loadPageUrl('<%=optsUrl%>', 'pf', this.options[this.selectedIndex].value)">
                <option value="" <%=pFilter.equals("")?"selected":""%>><%=paramRequest.getLocaleString("allProcesses")%></option>
                <%
                Iterator<ProcessGroup> itgroups = SWBComparator.sortByDisplayName(ProcessGroup.ClassMgr.listProcessGroups(paramRequest.getWebPage().getWebSite()), lang);
                while (itgroups.hasNext()) {
                    ProcessGroup pgroup = itgroups.next();
                    Iterator<Process> processes = SWBComparator.sortByDisplayName(pgroup.listProcesses(), lang);
                    ArrayList<Process> alProcesses = new ArrayList<>();

                    while (processes.hasNext()) {
                        Process process = processes.next();
                        if (process.isValid()) {
                            alProcesses.add(process);
                        }
                    }

                    if (!alProcesses.isEmpty()) {
                        processes = alProcesses.iterator();
                %>
                <optgroup label="<%=pgroup.getDisplayTitle(lang)%>">
                    <%
                    while (processes.hasNext()) {
                        Process process = processes.next();
                        String selected = "";
                        if (pFilter.equals(process.getId())) selected = "selected";
                    %>
                    <option value="<%=process.getId()%>" <%=selected%>><%=process.getDisplayTitle(lang)%></option>
                    <%
                }
                    %>
                </optgroup>
                <%
            }
        }
                %>
            </select>
        </div>  
    </div> 
    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-6">
        <div class="col-lg-4 col-md-4 hidden-sm hidden-xs text-right">
            <label for="">ordenar:</label>
        </div>
        <div class="col-lg-8 col-md-8 col-sm-12 col-xs-12 hidden-padding">
            <%
                        optsUrl = paramRequest.getRenderUrl();
                        if (applyFilter) {
                            optsUrl.setParameter("pf", pFilter);
                        }
                        optsUrl.setParameter("sf", sFilter);
                    %>
             
             <select class="form-control"  onchange="loadPageUrl('<%=optsUrl%>&sort='+this.options[this.selectedIndex].value, 'pf', this.options[this.selectedIndex].value)">
                 <optgroup class="dropdown-header" label="<%=paramRequest.getLocaleString("sortDate")%>">
                    <option value="1" <%=sortType.equals("1")?"selected":""%>><span class="fa fa-sort-numeric-asc"></span><%=paramRequest.getLocaleString("sortLatest")%></option>
                    <option value="2" <%=sortType.equals("2")?"selected":""%>><span class="fa fa-sort-numeric-desc"></span><%=paramRequest.getLocaleString("sortOldest")%></option>
                </optgroup>
                <optgroup class="dropdown-header" label="<%=paramRequest.getLocaleString("sortProcess")%>">  
                    <option value="3" <%=sortType.equals("3")?"selected":""%>><%=paramRequest.getLocaleString("sortNameAsc")%></option>
                    <option value="4" <%=sortType.equals("4")?"selected":""%>><%=paramRequest.getLocaleString("sortNameDes")%></option>
                </optgroup>
            </select>
        </div>       
    </div>

    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-6">
        <div class="col-lg-4 col-md-4 hidden-sm hidden-xs text-right">
            <label for="">Filtrar:</label>
        </div>
        <div class="col-lg-8 col-md-8 col-sm-12 col-xs-12 hidden-padding dropdown">
             <% optsUrl = paramRequest.getRenderUrl();
                optsUrl.setParameter("sort", sortType);
                if (applyFilter) {
                     optsUrl.setParameter("pf", pFilter);
                }
            %>
            <select class="form-control"  onchange="loadPageUrl('<%=optsUrl%>&sf='+this.options[this.selectedIndex].value, 'pf', this.options[this.selectedIndex].value)">
                <option <%=sFilter.equals(String.valueOf(FlowNodeInstance.STATUS_PROCESSING))?"selected":""%> value="<%=String.valueOf(FlowNodeInstance.STATUS_PROCESSING)%>"><%=paramRequest.getLocaleString("pendingTasks")%></option>
                <option <%=sFilter.equals(String.valueOf(FlowNodeInstance.STATUS_CLOSED))?"selected":""%> value="<%=String.valueOf(FlowNodeInstance.STATUS_CLOSED)%>"><%=paramRequest.getLocaleString("closedTasks")%></option>
                <option <%=sFilter.equals(String.valueOf(FlowNodeInstance.STATUS_ABORTED))?"selected":""%> value="<%=String.valueOf(FlowNodeInstance.STATUS_ABORTED)%>"><%=paramRequest.getLocaleString("abortedTasks")%></option>
            </select>

            <ul class="dropdown-menu" role="menu">
                <li class="dropdown-header" role="menuitem"><%=paramRequest.getLocaleString("sortStatus")%></li>
                    <%
                        optsUrl = paramRequest.getRenderUrl();
                        optsUrl.setParameter("sort", sortType);
                        if (applyFilter) {
                            optsUrl.setParameter("pf", pFilter);
                        }
                    %>
                <li role="menuitem">
                    <a href="<%=optsUrl.setParameter("sf", String.valueOf(FlowNodeInstance.STATUS_PROCESSING))%>"><span class="fa fa-flag-checkered"></span> <%=sFilter.equals(String.valueOf(FlowNodeInstance.STATUS_PROCESSING))?"<strong>":""%><%=paramRequest.getLocaleString("pendingTasks")%><%=sFilter.equals(String.valueOf(FlowNodeInstance.STATUS_PROCESSING))?"</strong>":""%></a>
                </li>
                <li role="menuitem">
                    <a href="<%=optsUrl.setParameter("sf", String.valueOf(FlowNodeInstance.STATUS_CLOSED))%>"><span class="fa fa-flag"></span> <%=sFilter.equals(String.valueOf(FlowNodeInstance.STATUS_CLOSED))?"<strong>":""%><%=paramRequest.getLocaleString("closedTasks")%><%=sFilter.equals(String.valueOf(FlowNodeInstance.STATUS_CLOSED))?"</strong>":""%></a>
                </li>
                <li role="menuitem">
                    <a href="<%=optsUrl.setParameter("sf", String.valueOf(FlowNodeInstance.STATUS_ABORTED))%>"><span class="fa fa-flag-o"></span> <%=sFilter.equals(String.valueOf(FlowNodeInstance.STATUS_ABORTED))?"<strong>":""%><%=paramRequest.getLocaleString("abortedTasks")%><%=sFilter.equals(String.valueOf(FlowNodeInstance.STATUS_ABORTED))?"</strong>":""%></a>
                </li>
            </ul>
        </div>             
    </div>  
</div> 
<% if (tinstances != null && tinstances.size() > 0) { %>
            <%Iterator<FlowNodeInstance> instances = tinstances.iterator();
            while(instances.hasNext()) {
                FlowNodeInstance instance = instances.next();
                    if (instance.getProcessInstance().getStatus() == Instance.STATUS_PROCESSING) {
            %>

        <div class="row swbp-input-tray"> 
            <%if (UserTaskInboxResource.COL_FLAGTASK != null) {
                UserTask utask = (UserTask)instance.getFlowNodeType();
                int delay = utask.getNotificationTime();
                boolean delayed = false;
                if (delay > 0) {
                    long today = System.currentTimeMillis();
                    long cr = instance.getCreated().getTime();
                    if (today - cr > (1000*60*delay)) {
                        delayed = true;
                    }
                }
                if (delayed) {%>
                    <div class="col-xs-12 swbp-tray-state-red"></div>
                <%} else {%>
                    <div class="col-xs-12 swbp-tray-state-green"></div>
                <%}  
            }%>
            <div class="row swbp-tray-info">    
            <% if (UserTaskInboxResource.COL_IDPROCESS != null) {%>
                <div class="col-lg-1 col-md-1 col-sm-1 col-xs-2 swbp-list-number"><%=instance.getProcessInstance().getId()%></div>
            <%}%>
            <div class="col-lg-11 col-md-11 col-sm-11 col-xs-10 hidden-padding">               
            <% if (UserTaskInboxResource.COL_NAMETASK != null) {%> 
                <div class="col-xs-12 swbp-tray-process">
                    <%=instance.getFlowNodeType().getDisplayTitle(lang)%>
                </div>
            <%} if (UserTaskInboxResource.COL_NAMEPROCESS != null) {%> 
                <div class="col-xs-12 swbp-tray-task">
                    Proceso: <%=instance.getFlowNodeType().getProcess().getDisplayTitle(lang)%>
                </div> 
            <%} if (cols.get(UserTaskInboxResource.COL_TASKSUBJECT) != null && null != instance.getSubject()) {%> 
                <div class="col-xs-12 swbp-tray-task">
                    <%= cols.get(UserTaskInboxResource.COL_TASKSUBJECT) %> : <%=instance.getSubject() %>
                </div> 
            <%} if (UserTaskInboxResource.COL_STARTTASK != null) {%>    
                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 swbp-tray-date">
                    <span class="">Inicio de la Tarea:</span>
                    <span class=""><%=SWBUtils.TEXT.getStrDate(instance.getCreated(), lang, "dd/mm/yy - hh:%m")%></span>
                </div>     
            <%} if (UserTaskInboxResource.COL_ENDTASK != null) {
                    String ended = "";
                    if (instance.getStatus() == Instance.STATUS_CLOSED || instance.getStatus() == Instance.STATUS_ABORTED) {
                        if (instance.getEnded() != null) {
                            ended = SWBUtils.TEXT.getStrDate(instance.getEnded(), lang, "dd/mm/yy - hh:%m");
                        }
                    }
                    if (!ended.isEmpty()) {
                    %>
                    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 swbp-tray-date">
                        <span class="">Fin de la Tarea:</span>
                        <span class=""><%=ended%></span>
                    </div>   
                <%
                    }
                }%>  
            </div>
            </div>
               <%if (UserTaskInboxResource.COL_ACTIONS != null) {%>
               <div class="row swbp-tray-action">
                <%UserTask utask = (UserTask) instance.getFlowNodeType();
                if (instance.getStatus() == ProcessInstance.STATUS_PROCESSING) {
                    if (isAdminUser(user, utir)) {
                        SWBResourceURL claimUrl = paramRequest.getActionUrl().setAction(UserTaskInboxResource.ACT_CLAIM);
                %>
                <a class="btn btn-default col-xs-3" href="<%=claimUrl%>?suri=<%=instance.getEncodedURI()%>" <% if (instance.getAssignedto() != null && !user.getURI().equals(instance.getAssignedto().getURI())) {%>onclick="return (confirm('La tarea le será asignada y desaparecerá de la bandeja del dueño. ¿Desea continuar?'))"<%}%>>
                    <span class="col-lg-4 col-md-4 col-sm-12 col-xs-12 fa fa-hand-o-up"></span>
                    <span class="col-lg-8 col-md-8 hidden-sm hidden-xs swbp-tray-text"><%=paramRequest.getLocaleString("actTake")%></span>
                </a>
                    <%
                } else {
                    %>
                <a class="btn btn-default col-xs-3" href="<%=utask.getTaskWebPage().getUrl()%>?suri=<%=instance.getEncodedURI()%>" title="<%=paramRequest.getLocaleString("actTake")%>">
                    <span class="col-lg-4 col-md-4 col-sm-12 col-xs-12 fa fa-hand-o-up"></span>
                    <span class="col-lg-8 col-md-8 hidden-sm hidden-xs swbp-tray-text"><%=paramRequest.getLocaleString("actTake")%></span>
                </a>
                    <%
                }
                if (allowForward) {
                    SWBResourceURL forward = paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setMode(UserTaskInboxResource.MODE_FWD);
                    //No es de nadie, no se permite reasignar a menos que sea admin
                    if (null == instance.getAssignedto()) {
                        if (isAdminUser(user, utir)) {
                    %><a href="<%=forward.setParameter("suri", instance.getURI())%>" class="btn btn-default col-xs-3" data-toggle="modal" data-target="#modalDialog">
                            <span class="col-lg-4 col-md-4 col-sm-12 col-xs-12 fa fa-exchange"></span>
                            <span class="col-lg-8 col-md-8 hidden-sm hidden-xs swbp-tray-text"><%=paramRequest.getLocaleString("actFwd")%></span>
                            
                    </a><%
}
} else if (instance.getAssignedto().getURI().equals(user.getURI()) || isAdminUser(user, utir)) {
                    %><a href="<%=forward.setParameter("suri", instance.getURI())%>" class="btn btn-default col-xs-3" data-toggle="modal" data-target="#modalDialog">
                            <span class="col-lg-4 col-md-4 col-sm-12 col-xs-12 fa fa-exchange"></span>
                            <span class="col-lg-8 col-md-8 hidden-sm hidden-xs swbp-tray-text"><%=paramRequest.getLocaleString("actFwd")%></span>
                    </a><%
}
}
}
if (statusWp != null) {%>
                <a class="btn btn-default col-xs-3" href="<%=statusWp.getUrl()%>?suri=<%=instance.getProcessInstance().getProcessType().getEncodedURI()%>">
                    <span class="col-lg-4 col-md-4 col-sm-12 col-xs-12 fa fa-sitemap fa-rotate-270"></span>
                    <span class="col-lg-8 col-md-8 hidden-sm hidden-xs swbp-tray-text"><%=paramRequest.getLocaleString("actMap")%></span></a><%
            }
            if(showPwpLink) {
                SWBResourceURL detailUrl = paramRequest.getRenderUrl().setMode(UserTaskInboxResource.MODE_PROCESSDETAIL);
                detailUrl.setParameter("suri", instance.getFlowNodeType().getProcess().getURI()).setParameter("suriInstance", instance.getProcessInstance().getURI());%>
                <a class="btn btn-default col-xs-3" href="<%=detailUrl%>">
                    <span class="col-lg-4 col-md-4 col-sm-12 col-xs-12 fa fa-bar-chart-o"></span>
                    <span class="col-lg-8 col-md-8 hidden-sm hidden-xs swbp-tray-text"><%=paramRequest.getLocaleString("actDetail")%></span>
                </a><%
            }
                    %>
            </div>
            <%
            } 
            %>         
        </div>
        <%
        }
}%>


<%
String sort = sortType;
String filter = sFilter;
String pfilter = pFilter;
if (sort != null && sort.length() > 0) {
    sort = "sort|"+sort;
} else {
    sort = "";
}

if (filter != null && filter.length() > 0) {
    filter = "sf|"+filter;
} else {
    filter = "";
}
            
if (pfilter != null && pfilter.length() > 0) {
    pfilter = "pf|"+pfilter;
} else {
    pfilter = "";
}
%>
<jsp:include page="/swbadmin/jsp/process/commons/pagination.jsp" flush="true">
    <jsp:param name="navUrlParams" value="<%=sort%>"/>
    <jsp:param name="navUrlParams" value="<%=filter%>"/>
    <jsp:param name="navUrlParams" value="<%=pfilter%>"/>
    <jsp:param name="showPageOfPage" value="true"/>
</jsp:include>
<%
} else {
%>
<div class="alert alert-warning">
    <p><%=paramRequest.getLocaleString("noTasks")%></p>
</div>
<%
}
}
}
%>