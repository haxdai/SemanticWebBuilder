<%-- 
    Document   : userTaskInboxD3Graphs
    Created on : 30/07/2013, 12:57:38 PM
    Author     : Hasdai Pacheco <ebenezer.sanchez@infotec.com.mx>
--%>
<%@page import="org.semanticwb.SWBPlatform"%>
<%@page import="org.semanticwb.process.resources.taskinbox.UserTaskInboxResource"%>
<%@page import="org.semanticwb.model.Resource"%>
<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<!--%@page contentType="text/html" pageEncoding="UTF-8"%-->
<%
SWBParamRequest paramRequest = (SWBParamRequest) request.getAttribute("paramRequest");
String processData = (String) request.getAttribute("processStats");

String _conf = (String)request.getAttribute("graphConfig");
if (null == _conf) _conf = "";

//boolean showInstances = _conf.contains(UserTaskInboxResource.ATT_INSTANCEGRAPH) && processData.contains("instanceData");//"use".equals(base.getAttribute(UserTaskInboxResource.ATT_INSTANCEGRAPH));
//boolean showResponse = _conf.contains(UserTaskInboxResource.ATT_RESPONSEGRAPH) && processData.contains("responseData");//"use".equals(base.getAttribute(UserTaskInboxResource.ATT_RESPONSEGRAPH));
//boolean showStatus = _conf.contains(UserTaskInboxResource.ATT_STATUSGRAPH) && processData.contains("statusData");//"use".equals(base.getAttribute(UserTaskInboxResource.ATT_STATUSGRAPH));
//boolean showParticipation  = _conf.contains(UserTaskInboxResource.ATT_PARTGRAPH) && processData.contains("partData");//"use".equals(base.getAttribute(UserTaskInboxResource.ATT_PARTGRAPH));
%>
<div class="row">
    <div class="col-sm-4">
        <div class="panel panel-default">
            <div class="panel-heading">Desempeño</div>
            <div class="panel-body">
                <div id="performanceGraph" class="row">
                    <div class="col-xs-12"><p class="text-center">Sin información</p></div>
                </div>
            </div>
        </div>
    </div>
    <div class="col-sm-4">
        <div class="panel panel-default">
            <div class="panel-heading"><%=paramRequest.getLocaleString("lblResponsetime")%></div>
            <div class="panel-body">
                <div id="responseTime" class="row">
                    <div class="col-xs-12"><p class="text-center">Sin información</p></div>
                </div>
            </div>
        </div>
    </div>
    <div class="col-sm-4">
        <div class="panel panel-default">
            <div class="panel-heading">Estatus</div>
            <div class="panel-body">
                <div id="overdueGraph" class="row">
                    <div class="col-xs-12"><p class="text-center">Sin información</p></div>
                </div>
            </div>
        </div>
    </div>
    <!--div class="col-sm-3">
        <div class="panel panel-default">
            <div class="panel-body">
               <div id="participationGraph" class="row">
                   <div class="col-sm-12"><p class="text-center">Sin información</p></div>
               </div>
            </div>
       </div>
    </div-->
</div>
<script>
    (function() {
        var tpl = "<div class='col-xs-4 chartContainer'></div><div class='col-xs-8 chartLabel'></div>";
        var lblTpl = "<div class='col-xs-12 text-left'><span>_labelVal_</span> _labelText_</div>";
        var createDonutChart = function(chartData, chartHolder) {
            if (chartData) {
                $("#"+chartHolder).empty();
                $("#"+chartHolder).append($(tpl));
                var chart = c3.generate({
                    data : {
                        columns: chartData,
                        type: "donut"
                    },
                    legend: {
                      show: false  
                    },
                    donut: {
                        label: {
                            show: false
                        }
                    },
                    size:{height:60},
                    bindto:$("#"+chartHolder+" .chartContainer")[0]
                });

                $("#"+chartHolder+" .chartLabel").append(lblTpl.replace("_labelVal_", chartData[0][1]).replace("_labelText_", chartData[0][0]));
                if (chartData[1]) {
                    $("#"+chartHolder+" .chartLabel").append(lblTpl.replace("_labelVal_", chartData[1][1]).replace("_labelText_", chartData[1][0]));
                }
            }
        };
        
        var processInfoStats = <%= processData %>;
        
        $(document).ready(function() {
            if (window.c3 && window.c3.version) {
                processInfoStats.responseData && createDonutChart(processInfoStats.responseData, "responseTime");
                processInfoStats.statusData && createDonutChart(processInfoStats.statusData, "overdueGraph");
                processInfoStats.instanceData && createDonutChart(processInfoStats.instanceData, "performanceGraph");
            }
        });
    })();
</script>
<!--script>
    (function() {
        $(document).ready(function(){
            function flatten(root) {
                var nodes = [], i = 0;
                function recurse(node) {
                    if (node.children) node.children.forEach(recurse);
                    if (!node.id) node.id = ++i;
                    nodes.push(node);
                }
                recurse(root);
                return nodes;
            }

            function updatePartChart(chartContainer) {
                var nodes = flatten(root);
                var links = d3.layout.tree().links(nodes);
                var max = root['max'];

                w = h = $(chartContainer).parent().width();

                root.fixed = true;
                root.x = w/2;
                root.y = h/2;

                var force = d3.layout.force()
                    .size([w,h])
                    .charge(-60)
                    .linkDistance(80)
                    .gravity(.05);

                $(chartContainer).html("<svg xmlns='http://www.w3.org/2000/svg'></svg>");

                var svg = d3.select(chartContainer+" svg")
                    .attr("width", w)
                    .attr("height", h)
                    .append("g");

                var linkScale = d3.scale.linear()
                    .domain([1,max])
                    .range([1,5]);

                force.nodes(nodes)
                    .links(links)
                    .start();

                var link = svg.selectAll("line.link")
                    .data(links, function(d) {
                        return d.target.id;
                    });

                link.enter().insert("svg:line", ".node")
                    .attr("class", "link")
                    .attr("x1", function(d) {
                        return d.source.x;
                    })
                    .attr("y1", function(d) {
                        return d.source.y;
                    })
                    .attr("x2", function(d) {
                        return d.target.x;
                    })
                    .attr("y2", function(d) {
                        return d.target.y;
                    })
                    .attr("stroke-width", function(d) {
                        return linkScale(d.target.participa)+"px";
                    })
                    .attr("stroke", "#BFBFCF")
                    .attr("fill", "none");

                link.exit().remove();

                var node = svg.selectAll("g.node")
                    .data(nodes, function(d) {
                        return d.id;
                    });

                var nodeEnter = node.enter().append("svg:g")
                    .attr("class", "node")
                    .attr("transform", function(d) {
                        return "translate(" + d.x + "," + d.y + ")";
                    })
                    .call(force.drag);

                nodeEnter.append("svg:image")
                    .attr("xlink:href", function(d) {
                        if (d.type && d.type==="process") {
                            return "<%=SWBPlatform.getContextPath()%>/work/models/<%=paramRequest.getWebPage().getWebSiteId()%>/css/images/icono-iniciado.gif";
                        } else {
                            return "<%=SWBPlatform.getContextPath()%>/work/models/<%=paramRequest.getWebPage().getWebSiteId()%>/css/images/colaborador.png";
                        }
                    })
                    .attr("x", -10)
                    .attr("y", -10)
                    .attr("width", 20)
                    .attr("height", 20);

                nodeEnter.append("svg:text")
                    .attr("font-family", "Arial")
                    .attr("font-size", "11")
                    .attr("stroke", "none")
                    .attr("fill", "#000000")
                    .attr("text-anchor", "middle")
                    .attr("dy", "2em")
                    .text(function(d) {
                        return d.name;
                    });

                node.exit().remove();

                link = svg.selectAll("line.link");
                node = svg.selectAll("g.node");

                force.on("tick", function() {
                    link.attr("x1", function(d) {
                        return d.source.x;
                    })
                    .attr("y1", function(d) {
                        return d.source.y;
                    })
                    .attr("x2", function(d) {
                        return d.target.x;
                    })
                    .attr("y2", function(d) {
                        return d.target.y;
                    });

                    node.attr("transform", function(d) {
                        return "translate(" + d.x + "," + d.y + ")";
                    });
                });

                /*svg.append("svg:text")
                    .text("<%=paramRequest.getLocaleString("lblParticipation")%>")
                    .attr("x",w/2)
                    .attr("y","22.85")
                    .style("text-anchor","middle")
                    .style("fill","black")
                    .style("font-size","10pt")
                    .style("font-weight","bold");*/
            }

            var root = window.processInfoStats.partData,
                w=200, h=200;

            updatePartChart("#participationGraph");
        });
    })();
</script-->