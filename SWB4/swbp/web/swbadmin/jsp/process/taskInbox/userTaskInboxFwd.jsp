<%-- 
    Document   : userTaskInboxFwd
    Created on : 4/09/2013, 08:15:19 PM
    Author     : Hasdai Pacheco <ebenezer.sanchez@infotec.com.mx>
--%>

<%@page import="org.semanticwb.process.resources.taskinbox.UserTaskInboxResource"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="org.semanticwb.model.RoleRef"%>
<%@page import="org.semanticwb.model.Role"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.semanticwb.process.model.UserTask"%>
<%@page import="org.semanticwb.model.UserRepository"%>
<%@page import="org.semanticwb.process.model.FlowNodeInstance"%>
<%@page import="org.semanticwb.platform.SemanticObject"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.semanticwb.model.WebSite"%>
<%@page import="org.semanticwb.model.User"%>
<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<%
SWBParamRequest paramRequest = (SWBParamRequest)request.getAttribute("paramRequest");
User user = paramRequest.getUser();
WebSite site = paramRequest.getWebPage().getWebSite();
String suri = request.getParameter("suri");
boolean isAdmin = (Boolean) request.getAttribute("isAdmin");

Iterator<User> tPartners = null;
FlowNodeInstance fni = null;

SemanticObject sobj = SemanticObject.createSemanticObject(suri);
if (sobj != null) {
    fni = (FlowNodeInstance) sobj.createGenericInstance();
}

if (fni != null) {
    User owner = fni.getAssignedto();
    if (isAdmin || owner.equals(user)) {
        UserRepository ur = site.getUserRepository();
        UserTask task = (UserTask) fni.getFlowNodeType();
        ArrayList<Role> taskRoles = new ArrayList<>();

        Iterator<RoleRef> refs = task.listRoleRefs();
        while (refs.hasNext()) {
            RoleRef roleRef = refs.next();
            if (roleRef.getRole() != null && roleRef.isActive()) {
                taskRoles.add(roleRef.getRole());
            }
        }

        if (taskRoles.isEmpty()) {
            tPartners = ur.listUsers();
        } else {
            ArrayList<User> _users = new ArrayList<>();
            Iterator<Role> tRoles = taskRoles.iterator();
            while (tRoles.hasNext()) {
                Role role = tRoles.next();
                Iterator<User> users = User.ClassMgr.listUserByRole(role);
                while (users.hasNext()) {
                    User user1 = users.next();
                    if (!_users.contains(user1) && !user1.equals(owner)) {
                        _users.add(user1);
                    }
                }
            }
            tPartners = _users.iterator();
        }
    }
}

SWBResourceURL forward = paramRequest.getActionUrl().setAction(UserTaskInboxResource.MODE_FWD);
%>
<div class="modal-dialog">
    <div class="modal-content">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            <h5 class="modal-title"><%=paramRequest.getLocaleString("actFwd")%></h5>
        </div>
        <%if (tPartners != null && tPartners.hasNext()) {%>
            <form method="post" action="<%=forward%>" >
                <input type="hidden" name="suri" value="<%=suri%>"/>
                <div class="modal-body">
                    <div class="row form-group">
                    <div class="col-lg-3 col-md-3 col-sm-2 col-xs-12 swbp-modal-property">
                        <label for="pid"><%=paramRequest.getLocaleString("promptFwd")%></label>
                    </div>
                    <div class="col-lg-7 col-md-7 col-sm-10 col-xs-12">
                        <select class="form-control" name="owner">
                        <option value="--"><%=paramRequest.getLocaleString("freeTask")%></option>
                        <%while(tPartners.hasNext()) {
                            User _user = tPartners.next();
                            if (!_user.equals(fni.getAssignedto())) {
                                %>
                                <option value="<%=_user.getId()%>"><%=(_user.getFullName()==null||_user.getFullName().trim().equals(""))?_user.getId():_user.getFullName()%></option>
                                <%
                            }
                        }
                        %>
                        </select>
                    </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-default pull-right col-lg-3 col-md-3 col-sm-6 col-xs-6">
                        <span class="fa fa-hand-o-right fa-fw"></span><%=paramRequest.getLocaleString("btnOk")%>
                    </button>
                    <button type="button" class="btn btn-default pull-right col-lg-3 col-md-3 col-sm-6 col-xs-6" data-dismiss="modal">
                        <span class="fa fa-arrow-left fa-fw"></span><%=paramRequest.getLocaleString("btnCancel")%>
                    </button>
                    
                </div>
            </form>
        <%
        } else {
        %>
            <div class="modal-body">
                <div class="text-center"><%=paramRequest.getLocaleString("msgFwdFail")%></div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal"><%=paramRequest.getLocaleString("btnCancel")%></button>
            </div>
        <%
        }
        %>
    </div>
</div>