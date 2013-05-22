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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;

/**
 *
 * @author serch
 */
public class CSVFileSplitter {
    
    private static Logger log = SWBUtils.getLogger(CSVFileSplitter.class);
    private boolean flag = false;
    private ArrayList<Long> list = new ArrayList<Long>();
    private long last_val = 0;
    private int file_num = 0;
    private boolean hasHeader = false;
    private final CSVFileParameters parameters;
    private final CSVFileParser csv;
    private final File destPath;

    public CSVFileSplitter(CSVFileParameters parameters, File destPath) throws IOException { 
        this.parameters = parameters;
        this.csv = new CSVFileParser(this.parameters);
        this.hasHeader = parameters.hasHeader();
        this.destPath = destPath;
    }

    public ArrayList<Long> split() throws IOException {
        if (!flag) {
            if (hasHeader) {
                list.add(csv.getCurrentPosition());
            } else {
                file_num++;
            }
            while (csv.hasData()) {
                for (int i = 0; i < parameters.getRecordsPerFile(); i++) {
                    if (!csv.hasData()) {
                        break;
                    }
                    csv.getNextRecord();
                }
                if (csv.hasData()) {
                    list.add(csv.getCurrentPosition());
                }
            }
            csv.close();
            try {
                BufferedInputStream in = new BufferedInputStream(new FileInputStream(parameters.getFile()));
                for (Long curr : list) {
                    FileOutputStream fos = new FileOutputStream(destPath + parameters.getFile().getName() + "_" + file_num);
                    fillFile(fos, in, last_val, curr);
                    fos.flush();
                    fos.close();
                    file_num++;
                    last_val = curr;
                }
                if (last_val < parameters.getFile().length()) {
                    FileOutputStream fos = new FileOutputStream(destPath + parameters.getFile().getName() + "_" + file_num);
                    fillFile(fos, in, last_val, parameters.getFile().length());
                    fos.flush();
                    fos.close();
                }
                in.close();
                PrintWriter pw = new PrintWriter(destPath + parameters.getFile().getName()+"_idx");
                pw.println(parameters.getFile().getCanonicalPath());
                pw.println(""+parameters.getRecordsPerFile());
                pw.println(""+hasHeader);
                
                for (Long curr: list){
                    pw.println(""+curr);
                }
                pw.flush();
                pw.close();
            } catch (IOException ioe) {
                log.error("While trying to splitt a CSV File: "+ioe.getMessage()
                        , ioe);
            }
        } else {
            throw new IllegalStateException("File Already Splitted");
        }
        return list;
    }

    private void fillFile(FileOutputStream fos, BufferedInputStream in,
            long val_ant, Long curr) throws IOException {
        byte[] buffer = new byte[8192];
        long diff = curr - val_ant;
        while (diff > 0) {
            int read;
            if (diff >= buffer.length) {
                read = in.read(buffer);
            } else {
                read = in.read(buffer, 0, (int) diff);
            }
            fos.write(buffer, 0, read);
            diff -= read;
        }
    }
}
