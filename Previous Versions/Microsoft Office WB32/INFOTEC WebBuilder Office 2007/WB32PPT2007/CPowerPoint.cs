/*	INFOTEC WebBuilder es una herramienta para el desarrollo de portales de conocimiento, colaboración e integración para Internet, la cual, es una creación original del Fondo de Información y Documentación para la Industria INFOTEC, misma que se encuentra debidamente registrada ante el Registro Público del Derecho de Autor de los Estados Unidos Mexicanos con el No. 03-2002-052312015400-14, para la versión 1; No. 03-2003-012112473900 para la versión 2, y No. 03-2006-012012004000-01 para la versión 3, respectivamente. 
	INFOTEC pone a su disposición la herramienta INFOTEC WebBuilder a través de su licenciamiento abierto al público (‘open source’), en virtud del cual, usted podrá usarlo en las mismas condiciones con que INFOTEC lo ha diseñado y puesto a su disposición; aprender de él; distribuirlo a terceros; acceder a su código fuente y modificarlo, y combinarlo o enlazarlo con otro software, todo ello de conformidad con los términos y condiciones de la LICENCIA ABIERTA AL PÚBLICO que otorga INFOTEC para la utilización de INFOTEC WebBuilder 3.2
	INFOTEC no otorga garantía sobre INFOTEC WebBuilder, de ninguna especie y naturaleza, ni implícita ni explícita, siendo usted completamente responsable de la utilización que le dé y asumiendo la totalidad de los riesgos que puedan derivar de la misma.
	Si usted tiene cualquier duda o comentario sobre INFOTEC WebBuilder, INFOTEC pone a su disposición la siguiente dirección electrónica: http://www.webbuilder.org.mx	
*/
using System;
using WBOffice3;
using CHtmlParser;
using System.Collections;
using System.IO;
using System.Windows.Forms;
using System.Diagnostics;
using System.Xml;
using System.Text;
using PowerPoint = Microsoft.Office.Interop.PowerPoint;
using Office = Microsoft.Office.Core;
namespace WBPowerPoint
{
    /// <summary>
    /// Descripción breve de CPowerPoint.
    /// </summary>
    public class CPowerPoint
    {
        System.Resources.ResourceManager resppt = new System.Resources.ResourceManager("WBPowerPoint.respp", System.Reflection.Assembly.GetExecutingAssembly());
        /// <summary>
        /// Tipo de documento
        /// </summary>
        public static readonly String TYPE = "PPTContent";
        /// <summary>
        /// Guarda propiedades en el documento
        /// </summary>
        /// <param name="topicmap"></param>
        /// <param name="topicid"></param>
        /// <param name="idcont"></param>
        public void Save(String topicmap, String topicid, String idcont)
        {
            bool save = false;
            Office.DocumentProperties props = (Office.DocumentProperties)CPowerPoint.doc.CustomDocumentProperties;
            foreach (Office.DocumentProperty prop in props)
            {
                if (prop.Name.Equals("topicid"))
                {
                    if (!topicid.Equals(prop.Value))
                        save = true;
                    prop.Value = topicid;
                }
                else if (prop.Name.Equals("topicmap"))
                {
                    if (!topicmap.Equals(prop.Value))
                        save = true;
                    prop.Value = topicmap;
                }
                else if (prop.Name.Equals("content"))
                {
                    if (!idcont.Equals(prop.Value))
                        save = true;
                    prop.Value = idcont;
                }
            }
            if (save)
            {
                if (CPowerPoint.doc.Saved == Office.MsoTriState.msoFalse)
                {                    
                    CPowerPoint.doc.Save();
                }
            }
        }        
        System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(CLibrary));
        /// <summary>
        /// Presentación a publicar
        /// </summary>
        public static PowerPoint.Presentation doc = null;
        /// <summary>
        /// Aplicación de PowerPoint
        /// </summary>
        public static PowerPoint.Application app = null;
        /// <summary>
        /// Usuario
        /// </summary>
        public static CUserAdmin user;
        /// <summary>
        /// Parametros para envio
        /// </summary>
        public static ParameterCollection parametros = new ParameterCollection();
        /// <summary>
        /// Parametros recibidos
        /// </summary>
        public static ParameterCollection resultados = new ParameterCollection();
        /// <summary>
        /// Imagenes del documento asociadas
        /// </summary>
        public static ArrayList imagenes = new ArrayList();
        /// <summary>
        /// Constructor por defecto
        /// </summary>
        public CPowerPoint()
        {
            
#if(ING)
				System.Threading.Thread.CurrentThread.CurrentUICulture =new  System.Globalization.CultureInfo("en",false) ;														
#endif
        }
        /// <summary>
        /// Resumen de archivos
        /// </summary>
        /// <param name="app"></param>
        /// <param name="user"></param>
        /// <returns></returns>
        public CUserAdmin ResumenArchivos(PowerPoint.Application app, CUserAdmin user)
        {
            CPowerPoint.app = app;
            CPowerPoint.user = user;

            if (isDocumentoNull())
            {
                return user;
            }
            CPowerPoint.doc = app.ActivePresentation;
            if (CPowerPoint.user == null)
            {
                CPowerPoint.user = this.Login(CPowerPoint.app);
            }
            if (CPowerPoint.user.ID <= 0)
            {
                CPowerPoint.user = this.Login(CPowerPoint.app);
            }
            if (!isValidSession())
            {
                return user;
            }
            FileInfo f = new FileInfo(CPowerPoint.doc.FullName);
            if (!f.Exists)
            {
                MessageBox.Show(resources.GetString("CWebBuilder.msg1"), resources.GetString("Global.title"), MessageBoxButtons.OK, MessageBoxIcon.Error);
                return CPowerPoint.user;
            }
            try
            {
                long l = f.Length;
            }
            catch (Exception fe)
            {
                Console.WriteLine(fe.Message);
                MessageBox.Show(resources.GetString("CWebBuilder.msg1"), resources.GetString("Global.title"), MessageBoxButtons.OK, MessageBoxIcon.Error);
                return CPowerPoint.user;
            }
            FrmDetalleDoc frm = new FrmDetalleDoc();
            frm.ShowDialog();
            return CPowerPoint.user;

        }
        /// <summary>
        /// Cambia el password de usuario
        /// </summary>
        /// <param name="app"></param>
        /// <param name="user"></param>
        /// <returns></returns>
        public CUserAdmin ChangePassword(PowerPoint.Application app, CUserAdmin user)
        {
            CPowerPoint.app = app;
            CPowerPoint.user = user;
            if (CPowerPoint.user == null)
            {
                CPowerPoint.user = this.Login(CPowerPoint.app);
            }
            if (CPowerPoint.user.ID <= 0)
            {
                CPowerPoint.user = this.Login(CPowerPoint.app);
            }
            if (!isValidSession())
            {
                return user;
            }
            FrmPassword frm = new FrmPassword(CPowerPoint.user);
            frm.ShowDialog();
            return CPowerPoint.user;
        }
        /// <summary>
        /// Muestra pantalla de acerca de
        /// </summary>
        public void About()
        {
            FrmAbout frm = new FrmAbout();
            frm.ShowDialog();
        }
        /// <summary>
        /// Muestra pantalla de preview
        /// </summary>
        /// <param name="app"></param>
        /// <param name="user"></param>
        /// <returns></returns>
        public CUserAdmin Preview(PowerPoint.Application app, CUserAdmin user)
        {
            CPowerPoint.app = app;
            if (isDocumentoNull())
            {
                return user;
            }
            CPowerPoint.doc = app.ActivePresentation;
            CPowerPoint.user = user;
            if (CPowerPoint.user == null)
            {
                CPowerPoint.user = this.Login(doc.Application);
            }
            if (CPowerPoint.user.ID <= 0)
            {
                CPowerPoint.user = this.Login(doc.Application);
            }
            if (!isValidSession())
            {
                return user;
            }
            Office.DocumentProperties props = (Office.DocumentProperties)CPowerPoint.doc.CustomDocumentProperties;
            String topicmap = "";
            String topicid = "";
            String idcont = "";
            foreach (Office.DocumentProperty prop in props)
            {
                if (prop.Name.Equals("content"))
                {
                    idcont = (String)prop.Value;
                }
                if (prop.Name.Equals("topicid"))
                {
                    topicid = (String)prop.Value;
                }
                if (prop.Name.Equals("topicmap"))
                {
                    topicmap = (String)prop.Value;
                }
            }
            if (idcont.Equals("") || topicid.Equals("") || topicmap.Equals(""))
            {
                MessageBox.Show(resources.GetString("CWebBuilder.msg2"), resources.GetString("Global.title"), MessageBoxButtons.OK, MessageBoxIcon.Error);
                return CPowerPoint.user;
            }
            Servicios servicio = new Servicios(CPowerPoint.user);
            if (!servicio.existsCont(idcont, topicmap, topicid))
            {
                // debe borrar la liga al contenido
                Office.DocumentProperties props2 = (Office.DocumentProperties)CPowerPoint.doc.CustomDocumentProperties;
                foreach (Office.DocumentProperty prop in props2)
                {
                    if (prop.Name.Equals("content"))
                    {
                        prop.Delete();
                        continue;
                    }
                    if (prop.Name.Equals("topicid"))
                    {
                        prop.Delete();
                        continue;
                    }
                    if (prop.Name.Equals("topicmap"))
                    {
                        prop.Delete();
                        continue;
                    }
                }
                if (doc.Saved == Office.MsoTriState.msoFalse)
                {
                    doc.Save();
                }
                return CPowerPoint.user;
            }
            servicio = new Servicios(CPowerPoint.user);
            XmlDocument resp = servicio.getContentAtt(topicmap, topicid, idcont);
            try
            {
                if (resp.GetElementsByTagName("lastversion").Count > 0)
                {
                    FrmPreview frm = new FrmPreview(topicmap, topicid, idcont, resp.GetElementsByTagName("lastversion")[0].InnerText, CPowerPoint.user);
                    frm.Text = resources.GetString("CWebBuilder.t1");
                    frm.ShowDialog();
                }
                else
                {
                    FrmPreview frm = new FrmPreview(topicmap, topicid, idcont, CPowerPoint.user);
                    frm.Text = resources.GetString("CWebBuilder.t1");
                    frm.ShowDialog();
                }

            }
            catch (Exception ue)
            {
                Debug.WriteLine(ue.Message);
            }
            return CPowerPoint.user;
        }
        /// <summary>
        /// Muestra página web de INFOTEC
        /// </summary>
        public void PagWeb()
        {
            FrmPreview frm = new FrmPreview("http://www.infotec.com.mx");
            frm.Text = resources.GetString("CWebBuilder.t2");

            frm.ShowDialog();

        }
        /// <summary>
        /// Convierte una cadena a hexadecimal
        /// </summary>
        /// <param name="dato"></param>
        /// <returns></returns>
        public String StringToHex(String dato)
        {
            byte[] b = System.Text.Encoding.Default.GetBytes(dato);
            String hits = "0123456789ABCDEF";
            System.Text.StringBuilder sb = new StringBuilder();

            for (int i = 0; i < b.Length; i++)
            {
                if (b[i] == 46)
                {
                    sb.Append('.');
                }
                else
                {
                    int j = ((int)b[i]) & 0xFF;

                    char first = hits[j / 16];
                    char second = hits[j % 16];
                    sb.Append('%');
                    sb.Append(first);
                    sb.Append(second);
                }
            }

            return sb.ToString();

        }
        /// <summary>
        /// Publica o actualiza un contenido
        /// </summary>
        /// <param name="app"></param>
        /// <param name="user"></param>
        /// <returns></returns>
        public CUserAdmin New(PowerPoint.Application app, CUserAdmin user)
        {
            ParameterCollection parametros = new ParameterCollection();
            ArrayList imagenes = new ArrayList();
            imagenes = new ArrayList();
            CPowerPoint.app = app;
            if (isDocumentoNull())
            {
                return user;
            }
            resultados = new ParameterCollection();
            parametros = new ParameterCollection();
            CPowerPoint.doc = (PowerPoint.Presentation)app.ActivePresentation;
            CPowerPoint.app = doc.Application;
            CPowerPoint.user = user;

            if (CPowerPoint.user == null)
            {
                CPowerPoint.user = this.Login(doc.Application);
            }
            if (CPowerPoint.user.ID <= 0)
            {
                CPowerPoint.user = this.Login(doc.Application);
            }
            if (!isValidSession())
            {
                return user;
            }
            FileInfo fname = new FileInfo(doc.FullName);
            String ext = fname.Extension;
            if (ext.ToLower().Equals(""))
            {
                try
                {
                    FrmSave frm = new FrmSave();
                    if (frm.saveFileDialog1.ShowDialog() == DialogResult.OK)
                    {
                        doc.SaveAs(frm.saveFileDialog1.FileName, PowerPoint.PpSaveAsFileType.ppSaveAsDefault, Office.MsoTriState.msoTrue);
                    }
                    else
                    {
                        return user;
                    }
                }
                catch (Exception)
                {
                    return user;
                }
            }
            fname = new FileInfo(doc.FullName);
            ext = fname.Extension;
            if (ext.ToLower().Equals(""))
            {
                MessageBox.Show(resources.GetString("CWebBuilder.msg4") + " .ppt", resources.GetString("Global.title"), MessageBoxButtons.OK, MessageBoxIcon.Information);
                try
                {
                    FrmSave frm = new FrmSave();
                    if (frm.saveFileDialog1.ShowDialog() == DialogResult.OK)
                    {
                        doc.SaveAs(frm.saveFileDialog1.FileName, PowerPoint.PpSaveAsFileType.ppSaveAsDefault, Office.MsoTriState.msoTrue);
                    }
                    else
                    {
                        return user;
                    }
                }
                catch (Exception)
                {
                    return user;
                }
            }
            if (ext.ToLower().Equals(""))
            {
                MessageBox.Show(resources.GetString("CWebBuilder.msg1"), resources.GetString("Global.title"), MessageBoxButtons.OK, MessageBoxIcon.Information);
                return CPowerPoint.user;
            }
            if (!(doc.Saved == Office.MsoTriState.msoFalse) && ext.Equals(""))
            {
                MessageBox.Show(resources.GetString("CWebBuilder.msg4") + " .ppt", resources.GetString("Global.title"), MessageBoxButtons.OK, MessageBoxIcon.Information);
                try
                {
                    FrmSave frm = new FrmSave();
                    if (frm.saveFileDialog1.ShowDialog() == DialogResult.OK)
                    {
                        doc.SaveAs(frm.saveFileDialog1.FileName, PowerPoint.PpSaveAsFileType.ppSaveAsDefault, Office.MsoTriState.msoTrue);
                    }
                    else
                    {
                        return user;
                    }
                }
                catch (Exception)
                {
                    return user;
                }
            }
            fname = new FileInfo(doc.FullName);
            ext = fname.Extension;
            if (!(doc.Saved == Office.MsoTriState.msoFalse) && ext.Equals(""))
            {
                MessageBox.Show(resources.GetString("CWebBuilder.msg1"), resources.GetString("Global.title"), MessageBoxButtons.OK, MessageBoxIcon.Information);
                return CPowerPoint.user;
            }
            // esta salvado

            if (!(ext.ToLower().Equals(".ppt") || ext.ToLower().Equals(".pptx")))
            {
                MessageBox.Show(resources.GetString("CWebBuilder.msg4") + " .ppt", resources.GetString("Global.title"), MessageBoxButtons.OK, MessageBoxIcon.Error);
                return CPowerPoint.user;
            }


            if (ValidaNombre(fname))
            {
                CUserAdmin usertemp = CPowerPoint.user;
                int pos = fname.Name.IndexOf(fname.Extension);
                String name = fname.Name.Substring(0, pos);
                if(doc.Saved==Office.MsoTriState.msoFalse)
                {
                    doc.Save();
                }                
                object missing = Type.Missing;
                string strpathHtml = fname.Directory.FullName + "\\" + name + ".html";
                object objtrue = true;
                object objfalse = false;
                try
                {
                    FileInfo f = new FileInfo((String)strpathHtml);
                    if (f.Exists)
                    {
                        f.Delete();
                    }
                }
                catch (Exception e)
                {
                    MessageBox.Show(e.Message, resources.GetString("Global.title"), MessageBoxButtons.OK, MessageBoxIcon.Error);
                    return CPowerPoint.user;
                }

                //				foreach(Slide slide in doc.Slides)
                //				{					
                //					foreach(PowerPoint.Hyperlink link in  slide.Hyperlinks )
                //					{					
                //						String archivo=link.Address;
                //						
                //						System.Uri basepath=new System.Uri(doc.Path+"\\");
                //						System.Uri filepath=new System.Uri(basepath, archivo);
                //						
                //						if(filepath.IsFile) 
                //						{
                //							FileInfo farchivo= new FileInfo(filepath.LocalPath);						
                //							if(farchivo.Extension.IndexOf(".")!=-1)
                //							{
                //								if(farchivo.Exists)
                //								{	
                //									String filename=StringToHex(farchivo.Name);
                //									link.Address=filename;
                //								}
                //							}
                //						}
                //					}
                //				}

                doc.WebOptions.FrameColors = PowerPoint.PpFrameColors.ppFrameColorsBrowserColors;
                FrmSelectPresentation frm2 = new FrmSelectPresentation();
                frm2.ShowDialog();
                if (frm2.DialogResult == DialogResult.Cancel)
                {
                    return CPowerPoint.user;
                }

                try
                {
                    FileInfo f = new FileInfo((String)strpathHtml);
                    if (f.Exists)
                    {
                        f.Delete();
                    }
                }
                catch (Exception e)
                {
                    MessageBox.Show(e.Message, resources.GetString("Global.title"), MessageBoxButtons.OK, MessageBoxIcon.Error);
                    return CPowerPoint.user;
                }
                WBOffice3.DialogResultEx valueres = WBOffice3.DialogResultEx.YES;
                foreach (PowerPoint.Slide slide in doc.Slides)
                {
                    foreach (PowerPoint.Hyperlink link in slide.Hyperlinks)
                    {
                        try
                        {
                            String archivo = link.Address;
                            if (archivo != null)
                            {

                                try
                                {
                                    System.Uri basepath = new System.Uri(doc.Path + "\\");
                                    System.Uri filepath = new System.Uri(basepath, archivo);

                                    if (filepath.IsFile)
                                    {

                                        FileInfo farchivo = new FileInfo(filepath.LocalPath);
                                        if (farchivo.Extension.IndexOf(".") != -1)
                                        {
                                            if (farchivo.Exists)
                                            {

                                                if (this.ValidaNombre(farchivo))
                                                {
                                                    imagenes.Add(farchivo);
                                                }
                                                else
                                                {

                                                    FrmDetalleDoc frmresumen = new FrmDetalleDoc();
                                                    frmresumen.ShowDialog();
                                                    return CPowerPoint.user;
                                                }
                                            }
                                            else
                                            {
                                                if (valueres != DialogResultEx.YESALL)
                                                {
                                                    valueres = WBOffice3.MessageBoxWB3.Show(resources.GetString("Global.title"), resources.GetString("CWebBuilder.msg5") + " " + farchivo.FullName + " " + resources.GetString("CWebBuilder.msg6") + "");
                                                    //if(MessageBox.Show(resources.GetString("CWebBuilder.msg5") +" "+ farchivo.FullName +" "+ resources.GetString("CWebBuilder.msg6") +"",resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Error)==DialogResult.No)
                                                    if (valueres == DialogResultEx.CANCEL)
                                                    {
                                                        return CPowerPoint.user;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                catch (Exception ue)
                                {
                                    Debug.WriteLine(ue.Message);
                                }
                            }
                        }
                        catch { }
                    }
                }
                FileInfo filesPPTX = new FileInfo(doc.FullName);
                if (filesPPTX.Extension.Equals(".pptx",StringComparison.CurrentCultureIgnoreCase))
                {
                    string fileDoc = filesPPTX.FullName.Substring(0, filesPPTX.FullName.Length - 1);
                    doc.SaveAs(fileDoc, PowerPoint.PpSaveAsFileType.ppSaveAsPresentation, Office.MsoTriState.msoFalse);
                    doc.Close();
                    object pathpptx = filesPPTX.FullName;
                    doc = (PowerPoint.Presentation)CPowerPoint.app.Presentations.Open((string)pathpptx, Office.MsoTriState.msoFalse, Office.MsoTriState.msoFalse, Office.MsoTriState.msoTrue);

                }
                if (frm2.opExplorer)
                {
                    doc.SaveAs(strpathHtml, PowerPoint.PpSaveAsFileType.ppSaveAsHTML, Office.MsoTriState.msoFalse);
                }
                else
                {
                    doc.SaveAs(strpathHtml, PowerPoint.PpSaveAsFileType.ppSaveAsHTMLDual, Office.MsoTriState.msoFalse);
                }


                doc.Close();
                object docfile = fname.FullName;

                doc = (PowerPoint.Presentation)CPowerPoint.app.Presentations.Open((string)docfile, Office.MsoTriState.msoFalse, Office.MsoTriState.msoFalse, Office.MsoTriState.msoTrue);



                FileInfo fhtmltemp = new FileInfo((String)strpathHtml);

                FileStream finhtml = fhtmltemp.OpenRead();
                byte[] bnew = new byte[fhtmltemp.Length];
                finhtml.Read(bnew, 0, bnew.Length);
                finhtml.Close();
                String htmlnew = System.Text.Encoding.Default.GetString(bnew, 0, bnew.Length);
                if (frm2.opExplorer)
                {
                    htmlnew = CreateHtml(fhtmltemp, htmlnew, parametros, CPowerPoint.doc, true, imagenes);
                }
                else
                {
                    htmlnew = CreateHtml(fhtmltemp, htmlnew, parametros, CPowerPoint.doc, false, imagenes);
                }

                char[] chars = htmlnew.ToCharArray();
                int index = 0;
                foreach (char cChar in chars)
                {
                    int ichar = (int)cChar;
                    if (ichar == 8220 || ichar == 8221)
                    {
                        //Debug.WriteLine(cChar); 
                        chars[index] = '\"';

                    }
                    index++;
                }
                htmlnew = new String(chars);

                finhtml = fhtmltemp.Open(FileMode.Create, FileAccess.ReadWrite, FileShare.ReadWrite);
                byte[] bnew2 = System.Text.Encoding.Default.GetBytes(htmlnew);
                finhtml.Write(bnew2, 0, bnew2.Length);
                finhtml.Close();

                finhtml = fhtmltemp.OpenRead();
                byte[] b = new byte[fhtmltemp.Length];
                finhtml.Read(b, 0, b.Length);
                finhtml.Close();
                String html = System.Text.Encoding.Default.GetString(b, 0, b.Length);
                CHtmlParser.CHTMLDcoument dochtml = new CHTMLDcoument();
                dochtml.LoadHml(html);
                                
                CPowerPoint.app = doc.Application;
                CPowerPoint.user = usertemp;
                // agrega el parametro					
                FileParameter phtml = new FileParameter("content", (String)strpathHtml);
                WBOffice3.Attribute atthtml = new WBOffice3.Attribute("filename", name + ".html");
                phtml.Attributes.Add(atthtml);
                parametros.Add(phtml);
                FileInfo fhtml = new FileInfo((String)strpathHtml);
                if (fhtml.Exists)
                {
                    try
                    {
                        fhtml.Delete();
                    }
                    catch { }
                }


                // busca el archivo de lista de archivos
                String pathfiles = name + doc.WebOptions.FolderSuffix;
                pathfiles = fname.Directory.FullName + "\\" + pathfiles + "\\filelist.xml";
                FileInfo fxml = new FileInfo(pathfiles);
                if (fxml.Exists && fxml.Length > 0)
                {
                    FileStream finxml = fxml.OpenRead();
                    byte[] bxmlfilelist = new byte[fxml.Length];
                    finxml.Read(bxmlfilelist, 0, bxmlfilelist.Length);
                    finxml.Close();
                    String xmllistfiles = System.Text.Encoding.ASCII.GetString(bxmlfilelist, 0, bxmlfilelist.Length);
                    System.Xml.XmlDocument xmlfilelist = new XmlDocument();
                    if (!xmllistfiles.Equals(""))
                    {
                        xmlfilelist.LoadXml(xmllistfiles);
                        System.Xml.XmlNodeList tags = xmlfilelist.GetElementsByTagName("o:File");
                        foreach (System.Xml.XmlNode node in tags)
                        {
                            foreach (System.Xml.XmlAttribute att in node.Attributes)
                            {
                                if (att.Name.ToLower().Equals("href"))
                                {
                                    String nameparameter = att.Value;
                                    String pathfileparameter = fxml.Directory.FullName + "\\" + att.Value;
                                    FileInfo fimagen = new FileInfo(pathfileparameter);
                                    if (fimagen.Exists)
                                    {
                                        imagenes.Add(fimagen);
                                    }
                                }
                            }
                        }
                    }


                }
                // fin de busqueda de archivos
                string pptx = filesPPTX.FullName;
                if (filesPPTX.Extension.Equals(".pptx",StringComparison.CurrentCultureIgnoreCase))
                {
                    pptx = pptx.Substring(0, pptx.Length - 1);
                }

                FileInfo fPPT = new FileInfo(pptx);
                if (fPPT.Exists)
                {
                    imagenes.Add(fPPT);
                }
                bool actualiza = false;
                String idcontent = null;
                Office.DocumentProperties props = (Office.DocumentProperties)CPowerPoint.doc.CustomDocumentProperties;
                foreach (Office.DocumentProperty prop in props)
                {
                    if (prop.Name.Equals("content"))
                    {
                        idcontent = (String)prop.Value;
                        actualiza = true;
                    }
                }
                if (idcontent == null)
                {
                    actualiza = false;
                }
                else
                {

                    if (idcontent.Trim().Equals(""))
                    {
                        foreach (Office.DocumentProperty prop in props)
                        {
                            if (prop.Name.Equals("content"))
                            {
                                prop.Delete();
                                if (doc.Saved == Office.MsoTriState.msoFalse)
                                {
                                    doc.Save();
                                }
                            }
                        }
                        actualiza = false;
                    }
                }
                if (actualiza)
                {
                    String topicmap = "", topicid = "";
                    foreach (Office.DocumentProperty prop in props)
                    {
                        if (prop.Name.Equals("topicmap"))
                        {
                            topicmap = (String)prop.Value;
                        }
                        if (prop.Name.Equals("topicid"))
                        {
                            topicid = (String)prop.Value;
                        }
                    }

                    Servicios s = new Servicios(CPowerPoint.user);
                    if (!s.existsCont(idcontent, topicmap, topicid))
                    {
                        MessageBox.Show(resources.GetString("CWebBuilder.msg2"), resources.GetString("Global.title"), MessageBoxButtons.OK, MessageBoxIcon.Error);
                        if (MessageBox.Show(resources.GetString("CWebBuilder.askquitaasocia"), resources.GetString("Global.title"), MessageBoxButtons.OKCancel, MessageBoxIcon.Question) == DialogResult.OK)
                        {
                            this.deleteAsociation();
                        }
                        return CPowerPoint.user;
                    }
                    s = new Servicios(CPowerPoint.user);
                    System.Xml.XmlDocument docxmlinfo = s.getContentAtt(topicmap, topicid, idcontent);
                    String status = docxmlinfo.GetElementsByTagName("status")[0].InnerText;
                    Servicios srevisor = new Servicios(CPowerPoint.user);
                    String occID = idcontent;
                    if (docxmlinfo.GetElementsByTagName("occurrence").Count > 0)
                    {
                        occID = docxmlinfo.GetElementsByTagName("occurrence")[0].InnerText;
                    }
                    if (!(docxmlinfo.GetElementsByTagName("activityName").Count == 1 && docxmlinfo.GetElementsByTagName("activityName")[0].InnerText == "Terminar flujo"))
                    {
                        if (status == "1" || status == "3")
                        {
                            bool isReviewver = srevisor.isReviewer(topicmap, topicid, occID);
                            if (isReviewver)
                            {
                                Servicios canEdit = new Servicios(CPowerPoint.user);
                                if (!canEdit.canEdit(topicmap, topicid, occID))
                                {
                                    MessageBox.Show(resources.GetString("CWebBuilder.canEdit"), resources.GetString("Global.title"), MessageBoxButtons.OK, MessageBoxIcon.Error);
                                    return CPowerPoint.user;
                                }
                            }
                            else
                            {
                                MessageBox.Show(resources.GetString("CWebBuilder.msg8"), resources.GetString("Global.title"), MessageBoxButtons.OK, MessageBoxIcon.Error);
                                return CPowerPoint.user;
                            }
                        }
                    }

                    System.Xml.XmlNodeList errors = docxmlinfo.GetElementsByTagName("err");
                    if (errors.Count > 0)
                    {
                        Office.DocumentProperties props2 = (Office.DocumentProperties)CPowerPoint.doc.CustomDocumentProperties;
                        foreach (Office.DocumentProperty prop in props2)
                        {
                            if (prop.Name.Equals("content"))
                            {
                                prop.Delete();
                                continue;
                            }
                            if (prop.Name.Equals("topicid"))
                            {
                                prop.Delete();
                                continue;
                            }
                            if (prop.Name.Equals("topicmap"))
                            {
                                prop.Delete();
                                continue;
                            }
                        }
                        if (doc.Saved == Office.MsoTriState.msoFalse)
                        {
                            doc.Save();
                        }
                        actualiza = false;
                        if (MessageBox.Show(resources.GetString("CWebBuilder.msg7"), resources.GetString("Global.title"), MessageBoxButtons.YesNo, MessageBoxIcon.Question) == System.Windows.Forms.DialogResult.No)
                        {
                            return CPowerPoint.user;
                        }
                    }
                }
                if (actualiza)
                {
                    String topicid = "";
                    String topicmap = "";
                    String idcont = idcontent;
                    Office.DocumentProperties props2 = (Office.DocumentProperties)CPowerPoint.doc.CustomDocumentProperties;
                    foreach (Office.DocumentProperty prop in props2)
                    {

                        if (prop.Name.Equals("topicid"))
                        {
                            WBOffice3.Parameter ptopicid = new WBOffice3.Parameter("topicid", (String)prop.Value);
                            topicid = (String)prop.Value;
                            parametros.Add(ptopicid);
                        }
                        if (prop.Name.Equals("topicmap"))
                        {
                            WBOffice3.Parameter ptopicmap = new WBOffice3.Parameter("topicmap", (String)prop.Value);
                            topicmap = (String)prop.Value;
                            parametros.Add(ptopicmap);
                        }

                    }
                    Servicios servicio = new Servicios(CPowerPoint.user);
                    if (!servicio.existsCont(idcontent, topicmap, topicid))
                    {
                        // debe borrar la liga al contenido
                        //Office.DocumentProperties props2=(Office.DocumentProperties)CPowerPoint.doc.CustomDocumentProperties;							
                        foreach (Office.DocumentProperty prop in props2)
                        {
                            if (prop.Name.Equals("content"))
                            {
                                prop.Delete();
                                continue;
                            }
                            if (prop.Name.Equals("topicid"))
                            {
                                prop.Delete();
                                continue;
                            }
                            if (prop.Name.Equals("topicmap"))
                            {
                                prop.Delete();
                                continue;
                            }
                        }
                        if (doc.Saved == Office.MsoTriState.msoFalse)
                        {
                            doc.Save();
                        }
                        return CPowerPoint.user;
                    }
                    if (!user.GetPermiso(topicmap, CPowerPoint.TYPE))
                    {
                        return CPowerPoint.user;
                    }


                    WBOffice3.Parameter pidContent = new WBOffice3.Parameter("id", idcontent);
                    parametros.Add(pidContent);
                    parametros.Add(new Parameter("type", CPowerPoint.TYPE));
                    servicio = new Servicios(CPowerPoint.user);
                    XmlDocument resp = servicio.updateCont(parametros, topicmap, topicid);
                    String version = null;
                    if (resp.GetElementsByTagName("id").Count > 0)
                    {
                        String id = resp.GetElementsByTagName("id")[0].InnerText;
                        if (resp.GetElementsByTagName("lastversion").Count > 0)
                        {
                            version = resp.GetElementsByTagName("lastversion")[0].InnerText;
                            Parameter p = new Parameter("id", id);
                            CPowerPoint.resultados.Add(p);
                            p = new Parameter("version", version);
                            CPowerPoint.resultados.Add(p);
                        }
                        else
                        {
                            version = resp.GetElementsByTagName("actualversion")[0].InnerText;
                            Parameter p = new Parameter("id", id);
                            CPowerPoint.resultados.Add(p);
                            p = new Parameter("version", version);
                            CPowerPoint.resultados.Add(p);
                        }
                    }
                    foreach (WBOffice3.Parameter p in CPowerPoint.resultados)
                    {
                        if (p.Name.Equals("version"))
                        {
                            version = p.Value;
                        }
                    }
                    if (version != null)
                    {
                        foreach (FileInfo fileimagen in imagenes)
                        {
                            String resType = CPowerPoint.TYPE;
                            CContentUpload cfile = new CContentUpload(fileimagen, topicmap, idcontent, version, user, resType);
                            FrmFileUpload fup = new FrmFileUpload(cfile);
                            fup.Send();
                            FileParameter pfile = new FileParameter("attach", fileimagen.FullName);
                            WBOffice3.Attribute att = new WBOffice3.Attribute("filename", fileimagen.Name);
                            pfile.Attributes.Add(att);
                            parametros.Add(pfile);

                        }
                    }
                    FrmResumenContenido frmnew = new FrmResumenContenido(parametros, resultados, user);
                    frmnew.ShowDialog();
                    foreach (Office.DocumentProperty prop in props2)
                    {

                        if (prop.Name.Equals("topicid"))
                        {
                            Parameter ptopicid = new Parameter("topicid", (String)prop.Value);
                            topicid = (String)prop.Value;
                            parametros.Add(ptopicid);
                        }
                        if (prop.Name.Equals("topicmap"))
                        {
                            Parameter ptopicmap = new Parameter("topicmap", (String)prop.Value);
                            topicmap = (String)prop.Value;
                            parametros.Add(ptopicmap);
                        }
                        if (prop.Name.Equals("content"))
                        {
                            idcont = (String)prop.Value;
                        }

                    }
                    if (topicid != null && topicmap != null && idcont != null)
                    {
                        Servicios sflow = new Servicios(CPowerPoint.user);
                        if (sflow.needAutorization(topicmap, topicid, idcont))
                        {
                            MessageBox.Show(resources.GetString("msgneed"), resources.GetString("Global.title"), MessageBoxButtons.OK, MessageBoxIcon.Information);
                        }
                    }

                }
                else
                {
                    FrmNewContent frm = new FrmNewContent(parametros, imagenes, CPowerPoint.user);
                    frm.ShowDialog();
                    
                    String topicid = null;
                    String topicmap = null;
                    String idcont = null;
                    Office.DocumentProperties props2 = (Office.DocumentProperties)CPowerPoint.doc.CustomDocumentProperties;
                    foreach (Office.DocumentProperty prop in props2)
                    {

                        if (prop.Name.Equals("topicid"))
                        {

                            topicid = (String)prop.Value;

                        }
                        if (prop.Name.Equals("topicmap"))
                        {

                            topicmap = (String)prop.Value;

                        }
                        if (prop.Name.Equals("content"))
                        {
                            idcont = (String)prop.Value;
                        }

                    }
                    if (topicid != null && topicmap != null && idcont != null)
                    {
                        Servicios sflow = new Servicios(CPowerPoint.user);
                        if (sflow.needAutorization(topicmap, topicid, idcont))
                        {
                            MessageBox.Show(resources.GetString("msgneed"), resources.GetString("Global.title"), MessageBoxButtons.OK, MessageBoxIcon.Information);
                        }
                    }
                }
                String dirarchivos = fxml.Directory.FullName + "\\";
                if (fxml.Exists)
                {
                    try
                    {
                        fxml.Delete();
                    }
                    catch { }
                }
                System.IO.DirectoryInfo dir = new DirectoryInfo(dirarchivos);
                try
                {
                    if (dir.Exists)
                    {
                        try
                        {
                            dir.Delete();
                        }
                        catch { }
                    }
                }
                catch (Exception dire)
                {
                    Console.WriteLine(dire.Message);
                }
                doc.Save();
            }

            return CPowerPoint.user;
        }
        /// <summary>
        /// Borra asociación de documento con sección y sitio
        /// </summary>
        public void deleteAsociation()
        {
            try
            {
                bool delete = false;
                Office.DocumentProperties props2 = (Office.DocumentProperties)CPowerPoint.doc.CustomDocumentProperties;
                foreach (Office.DocumentProperty prop in props2)
                {
                    if (prop.Name.Equals("content"))
                    {
                        prop.Delete();
                        delete = true;
                        continue;
                    }
                    if (prop.Name.Equals("topicid"))
                    {
                        prop.Delete();
                        delete = true;
                        continue;
                    }
                    if (prop.Name.Equals("topicmap"))
                    {
                        prop.Delete();
                        delete = true;
                        continue;
                    }
                }
                if (delete)
                {
                    if (doc.Saved == Office.MsoTriState.msoFalse)
                    {
                        doc.Save();
                    }
                }
            }
            catch (Exception e)
            {
                Debug.WriteLine(e.Message);
            }
            MessageBox.Show(resources.GetString("CWebBuilder.deleteasociation"), resources.GetString("Global.title"), MessageBoxButtons.OK, MessageBoxIcon.Information);
        }
        private bool ValidaNombre(FileInfo archivo)
        {

            String ext = archivo.Extension;
            int pos = archivo.Name.LastIndexOf(ext);
            String nombre = archivo.Name.Substring(0, pos);
            if (nombre.Length > 40)
            {
                MessageBox.Show(resources.GetString("CWebBuilder.mayor40"), resources.GetString("Global.title"), MessageBoxButtons.OK, MessageBoxIcon.Error);
                return false;
            }
            char[] letras = nombre.ToCharArray();
            for (int i = 0; i < letras.Length; i++)
            {
                char letra = letras[i];
                if (Char.IsPunctuation(letra))
                {
                    if (letra != '_')
                    {
                        MessageBox.Show(resources.GetString("CWebBuilder.msg9") + " " + letra + "", resources.GetString("Global.title"), MessageBoxButtons.OK, MessageBoxIcon.Error);
                        return false;
                    }
                }
                else if (Char.IsWhiteSpace(letra))
                {
                    MessageBox.Show(resources.GetString("CWebBuilder.msg10"), resources.GetString("Global.title"), MessageBoxButtons.OK, MessageBoxIcon.Error);
                    return false;
                }
                else if (!Char.IsLetterOrDigit(letra))
                {
                    if (letra != '_')
                    {
                        MessageBox.Show(resources.GetString("CWebBuilder.msg11") + " " + letra + "", resources.GetString("Global.title"), MessageBoxButtons.OK, MessageBoxIcon.Error);
                        return false;
                    }


                }
                else if (letra > 123)
                {
                    if (letra != '_')
                    {
                        MessageBox.Show(resources.GetString("CWebBuilder.msg11") + " " + letra + "", resources.GetString("Global.title"), MessageBoxButtons.OK, MessageBoxIcon.Error);
                        return false;
                    }

                }
            }

            return true;
        }
        /// <summary>
        /// Muestra pantalla de abrir sessión
        /// </summary>
        /// <param name="app"></param>
        /// <returns></returns>
        public CUserAdmin Login(PowerPoint.Application app)
        {

            CPowerPoint.app = app;

            CUserAdmin user = new CUserAdmin("", "", -1);
            FrmSplash frm = new FrmSplash(user);
            frm.ShowDialog();
            CPowerPoint.user = frm.user;
            return frm.user;
        }
        /// <summary>
        /// Muestra bitacora de cambio de contenido
        /// </summary>
        /// <param name="app"></param>
        /// <param name="user"></param>
        /// <returns></returns>
        public CUserAdmin Bitacora(PowerPoint.Application app, CUserAdmin user)
        {
            resultados = new ParameterCollection();
            parametros = new ParameterCollection();
            CPowerPoint.app = app;
            CPowerPoint.user = user;
            CPowerPoint.doc = app.ActivePresentation;
            if (CPowerPoint.user == null)
            {
                CPowerPoint.user = this.Login(CPowerPoint.app);
            }
            if (CPowerPoint.user.ID <= 0)
            {
                CPowerPoint.user = this.Login(CPowerPoint.app);
            }

            if (!isValidSession())
            {
                return user;
            }
            Office.DocumentProperties props = (Office.DocumentProperties)CPowerPoint.doc.CustomDocumentProperties;
            String topicmap = "";
            String topicid = "";
            String idcont = "";
            foreach (Office.DocumentProperty prop in props)
            {
                if (prop.Name.Equals("content"))
                {
                    idcont = (String)prop.Value;
                }
                if (prop.Name.Equals("topicid"))
                {
                    topicid = (String)prop.Value;
                }
                if (prop.Name.Equals("topicmap"))
                {
                    topicmap = (String)prop.Value;
                }
            }
            if (idcont.Equals("") || topicid.Equals("") || topicmap.Equals(""))
            {
                MessageBox.Show(resources.GetString("CWebBuilder.msg2"), resources.GetString("Global.title"), MessageBoxButtons.OK, MessageBoxIcon.Error);
                return CPowerPoint.user;
            }
            FrmBitacora frm = new FrmBitacora(CPowerPoint.user, idcont, topicmap, topicid);
            frm.ShowDialog();
            return CPowerPoint.user;

        }
        /// <summary>
        /// Abre un contenido
        /// </summary>
        /// <param name="app"></param>
        /// <param name="user"></param>
        /// <returns></returns>
        public CUserAdmin Open(PowerPoint.Application app, CUserAdmin user)
        {
            resultados = new ParameterCollection();
            parametros = new ParameterCollection();
            CPowerPoint.app = app;
            CPowerPoint.user = user;
            if (CPowerPoint.user == null)
            {
                CPowerPoint.user = this.Login(CPowerPoint.app);
            }
            if (CPowerPoint.user.ID <= 0)
            {
                CPowerPoint.user = this.Login(CPowerPoint.app);
            }
            if (!isValidSession())
            {
                return user;
            }


            FrmOpenContent frm = new FrmOpenContent(CPowerPoint.user);
            frm.ShowDialog();
            return CPowerPoint.user;
        }
        /// <summary>
        /// Borra un contenido
        /// </summary>
        /// <param name="app"></param>
        /// <param name="user"></param>
        /// <returns></returns>
        public CUserAdmin Delete(PowerPoint.Application app, CUserAdmin user)
        {
            CPowerPoint.app = app;
            if (isDocumentoNull())
            {
                return user;
            }
            CPowerPoint.resultados = new ParameterCollection();
            CPowerPoint.doc = app.ActivePresentation;
            CPowerPoint.user = user;
            CPowerPoint.app = doc.Application;

            if (CPowerPoint.user == null)
            {
                CPowerPoint.user = this.Login(doc.Application);
            }
            if (CPowerPoint.user.ID <= 0)
            {
                CPowerPoint.user = this.Login(doc.Application);
            }
            if (!isValidSession())
            {
                return user;
            }
            Office.DocumentProperties props = (Office.DocumentProperties)CPowerPoint.doc.CustomDocumentProperties;
            String topicmap = "";
            String topicid = "";
            String idcont = "";
            foreach (Office.DocumentProperty prop in props)
            {
                if (prop.Name.Equals("content"))
                {
                    idcont = (String)prop.Value;
                }
                if (prop.Name.Equals("topicid"))
                {
                    topicid = (String)prop.Value;
                }
                if (prop.Name.Equals("topicmap"))
                {
                    topicmap = (String)prop.Value;
                }
            }
            if (idcont.Equals("") || topicid.Equals("") || topicmap.Equals(""))
            {
                MessageBox.Show(resources.GetString("CWebBuilder.msg2"), resources.GetString("Global.title"), MessageBoxButtons.OK, MessageBoxIcon.Error);
                return CPowerPoint.user;
            }
            Servicios servicio = new Servicios(CPowerPoint.user);
            if (!servicio.existsCont(idcont, topicmap, topicid))
            {
                // debe borrar la liga al contenido
                Office.DocumentProperties props2 = (Office.DocumentProperties)CPowerPoint.doc.CustomDocumentProperties;
                foreach (Office.DocumentProperty prop in props2)
                {
                    if (prop.Name.Equals("content"))
                    {
                        prop.Delete();
                        continue;
                    }
                    if (prop.Name.Equals("topicid"))
                    {
                        prop.Delete();
                        continue;
                    }
                    if (prop.Name.Equals("topicmap"))
                    {
                        prop.Delete();
                        continue;
                    }
                    if (prop.Name.Equals("link"))
                    {
                        prop.Delete();
                        continue;
                    }
                }
                if (doc.Saved == Office.MsoTriState.msoFalse)
                {
                    doc.Save();
                }
                return CPowerPoint.user;
            }
            if (MessageBox.Show(resources.GetString("CWebBuilder.msg12"), resources.GetString("Global.title"), MessageBoxButtons.YesNo, MessageBoxIcon.Question) == System.Windows.Forms.DialogResult.No)
            {
                return CPowerPoint.user;
            }
            if (CPowerPoint.user == null)
            {
                CPowerPoint.user = this.Login(doc.Application);
            }
            if (CPowerPoint.user.ID <= 0)
            {
                CPowerPoint.user = this.Login(doc.Application);
            }
            if (!isValidSession())
            {
                return user;
            }
            Servicios s = new Servicios(CPowerPoint.user);
            //Debe verificar permisos
            if (user.GetPermiso(topicmap, CPowerPoint.TYPE))
            {
                s.deleteContent(topicmap, topicid, idcont);
                foreach (WBOffice3.IParameter p in CPowerPoint.resultados)
                {
                    if (p.Name.Equals("error"))
                    {
                        MessageBox.Show(p.Value, resources.GetString("Global.title"), MessageBoxButtons.OK, MessageBoxIcon.Error);
                        return CPowerPoint.user;
                    }
                }

                Office.DocumentProperties props2 = (Office.DocumentProperties)CPowerPoint.doc.CustomDocumentProperties;
                foreach (Office.DocumentProperty prop in props2)
                {
                    if (prop.Name.Equals("content"))
                    {
                        prop.Delete();
                        continue;
                    }
                    if (prop.Name.Equals("topicid"))
                    {
                        prop.Delete();
                        continue;
                    }
                    if (prop.Name.Equals("topicmap"))
                    {
                        prop.Delete();
                        continue;
                    }
                }
                if (doc.Saved == Office.MsoTriState.msoFalse)
                {
                    doc.Save();
                }
                MessageBox.Show(resources.GetString("CWebBuilder.msg13"), resources.GetString("Global.title"), MessageBoxButtons.OK, MessageBoxIcon.Information);
            }
            else
            {
                MessageBox.Show(resources.GetString("CWebBuilder.msg14"), resources.GetString("Global.title"), MessageBoxButtons.OK, MessageBoxIcon.Information);
            }
            return CPowerPoint.user;

        }
        /// <summary>
        /// Muestra las propiedades del contenido
        /// </summary>
        /// <param name="app"></param>
        /// <param name="user"></param>
        /// <returns></returns>
        public CUserAdmin Properties(PowerPoint.Application app, CUserAdmin user)
        {
            CPowerPoint.app = app;
            if (isDocumentoNull())
            {
                return user;
            }
            CPowerPoint.doc = app.ActivePresentation;
            CPowerPoint.user = user;
            if (CPowerPoint.user == null)
            {
                CPowerPoint.user = this.Login(doc.Application);
            }
            if (CPowerPoint.user.ID <= 0)
            {
                CPowerPoint.user = this.Login(doc.Application);
            }
            if (!isValidSession())
            {
                return user;
            }

            Office.DocumentProperties props = (Office.DocumentProperties)CPowerPoint.doc.CustomDocumentProperties;
            String topicmap = "";
            String topicid = "";
            String idcont = "";
            foreach (Office.DocumentProperty prop in props)
            {
                if (prop.Name.Equals("content"))
                {
                    idcont = (String)prop.Value;
                }
                if (prop.Name.Equals("topicid"))
                {
                    topicid = (String)prop.Value;
                }
                if (prop.Name.Equals("topicmap"))
                {
                    topicmap = (String)prop.Value;
                }
            }
            if (idcont.Equals("") || topicid.Equals("") || topicmap.Equals(""))
            {
                MessageBox.Show(resources.GetString("CWebBuilder.msg2"), resources.GetString("Global.title"), MessageBoxButtons.OK, MessageBoxIcon.Error);
                return CPowerPoint.user;
            }
            Servicios servicio = new Servicios(CPowerPoint.user);
            if (!servicio.existsCont(idcont, topicmap, topicid))
            {
                // debe borrar la liga al contenido
                Office.DocumentProperties props2 = (Office.DocumentProperties)CPowerPoint.doc.CustomDocumentProperties;
                foreach (Office.DocumentProperty prop in props2)
                {
                    if (prop.Name.Equals("content"))
                    {
                        prop.Delete();
                        continue;
                    }
                    if (prop.Name.Equals("topicid"))
                    {
                        prop.Delete();
                        continue;
                    }
                    if (prop.Name.Equals("topicmap"))
                    {
                        prop.Delete();
                        continue;
                    }
                }
                if (doc.Saved == Office.MsoTriState.msoFalse)
                {
                    doc.Save();
                }
                return CPowerPoint.user;
            }
            FrmProp frm = new FrmProp(topicmap, topicid, idcont, CPowerPoint.user, CPowerPoint.TYPE);
            frm.ShowDialog();
            this.Save(frm.TopicMap, frm.Topic, frm.Content);
            return CPowerPoint.user;

        }
        /// <summary>
        /// Función de autoejecución
        /// </summary>
        /// <param name="app"></param>
        /// <returns></returns>
        public CUserAdmin AutoExec(PowerPoint.Application app)
        {
            CConfig c = new CConfig();
            if (c.Startup.Equals("0"))
            {
                return null;
            }
            return this.Login(app);

        }
        /// <summary>
        /// Verifica contenido
        /// </summary>
        public void Verificacontenido()
        {
            if (CPowerPoint.user == null)
            {
                return;
            }
            if (CPowerPoint.user.Uri == null)
            {
                return;
            }
            if (CPowerPoint.doc != null)
            {
                String idcontent = null;
                Office.DocumentProperties props = (Office.DocumentProperties)CPowerPoint.doc.CustomDocumentProperties;
                foreach (Office.DocumentProperty prop in props)
                {
                    if (prop.Name.Equals("content"))
                    {
                        idcontent = (String)prop.Value;
                    }
                }
                if (idcontent != null)
                {
                    String topicmap = "", topicid = "";
                    foreach (Office.DocumentProperty prop in props)
                    {
                        if (prop.Name.Equals("topicmap"))
                        {
                            topicmap = (String)prop.Value;
                        }
                        if (prop.Name.Equals("topicid"))
                        {
                            topicid = (String)prop.Value;
                        }
                    }
                    Servicios s = new Servicios(CPowerPoint.user);
                    System.Xml.XmlDocument docxmlinfo = s.getContentAtt(topicmap, topicid, idcontent);
                    if (!s.IsError)
                    {
                        System.Xml.XmlNodeList errors = docxmlinfo.GetElementsByTagName("err");
                        if (errors.Count > 0)
                        {
                            Office.DocumentProperties props2 = (Office.DocumentProperties)CPowerPoint.doc.CustomDocumentProperties;
                            foreach (Office.DocumentProperty prop in props2)
                            {
                                if (prop.Name.Equals("content"))
                                {
                                    prop.Delete();
                                    continue;
                                }
                                if (prop.Name.Equals("topicid"))
                                {
                                    prop.Delete();
                                    continue;
                                }
                                if (prop.Name.Equals("topicmap"))
                                {
                                    prop.Delete();
                                    continue;
                                }
                            }
                            if (doc.Saved == Office.MsoTriState.msoFalse)
                            {
                                doc.Save();
                            }
                            MessageBox.Show(resources.GetString("CWebBuilder.msg7"), resources.GetString("Global.title"), MessageBoxButtons.OK, MessageBoxIcon.Information);
                        }
                    }

                }
            }
        }
        /// <summary>
        /// Muestra pantalla de cerrar sesión
        /// </summary>
        /// <param name="app"></param>
        /// <param name="user"></param>
        /// <returns></returns>
        public CUserAdmin Logout(PowerPoint.Application app, CUserAdmin user)
        {
            CPowerPoint.app = app;
            if (MessageBox.Show(resources.GetString("CWebBuilder.msg15"), resources.GetString("Global.title"), MessageBoxButtons.YesNo, MessageBoxIcon.Question) == System.Windows.Forms.DialogResult.No)
            {
                return user;
            }
            if (user != null)
            {
                user.ID = -1;
            }
            /*try
            {
                CPowerPoint.Connect.mLogout.Enabled = false;
                CPowerPoint.Connect.mLogin.Enabled = true;
            }
            catch { }*/
            return user;
        }
        /// <summary>
        /// Muestra pantalla de documentos por autorizar
        /// </summary>
        /// <param name="app"></param>
        /// <param name="user"></param>
        /// <returns></returns>
        public CUserAdmin MuestraFlujo(PowerPoint.Application app, CUserAdmin user)
        {
            CPowerPoint.user = user;
            CPowerPoint.app = app;
            if (CPowerPoint.user == null)
            {
                CPowerPoint.user = this.Login(CPowerPoint.app);
            }
            if (CPowerPoint.user.ID <= 0)
            {
                CPowerPoint.user = this.Login(CPowerPoint.app);
            }
            if (!isValidSession())
            {
                return user;
            }
            //FrmDocFlow frm=new FrmDocFlow(CPowerPoint.user); 						
            FrmDocumentosXAutorizar frm = new FrmDocumentosXAutorizar(CPowerPoint.user, app);
            frm.ShowDialog();
            return CPowerPoint.user;
        }
        /// <summary>
        /// Agrega reglas a contenido
        /// </summary>
        /// <param name="app"></param>
        /// <param name="user"></param>
        /// <returns></returns>
        public CUserAdmin CreateRule(PowerPoint.Application app, CUserAdmin user)
        {
            CPowerPoint.app = app;
            if (isDocumentoNull())
            {
                return user;
            }
            CPowerPoint.parametros = new ParameterCollection();
            CPowerPoint.resultados = new ParameterCollection();
            CPowerPoint.doc = app.ActivePresentation;
            CPowerPoint.app = doc.Application;
            CPowerPoint.user = user;
            if (CPowerPoint.user == null)
            {
                CPowerPoint.user = this.Login(doc.Application);
            }
            if (CPowerPoint.user.ID <= 0)
            {
                CPowerPoint.user = this.Login(doc.Application);
            }
            if (!isValidSession())
            {
                return user;
            }
            Office.DocumentProperties props = (Office.DocumentProperties)CPowerPoint.doc.CustomDocumentProperties;
            String topicmap = "";
            String topicid = "";
            String idcont = "";
            foreach (Office.DocumentProperty prop in props)
            {
                if (prop.Name.Equals("content"))
                {
                    idcont = (String)prop.Value;
                }
                if (prop.Name.Equals("topicid"))
                {
                    topicid = (String)prop.Value;
                }
                if (prop.Name.Equals("topicmap"))
                {
                    topicmap = (String)prop.Value;
                }
            }
            if (idcont.Equals("") || topicid.Equals("") || topicmap.Equals(""))
            {
                MessageBox.Show(resources.GetString("CWebBuilder.msg2"), resources.GetString("Global.title"), MessageBoxButtons.OK, MessageBoxIcon.Error);
                return CPowerPoint.user;
            }
            Servicios servicio = new Servicios(CPowerPoint.user);
            if (!servicio.existsCont(idcont, topicmap, topicid))
            {
                // debe borrar la liga al contenido
                Office.DocumentProperties props2 = (Office.DocumentProperties)CPowerPoint.doc.CustomDocumentProperties;
                foreach (Office.DocumentProperty prop in props2)
                {
                    if (prop.Name.Equals("content"))
                    {
                        prop.Delete();
                        continue;
                    }
                    if (prop.Name.Equals("topicid"))
                    {
                        prop.Delete();
                        continue;
                    }
                    if (prop.Name.Equals("topicmap"))
                    {
                        prop.Delete();
                        continue;
                    }
                }
                if (doc.Saved == Office.MsoTriState.msoFalse)
                {
                    doc.Save();
                }
                return CPowerPoint.user;
            }
            Servicios s = new Servicios(CPowerPoint.user);
            XmlDocument doc_user = s.haveAccess2System("WBAd_sysi_ContentsRules");
            if (doc_user.GetElementsByTagName("haveAccess2System").Count > 0 && doc_user.GetElementsByTagName("haveAccess2System")[0].InnerText == "true")
            {
                FrmRuleTopic frm = new FrmRuleTopic(topicmap, topicid, idcont, CPowerPoint.user);
                frm.ShowDialog();
            }
            else
            {
                MessageBox.Show(resources.GetString("FrmEditRule.msg1"), resources.GetString("Global.title"), MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            return CPowerPoint.user;
        }
        /// <summary>
        /// Muestra yuda
        /// </summary>
        public void ShowManual()
        {
            FrmPreview frm = new FrmPreview("http://espacio.webbuilder.com.mx/wb/WB3H/WB3H_webbuilder_office");
            frm.Text = resources.GetString("CWebBuilder.t3");

            frm.ShowDialog();
        }
        /// <summary>
        /// Muestra página de INFOTEC 
        /// </summary>
        public void ShowPagina()
        {
            FrmPreview frm = new FrmPreview("http://www.webbuilder.com.mx/");
            frm.Text = resources.GetString("CWebBuilder.t4");

            frm.ShowDialog();
        }
        /// <summary>
        /// Muestra asistente de creación de sección
        /// </summary>
        /// <param name="app"></param>
        /// <param name="user"></param>
        /// <returns></returns>
        public CUserAdmin CreateTopic(PowerPoint.Application app, CUserAdmin user)
        {
            CPowerPoint.parametros = new ParameterCollection();
            CPowerPoint.resultados = new ParameterCollection();
            CPowerPoint.app = app;
            CPowerPoint.user = user;
            if (CPowerPoint.user == null)
            {
                CPowerPoint.user = this.Login(CPowerPoint.app);
            }
            if (CPowerPoint.user.ID <= 0)
            {
                CPowerPoint.user = this.Login(doc.Application);
            }
            if (!isValidSession())
            {
                return user;
            }
            Servicios s = new Servicios(CPowerPoint.user);
            XmlDocument doc_user = s.haveAccess2Menu("WBAd_mnui_TopicCreate");
            if (doc_user.GetElementsByTagName("haveAccess2Menu").Count > 0 && doc_user.GetElementsByTagName("haveAccess2Menu")[0].InnerText == "true")
            {
                FrmNewSection frm = new FrmNewSection(CPowerPoint.user);
                frm.ShowDialog();
            }
            else
            {
                MessageBox.Show(resources.GetString("FrmNewTopic1.msg1"), resources.GetString("Global.title"), MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            return CPowerPoint.user;
        }

        private bool isDocumentoNull()
        {
            try
            {
                if (app.ActivePresentation == null)
                {
                    MessageBox.Show(resources.GetString("CWebBuilder.msg16"), resources.GetString("Global.title"), MessageBoxButtons.OK, MessageBoxIcon.Error);
                    return false;
                }
            }
            catch (Exception ue)
            {
                Console.WriteLine(ue.Message);
                MessageBox.Show(resources.GetString("CWebBuilder.msg16"), resources.GetString("Global.title"), MessageBoxButtons.OK, MessageBoxIcon.Error);
                return false;
            }
            return false;
        }
        private bool isValidSession()
        {
            if (CPowerPoint.user == null)
            {
                MessageBox.Show(resources.GetString("CWebBuilder.msg17"), resources.GetString("Global.title"), MessageBoxButtons.OK, MessageBoxIcon.Error);
                return false;
            }

            if (CPowerPoint.user.ID <= 0)
            {
                MessageBox.Show(resources.GetString("CWebBuilder.msg17"), resources.GetString("Global.title"), MessageBoxButtons.OK, MessageBoxIcon.Error);
                return false;
            }
            return true;
        }
        /// <summary>
        /// Acción al activar ventana
        /// </summary>
        /// <param name="doc"></param>
        /// <param name="window"></param>
        public void ActivateWindow2(PowerPoint.Presentation doc, PowerPoint.DocumentWindow window)
        {
            //CExcel.user=null;
            CPowerPoint.doc = doc;

            Verificacontenido();
        }
        private bool isFrame(String html)
        {
            if (html.ToLower().IndexOf("frameset") > 0)
            {
                return true;
            }
            return false;
        }
        private String CreateHtml(FileInfo f, string html, ParameterCollection parametros, PowerPoint.Presentation doc, bool framefile, ArrayList imagenes)
        {
            XmlDocument filelist;
            string htmloriginal = html;
            string htmlnuevo = "";
            int pos = 0;
            int pos2 = 0;
            String file = "frame.htm";
            String name = f.Name;
            name = name.Replace(f.Extension, "");
            FileInfo fhtm = new FileInfo(f.DirectoryName + "\\" + name + doc.WebOptions.FolderSuffix + "\\" + file);
            if (!fhtm.Exists)
            {
                file = "frame.html";
                fhtm = new FileInfo(f.DirectoryName + "\\" + name + doc.WebOptions.FolderSuffix + "\\" + file);
            }
            if (framefile)
            {
                pos = htmloriginal.ToLower().LastIndexOf("<frameset");
                if (pos != -1)
                {
                    pos2 = htmloriginal.ToLower().LastIndexOf("</frameset>");
                    htmloriginal = htmloriginal.Substring(0, pos) + htmloriginal.Substring(pos2);

                }

                try
                {
                    filelist = new XmlDocument();
                    filelist.Load(f.DirectoryName + "\\" + name + doc.WebOptions.FolderSuffix + "\\" + "filelist.xml");
                }
                catch (Exception)
                {
                    filelist = null;
                }
                if (filelist == null)
                {
                    file = "frame.htm";
                    fhtm = new FileInfo(f.DirectoryName + "\\" + name + doc.WebOptions.FolderSuffix + "\\" + file);
                    if (!fhtm.Exists)
                    {
                        file = "frame.html";
                        fhtm = new FileInfo(f.DirectoryName + "\\" + name + doc.WebOptions.FolderSuffix + "\\" + file);
                        if (!fhtm.Exists)
                        {
                            String file_prefix = "slide";
                            for (int i = 1; i <= 1000; i++)
                            {
                                file = file_prefix + i.ToString("0000") + ".htm";
                                fhtm = new FileInfo(f.DirectoryName + "\\" + name + doc.WebOptions.FolderSuffix + "\\" + file);
                                if (fhtm.Exists)
                                {
                                    break;
                                }
                                file = file_prefix + i.ToString("0000") + ".html";
                                fhtm = new FileInfo(f.DirectoryName + "\\" + name + doc.WebOptions.FolderSuffix + "\\" + file);
                                if (fhtm.Exists)
                                {
                                    break;
                                }
                            }
                        }

                    }
                }
                else
                {

                    fhtm = new FileInfo(f.DirectoryName + "\\" + name + doc.WebOptions.FolderSuffix + "\\" + file);

                    bool existe = false;
                    foreach (XmlElement efile in filelist.GetElementsByTagName("o:File"))
                    {
                        if (efile.GetAttribute("HRef") == file && fhtm.Exists)
                        {
                            existe = true;
                            break;
                        }
                    }
                    if (!existe)
                    {
                        file = "frame.htm";
                        fhtm = new FileInfo(f.DirectoryName + "\\" + name + doc.WebOptions.FolderSuffix + "\\" + file);
                        existe = false;
                        foreach (XmlElement efile in filelist.GetElementsByTagName("o:File"))
                        {
                            if (efile.GetAttribute("HRef") == file && fhtm.Exists)
                            {
                                existe = true;
                                break;
                            }
                        }
                        if (!existe)
                        {
                            file = "frame.html";
                            fhtm = new FileInfo(f.DirectoryName + "\\" + name + doc.WebOptions.FolderSuffix + "\\" + file);
                            existe = false;
                            foreach (XmlElement efile in filelist.GetElementsByTagName("o:File"))
                            {
                                if (efile.GetAttribute("HRef") == file && fhtm.Exists)
                                {
                                    existe = true;
                                    break;
                                }
                            }
                            if (!existe)
                            {
                                String file_prefix = "slide";
                                for (int i = 1; i <= 1000; i++)
                                {
                                    file = file_prefix + i.ToString("0000") + ".htm";
                                    fhtm = new FileInfo(f.DirectoryName + "\\" + name + doc.WebOptions.FolderSuffix + "\\" + file);
                                    existe = false;
                                    foreach (XmlElement efile in filelist.GetElementsByTagName("o:File"))
                                    {
                                        if (efile.GetAttribute("HRef") == file && fhtm.Exists)
                                        {
                                            existe = true;
                                            break;
                                        }
                                    }
                                    if (existe)
                                    {
                                        break;
                                    }
                                    file = file_prefix + i.ToString("0000") + ".html";
                                    fhtm = new FileInfo(f.DirectoryName + "\\" + name + doc.WebOptions.FolderSuffix + "\\" + file);
                                    existe = false;
                                    foreach (XmlElement efile in filelist.GetElementsByTagName("o:File"))
                                    {
                                        if (efile.GetAttribute("HRef") == file && fhtm.Exists)
                                        {
                                            existe = true;
                                            break;
                                        }
                                    }
                                    if (existe)
                                    {
                                        break;
                                    }
                                }
                            }

                        }
                    }
                }

                pos = htmloriginal.ToLower().LastIndexOf("</html>");
                htmloriginal = "<iframe src=\"" + file + "\" width=\"100%\" height=\"500\"></iframe>";
                //htmloriginal = htmloriginal.Insert(pos, "<iframe src=\"" + file + "\" width=\"100%\" height=\"500\"></iframe>");

            }
            else
            {
                double version = double.Parse(CPowerPoint.app.Version);
                //if(!doc.Application.Version.StartsWith("11"))
                if (version < 11)
                {
                    pos = htmloriginal.ToLower().LastIndexOf("<frameset");
                    pos2 = htmloriginal.ToLower().LastIndexOf("</frameset>");
                    int l = pos2 - pos + 11;
                    htmlnuevo = html.Substring(pos, l);
                    htmloriginal = htmloriginal.Replace(htmlnuevo, "<iframe src=\"v3_document.htm\" width=\"100%\" height=\"500\"></iframe>");
                    pos = htmloriginal.IndexOf("var szHTML=\"<frameset");
                    if (pos > 0)
                    {
                        pos2 = htmloriginal.IndexOf("close();", pos);
                        htmloriginal = htmloriginal.Remove(pos, pos2 - pos + 8);
                    }
                }
                else
                {
                    file = "v3_document.htm";
                    fhtm = new FileInfo(f.DirectoryName + "\\" + name + doc.WebOptions.FolderSuffix + "\\" + file);
                    if (!fhtm.Exists)
                    {
                        file = "v3_document.html";

                    }
                    pos = htmloriginal.ToLower().LastIndexOf("</html>");
                    htmloriginal = htmloriginal.Insert(pos, "<iframe src=\"" + file + "\" width=\"100%\" height=\"500\"></iframe>");
                }
            }

            pos = htmloriginal.ToLower().LastIndexOf("<script");
            while (pos != -1)
            {
                pos2 = htmloriginal.ToLower().LastIndexOf("</script>");
                if (pos2 != -1)
                {
                    String htmlscript = htmloriginal.Substring(pos, pos2 - pos + 9);
                    htmloriginal = htmloriginal.Replace(htmlscript, "");
                    pos = htmloriginal.ToLower().LastIndexOf("<script");
                }
                else
                {
                    pos = -1;
                }
                pos = htmloriginal.ToLower().LastIndexOf("<script");
            }
            f.Delete();
            FileStream fout = f.Open(FileMode.Create, FileAccess.ReadWrite, FileShare.ReadWrite);
            byte[] bcont = System.Text.Encoding.Default.GetBytes(htmloriginal);
            fout.Write(bcont, 0, bcont.Length);
            fout.Close();
            return htmloriginal;
        }
        /// <summary>
        /// Acción al activar ventana
        /// </summary>
        /// <param name="doc"></param>
        /// <param name="window"></param>
        /// <param name="user"></param>
        public void ActivateWindow(PowerPoint.Presentation doc, PowerPoint.DocumentWindow window, CUserAdmin user)
        {
            CPowerPoint.doc = doc;
            CPowerPoint.user = user;
            Verificacontenido();
            if (user == null)
            {
                return;
            }
            if (user.ID >= 0) // el usuario no esta registrado
            {

                return;
            }


        }
        /// <summary>
        /// Elimina asociación contenido sección, sitio
        /// </summary>
        /// <param name="app"></param>
        /// <param name="user"></param>
        /// <returns></returns>
        public CUserAdmin menuLink(PowerPoint.Application app, CUserAdmin user)
        {
            CPowerPoint.app = app;
            if (isDocumentoNull())
            {
                return user;
            }
            CPowerPoint.doc = (PowerPoint.Presentation)app.ActivePresentation;
            CPowerPoint.user = user;
            if (CPowerPoint.user == null)
            {
                CPowerPoint.user = this.Login(doc.Application);
            }
            if (CPowerPoint.user == null || CPowerPoint.user.ID <= 0)
            {
                CPowerPoint.user = this.Login(doc.Application);
            }
            if (!isValidSession())
            {
                return user;
            }

            Office.DocumentProperties props = (Office.DocumentProperties)CPowerPoint.doc.CustomDocumentProperties;
            String topicmap = "";
            String topicid = "";
            String idcont = "";
            foreach (Office.DocumentProperty prop in props)
            {
                if (prop.Name.Equals("content"))
                {
                    idcont = (String)prop.Value;
                }
                if (prop.Name.Equals("topicid"))
                {
                    topicid = (String)prop.Value;
                }
                if (prop.Name.Equals("topicmap"))
                {
                    topicmap = (String)prop.Value;
                }
            }
            if (idcont.Equals("") || topicid.Equals("") || topicmap.Equals(""))
            {
                MessageBox.Show(resources.GetString("CWebBuilder.msg2"), resources.GetString("Global.title"), MessageBoxButtons.OK, MessageBoxIcon.Error);
                return CPowerPoint.user;
            }
            Servicios servicio = new Servicios(CPowerPoint.user);
            if (!servicio.existsCont(idcont, topicmap, topicid))
            {
                // debe borrar la liga al contenido
                Office.DocumentProperties props2 = (Office.DocumentProperties)CPowerPoint.doc.CustomDocumentProperties;
                foreach (Office.DocumentProperty prop in props2)
                {
                    if (prop.Name.Equals("link"))
                    {
                        prop.Delete();
                        continue;
                    }
                    if (prop.Name.Equals("content"))
                    {
                        prop.Delete();
                        continue;
                    }
                    if (prop.Name.Equals("topicid"))
                    {
                        prop.Delete();
                        continue;
                    }
                    if (prop.Name.Equals("topicmap"))
                    {
                        prop.Delete();
                        continue;
                    }
                }

                if (doc.Saved == Office.MsoTriState.msoFalse)
                {
                    doc.Save();
                }
                return CPowerPoint.user;
            }
            string confpag = null;
            props = (Office.DocumentProperties)CPowerPoint.doc.CustomDocumentProperties;
            foreach (Office.DocumentProperty prop in props)
            {
                if (prop.Name.Equals("link"))
                {
                    confpag = (string)prop.Value;
                    break;
                }
            }
            FrmPagesConf frm = new FrmPagesConf();
            if (confpag != null && confpag != "")
            {
                frm.checkBoxConfPaginacion.Checked = true;
                frm.txtDownloadFile.Text = confpag;

            }
            if (frm.ShowDialog() == DialogResult.OK)
            {
                String conf = "";
                if (frm.checkBoxConfPaginacion.Checked)
                {
                    conf = frm.txtDownloadFile.Text;
                }
                bool existeConf = false;
                props = (Office.DocumentProperties)CPowerPoint.doc.CustomDocumentProperties;
                foreach (Office.DocumentProperty prop in props)
                {
                    if (prop.Name.Equals("link"))
                    {
                        prop.Value = conf;
                        existeConf = true;
                        break;
                    }
                }
                if (!existeConf)
                {
                    string str = "";
                    System.Object nullObjStr = str;
                    props.Add("link", false, Office.MsoDocProperties.msoPropertyTypeString, conf, nullObjStr);
                }
                Servicios s = new Servicios(CPowerPoint.user);

                ParameterCollection parameters = new ParameterCollection();

                if (frm.checkBoxConfPaginacion.Checked)
                {
                    parameters.Add(new Parameter("link", "true"));
                    parameters.Add(new Parameter("text", frm.txtDownloadFile.Text));
                }
                else
                {
                    parameters.Add(new Parameter("link", "false"));
                }

                parameters.Add(new Parameter("topicmap", topicmap));
                parameters.Add(new Parameter("topicid", topicid));
                parameters.Add(new Parameter("contentid", idcont));

                XmlDocument resp = s.addLinkToPPT(parameters);
                if (resp.GetElementsByTagName("pag").Count > 0)
                {
                    MessageBox.Show(resppt.GetString("msgPagDone"), resources.GetString("Global.title"), MessageBoxButtons.OK, MessageBoxIcon.Information);
                }


                if (doc.Saved == Office.MsoTriState.msoFalse)
                {
                    doc.Save();
                }
            }
            return CPowerPoint.user;
        }

    }
}
