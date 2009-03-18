/*	INFOTEC WebBuilder es una herramienta para el desarrollo de portales de conocimiento, colaboraci�n e integraci�n para Internet, la cual, es una creaci�n original del Fondo de Informaci�n y Documentaci�n para la Industria INFOTEC, misma que se encuentra debidamente registrada ante el Registro P�blico del Derecho de Autor de los Estados Unidos Mexicanos con el No. 03-2002-052312015400-14, para la versi�n 1; No. 03-2003-012112473900 para la versi�n 2, y No. 03-2006-012012004000-01 para la versi�n 3, respectivamente. 
	INFOTEC pone a su disposici�n la herramienta INFOTEC WebBuilder a trav�s de su licenciamiento abierto al p�blico (�open source�), en virtud del cual, usted podr� usarlo en las mismas condiciones con que INFOTEC lo ha dise�ado y puesto a su disposici�n; aprender de �l; distribuirlo a terceros; acceder a su c�digo fuente y modificarlo, y combinarlo o enlazarlo con otro software, todo ello de conformidad con los t�rminos y condiciones de la LICENCIA ABIERTA AL P�BLICO que otorga INFOTEC para la utilizaci�n de INFOTEC WebBuilder 3.2
	INFOTEC no otorga garant�a sobre INFOTEC WebBuilder, de ninguna especie y naturaleza, ni impl�cita ni expl�cita, siendo usted completamente responsable de la utilizaci�n que le d� y asumiendo la totalidad de los riesgos que puedan derivar de la misma.
	Si usted tiene cualquier duda o comentario sobre INFOTEC WebBuilder, INFOTEC pone a su disposici�n la siguiente direcci�n electr�nica: http://www.webbuilder.org.mx	
*/
using System;
using System.Collections;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Windows.Forms;
using System.Xml;
namespace WBOffice3
{
	/// <summary>Control que muestra los idiomas en los que se desea crear la secci�n</summary>
	public class New3 : TSWizards.BaseInteriorStep
	{
		System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(CLibrary));
		private System.Windows.Forms.CheckedListBox checkedListBox1;
		/// <summary> 
		/// Variable del dise�ador requerida.
		/// </summary>
		private System.ComponentModel.Container components = null;
		private System.Windows.Forms.ErrorProvider errorProvider1;
		String idioma,prefix;
		/// <summary>Crea el control</summary>
		public New3()
		{
			// Llamada necesaria para el Dise�ador de formularios Windows.Forms.
			InitializeComponent();

			// TODO: agregar cualquier inicializaci�n despu�s de llamar a InitializeComponent

		}

		/// <summary> 
		/// Limpiar los recursos que se est�n utilizando.
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

		#region C�digo generado por el Dise�ador de componentes
		/// <summary> 
		/// M�todo necesario para admitir el Dise�ador. No se puede modificar 
		/// el contenido del m�todo con el editor de c�digo.
		/// </summary>
		private void InitializeComponent()
		{
			System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(New3));
			this.checkedListBox1 = new System.Windows.Forms.CheckedListBox();
			this.errorProvider1 = new System.Windows.Forms.ErrorProvider();
			this.SuspendLayout();
			// 
			// Description
			// 
			this.Description.Name = "Description";
			this.Description.Text = resources.GetString("Description.Text");
			// 
			// checkedListBox1
			// 
			this.checkedListBox1.AccessibleDescription = resources.GetString("checkedListBox1.AccessibleDescription");
			this.checkedListBox1.AccessibleName = resources.GetString("checkedListBox1.AccessibleName");
			this.checkedListBox1.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("checkedListBox1.Anchor")));
			this.checkedListBox1.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("checkedListBox1.BackgroundImage")));
			this.checkedListBox1.CheckOnClick = true;
			this.checkedListBox1.ColumnWidth = ((int)(resources.GetObject("checkedListBox1.ColumnWidth")));
			this.checkedListBox1.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("checkedListBox1.Dock")));
			this.checkedListBox1.Enabled = ((bool)(resources.GetObject("checkedListBox1.Enabled")));
			this.errorProvider1.SetError(this.checkedListBox1, resources.GetString("checkedListBox1.Error"));
			this.checkedListBox1.Font = ((System.Drawing.Font)(resources.GetObject("checkedListBox1.Font")));
			this.checkedListBox1.HorizontalExtent = ((int)(resources.GetObject("checkedListBox1.HorizontalExtent")));
			this.checkedListBox1.HorizontalScrollbar = ((bool)(resources.GetObject("checkedListBox1.HorizontalScrollbar")));
			this.errorProvider1.SetIconAlignment(this.checkedListBox1, ((System.Windows.Forms.ErrorIconAlignment)(resources.GetObject("checkedListBox1.IconAlignment"))));
			this.errorProvider1.SetIconPadding(this.checkedListBox1, ((int)(resources.GetObject("checkedListBox1.IconPadding"))));
			this.checkedListBox1.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("checkedListBox1.ImeMode")));
			this.checkedListBox1.IntegralHeight = ((bool)(resources.GetObject("checkedListBox1.IntegralHeight")));
			this.checkedListBox1.Location = ((System.Drawing.Point)(resources.GetObject("checkedListBox1.Location")));
			this.checkedListBox1.Name = "checkedListBox1";
			this.checkedListBox1.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("checkedListBox1.RightToLeft")));
			this.checkedListBox1.ScrollAlwaysVisible = ((bool)(resources.GetObject("checkedListBox1.ScrollAlwaysVisible")));
			this.checkedListBox1.Size = ((System.Drawing.Size)(resources.GetObject("checkedListBox1.Size")));
			this.checkedListBox1.TabIndex = ((int)(resources.GetObject("checkedListBox1.TabIndex")));
			this.checkedListBox1.Visible = ((bool)(resources.GetObject("checkedListBox1.Visible")));
			this.checkedListBox1.SelectedIndexChanged += new System.EventHandler(this.checkedListBox1_SelectedIndexChanged);
			
			// 
			// errorProvider1
			// 
			this.errorProvider1.ContainerControl = this;
			this.errorProvider1.Icon = ((System.Drawing.Icon)(resources.GetObject("errorProvider1.Icon")));
			// 
			// New3
			// 
			this.AccessibleDescription = resources.GetString("$this.AccessibleDescription");
			this.AccessibleName = resources.GetString("$this.AccessibleName");
			this.AutoScroll = ((bool)(resources.GetObject("$this.AutoScroll")));
			this.AutoScrollMargin = ((System.Drawing.Size)(resources.GetObject("$this.AutoScrollMargin")));
			this.AutoScrollMinSize = ((System.Drawing.Size)(resources.GetObject("$this.AutoScrollMinSize")));
			this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
			this.Controls.Add(this.checkedListBox1);
			this.Enabled = ((bool)(resources.GetObject("$this.Enabled")));
			this.errorProvider1.SetError(this, resources.GetString("$this.Error"));
			this.Font = ((System.Drawing.Font)(resources.GetObject("$this.Font")));
			this.errorProvider1.SetIconAlignment(this, ((System.Windows.Forms.ErrorIconAlignment)(resources.GetObject("$this.IconAlignment"))));
			this.errorProvider1.SetIconPadding(this, ((int)(resources.GetObject("$this.IconPadding"))));
			this.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("$this.ImeMode")));
			this.Location = ((System.Drawing.Point)(resources.GetObject("$this.Location")));
			this.Name = "New3";
			this.NextStep = "Step4";
			this.PreviousStep = "Step2";
			this.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("$this.RightToLeft")));
			this.Size = ((System.Drawing.Size)(resources.GetObject("$this.Size")));
			this.StepDescription = resources.GetString("$this.StepDescription");
			this.StepTitle = resources.GetString("$this.StepTitle");
			this.ValidateStep += new System.ComponentModel.CancelEventHandler(this.New3_ValidateStep);
			this.ShowStep += new TSWizards.ShowStepEventHandler(this.New3_ShowStep);
			this.Controls.SetChildIndex(this.Description, 0);
			this.Controls.SetChildIndex(this.checkedListBox1, 0);
			this.ResumeLayout(false);

		}
		#endregion

		private void New3_ShowStep(object sender, TSWizards.ShowStepEventArgs e)
		{
			
			checkedListBox1_SelectedIndexChanged(null,null);
			this.checkedListBox1.Focus();
			this.Wizard.NextEnabled=false;
			checkedListBox1_SelectedIndexChanged(null,null);
			this.checkedListBox1.Items.Clear();
			New2 step2 = Wizard.GetStep("Step2") as New2;
			if(step2.treeView1.SelectedNode is WBNode)
			{
				WBNode wbnode=(WBNode)step2.treeView1.SelectedNode;
				char[] chars={'.'};
				String[] values=wbnode.ReloadPath.Split(chars);
				String idtopic=values[values.Length-1];
				String idtopicmap=values[values.Length-2];	

				Servicios s=new Servicios(FrmNewSection.user);
				XmlElement topicmap=(XmlElement)s.getTopicMapAtt(idtopicmap);
				idioma=topicmap.GetElementsByTagName("language")[0].InnerText; 
				idioma=idioma.Substring(6);			
				prefix=idtopicmap;
				if(prefix.Length>4)
				{
					prefix=prefix.Substring(0,4)+"_";
				}
				else
				{
					prefix+="_";
				}

				Servicios s2= new Servicios(FrmNewSection.user);
				XmlDocument doc=s2.getLanguage(idtopicmap); 
				System.Xml.XmlNodeList langs=doc.GetElementsByTagName("Lenguaje");  
				foreach(System.Xml.XmlElement  lang in langs)
				{
				
					String name=lang.ChildNodes[1].InnerText;  				
					String id=lang.GetElementsByTagName("lang")[0].InnerText; 
					String slang=lang.GetElementsByTagName("lang")[0].InnerText; 
					CCaracteristica clang=new CCaracteristica(name,id);
					bool bcheched=false;
					if(idioma.Equals(id))
					{
						bcheched=true;
						clang.Label +=" ("+ resources.GetString("FrmNewTopic2.t1") +")"; 
					}
				
					foreach(IParameter p in FrmNewSection.parametros)
					{
						if(p.Name.Equals("name"))
						{
							if(p.Attributes[1].Value.Equals(name))
							{
								bcheched=true;
							}
						}
					}
					this.checkedListBox1.Tag=clang;
					this.checkedListBox1.Items.Add(clang,bcheched);					
				}	
			}			
			checkedListBox1_SelectedIndexChanged(null,null);		
		}

		private void New3_ValidateStep(object sender, System.ComponentModel.CancelEventArgs e)
		{
			New2 step2=Wizard.GetStep("Step2") as New2;
			if(step2.treeView1.SelectedNode!=null && step2.treeView1.SelectedNode is WBNode && this.checkedListBox1.CheckedItems.Count>0)
			{
				WBNode wbnode=(WBNode)step2.treeView1.SelectedNode;
				char[] chars={'.'};
				String[] values=wbnode.ReloadPath.Split(chars);
				String idtopic=values[values.Length-1];
				String idtopicmap=values[values.Length-2];	

				bool seldefecto=false;
				foreach(CCaracteristica lang in this.checkedListBox1.CheckedItems)
				{
					if(lang.Name.Equals(this.Idioma))
					{
						seldefecto=true;
					}
				}
				if(!seldefecto)
				{
					this.errorProvider1.SetError(this.checkedListBox1,resources.GetString("FrmNewTopic2.msg1"));
					return;
				}
				ParameterCollection pant=FrmNewSection.parametros;
				ParameterCollection pnew=new ParameterCollection(); 
				foreach(IParameter padd in FrmNewSection.parametros)
				{
					if(padd.Name!="name")
					{
						pnew.Add(padd);
					}
				}
				FrmNewSection.parametros=pnew;
				Servicios s= new Servicios(FrmNewSection.user);
				XmlDocument doc=s.getLanguage(idtopicmap); 
				System.Xml.XmlNodeList langs=doc.GetElementsByTagName("Lenguaje");  				
				foreach(CCaracteristica lang in this.checkedListBox1.CheckedItems)
				{
					foreach(System.Xml.XmlElement xmllang in langs)
					{
						String name=xmllang.GetElementsByTagName("name")[0].InnerText;
						String id=xmllang.GetElementsByTagName("lang")[0].InnerText;				
						if(id.Equals(lang.Name))
						{
							String valueant="";
							foreach(IParameter pantvalue in pant)
							{
								if(pantvalue.Name.Equals("name"))
								{
									if(pantvalue.Attributes[1].Value.Equals(name))
									{
										valueant=pantvalue.Value;
									}
								}
							}
							Parameter plang=new Parameter("name",valueant);
							plang.Attributes.Add(new WBOffice3.Attribute("id",id));  
							plang.Attributes.Add(new WBOffice3.Attribute("desc",name));  
							FrmNewSection.parametros.Add(plang);   
						}
					}	
				}
				// debe recoger los nombres seleccionados
				foreach(IParameter p in FrmNewSection.parametros)
				{
					if(p.Name.Equals("name"))
					{						
						this.Cursor=Cursors.Default;						
						break;
					}
				}
			}
			else
			{

				e.Cancel=true;
			}
			
		}

		private void checkedListBox1_SelectedIndexChanged(object sender, System.EventArgs e)
		{
			
			int index=0;
			foreach(CCaracteristica c in this.checkedListBox1.Items)
			{				
				if(c==this.checkedListBox1.Tag)
				{
					break;
				}
				index++;
			}
			if(this.checkedListBox1.Items.Count>0)
			{
				if(!this.checkedListBox1.GetItemChecked(index))
				{
					
					//MessageBox.Show(this,"","",MessageBoxButtons.OK,MessageBoxIcon.Error);
					this.checkedListBox1.SetItemChecked(index,true);
				}
			}
			if(this.checkedListBox1.CheckedItems.Count>0)
			{
				this.Wizard.NextEnabled=true;
			}
			else
			{
				this.Wizard.NextEnabled=false;
			}
		}
	
		/// <summary>Idioma por defecto</summary>
		/// <value>Idioma por defecto</value>
		public String Idioma
		{
			get
			{
				return idioma;
			}
			set
			{
				idioma=value;
			}
		}
		/// <summary>Prefixo utilizado</summary>
		public String Prefix
		{
			get
			{
				return prefix;
			}
			set
			{
				prefix=value;
			}
		}
	}
}
