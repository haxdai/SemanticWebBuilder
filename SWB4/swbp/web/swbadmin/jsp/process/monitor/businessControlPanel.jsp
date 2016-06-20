<%--
     SemanticWebBuilder Process (SWBP) es una plataforma para la gestión de procesos de negocio mediante el uso de 
     tecnología semántica, que permite el modelado, configuración, ejecución y monitoreo de los procesos de negocio
     de una organización, así como el desarrollo de componentes y aplicaciones orientadas a la gestión de procesos.

     Mediante el uso de tecnología semántica, SemanticWebBuilder Process puede generar contextos de información
     alrededor de algún tema de interés o bien integrar información y aplicaciones de diferentes fuentes asociadas a
     un proceso de negocio, donde a la información se le asigna un significado, de forma que pueda ser interpretada
     y procesada por personas y/o sistemas. SemanticWebBuilder Process es una creación original del Fondo de 
     Información y Documentación para la Industria INFOTEC.

     INFOTEC pone a su disposición la herramienta SemanticWebBuilder Process a través de su licenciamiento abierto 
     al público ("open source"), en virtud del cual, usted podrá usarlo en las mismas condiciones con que INFOTEC 
     lo ha diseñado y puesto a su disposición; aprender de él; distribuirlo a terceros; acceder a su código fuente,
     modificarlo y combinarlo (o enlazarlo) con otro software. Todo lo anterior de conformidad con los términos y 
     condiciones de la LICENCIA ABIERTA AL PÚBLICO que otorga INFOTEC para la utilización de SemanticWebBuilder Process. 

     INFOTEC no otorga garantía sobre SemanticWebBuilder Process, de ninguna especie y naturaleza, ni implícita ni 
     explícita, siendo usted completamente responsable de la utilización que le dé y asumiendo la totalidad de los 
     riesgos que puedan derivar de la misma. 

     Si usted tiene cualquier duda o comentario sobre SemanticWebBuilder Process, INFOTEC pone a su disposición la
     siguiente dirección electrónica: 
     http://www.semanticwebbuilder.org.mx

    Document   : businessControlPanel
    Created on : 5/07/2011, 04:14:49 PM
    Author     : Hasdai Pacheco {ebenezer.sanchez@infotec.com.mx}
--%>
<%@page import="org.semanticwb.process.resources.controlpanel.ControlPanelResource"%>
<%@page import="org.semanticwb.process.model.IntermediateCatchEvent"%>
<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="org.semanticwb.model.User"%>
<%@page import="org.semanticwb.model.RoleRef"%>
<%@page import="org.semanticwb.model.Role"%>
<%@page import="org.semanticwb.model.WebSite"%>
<%@page import="org.semanticwb.model.WebPage"%>
<%@page import="org.semanticwb.process.model.ProcessInstance"%>
<%@page import="org.semanticwb.process.model.SubProcessInstance"%>
<%@page import="org.semanticwb.process.model.Activity"%>
<%@page import="org.semanticwb.process.model.Instance"%>
<%@page import="org.semanticwb.process.model.ProcessSite"%>
<%@page import="org.semanticwb.process.model.UserTask"%>
<%@page import="org.semanticwb.process.model.Process"%>
<%@page import="org.semanticwb.process.model.ProcessGroup"%>
<%@page import="org.semanticwb.process.model.SWBProcessMgr"%>
<%@page import="org.semanticwb.process.model.FlowNodeInstance"%>
<%@page import="org.semanticwb.SWBUtils"%>
<%@page import="org.semanticwb.SWBPortal"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="org.semanticwb.model.SWBComparator"%>
<%@page import="java.util.List"%>
<%@page import="java.lang.Math"%>
<%@page import="java.util.ArrayList"%>

<%!
    public String getStatusInstances(ProcessInstance pi, int status) {
        String ret = "";
        if (pi != null) {
            Iterator<FlowNodeInstance> actit = SWBComparator.sortByCreated(pi.listFlowNodeInstances());
            while (actit.hasNext()) {
                FlowNodeInstance obj = actit.next();
                ret += _getStatusInstances(obj, status);
            }
        }
        return (ret);
    }

    public String _getStatusInstances(FlowNodeInstance fi, int status) {
        String ret = "";
        if (fi instanceof SubProcessInstance) {
            SubProcessInstance pi = (SubProcessInstance) fi;
            Iterator<FlowNodeInstance> acit = pi.listFlowNodeInstances();
            if (acit.hasNext()) {
                while (acit.hasNext()) {
                    FlowNodeInstance actinst = acit.next();
                    ret += _getStatusInstances(actinst, status);
                }
            }
        } else if (fi.getFlowNodeType() instanceof Activity && fi.getStatus() == status) {
            ret += fi.getFlowNodeType().getURI() + "|";
        }
        return ret;
    }
%>
<script type="text/javascript">
    function loadPageUrl(url, paramName, paramValue) {
        var dest = url;
        if (paramName !== null && paramValue !== null) {
            dest += "&" + paramName + "=" + paramValue;
        }
        window.location = dest;
    }
</script>
<%
    SWBParamRequest paramRequest = (SWBParamRequest) request.getAttribute("paramRequest");
    WebPage statusWp = (WebPage) request.getAttribute("statusWp");

    SWBResourceURL detailURL = paramRequest.getRenderUrl().setMode(ControlPanelResource.MODE_DETAIL);
    User user = paramRequest.getUser();
    WebSite site = paramRequest.getWebPage().getWebSite();
    String sortType = request.getParameter("sort");
    String gFilter = request.getParameter("gF");
    String sFilter = request.getParameter("sF");
    String displayCols = (String) request.getAttribute("displayCols");
    String lang = "es";

    String pNum = request.getParameter("p");
    int maxPages = (Integer) request.getAttribute("maxPages");
    int pageNum = 1;

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

    if (gFilter == null || gFilter.trim().equals("")) {
        gFilter = "";
    }

    if (sFilter == null || sFilter.trim().equals("")) {
        sFilter = String.valueOf(ProcessInstance.STATUS_PROCESSING);
    }
    
    SWBResourceURL filterGroupUrl = paramRequest.getRenderUrl();
    filterGroupUrl.setParameter("p", String.valueOf(pageNum));
    filterGroupUrl.setParameter("sF", sFilter);
    filterGroupUrl.setParameter("sort", sortType);
    
    SWBResourceURL filterStatusUrl = paramRequest.getRenderUrl();
    filterStatusUrl.setParameter("p", String.valueOf(pageNum));
    filterStatusUrl.setParameter("gF", gFilter);
    filterStatusUrl.setParameter("sort", sortType);
    
    SWBResourceURL filterSort = paramRequest.getRenderUrl();
    filterSort.setParameter("p", String.valueOf(pageNum));
    filterSort.setParameter("gF", gFilter);
    filterSort.setParameter("sF", sFilter);
    
    ArrayList<ProcessInstance> pinstances = (ArrayList<ProcessInstance>) request.getAttribute("instances");
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
        if (paramRequest.getMode().equals(paramRequest.Mode_VIEW)) {
            %>
            <div class="row swbp-pad">&nbsp;</div>
            <div class="row form-group swbp-filters">
                <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 ">
                    <div class="col-lg-4 col-md-4 hidden-sm hidden-xs text-right">
                        <label for="">Mostrar:</label>
                    </div>
                    <div class="col-lg-8 col-md-8 col-sm-12 col-xs-12 hidden-padding">
                        <select id="groupSelect" class="form-control">
                            <option value="-1" <%=gFilter.equals("") ? "selected" : ""%>><%=paramRequest.getLocaleString("allGroups")%></option>
                            <%
                            Iterator<ProcessGroup> groups = ProcessGroup.ClassMgr.listProcessGroups(site);
                            groups = SWBComparator.sortByDisplayName(groups, lang);
                            while (groups.hasNext()) {
                                ProcessGroup group = groups.next();
                                String selected = gFilter.equals(group.getId()) ? "selected" : "";
                                if (group.isValid()) {
                                    %>
                                    <option value="<%=group.getId()%>" <%=selected%>><%=group.getDisplayTitle(lang)%></option>
                                    <%
                                }
                            }
                            %>
                        </select>
                    </div>
                </div>
                <div class="col-lg-4 col-md-4 col-sm-4 col-xs-6">
                    <div class="col-lg-4 col-md-4 hidden-sm hidden-xs text-right">
                        <label for="">Ordenar:</label>
                    </div>
                    <div class="col-lg-8 col-md-8 col-sm-12 col-xs-12 hidden-padding">
                         <select id="sortSelect" class="form-control">
                             <optgroup class="dropdown-header" label="<%=paramRequest.getLocaleString("sortDate")%>">
                                 <option value="1" <%= sortType.equals("1")?"selected":"" %>><%=paramRequest.getLocaleString("sortLatest")%></option>
                                <option value="2" <%= sortType.equals("2")?"selected":"" %>><%=paramRequest.getLocaleString("sortOldest")%></option>
                            </optgroup>
                            <optgroup class="dropdown-header" label="<%=paramRequest.getLocaleString("sortProcess")%>">  
                                <option value="3" <%= sortType.equals("3")?"selected":"" %>><%=paramRequest.getLocaleString("sortNameAsc")%></option>
                                <option value="4" <%= sortType.equals("4")?"selected":"" %>><%=paramRequest.getLocaleString("sortNameDes")%></option>
                            </optgroup>
                        </select>
                    </div>
                </div>
                <div class="col-lg-4 col-md-4 col-sm-4 col-xs-6">
                    <div class="col-lg-4 col-md-4 hidden-sm hidden-xs text-right">
                        <label for="">Filtrar:</label>
                    </div>
                    <div class="col-lg-8 col-md-8 col-sm-12 col-xs-12 hidden-padding dropdown">
                        <select id="statusSelect" class="form-control">
                            <option value="-1" <%= sFilter.equals("-1")?"selected":"" %>><%=paramRequest.getLocaleString("allStatus")%></option>
                            <option value="1" <%= sFilter.equals("1")?"selected":"" %>><%=paramRequest.getLocaleString("lblProcessing")%></option>
                            <option value="4" <%= sFilter.equals("4")?"selected":"" %>><%=paramRequest.getLocaleString("lblClosed")%></option>
                            <option value="3" <%= sFilter.equals("3")?"selected":"" %>><%=paramRequest.getLocaleString("lblAborted")%></option>
                        </select>
                    </div>
                </div>
            </div>
                <%
                if (null != pinstances && !pinstances.isEmpty()) {
                    %>
                    <div class="panel panel-default swbp-panel-head hidden-margin">
                        <div class="panel-heading text-center">Instancias de procesos</div>
                        <div class="panel-body swbp-panel-body-card swbp-tray-body-panel">
                            <div class="table-responsive-vertical shadow-z-1 swbp-table-responsive">
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <%
                                            if (displayCols.contains("idCol")) {
                                                %><th><%=paramRequest.getLocaleString("lblColID")%></th><%
                                            }
                                            if (displayCols.contains("priorityCol")) {
                                                %><th><%=paramRequest.getLocaleString("lblColPriority")%></th><%
                                            }
                                            if (displayCols.contains("nameCol")) {
                                                %><th><%=paramRequest.getLocaleString("lblColProcessName")%></th><%
                                            }
                                            if (displayCols.contains("sdateCol")) {
                                                %><th><%=paramRequest.getLocaleString("lblColStarted")%></th><%
                                            }
                                            if (displayCols.contains("edateCol")) {
                                                %><th><%=paramRequest.getLocaleString("lblColEnded")%></th><%
                                            }
                                            if (displayCols.contains("pendingCol")) {
                                                %><th><%=paramRequest.getLocaleString("lblColActivities")%></th><%
                                            }
                                            if (displayCols.contains("rolesCol")) {
                                                %><th><%=paramRequest.getLocaleString("lblColRoles")%></th><%
                                            }
                                            if (displayCols.contains("actionsCol")) {
                                                %><th class="swbp-actions"><%=paramRequest.getLocaleString("lblColActions")%></th><%
                                            }
                                            %>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
                                        Iterator<ProcessInstance> instances = pinstances.iterator();
                                        while (instances.hasNext()) {
                                            ProcessInstance instance = instances.next();
                                            String Id = instance.getId();
                                            String pName = instance.getProcessType().getDisplayTitle(lang);
                                            String pCreated = SWBUtils.TEXT.iso8601DateFormat(instance.getCreated());//getStrDate(instance.getCreated(), lang, "dd/mm/yy - hh:%m");
                                            String pClosed = "-";

                                            if (instance.getStatus() == ProcessInstance.STATUS_CLOSED) {
                                                pClosed = SWBUtils.TEXT.iso8601DateFormat(instance.getEnded());//getStrDate(instance.getEnded(), lang, "dd/mm/yy - hh:%m");
                                            }
                                            %>
                                            <tr>
                                                <%
                                                if (displayCols.contains("idCol")) {
                                                    %><td data-title="<%=paramRequest.getLocaleString("lblColID")%>"><%=Id%></td><%
                                                }
                                                if (displayCols.contains("priorityCol")) {
                                                    %><td data-title="<%=paramRequest.getLocaleString("lblColPriority")%>"><%=instance.getPriority()%></td><%
                                                }
                                                if (displayCols.contains("nameCol")) {
                                                    %><td data-title="<%=paramRequest.getLocaleString("lblColProcessName")%>"><%=pName%></td><%
                                                }
                                                if (displayCols.contains("sdateCol")) {
                                                    %><td data-title="<%=paramRequest.getLocaleString("lblColStarted")%>"><%=pCreated%></td><%
                                                }
                                                if (displayCols.contains("edateCol")) {
                                                    %><td data-title="<%=paramRequest.getLocaleString("lblColEnded")%>"><%=pClosed%></td><%
                                                }
                                                if (displayCols.contains("pendingCol")) {
                                                    %>
                                                    <td data-title="<%=paramRequest.getLocaleString("lblColActivities")%>">
                                                        <%
                                                        Iterator<FlowNodeInstance> tasks = instance.listFlowNodeInstances();
                                                        if (tasks.hasNext() && instance.getStatus() == ProcessInstance.STATUS_PROCESSING) {
                                                            %>
                                                            <ul>
                                                                <%
                                                                while (tasks.hasNext()) {
                                                                    FlowNodeInstance task = tasks.next();
                                                                    if (task.getFlowNodeType() instanceof UserTask) {
                                                                        if (task.getStatus() == task.STATUS_PROCESSING) {
                                                                            %>
                                                                            <b><%=task.getFlowNodeType().getDisplayTitle(lang)%></b><br/>
                                                                            <%
                                                                        }
                                                                    }
                                                                }
                                                                %>
                                                            </ul>
                                                            <%
                                                        }
                                                        %>
                                                    </td>
                                                    <%
                                                }
                                                if (displayCols.contains("rolesCol")) {
                                                    %>
                                                    <td data-title="<%=paramRequest.getLocaleString("lblColRoles")%>">
                                                        <%
                                                        Iterator<FlowNodeInstance> tasks = instance.listFlowNodeInstances();
                                                        if (tasks.hasNext() && instance.getStatus() == ProcessInstance.STATUS_PROCESSING) {
                                                            %>
                                                            <ul>
                                                                <%
                                                                while (tasks.hasNext()) {
                                                                    FlowNodeInstance task = tasks.next();
                                                                    if (task.getFlowNodeType() instanceof UserTask) {
                                                                        if (task.getStatus() == task.STATUS_PROCESSING) {
                                                                            UserTask utask = (UserTask) task.getFlowNodeType();
                                                                            Iterator<RoleRef> roles = utask.listRoleRefs();
                                                                            while (roles.hasNext()) {
                                                                                RoleRef roleRef = roles.next();
                                                                                String role = roleRef.getRole().getDisplayTitle(lang);
                                                                                %>
                                                                                <li>
                                                                                    <b><%=role%></b>
                                                                                </li>
                                                                                <%
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                                %>
                                                            </ul>
                                                            <%
                                                        }
                                                        %>
                                                    </td>
                                                    <%
                                                }
                                                if (displayCols.contains("actionsCol")) {
                                                    %>
                                                    <td class="swbp-action-table">
                                                        <%
                                                        String acts = getStatusInstances(instance, ProcessInstance.STATUS_PROCESSING);
                                                        if (acts != null && !acts.trim().equals("")) {
                                                            acts = "&currentActivities=" + URLEncoder.encode(acts);
                                                        }

                                                        if (statusWp != null) {
                                                            %>
                                                            <a href="<%=statusWp.getUrl()%>?suri=<%=instance.getProcessInstance().getProcessType().getEncodedURI()%>" class="btn btn-default col-lg-4 col-md-4" title="<%=paramRequest.getLocaleString("actMap")%>"><span class="fa fa-sitemap fa-rotate-270"></span></a>
                                                            <%
                                                        }
                                                        %>
                                                        <a href="<%=detailURL.setParameter("suriInstance", instance.getProcessInstance().getURI()).setParameter("suri", instance.getProcessType().getURI())%>" class="btn btn-default col-lg-4 col-md-4" title="<%=paramRequest.getLocaleString("actDetail")%>"><span class="fa fa-bar-chart-o"></span></a>
                                                        <%
                                                        SWBResourceURL docsUrl = paramRequest.getRenderUrl().setMode("showFiles");
                                                        docsUrl.setParameter("pid", instance.getId());
                                                        docsUrl.setParameter("gF", request.getParameter("gF"));
                                                        docsUrl.setParameter("sF", request.getParameter("sF"));
                                                        docsUrl.setParameter("sort", request.getParameter("sort"));
                                                        %>
                                                        <!--a href="<%=docsUrl%>" class="btn btn-default col-lg-4 col-md-4" title="<%=paramRequest.getLocaleString("actDocs")%>"><span class="fa fa-folder-open-o"></span></a-->
                                                    </td>
                                                    <%
                                                }
                                                %>
                                            </tr>
                                            <%
                                        }
                                        %>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <%
                    String sort = request.getParameter("sort");
                    if (sort != null && sort.length() > 0) {
                        sort = "sort|" + sort;
                    } else {
                        sort = "";
                    }
                    String p1 = sFilter.length() > 0 ? ("sF|"+sFilter) : "";
                    String p2 = gFilter.length() > 0 ? ("gF|"+gFilter) : "";
                    %>
                    <jsp:include page="/swbadmin/jsp/process/commons/pagination.jsp" flush="true">
                        <jsp:param name="navUrlParams" value="<%=sort%>"/>
                        <jsp:param name="navUrlParams" value="<%=p1%>"/>
                        <jsp:param name="navUrlParams" value="<%=p2%>"/>
                        <jsp:param name="showPageOfPage" value="true"/>
                    </jsp:include>                    
                    <%
                } else {
                    %>
                    <div class="alert alert-warning">
                        <p><%=paramRequest.getLocaleString("msgNoInfo")%></p>
                    </div>
                    <%
                }
                %>
            <script>
                (function() {
                    $(document).ready(function(){
                        var e = document.getElementById("groupSelect");
                        var e2 = document.getElementById("sortSelect");
                        var e3 = document.getElementById("statusSelect");
                        e.addEventListener("change", function(ev) {
                            var g = (ev.target && ev.target.options[ev.target.selectedIndex].value) || "";
                            window.location = '<%= filterGroupUrl %>&gF='+g;
                        });

                        e2.addEventListener("change", function(ev) {
                            var g = (ev.target && ev.target.options[ev.target.selectedIndex].value) || "";
                            window.location = '<%= filterSort %>&sort='+g;
                        });

                        e3.addEventListener("change", function(ev) {
                            var g = (ev.target && ev.target.options[ev.target.selectedIndex].value) || "";
                            window.location = '<%= filterStatusUrl %>&sF='+g;
                        });
                    });
                })();
            </script>
            <%
        }
    }
%>