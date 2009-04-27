/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.semanticwb.openoffice;

import java.awt.EventQueue;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import org.netbeans.spi.wizard.DeferredWizardResult;
import org.netbeans.spi.wizard.ResultProgressHandle;
import org.netbeans.spi.wizard.Summary;
import org.netbeans.spi.wizard.WizardException;
import org.netbeans.spi.wizard.WizardPage.WizardResultProducer;
import org.semanticwb.office.interfaces.PropertyInfo;
import org.semanticwb.office.interfaces.RepositoryInfo;
import org.semanticwb.openoffice.interfaces.IOpenOfficeDocument;
import org.semanticwb.openoffice.ui.wizard.ContentProperties;
import org.semanticwb.openoffice.ui.wizard.SelectCategory;
import org.semanticwb.openoffice.ui.wizard.SummaryPublish;
import org.semanticwb.openoffice.ui.wizard.TitleAndDescription;
import org.semanticwb.openoffice.util.StackTraceUtil;
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
        @Override
        public void start(Map wizardData, ResultProgressHandle progress)
        {
            assert !EventQueue.isDispatchThread();
            File zipFile = null;
            try
            {
                progress.setProgress("Preparando documento para guardar...", 0, 2);
                zipFile = document.createZipFile();
                progress.setProgress("Guardando Documento...", 1, 2);
                IOpenOfficeDocument openOfficeDocument = document.getOfficeDocumentProxy();
                openOfficeDocument.addAttachment(new Attachment(zipFile));
                String title = wizardData.get(TitleAndDescription.TITLE).toString();
                String description = wizardData.get(TitleAndDescription.DESCRIPTION).toString();
                String categoryID = wizardData.get(SelectCategory.CATEGORY_ID).toString();
                String repositoryName = wizardData.get(SelectCategory.REPOSITORY_ID).toString();
                RepositoryInfo info=(RepositoryInfo)wizardData.get(SelectCategory.REPOSITORY_ID);
                String nodeType = wizardData.get(TitleAndDescription.NODE_TYPE).toString();
                String name = document.getLocalPath().getName().replace(document.getDefaultExtension(), document.getPublicationExtension());
                HashMap<PropertyInfo, String> properties=(HashMap<PropertyInfo, String>)wizardData.get(ContentProperties.CONTENT_PROPERTIES);
                PropertyInfo[] propsToSave=properties.keySet().toArray(new PropertyInfo[properties.keySet().size()]);
                String[] values=properties.values().toArray(new String[properties.values().size()]);
                String contentID = openOfficeDocument.save(title, description, repositoryName, categoryID, document.getDocumentType().toString(), nodeType, name,propsToSave,values);
                document.deleteAssociation(false);
                document.saveContentId(contentID, repositoryName);
                int res = JOptionPane.showConfirmDialog(null, "¿Desea publicar este contenido en una página web?", "Publicación de contenido", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                if (res == JOptionPane.YES_OPTION)
                {
                    if(info.exclusive && info.siteInfo!=null)
                    {
                        document.publish(title,description,info.siteInfo.id);
                    }
                    else
                    {
                        document.publish(title,description,null);
                    }
                }
                Summary summary = Summary.create(new SummaryPublish(contentID, repositoryName), null);
                progress.finished(summary);
            }
            catch (Exception e)
            {
                progress.failed(e.getMessage()+"\r\n"+StackTraceUtil.getStackTrace(e), false);
            }
            finally
            {
                if (zipFile != null && zipFile.exists())
                {
                    zipFile.delete();
                }
            }
        }
    }
    @Override
    public boolean cancel(Map map)
    {
        return true;
    }
    @Override
    public Object finish(Map map) throws WizardException
    {
        return new BackgroundResultCreator();
    }
}
