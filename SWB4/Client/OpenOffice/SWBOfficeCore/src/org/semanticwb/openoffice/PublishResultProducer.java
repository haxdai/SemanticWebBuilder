/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.semanticwb.openoffice;

import java.awt.EventQueue;
import java.io.File;
import java.util.Map;
import org.netbeans.spi.wizard.DeferredWizardResult;
import org.netbeans.spi.wizard.ResultProgressHandle;
import org.netbeans.spi.wizard.Summary;
import org.netbeans.spi.wizard.WizardException;
import org.netbeans.spi.wizard.WizardPage.WizardResultProducer;
import org.semanticwb.openoffice.interfaces.IOpenOfficeDocument;
import org.semanticwb.openoffice.ui.wizard.SummaryPublish;
import org.semanticwb.xmlrpc.Attachment;


/**
 *
 * @author victor.lorenzana
 */
public class PublishResultProducer implements WizardResultProducer
{

    private OfficeDocument document;

    public PublishResultProducer(OfficeDocument document)
    {
        this.document = document;
    }

    class BackgroundResultCreator extends DeferredWizardResult
    {

        public void start(Map wizardData, ResultProgressHandle progress)
        {
            assert !EventQueue.isDispatchThread();
            File zipFile=null;
            try
            {
                progress.setProgress("Preparando documento para publicar", 0, 2);
                zipFile=document.createZipFile();                                
                progress.setProgress("Publicando Documento", 1, 2);
                IOpenOfficeDocument openOfficeDocument=document.getOfficeDocumentProxy();
                openOfficeDocument.addAttachment(new Attachment(zipFile, zipFile.getName()));                                
                String title=wizardData.get("title").toString();
                String description=wizardData.get("description").toString();
                String path=wizardData.get("path").toString();                
                int contentID=openOfficeDocument.publish(title, description, path);
                document.SaveContentId(contentID);                
                Summary summary=Summary.create(new SummaryPublish(),null);               
                progress.finished(summary);
            }           
            catch (Exception e)
            {
                progress.failed(e.getMessage(), false);
            }
            finally
            {                
                if(zipFile!=null && zipFile.exists())
                {
                    document.deleteTemporalDirectory(zipFile.getParentFile());                
                }
            }
        }
    }

    public boolean cancel(Map map)
    {        
//        boolean dialogShouldClose = JOptionPane.showConfirmDialog(null,
//                "¿Desea cerrar el asistente de publicación de contenido?","Asistente de Publicación",JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION;
//        return dialogShouldClose;
        return true;
    }

    public Object finish(Map map) throws WizardException
    {
        return new BackgroundResultCreator();
    }
}
