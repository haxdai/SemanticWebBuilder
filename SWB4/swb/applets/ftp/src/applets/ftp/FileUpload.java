/*
 * INFOTEC WebBuilder es una herramienta para el desarrollo de portales de conocimiento, colaboraci�n e integraci�n para Internet,
 * la cual, es una creaci�n original del Fondo de Informaci�n y Documentaci�n para la Industria INFOTEC, misma que se encuentra
 * debidamente registrada ante el Registro P�blico del Derecho de Autor de los Estados Unidos Mexicanos con el
 * No. 03-2002-052312015400-14, para la versi�n 1; No. 03-2003-012112473900 para la versi�n 2, y No. 03-2006-012012004000-01
 * para la versi�n 3, respectivamente.
 *
 * INFOTEC pone a su disposici�n la herramienta INFOTEC WebBuilder a trav�s de su licenciamiento abierto al p�blico (�open source�),
 * en virtud del cual, usted podr� usarlo en las mismas condiciones con que INFOTEC lo ha dise�ado y puesto a su disposici�n;
 * aprender de �l; distribuirlo a terceros; acceder a su c�digo fuente y modificarlo, y combinarlo o enlazarlo con otro software,
 * todo ello de conformidad con los t�rminos y condiciones de la LICENCIA ABIERTA AL P�BLICO que otorga INFOTEC para la utilizaci�n
 * de INFOTEC WebBuilder 3.2.
 *
 * INFOTEC no otorga garant�a sobre INFOTEC WebBuilder, de ninguna especie y naturaleza, ni impl�cita ni expl�cita,
 * siendo usted completamente responsable de la utilizaci�n que le d� y asumiendo la totalidad de los riesgos que puedan derivar
 * de la misma.
 *
 * Si usted tiene cualquier duda o comentario sobre INFOTEC WebBuilder, INFOTEC pone a su disposici�n la siguiente
 * direcci�n electr�nica:
 *
 *                                          http://www.webbuilder.org.mx
 */


/*
 * FileUpload.java
 *
 * Created on 11 de noviembre de 2004, 05:47 PM
 */

package applets.ftp;

import javax.swing.*;
import java.io.*;
import java.net.*;
import java.util.*;
/**
 * Clase que realiza la funci�n de env�ar un archivo al servidor, esta asociada
 * esta clase con la clase FUpload, que es la representaci�n grafica de esta
 * opci�n.
 * @author Victor Lorenzana
 */
public class FileUpload {
    
    /** Creates a new instance of FileUpload */
       
    URL url;
    String jsess;
    Vector listeners=new Vector();
    Locale locale;
    public FileUpload(String jsess,URL url,Locale locale) {                
        this.jsess=jsess;
        this.url=url;
        this.locale=locale;
    }    
    public void addSendListener(FileUploadListener listener)
    {
        listeners.add(listener);
    }
    public void fireSend(int size,int value)
    {
        Iterator it=listeners.iterator();
        while(it.hasNext())
        {
            FileUploadListener fl=(FileUploadListener)it.next();
            fl.onSend(size,value);
        }
    }
    public boolean sendFile(String path,java.io.File f) {  
        try
        {            
            int max=(int)(f.length()/2048);
            max++;            
            if(f.exists())
            {

                try
                {
                    HttpURLConnection con=(HttpURLConnection)url.openConnection();                        
                    con.setDefaultUseCaches(false);   
                    con.setFixedLengthStreamingMode((int)f.length());
                    if(jsess!=null)con.setRequestProperty("Cookie","JSESSIONID="+jsess);
                    con.addRequestProperty("PATHFILEWB",path);
                    con.setDoOutput(true);                
                    OutputStream out=con.getOutputStream();
                    FileInputStream fin=new FileInputStream(f);
                    byte[] bcont=new byte[2048];
                    int ret=fin.read(bcont);
                    int ivalue=0;
                    while(ret!=-1)
                    {
                        out.write(bcont,0,ret);                    
                        ivalue++;           
                        fireSend(max, ivalue);
                        ret=fin.read(bcont);
                        out.flush();
                    }
                    out.close();
                    fin.close();                                      
                    String resp=con.getHeaderField(0);
                    
                    StringTokenizer st=new StringTokenizer(resp," ");
                    if(st.countTokens()>=2)
                    {
                        String intcode=st.nextToken();
                        intcode=st.nextToken();
                        if(intcode.equals("200"))
                        {
                            return true;
                        }
                        else
                        {
                            if(st.countTokens()>=3)
                            {
                                System.out.println("fileupload http code: "+resp);
                                JOptionPane.showMessageDialog(null,st.nextToken(),java.util.ResourceBundle.getBundle("applets/ftp/ftp",locale).getString("title"),JOptionPane.ERROR_MESSAGE);            
                            }
                        }
                    }

                }
                catch(Exception e)
                {           
                    e.printStackTrace(System.out);
                    if(e.getMessage()!=null)
                    {
                        JOptionPane.showMessageDialog(null,"error: "+e.getMessage(),java.util.ResourceBundle.getBundle("applets/ftp/ftp",locale).getString("title"),JOptionPane.ERROR_MESSAGE);            
                    }
                    
                }
            }
        }
        catch(Exception err)
        {
            System.out.println("error: "+err.getMessage());
        }
        return false;
        
    }
    
}
