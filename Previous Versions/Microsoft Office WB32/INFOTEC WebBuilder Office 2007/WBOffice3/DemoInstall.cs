using System;
using System.Collections;
using System.Collections.Generic;
using System.ComponentModel;
using System.Configuration.Install;
using System.Linq;
using System.Diagnostics;
using System.Windows.Forms;
using System.IO;
namespace WBOffice3
{
    [RunInstaller(true)]
    public partial class DemoInstall : Installer
    {
        public DemoInstall()
        {
            InitializeComponent();
        }

        private void ExecuteFile(String path)
        {
            try
            {
                FileInfo file = new FileInfo(path);
                if (file.Exists)
                {
                    Process process = Process.Start(file.FullName);                    
                    if (process != null)
                    {
                        process.Refresh();
                        process.WaitForInputIdle();
                        process.WaitForExit();                        
                        process.Close();
                    }
                }
            }
            catch (Exception ue)
            {
                this.Context.LogMessage(System.DateTime.Now + " " + ue.StackTrace);
            }
        }

        private void DemoInstall_AfterInstall(object sender, InstallEventArgs e)
        {            
            string targetDir = this.Context.Parameters["dirinstall"];
            //ExecuteFile(targetDir + "o2007pia.msi");
            ExecuteFile(targetDir + "Word\\WB32Word2007.vsto");
            ExecuteFile(targetDir + "Excel\\WB32Excel2007.vsto");
            ExecuteFile(targetDir + "PPT\\WB32PPT2007.vsto");

        }

        private void DemoInstall_BeforeUninstall(object sender, InstallEventArgs e)
        {
            String pathCommandFiles = Environment.GetFolderPath(Environment.SpecialFolder.CommonProgramFiles);
            pathCommandFiles += "\\Microsoft Shared\\VSTO\\9.0\\VSTOInstaller.exe";
            

            string targetDir = this.Context.Parameters["dirinstall"];

            String filetoUninstall = "\"" + targetDir + "Word\\WB32Word2007.vsto\"";
            FileInfo file = new FileInfo(targetDir + "Word\\WB32Word2007.vsto");
            if (file.Exists)
            {
                try
                {
                    Process process = Process.Start(pathCommandFiles, " /u " + filetoUninstall);
                    if (process != null)
                    {
                        process.Close();
                    }
                }
                catch (Exception ue)
                {
                    this.Context.LogMessage(System.DateTime.Now + " " + ue.StackTrace);
                }
            }

            filetoUninstall = "\"" + targetDir + "Excel\\WB32Excel2007.vsto\"";
            file = new FileInfo(targetDir + "Excel\\WB32Excel2007.vsto");
            if (file.Exists)
            {
                try
                {
                    Process process = Process.Start(pathCommandFiles, " /u " + filetoUninstall);
                    if (process != null)
                    {
                        process.Close();
                    }
                }
                catch (Exception ue)
                {
                    this.Context.LogMessage(System.DateTime.Now + " " + ue.StackTrace);
                }
            }


            filetoUninstall = "\"" + targetDir + "PPT\\WB32PPT2007.vsto\"";
            file = new FileInfo(targetDir + "PPT\\WB32PPT2007.vsto");
            if (file.Exists)
            {
                try
                {
                    Process process = Process.Start(pathCommandFiles, " /u " + filetoUninstall);
                    if (process != null)
                    {
                        process.Close();
                    }
                }
                catch (Exception ue)
                {
                    this.Context.LogMessage(System.DateTime.Now + " " + ue.StackTrace);
                }
            }
            

        }
    }
}
