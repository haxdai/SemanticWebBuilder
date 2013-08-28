<%-- 
    Document   : ProcessDocumentationResource
    Created on : 24/07/2013, 06:41:50 PM
    Author     : carlos.alvarez
--%>

<%@page import="org.semanticwb.process.model.DataObject"%>
<%@page import="org.semanticwb.process.model.SequenceFlow"%>
<%@page import="org.semanticwb.process.model.ConnectionObject"%>
<%@page import="org.semanticwb.process.model.Containerable"%>
<%@page import="org.semanticwb.model.SWBComparator"%>
<%@page import="org.semanticwb.process.model.Event"%>
<%@page import="org.semanticwb.process.model.Activity"%>
<%@page import="org.semanticwb.process.model.Lane"%>
<%@page import="org.semanticwb.process.model.Gateway"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.semanticwb.SWBUtils"%>
<%@page import="org.semanticwb.SWBPortal"%>
<%@page import="org.semanticwb.model.SWBContext"%>
<%@page import="org.semanticwb.process.model.GraphicalElement"%>
<%@page import="org.semanticwb.process.model.FlowNode"%>
<%@page import="org.semanticwb.process.model.ProcessElement"%>
<%@page import="org.semanticwb.process.model.FlowNodeInstance"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.semanticwb.SWBPlatform"%>
<%@page import="org.semanticwb.platform.SemanticObject"%>
<%@page import="org.semanticwb.model.WebSite"%>
<%@page import="org.semanticwb.process.model.Documentation"%>
<%@page import="org.semanticwb.process.resources.DocumentationResource"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script type="text/javascript" src="/swbadmin/js/dojo/dojo/dojo.js" djConfig="parseOnLoad: true, isDebug: false, locale: 'es'" ></script>
<link rel="stylesheet" href="/swbadmin/jsp/process/formsBuilder.css" type="text/css"/>
<!DOCTYPE html>
<div id="workspace">
    <%
        SWBParamRequest paramRequest = (SWBParamRequest) request.getAttribute("paramRequest");
        WebSite wsite = (WebSite) paramRequest.getWebPage().getWebSite();
        String suri = request.getAttribute("suri") != null ? request.getAttribute("suri").toString() : "";
        String idDocumentation = request.getAttribute("idDocumentation") != null ? request.getAttribute("idDocumentation").toString() : "";
        Documentation documentation = Documentation.ClassMgr.getDocumentation(idDocumentation, wsite);
        ProcessElement pe = (ProcessElement) SWBPlatform.getSemanticMgr().getOntology().getGenericObject(suri);
        SWBResourceURL urlUpdate = paramRequest.getRenderUrl().setMode(DocumentationResource.MOD_UPDATETEXT).setCallMethod(SWBParamRequest.Call_DIRECT);
        SWBResourceURL urlGenerate = paramRequest.getRenderUrl().setMode("viewDocumentation");
        urlGenerate.setParameter("suri", suri);
        String text = paramRequest.getLocaleString("hereDoc");
        String aux = text;
        String element = paramRequest.getLocaleString("element");
        String suriProcess = "";
        ConnectionObject conObj = null;
        GraphicalElement graEle = null;
        Containerable container = null;
        if (pe instanceof org.semanticwb.process.model.Process) {%><a id="html" title="Generar html" onclick="window.location = '<%=urlGenerate%>'" style="cursor: pointer;"><img title="Generar html" src="/swbadmin/jsp/process/documentation/styles/css/images/html.png"/></a><%}%>
    <script type="text/javascript" src="<%=SWBPlatform.getContextPath() + "/swbadmin/jsp/process/tinymce/tinymce.min.js"%>"></script>
    <%
        if(pe instanceof org.semanticwb.process.model.Process
                || pe instanceof Lane
                || pe instanceof Activity
                || pe instanceof Gateway
                || pe instanceof ConnectionObject
                || pe instanceof Gateway
                || pe instanceof DataObject){
        if (pe instanceof org.semanticwb.process.model.Process) {
            out.println("<h2>" + paramRequest.getLocaleString("docFromPro") + " " + pe.getTitle() + "</h2>");
        } else {
            out.println("<h2>" + paramRequest.getLocaleString("docFromSub") + " " + pe.getTitle() + "</h2>");
            if (pe instanceof GraphicalElement) {
                graEle = (GraphicalElement) pe;
            }
            if (pe instanceof ConnectionObject) {
                conObj = (ConnectionObject) pe;
                graEle = (GraphicalElement) conObj.getSource();
            }
            container = graEle.getContainer();
            while (container != null) {
                if (container instanceof GraphicalElement) {
                    container = ((GraphicalElement) container).getContainer();
                } else {
                    suriProcess = ((org.semanticwb.process.model.Process) container).getURI();
                    container = null;
                }
            }
        }
    %>
    <form method="post" style="width: 100%;">
        <div class="editable" style="width:100%; height:100%;" id="idDocumentation/<%=idDocumentation%>">
            <%
                if (documentation != null) {
                    if (documentation.getText().trim().length() > 0) {
                        text = documentation.getText();
                    } else {
                        text = aux;
                    }
                    out.println(text);
                }%>
        </div>
        <input type="hidden" id="pe/<%=documentation.getId()%>" name="pe/<%=documentation.getId()%>" value="<%=pe.getTitle()%>"/>
    </form>
    <%
        if (pe instanceof org.semanticwb.process.model.Process) {
            SemanticObject semObj = SemanticObject.createSemanticObject(suri);
            org.semanticwb.process.model.Process process = (org.semanticwb.process.model.Process) semObj.createGenericInstance();
            if (process != null) {
                Iterator<GraphicalElement> iterator = process.listAllContaineds();
                ArrayList lane = new ArrayList();
                ArrayList activity = new ArrayList();
                ArrayList gateway = new ArrayList();
                ArrayList event = new ArrayList();
                ArrayList data = new ArrayList();
                GraphicalElement ge = null;
                Documentation doc = null;
                while (iterator.hasNext()) {
                    ge = iterator.next();
                    if (ge instanceof Lane) {
                        lane.add(ge);
                    }
                    if (ge instanceof Activity) {
                        activity.add(ge);
                    }
                    if (ge instanceof Gateway) {
                        gateway.add(ge);
                    }
                    if (ge instanceof Event) {
                        event.add(ge);
                    }
                    if (ge instanceof DataObject) {
                        data.add(ge);
                    }
                    if (!ge.listDocumentations().hasNext()) {
                        doc = Documentation.ClassMgr.createDocumentation(paramRequest.getWebPage().getWebSite());
                        doc.setText(text);
                        doc.setTextFormat("text/html");
                        ge.addDocumentation(doc);
                    }
                }
                //Lane
                iterator = SWBComparator.sortByDisplayName(lane.iterator(), paramRequest.getUser().getLanguage());
                if (lane.size() > 0) {
                    out.print("<h1>" + paramRequest.getLocaleString("lane") + "</h1>");
                }
                while (iterator.hasNext()) {
                    ge = iterator.next();
                    doc = ge.getDocumentation();
                    out.println("<h3>::: " + element + " " + ge.getTitle() + " :::</h3>");
                    out.println("<form method=\"post\">");
                    out.println("<div class=\"editable\" style=\"width:100%; border: 2px;\" id=\"idDocumentation/" + doc.getId() + "\">");
                    text = doc.getText();
                    out.println(text);
                    text = "";
                    out.println("</div>");
                    out.println("<input type=\"hidden\" id=\"pe/" + doc.getId() + "\" name=\"pe/" + doc.getId() + "\" value=\"" + ge.getTitle() + "\"/>");
                    out.println("</form>");
                }
                //Activity
                iterator = SWBComparator.sortByDisplayName(activity.iterator(), paramRequest.getUser().getLanguage());
                if (activity.size() > 0) {
                    out.print("<h1>" + paramRequest.getLocaleString("activity") + "</h1>");
                }
                while (iterator.hasNext()) {
                    ge = iterator.next();
                    doc = ge.getDocumentation();
                    out.println("<h3>::: " + element + " " + ge.getTitle() + " :::</h3>");
                    out.println("<form method=\"post\">");
                    out.println("<div class=\"editable\" style=\"width:100%; border: 2px;\" id=\"idDocumentation/" + doc.getId() + "\">");
                    if (doc.getText().trim().length() > 0) {
                        text = doc.getText();
                    } else {
                        text = aux;
                    }
                    out.println(text);
                    out.println("</div>");
                    out.println("<input type=\"hidden\" id=\"pe/" + doc.getId() + "\" name=\"pe/" + doc.getId() + "\" value=\"" + ge.getTitle() + "\"/>");
                    out.println("</form>");
                }
                //Gateway
                iterator = SWBComparator.sortByDisplayName(gateway.iterator(), paramRequest.getUser().getLanguage());
                if (gateway.size() > 0) {
                    out.print("<h1>" + paramRequest.getLocaleString("gateway") + "</h1>");
                }
                while (iterator.hasNext()) {
                    ge = iterator.next();
                    //Connections
                    Iterator<ConnectionObject> itConObj = SWBComparator.sortByDisplayName(((Gateway) ge).listOutputConnectionObjects(), paramRequest.getUser().getLanguage());
                    while (itConObj.hasNext()) {
                        ConnectionObject connectionObj = itConObj.next();
                        if (connectionObj instanceof SequenceFlow) {
                            if (connectionObj.getDocumentation() == null) {
                                doc = Documentation.ClassMgr.createDocumentation(paramRequest.getWebPage().getWebSite());
                                doc.setText(text);
                                doc.setTextFormat("text/html");
                                connectionObj.addDocumentation(doc);
                            } else {
                                doc = connectionObj.getDocumentation();
                            }
                            out.println("<h3>::: " + element + " " + connectionObj.getTitle() + " :::</h3>");
                            out.println("<form method=\"post\">");
                            out.println("<div class=\"editable\" style=\"width:100%; border: 2px;\" id=\"idDocumentation/" + doc.getId() + "\">");
                            if (doc.getText().trim().length() > 0) {
                                text = doc.getText();
                            } else {
                                text = aux;
                            }
                            out.println(text);
                            out.println("</div>");
                            out.println("<input type=\"hidden\" id=\"pe/" + doc.getId() + "\" name=\"pe/" + doc.getId() + "\" value=\"" + connectionObj.getTitle() + "\"/>");
                            out.println("</form>");
                        }
                    }
                    doc = ge.getDocumentation();
                    out.println("<h3>::: " + element + " " + ge.getTitle() + " :::</h3>");
                    out.println("<form method=\"post\">");
                    out.println("<div class=\"editable\" style=\"width:100%; border: 2px;\" id=\"idDocumentation/" + doc.getId() + "\">");
                    if (doc.getText().trim().length() > 0) {
                        text = doc.getText();
                    } else {
                        text = aux;
                    }
                    out.println(text);
                    out.println("</div>");
                    out.println("<input type=\"hidden\" id=\"pe/" + doc.getId() + "\" name=\"pe/" + doc.getId() + "\" value=\"" + ge.getTitle() + "\"/>");
                    out.println("</form>");
                }
                //Event
                iterator = SWBComparator.sortByDisplayName(event.iterator(), paramRequest.getUser().getLanguage());
                if (event.size() > 0) {
                    out.print("<h1>" + paramRequest.getLocaleString("event") + "</h1>");
                }
                while (iterator.hasNext()) {
                    ge = iterator.next();
                    doc = ge.getDocumentation();
                    out.println("<h3>::: " + element + " " + ge.getTitle() + " :::</h3>");
                    out.println("<form method=\"post\">");
                    out.println("<div class=\"editable\" style=\"width:100%; border: 2px;\" id=\"idDocumentation/" + doc.getId() + "\">");
                    if (doc.getText().trim().length() > 0) {
                        text = doc.getText();
                    } else {
                        text = aux;
                    }
                    out.println(text);
                    out.println("</div>");
                    out.println("<input type=\"hidden\" id=\"pe/" + doc.getId() + "\" name=\"pe/" + doc.getId() + "\" value=\"" + ge.getTitle() + "\"/>");
                    out.println("</form>");
                }
                //Data
                iterator = SWBComparator.sortByDisplayName(data.iterator(), paramRequest.getUser().getLanguage());
                if (data.size() > 0) {
                    out.print("<h1>" + paramRequest.getLocaleString("data") + "</h1>");
                }
                while (iterator.hasNext()) {
                    ge = iterator.next();
                    doc = ge.getDocumentation();
                    out.println("<h3>::: " + element + " " + ge.getTitle() + " :::</h3>");
                    out.println("<form method=\"post\">");
                    out.println("<div class=\"editable\" style=\"width:100%; border: 2px;\" id=\"idDocumentation/" + doc.getId() + "\">");
                    if (doc.getText().trim().length() > 0) {
                        text = doc.getText();
                    } else {
                        text = aux;
                    }
                    out.println(text);
                    out.println("</div>");
                    out.println("<input type=\"hidden\" id=\"pe/" + doc.getId() + "\" name=\"pe/" + doc.getId() + "\" value=\"" + ge.getTitle() + "\"/>");
                    out.println("</form>");
                }
            }
        }
    %>
    <script type="text/javascript">
            var suriProcess = "<%=suriProcess%>";
            tinymce.init({
                selector: "div.editable",
                inline: true,
                language: '<%=paramRequest.getUser().getLanguage()%>',
                theme: "modern",
                force_br_newlines: false,
                force_p_newlines: false,
                forced_root_block: '',
                plugins: [
                    "save advlist autolink autosave link image lists charmap print preview hr anchor pagebreak spellchecker",
                    "searchreplace wordcount visualblocks visualchars code fullscreen insertdatetime media nonbreaking",
                    "directionality emoticons template textcolor paste fullpage textcolor"
                ],
                save_onsavecallback: function(ed) {
                    var id = ed.id.replace("idDocumentation/", "");
                    var title = document.getElementById('pe/' + id).value;
                    submitUrl('<%=urlUpdate%>', ed.getContent(), ed.id, title);
                },
                toolbar: "save",
                save_enablewhendirty: true,
                toolbar1: "save bold italic underline strikethrough | alignleft aligncenter alignright alignjustify | styleselect formatselect fontselect fontsizeselect",
                toolbar2: "cut copy paste | searchreplace | bullist numlist | outdent indent blockquote | undo redo | link unlink anchor code | inserttime preview | forecolor backcolor",
                toolbar3: "thr removeformat | subscript superscript | charmap | print fullscreen | ltr rtl | spellchecker | visualchars visualblocks nonbreaking template pagebreak restoredraft",
                menubar: false,
                toolbar_items_size: 'small',
                style_formats: [
                    {title: 'Bold text', inline: 'b'},
                    {title: 'Red text', inline: 'span', styles: {color: '#ff0000'}},
                    {title: 'Red header', block: 'h1', styles: {color: '#ff0000'}},
                    {title: 'Example 1', inline: 'span', classes: 'example1'},
                    {title: 'Example 2', inline: 'span', classes: 'example2'},
                    {title: 'Table styles'},
                    {title: 'Table row 1', selector: 'tr', classes: 'tablerow1'}
                ]
            });

            function submitUrl(url, data, id, title) {
                dojo.xhrPost({
                    url: url,
                    contentType: "application/x-www-form-urlencoded; charset=utf-8",
                    content: {txt: data.toString().trim(), idDocumentation: id.replace("idDocumentation/", ""), suri: '<%=suri%>'},
                    load: function(response, ioArgs)
                    {
                        parent.reloadTab("" + suriProcess + "");
                        parent.showStatus("<%=paramRequest.getLocaleString("save")%> " + title, '#12345');
                        return response;
                    },
                    error: function(response, ioArgs) {
                        parent.showError("<%=paramRequest.getLocaleString("error")%>");
                        return response;
                    },
                    handleAs: "text"
                });

            }
            function generateHtml(url) {
                dojo.xhrPost({url: url,
                    contentType: "application/x-www-form-urlencoded; charset=utf-8",
                    content: {suri: '<%=suri%>'},
                    load: function(response, ioArgs)
                    {
                        return response;
                    },
                    error: function(response, ioArgs) {
                        return response;
                    },
                    handleAs: "text"
                });
            }
    </script>
    <%} else{out.println("<h1>"+ paramRequest.getLocaleLogString("noDocumentation")+"</h1>");}%>
</div>
