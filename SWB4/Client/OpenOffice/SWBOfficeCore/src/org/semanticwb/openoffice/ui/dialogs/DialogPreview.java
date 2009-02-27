/*
 * DialogPreview.java
 *
 * Created on 3 de junio de 2008, 05:48 PM
 */
package org.semanticwb.openoffice.ui.dialogs;

import java.awt.Frame;
import java.io.IOException;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;
import java.net.URL;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import org.semanticwb.openoffice.OfficeApplication;
import org.semanticwb.openoffice.ui.icons.ImageLoader;



/**
 *
 * @author  victor.lorenzana
 */
public class DialogPreview extends javax.swing.JDialog
{

    private final URL url;

    /** Creates new form DialogPreview */
    public DialogPreview(URL url,String title)
    {
        this(url,true,title);
    }

    public DialogPreview(URL url, boolean showAddress,String title)
    {
        super((Frame)null, ModalityType.TOOLKIT_MODAL);
        initComponents();
        this.setIconImage(ImageLoader.images.get("semius").getImage());
        this.url = url;
        if(title!=null)
        {
            this.setTitle(title);
        }        
        this.setModal(true);
        setLocationRelativeTo(null);
        this.jTextFieldURL.setVisible(showAddress);
        this.jLabelWebAddress.setVisible(showAddress);
        this.jButtonOpenBrowser.setVisible(showAddress);
        setLocationRelativeTo(null);
        setURL(url);

    }

    public void setURL(URL url)
    {
        try
        {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            HttpURLConnection.setFollowRedirects(true);
            Authenticator.setDefault(new MyAuthenticator());
            connection.setInstanceFollowRedirects(true);
            this.jEditorPane1.setPage(connection.getURL());
            this.jTextFieldURL.setText(url.toString());
            
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al mostrar contenido\r\n" + ioe.getLocalizedMessage(), "La página Web no puede ser vista", JOptionPane.OK_OPTION | JOptionPane.ERROR_MESSAGE);
        }
    }

    public static boolean showInBrowser(String url, Frame frame)
    {
        //minimizes the app
        if (frame != null)
        {
            frame.setExtendedState(JFrame.ICONIFIED);
        }

        String os = System.getProperty("os.name").toLowerCase();
        Runtime rt = Runtime.getRuntime();
        try
        {
            if (os.indexOf("win") >= 0)
            {
                String[] cmd = new String[4];
                cmd[0] = "cmd.exe";
                cmd[1] = "/C";
                cmd[2] = "start";
                cmd[3] = url;
                rt.exec(cmd);
            }
            else if (os.indexOf("mac") >= 0)
            {
                rt.exec("open " + url);
            }
            else
            {
                //prioritized 'guess' of users' preference
                String[] browsers =
                {
                    "epiphany", "firefox", "mozilla", "konqueror",
                    "netscape", "opera", "links", "lynx"
                };

                StringBuffer cmd = new StringBuffer();
                for (int i = 0; i < browsers.length; i++)
                {
                    cmd.append((i == 0 ? "" : " || ") + browsers[i] + " \"" + url + "\" ");
                }

                rt.exec(new String[]
                        {
                            "sh", "-c", cmd.toString()
                        });
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame,
                    "\n\n El sistema falló al tratr de invocar su navegador por defecto intentando acceder a: \n\n " + url + "\n\n",
                    "Error de navegador",
                    JOptionPane.WARNING_MESSAGE);

            return false;
        }
        return true;
    }

    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtonClose = new javax.swing.JButton();
        jTextFieldURL = new javax.swing.JTextField();
        jLabelWebAddress = new javax.swing.JLabel();
        jButtonOpenBrowser = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ver página");
        setModal(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setPreferredSize(new java.awt.Dimension(600, 50));

        jButtonClose.setText("Cerrar");
        jButtonClose.setToolTipText("No se puede navegar con esta vista");
        jButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloseActionPerformed(evt);
            }
        });

        jTextFieldURL.setEditable(false);

        jLabelWebAddress.setText("Dirección Web:");

        jButtonOpenBrowser.setText("Abrir en un navegador");
        jButtonOpenBrowser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOpenBrowserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabelWebAddress)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldURL, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonOpenBrowser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonClose)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonClose)
                    .addComponent(jButtonOpenBrowser)
                    .addComponent(jTextFieldURL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelWebAddress))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.SOUTH);

        jEditorPane1.setContentType("text/html");
        jEditorPane1.setEditable(false);
        jEditorPane1.setToolTipText("Esta página no es navegable");
        jEditorPane1.setPreferredSize(new java.awt.Dimension(600, 450));
        jScrollPane1.setViewportView(jEditorPane1);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        //this.setURL(url);
    }//GEN-LAST:event_formWindowOpened

    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseActionPerformed

        this.setVisible(false);
    }//GEN-LAST:event_jButtonCloseActionPerformed

    private void jButtonOpenBrowserActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonOpenBrowserActionPerformed
    {//GEN-HEADEREND:event_jButtonOpenBrowserActionPerformed
        showInBrowser(this.url.toString(), new Frame());
}//GEN-LAST:event_jButtonOpenBrowserActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClose;
    private javax.swing.JButton jButtonOpenBrowser;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabelWebAddress;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldURL;
    // End of variables declaration//GEN-END:variables
}

class MyAuthenticator extends java.net.Authenticator
{

    @Override
    protected PasswordAuthentication getPasswordAuthentication()
    {
        String user = "";
        String password = "";
        try
        {
            if (OfficeApplication.getOfficeApplicationProxy().getUser() != null)
            {
                /*String userPassword = OfficeApplication.getOfficeDocumentProxy().getUser() + ":" + OfficeApplication.getOfficeDocumentProxy().getPassword();
                String encoded = new String(encode(userPassword.getBytes()));
                connection.setRequestProperty("Authorization", "Basic " + encoded);*/
                user = OfficeApplication.getOfficeDocumentProxy().getUser();
                password = OfficeApplication.getOfficeDocumentProxy().getPassword();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return new PasswordAuthentication(user, password.toCharArray());
    }
}
