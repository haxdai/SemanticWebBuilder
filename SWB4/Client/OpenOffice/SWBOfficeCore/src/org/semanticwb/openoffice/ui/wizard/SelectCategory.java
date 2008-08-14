/*
 * SelectCategory.java
 *
 * Created on 3 de junio de 2008, 11:03 AM
 */
package org.semanticwb.openoffice.ui.wizard;

import java.awt.Component;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeCellRenderer;
import org.netbeans.spi.wizard.Wizard;
import org.netbeans.spi.wizard.WizardPage;
import org.netbeans.spi.wizard.WizardPanelNavResult;
import org.semanticwb.openoffice.OfficeApplication;

/**
 *
 * @author  victor.lorenzana
 */
public class SelectCategory extends WizardPage
{

    /** Creates new form SelectCategory */
    public SelectCategory()
    {
        initComponents();
        loadTree();
        this.getWizardDataMap().put("categoryID",null);
        this.getWizardDataMap().put("repositoryName",null);
    }

    private void loadTree()
    {
        DefaultMutableTreeNode repositories = new DefaultMutableTreeNode("Repositorios");
        DefaultTreeModel model = new DefaultTreeModel(repositories);
        this.jTreeCategory.setModel(model);
        try
        {
            for ( String repository : OfficeApplication.getOfficeApplicationProxy().getRepositories() )
            {
                DefaultMutableTreeNode repositoryNode = new RepositoryNode(repository);
                model.insertNodeInto(repositoryNode, repositories, 0);
                for(String category : OfficeApplication.getOfficeApplicationProxy().getCategories(repository))
                {
                    String[] values=category.split("\\,");
                    DefaultMutableTreeNode categoryNode = new CategoryNode(values[0],values[1]);
                    model.insertNodeInto(categoryNode,repositoryNode, 0);
                }
            }
        }
        catch ( Exception wbe )
        {

        }
    }

    public static String getDescription()
    {
        return "Ubicación del contenido en el sitio";
    }

    @Override
    public WizardPanelNavResult allowNext(String arg, Map map, Wizard wizard)
    {
        WizardPanelNavResult result = WizardPanelNavResult.PROCEED;               
        if ( this.getWizardDataMap().get("categoryID") == null )
        {
            javax.swing.JOptionPane.showMessageDialog(null, "¡Debe seleccionar una categoria!", getDescription(), JOptionPane.ERROR_MESSAGE);
            this.jTreeCategory.requestFocus();
            result = WizardPanelNavResult.REMAIN_ON_PAGE;               
        }        
        return result;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTreeCategory = new javax.swing.JTree();

        setPreferredSize(new java.awt.Dimension(500, 322));
        setLayout(new java.awt.BorderLayout());

        jTreeCategory.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                jTreeCategoryValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jTreeCategory);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jTreeCategoryValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_jTreeCategoryValueChanged
        if(this.jTreeCategory.getSelectionPath().getLastPathComponent() instanceof CategoryNode)
        {
            String categoryID=((CategoryNode)this.jTreeCategory.getSelectionPath().getLastPathComponent()).getID();
            String repositoryName=((RepositoryNode)this.jTreeCategory.getSelectionPath().getParentPath().getLastPathComponent()).getName();
            this.getWizardDataMap().put("categoryID",categoryID );
            this.getWizardDataMap().put("repositoryName",repositoryName);
        }
        else
        {
            this.getWizardDataMap().put("categoryID",null);
            this.getWizardDataMap().put("repositoryName",null);
        }
    }//GEN-LAST:event_jTreeCategoryValueChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTree jTreeCategory;
    // End of variables declaration//GEN-END:variables
}

class RepositoryNode extends DefaultMutableTreeNode
{

    private JLabel component = new JLabel();
    private String name;

    public RepositoryNode(String name)
    {
        this.name = name;
        component.setText(name);
        component.setOpaque(true);
    }

    public String getName()
    {
        return name;
    }

    @Override
    public String toString()
    {
        this.hashCode();
        return name;
    }

    @Override
    public int hashCode()
    {
        return this.name.hashCode();
    }

    @Override
    public boolean equals(Object obj)
    {
        if ( obj instanceof RepositoryNode )
        {
            return (( RepositoryNode ) obj).name.equals(this.name);
        }
        return false;
    }

    public JLabel getComponent()
    {
        return component;
    }
}

class CategoryNode extends DefaultMutableTreeNode
{

    private JLabel component = new JLabel();
    private String id;
    private String title;

    public CategoryNode(String id, String title)
    {
        this.id = id;
        this.title = title;
        component.setText(title);
        component.setOpaque(true);
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
        if ( obj instanceof CategoryNode )
        {
            return (( CategoryNode ) obj).title.equals(this.title);
        }
        return false;
    }

    public String getID()
    {
        return id;
    }

    public JLabel getComponent()
    {
        return component;
    }
}

class TreeRender extends JPanel implements TreeCellRenderer
{

    public Component getTreeCellRendererComponent(JTree tree, Object object, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus)
    {
        Component component = this;
        if ( object instanceof CategoryNode )
        {
            component = (( CategoryNode ) object).getComponent();
            component.setFont(tree.getFont());
        }
        if ( object instanceof RepositoryNode )
        {
            component = (( RepositoryNode ) object).getComponent();
            component.setFont(tree.getFont());
        }
        if ( component != null )
        {
            if ( expanded )
            {
                ((JLabel)component).setIcon(new javax.swing.ImageIcon(getClass().getResource("./open.gif")));
            }
            else
            {
                ((JLabel)component).setIcon(new javax.swing.ImageIcon(getClass().getResource("./close.gif")));
            }            
        }
        return component;
    }
}
