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

import com.infotec.csv.CSVFileParameters;
import java.io.File;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.semanticwb.Logger;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.GenericObject;

/**
 * Service to move Files to it's final destination, the destination path is set to 
 * /apps/dataLink but it can be redefined by setting the web.properties parameter
 * LODP/basePath
 * 
 * To use it invoke:
 * SenderService.getSender().submitFile2Send(fileToMove, relatedObject)
 * or
 * SenderService.getSender().submitCSVFile2Send(fileToMove, relatedObject, hasHeader, quoteChar, delChar, recordsPerPage)
 * 
 * both methods return a key which later can be used to ask what the result was with the method:
 * SenderService.getSender().getInfo(key)
 * 
 * which returns a {@link  com.infotec.filesender.TaskInfo  TaskInfo} Object with the result of the operation
 * 
 * @author serch
 */
public class SenderService {
    
    private static Logger log = SWBUtils.getLogger(SenderService.class);
    private static File basePath = null;

    private static SenderService instance = null;
    private ExecutorService senderService = null;
    private final HashMap<String, Future<TaskInfo>> wip;

    private SenderService() {
        wip = new HashMap<String, Future<TaskInfo>>();
    }

    /**
     * Get Access to the SenderService to submit a Task
     * @return 
     */
    public static synchronized SenderService getSender() {
        if (null == instance) {
            instance = new SenderService();
            instance.init();
        }
        return instance;
    }

    private void init() {
        senderService = Executors.newCachedThreadPool();
        basePath = new File (SWBPortal.getEnv("LODP/basePath", "/apps/dataLink"));
        
    }

    /**
     * Submits a regular file to be placed in the Delivery platform
     * @param file
     * @param object
     * @return the key to search for completed jobs
     */
    public String submitFile2Send(File file, GenericObject object) {
        if (file.exists() && null != object) {
            String key = UUID.randomUUID().toString();
            TaskInfo ti = new TaskInfo(file, object, basePath);
            Future<TaskInfo> taskFuture = senderService.submit(new SendFileTask(ti));
            wip.put(key, taskFuture);
            log.debug("SenderService.submitFile2Send: Task submited with key: "+key);
            return key;
        } else {
            log.debug("SenderService.submitFile2Send: The file "+file+" doesn't exists or the object is null");
            return null; //Error: no file to transmit or related object
        }
    }

    /**
     * Submits a CSV file to be placed in the Delivery platform
     * @param file
     * @param object
     * @param hasHeader
     * @param quote
     * @param delimiter
     * @param recordsPerPage
     * @return the key to search for completed jobs
     */
    public String submitCSVFile2Send(File file, GenericObject object, boolean hasHeader, char quote, char delimiter, int recordsPerPage) {
        if (file.exists() && null != object) {
            String key = UUID.randomUUID().toString();
            CSVFileParameters fp = new CSVFileParameters(file, hasHeader, quote, delimiter, recordsPerPage);
            TaskInfo ti = new TaskInfo(file, object, basePath, fp);
            Future<TaskInfo> taskFuture = senderService.submit(new SendFileTask(ti));
            wip.put(key, taskFuture);
            log.debug("SenderService.submitCSVFile2Send: Task submited with key: "+key);
            return key;
        } else {
            log.debug("SenderService.submitCSVFile2Send: The file "+file+" doesn't exists or the object is null");
            return null; //Error: no file to transmit or related object
        }
    }

    /**
     * Return returns a TaskInfo object if the task was completed or canceled, otherwise null
     * @param key key of the submitted task
     * @return The TaskInfo or return
     * @throws InterruptedException
     * @throws ExecutionException 
     */
    public TaskInfo getInfo(String key) throws InterruptedException, ExecutionException {
        Future result = wip.get(key);
        log.debug("SenderService.getInfo: The task is done:"+result.isDone()+ " is cancelled:"+result.isCancelled());
        if (result.isDone() || result.isCancelled()) {
            return wip.get(key).get();
        } else {
            log.debug("SenderService.getInfo: Nothing to report yet.");
            return null;
        }
    }
}
