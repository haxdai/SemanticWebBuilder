/**  
* SemanticWebBuilder es una plataforma para el desarrollo de portales y aplicaciones de integración, 
* colaboración y conocimiento, que gracias al uso de tecnología semántica puede generar contextos de 
* información alrededor de algún tema de interés o bien integrar información y aplicaciones de diferentes 
* fuentes, donde a la información se le asigna un significado, de forma que pueda ser interpretada y 
* procesada por personas y/o sistemas, es una creación original del Fondo de Información y Documentación 
* para la Industria INFOTEC, cuyo registro se encuentra actualmente en trámite. 
* 
* INFOTEC pone a su disposición la herramienta SemanticWebBuilder a través de su licenciamiento abierto al público (‘open source’), 
* en virtud del cual, usted podrá usarlo en las mismas condiciones con que INFOTEC lo ha diseñado y puesto a su disposición; 
* aprender de él; distribuirlo a terceros; acceder a su código fuente y modificarlo, y combinarlo o enlazarlo con otro software, 
* todo ello de conformidad con los términos y condiciones de la LICENCIA ABIERTA AL PÚBLICO que otorga INFOTEC para la utilización 
* del SemanticWebBuilder 4.0. 
* 
* INFOTEC no otorga garantía sobre SemanticWebBuilder, de ninguna especie y naturaleza, ni implícita ni explícita, 
* siendo usted completamente responsable de la utilización que le dé y asumiendo la totalidad de los riesgos que puedan derivar 
* de la misma. 
* 
* Si usted tiene cualquier duda o comentario sobre SemanticWebBuilder, INFOTEC pone a su disposición la siguiente 
* dirección electrónica: 
*  http://www.semanticwebbuilder.org
**/ 
 


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
