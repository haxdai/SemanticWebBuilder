using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Forms;
namespace WBWord
{
    public class FileRepository : ListViewItem
    {
        private FolderRepository folder;
        private String id;
        private String filename;
        private String url;
        public FileRepository(String text, String id, String time, String filename, FolderRepository folder,String url)
            : base(text)
        {
            this.SubItems[0].Text = text;
            this.SubItems.Add(time);
            this.folder = folder;
            this.id = id;
            this.filename = filename;
            this.url = url;

        }
        public String FileName
        {
            get
            {
                return filename;
            }
        }

        public String URL
        {
            get
            {
                return url;
            }
        }

        public String ID
        {
            get
            {
                return id;
            }
        }
        public FolderRepository FolderRepository
        {
            get
            {
                return folder;
            }
        }
    }
}
