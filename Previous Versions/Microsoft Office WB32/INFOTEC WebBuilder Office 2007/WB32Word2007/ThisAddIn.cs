using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Xml.Linq;
using System.Globalization;
using System.Threading;
using System.Windows.Forms;
using Word = Microsoft.Office.Interop.Word;
using Office = Microsoft.Office.Core;
using WBWord;
namespace WB32Word2007
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
				catch(Exception ue)
				{
					MessageBox.Show(ue.Message+"\r\n"+ue.StackTrace);
				}
#elif (DEBUG) 
				try
				{
					Thread.CurrentThread.CurrentUICulture=new CultureInfo("",false);                    
				}
				catch(Exception ue)
				{
					MessageBox.Show(ue.Message+"\r\n"+ue.StackTrace);
				}
#else
            try
            {
                
                Thread.CurrentThread.CurrentUICulture = new CultureInfo("es", false);                                
            }
            catch (Exception ue)
            {
                MessageBox.Show(ue.Message + "\r\n" + ue.StackTrace);
            }
#endif
            Connect.wb = new CWebBuilder();
            this.Application.DocumentOpen += new Microsoft.Office.Interop.Word.ApplicationEvents4_DocumentOpenEventHandler(app_DocumentOpen);
            this.Application.DocumentChange += new Microsoft.Office.Interop.Word.ApplicationEvents4_DocumentChangeEventHandler(app_DocumentChange);                        
        }

        private void ThisAddIn_Shutdown(object sender, System.EventArgs e)
        {
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

        public void app_DocumentChange()
        {
            app_DocumentOpen(null);
        }
        public void app_DocumentOpen(Microsoft.Office.Interop.Word.Document document)
        {
            ribbon.InvalidateControls();
        }
    }
}
