using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using WBOffice3;
using System.Xml;
namespace WBWord
{
    public partial class FrmInsertDocumentRepository : Form
    {
        public FrmInsertDocumentRepository()
        {
            InitializeComponent();
            Servicios s = new Servicios(CWebBuilder.user);
            XmlDocument sites = s.getPath("getServer");
            foreach (XmlElement enode in sites.GetElementsByTagName("res"))
            {
                foreach (XmlElement child in enode.ChildNodes)
                {
                    foreach (XmlElement child2 in child.ChildNodes)
                    {

                        String reload = child2.GetAttribute("reload");
                        if (child2.Name.Equals("node") && reload != null)
                        {
                            if (reload.StartsWith("getTopicMap"))
                            {
                                String siteid = child2.GetAttribute("id");
                                String text = child2.GetAttribute("name");
                                comboBoxSite.Items.Add(new CCaracteristica(text, siteid));

                            }
                        }
                    }
                }
            }
            if (this.comboBoxSite.Items.Count > 0 && this.comboBoxSite.SelectedItem == null)
            {
                this.comboBoxSite.SelectedIndex = 0;
            }

        }

        private void buttonClose_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void buttonInsert_Click(object sender, EventArgs e)
        {
            if (this.listViewFiles.SelectedItems.Count == 0)
            {
                MessageBox.Show(this, "¡Debe seleccionar un archivo del repositorio!", this.Text, MessageBoxButtons.OK, MessageBoxIcon.Error);
                return;
            }
            object missing = Type.Missing;
            FileRepository filerep = (FileRepository)this.listViewFiles.SelectedItems[0];
            String url = filerep.URL;
            //object address = "wbrelpath://" + url;
            object address = "wbrelpath://"+filerep.FolderRepository.TopicResource + "/_rid/1/_mto/3/" + url + "?repfop=view&reptp=" + filerep.FolderRepository.ID + "&repfiddoc=" + filerep.ID + "&repinline=true";
            object text = ((FileRepository)this.listViewFiles.SelectedItems[0]).Text;
            CWebBuilder.doc.Hyperlinks.Add(CWebBuilder.app.Selection.Range, ref address, ref missing, ref missing, ref text, ref missing);
            this.Close();
        }

        private void comboBoxSite_SelectedIndexChanged(object sender, EventArgs e)
        {
            this.Cursor = Cursors.WaitCursor;
            try
            {
                this.comboBoxRepository.Items.Clear();
                this.treeViewfolders.Nodes.Clear();
                this.listViewFiles.Items.Clear();
                if (this.comboBoxSite.SelectedItem != null)
                {
                    CCaracteristica value = (CCaracteristica)this.comboBoxSite.SelectedItem;
                    String siteid = value.Name;
                    Servicios s = new Servicios(CWebBuilder.user);
                    XmlDocument docRep = s.getRepositories(siteid);
                    foreach (XmlElement enode in docRep.GetElementsByTagName("res"))
                    {
                        foreach (XmlElement child in enode.ChildNodes)
                        {
                            String repid = child.GetAttribute("id");
                            String text = child.GetAttribute("name");
                            String tpc = child.GetAttribute("name");
                            comboBoxRepository.Items.Add(new CCaracteristica(text, repid));

                        }
                    }
                }
                if (this.comboBoxRepository.Items.Count > 0 && this.comboBoxRepository.SelectedItem == null)
                {
                    this.comboBoxRepository.SelectedIndex = 0;
                }
                if (comboBoxSite.SelectedItem != null && this.comboBoxRepository.Items.Count == 0)
                {
                    MessageBox.Show(this, "¡No hay repositorios en el sitio " + comboBoxSite.SelectedItem + "!", this.Text, MessageBoxButtons.OK, MessageBoxIcon.Information);
                }
            }
            catch { }
            finally
            {
                this.Cursor = Cursors.Default;
            }
        }

        private void comboBoxRepository_SelectedIndexChanged(object sender, EventArgs e)
        {
            this.Cursor = Cursors.WaitCursor;
            try
            {
                this.treeViewfolders.Nodes.Clear();
                this.listViewFiles.Items.Clear();
                if (this.comboBoxRepository.SelectedItem != null && this.comboBoxSite.SelectedItem != null)
                {
                    CCaracteristica value = (CCaracteristica)this.comboBoxRepository.SelectedItem;
                    String repid = value.Name;
                    String siteid = ((CCaracteristica)this.comboBoxSite.SelectedItem).Name;
                    Servicios s = new Servicios(CWebBuilder.user);
                    XmlDocument homedoc = s.getHomeRep(repid, siteid);
                    foreach (XmlElement enode in homedoc.GetElementsByTagName("res"))
                    {
                        foreach (XmlElement child in enode.ChildNodes)
                        {
                            this.treeViewfolders.Nodes.Clear();
                            String text = child.GetAttribute("title");
                            String id = child.GetAttribute("id");
                            String tpc = child.GetAttribute("tpc");
                            FolderRepository folder = new FolderRepository(text, id, siteid, repid, tpc);
                            this.treeViewfolders.Nodes.Add(folder);
                            String childs = child.GetAttribute("childs");
                            if (childs.Equals("1"))
                            {
                                folder.Nodes.Add(new DummyNode());
                            }
                        }
                    }

                }
            }
            catch { }
            finally
            {
                this.Cursor = Cursors.Default;
            }
        }

        private void treeViewfolders_AfterSelect(object sender, TreeViewEventArgs e)
        {
            this.Cursor = Cursors.WaitCursor;
            try
            {
                this.listViewFiles.Items.Clear();
                if (e.Node is FolderRepository)
                {
                    FolderRepository folder = (FolderRepository)e.Node;
                    Servicios s = new Servicios(CWebBuilder.user);
                    XmlDocument docFiles = s.getFiles(folder.RepositoryID, folder.SiteID, folder.ID);
                    foreach (XmlElement enode in docFiles.GetElementsByTagName("res"))
                    {
                        foreach (XmlElement child in enode.ChildNodes)
                        {
                            String text = child.GetAttribute("title");
                            String id = child.GetAttribute("id");
                            String date = child.GetAttribute("date");
                            String url = child.GetAttribute("url");
                            FileRepository file = new FileRepository(text, id, date, url, folder);
                            this.listViewFiles.Items.Add(file);
                        }
                    }
                }
            }
            catch { }
            finally
            {
                this.Cursor=Cursors.Default;
            }
        
        
        }

        private void treeViewfolders_BeforeExpand(object sender, TreeViewCancelEventArgs e)
        {
            this.Cursor = Cursors.WaitCursor;
            try
            {
                if (e.Node.Nodes.Count == 1 && e.Node.Nodes[0] is DummyNode)
                {
                    e.Node.Nodes.Clear();
                    Servicios s = new Servicios(CWebBuilder.user);
                    FolderRepository folderparent = (FolderRepository)e.Node;
                    String siteid = folderparent.SiteID;
                    String repid = folderparent.RepositoryID;
                    String folderid = folderparent.ID;
                    XmlDocument docchilds = s.getNodesRep(repid, siteid, folderid);
                    foreach (XmlElement enode in docchilds.GetElementsByTagName("res"))
                    {
                        foreach (XmlElement child in enode.ChildNodes)
                        {
                            String text = child.GetAttribute("title");
                            String id = child.GetAttribute("id");
                            String tpc = child.GetAttribute("tpc");
                            FolderRepository folder = new FolderRepository(text, id, siteid, repid, tpc);
                            folderparent.Nodes.Add(folder);
                            String childs = child.GetAttribute("childs");
                            if (childs.Equals("1"))
                            {
                                folder.Nodes.Add(new DummyNode());
                            }
                        }
                    }
                }
            }
            catch { }
            finally
            {
                this.Cursor = Cursors.Default;
            }
        }
    }
}
