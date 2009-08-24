<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.semanticwb.platform.SemanticObject,org.semanticwb.portal.api.*,org.semanticwb.portal.community.*,org.semanticwb.*,org.semanticwb.model.*,java.util.*"%>

<script type="text/javascript">
    dojo.require("dojox.layout.FloatingPane");
    dojo.require("dijit.form.Button");
    dojo.require("dijit.form.TextBox");

    dojo.require("dijit.Editor");
    dojo.require("dijit._editor.plugins.LinkDialog");
    dojo.require("dijit._editor.plugins.FontChoice");
    dojo.require("dijit._editor.plugins.TextColor");
    dojo.require("dojo.parser");    
    dojo.require("dojox.xml.parser");
</script>

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
            if(!post.canModify(member))
            {
                return;
            }
        %>
        <form name="frmaddpost" id="frmaddpost" method="post" action="<%=paramRequest.getActionUrl()%>">
            <input type="hidden" name="act" value="<%=request.getParameter("act")%>">
            <input type="hidden" name="mode" value="<%=request.getParameter("mode")%>">
            <input type="hidden" name="uri" value="<%=request.getParameter("uri")%>">            
            <div>
                <fieldset><legend>Editar entrada</legend>
                    <div>
                        <p>
                            <label for="title">Título:&nbsp;&nbsp;&nbsp;&nbsp;</label><input size="50" id="title" name="title" value="<%=post.getTitle()%>" maxlength="50"><br>
                            <label for="description">Descripción:&nbsp;&nbsp;&nbsp;&nbsp;</label><input size="50" id="description" name="description" maxlength="255" value="<%=post.getDescription()%>"><br>
                            <label for="content">Contenido de entrada:&nbsp;&nbsp;&nbsp;</label>
                            <textarea plugins="['bold','italic','underline', 'strikethrough','|','insertUnorderedList','insertOrderedList','|','createLink','unlink']" dojoType="dijit.Editor" id="content" rows="5" cols="23" name="content"><%=post.getContent()%></textarea>
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
                        <br>
                <div class="editarInfo"><p><a onclick="validaForma()" href="#">Guardar</a></p></div>
                <div class="editarInfo"><p><a href="<%=paramRequest.getRenderUrl()%>">Cancelar</a></p></div>                    
                    <script>
                        function validaForma()
                        {                            
                            var title = frmaddpost.title.value;
                            if(!title)
                            {
                                alert('Debe ingresar el título de la entrada');
                                return;
                            }
                            var description = frmaddpost.description.value;
                            if(!description)
                            {
                                alert('Debe ingresar la descripción de la entrada');
                                return;
                            }
                            content = dijit.byId('content').getValue(false);
                            if(!content)
                            {
                                alert('Debe ingresar la entrada del post');
                                return;
                            }
                            var msg='¿Estan los datos correctos de la entrada del blog?';
                            if(confirm(msg))
                            {
                                dojo.byId('content').value=content;                                
                                dojo.byId('frmaddpost').submit();
                            }
                        }
                    </script>
            </div>
            <input type="hidden" name="act" value="add"/>
        </form>
        <%
        }
        }
    else if("editblog".equals(request.getParameter("mode")))
    {
        if(member.getAccessLevel()!=Member.LEVEL_OWNER)
        {
            return;
        }
        %>
                 <div>
                <h3>Editar título y descripción del blog</h3>
            </div>
            <div>
                <fieldset><legend></legend>
                    <div>
                        <p>
                            <label for="title">Título</label>                            
                            <input id="title" name="title" value="<%=blog.getTitle()%>" size="20" maxlength="50"><br>
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

