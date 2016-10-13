<%@page import="org.semanticwb.model.SWBContext"%>
<%@page import="org.semanticwb.model.User"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="org.semanticwb.SWBPlatform"%>
<%@page import="org.semanticwb.model.PFlow"%>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest"/>
<%
PFlow af = (PFlow) SWBPlatform.getSemanticMgr().getOntology().getGenericObject(request.getParameter("suri"));
String resID = af.getWebSite().getId()+"_"+af.getId();

SWBResourceURL data = paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setMode("gateway").setAction("getWorkflow");
data.setParameter("suri", request.getParameter("suri"));

SWBResourceURL save = paramRequest.getActionUrl().setAction("updateWorkflow");
save.setParameter("suri", request.getParameter("suri"));
save.setParameter("id", resID);
%>
<!-- Transition Dialog -->
<div id="addTransitionDialog_<%= resID %>" data-dojo-type="dijit.Dialog" title="Agregar secuencia">
    <div class="swbform">
        <div id="addTransitionTabContainer_<%= resID %>" data-dojo-type="dijit.layout.TabContainer" style="width: 400px; height: 300px;">
            <div data-dojo-type="dijit.layout.ContentPane" title="Transición" id="infoPane_<%= resID %>">
                <form data-dojo-type="dijit.form.Form" id="addTransition_form<%= resID %>">
                    <fieldset>
                        <table>
                            <tr>
                                <td>
                                    Origen *:
                                </td>
                                <td>
                                    <select name="fromAct" id="fromAct_<%= resID %>" data-dojo-type="dijit/form/Select" required="true"></select>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Tipo:
                                </td>
                                <td>
                                    <select name="linkType" id="linkAct<%= resID %>" data-dojo-type="dijit/form/Select" required="true">
                                        <option value="1">Aprobación</option>
                                        <option value="2">Rechazo</option>
                                    </select>
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                    <fieldset>
                        <table>
                            <tr>
                                <td>
                                    <input name="name2" id="endflowRadio_<%= resID %>" type="radio" data-dojo-type="dijit.form.RadioButton" checked="true"/><label>Terminar flujo</label>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <input type="checkbox" id="autoPublish_<%= resID %>" data-dojo-type="dijit.form.CheckBox"/><label>Publicar automáticamente</label>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <input type="checkbox" id="authorized_<%= resID %>" data-dojo-type="dijit.form.CheckBox"/><label>Autorizado</label>
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                    <fieldset>
                        <table>
                            <tr>
                                <td>
                                    <input name="name2" id="startflowRadio_<%= resID %>" type="radio" data-dojo-type="dijit.form.RadioButton"/><label>Enviar al autor del contenido</label>
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                    <fieldset>
                        <table>
                            <tr>
                                <td>
                                    <input name="name2" id="redirectflowRadio_<%= resID %>" type="radio" data-dojo-type="dijit.form.RadioButton"/><label>Enviar a otra actividad</label>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <select name="nextAct" id="nextAct_<%= resID %>" data-dojo-type="dijit/form/Select">
                                    </select>
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                </form>
            </div>
            <div data-dojo-type="dijit.layout.ContentPane" title="Avisos">
                <div id="notifications_<%= resID %>">
                    <div data-dojo-type="dijit.layout.TabContainer" style="width: 400px; height: 300px;">
                        <div data-dojo-type="dijit.layout.ContentPane" title="Usuarios">
                            <div id="sequenceNotificationUsers_<%= resID %>"></div>
                        </div>
                        <div data-dojo-type="dijit.layout.ContentPane" title="Roles">
                            <div id="sequenceNotificationRoles_<%= resID %>"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <fieldset>
            <button id="addSequenceAccept_<%= resID %>">Aceptar</button>
            <button id="addSequenceCancel_<%= resID %>">Cancelar</button>
        </fieldset>
    </div>
</div>