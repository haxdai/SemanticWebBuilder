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
 * @(#)ContentModel.java	1.9 03/01/23
 *
 * Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package applets.htmleditor;

import javax.swing.text.html.parser.*;
import java.util.Vector;
import java.util.Enumeration;
import java.io.*;


/**
 * A representation of a content model. A content model is
 * basically a restricted BNF expression. It is restricted in
 * the sense that it must be deterministic. This means that you
 * don't have to represent it as a finite state automata.<p>
 * See Annex H on page 556 of the SGML handbook for more information.
 *
 * @author   Arthur van Hoff
 * @version  1.9,01/23/03
 *
 */
public final class WBContentModel implements Serializable {
    /**
     * Type. Either '*', '?', '+', ',', '|', '&'.
     */
    public int type;

    /**
     * The content. Either an WBElement or a ContentModel.
     */
    public Object content;

    /**
     * The next content model (in a ',', '|' or '&' expression).
     */
    public WBContentModel next;

    public WBContentModel() {
    }

    /**
     * Create a content model for an element.
     */
    public WBContentModel(WBElement content) {
	this(0, content, null);
    }

    /**
     * Create a content model of a particular type.
     */
    public WBContentModel(int type, WBContentModel content) {
	this(type, content, null);
    }

    /**
     * Create a content model of a particular type.
     */
    public WBContentModel(int type, Object content, WBContentModel next) {
	this.type = type;
	this.content = content;
	this.next = next;
    }

    /**
     * Return true if the content model could
     * match an empty input stream.
     */
    public boolean empty() {
	switch (type) {
	  case '*':
	  case '?':
	    return true;

	  case '+':
	  case '|':
	    for (WBContentModel m = (WBContentModel)content ; m != null ; m = m.next) {
		if (m.empty()) {
		    return true;
		}
	    }
	    return false;

	  case ',':
	  case '&':
	    for (WBContentModel m = (WBContentModel)content ; m != null ; m = m.next) {
		if (!m.empty()) {
		    return false;
		}
	    }
	    return true;

	  default:
	    return false;
	}
    }

    /**
     * Update elemVec with the list of elements that are
     * part of the this contentModel.
     */
     public void getElements(Vector elemVec) {         
         
	 switch (type) {
	 case '*':
	 case '?':
	 case '+':             
	     ((WBContentModel)content).getElements(elemVec);
	     break;
	 case ',':
	 case '|':
	 case '&':             
	     for (WBContentModel m=(WBContentModel)content; m != null; m=m.next){
		 m.getElements(elemVec);
	     }
	     break;
	 default:                          
	     elemVec.addElement(content);
	 }
     }

     private boolean valSet[];
     private boolean val[];
     // A cache used by first().  This cache was found to speed parsing
     // by about 10% (based on measurements of the 4-12 code base after
     // buffering was fixed).

    /**
     * Return true if the token could potentially be the
     * first token in the input stream.
     */
    public boolean first(Object token) {
	switch (type) {
	  case '*':
	  case '?':
	  case '+':
	    return ((WBContentModel)content).first(token);

	  case ',':
	    for (WBContentModel m = (WBContentModel)content ; m != null ; m = m.next) {
		if (m.first(token)) {
		    return true;
		}
		if (!m.empty()) {
		    return false;
		}
	    }
	    return false;

	  case '|':
	  case '&': {
	    WBElement e = (WBElement) token;
	    if (valSet == null) {
		valSet = new boolean[WBElement.maxIndex + 1];
		val = new boolean[WBElement.maxIndex + 1];
		// All WBElement instances are created before this ever executes
	    }
	    if (valSet[e.index]) {
		return val[e.index];
	    }
	    for (WBContentModel m = (WBContentModel)content ; m != null ; m = m.next) {
		if (m.first(token)) {
		    val[e.index] = true;
		    break;
		}
	    }
	    valSet[e.index] = true;
	    return val[e.index];
	  }

	  default:
	    return (content == token);
            // PENDING: refer to comment in ContentModelState
/*
              if (content == token) {
                  return true;
              }
              WBElement e = (WBElement)content;
              if (e.omitStart() && e.content != null) {
                  return e.content.first(token);
              }
              return false;
*/
	}
    }

    /**
     * Return the element that must be next.
     */
    public WBElement first() {
	switch (type) {
	  case '&':
	  case '|':
	  case '*':
	  case '?':
	    return null;

	  case '+':
	  case ',':
	    return ((WBContentModel)content).first();

	  default:
	    return (WBElement)content;
	}
    }

    /**
     * Convert to a string.
     */
    public String toString() {
	switch (type) {
	  case '*':
	    return content + "*";
	  case '?':
	    return content + "?";
	  case '+':
	    return content + "+";

	  case ',':
	  case '|':
	  case '&':
	    char data[] = {' ', (char)type, ' '};
	    String str = "";
	    for (WBContentModel m = (WBContentModel)content ; m != null ; m = m.next) {
		str = str + m;
		if (m.next != null) {
		    str += new String(data);
		}
	    }
	    return "(" + str + ")";

	  default:
	    return content.toString();
	}
    }
}
