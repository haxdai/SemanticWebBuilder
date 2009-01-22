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
 * FileDownload.java
 *
 * Created on 12 de noviembre de 2004, 09:55 AM
 */

package applets.ftp;
import javax.swing.*;
import java.io.*;
import java.net.*;
import java.util.*;
/**
 * Clase que hace la descarga de archivos de un servidor, esta asociada a la clase
 * FDownload, que la presentaci�n.
 * @author Victor Lorenzana
 */
public class FileDownload {
    
    /** Creates a new instance of FileDownload */
    JProgressBar progressbar;
    java.io.File f;    
    URL url;
    String path;
    String jsess;
    Locale locale;
    public FileDownload(String path,JProgressBar progressbar,java.io.File f,String jsess,URL url,Locale locale) {
        this.f=f;
        this.progressbar=progressbar;        
        this.path=path;
        this.jsess=jsess;
        this.url=url;
        this.locale=locale;
    }
    
    public void getFile() {
        try
        {            
            FileOutputStream out=new FileOutputStream(f);
            URLConnection con=url.openConnection();
            if(jsess!=null)con.setRequestProperty("Cookie","JSESSIONID="+jsess);
            con.addRequestProperty("PATHFILEWB",path);
            con.setDoInput(true);
            InputStream in=con.getInputStream();
            byte[] bcont=new byte[8192];
            String contentLength=con.getHeaderField("Content-Length");            
            int size=0;
            try
            {
                size=Integer.parseInt(contentLength);
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
            }
            int packs=(size/8192)+1;
            this.progressbar.setMaximum(packs);
            this.progressbar.setMinimum(0);
            this.progressbar.setValue(0);
            int ipack=0;
            int ret=in.read(bcont);
            while(ret!=-1)
            {
                out.write(bcont,0,ret);
                ipack++;
                this.progressbar.setValue(ipack);
                ret=in.read(bcont);
            }
            this.progressbar.setValue(0);            
            in.close();
            out.close();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage(),java.util.ResourceBundle.getBundle("applets/ftp/ftp",locale).getString("title"),JOptionPane.ERROR_MESSAGE);            
        }        
    }
    
}
