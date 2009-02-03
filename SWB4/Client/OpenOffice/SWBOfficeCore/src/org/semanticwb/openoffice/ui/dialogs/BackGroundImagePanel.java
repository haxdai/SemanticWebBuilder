/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * BackGroundImagePanel.java
 *
 * Created on 14/01/2009, 12:49:43 PM
 */
package org.semanticwb.openoffice.ui.dialogs;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.semanticwb.openoffice.ConfigurationListURI;
import org.semanticwb.openoffice.ui.icons.ImageLoader;

/**
 *
 * @author victor.lorenzana
 */
public class BackGroundImagePanel extends javax.swing.JPanel implements WindowFocusListener
{

    private int numTry = 0;        
    ConfigurationListURI configurationListURI = new ConfigurationListURI();
    private Image imgFondo;
    private DialogLogin parent;
    /** Creates new form BackGroundImagePanel */
    public BackGroundImagePanel(DialogLogin parent)
    {
        this.parent=parent;
        parent.addWindowFocusListener(this);
        preInit();
        initComponents();
        this.jComboBoxWebAddress.removeAllItems();
        for (URI uri : configurationListURI.getAddresses())
        {
            this.jComboBoxWebAddress.addItem(uri);
        }
        if (this.jComboBoxWebAddress.getSelectedItem() == null)
        {
            this.jComboBoxWebAddress.requestFocus();
        }
        else
        {
            if (this.jTextFieldClave.getText().equals(""))
            {
                this.jTextFieldClave.requestFocus();
            }
            else
            {
                this.jPassword.requestFocus();
            }
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelPassword = new javax.swing.JLabel();
        jLabelWebAddress = new javax.swing.JLabel();
        jLabelClave = new javax.swing.JLabel();
        jTextFieldClave = new javax.swing.JTextField();
        jPassword = new javax.swing.JPasswordField();
        jComboBoxWebAddress = new javax.swing.JComboBox();
        jButtonAvanced = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jButtonAccept = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();

        setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        setPreferredSize(new java.awt.Dimension(500, 310));
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });

        jLabelPassword.setFont(new java.awt.Font("Verdana", 1, 14));
        jLabelPassword.setForeground(new java.awt.Color(51, 102, 153));
        jLabelPassword.setLabelFor(jPassword);
        jLabelPassword.setText("Contraseña:");

        jLabelWebAddress.setFont(new java.awt.Font("Verdana", 1, 14));
        jLabelWebAddress.setForeground(new java.awt.Color(51, 102, 153));
        jLabelWebAddress.setLabelFor(jComboBoxWebAddress);
        jLabelWebAddress.setText("Sitio:");

        jLabelClave.setFont(new java.awt.Font("Verdana", 1, 14));
        jLabelClave.setForeground(new java.awt.Color(51, 102, 153));
        jLabelClave.setLabelFor(jTextFieldClave);
        jLabelClave.setText("Clave:");

        jTextFieldClave.setFont(new java.awt.Font("Tahoma", 0, 14));

        jPassword.setFont(new java.awt.Font("Tahoma", 0, 14));

        jComboBoxWebAddress.setEditable(true);
        jComboBoxWebAddress.setFont(new java.awt.Font("Tahoma", 0, 14));
        jComboBoxWebAddress.setAutoscrolls(true);
        jComboBoxWebAddress.setName("WebAddress"); // NOI18N
        jComboBoxWebAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxWebAddressActionPerformed(evt);
            }
        });

        jButtonAvanced.setBackground(new java.awt.Color(51, 102, 153));
        jButtonAvanced.setFont(new java.awt.Font("Tahoma", 0, 14));
        jButtonAvanced.setText("Avanzado");
        jButtonAvanced.setToolTipText("Configuración de Proxy");
        jButtonAvanced.setBorder(null);
        jButtonAvanced.setBorderPainted(false);
        jButtonAvanced.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAvancedActionPerformed(evt);
            }
        });

        jButtonCancel.setBackground(new java.awt.Color(51, 102, 153));
        jButtonCancel.setFont(new java.awt.Font("Tahoma", 0, 14));
        jButtonCancel.setText("Cancelar");
        jButtonCancel.setBorder(null);
        jButtonCancel.setBorderPainted(false);
        jButtonCancel.setDoubleBuffered(true);
        jButtonCancel.setMargin(new java.awt.Insets(0, 14, 2, 14));
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        jButtonAccept.setBackground(new java.awt.Color(51, 102, 153));
        jButtonAccept.setFont(new java.awt.Font("Tahoma", 0, 14));
        jButtonAccept.setText("Aceptar");
        jButtonAccept.setBorder(null);
        jButtonAccept.setBorderPainted(false);
        jButtonAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAcceptActionPerformed(evt);
            }
        });

        jButtonDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/semanticwb/openoffice/ui/icons/delete32.png"))); // NOI18N
        jButtonDelete.setToolTipText("Borrar conexión");
        jButtonDelete.setContentAreaFilled(false);
        jButtonDelete.setEnabled(false);
        jButtonDelete.setFocusPainted(false);
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelClave)
                    .addComponent(jLabelWebAddress)
                    .addComponent(jLabelPassword))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonAvanced, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(jButtonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jButtonAccept, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxWebAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                    .addComponent(jTextFieldClave, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE))
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxWebAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelWebAddress))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonDelete, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelClave))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAccept, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(jButtonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAvanced, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(158, 158, 158))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxWebAddressActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jComboBoxWebAddressActionPerformed
    {//GEN-HEADEREND:event_jComboBoxWebAddressActionPerformed
        this.jButtonDelete.setEnabled(false);
        if (this.jComboBoxWebAddress.getSelectedItem() != null)
        {
            this.jButtonDelete.setEnabled(true);
            String sUri = this.jComboBoxWebAddress.getSelectedItem().toString();
            try
            {
                URI uri = new URI(sUri);
                this.jTextFieldClave.setText(configurationListURI.getLogin(uri));
            }
            catch (URISyntaxException use)
            {
                JOptionPane.showMessageDialog(this, "Error al escribir la dirección web", "", JOptionPane.ERROR);
            }
        }
}//GEN-LAST:event_jComboBoxWebAddressActionPerformed

    private void jButtonAvancedActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonAvancedActionPerformed
    {//GEN-HEADEREND:event_jButtonAvancedActionPerformed
        DialogConfigProxy dialogConfigProxy = new DialogConfigProxy(new JFrame(), true);
        dialogConfigProxy.setLocationRelativeTo(this);
        dialogConfigProxy.setVisible(true);
}//GEN-LAST:event_jButtonAvancedActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonCancelActionPerformed
    {//GEN-HEADEREND:event_jButtonCancelActionPerformed
        parent.setVisible(false);
        parent.canceled = true;
}//GEN-LAST:event_jButtonCancelActionPerformed

    private void jButtonAcceptActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonAcceptActionPerformed
    {//GEN-HEADEREND:event_jButtonAcceptActionPerformed

        numTry++;
        if (numTry < 3)
        {
            if (this.jComboBoxWebAddress.getSelectedItem() != null)
            {
                String sUri = this.jComboBoxWebAddress.getSelectedItem().toString();
                try
                {
                    URI uri = new URI(sUri);
                    if (this.jTextFieldClave.getText().isEmpty())
                    {
                        JOptionPane.showMessageDialog(this, "Debe indicar la clave de acceso", "", JOptionPane.ERROR_MESSAGE);
                        this.jTextFieldClave.requestFocus();
                        return;
                    }
                    if (this.jPassword.getPassword().length == 0)
                    {
                        JOptionPane.showMessageDialog(this, "Debe indicar la contraseña de acceso", "", JOptionPane.ERROR_MESSAGE);
                        this.jPassword.requestFocus();
                        return;
                    }
                    configurationListURI.addUserConfiguration(uri, this.jTextFieldClave.getText());
                    parent.webAddress = uri;
                    parent.login = this.jTextFieldClave.getText();
                    parent.password = new String(this.jPassword.getPassword());
                    parent.setVisible(false);
                    parent.canceled = false;
                }
                catch (URISyntaxException use)
                {
                    JOptionPane.showMessageDialog(null, "La dirección Web no es válida", "", JOptionPane.ERROR_MESSAGE);
                    this.jComboBoxWebAddress.requestFocus();
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Debe indicar una dirección Web", "", JOptionPane.ERROR_MESSAGE);
                this.jComboBoxWebAddress.requestFocus();
            }

        }
        else
        {
            parent.setVisible(false);
            parent.canceled = true;
        }
    // TODO: Agregar logica de acceso
}//GEN-LAST:event_jButtonAcceptActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonDeleteActionPerformed
    {//GEN-HEADEREND:event_jButtonDeleteActionPerformed

        URI uri = (URI) this.jComboBoxWebAddress.getSelectedItem();
        if (uri != null)
        {
            int res = JOptionPane.showConfirmDialog(this, "¿Desea borrar esta configuración de conexión?", "Borrado de configuración", JOptionPane.YES_NO_OPTION);
            if (res == JOptionPane.YES_OPTION)
            {
                configurationListURI.removeAddress(uri);
                this.jComboBoxWebAddress.removeItem(uri);

            }
        }
}//GEN-LAST:event_jButtonDeleteActionPerformed

    private void formFocusGained(java.awt.event.FocusEvent evt)//GEN-FIRST:event_formFocusGained
    {//GEN-HEADEREND:event_formFocusGained
        if (this.jComboBoxWebAddress.getSelectedItem() == null)
        {
            this.jComboBoxWebAddress.requestFocus();
        }
        else
        {
            if (this.jTextFieldClave.getText().equals(""))
            {
                this.jTextFieldClave.requestFocus();
            }
            else
            {
                this.jPassword.requestFocus();
            }
        }
    }//GEN-LAST:event_formFocusGained

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAccept;
    private javax.swing.JButton jButtonAvanced;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JComboBox jComboBoxWebAddress;
    private javax.swing.JLabel jLabelClave;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JLabel jLabelWebAddress;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JTextField jTextFieldClave;
    // End of variables declaration//GEN-END:variables

    private void preInit()
    {
        imgFondo = ImageLoader.images.get("splash").getImage();
    }

    @Override
    public void paintComponent(Graphics g)
    {
        if (imgFondo != null)
        {
            g.drawImage(imgFondo, 0, 0, getWidth(), getHeight(), this);
        }
    }

    public void windowGainedFocus(WindowEvent e)
    {
        if (this.jComboBoxWebAddress.getSelectedItem() == null)
        {
            this.jComboBoxWebAddress.requestFocus();
        }
        else
        {
            if (this.jTextFieldClave.getText().equals(""))
            {
                this.jTextFieldClave.requestFocus();
            }
            else
            {
                this.jPassword.requestFocus();
            }
        }
    }

    public void windowLostFocus(WindowEvent e)
    {

    }

    
}
