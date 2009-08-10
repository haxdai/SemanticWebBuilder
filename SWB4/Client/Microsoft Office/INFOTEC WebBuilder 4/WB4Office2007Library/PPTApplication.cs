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
*  http://www.webbuilder.org.mx 
**/ 
 
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
