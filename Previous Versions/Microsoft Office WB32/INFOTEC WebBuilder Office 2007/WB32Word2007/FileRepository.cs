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
        private String url;
        public FileRepository(String text, String id, String time,String url, FolderRepository folder)
            : base(text)
        {
            this.SubItems[0].Text = text;
            this.SubItems.Add(time);
            this.folder = folder;
            this.id = id;
            this.url = url;

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
