/*	INFOTEC WebBuilder es una herramienta para el desarrollo de portales de conocimiento, colaboración e integración para Internet, la cual, es una creación original del Fondo de Información y Documentación para la Industria INFOTEC, misma que se encuentra debidamente registrada ante el Registro Público del Derecho de Autor de los Estados Unidos Mexicanos con el No. 03-2002-052312015400-14, para la versión 1; No. 03-2003-012112473900 para la versión 2, y No. 03-2006-012012004000-01 para la versión 3, respectivamente. 
	INFOTEC pone a su disposición la herramienta INFOTEC WebBuilder a través de su licenciamiento abierto al público (‘open source’), en virtud del cual, usted podrá usarlo en las mismas condiciones con que INFOTEC lo ha diseñado y puesto a su disposición; aprender de él; distribuirlo a terceros; acceder a su código fuente y modificarlo, y combinarlo o enlazarlo con otro software, todo ello de conformidad con los términos y condiciones de la LICENCIA ABIERTA AL PÚBLICO que otorga INFOTEC para la utilización de INFOTEC WebBuilder 3.2
	INFOTEC no otorga garantía sobre INFOTEC WebBuilder, de ninguna especie y naturaleza, ni implícita ni explícita, siendo usted completamente responsable de la utilización que le dé y asumiendo la totalidad de los riesgos que puedan derivar de la misma.
	Si usted tiene cualquier duda o comentario sobre INFOTEC WebBuilder, INFOTEC pone a su disposición la siguiente dirección electrónica: http://www.webbuilder.org.mx	
*/
/*

	Windows Forms Folder Tree View control for .Net
	Version 1.1, posted 20-Oct-2002
	(c)Copyright 2002 Furty (furty74@yahoo.com). All rights reserved.
	Free for any use, so long as copyright is acknowledged.
	
	This is an all-new version of the FolderTreeView control I posted here at CP some weeks ago.
	The control now starts in the Desktop namespace, and a new DrillToFolder method has been added
	so the startup folder can be specified. Please note that this control is not intended to have 
	all of the functionality of the actual Windows Explorer TreeView - it is a light-weight control 
	designed for use in projects where you want to supply a treeview for folder navigation, without supporting
	windows shell extensions. If you are looking for a control that supports shell extensions
	you should be looking at the excellent ËxplorerTreeControl submitted by Carlos H Perez at the CP website.
	
	The 3 classes that make up the control have been merged into the one file here for ease of
	integration into your own projects. The reason for separate classes is that this code has been
	extracted from a much larger project I'm working on, and the code that is not required for this
	control has been removed.	
	
	Acknowledgments:
	Substantial portions of the ShellOperations and ExtractIcons classes were borrowed from the 
	FTPCom article written by Jerome Lacaille, available on the www.codeproject.com website.
	
	If you improve this control, please email me the updated source, and if you have any 
	comments or suggestions, please post your thoughts in the feedback section on the 
	codeproject.com page for this control.
	
	Version 1.11 Changes:
	Updated the GetDesktopIcon method so that the small (16x16) desktop icon is returned instead of the large version
	Added code to give the Desktop root node a FolderItem object tag equal to the DesktopDirectory SpecialFolder,
	this ensures that the desktop node returns a file path.
 
 */
using System;
using System.Runtime.InteropServices;
using System.Windows.Forms;
using System.Drawing;
using System.IO;

using System.Diagnostics;

namespace WBOffice3
{
	#region FolderTreeView Class

	/// <summary>Clase que muestra las carpetas para guardar o selecionar archivos</summary>
	public class FolderTreeView : System.Windows.Forms.TreeView
	{
		private System.Windows.Forms.ImageList folderTreeViewImageList;
		private System.Globalization.CultureInfo cultureInfo = System.Globalization.CultureInfo.CurrentCulture;

		#region Constructors
		/// <summary>
		/// Constructor por defecto
		/// </summary>
		public FolderTreeView()
		{
			this.BeforeExpand += new System.Windows.Forms.TreeViewCancelEventHandler(this.TreeViewBeforeExpand);
		}
		/// <summary>
		/// inicia el árbol de directorios
		/// </summary>
		public void InitFolderTreeView()
		{
			InitImageList();
			ShellOperations.PopulateTree(this, base.ImageList);
			if(this.Nodes.Count > 0)
			{
				this.Nodes[0].Expand();
			}
		}

		private void InitImageList()
		{
			// setup the image list to hold the folder icons
			folderTreeViewImageList = new System.Windows.Forms.ImageList();
			folderTreeViewImageList.ColorDepth = System.Windows.Forms.ColorDepth.Depth32Bit;
			folderTreeViewImageList.ImageSize = new System.Drawing.Size(16, 16);
			folderTreeViewImageList.TransparentColor = System.Drawing.Color.Transparent;

			// add the Desktop icon to the image list
			try
			{
				folderTreeViewImageList.Images.Add(ExtractIcons.GetDesktopIcon());
			}
			catch
			{
				// Create a blank icon if the desktop icon fails for some reason
				Bitmap bmp = new Bitmap(16,16);
				Image img = (Image)bmp;
				folderTreeViewImageList.Images.Add((Image)img.Clone());
				bmp.Dispose();
			}
			this.ImageList = folderTreeViewImageList;
		}

		#endregion

		#region Event Handlers

		private void TreeViewBeforeExpand(object sender, System.Windows.Forms.TreeViewCancelEventArgs e)
		{
			this.Cursor=Cursors.WaitCursor;  
			this.BeginUpdate();
			ShellOperations.ExpandBranch(e.Node, this.ImageList);
			this.EndUpdate();
			this.Cursor=Cursors.Default;  
		}

		#endregion

		#region Furty.Windows.Forms.FolderTreeView Properties & Methods
		/// <summary>
		/// Regresa la ruta del nodo
		/// </summary>
		/// <returns>Ruta del nodo</returns>
		public string GetSelectedNodePath()
		{
			return ShellOperations.GetFilePath(SelectedNode);
		}
		/// <summary>
		/// Se puede mostrar los subdirectorios
		/// </summary>
		/// <param name="folderPath"></param>
		/// <returns></returns>
		private bool DrillToFolder(string folderPath)
		{
			bool folderFound = false;
			if(Directory.Exists(folderPath)) // don't bother drilling unless the directory exists
			{
				this.BeginUpdate();
				// if there's a trailing \ on the folderPath, remove it unless it's a drive letter
				if(folderPath.Length > 3 && folderPath.LastIndexOf("\\") == folderPath.Length -1)
					folderPath = folderPath.Substring(0, folderPath.Length -1);
				//Start drilling the tree
				DrillTree(this.Nodes[0].Nodes, folderPath.ToUpper(cultureInfo), ref folderFound);
				this.EndUpdate();
			}
			if(!folderFound)
				this.SelectedNode = this.Nodes[0];
			return folderFound;
		}

		private void DrillTree(TreeNodeCollection tnc, string path, ref bool folderFound)
		{
			foreach(TreeNode tn in tnc)
			{
				if(!folderFound)
				{
					this.SelectedNode = tn;
					string tnPath = ShellOperations.GetFilePath(tn).ToUpper(cultureInfo);
					if(path == tnPath && !folderFound)
					{
						this.SelectedNode = tn;
						tn.EnsureVisible();
						folderFound = true;
						break;
					}
					else if(path.IndexOf(tnPath) > -1 && !folderFound)
					{
						tn.Expand();
						DrillTree(tn.Nodes, path, ref folderFound);
					}
				}
			}
		}


		#endregion
        
		#region System.Windows.Forms.TreeView Properties
		/// <summary>
		/// Color de fondo
		/// </summary>
		public override System.Drawing.Color BackColor
		{
			get
			{ return base.BackColor; }
			set
			{ base.BackColor = value; }
		}
        /// <summary>
        /// Imagen de fondo
        /// </summary>
		public override System.Drawing.Image BackgroundImage
		{
			get
			{ return base.BackgroundImage; }
			set
			{ base.BackgroundImage = value; }
		}
        /// <summary>
        /// color de la fuente
        /// </summary>
		public override System.Drawing.Color ForeColor
		{
			get
			{ return base.ForeColor; }
			set
			{ base.ForeColor = value; }
		}
        /// <summary>
        /// Texto a mostrar
        /// </summary>
		public override string Text
		{
			get
			{ return base.Text; }
			set
			{ base.Text = value; }
		}
        
		/// <summary>
		/// Permite arrastrar
		/// </summary>
		public override bool AllowDrop
		{
			get
			{ return base.AllowDrop; }
			set
			{ base.AllowDrop = value; }
		}
        /// <summary>
        /// Define el Anchor
        /// </summary>
		public override System.Windows.Forms.AnchorStyles Anchor
		{
			get
			{ return base.Anchor; }
			set
			{ base.Anchor = value; }
		}
        /// <summary>
        /// Sin comentario
        /// </summary>
		public override System.Windows.Forms.BindingContext BindingContext
		{
			get
			{ return base.BindingContext; }
			set
			{ base.BindingContext = value; }
		}
        /// <summary>
        /// Son comentario
        /// </summary>
		public override System.Windows.Forms.ContextMenu ContextMenu
		{
			get
			{ return base.ContextMenu; }
			set
			{ base.ContextMenu = value; }
		}
        /// <summary>
        /// Regresa el cursos
        /// </summary>
		public override System.Windows.Forms.Cursor Cursor
		{
			get
			{  return base.Cursor; }
			set
			{  base.Cursor = value; }
		}
        /// <summary>
        /// Despliega un rectangulo
        /// </summary>
		public override System.Drawing.Rectangle DisplayRectangle
		{
			get
			{ return base.DisplayRectangle; }
		}
        /// <summary>
        /// Define el Dock
        /// </summary>
		public override System.Windows.Forms.DockStyle Dock
		{
			get
			{ return base.Dock;  }
			set
			{ base.Dock = value; }
		}
        /// <summary>
        /// Define el Focused
        /// </summary>
		public override bool Focused
		{
			get
			{ return base.Focused; }
		}
        /// <summary>
        /// Define la fuente a mostrar
        /// </summary>
		public override System.Drawing.Font Font
		{
			get
			{ return base.Font; }
			set
			{ base.Font = value; }
		}
        /// <summary>
        /// Define si los textos se muestran de derecha a izquierda
        /// </summary>
		public override System.Windows.Forms.RightToLeft RightToLeft
		{
			get
			{ return base.RightToLeft; }
			set
			{ base.RightToLeft = value; }
		}
        /// <summary>
        /// Define el site del componente
        /// </summary>
		public override System.ComponentModel.ISite Site
		{
			get
			{ return base.Site; }
			set
			{ base.Site = value; }
		}

		#endregion

		#region System.Windows.Forms.TreeView Overrides
		/// <summary>
		/// Reinicia el texto
		/// </summary>
		public override void ResetText()
		{
			base.ResetText();
		}
        /// <summary>
        /// Actualiza el árbol
        /// </summary>
		public override void Refresh()
		{
			base.Refresh();
		}
        /// <summary>
        /// Reinicia de derecha a izquierda
        /// </summary>
		public override void ResetRightToLeft()
		{
			base.ResetRightToLeft();
		}
        /// <summary>
        /// Reinicia el color de la fuente
        /// </summary>
		public override void ResetForeColor()
		{
			base.ResetForeColor();
		}
		/// <summary>
		/// Reinicia la fuente
		/// </summary>
        
		public override void ResetFont()
		{
			base.ResetFont();
		}
        /// <summary>
        /// Reinicia el cursor
        /// </summary>
		public override void ResetCursor()
		{
			base.ResetCursor();
		}
        /// <summary>
        /// Reinicia el color de fondo
        /// </summary>
		public override void ResetBackColor()
		{
			base.ResetBackColor();
		}
        /// <summary>
        /// Pre procesa el mensaje
        /// </summary>
        /// <param name="msg"></param>
        /// <returns></returns>
		public override bool PreProcessMessage(ref System.Windows.Forms.Message msg)
		{
			return base.PreProcessMessage(ref msg);
		}
        /// <summary>
        /// Crea refeceia a objeto
        /// </summary>
        /// <param name="requestedType"></param>
        /// <returns></returns>
		public override System.Runtime.Remoting.ObjRef CreateObjRef(System.Type requestedType)
		{
			return base.CreateObjRef(requestedType);
		}
        /// <summary>
        /// Inicializa el tiempo de vida del servicio
        /// </summary>
        /// <returns></returns>
		public override object InitializeLifetimeService()
		{
			return base.InitializeLifetimeService();
		}
        /// <summary>
        /// Obtiene el HashCode
        /// </summary>
        /// <returns></returns>
		public override int GetHashCode()
		{
			return base.GetHashCode();
		}
        /// <summary>
        /// indica si dos objeto son iguales
        /// </summary>
        /// <param name="obj"></param>
        /// <returns></returns>
		public override bool Equals(object obj)
		{
			return base.Equals(obj);
		}
        /// <summary>
        /// Regresa un string
        /// </summary>
        /// <returns></returns>
		public override string ToString()
		{
			return base.ToString();
		}

		#endregion

	}

	#endregion

	#region ShellOperations Class
	/// <summary>
	/// Clase que define las operaciones con el Shell de Windows
	/// </summary>
	public class ShellOperations
	{

		#region ShellFolder Enums
		/// <summary>
		///	Enums for standard Windows shell folders 
		/// </summary>		
		public enum ShellFolder
		{
			/// <summary>
			/// Es el nodo escritorio
			/// </summary>
			Desktop = Shell32.ShellSpecialFolderConstants.ssfDESKTOP, 
			/// <summary>
			/// Es el directorio del escritorio
			/// </summary>
			DesktopDirectory = Shell32.ShellSpecialFolderConstants.ssfDESKTOPDIRECTORY,
			/// <summary>
			/// Nodo my computer
			/// </summary>
			MyComputer = Shell32.ShellSpecialFolderConstants.ssfDRIVES,
			/// <summary>
			/// Nodo mis documentos
			/// </summary>
			MyDocuments = Shell32.ShellSpecialFolderConstants.ssfPERSONAL,
			/// <summary>
			/// Nodo mis aimagenes
			/// </summary>
			MyPictures = Shell32.ShellSpecialFolderConstants.ssfMYPICTURES,
			/// <summary>
			/// Nodo history
			/// </summary>
			History = Shell32.ShellSpecialFolderConstants.ssfHISTORY,
			/// <summary>
			/// Nodo mis favoritos
			/// </summary>
			Favorites = Shell32.ShellSpecialFolderConstants.ssfFAVORITES,
			/// <summary>
			/// Nodo de fuentes
			/// </summary>
			Fonts = Shell32.ShellSpecialFolderConstants.ssfFONTS,
			/// <summary>
			/// Nodo de panel de control
			/// </summary>
			ControlPanel = Shell32.ShellSpecialFolderConstants.ssfCONTROLS,
			/// <summary>
			/// Nodo de los archivos temporales
			/// </summary>
			TemporaryInternetFiles = Shell32.ShellSpecialFolderConstants.ssfINTERNETCACHE,
			/// <summary>
			/// Nodo de mis nodos de red
			/// </summary>
			MyNetworkPlaces = Shell32.ShellSpecialFolderConstants.ssfNETHOOD,
			/// <summary>
			/// Nodo de la red
			/// </summary>
			NetworkNeighborhood = Shell32.ShellSpecialFolderConstants.ssfNETWORK,
			/// <summary>
			/// nodo de program files
			/// </summary>
			ProgramFiles = Shell32.ShellSpecialFolderConstants.ssfPROGRAMFILES,
			/// <summary>
			/// Nodo de archivos recientes
			/// </summary>
			RecentFiles = Shell32.ShellSpecialFolderConstants.ssfRECENT,
			/// <summary>
			/// Nodo del menú de inicio
			/// </summary>
			StartMenu = Shell32.ShellSpecialFolderConstants.ssfSTARTMENU,
			/// <summary>
			/// Nodo de windows
			/// </summary>
			Windows = Shell32.ShellSpecialFolderConstants.ssfWINDOWS,
			/// <summary>
			/// Nodo de impresoras
			/// </summary>
			Printers = Shell32.ShellSpecialFolderConstants.ssfPRINTERS,
			/// <summary>
			/// nodo de papelera de reciclaje
			/// </summary>
			RecycleBin = Shell32.ShellSpecialFolderConstants.ssfBITBUCKET,
			/// <summary>
			/// Nodo de cookies
			/// </summary>
			Cookies = Shell32.ShellSpecialFolderConstants.ssfCOOKIES,
			/// <summary>
			/// Nodo de datos de aplicación
			/// </summary>
			ApplicationData = Shell32.ShellSpecialFolderConstants.ssfAPPDATA,
			/// <summary>
			/// nodo de enviar a
			/// </summary>
			SendTo = Shell32.ShellSpecialFolderConstants.ssfSENDTO,
			/// <summary>
			/// Nodo de inicio
			/// </summary>
			StartUp = Shell32.ShellSpecialFolderConstants.ssfSTARTUP
		}
		#endregion
		
		#region FolderTreeView Methods

		#region GetFilePath
		/// <summary>Obtiene la ruta de un folder</summary>
		public static string GetFilePath(TreeNode tn)
		{
			try
			{
				Shell32.FolderItem folderItem = (Shell32.FolderItem)tn.Tag;
				string folderPath = folderItem.Path;
				if(Directory.Exists(folderPath))
					return folderPath;
				else
					return "";
			}
			catch
			{
				return "";
			}
		}
		#endregion

		#region Populate Tree
		/// <summary>Llena un arbol con las carpetas encontradas</summary>
		/// <param name="tree">Arbol al que se va a llenar</param>
		/// <param name="imageList">Lista de imagenes a utilizar</param>
		public static void PopulateTree(TreeView tree, ImageList imageList)
		{
			int imageCount = imageList.Images.Count -1;
			tree.Nodes.Clear();
			AddRootNode(tree, ref imageCount, imageList, ShellFolder.Desktop, true);
			if(tree.Nodes.Count > 1)
			{
				tree.SelectedNode = tree.Nodes[1];
				ExpandBranch(tree.Nodes[1], imageList);
			}
		}
		#endregion

		#region Add Root Node
		private static void AddRootNode(TreeView tree, ref int imageCount, ImageList imageList, ShellFolder shellFolder, bool getIcons)
		{
			Shell32.Shell shell32 = new Shell32.ShellClass();
			Shell32.Folder shell32Folder = shell32.NameSpace(shellFolder);
			Shell32.FolderItems items = shell32Folder.Items();

			tree.Nodes.Clear();
			TreeNode desktop = new TreeNode("Desktop", 0, 0);
	
			// Added in version 1.11
			// add a FolderItem object to the root (Desktop) node tag that corresponds to the DesktopDirectory namespace
			// This ensures that the GetSelectedNodePath will return the actual Desktop folder path when queried.
			// There's possibly a better way to create a Shell32.FolderItem instance for this purpose, 
			// but I surely don't know it

			Shell32.Folder dfolder = shell32.NameSpace(ShellFolder.DesktopDirectory);
			foreach(Shell32.FolderItem fi in dfolder.ParentFolder.Items())
			{
				if(fi.Name == dfolder.Title)
				{
					desktop.Tag = fi;
					break;
				}
			}

			// Add the Desktop root node to the tree
			tree.Nodes.Add(desktop);
			
			// iterate through the Desktop namespace and populate the first level nodes
			foreach(Shell32.FolderItem item in items)
			{
				if(item.IsFolder) // this ensures that desktop shortcuts etc are not displayed
				{
					TreeNode tn = AddTreeNode(item, ref imageCount, imageList, getIcons);
					desktop.Nodes.Add(tn);
					CheckForSubDirs(tn, imageList);
				}
			}
			
		}
		#endregion

		#region Fill Sub Dirs
		private static void FillSubDirectories(TreeNode tn, ref int imageCount, ImageList imageList, bool getIcons)
		{
			Shell32.FolderItem folderItem = (Shell32.FolderItem)tn.Tag;
			Shell32.Folder folder = (Shell32.Folder)folderItem.GetFolder;

			foreach(Shell32.FolderItem item in folder.Items())
			{
				if(item.IsFileSystem && item.IsFolder && !item.IsBrowsable)
				{
					TreeNode ntn = AddTreeNode(item, ref imageCount, imageList, getIcons);
					tn.Nodes.Add(ntn);
					CheckForSubDirs(ntn, imageList);
				}
			}
		}
		#endregion

		#region Create Dummy Node
		private static void CheckForSubDirs(TreeNode tn, ImageList imageList)
		{
			if(tn.Nodes.Count == 0)
			{
				try
				{
					// create dummy nodes for any subfolders that have further subfolders
					Shell32.FolderItem folderItem = (Shell32.FolderItem)tn.Tag;
					Shell32.Folder folder = (Shell32.Folder)folderItem.GetFolder;

					bool hasFolders = false;
					foreach(Shell32.FolderItem item in folder.Items())
					{
						if(item.IsFileSystem && item.IsFolder && !item.IsBrowsable)
						{
							hasFolders = true;
							break;
						}
					}
					if(hasFolders)
					{
						TreeNode ntn = new TreeNode();
						ntn.Tag = "DUMMYNODE";
						tn.Nodes.Add(ntn);
					}
				}
				catch {}
			}
		}
		#endregion

		#region Expand Branch
		/// <summary>
		/// Sin comentario
		/// </summary>
		/// <param name="tn"></param>
		/// <param name="imageList"></param>
		public static void ExpandBranch(TreeNode tn, ImageList imageList)
		{
			// if there's a dummy node present, clear it and replace with actual contents
			if(tn.Nodes.Count == 1 && tn.Nodes[0].Tag.ToString() == "DUMMYNODE")
			{
				tn.Nodes.Clear();
				Shell32.FolderItem folderItem = (Shell32.FolderItem)tn.Tag;
				Shell32.Folder folder = (Shell32.Folder)folderItem.GetFolder;
				int imageCount = imageList.Images.Count - 1;
				foreach(Shell32.FolderItem item in folder.Items())
				{
					if(item.IsFileSystem && item.IsFolder && !item.IsBrowsable)
					{
						TreeNode ntn = AddTreeNode(item, ref imageCount, imageList, true);
						tn.Nodes.Add(ntn);
						CheckForSubDirs(ntn, imageList);
					}
				}
			}
		}
		#endregion

		#region Add Tree Node
		private static TreeNode AddTreeNode(Shell32.FolderItem item, ref int imageCount, ImageList imageList, bool getIcons)
		{
			TreeNode tn = new TreeNode();
			tn.Text = item.Name;
			tn.Tag = item;

			if(getIcons)
			{
				try
				{
					imageCount++;
					tn.ImageIndex = imageCount;
					imageCount++;
					tn.SelectedImageIndex = imageCount;
					imageList.Images.Add(ExtractIcons.GetIcon(item.Path, false)); // normal icon
					imageList.Images.Add(ExtractIcons.GetIcon(item.Path, true)); // selected icon
				}
				catch // use default 
				{
					tn.ImageIndex = 1;
					tn.SelectedImageIndex = 2;
				}
			}
			else // use default
			{
				tn.ImageIndex = 1;
				tn.SelectedImageIndex = 2;
			}
			return tn;
		}

		#endregion

		#endregion
	}

	#endregion

	#region ExtractIcons Class
	/// <summary>
	/// Clase que extrae iconos de directorio y otros nodos
	/// </summary>
	public class ExtractIcons
	{
		#region Structs & Enum

		[StructLayout(LayoutKind.Sequential)]
			private struct SHFILEINFO
		{
			public SHFILEINFO(bool b)
			{
				hIcon=IntPtr.Zero;iIcon=0;dwAttributes=0;szDisplayName="";szTypeName="";
			}
			public IntPtr hIcon;
			public int iIcon;
			public uint dwAttributes;
			[MarshalAs(UnmanagedType.LPStr, SizeConst=260)]
			public string szDisplayName;
			[MarshalAs(UnmanagedType.LPStr, SizeConst=80)]
			public string szTypeName;
		};

		private enum SHGFI
		{
			SHGFI_ICON =             0x000000100,     // get icon
			SHGFI_DISPLAYNAME =      0x000000200,     // get display name
			SHGFI_TYPENAME =         0x000000400,     // get type name
			SHGFI_ATTRIBUTES =       0x000000800,     // get attributes
			SHGFI_ICONLOCATION =     0x000001000,     // get icon location
			SHGFI_EXETYPE =          0x000002000,     // return exe type
			SHGFI_SYSICONINDEX =     0x000004000,     // get system icon index
			SHGFI_LINKOVERLAY =      0x000008000,     // put a link overlay on icon
			SHGFI_SELECTED =         0x000010000,     // show icon in selected state
			SHGFI_ATTR_SPECIFIED =   0x000020000,     // get only specified attributes
			SHGFI_LARGEICON =        0x000000000,     // get large icon
			SHGFI_SMALLICON =        0x000000001,     // get small icon
			SHGFI_OPENICON =         0x000000002,     // get open icon
			SHGFI_SHELLICONSIZE =    0x000000004,     // get shell size icon
			SHGFI_PIDL =             0x000000008,     // pszPath is a pidl
			SHGFI_USEFILEATTRIBUTES = 0x000000010     // use passed dwFileAttribute
		}

		#endregion

		#region Get Folder Icons

		[DllImport("Shell32.dll")]
		private static extern IntPtr SHGetFileInfo(string pszPath, uint dwFileAttributes, 
			out SHFILEINFO psfi, uint cbfileInfo, SHGFI uFlags );

		
				
		/// <summary>
		/// Obtiene el icono asociado a la carpeta
		/// </summary>
		/// <param name="strPath">Path del folder</param>
		/// <param name="selected">Indica si esta selecionado</param>
		/// <returns>Regresa el icono asociado</returns>
		public static Icon GetIcon(string strPath, bool selected)
		{
			SHFILEINFO info = new SHFILEINFO(true);
			int cbFileInfo = Marshal.SizeOf(info);
			SHGFI flags;
			if (!selected)
				flags = SHGFI.SHGFI_ICON|SHGFI.SHGFI_SMALLICON;
			else
				flags = SHGFI.SHGFI_ICON|SHGFI.SHGFI_SMALLICON|SHGFI.SHGFI_OPENICON;

			SHGetFileInfo(strPath, 256, out info,(uint)cbFileInfo, flags);
			return Icon.FromHandle(info.hIcon);
		}

		#endregion

		#region Get Desktop Icon

				// Updated this method in v1.11 so that the icon returned is a small icon, not a large icon as
		// returned by the old method above
		/// <summary>
		/// Extre icono
		/// </summary>
		/// <param name="lpszFile">Archivo</param>
		/// <param name="nIconIndex">Indice</param>
		/// <param name="phiconLarge">Imagen en grande</param>
		/// <param name="phiconSmall">Imagen en pequeño</param>
		/// <param name="nIcons">Iconos</param>
		/// <returns></returns>
		[DllImport("Shell32.dll", CharSet=CharSet.Auto)]
		public static extern uint ExtractIconEx(
			string lpszFile, int nIconIndex, IntPtr[] phiconLarge, IntPtr[] phiconSmall, uint nIcons );

		/// <summary>Obtiene el icono del nodo Desktop del equipo</summary>
		/// <returns>Regresa la Imagen asociada</returns>
		public static Icon GetDesktopIcon()
		{
			IntPtr[] handlesIconLarge = new IntPtr[1];
			IntPtr[] handlesIconSmall = new IntPtr[1];
			uint i = ExtractIconEx(Environment.SystemDirectory + "\\shell32.dll", 34, 
				handlesIconLarge, handlesIconSmall, 1);

			return Icon.FromHandle(handlesIconSmall[0]);
		}
		
		#endregion

	}

	#endregion


}