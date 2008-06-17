/*
 * PagContenido.java
 *
 * Created on 3 de junio de 2008, 11:23 AM
 */
package org.semanticwb.openoffice.ui.wizard;

import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import org.netbeans.spi.wizard.Wizard;
import org.netbeans.spi.wizard.WizardPage;
import org.netbeans.spi.wizard.WizardPanelNavResult;
import org.semanticwb.openoffice.util.FixedLengthPlainDocument;

/**
 *
 * @author  victor.lorenzana
 */
public class PagContenido extends WizardPage
{
    public static final String NEXT = "next";
    public static final String PREV = "prev";
    private static final String NUMPAG = "numpag";
    private static final String SHOWNUMPAG = "shownumpag";
    private static final String TITLE = "Configuración de páginación";

    /** Creates new form PagContenido */
    public PagContenido()
    {
        initComponents();        
        jSpinnerNumPag.setModel(new SpinnerNumberModel(0,0,50,1));
        jTextFieldNext.setDocument(new FixedLengthPlainDocument(40));
        jTextFieldPrev.setDocument(new FixedLengthPlainDocument(40));        
        if (this.getWizardData(SHOWNUMPAG) != null)
        {
            this.jCheckBoxShowNumPag.setSelected((Boolean)this.getWizardData(SHOWNUMPAG));
        }
        if (this.getWizardData(SHOWNUMPAG) != null)
        {
            this.jCheckBoxShowNumPag.setSelected((Boolean) this.getWizardData(SHOWNUMPAG));
            if (this.getWizardData(NUMPAG) != null)
            {
                this.jSpinnerNumPag.setValue(this.getWizardData(NUMPAG));
            }
            if (this.getWizardData(NEXT) != null)
            {
                this.jTextFieldNext.setText((String) this.getWizardData(NEXT));
            }
            if (this.getWizardData(PREV) != null)
            {
                this.jTextFieldPrev.setText((String) this.getWizardData(PREV));
            }
        }
    }

    @Override
    public WizardPanelNavResult allowNext(String arg, Map map, Wizard wizard)
    {
        WizardPanelNavResult result=WizardPanelNavResult.REMAIN_ON_PAGE;
        if (this.jCheckBoxShowNumPag.isSelected())
        {
            if (this.jTextFieldNext.getText().trim().equals(""))
            {
                javax.swing.JOptionPane.showMessageDialog(null, "¡Debe indicar un texto para la navegación(Siguiente)!", getDescription(), JOptionPane.ERROR_MESSAGE);
                this.jTextFieldNext.requestFocus();                
            }
            else if (this.jTextFieldPrev.getText().trim().equals(""))
            {
                javax.swing.JOptionPane.showMessageDialog(null, "¡Debe indicar un texto para la navegación(Anterior)!", getDescription(), JOptionPane.ERROR_MESSAGE);
                this.jTextFieldPrev.requestFocus();                
            }
            else
            {
                map.put(SHOWNUMPAG, true);
                map.put(NUMPAG, this.jSpinnerNumPag.getValue());
                map.put(NEXT, this.jTextFieldNext.getText().trim());
                map.put(PREV, this.jTextFieldPrev.getText().trim());
                result=WizardPanelNavResult.PROCEED;
            }
        }
        else
        {
            map.remove(NUMPAG);
            map.remove(SHOWNUMPAG);
            map.remove(NEXT);
            map.remove(PREV);
            result=WizardPanelNavResult.PROCEED;
        }
        return result;
    }

    public static String getDescription()
    {
        return TITLE;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jCheckBoxShowNumPag = new javax.swing.JCheckBox();
        jPanelOptions = new javax.swing.JPanel();
        jLabelNumPag = new javax.swing.JLabel();
        jLabelTextNext = new javax.swing.JLabel();
        jLabelTextPrev = new javax.swing.JLabel();
        jPanelShowNumPagesUP_DOWN = new javax.swing.JPanel();
        jRadioButtonUp = new javax.swing.JRadioButton();
        jRadioButtonDown = new javax.swing.JRadioButton();
        jRadioButtonUpAndDown = new javax.swing.JRadioButton();
        jTextFieldNext = new javax.swing.JTextField();
        jTextFieldPrev = new javax.swing.JTextField();
        jSpinnerNumPag = new javax.swing.JSpinner();

        jCheckBoxShowNumPag.setText("Mostrar número de páginas del contenido");
        jCheckBoxShowNumPag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxShowNumPagActionPerformed(evt);
            }
        });

        jPanelOptions.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opciones", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP));
        jPanelOptions.setEnabled(false);

        jLabelNumPag.setText("Número de páginas a mostrar:");

        jLabelTextNext.setText("Texto a mostrar para navegación (Siguiente):");

        jLabelTextPrev.setText("Texto a mostrar para nevegación (Anterior):");

        jPanelShowNumPagesUP_DOWN.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Motrar el número de páginas", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP));

        buttonGroup1.add(jRadioButtonUp);
        jRadioButtonUp.setSelected(true);
        jRadioButtonUp.setText("Arriba");

        buttonGroup1.add(jRadioButtonDown);
        jRadioButtonDown.setText("Abajo");

        buttonGroup1.add(jRadioButtonUpAndDown);
        jRadioButtonUpAndDown.setText("Arriba y Abajo");

        javax.swing.GroupLayout jPanelShowNumPagesUP_DOWNLayout = new javax.swing.GroupLayout(jPanelShowNumPagesUP_DOWN);
        jPanelShowNumPagesUP_DOWN.setLayout(jPanelShowNumPagesUP_DOWNLayout);
        jPanelShowNumPagesUP_DOWNLayout.setHorizontalGroup(
            jPanelShowNumPagesUP_DOWNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelShowNumPagesUP_DOWNLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelShowNumPagesUP_DOWNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButtonUp)
                    .addComponent(jRadioButtonDown)
                    .addComponent(jRadioButtonUpAndDown))
                .addContainerGap(227, Short.MAX_VALUE))
        );
        jPanelShowNumPagesUP_DOWNLayout.setVerticalGroup(
            jPanelShowNumPagesUP_DOWNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelShowNumPagesUP_DOWNLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jRadioButtonUp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButtonDown)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButtonUpAndDown))
        );

        javax.swing.GroupLayout jPanelOptionsLayout = new javax.swing.GroupLayout(jPanelOptions);
        jPanelOptions.setLayout(jPanelOptionsLayout);
        jPanelOptionsLayout.setHorizontalGroup(
            jPanelOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelOptionsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanelShowNumPagesUP_DOWN, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelOptionsLayout.createSequentialGroup()
                        .addGroup(jPanelOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelTextNext)
                            .addComponent(jLabelNumPag)
                            .addComponent(jLabelTextPrev))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldPrev, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                            .addComponent(jTextFieldNext, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                            .addComponent(jSpinnerNumPag, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanelOptionsLayout.setVerticalGroup(
            jPanelOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOptionsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNumPag)
                    .addComponent(jSpinnerNumPag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTextNext)
                    .addComponent(jTextFieldNext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTextPrev)
                    .addComponent(jTextFieldPrev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelShowNumPagesUP_DOWN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelOptions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckBoxShowNumPag))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCheckBoxShowNumPag)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelOptions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    private void jCheckBoxShowNumPagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxShowNumPagActionPerformed
        if (this.jCheckBoxShowNumPag.isSelected())
        {
            this.jPanelOptions.setEnabled(true);
        }
        else
        {
            this.jPanelOptions.setEnabled(false);
        }
    }//GEN-LAST:event_jCheckBoxShowNumPagActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox jCheckBoxShowNumPag;
    private javax.swing.JLabel jLabelNumPag;
    private javax.swing.JLabel jLabelTextNext;
    private javax.swing.JLabel jLabelTextPrev;
    private javax.swing.JPanel jPanelOptions;
    private javax.swing.JPanel jPanelShowNumPagesUP_DOWN;
    private javax.swing.JRadioButton jRadioButtonDown;
    private javax.swing.JRadioButton jRadioButtonUp;
    private javax.swing.JRadioButton jRadioButtonUpAndDown;
    private javax.swing.JSpinner jSpinnerNumPag;
    private javax.swing.JTextField jTextFieldNext;
    private javax.swing.JTextField jTextFieldPrev;
    // End of variables declaration//GEN-END:variables
}
