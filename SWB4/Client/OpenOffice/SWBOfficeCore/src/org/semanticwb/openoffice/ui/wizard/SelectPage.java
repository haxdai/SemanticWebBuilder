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
 * SelectPage.java
 *
 * Created on 26 de diciembre de 2008, 07:11 PM
 */
package org.semanticwb.openoffice.ui.wizard;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultTreeSelectionModel;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import org.netbeans.spi.wizard.Wizard;
import org.netbeans.spi.wizard.WizardPage;
import org.netbeans.spi.wizard.WizardPanelNavResult;
import org.semanticwb.office.interfaces.WebPageInfo;
import org.semanticwb.office.interfaces.WebSiteInfo;
import org.semanticwb.openoffice.OfficeApplication;

/**
 *
 * @author  victor.lorenzana
 */
public class SelectPage extends WizardPage
{

    public static final String WEBPAGE = "WEBPAGE";
    String siteId;

    /** Creates new form SelectPage */
    public SelectPage()
    {
        initComponents();
        DefaultTreeSelectionModel selectionModel = new DefaultTreeSelectionModel();
        selectionModel.setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        jTreeSite.setSelectionModel(selectionModel);        
        loadTree();
        jTreeSite.setRootVisible(false);
    }

    @Override
    public WizardPanelNavResult allowFinish(String stepName, Map map, Wizard wizard)
    {
        return this.allowNext(stepName, map, wizard);
    }

    @Override
    public WizardPanelNavResult allowNext(String stepName, Map map, Wizard wizard)
    {
        WizardPanelNavResult res=WizardPanelNavResult.PROCEED;
        if(map.get(WEBPAGE)==null)
        {
            res=WizardPanelNavResult.REMAIN_ON_PAGE;
            JOptionPane.showMessageDialog(this, "¡Debe indicar una página web!", getDescription(), JOptionPane.OK_OPTION | JOptionPane.ERROR_MESSAGE);
            this.jTreeSite.requestFocus();
        }
        return res;
    }

   

    public SelectPage(String siteId)
    {
        this();
        this.siteId = siteId;
    }

    class TreeRender extends JPanel implements TreeCellRenderer
    {

        public Component getTreeCellRendererComponent(JTree tree, Object object, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus)
        {
            Component component = this;
            tree.setToolTipText("");
            if (object instanceof Site)
            {
                component = ((Site) object).getComponent();
                if (hasFocus)
                {
                    //tree.setToolTipText(((Site) object).);
                }
            }
            if (object instanceof WebPage)
            {
                component = ((WebPage) object).getComponent();
                if (hasFocus)
                {
                    tree.setToolTipText(((WebPage) object).description);
                }
            }
            if (component != null && component instanceof JLabel)
            {
                JLabel label = (JLabel) component;

                label.setFont(tree.getFont());
                if (object instanceof WebPage)
                {
                    if (object instanceof HomeWebPage)
                    {
                        HomeWebPage homeWebPage=(HomeWebPage)object;
                        if(homeWebPage.isActive())
                        {
                            label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/semanticwb/openoffice/ui/icons/home.png")));
                        }
                        else
                        {
                            label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/semanticwb/openoffice/ui/icons/home_deactivated.png")));
                        }
                    }
                    else
                    {
                        WebPage page=(WebPage)object;
                        if(page.isActive())
                        {
                            label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/semanticwb/openoffice/ui/icons/page.png")));
                        }
                        else
                        {
                            label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/semanticwb/openoffice/ui/icons/pag_deactivated.png")));
                        }
                    }
                }
                else
                {
                    label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/semanticwb/openoffice/ui/icons/site.png")));
                }
                if (expanded)
                {
                }
                else
                {
                }
                if (selected)
                {
                    label.setBackground(Color.BLUE);
                    label.setForeground(Color.WHITE);
                }
                else
                {
                    label.setBackground(tree.getBackground());
                    label.setForeground(tree.getForeground());
                }
            }
            return component;

        }
    }

    private void loadTree()
    {
        this.jTreeSite.setCellRenderer(new TreeRender());
        this.jTreeSite.setEditable(false);
        Root root = new Root("", "Sitios");
        DefaultTreeModel model = new DefaultTreeModel(root);
        model.setRoot(root);
        this.jTreeSite.setModel(model);


        try
        {
            for (WebSiteInfo website : OfficeApplication.getOfficeApplicationProxy().getSites())
            {
                if (siteId == null)
                {
                    Site site = new Site(website.id, website.title);
                    model.insertNodeInto(site, root, 0);                    
                    WebPageInfo home = OfficeApplication.getOfficeApplicationProxy().getHomePage(website);
                    HomeWebPage child = new HomeWebPage(home.id, home.title, home.description, website.id, home.url,home.active);
                    site.add(child);
                    if (home.childs > 0)
                    {
                        DefaultMutableTreeNode dummy = new DefaultMutableTreeNode();
                        child.add(dummy);
                    }
                    TreeNode[] path=site.getPath();
                    jTreeSite.expandPath(new TreePath(path));
                }
                else
                {
                    if (siteId.equals(website.id))
                    {
                        Site site = new Site(website.id, website.title);
                        model.insertNodeInto(site, root, 0);                        
                        WebPageInfo home = OfficeApplication.getOfficeApplicationProxy().getHomePage(website);
                        HomeWebPage child = new HomeWebPage(home.id, home.title, home.description, website.id, home.url,home.active);
                        site.add(child);
                        if (home.childs > 0)
                        {
                            DefaultMutableTreeNode dummy = new DefaultMutableTreeNode();
                            child.add(dummy);
                        }
                        TreeNode[] path=site.getPath();
                        jTreeSite.expandPath(new TreePath(path));
                    }
                }

            }
        }
        catch (Exception wbe)
        {
            String message = wbe.getLocalizedMessage();
            if (wbe.getCause() != null)
            {
                Throwable cause = wbe.getCause();
                message += "\r\n" + cause.getMessage();
            }
            JOptionPane.showMessageDialog(this, message, getDescription(), JOptionPane.OK_OPTION);
            this.setProblem(message);
            return;
        }
        jTreeSite.expandPath(new TreePath(root.getPath()));
    }

    private void addWebPage(WebPage nodeParent)
    {
        try
        {
            WebPageInfo parent = new WebPageInfo();
            parent.id = nodeParent.id;
            parent.siteID = nodeParent.webSite;
            for (WebPageInfo webpage : OfficeApplication.getOfficeApplicationProxy().getPages(parent))
            {
                WebPage child = new WebPage(webpage.id, webpage.title, webpage.description, webpage.siteID, webpage.url,webpage.active);
                nodeParent.add(child);
                if (webpage.childs > 0)
                {
                    DefaultMutableTreeNode dummy = new DefaultMutableTreeNode();
                    child.add(dummy);
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static String getDescription()
    {
        return "Seleccionar Página";
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTreeSite = new javax.swing.JTree();
        jPanel1 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jButtonAddPage = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(500, 322));
        setLayout(new java.awt.BorderLayout());

        jTreeSite.setRowHeight(20);
        jTreeSite.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                jTreeSiteValueChanged(evt);
            }
        });
        jTreeSite.addTreeWillExpandListener(new javax.swing.event.TreeWillExpandListener() {
            public void treeWillCollapse(javax.swing.event.TreeExpansionEvent evt)throws javax.swing.tree.ExpandVetoException {
            }
            public void treeWillExpand(javax.swing.event.TreeExpansionEvent evt)throws javax.swing.tree.ExpandVetoException {
                jTreeSiteTreeWillExpand(evt);
            }
        });
        jScrollPane1.setViewportView(jTreeSite);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.setMinimumSize(new java.awt.Dimension(50, 100));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jButtonAddPage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/semanticwb/openoffice/ui/icons/icon_agregarpag.png"))); // NOI18N
        jButtonAddPage.setToolTipText("Agregar página al sitio web");
        jButtonAddPage.setEnabled(false);
        jButtonAddPage.setFocusable(false);
        jButtonAddPage.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonAddPage.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonAddPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddPageActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonAddPage);

        jPanel1.add(jToolBar1);

        add(jPanel1, java.awt.BorderLayout.NORTH);
    }// </editor-fold>//GEN-END:initComponents

private void jTreeSiteValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_jTreeSiteValueChanged
    this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
    Object selected = this.jTreeSite.getLastSelectedPathComponent();
    this.getWizardDataMap().put(WEBPAGE, null);
    if (selected != null && selected instanceof Site)
    {
        if (selected instanceof Root)
        {
            this.jButtonAddPage.setEnabled(false);
        }
        else
        {

            Site rep = (Site) selected;
            if (rep.getChildCount() == 0)
            {
                JOptionPane.showMessageDialog(this, "¡No existen páginas en este sitio!\r\nDebe crear una pagina para poder publicar el contenido", getDescription(), JOptionPane.ERROR_MESSAGE);
            }
            this.jButtonAddPage.setEnabled(true);
        }
    }
    this.jButtonAddPage.setEnabled(false);
    if (selected != null && selected instanceof WebPage)
    {
        WebPage siteNode = (WebPage) selected;
        this.getWizardDataMap().put(WEBPAGE, siteNode);
        this.jButtonAddPage.setEnabled(true);
    }
    this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
}//GEN-LAST:event_jTreeSiteValueChanged

private void jButtonAddPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddPageActionPerformed
    Object selected = this.jTreeSite.getSelectionPath().getLastPathComponent();
    if (selected != null && selected instanceof WebPage)
    {
        boolean isExpanded = jTreeSite.isExpanded(this.jTreeSite.getSelectionPath());
        WebPage siteNode = (WebPage) selected;
        WebPageInfo info = new WebPageInfo();
        info.id = siteNode.id;
        info.siteID = siteNode.webSite;
        OfficeApplication.createPage(info);
        siteNode.removeAllChildren();
        info.title = siteNode.title;
        info.description = siteNode.description;
        addWebPage(siteNode);
        if (isExpanded)
        {
            jTreeSite.expandPath(this.jTreeSite.getSelectionPath());
        }
    }
}//GEN-LAST:event_jButtonAddPageActionPerformed

private void jTreeSiteTreeWillExpand(javax.swing.event.TreeExpansionEvent evt)throws javax.swing.tree.ExpandVetoException//GEN-FIRST:event_jTreeSiteTreeWillExpand
{//GEN-HEADEREND:event_jTreeSiteTreeWillExpand
    Object selected = evt.getPath().getLastPathComponent();
    if (selected instanceof WebPage && ((WebPage) selected).getChildCount() == 1 && !(((WebPage) selected).getChildAt(0) instanceof WebPage))
    {
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        WebPage node = (WebPage) selected;
        node.removeAllChildren();
        addWebPage(node);
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }
}//GEN-LAST:event_jTreeSiteTreeWillExpand

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddPage;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTree jTreeSite;
    // End of variables declaration//GEN-END:variables

    interface ToolTipTreeNode
    {

        public String getToolTipText();
    }

    class Root extends Site
    {

        public Root(String id, String title)
        {
            super(id, title);
        }
        

        @Override
        public boolean isRoot()
        {
            return true;
        }
    }

    

    class Site extends DefaultMutableTreeNode implements ToolTipTreeNode
    {

        private JLabel component = new JLabel();

        @Override
        public boolean isRoot()
        {
            return false;
        }

        
        private String id;
        private String title;

        public Site(String id, String title)
        {
            this.id = id;
            this.title = title;
            component.setText(title);
            component.setOpaque(true);
        }

        public String getToolTipText()
        {
            return this.title;
        }

        @Override
        public String toString()
        {
            return title;
        }

        @Override
        public int hashCode()
        {
            return this.id.hashCode();
        }

        @Override
        public boolean equals(Object obj)
        {
            boolean equals = false;
            if (obj instanceof Site)
            {
                equals = ((Site) obj).id.equals(this.id);
            }
            return equals;
        }

        public JLabel getComponent()
        {
            return component;
        }
    }

    public class HomeWebPage extends WebPage
    {

        public HomeWebPage(String id, String title, String description, String webSite, String url,boolean active)
        {
            super(id, title, description, webSite, url,active);
        }
    }

    public class WebPage extends DefaultMutableTreeNode implements ToolTipTreeNode
    {

        private JLabel component = new JLabel();
        private String id;
        private String title;
        private String description;
        private String webSite;
        private String url;
        private boolean active;
        public WebPage(String id, String title, String description, String webSite, String url,boolean active)
        {
            this.id = id;
            this.title = title;
            this.description = description;
            this.webSite = webSite;
            this.url = url;
            this.active=active;
            component.setText(title);
            component.setToolTipText(description);
            component.setOpaque(true);
        }
        public boolean isActive()
        {
            return active;
        }

        public String getURL()
        {
            return url;
        }

        public String getSite()
        {
            return this.webSite;
        }

        public String getToolTipText()
        {
            return description;
        }

        @Override
        public String toString()
        {
            this.hashCode();
            return title;
        }

        @Override
        public int hashCode()
        {
            return this.title.hashCode();
        }

        @Override
        public boolean equals(Object obj)
        {
            boolean equals = false;
            if (obj instanceof WebPage)
            {
                equals = ((WebPage) obj).title.equals(this.title);
            }
            return equals;
        }

        public String getID()
        {
            return id;
        }

        public String getDescription()
        {
            return this.description;
        }

        public JLabel getComponent()
        {
            return component;
        }

        

        @Override
        public boolean isRoot()
        {
            return false;
        }
    }
}
