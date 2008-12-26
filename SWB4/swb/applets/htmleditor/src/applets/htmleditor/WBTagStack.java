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
 * @(#)TagStack.java	1.9 03/01/23
 *
 * Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package applets.htmleditor;

import java.util.BitSet;
import java.util.Vector;
import java.io.*;

import javax.swing.text.html.parser.*;

/**
 * A stack of tags. Used while parsing an HTML document.
 * It, together with the ContentModelStates, defines the
 * complete state of the parser while reading a document.
 * When a start tag is encountered an element is pushed onto
 * the stack, when an end tag is enountered an element is popped
 * of the stack.
 *
 * @see Parser
 * @see DTD
 * @see WBContentModelState
 * @version 	1.9, 01/23/03
 * @author 	Arthur van Hoff
 */
final class WBTagStack implements DTDConstants {
    WBTagElement tag;
    WBElement elem;
    WBContentModelState state;
    WBTagStack next;
    BitSet inclusions;
    BitSet exclusions;
    boolean net;
    boolean pre;

    /**
     * Construct a stack element.
     */
    WBTagStack(WBTagElement tag, WBTagStack next) {
	this.tag = tag;
	this.elem = tag.getElement();
	this.next = next;

	WBElement elem = tag.getElement();
	if (elem.getContent() != null) {
	    this.state = new WBContentModelState(elem.getContent());
	}

	if (next != null) {
	    inclusions = next.inclusions;
	    exclusions = next.exclusions;
	    pre = next.pre;
	}
	if (tag.isPreformatted()) {
	    pre = true;
	}

	if (elem.inclusions != null) {
	    if (inclusions != null) {
		inclusions = (BitSet)inclusions.clone();
		inclusions.or(elem.inclusions);
	    } else {
		inclusions = elem.inclusions;
	    }
	}
	if (elem.exclusions != null) {
	    if (exclusions != null) {
		exclusions = (BitSet)exclusions.clone();
		exclusions.or(elem.exclusions);
	    } else {
		exclusions = elem.exclusions;
	    }
	}
    }

    /**
     * Return the element that must come next in the
     * input stream.
     */
    public WBElement first() {
	return (state != null) ? state.first() : null;
    }

    /**
     * Return the ContentModel that must be satisfied by
     * what comes next in the input stream.
     */
    public WBContentModel contentModel() {
	if (state == null) {
	    return null;
	} else {
	    return state.getModel();
	}
    }

    /**
     * Return true if the element that is contained at
     * the index specified by the parameter is part of
     * the exclusions specified in the DTD for the element
     * currently on the TagStack.
     */
    boolean excluded(int elemIndex) {
	return (exclusions != null) && exclusions.get(elem.getIndex());
    }

    /**
     * Update the Vector elemVec with all the elements that
     * are part of the inclusions listed in DTD for the element
     * currently on the TagStack.
     */
    boolean included(Vector elemVec, DTD dtd) {

	for (int i = 0 ; i < inclusions.size(); i++) {
	    if (inclusions.get(i)) {
		elemVec.addElement(dtd.getElement(i));
		System.out.println("WBElement add thru' inclusions: " + dtd.getElement(i).getName());
	    }
	}
	return (!elemVec.isEmpty());
    }


    /**
     * Advance the state by reducing the given element.
     * Returns false if the element is not legal and the
     * state is not advanced.
     */
    boolean advance(WBElement elem) {
	if ((exclusions != null) && exclusions.get(elem.getIndex())) {
	    return false;
	}
	if (state != null) {
	    WBContentModelState newState = state.advance(elem);
	    if (newState != null) {
		state = newState;
		return true;
	    }
	} else if (this.elem.getType() == ANY) {
	    return true;
	}
	return (inclusions != null) && inclusions.get(elem.getIndex());
    }

    /**
     * Return true if the current state can be terminated.
     */
    boolean terminate() {
	return (state == null) || state.terminate();
    }

    /**
     * Convert to a string.
     */
    public String toString() {
	return (next == null) ?
	    "<" + tag.getElement().getName() + ">" :
	    next + " <" + tag.getElement().getName() + ">";
    }
}

class NPrintWriter extends PrintWriter {

    private int numLines = 5;
    private int numPrinted = 0;

    public NPrintWriter (int numberOfLines) {
	super(System.out);
	numLines = numberOfLines;
    }

    public void println(char[] array) {
	if (numPrinted >= numLines) {
	    return;
	}

	char[] partialArray = null;

	for (int i = 0; i < array.length; i++) {
	    if (array[i] == '\n') {
		numPrinted++;
	    }

	    if (numPrinted == numLines) {
		System.arraycopy(array, 0, partialArray, 0, i);
	    }
	}

	if (partialArray != null) {
	    super.print(partialArray);
	}

	if (numPrinted == numLines) {
	    return;
	}

	super.println(array);
	numPrinted++;
    }
}


