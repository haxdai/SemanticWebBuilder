
<%@page import="org.semanticwb.portal.SWBFormButton"%>
<%@page import="org.semanticwb.platform.SemanticObject"%>
<%@page import="org.semanticwb.portal.SWBFormMgr"%>
<%@page import="com.infotec.cvi.swb.DocumentoProbatorio"%>
<%--   
    Document   : view Recurso DocumentosProbatoriosResource
    Created on : 24/02/2012
    Author     : juan.fernandez
--%>

<%@page import="java.util.Collections"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.semanticwb.model.WebPage"%>
<%@page import="com.infotec.cvi.swb.CV"%>
<%@page import="com.infotec.cvi.swb.DocumentoProbatorio"%>
<%@page import="java.util.Set"%>
<%@page import="org.semanticwb.model.SWBComparator"%>
<%@page import="java.util.Locale"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="org.semanticwb.model.WebSite"%>

<%@page import="org.semanticwb.model.User"%>
<%@page import="org.semanticwb.model.Role"%>
<%@page import="org.semanticwb.model.Resource"%> 
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="org.semanticwb.SWBUtils"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest" />

<%

    String MODE_GETFILE ="getFile";  
    WebPage wpage = paramRequest.getWebPage();
    WebSite wsite = wpage.getWebSite();
    User usr = paramRequest.getUser();
    Role role = null;

    CV cv = CV.ClassMgr.getCV(usr.getId(), wsite);
    if (cv == null) {
        cv = CV.ClassMgr.createCV(usr.getId(), wsite);
        cv.setPropietario(usr);
    }

    DocumentoProbatorio doc = cv.getDocumentoProbatorio();
    if (doc == null) {
        doc = DocumentoProbatorio.ClassMgr.createDocumentoProbatorio(wsite);
        cv.setDocumentoProbatorio(doc);
    }

    SemanticObject obj = doc.getSemanticObject();

    Resource base = paramRequest.getResourceBase();
    String action = request.getParameter("act");

    if (action == null) {
        action = "";
    }

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
<div >
    <div id="icv">
        <%@include file="../menucvi.jsp" %>
        <div id="icv-data">
            <h3>Documentos Probatorios</h3>
            <div>
            <%

                String wptitle = wpage.getDisplayName(usr.getLanguage());
                SWBFormMgr fmgr = null;
                fmgr = new SWBFormMgr(obj, null, SWBFormMgr.MODE_EDIT);

                fmgr.clearProperties();
                
                fmgr.addProperty(DocumentoProbatorio.intranet_fileActaNacimiento);
                fmgr.addProperty(DocumentoProbatorio.intranet_fileActaMatrimonio);
                fmgr.addProperty(DocumentoProbatorio.intranet_hasActasNacimientoFamiliares);
                fmgr.addProperty(DocumentoProbatorio.intranet_fileFotoTamInfantil);
                fmgr.addProperty(DocumentoProbatorio.intranet_fileCopiaRFC);
                fmgr.addProperty(DocumentoProbatorio.intranet_fileCURP);
                fmgr.addProperty(DocumentoProbatorio.intranet_hasFilesComprobanteEstudio);
                fmgr.addProperty(DocumentoProbatorio.intranet_hasFilesIdentificacionOficial);
                fmgr.addProperty(DocumentoProbatorio.intranet_fileComprobanteDomicilio);
                fmgr.addProperty(DocumentoProbatorio.intranet_fileNumeroSeguridadSocial);
                
                
                fmgr.setFilterHTMLTags(false);
                fmgr.setType(SWBFormMgr.TYPE_DOJO);              

                SWBResourceURL urlupdtf = paramRequest.getActionUrl();
                urlupdtf.setAction(SWBResourceURL.Action_ADD);

                fmgr.setAction(urlupdtf.toString());
                //fmgr.addButton(SWBFormButton.newSaveButton());
                //out.println(fmgr.renderForm(request));
            %>

      <script type="text/javascript">
      // scan page for widgets and instantiate them
      dojo.require("dojo.parser");
      dojo.require("dijit._Calendar");
      dojo.require("dijit.ProgressBar");
 
      // editor:
      dojo.require("dijit.Editor");
 
      // various Form elemetns
      dojo.require("dijit.form.Form");
      dojo.require("dijit.form.CheckBox");
      dojo.require("dijit.form.Textarea");
      dojo.require("dijit.form.FilteringSelect");
      dojo.require("dijit.form.TextBox");
      dojo.require("dijit.form.DateTextBox");
      dojo.require("dijit.form.TimeTextBox");
      dojo.require("dijit.form.Button");
      dojo.require("dijit.form.NumberSpinner");
      dojo.require("dijit.form.Slider");
      dojo.require("dojox.form.BusyButton");
      dojo.require("dojox.form.TimeSpinner");
      
      function getDownloadFile(val)
       {  
           var sel = document.getElementById(val);
    //       alert(sel.value)
           if(sel.value=='')
               { 
                   alert('Selecciona un archivo de la lista.')
               } 
           else 
               { 
                   window.location=sel.value;
               }
           return false;

      }
      
      function enviar() {
        var objd=dijit.byId('<%=doc.getURI()%>/form');
//alert(objd);
        if(objd.validate())//isValid()&&!isEmpty('idgavance')&&!isEmpty('idestudio'))
        {
                return true;
        }else {
            alert("Datos incompletos o erroneos");
        }
        return false;
    }
    function isEmpty(objid) {
        var obj = dojo.byId(objid);
        if (obj==null || obj.value=='' || !isNaN(obj.value) || obj.value.charAt(0) == ' ') {
            return true;
        }else {
            return false;
        }
    }
    </script>
<script type="text/javascript">
                             
                            </script>
            <form  id="<%=doc.getURI()%>/form" dojoType="dijit.form.Form" class="swbform" action="<%=urlupdtf%>" method="post">
                <input type="hidden" name="act" value="edit" />
                <input type="hidden" name="suri" value="<%=doc.getURI()%>" />
                <input type="hidden" name="scls" value="<%=DocumentoProbatorio.intranet_DocumentoProbatorio.getURI()%>" />
                <input type="hidden" name="smode" value="edit"/>
	<fieldset >
	    <table>
                <tr><td width="300px" align="right"><%=fmgr.renderLabel(request, DocumentoProbatorio.intranet_fileActaNacimiento, SWBFormMgr.MODE_EDIT)%></td>
                    <td><%=fmgr.renderElement(request, DocumentoProbatorio.intranet_fileActaNacimiento, SWBFormMgr.MODE_EDIT)%></td>
                    <td>
                       <%
                       String iniName = DocumentoProbatorio.intranet_fileActaNacimiento.getName() + "_" + doc.getSemanticObject().getId();
                       String strfile = doc.getFileActaNacimiento();
                       if(null!=strfile){
                            SWBResourceURL urlgetfile1 = paramRequest.getRenderUrl();
                            urlgetfile1.setMode(MODE_GETFILE);
                            urlgetfile1.setAction("inline");
                            urlgetfile1.setCallMethod(SWBResourceURL.Call_DIRECT);
                            urlgetfile1.setWindowState(SWBResourceURL.WinState_MAXIMIZED);
                            urlgetfile1.setParameter("fileid", strfile);
                            urlgetfile1.setParameter("propURI", DocumentoProbatorio.intranet_fileActaNacimiento.getURI());
                            if (strfile.startsWith(iniName)) {
                                strfile = strfile.substring(iniName.length() + 1);
                            }
                            if(strfile.length()>25) strfile = strfile.substring(0,24)+"...";
                       %>     
                            <div id="icv-ver" ><a href="#" onclick="window.location='<%=urlgetfile1%>';return false;"><%=strfile%></a></div> 
                       <%
                          }
                       %>
                    
                    </td>
                </tr>
                <tr><td width="300px" align="right"><%=fmgr.renderLabel(request, DocumentoProbatorio.intranet_fileActaMatrimonio, SWBFormMgr.MODE_EDIT)%></td>
                    <td><%=fmgr.renderElement(request, DocumentoProbatorio.intranet_fileActaMatrimonio, SWBFormMgr.MODE_EDIT)%></td>
                    <td>
                      <%
                       iniName = DocumentoProbatorio.intranet_fileActaMatrimonio.getName() + "_" + doc.getSemanticObject().getId();
                       strfile = doc.getFileActaMatrimonio();
                       if(null!=strfile){
                            SWBResourceURL urlgetfile1 = paramRequest.getRenderUrl();
                            urlgetfile1.setMode(MODE_GETFILE);
                            urlgetfile1.setAction("inline");
                            urlgetfile1.setCallMethod(SWBResourceURL.Call_DIRECT);
                            urlgetfile1.setWindowState(SWBResourceURL.WinState_MAXIMIZED);
                            urlgetfile1.setParameter("fileid", strfile);
                            urlgetfile1.setParameter("propURI", DocumentoProbatorio.intranet_fileActaMatrimonio.getURI());
                            if (strfile.startsWith(iniName)) {
                                strfile = strfile.substring(iniName.length() + 1);
                            }
                            if(strfile.length()>25) strfile = strfile.substring(0,24)+"...";
                       %>     
                            <div id="icv-ver" ><a href="#" onclick="window.location='<%=urlgetfile1%>';return false;"><%=strfile%></a></div> 
                       <%
                          }
                       %>
                    </td>
                </tr>
                <tr><td width="300px" align="right"><%=fmgr.renderLabel(request, DocumentoProbatorio.intranet_hasActasNacimientoFamiliares, SWBFormMgr.MODE_EDIT)%></td>
                    <td><%=fmgr.renderElement(request, DocumentoProbatorio.intranet_hasActasNacimientoFamiliares, SWBFormMgr.MODE_EDIT)%></td>
                    <td>
                        <%
                            iniName = DocumentoProbatorio.intranet_hasActasNacimientoFamiliares.getName() + "_" + doc.getSemanticObject().getId();
                            Iterator<String> itstr = doc.listActasNacimientoFamiliareses();

                            if(itstr.hasNext()){
                        %>
                        
                        <!-- <select id="IDgetFile1" name="IDgetFile1" size="5"> -->
                        <%
                            
                            while (itstr.hasNext()) {

                                strfile = itstr.next();

                                SWBResourceURL urlgetfile = paramRequest.getRenderUrl();
                                urlgetfile.setMode(MODE_GETFILE);
                                urlgetfile.setAction("inline");
                                urlgetfile.setCallMethod(SWBResourceURL.Call_DIRECT);
                                urlgetfile.setWindowState(SWBResourceURL.WinState_MAXIMIZED);
                                urlgetfile.setParameter("fileid", strfile);
                                urlgetfile.setParameter("propURI", DocumentoProbatorio.intranet_hasActasNacimientoFamiliares.getURI());

                                if (strfile.startsWith(iniName)) {
                                    strfile = strfile.substring(iniName.length() + 1);
                                }

                                if(strfile.length()>25) strfile = strfile.substring(0,24)+"...";
                                %>     
                            <div id="icv-ver" ><a href="#" onclick="window.location='<%=urlgetfile%>';return false;"><%=strfile%></a></div> 
                       <%
                            }
                        
                        %>
                        <!--
                        </select>
                        <button class="boton" name="btngetfile" onclick="getDownloadFile('IDgetFile1');">Descargar</button>
                            
                        <div id="icv-ver" ><a href="#"><%//=strfile%></a></div> -->
                    <%
                        }
                    %>
                    
                    </td>
                </tr>
                <tr><td width="300px" align="right"><%=fmgr.renderLabel(request, DocumentoProbatorio.intranet_fileFotoTamInfantil, SWBFormMgr.MODE_EDIT)%></td>
                    <td><%=fmgr.renderElement(request, DocumentoProbatorio.intranet_fileFotoTamInfantil, SWBFormMgr.MODE_EDIT)%></td>
                    <td>
                      <%
                       iniName = DocumentoProbatorio.intranet_fileFotoTamInfantil.getName() + "_" + doc.getSemanticObject().getId();
                       strfile = doc.getFileFotoTamInfantil();
                       if(null!=strfile){
                            SWBResourceURL urlgetfile1 = paramRequest.getRenderUrl();
                            urlgetfile1.setMode(MODE_GETFILE);
                            urlgetfile1.setAction("inline");
                            urlgetfile1.setCallMethod(SWBResourceURL.Call_DIRECT);
                            urlgetfile1.setWindowState(SWBResourceURL.WinState_MAXIMIZED);
                            urlgetfile1.setParameter("fileid", strfile);
                            urlgetfile1.setParameter("propURI", DocumentoProbatorio.intranet_fileFotoTamInfantil.getURI());
                            if (strfile.startsWith(iniName)) {
                                strfile = strfile.substring(iniName.length() + 1);
                            }
                            if(strfile.length()>25) strfile = strfile.substring(0,24)+"...";
                       %>     
                            <div id="icv-ver" ><a href="#" onclick="window.location='<%=urlgetfile1%>';return false;"><%=strfile%></a></div> 
                       <%
                          }
                       %>
                    </td>
                </tr>
                <tr><td width="300px" align="right"><%=fmgr.renderLabel(request, DocumentoProbatorio.intranet_fileCopiaRFC, SWBFormMgr.MODE_EDIT)%></td>
                    <td><%=fmgr.renderElement(request, DocumentoProbatorio.intranet_fileCopiaRFC, SWBFormMgr.MODE_EDIT)%></td>
                    <td>
                      <%
                      iniName = DocumentoProbatorio.intranet_fileCopiaRFC.getName() + "_" + doc.getSemanticObject().getId();
                       strfile = doc.getFileCopiaRFC();
                       if(null!=strfile){
                            SWBResourceURL urlgetfile1 = paramRequest.getRenderUrl();
                            urlgetfile1.setMode(MODE_GETFILE);
                            urlgetfile1.setAction("inline");
                            urlgetfile1.setCallMethod(SWBResourceURL.Call_DIRECT);
                            urlgetfile1.setWindowState(SWBResourceURL.WinState_MAXIMIZED);
                            urlgetfile1.setParameter("fileid", strfile);
                            urlgetfile1.setParameter("propURI", DocumentoProbatorio.intranet_fileCopiaRFC.getURI());
                            if (strfile.startsWith(iniName)) {
                                strfile = strfile.substring(iniName.length() + 1);
                            }
                            if(strfile.length()>25) strfile = strfile.substring(0,24)+"...";
                       %>     
                            <div id="icv-ver" ><a href="#" onclick="window.location='<%=urlgetfile1%>';return false;"><%=strfile%></a></div> 
                       <%
                          }
                       %>
                    </td>
                </tr>
                <tr><td width="300px" align="right"><%=fmgr.renderLabel(request, DocumentoProbatorio.intranet_fileCURP, SWBFormMgr.MODE_EDIT)%></td>
                    <td><%=fmgr.renderElement(request, DocumentoProbatorio.intranet_fileCURP, SWBFormMgr.MODE_EDIT)%></td>
                    <td>
                      <%
                      iniName = DocumentoProbatorio.intranet_fileCURP.getName() + "_" + doc.getSemanticObject().getId();
                       strfile = doc.getFileActaNacimiento();
                       if(null!=strfile){
                            SWBResourceURL urlgetfile1 = paramRequest.getRenderUrl();
                            urlgetfile1.setMode(MODE_GETFILE);
                            urlgetfile1.setAction("inline");
                            urlgetfile1.setCallMethod(SWBResourceURL.Call_DIRECT);
                            urlgetfile1.setWindowState(SWBResourceURL.WinState_MAXIMIZED);
                            urlgetfile1.setParameter("fileid", strfile);
                            urlgetfile1.setParameter("propURI", DocumentoProbatorio.intranet_fileCURP.getURI());
                            if (strfile.startsWith(iniName)) {
                                strfile = strfile.substring(iniName.length() + 1);
                            }
                            if(strfile.length()>25) strfile = strfile.substring(0,24)+"...";
                       %>     
                            <div id="icv-ver" ><a href="#" onclick="window.location='<%=urlgetfile1%>';return false;"><%=strfile%></a></div> 
                       <%
                          }
                       %>
                    </td>
                </tr>
                <tr><td width="300px" align="right"><%=fmgr.renderLabel(request, DocumentoProbatorio.intranet_hasFilesComprobanteEstudio, SWBFormMgr.MODE_EDIT)%></td>
                    <td><%=fmgr.renderElement(request, DocumentoProbatorio.intranet_hasFilesComprobanteEstudio, SWBFormMgr.MODE_EDIT)%></td>
                    <td>
                        <%
                            iniName = DocumentoProbatorio.intranet_hasFilesComprobanteEstudio.getName() + "_" + doc.getSemanticObject().getId();

                            itstr = doc.listFilesComprobanteEstudios();
                            
                            if(itstr.hasNext()){
                        %>
                        
                        
                        <!-- <select id="IDgetFile2" name="IDgetFile2" size="5"> -->
                        <%
                            
                            while (itstr.hasNext()) {

                                strfile = itstr.next();

                                SWBResourceURL urlgetfile = paramRequest.getRenderUrl();
                                urlgetfile.setMode(MODE_GETFILE);
                                urlgetfile.setAction("inline");
                                urlgetfile.setCallMethod(SWBResourceURL.Call_DIRECT);
                                urlgetfile.setWindowState(SWBResourceURL.WinState_MAXIMIZED);
                                urlgetfile.setParameter("fileid", strfile);
                                urlgetfile.setParameter("propURI", DocumentoProbatorio.intranet_hasFilesComprobanteEstudio.getURI());

                                if (strfile.startsWith(iniName)) {
                                    strfile = strfile.substring(iniName.length() + 1);
                                }
                                if(strfile.length()>25) strfile = strfile.substring(0,24)+"...";
                                //out.println("<option value=\"" + urlgetfile + "\">" + strfile + "</option>");
                                %>     
                            <div id="icv-ver" ><a href="#" onclick="window.location='<%=urlgetfile%>';return false;"><%=strfile%></a></div> 
                       <%
                            }
                        
                        %>
                        <!-- </select>
                        <button class="boton" name="btngetfile" onclick="getDownloadFile('IDgetFile2');">Descargar</button>
                            
                        <div id="icv-ver" ><a href="#"><%//=strfile%></a></div> -->
                    <%
                          }
                       %>
                    </td>
                </tr>
                <tr><td width="300px" align="right"><%=fmgr.renderLabel(request, DocumentoProbatorio.intranet_hasFilesIdentificacionOficial, SWBFormMgr.MODE_EDIT)%></td>
                    <td><%=fmgr.renderElement(request, DocumentoProbatorio.intranet_hasFilesIdentificacionOficial, SWBFormMgr.MODE_EDIT)%></td>
                    <td>
                        <%
                            iniName = DocumentoProbatorio.intranet_hasFilesIdentificacionOficial.getName() + "_" + doc.getSemanticObject().getId();

                            itstr = doc.listFilesIdentificacionOficials();
                            
                            if(itstr.hasNext()){
                        %>
                        <!-- <select id="IDgetFile3" name="IDgetFile3" size="5"> -->
                        <%
                            
                            while (itstr.hasNext()) {

                                strfile = itstr.next();

                                SWBResourceURL urlgetfile = paramRequest.getRenderUrl();
                                urlgetfile.setMode(MODE_GETFILE);
                                urlgetfile.setAction("inline");
                                urlgetfile.setCallMethod(SWBResourceURL.Call_DIRECT);
                                urlgetfile.setWindowState(SWBResourceURL.WinState_MAXIMIZED);
                                urlgetfile.setParameter("fileid", strfile);
                                urlgetfile.setParameter("propURI", DocumentoProbatorio.intranet_hasFilesIdentificacionOficial.getURI());

                                if (strfile.startsWith(iniName)) {
                                    strfile = strfile.substring(iniName.length() + 1);
                                }
                                if(strfile.length()>25) strfile = strfile.substring(0,24)+"...";
                                //out.println("<option value=\"" + urlgetfile + "\">" + strfile + "</option>");
                                %>     
                            <div id="icv-ver" ><a href="#" onclick="window.location='<%=urlgetfile%>';return false;"><%=strfile%></a></div> 
                       <%
                            }
                        
                        %>
                        <!-- </select>
                        <button class="boton" name="btngetfile" onclick="getDownloadFile('IDgetFile3');">Descargar</button>
                            
                        <div id="icv-ver" ><a href="#"><%=strfile%></a></div> -->
                    <%
                          }
                       %>
                    
                    </td>
                </tr>
                <tr><td width="300px" align="right"><%=fmgr.renderLabel(request, DocumentoProbatorio.intranet_fileComprobanteDomicilio, SWBFormMgr.MODE_EDIT)%></td>
                    <td><%=fmgr.renderElement(request, DocumentoProbatorio.intranet_fileComprobanteDomicilio, SWBFormMgr.MODE_EDIT)%></td>
                    <td>
                      <%
                      iniName = DocumentoProbatorio.intranet_fileComprobanteDomicilio.getName() + "_" + doc.getSemanticObject().getId();
                       strfile = doc.getFileComprobanteDomicilio();
                       if(null!=strfile){
                            SWBResourceURL urlgetfile1 = paramRequest.getRenderUrl();
                            urlgetfile1.setMode(MODE_GETFILE);
                            urlgetfile1.setAction("inline");
                            urlgetfile1.setCallMethod(SWBResourceURL.Call_DIRECT);
                            urlgetfile1.setWindowState(SWBResourceURL.WinState_MAXIMIZED);
                            urlgetfile1.setParameter("fileid", strfile);
                            urlgetfile1.setParameter("propURI", DocumentoProbatorio.intranet_fileComprobanteDomicilio.getURI());
                            if (strfile.startsWith(iniName)) {
                                strfile = strfile.substring(iniName.length() + 1);
                            }
                            if(strfile.length()>25) strfile = strfile.substring(0,24)+"...";
                       %>     
                            <div id="icv-ver" ><a href="#" onclick="window.location='<%=urlgetfile1%>';return false;"><%=strfile%></a></div> 
                       <%
                          }
                       %>
                    </td>
                </tr>
                <tr><td width="300px" align="right"><%=fmgr.renderLabel(request, DocumentoProbatorio.intranet_fileNumeroSeguridadSocial, SWBFormMgr.MODE_EDIT)%></td>
                    <td><%=fmgr.renderElement(request, DocumentoProbatorio.intranet_fileNumeroSeguridadSocial, SWBFormMgr.MODE_EDIT)%></td>
                    <td>
                      <%
                      iniName = DocumentoProbatorio.intranet_fileNumeroSeguridadSocial.getName() + "_" + doc.getSemanticObject().getId();
                       strfile = doc.getFileNumeroSeguridadSocial();
                       if(null!=strfile){
                            SWBResourceURL urlgetfile1 = paramRequest.getRenderUrl();
                            urlgetfile1.setMode(MODE_GETFILE);
                            urlgetfile1.setAction("inline");
                            urlgetfile1.setCallMethod(SWBResourceURL.Call_DIRECT);
                            urlgetfile1.setWindowState(SWBResourceURL.WinState_MAXIMIZED);
                            urlgetfile1.setParameter("fileid", strfile);
                            urlgetfile1.setParameter("propURI", DocumentoProbatorio.intranet_fileNumeroSeguridadSocial.getURI());
                            if (strfile.startsWith(iniName)) {
                                strfile = strfile.substring(iniName.length() + 1);
                            }
                            if(strfile.length()>25) strfile = strfile.substring(0,24)+"...";
                       %>     
                            <div id="icv-ver" ><a href="#" onclick="window.location='<%=urlgetfile1%>';return false;"><%=strfile%></a></div> 
                       <%
                          }
                       %>
                    </td>
                </tr>
                
	    </table>
	</fieldset>
<fieldset><span align="center">
        <%
                        //SWBResourceURL urlBack = paramRequest.getRenderUrl();
                        //urlBack.setParameter("act", "");
                        
        %>
        <!-- button dojoType="dijit.form.Button" type="button" onclick="window.location='<%//=urlBack%>'; return false;">Regresar</button -->
        <input type="button" value="Enviar Archivos" />
        <input  type="submit" onclick="return enviar()" value="Guardar" />
</span></fieldset>
</form>

            </div>
        </div><!-- icv-data -->  
    </div>
</div>


