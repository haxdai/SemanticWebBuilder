<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="xml" omit-xml-declaration="yes" indent="yes" encoding="ISO-8859-1"/>

    <xsl:template match="/promo">
        <div class="swb-promo leftPromo">
            <xsl:apply-templates select="title"/>
            <xsl:apply-templates select="image"/>
            <div class="promoInfo_LeftAlign">
                <xsl:apply-templates select="subtitle"/>
                <xsl:apply-templates select="content"/>
            </div>
            <xsl:apply-templates select="more"/>
        </div>
    </xsl:template>

    <xsl:template match="title">
        <h2><xsl:apply-templates/></h2>
    </xsl:template>

    <xsl:template match="image">
        <div class="promoImage">
            <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab" width="{@width}" height="{@height}">
                <param name="movie" value="{@src}" />
                <param name="quality" value="high" />
                <param name="wmode" value="transparent" />
                <param name="FlashVars" value="" />
                <embed src="{@src}" FlashVars="" quality="high" pluginspage="http://get.adobe.com/flashplayer/" type="application/x-shockwave-flash" >
                    <xsl:text  disable-output-escaping="yes">
                        &amp;nbsp;
                    </xsl:text>
                </embed>
            </object>
            <xsl:apply-templates select="imageFoot"/>
        </div>
    </xsl:template>

    <xsl:template match="imageFoot">
        <p class="promoFoot">
            <xsl:apply-templates/>
        </p>
    </xsl:template>

    <xsl:template match="subtitle">
        <h3><xsl:apply-templates/></h3>
    </xsl:template>

    <xsl:template match="content">
        <p><xsl:apply-templates/></p>
    </xsl:template>

    <xsl:template match="more">
        <div class="more">
            <p>
                <xsl:if test="@target='true'">
                    <a href="{@url}" title="Ver m�s" style="text-decoration: none;" target="_blank">
                        <xsl:apply-templates/>
                    </a>
                </xsl:if>
                <xsl:if test="@target='false'">
                    <a href="{@url}" title="Ver m�s" style="text-decoration: none;">
                        <xsl:apply-templates/>
                    </a>
                </xsl:if>
            </p>
        </div>
    </xsl:template>
</xsl:stylesheet>