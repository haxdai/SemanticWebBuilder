<%-- 
    Document   : userTaskInboxNewCase
    Created on : 3/09/2013, 11:41:28 AM
    Author     : Hasdai Pacheco <ebenezer.sanchez@infotec.com.mx>
--%>
<%@page import="org.semanticwb.model.SWBComparator"%>
<%@page import="org.semanticwb.process.model.StartEvent"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.semanticwb.process.resources.taskinbox.UserTaskInboxResource"%>
<%@page import="java.util.TreeMap"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="org.semanticwb.model.User"%>
<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<%@page import="org.semanticwb.process.model.Process"%>
<%
SWBParamRequest paramRequest = (SWBParamRequest) request.getAttribute("paramRequest");
User user = paramRequest.getUser();
String lang = "es";
        
if (user != null && user.getLanguage() != null) {
    lang = user.getLanguage();
}

Map<String, ArrayList<Process>> groups = new TreeMap<>();
SWBResourceURL createUrl = paramRequest.getActionUrl().setAction(UserTaskInboxResource.ACT_CREATE);
ArrayList<Process> pccs = null;

//Obtener los eventos de inicio
Iterator<StartEvent> startEvents = StartEvent.ClassMgr.listStartEvents(paramRequest.getWebPage().getWebSite());
while(startEvents.hasNext()) {
    StartEvent sevt = startEvents.next();
    //Si el usuario tiene permisos en el evento
    if (sevt.getContainer() != null && sevt.getContainer() instanceof Process && user.haveAccess(sevt)) {
        Process itp = sevt.getProcess();
        //Si el proceso al que pertenece el evento y es válido
        if (itp != null && itp.isValid() && itp.isExecutable()) {
            if(itp.getProcessGroup() != null) {
                String pg = itp.getProcessGroup().getDisplayTitle(lang);
                //Si ya existe el grupo de procesos en el treemap
                if(groups.get(pg) != null) {
                    pccs = groups.get(pg);
                    if (!pccs.contains(itp)) {
                        pccs.add(itp);
                    }
                    groups.put(pg, pccs);
                } else { //Si no existe el grupo de procesos en el treemap
                    pccs = new ArrayList<>();
                    pccs.add(itp);
                    groups.put(pg, pccs);
                }
            }
        }
    }
}
Iterator<String> keys = groups.keySet().iterator();
%>
<div class="modal-dialog">
    <div class="modal-content">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            <h5 class="modal-title"><%=paramRequest.getLocaleString("createCase")%></h5>
        </div>
        <%if (keys.hasNext()) {%>
            <div id="formContainer">
                <form id="createInstanceForm" method="post" action="<%=createUrl%>" class="form-horizontal">
                    <div class="modal-body">
                        <div class="form-group">
                            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-12 swbp-modal-property">
                                <label for="pid">Proceso:</label>
                            </div>
                            <div class="col-lg-7 col-md-7 col-sm-7 col-xs-12">
                                <select class="form-control" name="pid" required>
                                <%while(keys.hasNext()) {
                                    String key = keys.next();
                                    %>
                                        <optgroup label="<%=key%>">
                                        <%Iterator<Process> it_pccs = SWBComparator.sortByDisplayName(groups.get(key).iterator(), lang);
                                        while(it_pccs.hasNext()) {
                                            Process pcc = it_pccs.next();
                                        %>
                                            <option value="<%=pcc.getId()%>"><%=pcc.getDisplayTitle(lang)%></option>
                                        <%
                                        }
                                        %>
                                        </optgroup>
                                    <%
                                }
                                %>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-default pull-right col-lg-3 col-md-3 col-sm-6 col-xs-6"><span class="fa fa-save fa-fw"></span><%=paramRequest.getLocaleString("btnOk")%></button>
                        <button type="button" class="btn btn-default pull-right col-lg-3 col-md-3 col-sm-6 col-xs-6" data-dismiss="modal"><span class="fa fa-arrow-left fa-fw"></span><%=paramRequest.getLocaleString("btnCancel")%></button>
                    </div>
                </form>
            </div>
            <script>
                (function() {
                    $(document).ready(function() {
                        var theForm = document.getElementById('createInstanceForm');
                        
                        if (theForm) {
                            $("#createInstanceForm").on("submit", function(evt) {
                                $.ajax({
                                    url: $(theForm).attr('action'),
                                    cache: false,
                                    data: $(theForm).serialize(),
                                    type: 'POST',
                                    contentType: "application/x-www-form-urlencoded; charset=utf-8",
                                    beforeSend: function() {
                                        $("#formContainer").empty();
                                        $("#formContainer").html('<div class="modal-body"><div class="row text-center"><p><span class="fa fa-refresh fa-2x fa-spin"></span></p><p>Creando instancia...</p></div></div>')
                                    },
                                    success: function(data) {
                                        $("#modalDialog").toggle("modal");
                                        if (data.status === "ok") {
                                            if (data.redirectUrl) window.location = data.redirectUrl;
                                        } else {
                                            if (window.toastr) {
                                                toastr.options.closeButton = true;
                                                toastr.options.positionClass = "toast-bottom-full-width";
                                                toastr.error("Ha ocurrido un error al crear la instancia");
                                            }
                                        }
                                    }
                                });
                                evt.preventDefault();
                            });
                        }
                    });
                })();
            </script>
        <%
        } else {
            %>
                <div class="modal-body">
                    <div class="text-center"><%=paramRequest.getLocaleString("msgNoProcess")%></div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn pull-right col-lg-3 col-md-3 col-sm-6 col-xs-6" data-dismiss="modal"><span class="fa fa-arrow-left fa-fw"></span><%=paramRequest.getLocaleString("btnCancel")%></button>
                </div>
            <%
        }
        %>
    </div>
</div>