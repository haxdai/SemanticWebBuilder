/*	INFOTEC WebBuilder es una herramienta para el desarrollo de portales de conocimiento, colaboración e integración para Internet, la cual, es una creación original del Fondo de Información y Documentación para la Industria INFOTEC, misma que se encuentra debidamente registrada ante el Registro Público del Derecho de Autor de los Estados Unidos Mexicanos con el No. 03-2002-052312015400-14, para la versión 1; No. 03-2003-012112473900 para la versión 2, y No. 03-2006-012012004000-01 para la versión 3, respectivamente. 
	INFOTEC pone a su disposición la herramienta INFOTEC WebBuilder a través de su licenciamiento abierto al público (‘open source’), en virtud del cual, usted podrá usarlo en las mismas condiciones con que INFOTEC lo ha diseñado y puesto a su disposición; aprender de él; distribuirlo a terceros; acceder a su código fuente y modificarlo, y combinarlo o enlazarlo con otro software, todo ello de conformidad con los términos y condiciones de la LICENCIA ABIERTA AL PÚBLICO que otorga INFOTEC para la utilización de INFOTEC WebBuilder 3.2
	INFOTEC no otorga garantía sobre INFOTEC WebBuilder, de ninguna especie y naturaleza, ni implícita ni explícita, siendo usted completamente responsable de la utilización que le dé y asumiendo la totalidad de los riesgos que puedan derivar de la misma.
	Si usted tiene cualquier duda o comentario sobre INFOTEC WebBuilder, INFOTEC pone a su disposición la siguiente dirección electrónica: http://www.webbuilder.org.mx	
*/
using System;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.Windows.Forms;
using WBOffice3;
using System.Reflection;
using Office = Microsoft.Office.Core;
using System.Diagnostics;
namespace WBWord
{
	/// <summary>Forma que muestra el acceso de un usuario al servidor</summary>
	public class FrmSplash : System.Windows.Forms.Form
	{
		System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(CLibrary));
		/// <summary>Usuario actual</summary>
		/// <value>Usuario actual</value>
		public CUserAdmin user;	
		private System.Windows.Forms.PictureBox pictureBox1;
		private System.Windows.Forms.CheckBox checkBox1;
		private System.Windows.Forms.TextBox textBox3;
		private System.Windows.Forms.TextBox textBox2;
		private System.Windows.Forms.TextBox textBox1;
		private System.Windows.Forms.CheckBox checkBoxabrir;
		private System.Windows.Forms.Label label4;
		/// <summary>
		/// Required designer variable.
		/// </summary>
		private System.ComponentModel.Container components = null;
		/// <summary>Configuración del servidor proxy</summary>
		/// <value>Configuración del servidor proxy</value>
		public String proxyserver="";
		private System.Windows.Forms.Label label5;
		private System.Windows.Forms.Label label2;
		private System.Windows.Forms.Label label1;
		private System.Windows.Forms.Label label3;
		private System.Windows.Forms.Button buttonCancel;
		private System.Windows.Forms.Button buttonEntrar;
		private System.Windows.Forms.Button buttonAvanzado;
		/// <summary>Configuración del puerto del servidor proxy</summary>
		/// <value>Configuración del puerto del servidor proxy</value>
		public String portserverproxy="80";
		
		/// <summary>Crea una forma de accesos a WB</summary>
		/// <param name="user">Usuario que intenta acceder</param>
		public FrmSplash(CUserAdmin user)
		{
			//
			// Required for Windows Form Designer support
			//
			InitializeComponent();

			//
			// TODO: Add any constructor code after InitializeComponent call
			//
			
			this.user=user;
			Assembly asm=Assembly.GetAssembly((new WBOffice3.CConfig()).GetType());				
			char[] sep={',','='};
			string[] data=asm.FullName.Split(sep);
			String version="";
			int i=0;
			foreach(String s in data)
			{
				if(s.IndexOf("Version")!=-1)
				{
					version=data[i+1];
				}
				i++;
			}
			this.label5.Text="Prod No. "+  version		+"";
			//this.label5.Text="Prod. "+ Application.ProductVersion +"";
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(FrmSplash));
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.buttonCancel = new System.Windows.Forms.Button();
            this.checkBox1 = new System.Windows.Forms.CheckBox();
            this.textBox3 = new System.Windows.Forms.TextBox();
            this.buttonEntrar = new System.Windows.Forms.Button();
            this.textBox2 = new System.Windows.Forms.TextBox();
            this.textBox1 = new System.Windows.Forms.TextBox();
            this.checkBoxabrir = new System.Windows.Forms.CheckBox();
            this.label4 = new System.Windows.Forms.Label();
            this.buttonAvanzado = new System.Windows.Forms.Button();
            this.label5 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            this.SuspendLayout();
            // 
            // pictureBox1
            // 
            this.pictureBox1.AccessibleDescription = null;
            this.pictureBox1.AccessibleName = null;
            resources.ApplyResources(this.pictureBox1, "pictureBox1");
            this.pictureBox1.BackgroundImage = null;
            this.pictureBox1.Font = null;
            this.pictureBox1.ImageLocation = null;
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.TabStop = false;
            // 
            // buttonCancel
            // 
            this.buttonCancel.AccessibleDescription = null;
            this.buttonCancel.AccessibleName = null;
            resources.ApplyResources(this.buttonCancel, "buttonCancel");
            this.buttonCancel.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(73)))), ((int)(((byte)(134)))), ((int)(((byte)(31)))));
            this.buttonCancel.BackgroundImage = null;
            this.buttonCancel.DialogResult = System.Windows.Forms.DialogResult.Cancel;
            this.buttonCancel.ForeColor = System.Drawing.Color.White;
            this.buttonCancel.Name = "buttonCancel";
            this.buttonCancel.UseVisualStyleBackColor = false;
            this.buttonCancel.Click += new System.EventHandler(this.button2_Click);
            // 
            // checkBox1
            // 
            this.checkBox1.AccessibleDescription = null;
            this.checkBox1.AccessibleName = null;
            resources.ApplyResources(this.checkBox1, "checkBox1");
            this.checkBox1.BackColor = System.Drawing.Color.White;
            this.checkBox1.BackgroundImage = null;
            this.checkBox1.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(41)))), ((int)(((byte)(73)))), ((int)(((byte)(32)))));
            this.checkBox1.Name = "checkBox1";
            this.checkBox1.UseVisualStyleBackColor = false;
            // 
            // textBox3
            // 
            this.textBox3.AccessibleDescription = null;
            this.textBox3.AccessibleName = null;
            resources.ApplyResources(this.textBox3, "textBox3");
            this.textBox3.BackgroundImage = null;
            this.textBox3.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.textBox3.Name = "textBox3";
            // 
            // buttonEntrar
            // 
            this.buttonEntrar.AccessibleDescription = null;
            this.buttonEntrar.AccessibleName = null;
            resources.ApplyResources(this.buttonEntrar, "buttonEntrar");
            this.buttonEntrar.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(73)))), ((int)(((byte)(134)))), ((int)(((byte)(31)))));
            this.buttonEntrar.BackgroundImage = null;
            this.buttonEntrar.ForeColor = System.Drawing.Color.White;
            this.buttonEntrar.Name = "buttonEntrar";
            this.buttonEntrar.UseVisualStyleBackColor = false;
            this.buttonEntrar.Click += new System.EventHandler(this.button1_Click);
            // 
            // textBox2
            // 
            this.textBox2.AccessibleDescription = null;
            this.textBox2.AccessibleName = null;
            resources.ApplyResources(this.textBox2, "textBox2");
            this.textBox2.BackgroundImage = null;
            this.textBox2.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.textBox2.Name = "textBox2";
            // 
            // textBox1
            // 
            this.textBox1.AccessibleDescription = null;
            this.textBox1.AccessibleName = null;
            resources.ApplyResources(this.textBox1, "textBox1");
            this.textBox1.BackColor = System.Drawing.Color.White;
            this.textBox1.BackgroundImage = null;
            this.textBox1.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.textBox1.Name = "textBox1";
            // 
            // checkBoxabrir
            // 
            this.checkBoxabrir.AccessibleDescription = null;
            this.checkBoxabrir.AccessibleName = null;
            resources.ApplyResources(this.checkBoxabrir, "checkBoxabrir");
            this.checkBoxabrir.BackColor = System.Drawing.Color.White;
            this.checkBoxabrir.BackgroundImage = null;
            this.checkBoxabrir.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(41)))), ((int)(((byte)(73)))), ((int)(((byte)(32)))));
            this.checkBoxabrir.Name = "checkBoxabrir";
            this.checkBoxabrir.UseVisualStyleBackColor = false;
            // 
            // label4
            // 
            this.label4.AccessibleDescription = null;
            this.label4.AccessibleName = null;
            resources.ApplyResources(this.label4, "label4");
            this.label4.BackColor = System.Drawing.Color.White;
            this.label4.Name = "label4";
            // 
            // buttonAvanzado
            // 
            this.buttonAvanzado.AccessibleDescription = null;
            this.buttonAvanzado.AccessibleName = null;
            resources.ApplyResources(this.buttonAvanzado, "buttonAvanzado");
            this.buttonAvanzado.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(73)))), ((int)(((byte)(134)))), ((int)(((byte)(31)))));
            this.buttonAvanzado.BackgroundImage = null;
            this.buttonAvanzado.ForeColor = System.Drawing.Color.White;
            this.buttonAvanzado.Name = "buttonAvanzado";
            this.buttonAvanzado.UseVisualStyleBackColor = false;
            this.buttonAvanzado.Click += new System.EventHandler(this.button3_Click);
            // 
            // label5
            // 
            this.label5.AccessibleDescription = null;
            this.label5.AccessibleName = null;
            resources.ApplyResources(this.label5, "label5");
            this.label5.BackColor = System.Drawing.Color.White;
            this.label5.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.label5.Name = "label5";
            // 
            // label2
            // 
            this.label2.AccessibleDescription = null;
            this.label2.AccessibleName = null;
            resources.ApplyResources(this.label2, "label2");
            this.label2.BackColor = System.Drawing.Color.White;
            this.label2.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(114)))), ((int)(((byte)(169)))), ((int)(((byte)(69)))));
            this.label2.Name = "label2";
            // 
            // label1
            // 
            this.label1.AccessibleDescription = null;
            this.label1.AccessibleName = null;
            resources.ApplyResources(this.label1, "label1");
            this.label1.BackColor = System.Drawing.Color.White;
            this.label1.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(114)))), ((int)(((byte)(169)))), ((int)(((byte)(69)))));
            this.label1.Name = "label1";
            // 
            // label3
            // 
            this.label3.AccessibleDescription = null;
            this.label3.AccessibleName = null;
            resources.ApplyResources(this.label3, "label3");
            this.label3.BackColor = System.Drawing.Color.White;
            this.label3.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(114)))), ((int)(((byte)(169)))), ((int)(((byte)(69)))));
            this.label3.Name = "label3";
            // 
            // FrmSplash
            // 
            this.AcceptButton = this.buttonEntrar;
            this.AccessibleDescription = null;
            this.AccessibleName = null;
            resources.ApplyResources(this, "$this");
            this.BackgroundImage = null;
            this.CancelButton = this.buttonCancel;
            this.Controls.Add(this.textBox2);
            this.Controls.Add(this.buttonEntrar);
            this.Controls.Add(this.textBox1);
            this.Controls.Add(this.textBox3);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.buttonAvanzado);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.checkBoxabrir);
            this.Controls.Add(this.buttonCancel);
            this.Controls.Add(this.checkBox1);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.pictureBox1);
            this.Font = null;
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.Icon = null;
            this.Name = "FrmSplash";
            this.Load += new System.EventHandler(this.FrmSplash_Load);
            this.Activated += new System.EventHandler(this.FrmSplash_Activated);
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

		}
		#endregion

		private void button2_Click(object sender, System.EventArgs e)
		{
			this.DialogResult=DialogResult.Cancel;
			this.Close();
		}

		private void button1_Click(object sender, System.EventArgs e)
		{
			this.DialogResult=DialogResult.Cancel;
			this.Cursor=Cursors.WaitCursor; 
			CConfig c= new CConfig();
			if(this.textBox1.Text.Trim().Equals(""))
			{
				this.Cursor=Cursors.Default; 
				MessageBox.Show(this,resources.GetString("FrmSplash.msg1"),this.Text,MessageBoxButtons.OK,MessageBoxIcon.Error);  
				this.textBox1.Focus(); 
				return;
			}
			if(this.textBox2.Text.Trim().Equals(""))
			{
				this.Cursor=Cursors.Default; 
				MessageBox.Show(this,resources.GetString("FrmSplash.msg2"),this.Text,MessageBoxButtons.OK,MessageBoxIcon.Error);  
				this.textBox2.Focus(); 
				return;
			}
			try
			{
				System.Uri uri=new System.Uri(this.textBox3.Text);
			}
			catch(System.UriFormatException urfe)
			{
				Console.WriteLine(urfe.Message); 
				this.Cursor=Cursors.Default; 
				MessageBox.Show(this,resources.GetString("FrmSplash.msg3"),this.Text,MessageBoxButtons.OK,MessageBoxIcon.Error);  
				if(!c.Web.Equals(""))
				{
					this.textBox3.Text=c.Web;
					this.textBox3.Focus(); 
				}				
				return;
			}
			if(!(this.textBox3.Text.StartsWith("http://") || this.textBox3.Text.StartsWith("https://")))
			{
				this.Cursor=Cursors.Default; 
				MessageBox.Show(this,resources.GetString("FrmSplash.msg4"),this.Text,MessageBoxButtons.OK,MessageBoxIcon.Error);  
				this.textBox3.Focus(); 
				return;
			}
			if(!this.textBox3.Text.EndsWith("/"))
			{
				this.textBox3.Text+="/";
			}
			if(checkBox1.Checked)
			{
				
				c.Password=this.textBox2.Text;
				c.User=this.textBox1.Text;
				c.Web=this.textBox3.Text;  
				
				
			}
			else
			{
				c.Password="";
				c.User="";
				c.Web="";
				
			}	
			if(this.checkBoxabrir.Checked) 
			{
				c.Startup="1"; 		
			}
			else
			{
				c.Startup="0"; 		
			}
			c.Password="";
			c.PortProxy=Int32.Parse(this.portserverproxy);
			c.ServerProxy=this.proxyserver; 
			c.Save();		
			
			try
			{
				

				user.User=this.textBox1.Text;
				user.Password=this.textBox2.Text;
				user.Uri=this.textBox3.Text;
				CWebBuilder.user=user;				
				Servicios s= new Servicios(user);
				CRequest.sesion=null;	
				CWebBuilder.user.ServerProxy=this.proxyserver;
				CWebBuilder.user.PortServerProxy=Int32.Parse(this.portserverproxy); 
				s.login();	
				if(!s.IsError) 
				{					
					this.DialogResult=DialogResult.OK;
					MessageBox.Show(this,resources.GetString("FrmSplash.msg5"),this.Text,MessageBoxButtons.OK,MessageBoxIcon.Information);  
					this.Close();
					this.Cursor=Cursors.Default; 
					return;
				}
				else
				{
					if(s.Error==0)
					{
						MessageBox.Show(this,resources.GetString("FrmSplash.msg6"),this.Text,MessageBoxButtons.OK,MessageBoxIcon.Error);  
						this.textBox1.Focus(); 
						this.Cursor=Cursors.Default; 
						return;
					}
					if(s.Error==-500)
					{
						MessageBox.Show(this,resources.GetString("FrmSplash.msg3"),this.Text,MessageBoxButtons.OK,MessageBoxIcon.Error);  
						this.textBox1.Focus(); 
						this.Cursor=Cursors.Default; 
						return;
					}
					else if(s.Error==-404)
					{
						MessageBox.Show(this,resources.GetString("FrmSplash.msg3"),this.Text,MessageBoxButtons.OK,MessageBoxIcon.Error);  
						this.textBox3.Focus(); 
						this.Cursor=Cursors.Default; 
						return;
					}
					else
					{
						MessageBox.Show(this,resources.GetString("FrmSplash.msg3"),this.Text,MessageBoxButtons.OK,MessageBoxIcon.Error);  
						this.textBox3.Focus(); 
						this.Cursor=Cursors.Default; 
						return;
					}
				}
			}
			catch(System.UriFormatException uri)
			{
				Console.WriteLine(uri.Message); 
				this.Cursor=Cursors.Default; 
				MessageBox.Show(this,resources.GetString("FrmSplash.msg7"),this.Text,MessageBoxButtons.OK,MessageBoxIcon.Error);  
			}
			this.Cursor=Cursors.Default; 
			
		}

		private void FrmSplash_Load(object sender, System.EventArgs e)
		{

			CConfig c= new CConfig();
			this.textBox1.Text=c.User;
			this.textBox2.Text=c.Password;
			this.textBox3.Text=c.Web;
			if(!c.User.Equals("") || !c.Password.Equals("") || !c.Web.Equals(""))
			{
				this.checkBox1.Checked=true;  
			}
			if(c.Startup.Equals("1"))
			{
				this.checkBoxabrir.Checked=true;  
			}
			else
			{
				this.checkBoxabrir.Checked=false;  
			}

			this.proxyserver=c.ServerProxy;  
			this.portserverproxy=""+c.PortProxy;  
			

		}

		private void button3_Click(object sender, System.EventArgs e)
		{
			FrmConfigProxy frm=new FrmConfigProxy(this.proxyserver,this.portserverproxy);
			frm.ShowDialog(this);
			this.proxyserver=frm.proxyserver;
			this.portserverproxy=frm.portserverproxy;
		}

		private void FrmSplash_Activated(object sender, System.EventArgs e)
		{
			if(this.textBox1.Text.Length>0)
			{
				this.textBox2.Focus(); 
			}
		}
		
	
	}
}
