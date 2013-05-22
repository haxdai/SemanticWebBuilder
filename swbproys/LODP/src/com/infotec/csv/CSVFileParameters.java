/*
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
 * http://www.semanticwebbuilder.org
 */
package com.infotec.csv;

import java.io.File;

/**
 *
 * @author serch
 */

public class CSVFileParameters {
    
    private final File file;
    private final boolean hasHeader;
    private final char quote;
    private final char delimiter;
    private final int recordsPerFile;
    
    
    public CSVFileParameters(File file, boolean hasHeader, char quote, char delimiter, int recordsPerFile) {
        this.file = file;
        this.hasHeader = hasHeader;
        this.quote = quote;
        this.delimiter = delimiter;
        this.recordsPerFile = recordsPerFile;
    }

    public File getFile() {
        return file;
    }

    public boolean hasHeader() {
        return hasHeader;
    }

    public char getQuote() {
        return quote;
    }

    public char getDelimiter() {
        return delimiter;
    }

    public int getRecordsPerFile() {
        return recordsPerFile;
    }
    
}
