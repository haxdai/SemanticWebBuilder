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
 * @(#)ParserDelegator.java	1.13 03/01/23
 *
 * Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package applets.htmleditor;

import javax.swing.text.html.parser.*;
import javax.swing.text.html.HTMLEditorKit;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.DataInputStream;
import java.io.ObjectInputStream;
import java.io.Reader;
import java.io.Serializable;
import java.lang.reflect.Method;

/**
 * Responsible for starting up a new DocumentParser
 * each time its parse method is invoked. Stores a
 * reference to the dtd.
 *
 * @author  Sunita Mani
 * @version 1.13, 01/23/03
 */

public class WBParserDelegator extends HTMLEditorKit.Parser implements Serializable {

    private static WBDTD dtd = null;

    protected static void setDefaultDTD() {
        if (dtd == null) {
            synchronized(ParserDelegator.class) {
                if (dtd == null) {
                    WBDTD _dtd = null;
                    // (PENDING) Hate having to hard code!
                    String nm = "html32";
                    try {
                        _dtd = WBDTD.getDTD(nm);
                    } catch (IOException e) {
                        // (PENDING) UGLY!
                        System.out.println("Throw an exception: could not get default dtd: " + nm);
                    }
                    _dtd = createDTD(_dtd, nm);
                    dtd = _dtd;
                }
            }
        }
    }

    protected static WBDTD createDTD(WBDTD dtd, String name) {

	InputStream in = null;
	boolean debug = true;
	try {
	    String path = name + ".bdtd";
	    in = getResourceAsStream(path);
            if (in != null) {
                dtd.read(new DataInputStream(new BufferedInputStream(in)));
                dtd.putDTDHash(name, dtd);
	    }
        } catch (Exception e) {
            System.out.println(e);
        }
        return dtd;
    }


    public WBParserDelegator() {
	if (dtd == null) {
	    setDefaultDTD();
	}
    }

    public void parse(Reader r, HTMLEditorKit.ParserCallback cb, boolean ignoreCharSet) throws IOException {
	new WBDocumentParser(dtd).parse(r, cb, ignoreCharSet);
    }

    /**
     * Fetch a resource relative to the ParserDelegator classfile.
     * If this is called on 1.2 the loading will occur under the
     * protection of a doPrivileged call to allow the ParserDelegator
     * to function when used in an applet.
     *
     * @param name the name of the resource, relative to the
     *  ParserDelegator class.
     * @returns a stream representing the resource
     */
    static InputStream getResourceAsStream(String name) {
	try {
            return WBResourceLoader.getResourceAsStream(name);
	} catch (Throwable e) {
	    // If the class doesn't exist or we have some other 
	    // problem we just try to call getResourceAsStream directly.
	    return WBParserDelegator.class.getResourceAsStream(name);
	}
    }

    private void readObject(ObjectInputStream s)
	throws ClassNotFoundException, IOException {
	s.defaultReadObject();
	if (dtd == null) {
	    setDefaultDTD();
	}
    }
}


