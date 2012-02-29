
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
<%@page import="com.infotec.cvi.swb.Estudios"%>
<%@page import="com.infotec.cvi.swb.Avance"%>
<%@page import="com.infotec.cvi.swb.EstudioSuperior"%>
<%@page import="com.infotec.cvi.swb.SituacionAcademica"%>
<%@page import="org.semanticwb.model.WebPage"%>
<%@page import="com.infotec.cvi.swb.GradoAcademico"%>
<%@page import="com.infotec.cvi.swb.Academia"%>
<%@page import="com.infotec.cvi.swb.CV"%>
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

                fmgr.setFilterHTMLTags(false);
                fmgr.setType(SWBFormMgr.TYPE_DOJO);

                

                SWBResourceURL urlupdtf = paramRequest.getActionUrl();
                urlupdtf.setAction(SWBResourceURL.Action_ADD);

                fmgr.setAction(urlupdtf.toString());
                fmgr.addButton(SWBFormButton.newSaveButton());
                out.println(fmgr.renderForm(request));
            %>
<!--
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
    </script>

            <form  id="<%//=doc.getURI()%>/formfiles" action="<%//=urlupdtf%>" enctype="multipart/form-data">
                <input type="hidden" name="act" value="edit" />
                <input type="hidden" name="suri" value="<%//=doc.getURI()%>" />
                <input type="hidden" name="clsuri" value="<%//=DocumentoProbatorio.intranet_DocumentoProbatorio.getURI()%>" />
                <input type="hidden" name="sval" value="<%//=doc.getURI()%>">
                <input type="hidden" name="actiontype" value="updtfiles" />
                <input name="smode" value="edit" type="hidden" />
                <div class="icv-div-grupo">
                    <label><b>*</b>Acta de Nacimiento</label><br/>
                        <%//=fmgr.renderElement(request, DocumentoProbatorio.intranet_fileActaNacimiento, SWBFormMgr.MODE_EDIT)%><br/>
                        <label>Acta de Matrimonio (en su caso)</label><br/>
                        <%//=fmgr.renderElement(request, DocumentoProbatorio.intranet_fileActaMatrimonio, SWBFormMgr.MODE_EDIT)%><br/>
                        <label>Acta de Nacimiento Familiares (en su caso)</label><br/>
                        <%//=fmgr.renderElement(request, DocumentoProbatorio.intranet_hasActasNacimientoFamiliares, SWBFormMgr.MODE_EDIT)%><br/>
                        <label><b>*</b>Una fotografía tamaño infantil</label><br/>
                        <%//=fmgr.renderElement(request, DocumentoProbatorio.intranet_fileFotoTamInfantil, SWBFormMgr.MODE_EDIT)%><br/>
                        <label><b>*</b>Copia de RFC</label><br/>
                        <%//=fmgr.renderElement(request, DocumentoProbatorio.intranet_fileCopiaRFC, SWBFormMgr.MODE_EDIT)%><br/>
                        <label><b>*</b>Identificación Oficial (IFE, Pasaporte)</label><br/>
                        <%//=fmgr.renderElement(request, DocumentoProbatorio.intranet_hasFilesIdentificacionOficial, SWBFormMgr.MODE_EDIT)%><br/>
                        <label><b>*</b>CURP</label><br/>
                        <%//=fmgr.renderElement(request, DocumentoProbatorio.intranet_fileCURP, SWBFormMgr.MODE_EDIT)%><br/>
                        <label><b>*</b>Comprobante de Estudios</label><br/>
                        <%//=fmgr.renderElement(request, DocumentoProbatorio.intranet_hasFilesComprobanteEstudio, SWBFormMgr.MODE_EDIT)%><br/>
                        <label><b>*</b>Comprobante de domicilio</label><br/>
                        <%//=fmgr.renderElement(request, DocumentoProbatorio.intranet_fileComprobanteDomicilio, SWBFormMgr.MODE_EDIT)%><br/>
                        <label><b>*</b>Justificación técnica (original)</label><br/>
                        <%//=fmgr.renderElement(request, DocumentoProbatorio.intranet_fileJustificacionTecnica, SWBFormMgr.MODE_EDIT)%><br/>
                        <label><b>*</b>Número de Seguridad Social</label><br/>
                        <%//=fmgr.renderElement(request, DocumentoProbatorio.intranet_fileNumeroSeguridadSocial, SWBFormMgr.MODE_EDIT)%><br/>
                        <label><b>*</b>Carta depósito bancario con CLABE (original)</label>
                        <%//=fmgr.renderElement(request, DocumentoProbatorio.intranet_fileCartaDepositoBancario, SWBFormMgr.MODE_EDIT)%><br/>
                        <label><b>*</b>Carta de protesta (original)</label><br/>
                        <%//=fmgr.renderElement(request, DocumentoProbatorio.intranet_fileCartaProtesta, SWBFormMgr.MODE_EDIT)%><br/>
                        
                                            <div class="clearer">&nbsp;</div>
                </div>

                <div class="centro">
                    <%
                        //SWBResourceURL urlBack = paramRequest.getRenderUrl();
                        //urlBack.setParameter("act", "");
                    %>
                    <button name="btnupload" type="button">Subir Archivo</button>
                    <input type="button" name="regresar" id="regresar" value="Regresar" onclick="window.location='<%//=urlBack%>'; return false;"/>
                    <input type="submit" name="btnsave" id="guardar" value="Guardar" onclick="return enviar()"/>
                </div>

            </form>
-->
            </div>
        </div><!-- icv-data -->  
    </div>
</div>


