<form action="<%=urlAction.setAction("uploadVideo")%>" method="post">
    <ul>
        <li>T�tulo:<input type="text" name="title"></li>
        <li>Descripci�n:<input type="text" name="description"></li>
        <li>Palabras clave:<input type="text" name="keywords"></li>
    </ul>
<input type="hidden" name="socialUri" value="<%=socialUri%>"/>
<input type="hidden" name="toPost" value="<%=request.getParameter("toPost")%>">
<li><input type="submit" value="enviar"></li>
</form>
