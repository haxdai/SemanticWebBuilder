using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Forms;
namespace WBWord
{
    public class FolderRepository : TreeNode
    {
        private String siteid;
        private String repositoryid;
        private String id;
        private String tpc;
        private String url;
        public FolderRepository(String text,String id,String siteid,String repositoryid,String tpc,String url) : base(text)
        {
            this.siteid = siteid;
            this.id = id;
            this.repositoryid = repositoryid;
            this.tpc = tpc;
            this.SelectedImageIndex = 1;
            this.ImageIndex = 0;
            this.url = url;
        }
        public String URL
        {
            get
            {
                return url;
            }
        }
        public String TopicResource
        {
            get
            {
                return tpc;
            }
        }
        public String ID
        {
            get
            {
                return id;
            }
        }
        public String SiteID
        {
            get
            {
                return siteid;
            }
        }
        public String RepositoryID
        {
            get
            {
                return repositoryid;
            }
        }
    }
}
