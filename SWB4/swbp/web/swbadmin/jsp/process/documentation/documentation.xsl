<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="xml" version="1.0" encoding="ISO-8859-1" omit-xml-declaration="yes" indent="yes"/>
    <xsl:template match="/">    
        <div class="panel-body"><!-- begin Panel body -->
            <xsl:if test="root/model">
                <div class="row">
                    <div class="col-lg-2">
                        <ul class="nav nav-pills nav-stacked">
                            <li>
                                <a data-toggle="collapse" data-target="#collapsemodel" id="collapseModelButton">Modelo</a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="table-responsive">
                    <table> 
                        <tr>
                            <td>
                                <div class="in" id="collapsemodel" style="height: auto;">
                                    <div class="row text-center" id="modelerprocess">
                                        <xsl:value-of select="root/model" disable-output-escaping="yes" />
                                    </div>
                                </div> 
                            </td>
                        </tr>
                    </table>
                    <xsl:value-of select="root/colorTask" disable-output-escaping="yes"/>
                </div>
            </xsl:if>
            <div class="row">
                <div class="col-lg-2">
                    <ul id="myTab0" class="nav nav-pills nav-stacked">
                        <xsl:for-each select="root/section">
                            <li>
                                <a data-toggle="tab" href="#{@url}" id="{@className}">
                                    <xsl:value-of select="@title"/>
                                </a>
                            </li>
                        </xsl:for-each>
                    </ul>
                </div>    
                <div class="tab-content col-lg-10">
                    <xsl:for-each select="root/section">
                        <div id="{@url}" class="tab-pane">
                            <xsl:if test="@className != 'Activity' and @className != 'FreeText' and @className != 'Model'">
                                <div class="table-responsive">
                                    <table class="table table-hover swbp-table">
                                        <thead>
                                            <xsl:for-each select="instance">
                                                <xsl:if test="@count = 1">
                                                    <xsl:for-each select="property">
                                                        <th>
                                                            <xsl:value-of select="@title"/>
                                                        </th>
                                                    </xsl:for-each>
                                                </xsl:if>
                                            </xsl:for-each>
                                        </thead>
                                        <xsl:for-each select="instance">
                                            <tr>
                                                <xsl:for-each select="property">
                                                    <td>
                                                        <xsl:value-of select="." disable-output-escaping="yes"/>
                                                    </td>
                                                </xsl:for-each>
                                            </tr>
                                        </xsl:for-each>
                                    </table>
                                </div>
                            </xsl:if>
                            <xsl:if test="@className = 'Activity'">
                                <ul class="list-group" id="ulactivity">
                                    <xsl:for-each select="instance">
                                        <li class="list-group-item" id="liactivity{@id}">
                                            
                                            <div class="row">
                                                <div class="col-lg-11">
                                                    <xsl:value-of select="property" disable-output-escaping="yes"/>
                                                </div>
                                                <xsl:if test="@related = 'true'">
                                                    <div class="col-lg-1">
                                                        <a class="btn btn-default pull-right" data-toggle="collapse" data-parent="#liactivity{property/@id}" href="#colact{@id}" aria-expanded="true" aria-controls="collapseOne">
                                                            <span class="fa fa-eye"></span>
                                                        </a>  
                                                    </div>
                                                </xsl:if>
                                            </div>
                                            <!-- Si contiene elementos relacionados -->
                                            <xsl:if test="@related = 'true'">                           
                                                <div class="row panel-collapse collapse" id="colact{@id}">
                                                    <div class="col-lg-2">
                                                        <ul id="relatedTab" class="nav nav-pills nav-stacked">
                                                            <xsl:for-each select="documentSection">
                                                                <li>
                                                                    <a data-toggle="tab" href="#{@url}" id="{@className}">
                                                                        <xsl:value-of select="@title"/>
                                                                    </a>
                                                                </li>
                                                            </xsl:for-each>
                                                        </ul>
                                                    </div>
                                                    <div class="tab-content col-lg-10">
                                                        <xsl:for-each select="documentSection">
                                                            <div id="{@url}" class="tab-pane">
                                                                <div class="table-responsive">
                                                                    <table class="table table-hover swbp-table">
                                                                        <thead>
                                                                            <xsl:for-each select="related">
                                                                                <xsl:if test="@count = 0">
                                                                                    <xsl:for-each select="relatedprop">
                                                                                        <th>
                                                                                            <xsl:value-of select="@title"/>
                                                                                        </th>
                                                                                    </xsl:for-each>
                                                                                </xsl:if>
                                                                            </xsl:for-each>
                                                                        </thead>
                                                                        <xsl:for-each select="related">
                                                                            <tr>
                                                                                <xsl:for-each select="relatedprop">
                                                                                    <td>
                                                                                        <xsl:value-of select="." disable-output-escaping="yes"/>
                                                                                    </td>
                                                                                </xsl:for-each>
                                                                            </tr>
                                                                        </xsl:for-each>
                                                                    </table>
                                                                </div>
                                                            </div>
                                                        </xsl:for-each>
                                                    </div>
                                                </div>   
                                            </xsl:if>
                                        </li>
                                    </xsl:for-each>
                                </ul>
                            </xsl:if>
                            <xsl:if test="@className = 'FreeText'">
                                <ul class="list-group">
                                    <xsl:for-each select="instance">
                                        <li class="list-group-item" id="liactivity{property/@id}">
                                            <xsl:value-of select="." disable-output-escaping="yes"/>
                                        </li>
                                    </xsl:for-each>
                                </ul>
                            </xsl:if>
                        </div>
                    </xsl:for-each>
                </div>
            </div>
        </div> <!-- end Panel body -->
        <!--/div-->
    </xsl:template>
</xsl:stylesheet>