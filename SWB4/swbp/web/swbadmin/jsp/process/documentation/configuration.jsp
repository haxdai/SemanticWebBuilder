<%-- 
    Document   : configuration
    Created on : 10/09/2014, 04:03:10 PM
    Author     : carlos.alvarez
--%>

<%@page import="org.semanticwb.process.documentation.resources.SWPConfigurationResource"%>
<%@page import="org.semanticwb.model.User"%>
<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    SWBParamRequest paramRequest = (SWBParamRequest) request.getAttribute(SWPConfigurationResource.PARAM_REQUEST);
    User user = paramRequest.getUser();
    String lang = user != null && user.getLanguage() != null ? user.getLanguage() : "es";
%>
<div class="row text-right">
    <ul class="list-unstyled list-inline ">
        <li>
            <a href="<%=paramRequest.getWebPage().getParent().getUrl(lang)%>" class="btn btn-default swbp-btn-action" data-toggle="tooltip" data-placement="bottom" data-original-title="<%=paramRequest.getLocaleString("lblBack")%>" title="<%=paramRequest.getLocaleString("lblBack")%>">
                <span class="fa fa-reply fa-fw"></span><%=paramRequest.getLocaleString("lblBack")%>
            </a>
        </li>
    </ul>
</div>
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">
            <div class="panel-title">
                <span class="fa fa-cogs"></span>
                Configuración General de Sitio de Documentación
            </div>
        </div>
        <div class="panel-body">            
            <ul class="nav nav-tabs" role="tablist">
                <li class="active"><a href="#general" role="tab" data-toggle="tab"><span class="fa fa-eye"></span> Vista general</a></li>
                <li><a href="#export" role="tab" data-toggle="tab"><span class="fa fa-files-o"></span> Exportar</a></li>
            </ul>
            <!-- Tab panes -->
            <div class="tab-content">
                <!-- Edit General -->
                <div class="tab-pane active" id="general">
                    <form class="form-horizontal col-lg-8" id="formConfigura" name="formConfigura" enctype="multipart/form-data">
                        <h3 class="page-header">Seleccionar imagen para sitio</h3>
                        <div class="form-group">
                            <label class="col-lg-2 control-label">Logotipo: </label>
                            <div class="col-lg-4">
                                <div class="input-group">
                                    <span class="input-group-btn">
                                        <span class="btn btn-default btn-file">
                                            <span class="fa fa-cloud-upload"></span>
                                            Archivo
                                            <input type="file" accept="image/jpg,image/png,image/jpeg,image/gif"  name="f" id="f" class="form-control"/>
                                        </span>
                                    </span>
                                    <input type="text" id="nameLogo" class="form-control" disabled/>
                                    <span class="input-group-btn" id="spDelete">
                                    </span>
                                </div>
                            </div>
                            <label class="col-lg-1 control-label">Alto: </label>
                            <div class="col-lg-2">
                                <input type="number" class="form-control" id="imgheight">
                            </div>
                            <label class="col-lg-1 control-label">Ancho: </label>
                            <div class="col-lg-2">
                                <input type="number" class="form-control" id="imgwidth">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-2 control-label">Vista previa</label>
                            <div class="col-md-10" id="previewLogo">
                            </div>
                        </div>
                        <div class="form-group">
                            <hr>
                        </div>
                        <h3 class="page-header">Botones de navegación</h3>
                        <div class="form-group">
                            <label class="col-lg-2 control-label">Administrar plantillas</label>
                            <a class="btn btn-default" id="btnAdmTemplates"
                               data-placement="right" data-toggle="tooltip" data-original-title="Administrar Plantillas">
                                <span class="fa fa-list-alt fa-fw"></span>
                            </a>
                            <div class="col-lg-4">
                                <div class="row">
                                    <label class="col-lg-4 control-label">Color</label>
                                    <div class="col-lg-8">
                                        <div class="input-group swbp-colorpicker-color">
                                            <input type="text" class="form-control" name="c"/>
                                            <span class="input-group-addon"><i></i></span>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <label class="col-lg-4 control-label">Background</label>
                                    <div class="col-lg-8">
                                        <div class="input-group swbp-colorpicker-background">
                                            <input type="text" class="form-control" name="b"/>
                                            <span class="input-group-addon"><i></i></span>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <label class="col-lg-4 control-label">Border</label>
                                    <div class="col-lg-8">
                                        <div class="input-group swbp-colorpicker-border">
                                            <input type="text" class="form-control" name="br"/>
                                            <span class="input-group-addon"><i></i></span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="text-right">
                            <button class="btn btn-default" onclick="javascript:window.history.back();">
                                <span class="fa fa-mail-reply"></span>
                                Regresar
                            </button>
                            <button id="btnSave" class="btn btn-default">
                                <span class="fa fa-save"></span>
                                Guardar
                            </button>
                        </div>
                    </form>
                </div>
                <div class="tab-pane" id="export">Exportar documentación</div>
            </div>
        </div>
    </div>
</div>