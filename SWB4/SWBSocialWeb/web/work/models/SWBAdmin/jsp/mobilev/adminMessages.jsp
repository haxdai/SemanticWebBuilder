<%-- 
    Document   : adminMessages
    Created on : 24/10/2014, 11:15:40 AM
    Author     : jorge.jimenez
--%>
<%@page import="org.semanticwb.social.util.SocialLoader"%>
<%@page import="org.semanticwb.social.util.SWBSocialUtil"%>
<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<%@page import="org.semanticwb.social.*"%>
<%@page import="org.semanticwb.SWBUtils"%>
<%@page import="java.util.*"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="org.semanticwb.social.SocialFlow.SocialPFlowMgr"%>
<%@page import="org.semanticwb.*,org.semanticwb.platform.*,org.semanticwb.portal.*,org.semanticwb.model.*,java.util.*,org.semanticwb.base.util.*"%>
<%@page import="java.text.SimpleDateFormat"%>

<%
 try
 {    
    WebPage wp = (WebPage) request.getAttribute("webpage");
    User user = (User) request.getAttribute("user");
    WebSite wsite = SWBSocialUtil.getConfigWebSite(); 
    WebSite adminWebSite=SWBContext.getAdminWebSite();
    WebPage userMsgBoardwp=adminWebSite.getWebPage("m_umb");

    Iterator<UserMessage> itUserMsg = UserMessage.ClassMgr.listUserMessageByUsers(user, wsite); 
    //System.out.println("itUserMsgJJ:"+itUserMsg); 
    HashMap hashBydate = new HashMap();
    //ArrayList lista = new ArrayList();
    while (itUserMsg.hasNext()) {
        UserMessage userMsg = itUserMsg.next();
        Date toDateD = userMsg.getCreated();
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
        String fecha = formatoDelTexto.format(toDateD);
        hashBydate.put(fecha, cad(userMsg, (ArrayList) hashBydate.get(fecha)));
    }

    ArrayList<Date> list = new ArrayList<Date>();
    Iterator i = hashBydate.entrySet().iterator();
    while (i.hasNext()) {
        Map.Entry e = (Map.Entry) i.next();
        list = (ArrayList) e.getValue();
        ordenarDescendente(list);
        Iterator x = list.iterator();
   
        while (x.hasNext()) {
            UserMessage um = (UserMessage) x.next();
            Date toDateD = um.getCreated();
            SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
            SimpleDateFormat hours = new SimpleDateFormat("hh:mm");
            String fecha = formatoDelTexto.format(toDateD);
            String hoursS = hours.format(toDateD);
            User u = um.getModifiedBy();
            %>
                <li>
                    <a href="<%=userMsgBoardwp.getUrl()%>?action=viewMsg&msgUri=<%=um.getEncodedURI()%>"> 
                        <div>
                            <i class="fa fa-envelope fa-fw"></i>
                            <strong><%=u.getName()%></strong>
                            <span class="pull-right text-muted">
                                <em><%=hoursS%></em>
                            </span>
                        </div>
                                <div><%=um.getUsrMsg().length()>50?um.getUsrMsg().substring(0,50):um.getUsrMsg()%></div>
                    </a>
                </li>
            <%
            }
        }
    %>
    <li class="divider"></li>
    <li>
        <a class="text-center" href="<%=userMsgBoardwp.getUrl()%>">
            <strong>Centro de mensajes</strong>
            <i class="fa fa-angle-right"></i>
        </a>
    </li>
<%
 }catch(Exception e){e.printStackTrace();}
%>


<%!
    public ArrayList cad(UserMessage cadena, ArrayList pi) {

        if (pi == null) {
            pi = new ArrayList();
        }
        pi.add(cadena);
        return pi;

    }

    public void ordenarDescendente(ArrayList fechas) {

        for (int i = 0; i < fechas.size(); i++) {
            for (int j = 0; j < fechas.size(); j++) {
                UserMessage o = (UserMessage) fechas.get(i);
                UserMessage oo = (UserMessage) fechas.get(j);

                if (o.getCreated().after(oo.getCreated())) {
                    fechas.set(i, fechas.get(j));
                    fechas.set(j, o);
                }
            }
        }
    }
%>
