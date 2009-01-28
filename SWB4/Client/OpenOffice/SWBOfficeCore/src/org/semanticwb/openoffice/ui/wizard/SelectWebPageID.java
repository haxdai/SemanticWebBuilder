/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SelectWebPageID.java
 *
 * Created on 27/01/2009, 06:34:55 PM
 */
package org.semanticwb.openoffice.ui.wizard;

import java.awt.event.KeyEvent;
import java.util.Map;
import javax.swing.JOptionPane;
import org.netbeans.spi.wizard.Wizard;
import org.netbeans.spi.wizard.WizardPage;
import org.netbeans.spi.wizard.WizardPanelNavResult;

/**
 *
 * @author victor.lorenzana
 */
public class SelectWebPageID extends WizardPage
{

    public static final String WEBPAGEID = "WEBPAGEID";

    /** Creates new form SelectWebPageID */
    public SelectWebPageID()
    {
        initComponents();
    }

    public static String getDescription()
    {
        return "Identificador de página";
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
        jTextFieldWebPageID = new javax.swing.JTextField();

        jLabel1.setText("Identificador de página:");

        jTextFieldWebPageID.setToolTipText("");
        jTextFieldWebPageID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldWebPageIDFocusGained(evt);
            }
        });
        jTextFieldWebPageID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldWebPageIDKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldWebPageID, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldWebPageID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(228, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    public void setId()
    {
        this.jTextFieldWebPageIDFocusGained(null);
    }
    private String getId(String titulo)
    {
        String newtitulo = "";
        char[] caracteres = titulo.toCharArray();
        for (int i = 0; i < caracteres.length; i++)
        {
            char c = caracteres[i];
            if (c >= 48 && c <= 57) // 0 - 9
            {
                newtitulo += c;
            }
            if (c >= 65 && c <= 90) // A - Z
            {
                newtitulo += c;
            }
            if (c >= 97 && c <= 122) // a - z
            {
                newtitulo += c;
            }
            if (c == 32) // espacio
            {
                newtitulo += "_";
            }
            if (c == 241) // ñ
            {
                newtitulo += "n";
            }
            if (c == 209) // Ñ
            {
                newtitulo += "N";
            }
            if (c >= 224 && c <= 229)	// a
            {
                newtitulo += "a";
            }
            if (c >= 232 && c <= 235)	// e
            {
                newtitulo += "e";
            }
            if (c >= 236 && c <= 239)	// i
            {
                newtitulo += "i";
            }
            if (c >= 242 && c <= 246)	// o
            {
                newtitulo += "o";
            }
            if (c >= 249 && c <= 252)	// u
            {
                newtitulo += "u";
            }
            if (c >= 192 && c <= 197)	// A
            {
                newtitulo += "A";
            }
            if (c >= 200 && c <= 203)	// E
            {
                newtitulo += "E";
            }
            if (c >= 204 && c <= 207)	// I
            {
                newtitulo += "I";
            }
            if (c >= 210 && c <= 214)	// O
            {
                newtitulo += "O";
            }
            if (c >= 217 && c <= 220)	// U
            {
                newtitulo += "U";
            }
            else
            {
                newtitulo += "";
            }
        }
        return newtitulo;
    }

    private void jTextFieldWebPageIDFocusGained(java.awt.event.FocusEvent evt)//GEN-FIRST:event_jTextFieldWebPageIDFocusGained
    {//GEN-HEADEREND:event_jTextFieldWebPageIDFocusGained
        if (this.jTextFieldWebPageID.getText().isEmpty())
        {
            String titulo = this.getWizardData(TitleAndDescription.TITLE).toString();
            this.jTextFieldWebPageID.setText(getId(titulo));
        }
    }//GEN-LAST:event_jTextFieldWebPageIDFocusGained

    private void jTextFieldWebPageIDKeyTyped(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jTextFieldWebPageIDKeyTyped
    {//GEN-HEADEREND:event_jTextFieldWebPageIDKeyTyped
        int ichar = evt.getKeyCode();
        if (ichar == KeyEvent.VK_BACK_SPACE)
        {
            return;
        }

        if (jTextFieldWebPageID.getText().length() > 50)
        {
            evt.consume();
        }

        if (evt.getKeyChar() >= 'A' && evt.getKeyChar() <= 'Z') // A-Z
        {
            return;
        }
        else if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') // 0 - 9
        {
            return;
        }
        else if (evt.getKeyChar() >= 'a' && evt.getKeyChar() <= 'z') // a - z
        {
            return;
        }
        else if (evt.getKeyChar() == '_')
        {
            return;
        }
        else
        {
            evt.consume();

        }
    }//GEN-LAST:event_jTextFieldWebPageIDKeyTyped

    @Override
    public WizardPanelNavResult allowNext(String arg, Map map, Wizard wizard)
    {
        return allowFinish(arg, map, wizard);
    }

    @Override
    public WizardPanelNavResult allowFinish(String arg, Map map, Wizard wizard)
    {
        WizardPanelNavResult result = WizardPanelNavResult.REMAIN_ON_PAGE;
        if (jTextFieldWebPageID.getText().isEmpty())
        {
            jTextFieldWebPageID.requestFocus();
            JOptionPane.showMessageDialog(this, "¡Debe indicar un identificador!", getDescription(), JOptionPane.OK_OPTION | JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            map.put(WEBPAGEID, jTextFieldWebPageID.getText());
            result = WizardPanelNavResult.PROCEED;
        }
        return result;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextFieldWebPageID;
    // End of variables declaration//GEN-END:variables
}
