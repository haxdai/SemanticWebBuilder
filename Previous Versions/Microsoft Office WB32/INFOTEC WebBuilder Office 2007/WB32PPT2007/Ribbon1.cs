using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using System.Text;
using System.Reflection;
using System.Runtime.InteropServices;
using System.Windows.Forms;
using System.Drawing;
using Office = Microsoft.Office.Core;
using PowerPoint = Microsoft.Office.Interop.PowerPoint;
namespace WBPPT
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
        PowerPoint.Application applicationObject;
        private Office.IRibbonUI ribbonUI;
        WBOffice3.CUserAdmin user;
        System.Resources.ResourceManager resources = new System.Resources.ResourceManager("WB32PPT2007.ResourceConfig", Assembly.GetExecutingAssembly());
        public Ribbon1(PowerPoint.Application applicationObject)
        {
            this.applicationObject = applicationObject;
        }

        #region IRibbonExtensibility Members

        public string GetCustomUI(string ribbonID)
        {
            return GetResourceText("WB32PPT2007.Ribbon1.xml");
        }

        #endregion

        #region Ribbon Callbacks

        public void OnLoad(Office.IRibbonUI ribbonUI)
        {
            this.ribbonUI = ribbonUI;
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
        public stdole.IPictureDisp LoadImage(Office.IRibbonControl control)
        {
            try
            {
                Bitmap image = (Bitmap)resources.GetObject(control.Id);
                return WBPPT.PictureConverter.ImageToPictureDisp(image);
            }
            catch (Exception e)
            {
                Log(e);
                return null;
            }
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

        public bool isDocument(Office.IRibbonControl control)
        {
            if (this.applicationObject.Presentations.Count == 0)
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
                PowerPoint.Presentation presentation = this.applicationObject.ActivePresentation;
                if (presentation == null)
                {
                    return false;
                }
                Microsoft.Office.Core.DocumentProperties props = (Microsoft.Office.Core.DocumentProperties)presentation.CustomDocumentProperties;
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
        #region Funciones de WB 3.1
        public void onBitacora(Office.IRibbonControl control)
        {
            try
            {


                WBPowerPoint.Connect.wbe.Bitacora(this.applicationObject, user);
                this.InvalidateControls();
            }
            catch (Exception ue)
            {
                Debug.WriteLine(ue.Message);
            }
        }
        public void onInfo(Office.IRibbonControl control)
        {
            try
            {


                WBPowerPoint.Connect.wbe.ResumenArchivos(this.applicationObject, user);
                this.InvalidateControls();
            }
            catch (Exception ue)
            {
                Debug.WriteLine(ue.Message);
            }
        }
        public void onMenuLink(Office.IRibbonControl control)
        {
            try
            {


                WBPowerPoint.Connect.wbe.menuLink(this.applicationObject, user);
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


                WBPowerPoint.Connect.wbe.ShowPagina();
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

                WBPowerPoint.Connect.wbe.ShowManual();
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


                WBPowerPoint.Connect.wbe.Preview(this.applicationObject, user);
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


                WBPowerPoint.Connect.wbe.MuestraFlujo(this.applicationObject, user);
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


                WBPowerPoint.Connect.wbe.deleteAsociation();
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


                WBPowerPoint.Connect.wbe.Delete(this.applicationObject, user);
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


                WBPowerPoint.Connect.wbe.ChangePassword(this.applicationObject, user);
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


                WBPowerPoint.Connect.wbe.CreateTopic(this.applicationObject, user);
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


                WBPowerPoint.Connect.wbe.CreateRule(this.applicationObject, user);
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


                WBPowerPoint.Connect.wbe.About();
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


                WBPowerPoint.Connect.wbe.Properties(this.applicationObject, user);
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


                WBPowerPoint.Connect.wbe.New(this.applicationObject, user);
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


                WBPowerPoint.Connect.wbe.Open(this.applicationObject, user);
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


                WBPowerPoint.CPowerPoint.user = WBPowerPoint.Connect.wbe.Logout(this.applicationObject, user);
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


                WBPowerPoint.CPowerPoint.user = WBPowerPoint.Connect.wbe.Login(this.applicationObject);
                this.InvalidateControls();
            }
            catch (Exception ue)
            {
                Debug.WriteLine(ue.Message);
            }

        }
        #endregion
        public void InvalidateControls()
        {
            try
            {
                this.user = WBPowerPoint.CPowerPoint.user;
                this.ribbonUI.InvalidateControl("init");
                this.ribbonUI.InvalidateControl("close");
                this.ribbonUI.InvalidateControl("preview");
                this.ribbonUI.InvalidateControl("propiedades");
                this.ribbonUI.InvalidateControl("rules");
                this.ribbonUI.InvalidateControl("download");
                this.ribbonUI.InvalidateControl("deletelink");
                this.ribbonUI.InvalidateControl("delete");
                this.ribbonUI.InvalidateControl("save");
                this.ribbonUI.InvalidateControl("addlink");
            }
            catch (Exception e)
            {
                Debug.WriteLine(e.Message);
            }
        }
    }
}
