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
import org.semanticwb.model.GenericObject;

/**
 *
 * @author serch
 */
public class TaskInfo {
    
    private final File fileToSend;
    private final GenericObject relatedObject;
    private final CSVFileParameters fileParameters;
    private boolean filesTransfered=false;
    private String resultMessage="";
    private Exception errorException=null;
    private final File base;

    public TaskInfo(File fileToSend, GenericObject relatedObject, File file,CSVFileParameters fileParameters) {
        this.fileToSend = fileToSend;
        this.relatedObject = relatedObject;
        this.fileParameters = fileParameters;
        this.base = file;
    }
    
    public TaskInfo(File fileToSend, GenericObject relatedObject, File file) {
        this.fileToSend = fileToSend;
        this.relatedObject = relatedObject;
        this.fileParameters = null;
        this.base = file;
    }

    public boolean isFilesTransfered() {
        return filesTransfered;
    }

    public void setFilesTransfered(boolean filesTransfered) {
        this.filesTransfered = filesTransfered;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public Exception getErrorException() {
        return errorException;
    }

    public void setErrorException(Exception errorException) {
        this.errorException = errorException;
    }

    public File getFileToSend() {
        return fileToSend;
    }

    public GenericObject getRelatedObject() {
        return relatedObject;
    }

    public CSVFileParameters getFileParameters() {
        return fileParameters;
    }

    public File getBase() {
        return base;
    }
    
}
