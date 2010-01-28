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
package org.semanticwb.resource.office.sem;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import javax.servlet.http.*;
import org.semanticwb.Logger;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.GenericObject;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.platform.SemanticProperty;
import org.semanticwb.portal.api.*;

public class OfficeResource extends org.semanticwb.resource.office.sem.base.OfficeResourceBase
{

    public OfficeResource()
    {
        super();
    }

    public OfficeResource(SemanticObject obj)
    {
        super(obj);
    }
    private static Logger log = SWBUtils.getLogger(OfficeResource.class);

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
    }

    public void validateViewPropertyValues(HashMap<SemanticProperty, Object> valuesToValidate) throws Exception
    {
    }

    public static void clean(String dir)
    {
        File fdir = new File(SWBPortal.getWorkPath() + dir);
        if (fdir.exists())
        {
            for (File file : fdir.listFiles())
            {
                if (file.isDirectory())
                {
                    clean(file.getAbsolutePath());
                }
                else
                {
                    file.delete();
                }
            }
            fdir.delete();
        }
    }

    private void clean(File dir)
    {
        if (dir.exists() && dir.listFiles() != null)
        {
            for (File file : dir.listFiles())
            {
                if (file.isDirectory())
                {
                    clean(file);
                }
                else
                {
                    file.delete();
                }
            }
        }
    }

    public void clean()
    {
        if (SWBPortal.getWorkPath() != null && getResourceBase() != null && getResourceBase().getWorkPath() != null)
        {
            File dir = new File(SWBPortal.getWorkPath() + getResourceBase().getWorkPath());
            clean(dir);
        }
    }

    public void loadContent(InputStream in)
    {
        clean();
        File zipFile = null;
        try
        {
            if (in != null)
            {
                String name = UUID.randomUUID().toString() + ".zip";
                SWBPortal.writeFileToWorkPath(getResourceBase().getWorkPath() + "/" + name, in, "");
                zipFile = new File(SWBPortal.getWorkPath() + getResourceBase().getWorkPath() + "/" + name);
                ZipFile zip = new ZipFile(zipFile);
                Enumeration entries = zip.entries();
                while (entries.hasMoreElements())
                {
                    ZipEntry entry = (ZipEntry) entries.nextElement();
                    if (!entry.isDirectory())
                    {
                        InputStream inEntry = zip.getInputStream(entry);
                        String file = entry.getName();
                        if (inEntry != null)
                        {
                            int pos = file.lastIndexOf("/");
                            if (pos != -1)
                            {
                                file = file.substring(pos + 1);
                            }
                            SWBPortal.writeFileToWorkPath(getResourceBase().getWorkPath() + "/" + file, inEntry, "");
                        }
                        else
                        {
                            log.error("No se puede sacar archivo de zip, para publicación de office entrada: " + entry.getName() + " tamaño: " + entry.getSize() + " archivo zip: " + zipFile.getAbsolutePath());
                        }
                    }
                }
                zip.close();
            }
        }
        catch (Exception e)
        {
            log.error(e);
        }
        finally
        {
            if (zipFile != null && zipFile.exists())
            {
                zipFile.delete();
            }
        }

    }

    public static void loadContent(InputStream in, String dir, String type)
    {
        File zipFile = null;
        try
        {
            if (in != null)
            {
                String name = UUID.randomUUID().toString() + ".zip";
                SWBPortal.writeFileToWorkPath(dir + "/" + name, in, "");
                zipFile = new File(SWBPortal.getWorkPath() + dir + "/" + name);
                ZipFile zip = new ZipFile(zipFile);
                Enumeration entries = zip.entries();
                while (entries.hasMoreElements())
                {
                    ZipEntry entry = (ZipEntry) entries.nextElement();
                    if (!entry.isDirectory())
                    {
                        /*InputStream inEntry = zip.getInputStream(entry);
                        int pos=file.lastIndexOf("/");
                        if(pos!=-1)
                        {
                        file=file.substring(pos+1);
                        }
                        SWBPlatform.writeFileToWorkPath(dir + "/" + entry.getName(), inEntry, "");*/
                        InputStream inEntry = zip.getInputStream(entry);
                        String file = entry.getName();
                        if (!type.equals("excel"))
                        {
                            int pos = file.lastIndexOf("/");
                            if (pos != -1)
                            {
                                file = file.substring(pos + 1);
                            }
                        }
                        SWBPortal.writeFileToWorkPath(dir + "/" + file, inEntry, "");
                    }
                }
                zip.close();
            }
        }
        catch (Exception e)
        {
            log.error(e);
        }
        finally
        {
            if (zipFile != null && zipFile.exists())
            {
                zipFile.delete();
            }
        }

    }

    public static org.semanticwb.resource.office.sem.OfficeResource getOfficeResource(String id, org.semanticwb.model.SWBModel model)
    {
        GenericObject obj = model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id, ClassMgr.sclass), ClassMgr.sclass);
        if (obj == null)
        {
            obj = model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id, WordResource.ClassMgr.sclass), WordResource.ClassMgr.sclass);
            if (obj == null)
            {
                obj = model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id, ExcelResource.ClassMgr.sclass), ExcelResource.ClassMgr.sclass);
                if (obj == null)
                {
                    obj = model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id, PPTResource.ClassMgr.sclass), PPTResource.ClassMgr.sclass);
                }
            }
        }
        return (org.semanticwb.resource.office.sem.OfficeResource) obj;
    }
}
