<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.net.*,org.semanticwb.platform.SemanticObject,org.semanticwb.portal.api.*,org.semanticwb.portal.community.*,org.semanticwb.*,org.semanticwb.model.*,java.util.*"%>

<%
    //SWBParamRequest paramRequest=(SWBParamRequest)request.getAttribute("paramRequest");
    ArrayList<NewsElement> elements=(ArrayList<NewsElement>)request.getAttribute("elements");
    %>
    <div class="recentEntry_last">
        <h2 class="titulo">Noticias recientes</h2>

    <%
    if(elements.size()>0)
    {
%>
    
        <%
            for(NewsElement element : elements)
            {
                String href=element.getURL();                
                String src=element.getNewsPicture();
                if(element.getNewsPicture()!=null)
                {
                    src=element.getWorkPath()+element.getNewsPicture();
                }
                String title=element.getTitle();
                if(title==null)
                {
                    title="";
                }
                String description=element.getDescription();
                if(description==null)
                {
                    description="";
                }
                if(description.length()>200)
                {
                    description=description.substring(0, 197)+" ...";
                }
                %>
                  <div class="entry">
                      <%
                        if(src!=null)
                        {
                            %>
                            <p><img src="<%=src%>" alt="<%=title%>" width="49" height="49" ></p>
                            <%
                        }                
                      %>
                  
                  <h3 class="titulo"><%=title%></h3>
                  <p><%=description%></p>
                  <%
                    if(href!=null)
                    {
                        %>
                        <p class="vermas"><a href="<%=href%>" >Ver m&aacute;s</a></p>
                        <%
                    }
                  %>
                  
                </div>
                <%
            }
    }
    else
        {
        %>
        <p>No hay noticias publicadas</p>
        <%
        }
%></div>