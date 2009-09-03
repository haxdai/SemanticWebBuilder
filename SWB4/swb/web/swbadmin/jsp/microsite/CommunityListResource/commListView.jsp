<%@page contentType="text/html"%>
<%@page import="org.semanticwb.portal.api.*,org.semanticwb.portal.community.*,org.semanticwb.*,org.semanticwb.model.*,java.util.*"%>


<%!

    private int getExistingCommunities(WebPage wp, User user)
    {
        int numc=0;
        Iterator<WebPage> itwp = wp.listChilds(user.getLanguage(), Boolean.TRUE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE);
        while(itwp.hasNext())
        {
            WebPage wpit = itwp.next();
            if(wpit.getSemanticObject().getGenericInstance() instanceof MicroSite)
            {
               numc++;
            }
        }
        return numc;
    }
%>
<%
    SWBParamRequest paramRequest=(SWBParamRequest)request.getAttribute("paramRequest");
    User user=paramRequest.getUser();
    WebPage wpp=paramRequest.getWebPage();

    WebPage wpch = null;
    WebPage wpgs = null;

    int nwp = 0;
    int nms = 0;

    Iterator<WebPage> itso = wpp.listChilds(user.getLanguage(),true,false,false,false);
    if(itso.hasNext())
    {
        while(itso.hasNext())
        {
            WebPage so = itso.next();
            if(so.getSemanticObject().getGenericInstance() instanceof WebPage && !(so.getSemanticObject().getGenericInstance() instanceof MicroSite) )
            {
                nwp++;
                //break;
            }
            else
            {
                nms++;
            }
        }
    }





    int numcomm = 0;
    int nums = 0;
    String nummsg = "";
    int wplevel=wpp.getLevel();

    Iterator<WebPage> itwp = wpp.listChilds(user.getLanguage(), Boolean.TRUE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE);

    if(wplevel==3||nwp==0)
    {
%>
        <h2 class="tituloInteres">Comunidades de <%=wpp.getDisplayTitle(user.getLanguage())%></h2>
        <div id="gruposInteres">
<%
        if(nms>0)
        {
%>
            <ul>
<%            
            while(itwp.hasNext())
            {
                wpch = itwp.next();
                if(wpch.isActive()&&!wpch.isDeleted())
                {
%>
                <li><a href="<%=wpch.getUrl()%>"><%=wpch.getDisplayTitle(user.getLanguage())%>&nbsp;</a></li>
<%
                }
            }
%>
            </ul>
<%
        }
        else
        {
            if(user.isRegistered())
                out.println("No existen comunidades, aqu� puedes crear t� comunidad.");
            else
                out.println("No existen comunidades, aqu� puedes crear t� comunidad si eres usuario registrado.");
        }
%>
        <div id="clear">&nbsp;</div>
      </div>
      <div id="bottomInteres">&nbsp;</div>
<%
    }
    else if(wplevel==2)
    {
        wpch=paramRequest.getWebPage();
        %>
        <div class="groupInteres">
        <h3 class="titulo"><a href="<%=wpch.getUrl()%>"><%=wpch.getDisplayTitle(user.getLanguage())%></a></h3>
        <%

        Iterator<WebPage> itwpch = wpch.listChilds(user.getLanguage(), Boolean.TRUE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE);
                if(itwpch.hasNext())
                {
%>
            <ul>
<%
                    while(itwpch.hasNext())
                    {
                        wpgs = itwpch.next();

                        if(!(wpgs instanceof MicroSite) && wpgs.isActive()&&!wpgs.isDeleted()&&!(wpgs.getSemanticObject().getGenericInstance() instanceof MicroSiteWebPageUtil))
                        {
                            numcomm= getExistingCommunities(wpgs,user);
                            nummsg = "";
                            if(numcomm>0)  nummsg = "("+numcomm+")";
                            %>
                                            <li><a href="<%=wpgs.getUrl()%>"><%=wpgs.getDisplayTitle(user.getLanguage())%>&nbsp;<%=nummsg%></a></li>
                            <%
                        }
                        numcomm=0;

                    }
%>
            </ul>
<%
                   }
%>
        </div>
        <%
    }
    else if(wplevel==1)
    {
        while(itwp.hasNext())
        {

            wpch = itwp.next();
            
            if(wpch.isActive()&&!wpch.isDeleted()) 
            {
                nums++;
%>
            <div class="groupInteres">
            <h3 class="titulo"><a href="<%=wpch.getUrl()%>"><%=wpch.getDisplayTitle(user.getLanguage())%></a></h3>
<%                
                Iterator<WebPage> itwpch = wpch.listChilds(user.getLanguage(), Boolean.TRUE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE);
                if(itwpch.hasNext())
                {
%>
            <ul>
<%
                    while(itwpch.hasNext())
                    {
                        wpgs = itwpch.next();
                        
                        if(!(wpgs instanceof MicroSite) && wpgs.isActive()&&!wpgs.isDeleted()&&!(wpgs.getSemanticObject().getGenericInstance() instanceof MicroSiteWebPageUtil))
                        {
                            numcomm= getExistingCommunities(wpgs,user);
                            nummsg = "";
                            if(numcomm>0)  nummsg = "("+numcomm+")";
                            %>
                                            <li><a href="<%=wpgs.getUrl()%>"><%=wpgs.getDisplayTitle(user.getLanguage())%>&nbsp;<%=nummsg%></a></li>
                            <%
                        }
                        numcomm=0;
                        
                    }
%>
            </ul>
<%
                   }
%>
            </div>
<%
            }
        }
     }
%>

