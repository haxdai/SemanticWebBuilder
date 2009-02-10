/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SelectTitle.java
 *
 * Created on 10/02/2009, 03:26:06 PM
 */
package org.semanticwb.openoffice.ui.wizard;

import java.util.Map;
import javax.swing.JOptionPane;
import org.netbeans.spi.wizard.Wizard;
import org.netbeans.spi.wizard.WizardPage;
import org.netbeans.spi.wizard.WizardPanelNavResult;

/**
 *
 * @author victor.lorenzana
 */
public class SelectTitle extends WizardPage
{

    public static final String TITLE = "title";

    /** Creates new form SelectTitle */
    public SelectTitle()
    {
        initComponents();
    }

    public static String getDescription()
    {
        return "Seleccionar Título";
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextFieldTitle = new javax.swing.JTextField();

        jLabel1.setText("Títutlo:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jTextFieldTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(209, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextFieldTitle;
    // End of variables declaration//GEN-END:variables
    @Override
    public WizardPanelNavResult allowFinish(String arg, Map map, Wizard wizard)
    {
        return allowNext(arg, map, wizard);
    }

    @Override
    public WizardPanelNavResult allowNext(String arg, Map map, Wizard wizard)
    {
        WizardPanelNavResult result = WizardPanelNavResult.PROCEED;
        if(jTextFieldTitle.getText().isEmpty())
        {
            result = WizardPanelNavResult.REMAIN_ON_PAGE;
            JOptionPane.showMessageDialog(this, "¡Debe indicar el titulo!",getDescription(),JOptionPane.OK_OPTION | JOptionPane.ERROR_MESSAGE);
            jTextFieldTitle.requestFocus();
        }
        map.put(TITLE, this.jTextFieldTitle.getText());
        return result;
    }
}
