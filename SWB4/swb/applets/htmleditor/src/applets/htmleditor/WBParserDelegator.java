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


