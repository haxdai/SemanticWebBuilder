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
 * SelectTopic.java
 *
 * Created on 21 de febrero de 2002, 19:57
 */
package applets.mapsadm;

import java.util.*;
import javax.swing.*;
import javax.swing.DefaultListModel;

import applets.commons.*;
/**
 *
 * @author  Administrador
 */
public class SelectTopic extends javax.swing.JFrame {

    private Vector obj;
    private DefaultListModel list;
    private TMViewer applet;
    private TMWBAdmin admin;
    private AppObject actualchange;
    private Locale locale;
    
    /** Creates new form SelectTopic */
    public SelectTopic(Locale locale) {
        this.locale=locale;
        initComponents();
        this.setSize(350,350);
        this.move(400,400);
    }
    
    public SelectTopic(Vector obj, DefaultListModel list, Locale locale) {
        this(locale);
        this.obj=obj;
        applet=null;
        this.list=list;
        initTopics();
        setTitle(java.util.ResourceBundle.getBundle("applets/mapsadm/locale",locale).getString("frmSelect.title"));
    }    

    public SelectTopic(Vector obj, DefaultListModel list, AppObject actualchange, TMWBAdmin admin, Locale locale) {
        this(locale);
        this.obj=obj;
        this.admin=admin;
        applet=null;
        this.list=list;
        this.actualchange=actualchange;
        initTopics();
        setTitle(java.util.ResourceBundle.getBundle("applets/mapsadm/locale",locale).getString("frmSelect.title"));
    }    

    public SelectTopic(Vector obj, TMViewer applet, Locale locale) {
        this(locale);
        this.obj=obj;
        list=null;
        this.applet=applet;
        initTopics();
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        setTitle(java.util.ResourceBundle.getBundle("applets/mapsadm/locale",locale).getString("frmSelect.goto"));
    }    
    
    public void initTopics()
    {
        Enumeration en=obj.elements();
        while(en.hasMoreElements())
        {
            AppObject topic=(AppObject)en.nextElement();
            ((DefaultListModel)jList1.getModel()).addElement(topic);
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        
        setTitle(java.util.ResourceBundle.getBundle("applets/mapsadm/locale",locale).getString("frmSelect.title"));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });
        
        jList1.setModel(new DefaultListModel());
        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        
        jScrollPane1.setViewportView(jList1);
        
        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);
        
        jButton1.setText(java.util.ResourceBundle.getBundle("applets/mapsadm/locale",locale).getString("frmSelect.btn.accept"));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        
        jPanel1.add(jButton1);
        
        jButton2.setText(java.util.ResourceBundle.getBundle("applets/mapsadm/locale",locale).getString("CancelarfrmSelect.btn.cancel"));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        
        jPanel1.add(jButton2);
        
        getContentPane().add(jPanel1, java.awt.BorderLayout.SOUTH);
        
        pack();
    }//GEN-END:initComponents

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
        if(jList1.getSelectedIndices().length==1)jList1.ensureIndexIsVisible(jList1.getSelectedIndex());
    }//GEN-LAST:event_jList1ValueChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Add your handling code here:
        dispose();
        //System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Add your handling code here:
        if(list!=null)
        {
            int i[]=jList1.getSelectedIndices();
        
            for(int x=0;x<i.length;x++)
            {
                if(jList1.getModel().getElementAt(i[x])==actualchange || ((AppObject)jList1.getModel().getElementAt(i[x])).isChildof(actualchange))
                {
                    JOptionPane.showMessageDialog(this,java.util.ResourceBundle.getBundle("applets/mapsadm/locale",locale).getString("frmSelect.usrmsg.cyclic"),java.util.ResourceBundle.getBundle("applets/mapsadm/locale",locale).getString("frmSelect.usrmsg.addtype"),JOptionPane.ERROR_MESSAGE);
                    return;
                }
                else
                {
                    if(list.indexOf(jList1.getModel().getElementAt(i[x]))<0)
                    {                    
                        list.addElement(jList1.getModel().getElementAt(i[x]));
                        admin.setEditing(true,2);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this,java.util.ResourceBundle.getBundle("applets/mapsadm/locale",locale).getString("frmSelect.usrmsg.alreadyType"),java.util.ResourceBundle.getBundle("applets/mapsadm/locale",locale).getString("frmSelect.usrmsg.addtype"),JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
            }
            dispose();
        }
        else
        {
            applet.setActual(((AppObject)jList1.getModel().getElementAt(jList1.getSelectedIndex())).id);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /** Exit the Application */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        dispose();
        //System.exit(0);
    }//GEN-LAST:event_exitForm

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        new SelectTopic(Locale.getDefault()).show();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    // End of variables declaration//GEN-END:variables

}
