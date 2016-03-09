<%-- 
    Document   : render
    Created on : 28-ene-2016, 14:30:25
    Author     : hasdai
--%>
<%@page import="org.semanticwb.model.FormElement"%>
<%@page import="org.semanticwb.process.model.SWBProcessFormMgr"%>
<%@page import="org.semanticwb.platform.SemanticObject"%>
<%@page import="org.semanticwb.portal.SWBFormMgr"%>
<%@page import="org.semanticwb.process.model.ItemAware"%>
<%@page import="org.semanticwb.process.model.DataTypes"%>
<%@page import="org.semanticwb.model.SWBClass"%>
<%@page import="org.semanticwb.process.model.ItemAwareReference"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.semanticwb.platform.SemanticClass"%>
<%@page import="org.semanticwb.platform.SemanticProperty"%>
<%@page import="java.util.HashMap"%>
<%@page import="org.semanticwb.portal.SWBForms"%>
<%@page import="org.semanticwb.process.forms.SWBFormMgrLayer"%>
<%@page import="org.semanticwb.SWBUtils"%>
<%@page import="org.semanticwb.SWBPortal"%>
<%@page import="java.util.Date"%>
<%@page import="org.semanticwb.process.model.UserTask"%>
<%@page import="org.semanticwb.model.Resource"%>
<%@page import="org.semanticwb.process.model.Instance"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="org.semanticwb.model.User"%>
<%@page import="org.semanticwb.SWBPlatform"%>
<%@page import="org.semanticwb.process.model.FlowNodeInstance"%>
<%@page import="org.semanticwb.process.resources.ProcessForm"%>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest"/>
<%
    FlowNodeInstance foi = (FlowNodeInstance) SWBPlatform.getSemanticMgr().getOntology().getGenericObject(request.getParameter(ProcessForm.PARAM_SURI));
    ProcessForm pForm = (ProcessForm) request.getAttribute(ProcessForm.ATT_RBASE);
    Resource base = pForm.getResourceBase();
    User user = paramRequest.getUser();
    
    String adminMode = base.getAttribute("adminMode", ProcessForm.ADM_MODESIMPLE);
    String action = paramRequest.getAction();
    String lang = "es";
    if (null != user && user.getLanguage() != null) lang = user.getLanguage();
    
    boolean isAssigned = false;
    boolean isClosed = false;
    boolean noInstance = (null == foi);
    String errorMsg = "";
    String backUrl = "#";
    
    if (noInstance) {
        errorMsg = paramRequest.getLocaleString("msgNoInstance");
        backUrl = pForm.getUserTaskInboxUrl();
    } else {
        backUrl = foi.getUserTaskInboxUrl();
        isClosed = foi.getStatus() == Instance.STATUS_CLOSED || foi.getStatus() == Instance.STATUS_ABORTED || foi.getStatus() == Instance.STATUS_STOPED;
        
        if (isClosed) {
            errorMsg = "La tarea ya ha sido cerrada";
        } else {
            User assigned = foi.getAssignedto();
            isAssigned = (null != assigned && !assigned.equals(user));
            errorMsg = paramRequest.getLocaleString("msgAssigned");
        }
    }
    
    if (isAssigned || isClosed || noInstance) {
        %>
        <script>
            alert('<%= errorMsg %>');
            window.location= '<%= backUrl %>';
        </script>
        <%
    } else {
        //Show message
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

        //Asign task to user
        foi.setAssigned(new Date());
        foi.setAssignedto(user);

        //Get class and properties map from itemaware objects related
        HashMap<String, ItemAware> userDefinedVars = new HashMap<>();
        HashMap<String, SemanticClass> hmclass = new HashMap<>();
        HashMap<String, SemanticProperty> hmprops = new HashMap<>();
        Iterator<ItemAwareReference> it = foi.listHeraquicalItemAwareReference().iterator();
        while (it.hasNext()) {
            ItemAwareReference item = it.next();
            SWBClass obj = item.getProcessObject();

            if (obj != null) {
                SemanticClass cls = obj.getSemanticObject().getSemanticClass();

                hmclass.put(item.getItemAware().getName(), cls);
                Iterator<SemanticProperty> itp = cls.listProperties();
                while (itp.hasNext()) {
                    SemanticProperty prop = itp.next();
                    String name = item.getItemAware().getName() + "|" + prop.getPropId();
                    if (cls.isSubClass(DataTypes.sclass) && !userDefinedVars.containsKey(name)) {
                        userDefinedVars.put(name, item.getItemAware());
                    }
                    hmprops.put(name, prop);
                }
            }
        }

        if (ProcessForm.ADM_MODEADVANCED.equals(adminMode)) {
            if (action.equals("add") || action.equals("edit")) {
                String basepath = SWBPortal.getWorkPath() + base.getWorkPath() + "/";
                String xml = SWBUtils.IO.getFileFromPath(basepath + "code.xml");
                if (xml != null && xml.trim().length() > 0) {
                    SWBFormMgrLayer swbFormMgrLayer = new SWBFormMgrLayer(xml, paramRequest, request);
                    out.print(swbFormMgrLayer.getHtml());
                }
            }
        } else if (ProcessForm.ADM_MODESIMPLE.equals(adminMode)) {
            SWBResourceURL urlact = paramRequest.getActionUrl();
            urlact.setAction(ProcessForm.ACT_PROCESS);
            boolean showHeader = base.getAttribute("showHeader", "").equals("use");
            boolean btnSave = base.getAttribute("btnSave", "").equals("use");
            boolean btnAccept = base.getAttribute("btnAccept", "").equals("use");
            boolean btnReject = base.getAttribute("btnReject", "").equals("use");
            boolean btnCancel = base.getAttribute("btnCancel", "").equals("use");
            %>
            <%= SWBForms.DOJO_REQUIRED %>
            <div class="panel panel-default swbp-panel-head hidden-margin">
                <%
                if (showHeader) {
                    %><div class="panel-heading text-center"><%= foi.getFlowNodeType().getTitle() %></div><%
                }
                %>
                <form name="<%= foi.getId() %>" id="<%= foi.getId() %>/form" dojoType="dijit.form.Form" action="<%= urlact %>" method="post" onSubmit="return validateForm<%= foi.getId() %>('<%= foi.getId() %>/form');" class="form-horizontal">
                    <input type="hidden" name="<%= ProcessForm.PARAM_SURI %>" value="<%= foi.getURI() %>"/>
                    <input type="hidden" name="smode" value="edit"/>
                    <div class="panel-body swbp-panel-body-card">
                                <%
                                int max = 1;
                                if (!base.getAttribute("prop" + max, "").equals("")) {
                                    while (!base.getAttribute("prop" + max, "").equals("")) {
                                        String val = base.getAttribute("prop" + max);
                                        HashMap<String, String> propsMap = ProcessForm.getPropertiesMap(val);
                                        SemanticProperty semprop = hmprops.get(propsMap.get("varName") + "|" + propsMap.get("propId"));

                                        SemanticClass semclass = hmclass.get(propsMap.get("varName"));

                                        if (semclass != null && semprop != null) {
                                            SemanticObject sofe = SWBPlatform.getSemanticMgr().getOntology().getSemanticObject(propsMap.get("fe"));
                                            SWBProcessFormMgr fmgr = new SWBProcessFormMgr(foi);
                                            FormElement ele = fmgr.getFormElement(semprop, propsMap.get("varName"));

                                            if (propsMap.get("label") == null) {
                                                if (userDefinedVars.containsKey(propsMap.get("varName") + "|" + propsMap.get("propId"))) {
                                                    propsMap.put("label", userDefinedVars.get(propsMap.get("varName") + "|" + propsMap.get("propId")).getDisplayTitle(lang));
                                                } else {
                                                    propsMap.put("label", semprop.getDisplayName(lang));
                                                }
                                            }
                                            %>
                                            <div class="form-group">
                                                <div class="col-lg-3 col-md-3 col-sm-3 col-xs-12 swbp-modal-property">
                                                    <%
                                                        if (null == ele) {
                                                            %>
                                                            <%= fmgr.renderLabel(request, semprop, propsMap.get("varName"), propsMap.get("mode")) %>
                                                            <%
                                                        } else {
                                                            %>
                                                            <%= ele.renderLabel(request, null, semprop, propsMap.get("varName") + "." + semprop.getName(), SWBFormMgr.TYPE_DOJO, SWBFormMgr.MODE_CREATE, lang, propsMap.get("label")) %>
                                                            <%
                                                        }
                                                    %>
                                                </div>
                                                <div class="col-lg-7 col-md-7 col-sm-9 col-xs-12">
                                                    <%
                                                    if (null != sofe) {
                                                        FormElement frme = (FormElement) sofe.createGenericInstance();
                                                        %><%= fmgr.renderElement(request, propsMap.get("varName"), semprop, frme, propsMap.get("mode")) %><%
                                                    } else {
                                                        %><%= fmgr.renderElement(request, propsMap.get("varName"), semprop, propsMap.get("mode")) %><%
                                                    }
                                                    %>
                                                </div>
                                            </div>
                                            <%
                                        }
                                        max++;
                                    }
                                }
                                %>
                    </div>
                    <%
                    if (btnSave || btnAccept || btnReject || btnCancel) {
                        %>
                        <div class="panel-footer swbp-mup">
                            <!--haxdai14032014: Changed submit to onClick events and actions as hidden parameters as a workaround for dojo uploader-->
                            <%
                            if (btnSave) {
                                %>
                                <button dojoType="dijit.form.Button" type="submit" onclick="dojo.byId('<%= foi.getId()%>/form').submit();"><%=base.getAttribute("btnSaveLabel",paramRequest.getLocaleString("btnSaveTask"))%></button>
                                <%
                            }
                            if (btnAccept) {
                            %>
                                <input type="hidden" name="accept" />
                                <button dojoType="dijit.form.Button" type="submit" onclick="sendProcessForm<%=foi.getId()%>('accept');"><%=base.getAttribute("btnAcceptLabel",paramRequest.getLocaleString("btnCloseTask"))%></button>
                            <%
                            }
                            if (btnReject) {
                                %>
                                <input type="hidden" name="reject" />
                                <button dojoType="dijit.form.Button" type="submit" onclick="sendProcessForm<%=foi.getId()%>('reject');"><%=base.getAttribute("btnRejectLabel",paramRequest.getLocaleString("btnRejectTask"))%></button>
                                <%
                            }
                            if (btnCancel) {
                                %>
                                <input type="hidden" name="cancel" />
                                <button dojoType="dijit.form.Button" onclick="window.location='<%= foi.getUserTaskInboxUrl() + "?suri=" + foi.getURI() %>';"><%=base.getAttribute("btnCancelLabel",paramRequest.getLocaleString("btnBack"))%></button>
                                <%
                            }
                            %>
                            <!--haxdai14032014-->
                        </div>
                        <%
                    }
                    %>
                </form>
            </div>
            <script>
                function validateForm<%= foi.getId() %>(form) {
                    var frm = dijit.byId(form); 
                    if (frm.isValid()) {
                        return true;
                    } else {
                        alert('<%=paramRequest.getLocaleString("cancel")%>'); return false;
                    }
                }
            </script>
            <!--haxdai14032014: Added as workaround for dojo uploader-->
            <script>
                function sendProcessForm<%= foi.getId() %>(_action) {
                    var frm = dojo.byId('<%= foi.getId() %>/form');
                    if (_action && _action !== '') {
                        frm[_action].value=_action;
                    }
                    frm.submit();
                }
            </script>
            <!--haxdai14032014-->
            <%
        }
    }
%>