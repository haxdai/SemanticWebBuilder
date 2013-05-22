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
package com.infotec.filesender;

import com.infotec.csv.CSVFileSplitter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.concurrent.Callable;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;

/**
 *
 * @author serch
 */
public class SendFileTask implements Callable<TaskInfo> {

    private static Logger log = SWBUtils.getLogger(SendFileTask.class);
    private final TaskInfo ti;

    SendFileTask(TaskInfo ti) {
        this.ti = ti;
    }

    @Override
    public TaskInfo call() throws Exception {
        try {
            String dir = ti.getRelatedObject().getSemanticObject().
                    getSemanticClass().getClassCodeName() + ti.getRelatedObject().getId();
            File path = new File(ti.getBase(), dir);
            if (!path.exists()) {
                path.mkdirs();
            }

            if (ti.getFileParameters() != null) {
                log.debug("SendFileTask: Processing CSV file");
                CSVFileSplitter csvfs = new CSVFileSplitter(ti.getFileParameters(), path);
                csvfs.split();
                log.debug("SendFileTask: CSV file processed");
                ti.setResultMessage("The CSV was proceced and stored. ");
            } else {
                File dest = new File(path, ti.getFileToSend().getName());
                FileInputStream fis = new FileInputStream(ti.getFileToSend());
                FileOutputStream fos = new FileOutputStream(dest);
                byte[] buffer = new byte[8192];
                int readbytes = 0;
                while ((readbytes = fis.read(buffer)) > -1) {
                    fos.write(buffer, 0, readbytes);
                }
                fis.close();
                fos.flush();
                fos.close();
            }
            ti.getFileToSend().delete();
            ti.setResultMessage(ti.getResultMessage() + "The original file was deleted. ");
            log.debug("SendFileTask: Original file deleted");
        } catch (Exception ex) {
            ti.setErrorException(ex);
            ti.setResultMessage(ti.getResultMessage() + "error: " + ex.getLocalizedMessage());
            ti.setFilesTransfered(false);
            log.debug("SendFileTask: Error detected", ex);
        }

        ti.setFilesTransfered(true);
        return ti;
    }
}
