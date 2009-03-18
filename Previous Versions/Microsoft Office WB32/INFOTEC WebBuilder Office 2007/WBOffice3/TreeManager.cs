/*	INFOTEC WebBuilder es una herramienta para el desarrollo de portales de conocimiento, colaboraci�n e integraci�n para Internet, la cual, es una creaci�n original del Fondo de Informaci�n y Documentaci�n para la Industria INFOTEC, misma que se encuentra debidamente registrada ante el Registro P�blico del Derecho de Autor de los Estados Unidos Mexicanos con el No. 03-2002-052312015400-14, para la versi�n 1; No. 03-2003-012112473900 para la versi�n 2, y No. 03-2006-012012004000-01 para la versi�n 3, respectivamente. 
	INFOTEC pone a su disposici�n la herramienta INFOTEC WebBuilder a trav�s de su licenciamiento abierto al p�blico (�open source�), en virtud del cual, usted podr� usarlo en las mismas condiciones con que INFOTEC lo ha dise�ado y puesto a su disposici�n; aprender de �l; distribuirlo a terceros; acceder a su c�digo fuente y modificarlo, y combinarlo o enlazarlo con otro software, todo ello de conformidad con los t�rminos y condiciones de la LICENCIA ABIERTA AL P�BLICO que otorga INFOTEC para la utilizaci�n de INFOTEC WebBuilder 3.2
	INFOTEC no otorga garant�a sobre INFOTEC WebBuilder, de ninguna especie y naturaleza, ni impl�cita ni expl�cita, siendo usted completamente responsable de la utilizaci�n que le d� y asumiendo la totalidad de los riesgos que puedan derivar de la misma.
	Si usted tiene cualquier duda o comentario sobre INFOTEC WebBuilder, INFOTEC pone a su disposici�n la siguiente direcci�n electr�nica: http://www.webbuilder.org.mx	
*/
using System;
using System.Windows.Forms;
using System.Drawing;
using WBOffice3;
using System.Xml;
using System.Collections;
using System.Net;
using System.IO;
using System.Diagnostics;
namespace WBOffice3
{
	/// <summary>Manejador de los �rboles de secciones</summary>
	public class TreeManager
	{
		System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(CLibrary));
		Button buttonSiguiente;
		TreeView treeView1;
		CUserAdmin user;
		/// <summary>Conjunto de iconos a desplegar de acuerdo a los nodos del �rbol</summary>
		public static Hashtable icons=new Hashtable();
		
		/// <summary>Contruye un arbol de secciones y sitios</summary>
		/// <param name="treeView1">Arbol a llenar</param>
		/// <param name="buttonSiguiente">Boton siguiente para habiliatr o desabilitar en caso necesario</param>
		/// <param name="user">Usuario que esta siendo uso de la aplicaci�n</param>
		public TreeManager(TreeView treeView1,Button buttonSiguiente,CUserAdmin user)
		{
			//
			// TODO: Add constructor logic here
			//
			
			try
			{
				this.user=user;
				
				this.buttonSiguiente=buttonSiguiente;
				
				this.treeView1=treeView1;
				
				this.treeView1.BeforeExpand+=new TreeViewCancelEventHandler(treeView1_BeforeExpand);
				
				this.treeView1.AfterSelect+=new TreeViewEventHandler(treeView1_AfterSelect);
				
				Servicios s= new Servicios(this.user);
				
				XmlDocument resp=s.getVersiones();			
				
				if(this.treeView1.ImageList!=null)
				{
					
					this.treeView1.ImageList.Images.Clear();
					
					foreach(XmlElement eicon in resp.GetElementsByTagName("icon"))
					{
					
						String id=eicon.GetAttribute("id");							
						if(!TreeManager.icons.Contains(id))
						{												
							String path=user.Uri+"wbadmin/resources/GatewayOfficeImp/"+eicon.GetAttribute("path");																					
							try
							{
								MemoryStream ms=new MemoryStream();
								System.Net.WebClient wc=new System.Net.WebClient();
								byte[] bcont=wc.DownloadData(path);
								ms.Write(bcont,0,bcont.Length);
								if(ms!=null)
								{
									try
									{					
										
										Image icon=Image.FromStream(ms);
										
										this.treeView1.ImageList.Images.Add(icon);
										
										int index=this.treeView1.ImageList.Images.Count-1;
										
										ImageTree img=new ImageTree(index,icon);
										
										icons.Add(id,img);
										
									}
									catch(Exception e)
									{
										Debug.WriteLine(e.Message);
										MessageBox.Show(resources.GetString("TreeManager.ErrorImagen")+" "+e.Message+"\r\n"+path,resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Error);										
									}
								}								
								else
								{
									MessageBox.Show(resources.GetString("TreeManager.ErrorImagen")+"\r\n"+path,resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Error);
								}
							}
							catch(Exception e)
							{
								Debug.WriteLine(e.Message);
								MessageBox.Show(resources.GetString("TreeManager.ErrorImagen")+" "+e.Message+"\r\n"+path,resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Error);								
							}
							
						}
						else
						{
							ImageTree imgtree=(ImageTree)TreeManager.icons[id];
							if(imgtree!=null)
							{
								Image icon=imgtree.Image;
								if(icon!=null)
								{
									this.treeView1.ImageList.Images.Add(icon);						
								}
								else
								{
									MessageBox.Show(resources.GetString("TreeManager.ErrorImagen"),resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Error);
								}
							}
							else
							{
								MessageBox.Show(resources.GetString("TreeManager.ErrorImagen"),resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Error);
							}
						}
						
					}
				}
				foreach(XmlElement enode in resp.GetElementsByTagName("res"))
				{				
					foreach(XmlElement child in enode.ChildNodes)
					{
						String reload=child.GetAttribute("reload");
						if(child.Name.Equals("node") && reload!=null)						
						{			
							if(reload.StartsWith("getTopic") || reload.StartsWith("getTopicMap") || reload.StartsWith("getServer"))
							{
								WBNode node=new WBNode(child.GetAttribute("id"),child.GetAttribute("name"),reload);
								ImageTree imgtree=(ImageTree)TreeManager.icons[child.GetAttribute("icon")];
								node.Tag=reload;
								if(child.GetAttribute("icon")!="")
								{
									node.ImageIndex=imgtree.Index;
									node.SelectedImageIndex=imgtree.Index;
								}
								this.treeView1.Nodes.Add(node);
								bool willExpand=false;
								foreach(XmlElement enodei in child.ChildNodes)
								{
									if(enodei.Name.Equals("events"))
									{
										foreach(XmlElement enodei2 in enodei.ChildNodes)
										{
											if(enodei2.Name.Equals("willExpand"))
											{											
												willExpand=true;
											}
										}
									}
								}
								node.WillExpand=willExpand;	
								loadNodes(child,node);
							}
						}
					}
				}
			}
			catch(Exception e)
			{				
				MessageBox.Show(resources.GetString("TreeManager.ErrorImagen")+" "+e.Message,resources.GetString("Global.title"),MessageBoxButtons.OK,MessageBoxIcon.Error);								
			}
			
		}
		private void loadNodes(XmlElement enode,TreeNode noderoot)
		{			
			foreach(XmlNode echild in enode.ChildNodes)
			{
				if(echild is XmlElement)
				{
					XmlElement child=(XmlElement)echild;
					String reload=child.GetAttribute("reload");
					if(child.Name.Equals("node"))						
					{		
						
						if(reload=="" || reload.StartsWith("getTopic") || reload.StartsWith("getTopicMap") || reload.StartsWith("getServer"))
						{						
							WBNode node=new WBNode(child.GetAttribute("id"),child.GetAttribute("name"),reload);
							node.Tag=reload;
							noderoot.Nodes.Add(node);													
							if(child.GetAttribute("icon")!=null && child.GetAttribute("icon")!="")
							{
								ImageTree imgtree=(ImageTree)TreeManager.icons[child.GetAttribute("icon")];								
								if(reload!="")
								{
									node.ImageIndex=imgtree.Index;
									node.SelectedImageIndex=imgtree.Index;
								}
							}
							else
							{
								node.ImageIndex=-1;
								node.SelectedImageIndex=-1;
							}
							
							bool willExpand=false;
							foreach(XmlElement enodei in child.ChildNodes)
							{
								if(enodei.Name.Equals("events"))
								{
									foreach(XmlElement enodei2 in enodei.ChildNodes)
									{
										if(enodei2.Name.Equals("willExpand"))
										{											
											willExpand=true;
										}
									}
								}
							}
							node.WillExpand=willExpand;								
							loadNodes(child,node);							
						}
						
					}
				}				
			}
		}
	
		/// <summary>Evento antes de expander el arbol</summary>
		/// <param name="sender">Quien envia el evento</param>
		/// <param name="e">Evento asociado</param>
		public void treeView1_BeforeExpand(object sender, System.Windows.Forms.TreeViewCancelEventArgs e)
		{
			this.treeView1.Cursor=Cursors.WaitCursor;
			if(e.Node is WBNode)
			{
				WBNode wbnode=(WBNode)e.Node;				
				if(wbnode.WillExpand)
				{
					wbnode.Nodes.Clear();
					Servicios s=new Servicios(this.user);
					XmlDocument doc=s.getPath(wbnode.ReloadPath);
					wbnode.Nodes.Clear();
					XmlElement eres=(XmlElement)doc.GetElementsByTagName("res")[0];
					if(eres.FirstChild is XmlElement)
					{
						XmlElement enode=(XmlElement)eres.FirstChild;
						if(enode.Name=="node")
						{
							loadNodes(enode,e.Node);					
						}
					}
					
				}
				wbnode.WillExpand=false;
			}
			this.treeView1.Cursor=Cursors.Default;
		}

		/// <summary>Evento despu�s de selecionar un nodo</summary>
		/// <param name="sender">Quien envia el evento</param>
		/// <param name="e">Evento asociado</param>
		public void treeView1_AfterSelect(object sender, System.Windows.Forms.TreeViewEventArgs e)
		{
			if(buttonSiguiente!=null)
				this.buttonSiguiente.Enabled=false;
			if(e.Node is WBNode)
			{
				WBNode node=(WBNode)e.Node;
				if(!(node.ReloadPath==null || node.ReloadPath.Equals("")))
				{
					char[] cparams=new char[1];
					cparams[0]='.';
					String[] values=node.ReloadPath.Split(cparams);
					if(values[0].Equals("getTopic"))
					{
						if(buttonSiguiente!=null)
							this.buttonSiguiente.Enabled=true;
					}
					else
					{
						if(buttonSiguiente!=null)
							this.buttonSiguiente.Enabled=false;
					}
				}

			}
			
				
			
			
			
		}

	}
	class ImageTree
	{		
		int index=0;
		Image image;
		public ImageTree(int index,Image image)
		{
			this.index=index;	
			this.image=image;
		}
		public Image Image
		{
			get
			{
				return image;
			}
		}
		public int Index
		{
			get
			{
				return index;
			}
		}		
	}

}
