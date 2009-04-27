/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.openoffice;

import java.net.URI;
import java.util.Map;
import javax.swing.JOptionPane;
import org.netbeans.spi.wizard.WizardException;
import org.netbeans.spi.wizard.WizardPage.WizardResultProducer;
import org.semanticwb.openoffice.ui.wizard.SelectPage;
import org.semanticwb.openoffice.ui.wizard.SelectTitle;

/**
 *
 * @author victor.lorenzana
 */
public class AddLinkProducer implements WizardResultProducer {

    private OfficeDocument document;
    public AddLinkProducer(OfficeDocument document)
    {
        this.document = document;
    }
    public boolean cancel(Map map)
    {
        
        return true;
    }

    public Object finish(Map map) throws WizardException
    {
        SelectPage.WebPage page=(SelectPage.WebPage)map.get(SelectPage.WEBPAGE);
        try
        {
            URI uri=document.getOfficeDocumentProxy().getWebAddress();
            String url=uri.getScheme()+"://"+uri.getHost()+":"+uri.getPort()+""+page.getURL();
            String title=map.get(SelectTitle.TITLE).toString();
            document.insertLink(url, title);
            JOptionPane.showMessageDialog(null, "Liga a la página "+ page.toString() +" insertada con éxito","Inserción liga de página",JOptionPane.OK_OPTION | JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
