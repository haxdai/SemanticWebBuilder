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

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;


/**
 *
 * @author serch
 */
public class CSVFileParser {
    
    private static Logger log = SWBUtils.getLogger(CSVFileParser.class);
    
    private SWBcvsInputStream in;
    private CSVFileParameters parameters;
    private String[] headers = null;
    private String[] tempString = new String[0];
    private boolean inRecord = false;
    private boolean inQuotedField = false;
    private boolean inField = false;
    

    public CSVFileParser(CSVFileParameters parameters) throws IOException { 
        this.in = new SWBcvsInputStream(new FileInputStream(parameters.getFile()), 8 * 1024);
        this.parameters = parameters;
        if (this.parameters.hasHeader()) {
            processHeader();
        }
    }

    private void processHeader() throws IOException {
        headers = getNextRecord();
    }

    public synchronized String[] getNextRecord() throws IOException {
        ArrayList<String> record = new ArrayList<String>();
        if (!hasData()){
            throw new RuntimeException("No more data available...");
        }
        inRecord = true;
        while (inRecord) {
            record.add(processToken());
        }
        return record.toArray(tempString);
    }

    private String processToken() throws IOException { 
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int nb;
        boolean inToken = true;
        inField = false;
        while (inToken) {
            nb = in.read();
            if (nb == SWBcvsInputStream.END_OF_FILE) {
                inRecord = false;
                break;
            }
            if (nb == parameters.getQuote()) {
                if (inQuotedField) {
                    if (in.whichNextbyte() == parameters.getQuote()) {
                        nb = in.read();
                        baos.write(nb);
                    } else {
                        inQuotedField = false;
                    }
                } else if (inField) {
                    baos.write(nb);
                } else if (!inField) {
                    inField = true;
                    inQuotedField = true;
                }
            } else if (nb == parameters.getDelimiter()) {
                if (!inQuotedField && inField) {
                    inField = false;
                    inToken = false;
                } else if (inQuotedField) {
                    baos.write(nb);
                }
            } else if (nb == SWBcvsInputStream.CR || nb == SWBcvsInputStream.LF) {
                if (inQuotedField) {
                    baos.write(nb);
                } else if (!inQuotedField) {
                    int tmpnb = in.whichNextbyte();
                    if (tmpnb == SWBcvsInputStream.CR
                            || tmpnb == SWBcvsInputStream.LF) {
                        in.read();
                    }
                    inField = false;
                    inRecord = false;
                    inToken = false;
                }
            } else {
                baos.write(nb);
            }
        }
        return baos.toString();
    }

    public String[] getHeader() {
        if (parameters.hasHeader()) {
            return headers;
        } else {
            return null;
        }
    }
    
    public long getCurrentPosition(){
        return in.getCurrentPosition();
    }
    
    public boolean hasData(){
        boolean ret = false;
        try { ret =  in.available() >0; } catch (IOException noe){}
        return ret;
    }
    
    public void close() throws IOException{
        in.close();
    }
}
final class SWBcvsInputStream extends BufferedInputStream {

    static final byte CR = '\r';
    static final byte LF = '\n';
    static final int END_OF_FILE = -1;
    static final int NONE = -2;
    private int prevByte = NONE;
    
    private long position = 0;

    public SWBcvsInputStream(final InputStream in) {
        super(in);
    }

    public SWBcvsInputStream(final InputStream in, int size) {
        super(in, size);
    }

    @Override
    public int read() throws IOException {
        final int currByte = super.read();
        prevByte = currByte;
        position++;
        return prevByte;
    }

    int getPrevByte() {
        return prevByte;
    }

    @Override
    public int read(final byte[] buf, final int offset, final int length) throws IOException {
        if (length == 0) {
            return 0;
        }
        final int len = super.read(buf, offset, length);
        if (len > 0) {
            prevByte = buf[offset + len - 1];
            position += len;
        } else if (len == -1) {
            prevByte = END_OF_FILE;
        }
        return len;
    }

    public int whichNextbyte() throws IOException {
        super.mark(1);
        final int nextByte = super.read();
        super.reset();
        return nextByte;
    }
    
    public long getCurrentPosition(){
        return position;
    }
}
