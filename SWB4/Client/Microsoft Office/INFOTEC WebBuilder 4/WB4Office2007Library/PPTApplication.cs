﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;
using WBOffice4;
using WB4Office2007Library;
using PowerPoint = Microsoft.Office.Interop.PowerPoint;
using Office = Microsoft.Office.Core;

namespace WB4Office2007Library
{
    public class PptApplication : OfficeApplication
    {
        public const String HtmlExtension = ".html";
        private PowerPoint.Application application;        
        public PptApplication(PowerPoint.Application application)
        {
            this.application = application;
            this.application.PresentationOpen += new Microsoft.Office.Interop.PowerPoint.EApplication_PresentationOpenEventHandler(PresentationOpen);
            this.application.WindowActivate += new Microsoft.Office.Interop.PowerPoint.EApplication_WindowActivateEventHandler(PresentationNew);            
            this.application.PresentationClose += new Microsoft.Office.Interop.PowerPoint.EApplication_PresentationCloseEventHandler(PresentationClose);            
        }
        private void ActivateDocument(Microsoft.Office.Interop.PowerPoint.Presentation presentation)
        {
            OfficeDocument officeDocument = new PowerPoint2007OfficeDocument(presentation);
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
        private void PresentationOpen(PowerPoint.Presentation presentation)
        {
            ActivateDocument(presentation);
        }
        private void PresentationNew(PowerPoint.Presentation presentation,PowerPoint.DocumentWindow window)
        {
            ActivateDocument(presentation);
        }
        private void PresentationClose(PowerPoint.Presentation presentation)
        {
            if (presentation.Application.Presentations.Count == 1)
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
                foreach (PowerPoint.Presentation presentation in this.application.Presentations)
                {
                    documents.Add(new PowerPoint2007OfficeDocument(presentation));
                }
                return documents;
            }

        }
        protected override OfficeDocument Open(System.IO.FileInfo file)
        {
            string filedocxtoOpen = file.FullName;
            if (file.Extension.Equals(HtmlExtension, StringComparison.CurrentCultureIgnoreCase) || file.Extension.Equals(".htm", StringComparison.CurrentCultureIgnoreCase))
            {
                FileInfo docFile = new FileInfo(file.FullName.Replace(file.Extension, ".ppt"));
                if (docFile.Exists)
                {
                    filedocxtoOpen = docFile.FullName;
                }
            }            
            PowerPoint.Presentation presentation = application.Presentations.Open(filedocxtoOpen, Office.MsoTriState.msoFalse, Office.MsoTriState.msoFalse, Office.MsoTriState.msoTrue);
            return new PowerPoint2007OfficeDocument(presentation);    
        }
    }
}
