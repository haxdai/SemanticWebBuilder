<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.semanticwb.platform.SemanticObject,org.semanticwb.portal.api.*,org.semanticwb.portal.community.*,org.semanticwb.*,org.semanticwb.model.*,java.util.*"%>
<%
    SWBParamRequest paramRequest=(SWBParamRequest)request.getAttribute("paramRequest");
    User user=paramRequest.getUser();
    WebPage wpage=paramRequest.getWebPage();
    Member member=Member.getMember(user,wpage);
    Blog blog=(Blog)request.getAttribute("blog");
%>
<%
    if("editpost".equals(request.getParameter("mode")))
        {
        String uri=request.getParameter("uri");
        if(uri!=null)
            {
            PostElement post = (PostElement) SemanticObject.createSemanticObject(uri).createGenericInstance();
        %>
        <form method="post" action="<%=paramRequest.getActionUrl()%>">
            <input type="hidden" name="act" value="<%=request.getParameter("act")%>">
            <input type="hidden" name="mode" value="<%=request.getParameter("mode")%>">
            <input type="hidden" name="uri" value="<%=request.getParameter("uri")%>">
            <div>
                <h3>Editar una nueva entrada al Blog</h3>
            </div>
            <div>
                <fieldset><legend>Editar entrada</legend>
                    <div>
                        <p>
                            <label for="title">Título</label><input id="title" name="title" value="<%=post.getTitle()%>"><br>
                            <label for="description">Contenido de entrada</label>                            
                            <textarea id="description" rows="5" cols="23" name="description"><%=post.getDescription()%></textarea>
                        </p>
                    </div>
                </fieldset>
                    <fieldset>
                        <legend><strong>¿Quién puede ver este video?</strong></legend>
                        <ul class="options">
                            <%String chk="checked=\"checked\"";%>
                            <li><label><input type="radio" class="radio" name="level" value="0" <%if(post.getVisibility()==0)out.println(chk);%>/> Cualquiera</label></li>
                            <li><label><input type="radio" class="radio" name="level" value="1" <%if(post.getVisibility()==1)out.println(chk);%>/> Sólo los miembros</label></li>
                            <li><label><input type="radio" class="radio" name="level" value="3" <%if(post.getVisibility()==3)out.println(chk);%>/> Sólo yo</label></li>
                        </ul>
                    </fieldset>
                <p class="pad5 last-child clear right">
                    <strong><input type="submit" value="Guardar cambios" class="button"/></strong>
                    <a class="button" href="<%=paramRequest.getRenderUrl()%>">Cancelar</a>
                </p>
            </div>
            <input type="hidden" name="act" value="add"/>
        </form>
        <%
        }
        }
    else if("editblog".equals(request.getParameter("mode")))
        {
        %>
                 <div>
                <h3>Editar título y descripción del blog</h3>
            </div>
            <div>
                <fieldset><legend></legend>
                    <div>
                        <p>
                            <label for="title">Título</label>                            
                            <input id="title" name="title" value="<%=blog.getTitle()%>"><br>
                            <label for="description">Contenido de entrada</label>
                            <textarea id="description" rows="5" cols="23" name="description"><%=blog.getDescription()%></textarea>
                        </p>
                    </div>
                </fieldset>
                <p class="pad5 last-child clear right">
                    <strong><input type="submit" value="Guardar cambios" class="button"/></strong>
                    <a class="button" href="<%=paramRequest.getRenderUrl()%>">Cancelar</a>
                </p>
            </div>
            <input type="hidden" name="act" value="add"/>
        </form>
        <%
        }
%>

