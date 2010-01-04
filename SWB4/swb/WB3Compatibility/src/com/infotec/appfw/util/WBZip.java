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
 * WBZip.java
 *
 * Created on 3 de junio de 2002, 03:18 PM
 */

package com.infotec.appfw.util;

import java.io.*;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Genera un archivo ZIP en base a un directorio
 * @author Javier Solis Gonzalez
 * @version
 */
public class WBZip
{

    /** Creates new WBZip */
    public WBZip()
    {
    }

    public void createZip(String targetfile, String sourcefiles[])
    {
        try
        {
            ZipOutputStream zipoutputstream = new ZipOutputStream(new FileOutputStream(targetfile));
            for (int i = 0; i < sourcefiles.length; i++)
            {
                File file = new File(sourcefiles[i]);
                if (!file.isDirectory())
                {
                    ZipEntry zipentry = new ZipEntry(sourcefiles[i]);
                    zipoutputstream.setMethod(8);
                    zipoutputstream.setLevel(-1);
                    zipoutputstream.putNextEntry(zipentry);
                    File file1 = new File(sourcefiles[i]);
                    DataInputStream datainputstream = new DataInputStream(new FileInputStream(sourcefiles[i]));
                    byte abyte0[] = new byte[4096];
                    int j;
                    while ((j = datainputstream.read(abyte0, 0, 4096)) != -1)
                        zipoutputstream.write(abyte0, 0, j);
                    zipoutputstream.closeEntry();
                }
            }

            zipoutputstream.close();
        } catch (Exception exception)
        {
            System.out.println(exception.toString());
        }
    }

    /*public boolean Almacena(String s)
    {
        boolean flag = false;
        Date date = new Date(System.currentTimeMillis());
        String s1 = "" + (date.getYear() + 1900);
        s1 = s1 + "-" + date.getMonth()+1;
        s1 = s1 + "-" + date.getDate();
        s1 = s1 + "-" + date.getHours();
        s1 = s1 + "-" + date.getMinutes();
        String s2 = s + "backup/";
        String s3 = s + "imagenes/";
        File file = new File(s);
        if(!file.isDirectory())
            return false;
        File file1 = new File(s2);
        if(!file1.exists())
            file1.mkdir();
        int i = 0;
        File file2 = new File(s3);
        i = file.list().length;
        i += file2.list().length;
        if(file1.exists())
        {
            String as[] = new String[i];
            for(int j = 0; j < file.list().length; j++)
                as[j] = s + file.list()[j];

            int k = 0;
            for(int l = file.list().length; l < file2.list().length + file.list().length; l++)
            {
                as[l] = s3 + file2.list()[k];
                k++;
            }

            createZip(s2 + s1 + ".zip", as);
            return true;
        } else
        {
            return false;
        }
    }*/

}
