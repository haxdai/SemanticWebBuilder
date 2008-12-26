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
 * WBHTMLDocument.java
 *
 * Created on 5 de octubre de 2004, 02:12 PM
 */

package applets.htmleditor;

import java.awt.Color;
import java.awt.Component;
import java.awt.font.TextAttribute;
import java.util.*;
import java.net.URL;
import java.net.URLEncoder;
import java.net.MalformedURLException;
import java.io.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
import javax.swing.undo.*;
import java.text.Bidi;
import javax.swing.text.html.*;

/**
 *
 * @author Javier Solis Gonzalez
 */
public class WBHTMLDocument extends HTMLDocument
{
     static String MAP_PROPERTY = "__MAP__";
     boolean hasBaseTag = false;
     
    
    /**
     * Constructs an HTML document using the default buffer size
     * and a default <code>StyleSheet</code>.  This is a convenience
     * method for the constructor
     * <code>HTMLDocument(Content, StyleSheet)</code>.
     */
    public WBHTMLDocument() {
	super();
    }
    
    /**
     * Constructs an HTML document with the default content
     * storage implementation and the specified style/attribute
     * storage mechanism.  This is a convenience method for the
     * constructor
     * <code>HTMLDocument(Content, StyleSheet)</code>.
     *
     * @param styles  the styles
     */
    public WBHTMLDocument(StyleSheet styles) {
	super(styles);
    }

    /**
     * Constructs an HTML document with the given content
     * storage implementation and the given style/attribute
     * storage mechanism.
     *
     * @param c  the container for the content
     * @param styles the styles
     */
    public WBHTMLDocument(Content c, StyleSheet styles) {
        super(c, styles);
    }    
    
    /**
     * Fetches the reader for the parser to use when loading the document
     * with HTML.  This is implemented to return an instance of
     * <code>HTMLDocument.HTMLReader</code>. 
     * Subclasses can reimplement this
     * method to change how the document gets structured if desired.
     * (For example, to handle custom tags, or structurally represent character
     * style elements.)
     *
     * @param pos the starting position
     * @return the reader used by the parser to load the document
     */
    public HTMLEditorKit.ParserCallback getReader(int pos) {
	Object desc = getProperty(Document.StreamDescriptionProperty);
	if (desc instanceof URL) { 
	    setBase((URL)desc);
	}
	HTMLReader reader = new HTMLReader(pos);
        //HTMLEditorKit.ParserCallback reader = new WBParserCallback();
	return reader;
    }    
    
     /**
     * Returns an <code>Enumeration</code> of the possible Maps.
     * @return the enumerated list of maps, or <code>null</code>
     *		if the maps are not an instance of <code>Hashtable</code>
     */
    public Enumeration getMaps() {
	Object maps = getProperty(MAP_PROPERTY);

	if (maps instanceof Hashtable) {
	    return ((Hashtable)maps).elements();
	}
	return null;
    }
    
}
