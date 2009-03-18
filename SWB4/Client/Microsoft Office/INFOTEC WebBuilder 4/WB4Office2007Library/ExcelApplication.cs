﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;
using WBOffice4;
using Excel = Microsoft.Office.Interop.Excel;
using Office = Microsoft.Office.Core;
namespace WB4Office2007Library
{
    public class ExcelApplication : OfficeApplication
    {
        private static object missing = Type.Missing;
        
        private Excel.Application application;
        public ExcelApplication(Excel.Application application)
        {            
            this.application = application;
            this.application.WorkbookOpen += new Microsoft.Office.Interop.Excel.AppEvents_WorkbookOpenEventHandler(ApplicationWorkbookOpen);            
            this.application.WorkbookBeforeClose += new Microsoft.Office.Interop.Excel.AppEvents_WorkbookBeforeCloseEventHandler(ApplicationWorkbookBeforeClose);            
            this.application.WorkbookActivate += new Microsoft.Office.Interop.Excel.AppEvents_WorkbookActivateEventHandler(ApplicationWorkbookOpen);
            if (this.application.ActiveWorkbook != null)
            {
                ActivateDocument(this.application.ActiveWorkbook);
            }

        }        
        private void ActivateDocument(Excel.Workbook workbook)
        {
            OfficeDocument officeDocument = new Excel2007OfficeDocument(workbook);
            if (officeDocument.IsPublished)
            {
                if (MenuListener != null)
                {
                    OfficeApplication.MenuListener.DocumentPublished();
                }
            }
            else
            {
                if (MenuListener != null)
                {
                    OfficeApplication.MenuListener.NoDocumentPublished();
                }
            }
        }
        private void ApplicationWorkbookBeforeClose(Excel.Workbook workbook, ref bool cancel)
        {
            if (workbook.Application.Workbooks.Count == 1)
            {
                // Es el último
                if (MenuListener != null)
                {
                    OfficeApplication.MenuListener.NoDocumentsActive();
                }
            }
            else
            {
                if (MenuListener != null)
                {
                    OfficeApplication.MenuListener.DocumentsActive();
                }
            }
        }
        private void ApplicationWorkbookOpen(Excel.Workbook workbook)
        {
            ActivateDocument(workbook);
        }
        protected override string Version
        {
            get
            {
                return application.Version;
            }
        }
        protected override ICollection<OfficeDocument> Documents
        {
            get
            {
                List<OfficeDocument> documents = new List<OfficeDocument>();
                foreach (Excel.Workbook workbook in this.application.Workbooks)
                {
                    documents.Add(new Excel2007OfficeDocument(workbook));
                }
                return documents;
            }

        }
        protected override OfficeDocument Open(System.IO.FileInfo file)
        {            
            Excel.Workbook workbook = application.Workbooks.Open(file.FullName, missing, missing, missing, missing, missing, missing, missing, missing, missing, missing, missing, missing, missing, missing);
            return new Excel2007OfficeDocument(workbook);
        }
    }
}
