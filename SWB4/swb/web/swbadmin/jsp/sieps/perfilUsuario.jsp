
<%@page import="java.util.List"%>
<%@page import="org.semanticwb.sieps.Busqueda"%>
<%@page import="org.semanticwb.sieps.Empresa"%>
<%@page import="org.semanticwb.scian.Clase"%>
<%@page import="com.hp.hpl.jena.rdf.model.*"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.semanticwb.SWBPlatform"%>
<%@page import="org.semanticwb.SWBPortal"%>


<%@page import="org.semanticwb.sieps.Producto"%><jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest"/>
<%
List<Busqueda> listBusquedas      	= 	(List<Busqueda>)request.getAttribute("busquedas");
List<Empresa> listEmpresasCert    	= 	(List<Empresa>)request.getAttribute("empresasCertificadas");
List<Empresa> listEmpresasInteres 	= 	(List<Empresa>)request.getAttribute("empresasInteres");
List<Producto> listProductos 		= 	(List<Producto>)request.getAttribute("productos");

SWBResourceURL 	urlEliminaBusqueda 		= 	paramRequest.getActionUrl().setAction("eliminaConsulta"),
				urlEliminaEmpresasInt 	= 	paramRequest.getActionUrl().setAction("eliminaEmpresasInteres"),
				urlEliminaEmpresasCert 	= 	paramRequest.getActionUrl().setAction("eliminaEmpresasCert"),
				urlEliminaProducto 		= 	paramRequest.getActionUrl().setAction("eliminaProductos");

String mensaje	   	= 	"";//request.getParameter("mensaje")!= null ? request.getParameter("mensaje") : "";
String mensajeUsr  	= 	(String)request.getAttribute("mensajeUsr");
boolean isMensaje  	= 	(mensajeUsr != null && mensajeUsr.length() > 0);
String urlImages	=	"/swbadmin/jsp/"+paramRequest.getWebPage().getWebSiteId()+"/images/";
String idWebSite	=	paramRequest.getWebPage().getWebSiteId();
String userLang		=	paramRequest.getUser().getLanguage();

%>
<script type="text/javascript" src="/swbadmin/jsp/sieps/sieps.js"></script>
<%if (!isMensaje) {%>
	<form id="frmPerfil" name="frmPerfil" action="" method="post">		        
        <h2 class="mi-carpeta"><img src="<%=urlImages%>carpeta_icon.png" width="50" height="35" alt="" />Mi carpeta</h2>
        <!-- B�squedas -->       
        <h3 class="mi-carpeta">Mis b&uacute;squedas</h3>
        <% if (!listBusquedas.isEmpty()) {%>
	        <table class="tabla-resultados">
	          <tr>
	            <th colspan="2">B�squeda</th>
	          </tr>
        	<% for (int i = 0; i < listBusquedas.size(); i++) {
        		String estiloRow 		= 	(i % 2 == 0) ? "odd" : "even";
        		Busqueda busqueda		=	listBusquedas.get(i);        		
        	%>
		          <tr>
		            <td class="<%=estiloRow%> bold"><a href="/<%=userLang%>/<%=idWebSite%>/Resultados_Empresas?act=results&query=<%=busqueda.getSeach()%>"><%=busqueda.getSeach()%></a></td>
		            <td class="<%=estiloRow%>" style="text-align: center;"><input type="checkbox" name="checkBusqueda" id="checkBusqueda" value="<%=busqueda.getURI()%>"/></td>
		          </tr>
		    <% } %>
		    </table>
        	<p class="mi-carpeta"><input type="button" value="Eliminar" name="eliminar_1" class="btn-small" onclick="eliminaBusquedasCarpeta('<%=urlEliminaBusqueda%>', this, 'checkBusqueda')"/></p>
	    <% } else {%>
	    	<p class="fecha">No hay consultas en su carpeta</p>
	    <% } %>
		
		<!-- Empresas de certificadas -->        
        <h3 class="mi-carpeta">Mis empresas certificadas</h3>
        <% if (!listEmpresasCert.isEmpty()) {%>
        <table class="tabla-resultados">
          <tr>
            <th>C�digo</th>
            <th>Categor�a</th>
            <th>Subcategor�a</th>
            <th>Empresa</th>
            <th colspan="2">Ubicaci�n</th>
          </tr>
          <% for (int i = 0; i < listEmpresasCert.size(); i++) {
        		String estiloRow 		= 	(i % 2 == 0) ? "odd" : "even";
        		Empresa empresa			=	listEmpresasCert.get(i);
        		SWBResourceURL urlEmp 	= 	paramRequest.getRenderUrl().setParameter("act", "detail").setParameter("uri", empresa.getEncodedURI());
        		String subcategoria		=	"Sin subcategoria";
          	  	String categoria		=	"Sin categoria";
          	  	Clase clase				=	empresa.getScian();
          	  	
          	  	if(clase!=null) {
	                    subcategoria	=	clase.getSemanticObject().getLabel(paramRequest.getUser().getLanguage());
	                    Resource res	=	clase.getSemanticObject().getRDFResource();	                   
	                    org.semanticwb.platform.SemanticProperty prop				=	paramRequest.getWebPage().getSemanticObject().getModel().getSemanticProperty(org.semanticwb.platform.SemanticVocabulary.RDFS_SUBCLASSOF);
	                    Iterator<org.semanticwb.platform.SemanticObject> parents	=	clase.getSemanticObject().listObjectProperties(prop);
	                    org.semanticwb.platform.SemanticObject parent=null;
	                    while(parents.hasNext()) {
	                        org.semanticwb.platform.SemanticObject temp	=	parents.next();
	                        if(org.semanticwb.scian.SubRama.sclass.equals(temp.getSemanticClass())) {                            
	                            parent=temp;
	                            break;
	                        }
	                    }
	
	                    if(parent != null) {
	                        categoria=parent.getLabel(paramRequest.getUser().getLanguage());
	                    }
	                    if(subcategoria==null) {
	                            subcategoria="Sin subcategoria";
	                    }
	            }
          %>
	          <tr>          
	            <td class="<%=estiloRow%> bold"><%=clase.getCode()%></td>
	            <td class="<%=estiloRow%> bold"><%=categoria%></td>
	            <td class="<%=estiloRow%> bold"><%=subcategoria %></td>
	            <td class="<%=estiloRow%> bold"><a href="/<%=userLang%>/<%=idWebSite%>/Resultados_Empresas?act=detail&uri=<%=empresa.getEncodedURI()%>"><%=empresa.getName()%></a></td>
	            <td class="<%=estiloRow%> bold"><%=empresa.getEstado()%><span class="<%=estiloRow%>">
	            </span></td>
	            <td class="<%=estiloRow%>"><input type="checkbox" name="checkEmpCert" id="checkEmpCert" value="<%=empresa.getURI()%>"/></td>
	          </tr>
	      <% } %>
        </table>
       	<% } else {%>
	    	<p class="fecha">No hay empresas certificadas en su carpeta</p>
	    <% } %>
        <p class="mi-carpeta">
        <% if (!listEmpresasCert.isEmpty()) { %>
        	<input type="button" value="Eliminar" name="eliminar_3" class="btn-small" onclick="eliminaEmpresasCarpeta('<%=urlEliminaEmpresasCert%>', this, 'checkEmpCert')"/>
       	<% } %>
        <input type="button" value="Agregar otra empresa" name="eliminar_2" class="btn-big" onclick="document.location='/swb/<%=idWebSite%>/Certificados'"/>
        </p>
        <h3 class="mi-carpeta">Mis empresas de inter�s</h3>
        <% if (!listEmpresasInteres.isEmpty()) {%>
        <table class="tabla-resultados">
          <tr>
            <th>C�digo</th>
            <th>Categor�a</th>
            <th>Subcategor�a</th>
            <th>Empresa</th>
            <th colspan="2">Ubicaci�n</th>
          </tr>
          <% for (int i = 0; i < listEmpresasInteres.size(); i++) {
        		String estiloRow 		= 	(i % 2 == 0) ? "odd" : "even";
        		Empresa empresa			=	listEmpresasInteres.get(i);
        		SWBResourceURL urlEmp 	= 	paramRequest.getRenderUrl().setParameter("act", "detail").setParameter("uri", empresa.getEncodedURI());
        		String subcategoria		=	"Sin subcategoria";
          	  	String categoria		=	"Sin categoria";
          	  	Clase clase				=	empresa.getScian();
          	  	
          	  	if(clase!=null) {
	                    subcategoria	=	clase.getSemanticObject().getLabel(paramRequest.getUser().getLanguage());
	                    Resource res	=	clase.getSemanticObject().getRDFResource();	                   
	                    org.semanticwb.platform.SemanticProperty prop				=	paramRequest.getWebPage().getSemanticObject().getModel().getSemanticProperty(org.semanticwb.platform.SemanticVocabulary.RDFS_SUBCLASSOF);
	                    Iterator<org.semanticwb.platform.SemanticObject> parents	=	clase.getSemanticObject().listObjectProperties(prop);
	                    org.semanticwb.platform.SemanticObject parent=null;
	                    while(parents.hasNext()) {
	                        org.semanticwb.platform.SemanticObject temp	=	parents.next();
	                        if(org.semanticwb.scian.SubRama.sclass.equals(temp.getSemanticClass())) {                            
	                            parent=temp;
	                            break;
	                        }
	                    }
	
	                    if(parent != null) {
	                        categoria=parent.getLabel(paramRequest.getUser().getLanguage());
	                    }
	                    if(subcategoria==null) {
	                            subcategoria="Sin subcategoria";
	                    }
	            }
          %>
	          <tr>          
	            <td class="<%=estiloRow%> bold"><%=clase != null ? clase.getCode() : "No disponible"%></td>
	            <td class="<%=estiloRow%> bold"><%=categoria%></td>
	            <td class="<%=estiloRow%> bold"><%=subcategoria %></td>
	            <td class="<%=estiloRow%> bold"><a href="/<%=userLang%>/<%=idWebSite%>/Resultados_Empresas?act=detail&uri=<%=empresa.getEncodedURI()%>"><%=empresa.getName()%></a></td>
	            <td class="<%=estiloRow%> bold"><%=empresa.getEstado()%><span class="<%=estiloRow%>">
	            </span></td>
	            <td class="<%=estiloRow%>"><input type="checkbox" name="checkEmpInt" id="checkEmpInt" value="<%=empresa.getURI()%>"/></td>
	          </tr>
	      <% } %>
        </table>
         <p class="mi-carpeta">
	        <input type="button" value="Eliminar" name="eliminar_3" class="btn-small" onclick="eliminaEmpresasCarpeta('<%=urlEliminaEmpresasInt%>', this, 'checkEmpInt')"/>
       	 </p>        
       	<% } else {%>
	    	<p class="fecha" >No hay empresas de inter�s en su carpeta</p>
	    <% } %> 
	    <!-- Productos de Inter�s -->
	    <h3 class="mi-carpeta">Mis productos de inter�s</h3>
        <% if (!listProductos.isEmpty()) {%>
        <table class="tabla-resultados">
          <tr>
            <th>C�digo</th>
            <th>Producto</th>
            <th>Subcategor�a</th>
            <th>Empresa</th>
            <th colspan="2">Ubicaci�n</th>
          </tr>
          <% for (int i = 0; i < listProductos.size(); i++) {
        		String estiloRow 		= 	(i % 2 == 0) ? "odd" : "even";
        		Producto producto		=	listProductos.get(i);
        		SWBResourceURL urlEmp 	= 	paramRequest.getRenderUrl().setParameter("act", "detail").setParameter("uri", producto.getEncodedURI());
        		String subcategoria		=	"Sin subcategoria";          	  	
          	  	String codigo			=	"";
              
              if(producto.getUnspsc()!=null && producto.getUnspsc().getUnspsc()!=null) {
                    codigo	=	producto.getUnspsc().getUnspsc();
              }
              if(producto.getUnspsc()!=null) {
                    subcategoria	=	producto.getUnspsc().getSemanticObject().getLabel(paramRequest.getUser().getLanguage());
              }
          %>
	          <tr>          
	            <td class="<%=estiloRow%> bold"><%=codigo != null ? codigo : "No disponible"%></td>
	            <td class="<%=estiloRow%> bold"><a href="/<%=userLang%>/<%=idWebSite%>/Resultados_Empresas?act=detail&uri=<%=producto.getEncodedURI()%>"><%=producto.getDisplayTitle(userLang)%></a></td>
	            <td class="<%=estiloRow%> bold"><%=subcategoria %></td>
	            <td class="<%=estiloRow%> bold"><a href="/<%=userLang%>/<%=idWebSite%>/Resultados_Empresas?act=detail&uri=<%=producto.getFabrica().getEncodedURI()%>"><%=producto.getDisplayTitle(userLang)%></a></td>	            
	            <td class="<%=estiloRow%> bold"><%=producto.getFabrica().getEstado()%><span class="<%=estiloRow%>">
	            </span></td>
	            <td class="<%=estiloRow%>"><input type="checkbox" name="checkProductos" id="checkProductos" value="<%=producto.getURI()%>"/></td>
	          </tr>
	      <% } %>
        </table>
         <p class="mi-carpeta">
	        <input type="button" value="Eliminar" name="eliminar_3" class="btn-small" onclick="eliminaProductosCarpeta('<%=urlEliminaProducto%>', this, 'checkProductos')"/>
       	 </p>        
       	<% } else {%>
	    	<p class="fecha" >No hay productos de inter�s en su carpeta</p>
	    <% } %>        	    
</form>
<script type="text/javascript">muestraMensaje('<%=mensaje%>');</script>	    
<%} else {%>
	<h2 class="tableH2"><%=mensajeUsr%></h2>
<%}%>