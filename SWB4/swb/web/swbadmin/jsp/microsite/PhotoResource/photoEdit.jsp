<%@page contentType="text/html"%>
<%@page import="org.semanticwb.platform.*,org.semanticwb.portal.api.*,org.semanticwb.portal.community.*,org.semanticwb.*,org.semanticwb.model.*,java.util.*"%>
<%
    SWBParamRequest paramRequest=(SWBParamRequest)request.getAttribute("paramRequest");
    User user=paramRequest.getUser();
    WebPage wpage=paramRequest.getWebPage();
    Member member=Member.getMember(user,wpage);
%>
<%
        String uri=request.getParameter("uri");        
        PhotoElement rec= (PhotoElement)SemanticObject.createSemanticObject(uri).createGenericInstance();
        if(rec==null)
        {
%>
            Error: Elemento no encontrado...
<%
            return;
        }
        if(!rec.canModify(member))
    {
        return;
    }
%>
<script type="text/javascript">
function validaForma()
{    
    var title = document.frmaddfoto.title.value;
    if(!title)
    {
        alert('�Debe ingresar el t�tulo de la foto!');
        document.frmaddfoto.description.focus();
        return;
    }
    var description = document.frmaddfoto.description.value;
    if(!description)
    {
        alert('�Debe ingresar la description de la foto!');
        document.frmaddfoto.description.focus();
        return;
    }
    document.frmaddfoto.submit();
}
</script>

<br />
<div id="panorama">
<form name="frmaddfoto" id="frmaddfoto" enctype="multipart/form-data" method="post" action="<%=paramRequest.getActionUrl()%>">
    <div>
        <fieldset>
            <legend>Editar foto</legend>
            <div>
                <p>
                    <label for="foto">Archivo:&nbsp;</label><br />
                    <input id="foto" type="file" size="22" name="foto" size="60" />
                </p>
                <p>
                    <label for="title">T�tulo:&nbsp;</label><br />
                    <input id="title" type="text" size="25" name="title" maxlength="50" value="<%= rec.getTitle()%>" size="60" />
                </p>
                <p>
                    <label for="description">Descripci�n</label><br />
                    <textarea id="description" cols="60" rows="5" name="description"><%= rec.getDescription()%></textarea>
                 </p>
                 <p>
                    <label for="tags">Etiquetas:&nbsp;</label><br />
                    <input id="tags" type="text" size="22" name="tags" maxlength="50" value="<%= rec.getTags()%>" size="60" />
                </p>
            </div>
        </fieldset>
        <fieldset>
            <legend>�Qui�n puede ver este evento?</legend>
            <%String chk = "checked=\"checked\"";%>
            <div>
                <p>
                    <label for="level"><input type="radio" name="level" value="0" <%if(rec.getVisibility()==0)out.println(chk);%> />&nbsp;Cualquiera</label>
                </p>
                <p>
                    <label for="level"><input type="radio" name="level" value="1" <%if(rec.getVisibility()==1)out.println(chk);%> />&nbsp;S�lo los miembros</label>
                </p>
                <p>
                    <label for="level"><input type="radio" name="level" value="3" <%if(rec.getVisibility()==3)out.println(chk);%> />&nbsp;S�lo yo</label>
                </p>
            </div>
        </fieldset>
        <fieldset>
            <legend></legend>
            <div>
            <p>
                <div class="editarInfo"><p><a onclick="validaForma()" href="#">Guardar</a></p></div>
                <div class="editarInfo"><p><a href="<%=paramRequest.getRenderUrl()%>">Cancelar</a></p></div>
            </p>
            </div>
        </fieldset>
    </div>
    <input type="hidden" name="uri" value="<%=rec.getURI()%>"/>
    <input type="hidden" name="act" value="edit"/>
</form>
</div>