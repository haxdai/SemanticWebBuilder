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
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using WBOffice4.Steps;
using WBOffice4.Interfaces;
namespace WBOffice4.Forms
{
    public partial class FormPublishcontentToPage : TSWizards.BaseWizard
    {
        private OfficeDocument document;
        private String title,description;
        public FormPublishcontentToPage(OfficeDocument document)
        {
            InitializeComponent();
            this.document = document;            

        }        
        public FormPublishcontentToPage(OfficeDocument document,String title,String description)
        {
            InitializeComponent();
            this.document = document;
            this.title = title;
            this.description = description;
        }

        private void FormPublishcontentToPage_LoadSteps(object sender, EventArgs e)
        {
            PropertyInfo[] properties = OfficeApplication.OfficeDocumentProxy.getResourceProperties(document.reporitoryID, document.contentID);
            if (title == null || description == null)
            {
                this.AddStep(new TitleAndDescription(document,false));
                this.AddStep(new SelectVersionToPublish(document));
                if (properties != null && properties.Length > 0)
                {
                    this.AddStep(new ViewProperties());
                }
                this.AddStep(new SelectSitePublish(document));
                
            }
            else
            {                
                this.AddStep(new SelectVersionToPublish(document));
                if (properties != null && properties.Length > 0)
                {
                    this.AddStep(new ViewProperties());
                }                
                this.AddStep(new SelectSitePublish(title, description,document));                
            }
            
        }
    }
}
