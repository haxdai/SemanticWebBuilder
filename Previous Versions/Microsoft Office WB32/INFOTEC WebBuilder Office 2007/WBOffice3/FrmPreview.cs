/*	INFOTEC WebBuilder es una herramienta para el desarrollo de portales de conocimiento, colaboraci�n e integraci�n para Internet, la cual, es una creaci�n original del Fondo de Informaci�n y Documentaci�n para la Industria INFOTEC, misma que se encuentra debidamente registrada ante el Registro P�blico del Derecho de Autor de los Estados Unidos Mexicanos con el No. 03-2002-052312015400-14, para la versi�n 1; No. 03-2003-012112473900 para la versi�n 2, y No. 03-2006-012012004000-01 para la versi�n 3, respectivamente. 
	INFOTEC pone a su disposici�n la herramienta INFOTEC WebBuilder a trav�s de su licenciamiento abierto al p�blico (�open source�), en virtud del cual, usted podr� usarlo en las mismas condiciones con que INFOTEC lo ha dise�ado y puesto a su disposici�n; aprender de �l; distribuirlo a terceros; acceder a su c�digo fuente y modificarlo, y combinarlo o enlazarlo con otro software, todo ello de conformidad con los t�rminos y condiciones de la LICENCIA ABIERTA AL P�BLICO que otorga INFOTEC para la utilizaci�n de INFOTEC WebBuilder 3.2
	INFOTEC no otorga garant�a sobre INFOTEC WebBuilder, de ninguna especie y naturaleza, ni impl�cita ni expl�cita, siendo usted completamente responsable de la utilizaci�n que le d� y asumiendo la totalidad de los riesgos que puedan derivar de la misma.
	Si usted tiene cualquier duda o comentario sobre INFOTEC WebBuilder, INFOTEC pone a su disposici�n la siguiente direcci�n electr�nica: http://www.webbuilder.org.mx	
*/
using System;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.Windows.Forms;
using WBOffice3;
namespace WBOffice3
{
	/// <summary>Forma que presenta un browser con un contenido en presentaci�n preeliminar</summary>
	public class FrmPreview : System.Windows.Forms.Form
	{
		
		
		/// <summary>
		/// Required designer variable.
		/// </summary>
		private System.ComponentModel.Container components = null;
		String topicmap,topicid,contentid;
		CUserAdmin admin;		
		String url;
        private WebBrowser webBrowser1;
		String navigateURL;
		/// <summary>Crea la forma con una direcci�n Web a mostrar</summary>
		/// <param name="url">Url a mostrar</param>
		public FrmPreview(String url)
		{
			//
			// Required for Windows Form Designer support
			//
			InitializeComponent();
			
			System.Object nullObject = 0;
			string str = "";
			System.Object nullObjStr = str;	
			//string headers="WBCookie:JSESSIONID="+ CRequest.idsesion +"\r\n";
			string headers="Content-Type: application/x-www-form-urlencoded";
			System.Object headerObjStr = headers;
            this.webBrowser1.Navigate(url);
			//this.axWebBrowser1.Navigate(url,ref nullObject, ref nullObjStr, ref nullObjStr, ref headerObjStr);								
			navigateURL=url;
		}
        public FrmPreview(String topicmap, String topicid, String contentid,CUserAdmin admin)
        {
            //
            // Required for Windows Form Designer support
            //
            InitializeComponent();

            this.topicmap = topicmap;
            this.topicid = topicid;
            this.contentid = contentid;
            this.admin = admin;
            object missing = Type.Missing;
            //			string headers="Content-Type: application/x-www-form-urlencoded\r\n";			
            Servicios s = new Servicios(admin);


            s = new Servicios(admin);
            //url=s.getURLPreview(this.topicmap,this.topicid,this.contentid);
            url = "/wb/WBAdmin/WBAd_utl_ResourcePreview/_rid/" + this.contentid + "/_idtm/" + this.topicmap + "/_mto/3/_wst/maximized";
            //url="wb/WBAdmin/WBAd_utl_ResourcePreview/_cnt?wbcntid="+this.contentid+"&wbcntidtm="+this.topicmap;
            url += "?wblastversion=1&" + "_wb_username=" + admin.User + "&_wb_password=" + admin.Password;            
            /*if(url.StartsWith("/wb/"))
            {
                url=url.Substring(3);
                url="login"+url;
            }*/
            if (admin.Uri.EndsWith("/"))
            {
                url = url.Substring(1);
            }
            navigateURL = admin.Uri + url;
            if (s.isModeWeb(this.contentid, this.topicmap, this.topicid))
            {
                this.webBrowser1.Navigate(navigateURL);
                //this.axWebBrowser1.Navigate(navigateURL,ref missing, ref missing,ref missing, ref missing);											
            }
            else
            {
                System.Diagnostics.Process.Start("explorer.exe", "\"" + navigateURL + "\"");
                this.Close();
            }


        }
		/// <summary>
		/// Constructor de forma para presentaci�n preeliminar
		/// </summary>
		/// <param name="topicmap">Sitio donde se encuentra el contenido</param>
		/// <param name="topicid">Secci�n donde se encuentra el contenido</param>
		/// <param name="contentid">Identificador de contenido</param>
		/// <param name="lastversion">�ltima versi�n existente</param>
		/// <param name="admin">Usuario</param>
		public FrmPreview(String topicmap,String topicid,String contentid,String lastversion,CUserAdmin admin)
		{
			//
			// Required for Windows Form Designer support
			//
			InitializeComponent();

			this.topicmap=topicmap;
			this.topicid=topicid;
			this.contentid=contentid;
			this.admin=admin;			
			object missing = Type.Missing;			
//			string headers="Content-Type: application/x-www-form-urlencoded\r\n";			
			Servicios s=new Servicios(admin);
			

			s=new Servicios(admin);
			//url=s.getURLPreview(this.topicmap,this.topicid,this.contentid);
			url="/wb/WBAdmin/WBAd_utl_ResourcePreview/_rid/"+this.contentid+"/_idtm/"+ this.topicmap+"/_mto/3/_wst/maximized";
			//url="wb/WBAdmin/WBAd_utl_ResourcePreview/_cnt?wbcntid="+this.contentid+"&wbcntidtm="+this.topicmap;
			if(lastversion!=null)
			{
                url += "?wbresversion=" + lastversion + "&" + "_wb_username=" + admin.User + "&_wb_password=" + admin.Password;
                //wbresversion
			}
			/*if(url.StartsWith("/wb/"))
			{
				url=url.Substring(3);
				url="login"+url;
			}*/	
			if(admin.Uri.EndsWith("/"))
			{
				url=url.Substring(1);
			}
			navigateURL=admin.Uri+url;
			if(s.isModeWeb(this.contentid,this.topicmap,this.topicid))
			{
                this.webBrowser1.Navigate(navigateURL);
				//this.axWebBrowser1.Navigate(navigateURL,ref missing, ref missing,ref missing, ref missing);											
			}
			else
			{
				System.Diagnostics.Process.Start("explorer.exe","\""+navigateURL+"\"");
				this.Close();			
			}
			

		}
		/// <summary>
		/// Direcci�n URL para presentar
		/// </summary>
		public String Navigate
		{
			get
			{
				return navigateURL;
			}
		}
		/// <summary>
		/// Clean up any resources being used.
		/// </summary>
		protected override void Dispose( bool disposing )
		{
			if( disposing )
			{
				if(components != null)
				{
					components.Dispose();
				}
			}
			base.Dispose( disposing );
		}

		#region Windows Form Designer generated code
		/// <summary>
		/// Required method for Designer support - do not modify
		/// the contents of this method with the code editor.
		/// </summary>
		private void InitializeComponent()
		{
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(FrmPreview));
            this.webBrowser1 = new System.Windows.Forms.WebBrowser();
            this.SuspendLayout();
            // 
            // webBrowser1
            // 
            resources.ApplyResources(this.webBrowser1, "webBrowser1");
            this.webBrowser1.MinimumSize = new System.Drawing.Size(20, 20);
            this.webBrowser1.Name = "webBrowser1";
            // 
            // FrmPreview
            // 
            resources.ApplyResources(this, "$this");
            this.Controls.Add(this.webBrowser1);
            this.MinimizeBox = false;
            this.Name = "FrmPreview";
            this.ShowInTaskbar = false;
            this.ResumeLayout(false);

		}
		#endregion

		
		
	}
}
