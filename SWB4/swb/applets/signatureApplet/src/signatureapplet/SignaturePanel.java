/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package signatureapplet;

import java.applet.Applet;
import java.awt.GridLayout;
import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import netscape.javascript.JSObject;
import org.bouncycastle.util.encoders.Base64;
import org.semanticwb.security.SignatureRecord;
import signatureapplet.util.ExtensionFileFilter;
import signatureapplet.util.GetFIELPK;
import signatureapplet.util.SignatureManager;

/**
 *
 * @author serch
 */
public class SignaturePanel extends javax.swing.JPanel {

    private File privFileName = null;
    private File pubFileName = null;
    private String message = null;
    private String postURL = null;
    private String sessionid = null;
    private Applet applet = null;

    /**
     * Creates new form SignatureApplet
     */
    public SignaturePanel() {
        try {
        initComponents();
        } catch (Throwable t){
            t.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        seleccionArchivo = new javax.swing.JFileChooser();
        title2 = new javax.swing.JLabel();
        privateKeyFilename = new javax.swing.JLabel();
        title3 = new javax.swing.JLabel();
        publicKeyFilename = new javax.swing.JLabel();
        privSelBtn = new javax.swing.JButton();
        pubSelBtn = new javax.swing.JButton();
        signerBtn = new javax.swing.JButton();
        title1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextToSign = new javax.swing.JTextArea();
        seleccionArchivo.getAccessibleContext().setAccessibleParent(privSelBtn);

        setBackground(new java.awt.Color(255, 255, 255));
        setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        setPreferredSize(new java.awt.Dimension(600, 330));

        title2.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        title2.setText("llave Privada:");

        privateKeyFilename.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        privateKeyFilename.setPreferredSize(new java.awt.Dimension(500, 17));

        title3.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        title3.setText("llave Pública:");

        publicKeyFilename.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        publicKeyFilename.setPreferredSize(new java.awt.Dimension(500, 17));

        privSelBtn.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        privSelBtn.setText("Elija su llave privada");
        privSelBtn.setPreferredSize(new java.awt.Dimension(190, 30));
        privSelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                privSelBtnActionPerformed(evt);
            }
        });

        pubSelBtn.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        pubSelBtn.setText("Elija su llave pública");
        pubSelBtn.setPreferredSize(new java.awt.Dimension(190, 30));
        pubSelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pubSelBtnActionPerformed(evt);
            }
        });

        signerBtn.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        signerBtn.setText("Firmar");
        signerBtn.setPreferredSize(new java.awt.Dimension(190, 30));
        signerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signerBtnActionPerformed(evt);
            }
        });

        title1.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        title1.setText("Cadena a firmar:");

        jScrollPane1.setPreferredSize(new java.awt.Dimension(244, 44));

        jTextToSign.setEditable(false);
        jTextToSign.setColumns(20);
        jTextToSign.setLineWrap(true);
        jTextToSign.setRows(5);
        jTextToSign.setPreferredSize(new java.awt.Dimension(240, 40));
        jScrollPane1.setViewportView(jTextToSign);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(title2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(privateKeyFilename, javax.swing.GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(title3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(publicKeyFilename, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(privSelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pubSelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(signerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(title1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(title2)
                    .addComponent(privateKeyFilename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(title3)
                    .addComponent(publicKeyFilename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pubSelBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(privSelBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(signerBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void privSelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_privSelBtnActionPerformed
        FileFilter filter = new ExtensionFileFilter("Llave Privada", "key");
        seleccionArchivo.setFileFilter(filter);
        int retFC = seleccionArchivo.showDialog(this, "Elija llave privada");
        if (retFC == JFileChooser.APPROVE_OPTION) {
            privFileName = seleccionArchivo.getSelectedFile();
            privateKeyFilename.setText(privFileName.getAbsolutePath());
        }
    }//GEN-LAST:event_privSelBtnActionPerformed

    private void pubSelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pubSelBtnActionPerformed
        FileFilter filter = new ExtensionFileFilter("Llave Pública", "cer");
        seleccionArchivo.setFileFilter(filter);
        int retFC = seleccionArchivo.showDialog(this, "Elija llave pública");
        if (retFC == JFileChooser.APPROVE_OPTION) {
            pubFileName = seleccionArchivo.getSelectedFile();
            publicKeyFilename.setText(pubFileName.getAbsolutePath());
        }
    }//GEN-LAST:event_pubSelBtnActionPerformed

    private void signerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signerBtnActionPerformed
        if (null == privFileName) {
            JOptionPane.showMessageDialog(this, "Falta obtener la llave privada", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (null == pubFileName) {
            JOptionPane.showMessageDialog(this, "Falta obtener la llave pública", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        char[] enteredPassword = null;
        JPanel userPanel = new JPanel();
        userPanel.setLayout(new GridLayout(1, 1));
        JLabel passwordLbl = new JLabel("Contraseña:");
        passwordLbl.setFont(new java.awt.Font("Lucida Sans", 0, 12));
        JPasswordField passwordFld = new JPasswordField();
        userPanel.add(passwordLbl);
        userPanel.add(passwordFld);
        userPanel.setFocusable(true);
        int input = JOptionPane.showConfirmDialog(this, userPanel,
                "Contraseña de la llave privada:", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);
        if (input == 0) //OK Button = 0
        {
            enteredPassword = passwordFld.getPassword();
        }
        if (null != enteredPassword) {
            try {
                
                PrivateKey privateKey =GetFIELPK.getKey(privFileName, enteredPassword);

                FileInputStream fis = new FileInputStream(pubFileName);
                BufferedInputStream bis = new BufferedInputStream(fis);

                CertificateFactory cf = CertificateFactory.getInstance("X.509");
                Certificate cert = null;
                if (bis.available() > 0) {
                    cert = cf.generateCertificate(bis);
                    X509Certificate x509 = (X509Certificate) cert;
//                    System.out.println("SerialNumber:" + x509.getSerialNumber());
//                    System.out.println("DN:" + x509.getSubjectDN().getName());
//                    System.out.println("Subject UniqueID:" + x509.getSubjectUniqueID());
//                    System.out.println("X500P:" + x509.getSubjectX500Principal().getName());
                }
                bis.close();
                fis.close();
                SignatureRecord sr = SignatureManager.wrapData(message, privateKey, cert);
                String ret = new String(Base64.encode(sr.getSignature()));
                String data = SignatureManager.encodeSignatureRecord(sr);
                //String urlParameters = "fName=" + URLEncoder.encode("???", "UTF-8") +  "&lName=" + URLEncoder.encode("???", "UTF-8")
                
                sr = SignatureManager.decodeSignatureRecord(data);
                boolean valid = SignatureManager.ValidateSignatureRecord(sr);
                
                if (valid){
                    JSObject browser = JSObject.getWindow(applet);
                    browser.call("setSignature", new Object[]{ret});
                    //int result=postData(new URL(postURL), "signature="+URLEncoder.encode(data, "UTF-8"));
                    //if (result==200){
//                        JOptionPane.showMessageDialog(this, "Firma enviada", "Firma", JOptionPane.INFORMATION_MESSAGE);
//                        signerBtn.setEnabled(false);
                    //} else {
                    //    JOptionPane.showMessageDialog(this, "Error: "+result, "Error", JOptionPane.ERROR_MESSAGE);
                    //}
                }
                
            } catch (GeneralSecurityException ngse) {
                ngse.printStackTrace();
                JOptionPane.showMessageDialog(this, "Contraseña o llave privada incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error: " + e.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_signerBtnActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextToSign;
    private javax.swing.JButton privSelBtn;
    private javax.swing.JLabel privateKeyFilename;
    private javax.swing.JButton pubSelBtn;
    private javax.swing.JLabel publicKeyFilename;
    private javax.swing.JFileChooser seleccionArchivo;
    private javax.swing.JButton signerBtn;
    private javax.swing.JLabel title1;
    private javax.swing.JLabel title2;
    private javax.swing.JLabel title3;
    // End of variables declaration//GEN-END:variables

    public void setToSignString(String message, String url, String sessionid, Applet applet) {
        this.message = message;
        jTextToSign.setText(this.message);
        this.postURL = url;
        this.applet = applet;
    }

    int postData(URL url, String data) {
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");

            connection.setRequestProperty("Content-Length", ""
                    + Integer.toString(data.getBytes().length));
            connection.setRequestProperty("Content-Language", "en-US");
            connection.addRequestProperty("JSESSIONID", sessionid);
            connection.setUseCaches(false);
            connection.setDoInput(true);
            connection.setDoOutput(true);

            DataOutputStream wr = new DataOutputStream(
                    connection.getOutputStream());
            wr.writeBytes(data);
            wr.flush();
            wr.close();
            return connection.getResponseCode();

        } catch (Exception e) {

            e.printStackTrace();
            return 500;

        } finally {

            if (connection != null) {
                connection.disconnect();
            }
        }
    }

}
