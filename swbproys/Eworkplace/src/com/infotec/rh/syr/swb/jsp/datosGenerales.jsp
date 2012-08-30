<%@page import="org.semanticwb.portal.SWBFormMgr"%>
<%@page import="com.infotec.cvi.swb.SolicitudRecurso"%>
<%@page import="org.semanticwb.process.model.FlowNodeInstance"%>
<%@page import="org.semanticwb.process.model.SWBProcessFormMgr"%>

<%
SWBProcessFormMgr fmgr = (SWBProcessFormMgr) request.getAttribute("fmgr");
FlowNodeInstance foi = (FlowNodeInstance) request.getAttribute("foi");
String varSolicitud = (String) request.getAttribute("varSolicitud");
String varSeguimiento = (String) request.getAttribute("varSeguimiento");
%>

<tr><td colspan="2"><b>Datos generales</b></td></tr>
<tr>
    <td width="200px" align="right"><label for="title">Fecha de solicitud</label>
    <td>
        <span><%=foi.getCreated()%></span>
    </td>
</tr>
<tr>
    <td width="200px" align="right"><label for="title">Nombre del solicitante</label>
    <td>
        <span><%=foi.getProcessInstance().getCreator().getFullName()%></span>
    </td>
</tr>
<tr>
    <td width="200px" align="right"><label for="title"><%=fmgr.renderLabel(request, SolicitudRecurso.intranet_folio, varSolicitud, SWBFormMgr.MODE_VIEW)%></label>
    <td>
        <%=fmgr.renderElement(request, varSolicitud, SolicitudRecurso.intranet_folio, SWBFormMgr.MODE_VIEW)%>
    </td>
</tr>
<tr>
    <td width="200px" align="right"><label for="title">&Aacute;rea de adscripci&oacute;n</label>
    <td>
        <span><%=foi.getProcessInstance().getCreator().getUserGroup().getTitle()%></span>
    </td>
</tr>
<tr>
    <td width="200px" align="right"><label for="title">Jefe inmediato</label>
    <td>
        <span>Jefe inmediato</span>
    </td>
</tr>
<tr>
    <td width="200px" align="right"><label for="title"><%=fmgr.renderLabel(request, SolicitudRecurso.intranet_contratacion, varSolicitud, SWBFormMgr.MODE_VIEW)%></label></td>
    <td>
        <%=fmgr.renderElement(request, varSolicitud, SolicitudRecurso.intranet_contratacion, SWBFormMgr.MODE_VIEW)%>
    </td>
</tr>
<tr>
    <td width="200px" align="right"><label for="title"><%=fmgr.renderLabel(request, SolicitudRecurso.intranet_motivoContratacion, varSolicitud, SWBFormMgr.MODE_VIEW)%></label></td>
    <td>
        <%=fmgr.renderElement(request, varSolicitud, SolicitudRecurso.intranet_motivoContratacion, SWBFormMgr.MODE_VIEW)%>
    </td>
</tr>