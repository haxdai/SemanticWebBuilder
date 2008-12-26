/*
 * INFOTEC WebBuilder es una herramienta para el desarrollo de portales de conocimiento, colaboraci�n e integraci�n para Internet,
 * la cual, es una creaci�n original del Fondo de Informaci�n y Documentaci�n para la Industria INFOTEC, misma que se encuentra
 * debidamente registrada ante el Registro P�blico del Derecho de Autor de los Estados Unidos Mexicanos con el
 * No. 03-2002-052312015400-14, para la versi�n 1; No. 03-2003-012112473900 para la versi�n 2, y No. 03-2006-012012004000-01
 * para la versi�n 3, respectivamente.
 *
 * INFOTEC pone a su disposici�n la herramienta INFOTEC WebBuilder a trav�s de su licenciamiento abierto al p�blico (�open source�),
 * en virtud del cual, usted podr� usarlo en las mismas condiciones con que INFOTEC lo ha dise�ado y puesto a su disposici�n;
 * aprender de �l; distribuirlo a terceros; acceder a su c�digo fuente y modificarlo, y combinarlo o enlazarlo con otro software,
 * todo ello de conformidad con los t�rminos y condiciones de la LICENCIA ABIERTA AL P�BLICO que otorga INFOTEC para la utilizaci�n
 * de INFOTEC WebBuilder 3.2.
 *
 * INFOTEC no otorga garant�a sobre INFOTEC WebBuilder, de ninguna especie y naturaleza, ni impl�cita ni expl�cita,
 * siendo usted completamente responsable de la utilizaci�n que le d� y asumiendo la totalidad de los riesgos que puedan derivar
 * de la misma.
 *
 * Si usted tiene cualquier duda o comentario sobre INFOTEC WebBuilder, INFOTEC pone a su disposici�n la siguiente
 * direcci�n electr�nica:
 *
 *                                          http://www.webbuilder.org.mx
 */


/*
 * WBDocumentParser.java
 *
 * Created on 7 de octubre de 2004, 05:08 PM
 */
package applets.htmleditor;

import javax.swing.text.html.parser.*;

import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.HTML;
import javax.swing.text.ChangedCharSetException;

import java.util.*;
import java.io.*;
import java.net.*;

import sun.io.*;

/**
 *
 * @author Javier Solis Gonzalez
 */
public class WBDocumentParser extends WBParser
{
    private int inbody;
    private int intitle;
    private int inhead;
    private int instyle;
    private boolean seentitle;
    private HTMLEditorKit.ParserCallback callback = null;
    private boolean ignoreCharSet = false;
    private static final boolean debugFlag = false;

    public WBDocumentParser(WBDTD dtd) {
	super(dtd);
    }
 
    public void parse(Reader in,  HTMLEditorKit.ParserCallback callback, boolean ignoreCharSet) throws IOException {
	this.ignoreCharSet = ignoreCharSet;
	this.callback = callback;
	parse(in);
	// end of line
	callback.handleEndOfLineString(getEndOfLineString());
    }

    /**
     * Handle Start Tag.
     */
    protected void handleStartTag(WBTagElement tag) {

	WBElement elem = tag.getElement();
	if (elem == dtd.body) {
	    inbody++;
	} else if (elem == dtd.html) {
	} else if (elem == dtd.head) {
	    inhead++;
	} else if (elem == dtd.title) {
	    intitle++;
	} else if (elem == dtd.style) {
	    instyle++;
	}	
	if (debugFlag) {
	    if (tag.fictional()) {
		debug("Start Tag: " + tag.getHTMLTag() + " pos: " + getCurrentPos());
	    } else {
		debug("Start Tag: " + tag.getHTMLTag() + " attributes: " + 
		      getAttributes() + " pos: " + getCurrentPos());
	    }
	}
	if (tag.fictional()) {
	    SimpleAttributeSet attrs = new SimpleAttributeSet();
	    attrs.addAttribute(HTMLEditorKit.ParserCallback.IMPLIED,
			       Boolean.TRUE);
	    callback.handleStartTag(tag.getHTMLTag(), attrs,
				    getBlockStartPosition());
	} else {
	    callback.handleStartTag(tag.getHTMLTag(), getAttributes(),
				    getBlockStartPosition());
	    flushAttributes();
	}
    }


    protected void handleComment(char text[]) {
	if (debugFlag) {
	    debug("comment: ->" + new String(text) + "<-"
		  + " pos: " + getCurrentPos());
	}
	callback.handleComment(text, getBlockStartPosition());
    }

    /**
     * Handle Empty Tag.
     */
    protected void handleEmptyTag(WBTagElement tag) throws ChangedCharSetException {

	WBElement elem = tag.getElement();
	if (elem == dtd.meta && !ignoreCharSet) {
	    SimpleAttributeSet atts = getAttributes();
	    if (atts != null) {
		String content = (String)atts.getAttribute(HTML.Attribute.CONTENT);
		if (content != null) {
		    if ("content-type".equalsIgnoreCase((String)atts.getAttribute(HTML.Attribute.HTTPEQUIV))) {
			throw new ChangedCharSetException(content, false);
		    } else if ("charset" .equalsIgnoreCase((String)atts.getAttribute(HTML.Attribute.HTTPEQUIV))) {
			throw new ChangedCharSetException(content, true);
		    }
		}
	    }
	}
	if (inbody != 0 || elem == dtd.meta || elem == dtd.base || elem == dtd.isindex || elem == dtd.style || elem == dtd.link) {
	    if (debugFlag) {
		if (tag.fictional()) {
		    debug("Empty Tag: " + tag.getHTMLTag() + " pos: " + getCurrentPos());
		} else {
		    debug("Empty Tag: " + tag.getHTMLTag() + " attributes: " 
			  + getAttributes() + " pos: " + getCurrentPos());
		}
	    }
	    if (tag.fictional()) {
		SimpleAttributeSet attrs = new SimpleAttributeSet();
		attrs.addAttribute(HTMLEditorKit.ParserCallback.IMPLIED,
				   Boolean.TRUE);
		callback.handleSimpleTag(tag.getHTMLTag(), attrs,
					 getBlockStartPosition());
	    } else {
		callback.handleSimpleTag(tag.getHTMLTag(), getAttributes(),
					 getBlockStartPosition());
		flushAttributes();
	    }
	}
    }

    /**
     * Handle End Tag.
     */
    protected void handleEndTag(WBTagElement tag) {
	WBElement elem = tag.getElement();
	if (elem == dtd.body) {
	    inbody--;
	} else if (elem == dtd.title) {
	    intitle--;
	    seentitle = true;
	} else if (elem == dtd.head) {
            inhead--;
	} else if (elem == dtd.style) {
            instyle--;
	}
	if (debugFlag) {
	    debug("End Tag: " + tag.getHTMLTag() + " pos: " + getCurrentPos());
	}
	callback.handleEndTag(tag.getHTMLTag(), getBlockStartPosition());

    }

    /**
     * Handle Text.
     */
    protected void handleText(char data[]) {
	if (data != null) {
	    if (inbody != 0 || ((instyle != 0) ||
				((intitle != 0) && !seentitle))) {
		if (debugFlag) {
		    debug("text:  ->" + new String(data) + "<-" + " pos: " + getCurrentPos());
		}
		callback.handleText(data, getBlockStartPosition());
	    }
	}
    }

    /*
     * Error handling.
     */
    protected void handleError(int ln, String errorMsg) {
	if (debugFlag) {
	    debug("Error: ->" + errorMsg + "<-" + " pos: " + getCurrentPos());
	}
	/* PENDING: need to improve the error string. */
	callback.handleError(errorMsg, getCurrentPos());
    }


    /*
     * debug messages
     */
    private void debug(String msg) {
	System.out.println(msg);
    }
}
