<%-- 
    Document   : modelerToolbar
    Created on : 17-feb-2016, 17:28:13
    Author     : hasdai
--%>
<%@page import="org.semanticwb.model.SWBContext"%>
<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<%
SWBParamRequest paramRequest = (SWBParamRequest) request.getAttribute("paramRequest");
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
    <span class="_group" cId ="GroupArtifact" onmouseover="ToolBar.overToolBar(true);" onmouseout="ToolBar.outToolBar()" title="<%=paramRequest.getLocaleString("itemGroup")%>" onclick="Modeler.creationStart(this)"></span>
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