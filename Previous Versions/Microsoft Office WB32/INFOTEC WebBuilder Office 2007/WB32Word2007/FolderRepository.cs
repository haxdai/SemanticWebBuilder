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
        public FolderRepository(String text,String id,String siteid,String repositoryid) : base(text)
        {
            this.siteid = siteid;
            this.id = id;
            this.repositoryid = repositoryid;
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
