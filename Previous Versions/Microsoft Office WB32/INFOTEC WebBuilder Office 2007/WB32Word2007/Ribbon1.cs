using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using System.Text;
using System.Reflection;
using System.Runtime.InteropServices;
using System.Windows.Forms;
using Word = Microsoft.Office.Interop.Word;
using Office = Microsoft.Office.Core;
using System.Drawing;
namespace WBWord
{
    // TODO:
    // This is an override of the RequestService method in the ThisAddIn class.
    // To hook up your custom ribbon uncomment this code.
    //public partial class ThisAddIn
    //{
    //    private Ribbon1 ribbon;
    //
    //    protected override object RequestService(Guid serviceGuid)
    //    {
    //        if (serviceGuid == typeof(Office.IRibbonExtensibility).GUID)
    //        {
    //            if (ribbon == null)
    //                ribbon = new Ribbon1();
    //            return ribbon;
    //        }
    //
    //        return base.RequestService(serviceGuid);
    //    }
    //}

    [ComVisible(true)]
    public class Ribbon1 : Office.IRibbonExtensibility
    {
        System.Resources.ResourceManager resources = new System.Resources.ResourceManager("WB32Word2007.ResourceConfig", Assembly.GetExecutingAssembly());
        WBOffice3.CUserAdmin user;
        private Office.IRibbonUI ribbonUI;
        Word.Application applicationObject;
        public Ribbon1(Word.Application applicationObject)
        {
            this.applicationObject = applicationObject;
        }

        #region IRibbonExtensibility Members

        public string GetCustomUI(string ribbonID)
        {
            return GetResourceText("WB32Word2007.Ribbon1.xml");
        }
        public bool GetInitEnabled(Office.IRibbonControl control)
        {
            if (user == null || user.ID <= 0)
            {
                return true;
            }
            return false;
        }
        public bool GetCloseEnabled(Office.IRibbonControl control)
        {
            if (user == null || user.ID <= 0)
            {
                return false;
            }
            return true;
        }
        #endregion

        #region Ribbon Callbacks

        public void OnLoad(Office.IRibbonUI ribbonUI)
        {
            this.ribbonUI = ribbonUI;                                   
            
            
        }
               

        #endregion

        #region Helpers

        private static string GetResourceText(string resourceName)
        {
            Assembly asm = Assembly.GetExecutingAssembly();
            string[] resourceNames = asm.GetManifestResourceNames();
            for (int i = 0; i < resourceNames.Length; ++i)
            {
                if (string.Compare(resourceName, resourceNames[i], StringComparison.OrdinalIgnoreCase) == 0)
                {
                    using (StreamReader resourceReader = new StreamReader(asm.GetManifestResourceStream(resourceNames[i])))
                    {
                        if (resourceReader != null)
                        {
                            return resourceReader.ReadToEnd();
                        }
                    }
                }
            }
            return null;
        }

        #endregion
        #region Funciones WB 3.2
        public void InvalidateControls()
        {
            try
            {
                this.user = WBWord.CWebBuilder.user;
                if (this.ribbonUI != null)
                {
                    this.ribbonUI.InvalidateControl("init");
                    this.ribbonUI.InvalidateControl("info");
                    this.ribbonUI.InvalidateControl("close");
                    this.ribbonUI.InvalidateControl("preview");
                    this.ribbonUI.InvalidateControl("propiedades");
                    this.ribbonUI.InvalidateControl("rules");
                    this.ribbonUI.InvalidateControl("download");
                    this.ribbonUI.InvalidateControl("deletelink");
                    this.ribbonUI.InvalidateControl("delete");
                    this.ribbonUI.InvalidateControl("save");
                    this.ribbonUI.InvalidateControl("bitacora");
                    this.ribbonUI.InvalidateControl("pag");                    
                    this.ribbonUI.InvalidateControl("addlink");
                }
            }
            catch (Exception e)
            {
                Debug.WriteLine(e.Message);
            }
        }
        public void onBitacora(Office.IRibbonControl control)
        {
            try
            {                

                Connect.wb.Bitacora(this.applicationObject, user);
                this.InvalidateControls();
            }
            catch (Exception ue)
            {
                Debug.WriteLine(ue.Message);
            }
        }        
        private static void Log(string msg)
        {
            System.Diagnostics.TextWriterTraceListener listener = new System.Diagnostics.TextWriterTraceListener(@"c:\temp\log.txt");
            listener.WriteLine(msg);
            listener.Flush();
            listener.Close();
        }
        private static void Log(Exception e)
        {
            Log(e.Message);
            Log(e.StackTrace);
        }
        public bool isDocument(Office.IRibbonControl control)
        {
            if (this.applicationObject.Documents.Count == 0)
            {
                return false;
            }
            return true;
        }
        public bool isWBDocument(Office.IRibbonControl control)
        {
            try
            {
                if (!isDocument(null))
                {
                    return false;
                }
                Word.Document document = this.applicationObject.ActiveDocument;
                if (document == null)
                {
                    return false;
                }
                Microsoft.Office.Core.DocumentProperties props = (Microsoft.Office.Core.DocumentProperties)document.CustomDocumentProperties;
                if (props["content"] == null || props["content"].Value == null || string.IsNullOrEmpty(props["content"].Value.ToString()))
                {
                    return false;
                }
                if (props["topicmap"] == null || props["topicmap"].Value == null || string.IsNullOrEmpty(props["topicmap"].Value.ToString()))
                {
                    return false;
                }
                if (props["topicid"] == null || props["topicid"].Value == null || string.IsNullOrEmpty(props["topicid"].Value.ToString()))
                {
                    return false;
                }
            }
            catch
            {
                return false;
            }
            return true;
        }
        public stdole.IPictureDisp LoadImage(Office.IRibbonControl control)
        {
            try
            {
                Bitmap image = (Bitmap)resources.GetObject(control.Id);
                return PictureConverter.ImageToPictureDisp(image);
            }
            catch (Exception e)
            {
                Log(e);
                return null;
            }
        }
        public void onInfo(Office.IRibbonControl control)
        {
            try
            {


                Connect.wb.ResumenArchivos(this.applicationObject, user);
                this.InvalidateControls();
            }
            catch (Exception ue)
            {
                Debug.WriteLine(ue.Message);
            }
        }
        public void onAddLink(Office.IRibbonControl control)
        {
            try
            {


                Connect.wb.AddLink(this.applicationObject, user);
                this.InvalidateControls();
            }
            catch (Exception ue)
            {
                Debug.WriteLine(ue.Message);
            }
        }
        public void onMenuPag(Office.IRibbonControl control)
        {
            try
            {


                Connect.wb.menuPag(this.applicationObject, user);
                this.InvalidateControls();
            }
            catch (Exception ue)
            {
                Debug.WriteLine(ue.Message);
            }
        }
        public void onShowPagina(Office.IRibbonControl control)
        {
            try
            {


                Connect.wb.ShowPagina();
                this.InvalidateControls();
            }
            catch (Exception ue)
            {
                Debug.WriteLine(ue.Message);
            }
        }
        public void onShowManual(Office.IRibbonControl control)
        {
            try
            {


                Connect.wb.ShowManual();
                this.InvalidateControls();
            }
            catch (Exception ue)
            {
                Debug.WriteLine(ue.Message);
            }
        }
        public void onPreview(Office.IRibbonControl control)
        {
            try
            {


                Connect.wb.Preview(this.applicationObject, user);
                this.InvalidateControls();
            }
            catch (Exception ue)
            {
                Debug.WriteLine(ue.Message);
            }
        }
        public void onMuestraFlujo(Office.IRibbonControl control)
        {
            try
            {


                Connect.wb.MuestraFlujo(this.applicationObject, user);
                this.InvalidateControls();
            }
            catch (Exception ue)
            {
                Debug.WriteLine(ue.Message);
            }
        }
        public void onDeleteAsociation(Office.IRibbonControl control)
        {
            try
            {


                Connect.wb.deleteAsociation();
                this.InvalidateControls();
            }
            catch (Exception ue)
            {
                Debug.WriteLine(ue.Message);
            }
        }
        public void onDelete(Office.IRibbonControl control)
        {
            try
            {


                Connect.wb.Delete(this.applicationObject, user);
                this.InvalidateControls();
            }
            catch (Exception ue)
            {
                Debug.WriteLine(ue.Message);
            }
        }
        public void onChangePassword(Office.IRibbonControl control)
        {
            try
            {


                Connect.wb.ChangePassword(this.applicationObject, user);
                this.InvalidateControls();
            }
            catch (Exception ue)
            {
                Debug.WriteLine(ue.Message);
            }
        }
        public void onCreateTopic(Office.IRibbonControl control)
        {
            try
            {


                Connect.wb.CreateTopic(this.applicationObject, user);
                this.InvalidateControls();
            }
            catch (Exception ue)
            {
                Debug.WriteLine(ue.Message);
            }
        }
        public void onCreateRule(Office.IRibbonControl control)
        {
            try
            {


                Connect.wb.CreateRule(this.applicationObject, user);
                this.InvalidateControls();
            }
            catch (Exception ue)
            {
                Debug.WriteLine(ue.Message);
            }
        }
        public void onAbout(Office.IRibbonControl control)
        {
            try
            {


                Connect.wb.About();
                this.InvalidateControls();
            }
            catch (Exception ue)
            {
                Debug.WriteLine(ue.Message);
            }
        }
        public void Onprop(Office.IRibbonControl control)
        {
            try
            {


                Connect.wb.Properties(this.applicationObject, user);
                this.InvalidateControls();
            }
            catch (Exception ue)
            {
                Debug.WriteLine(ue.Message);
            }
        }
        public void onSave(Office.IRibbonControl control)
        {
            try
            {


                Connect.wb.New(this.applicationObject, user);
                this.InvalidateControls();
            }
            catch (Exception ue)
            {
                Debug.WriteLine(ue.Message);
            }
        }
        public void onOpen(Office.IRibbonControl control)
        {
            try
            {


                Connect.wb.Open(this.applicationObject, user);
                this.InvalidateControls();
            }
            catch (Exception ue)
            {
                Debug.WriteLine(ue.Message);
            }
        }
        public void onClose(Office.IRibbonControl control)
        {
            try
            {


                WBWord.CWebBuilder.user = Connect.wb.Logout(this.applicationObject, user);
                this.InvalidateControls();
            }
            catch (Exception ue)
            {
                Debug.WriteLine(ue.Message);
            }

        }
        public void OnInit(Office.IRibbonControl control)
        {
            try
            {
                
                WBWord.CWebBuilder.user = Connect.wb.Login(this.applicationObject);
                this.InvalidateControls();
            }
            catch (Exception ue)
            {
                Debug.WriteLine(ue.Message);
            }

        }
        #endregion
    }
}
