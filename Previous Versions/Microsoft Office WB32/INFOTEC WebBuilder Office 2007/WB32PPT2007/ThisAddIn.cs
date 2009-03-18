using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Xml.Linq;
using System.Globalization;
using System.Threading;
using System.Windows.Forms;

using PowerPoint = Microsoft.Office.Interop.PowerPoint;
using Office = Microsoft.Office.Core;
using WBPPT;
namespace WB32PPT2007
{
    public partial class ThisAddIn
    {
        private Ribbon1 ribbon;
        private void ThisAddIn_Startup(object sender, System.EventArgs e)
        {
#if(INGLES)
				try
				{
					Thread.CurrentThread.CurrentUICulture=new CultureInfo("en",false);													
				}
				catch(Exception e)
				{
					MessageBox.Show(ue.Message+"\r\n"+ue.StackTrace);
				}
#elif (DEBUG) 
				try
				{
					Thread.CurrentThread.CurrentUICulture=new CultureInfo("es",false);													
				}
				catch(Exception ue)
				{
					MessageBox.Show(ue.Message+"\r\n"+ue.StackTrace);
				}
#else
            try
            {
                Thread.CurrentThread.CurrentUICulture = new CultureInfo("", false);
            }
            catch (Exception ue)
            {
                MessageBox.Show(ue.Message + "\r\n" + ue.StackTrace);
            }
#endif
            WBPowerPoint.Connect.wbe = new WBPowerPoint.CPowerPoint();
            this.Application.AfterNewPresentation += new Microsoft.Office.Interop.PowerPoint.EApplication_AfterNewPresentationEventHandler(applicationObject_PresentationOpen);
            this.Application.AfterPresentationOpen += new Microsoft.Office.Interop.PowerPoint.EApplication_AfterPresentationOpenEventHandler(applicationObject_PresentationOpen);
            this.Application.PresentationClose += new Microsoft.Office.Interop.PowerPoint.EApplication_PresentationCloseEventHandler(applicationObject_PresentationOpen);      
        }
        protected override object RequestService(Guid serviceGuid)
        {
            if (serviceGuid == typeof(Office.IRibbonExtensibility).GUID)
            {
                if (ribbon == null)
                    ribbon = new Ribbon1(this.Application);
                return ribbon;
            }

            return base.RequestService(serviceGuid);
        }
        public void applicationObject_PresentationOpen(Microsoft.Office.Interop.PowerPoint.Presentation presentation)
        {
            ribbon.InvalidateControls();
        } 

        private void ThisAddIn_Shutdown(object sender, System.EventArgs e)
        {
        }

        #region VSTO generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InternalStartup()
        {
            this.Startup += new System.EventHandler(ThisAddIn_Startup);
            this.Shutdown += new System.EventHandler(ThisAddIn_Shutdown);
        }
        
        #endregion
    }
}
