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
        private String tp;
        private String tm;
        private String resid;
        public FileRepository(String text, String id, String time, String filename, FolderRepository folder,String tp,String tm,String resid)
            : base(text)
        {
            this.SubItems[0].Text = text;
            this.SubItems.Add(time);
            this.folder = folder;
            this.id = id;
            this.filename = filename;
            this.tp = tp;
            this.tm = tm;
            this.resid = resid;

        }
        public String FileName
        {
            get
            {
                return filename;
            }
        }
        public String ResourceID
        {
            get
            {
                return resid;
            }
        }


        public String Topic
        {
            get
            {
                return tp;
            }
        }

        public String Map
        {
            get
            {
                return tm;
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
