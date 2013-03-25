<%--   
    Document   : view Recurso Temas
    Created on : 27/06/2012
    Author     : rene.jara
--%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.semanticwb.SWBUtils"%>
<%@page import="java.util.Comparator"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.infotec.conorg.*"%>
<%@page import="org.semanticwb.model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest" />
<%
    WebPage wpage = paramRequest.getWebPage();
    WebSite wsite = wpage.getWebSite();
    User user = paramRequest.getUser();
    String orderby = request.getParameter("ob");
    String url = paramRequest.getRenderUrl().toString();
    org.semanticwb.model.Resource base = paramRequest.getResourceBase();

    int numpag;
    try {
        numpag = Integer.parseInt(base.getAttribute("numpag", "10"));
    } catch (Exception ignored) {
        numpag = 10;
    }
    //long totpag;
    int curpag;
    //long currec=0;
    try {
        curpag = Integer.parseInt(request.getParameter("page"));
    } catch (Exception ignored) {
        curpag = 0;
    }
    String toid = request.getParameter("toid");
    if (toid == null || toid.equals("")) {
        Iterator<com.infotec.conorg.Topic> ittmp = com.infotec.conorg.Topic.ClassMgr.listTopics(wsite);
        Iterator<com.infotec.conorg.Topic> itto = com.infotec.conorg.Topic.ClassMgr.listTopics(wsite);
        long totrec = SWBUtils.Collections.sizeOf(itto);
        //totpag=(long)Math.floor(totrec/numpag);

        /*if((totrec%numpag)>0){
         totpag++;
         }*/
        if (orderby == null || orderby.equals("")) {
            orderby = "n";
        }
        if (orderby.equals("n")) {
            itto = SWBComparator.sortByDisplayName(ittmp, user.getLanguage());
        } else if (orderby.equals("d")) {
            itto = SWBComparator.sortSermanticObjects(new orderByDescription(), ittmp);
        } else {
            //itto=ittmp;
            itto = SWBComparator.sortByDisplayName(ittmp, user.getLanguage());
        }
        WebPage wptocontent = wsite.getWebPage(base.getAttribute("idwpto", wpage.getId()));

        
            if (request.getParameter("alertmsg") != null) {
        String strMsg = request.getParameter("alertmsg");
        strMsg = strMsg.replace("<br>", "\\n\\r");
%>
<script type="text/javascript">
    alert('<%=strMsg%>');
</script>
<%
    }
%>

<script type="text/javascript">
    <!--
    // scan page for widgets and instantiate them
    dojo.require("dojo.parser");
    dojo.require("dijit.TitlePane");
    dojo.require("dijit.TooltipDialog");
    dojo.require("dijit.Dialog");

    // various Form elemetns
    dojo.require("dijit.form.Form");
    dojo.require("dijit.form.Textarea");
    dojo.require("dijit.form.TextBox");
    dojo.require("dijit.form.Button");
    dojo.require("dojox.form.BusyButton");
    dojo.require("dijit.form.ValidationTextBox");

    -->
</script>
<button  dojoType="dijit.form.Button" onclick="dijit.byId('newTema').show()" >Proponer nuevo tema</button>
<span><%//=strTitle%></span>
<div  dojoType="dijit.Dialog"  id="newTema" execute="" title="Propuesta del Nuevo tema">
<%
    SWBResourceURL urlemail = paramRequest.getActionUrl();
    urlemail.setAction(SWBResourceURL.Action_ADD); 
%>
<form action="<%=urlemail%>" method="post">
        <table>
            <tr>
                <td><label for="nomTema">Título: </label></td>
                <td><textarea dojoType="dijit.form.TextBox" type="text" name="nomTema"></textarea></td>
            </tr>
            <tr>
                <td><label for="descripTema">Descripción: </label></td>
                <td><textarea dojoType="dijit.form.Textarea" type="text" name="descripTema" rows="10" cols="30" ></textarea></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <button dojoType="dijit.form.Button" type="submit">Enviar solicitud</button>
                    <button dojoType="dijit.form.Button" onclick="dijit.byId('newTema').hide(); return false;">Cancelar</button>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    * La propuesta del nuevo tema se enviará por correo electrónico al administrador.
                </td>
            </tr>
        </table>
    </form>
</div>

<table class="conorg-table tema-vista">
    <thead>
        <tr>
            <%
                if (orderby != null && orderby.equals("n")) {
            %>
            <th><strong>Nombre</strong></th>

            <%} else {
            %>
            <th><a href="<%=url%>?ob=n">Nombre</a></th>
            <%

                }
                if (orderby != null && orderby.equals("d")) {
            %>
            <th><strong>Descripción</strong></th>

            <%} else {
            %>
            <th><a href="<%=url%>?ob=d">Descripción</a></th>
            <%

                }
            %>
        </tr>
    </thead>
    <tbody>
        <%
            int ps = numpag;
            long l = 0;// = intSize;
            int p = curpag;
            int e = 0;
            /*if (curpag != null) {
             p = Integer.parseInt(curpag);
             } */
            int x = 0;
            while (itto.hasNext()) {
                com.infotec.conorg.Topic topic = itto.next();
                x++;
                if (x > (ps * p) && !(x > (ps * (p + 1)))) {
                    
        %>
        <tr>
            <td><a href="<%=wptocontent.getUrl()%>?toid=<%=topic.getId()%>"><%=topic.getTitle()%></a></td>
            <td><%//=(topic.getDescription()!=null||(topic.getDescription()!=null&&!topic.getDescription().equals("null"))?topic.getDescription():"")%>
                <%=(topic.getDescription()!=null&&!topic.getDescription().equals("")&&!topic.getDescription().equals("null"))?topic.getDescription():""%></td>
        </tr>
        <%
                } else if (x > (ps * (p + 1))) {
                    e++;
                }
            }
            l = x;
            x -= e;
        %>
    </tbody>
</table>
<div class="paginar">
    <p>
        <%
            if ((p > 0 || x < l))// && (paramRequest.getCallMethod() == SWBParamRequest.Call_CONTENT)) //Requiere paginacion
            {

                int pages = (int) (l / ps);
                if ((l % ps) > 0) {
                    pages++;
                }

                //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

                int inicia = 0;
                int finaliza = pages;


                int rangoinicial = p - 5;
                int rangofinal = p + 5;
                if (pages <= 10) {
                    inicia = 0;
                    finaliza = pages;
                } else {
                    if (rangoinicial < 0) {
                        inicia = 0;
                        finaliza = Math.abs(rangoinicial) + rangofinal;
                    } else if (rangofinal > pages) {
                        inicia = pages - 10;
                        finaliza = pages;
                    } else {
                        inicia = rangoinicial;
                        finaliza = rangofinal;
                    }
                }

                if (pages > 10) {
                    SWBResourceURL urlNext = paramRequest.getRenderUrl();
                    urlNext.setParameter("page", "" + 0);
        %>
        <a href="#" onclick="window.location='<%=urlNext%>';">Ir al inicio</a>
        <%
            }

            for (int z = inicia; z < finaliza; z++) {
                SWBResourceURL urlNext = paramRequest.getRenderUrl();
                urlNext.setParameter("page", "" + z);
                if (z != p) {
        %>
        <a href="#" onclick="window.location='<%=urlNext%>';"><%=(z + 1)%></a>
        <%
        } else {
        %>
        <%=(z + 1) + " "%>
        <%
                }
            }
            if (pages > 10) {
                SWBResourceURL urlNext = paramRequest.getRenderUrl();
                urlNext.setParameter("page", "" + (pages - 1));
        %>
        <a href="#" onclick="window.location='<%=urlNext%>';">Ir al final</a>
        <%
                }
            }
        %>
    </p></div>
    <%
    } else {
        WebPage wpwscontent = wsite.getWebPage(base.getAttribute("idwpws", wpage.getId()));
        com.infotec.conorg.Topic topic = com.infotec.conorg.Topic.ClassMgr.getTopic(toid, wsite);
        if (topic != null) {
    %>
<div id="temas-wksp">
    <h3><%=topic.getTitle()%></h3>
    <p><%//=(topic.getDescription()!=null||(topic.getDescription()!=null&&!topic.getDescription().equals("null"))?topic.getDescription():"")%>
    <%=(topic.getDescription()!=null&&!topic.getDescription().equals("")&&!topic.getDescription().equals("null"))?topic.getDescription():""%></p>
    <ul>
        <%
            //Member member=Member.ClassMgr.getMember(user.getId(),wsite);
            //if(member!=null){
            Iterator<WorkSpace> itwsto = WorkSpace.ClassMgr.listWorkSpaceByTopic(topic, wsite);
            //ArrayList alwsp = new ArrayList();
            while (itwsto.hasNext()) {
                WorkSpace workSpace = itwsto.next();
                //                    if(workSpace.hasMember(member)){
%>
        <li >
            <a href="<%=wpwscontent.getUrl()%>?wsid=<%=workSpace.getId()%>"><%=workSpace.getTitle()%></a><br/>
            <%=workSpace.getDescription()%>
        </li>

        <%
            }
        %>
    </ul>
</div>




<%
        }
    }
%>
<%!
    class orderByDescription implements Comparator<com.infotec.conorg.Topic> {

        public int compare(com.infotec.conorg.Topic t1, com.infotec.conorg.Topic t2) {
            String n1, n2;
            n1 = t1.getDescription();
            n2 = t2.getDescription();
            return n1.compareTo(n2);
        }
    }

%>
