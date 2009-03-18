/*	INFOTEC WebBuilder es una herramienta para el desarrollo de portales de conocimiento, colaboración e integración para Internet, la cual, es una creación original del Fondo de Información y Documentación para la Industria INFOTEC, misma que se encuentra debidamente registrada ante el Registro Público del Derecho de Autor de los Estados Unidos Mexicanos con el No. 03-2002-052312015400-14, para la versión 1; No. 03-2003-012112473900 para la versión 2, y No. 03-2006-012012004000-01 para la versión 3, respectivamente. 
	INFOTEC pone a su disposición la herramienta INFOTEC WebBuilder a través de su licenciamiento abierto al público (‘open source’), en virtud del cual, usted podrá usarlo en las mismas condiciones con que INFOTEC lo ha diseñado y puesto a su disposición; aprender de él; distribuirlo a terceros; acceder a su código fuente y modificarlo, y combinarlo o enlazarlo con otro software, todo ello de conformidad con los términos y condiciones de la LICENCIA ABIERTA AL PÚBLICO que otorga INFOTEC para la utilización de INFOTEC WebBuilder 3.2
	INFOTEC no otorga garantía sobre INFOTEC WebBuilder, de ninguna especie y naturaleza, ni implícita ni explícita, siendo usted completamente responsable de la utilización que le dé y asumiendo la totalidad de los riesgos que puedan derivar de la misma.
	Si usted tiene cualquier duda o comentario sobre INFOTEC WebBuilder, INFOTEC pone a su disposición la siguiente dirección electrónica: http://www.webbuilder.org.mx	
*/
using System;
using System.Collections;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Windows.Forms;
using System.Runtime.InteropServices;
using System.Text;
using WBOffice3;
using System.IO;
using System.Diagnostics;
namespace WBExcel
{
	struct DriveInfo
	{
		private string letter;  //drive letter : "C:\","A:\"
		private int type;       //below
		private string name;    //Disc Label

		public int Type
		{
			get 
			{
				return type;
			}
		}

		public int Icon
		{
			get
			{
				if(name=="My Computer")return 0;
				if(type==5)return 3;//cd
				if(type==3)return 2;//fixed
				if(type==2)return 1;//removable
				if(type==4)return 4;//remote disk
				if(type==6)return 5;//ram disk
				return 6;//unknown
			}
		}

		public string Letter
		{
			get
			{
				if(letter!="")return " ("+letter+")";
				else return "";
			}
		}
		public string Name
		{
			get
			{
				if(name!="")return name;
				else
				{
					switch (this.Type)
					{
						case 3:
							if(letter==System.IO.Directory.GetDirectoryRoot(
								System.Environment.SystemDirectory))
								return "System";
							else 
								return "Local Disc";
						case 5:return "CD Rom";
						case 6:return "RAM Disc";
						case 4:return "Network Drive";
						case 2:
							if(letter=="A:\\")return "3.5 Floppy";
							else return "Removable Disc";
						default:return  "";
					}
				}
			}
		}

		//TYPE:
		//5-A CD-ROM drive. 
		//3-A hard drive. 
		//6-A RAM disk. 
		//4-A network drive or a drive located on a network server. 
		//2-A floppy drive or some other removable-disk drive. 
		public DriveInfo(string strLetter,int intType,string strName)
		{
			letter=strLetter;
			name=strName;
			type=intType;
		}
	}

	/// <summary>
	/// Control que muestra listado de directorios de la máquina para selecionar el
	/// directorio donde se almacenrá el contenido que se va a abrir
	/// </summary>
	public class OpenStep4 : TSWizards.BaseStep
	{
		
		private static String lastpath=null;
		/// <summary>Función que regresa el tipo de drive existente en la máquina actual</summary>
		/// <returns>
		/// 	<para>Número indica el tipo de drive</para>
		/// 	<para><font color="green" size="2">if(name=="My Computer")return 0;</font></para>
		/// 	<para>if(type==5)return 3;//cd</para>
		/// 	<para>if(type==3)return 2;//fixed</para>
		/// 	<para>if(type==2)return 1;//removable</para>
		/// 	<para>if(type==4)return 4;//remote disk</para>
		/// 	<para>if(type==6)return 5;//ram disk</para>
		/// 	<para>return 6;//unknown*/</para>
		/// </returns>
		/// <example>
		/// 	<para>long type=GetDriveType("c:");</para>
		/// 	<para>if(type==5)</para>
		/// 	<para>{</para>
		/// 	<para>return "CD";</para>
		/// 	<para>}</para>
		/// </example>
		/// <param name="driveLetter">
		/// 	<para><font color="green" size="2"><font color="black">Letra del
		///     drive</font></font></para>
		/// </param>
        public int getDriveType(string drive)
        {
            /*if((GetDriveType(drive) & 5)==5)return 5;//cd
            if((GetDriveType(drive) & 3)==3)return 3;//fixed
            if((GetDriveType(drive) & 2)==2)return 2;//removable
            if((GetDriveType(drive) & 4)==4)return 4;//remote disk
            if((GetDriveType(drive) & 6)==6)return 6;//ram disk
            return 0;*/
            if (GetDriveType(drive) == DriveType.CDRom)
            {
                return 5;
            }
            if (GetDriveType(drive) == DriveType.Fixed)
            {
                return 3;
            }
            if (GetDriveType(drive) == DriveType.Removable)
            {
                return 2;
            }
            if (GetDriveType(drive) == DriveType.Ram)
            {
                return 6;
            }
            if (GetDriveType(drive) == DriveType.Network)
            {
                return 4;
            }
            else
            {
                return 0;
            }
        }

        public System.IO.DriveType GetDriveType(string drive)
        {
            System.IO.DriveInfo[] drives = System.IO.DriveInfo.GetDrives();

            foreach (System.IO.DriveInfo odrive in drives)
            {
                if (odrive.Name == drive)
                {
                    return odrive.DriveType;
                }
            }
            return System.IO.DriveType.Unknown;

        }
		
		System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(CLibrary));
		/// <summary>
		/// ärbol de secciones
		/// </summary>
		public System.Windows.Forms.TreeView treedir;
		private System.Windows.Forms.ImageList imageList1;
		private System.Windows.Forms.ContextMenu contextMenu1;
		private System.Windows.Forms.MenuItem menuItem2;
		private System.Windows.Forms.MenuItem menuItemNew;
		private System.Windows.Forms.MenuItem menuItemDelete;
		private System.Windows.Forms.MenuItem menuItemRename;
		private System.ComponentModel.IContainer components;
		/// <summary>
		/// Crea el control que muestra listado de directorios de la máquina para selecionar
		/// el directorio donde se almacenrá el contenido que se va a abrir
		/// </summary>
		public OpenStep4()
		{
			// Llamada necesaria para el Diseñador de formularios Windows.Forms.
			InitializeComponent();

			// TODO: agregar cualquier inicialización después de llamar a InitializeComponent

		}

		/// <summary> 
		/// Limpiar los recursos que se estén utilizando.
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

		#region Código generado por el Diseñador de componentes
		/// <summary> 
		/// Método necesario para admitir el Diseñador. No se puede modificar 
		/// el contenido del método con el editor de código.
		/// </summary>
		private void InitializeComponent()
		{
			this.components = new System.ComponentModel.Container();
			System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(OpenStep4));
			this.treedir = new System.Windows.Forms.TreeView();
			this.contextMenu1 = new System.Windows.Forms.ContextMenu();
			this.menuItemNew = new System.Windows.Forms.MenuItem();
			this.menuItemRename = new System.Windows.Forms.MenuItem();
			this.menuItem2 = new System.Windows.Forms.MenuItem();
			this.menuItemDelete = new System.Windows.Forms.MenuItem();
			this.imageList1 = new System.Windows.Forms.ImageList(this.components);
			this.SuspendLayout();
			// 
			// Description
			// 
			this.Description.Name = "Description";
			this.Description.Text = resources.GetString("Description.Text");
			// 
			// treedir
			// 
			this.treedir.AccessibleDescription = resources.GetString("treedir.AccessibleDescription");
			this.treedir.AccessibleName = resources.GetString("treedir.AccessibleName");
			this.treedir.Anchor = ((System.Windows.Forms.AnchorStyles)(resources.GetObject("treedir.Anchor")));
			this.treedir.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("treedir.BackgroundImage")));
			this.treedir.ContextMenu = this.contextMenu1;
			this.treedir.Dock = ((System.Windows.Forms.DockStyle)(resources.GetObject("treedir.Dock")));
			this.treedir.Enabled = ((bool)(resources.GetObject("treedir.Enabled")));
			this.treedir.Font = ((System.Drawing.Font)(resources.GetObject("treedir.Font")));
			this.treedir.HideSelection = false;
			this.treedir.ImageIndex = ((int)(resources.GetObject("treedir.ImageIndex")));
			this.treedir.ImageList = this.imageList1;
			this.treedir.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("treedir.ImeMode")));
			this.treedir.Indent = ((int)(resources.GetObject("treedir.Indent")));
			this.treedir.ItemHeight = ((int)(resources.GetObject("treedir.ItemHeight")));
			this.treedir.LabelEdit = true;
			this.treedir.Location = ((System.Drawing.Point)(resources.GetObject("treedir.Location")));
			this.treedir.Name = "treedir";
			this.treedir.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("treedir.RightToLeft")));
			this.treedir.SelectedImageIndex = ((int)(resources.GetObject("treedir.SelectedImageIndex")));
			this.treedir.Size = ((System.Drawing.Size)(resources.GetObject("treedir.Size")));
			this.treedir.TabIndex = ((int)(resources.GetObject("treedir.TabIndex")));
			this.treedir.Text = resources.GetString("treedir.Text");
			this.treedir.Visible = ((bool)(resources.GetObject("treedir.Visible")));
			this.treedir.AfterExpand += new System.Windows.Forms.TreeViewEventHandler(this.treedir_AfterExpand);
			this.treedir.AfterCollapse += new System.Windows.Forms.TreeViewEventHandler(this.treedir_AfterCollapse);
			this.treedir.AfterSelect += new System.Windows.Forms.TreeViewEventHandler(this.treedir_AfterSelect);
			this.treedir.AfterLabelEdit += new System.Windows.Forms.NodeLabelEditEventHandler(this.treedir_AfterLabelEdit);
			this.treedir.BeforeExpand += new System.Windows.Forms.TreeViewCancelEventHandler(this.treedir_BeforeExpand);
			// 
			// contextMenu1
			// 
			this.contextMenu1.MenuItems.AddRange(new System.Windows.Forms.MenuItem[] {
																						 this.menuItemNew,
																						 this.menuItemRename,
																						 this.menuItem2,
																						 this.menuItemDelete});
			this.contextMenu1.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("contextMenu1.RightToLeft")));
			// 
			// menuItemNew
			// 
			this.menuItemNew.Enabled = ((bool)(resources.GetObject("menuItemNew.Enabled")));
			this.menuItemNew.Index = 0;
			this.menuItemNew.Shortcut = ((System.Windows.Forms.Shortcut)(resources.GetObject("menuItemNew.Shortcut")));
			this.menuItemNew.ShowShortcut = ((bool)(resources.GetObject("menuItemNew.ShowShortcut")));
			this.menuItemNew.Text = resources.GetString("menuItemNew.Text");
			this.menuItemNew.Visible = ((bool)(resources.GetObject("menuItemNew.Visible")));
			this.menuItemNew.Click += new System.EventHandler(this.menuItemNew_Click);
			// 
			// menuItemRename
			// 
			this.menuItemRename.Enabled = ((bool)(resources.GetObject("menuItemRename.Enabled")));
			this.menuItemRename.Index = 1;
			this.menuItemRename.Shortcut = ((System.Windows.Forms.Shortcut)(resources.GetObject("menuItemRename.Shortcut")));
			this.menuItemRename.ShowShortcut = ((bool)(resources.GetObject("menuItemRename.ShowShortcut")));
			this.menuItemRename.Text = resources.GetString("menuItemRename.Text");
			this.menuItemRename.Visible = ((bool)(resources.GetObject("menuItemRename.Visible")));
			this.menuItemRename.Click += new System.EventHandler(this.menuItemRename_Click);
			// 
			// menuItem2
			// 
			this.menuItem2.Enabled = ((bool)(resources.GetObject("menuItem2.Enabled")));
			this.menuItem2.Index = 2;
			this.menuItem2.Shortcut = ((System.Windows.Forms.Shortcut)(resources.GetObject("menuItem2.Shortcut")));
			this.menuItem2.ShowShortcut = ((bool)(resources.GetObject("menuItem2.ShowShortcut")));
			this.menuItem2.Text = resources.GetString("menuItem2.Text");
			this.menuItem2.Visible = ((bool)(resources.GetObject("menuItem2.Visible")));
			// 
			// menuItemDelete
			// 
			this.menuItemDelete.Enabled = ((bool)(resources.GetObject("menuItemDelete.Enabled")));
			this.menuItemDelete.Index = 3;
			this.menuItemDelete.Shortcut = ((System.Windows.Forms.Shortcut)(resources.GetObject("menuItemDelete.Shortcut")));
			this.menuItemDelete.ShowShortcut = ((bool)(resources.GetObject("menuItemDelete.ShowShortcut")));
			this.menuItemDelete.Text = resources.GetString("menuItemDelete.Text");
			this.menuItemDelete.Visible = ((bool)(resources.GetObject("menuItemDelete.Visible")));
			this.menuItemDelete.Click += new System.EventHandler(this.menuItemDelete_Click);
			// 
			// imageList1
			// 
			this.imageList1.ImageSize = ((System.Drawing.Size)(resources.GetObject("imageList1.ImageSize")));
			this.imageList1.ImageStream = ((System.Windows.Forms.ImageListStreamer)(resources.GetObject("imageList1.ImageStream")));
			this.imageList1.TransparentColor = System.Drawing.Color.Transparent;
			// 
			// OpenStep4
			// 
			this.AccessibleDescription = resources.GetString("$this.AccessibleDescription");
			this.AccessibleName = resources.GetString("$this.AccessibleName");
			this.AutoScroll = ((bool)(resources.GetObject("$this.AutoScroll")));
			this.AutoScrollMargin = ((System.Drawing.Size)(resources.GetObject("$this.AutoScrollMargin")));
			this.AutoScrollMinSize = ((System.Drawing.Size)(resources.GetObject("$this.AutoScrollMinSize")));
			this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
			this.Controls.Add(this.treedir);
			this.Enabled = ((bool)(resources.GetObject("$this.Enabled")));
			this.Font = ((System.Drawing.Font)(resources.GetObject("$this.Font")));
			this.ImeMode = ((System.Windows.Forms.ImeMode)(resources.GetObject("$this.ImeMode")));
			this.Location = ((System.Drawing.Point)(resources.GetObject("$this.Location")));
			this.Name = "OpenStep4";
			this.NextStep = "Step5";
			this.PreviousStep = "Step3";
			this.RightToLeft = ((System.Windows.Forms.RightToLeft)(resources.GetObject("$this.RightToLeft")));
			this.Size = ((System.Drawing.Size)(resources.GetObject("$this.Size")));
			this.StepDescription = resources.GetString("$this.StepDescription");
			this.StepTitle = resources.GetString("$this.StepTitle");
			this.ValidateStep += new System.ComponentModel.CancelEventHandler(this.OpenStep4_ValidateStep);
			this.ShowStep += new TSWizards.ShowStepEventHandler(this.OpenStep4_ShowStep);
			this.Controls.SetChildIndex(this.Description, 0);
			this.Controls.SetChildIndex(this.treedir, 0);
			this.ResumeLayout(false);

		}
		#endregion

		private void treedir_AfterCollapse(object sender, System.Windows.Forms.TreeViewEventArgs e)
		{
			
			if(e.Node.Parent!=null)
			{
				e.Node.ImageIndex=0;
				e.Node.SelectedImageIndex=0;  
			}
		}

		private void treedir_AfterExpand(object sender, System.Windows.Forms.TreeViewEventArgs e)
		{
			if(e.Node.Parent!=null)
			{
				e.Node.ImageIndex=1;  
				e.Node.SelectedImageIndex=1;  
			}
		}

		private void OpenStep4_ShowStep(object sender, TSWizards.ShowStepEventArgs e)
		{
			this.Wizard.NextEnabled=false;
			this.treedir.Nodes.Clear();
			String[] drives=System.IO.Directory.GetLogicalDrives();
			foreach(String drive in drives)
			{
				System.IO.DirectoryInfo d= new System.IO.DirectoryInfo(drive);					
				int tempType = getDriveType(drive);
				string tempName = GetDriveName(drive);
				DriveInfo tempInfo = new DriveInfo(drive,tempType,tempName);
				int type=tempInfo.Type;
				TreeNode raiz=this.treedir.Nodes.Add(tempInfo.Name+" ("+ drive +")");  
				raiz.Tag=d;
				//TreeNode raiz=this.treedir.Nodes.Add(drive);  
				/*if(name=="My Computer")return 0;
				if(type==5)return 3;//cd
				if(type==3)return 2;//fixed
				if(type==2)return 1;//removable
				if(type==4)return 4;//remote disk
				if(type==6)return 5;//ram disk
				return 6;//unknown*/
				switch (tempInfo.Icon)
				{
					case 1:
						raiz.ImageIndex=3;
						raiz.SelectedImageIndex=3; 
						break;
					case 2:
						raiz.ImageIndex=2;
						raiz.SelectedImageIndex=2; 
						break;
					case 3:
						raiz.ImageIndex=4;
						raiz.SelectedImageIndex=4; 
						break;
					case 4:
						raiz.ImageIndex=5;
						raiz.SelectedImageIndex=5; 
						break;
					case 5:
						raiz.ImageIndex=2;
						raiz.SelectedImageIndex=2; 
						break;
					default:
						raiz.ImageIndex=2;
						raiz.SelectedImageIndex=2; 
						break;

				}			
				raiz.Nodes.Add(""); 
			}
			if(lastpath!=null)
			{
				DirectoryInfo lastdir=new DirectoryInfo(lastpath);
				if(lastdir.Exists)
				{
					ArrayList dirsinicio=new ArrayList();
					dirsinicio.Add(lastdir);
					while(lastdir.Parent!=null)
					{
						dirsinicio.Add(lastdir.Parent);
						lastdir=lastdir.Parent;
					}
					ArrayList dirs=new ArrayList();
					for(int i=dirsinicio.Count-1;i>=0;i--)
					{
						dirs.Add(dirsinicio[i]);
					}	
					lastdir=new DirectoryInfo(lastpath);
					if(dirs.Count>0)
					{
						TreeNode root=null;
						foreach(TreeNode node in this.treedir.Nodes)
						{
							if(node.Tag is DirectoryInfo)
							{
								DirectoryInfo dirroot=(DirectoryInfo)node.Tag;
								if(dirroot.FullName==((DirectoryInfo)dirs[0]).FullName)
								{
									root=node;
								}
							}
						}
						if(root!=null)
						{
							foreach(DirectoryInfo dir in dirs)
							{			
			
								root=BuscaNodo(root,dir);
								if(root!=null)
								{
									this.treedir.SelectedNode=root;
									root.Expand();
								}
								else
								{
									return;
								}
							}
						}
					}
				}
			}
		}
		private TreeNode BuscaNodo(TreeNode root,DirectoryInfo dir)
		{
			if(((DirectoryInfo)root.Tag).FullName==dir.FullName)
			{
				return root; 
			}
			foreach(TreeNode node in root.Nodes)
			{
				if(node.Tag is DirectoryInfo)
				{
					DirectoryInfo subnode=(DirectoryInfo)node.Tag;
					if(subnode.FullName==dir.FullName)
					{
						return node;
					}
				}
			}
			return null;
		}

		private void treedir_AfterSelect(object sender, System.Windows.Forms.TreeViewEventArgs e)
		{
			if(e.Node.Tag is DirectoryInfo && (e.Node.ImageIndex==-1 || e.Node.ImageIndex==0 || e.Node.ImageIndex==1))
			{
				this.treedir.ContextMenu=this.contextMenu1;				
			}
			else
			{
				this.treedir.ContextMenu=null;
			}
			this.Wizard.NextEnabled=true;

		}
		

		/// <summary>Obtiene el nombre del drive</summary>
		/// <returns>Nombre del Drive</returns>
		/// <param name="drive">Drive a buscar nombre , puede ser c:, d:, etc.</param>
        public string GetDriveName(string drive)
        {
            string retval = "";
            System.IO.DriveInfo[] drives = System.IO.DriveInfo.GetDrives();
            foreach (System.IO.DriveInfo odrive in drives)
            {
                if (odrive.Name == drive)
                {
                    if (odrive.IsReady)
                    {
                        retval = odrive.VolumeLabel;
                    }
                }
            }
            return retval;
        }

		private void treedir_BeforeExpand(object sender, System.Windows.Forms.TreeViewCancelEventArgs e)
		{
			if(e.Node.FirstNode!=null)
			{
				if(e.Node.FirstNode.Text.Equals(""))
				{
					e.Node.Nodes.Clear();
					try
					{
						
						System.IO.DirectoryInfo dir=(DirectoryInfo)e.Node.Tag;
						System.IO.DirectoryInfo[] dirs=dir.GetDirectories(); 
						foreach(System.IO.DirectoryInfo dirinfo in dirs)
						{
							TreeNode node=e.Node.Nodes.Add(dirinfo.Name);						
							node.Tag=dirinfo;
							node.Nodes.Add("");						 
						}
					}
					catch(System.IO.IOException ioe)
					{
						System.Console.WriteLine(ioe.Message);  
					}
				}
			}
		}

		private void menuItemNew_Click(object sender, System.EventArgs e)
		{
			if(this.treedir.SelectedNode!=null)
			{
				if(this.treedir.SelectedNode.Tag is DirectoryInfo)
				{
					try
					{
						DirectoryInfo dir=(DirectoryInfo)this.treedir.SelectedNode.Tag;
						int iCarpeta=1;
						bool continua=true;
						while(continua)
						{
							TreeNode nodenew=null;
							DirectoryInfo dirnew=new DirectoryInfo(dir.FullName+"\\Folder "+iCarpeta);
							if(dirnew.Exists)
							{								
								continua=true;
								iCarpeta++;
							}
							else
							{
								continua=false;
								dirnew.Create();
								if(this.treedir.SelectedNode.Nodes.Count==1 && this.treedir.SelectedNode.Nodes[0].Text=="")
								{
									this.treedir.SelectedNode.Expand();
									foreach(TreeNode node in this.treedir.SelectedNode.Nodes)
									{
										if(node.Tag is DirectoryInfo)
										{
											DirectoryInfo dirtest=(DirectoryInfo)node.Tag;
											if(dirtest.FullName==dirnew.FullName)
											{
												this.treedir.SelectedNode=node;
												nodenew=node;
											}
										}
									}
								}
								else
								{
									nodenew=new TreeNode(dirnew.Name);
									nodenew.Tag=dirnew;
									nodenew.ImageIndex=0;
									nodenew.SelectedImageIndex=0;
									this.treedir.SelectedNode.Nodes.Add(nodenew);
									this.treedir.SelectedNode=nodenew;
								}
								if(nodenew!=null)
								{
									nodenew.BeginEdit();
								}
							}

						}
					}
					catch(Exception err)
					{
						MessageBox.Show(this,err.Message,resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Error);
					}
					
				}
			}
		}

		private void treedir_AfterLabelEdit(object sender, System.Windows.Forms.NodeLabelEditEventArgs e)
		{
			if(this.treedir.SelectedNode!=null && this.treedir.SelectedNode.Tag is DirectoryInfo && (e.Node.ImageIndex==-1 || this.treedir.SelectedNode.ImageIndex==0 || this.treedir.SelectedNode.ImageIndex==1))
			{
				try
				{
					DirectoryInfo dir=(DirectoryInfo)this.treedir.SelectedNode.Tag;
					dir.MoveTo(dir.Parent.FullName+"\\"+ e.Label);
					DirectoryInfo dirnew=new DirectoryInfo(dir.Parent.FullName+"\\"+ e.Label);
					this.treedir.SelectedNode.Tag=dirnew;
				}
				catch(Exception err)
				{
					MessageBox.Show(this,err.Message,resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Error);
					e.CancelEdit=true;
				}

			}
			else
			{
				e.CancelEdit=true;
			}
		}

		private void menuItemRename_Click(object sender, System.EventArgs e)
		{
			if(this.treedir.SelectedNode!=null && this.treedir.SelectedNode.Tag is DirectoryInfo && (this.treedir.SelectedNode.ImageIndex==-1 || this.treedir.SelectedNode.ImageIndex==0 || this.treedir.SelectedNode.ImageIndex==1))
			{
				this.treedir.SelectedNode.BeginEdit();
			}			
		}		
		private void menuItemDelete_Click(object sender, System.EventArgs e)
		{
			if(this.treedir.SelectedNode!=null && this.treedir.SelectedNode.Tag is DirectoryInfo && (this.treedir.SelectedNode.ImageIndex==-1 || this.treedir.SelectedNode.ImageIndex==0 || this.treedir.SelectedNode.ImageIndex==1))
			{
				if(MessageBox.Show(this,resources.GetString("openstep4.delete"),resources.GetString("Global.title"),MessageBoxButtons.OKCancel,MessageBoxIcon.Question)==DialogResult.Cancel)
				{
					return;
				}
				DirectoryInfo dir=(DirectoryInfo)this.treedir.SelectedNode.Tag;
				try
				{	
					dir.Delete(true);
					TreeNode node=this.treedir.SelectedNode;
					if(this.treedir.SelectedNode.Parent!=null)
					{
						this.treedir.SelectedNode=this.treedir.SelectedNode.Parent;
					}
					node.Remove();
				}
				catch(Exception err)
				{
					MessageBox.Show(this,err.Message,resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Error);
				}
			}
		}

		private void OpenStep4_ValidateStep(object sender, System.ComponentModel.CancelEventArgs e)
		{
			if(this.treedir.SelectedNode!=null && this.treedir.SelectedNode.Tag is DirectoryInfo)
			{
				DirectoryInfo dir=(DirectoryInfo)this.treedir.SelectedNode.Tag;
				lastpath=dir.FullName;
			}
		}

	}
}
