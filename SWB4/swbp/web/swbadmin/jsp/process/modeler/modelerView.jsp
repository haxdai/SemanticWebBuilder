<%-- 
    Document   : modelerView
    Created on : 7/05/2013, 12:09:42 PM
    Author     : Hasdai Pacheco <ebenezer.sanchez@infotec.com.mx>
--%>
<%@page import="org.semanticwb.SWBPortal"%>
<%@page import="org.semanticwb.SWBPlatform"%>
<%@page import="org.semanticwb.model.SWBContext"%>
<%@page import="org.semanticwb.process.resources.SVGModeler"%>
<%@page import="org.semanticwb.process.model.Process"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<%
    SWBParamRequest paramRequest = (SWBParamRequest) request.getAttribute("paramRequest");
    boolean isViewMode = (Boolean) request.getAttribute("isViewMode");

    SWBResourceURL commandUrl = paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT);
    String suri = request.getParameter("suri");

    commandUrl.setMode(SVGModeler.MODE_GATEWAY);
    commandUrl.setAction(SVGModeler.ACT_GETPROCESSJSON);
    commandUrl.setParameter("suri", suri);
    SWBResourceURL exportUrl = paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT);
    exportUrl.setMode(SVGModeler.MODE_EXPORT);
%>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7" >
    <script type="text/javascript" src="<%=SWBPortal.getContextPath()%>/swbadmin/js/dojo/dojo/dojo.js" djConfig="parseOnLoad: true, isDebug: false, locale: 'es'" ></script>
    <script type="text/javascript" src="<%=SWBPortal.getContextPath()%>/swbadmin/js/jquery/jquery.js" ></script>
    <script type="text/javascript" src="<%=SWBPortal.getContextPath()%>/swbadmin/jsp/process/modeler/toolkit.js?v=<%= Math.floor(Math.random() * 100) %>" charset="utf-8"></script>
    <script type="text/javascript" src="<%=SWBPortal.getContextPath()%>/swbadmin/jsp/process/modeler/modeler.js?v=<%= Math.floor(Math.random() * 100) %>" charset="utf-8"></script>
    <link href="<%=SWBPortal.getContextPath()%>/swbadmin/jsp/process/modeler/images/modelerFrame.css" rel="stylesheet" type="text/css">
</head>
<body style="margin: 0px;" onload="Modeler.init('modeler', {mode: '<%=  !isViewMode ? "edit" : "view" %>'}, loadProcess);">
    <%
    if (!isViewMode) {
        %>
        <div class="toolbarContainer">
            <div id="toolBar">
                <div class="toolbarItem"><span class="toolbarHeader"></span></div>
                <div class="toolbarItem" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()">
                    <span title="<%=paramRequest.getLocaleString("itemFile")%>" class="fileItem" onclick="ToolBar.showSubBar('fileBar', this)"></span>
                </div>
                <div class="toolbarItem" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()">
                    <span title="<%=paramRequest.getLocaleString("itemStartEvents")%>" class="startEventItem" onclick="ToolBar.showSubBar('startEventsBar', this)"></span>
                </div>
                <div class="toolbarItem" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()">
                    <span title="<%=paramRequest.getLocaleString("itemInterEvents")%>" class="intereventItem" onclick="ToolBar.showSubBar('interEventsBar', this)"></span>
                </div>
                <div class="toolbarItem" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()">
                    <span title="<%=paramRequest.getLocaleString("itemEndEvents")%>" class="endeventItem" onclick="ToolBar.showSubBar('endEventsBar', this)"></span>
                </div>
                <div class="toolbarItem"><span class="toolbarSeparator"></span></div>
                <div class="toolbarItem" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()">
                    <span title="<%=paramRequest.getLocaleString("itemTasks")%>" class="taskItem" onclick="ToolBar.showSubBar('tasksBar', this)"></span>
                </div>
                <div class="toolbarItem" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()">
                    <span title="<%=paramRequest.getLocaleString("itemSubprocesses")%>" class="subtaskItem" onclick="ToolBar.showSubBar('subtasksBar', this)"></span>
                </div>
                <div class="toolbarItem" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()">
                    <span title="<%=paramRequest.getLocaleString("itemCallTasks")%>" class="taskcallItem" onclick="ToolBar.showSubBar('calltasksBar', this)"></span>
                </div>
                <div class="toolbarItem" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()">
                    <span title="<%=paramRequest.getLocaleString("itemGateways")%>" class="gatewayItem" onclick="ToolBar.showSubBar('gatewaysBar', this)"></span>
                </div>
                <div class="toolbarItem"><span class="toolbarSeparator"></span></div>
                <div class="toolbarItem" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()">
                    <span title="<%=paramRequest.getLocaleString("itemConnObjects")%>" class="flowItem" onclick="ToolBar.showSubBar('connectionsBar', this)"></span>
                </div>
                <div class="toolbarItem" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()">
                    <span title="<%=paramRequest.getLocaleString("itemArtifacts")%>" class="artifactItem" onclick="ToolBar.showSubBar('artifactsBar', this)"></span>
                </div>
                <div class="toolbarItem" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()">
                    <span title="<%=paramRequest.getLocaleString("itemDataObjects")%>" class="dataobjectItem" onclick="ToolBar.showSubBar('dataobjectsBar', this)"></span>
                </div>
                <div class="toolbarItem"><span class="toolbarSeparator"></span></div>
                <div class="toolbarItem" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()">
                    <span title="<%=paramRequest.getLocaleString("itemSwimlanes")%>" class="poolItem" onclick="ToolBar.showSubBar('swimlanesBar', this)"></span>
                </div>
                <div class="toolbarItem" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()">
                    <span class="toolbarFooter"></span>
                </div>
            </div>
        </div>
        <div id="fileBar" class="subbarHidden" style="width: 385px;">
            <span class="subbarStart"></span>
            <span class="newProcess" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%= paramRequest.getLocaleString("itemNew") %>" onclick="if (confirm('<%= paramRequest.getLocaleString("msgClearCanvas") %>')) {
                    Modeler.clearCanvas();
                }"></span>
            <span class="openProcess" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%= paramRequest.getLocaleString("itemOpen") %>" onclick="showLoadDialog();"></span>
            <%
            if (SWBContext.getAdminWebSite().equals(paramRequest.getWebPage().getWebSite())) {
                %>
                <span class="storeProcess" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%= paramRequest.getLocaleString("itemSend") %>" onclick="storeProcess();"></span>
                <%
            }
            %>
            <span class="saveProcess" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemSave")%>" onclick="submit_download_form('swp')"></span>
            <span class="saveAsSVG" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemSaveImageSVG")%>" onclick="submit_download_form('svg')"></span>
            <span class="saveAsImage" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemSaveImagePNG")%>" onclick="submit_download_form('png')"></span>
            <span class="subbarEnd"></span>
        </div>
        <div id="startEventsBar" class="subbarHidden" style="width: 385px;">
            <span class="subbarStart"></span>
            <span class="normalStartEvent"  cId ="StartEvent" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemStartNormal")%>" onclick="Modeler.creationStart(this)"></span>
            <span class="messageStartEvent" cId ="MessageStartEvent" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemStartMsg")%>" onclick="Modeler.creationStart(this)"></span>
            <span class="timerStartEvent" cId ="TimerStartEvent" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemStartTimer")%>"  onclick="Modeler.creationStart(this)"></span>
            <span class="ruleStartEvent" cId ="RuleStartEvent" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemStartRule")%>" onclick="Modeler.creationStart(this)"></span>
            <span class="signalStartEvent" cId ="SignalStartEvent" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemStartSignal")%>" onclick="Modeler.creationStart(this)"></span>
            <span class="multiStartEvent" cId ="MultipleStartEvent" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemStartMultiple")%>" onclick="Modeler.creationStart(this)"></span>
            <span class="parallelStartEvent" cId ="ParallelStartEvent" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemStartParallel")%>" onclick="Modeler.creationStart(this)"></span>
            <span class="scalaStartEvent" cId ="ScalationStartEvent" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemStartScala")%>" onclick="Modeler.creationStart(this)"></span>
            <span class="errorStartEvent" cId ="ErrorStartEvent" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemStartError")%>" onclick="Modeler.creationStart(this)"></span>
            <span class="compensaStartEvent" cId ="CompensationStartEvent" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemStartCompensa")%>"  onclick="Modeler.creationStart(this)"></span>
            <span class="subbarEnd"></span>
        </div>
        <div id="interEventsBar" class="subbarHidden" style="width: 645px;">
            <span class="subbarStart"></span>
            <span class="messageInterCatchEvent" cId ="MessageIntermediateCatchEvent" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemInterCatchMsg")%>" onclick="Modeler.creationStart(this)"></span>
            <span class="messageInterThrowEvent" cId ="MessageIntermediateThrowEvent" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemInterThrowMsg")%>" onclick="Modeler.creationStart(this)"></span>
            <span class="timerInterEvent" cId ="TimerIntermediateCatchEvent" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemInterCatchTimer")%>" onclick="Modeler.creationStart(this)"></span>
            <span class="errorInterEvent" cId ="ErrorIntermediateCatchEvent" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemInterCatchError")%>" onclick="Modeler.creationStart(this)"></span>
            <span class="cancelInterEvent" cId ="CancelationIntermediateCatchEvent" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemInterCatchCancel")%>" onclick="Modeler.creationStart(this)"></span>
            <span class="compensaInterCatchEvent" cId ="CompensationIntermediateCatchEvent" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemInterCatchCompensa")%>" onclick="Modeler.creationStart(this)"></span>
            <span class="compensaInterThrowEvent" cId ="CompensationIntermediateThrowEvent" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemInterThrowCompensa")%>" onclick="Modeler.creationStart(this)"></span>
            <span class="ruleInterEvent" cId ="RuleIntermediateCatchEvent" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemInterCatchRule")%>" onclick="Modeler.creationStart(this)"></span>
            <span class="linkInterCatchEvent" cId ="LinkIntermediateCatchEvent" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemInterCatchLink")%>" onclick="Modeler.creationStart(this)"></span>
            <span class="linkInterThrowEvent" cId ="LinkIntermediateThrowEvent" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemInterThrowLink")%>" onclick="Modeler.creationStart(this)"></span>
            <span class="signalInterCatchEvent" cId ="SignalIntermediateCatchEvent" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemInterCatchSignal")%>" onclick="Modeler.creationStart(this)"></span>
            <span class="signalInterThrowEvent" cId ="SignalIntermediateThrowEvent" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemInterThrowSignal")%>" onclick="Modeler.creationStart(this)"></span>
            <span class="multipleInterCatchEvent" cId ="MultipleIntermediateCatchEvent" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemInterCatchMultiple")%>" onclick="Modeler.creationStart(this)"></span>
            <span class="multipleInterThrowEvent" cId ="MultipleIntermediateThrowEvent" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemInterThrowMultiple")%>" onclick="Modeler.creationStart(this)"></span>
            <span class="scalaInterCatchEvent" cId ="ScalationIntermediateCatchEvent" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemInterCatchScala")%>" onclick="Modeler.creationStart(this)"></span>
            <span class="scalaInterThrowEvent" cId ="ScalationIntermediateThrowEvent" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemInterThrowScala")%>" onclick="Modeler.creationStart(this)"></span>
            <span class="parallelInterEvent" cId ="ParallelIntermediateCatchEvent" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemInterCatchParallel")%>" onclick="Modeler.creationStart(this)"></span>
            <span class="subbarEnd"></span>
        </div>
        <div id="endEventsBar" class="subbarHidden" style="width: 348px;">
            <span class="subbarStart"></span>
            <span class="normalEndEvent" cId ="EndEvent" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemEndNormal")%>" onclick="Modeler.creationStart(this)"></span>
            <span class="messageEndEvent" cId ="MessageEndEvent" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemEndMsg")%>"  onclick="Modeler.creationStart(this)"></span>
            <span class="errorEndEvent" cId ="ErrorEndEvent" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemEndError")%>"  onclick="Modeler.creationStart(this)"></span>
            <span class="cancelEndEvent" cId ="CancelationEndEvent" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemEndCancela")%>" onclick="Modeler.creationStart(this)"></span>
            <span class="compensaEndEvent" cId ="CompensationEndEvent" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemEndCompensa")%>"  onclick="Modeler.creationStart(this)"></span>
            <span class="signalEndEvent" cId ="SignalEndEvent" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemEndSignal")%>" onclick="Modeler.creationStart(this)"></span>
            <span class="multiEndEvent" cId ="MultipleEndEvent" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemEndMultiple")%>"  onclick="Modeler.creationStart(this)"></span>
            <span class="escalaEndEvent" cId ="ScalationEndEvent" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemEndScala")%>" onclick="Modeler.creationStart(this)"></span>
            <span class="terminalEndEvent" cId ="TerminationEndEvent" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemEndTermina")%>" onclick="Modeler.creationStart(this)"></span>
            <span class="subbarEnd"></span>
        </div>
        <div id="tasksBar" class="subbarHidden" style="width: 311px;">
            <span class="subbarStart"></span>
            <span class="abstractTask" cId ="Task" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemTaskAbstract")%>" onclick="Modeler.creationStart(this)"></span>
            <span class="userTask" cId ="UserTask" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemTaskUser")%>" onclick="Modeler.creationStart(this)"></span>
            <span class="serviceTask" cId ="ServiceTask" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemTaskService")%>" onclick="Modeler.creationStart(this)"></span>
            <span class="scriptTask" cId ="ScriptTask" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemTaskScript")%>" onclick="Modeler.creationStart(this)"></span>
            <span class="ruleTask" cId ="BusinessRuleTask" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemTaskRule")%>" onclick="Modeler.creationStart(this)"></span>
            <span class="manualTask" cId ="ManualTask" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemTaskManual")%>" onclick="Modeler.creationStart(this)"></span>
            <span class="sendTask" cId ="SendTask" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemTaskSend")%>" onclick="Modeler.creationStart(this)"></span>
            <span class="receiveTask" cId ="ReceiveTask" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemTaskReceive")%>" onclick="Modeler.creationStart(this)"></span>
            <span class="subbarEnd"></span>
        </div>
        <div id="subtasksBar" class="subbarHidden" style="width: 163px;">
            <span class="subbarStart"></span>
            <span class="subProcess" cId ="SubProcess" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemSubprocess")%>" onclick="Modeler.creationStart(this)"></span>
            <span class="adhocsubProcess" cId ="AdhocSubProcess" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemSubprocessAdhoc")%>" onclick="Modeler.creationStart(this)"></span>
            <span class="eventsubProcess" cId ="EventSubProcess" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemSubprocessEvent")%>" onclick="Modeler.creationStart(this)"></span>
            <span class="transactionsubProcess" cId ="TransactionSubProcess" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemTransaction")%>" onclick="Modeler.creationStart(this)"></span>
            <span class="subbarEnd"></span>
        </div>
        <div id="calltasksBar" class="subbarHidden" style="width: 237px;">
            <span class="subbarStart"></span>
            <span class="callTask" cId ="CallTask" onmouseover="ToolBar.overToolBar();" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemCallTask")%>" onclick="Modeler.creationStart(this)"></span>
            <span class="callmanualTask" cId ="CallManualTask" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemCallTaskManual")%>" onclick="Modeler.creationStart(this)"></span>
            <span class="callruleTask" cId ="CallBusinessRuleTask" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemCallTaskRule")%>" onclick="Modeler.creationStart(this)"></span>
            <span class="callscriptTask" cId ="CallScriptTask" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemCallTaskScript")%>" onclick="Modeler.creationStart(this)"></span>
            <span class="calluserTask" cId ="CallUserTask" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemCallTaskUser")%>" onclick="Modeler.creationStart(this)"></span>
            <span class="callsubProcess" cId ="CallSubProcess" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemCallSubprocess")%>" onclick="Modeler.creationStart(this)"></span>
            <span class="subbarEnd"></span>
        </div>
        <div id="gatewaysBar" class="subbarHidden" style="width: 274px;">
            <span class="subbarStart"></span>
            <span class="exclusiveDataGateway" cId ="ExclusiveGateway" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemGatewayExData")%>" onclick="Modeler.creationStart(this)"></span>
            <span class="inclusiveDataGateway" cId ="InclusiveGateway" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemGatewayIncData")%>" onclick="Modeler.creationStart(this)"></span>
            <span class="exclusiveStartEventGateway" cId ="ExclusiveStartEventGateway" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemGatewayExStart")%>" onclick="Modeler.creationStart(this)"></span>
            <span class="exclusiveEventGateway" cId="ExclusiveIntermediateEventGateway" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemGatewayExEvt")%>" onclick="Modeler.creationStart(this)"></span>
            <span class="parallelGateway" cId ="ParallelGateway" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemGatewayParallel")%>" onclick="Modeler.creationStart(this)"></span>
            <span class="parallelStartGateway" cId ="ParallelStartEventGateway" onmouseover="ToolBar.overToolBar();" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemGatewayParallelStart")%>" onclick="Modeler.creationStart(this)"></span>
            <span class="complexGateway" cId ="ComplexGateway" onmouseover="ToolBar.overToolBar();" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemGatewayComplex")%>" onclick="Modeler.creationStart(this)"></span>
            <span class="subbarEnd"></span>
        </div>
        <div id="connectionsBar" class="subbarHidden" style="width: 237px;">
            <span class="subbarStart"></span>
            <span class="sequenceFlow" cId ="SequenceFlow" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemConnSequence")%>" onclick="Modeler.creationStart(this)"></span>
            <span class="conditionalFlow" cId ="ConditionalFlow" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemConnCond")%>" onclick="Modeler.creationStart(this)"></span>
            <span class="defaultFlow" cId ="DefaultFlow" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemConnDefault")%>" onclick="Modeler.creationStart(this)"></span>
            <span class="messageFlow" cId ="MessageFlow" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemConnMsg")%>" onclick="Modeler.creationStart(this)"></span>
            <span class="associationFlow" cId ="AssociationFlow" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemConnAssoc")%>" onclick="Modeler.creationStart(this)"></span>
            <span class="directionalassociationFlow" cId ="DirectionalAssociation" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemConnDirAssoc")%>" onclick="Modeler.creationStart(this)"></span>
            <span class="subbarEnd"></span>
        </div>
        <div id="artifactsBar" class="subbarHidden" style="width: 89px;">
            <span class="subbarStart"></span>
            <span class="annotation" cId ="AnnotationArtifact" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemAnnotation")%>" onclick="Modeler.creationStart(this)"></span>
            <span class="group" cId ="GroupArtifact" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemGroup")%>" onclick="Modeler.creationStart(this)"></span>
            <span class="subbarEnd"></span>
        </div>
        <div id="dataobjectsBar" class="subbarHidden" style="width: 163px;">
            <span class="subbarStart"></span>
            <span class="dataObject" cId ="DataObject" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemData")%>" onclick="Modeler.creationStart(this)"></span>
            <span class="dataInput" cId ="DataInput" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemDataInput")%>" onclick="Modeler.creationStart(this)"></span>
            <span class="dataOutput" cId ="DataOutput" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemDataOutput")%>" onclick="Modeler.creationStart(this)"></span>
            <span class="dataStore" cId ="DataStore" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemDataStore")%>" onclick="Modeler.creationStart(this)"></span>
            <span class="subbarEnd"></span>
        </div>
        <div id="swimlanesBar" class="subbarHidden" style="width: 89px;">
            <span class="subbarStart"></span>
            <span class="pool" cId ="Pool" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemPool")%>" onclick="Modeler.creationStart(this)"></span>
            <span class="lane" cId ="Lane" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemLane")%>" onclick="Modeler.creationStart(this)"></span>
            <span class="subbarEnd"></span>
        </div>
        <%
    }

    Process p = (Process) SWBPlatform.getSemanticMgr().getOntology().getGenericObject(suri);
    if (isViewMode && p != null) {//TODO: Revisar este display de header
        %>
        <h1><%=p.getTitle()%>&nbsp;<a href="" onclick="window.history.go(-1);
            return false;"><img alt="<%=paramRequest.getLocaleString("back")%>" src="/work/models/<%=paramRequest.getWebPage().getWebSiteId()%>/css/images/icono-atras.png"/></a></h1>
        <%
    }
    %>
    <jsp:include page="modelerSVG.jsp" flush="true"/>
    <form id="svgform" accept-charset="utf-8" method="post" action="<%=exportUrl%>">
        <input type="hidden" id="output_format" name="output_format" value="">
        <input type="hidden" name="suri" value="<%=suri%>">
        <input type="hidden" id="data" name="data" value="">
        <input type="hidden" id="viewBox" name="viewBox" value="">
    </form>
    <%
    SWBResourceURL uploadUrl = paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT);
    uploadUrl.setMode(SVGModeler.MODE_GATEWAY).setAction(SVGModeler.ACT_LOADFILE).setParameter("suri", suri);
    %>
    <div class="overlay" id="overlayBackground">
        <div class="loadDialog">
            <p class="titleBar"><%=paramRequest.getLocaleString("lblLoadModel")%></p>
            <span class="loadDialogCloseButton">
                <a href="#" onclick="hideLoadDialog();return false;"><%=paramRequest.getLocaleString("lblClose")%></a>
            </span>
            <form action="<%=uploadUrl%>" method="post">
                <iframe id='target_upload_swpFile' name='target_upload_swpFile' src='' style='display: none'></iframe>
                <div class="loadDialogContent">
                    <p>
                        <input id="swpFile" name="swpFile" type="file" onChange="javascript:validFileType(this);">
                        <script type="text/javascript">
                            frame = document.getElementById('target_upload_swpFile');
                            function validFileType(element) {
                                if (!isFileType(element.value, 'swp|xpdl')) {
                                    element.value = "";
                                }
                                return false;
                            }

                            function iframeHandler() {
                                //Eliminar los handlers del iframe
                                if (frame.detachEvent)
                                    frame.detachEvent("onload", iframeHandler);
                                else
                                    frame.removeEventListener("load", iframeHandler, false);

                                var content = "";
                                if (frame.contentDocument) {
                                    content = frame.contentDocument.body.innerHTML;
                                } else if (frame.contentWindow) {
                                    content = frame.contentWindow.document.body.innerHTML;
                                } else if (frame.document) {
                                    content = frame.document.body.innerHTML;
                                }
                                Modeler.loadProcess(content);
                            }

                            function uploadjs_swpFile(forma) {
                                var encoding = forma.encoding;
                                forma.encoding = 'multipart/form-data';
                                var action = forma.action;

                                var target = forma.target;
                                forma.target = 'target_upload_swpFile';

                                //Agregar los handlers al iframe
                                if (frame.attachEvent)
                                    frame.attachEvent("onload", iframeHandler);
                                else
                                    frame.addEventListener("load", iframeHandler, true);

                                forma.submit();

                                forma.encoding = encoding;
                                forma.action = action;
                                forma.target = target;
                                hideLoadDialog();

                                return false;
                            }

                            function isFileType(pFile, pExt) {
                                if (pFile.length > 0 && pExt.length > 0) {
                                    var swFormat = pExt + '|';
                                    var sExt = pFile.substring(pFile.indexOf(".")).toLowerCase();
                                    var sType = '';
                                    while (swFormat.length > 0) {
                                        sType = swFormat.substring(0, swFormat.indexOf("|"));
                                        if (sExt.indexOf(sType) !== -1)
                                            return true;
                                        swFormat = swFormat.substring(swFormat.indexOf("|") + 1);
                                    }
                                    while (pExt.indexOf("|") !== - 1)
                                        pExt = pExt.replace('|', ',');
                                    alert("<%=paramRequest.getLocaleString("msgBadFile")%>");
                                    return false;
                                } else {
                                    return true;
                                }
                            }
                        </script>
                    </p>
                </div>
                <div class='buttonRibbon'>
                    <input type="submit" value="<%=paramRequest.getLocaleString("lblSend")%>" onclick="uploadjs_swpFile(this.form);
                            return false;"/>
                    <input type="button" value="<%=paramRequest.getLocaleString("lblCancel")%>" onclick="hideLoadDialog();
                            return false;"/>
                </div>
            </form>
        </div>
    </div>
    <script type="text/javascript">
        function callbackLoad(response) {
            Modeler.loadProcess(response);
            parent.reloadTreeNodeByURI && parent.reloadTreeNodeByURI('<%=suri%>');
            hideLoadDialog();
        };

        /*
         Utility function: populates the <FORM> with the SVG data
         and the requested output format, and submits the form.
         */
        function submit_download_form(output_format) {
            var form = document.getElementById("svgform");
            var viewBox = document.getElementById("modeler");
            var element = document.getElementById("viewBox");
            element.value = "0 0 " + viewBox.getAttribute('width') + " " + viewBox.getAttribute('height');


            if (output_format === "svg" || output_format === "png") {
                // Get the SVG element
                var svg = document.getElementsByTagName("svg")[0];
                // Extract the data as SVG text string
                var svg_xml = (new XMLSerializer).serializeToString(svg);
                form['data'].value = svg_xml;
            } else if (output_format === "swp") {
                form['data'].value = JSON.stringify(Modeler.getProcessJSON());
            }
            // Submit the <FORM> to the server.
            // The result will be an attachment file to download.
            form['output_format'].value = output_format;
            form.submit();
        };

        function showLoadDialog() {
            var ov = document.getElementById("overlayBackground");
            if (ov) {
                ov.style.display = "block";
            }
            //ov.style.width = window.outerWidth+"px";
            //ov.style.height = window.outerHeight+"px";
        }

        function hideLoadDialog() {
            var ov = document.getElementById("overlayBackground");
            if (ov) {
                ov.style.display = "none";
            }
        };

        <%
        if (suri != null) {
            commandUrl = paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT);
            commandUrl.setMode(SVGModeler.MODE_GATEWAY);
            commandUrl.setAction(SVGModeler.ACT_GETPROCESSJSON);
            commandUrl.setParameter("suri", suri);
            %>
            function loadProcess() {
                if (ToolKit && ToolKit !== null) {
                    ToolKit.showTooltip(0, "<%=paramRequest.getLocaleString("loading")%>", 200, "Warning");
                }
                Modeler.submitCommand('<%=commandUrl%>', null, callbackLoad);
            };
            <%
        }
        if (SWBContext.getAdminWebSite().equals(paramRequest.getWebPage().getWebSite())) {
            commandUrl = paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT);
            commandUrl.setMode(SVGModeler.MODE_GATEWAY);
            commandUrl.setAction(SVGModeler.ACT_STOREPROCESS);
            commandUrl.setParameter("suri", suri);
            %>
            function storeProcess() {
                var json = Modeler.getProcessJSON();
                var jsonString = "JSONSTART" + JSON.stringify(json) + "JSONEND";
                if (ToolKit && ToolKit !== null) {
                    ToolKit.showTooltip(0, "<%=paramRequest.getLocaleString("sending")%>", 200, "Warning");
                }
                Modeler.submitCommand('<%=commandUrl%>', jsonString, loadProcess);
            };
            <%
        }
        %>
    </script>
</body>